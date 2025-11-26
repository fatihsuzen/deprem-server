package a4;

import V3.c;
import e4.C2359h;
import java.io.IOException;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    static final C2359h f20335a = C2359h.f("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f20336b = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* renamed from: c  reason: collision with root package name */
    static final String[] f20337c = new String[64];

    /* renamed from: d  reason: collision with root package name */
    static final String[] f20338d = new String[256];

    static {
        int i5 = 0;
        int i6 = 0;
        while (true) {
            String[] strArr = f20338d;
            if (i6 >= strArr.length) {
                break;
            }
            strArr[i6] = c.o("%8s", Integer.toBinaryString(i6)).replace(' ', '0');
            i6++;
        }
        String[] strArr2 = f20337c;
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
            String[] strArr3 = f20337c;
            int i11 = i10 | i9;
            strArr3[i11] = strArr3[i10] + '|' + strArr3[i9];
            strArr3[i11 | 8] = strArr3[i10] + '|' + strArr3[i9] + "|PADDED";
        }
        while (true) {
            String[] strArr4 = f20337c;
            if (i5 < strArr4.length) {
                if (strArr4[i5] == null) {
                    strArr4[i5] = f20338d[i5];
                }
                i5++;
            } else {
                return;
            }
        }
    }

    static String a(byte b5, byte b6) {
        String str;
        if (b6 == 0) {
            return "";
        }
        if (!(b5 == 2 || b5 == 3)) {
            if (b5 == 4 || b5 == 6) {
                if (b6 == 1) {
                    return "ACK";
                }
                return f20338d[b6];
            } else if (!(b5 == 7 || b5 == 8)) {
                String[] strArr = f20337c;
                if (b6 < strArr.length) {
                    str = strArr[b6];
                } else {
                    str = f20338d[b6];
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
        return f20338d[b6];
    }

    static String b(boolean z4, int i5, int i6, byte b5, byte b6) {
        String str;
        String str2;
        String[] strArr = f20336b;
        if (b5 < strArr.length) {
            str = strArr[b5];
        } else {
            str = c.o("0x%02x", Byte.valueOf(b5));
        }
        String a5 = a(b5, b6);
        if (z4) {
            str2 = "<<";
        } else {
            str2 = ">>";
        }
        return c.o("%s 0x%08x %5d %-13s %s", str2, Integer.valueOf(i5), Integer.valueOf(i6), str, a5);
    }

    static IllegalArgumentException c(String str, Object... objArr) {
        throw new IllegalArgumentException(c.o(str, objArr));
    }

    static IOException d(String str, Object... objArr) {
        throw new IOException(c.o(str, objArr));
    }
}
