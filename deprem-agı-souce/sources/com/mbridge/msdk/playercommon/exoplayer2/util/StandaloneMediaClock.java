package com.mbridge.msdk.playercommon.exoplayer2.util;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.PlaybackParameters;

public final class StandaloneMediaClock implements MediaClock {
    private long baseElapsedMs;
    private long baseUs;
    private final Clock clock;
    private PlaybackParameters playbackParameters = PlaybackParameters.DEFAULT;
    private boolean started;

    public StandaloneMediaClock(Clock clock2) {
        this.clock = clock2;
    }

    public final PlaybackParameters getPlaybackParameters() {
        return this.playbackParameters;
    }

    public final long getPositionUs() {
        long mediaTimeUsForPlayoutTimeMs;
        long j5 = this.baseUs;
        if (!this.started) {
            return j5;
        }
        long elapsedRealtime = this.clock.elapsedRealtime() - this.baseElapsedMs;
        PlaybackParameters playbackParameters2 = this.playbackParameters;
        if (playbackParameters2.speed == 1.0f) {
            mediaTimeUsForPlayoutTimeMs = C.msToUs(elapsedRealtime);
        } else {
            mediaTimeUsForPlayoutTimeMs = playbackParameters2.getMediaTimeUsForPlayoutTimeMs(elapsedRealtime);
        }
        return j5 + mediaTimeUsForPlayoutTimeMs;
    }

    public final void resetPosition(long j5) {
        this.baseUs = j5;
        if (this.started) {
            this.baseElapsedMs = this.clock.elapsedRealtime();
        }
    }

    public final PlaybackParameters setPlaybackParameters(PlaybackParameters playbackParameters2) {
        if (this.started) {
            resetPosition(getPositionUs());
        }
        this.playbackParameters = playbackParameters2;
        return playbackParameters2;
    }

    public final void start() {
        if (!this.started) {
            this.baseElapsedMs = this.clock.elapsedRealtime();
            this.started = true;
        }
    }

    public final void stop() {
        if (this.started) {
            resetPosition(getPositionUs());
            this.started = false;
        }
    }
}
