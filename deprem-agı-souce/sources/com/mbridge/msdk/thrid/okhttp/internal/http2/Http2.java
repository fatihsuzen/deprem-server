package com.mbridge.msdk.thrid.okhttp.internal.http2;

import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okio.ByteString;
import java.io.IOException;

public final class Http2 {
    static final String[] BINARY = new String[256];
    static final ByteString CONNECTION_PREFACE = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    static final String[] FLAGS = new String[64];
    static final byte FLAG_ACK = 1;
    static final byte FLAG_COMPRESSED = 32;
    static final byte FLAG_END_HEADERS = 4;
    static final byte FLAG_END_PUSH_PROMISE = 4;
    static final byte FLAG_END_STREAM = 1;
    static final byte FLAG_NONE = 0;
    static final byte FLAG_PADDED = 8;
    static final byte FLAG_PRIORITY = 32;
    private static final String[] FRAME_NAMES = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    static final int INITIAL_MAX_FRAME_SIZE = 16384;
    static final byte TYPE_CONTINUATION = 9;
    static final byte TYPE_DATA = 0;
    static final byte TYPE_GOAWAY = 7;
    static final byte TYPE_HEADERS = 1;
    static final byte TYPE_PING = 6;
    static final byte TYPE_PRIORITY = 2;
    static final byte TYPE_PUSH_PROMISE = 5;
    static final byte TYPE_RST_STREAM = 3;
    static final byte TYPE_SETTINGS = 4;
    static final byte TYPE_WINDOW_UPDATE = 8;

    static {
        int i5 = 0;
        int i6 = 0;
        while (true) {
            String[] strArr = BINARY;
            if (i6 >= strArr.length) {
                break;
            }
            strArr[i6] = Util.format("%8s", Integer.toBinaryString(i6)).replace(' ', '0');
            i6++;
        }
        String[] strArr2 = FLAGS;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i7 = iArr[0];
        strArr2[i7 | 8] = strArr2[i7] + "|PADDED";
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i8 = 0; i8 < 3; i8++) {
            int i9 = iArr2[i8];
            int i10 = iArr[0];
            String[] strArr3 = FLAGS;
            int i11 = i10 | i9;
            strArr3[i11] = strArr3[i10] + '|' + strArr3[i9];
            strArr3[i11 | 8] = strArr3[i10] + '|' + strArr3[i9] + "|PADDED";
        }
        while (true) {
            String[] strArr4 = FLAGS;
            if (i5 < strArr4.length) {
                if (strArr4[i5] == null) {
                    strArr4[i5] = BINARY[i5];
                }
                i5++;
            } else {
                return;
            }
        }
    }

    private Http2() {
    }

    static String formatFlags(byte b5, byte b6) {
        String str;
        if (b6 == 0) {
            return "";
        }
        if (!(b5 == 2 || b5 == 3)) {
            if (b5 == 4 || b5 == 6) {
                if (b6 == 1) {
                    return "ACK";
                }
                return BINARY[b6];
            } else if (!(b5 == 7 || b5 == 8)) {
                String[] strArr = FLAGS;
                if (b6 < strArr.length) {
                    str = strArr[b6];
                } else {
                    str = BINARY[b6];
                }
                if (b5 == 5 && (b6 & 4) != 0) {
                    return str.replace("HEADERS", "PUSH_PROMISE");
                }
                if (b5 != 0 || (b6 & 32) == 0) {
                    return str;
                }
                return str.replace("PRIORITY", "COMPRESSED");
            }
        }
        return BINARY[b6];
    }

    static String frameLog(boolean z4, int i5, int i6, byte b5, byte b6) {
        String str;
        String str2;
        String[] strArr = FRAME_NAMES;
        if (b5 < strArr.length) {
            str = strArr[b5];
        } else {
            str = Util.format("0x%02x", Byte.valueOf(b5));
        }
        String formatFlags = formatFlags(b5, b6);
        if (z4) {
            str2 = "<<";
        } else {
            str2 = ">>";
        }
        return Util.format("%s 0x%08x %5d %-13s %s", str2, Integer.valueOf(i5), Integer.valueOf(i6), str, formatFlags);
    }

    static IllegalArgumentException illegalArgument(String str, Object... objArr) {
        throw new IllegalArgumentException(Util.format(str, objArr));
    }

    static IOException ioException(String str, Object... objArr) throws IOException {
        throw new IOException(Util.format(str, objArr));
    }
}
