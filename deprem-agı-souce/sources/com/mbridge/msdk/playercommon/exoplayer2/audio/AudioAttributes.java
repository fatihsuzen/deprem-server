package com.mbridge.msdk.playercommon.exoplayer2.audio;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import androidx.annotation.Nullable;

public final class AudioAttributes {
    public static final AudioAttributes DEFAULT = new Builder().build();
    private android.media.AudioAttributes audioAttributesV21;
    public final int contentType;
    public final int flags;
    public final int usage;

    public static final class Builder {
        private int contentType = 0;
        private int flags = 0;
        private int usage = 1;

        public final AudioAttributes build() {
            return new AudioAttributes(this.contentType, this.flags, this.usage);
        }

        public final Builder setContentType(int i5) {
            this.contentType = i5;
            return this;
        }

        public final Builder setFlags(int i5) {
            this.flags = i5;
            return this;
        }

        public final Builder setUsage(int i5) {
            this.usage = i5;
            return this;
        }
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && AudioAttributes.class == obj.getClass()) {
            AudioAttributes audioAttributes = (AudioAttributes) obj;
            if (this.contentType == audioAttributes.contentType && this.flags == audioAttributes.flags && this.usage == audioAttributes.usage) {
                return true;
            }
            return false;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    @TargetApi(21)
    public final android.media.AudioAttributes getAudioAttributesV21() {
        if (this.audioAttributesV21 == null) {
            this.audioAttributesV21 = new AudioAttributes.Builder().setContentType(this.contentType).setFlags(this.flags).setUsage(this.usage).build();
        }
        return this.audioAttributesV21;
    }

    public final int hashCode() {
        return ((((527 + this.contentType) * 31) + this.flags) * 31) + this.usage;
    }

    private AudioAttributes(int i5, int i6, int i7) {
        this.contentType = i5;
        this.flags = i6;
        this.usage = i7;
    }
}
