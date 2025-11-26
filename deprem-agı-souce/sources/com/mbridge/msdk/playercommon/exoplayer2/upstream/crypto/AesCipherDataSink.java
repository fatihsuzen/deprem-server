package com.mbridge.msdk.playercommon.exoplayer2.upstream.crypto;

import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSink;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec;
import java.io.IOException;

public final class AesCipherDataSink implements DataSink {
    private AesFlushingCipher cipher;
    private final byte[] scratch;
    private final byte[] secretKey;
    private final DataSink wrappedDataSink;

    public AesCipherDataSink(byte[] bArr, DataSink dataSink) {
        this(bArr, dataSink, (byte[]) null);
    }

    public final void close() throws IOException {
        this.cipher = null;
        this.wrappedDataSink.close();
    }

    public final void open(DataSpec dataSpec) throws IOException {
        this.wrappedDataSink.open(dataSpec);
        this.cipher = new AesFlushingCipher(1, this.secretKey, CryptoUtil.getFNV64Hash(dataSpec.key), dataSpec.absoluteStreamPosition);
    }

    public final void write(byte[] bArr, int i5, int i6) throws IOException {
        if (this.scratch == null) {
            this.cipher.updateInPlace(bArr, i5, i6);
            this.wrappedDataSink.write(bArr, i5, i6);
            return;
        }
        int i7 = 0;
        while (i7 < i6) {
            int min = Math.min(i6 - i7, this.scratch.length);
            byte[] bArr2 = bArr;
            this.cipher.update(bArr2, i5 + i7, min, this.scratch, 0);
            this.wrappedDataSink.write(this.scratch, 0, min);
            i7 += min;
            bArr = bArr2;
        }
    }

    public AesCipherDataSink(byte[] bArr, DataSink dataSink, byte[] bArr2) {
        this.wrappedDataSink = dataSink;
        this.secretKey = bArr;
        this.scratch = bArr2;
    }
}
