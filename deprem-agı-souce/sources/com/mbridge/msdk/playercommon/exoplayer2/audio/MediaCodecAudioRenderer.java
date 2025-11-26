package com.mbridge.msdk.playercommon.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.BaseRenderer;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlaybackException;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.PlaybackParameters;
import com.mbridge.msdk.playercommon.exoplayer2.audio.AudioRendererEventListener;
import com.mbridge.msdk.playercommon.exoplayer2.audio.AudioSink;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderInputBuffer;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmSessionManager;
import com.mbridge.msdk.playercommon.exoplayer2.drm.FrameworkMediaCrypto;
import com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecInfo;
import com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecRenderer;
import com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecSelector;
import com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecUtil;
import com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaFormatUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.MediaClock;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.nio.ByteBuffer;

@TargetApi(16)
public class MediaCodecAudioRenderer extends MediaCodecRenderer implements MediaClock {
    private boolean allowFirstBufferPositionDiscontinuity;
    /* access modifiers changed from: private */
    public boolean allowPositionDiscontinuity;
    private final AudioSink audioSink;
    private int channelCount;
    private int codecMaxInputSize;
    private boolean codecNeedsDiscardChannelsWorkaround;
    private final Context context;
    private long currentPositionUs;
    private int encoderDelay;
    private int encoderPadding;
    /* access modifiers changed from: private */
    public final AudioRendererEventListener.EventDispatcher eventDispatcher;
    private boolean passthroughEnabled;
    private MediaFormat passthroughMediaFormat;
    private int pcmEncoding;

    private final class AudioSinkListener implements AudioSink.Listener {
        private AudioSinkListener() {
        }

        public final void onAudioSessionId(int i5) {
            MediaCodecAudioRenderer.this.eventDispatcher.audioSessionId(i5);
            MediaCodecAudioRenderer.this.onAudioSessionId(i5);
        }

        public final void onPositionDiscontinuity() {
            MediaCodecAudioRenderer.this.onAudioTrackPositionDiscontinuity();
            boolean unused = MediaCodecAudioRenderer.this.allowPositionDiscontinuity = true;
        }

        public final void onUnderrun(int i5, long j5, long j6) {
            int i6 = i5;
            long j7 = j5;
            long j8 = j6;
            MediaCodecAudioRenderer.this.eventDispatcher.audioTrackUnderrun(i6, j7, j8);
            long j9 = j7;
            int i7 = i6;
            MediaCodecAudioRenderer.this.onAudioTrackUnderrun(i7, j9, j8);
        }
    }

    public MediaCodecAudioRenderer(Context context2, MediaCodecSelector mediaCodecSelector) {
        this(context2, mediaCodecSelector, (DrmSessionManager<FrameworkMediaCrypto>) null, false);
    }

    private static boolean areAdaptationCompatible(Format format, Format format2) {
        if (format.sampleMimeType.equals(format2.sampleMimeType) && format.channelCount == format2.channelCount && format.sampleRate == format2.sampleRate && format.encoderDelay == 0 && format.encoderPadding == 0 && format2.encoderDelay == 0 && format2.encoderPadding == 0 && format.initializationDataEquals(format2)) {
            return true;
        }
        return false;
    }

    private static boolean codecNeedsDiscardChannelsWorkaround(String str) {
        if (Util.SDK_INT >= 24 || !"OMX.SEC.aac.dec".equals(str) || !"samsung".equals(Util.MANUFACTURER)) {
            return false;
        }
        String str2 = Util.DEVICE;
        if (str2.startsWith("zeroflte") || str2.startsWith("herolte") || str2.startsWith("heroqlte")) {
            return true;
        }
        return false;
    }

