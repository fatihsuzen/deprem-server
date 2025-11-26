package com.mbridge.msdk.playercommon.exoplayer2.video;

import com.mbridge.msdk.playercommon.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.util.NalUnitUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.util.Collections;
import java.util.List;

public final class HevcConfig {
    public final List<byte[]> initializationData;
    public final int nalUnitLengthFieldLength;

    private HevcConfig(List<byte[]> list, int i5) {
        this.initializationData = list;
        this.nalUnitLengthFieldLength = i5;
    }

    public static HevcConfig parse(ParsableByteArray parsableByteArray) throws ParserException {
        List list;
        try {
            parsableByteArray.skipBytes(21);
            int readUnsignedByte = parsableByteArray.readUnsignedByte() & 3;
            int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
            int position = parsableByteArray.getPosition();
            int i5 = 0;
            for (int i6 = 0; i6 < readUnsignedByte2; i6++) {
                parsableByteArray.skipBytes(1);
                int readUnsignedShort = parsableByteArray.readUnsignedShort();
                for (int i7 = 0; i7 < readUnsignedShort; i7++) {
                    int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
                    i5 += readUnsignedShort2 + 4;
                    parsableByteArray.skipBytes(readUnsignedShort2);
                }
            }
            parsableByteArray.setPosition(position);
            byte[] bArr = new byte[i5];
            int i8 = 0;
            for (int i9 = 0; i9 < readUnsignedByte2; i9++) {
                parsableByteArray.skipBytes(1);
                int readUnsignedShort3 = parsableByteArray.readUnsignedShort();
                for (int i10 = 0; i10 < readUnsignedShort3; i10++) {
                    int readUnsignedShort4 = parsableByteArray.readUnsignedShort();
                    byte[] bArr2 = NalUnitUtil.NAL_START_CODE;
                    System.arraycopy(bArr2, 0, bArr, i8, bArr2.length);
                    int length = i8 + bArr2.length;
                    System.arraycopy(parsableByteArray.data, parsableByteArray.getPosition(), bArr, length, readUnsignedShort4);
                    i8 = length + readUnsignedShort4;
                    parsableByteArray.skipBytes(readUnsignedShort4);
                }
            }
            if (i5 == 0) {
                list = null;
            } else {
                list = Collections.singletonList(bArr);
            }
            return new HevcConfig(list, readUnsignedByte + 1);
        } catch (ArrayIndexOutOfBoundsException e5) {
            throw new ParserException("Error parsing HEVC config", e5);
        }
    }
}
