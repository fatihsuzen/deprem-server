package com.mbridge.msdk.playercommon.exoplayer2.upstream;

import android.net.Uri;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.io.IOException;

public final class ByteArrayDataSource implements DataSource {
    private int bytesRemaining;
    private final byte[] data;
    private int readPosition;
    private Uri uri;

    public ByteArrayDataSource(byte[] bArr) {
        boolean z4;
        Assertions.checkNotNull(bArr);
        if (bArr.length > 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkArgument(z4);
        this.data = bArr;
    }

    public final void close() throws IOException {
        this.uri = null;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final long open(DataSpec dataSpec) throws IOException {
        this.uri = dataSpec.uri;
        long j5 = dataSpec.position;
        int i5 = (int) j5;
        this.readPosition = i5;
        long j6 = dataSpec.length;
        if (j6 == -1) {
            j6 = ((long) this.data.length) - j5;
        }
        int i6 = (int) j6;
        this.bytesRemaining = i6;
        if (i6 > 0 && i5 + i6 <= this.data.length) {
            return (long) i6;
        }
        throw new IOException("Unsatisfiable range: [" + this.readPosition + ", " + dataSpec.length + "], length: " + this.data.length);
    }

    public final int read(byte[] bArr, int i5, int i6) throws IOException {
        if (i6 == 0) {
            return 0;
        }
        int i7 = this.bytesRemaining;
        if (i7 == 0) {
            return -1;
        }
        int min = Math.min(i6, i7);
        System.arraycopy(this.data, this.readPosition, bArr, i5, min);
        this.readPosition += min;
        this.bytesRemaining -= min;
        return min;
    }
}
