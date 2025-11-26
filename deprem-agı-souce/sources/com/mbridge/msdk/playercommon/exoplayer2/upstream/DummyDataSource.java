package com.mbridge.msdk.playercommon.exoplayer2.upstream;

import android.net.Uri;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource;
import java.io.IOException;

public final class DummyDataSource implements DataSource {
    public static final DataSource.Factory FACTORY = new DataSource.Factory() {
        public final DataSource createDataSource() {
            return new DummyDataSource();
        }
    };
    public static final DummyDataSource INSTANCE = new DummyDataSource();

    private DummyDataSource() {
    }

    public final void close() throws IOException {
    }

    public final Uri getUri() {
        return null;
    }

    public final long open(DataSpec dataSpec) throws IOException {
        throw new IOException("Dummy source");
    }

    public final int read(byte[] bArr, int i5, int i6) throws IOException {
        throw new UnsupportedOperationException();
    }
}
