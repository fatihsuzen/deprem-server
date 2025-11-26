package com.mbridge.msdk.playercommon.exoplayer2.offline;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray;
import java.util.List;

public final class ProgressiveDownloadHelper extends DownloadHelper {
    @Nullable
    private final String customCacheKey;
    private final Uri uri;

    public ProgressiveDownloadHelper(Uri uri2) {
        this(uri2, (String) null);
    }

    public final DownloadAction getDownloadAction(@Nullable byte[] bArr, List<TrackKey> list) {
        return new ProgressiveDownloadAction(this.uri, false, bArr, this.customCacheKey);
    }

    public final int getPeriodCount() {
        return 1;
    }

    public final DownloadAction getRemoveAction(@Nullable byte[] bArr) {
        return new ProgressiveDownloadAction(this.uri, true, bArr, this.customCacheKey);
    }

    public final TrackGroupArray getTrackGroups(int i5) {
        return TrackGroupArray.EMPTY;
    }

    /* access modifiers changed from: protected */
    public final void prepareInternal() {
    }

    public ProgressiveDownloadHelper(Uri uri2, @Nullable String str) {
        this.uri = uri2;
        this.customCacheKey = str;
    }
}