    private void updateCurrentPosition() {
        long currentPositionUs2 = this.audioSink.getCurrentPositionUs(isEnded());
        if (currentPositionUs2 != Long.MIN_VALUE) {
            if (!this.allowPositionDiscontinuity) {
                currentPositionUs2 = Math.max(this.currentPositionUs, currentPositionUs2);
            }
            this.currentPositionUs = currentPositionUs2;
            this.allowPositionDiscontinuity = false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean allowPassthrough(String str) {
        int encoding = MimeTypes.getEncoding(str);
        if (encoding == 0 || !this.audioSink.isEncodingSupported(encoding)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public int canKeepCodec(MediaCodec mediaCodec, MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void configureCodec(MediaCodecInfo mediaCodecInfo, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        this.codecMaxInputSize = getCodecMaxInputSize(mediaCodecInfo, format, getStreamFormats());
        this.codecNeedsDiscardChannelsWorkaround = codecNeedsDiscardChannelsWorkaround(mediaCodecInfo.name);
        this.passthroughEnabled = mediaCodecInfo.passthrough;
        String str = mediaCodecInfo.mimeType;
        if (str == null) {
            str = MimeTypes.AUDIO_RAW;
        }
        MediaFormat mediaFormat = getMediaFormat(format, str, this.codecMaxInputSize);
        mediaCodec.configure(mediaFormat, (Surface) null, mediaCrypto, 0);
        if (this.passthroughEnabled) {
            this.passthroughMediaFormat = mediaFormat;
            mediaFormat.setString("mime", format.sampleMimeType);
            return;
        }
        this.passthroughMediaFormat = null;
    }

    /* access modifiers changed from: protected */
    public int getCodecMaxInputSize(MediaCodecInfo mediaCodecInfo, Format format, Format[] formatArr) {
        return getCodecMaxInputSize(mediaCodecInfo, format);
    }

    /* access modifiers changed from: protected */
    public MediaCodecInfo getDecoderInfo(MediaCodecSelector mediaCodecSelector, Format format, boolean z4) throws MediaCodecUtil.DecoderQueryException {
        MediaCodecInfo passthroughDecoderInfo;
        if (!allowPassthrough(format.sampleMimeType) || (passthroughDecoderInfo = mediaCodecSelector.getPassthroughDecoderInfo()) == null) {
            return super.getDecoderInfo(mediaCodecSelector, format, z4);
        }
        return passthroughDecoderInfo;
    }

    public MediaClock getMediaClock() {
        return this;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"InlinedApi"})
    public MediaFormat getMediaFormat(Format format, String str, int i5) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("channel-count", format.channelCount);
        mediaFormat.setInteger("sample-rate", format.sampleRate);
        MediaFormatUtil.setCsdBuffers(mediaFormat, format.initializationData);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "max-input-size", i5);
        if (Util.SDK_INT >= 23) {
            mediaFormat.setInteger("priority", 0);
        }
        return mediaFormat;
    }

    public PlaybackParameters getPlaybackParameters() {
        return this.audioSink.getPlaybackParameters();
    }

    public long getPositionUs() {
        if (getState() == 2) {
            updateCurrentPosition();
        }
        return this.currentPositionUs;
    }

    public void handleMessage(int i5, Object obj) throws ExoPlaybackException {
        if (i5 == 2) {
            this.audioSink.setVolume(((Float) obj).floatValue());
        } else if (i5 != 3) {
            super.handleMessage(i5, obj);
        } else {
            this.audioSink.setAudioAttributes((AudioAttributes) obj);
        }
    }

    public boolean isEnded() {
        if (!super.isEnded() || !this.audioSink.isEnded()) {
            return false;
        }
        return true;
    }

    public boolean isReady() {
        if (this.audioSink.hasPendingData() || super.isReady()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onAudioSessionId(int i5) {
    }

    /* access modifiers changed from: protected */
    public void onAudioTrackPositionDiscontinuity() {
    }

    /* access modifiers changed from: protected */
    public void onAudioTrackUnderrun(int i5, long j5, long j6) {
    }

    /* access modifiers changed from: protected */
    public void onCodecInitialized(String str, long j5, long j6) {
        this.eventDispatcher.decoderInitialized(str, j5, j6);
    }

    /* access modifiers changed from: protected */
    public void onDisabled() {
        try {
            this.audioSink.release();
            try {
                super.onDisabled();
            } finally {
                this.decoderCounters.ensureUpdated();
                this.eventDispatcher.disabled(this.decoderCounters);
            }
        } catch (Throwable th) {
            super.onDisabled();
            throw th;
        } finally {
            this.decoderCounters.ensureUpdated();
            this.eventDispatcher.disabled(this.decoderCounters);
        }
    }

    /* access modifiers changed from: protected */
    public void onEnabled(boolean z4) throws ExoPlaybackException {
        super.onEnabled(z4);
        this.eventDispatcher.enabled(this.decoderCounters);
        int i5 = getConfiguration().tunnelingAudioSessionId;
        if (i5 != 0) {
            this.audioSink.enableTunnelingV21(i5);
        } else {
            this.audioSink.disableTunneling();
        }
    }

    /* access modifiers changed from: protected */
    public void onInputFormatChanged(Format format) throws ExoPlaybackException {
        int i5;
        super.onInputFormatChanged(format);
        this.eventDispatcher.inputFormatChanged(format);
        if (MimeTypes.AUDIO_RAW.equals(format.sampleMimeType)) {
            i5 = format.pcmEncoding;
        } else {
            i5 = 2;
        }
        this.pcmEncoding = i5;
        this.channelCount = format.channelCount;
        this.encoderDelay = format.encoderDelay;
        this.encoderPadding = format.encoderPadding;
    }

    /* access modifiers changed from: protected */
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) throws ExoPlaybackException {
        int i5;
        int[] iArr;
        int i6;
        MediaFormat mediaFormat2 = this.passthroughMediaFormat;
        if (mediaFormat2 != null) {
            i5 = MimeTypes.getEncoding(mediaFormat2.getString("mime"));
            mediaFormat = this.passthroughMediaFormat;
        } else {
            i5 = this.pcmEncoding;
        }
        int i7 = i5;
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (!this.codecNeedsDiscardChannelsWorkaround || integer != 6 || (i6 = this.channelCount) >= 6) {
            iArr = null;
        } else {
            iArr = new int[i6];
            for (int i8 = 0; i8 < this.channelCount; i8++) {
                iArr[i8] = i8;
            }
        }
        try {
            this.audioSink.configure(i7, integer, integer2, 0, iArr, this.encoderDelay, this.encoderPadding);
        } catch (AudioSink.ConfigurationException e5) {
            throw ExoPlaybackException.createForRenderer(e5, getIndex());
        }
    }

    /* access modifiers changed from: protected */
    public void onPositionReset(long j5, boolean z4) throws ExoPlaybackException {
        super.onPositionReset(j5, z4);
        this.audioSink.reset();
        this.currentPositionUs = j5;
        this.allowFirstBufferPositionDiscontinuity = true;
        this.allowPositionDiscontinuity = true;
    }

    /* access modifiers changed from: protected */
    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        if (this.allowFirstBufferPositionDiscontinuity && !decoderInputBuffer.isDecodeOnly()) {
            if (Math.abs(decoderInputBuffer.timeUs - this.currentPositionUs) > 500000) {
                this.currentPositionUs = decoderInputBuffer.timeUs;
            }
            this.allowFirstBufferPositionDiscontinuity = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onStarted() {
        super.onStarted();
        this.audioSink.play();
    }

    /* access modifiers changed from: protected */
    public void onStopped() {
        updateCurrentPosition();
        this.audioSink.pause();
        super.onStopped();
    }

    /* access modifiers changed from: protected */
    public boolean processOutputBuffer(long j5, long j6, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i5, int i6, long j7, boolean z4) throws ExoPlaybackException {
        if (this.passthroughEnabled && (i6 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i5, false);
            return true;
        } else if (z4) {
            mediaCodec.releaseOutputBuffer(i5, false);
            this.decoderCounters.skippedOutputBufferCount++;
            this.audioSink.handleDiscontinuity();
            return true;
        } else {
            try {
                if (!this.audioSink.handleBuffer(byteBuffer, j7)) {
                    return false;
                }
                mediaCodec.releaseOutputBuffer(i5, false);
                this.decoderCounters.renderedOutputBufferCount++;
                return true;
            } catch (AudioSink.InitializationException | AudioSink.WriteException e5) {
                throw ExoPlaybackException.createForRenderer(e5, getIndex());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void renderToEndOfStream() throws ExoPlaybackException {
        try {
            this.audioSink.playToEndOfStream();
        } catch (AudioSink.WriteException e5) {
            throw ExoPlaybackException.createForRenderer(e5, getIndex());
        }
    }

    public PlaybackParameters setPlaybackParameters(PlaybackParameters playbackParameters) {
        return this.audioSink.setPlaybackParameters(playbackParameters);
    }

    /* access modifiers changed from: protected */
    public int supportsFormat(MediaCodecSelector mediaCodecSelector, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, Format format) throws MediaCodecUtil.DecoderQueryException {
        int i5;
        boolean z4;
        int i6;
        int i7;
        int i8;
        String str = format.sampleMimeType;
        if (!MimeTypes.isAudio(str)) {
            return 0;
        }
        if (Util.SDK_INT >= 21) {
            i5 = 32;
        } else {
            i5 = 0;
        }
        boolean supportsFormatDrm = BaseRenderer.supportsFormatDrm(drmSessionManager, format.drmInitData);
        if (supportsFormatDrm && allowPassthrough(str) && mediaCodecSelector.getPassthroughDecoderInfo() != null) {
            return i5 | 12;
        }
        if ((MimeTypes.AUDIO_RAW.equals(str) && !this.audioSink.isEncodingSupported(format.pcmEncoding)) || !this.audioSink.isEncodingSupported(2)) {
            return 1;
        }
        DrmInitData drmInitData = format.drmInitData;
        if (drmInitData != null) {
            z4 = false;
            for (int i9 = 0; i9 < drmInitData.schemeDataCount; i9++) {
                z4 |= drmInitData.get(i9).requiresSecureDecryption;
            }
        } else {
            z4 = false;
        }
        MediaCodecInfo decoderInfo = mediaCodecSelector.getDecoderInfo(str, z4);
        if (decoderInfo == null) {
            if (!z4 || mediaCodecSelector.getDecoderInfo(str, false) == null) {
                return 1;
            }
            return 2;
        } else if (!supportsFormatDrm) {
            return 2;
        } else {
            if (Util.SDK_INT < 21 || (((i7 = format.sampleRate) == -1 || decoderInfo.isAudioSampleRateSupportedV21(i7)) && ((i8 = format.channelCount) == -1 || decoderInfo.isAudioChannelCountSupportedV21(i8)))) {
                i6 = 4;
            } else {
                i6 = 3;
            }
            return i6 | i5 | 8;
        }
    }

    public MediaCodecAudioRenderer(Context context2, MediaCodecSelector mediaCodecSelector, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z4) {
        this(context2, mediaCodecSelector, drmSessionManager, z4, (Handler) null, (AudioRendererEventListener) null);
    }

    private int getCodecMaxInputSize(MediaCodecInfo mediaCodecInfo, Format format) {
        PackageManager packageManager;
        int i5 = Util.SDK_INT;
        if (i5 >= 24 || !"OMX.google.raw.decoder".equals(mediaCodecInfo.name) || (i5 == 23 && (packageManager = this.context.getPackageManager()) != null && packageManager.hasSystemFeature("android.software.leanback"))) {
            return format.maxInputSize;
        }
        return -1;
    }

    public MediaCodecAudioRenderer(Context context2, MediaCodecSelector mediaCodecSelector, @Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener) {
        this(context2, mediaCodecSelector, (DrmSessionManager<FrameworkMediaCrypto>) null, false, handler, audioRendererEventListener);
    }

    public MediaCodecAudioRenderer(Context context2, MediaCodecSelector mediaCodecSelector, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z4, @Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener) {
        this(context2, mediaCodecSelector, drmSessionManager, z4, handler, audioRendererEventListener, (AudioCapabilities) null, new AudioProcessor[0]);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MediaCodecAudioRenderer(android.content.Context r2, com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecSelector r3, @androidx.annotation.Nullable com.mbridge.msdk.playercommon.exoplayer2.drm.DrmSessionManager<com.mbridge.msdk.playercommon.exoplayer2.drm.FrameworkMediaCrypto> r4, boolean r5, @androidx.annotation.Nullable android.os.Handler r6, @androidx.annotation.Nullable com.mbridge.msdk.playercommon.exoplayer2.audio.AudioRendererEventListener r7, @androidx.annotation.Nullable com.mbridge.msdk.playercommon.exoplayer2.audio.AudioCapabilities r8, com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor... r9) {
        /*
            r1 = this;
            r0 = r9
            com.mbridge.msdk.playercommon.exoplayer2.audio.DefaultAudioSink r9 = new com.mbridge.msdk.playercommon.exoplayer2.audio.DefaultAudioSink
            r9.<init>(r8, r0)
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.audio.MediaCodecAudioRenderer.<init>(android.content.Context, com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecSelector, com.mbridge.msdk.playercommon.exoplayer2.drm.DrmSessionManager, boolean, android.os.Handler, com.mbridge.msdk.playercommon.exoplayer2.audio.AudioRendererEventListener, com.mbridge.msdk.playercommon.exoplayer2.audio.AudioCapabilities, com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor[]):void");
    }

    public MediaCodecAudioRenderer(Context context2, MediaCodecSelector mediaCodecSelector, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z4, @Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, AudioSink audioSink2) {
        super(1, mediaCodecSelector, drmSessionManager, z4);
        this.context = context2.getApplicationContext();
        this.audioSink = audioSink2;
        this.eventDispatcher = new AudioRendererEventListener.EventDispatcher(handler, audioRendererEventListener);
        audioSink2.setListener(new AudioSinkListener());
    }
}
