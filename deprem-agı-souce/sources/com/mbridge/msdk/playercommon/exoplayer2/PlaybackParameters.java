package com.mbridge.msdk.playercommon.exoplayer2;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;

public final class PlaybackParameters {
    public static final PlaybackParameters DEFAULT = new PlaybackParameters(1.0f);
    public final float pitch;
    private final int scaledUsPerMs;
    public final boolean skipSilence;
    public final float speed;

    public PlaybackParameters(float f5) {
        this(f5, 1.0f, false);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && PlaybackParameters.class == obj.getClass()) {
            PlaybackParameters playbackParameters = (PlaybackParameters) obj;
            if (this.speed == playbackParameters.speed && this.pitch == playbackParameters.pitch && this.skipSilence == playbackParameters.skipSilence) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final long getMediaTimeUsForPlayoutTimeMs(long j5) {
        return j5 * ((long) this.scaledUsPerMs);
    }

    public final int hashCode() {
        return ((((527 + Float.floatToRawIntBits(this.speed)) * 31) + Float.floatToRawIntBits(this.pitch)) * 31) + (this.skipSilence ? 1 : 0);
    }

    public PlaybackParameters(float f5, float f6) {
        this(f5, f6, false);
    }

    public PlaybackParameters(float f5, float f6, boolean z4) {
        boolean z5 = false;
        Assertions.checkArgument(f5 > 0.0f);
        Assertions.checkArgument(f6 > 0.0f ? true : z5);
        this.speed = f5;
        this.pitch = f6;
        this.skipSilence = z4;
        this.scaledUsPerMs = Math.round(f5 * 1000.0f);
    }
}
