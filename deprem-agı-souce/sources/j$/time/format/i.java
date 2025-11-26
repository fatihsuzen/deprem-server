package j$.time.format;

import androidx.work.WorkRequest;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import j$.time.temporal.q;

public class i implements f {

    /* renamed from: f  reason: collision with root package name */
    public static final long[] f1107f = {0, 10, 100, 1000, WorkRequest.MIN_BACKOFF_MILLIS, 100000, 1000000, 10000000, 100000000, C.NANOS_PER_SECOND, 10000000000L};

    /* renamed from: a  reason: collision with root package name */
    public final q f1108a;

    /* renamed from: b  reason: collision with root package name */
    public final int f1109b;

    /* renamed from: c  reason: collision with root package name */
    public final int f1110c;

    /* renamed from: d  reason: collision with root package name */
    public final u f1111d;

    /* renamed from: e  reason: collision with root package name */
    public final int f1112e;

    public i(q qVar, int i5, int i6, u uVar) {
        this.f1108a = qVar;
        this.f1109b = i5;
        this.f1110c = i6;
        this.f1111d = uVar;
        this.f1112e = 0;
    }

    public i(q qVar, int i5, int i6, u uVar, int i7) {
        this.f1108a = qVar;
        this.f1109b = i5;
        this.f1110c = i6;
        this.f1111d = uVar;
        this.f1112e = i7;
    }

    public i a() {
        if (this.f1112e == -1) {
            return this;
        }
        return new i(this.f1108a, this.f1109b, this.f1110c, this.f1111d, -1);
    }

    public i b(int i5) {
        return new i(this.f1108a, this.f1109b, this.f1110c, this.f1111d, this.f1112e + i5);
    }

    public boolean e(p pVar, StringBuilder sb) {
        q qVar = this.f1108a;
        Long a5 = pVar.a(qVar);
        if (a5 == null) {
            return false;
        }
        long longValue = a5.longValue();
        s sVar = pVar.f1135b.f1096c;
        String l5 = longValue == Long.MIN_VALUE ? "9223372036854775808" : Long.toString(Math.abs(longValue));
        int length = l5.length();
        int i5 = this.f1110c;
        if (length <= i5) {
            sVar.getClass();
            int i6 = (longValue > 0 ? 1 : (longValue == 0 ? 0 : -1));
            int i7 = this.f1109b;
            u uVar = this.f1111d;
            if (i6 >= 0) {
                int i8 = c.f1101a[uVar.ordinal()];
                if (i8 != 1) {
                    if (i8 == 2) {
                        sb.append('+');
                    }
                } else if (i7 < 19 && longValue >= f1107f[i7]) {
                    sb.append('+');
                }
            } else {
                int i9 = c.f1101a[uVar.ordinal()];
                if (i9 == 1 || i9 == 2 || i9 == 3) {
                    sb.append('-');
                } else if (i9 == 4) {
                    throw new RuntimeException("Field " + qVar + " cannot be printed as the value " + longValue + " cannot be negative according to the SignStyle");
                }
            }
            for (int i10 = 0; i10 < i7 - l5.length(); i10++) {
                sb.append('0');
            }
            sb.append(l5);
            return true;
        }
        throw new RuntimeException("Field " + qVar + " cannot be printed as the value " + longValue + " exceeds the maximum print width of " + i5);
    }

    public String toString() {
        int i5 = this.f1110c;
        q qVar = this.f1108a;
        u uVar = this.f1111d;
        int i6 = this.f1109b;
        if (i6 == 1 && i5 == 19 && uVar == u.NORMAL) {
            return "Value(" + qVar + ")";
        } else if (i6 == i5 && uVar == u.NOT_NEGATIVE) {
            return "Value(" + qVar + "," + i6 + ")";
        } else {
            return "Value(" + qVar + "," + i6 + "," + i5 + "," + uVar + ")";
        }
    }
}
