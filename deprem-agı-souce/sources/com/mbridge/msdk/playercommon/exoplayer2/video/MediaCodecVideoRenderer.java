package com.mbridge.msdk.playercommon.exoplayer2.video;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.WorkRequest;
import com.mbridge.msdk.playercommon.exoplayer2.BaseRenderer;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlaybackException;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderCounters;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderInputBuffer;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmSessionManager;
import com.mbridge.msdk.playercommon.exoplayer2.drm.FrameworkMediaCrypto;
import com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecInfo;
import com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecRenderer;
import com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecSelector;
import com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecUtil;
import com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaFormatUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.TraceUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import com.mbridge.msdk.playercommon.exoplayer2.video.VideoRendererEventListener;
import java.nio.ByteBuffer;

@TargetApi(16)
public class MediaCodecVideoRenderer extends MediaCodecRenderer {
    private static final String KEY_CROP_BOTTOM = "crop-bottom";
    private static final String KEY_CROP_LEFT = "crop-left";
    private static final String KEY_CROP_RIGHT = "crop-right";
    private static final String KEY_CROP_TOP = "crop-top";
    private static final int MAX_PENDING_OUTPUT_STREAM_OFFSET_COUNT = 10;
    private static final int[] STANDARD_LONG_EDGE_VIDEO_PX = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private static final String TAG = "MediaCodecVideoRenderer";
    private static boolean deviceNeedsSetOutputSurfaceWorkaround;
    private static boolean evaluatedDeviceNeedsSetOutputSurfaceWorkaround;
    private final long allowedJoiningTimeMs;
    private int buffersInCodecCount;
    private CodecMaxValues codecMaxValues;
    private boolean codecNeedsSetOutputSurfaceWorkaround;
    private int consecutiveDroppedFrameCount;
    private final Context context;
    private int currentHeight;
    private float currentPixelWidthHeightRatio;
    private int currentUnappliedRotationDegrees;
    private int currentWidth;
    private final boolean deviceNeedsAutoFrcWorkaround;
    private long droppedFrameAccumulationStartTimeMs;
    private int droppedFrames;
    private Surface dummySurface;
    private final VideoRendererEventListener.EventDispatcher eventDispatcher;
    private final VideoFrameReleaseTimeHelper frameReleaseTimeHelper;
    private long initialPositionUs;
    private long joiningDeadlineMs;
    private long lastInputTimeUs;
    private long lastRenderTimeUs;
    private final int maxDroppedFramesToNotify;
    private long outputStreamOffsetUs;
    private int pendingOutputStreamOffsetCount;
    private final long[] pendingOutputStreamOffsetsUs;
    private final long[] pendingOutputStreamSwitchTimesUs;
    private float pendingPixelWidthHeightRatio;
    private int pendingRotationDegrees;
    private boolean renderedFirstFrame;
    private int reportedHeight;
    private float reportedPixelWidthHeightRatio;
    private int reportedUnappliedRotationDegrees;
    private int reportedWidth;
    private int scalingMode;
    private Surface surface;
    private boolean tunneling;
    private int tunnelingAudioSessionId;
    OnFrameRenderedListenerV23 tunnelingOnFrameRenderedListener;

    protected static final class CodecMaxValues {
        public final int height;
        public final int inputSize;
        public final int width;

        public CodecMaxValues(int i5, int i6, int i7) {
            this.width = i5;
            this.height = i6;
            this.inputSize = i7;
        }
    }

    @TargetApi(23)
    private final class OnFrameRenderedListenerV23 implements MediaCodec.OnFrameRenderedListener {
        public final void onFrameRendered(@NonNull MediaCodec mediaCodec, long j5, long j6) {
            MediaCodecVideoRenderer mediaCodecVideoRenderer = MediaCodecVideoRenderer.this;
            if (this == mediaCodecVideoRenderer.tunnelingOnFrameRenderedListener) {
                mediaCodecVideoRenderer.maybeNotifyRenderedFirstFrame();
            }
        }

        private OnFrameRenderedListenerV23(MediaCodec mediaCodec) {
            mediaCodec.setOnFrameRenderedListener(this, new Handler());
        }
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecSelector mediaCodecSelector) {
        this(context2, mediaCodecSelector, 0);
    }

    private static boolean areAdaptationCompatible(boolean z4, Format format, Format format2) {
        if (!format.sampleMimeType.equals(format2.sampleMimeType) || format.rotationDegrees != format2.rotationDegrees) {
            return false;
        }
        if ((z4 || (format.width == format2.width && format.height == format2.height)) && Util.areEqual(format.colorInfo, format2.colorInfo)) {
            return true;
        }
        return false;
    }

    private void clearRenderedFirstFrame() {
        MediaCodec codec;
        this.renderedFirstFrame = false;
        if (Util.SDK_INT >= 23 && this.tunneling && (codec = getCodec()) != null) {
            this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23(codec);
        }
    }

    private void clearReportedVideoSize() {
        this.reportedWidth = -1;
        this.reportedHeight = -1;
        this.reportedPixelWidthHeightRatio = -1.0f;
        this.reportedUnappliedRotationDegrees = -1;
    }

