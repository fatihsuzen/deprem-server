package com.mbridge.msdk.playercommon.exoplayer2.upstream;

import android.net.Uri;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.io.IOException;

public final class TeeDataSource implements DataSource {
    private long bytesRemaining;
    private final DataSink dataSink;
    private boolean dataSinkNeedsClosing;
    private final DataSource upstream;

    public TeeDataSource(DataSource dataSource, DataSink dataSink2) {
        this.upstream = (DataSource) Assertions.checkNotNull(dataSource);
        this.dataSink = (DataSink) Assertions.checkNotNull(dataSink2);
    }

    public final void close() throws IOException {
        try {
            this.upstream.close();
        } finally {
            if (this.dataSinkNeedsClosing) {
                this.dataSinkNeedsClosing = false;
                this.dataSink.close();
            }
        }
    }

    public final Uri getUri() {
        return this.upstream.getUri();
    }

    public final long open(DataSpec dataSpec) throws IOException {
        long open = this.upstream.open(dataSpec);
        this.bytesRemaining = open;
        if (open == 0) {
            return 0;
        }
        if (dataSpec.length == -1 && open != -1) {
            dataSpec = new DataSpec(dataSpec.uri, dataSpec.absoluteStreamPosition, dataSpec.position, open, dataSpec.key, dataSpec.flags);
        }
        this.dataSinkNeedsClosing = true;
        this.dataSink.open(dataSpec);
        return this.bytesRemaining;
    }

    public final int read(byte[] bArr, int i5, int i6) throws IOException {
        if (this.bytesRemaining == 0) {
            return -1;
        }
        int read = this.upstream.read(bArr, i5, i6);
        if (read > 0) {
            this.dataSink.write(bArr, i5, read);
            long j5 = this.bytesRemaining;
            if (j5 != -1) {
                this.bytesRemaining = j5 - ((long) read);
            }
        }
        return read;
    }
}
