package com.mbridge.msdk.playercommon.exoplayer2.extractor.mkv;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

final class Sniffer {
    private static final int ID_EBML = 440786851;
    private static final int SEARCH_LENGTH = 1024;
    private int peekLength;
    private final ParsableByteArray scratch = new ParsableByteArray(8);

    private long readUint(ExtractorInput extractorInput) throws IOException, InterruptedException {
        int i5 = 0;
        extractorInput.peekFully(this.scratch.data, 0, 1);
        byte b5 = this.scratch.data[0] & 255;
        if (b5 == 0) {
            return Long.MIN_VALUE;
        }
        int i6 = 128;
        int i7 = 0;
        while ((b5 & i6) == 0) {
            i6 >>= 1;
            i7++;
        }
        int i8 = b5 & (~i6);
        extractorInput.peekFully(this.scratch.data, 1, i7);
        while (i5 < i7) {
            i5++;
            i8 = (this.scratch.data[i5] & 255) + (i8 << 8);
        }
        this.peekLength += i7 + 1;
        return (long) i8;
    }

    public final boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        long readUint;
        int i5;
        long length = extractorInput.getLength();
        int i6 = (length > -1 ? 1 : (length == -1 ? 0 : -1));
        long j5 = 1024;
        if (i6 != 0 && length <= 1024) {
            j5 = length;
        }
        int i7 = (int) j5;
        extractorInput.peekFully(this.scratch.data, 0, 4);
        long readUnsignedInt = this.scratch.readUnsignedInt();
        this.peekLength = 4;
        while (readUnsignedInt != 440786851) {
            int i8 = this.peekLength + 1;
            this.peekLength = i8;
            if (i8 == i7) {
                return false;
            }
            extractorInput.peekFully(this.scratch.data, 0, 1);
            readUnsignedInt = ((readUnsignedInt << 8) & -256) | ((long) (this.scratch.data[0] & 255));
        }
        long readUint2 = readUint(extractorInput);
        long j6 = (long) this.peekLength;
        if (readUint2 != Long.MIN_VALUE && (i6 == 0 || j6 + readUint2 < length)) {
            while (true) {
                int i9 = this.peekLength;
                long j7 = j6 + readUint2;
                if (((long) i9) < j7) {
                    if (readUint(extractorInput) != Long.MIN_VALUE && readUint >= 0 && readUint <= 2147483647L) {
                        if (i5 != 0) {
                            int readUint3 = (int) (readUint = readUint(extractorInput));
                            extractorInput.advancePeekPosition(readUint3);
                            this.peekLength += readUint3;
                        }
                    }
                } else if (((long) i9) == j7) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
