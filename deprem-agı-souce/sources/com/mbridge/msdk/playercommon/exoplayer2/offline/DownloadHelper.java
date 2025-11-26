package com.mbridge.msdk.playercommon.exoplayer2.offline;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray;
import java.io.IOException;
import java.util.List;

public abstract class DownloadHelper {

    public interface Callback {
        void onPrepareError(DownloadHelper downloadHelper, IOException iOException);

        void onPrepared(DownloadHelper downloadHelper);
    }

    public abstract DownloadAction getDownloadAction(@Nullable byte[] bArr, List<TrackKey> list);

    public abstract int getPeriodCount();

    public abstract DownloadAction getRemoveAction(@Nullable byte[] bArr);

    public abstract TrackGroupArray getTrackGroups(int i5);

    public void prepare(final Callback callback) {
        Looper looper;
        if (Looper.myLooper() != null) {
            looper = Looper.myLooper();
        } else {
            looper = Looper.getMainLooper();
        }
        final Handler handler = new Handler(looper);
        new Thread() {
            public void run() {
                try {
                    DownloadHelper.this.prepareInternal();
                    handler.post(new Runnable() {
                        public void run() {
                            AnonymousClass1 r02 = AnonymousClass1.this;
                            callback.onPrepared(DownloadHelper.this);
                        }
                    });
                } catch (IOException e5) {
                    handler.post(new Runnable() {
                        public void run() {
                            AnonymousClass1 r02 = AnonymousClass1.this;
                            callback.onPrepareError(DownloadHelper.this, e5);
                        }
                    });
                }
            }
        }.start();
    }

    /* access modifiers changed from: protected */
    public abstract void prepareInternal() throws IOException;
}
