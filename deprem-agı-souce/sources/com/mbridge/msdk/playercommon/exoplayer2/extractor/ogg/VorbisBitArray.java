package com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg;

import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;

final class VorbisBitArray {
    private int bitOffset;
    private final int byteLimit;
    private int byteOffset;
    private final byte[] data;

    public VorbisBitArray(byte[] bArr) {
        this.data = bArr;
        this.byteLimit = bArr.length;
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

    public final int getPosition() {
        return (this.byteOffset * 8) + this.bitOffset;
    }

    public final boolean readBit() {
        boolean z4;
        if ((((this.data[this.byteOffset] & 255) >> this.bitOffset) & 1) == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        skipBits(1);
        return z4;
    }

    public final int readBits(int i5) {
        int i6 = this.byteOffset;
        int min = Math.min(i5, 8 - this.bitOffset);
        int i7 = i6 + 1;
        int i8 = ((this.data[i6] & 255) >> this.bitOffset) & (255 >> (8 - min));
        while (min < i5) {
            i8 |= (this.data[i7] & 255) << min;
            min += 8;
            i7++;
        }
        int i9 = i8 & (-1 >>> (32 - i5));
        skipBits(i5);
        return i9;
    }

    public final void reset() {
        this.byteOffset = 0;
        this.bitOffset = 0;
    }

    public final void setPosition(int i5) {
        int i6 = i5 / 8;
        this.byteOffset = i6;
        this.bitOffset = i5 - (i6 * 8);
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
}
