package com.mbridge.msdk.playercommon.exoplayer2.upstream.crypto;

import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class AesFlushingCipher {
    private final int blockSize;
    private final Cipher cipher;
    private final byte[] flushedBlock;
    private int pendingXorBytes;
    private final byte[] zerosBlock;

    public AesFlushingCipher(int i5, byte[] bArr, long j5, long j6) {
        try {
            Cipher instance = Cipher.getInstance("AES/CTR/NoPadding");
            this.cipher = instance;
            int blockSize2 = instance.getBlockSize();
            this.blockSize = blockSize2;
            this.zerosBlock = new byte[blockSize2];
            this.flushedBlock = new byte[blockSize2];
            long j7 = j6 / ((long) blockSize2);
            int i6 = (int) (j6 % ((long) blockSize2));
            instance.init(i5, new SecretKeySpec(bArr, Util.splitAtFirst(instance.getAlgorithm(), "/")[0]), new IvParameterSpec(getInitializationVector(j5, j7)));
            if (i6 != 0) {
                updateInPlace(new byte[i6], 0, i6);
            }
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e5) {
            throw new RuntimeException(e5);
        }
    }

    private byte[] getInitializationVector(long j5, long j6) {
        return ByteBuffer.allocate(16).putLong(j5).putLong(j6).array();
    }

    private int nonFlushingUpdate(byte[] bArr, int i5, int i6, byte[] bArr2, int i7) {
        try {
            return this.cipher.update(bArr, i5, i6, bArr2, i7);
        } catch (ShortBufferException e5) {
            throw new RuntimeException(e5);
        }
    }

    public final void update(byte[] bArr, int i5, int i6, byte[] bArr2, int i7) {
        boolean z4;
        int i8 = i5;
        int i9 = i6;
        int i10 = i7;
        do {
            int i11 = this.pendingXorBytes;
            if (i11 > 0) {
                bArr2[i10] = (byte) (bArr[i8] ^ this.flushedBlock[this.blockSize - i11]);
                i10++;
                i8++;
                this.pendingXorBytes = i11 - 1;
                i9--;
            } else {
                int nonFlushingUpdate = nonFlushingUpdate(bArr, i8, i9, bArr2, i10);
                if (i9 != nonFlushingUpdate) {
                    int i12 = i9 - nonFlushingUpdate;
                    int i13 = 0;
                    boolean z5 = true;
                    if (i12 < this.blockSize) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    Assertions.checkState(z4);
                    int i14 = i10 + nonFlushingUpdate;
                    int i15 = this.blockSize - i12;
                    this.pendingXorBytes = i15;
                    if (nonFlushingUpdate(this.zerosBlock, 0, i15, this.flushedBlock, 0) != this.blockSize) {
                        z5 = false;
                    }
                    Assertions.checkState(z5);
                    while (i13 < i12) {
                        bArr2[i14] = this.flushedBlock[i13];
                        i13++;
                        i14++;
                    }
                    return;
                }
                return;
            }
        } while (i9 != 0);
    }

    public final void updateInPlace(byte[] bArr, int i5, int i6) {
        update(bArr, i5, i6, bArr, i5);
    }
}
