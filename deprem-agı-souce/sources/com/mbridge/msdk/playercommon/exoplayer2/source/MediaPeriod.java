package com.mbridge.msdk.playercommon.exoplayer2.source;

import com.mbridge.msdk.playercommon.exoplayer2.SeekParameters;
import com.mbridge.msdk.playercommon.exoplayer2.source.SequenceableLoader;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection;
import java.io.IOException;

public interface MediaPeriod extends SequenceableLoader {

    public interface Callback extends SequenceableLoader.Callback<MediaPeriod> {
        void onPrepared(MediaPeriod mediaPeriod);
    }

    boolean continueLoading(long j5);

    void discardBuffer(long j5, boolean z4);

    long getAdjustedSeekPositionUs(long j5, SeekParameters seekParameters);

    long getBufferedPositionUs();

    long getNextLoadPositionUs();

    TrackGroupArray getTrackGroups();

    void maybeThrowPrepareError() throws IOException;

    void prepare(Callback callback, long j5);

    long readDiscontinuity();

    void reevaluateBuffer(long j5);

    long seekToUs(long j5);

    long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j5);
}
