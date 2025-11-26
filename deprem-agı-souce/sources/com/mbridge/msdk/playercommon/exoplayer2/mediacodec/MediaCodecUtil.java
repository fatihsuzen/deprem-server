package com.mbridge.msdk.playercommon.exoplayer2.mediacodec;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressLint({"InlinedApi"})
@TargetApi(16)
public final class MediaCodecUtil {
    private static final SparseIntArray AVC_LEVEL_NUMBER_TO_CONST;
    private static final SparseIntArray AVC_PROFILE_NUMBER_TO_CONST;
    private static final String CODEC_ID_AVC1 = "avc1";
    private static final String CODEC_ID_AVC2 = "avc2";
    private static final String CODEC_ID_HEV1 = "hev1";
    private static final String CODEC_ID_HVC1 = "hvc1";
    private static final String GOOGLE_RAW_DECODER_NAME = "OMX.google.raw.decoder";
    private static final Map<String, Integer> HEVC_CODEC_STRING_TO_PROFILE_LEVEL;
    private static final String MTK_RAW_DECODER_NAME = "OMX.MTK.AUDIO.DECODER.RAW";
    private static final MediaCodecInfo PASSTHROUGH_DECODER_INFO = MediaCodecInfo.newPassthroughInstance(GOOGLE_RAW_DECODER_NAME);
    private static final Pattern PROFILE_PATTERN = Pattern.compile("^\\D?(\\d+)$");
    private static final String TAG = "MediaCodecUtil";
    private static final HashMap<CodecKey, List<MediaCodecInfo>> decoderInfosCache = new HashMap<>();
    private static int maxH264DecodableFrameSize = -1;

    private static final class CodecKey {
        public final String mimeType;
        public final boolean secure;

        public CodecKey(String str, boolean z4) {
            this.mimeType = str;
            this.secure = z4;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && obj.getClass() == CodecKey.class) {
                CodecKey codecKey = (CodecKey) obj;
                if (!TextUtils.equals(this.mimeType, codecKey.mimeType) || this.secure != codecKey.secure) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public final int hashCode() {
            int i5;
            int i6;
            String str = this.mimeType;
            if (str == null) {
                i5 = 0;
            } else {
                i5 = str.hashCode();
            }
            int i7 = (i5 + 31) * 31;
            if (this.secure) {
                i6 = 1231;
            } else {
                i6 = 1237;
            }
            return i7 + i6;
        }
    }

