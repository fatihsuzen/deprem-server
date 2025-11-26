package com.mbridge.msdk.playercommon.exoplayer2.text.cea;

import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;

public final class CeaUtil {
    private static final int COUNTRY_CODE = 181;
    private static final int PAYLOAD_TYPE_CC = 4;
    private static final int PROVIDER_CODE_ATSC = 49;
    private static final int PROVIDER_CODE_DIRECTV = 47;
    private static final String TAG = "CeaUtil";
    private static final int USER_DATA_TYPE_CODE = 3;
    private static final int USER_ID_DTG1 = Util.getIntegerCodeForString("DTG1");
    private static final int USER_ID_GA94 = Util.getIntegerCodeForString("GA94");

    private CeaUtil() {
    }

    public static void consume(long j5, ParsableByteArray parsableByteArray, TrackOutput[] trackOutputArr) {
        int i5;
        boolean z4;
        boolean z5;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        TrackOutput[] trackOutputArr2 = trackOutputArr;
        while (parsableByteArray2.bytesLeft() > 1) {
            int readNon255TerminatedValue = readNon255TerminatedValue(parsableByteArray2);
            int readNon255TerminatedValue2 = readNon255TerminatedValue(parsableByteArray2);
            int position = parsableByteArray2.getPosition() + readNon255TerminatedValue2;
            if (readNon255TerminatedValue2 == -1 || readNon255TerminatedValue2 > parsableByteArray2.bytesLeft()) {
                Log.w(TAG, "Skipping remainder of malformed SEI NAL unit.");
                position = parsableByteArray2.limit();
            } else if (readNon255TerminatedValue == 4 && readNon255TerminatedValue2 >= 8) {
                int readUnsignedByte = parsableByteArray2.readUnsignedByte();
                int readUnsignedShort = parsableByteArray2.readUnsignedShort();
                if (readUnsignedShort == 49) {
                    i5 = parsableByteArray2.readInt();
                } else {
                    i5 = 0;
                }
                int readUnsignedByte2 = parsableByteArray2.readUnsignedByte();
                if (readUnsignedShort == 47) {
                    parsableByteArray2.skipBytes(1);
                }
                if (readUnsignedByte == COUNTRY_CODE && ((readUnsignedShort == 49 || readUnsignedShort == 47) && readUnsignedByte2 == 3)) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (readUnsignedShort == 49) {
                    if (i5 == USER_ID_GA94 || i5 == USER_ID_DTG1) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    z4 &= z5;
                }
                if (z4) {
                    parsableByteArray2.skipBytes(1);
                    int readUnsignedByte3 = (parsableByteArray2.readUnsignedByte() & 31) * 3;
                    int position2 = parsableByteArray2.getPosition();
                    for (TrackOutput trackOutput : trackOutputArr2) {
                        parsableByteArray2.setPosition(position2);
                        trackOutput.sampleData(parsableByteArray2, readUnsignedByte3);
                        trackOutput.sampleMetadata(j5, 1, readUnsignedByte3, 0, (TrackOutput.CryptoData) null);
                    }
                }
            }
            parsableByteArray2.setPosition(position);
        }
    }

    private static int readNon255TerminatedValue(ParsableByteArray parsableByteArray) {
        int i5 = 0;
        while (parsableByteArray.bytesLeft() != 0) {
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            i5 += readUnsignedByte;
            if (readUnsignedByte != 255) {
                return i5;
            }
        }
        return -1;
    }
}
