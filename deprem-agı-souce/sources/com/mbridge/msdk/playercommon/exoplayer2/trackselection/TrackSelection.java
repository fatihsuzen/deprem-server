package com.mbridge.msdk.playercommon.exoplayer2.trackselection;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroup;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.MediaChunk;
import java.util.List;

public interface TrackSelection {

    public interface Factory {
        TrackSelection createTrackSelection(TrackGroup trackGroup, int... iArr);
    }

    boolean blacklist(int i5, long j5);

    void disable();

    void enable();

    int evaluateQueueSize(long j5, List<? extends MediaChunk> list);

    Format getFormat(int i5);

    int getIndexInTrackGroup(int i5);

    Format getSelectedFormat();

    int getSelectedIndex();

    int getSelectedIndexInTrackGroup();

    @Nullable
    Object getSelectionData();

    int getSelectionReason();

    TrackGroup getTrackGroup();

    int indexOf(int i5);

    int indexOf(Format format);

    int length();

    void onPlaybackSpeed(float f5);

    void updateSelectedTrack(long j5, long j6, long j7);
}