    @TargetApi(21)
    private static void configureTunnelingV21(MediaFormat mediaFormat, int i5) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i5);
    }

    private static boolean deviceNeedsAutoFrcWorkaround() {
        if (Util.SDK_INT > 22 || !"foster".equals(Util.DEVICE) || !"NVIDIA".equals(Util.MANUFACTURER)) {
            return false;
        }
        return true;
    }

    private static Point getCodecMaxSize(MediaCodecInfo mediaCodecInfo, Format format) throws MediaCodecUtil.DecoderQueryException {
        boolean z4;
        int i5;
        int i6;
        int i7;
        int i8 = format.height;
        int i9 = format.width;
        if (i8 > i9) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            i5 = i8;
        } else {
            i5 = i9;
        }
        if (z4) {
            i8 = i9;
        }
        float f5 = ((float) i8) / ((float) i5);
        for (int i10 : STANDARD_LONG_EDGE_VIDEO_PX) {
            int i11 = (int) (((float) i10) * f5);
            if (i10 <= i5 || i11 <= i8) {
                break;
            }
            if (Util.SDK_INT >= 21) {
                if (z4) {
                    i7 = i11;
                } else {
                    i7 = i10;
                }
                if (!z4) {
                    i10 = i11;
                }
                Point alignVideoSizeV21 = mediaCodecInfo.alignVideoSizeV21(i7, i10);
                if (mediaCodecInfo.isVideoSizeAndRateSupportedV21(alignVideoSizeV21.x, alignVideoSizeV21.y, (double) format.frameRate)) {
                    return alignVideoSizeV21;
                }
            } else {
                int ceilDivide = Util.ceilDivide(i10, 16) * 16;
                int ceilDivide2 = Util.ceilDivide(i11, 16) * 16;
                if (ceilDivide * ceilDivide2 <= MediaCodecUtil.maxH264DecodableFrameSize()) {
                    if (z4) {
                        i6 = ceilDivide2;
                    } else {
                        i6 = ceilDivide;
                    }
                    if (!z4) {
                        ceilDivide = ceilDivide2;
                    }
                    return new Point(i6, ceilDivide);
                }
            }
        }
        return null;
    }

    private static int getMaxInputSize(MediaCodecInfo mediaCodecInfo, Format format) {
        if (format.maxInputSize == -1) {
            return getMaxInputSize(mediaCodecInfo, format.sampleMimeType, format.width, format.height);
        }
        int size = format.initializationData.size();
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            i5 += format.initializationData.get(i6).length;
        }
        return format.maxInputSize + i5;
    }

    private static boolean isBufferLate(long j5) {
        return j5 < -30000;
    }

    private static boolean isBufferVeryLate(long j5) {
        return j5 < -500000;
    }

    private void maybeNotifyDroppedFrames() {
        if (this.droppedFrames > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.eventDispatcher.droppedFrames(this.droppedFrames, elapsedRealtime - this.droppedFrameAccumulationStartTimeMs);
            this.droppedFrames = 0;
            this.droppedFrameAccumulationStartTimeMs = elapsedRealtime;
        }
    }

    private void maybeNotifyVideoSizeChanged() {
        int i5 = this.currentWidth;
        if (i5 != -1 || this.currentHeight != -1) {
            if (this.reportedWidth != i5 || this.reportedHeight != this.currentHeight || this.reportedUnappliedRotationDegrees != this.currentUnappliedRotationDegrees || this.reportedPixelWidthHeightRatio != this.currentPixelWidthHeightRatio) {
                this.eventDispatcher.videoSizeChanged(i5, this.currentHeight, this.currentUnappliedRotationDegrees, this.currentPixelWidthHeightRatio);
                this.reportedWidth = this.currentWidth;
                this.reportedHeight = this.currentHeight;
                this.reportedUnappliedRotationDegrees = this.currentUnappliedRotationDegrees;
                this.reportedPixelWidthHeightRatio = this.currentPixelWidthHeightRatio;
            }
        }
    }

    private void maybeRenotifyRenderedFirstFrame() {
        if (this.renderedFirstFrame) {
            this.eventDispatcher.renderedFirstFrame(this.surface);
        }
    }

    private void maybeRenotifyVideoSizeChanged() {
        int i5 = this.reportedWidth;
        if (i5 != -1 || this.reportedHeight != -1) {
            this.eventDispatcher.videoSizeChanged(i5, this.reportedHeight, this.reportedUnappliedRotationDegrees, this.reportedPixelWidthHeightRatio);
        }
    }

    private void setJoiningDeadlineMs() {
        long j5;
        if (this.allowedJoiningTimeMs > 0) {
            j5 = SystemClock.elapsedRealtime() + this.allowedJoiningTimeMs;
        } else {
            j5 = C.TIME_UNSET;
        }
        this.joiningDeadlineMs = j5;
    }

    @TargetApi(23)
    private static void setOutputSurfaceV23(MediaCodec mediaCodec, Surface surface2) {
        mediaCodec.setOutputSurface(surface2);
    }

    private void setSurface(Surface surface2) throws ExoPlaybackException {
        if (surface2 == null) {
            Surface surface3 = this.dummySurface;
            if (surface3 != null) {
                surface2 = surface3;
            } else {
                MediaCodecInfo codecInfo = getCodecInfo();
                if (codecInfo != null && shouldUseDummySurface(codecInfo)) {
                    surface2 = DummySurface.newInstanceV17(this.context, codecInfo.secure);
                    this.dummySurface = surface2;
                }
            }
        }
        if (this.surface != surface2) {
            this.surface = surface2;
            int state = getState();
            if (state == 1 || state == 2) {
                MediaCodec codec = getCodec();
                if (Util.SDK_INT < 23 || codec == null || surface2 == null || this.codecNeedsSetOutputSurfaceWorkaround) {
                    releaseCodec();
                    maybeInitCodec();
                } else {
                    setOutputSurfaceV23(codec, surface2);
                }
            }
            if (surface2 == null || surface2 == this.dummySurface) {
                clearReportedVideoSize();
                clearRenderedFirstFrame();
                return;
            }
            maybeRenotifyVideoSizeChanged();
            clearRenderedFirstFrame();
            if (state == 2) {
                setJoiningDeadlineMs();
            }
        } else if (surface2 != null && surface2 != this.dummySurface) {
            maybeRenotifyVideoSizeChanged();
            maybeRenotifyRenderedFirstFrame();
        }
    }

    private boolean shouldUseDummySurface(MediaCodecInfo mediaCodecInfo) {
        if (Util.SDK_INT < 23 || this.tunneling || codecNeedsSetOutputSurfaceWorkaround(mediaCodecInfo.name)) {
            return false;
        }
        if (!mediaCodecInfo.secure || DummySurface.isSecureSupported(this.context)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public int canKeepCodec(MediaCodec mediaCodec, MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        if (!areAdaptationCompatible(mediaCodecInfo.adaptive, format, format2)) {
            return 0;
        }
        int i5 = format2.width;
        CodecMaxValues codecMaxValues2 = this.codecMaxValues;
        if (i5 > codecMaxValues2.width || format2.height > codecMaxValues2.height || getMaxInputSize(mediaCodecInfo, format2) > this.codecMaxValues.inputSize) {
            return 0;
        }
        if (format.initializationDataEquals(format2)) {
            return 1;
        }
        return 3;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:368:0x059d, code lost:
        r2 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:369:0x059e, code lost:
        switch(r2) {
            case 0: goto L_0x05a2;
            case 1: goto L_0x05a2;
            case 2: goto L_0x05a2;
            case 3: goto L_0x05a2;
            case 4: goto L_0x05a2;
            case 5: goto L_0x05a2;
            case 6: goto L_0x05a2;
            case 7: goto L_0x05a2;
            case 8: goto L_0x05a2;
            case 9: goto L_0x05a2;
            case 10: goto L_0x05a2;
            case 11: goto L_0x05a2;
            case 12: goto L_0x05a2;
            case 13: goto L_0x05a2;
            case 14: goto L_0x05a2;
            case 15: goto L_0x05a2;
            case 16: goto L_0x05a2;
            case 17: goto L_0x05a2;
            case 18: goto L_0x05a2;
            case 19: goto L_0x05a2;
            case 20: goto L_0x05a2;
            case 21: goto L_0x05a2;
            case 22: goto L_0x05a2;
            case 23: goto L_0x05a2;
            case 24: goto L_0x05a2;
            case 25: goto L_0x05a2;
            case 26: goto L_0x05a2;
            case 27: goto L_0x05a2;
            case 28: goto L_0x05a2;
            case 29: goto L_0x05a2;
            case 30: goto L_0x05a2;
            case 31: goto L_0x05a2;
            case 32: goto L_0x05a2;
            case 33: goto L_0x05a2;
            case 34: goto L_0x05a2;
            case 35: goto L_0x05a2;
            case 36: goto L_0x05a2;
            case 37: goto L_0x05a2;
            case 38: goto L_0x05a2;
            case 39: goto L_0x05a2;
            case 40: goto L_0x05a2;
            case 41: goto L_0x05a2;
            case 42: goto L_0x05a2;
            case 43: goto L_0x05a2;
            case 44: goto L_0x05a2;
            case 45: goto L_0x05a2;
            case 46: goto L_0x05a2;
            case 47: goto L_0x05a2;
            case 48: goto L_0x05a2;
            case 49: goto L_0x05a2;
            case 50: goto L_0x05a2;
            case 51: goto L_0x05a2;
            case 52: goto L_0x05a2;
            case 53: goto L_0x05a2;
            case 54: goto L_0x05a2;
            case 55: goto L_0x05a2;
            case 56: goto L_0x05a2;
            case 57: goto L_0x05a2;
            case 58: goto L_0x05a2;
            case 59: goto L_0x05a2;
            case 60: goto L_0x05a2;
            case 61: goto L_0x05a2;
            case 62: goto L_0x05a2;
            case 63: goto L_0x05a2;
            case 64: goto L_0x05a2;
            case 65: goto L_0x05a2;
            case 66: goto L_0x05a2;
            case 67: goto L_0x05a2;
            case 68: goto L_0x05a2;
            case 69: goto L_0x05a2;
            case 70: goto L_0x05a2;
            case 71: goto L_0x05a2;
            case 72: goto L_0x05a2;
            case 73: goto L_0x05a2;
            case 74: goto L_0x05a2;
            case 75: goto L_0x05a2;
            case 76: goto L_0x05a2;
            case 77: goto L_0x05a2;
            case 78: goto L_0x05a2;
            case 79: goto L_0x05a2;
            case 80: goto L_0x05a2;
            case 81: goto L_0x05a2;
            case 82: goto L_0x05a2;
            case 83: goto L_0x05a2;
            case 84: goto L_0x05a2;
            case 85: goto L_0x05a2;
            case 86: goto L_0x05a2;
            case 87: goto L_0x05a2;
            case 88: goto L_0x05a2;
            case 89: goto L_0x05a2;
            case 90: goto L_0x05a2;
            case 91: goto L_0x05a2;
            case 92: goto L_0x05a2;
            case 93: goto L_0x05a2;
            case 94: goto L_0x05a2;
            case 95: goto L_0x05a2;
            case 96: goto L_0x05a2;
            case 97: goto L_0x05a2;
            case 98: goto L_0x05a2;
            case 99: goto L_0x05a2;
            case 100: goto L_0x05a2;
            case 101: goto L_0x05a2;
            case 102: goto L_0x05a2;
            case 103: goto L_0x05a2;
            case 104: goto L_0x05a2;
            case 105: goto L_0x05a2;
            case 106: goto L_0x05a2;
            case 107: goto L_0x05a2;
            case 108: goto L_0x05a2;
            case 109: goto L_0x05a2;
            case 110: goto L_0x05a2;
            case 111: goto L_0x05a2;
            case 112: goto L_0x05a2;
            case 113: goto L_0x05a2;
            case 114: goto L_0x05a2;
            case 115: goto L_0x05a2;
            case 116: goto L_0x05a2;
            case 117: goto L_0x05a2;
            default: goto L_0x05a1;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:371:0x05a2, code lost:
        deviceNeedsSetOutputSurfaceWorkaround = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:372:0x05a4, code lost:
        r0 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.MODEL;
        r2 = r0.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:373:0x05ad, code lost:
        if (r2 == 2006354) goto L_0x05bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:375:0x05b2, code lost:
        if (r2 == 2006367) goto L_0x05b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:378:0x05bb, code lost:
        if (r0.equals("AFTN") == false) goto L_0x05c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:379:0x05bd, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:381:0x05c5, code lost:
        if (r0.equals("AFTA") == false) goto L_0x05c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:383:0x05c8, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:384:0x05c9, code lost:
        if (r1 == false) goto L_0x05ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:385:0x05cb, code lost:
        if (r1 == true) goto L_0x05ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:387:0x05ce, code lost:
        deviceNeedsSetOutputSurfaceWorkaround = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:388:0x05d0, code lost:
        evaluatedDeviceNeedsSetOutputSurfaceWorkaround = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean codecNeedsSetOutputSurfaceWorkaround(java.lang.String r7) {
        /*
            r6 = this;
            int r0 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.SDK_INT
            r1 = 0
            r2 = 27
            if (r0 >= r2) goto L_0x05d8
            java.lang.String r0 = "OMX.google"
            boolean r7 = r7.startsWith(r0)
            if (r7 == 0) goto L_0x0011
            goto L_0x05d8
        L_0x0011:
            java.lang.Class<com.mbridge.msdk.playercommon.exoplayer2.video.MediaCodecVideoRenderer> r7 = com.mbridge.msdk.playercommon.exoplayer2.video.MediaCodecVideoRenderer.class
            monitor-enter(r7)
            boolean r0 = evaluatedDeviceNeedsSetOutputSurfaceWorkaround     // Catch:{ all -> 0x0031 }
            if (r0 != 0) goto L_0x05d2
            java.lang.String r0 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.DEVICE     // Catch:{ all -> 0x0031 }
            int r3 = r0.hashCode()     // Catch:{ all -> 0x0031 }
            r4 = -1
            r5 = 1
            switch(r3) {
                case -2144781245: goto L_0x0592;
                case -2144781185: goto L_0x0587;
                case -2144781160: goto L_0x057c;
                case -2097309513: goto L_0x0571;
                case -2022874474: goto L_0x0566;
                case -1978993182: goto L_0x055b;
                case -1978990237: goto L_0x0550;
                case -1936688988: goto L_0x0545;
                case -1936688066: goto L_0x053a;
                case -1936688065: goto L_0x052e;
                case -1931988508: goto L_0x0522;
                case -1696512866: goto L_0x0516;
                case -1680025915: goto L_0x050a;
                case -1615810839: goto L_0x04fe;
                case -1554255044: goto L_0x04f2;
                case -1481772737: goto L_0x04e6;
                case -1481772730: goto L_0x04da;
                case -1481772729: goto L_0x04ce;
                case -1320080169: goto L_0x04c2;
                case -1217592143: goto L_0x04b6;
                case -1180384755: goto L_0x04aa;
                case -1139198265: goto L_0x049e;
                case -1052835013: goto L_0x0492;
                case -993250464: goto L_0x0487;
                case -965403638: goto L_0x047b;
                case -958336948: goto L_0x046f;
                case -879245230: goto L_0x0463;
                case -842500323: goto L_0x0457;
                case -821392978: goto L_0x044c;
                case -797483286: goto L_0x0440;
                case -794946968: goto L_0x0434;
                case -788334647: goto L_0x0428;
                case -782144577: goto L_0x041c;
                case -575125681: goto L_0x0410;
                case -521118391: goto L_0x0404;
                case -430914369: goto L_0x03f8;
                case -290434366: goto L_0x03ec;
                case -282781963: goto L_0x03e0;
                case -277133239: goto L_0x03d4;
                case -173639913: goto L_0x03c8;
                case -56598463: goto L_0x03bc;
                case 2126: goto L_0x03b0;
                case 2564: goto L_0x03a4;
                case 2715: goto L_0x0398;
                case 2719: goto L_0x038c;
                case 3483: goto L_0x0380;
                case 73405: goto L_0x0374;
                case 75739: goto L_0x0368;
                case 76779: goto L_0x035c;
                case 78669: goto L_0x0350;
                case 79305: goto L_0x0344;
                case 80618: goto L_0x0338;
                case 88274: goto L_0x032c;
                case 98846: goto L_0x0320;
                case 98848: goto L_0x0314;
                case 99329: goto L_0x0308;
                case 101481: goto L_0x02fc;
                case 1513190: goto L_0x02f1;
                case 1514184: goto L_0x02e6;
                case 1514185: goto L_0x02db;
                case 2436959: goto L_0x02cf;
                case 2463773: goto L_0x02c3;
                case 2464648: goto L_0x02b7;
                case 2689555: goto L_0x02ab;
                case 3351335: goto L_0x029f;
                case 3386211: goto L_0x0293;
                case 41325051: goto L_0x0287;
                case 55178625: goto L_0x027b;
                case 61542055: goto L_0x0270;
                case 65355429: goto L_0x0264;
                case 66214468: goto L_0x0258;
                case 66214470: goto L_0x024c;
                case 66214473: goto L_0x0240;
                case 66215429: goto L_0x0234;
                case 66215431: goto L_0x0228;
                case 66215433: goto L_0x021c;
                case 66216390: goto L_0x0210;
                case 76402249: goto L_0x0204;
                case 76404105: goto L_0x01f8;
                case 76404911: goto L_0x01ec;
                case 80963634: goto L_0x01e0;
                case 82882791: goto L_0x01d4;
                case 102844228: goto L_0x01c8;
                case 165221241: goto L_0x01bd;
                case 182191441: goto L_0x01b1;
                case 245388979: goto L_0x01a5;
                case 287431619: goto L_0x0199;
                case 307593612: goto L_0x018d;
                case 308517133: goto L_0x0181;
                case 316215098: goto L_0x0175;
                case 316215116: goto L_0x0169;
                case 316246811: goto L_0x015d;
                case 316246818: goto L_0x0151;
                case 407160593: goto L_0x0145;
                case 507412548: goto L_0x0139;
                case 793982701: goto L_0x012d;
                case 794038622: goto L_0x0121;
                case 794040393: goto L_0x0115;
                case 835649806: goto L_0x0109;
                case 917340916: goto L_0x00fe;
                case 958008161: goto L_0x00f2;
                case 1060579533: goto L_0x00e6;
                case 1150207623: goto L_0x00da;
                case 1176899427: goto L_0x00ce;
                case 1280332038: goto L_0x00c2;
                case 1306947716: goto L_0x00b8;
                case 1349174697: goto L_0x00ac;
                case 1522194893: goto L_0x00a0;
                case 1691543273: goto L_0x0094;
                case 1709443163: goto L_0x0088;
                case 1865889110: goto L_0x007c;
                case 1906253259: goto L_0x0070;
                case 1977196784: goto L_0x0064;
                case 2029784656: goto L_0x0058;
                case 2030379515: goto L_0x004c;
                case 2047190025: goto L_0x0040;
                case 2047252157: goto L_0x0034;
                case 2048319463: goto L_0x0025;
                default: goto L_0x0023;
            }     // Catch:{ all -> 0x0031 }
        L_0x0023:
            goto L_0x059d
        L_0x0025:
            java.lang.String r2 = "HWVNS-H"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 50
            goto L_0x059e
        L_0x0031:
            r0 = move-exception
            goto L_0x05d6
        L_0x0034:
            java.lang.String r2 = "ELUGA_Prim"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 25
            goto L_0x059e
        L_0x0040:
            java.lang.String r2 = "ELUGA_Note"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 24
            goto L_0x059e
        L_0x004c:
            java.lang.String r2 = "HWCAM-H"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 49
            goto L_0x059e
        L_0x0058:
            java.lang.String r2 = "HWBLN-H"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 48
            goto L_0x059e
        L_0x0064:
            java.lang.String r2 = "Infinix-X572"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 52
            goto L_0x059e
        L_0x0070:
            java.lang.String r2 = "PB2-670M"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 79
            goto L_0x059e
        L_0x007c:
            java.lang.String r2 = "santoni"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 95
            goto L_0x059e
        L_0x0088:
            java.lang.String r2 = "iball8735_9806"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 51
            goto L_0x059e
        L_0x0094:
            java.lang.String r2 = "CPH1609"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 17
            goto L_0x059e
        L_0x00a0:
            java.lang.String r2 = "woods_f"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 111(0x6f, float:1.56E-43)
            goto L_0x059e
        L_0x00ac:
            java.lang.String r2 = "htc_e56ml_dtul"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 46
            goto L_0x059e
        L_0x00b8:
            java.lang.String r3 = "EverStar_S"
            boolean r0 = r0.equals(r3)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            goto L_0x059e
        L_0x00c2:
            java.lang.String r2 = "hwALE-H"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 47
            goto L_0x059e
        L_0x00ce:
            java.lang.String r2 = "itel_S41"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 54
            goto L_0x059e
        L_0x00da:
            java.lang.String r2 = "LS-5017"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 59
            goto L_0x059e
        L_0x00e6:
            java.lang.String r2 = "panell_d"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 75
            goto L_0x059e
        L_0x00f2:
            java.lang.String r2 = "j2xlteins"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 55
            goto L_0x059e
        L_0x00fe:
            java.lang.String r2 = "A7000plus"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 7
            goto L_0x059e
        L_0x0109:
            java.lang.String r2 = "manning"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 61
            goto L_0x059e
        L_0x0115:
            java.lang.String r2 = "GIONEE_WBL7519"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 44
            goto L_0x059e
        L_0x0121:
            java.lang.String r2 = "GIONEE_WBL7365"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 43
            goto L_0x059e
        L_0x012d:
            java.lang.String r2 = "GIONEE_WBL5708"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 42
            goto L_0x059e
        L_0x0139:
            java.lang.String r2 = "QM16XE_U"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 93
            goto L_0x059e
        L_0x0145:
            java.lang.String r2 = "Pixi5-10_4G"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 85
            goto L_0x059e
        L_0x0151:
            java.lang.String r2 = "TB3-850M"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 103(0x67, float:1.44E-43)
            goto L_0x059e
        L_0x015d:
            java.lang.String r2 = "TB3-850F"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 102(0x66, float:1.43E-43)
            goto L_0x059e
        L_0x0169:
            java.lang.String r2 = "TB3-730X"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 101(0x65, float:1.42E-43)
            goto L_0x059e
        L_0x0175:
            java.lang.String r2 = "TB3-730F"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 100
            goto L_0x059e
        L_0x0181:
            java.lang.String r2 = "A7020a48"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 9
            goto L_0x059e
        L_0x018d:
            java.lang.String r2 = "A7010a48"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 8
            goto L_0x059e
        L_0x0199:
            java.lang.String r2 = "griffin"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 45
            goto L_0x059e
        L_0x01a5:
            java.lang.String r2 = "marino_f"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 62
            goto L_0x059e
        L_0x01b1:
            java.lang.String r2 = "CPY83_I00"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 18
            goto L_0x059e
        L_0x01bd:
            java.lang.String r2 = "A2016a40"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 5
            goto L_0x059e
        L_0x01c8:
            java.lang.String r2 = "le_x6"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 58
            goto L_0x059e
        L_0x01d4:
            java.lang.String r2 = "X3_HK"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 113(0x71, float:1.58E-43)
            goto L_0x059e
        L_0x01e0:
            java.lang.String r2 = "V23GB"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 106(0x6a, float:1.49E-43)
            goto L_0x059e
        L_0x01ec:
            java.lang.String r2 = "Q4310"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 91
            goto L_0x059e
        L_0x01f8:
            java.lang.String r2 = "Q4260"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 89
            goto L_0x059e
        L_0x0204:
            java.lang.String r2 = "PRO7S"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 87
            goto L_0x059e
        L_0x0210:
            java.lang.String r2 = "F3311"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 34
            goto L_0x059e
        L_0x021c:
            java.lang.String r2 = "F3215"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 33
            goto L_0x059e
        L_0x0228:
            java.lang.String r2 = "F3213"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 32
            goto L_0x059e
        L_0x0234:
            java.lang.String r2 = "F3211"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 31
            goto L_0x059e
        L_0x0240:
            java.lang.String r2 = "F3116"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 30
            goto L_0x059e
        L_0x024c:
            java.lang.String r2 = "F3113"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 29
            goto L_0x059e
        L_0x0258:
            java.lang.String r2 = "F3111"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 28
            goto L_0x059e
        L_0x0264:
            java.lang.String r2 = "E5643"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 22
            goto L_0x059e
        L_0x0270:
            java.lang.String r2 = "A1601"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 4
            goto L_0x059e
        L_0x027b:
            java.lang.String r2 = "Aura_Note_2"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 11
            goto L_0x059e
        L_0x0287:
            java.lang.String r2 = "MEIZU_M5"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 63
            goto L_0x059e
        L_0x0293:
            java.lang.String r2 = "p212"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 72
            goto L_0x059e
        L_0x029f:
            java.lang.String r2 = "mido"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 65
            goto L_0x059e
        L_0x02ab:
            java.lang.String r2 = "XE2X"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 114(0x72, float:1.6E-43)
            goto L_0x059e
        L_0x02b7:
            java.lang.String r2 = "Q427"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 90
            goto L_0x059e
        L_0x02c3:
            java.lang.String r2 = "Q350"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 88
            goto L_0x059e
        L_0x02cf:
            java.lang.String r2 = "P681"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 73
            goto L_0x059e
        L_0x02db:
            java.lang.String r2 = "1714"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 2
            goto L_0x059e
        L_0x02e6:
            java.lang.String r2 = "1713"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = r5
            goto L_0x059e
        L_0x02f1:
            java.lang.String r2 = "1601"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = r1
            goto L_0x059e
        L_0x02fc:
            java.lang.String r2 = "flo"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 35
            goto L_0x059e
        L_0x0308:
            java.lang.String r2 = "deb"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 21
            goto L_0x059e
        L_0x0314:
            java.lang.String r2 = "cv3"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 20
            goto L_0x059e
        L_0x0320:
            java.lang.String r2 = "cv1"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 19
            goto L_0x059e
        L_0x032c:
            java.lang.String r2 = "Z80"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 117(0x75, float:1.64E-43)
            goto L_0x059e
        L_0x0338:
            java.lang.String r2 = "QX1"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 94
            goto L_0x059e
        L_0x0344:
            java.lang.String r2 = "PLE"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 86
            goto L_0x059e
        L_0x0350:
            java.lang.String r2 = "P85"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 74
            goto L_0x059e
        L_0x035c:
            java.lang.String r2 = "MX6"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 66
            goto L_0x059e
        L_0x0368:
            java.lang.String r2 = "M5c"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 60
            goto L_0x059e
        L_0x0374:
            java.lang.String r2 = "JGZ"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 56
            goto L_0x059e
        L_0x0380:
            java.lang.String r2 = "mh"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 64
            goto L_0x059e
        L_0x038c:
            java.lang.String r2 = "V5"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 107(0x6b, float:1.5E-43)
            goto L_0x059e
        L_0x0398:
            java.lang.String r2 = "V1"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 105(0x69, float:1.47E-43)
            goto L_0x059e
        L_0x03a4:
            java.lang.String r2 = "Q5"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 92
            goto L_0x059e
        L_0x03b0:
            java.lang.String r2 = "C1"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 14
            goto L_0x059e
        L_0x03bc:
            java.lang.String r2 = "woods_fn"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 112(0x70, float:1.57E-43)
            goto L_0x059e
        L_0x03c8:
            java.lang.String r2 = "ELUGA_A3_Pro"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 23
            goto L_0x059e
        L_0x03d4:
            java.lang.String r2 = "Z12_PRO"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 116(0x74, float:1.63E-43)
            goto L_0x059e
        L_0x03e0:
            java.lang.String r2 = "BLACK-1X"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 12
            goto L_0x059e
        L_0x03ec:
            java.lang.String r2 = "taido_row"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 99
            goto L_0x059e
        L_0x03f8:
            java.lang.String r2 = "Pixi4-7_3G"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 84
            goto L_0x059e
        L_0x0404:
            java.lang.String r2 = "GIONEE_GBL7360"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 38
            goto L_0x059e
        L_0x0410:
            java.lang.String r2 = "GiONEE_CBL7513"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 36
            goto L_0x059e
        L_0x041c:
            java.lang.String r2 = "OnePlus5T"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 71
            goto L_0x059e
        L_0x0428:
            java.lang.String r2 = "whyred"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 110(0x6e, float:1.54E-43)
            goto L_0x059e
        L_0x0434:
            java.lang.String r2 = "watson"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 109(0x6d, float:1.53E-43)
            goto L_0x059e
        L_0x0440:
            java.lang.String r2 = "SVP-DTV15"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 97
            goto L_0x059e
        L_0x044c:
            java.lang.String r2 = "A7000-a"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 6
            goto L_0x059e
        L_0x0457:
            java.lang.String r2 = "nicklaus_f"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 68
            goto L_0x059e
        L_0x0463:
            java.lang.String r2 = "tcl_eu"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 104(0x68, float:1.46E-43)
            goto L_0x059e
        L_0x046f:
            java.lang.String r2 = "ELUGA_Ray_X"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 26
            goto L_0x059e
        L_0x047b:
            java.lang.String r2 = "s905x018"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 98
            goto L_0x059e
        L_0x0487:
            java.lang.String r2 = "A10-70F"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 3
            goto L_0x059e
        L_0x0492:
            java.lang.String r2 = "namath"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 67
            goto L_0x059e
        L_0x049e:
            java.lang.String r2 = "Slate_Pro"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 96
            goto L_0x059e
        L_0x04aa:
            java.lang.String r2 = "iris60"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 53
            goto L_0x059e
        L_0x04b6:
            java.lang.String r2 = "BRAVIA_ATV2"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 13
            goto L_0x059e
        L_0x04c2:
            java.lang.String r2 = "GiONEE_GBL7319"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 37
            goto L_0x059e
        L_0x04ce:
            java.lang.String r2 = "panell_dt"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 78
            goto L_0x059e
        L_0x04da:
            java.lang.String r2 = "panell_ds"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 77
            goto L_0x059e
        L_0x04e6:
            java.lang.String r2 = "panell_dl"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 76
            goto L_0x059e
        L_0x04f2:
            java.lang.String r2 = "vernee_M5"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 108(0x6c, float:1.51E-43)
            goto L_0x059e
        L_0x04fe:
            java.lang.String r2 = "Phantom6"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 83
            goto L_0x059e
        L_0x050a:
            java.lang.String r2 = "ComioS1"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 15
            goto L_0x059e
        L_0x0516:
            java.lang.String r2 = "XT1663"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 115(0x73, float:1.61E-43)
            goto L_0x059e
        L_0x0522:
            java.lang.String r2 = "AquaPowerM"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 10
            goto L_0x059e
        L_0x052e:
            java.lang.String r2 = "PGN611"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 82
            goto L_0x059e
        L_0x053a:
            java.lang.String r2 = "PGN610"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 81
            goto L_0x059e
        L_0x0545:
            java.lang.String r2 = "PGN528"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 80
            goto L_0x059e
        L_0x0550:
            java.lang.String r2 = "NX573J"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 70
            goto L_0x059e
        L_0x055b:
            java.lang.String r2 = "NX541J"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 69
            goto L_0x059e
        L_0x0566:
            java.lang.String r2 = "CP8676_I02"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 16
            goto L_0x059e
        L_0x0571:
            java.lang.String r2 = "K50a40"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 57
            goto L_0x059e
        L_0x057c:
            java.lang.String r2 = "GIONEE_SWW1631"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 41
            goto L_0x059e
        L_0x0587:
            java.lang.String r2 = "GIONEE_SWW1627"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 40
            goto L_0x059e
        L_0x0592:
            java.lang.String r2 = "GIONEE_SWW1609"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x059d
            r2 = 39
            goto L_0x059e
        L_0x059d:
            r2 = r4
        L_0x059e:
            switch(r2) {
                case 0: goto L_0x05a2;
                case 1: goto L_0x05a2;
                case 2: goto L_0x05a2;
                case 3: goto L_0x05a2;
                case 4: goto L_0x05a2;
                case 5: goto L_0x05a2;
                case 6: goto L_0x05a2;
                case 7: goto L_0x05a2;
                case 8: goto L_0x05a2;
                case 9: goto L_0x05a2;
                case 10: goto L_0x05a2;
                case 11: goto L_0x05a2;
                case 12: goto L_0x05a2;
                case 13: goto L_0x05a2;
                case 14: goto L_0x05a2;
                case 15: goto L_0x05a2;
                case 16: goto L_0x05a2;
                case 17: goto L_0x05a2;
                case 18: goto L_0x05a2;
                case 19: goto L_0x05a2;
                case 20: goto L_0x05a2;
                case 21: goto L_0x05a2;
                case 22: goto L_0x05a2;
                case 23: goto L_0x05a2;
                case 24: goto L_0x05a2;
                case 25: goto L_0x05a2;
                case 26: goto L_0x05a2;
                case 27: goto L_0x05a2;
                case 28: goto L_0x05a2;
                case 29: goto L_0x05a2;
                case 30: goto L_0x05a2;
                case 31: goto L_0x05a2;
                case 32: goto L_0x05a2;
                case 33: goto L_0x05a2;
                case 34: goto L_0x05a2;
                case 35: goto L_0x05a2;
                case 36: goto L_0x05a2;
                case 37: goto L_0x05a2;
                case 38: goto L_0x05a2;
                case 39: goto L_0x05a2;
                case 40: goto L_0x05a2;
                case 41: goto L_0x05a2;
                case 42: goto L_0x05a2;
                case 43: goto L_0x05a2;
                case 44: goto L_0x05a2;
                case 45: goto L_0x05a2;
                case 46: goto L_0x05a2;
                case 47: goto L_0x05a2;
                case 48: goto L_0x05a2;
                case 49: goto L_0x05a2;
                case 50: goto L_0x05a2;
                case 51: goto L_0x05a2;
                case 52: goto L_0x05a2;
                case 53: goto L_0x05a2;
                case 54: goto L_0x05a2;
                case 55: goto L_0x05a2;
                case 56: goto L_0x05a2;
                case 57: goto L_0x05a2;
                case 58: goto L_0x05a2;
                case 59: goto L_0x05a2;
                case 60: goto L_0x05a2;
                case 61: goto L_0x05a2;
                case 62: goto L_0x05a2;
                case 63: goto L_0x05a2;
                case 64: goto L_0x05a2;
                case 65: goto L_0x05a2;
                case 66: goto L_0x05a2;
                case 67: goto L_0x05a2;
                case 68: goto L_0x05a2;
                case 69: goto L_0x05a2;
                case 70: goto L_0x05a2;
                case 71: goto L_0x05a2;
                case 72: goto L_0x05a2;
                case 73: goto L_0x05a2;
                case 74: goto L_0x05a2;
                case 75: goto L_0x05a2;
                case 76: goto L_0x05a2;
                case 77: goto L_0x05a2;
                case 78: goto L_0x05a2;
                case 79: goto L_0x05a2;
                case 80: goto L_0x05a2;
                case 81: goto L_0x05a2;
                case 82: goto L_0x05a2;
                case 83: goto L_0x05a2;
                case 84: goto L_0x05a2;
                case 85: goto L_0x05a2;
                case 86: goto L_0x05a2;
                case 87: goto L_0x05a2;
                case 88: goto L_0x05a2;
                case 89: goto L_0x05a2;
                case 90: goto L_0x05a2;
                case 91: goto L_0x05a2;
                case 92: goto L_0x05a2;
                case 93: goto L_0x05a2;
                case 94: goto L_0x05a2;
                case 95: goto L_0x05a2;
                case 96: goto L_0x05a2;
                case 97: goto L_0x05a2;
                case 98: goto L_0x05a2;
                case 99: goto L_0x05a2;
                case 100: goto L_0x05a2;
                case 101: goto L_0x05a2;
                case 102: goto L_0x05a2;
                case 103: goto L_0x05a2;
                case 104: goto L_0x05a2;
                case 105: goto L_0x05a2;
                case 106: goto L_0x05a2;
                case 107: goto L_0x05a2;
                case 108: goto L_0x05a2;
                case 109: goto L_0x05a2;
                case 110: goto L_0x05a2;
                case 111: goto L_0x05a2;
                case 112: goto L_0x05a2;
                case 113: goto L_0x05a2;
                case 114: goto L_0x05a2;
                case 115: goto L_0x05a2;
                case 116: goto L_0x05a2;
                case 117: goto L_0x05a2;
                default: goto L_0x05a1;
            }     // Catch:{ all -> 0x0031 }
        L_0x05a1:
            goto L_0x05a4
        L_0x05a2:
            deviceNeedsSetOutputSurfaceWorkaround = r5     // Catch:{ all -> 0x0031 }
        L_0x05a4:
            java.lang.String r0 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.MODEL     // Catch:{ all -> 0x0031 }
            int r2 = r0.hashCode()     // Catch:{ all -> 0x0031 }
            r3 = 2006354(0x1e9d52, float:2.811501E-39)
            if (r2 == r3) goto L_0x05bf
            r1 = 2006367(0x1e9d5f, float:2.811519E-39)
            if (r2 == r1) goto L_0x05b5
            goto L_0x05c8
        L_0x05b5:
            java.lang.String r1 = "AFTN"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x05c8
            r1 = r5
            goto L_0x05c9
        L_0x05bf:
            java.lang.String r2 = "AFTA"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x05c8
            goto L_0x05c9
        L_0x05c8:
            r1 = r4
        L_0x05c9:
            if (r1 == 0) goto L_0x05ce
            if (r1 == r5) goto L_0x05ce
            goto L_0x05d0
        L_0x05ce:
            deviceNeedsSetOutputSurfaceWorkaround = r5     // Catch:{ all -> 0x0031 }
        L_0x05d0:
            evaluatedDeviceNeedsSetOutputSurfaceWorkaround = r5     // Catch:{ all -> 0x0031 }
        L_0x05d2:
            monitor-exit(r7)     // Catch:{ all -> 0x0031 }
            boolean r7 = deviceNeedsSetOutputSurfaceWorkaround
            return r7
        L_0x05d6:
            monitor-exit(r7)     // Catch:{ all -> 0x0031 }
            throw r0
        L_0x05d8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.video.MediaCodecVideoRenderer.codecNeedsSetOutputSurfaceWorkaround(java.lang.String):boolean");
    }

    /* access modifiers changed from: protected */
    public void configureCodec(MediaCodecInfo mediaCodecInfo, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) throws MediaCodecUtil.DecoderQueryException {
        CodecMaxValues codecMaxValues2 = getCodecMaxValues(mediaCodecInfo, format, getStreamFormats());
        this.codecMaxValues = codecMaxValues2;
        MediaFormat mediaFormat = getMediaFormat(format, codecMaxValues2, this.deviceNeedsAutoFrcWorkaround, this.tunnelingAudioSessionId);
        if (this.surface == null) {
            Assertions.checkState(shouldUseDummySurface(mediaCodecInfo));
            if (this.dummySurface == null) {
                this.dummySurface = DummySurface.newInstanceV17(this.context, mediaCodecInfo.secure);
            }
            this.surface = this.dummySurface;
        }
        mediaCodec.configure(mediaFormat, this.surface, mediaCrypto, 0);
        if (Util.SDK_INT >= 23 && this.tunneling) {
            this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23(mediaCodec);
        }
    }

    /* access modifiers changed from: protected */
    public void dropOutputBuffer(MediaCodec mediaCodec, int i5, long j5) {
        TraceUtil.beginSection("dropVideoBuffer");
        mediaCodec.releaseOutputBuffer(i5, false);
        TraceUtil.endSection();
        updateDroppedBufferCounters(1);
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void flushCodec() throws ExoPlaybackException {
        super.flushCodec();
        this.buffersInCodecCount = 0;
    }

    /* access modifiers changed from: protected */
    public CodecMaxValues getCodecMaxValues(MediaCodecInfo mediaCodecInfo, Format format, Format[] formatArr) throws MediaCodecUtil.DecoderQueryException {
        boolean z4;
        int i5 = format.width;
        int i6 = format.height;
        int maxInputSize = getMaxInputSize(mediaCodecInfo, format);
        if (formatArr.length == 1) {
            return new CodecMaxValues(i5, i6, maxInputSize);
        }
        boolean z5 = false;
        for (Format format2 : formatArr) {
            if (areAdaptationCompatible(mediaCodecInfo.adaptive, format, format2)) {
                int i7 = format2.width;
                if (i7 == -1 || format2.height == -1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                z5 |= z4;
                i5 = Math.max(i5, i7);
                i6 = Math.max(i6, format2.height);
                maxInputSize = Math.max(maxInputSize, getMaxInputSize(mediaCodecInfo, format2));
            }
        }
        if (z5) {
            Log.w(TAG, "Resolutions unknown. Codec max resolution: " + i5 + "x" + i6);
            Point codecMaxSize = getCodecMaxSize(mediaCodecInfo, format);
            if (codecMaxSize != null) {
                i5 = Math.max(i5, codecMaxSize.x);
                i6 = Math.max(i6, codecMaxSize.y);
                maxInputSize = Math.max(maxInputSize, getMaxInputSize(mediaCodecInfo, format.sampleMimeType, i5, i6));
                Log.w(TAG, "Codec max resolution adjusted to: " + i5 + "x" + i6);
            }
        }
        return new CodecMaxValues(i5, i6, maxInputSize);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"InlinedApi"})
    public MediaFormat getMediaFormat(Format format, CodecMaxValues codecMaxValues2, boolean z4, int i5) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", format.sampleMimeType);
        mediaFormat.setInteger("width", format.width);
        mediaFormat.setInteger("height", format.height);
        MediaFormatUtil.setCsdBuffers(mediaFormat, format.initializationData);
        MediaFormatUtil.maybeSetFloat(mediaFormat, "frame-rate", format.frameRate);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "rotation-degrees", format.rotationDegrees);
        MediaFormatUtil.maybeSetColorInfo(mediaFormat, format.colorInfo);
        mediaFormat.setInteger("max-width", codecMaxValues2.width);
        mediaFormat.setInteger("max-height", codecMaxValues2.height);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "max-input-size", codecMaxValues2.inputSize);
        if (Util.SDK_INT >= 23) {
            mediaFormat.setInteger("priority", 0);
        }
        if (z4) {
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i5 != 0) {
            configureTunnelingV21(mediaFormat, i5);
        }
        return mediaFormat;
    }

    public void handleMessage(int i5, Object obj) throws ExoPlaybackException {
        if (i5 == 1) {
            setSurface((Surface) obj);
        } else if (i5 == 4) {
            this.scalingMode = ((Integer) obj).intValue();
            MediaCodec codec = getCodec();
            if (codec != null) {
                codec.setVideoScalingMode(this.scalingMode);
            }
        } else {
            super.handleMessage(i5, obj);
        }
    }

    public boolean isReady() {
        Surface surface2;
        if (super.isReady() && (this.renderedFirstFrame || (((surface2 = this.dummySurface) != null && this.surface == surface2) || getCodec() == null || this.tunneling))) {
            this.joiningDeadlineMs = C.TIME_UNSET;
            return true;
        } else if (this.joiningDeadlineMs == C.TIME_UNSET) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.joiningDeadlineMs) {
                return true;
            }
            this.joiningDeadlineMs = C.TIME_UNSET;
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean maybeDropBuffersToKeyframe(MediaCodec mediaCodec, int i5, long j5, long j6) throws ExoPlaybackException {
        int skipSource = skipSource(j6);
        if (skipSource == 0) {
            return false;
        }
        this.decoderCounters.droppedToKeyframeCount++;
        updateDroppedBufferCounters(this.buffersInCodecCount + skipSource);
        flushCodec();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void maybeNotifyRenderedFirstFrame() {
        if (!this.renderedFirstFrame) {
            this.renderedFirstFrame = true;
            this.eventDispatcher.renderedFirstFrame(this.surface);
        }
    }

    /* access modifiers changed from: protected */
    public void onCodecInitialized(String str, long j5, long j6) {
        String str2 = str;
        this.eventDispatcher.decoderInitialized(str2, j5, j6);
        this.codecNeedsSetOutputSurfaceWorkaround = codecNeedsSetOutputSurfaceWorkaround(str2);
    }

    /* access modifiers changed from: protected */
    public void onDisabled() {
        this.currentWidth = -1;
        this.currentHeight = -1;
        this.currentPixelWidthHeightRatio = -1.0f;
        this.pendingPixelWidthHeightRatio = -1.0f;
        this.outputStreamOffsetUs = C.TIME_UNSET;
        this.lastInputTimeUs = C.TIME_UNSET;
        this.pendingOutputStreamOffsetCount = 0;
        clearReportedVideoSize();
        clearRenderedFirstFrame();
        this.frameReleaseTimeHelper.disable();
        this.tunnelingOnFrameRenderedListener = null;
        this.tunneling = false;
        try {
            super.onDisabled();
        } finally {
            this.decoderCounters.ensureUpdated();
            this.eventDispatcher.disabled(this.decoderCounters);
        }
    }

    /* access modifiers changed from: protected */
    public void onEnabled(boolean z4) throws ExoPlaybackException {
        boolean z5;
        super.onEnabled(z4);
        int i5 = getConfiguration().tunnelingAudioSessionId;
        this.tunnelingAudioSessionId = i5;
        if (i5 != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.tunneling = z5;
        this.eventDispatcher.enabled(this.decoderCounters);
        this.frameReleaseTimeHelper.enable();
    }

    /* access modifiers changed from: protected */
    public void onInputFormatChanged(Format format) throws ExoPlaybackException {
        super.onInputFormatChanged(format);
        this.eventDispatcher.inputFormatChanged(format);
        this.pendingPixelWidthHeightRatio = format.pixelWidthHeightRatio;
        this.pendingRotationDegrees = format.rotationDegrees;
    }

    /* access modifiers changed from: protected */
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        boolean z4;
        int i5;
        int i6;
        if (!mediaFormat.containsKey(KEY_CROP_RIGHT) || !mediaFormat.containsKey(KEY_CROP_LEFT) || !mediaFormat.containsKey(KEY_CROP_BOTTOM) || !mediaFormat.containsKey(KEY_CROP_TOP)) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (z4) {
            i5 = (mediaFormat.getInteger(KEY_CROP_RIGHT) - mediaFormat.getInteger(KEY_CROP_LEFT)) + 1;
        } else {
            i5 = mediaFormat.getInteger("width");
        }
        this.currentWidth = i5;
        if (z4) {
            i6 = (mediaFormat.getInteger(KEY_CROP_BOTTOM) - mediaFormat.getInteger(KEY_CROP_TOP)) + 1;
        } else {
            i6 = mediaFormat.getInteger("height");
        }
        this.currentHeight = i6;
        float f5 = this.pendingPixelWidthHeightRatio;
        this.currentPixelWidthHeightRatio = f5;
        if (Util.SDK_INT >= 21) {
            int i7 = this.pendingRotationDegrees;
            if (i7 == 90 || i7 == 270) {
                int i8 = this.currentWidth;
                this.currentWidth = i6;
                this.currentHeight = i8;
                this.currentPixelWidthHeightRatio = 1.0f / f5;
            }
        } else {
            this.currentUnappliedRotationDegrees = this.pendingRotationDegrees;
        }
        mediaCodec.setVideoScalingMode(this.scalingMode);
    }

    /* access modifiers changed from: protected */
    public void onPositionReset(long j5, boolean z4) throws ExoPlaybackException {
        super.onPositionReset(j5, z4);
        clearRenderedFirstFrame();
        this.initialPositionUs = C.TIME_UNSET;
        this.consecutiveDroppedFrameCount = 0;
        this.lastInputTimeUs = C.TIME_UNSET;
        int i5 = this.pendingOutputStreamOffsetCount;
        if (i5 != 0) {
            this.outputStreamOffsetUs = this.pendingOutputStreamOffsetsUs[i5 - 1];
            this.pendingOutputStreamOffsetCount = 0;
        }
        if (z4) {
            setJoiningDeadlineMs();
        } else {
            this.joiningDeadlineMs = C.TIME_UNSET;
        }
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onProcessedOutputBuffer(long j5) {
        this.buffersInCodecCount--;
        while (true) {
            int i5 = this.pendingOutputStreamOffsetCount;
            if (i5 != 0 && j5 >= this.pendingOutputStreamSwitchTimesUs[0]) {
                long[] jArr = this.pendingOutputStreamOffsetsUs;
                this.outputStreamOffsetUs = jArr[0];
                int i6 = i5 - 1;
                this.pendingOutputStreamOffsetCount = i6;
                System.arraycopy(jArr, 1, jArr, 0, i6);
                long[] jArr2 = this.pendingOutputStreamSwitchTimesUs;
                System.arraycopy(jArr2, 1, jArr2, 0, this.pendingOutputStreamOffsetCount);
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        this.buffersInCodecCount++;
        this.lastInputTimeUs = Math.max(decoderInputBuffer.timeUs, this.lastInputTimeUs);
        if (Util.SDK_INT < 23 && this.tunneling) {
            maybeNotifyRenderedFirstFrame();
        }
    }

    /* access modifiers changed from: protected */
    public void onStarted() {
        super.onStarted();
        this.droppedFrames = 0;
        this.droppedFrameAccumulationStartTimeMs = SystemClock.elapsedRealtime();
        this.lastRenderTimeUs = SystemClock.elapsedRealtime() * 1000;
    }

    /* access modifiers changed from: protected */
    public void onStopped() {
        this.joiningDeadlineMs = C.TIME_UNSET;
        maybeNotifyDroppedFrames();
        super.onStopped();
    }

    /* access modifiers changed from: protected */
    public void onStreamChanged(Format[] formatArr, long j5) throws ExoPlaybackException {
        if (this.outputStreamOffsetUs == C.TIME_UNSET) {
            this.outputStreamOffsetUs = j5;
        } else {
            int i5 = this.pendingOutputStreamOffsetCount;
            if (i5 == this.pendingOutputStreamOffsetsUs.length) {
                Log.w(TAG, "Too many stream changes, so dropping offset: " + this.pendingOutputStreamOffsetsUs[this.pendingOutputStreamOffsetCount - 1]);
            } else {
                this.pendingOutputStreamOffsetCount = i5 + 1;
            }
            long[] jArr = this.pendingOutputStreamOffsetsUs;
            int i6 = this.pendingOutputStreamOffsetCount;
            jArr[i6 - 1] = j5;
            this.pendingOutputStreamSwitchTimesUs[i6 - 1] = this.lastInputTimeUs;
        }
        super.onStreamChanged(formatArr, j5);
    }

    /* access modifiers changed from: protected */
    public boolean processOutputBuffer(long j5, long j6, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i5, int i6, long j7, boolean z4) throws ExoPlaybackException {
        boolean z5;
        long j8;
        MediaCodec mediaCodec2;
        long j9 = j5;
        long j10 = j6;
        MediaCodec mediaCodec3 = mediaCodec;
        int i7 = i5;
        long j11 = j7;
        if (this.initialPositionUs == C.TIME_UNSET) {
            this.initialPositionUs = j9;
        }
        long j12 = j11 - this.outputStreamOffsetUs;
        if (z4) {
            skipOutputBuffer(mediaCodec3, i7, j12);
            return true;
        }
        long j13 = j11 - j9;
        if (this.surface != this.dummySurface) {
            long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
            if (getState() == 2) {
                z5 = true;
            } else {
                z5 = false;
            }
            long j14 = j12;
            if (!this.renderedFirstFrame || (z5 && shouldForceRenderOutputBuffer(j13, elapsedRealtime - this.lastRenderTimeUs))) {
                MediaCodec mediaCodec4 = mediaCodec;
                long j15 = j14;
                if (Util.SDK_INT >= 21) {
                    renderOutputBufferV21(mediaCodec4, i7, j15, System.nanoTime());
                } else {
                    renderOutputBuffer(mediaCodec4, i7, j15);
                }
                return true;
            }
            if (z5 && j9 != this.initialPositionUs) {
                long nanoTime = System.nanoTime();
                long adjustReleaseTime = this.frameReleaseTimeHelper.adjustReleaseTime(j11, ((j13 - (elapsedRealtime - j10)) * 1000) + nanoTime);
                long j16 = (adjustReleaseTime - nanoTime) / 1000;
                if (shouldDropBuffersToKeyframe(j16, j10)) {
                    mediaCodec2 = mediaCodec;
                    j8 = j14;
                    if (maybeDropBuffersToKeyframe(mediaCodec2, i7, j8, j9)) {
                        return false;
                    }
                } else {
                    mediaCodec2 = mediaCodec;
                    j8 = j14;
                }
                if (shouldDropOutputBuffer(j16, j10)) {
                    dropOutputBuffer(mediaCodec2, i7, j8);
                    return true;
                } else if (Util.SDK_INT >= 21) {
                    if (j16 < 50000) {
                        renderOutputBufferV21(mediaCodec2, i7, j8, adjustReleaseTime);
                        return true;
                    }
                } else if (j16 < WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                    if (j16 > 11000) {
                        try {
                            Thread.sleep((j16 - WorkRequest.MIN_BACKOFF_MILLIS) / 1000);
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            return false;
                        }
                    }
                    renderOutputBuffer(mediaCodec2, i7, j8);
                    return true;
                }
            }
            return false;
        } else if (!isBufferLate(j13)) {
            return false;
        } else {
            skipOutputBuffer(mediaCodec3, i7, j12);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void releaseCodec() {
        try {
            super.releaseCodec();
            this.buffersInCodecCount = 0;
            Surface surface2 = this.dummySurface;
            if (surface2 != null) {
                if (this.surface == surface2) {
                    this.surface = null;
                }
                surface2.release();
                this.dummySurface = null;
            }
        } catch (Throwable th) {
            this.buffersInCodecCount = 0;
            if (this.dummySurface != null) {
                Surface surface3 = this.surface;
                Surface surface4 = this.dummySurface;
                if (surface3 == surface4) {
                    this.surface = null;
                }
                surface4.release();
                this.dummySurface = null;
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public void renderOutputBuffer(MediaCodec mediaCodec, int i5, long j5) {
        maybeNotifyVideoSizeChanged();
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i5, true);
        TraceUtil.endSection();
        this.lastRenderTimeUs = SystemClock.elapsedRealtime() * 1000;
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        maybeNotifyRenderedFirstFrame();
    }

    /* access modifiers changed from: protected */
    @TargetApi(21)
    public void renderOutputBufferV21(MediaCodec mediaCodec, int i5, long j5, long j6) {
        maybeNotifyVideoSizeChanged();
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i5, j6);
        TraceUtil.endSection();
        this.lastRenderTimeUs = SystemClock.elapsedRealtime() * 1000;
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        maybeNotifyRenderedFirstFrame();
    }

    /* access modifiers changed from: protected */
    public boolean shouldDropBuffersToKeyframe(long j5, long j6) {
        return isBufferVeryLate(j5);
    }

    /* access modifiers changed from: protected */
    public boolean shouldDropOutputBuffer(long j5, long j6) {
        return isBufferLate(j5);
    }

    /* access modifiers changed from: protected */
    public boolean shouldForceRenderOutputBuffer(long j5, long j6) {
        if (!isBufferLate(j5) || j6 <= 100000) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean shouldInitCodec(MediaCodecInfo mediaCodecInfo) {
        if (this.surface != null || shouldUseDummySurface(mediaCodecInfo)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void skipOutputBuffer(MediaCodec mediaCodec, int i5, long j5) {
        TraceUtil.beginSection("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i5, false);
        TraceUtil.endSection();
        this.decoderCounters.skippedOutputBufferCount++;
    }

    /* access modifiers changed from: protected */
    public int supportsFormat(MediaCodecSelector mediaCodecSelector, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, Format format) throws MediaCodecUtil.DecoderQueryException {
        boolean z4;
        int i5;
        int i6;
        int i7;
        int i8;
        String str = format.sampleMimeType;
        int i9 = 0;
        if (!MimeTypes.isVideo(str)) {
            return 0;
        }
        DrmInitData drmInitData = format.drmInitData;
        if (drmInitData != null) {
            z4 = false;
            for (int i10 = 0; i10 < drmInitData.schemeDataCount; i10++) {
                z4 |= drmInitData.get(i10).requiresSecureDecryption;
            }
        } else {
            z4 = false;
        }
        MediaCodecInfo decoderInfo = mediaCodecSelector.getDecoderInfo(str, z4);
        boolean z5 = true;
        if (decoderInfo == null) {
            if (!z4 || mediaCodecSelector.getDecoderInfo(str, false) == null) {
                return 1;
            }
            return 2;
        } else if (!BaseRenderer.supportsFormatDrm(drmSessionManager, drmInitData)) {
            return 2;
        } else {
            boolean isCodecSupported = decoderInfo.isCodecSupported(format.codecs);
            if (isCodecSupported && (i7 = format.width) > 0 && (i8 = format.height) > 0) {
                if (Util.SDK_INT >= 21) {
                    isCodecSupported = decoderInfo.isVideoSizeAndRateSupportedV21(i7, i8, (double) format.frameRate);
                } else {
                    if (i7 * i8 > MediaCodecUtil.maxH264DecodableFrameSize()) {
                        z5 = false;
                    }
                    if (!z5) {
                        Log.d(TAG, "FalseCheck [legacyFrameSize, " + format.width + "x" + format.height + "] [" + Util.DEVICE_DEBUG_INFO + "]");
                    }
                    isCodecSupported = z5;
                }
            }
            if (decoderInfo.adaptive) {
                i5 = 16;
            } else {
                i5 = 8;
            }
            if (decoderInfo.tunneling) {
                i9 = 32;
            }
            if (isCodecSupported) {
                i6 = 4;
            } else {
                i6 = 3;
            }
            return i6 | i5 | i9;
        }
    }

    /* access modifiers changed from: protected */
    public void updateDroppedBufferCounters(int i5) {
        DecoderCounters decoderCounters = this.decoderCounters;
        decoderCounters.droppedBufferCount += i5;
        this.droppedFrames += i5;
        int i6 = this.consecutiveDroppedFrameCount + i5;
        this.consecutiveDroppedFrameCount = i6;
        decoderCounters.maxConsecutiveDroppedBufferCount = Math.max(i6, decoderCounters.maxConsecutiveDroppedBufferCount);
        if (this.droppedFrames >= this.maxDroppedFramesToNotify) {
            maybeNotifyDroppedFrames();
        }
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecSelector mediaCodecSelector, long j5) {
        this(context2, mediaCodecSelector, j5, (Handler) null, (VideoRendererEventListener) null, -1);
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecSelector mediaCodecSelector, long j5, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i5) {
        this(context2, mediaCodecSelector, j5, (DrmSessionManager<FrameworkMediaCrypto>) null, false, handler, videoRendererEventListener, i5);
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecSelector mediaCodecSelector, long j5, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z4, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i5) {
        super(2, mediaCodecSelector, drmSessionManager, z4);
        this.allowedJoiningTimeMs = j5;
        this.maxDroppedFramesToNotify = i5;
        Context applicationContext = context2.getApplicationContext();
        this.context = applicationContext;
        this.frameReleaseTimeHelper = new VideoFrameReleaseTimeHelper(applicationContext);
        this.eventDispatcher = new VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        this.deviceNeedsAutoFrcWorkaround = deviceNeedsAutoFrcWorkaround();
        this.pendingOutputStreamOffsetsUs = new long[10];
        this.pendingOutputStreamSwitchTimesUs = new long[10];
        this.outputStreamOffsetUs = C.TIME_UNSET;
        this.lastInputTimeUs = C.TIME_UNSET;
        this.joiningDeadlineMs = C.TIME_UNSET;
        this.currentWidth = -1;
        this.currentHeight = -1;
        this.currentPixelWidthHeightRatio = -1.0f;
        this.pendingPixelWidthHeightRatio = -1.0f;
        this.scalingMode = 1;
        clearReportedVideoSize();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int getMaxInputSize(com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecInfo r5, java.lang.String r6, int r7, int r8) {
        /*
            r0 = -1
            if (r7 == r0) goto L_0x009b
            if (r8 != r0) goto L_0x0007
            goto L_0x009b
        L_0x0007:
            r6.getClass()
            int r1 = r6.hashCode()
            r2 = 4
            r3 = 3
            r4 = 2
            switch(r1) {
                case -1664118616: goto L_0x004d;
                case -1662541442: goto L_0x0042;
                case 1187890754: goto L_0x0037;
                case 1331836730: goto L_0x002c;
                case 1599127256: goto L_0x0021;
                case 1599127257: goto L_0x0016;
                default: goto L_0x0014;
            }
        L_0x0014:
            r6 = r0
            goto L_0x0057
        L_0x0016:
            java.lang.String r1 = "video/x-vnd.on2.vp9"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x001f
            goto L_0x0014
        L_0x001f:
            r6 = 5
            goto L_0x0057
        L_0x0021:
            java.lang.String r1 = "video/x-vnd.on2.vp8"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x002a
            goto L_0x0014
        L_0x002a:
            r6 = r2
            goto L_0x0057
        L_0x002c:
            java.lang.String r1 = "video/avc"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0035
            goto L_0x0014
        L_0x0035:
            r6 = r3
            goto L_0x0057
        L_0x0037:
            java.lang.String r1 = "video/mp4v-es"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0040
            goto L_0x0014
        L_0x0040:
            r6 = r4
            goto L_0x0057
        L_0x0042:
            java.lang.String r1 = "video/hevc"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x004b
            goto L_0x0014
        L_0x004b:
            r6 = 1
            goto L_0x0057
        L_0x004d:
            java.lang.String r1 = "video/3gpp"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0056
            goto L_0x0014
        L_0x0056:
            r6 = 0
        L_0x0057:
            switch(r6) {
                case 0: goto L_0x005b;
                case 1: goto L_0x0096;
                case 2: goto L_0x005b;
                case 3: goto L_0x005e;
                case 4: goto L_0x005b;
                case 5: goto L_0x0096;
                default: goto L_0x005a;
            }
        L_0x005a:
            return r0
        L_0x005b:
            int r7 = r7 * r8
        L_0x005c:
            r2 = r4
            goto L_0x0097
        L_0x005e:
            java.lang.String r6 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.MODEL
            java.lang.String r1 = "BRAVIA 4K 2015"
            boolean r1 = r1.equals(r6)
            if (r1 != 0) goto L_0x0095
            java.lang.String r1 = "Amazon"
            java.lang.String r2 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.MANUFACTURER
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0087
            java.lang.String r1 = "KFSOWI"
            boolean r1 = r1.equals(r6)
            if (r1 != 0) goto L_0x0095
            java.lang.String r1 = "AFTS"
            boolean r6 = r1.equals(r6)
            if (r6 == 0) goto L_0x0087
            boolean r5 = r5.secure
            if (r5 == 0) goto L_0x0087
            goto L_0x0095
        L_0x0087:
            r5 = 16
            int r6 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.ceilDivide((int) r7, (int) r5)
            int r5 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.ceilDivide((int) r8, (int) r5)
            int r6 = r6 * r5
            int r7 = r6 * 256
            goto L_0x005c
        L_0x0095:
            return r0
        L_0x0096:
            int r7 = r7 * r8
        L_0x0097:
            int r7 = r7 * r3
            int r2 = r2 * r4
            int r7 = r7 / r2
            return r7
        L_0x009b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.video.MediaCodecVideoRenderer.getMaxInputSize(com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecInfo, java.lang.String, int, int):int");
    }
}
