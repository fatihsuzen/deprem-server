package com.mbridge.msdk.playercommon.exoplayer2.extractor.mkv;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import java.io.IOException;

final class VarintReader {
    private static final int STATE_BEGIN_READING = 0;
    private static final int STATE_READ_CONTENTS = 1;
    private static final long[] VARINT_LENGTH_MASKS = {128, 64, 32, 16, 8, 4, 2, 1};
    private int length;
    private final byte[] scratch = new byte[8];
    private int state;

    public static long assembleVarint(byte[] bArr, int i5, boolean z4) {
        long j5 = ((long) bArr[0]) & 255;
        if (z4) {
            j5 &= ~VARINT_LENGTH_MASKS[i5 - 1];
        }
        for (int i6 = 1; i6 < i5; i6++) {
            j5 = (j5 << 8) | (((long) bArr[i6]) & 255);
        }
        return j5;
    }

    public static int parseUnsignedVarintLength(int i5) {
        int i6 = 0;
        while (true) {
            long[] jArr = VARINT_LENGTH_MASKS;
            if (i6 >= jArr.length) {
                return -1;
            }
            if ((jArr[i6] & ((long) i5)) != 0) {
                return i6 + 1;
            }
            i6++;
        }
    }

    public final int getLastLength() {
        return this.length;
    }

    public final long readUnsignedVarint(ExtractorInput extractorInput, boolean z4, boolean z5, int i5) throws IOException, InterruptedException {
        if (this.state == 0) {
            if (!extractorInput.readFully(this.scratch, 0, 1, z4)) {
                return -1;
            }
            int parseUnsignedVarintLength = parseUnsignedVarintLength(this.scratch[0] & 255);
            this.length = parseUnsignedVarintLength;
            if (parseUnsignedVarintLength != -1) {
                this.state = 1;
            } else {
                throw new IllegalStateException("No valid varint length mask found");
            }
        }
        int i6 = this.length;
        if (i6 > i5) {
            this.state = 0;
            return -2;
        }
        if (i6 != 1) {
            extractorInput.readFully(this.scratch, 1, i6 - 1);
        }
        this.state = 0;
        return assembleVarint(this.scratch, this.length, z5);
    }

    public final void reset() {
        this.state = 0;
        this.length = 0;
    }
}
