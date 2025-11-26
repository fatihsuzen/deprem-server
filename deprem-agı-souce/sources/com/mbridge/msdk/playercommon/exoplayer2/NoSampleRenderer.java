package com.mbridge.msdk.playercommon.exoplayer2;

import com.mbridge.msdk.playercommon.exoplayer2.source.SampleStream;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.MediaClock;
import java.io.IOException;

public abstract class NoSampleRenderer implements Renderer, RendererCapabilities {
    private RendererConfiguration configuration;
    private int index;
    private int state;
    private SampleStream stream;
    private boolean streamIsFinal;

    public final void disable() {
        boolean z4 = true;
        if (this.state != 1) {
            z4 = false;
        }
        Assertions.checkState(z4);
        this.state = 0;
        this.stream = null;
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

    public final int getTrackType() {
        return 5;
    }

    public void handleMessage(int i5, Object obj) throws ExoPlaybackException {
    }

    public final boolean hasReadStreamToEnd() {
        return true;
    }

    public final boolean isCurrentStreamFinal() {
        return this.streamIsFinal;
    }

    public boolean isEnded() {
        return true;
    }

    public boolean isReady() {
        return true;
    }

    public final void maybeThrowStreamError() throws IOException {
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
    public void onRendererOffsetChanged(long j5) throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public void onStarted() throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public void onStopped() throws ExoPlaybackException {
    }

    public final void replaceStream(Format[] formatArr, SampleStream sampleStream, long j5) throws ExoPlaybackException {
        Assertions.checkState(!this.streamIsFinal);
        this.stream = sampleStream;
        onRendererOffsetChanged(j5);
    }

    public final void resetPosition(long j5) throws ExoPlaybackException {
        this.streamIsFinal = false;
        onPositionReset(j5, false);
    }

    public final void setCurrentStreamFinal() {
        this.streamIsFinal = true;
    }

    public final void setIndex(int i5) {
        this.index = i5;
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

    public int supportsFormat(Format format) throws ExoPlaybackException {
        return 0;
    }

    public int supportsMixedMimeTypeAdaptation() throws ExoPlaybackException {
        return 0;
    }
}
