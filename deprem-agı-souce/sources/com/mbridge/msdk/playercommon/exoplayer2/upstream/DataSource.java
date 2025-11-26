package com.mbridge.msdk.playercommon.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;

public interface DataSource {

    public interface Factory {
        DataSource createDataSource();
    }

    void close() throws IOException;

    @Nullable
    Uri getUri();

    long open(DataSpec dataSpec) throws IOException;

    int read(byte[] bArr, int i5, int i6) throws IOException;
}
