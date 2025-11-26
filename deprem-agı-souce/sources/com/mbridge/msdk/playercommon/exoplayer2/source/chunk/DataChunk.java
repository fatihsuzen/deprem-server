package com.mbridge.msdk.playercommon.exoplayer2.source.chunk;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Arrays;

public abstract class DataChunk extends Chunk {
    private static final int READ_GRANULARITY = 16384;
    private byte[] data;
    private int limit;
    private volatile boolean loadCanceled;

    public DataChunk(DataSource dataSource, DataSpec dataSpec, int i5, Format format, int i6, Object obj, byte[] bArr) {
        super(dataSource, dataSpec, i5, format, i6, obj, C.TIME_UNSET, C.TIME_UNSET);
        this.data = bArr;
    }

    private void maybeExpandData() {
        byte[] bArr = this.data;
        if (bArr == null) {
            this.data = new byte[16384];
        } else if (bArr.length < this.limit + 16384) {
            this.data = Arrays.copyOf(bArr, bArr.length + 16384);
        }
    }

    public long bytesLoaded() {
        return (long) this.limit;
    }

    public final void cancelLoad() {
        this.loadCanceled = true;
    }

    /* access modifiers changed from: protected */
    public abstract void consume(byte[] bArr, int i5) throws IOException;

    public byte[] getDataHolder() {
        return this.data;
    }

    public final void load() throws IOException, InterruptedException {
        try {
            this.dataSource.open(this.dataSpec);
            int i5 = 0;
            this.limit = 0;
            while (i5 != -1 && !this.loadCanceled) {
                maybeExpandData();
                i5 = this.dataSource.read(this.data, this.limit, 16384);
                if (i5 != -1) {
                    this.limit += i5;
                }
            }
            if (!this.loadCanceled) {
                consume(this.data, this.limit);
            }
            Util.closeQuietly(this.dataSource);
        } catch (Throwable th) {
            Util.closeQuietly(this.dataSource);
            throw th;
        }
    }
}
