package com.mbridge.msdk.playercommon.exoplayer2.source.chunk;

import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.HttpDataSource;

public final class ChunkedTrackBlacklistUtil {
    public static final long DEFAULT_TRACK_BLACKLIST_MS = 60000;
    private static final String TAG = "ChunkedTrackBlacklist";

    private ChunkedTrackBlacklistUtil() {
    }

    public static boolean maybeBlacklistTrack(TrackSelection trackSelection, int i5, Exception exc) {
        return maybeBlacklistTrack(trackSelection, i5, exc, DEFAULT_TRACK_BLACKLIST_MS);
    }

    public static boolean shouldBlacklist(Exception exc) {
        if (!(exc instanceof HttpDataSource.InvalidResponseCodeException)) {
            return false;
        }
        int i5 = ((HttpDataSource.InvalidResponseCodeException) exc).responseCode;
        if (i5 == 404 || i5 == 410) {
            return true;
        }
        return false;
    }

    public static boolean maybeBlacklistTrack(TrackSelection trackSelection, int i5, Exception exc, long j5) {
        if (!shouldBlacklist(exc)) {
            return false;
        }
        boolean blacklist = trackSelection.blacklist(i5, j5);
        int i6 = ((HttpDataSource.InvalidResponseCodeException) exc).responseCode;
        if (blacklist) {
            Log.w(TAG, "Blacklisted: duration=" + j5 + ", responseCode=" + i6 + ", format=" + trackSelection.getFormat(i5));
            return blacklist;
        }
        Log.w(TAG, "Blacklisting failed (cannot blacklist last enabled track): responseCode=" + i6 + ", format=" + trackSelection.getFormat(i5));
        return blacklist;
    }
}
