package com.mbridge.msdk.playercommon.exoplayer2.video;

import com.mbridge.msdk.playercommon.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.util.CodecSpecificDataUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.NalUnitUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.List;

public final class AvcConfig {
    public final int height;
    public final List<byte[]> initializationData;
    public final int nalUnitLengthFieldLength;
    public final float pixelWidthAspectRatio;
    public final int width;

    private AvcConfig(List<byte[]> list, int i5, int i6, int i7, float f5) {
        this.initializationData = list;
        this.nalUnitLengthFieldLength = i5;
        this.width = i6;
        this.height = i7;
        this.pixelWidthAspectRatio = f5;
    }

    private static byte[] buildNalUnitForChild(ParsableByteArray parsableByteArray) {
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int position = parsableByteArray.getPosition();
        parsableByteArray.skipBytes(readUnsignedShort);
        return CodecSpecificDataUtil.buildNalUnit(parsableByteArray.data, position, readUnsignedShort);
    }

    public static AvcConfig parse(ParsableByteArray parsableByteArray) throws ParserException {
        float f5;
        int i5;
        int i6;
        try {
            parsableByteArray.skipBytes(4);
            int readUnsignedByte = (parsableByteArray.readUnsignedByte() & 3) + 1;
            if (readUnsignedByte != 3) {
                ArrayList arrayList = new ArrayList();
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte() & 31;
                for (int i7 = 0; i7 < readUnsignedByte2; i7++) {
                    arrayList.add(buildNalUnitForChild(parsableByteArray));
                }
                int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                for (int i8 = 0; i8 < readUnsignedByte3; i8++) {
                    arrayList.add(buildNalUnitForChild(parsableByteArray));
                }
                if (readUnsignedByte2 > 0) {
                    NalUnitUtil.SpsData parseSpsNalUnit = NalUnitUtil.parseSpsNalUnit((byte[]) arrayList.get(0), readUnsignedByte, ((byte[]) arrayList.get(0)).length);
                    int i9 = parseSpsNalUnit.width;
                    int i10 = parseSpsNalUnit.height;
                    f5 = parseSpsNalUnit.pixelWidthAspectRatio;
                    i5 = i9;
                    i6 = i10;
                } else {
                    f5 = 1.0f;
                    i5 = -1;
                    i6 = -1;
                }
                return new AvcConfig(arrayList, readUnsignedByte, i5, i6, f5);
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e5) {
            throw new ParserException("Error parsing AVC config", e5);
        }
    }
}
