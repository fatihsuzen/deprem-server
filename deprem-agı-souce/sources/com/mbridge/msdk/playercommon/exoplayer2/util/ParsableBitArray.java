package com.mbridge.msdk.playercommon.exoplayer2.util;

import androidx.core.view.MotionEventCompat;

public final class ParsableBitArray {
    private int bitOffset;
    private int byteLimit;
    private int byteOffset;
    public byte[] data;

    public ParsableBitArray() {
    }

    private void assertValidOffset() {
        boolean z4;
        int i5;
        int i6 = this.byteOffset;
        if (i6 < 0 || (i6 >= (i5 = this.byteLimit) && !(i6 == i5 && this.bitOffset == 0))) {
            z4 = false;
        } else {
            z4 = true;
        }
        Assertions.checkState(z4);
    }

    public final int bitsLeft() {
        return ((this.byteLimit - this.byteOffset) * 8) - this.bitOffset;
    }

    public final void byteAlign() {
        if (this.bitOffset != 0) {
            this.bitOffset = 0;
            this.byteOffset++;
            assertValidOffset();
        }
    }

    public final int getBytePosition() {
        boolean z4;
        if (this.bitOffset == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkState(z4);
        return this.byteOffset;
    }

    public final int getPosition() {
        return (this.byteOffset * 8) + this.bitOffset;
    }

    public final void putInt(int i5, int i6) {
        if (i6 < 32) {
            i5 &= (1 << i6) - 1;
        }
        int min = Math.min(8 - this.bitOffset, i6);
        int i7 = this.bitOffset;
        int i8 = (8 - i7) - min;
        byte b5 = (MotionEventCompat.ACTION_POINTER_INDEX_MASK >> i7) | ((1 << i8) - 1);
        byte[] bArr = this.data;
        int i9 = this.byteOffset;
        byte b6 = (byte) (b5 & bArr[i9]);
        bArr[i9] = b6;
        int i10 = i6 - min;
        bArr[i9] = (byte) (b6 | ((i5 >>> i10) << i8));
        int i11 = i9 + 1;
        while (i10 > 8) {
            this.data[i11] = (byte) (i5 >>> (i10 - 8));
            i10 -= 8;
            i11++;
        }
        int i12 = 8 - i10;
        byte[] bArr2 = this.data;
        byte b7 = (byte) (bArr2[i11] & ((1 << i12) - 1));
        bArr2[i11] = b7;
        bArr2[i11] = (byte) (((i5 & ((1 << i10) - 1)) << i12) | b7);
        skipBits(i6);
        assertValidOffset();
    }

    public final boolean readBit() {
        boolean z4;
        if ((this.data[this.byteOffset] & (128 >> this.bitOffset)) != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        skipBit();
        return z4;
    }

    public final int readBits(int i5) {
        int i6;
        if (i5 == 0) {
            return 0;
        }
        this.bitOffset += i5;
        int i7 = 0;
        while (true) {
            i6 = this.bitOffset;
            if (i6 <= 8) {
                break;
            }
            int i8 = i6 - 8;
            this.bitOffset = i8;
            byte[] bArr = this.data;
            int i9 = this.byteOffset;
            this.byteOffset = i9 + 1;
            i7 |= (bArr[i9] & 255) << i8;
        }
        byte[] bArr2 = this.data;
        int i10 = this.byteOffset;
        int i11 = (-1 >>> (32 - i5)) & (i7 | ((bArr2[i10] & 255) >> (8 - i6)));
        if (i6 == 8) {
            this.bitOffset = 0;
            this.byteOffset = i10 + 1;
        }
        assertValidOffset();
        return i11;
    }

    public final void readBytes(byte[] bArr, int i5, int i6) {
        boolean z4;
        if (this.bitOffset == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkState(z4);
        System.arraycopy(this.data, this.byteOffset, bArr, i5, i6);
        this.byteOffset += i6;
        assertValidOffset();
    }

    public final void reset(byte[] bArr) {
        reset(bArr, bArr.length);
    }

    public final void setPosition(int i5) {
        int i6 = i5 / 8;
        this.byteOffset = i6;
        this.bitOffset = i5 - (i6 * 8);
        assertValidOffset();
    }

    public final void skipBit() {
        int i5 = this.bitOffset + 1;
        this.bitOffset = i5;
        if (i5 == 8) {
            this.bitOffset = 0;
            this.byteOffset++;
        }
        assertValidOffset();
    }

    public final void skipBits(int i5) {
        int i6 = i5 / 8;
        int i7 = this.byteOffset + i6;
        this.byteOffset = i7;
        int i8 = this.bitOffset + (i5 - (i6 * 8));
        this.bitOffset = i8;
        if (i8 > 7) {
            this.byteOffset = i7 + 1;
            this.bitOffset = i8 - 8;
        }
        assertValidOffset();
    }

    public final void skipBytes(int i5) {
        boolean z4;
        if (this.bitOffset == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkState(z4);
        this.byteOffset += i5;
        assertValidOffset();
    }

    public ParsableBitArray(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public final void reset(ParsableByteArray parsableByteArray) {
        reset(parsableByteArray.data, parsableByteArray.limit());
        setPosition(parsableByteArray.getPosition() * 8);
    }

    public ParsableBitArray(byte[] bArr, int i5) {
        this.data = bArr;
        this.byteLimit = i5;
    }

    public final void reset(byte[] bArr, int i5) {
        this.data = bArr;
        this.byteOffset = 0;
        this.bitOffset = 0;
        this.byteLimit = i5;
    }

    public final void readBits(byte[] bArr, int i5, int i6) {
        int i7 = (i6 >> 3) + i5;
        while (i5 < i7) {
            byte[] bArr2 = this.data;
            int i8 = this.byteOffset;
            int i9 = i8 + 1;
            this.byteOffset = i9;
            byte b5 = bArr2[i8];
            int i10 = this.bitOffset;
            byte b6 = (byte) (b5 << i10);
            bArr[i5] = b6;
            bArr[i5] = (byte) (((255 & bArr2[i9]) >> (8 - i10)) | b6);
            i5++;
        }
        int i11 = i6 & 7;
        if (i11 != 0) {
            byte b7 = (byte) (bArr[i7] & (255 >> i11));
            bArr[i7] = b7;
            int i12 = this.bitOffset;
            if (i12 + i11 > 8) {
                byte[] bArr3 = this.data;
                int i13 = this.byteOffset;
                this.byteOffset = i13 + 1;
                bArr[i7] = (byte) (b7 | ((bArr3[i13] & 255) << i12));
                this.bitOffset = i12 - 8;
            }
            int i14 = this.bitOffset + i11;
            this.bitOffset = i14;
            byte[] bArr4 = this.data;
            int i15 = this.byteOffset;
            bArr[i7] = (byte) (((byte) (((255 & bArr4[i15]) >> (8 - i14)) << (8 - i11))) | bArr[i7]);
            if (i14 == 8) {
                this.bitOffset = 0;
                this.byteOffset = i15 + 1;
            }
            assertValidOffset();
        }
    }
}
