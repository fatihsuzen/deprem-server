package com.mbridge.msdk.playercommon.exoplayer2;

import androidx.annotation.Nullable;

public final class RendererConfiguration {
    public static final RendererConfiguration DEFAULT = new RendererConfiguration(0);
    public final int tunnelingAudioSessionId;

    public RendererConfiguration(int i5) {
        this.tunnelingAudioSessionId = i5;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && RendererConfiguration.class == obj.getClass() && this.tunnelingAudioSessionId == ((RendererConfiguration) obj).tunnelingAudioSessionId) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.tunnelingAudioSessionId;
    }
}
