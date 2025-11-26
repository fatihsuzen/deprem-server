package com.mbridge.msdk.playercommon.exoplayer2.audio;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

final class AudioTimestampPoller {
    private static final int ERROR_POLL_INTERVAL_US = 500000;
    private static final int FAST_POLL_INTERVAL_US = 5000;
    private static final int INITIALIZING_DURATION_US = 500000;
    private static final int SLOW_POLL_INTERVAL_US = 10000000;
    private static final int STATE_ERROR = 4;
    private static final int STATE_INITIALIZING = 0;
    private static final int STATE_NO_TIMESTAMP = 3;
    private static final int STATE_TIMESTAMP = 1;
    private static final int STATE_TIMESTAMP_ADVANCING = 2;
    @Nullable
    private final AudioTimestampV19 audioTimestamp;
    private long initialTimestampPositionFrames;
    private long initializeSystemTimeUs;
    private long lastTimestampSampleTimeUs;
    private long sampleIntervalUs;
    private int state;

    @TargetApi(19)
    private static final class AudioTimestampV19 {
        private final AudioTimestamp audioTimestamp = new AudioTimestamp();
        private final AudioTrack audioTrack;
        private long lastTimestampPositionFrames;
        private long lastTimestampRawPositionFrames;
        private long rawTimestampFramePositionWrapCount;

        public AudioTimestampV19(AudioTrack audioTrack2) {
            this.audioTrack = audioTrack2;
        }

        public final long getTimestampPositionFrames() {
            return this.lastTimestampPositionFrames;
        }

        public final long getTimestampSystemTimeUs() {
            return this.audioTimestamp.nanoTime / 1000;
        }

        public final boolean maybeUpdateTimestamp() {
            boolean timestamp = this.audioTrack.getTimestamp(this.audioTimestamp);
            if (timestamp) {
                long j5 = this.audioTimestamp.framePosition;
                if (this.lastTimestampRawPositionFrames > j5) {
                    this.rawTimestampFramePositionWrapCount++;
                }
                this.lastTimestampRawPositionFrames = j5;
                this.lastTimestampPositionFrames = j5 + (this.rawTimestampFramePositionWrapCount << 32);
            }
            return timestamp;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface State {
    }

    public AudioTimestampPoller(AudioTrack audioTrack) {
        if (Util.SDK_INT >= 19) {
            this.audioTimestamp = new AudioTimestampV19(audioTrack);
            reset();
            return;
        }
        this.audioTimestamp = null;
        updateState(3);
    }

    private void updateState(int i5) {
        this.state = i5;
        if (i5 == 0) {
            this.lastTimestampSampleTimeUs = 0;
            this.initialTimestampPositionFrames = -1;
            this.initializeSystemTimeUs = System.nanoTime() / 1000;
            this.sampleIntervalUs = 5000;
        } else if (i5 == 1) {
            this.sampleIntervalUs = 5000;
        } else if (i5 == 2 || i5 == 3) {
            this.sampleIntervalUs = 10000000;
        } else if (i5 == 4) {
            this.sampleIntervalUs = 500000;
        } else {
            throw new IllegalStateException();
        }
    }

    public final void acceptTimestamp() {
        if (this.state == 4) {
            reset();
        }
    }

    public final long getTimestampPositionFrames() {
        AudioTimestampV19 audioTimestampV19 = this.audioTimestamp;
        if (audioTimestampV19 != null) {
            return audioTimestampV19.getTimestampPositionFrames();
        }
        return -1;
    }

    public final long getTimestampSystemTimeUs() {
        AudioTimestampV19 audioTimestampV19 = this.audioTimestamp;
        if (audioTimestampV19 != null) {
            return audioTimestampV19.getTimestampSystemTimeUs();
        }
        return C.TIME_UNSET;
    }

    public final boolean hasTimestamp() {
        int i5 = this.state;
        if (i5 == 1 || i5 == 2) {
            return true;
        }
        return false;
    }

    public final boolean isTimestampAdvancing() {
        if (this.state == 2) {
            return true;
        }
        return false;
    }

    public final boolean maybePollTimestamp(long j5) {
        AudioTimestampV19 audioTimestampV19 = this.audioTimestamp;
        if (audioTimestampV19 == null || j5 - this.lastTimestampSampleTimeUs < this.sampleIntervalUs) {
            return false;
        }
        this.lastTimestampSampleTimeUs = j5;
        boolean maybeUpdateTimestamp = audioTimestampV19.maybeUpdateTimestamp();
        int i5 = this.state;
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        if (i5 != 4) {
                            throw new IllegalStateException();
                        }
                    } else if (maybeUpdateTimestamp) {
                        reset();
                        return maybeUpdateTimestamp;
                    }
                } else if (!maybeUpdateTimestamp) {
                    reset();
                    return maybeUpdateTimestamp;
                }
            } else if (!maybeUpdateTimestamp) {
                reset();
                return maybeUpdateTimestamp;
            } else if (this.audioTimestamp.getTimestampPositionFrames() > this.initialTimestampPositionFrames) {
                updateState(2);
                return maybeUpdateTimestamp;
            }
        } else if (maybeUpdateTimestamp) {
            if (this.audioTimestamp.getTimestampSystemTimeUs() < this.initializeSystemTimeUs) {
                return false;
            }
            this.initialTimestampPositionFrames = this.audioTimestamp.getTimestampPositionFrames();
            updateState(1);
            return maybeUpdateTimestamp;
        } else if (j5 - this.initializeSystemTimeUs > 500000) {
            updateState(3);
        }
        return maybeUpdateTimestamp;
    }

    public final void rejectTimestamp() {
        updateState(4);
    }

    public final void reset() {
        if (this.audioTimestamp != null) {
            updateState(0);
        }
    }
}