    public static class DecoderQueryException extends Exception {
        private DecoderQueryException(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    private interface MediaCodecListCompat {
        int getCodecCount();

        MediaCodecInfo getCodecInfoAt(int i5);

        boolean isSecurePlaybackSupported(String str, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean secureDecodersExplicit();
    }

    private static final class MediaCodecListCompatV16 implements MediaCodecListCompat {
        private MediaCodecListCompatV16() {
        }

        public final int getCodecCount() {
            return MediaCodecList.getCodecCount();
        }

        public final MediaCodecInfo getCodecInfoAt(int i5) {
            return MediaCodecList.getCodecInfoAt(i5);
        }

        public final boolean isSecurePlaybackSupported(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return MimeTypes.VIDEO_H264.equals(str);
        }

        public final boolean secureDecodersExplicit() {
            return false;
        }
    }

    @TargetApi(21)
    private static final class MediaCodecListCompatV21 implements MediaCodecListCompat {
        private final int codecKind;
        private MediaCodecInfo[] mediaCodecInfos;

        public MediaCodecListCompatV21(boolean z4) {
            this.codecKind = z4 ? 1 : 0;
        }

        private void ensureMediaCodecInfosInitialized() {
            if (this.mediaCodecInfos == null) {
                this.mediaCodecInfos = new MediaCodecList(this.codecKind).getCodecInfos();
            }
        }

        public final int getCodecCount() {
            ensureMediaCodecInfosInitialized();
            return this.mediaCodecInfos.length;
        }

        public final MediaCodecInfo getCodecInfoAt(int i5) {
            ensureMediaCodecInfosInitialized();
            return this.mediaCodecInfos[i5];
        }

        public final boolean isSecurePlaybackSupported(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported("secure-playback");
        }

        public final boolean secureDecodersExplicit() {
            return true;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        AVC_PROFILE_NUMBER_TO_CONST = sparseIntArray;
        sparseIntArray.put(66, 1);
        sparseIntArray.put(77, 2);
        sparseIntArray.put(88, 4);
        sparseIntArray.put(100, 8);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        AVC_LEVEL_NUMBER_TO_CONST = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        sparseIntArray2.put(11, 4);
        sparseIntArray2.put(12, 8);
        sparseIntArray2.put(13, 16);
        sparseIntArray2.put(20, 32);
        sparseIntArray2.put(21, 64);
        sparseIntArray2.put(22, 128);
        sparseIntArray2.put(30, 256);
        sparseIntArray2.put(31, 512);
        sparseIntArray2.put(32, 1024);
        sparseIntArray2.put(40, 2048);
        sparseIntArray2.put(41, 4096);
        sparseIntArray2.put(42, 8192);
        sparseIntArray2.put(50, 16384);
        sparseIntArray2.put(51, 32768);
        sparseIntArray2.put(52, 65536);
        HashMap hashMap = new HashMap();
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL = hashMap;
        hashMap.put("L30", 1);
        hashMap.put("L60", 4);
        hashMap.put("L63", 16);
        hashMap.put("L90", 64);
        hashMap.put("L93", 256);
        hashMap.put("L120", 1024);
        hashMap.put("L123", 4096);
        hashMap.put("L150", 16384);
        hashMap.put("L153", 65536);
        hashMap.put("L156", 262144);
        hashMap.put("L180", 1048576);
        hashMap.put("L183", 4194304);
        hashMap.put("L186", 16777216);
        hashMap.put("H30", 2);
        hashMap.put("H60", 8);
        hashMap.put("H63", 32);
        hashMap.put("H90", 128);
        hashMap.put("H93", 512);
        hashMap.put("H120", 2048);
        hashMap.put("H123", 8192);
        hashMap.put("H150", 32768);
        hashMap.put("H153", 131072);
        hashMap.put("H156", 524288);
        hashMap.put("H180", 2097152);
        hashMap.put("H183", 8388608);
        hashMap.put("H186", 33554432);
    }

    private MediaCodecUtil() {
    }

    private static void applyWorkarounds(List<MediaCodecInfo> list) {
        if (Util.SDK_INT < 26) {
            if (list.size() > 1 && MTK_RAW_DECODER_NAME.equals(list.get(0).name)) {
                for (int i5 = 1; i5 < list.size(); i5++) {
                    MediaCodecInfo mediaCodecInfo = list.get(i5);
                    if (GOOGLE_RAW_DECODER_NAME.equals(mediaCodecInfo.name)) {
                        list.remove(i5);
                        list.add(0, mediaCodecInfo);
                        return;
                    }
                }
            }
        }
    }

    private static int avcLevelToMaxFrameSize(int i5) {
        if (i5 == 1 || i5 == 2) {
            return 25344;
        }
        switch (i5) {
            case 8:
            case 16:
            case 32:
                return 101376;
            case 64:
                return 202752;
            case 128:
            case 256:
                return 414720;
            case 512:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
            case 4096:
                return 2097152;
            case 8192:
                return 2228224;
            case 16384:
                return 5652480;
            case 32768:
            case 65536:
                return 9437184;
            default:
                return -1;
        }
    }

    private static boolean codecNeedsDisableAdaptationWorkaround(String str) {
        if (Util.SDK_INT > 22) {
            return false;
        }
        String str2 = Util.MODEL;
        if (!"ODROID-XU3".equals(str2) && !"Nexus 10".equals(str2)) {
            return false;
        }
        if ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str)) {
            return true;
        }
        return false;
    }

    private static Pair<Integer, Integer> getAvcProfileAndLevel(String str, String[] strArr) {
        Integer num;
        Integer num2;
        if (strArr.length < 2) {
            Log.w(TAG, "Ignoring malformed AVC codec string: " + str);
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                num2 = Integer.valueOf(Integer.parseInt(strArr[1].substring(0, 2), 16));
                num = Integer.valueOf(Integer.parseInt(strArr[1].substring(4), 16));
            } else if (strArr.length >= 3) {
                Integer valueOf = Integer.valueOf(Integer.parseInt(strArr[1]));
                num = Integer.valueOf(Integer.parseInt(strArr[2]));
                num2 = valueOf;
            } else {
                Log.w(TAG, "Ignoring malformed AVC codec string: " + str);
                return null;
            }
            int i5 = AVC_PROFILE_NUMBER_TO_CONST.get(num2.intValue(), -1);
            if (i5 == -1) {
                Log.w(TAG, "Unknown AVC profile: " + num2);
                return null;
            }
            int i6 = AVC_LEVEL_NUMBER_TO_CONST.get(num.intValue(), -1);
            if (i6 != -1) {
                return new Pair<>(Integer.valueOf(i5), Integer.valueOf(i6));
            }
            Log.w(TAG, "Unknown AVC level: " + num);
            return null;
        } catch (NumberFormatException unused) {
            Log.w(TAG, "Ignoring malformed AVC codec string: " + str);
            return null;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0041, code lost:
        if (r3.equals(CODEC_ID_AVC1) == false) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> getCodecProfileAndLevel(java.lang.String r6) {
        /*
            r0 = 0
            if (r6 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = "\\."
            java.lang.String[] r1 = r6.split(r1)
            r2 = 0
            r3 = r1[r2]
            r3.getClass()
            int r4 = r3.hashCode()
            r5 = -1
            switch(r4) {
                case 3006243: goto L_0x003b;
                case 3006244: goto L_0x0030;
                case 3199032: goto L_0x0025;
                case 3214780: goto L_0x001a;
                default: goto L_0x0018;
            }
        L_0x0018:
            r2 = r5
            goto L_0x0044
        L_0x001a:
            java.lang.String r2 = "hvc1"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x0023
            goto L_0x0018
        L_0x0023:
            r2 = 3
            goto L_0x0044
        L_0x0025:
            java.lang.String r2 = "hev1"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x002e
            goto L_0x0018
        L_0x002e:
            r2 = 2
            goto L_0x0044
        L_0x0030:
            java.lang.String r2 = "avc2"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x0039
            goto L_0x0018
        L_0x0039:
            r2 = 1
            goto L_0x0044
        L_0x003b:
            java.lang.String r4 = "avc1"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0044
            goto L_0x0018
        L_0x0044:
            switch(r2) {
                case 0: goto L_0x004d;
                case 1: goto L_0x004d;
                case 2: goto L_0x0048;
                case 3: goto L_0x0048;
                default: goto L_0x0047;
            }
        L_0x0047:
            return r0
        L_0x0048:
            android.util.Pair r6 = getHevcProfileAndLevel(r6, r1)
            return r6
        L_0x004d:
            android.util.Pair r6 = getAvcProfileAndLevel(r6, r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecUtil.getCodecProfileAndLevel(java.lang.String):android.util.Pair");
    }

    @Nullable
    public static MediaCodecInfo getDecoderInfo(String str, boolean z4) throws DecoderQueryException {
        List<MediaCodecInfo> decoderInfos = getDecoderInfos(str, z4);
        if (decoderInfos.isEmpty()) {
            return null;
        }
        return decoderInfos.get(0);
    }

    public static synchronized List<MediaCodecInfo> getDecoderInfos(String str, boolean z4) throws DecoderQueryException {
        MediaCodecListCompat mediaCodecListCompat;
        synchronized (MediaCodecUtil.class) {
            try {
                CodecKey codecKey = new CodecKey(str, z4);
                HashMap<CodecKey, List<MediaCodecInfo>> hashMap = decoderInfosCache;
                List<MediaCodecInfo> list = hashMap.get(codecKey);
                if (list != null) {
                    return list;
                }
                int i5 = Util.SDK_INT;
                if (i5 >= 21) {
                    mediaCodecListCompat = new MediaCodecListCompatV21(z4);
                } else {
                    mediaCodecListCompat = new MediaCodecListCompatV16();
                }
                ArrayList<MediaCodecInfo> decoderInfosInternal = getDecoderInfosInternal(codecKey, mediaCodecListCompat, str);
                if (z4 && decoderInfosInternal.isEmpty() && 21 <= i5 && i5 <= 23) {
                    mediaCodecListCompat = new MediaCodecListCompatV16();
                    decoderInfosInternal = getDecoderInfosInternal(codecKey, mediaCodecListCompat, str);
                    if (!decoderInfosInternal.isEmpty()) {
                        Log.w(TAG, "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + decoderInfosInternal.get(0).name);
                    }
                }
                if (MimeTypes.AUDIO_E_AC3_JOC.equals(str)) {
                    decoderInfosInternal.addAll(getDecoderInfosInternal(new CodecKey(MimeTypes.AUDIO_E_AC3, codecKey.secure), mediaCodecListCompat, str));
                }
                applyWorkarounds(decoderInfosInternal);
                List<MediaCodecInfo> unmodifiableList = DesugarCollections.unmodifiableList(decoderInfosInternal);
                hashMap.put(codecKey, unmodifiableList);
                return unmodifiableList;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0048, code lost:
        if (r1.secure != r7) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0055, code lost:
        if (r1.secure == false) goto L_0x004b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x008f A[SYNTHETIC, Splitter:B:38:0x008f] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00af A[EDGE_INSN: B:51:0x00af->B:42:0x00af ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.ArrayList<com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecInfo> getDecoderInfosInternal(com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecUtil.CodecKey r17, com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat r18, java.lang.String r19) throws com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        /*
            r1 = r17
            r2 = r18
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x00e6 }
            r3.<init>()     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r4 = r1.mimeType     // Catch:{ Exception -> 0x00e6 }
            int r5 = r2.getCodecCount()     // Catch:{ Exception -> 0x00e6 }
            boolean r6 = r2.secureDecodersExplicit()     // Catch:{ Exception -> 0x00e6 }
            r8 = 0
        L_0x0014:
            if (r8 >= r5) goto L_0x00e5
            android.media.MediaCodecInfo r9 = r2.getCodecInfoAt(r8)     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r10 = r9.getName()     // Catch:{ Exception -> 0x00e6 }
            r11 = r19
            boolean r0 = isCodecUsableDecoder(r9, r10, r6, r11)     // Catch:{ Exception -> 0x00e6 }
            if (r0 == 0) goto L_0x00db
            java.lang.String[] r12 = r9.getSupportedTypes()     // Catch:{ Exception -> 0x00e6 }
            int r13 = r12.length     // Catch:{ Exception -> 0x00e6 }
            r14 = 0
        L_0x002c:
            if (r14 >= r13) goto L_0x00db
            r15 = r12[r14]     // Catch:{ Exception -> 0x00e6 }
            boolean r0 = r15.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x00e6 }
            if (r0 == 0) goto L_0x00d1
            android.media.MediaCodecInfo$CodecCapabilities r0 = r9.getCapabilitiesForType(r15)     // Catch:{ Exception -> 0x0084 }
            boolean r7 = r2.isSecurePlaybackSupported(r4, r0)     // Catch:{ Exception -> 0x0084 }
            boolean r2 = codecNeedsDisableAdaptationWorkaround(r10)     // Catch:{ Exception -> 0x0084 }
            if (r6 == 0) goto L_0x004f
            r16 = r5
            boolean r5 = r1.secure     // Catch:{ Exception -> 0x004d }
            if (r5 == r7) goto L_0x004b
            goto L_0x0051
        L_0x004b:
            r5 = 0
            goto L_0x0058
        L_0x004d:
            r0 = move-exception
            goto L_0x0087
        L_0x004f:
            r16 = r5
        L_0x0051:
            if (r6 != 0) goto L_0x0061
            boolean r5 = r1.secure     // Catch:{ Exception -> 0x0063 }
            if (r5 != 0) goto L_0x0061
            goto L_0x004b
        L_0x0058:
            com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecInfo r0 = com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecInfo.newInstance(r10, r4, r0, r2, r5)     // Catch:{ Exception -> 0x004d }
            r3.add(r0)     // Catch:{ Exception -> 0x004d }
            goto L_0x00d3
        L_0x0061:
            r5 = 0
            goto L_0x0066
        L_0x0063:
            r0 = move-exception
            r5 = 0
            goto L_0x0087
        L_0x0066:
            if (r6 != 0) goto L_0x00d3
            if (r7 == 0) goto L_0x00d3
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004d }
            r7.<init>()     // Catch:{ Exception -> 0x004d }
            r7.append(r10)     // Catch:{ Exception -> 0x004d }
            java.lang.String r5 = ".secure"
            r7.append(r5)     // Catch:{ Exception -> 0x004d }
            java.lang.String r5 = r7.toString()     // Catch:{ Exception -> 0x004d }
            r7 = 1
            com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecInfo r0 = com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecInfo.newInstance(r5, r4, r0, r2, r7)     // Catch:{ Exception -> 0x004d }
            r3.add(r0)     // Catch:{ Exception -> 0x004d }
            goto L_0x00e5
        L_0x0084:
            r0 = move-exception
            r16 = r5
        L_0x0087:
            int r2 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.SDK_INT     // Catch:{ Exception -> 0x00e6 }
            r5 = 23
            java.lang.String r7 = "MediaCodecUtil"
            if (r2 > r5) goto L_0x00af
            boolean r2 = r3.isEmpty()     // Catch:{ Exception -> 0x00e6 }
            if (r2 != 0) goto L_0x00af
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e6 }
            r0.<init>()     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r2 = "Skipping codec "
            r0.append(r2)     // Catch:{ Exception -> 0x00e6 }
            r0.append(r10)     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r2 = " (failed to query capabilities)"
            r0.append(r2)     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00e6 }
            android.util.Log.e(r7, r0)     // Catch:{ Exception -> 0x00e6 }
            goto L_0x00d3
        L_0x00af:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e6 }
            r1.<init>()     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r2 = "Failed to query codec "
            r1.append(r2)     // Catch:{ Exception -> 0x00e6 }
            r1.append(r10)     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r2 = " ("
            r1.append(r2)     // Catch:{ Exception -> 0x00e6 }
            r1.append(r15)     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r2 = ")"
            r1.append(r2)     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00e6 }
            android.util.Log.e(r7, r1)     // Catch:{ Exception -> 0x00e6 }
            throw r0     // Catch:{ Exception -> 0x00e6 }
        L_0x00d1:
            r16 = r5
        L_0x00d3:
            int r14 = r14 + 1
            r2 = r18
            r5 = r16
            goto L_0x002c
        L_0x00db:
            r16 = r5
            int r8 = r8 + 1
            r2 = r18
            r5 = r16
            goto L_0x0014
        L_0x00e5:
            return r3
        L_0x00e6:
            r0 = move-exception
            com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecUtil$DecoderQueryException r1 = new com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecUtil$DecoderQueryException
            r2 = 0
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecUtil.getDecoderInfosInternal(com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecUtil$CodecKey, com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecUtil$MediaCodecListCompat, java.lang.String):java.util.ArrayList");
    }

    private static Pair<Integer, Integer> getHevcProfileAndLevel(String str, String[] strArr) {
        int i5;
        if (strArr.length < 4) {
            Log.w(TAG, "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        Matcher matcher = PROFILE_PATTERN.matcher(strArr[1]);
        if (!matcher.matches()) {
            Log.w(TAG, "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        String group = matcher.group(1);
        if ("1".equals(group)) {
            i5 = 1;
        } else if ("2".equals(group)) {
            i5 = 2;
        } else {
            Log.w(TAG, "Unknown HEVC profile string: " + group);
            return null;
        }
        Integer num = HEVC_CODEC_STRING_TO_PROFILE_LEVEL.get(strArr[3]);
        if (num != null) {
            return new Pair<>(Integer.valueOf(i5), num);
        }
        Log.w(TAG, "Unknown HEVC level string: " + matcher.group(1));
        return null;
    }

    public static MediaCodecInfo getPassthroughDecoderInfo() {
        return PASSTHROUGH_DECODER_INFO;
    }

    private static boolean isCodecUsableDecoder(MediaCodecInfo mediaCodecInfo, String str, boolean z4, String str2) {
        if (mediaCodecInfo.isEncoder() || (!z4 && str.endsWith(".secure"))) {
            return false;
        }
        int i5 = Util.SDK_INT;
        if (i5 < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (i5 < 18 && "OMX.SEC.MP3.Decoder".equals(str)) {
            return false;
        }
        if (i5 < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str)) {
            String str3 = Util.DEVICE;
            if ("a70".equals(str3) || ("Xiaomi".equals(Util.MANUFACTURER) && str3.startsWith("HM"))) {
                return false;
            }
        }
        if (i5 == 16 && "OMX.qcom.audio.decoder.mp3".equals(str)) {
            String str4 = Util.DEVICE;
            if ("dlxu".equals(str4) || "protou".equals(str4) || "ville".equals(str4) || "villeplus".equals(str4) || "villec2".equals(str4) || str4.startsWith("gee") || "C6602".equals(str4) || "C6603".equals(str4) || "C6606".equals(str4) || "C6616".equals(str4) || "L36h".equals(str4) || "SO-02E".equals(str4)) {
                return false;
            }
        }
        if (i5 == 16 && "OMX.qcom.audio.decoder.aac".equals(str)) {
            String str5 = Util.DEVICE;
            if ("C1504".equals(str5) || "C1505".equals(str5) || "C1604".equals(str5) || "C1605".equals(str5)) {
                return false;
            }
        }
        if (i5 < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && "samsung".equals(Util.MANUFACTURER))) {
            String str6 = Util.DEVICE;
            if (str6.startsWith("zeroflte") || str6.startsWith("zerolte") || str6.startsWith("zenlte") || "SC-05G".equals(str6) || "marinelteatt".equals(str6) || "404SC".equals(str6) || "SC-04G".equals(str6) || "SCV31".equals(str6)) {
                return false;
            }
        }
        if (i5 <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(Util.MANUFACTURER)) {
            String str7 = Util.DEVICE;
            if (str7.startsWith("d2") || str7.startsWith("serrano") || str7.startsWith("jflte") || str7.startsWith("santos") || str7.startsWith("t0")) {
                return false;
            }
        }
        if (i5 <= 19 && Util.DEVICE.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
            return false;
        }
        if (!MimeTypes.AUDIO_E_AC3_JOC.equals(str2) || !"OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) {
            return true;
        }
        return false;
    }

    public static int maxH264DecodableFrameSize() throws DecoderQueryException {
        int i5;
        if (maxH264DecodableFrameSize == -1) {
            int i6 = 0;
            MediaCodecInfo decoderInfo = getDecoderInfo(MimeTypes.VIDEO_H264, false);
            if (decoderInfo != null) {
                MediaCodecInfo.CodecProfileLevel[] profileLevels = decoderInfo.getProfileLevels();
                int length = profileLevels.length;
                int i7 = 0;
                while (i6 < length) {
                    i7 = Math.max(avcLevelToMaxFrameSize(profileLevels[i6].level), i7);
                    i6++;
                }
                if (Util.SDK_INT >= 21) {
                    i5 = 345600;
                } else {
                    i5 = 172800;
                }
                i6 = Math.max(i7, i5);
            }
            maxH264DecodableFrameSize = i6;
        }
        return maxH264DecodableFrameSize;
    }

    public static void warmDecoderInfoCache(String str, boolean z4) {
        try {
            getDecoderInfos(str, z4);
        } catch (DecoderQueryException e5) {
            Log.e(TAG, "Codec warming failed", e5);
        }
    }
}
