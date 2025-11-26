package com.mbridge.msdk.playercommon.exoplayer2.audio;

import android.media.AudioTrack;
import android.os.SystemClock;
import androidx.work.WorkRequest;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

final class AudioTrackPositionTracker {
    private static final long FORCE_RESET_WORKAROUND_TIMEOUT_MS = 200;
    private static final long MAX_AUDIO_TIMESTAMP_OFFSET_US = 5000000;
    private static final long MAX_LATENCY_US = 5000000;
    private static final int MAX_PLAYHEAD_OFFSET_COUNT = 10;
    private static final int MIN_LATENCY_SAMPLE_INTERVAL_US = 500000;
    private static final int MIN_PLAYHEAD_OFFSET_SAMPLE_INTERVAL_US = 30000;
    private static final int PLAYSTATE_PAUSED = 2;
    private static final int PLAYSTATE_PLAYING = 3;
    private static final int PLAYSTATE_STOPPED = 1;
    private AudioTimestampPoller audioTimestampPoller;
    private AudioTrack audioTrack;
    private int bufferSize;
    private long bufferSizeUs;
    private long endPlaybackHeadPosition;
    private long forceResetWorkaroundTimeMs;
    private Method getLatencyMethod;
    private boolean hasData;
    private boolean isOutputPcm;
    private long lastLatencySampleTimeUs;
    private long lastPlayheadSampleTimeUs;
    private long lastRawPlaybackHeadPosition;
    private long latencyUs;
    private final Listener listener;
    private boolean needsPassthroughWorkarounds;
    private int nextPlayheadOffsetIndex;
    private int outputPcmFrameSize;
    private int outputSampleRate;
    private long passthroughWorkaroundPauseOffset;
    private int playheadOffsetCount;
    private final long[] playheadOffsets;
    private long rawPlaybackHeadWrapCount;
    private long smoothedPlayheadOffsetUs;
    private long stopPlaybackHeadPosition;
    private long stopTimestampUs;

    public interface Listener {
        void onInvalidLatency(long j5);

        void onPositionFramesMismatch(long j5, long j6, long j7, long j8);

        void onSystemTimeUsMismatch(long j5, long j6, long j7, long j8);

        void onUnderrun(int i5, long j5);
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface PlayState {
    }

