package com.mbridge.msdk.playercommon.exoplayer2.source.chunk;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Loader;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;

public abstract class Chunk implements Loader.Loadable {
    protected final DataSource dataSource;
    public final DataSpec dataSpec;
    public final long endTimeUs;
    public final long startTimeUs;
    public final Format trackFormat;
    @Nullable
    public final Object trackSelectionData;
    public final int trackSelectionReason;
    public final int type;

    public Chunk(DataSource dataSource2, DataSpec dataSpec2, int i5, Format format, int i6, @Nullable Object obj, long j5, long j6) {
        this.dataSource = (DataSource) Assertions.checkNotNull(dataSource2);
        this.dataSpec = (DataSpec) Assertions.checkNotNull(dataSpec2);
        this.type = i5;
        this.trackFormat = format;
        this.trackSelectionReason = i6;
        this.trackSelectionData = obj;
        this.startTimeUs = j5;
        this.endTimeUs = j6;
    }

    public abstract long bytesLoaded();

    public final long getDurationUs() {
        return this.endTimeUs - this.startTimeUs;
    }
}
