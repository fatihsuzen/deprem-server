package com.mbridge.msdk.playercommon.exoplayer2;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderInputBuffer;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmSessionManager;
import com.mbridge.msdk.playercommon.exoplayer2.source.SampleStream;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.MediaClock;
import java.io.IOException;

public abstract class BaseRenderer implements Renderer, RendererCapabilities {
    private RendererConfiguration configuration;
    private int index;
    private boolean readEndOfStream = true;
    private int state;
    private SampleStream stream;
    private Format[] streamFormats;
    private boolean streamIsFinal;
    private long streamOffsetUs;
    private final int trackType;

    public BaseRenderer(int i5) {
        this.trackType = i5;
    }

    protected static boolean supportsFormatDrm(@Nullable DrmSessionManager<?> drmSessionManager, @Nullable DrmInitData drmInitData) {
        if (drmInitData == null) {
            return true;
        }
        if (drmSessionManager == null) {
            return false;
        }
        return drmSessionManager.canAcquireSession(drmInitData);
    }

    public final void disable() {
        boolean z4 = true;
        if (this.state != 1) {
            z4 = false;
        }
        Assertions.checkState(z4);
        this.state = 0;
        this.stream = null;
        this.streamFormats = null;
        this.streamIsFinal = false;
        onDisabled();
    }

    public final void enable(RendererConfiguration rendererConfiguration, Format[] formatArr, SampleStream sampleStream, long j5, boolean z4, long j6) throws ExoPlaybackException {
        boolean z5;
        if (this.state == 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        Assertions.checkState(z5);
        this.configuration = rendererConfiguration;
        this.state = 1;
        onEnabled(z4);
        replaceStream(formatArr, sampleStream, j6);
        onPositionReset(j5, z4);
    }

    public final RendererCapabilities getCapabilities() {
        return this;
    }

    /* access modifiers changed from: protected */
    public final RendererConfiguration getConfiguration() {
        return this.configuration;
    }

    /* access modifiers changed from: protected */
    public final int getIndex() {
        return this.index;
    }

    public MediaClock getMediaClock() {
        return null;
    }

    public final int getState() {
        return this.state;
    }

    public final SampleStream getStream() {
        return this.stream;
    }

    /* access modifiers changed from: protected */
    public final Format[] getStreamFormats() {
        return this.streamFormats;
    }

    public final int getTrackType() {
        return this.trackType;
    }

    public void handleMessage(int i5, Object obj) throws ExoPlaybackException {
    }

    public final boolean hasReadStreamToEnd() {
        return this.readEndOfStream;
    }

    public final boolean isCurrentStreamFinal() {
        return this.streamIsFinal;
    }

    /* access modifiers changed from: protected */
    public final boolean isSourceReady() {
        if (this.readEndOfStream) {
            return this.streamIsFinal;
        }
        return this.stream.isReady();
    }

    public final void maybeThrowStreamError() throws IOException {
        this.stream.maybeThrowError();
    }

    /* access modifiers changed from: protected */
    public void onDisabled() {
    }

    /* access modifiers changed from: protected */
    public void onEnabled(boolean z4) throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public void onPositionReset(long j5, boolean z4) throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public void onStarted() throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public void onStopped() throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public void onStreamChanged(Format[] formatArr, long j5) throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public final int readSource(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z4) {
        int readData = this.stream.readData(formatHolder, decoderInputBuffer, z4);
        if (readData != -4) {
            if (readData == -5) {
                Format format = formatHolder.format;
                long j5 = format.subsampleOffsetUs;
                if (j5 != Long.MAX_VALUE) {
                    formatHolder.format = format.copyWithSubsampleOffsetUs(j5 + this.streamOffsetUs);
                }
            }
            return readData;
        } else if (decoderInputBuffer.isEndOfStream()) {
            this.readEndOfStream = true;
            if (this.streamIsFinal) {
                return -4;
            }
            return -3;
        } else {
            decoderInputBuffer.timeUs += this.streamOffsetUs;
            return readData;
        }
    }

    public final void replaceStream(Format[] formatArr, SampleStream sampleStream, long j5) throws ExoPlaybackException {
        Assertions.checkState(!this.streamIsFinal);
        this.stream = sampleStream;
        this.readEndOfStream = false;
        this.streamFormats = formatArr;
        this.streamOffsetUs = j5;
        onStreamChanged(formatArr, j5);
    }

    public final void resetPosition(long j5) throws ExoPlaybackException {
        this.streamIsFinal = false;
        this.readEndOfStream = false;
        onPositionReset(j5, false);
    }

    public final void setCurrentStreamFinal() {
        this.streamIsFinal = true;
    }

    public final void setIndex(int i5) {
        this.index = i5;
    }

    /* access modifiers changed from: protected */
    public int skipSource(long j5) {
        return this.stream.skipData(j5 - this.streamOffsetUs);
    }

    public final void start() throws ExoPlaybackException {
        boolean z4 = true;
        if (this.state != 1) {
            z4 = false;
        }
        Assertions.checkState(z4);
        this.state = 2;
        onStarted();
    }

    public final void stop() throws ExoPlaybackException {
        boolean z4;
        if (this.state == 2) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkState(z4);
        this.state = 1;
        onStopped();
    }

    public int supportsMixedMimeTypeAdaptation() throws ExoPlaybackException {
        return 0;
    }
}
