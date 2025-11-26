package com.mbridge.msdk.playercommon.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.BaseRenderer;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlaybackException;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.FormatHolder;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderCounters;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderInputBuffer;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmSession;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmSessionManager;
import com.mbridge.msdk.playercommon.exoplayer2.drm.FrameworkMediaCrypto;
import com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.NalUnitUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.TraceUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
public abstract class MediaCodecRenderer extends BaseRenderer {
    private static final byte[] ADAPTATION_WORKAROUND_BUFFER = Util.getBytesFromHexString("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private static final int ADAPTATION_WORKAROUND_MODE_ALWAYS = 2;
    private static final int ADAPTATION_WORKAROUND_MODE_NEVER = 0;
    private static final int ADAPTATION_WORKAROUND_MODE_SAME_RESOLUTION = 1;
    private static final int ADAPTATION_WORKAROUND_SLICE_WIDTH_HEIGHT = 32;
    protected static final int KEEP_CODEC_RESULT_NO = 0;
    protected static final int KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION = 1;
    protected static final int KEEP_CODEC_RESULT_YES_WITH_RECONFIGURATION = 3;
    private static final long MAX_CODEC_HOTSWAP_TIME_MS = 1000;
    private static final int RECONFIGURATION_STATE_NONE = 0;
    private static final int RECONFIGURATION_STATE_QUEUE_PENDING = 2;
    private static final int RECONFIGURATION_STATE_WRITE_PENDING = 1;
    private static final int REINITIALIZATION_STATE_NONE = 0;
    private static final int REINITIALIZATION_STATE_SIGNAL_END_OF_STREAM = 1;
    private static final int REINITIALIZATION_STATE_WAIT_END_OF_STREAM = 2;
    private static final String TAG = "MediaCodecRenderer";
    private final DecoderInputBuffer buffer;
    private MediaCodec codec;
    private int codecAdaptationWorkaroundMode;
    private long codecHotswapDeadlineMs;
    private MediaCodecInfo codecInfo;
    private boolean codecNeedsAdaptationWorkaroundBuffer;
    private boolean codecNeedsDiscardToSpsWorkaround;
    private boolean codecNeedsEosFlushWorkaround;
    private boolean codecNeedsEosOutputExceptionWorkaround;
    private boolean codecNeedsEosPropagationWorkaround;
    private boolean codecNeedsFlushWorkaround;
    private boolean codecNeedsMonoChannelCountWorkaround;
    private boolean codecReceivedBuffers;
    private boolean codecReceivedEos;
    private int codecReconfigurationState;
    private boolean codecReconfigured;
    private int codecReinitializationState;
    private final List<Long> decodeOnlyPresentationTimestamps;
    protected DecoderCounters decoderCounters;
    private DrmSession<FrameworkMediaCrypto> drmSession;
    @Nullable
    private final DrmSessionManager<FrameworkMediaCrypto> drmSessionManager;
    private final DecoderInputBuffer flagsOnlyBuffer;
    private Format format;
    private final FormatHolder formatHolder;
    private ByteBuffer[] inputBuffers;
    private int inputIndex;
    private boolean inputStreamEnded;
    private final MediaCodecSelector mediaCodecSelector;
    private ByteBuffer outputBuffer;
    private final MediaCodec.BufferInfo outputBufferInfo;
    private ByteBuffer[] outputBuffers;
    private int outputIndex;
    private boolean outputStreamEnded;
    private DrmSession<FrameworkMediaCrypto> pendingDrmSession;
    private final boolean playClearSamplesWithoutKeys;
    private boolean shouldSkipAdaptationWorkaroundOutputBuffer;
    private boolean shouldSkipOutputBuffer;
    private boolean waitingForFirstSyncFrame;
    private boolean waitingForKeys;

    @Retention(RetentionPolicy.SOURCE)
    private @interface AdaptationWorkaroundMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    protected @interface KeepCodecResult {
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface ReconfigurationState {
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface ReinitializationState {
    }

    public MediaCodecRenderer(int i5, MediaCodecSelector mediaCodecSelector2, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager2, boolean z4) {
        super(i5);
        boolean z5;
        if (Util.SDK_INT >= 16) {
            z5 = true;
        } else {
            z5 = false;
        }
        Assertions.checkState(z5);
        this.mediaCodecSelector = (MediaCodecSelector) Assertions.checkNotNull(mediaCodecSelector2);
        this.drmSessionManager = drmSessionManager2;
        this.playClearSamplesWithoutKeys = z4;
        this.buffer = new DecoderInputBuffer(0);
        this.flagsOnlyBuffer = DecoderInputBuffer.newFlagsOnlyInstance();
        this.formatHolder = new FormatHolder();
        this.decodeOnlyPresentationTimestamps = new ArrayList();
        this.outputBufferInfo = new MediaCodec.BufferInfo();
        this.codecReconfigurationState = 0;
        this.codecReinitializationState = 0;
    }

    private int codecAdaptationWorkaroundMode(String str) {
        int i5 = Util.SDK_INT;
        if (i5 <= 25 && "OMX.Exynos.avc.dec.secure".equals(str)) {
            String str2 = Util.MODEL;
            if (str2.startsWith("SM-T585") || str2.startsWith("SM-A510") || str2.startsWith("SM-A520") || str2.startsWith("SM-J700")) {
                return 2;
            }
        }
        if (i5 >= 24) {
            return 0;
        }
        if (!"OMX.Nvidia.h264.decode".equals(str) && !"OMX.Nvidia.h264.decode.secure".equals(str)) {
            return 0;
        }
        String str3 = Util.DEVICE;
        if ("flounder".equals(str3) || "flounder_lte".equals(str3) || "grouper".equals(str3) || "tilapia".equals(str3)) {
            return 1;
        }
        return 0;
    }

    private static boolean codecNeedsDiscardToSpsWorkaround(String str, Format format2) {
        if (Util.SDK_INT >= 21 || !format2.initializationData.isEmpty() || !"OMX.MTK.VIDEO.DECODER.AVC".equals(str)) {
            return false;
        }
        return true;
    }

    private static boolean codecNeedsEosFlushWorkaround(String str) {
        int i5 = Util.SDK_INT;
        if (i5 <= 23 && "OMX.google.vorbis.decoder".equals(str)) {
            return true;
        }
        if (i5 > 19 || !"hb2000".equals(Util.DEVICE)) {
            return false;
        }
        if ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str)) {
            return true;
        }
        return false;
    }

    private static boolean codecNeedsEosOutputExceptionWorkaround(String str) {
        if (Util.SDK_INT != 21 || !"OMX.google.aac.decoder".equals(str)) {
            return false;
        }
        return true;
    }

    private static boolean codecNeedsEosPropagationWorkaround(MediaCodecInfo mediaCodecInfo) {
        String str = mediaCodecInfo.name;
        if (Util.SDK_INT <= 17 && ("OMX.rk.video_decoder.avc".equals(str) || "OMX.allwinner.video.decoder.avc".equals(str))) {
            return true;
        }
        if (!"Amazon".equals(Util.MANUFACTURER) || !"AFTS".equals(Util.MODEL) || !mediaCodecInfo.secure) {
            return false;
        }
        return true;
    }

    private static boolean codecNeedsFlushWorkaround(String str) {
        int i5 = Util.SDK_INT;
        if (i5 < 18) {
            return true;
        }
        if (i5 == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) {
            return true;
        }
        if (i5 != 19 || !Util.MODEL.startsWith("SM-G800")) {
            return false;
        }
        if ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)) {
            return true;
        }
        return false;
    }

    private static boolean codecNeedsMonoChannelCountWorkaround(String str, Format format2) {
        if (Util.SDK_INT > 18 || format2.channelCount != 1 || !"OMX.MTK.AUDIO.DECODER.MP3".equals(str)) {
            return false;
        }
        return true;
    }

    private boolean deviceNeedsDrmKeysToConfigureCodecWorkaround() {
        if (!"Amazon".equals(Util.MANUFACTURER)) {
            return false;
        }
        String str = Util.MODEL;
        if ("AFTM".equals(str) || "AFTB".equals(str)) {
            return true;
        }
        return false;
    }

    private boolean drainOutputBuffer(long j5, long j6) throws ExoPlaybackException {
        boolean z4;
        boolean z5;
        int i5;
        if (!hasOutputBuffer()) {
            if (!this.codecNeedsEosOutputExceptionWorkaround || !this.codecReceivedEos) {
                i5 = this.codec.dequeueOutputBuffer(this.outputBufferInfo, getDequeueOutputBufferTimeoutUs());
            } else {
                try {
                    i5 = this.codec.dequeueOutputBuffer(this.outputBufferInfo, getDequeueOutputBufferTimeoutUs());
                } catch (IllegalStateException unused) {
                    processEndOfStream();
                    if (this.outputStreamEnded) {
                        releaseCodec();
                    }
                    return false;
                }
            }
            if (i5 >= 0) {
                if (this.shouldSkipAdaptationWorkaroundOutputBuffer) {
                    this.shouldSkipAdaptationWorkaroundOutputBuffer = false;
                    this.codec.releaseOutputBuffer(i5, false);
                    return true;
                }
                MediaCodec.BufferInfo bufferInfo = this.outputBufferInfo;
                if (bufferInfo.size != 0 || (bufferInfo.flags & 4) == 0) {
                    this.outputIndex = i5;
                    ByteBuffer outputBuffer2 = getOutputBuffer(i5);
                    this.outputBuffer = outputBuffer2;
                    if (outputBuffer2 != null) {
                        outputBuffer2.position(this.outputBufferInfo.offset);
                        ByteBuffer byteBuffer = this.outputBuffer;
                        MediaCodec.BufferInfo bufferInfo2 = this.outputBufferInfo;
                        byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
                    }
                    this.shouldSkipOutputBuffer = shouldSkipOutputBuffer(this.outputBufferInfo.presentationTimeUs);
                } else {
                    processEndOfStream();
                    return false;
                }
            } else if (i5 == -2) {
                processOutputFormat();
                return true;
            } else if (i5 == -3) {
                processOutputBuffersChanged();
                return true;
            } else {
                if (this.codecNeedsEosPropagationWorkaround && (this.inputStreamEnded || this.codecReinitializationState == 2)) {
                    processEndOfStream();
                }
                return false;
            }
        }
        if (!this.codecNeedsEosOutputExceptionWorkaround || !this.codecReceivedEos) {
            MediaCodec mediaCodec = this.codec;
            ByteBuffer byteBuffer2 = this.outputBuffer;
            int i6 = this.outputIndex;
            MediaCodec.BufferInfo bufferInfo3 = this.outputBufferInfo;
            z4 = processOutputBuffer(j5, j6, mediaCodec, byteBuffer2, i6, bufferInfo3.flags, bufferInfo3.presentationTimeUs, this.shouldSkipOutputBuffer);
        } else {
            try {
                MediaCodec mediaCodec2 = this.codec;
                ByteBuffer byteBuffer3 = this.outputBuffer;
                int i7 = this.outputIndex;
                MediaCodec.BufferInfo bufferInfo4 = this.outputBufferInfo;
                z4 = processOutputBuffer(j5, j6, mediaCodec2, byteBuffer3, i7, bufferInfo4.flags, bufferInfo4.presentationTimeUs, this.shouldSkipOutputBuffer);
            } catch (IllegalStateException unused2) {
                processEndOfStream();
                if (this.outputStreamEnded) {
                    releaseCodec();
                }
                return false;
            }
        }
        if (z4) {
            onProcessedOutputBuffer(this.outputBufferInfo.presentationTimeUs);
            if ((this.outputBufferInfo.flags & 4) != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            resetOutputBuffer();
            if (!z5) {
                return true;
            }
            processEndOfStream();
        }
        return false;
    }

    private boolean feedInputBuffer() throws ExoPlaybackException {
        int i5;
        int i6;
        MediaCodec mediaCodec = this.codec;
        if (mediaCodec == null || this.codecReinitializationState == 2 || this.inputStreamEnded) {
            return false;
        }
        if (this.inputIndex < 0) {
            int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(0);
            this.inputIndex = dequeueInputBuffer;
            if (dequeueInputBuffer < 0) {
                return false;
            }
            this.buffer.data = getInputBuffer(dequeueInputBuffer);
            this.buffer.clear();
        }
        if (this.codecReinitializationState == 1) {
            if (!this.codecNeedsEosPropagationWorkaround) {
                this.codecReceivedEos = true;
                this.codec.queueInputBuffer(this.inputIndex, 0, 0, 0, 4);
                resetInputBuffer();
            }
            this.codecReinitializationState = 2;
            return false;
        } else if (this.codecNeedsAdaptationWorkaroundBuffer) {
            this.codecNeedsAdaptationWorkaroundBuffer = false;
            ByteBuffer byteBuffer = this.buffer.data;
            byte[] bArr = ADAPTATION_WORKAROUND_BUFFER;
            byteBuffer.put(bArr);
            this.codec.queueInputBuffer(this.inputIndex, 0, bArr.length, 0, 0);
            resetInputBuffer();
            this.codecReceivedBuffers = true;
            return true;
        } else {
            if (this.waitingForKeys) {
                i6 = -4;
                i5 = 0;
            } else {
                if (this.codecReconfigurationState == 1) {
                    for (int i7 = 0; i7 < this.format.initializationData.size(); i7++) {
                        this.buffer.data.put(this.format.initializationData.get(i7));
                    }
                    this.codecReconfigurationState = 2;
                }
                i5 = this.buffer.data.position();
                i6 = readSource(this.formatHolder, this.buffer, false);
            }
            if (i6 == -3) {
                return false;
            }
            if (i6 == -5) {
                if (this.codecReconfigurationState == 2) {
                    this.buffer.clear();
                    this.codecReconfigurationState = 1;
                }
                onInputFormatChanged(this.formatHolder.format);
                return true;
            } else if (this.buffer.isEndOfStream()) {
                if (this.codecReconfigurationState == 2) {
                    this.buffer.clear();
                    this.codecReconfigurationState = 1;
                }
                this.inputStreamEnded = true;
                if (!this.codecReceivedBuffers) {
                    processEndOfStream();
                    return false;
                }
                try {
                    if (!this.codecNeedsEosPropagationWorkaround) {
                        this.codecReceivedEos = true;
                        this.codec.queueInputBuffer(this.inputIndex, 0, 0, 0, 4);
                        resetInputBuffer();
                    }
                    return false;
                } catch (MediaCodec.CryptoException e5) {
                    throw ExoPlaybackException.createForRenderer(e5, getIndex());
                }
            } else if (!this.waitingForFirstSyncFrame || this.buffer.isKeyFrame()) {
                this.waitingForFirstSyncFrame = false;
                boolean isEncrypted = this.buffer.isEncrypted();
                boolean shouldWaitForKeys = shouldWaitForKeys(isEncrypted);
                this.waitingForKeys = shouldWaitForKeys;
                if (shouldWaitForKeys) {
                    return false;
                }
                if (this.codecNeedsDiscardToSpsWorkaround && !isEncrypted) {
                    NalUnitUtil.discardToSps(this.buffer.data);
                    if (this.buffer.data.position() == 0) {
                        return true;
                    }
                    this.codecNeedsDiscardToSpsWorkaround = false;
                }
                try {
                    DecoderInputBuffer decoderInputBuffer = this.buffer;
                    long j5 = decoderInputBuffer.timeUs;
                    if (decoderInputBuffer.isDecodeOnly()) {
                        this.decodeOnlyPresentationTimestamps.add(Long.valueOf(j5));
                    }
                    this.buffer.flip();
                    onQueueInputBuffer(this.buffer);
                    if (isEncrypted) {
                        this.codec.queueSecureInputBuffer(this.inputIndex, 0, getFrameworkCryptoInfo(this.buffer, i5), j5, 0);
                    } else {
                        this.codec.queueInputBuffer(this.inputIndex, 0, this.buffer.data.limit(), j5, 0);
                    }
                    resetInputBuffer();
                    this.codecReceivedBuffers = true;
                    this.codecReconfigurationState = 0;
                    this.decoderCounters.inputBufferCount++;
                    return true;
                } catch (MediaCodec.CryptoException e6) {
                    throw ExoPlaybackException.createForRenderer(e6, getIndex());
                }
            } else {
                this.buffer.clear();
                if (this.codecReconfigurationState == 2) {
                    this.codecReconfigurationState = 1;
                }
                return true;
            }
        }
    }

    private void getCodecBuffers() {
        if (Util.SDK_INT < 21) {
            this.inputBuffers = this.codec.getInputBuffers();
            this.outputBuffers = this.codec.getOutputBuffers();
        }
    }

    private static MediaCodec.CryptoInfo getFrameworkCryptoInfo(DecoderInputBuffer decoderInputBuffer, int i5) {
        MediaCodec.CryptoInfo frameworkCryptoInfoV16 = decoderInputBuffer.cryptoInfo.getFrameworkCryptoInfoV16();
        if (i5 == 0) {
            return frameworkCryptoInfoV16;
        }
        if (frameworkCryptoInfoV16.numBytesOfClearData == null) {
            frameworkCryptoInfoV16.numBytesOfClearData = new int[1];
        }
        int[] iArr = frameworkCryptoInfoV16.numBytesOfClearData;
        iArr[0] = iArr[0] + i5;
        return frameworkCryptoInfoV16;
    }

    private ByteBuffer getInputBuffer(int i5) {
        if (Util.SDK_INT >= 21) {
            return this.codec.getInputBuffer(i5);
        }
        return this.inputBuffers[i5];
    }

    private ByteBuffer getOutputBuffer(int i5) {
        if (Util.SDK_INT >= 21) {
            return this.codec.getOutputBuffer(i5);
        }
        return this.outputBuffers[i5];
    }

    private boolean hasOutputBuffer() {
        if (this.outputIndex >= 0) {
            return true;
        }
        return false;
    }

    private void processEndOfStream() throws ExoPlaybackException {
        if (this.codecReinitializationState == 2) {
            releaseCodec();
            maybeInitCodec();
            return;
        }
        this.outputStreamEnded = true;
        renderToEndOfStream();
    }

    private void processOutputBuffersChanged() {
        if (Util.SDK_INT < 21) {
            this.outputBuffers = this.codec.getOutputBuffers();
        }
    }

    private void processOutputFormat() throws ExoPlaybackException {
        MediaFormat outputFormat = this.codec.getOutputFormat();
        if (this.codecAdaptationWorkaroundMode != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
            this.shouldSkipAdaptationWorkaroundOutputBuffer = true;
            return;
        }
        if (this.codecNeedsMonoChannelCountWorkaround) {
            outputFormat.setInteger("channel-count", 1);
        }
        onOutputFormatChanged(this.codec, outputFormat);
    }

    private void resetCodecBuffers() {
        if (Util.SDK_INT < 21) {
            this.inputBuffers = null;
            this.outputBuffers = null;
        }
    }

    private void resetInputBuffer() {
        this.inputIndex = -1;
        this.buffer.data = null;
    }

    private void resetOutputBuffer() {
        this.outputIndex = -1;
        this.outputBuffer = null;
    }

    private boolean shouldSkipOutputBuffer(long j5) {
        int size = this.decodeOnlyPresentationTimestamps.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (this.decodeOnlyPresentationTimestamps.get(i5).longValue() == j5) {
                this.decodeOnlyPresentationTimestamps.remove(i5);
                return true;
            }
        }
        return false;
    }

    private boolean shouldWaitForKeys(boolean z4) throws ExoPlaybackException {
        DrmSession<FrameworkMediaCrypto> drmSession2 = this.drmSession;
        if (drmSession2 == null || (!z4 && this.playClearSamplesWithoutKeys)) {
            return false;
        }
        int state = drmSession2.getState();
        if (state == 1) {
            throw ExoPlaybackException.createForRenderer(this.drmSession.getError(), getIndex());
        } else if (state != 4) {
            return true;
        } else {
            return false;
        }
    }

    private void throwDecoderInitError(DecoderInitializationException decoderInitializationException) throws ExoPlaybackException {
        throw ExoPlaybackException.createForRenderer(decoderInitializationException, getIndex());
    }

    /* access modifiers changed from: protected */
    public int canKeepCodec(MediaCodec mediaCodec, MediaCodecInfo mediaCodecInfo, Format format2, Format format3) {
        return 0;
    }

    /* access modifiers changed from: protected */
    public abstract void configureCodec(MediaCodecInfo mediaCodecInfo, MediaCodec mediaCodec, Format format2, MediaCrypto mediaCrypto) throws MediaCodecUtil.DecoderQueryException;

    /* access modifiers changed from: protected */
    public void flushCodec() throws ExoPlaybackException {
        this.codecHotswapDeadlineMs = C.TIME_UNSET;
        resetInputBuffer();
        resetOutputBuffer();
        this.waitingForFirstSyncFrame = true;
        this.waitingForKeys = false;
        this.shouldSkipOutputBuffer = false;
        this.decodeOnlyPresentationTimestamps.clear();
        this.codecNeedsAdaptationWorkaroundBuffer = false;
        this.shouldSkipAdaptationWorkaroundOutputBuffer = false;
        if (this.codecNeedsFlushWorkaround || (this.codecNeedsEosFlushWorkaround && this.codecReceivedEos)) {
            releaseCodec();
            maybeInitCodec();
        } else if (this.codecReinitializationState != 0) {
            releaseCodec();
            maybeInitCodec();
        } else {
            this.codec.flush();
            this.codecReceivedBuffers = false;
        }
        if (this.codecReconfigured && this.format != null) {
            this.codecReconfigurationState = 1;
        }
    }

    /* access modifiers changed from: protected */
    public final MediaCodec getCodec() {
        return this.codec;
    }

    /* access modifiers changed from: protected */
    public final MediaCodecInfo getCodecInfo() {
        return this.codecInfo;
    }

    /* access modifiers changed from: protected */
    public MediaCodecInfo getDecoderInfo(MediaCodecSelector mediaCodecSelector2, Format format2, boolean z4) throws MediaCodecUtil.DecoderQueryException {
        return mediaCodecSelector2.getDecoderInfo(format2.sampleMimeType, z4);
    }

    /* access modifiers changed from: protected */
    public long getDequeueOutputBufferTimeoutUs() {
        return 0;
    }

    public boolean isEnded() {
        return this.outputStreamEnded;
    }

    public boolean isReady() {
        if (this.format == null || this.waitingForKeys) {
            return false;
        }
        if (isSourceReady() || hasOutputBuffer()) {
            return true;
        }
        if (this.codecHotswapDeadlineMs == C.TIME_UNSET || SystemClock.elapsedRealtime() >= this.codecHotswapDeadlineMs) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0040, code lost:
        if (r6 != 4) goto L_0x0008;
     */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0161  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void maybeInitCodec() throws com.mbridge.msdk.playercommon.exoplayer2.ExoPlaybackException {
        /*
            r12 = this;
            android.media.MediaCodec r0 = r12.codec
            if (r0 != 0) goto L_0x0008
            com.mbridge.msdk.playercommon.exoplayer2.Format r0 = r12.format
            if (r0 != 0) goto L_0x000b
        L_0x0008:
            r6 = r12
            goto L_0x0177
        L_0x000b:
            com.mbridge.msdk.playercommon.exoplayer2.drm.DrmSession<com.mbridge.msdk.playercommon.exoplayer2.drm.FrameworkMediaCrypto> r1 = r12.pendingDrmSession
            r12.drmSession = r1
            java.lang.String r0 = r0.sampleMimeType
            r2 = 0
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0052
            com.mbridge.msdk.playercommon.exoplayer2.drm.ExoMediaCrypto r1 = r1.getMediaCrypto()
            com.mbridge.msdk.playercommon.exoplayer2.drm.FrameworkMediaCrypto r1 = (com.mbridge.msdk.playercommon.exoplayer2.drm.FrameworkMediaCrypto) r1
            if (r1 != 0) goto L_0x0029
            com.mbridge.msdk.playercommon.exoplayer2.drm.DrmSession<com.mbridge.msdk.playercommon.exoplayer2.drm.FrameworkMediaCrypto> r1 = r12.drmSession
            com.mbridge.msdk.playercommon.exoplayer2.drm.DrmSession$DrmSessionException r1 = r1.getError()
            if (r1 == 0) goto L_0x0008
            r1 = r2
            r5 = r3
            goto L_0x0031
        L_0x0029:
            android.media.MediaCrypto r5 = r1.getWrappedMediaCrypto()
            boolean r1 = r1.requiresSecureDecoderComponent(r0)
        L_0x0031:
            boolean r6 = r12.deviceNeedsDrmKeysToConfigureCodecWorkaround()
            if (r6 == 0) goto L_0x0054
            com.mbridge.msdk.playercommon.exoplayer2.drm.DrmSession<com.mbridge.msdk.playercommon.exoplayer2.drm.FrameworkMediaCrypto> r6 = r12.drmSession
            int r6 = r6.getState()
            if (r6 == r4) goto L_0x0043
            r7 = 4
            if (r6 == r7) goto L_0x0054
            goto L_0x0008
        L_0x0043:
            com.mbridge.msdk.playercommon.exoplayer2.drm.DrmSession<com.mbridge.msdk.playercommon.exoplayer2.drm.FrameworkMediaCrypto> r0 = r12.drmSession
            com.mbridge.msdk.playercommon.exoplayer2.drm.DrmSession$DrmSessionException r0 = r0.getError()
            int r1 = r12.getIndex()
            com.mbridge.msdk.playercommon.exoplayer2.ExoPlaybackException r0 = com.mbridge.msdk.playercommon.exoplayer2.ExoPlaybackException.createForRenderer(r0, r1)
            throw r0
        L_0x0052:
            r1 = r2
            r5 = r3
        L_0x0054:
            com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecInfo r6 = r12.codecInfo
            if (r6 != 0) goto L_0x00b9
            com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecSelector r6 = r12.mediaCodecSelector     // Catch:{ DecoderQueryException -> 0x009a }
            com.mbridge.msdk.playercommon.exoplayer2.Format r7 = r12.format     // Catch:{ DecoderQueryException -> 0x009a }
            com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecInfo r6 = r12.getDecoderInfo(r6, r7, r1)     // Catch:{ DecoderQueryException -> 0x009a }
            r12.codecInfo = r6     // Catch:{ DecoderQueryException -> 0x009a }
            if (r6 != 0) goto L_0x00a8
            if (r1 == 0) goto L_0x00a8
            com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecSelector r6 = r12.mediaCodecSelector     // Catch:{ DecoderQueryException -> 0x009a }
            com.mbridge.msdk.playercommon.exoplayer2.Format r7 = r12.format     // Catch:{ DecoderQueryException -> 0x009a }
            com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecInfo r2 = r12.getDecoderInfo(r6, r7, r2)     // Catch:{ DecoderQueryException -> 0x009a }
            r12.codecInfo = r2     // Catch:{ DecoderQueryException -> 0x009a }
            if (r2 == 0) goto L_0x00a8
            java.lang.String r2 = "MediaCodecRenderer"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ DecoderQueryException -> 0x009a }
            r6.<init>()     // Catch:{ DecoderQueryException -> 0x009a }
            java.lang.String r7 = "Drm session requires secure decoder for "
            r6.append(r7)     // Catch:{ DecoderQueryException -> 0x009a }
            r6.append(r0)     // Catch:{ DecoderQueryException -> 0x009a }
            java.lang.String r0 = ", but no secure decoder available. Trying to proceed with "
            r6.append(r0)     // Catch:{ DecoderQueryException -> 0x009a }
            com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecInfo r0 = r12.codecInfo     // Catch:{ DecoderQueryException -> 0x009a }
            java.lang.String r0 = r0.name     // Catch:{ DecoderQueryException -> 0x009a }
            r6.append(r0)     // Catch:{ DecoderQueryException -> 0x009a }
            java.lang.String r0 = "."
            r6.append(r0)     // Catch:{ DecoderQueryException -> 0x009a }
            java.lang.String r0 = r6.toString()     // Catch:{ DecoderQueryException -> 0x009a }
            android.util.Log.w(r2, r0)     // Catch:{ DecoderQueryException -> 0x009a }
            goto L_0x00a8
        L_0x009a:
            r0 = move-exception
            com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecRenderer$DecoderInitializationException r2 = new com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecRenderer$DecoderInitializationException
            com.mbridge.msdk.playercommon.exoplayer2.Format r6 = r12.format
            r7 = -49998(0xffffffffffff3cb2, float:NaN)
            r2.<init>((com.mbridge.msdk.playercommon.exoplayer2.Format) r6, (java.lang.Throwable) r0, (boolean) r1, (int) r7)
            r12.throwDecoderInitError(r2)
        L_0x00a8:
            com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecInfo r0 = r12.codecInfo
            if (r0 != 0) goto L_0x00b9
            com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecRenderer$DecoderInitializationException r0 = new com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecRenderer$DecoderInitializationException
            com.mbridge.msdk.playercommon.exoplayer2.Format r2 = r12.format
            r6 = -49999(0xffffffffffff3cb1, float:NaN)
            r0.<init>((com.mbridge.msdk.playercommon.exoplayer2.Format) r2, (java.lang.Throwable) r3, (boolean) r1, (int) r6)
            r12.throwDecoderInitError(r0)
        L_0x00b9:
            com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecInfo r0 = r12.codecInfo
            boolean r0 = r12.shouldInitCodec(r0)
            if (r0 != 0) goto L_0x00c3
            goto L_0x0008
        L_0x00c3:
            com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecInfo r0 = r12.codecInfo
            java.lang.String r7 = r0.name
            int r0 = r12.codecAdaptationWorkaroundMode(r7)
            r12.codecAdaptationWorkaroundMode = r0
            com.mbridge.msdk.playercommon.exoplayer2.Format r0 = r12.format
            boolean r0 = codecNeedsDiscardToSpsWorkaround(r7, r0)
            r12.codecNeedsDiscardToSpsWorkaround = r0
            boolean r0 = codecNeedsFlushWorkaround(r7)
            r12.codecNeedsFlushWorkaround = r0
            com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecInfo r0 = r12.codecInfo
            boolean r0 = codecNeedsEosPropagationWorkaround(r0)
            r12.codecNeedsEosPropagationWorkaround = r0
            boolean r0 = codecNeedsEosFlushWorkaround(r7)
            r12.codecNeedsEosFlushWorkaround = r0
            boolean r0 = codecNeedsEosOutputExceptionWorkaround(r7)
            r12.codecNeedsEosOutputExceptionWorkaround = r0
            com.mbridge.msdk.playercommon.exoplayer2.Format r0 = r12.format
            boolean r0 = codecNeedsMonoChannelCountWorkaround(r7, r0)
            r12.codecNeedsMonoChannelCountWorkaround = r0
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0146 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0146 }
            r0.<init>()     // Catch:{ Exception -> 0x0146 }
            java.lang.String r6 = "createCodec:"
            r0.append(r6)     // Catch:{ Exception -> 0x0146 }
            r0.append(r7)     // Catch:{ Exception -> 0x0146 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0146 }
            com.mbridge.msdk.playercommon.exoplayer2.util.TraceUtil.beginSection(r0)     // Catch:{ Exception -> 0x0146 }
            android.media.MediaCodec r0 = android.media.MediaCodec.createByCodecName(r7)     // Catch:{ Exception -> 0x0146 }
            r12.codec = r0     // Catch:{ Exception -> 0x0146 }
            com.mbridge.msdk.playercommon.exoplayer2.util.TraceUtil.endSection()     // Catch:{ Exception -> 0x0146 }
            java.lang.String r0 = "configureCodec"
            com.mbridge.msdk.playercommon.exoplayer2.util.TraceUtil.beginSection(r0)     // Catch:{ Exception -> 0x0146 }
            com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecInfo r0 = r12.codecInfo     // Catch:{ Exception -> 0x0146 }
            android.media.MediaCodec r6 = r12.codec     // Catch:{ Exception -> 0x0146 }
            com.mbridge.msdk.playercommon.exoplayer2.Format r8 = r12.format     // Catch:{ Exception -> 0x0146 }
            r12.configureCodec(r0, r6, r8, r5)     // Catch:{ Exception -> 0x0146 }
            com.mbridge.msdk.playercommon.exoplayer2.util.TraceUtil.endSection()     // Catch:{ Exception -> 0x0146 }
            java.lang.String r0 = "startCodec"
            com.mbridge.msdk.playercommon.exoplayer2.util.TraceUtil.beginSection(r0)     // Catch:{ Exception -> 0x0146 }
            android.media.MediaCodec r0 = r12.codec     // Catch:{ Exception -> 0x0146 }
            r0.start()     // Catch:{ Exception -> 0x0146 }
            com.mbridge.msdk.playercommon.exoplayer2.util.TraceUtil.endSection()     // Catch:{ Exception -> 0x0146 }
            long r8 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0146 }
            long r10 = r8 - r2
            r6 = r12
            r6.onCodecInitialized(r7, r8, r10)     // Catch:{ Exception -> 0x0144 }
            r12.getCodecBuffers()     // Catch:{ Exception -> 0x0144 }
            goto L_0x0152
        L_0x0144:
            r0 = move-exception
            goto L_0x0148
        L_0x0146:
            r0 = move-exception
            r6 = r12
        L_0x0148:
            com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecRenderer$DecoderInitializationException r2 = new com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecRenderer$DecoderInitializationException
            com.mbridge.msdk.playercommon.exoplayer2.Format r3 = r6.format
            r2.<init>((com.mbridge.msdk.playercommon.exoplayer2.Format) r3, (java.lang.Throwable) r0, (boolean) r1, (java.lang.String) r7)
            r12.throwDecoderInitError(r2)
        L_0x0152:
            int r0 = r12.getState()
            r1 = 2
            if (r0 != r1) goto L_0x0161
            long r0 = android.os.SystemClock.elapsedRealtime()
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 + r2
            goto L_0x0166
        L_0x0161:
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x0166:
            r6.codecHotswapDeadlineMs = r0
            r12.resetInputBuffer()
            r12.resetOutputBuffer()
            r6.waitingForFirstSyncFrame = r4
            com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderCounters r0 = r6.decoderCounters
            int r1 = r0.decoderInitCount
            int r1 = r1 + r4
            r0.decoderInitCount = r1
        L_0x0177:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecRenderer.maybeInitCodec():void");
    }

    /* access modifiers changed from: protected */
    public void onCodecInitialized(String str, long j5, long j6) {
    }

    /* access modifiers changed from: protected */
    public void onDisabled() {
        this.format = null;
        try {
            releaseCodec();
            try {
                DrmSession<FrameworkMediaCrypto> drmSession2 = this.drmSession;
                if (drmSession2 != null) {
                    this.drmSessionManager.releaseSession(drmSession2);
                }
                try {
                    DrmSession<FrameworkMediaCrypto> drmSession3 = this.pendingDrmSession;
                    if (!(drmSession3 == null || drmSession3 == this.drmSession)) {
                        this.drmSessionManager.releaseSession(drmSession3);
                    }
                } finally {
                    this.drmSession = null;
                    this.pendingDrmSession = null;
                }
            } catch (Throwable th) {
                DrmSession<FrameworkMediaCrypto> drmSession4 = this.pendingDrmSession;
                if (!(drmSession4 == null || drmSession4 == this.drmSession)) {
                    this.drmSessionManager.releaseSession(drmSession4);
                }
                throw th;
            } finally {
                this.drmSession = null;
                this.pendingDrmSession = null;
            }
        } catch (Throwable th2) {
            try {
                DrmSession<FrameworkMediaCrypto> drmSession5 = this.pendingDrmSession;
                if (!(drmSession5 == null || drmSession5 == this.drmSession)) {
                    this.drmSessionManager.releaseSession(drmSession5);
                }
                throw th2;
            } finally {
                this.drmSession = null;
                this.pendingDrmSession = null;
            }
        } finally {
        }
    }

    /* access modifiers changed from: protected */
    public void onEnabled(boolean z4) throws ExoPlaybackException {
        this.decoderCounters = new DecoderCounters();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0078, code lost:
        if (r5.height == r0.height) goto L_0x007c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onInputFormatChanged(com.mbridge.msdk.playercommon.exoplayer2.Format r5) throws com.mbridge.msdk.playercommon.exoplayer2.ExoPlaybackException {
        /*
            r4 = this;
            com.mbridge.msdk.playercommon.exoplayer2.Format r0 = r4.format
            r4.format = r5
            com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData r5 = r5.drmInitData
            r1 = 0
            if (r0 != 0) goto L_0x000b
            r2 = r1
            goto L_0x000d
        L_0x000b:
            com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData r2 = r0.drmInitData
        L_0x000d:
            boolean r5 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.areEqual(r5, r2)
            if (r5 != 0) goto L_0x0047
            com.mbridge.msdk.playercommon.exoplayer2.Format r5 = r4.format
            com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData r5 = r5.drmInitData
            if (r5 == 0) goto L_0x0045
            com.mbridge.msdk.playercommon.exoplayer2.drm.DrmSessionManager<com.mbridge.msdk.playercommon.exoplayer2.drm.FrameworkMediaCrypto> r5 = r4.drmSessionManager
            if (r5 == 0) goto L_0x0035
            android.os.Looper r1 = android.os.Looper.myLooper()
            com.mbridge.msdk.playercommon.exoplayer2.Format r2 = r4.format
            com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData r2 = r2.drmInitData
            com.mbridge.msdk.playercommon.exoplayer2.drm.DrmSession r5 = r5.acquireSession(r1, r2)
            r4.pendingDrmSession = r5
            com.mbridge.msdk.playercommon.exoplayer2.drm.DrmSession<com.mbridge.msdk.playercommon.exoplayer2.drm.FrameworkMediaCrypto> r1 = r4.drmSession
            if (r5 != r1) goto L_0x0047
            com.mbridge.msdk.playercommon.exoplayer2.drm.DrmSessionManager<com.mbridge.msdk.playercommon.exoplayer2.drm.FrameworkMediaCrypto> r1 = r4.drmSessionManager
            r1.releaseSession(r5)
            goto L_0x0047
        L_0x0035:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Media requires a DrmSessionManager"
            r5.<init>(r0)
            int r0 = r4.getIndex()
            com.mbridge.msdk.playercommon.exoplayer2.ExoPlaybackException r5 = com.mbridge.msdk.playercommon.exoplayer2.ExoPlaybackException.createForRenderer(r5, r0)
            throw r5
        L_0x0045:
            r4.pendingDrmSession = r1
        L_0x0047:
            com.mbridge.msdk.playercommon.exoplayer2.drm.DrmSession<com.mbridge.msdk.playercommon.exoplayer2.drm.FrameworkMediaCrypto> r5 = r4.pendingDrmSession
            com.mbridge.msdk.playercommon.exoplayer2.drm.DrmSession<com.mbridge.msdk.playercommon.exoplayer2.drm.FrameworkMediaCrypto> r1 = r4.drmSession
            r2 = 1
            if (r5 != r1) goto L_0x0086
            android.media.MediaCodec r5 = r4.codec
            if (r5 == 0) goto L_0x0086
            com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecInfo r1 = r4.codecInfo
            com.mbridge.msdk.playercommon.exoplayer2.Format r3 = r4.format
            int r5 = r4.canKeepCodec(r5, r1, r0, r3)
            if (r5 == 0) goto L_0x0086
            if (r5 == r2) goto L_0x0085
            r1 = 3
            if (r5 != r1) goto L_0x007f
            r4.codecReconfigured = r2
            r4.codecReconfigurationState = r2
            int r5 = r4.codecAdaptationWorkaroundMode
            r1 = 2
            if (r5 == r1) goto L_0x007c
            if (r5 != r2) goto L_0x007b
            com.mbridge.msdk.playercommon.exoplayer2.Format r5 = r4.format
            int r1 = r5.width
            int r3 = r0.width
            if (r1 != r3) goto L_0x007b
            int r5 = r5.height
            int r0 = r0.height
            if (r5 != r0) goto L_0x007b
            goto L_0x007c
        L_0x007b:
            r2 = 0
        L_0x007c:
            r4.codecNeedsAdaptationWorkaroundBuffer = r2
            return
        L_0x007f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            r5.<init>()
            throw r5
        L_0x0085:
            return
        L_0x0086:
            boolean r5 = r4.codecReceivedBuffers
            if (r5 == 0) goto L_0x008d
            r4.codecReinitializationState = r2
            return
        L_0x008d:
            r4.releaseCodec()
            r4.maybeInitCodec()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecRenderer.onInputFormatChanged(com.mbridge.msdk.playercommon.exoplayer2.Format):void");
    }

    /* access modifiers changed from: protected */
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public void onPositionReset(long j5, boolean z4) throws ExoPlaybackException {
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        if (this.codec != null) {
            flushCodec();
        }
    }

    /* access modifiers changed from: protected */
    public void onProcessedOutputBuffer(long j5) {
    }

    /* access modifiers changed from: protected */
    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
    }

    /* access modifiers changed from: protected */
    public void onStarted() {
    }

    /* access modifiers changed from: protected */
    public void onStopped() {
    }

    /* access modifiers changed from: protected */
    public abstract boolean processOutputBuffer(long j5, long j6, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i5, int i6, long j7, boolean z4) throws ExoPlaybackException;

    /* access modifiers changed from: protected */
    public void releaseCodec() {
        this.codecHotswapDeadlineMs = C.TIME_UNSET;
        resetInputBuffer();
        resetOutputBuffer();
        this.waitingForKeys = false;
        this.shouldSkipOutputBuffer = false;
        this.decodeOnlyPresentationTimestamps.clear();
        resetCodecBuffers();
        this.codecInfo = null;
        this.codecReconfigured = false;
        this.codecReceivedBuffers = false;
        this.codecNeedsDiscardToSpsWorkaround = false;
        this.codecNeedsFlushWorkaround = false;
        this.codecAdaptationWorkaroundMode = 0;
        this.codecNeedsEosPropagationWorkaround = false;
        this.codecNeedsEosFlushWorkaround = false;
        this.codecNeedsMonoChannelCountWorkaround = false;
        this.codecNeedsAdaptationWorkaroundBuffer = false;
        this.shouldSkipAdaptationWorkaroundOutputBuffer = false;
        this.codecReceivedEos = false;
        this.codecReconfigurationState = 0;
        this.codecReinitializationState = 0;
        MediaCodec mediaCodec = this.codec;
        if (mediaCodec != null) {
            this.decoderCounters.decoderReleaseCount++;
            try {
                mediaCodec.stop();
                try {
                    this.codec.release();
                    this.codec = null;
                    DrmSession<FrameworkMediaCrypto> drmSession2 = this.drmSession;
                    if (drmSession2 != null && this.pendingDrmSession != drmSession2) {
                        try {
                            this.drmSessionManager.releaseSession(drmSession2);
                        } finally {
                            this.drmSession = null;
                        }
                    }
                } catch (Throwable th) {
                    this.codec = null;
                    DrmSession<FrameworkMediaCrypto> drmSession3 = this.drmSession;
                    if (!(drmSession3 == null || this.pendingDrmSession == drmSession3)) {
                        this.drmSessionManager.releaseSession(drmSession3);
                    }
                    throw th;
                } finally {
                    this.drmSession = null;
                }
            } catch (Throwable th2) {
                this.codec = null;
                DrmSession<FrameworkMediaCrypto> drmSession4 = this.drmSession;
                if (!(drmSession4 == null || this.pendingDrmSession == drmSession4)) {
                    try {
                        this.drmSessionManager.releaseSession(drmSession4);
                    } finally {
                        this.drmSession = null;
                    }
                }
                throw th2;
            } finally {
            }
        }
    }

    public void render(long j5, long j6) throws ExoPlaybackException {
        if (this.outputStreamEnded) {
            renderToEndOfStream();
            return;
        }
        if (this.format == null) {
            this.flagsOnlyBuffer.clear();
            int readSource = readSource(this.formatHolder, this.flagsOnlyBuffer, true);
            if (readSource == -5) {
                onInputFormatChanged(this.formatHolder.format);
            } else if (readSource == -4) {
                Assertions.checkState(this.flagsOnlyBuffer.isEndOfStream());
                this.inputStreamEnded = true;
                processEndOfStream();
                return;
            } else {
                return;
            }
        }
        maybeInitCodec();
        if (this.codec != null) {
            TraceUtil.beginSection("drainAndFeed");
            do {
            } while (drainOutputBuffer(j5, j6));
            do {
            } while (feedInputBuffer());
            TraceUtil.endSection();
        } else {
            this.decoderCounters.skippedInputBufferCount += skipSource(j5);
            this.flagsOnlyBuffer.clear();
            int readSource2 = readSource(this.formatHolder, this.flagsOnlyBuffer, false);
            if (readSource2 == -5) {
                onInputFormatChanged(this.formatHolder.format);
            } else if (readSource2 == -4) {
                Assertions.checkState(this.flagsOnlyBuffer.isEndOfStream());
                this.inputStreamEnded = true;
                processEndOfStream();
            }
        }
        this.decoderCounters.ensureUpdated();
    }

    /* access modifiers changed from: protected */
    public void renderToEndOfStream() throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public boolean shouldInitCodec(MediaCodecInfo mediaCodecInfo) {
        return true;
    }

    public final int supportsFormat(Format format2) throws ExoPlaybackException {
        try {
            return supportsFormat(this.mediaCodecSelector, this.drmSessionManager, format2);
        } catch (MediaCodecUtil.DecoderQueryException e5) {
            throw ExoPlaybackException.createForRenderer(e5, getIndex());
        }
    }

    /* access modifiers changed from: protected */
    public abstract int supportsFormat(MediaCodecSelector mediaCodecSelector2, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager2, Format format2) throws MediaCodecUtil.DecoderQueryException;

    public final int supportsMixedMimeTypeAdaptation() {
        return 8;
    }

    public static class DecoderInitializationException extends Exception {
        private static final int CUSTOM_ERROR_CODE_BASE = -50000;
        private static final int DECODER_QUERY_ERROR = -49998;
        private static final int NO_SUITABLE_DECODER_ERROR = -49999;
        public final String decoderName;
        public final String diagnosticInfo;
        public final String mimeType;
        public final boolean secureDecoderRequired;

        public DecoderInitializationException(Format format, Throwable th, boolean z4, int i5) {
            super("Decoder init failed: [" + i5 + "], " + format, th);
            this.mimeType = format.sampleMimeType;
            this.secureDecoderRequired = z4;
            this.decoderName = null;
            this.diagnosticInfo = buildCustomDiagnosticInfo(i5);
        }

        private static String buildCustomDiagnosticInfo(int i5) {
            String str;
            if (i5 < 0) {
                str = "neg_";
            } else {
                str = "";
            }
            return "com.google.android.exoplayer.MediaCodecTrackRenderer_" + str + Math.abs(i5);
        }

        @TargetApi(21)
        private static String getDiagnosticInfoV21(Throwable th) {
            if (th instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            return null;
        }

        public DecoderInitializationException(Format format, Throwable th, boolean z4, String str) {
            super("Decoder init failed: " + str + ", " + format, th);
            this.mimeType = format.sampleMimeType;
            this.secureDecoderRequired = z4;
            this.decoderName = str;
            this.diagnosticInfo = Util.SDK_INT >= 21 ? getDiagnosticInfoV21(th) : null;
        }
    }
}
