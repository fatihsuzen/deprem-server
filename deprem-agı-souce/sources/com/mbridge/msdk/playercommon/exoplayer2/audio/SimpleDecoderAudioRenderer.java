package com.mbridge.msdk.playercommon.exoplayer2.audio;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.mbridge.msdk.playercommon.exoplayer2.BaseRenderer;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlaybackException;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.FormatHolder;
import com.mbridge.msdk.playercommon.exoplayer2.PlaybackParameters;
import com.mbridge.msdk.playercommon.exoplayer2.audio.AudioRendererEventListener;
import com.mbridge.msdk.playercommon.exoplayer2.audio.AudioSink;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderCounters;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderInputBuffer;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.SimpleDecoder;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.SimpleOutputBuffer;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmSession;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmSessionManager;
import com.mbridge.msdk.playercommon.exoplayer2.drm.ExoMediaCrypto;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.MediaClock;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.TraceUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public abstract class SimpleDecoderAudioRenderer extends BaseRenderer implements MediaClock {
    private static final int REINITIALIZATION_STATE_NONE = 0;
    private static final int REINITIALIZATION_STATE_SIGNAL_END_OF_STREAM = 1;
    private static final int REINITIALIZATION_STATE_WAIT_END_OF_STREAM = 2;
    private boolean allowFirstBufferPositionDiscontinuity;
    /* access modifiers changed from: private */
    public boolean allowPositionDiscontinuity;
    private final AudioSink audioSink;
    private boolean audioTrackNeedsConfigure;
    private long currentPositionUs;
    private SimpleDecoder<DecoderInputBuffer, ? extends SimpleOutputBuffer, ? extends AudioDecoderException> decoder;
    private DecoderCounters decoderCounters;
    private boolean decoderReceivedBuffers;
    private int decoderReinitializationState;
    private DrmSession<ExoMediaCrypto> drmSession;
    private final DrmSessionManager<ExoMediaCrypto> drmSessionManager;
    private int encoderDelay;
    private int encoderPadding;
    /* access modifiers changed from: private */
    public final AudioRendererEventListener.EventDispatcher eventDispatcher;
    private final DecoderInputBuffer flagsOnlyBuffer;
    private final FormatHolder formatHolder;
    private DecoderInputBuffer inputBuffer;
    private Format inputFormat;
    private boolean inputStreamEnded;
    private SimpleOutputBuffer outputBuffer;
    private boolean outputStreamEnded;
    private DrmSession<ExoMediaCrypto> pendingDrmSession;
    private final boolean playClearSamplesWithoutKeys;
    private boolean waitingForKeys;

    private final class AudioSinkListener implements AudioSink.Listener {
        private AudioSinkListener() {
        }

        public final void onAudioSessionId(int i5) {
            SimpleDecoderAudioRenderer.this.eventDispatcher.audioSessionId(i5);
            SimpleDecoderAudioRenderer.this.onAudioSessionId(i5);
        }

        public final void onPositionDiscontinuity() {
            SimpleDecoderAudioRenderer.this.onAudioTrackPositionDiscontinuity();
            boolean unused = SimpleDecoderAudioRenderer.this.allowPositionDiscontinuity = true;
        }

        public final void onUnderrun(int i5, long j5, long j6) {
            int i6 = i5;
            long j7 = j5;
            long j8 = j6;
            SimpleDecoderAudioRenderer.this.eventDispatcher.audioTrackUnderrun(i6, j7, j8);
            long j9 = j7;
            int i7 = i6;
            SimpleDecoderAudioRenderer.this.onAudioTrackUnderrun(i7, j9, j8);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface ReinitializationState {
    }

    public SimpleDecoderAudioRenderer() {
        this((Handler) null, (AudioRendererEventListener) null, new AudioProcessor[0]);
    }

    private boolean drainOutputBuffer() throws ExoPlaybackException, AudioDecoderException, AudioSink.ConfigurationException, AudioSink.InitializationException, AudioSink.WriteException {
        if (this.outputBuffer == null) {
            SimpleOutputBuffer simpleOutputBuffer = (SimpleOutputBuffer) this.decoder.dequeueOutputBuffer();
            this.outputBuffer = simpleOutputBuffer;
            if (simpleOutputBuffer == null) {
                return false;
            }
            this.decoderCounters.skippedOutputBufferCount += simpleOutputBuffer.skippedOutputBufferCount;
        }
        if (this.outputBuffer.isEndOfStream()) {
            if (this.decoderReinitializationState == 2) {
                releaseDecoder();
                maybeInitDecoder();
                this.audioTrackNeedsConfigure = true;
            } else {
                this.outputBuffer.release();
                this.outputBuffer = null;
                processEndOfStream();
            }
            return false;
        }
        if (this.audioTrackNeedsConfigure) {
            Format outputFormat = getOutputFormat();
            this.audioSink.configure(outputFormat.pcmEncoding, outputFormat.channelCount, outputFormat.sampleRate, 0, (int[]) null, this.encoderDelay, this.encoderPadding);
            this.audioTrackNeedsConfigure = false;
        }
        AudioSink audioSink2 = this.audioSink;
        SimpleOutputBuffer simpleOutputBuffer2 = this.outputBuffer;
        if (!audioSink2.handleBuffer(simpleOutputBuffer2.data, simpleOutputBuffer2.timeUs)) {
            return false;
        }
        this.decoderCounters.renderedOutputBufferCount++;
        this.outputBuffer.release();
        this.outputBuffer = null;
        return true;
    }

    private boolean feedInputBuffer() throws AudioDecoderException, ExoPlaybackException {
        int i5;
        SimpleDecoder<DecoderInputBuffer, ? extends SimpleOutputBuffer, ? extends AudioDecoderException> simpleDecoder = this.decoder;
        if (simpleDecoder == null || this.decoderReinitializationState == 2 || this.inputStreamEnded) {
            return false;
        }
        if (this.inputBuffer == null) {
            DecoderInputBuffer dequeueInputBuffer = simpleDecoder.dequeueInputBuffer();
            this.inputBuffer = dequeueInputBuffer;
            if (dequeueInputBuffer == null) {
                return false;
            }
        }
        if (this.decoderReinitializationState == 1) {
            this.inputBuffer.setFlags(4);
            this.decoder.queueInputBuffer(this.inputBuffer);
            this.inputBuffer = null;
            this.decoderReinitializationState = 2;
            return false;
        }
        if (this.waitingForKeys) {
            i5 = -4;
        } else {
            i5 = readSource(this.formatHolder, this.inputBuffer, false);
        }
        if (i5 == -3) {
            return false;
        }
        if (i5 == -5) {
            onInputFormatChanged(this.formatHolder.format);
            return true;
        } else if (this.inputBuffer.isEndOfStream()) {
            this.inputStreamEnded = true;
            this.decoder.queueInputBuffer(this.inputBuffer);
            this.inputBuffer = null;
            return false;
        } else {
            boolean shouldWaitForKeys = shouldWaitForKeys(this.inputBuffer.isEncrypted());
            this.waitingForKeys = shouldWaitForKeys;
            if (shouldWaitForKeys) {
                return false;
            }
            this.inputBuffer.flip();
            onQueueInputBuffer(this.inputBuffer);
            this.decoder.queueInputBuffer(this.inputBuffer);
            this.decoderReceivedBuffers = true;
            this.decoderCounters.inputBufferCount++;
            this.inputBuffer = null;
            return true;
        }
    }

    private void flushDecoder() throws ExoPlaybackException {
        this.waitingForKeys = false;
        if (this.decoderReinitializationState != 0) {
            releaseDecoder();
            maybeInitDecoder();
            return;
        }
        this.inputBuffer = null;
        SimpleOutputBuffer simpleOutputBuffer = this.outputBuffer;
        if (simpleOutputBuffer != null) {
            simpleOutputBuffer.release();
            this.outputBuffer = null;
        }
        this.decoder.flush();
        this.decoderReceivedBuffers = false;
    }

    private void maybeInitDecoder() throws ExoPlaybackException {
        ExoMediaCrypto exoMediaCrypto;
        if (this.decoder == null) {
            DrmSession<ExoMediaCrypto> drmSession2 = this.pendingDrmSession;
            this.drmSession = drmSession2;
            if (drmSession2 != null) {
                exoMediaCrypto = drmSession2.getMediaCrypto();
                if (exoMediaCrypto == null && this.drmSession.getError() == null) {
                    return;
                }
            } else {
                exoMediaCrypto = null;
            }
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                TraceUtil.beginSection("createAudioDecoder");
                this.decoder = createDecoder(this.inputFormat, exoMediaCrypto);
                TraceUtil.endSection();
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                this.eventDispatcher.decoderInitialized(this.decoder.getName(), elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                this.decoderCounters.decoderInitCount++;
            } catch (AudioDecoderException e5) {
                throw ExoPlaybackException.createForRenderer(e5, getIndex());
            }
        }
    }

    private void onInputFormatChanged(Format format) throws ExoPlaybackException {
        DrmInitData drmInitData;
        Format format2 = this.inputFormat;
        this.inputFormat = format;
        DrmInitData drmInitData2 = format.drmInitData;
        if (format2 == null) {
            drmInitData = null;
        } else {
            drmInitData = format2.drmInitData;
        }
        if (!Util.areEqual(drmInitData2, drmInitData)) {
            if (this.inputFormat.drmInitData != null) {
                DrmSessionManager<ExoMediaCrypto> drmSessionManager2 = this.drmSessionManager;
                if (drmSessionManager2 != null) {
                    DrmSession<ExoMediaCrypto> acquireSession = drmSessionManager2.acquireSession(Looper.myLooper(), this.inputFormat.drmInitData);
                    this.pendingDrmSession = acquireSession;
                    if (acquireSession == this.drmSession) {
                        this.drmSessionManager.releaseSession(acquireSession);
                    }
                } else {
                    throw ExoPlaybackException.createForRenderer(new IllegalStateException("Media requires a DrmSessionManager"), getIndex());
                }
            } else {
                this.pendingDrmSession = null;
            }
        }
        if (this.decoderReceivedBuffers) {
            this.decoderReinitializationState = 1;
        } else {
            releaseDecoder();
            maybeInitDecoder();
            this.audioTrackNeedsConfigure = true;
        }
        this.encoderDelay = format.encoderDelay;
        this.encoderPadding = format.encoderPadding;
        this.eventDispatcher.inputFormatChanged(format);
    }

    private void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        if (this.allowFirstBufferPositionDiscontinuity && !decoderInputBuffer.isDecodeOnly()) {
            if (Math.abs(decoderInputBuffer.timeUs - this.currentPositionUs) > 500000) {
                this.currentPositionUs = decoderInputBuffer.timeUs;
            }
            this.allowFirstBufferPositionDiscontinuity = false;
        }
    }

    private void processEndOfStream() throws ExoPlaybackException {
        this.outputStreamEnded = true;
        try {
            this.audioSink.playToEndOfStream();
        } catch (AudioSink.WriteException e5) {
            throw ExoPlaybackException.createForRenderer(e5, getIndex());
        }
    }

    private void releaseDecoder() {
        SimpleDecoder<DecoderInputBuffer, ? extends SimpleOutputBuffer, ? extends AudioDecoderException> simpleDecoder = this.decoder;
        if (simpleDecoder != null) {
            this.inputBuffer = null;
            this.outputBuffer = null;
            simpleDecoder.release();
            this.decoder = null;
            this.decoderCounters.decoderReleaseCount++;
            this.decoderReinitializationState = 0;
            this.decoderReceivedBuffers = false;
        }
    }

    private boolean shouldWaitForKeys(boolean z4) throws ExoPlaybackException {
        DrmSession<ExoMediaCrypto> drmSession2 = this.drmSession;
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
    public abstract SimpleDecoder<DecoderInputBuffer, ? extends SimpleOutputBuffer, ? extends AudioDecoderException> createDecoder(Format format, ExoMediaCrypto exoMediaCrypto) throws AudioDecoderException;

    public MediaClock getMediaClock() {
        return this;
    }

    /* access modifiers changed from: protected */
    public Format getOutputFormat() {
        Format format = this.inputFormat;
        return Format.createAudioSampleFormat((String) null, MimeTypes.AUDIO_RAW, (String) null, -1, -1, format.channelCount, format.sampleRate, 2, (List<byte[]>) null, (DrmInitData) null, 0, (String) null);
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
        if (!this.outputStreamEnded || !this.audioSink.isEnded()) {
            return false;
        }
        return true;
    }

    public boolean isReady() {
        if (this.audioSink.hasPendingData()) {
            return true;
        }
        if (this.inputFormat == null || this.waitingForKeys) {
            return false;
        }
        if (isSourceReady() || this.outputBuffer != null) {
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
    public void onDisabled() {
        this.inputFormat = null;
        this.audioTrackNeedsConfigure = true;
        this.waitingForKeys = false;
        try {
            releaseDecoder();
            this.audioSink.release();
            try {
                DrmSession<ExoMediaCrypto> drmSession2 = this.drmSession;
                if (drmSession2 != null) {
                    this.drmSessionManager.releaseSession(drmSession2);
                }
                try {
                    DrmSession<ExoMediaCrypto> drmSession3 = this.pendingDrmSession;
                    if (!(drmSession3 == null || drmSession3 == this.drmSession)) {
                        this.drmSessionManager.releaseSession(drmSession3);
                    }
                } finally {
                    this.drmSession = null;
                    this.pendingDrmSession = null;
                    this.decoderCounters.ensureUpdated();
                    this.eventDispatcher.disabled(this.decoderCounters);
                }
            } catch (Throwable th) {
                DrmSession<ExoMediaCrypto> drmSession4 = this.pendingDrmSession;
                if (!(drmSession4 == null || drmSession4 == this.drmSession)) {
                    this.drmSessionManager.releaseSession(drmSession4);
                }
                throw th;
            } finally {
                this.drmSession = null;
                this.pendingDrmSession = null;
                this.decoderCounters.ensureUpdated();
                this.eventDispatcher.disabled(this.decoderCounters);
            }
        } catch (Throwable th2) {
            try {
                DrmSession<ExoMediaCrypto> drmSession5 = this.pendingDrmSession;
                if (!(drmSession5 == null || drmSession5 == this.drmSession)) {
                    this.drmSessionManager.releaseSession(drmSession5);
                }
                throw th2;
            } finally {
                this.drmSession = null;
                this.pendingDrmSession = null;
                this.decoderCounters.ensureUpdated();
                this.eventDispatcher.disabled(this.decoderCounters);
            }
        } finally {
        }
    }

    /* access modifiers changed from: protected */
    public void onEnabled(boolean z4) throws ExoPlaybackException {
        DecoderCounters decoderCounters2 = new DecoderCounters();
        this.decoderCounters = decoderCounters2;
        this.eventDispatcher.enabled(decoderCounters2);
        int i5 = getConfiguration().tunnelingAudioSessionId;
        if (i5 != 0) {
            this.audioSink.enableTunnelingV21(i5);
        } else {
            this.audioSink.disableTunneling();
        }
    }

    /* access modifiers changed from: protected */
    public void onPositionReset(long j5, boolean z4) throws ExoPlaybackException {
        this.audioSink.reset();
        this.currentPositionUs = j5;
        this.allowFirstBufferPositionDiscontinuity = true;
        this.allowPositionDiscontinuity = true;
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        if (this.decoder != null) {
            flushDecoder();
        }
    }

    /* access modifiers changed from: protected */
    public void onStarted() {
        this.audioSink.play();
    }

    /* access modifiers changed from: protected */
    public void onStopped() {
        updateCurrentPosition();
        this.audioSink.pause();
    }

    public void render(long j5, long j6) throws ExoPlaybackException {
        if (this.outputStreamEnded) {
            try {
                this.audioSink.playToEndOfStream();
            } catch (AudioSink.WriteException e5) {
                throw ExoPlaybackException.createForRenderer(e5, getIndex());
            }
        } else {
            if (this.inputFormat == null) {
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
            maybeInitDecoder();
            if (this.decoder != null) {
                try {
                    TraceUtil.beginSection("drainAndFeed");
                    while (drainOutputBuffer()) {
                    }
                    while (feedInputBuffer()) {
                    }
                    TraceUtil.endSection();
                    this.decoderCounters.ensureUpdated();
                } catch (AudioDecoderException | AudioSink.ConfigurationException | AudioSink.InitializationException | AudioSink.WriteException e6) {
                    throw ExoPlaybackException.createForRenderer(e6, getIndex());
                }
            }
        }
    }

    public PlaybackParameters setPlaybackParameters(PlaybackParameters playbackParameters) {
        return this.audioSink.setPlaybackParameters(playbackParameters);
    }

    public final int supportsFormat(Format format) {
        int i5;
        int supportsFormatInternal = supportsFormatInternal(this.drmSessionManager, format);
        if (supportsFormatInternal <= 2) {
            return supportsFormatInternal;
        }
        if (Util.SDK_INT >= 21) {
            i5 = 32;
        } else {
            i5 = 0;
        }
        return supportsFormatInternal | i5 | 8;
    }

    /* access modifiers changed from: protected */
    public abstract int supportsFormatInternal(DrmSessionManager<ExoMediaCrypto> drmSessionManager2, Format format);

    /* access modifiers changed from: protected */
    public final boolean supportsOutputEncoding(int i5) {
        return this.audioSink.isEncodingSupported(i5);
    }

    public SimpleDecoderAudioRenderer(Handler handler, AudioRendererEventListener audioRendererEventListener, AudioProcessor... audioProcessorArr) {
        this(handler, audioRendererEventListener, (AudioCapabilities) null, (DrmSessionManager<ExoMediaCrypto>) null, false, audioProcessorArr);
    }

    public SimpleDecoderAudioRenderer(Handler handler, AudioRendererEventListener audioRendererEventListener, AudioCapabilities audioCapabilities) {
        this(handler, audioRendererEventListener, audioCapabilities, (DrmSessionManager<ExoMediaCrypto>) null, false, new AudioProcessor[0]);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SimpleDecoderAudioRenderer(android.os.Handler r2, com.mbridge.msdk.playercommon.exoplayer2.audio.AudioRendererEventListener r3, com.mbridge.msdk.playercommon.exoplayer2.audio.AudioCapabilities r4, com.mbridge.msdk.playercommon.exoplayer2.drm.DrmSessionManager<com.mbridge.msdk.playercommon.exoplayer2.drm.ExoMediaCrypto> r5, boolean r6, com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor... r7) {
        /*
            r1 = this;
            r0 = r7
            com.mbridge.msdk.playercommon.exoplayer2.audio.DefaultAudioSink r7 = new com.mbridge.msdk.playercommon.exoplayer2.audio.DefaultAudioSink
            r7.<init>(r4, r0)
            r4 = r3
            r3 = r2
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.audio.SimpleDecoderAudioRenderer.<init>(android.os.Handler, com.mbridge.msdk.playercommon.exoplayer2.audio.AudioRendererEventListener, com.mbridge.msdk.playercommon.exoplayer2.audio.AudioCapabilities, com.mbridge.msdk.playercommon.exoplayer2.drm.DrmSessionManager, boolean, com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor[]):void");
    }

    public SimpleDecoderAudioRenderer(Handler handler, AudioRendererEventListener audioRendererEventListener, DrmSessionManager<ExoMediaCrypto> drmSessionManager2, boolean z4, AudioSink audioSink2) {
        super(1);
        this.drmSessionManager = drmSessionManager2;
        this.playClearSamplesWithoutKeys = z4;
        this.eventDispatcher = new AudioRendererEventListener.EventDispatcher(handler, audioRendererEventListener);
        this.audioSink = audioSink2;
        audioSink2.setListener(new AudioSinkListener());
        this.formatHolder = new FormatHolder();
        this.flagsOnlyBuffer = DecoderInputBuffer.newFlagsOnlyInstance();
        this.decoderReinitializationState = 0;
        this.audioTrackNeedsConfigure = true;
    }
}