    public AudioTrackPositionTracker(Listener listener2) {
        this.listener = (Listener) Assertions.checkNotNull(listener2);
        if (Util.SDK_INT >= 18) {
            try {
                this.getLatencyMethod = AudioTrack.class.getMethod("getLatency", (Class[]) null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.playheadOffsets = new long[10];
    }

    private boolean forceHasPendingData() {
        if (this.needsPassthroughWorkarounds && this.audioTrack.getPlayState() == 2 && getPlaybackHeadPosition() == 0) {
            return true;
        }
        return false;
    }

    private long framesToDurationUs(long j5) {
        return (j5 * 1000000) / ((long) this.outputSampleRate);
    }

    private long getPlaybackHeadPosition() {
        if (this.stopTimestampUs != C.TIME_UNSET) {
            return Math.min(this.endPlaybackHeadPosition, this.stopPlaybackHeadPosition + ((((SystemClock.elapsedRealtime() * 1000) - this.stopTimestampUs) * ((long) this.outputSampleRate)) / 1000000));
        }
        int playState = this.audioTrack.getPlayState();
        if (playState == 1) {
            return 0;
        }
        long playbackHeadPosition = ((long) this.audioTrack.getPlaybackHeadPosition()) & 4294967295L;
        if (this.needsPassthroughWorkarounds) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.passthroughWorkaroundPauseOffset = this.lastRawPlaybackHeadPosition;
            }
            playbackHeadPosition += this.passthroughWorkaroundPauseOffset;
        }
        if (Util.SDK_INT <= 28) {
            if (playbackHeadPosition == 0 && this.lastRawPlaybackHeadPosition > 0 && playState == 3) {
                if (this.forceResetWorkaroundTimeMs == C.TIME_UNSET) {
                    this.forceResetWorkaroundTimeMs = SystemClock.elapsedRealtime();
                }
                return this.lastRawPlaybackHeadPosition;
            }
            this.forceResetWorkaroundTimeMs = C.TIME_UNSET;
        }
        if (this.lastRawPlaybackHeadPosition > playbackHeadPosition) {
            this.rawPlaybackHeadWrapCount++;
        }
        this.lastRawPlaybackHeadPosition = playbackHeadPosition;
        return playbackHeadPosition + (this.rawPlaybackHeadWrapCount << 32);
    }

    private long getPlaybackHeadPositionUs() {
        return framesToDurationUs(getPlaybackHeadPosition());
    }

    private void maybePollAndCheckTimestamp(long j5, long j6) {
        if (this.audioTimestampPoller.maybePollTimestamp(j5)) {
            long timestampSystemTimeUs = this.audioTimestampPoller.getTimestampSystemTimeUs();
            long timestampPositionFrames = this.audioTimestampPoller.getTimestampPositionFrames();
            if (Math.abs(timestampSystemTimeUs - j5) > 5000000) {
                this.listener.onSystemTimeUsMismatch(timestampPositionFrames, timestampSystemTimeUs, j5, j6);
                this.audioTimestampPoller.rejectTimestamp();
                return;
            }
            long j7 = j5;
            long j8 = j6;
            if (Math.abs(framesToDurationUs(timestampPositionFrames) - j8) > 5000000) {
                this.listener.onPositionFramesMismatch(timestampPositionFrames, timestampSystemTimeUs, j7, j8);
                this.audioTimestampPoller.rejectTimestamp();
                return;
            }
            this.audioTimestampPoller.acceptTimestamp();
        }
    }

    private void maybeSampleSyncParams() {
        long playbackHeadPositionUs = getPlaybackHeadPositionUs();
        if (playbackHeadPositionUs != 0) {
            long nanoTime = System.nanoTime() / 1000;
            if (nanoTime - this.lastPlayheadSampleTimeUs >= WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                long[] jArr = this.playheadOffsets;
                int i5 = this.nextPlayheadOffsetIndex;
                jArr[i5] = playbackHeadPositionUs - nanoTime;
                this.nextPlayheadOffsetIndex = (i5 + 1) % 10;
                int i6 = this.playheadOffsetCount;
                if (i6 < 10) {
                    this.playheadOffsetCount = i6 + 1;
                }
                this.lastPlayheadSampleTimeUs = nanoTime;
                this.smoothedPlayheadOffsetUs = 0;
                int i7 = 0;
                while (true) {
                    int i8 = this.playheadOffsetCount;
                    if (i7 >= i8) {
                        break;
                    }
                    this.smoothedPlayheadOffsetUs += this.playheadOffsets[i7] / ((long) i8);
                    i7++;
                }
            }
            if (!this.needsPassthroughWorkarounds) {
                maybePollAndCheckTimestamp(nanoTime, playbackHeadPositionUs);
                maybeUpdateLatency(nanoTime);
            }
        }
    }

    private void maybeUpdateLatency(long j5) {
        Method method;
        if (this.isOutputPcm && (method = this.getLatencyMethod) != null && j5 - this.lastLatencySampleTimeUs >= 500000) {
            try {
                long intValue = (((long) ((Integer) method.invoke(this.audioTrack, (Object[]) null)).intValue()) * 1000) - this.bufferSizeUs;
                this.latencyUs = intValue;
                long max = Math.max(intValue, 0);
                this.latencyUs = max;
                if (max > 5000000) {
                    this.listener.onInvalidLatency(max);
                    this.latencyUs = 0;
                }
            } catch (Exception unused) {
                this.getLatencyMethod = null;
            }
            this.lastLatencySampleTimeUs = j5;
        }
    }

    private static boolean needsPassthroughWorkarounds(int i5) {
        if (Util.SDK_INT >= 23) {
            return false;
        }
        if (i5 == 5 || i5 == 6) {
            return true;
        }
        return false;
    }

    private void resetSyncParams() {
        this.smoothedPlayheadOffsetUs = 0;
        this.playheadOffsetCount = 0;
        this.nextPlayheadOffsetIndex = 0;
        this.lastPlayheadSampleTimeUs = 0;
    }

    public final int getAvailableBufferSize(long j5) {
        return this.bufferSize - ((int) (j5 - (getPlaybackHeadPosition() * ((long) this.outputPcmFrameSize))));
    }

    public final long getCurrentPositionUs(boolean z4) {
        long j5;
        if (this.audioTrack.getPlayState() == 3) {
            maybeSampleSyncParams();
        }
        long nanoTime = System.nanoTime() / 1000;
        if (this.audioTimestampPoller.hasTimestamp()) {
            long framesToDurationUs = framesToDurationUs(this.audioTimestampPoller.getTimestampPositionFrames());
            if (!this.audioTimestampPoller.isTimestampAdvancing()) {
                return framesToDurationUs;
            }
            return framesToDurationUs + (nanoTime - this.audioTimestampPoller.getTimestampSystemTimeUs());
        }
        if (this.playheadOffsetCount == 0) {
            j5 = getPlaybackHeadPositionUs();
        } else {
            j5 = nanoTime + this.smoothedPlayheadOffsetUs;
        }
        if (!z4) {
            return j5 - this.latencyUs;
        }
        return j5;
    }

    public final void handleEndOfStream(long j5) {
        this.stopPlaybackHeadPosition = getPlaybackHeadPosition();
        this.stopTimestampUs = SystemClock.elapsedRealtime() * 1000;
        this.endPlaybackHeadPosition = j5;
    }

    public final boolean hasPendingData(long j5) {
        if (j5 > getPlaybackHeadPosition() || forceHasPendingData()) {
            return true;
        }
        return false;
    }

    public final boolean isPlaying() {
        if (this.audioTrack.getPlayState() == 3) {
            return true;
        }
        return false;
    }

    public final boolean isStalled(long j5) {
        if (this.forceResetWorkaroundTimeMs == C.TIME_UNSET || j5 <= 0 || SystemClock.elapsedRealtime() - this.forceResetWorkaroundTimeMs < FORCE_RESET_WORKAROUND_TIMEOUT_MS) {
            return false;
        }
        return true;
    }

    public final boolean mayHandleBuffer(long j5) {
        Listener listener2;
        int playState = this.audioTrack.getPlayState();
        if (this.needsPassthroughWorkarounds) {
            if (playState == 2) {
                this.hasData = false;
                return false;
            } else if (playState == 1 && getPlaybackHeadPosition() == 0) {
                return false;
            }
        }
        boolean z4 = this.hasData;
        boolean hasPendingData = hasPendingData(j5);
        this.hasData = hasPendingData;
        if (z4 && !hasPendingData && playState != 1 && (listener2 = this.listener) != null) {
            listener2.onUnderrun(this.bufferSize, C.usToMs(this.bufferSizeUs));
        }
        return true;
    }

    public final boolean pause() {
        resetSyncParams();
        if (this.stopTimestampUs != C.TIME_UNSET) {
            return false;
        }
        this.audioTimestampPoller.reset();
        return true;
    }

    public final void reset() {
        resetSyncParams();
        this.audioTrack = null;
        this.audioTimestampPoller = null;
    }

    public final void setAudioTrack(AudioTrack audioTrack2, int i5, int i6, int i7) {
        long j5;
        this.audioTrack = audioTrack2;
        this.outputPcmFrameSize = i6;
        this.bufferSize = i7;
        this.audioTimestampPoller = new AudioTimestampPoller(audioTrack2);
        this.outputSampleRate = audioTrack2.getSampleRate();
        this.needsPassthroughWorkarounds = needsPassthroughWorkarounds(i5);
        boolean isEncodingPcm = Util.isEncodingPcm(i5);
        this.isOutputPcm = isEncodingPcm;
        if (isEncodingPcm) {
            j5 = framesToDurationUs((long) (i7 / i6));
        } else {
            j5 = -9223372036854775807L;
        }
        this.bufferSizeUs = j5;
        this.lastRawPlaybackHeadPosition = 0;
        this.rawPlaybackHeadWrapCount = 0;
        this.passthroughWorkaroundPauseOffset = 0;
        this.hasData = false;
        this.stopTimestampUs = C.TIME_UNSET;
        this.forceResetWorkaroundTimeMs = C.TIME_UNSET;
        this.latencyUs = 0;
    }

    public final void start() {
        this.audioTimestampPoller.reset();
    }
}
