package com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import java.util.Arrays;

final class OggPacket {
    private int currentSegmentIndex = -1;
    private final ParsableByteArray packetArray = new ParsableByteArray(new byte[OggPageHeader.MAX_PAGE_PAYLOAD], 0);
    private final OggPageHeader pageHeader = new OggPageHeader();
    private boolean populated;
    private int segmentCount;

    OggPacket() {
    }

    private int calculatePacketSize(int i5) {
        int i6;
        int i7 = 0;
        this.segmentCount = 0;
        do {
            int i8 = this.segmentCount;
            int i9 = i5 + i8;
            OggPageHeader oggPageHeader = this.pageHeader;
            if (i9 >= oggPageHeader.pageSegmentCount) {
                break;
            }
            int[] iArr = oggPageHeader.laces;
            this.segmentCount = i8 + 1;
            i6 = iArr[i8 + i5];
            i7 += i6;
        } while (i6 == 255);
        return i7;
    }

    public final OggPageHeader getPageHeader() {
        return this.pageHeader;
    }

    public final ParsableByteArray getPayload() {
        return this.packetArray;
    }

    public final boolean populate(ExtractorInput extractorInput) throws IOException, InterruptedException {
        boolean z4;
        boolean z5;
        int i5;
        if (extractorInput != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkState(z4);
        if (this.populated) {
            this.populated = false;
            this.packetArray.reset();
        }
        while (!this.populated) {
            if (this.currentSegmentIndex < 0) {
                if (!this.pageHeader.populate(extractorInput, true)) {
                    return false;
                }
                OggPageHeader oggPageHeader = this.pageHeader;
                int i6 = oggPageHeader.headerSize;
                if ((oggPageHeader.type & 1) == 1 && this.packetArray.limit() == 0) {
                    i6 += calculatePacketSize(0);
                    i5 = this.segmentCount;
                } else {
                    i5 = 0;
                }
                extractorInput.skipFully(i6);
                this.currentSegmentIndex = i5;
            }
            int calculatePacketSize = calculatePacketSize(this.currentSegmentIndex);
            int i7 = this.currentSegmentIndex + this.segmentCount;
            if (calculatePacketSize > 0) {
                if (this.packetArray.capacity() < this.packetArray.limit() + calculatePacketSize) {
                    ParsableByteArray parsableByteArray = this.packetArray;
                    parsableByteArray.data = Arrays.copyOf(parsableByteArray.data, parsableByteArray.limit() + calculatePacketSize);
                }
                ParsableByteArray parsableByteArray2 = this.packetArray;
                extractorInput.readFully(parsableByteArray2.data, parsableByteArray2.limit(), calculatePacketSize);
                ParsableByteArray parsableByteArray3 = this.packetArray;
                parsableByteArray3.setLimit(parsableByteArray3.limit() + calculatePacketSize);
                if (this.pageHeader.laces[i7 - 1] != 255) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                this.populated = z5;
            }
            if (i7 == this.pageHeader.pageSegmentCount) {
                i7 = -1;
            }
            this.currentSegmentIndex = i7;
        }
        return true;
    }

    public final void reset() {
        this.pageHeader.reset();
        this.packetArray.reset();
        this.currentSegmentIndex = -1;
        this.populated = false;
    }

    public final void trimPayload() {
        ParsableByteArray parsableByteArray = this.packetArray;
        byte[] bArr = parsableByteArray.data;
        if (bArr.length != 65025) {
            parsableByteArray.data = Arrays.copyOf(bArr, Math.max(OggPageHeader.MAX_PAGE_PAYLOAD, parsableByteArray.limit()));
        }
    }
}
