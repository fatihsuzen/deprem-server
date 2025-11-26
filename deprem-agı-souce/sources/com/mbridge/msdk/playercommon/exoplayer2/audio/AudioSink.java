package com.mbridge.msdk.playercommon.exoplayer2.audio;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.PlaybackParameters;
import java.nio.ByteBuffer;

public interface AudioSink {
    public static final long CURRENT_POSITION_NOT_SET = Long.MIN_VALUE;

    public static final class ConfigurationException extends Exception {
        public ConfigurationException(Throwable th) {
            super(th);
        }

        public ConfigurationException(String str) {
            super(str);
        }
    }

    public static final class InitializationException extends Exception {
        public final int audioTrackState;

        public InitializationException(int i5, int i6, int i7, int i8) {
            super("AudioTrack init failed: " + i5 + ", Config(" + i6 + ", " + i7 + ", " + i8 + ")");
            this.audioTrackState = i5;
        }
    }

    public interface Listener {
        void onAudioSessionId(int i5);

        void onPositionDiscontinuity();

        void onUnderrun(int i5, long j5, long j6);
    }

    public static final class WriteException extends Exception {
        public final int errorCode;

        public WriteException(int i5) {
            super("AudioTrack write failed: " + i5);
            this.errorCode = i5;
        }
    }

    void configure(int i5, int i6, int i7, int i8, @Nullable int[] iArr, int i9, int i10) throws ConfigurationException;

    void disableTunneling();

    void enableTunnelingV21(int i5);

    long getCurrentPositionUs(boolean z4);

    PlaybackParameters getPlaybackParameters();

    boolean handleBuffer(ByteBuffer byteBuffer, long j5) throws InitializationException, WriteException;

    void handleDiscontinuity();

    boolean hasPendingData();

    boolean isEncodingSupported(int i5);

    boolean isEnded();

    void pause();

    void play();

    void playToEndOfStream() throws WriteException;

    void release();

    void reset();

    void setAudioAttributes(AudioAttributes audioAttributes);

    void setAudioSessionId(int i5);

    void setListener(Listener listener);

    PlaybackParameters setPlaybackParameters(PlaybackParameters playbackParameters);

    void setVolume(float f5);
}
