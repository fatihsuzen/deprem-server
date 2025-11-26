package e4;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import e4.C2356e;
import f4.b;
import kotlin.jvm.internal.t;
import t3.s;

/* renamed from: e4.b  reason: case insensitive filesystem */
public abstract class C2353b {

    /* renamed from: a  reason: collision with root package name */
    private static final C2356e.a f21535a = new C2356e.a();

    /* renamed from: b  reason: collision with root package name */
    private static final int f21536b = -1234567890;

    public static final boolean a(byte[] bArr, int i5, byte[] bArr2, int i6, int i7) {
        t.e(bArr, "a");
        t.e(bArr2, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
        for (int i8 = 0; i8 < i7; i8++) {
            if (bArr[i8 + i5] != bArr2[i8 + i6]) {
                return false;
            }
        }
        return true;
    }

    public static final void b(long j5, long j6, long j7) {
        if ((j6 | j7) < 0 || j6 > j5 || j5 - j6 < j7) {
            throw new ArrayIndexOutOfBoundsException("size=" + j5 + " offset=" + j6 + " byteCount=" + j7);
        }
    }

    public static final int c() {
        return f21536b;
    }

    public static final int d(C2359h hVar, int i5) {
        t.e(hVar, "<this>");
        if (i5 == f21536b) {
            return hVar.F();
        }
        return i5;
    }

    public static final int e(int i5) {
        return ((i5 & 255) << 24) | ((-16777216 & i5) >>> 24) | ((16711680 & i5) >>> 8) | ((65280 & i5) << 8);
    }

    public static final long f(long j5) {
        return ((j5 & 255) << 56) | ((-72057594037927936L & j5) >>> 56) | ((71776119061217280L & j5) >>> 40) | ((280375465082880L & j5) >>> 24) | ((1095216660480L & j5) >>> 8) | ((4278190080L & j5) << 8) | ((16711680 & j5) << 24) | ((65280 & j5) << 40);
    }

    public static final short g(short s5) {
        return (short) (((s5 & 255) << 8) | ((65280 & s5) >>> 8));
    }

    public static final String h(byte b5) {
        return s.y(new char[]{b.f()[(b5 >> 4) & 15], b.f()[b5 & 15]});
    }

    public static final String i(int i5) {
        if (i5 == 0) {
            return "0";
        }
        int i6 = 0;
        char[] cArr = {b.f()[(i5 >> 28) & 15], b.f()[(i5 >> 24) & 15], b.f()[(i5 >> 20) & 15], b.f()[(i5 >> 16) & 15], b.f()[(i5 >> 12) & 15], b.f()[(i5 >> 8) & 15], b.f()[(i5 >> 4) & 15], b.f()[i5 & 15]};
        while (i6 < 8 && cArr[i6] == '0') {
            i6++;
        }
        return s.z(cArr, i6, 8);
    }
}
