package com.mbridge.msdk.playercommon.exoplayer2.extractor.ts;

import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.util.Arrays;

final class NalUnitTargetBuffer {
    private boolean isCompleted;
    private boolean isFilling;
    public byte[] nalData;
    public int nalLength;
    private final int targetType;

    public NalUnitTargetBuffer(int i5, int i6) {
        this.targetType = i5;
        byte[] bArr = new byte[(i6 + 3)];
        this.nalData = bArr;
        bArr[2] = 1;
    }

    public final void appendToNalUnit(byte[] bArr, int i5, int i6) {
        if (this.isFilling) {
            int i7 = i6 - i5;
            byte[] bArr2 = this.nalData;
            int length = bArr2.length;
            int i8 = this.nalLength;
            if (length < i8 + i7) {
                this.nalData = Arrays.copyOf(bArr2, (i8 + i7) * 2);
            }
            System.arraycopy(bArr, i5, this.nalData, this.nalLength, i7);
            this.nalLength += i7;
        }
    }

    public final boolean endNalUnit(int i5) {
        if (!this.isFilling) {
            return false;
        }
        this.nalLength -= i5;
        this.isFilling = false;
        this.isCompleted = true;
        return true;
    }

    public final boolean isCompleted() {
        return this.isCompleted;
    }

    public final void reset() {
        this.isFilling = false;
        this.isCompleted = false;
    }

    public final void startNalUnit(int i5) {
        boolean z4 = true;
        Assertions.checkState(!this.isFilling);
        if (i5 != this.targetType) {
            z4 = false;
        }
        this.isFilling = z4;
        if (z4) {
            this.nalLength = 3;
            this.isCompleted = false;
        }
    }
}
