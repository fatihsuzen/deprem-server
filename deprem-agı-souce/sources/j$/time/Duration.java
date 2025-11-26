package j$.time;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import j$.com.android.tools.r8.a;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.math.BigInteger;

public final class Duration implements Comparable<Duration>, Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final Duration f1003c = new Duration(0, 0);
    private static final long serialVersionUID = 3078945930695997490L;

    /* renamed from: a  reason: collision with root package name */
    public final long f1004a;

    /* renamed from: b  reason: collision with root package name */
    public final int f1005b;

    public final int compareTo(Object obj) {
        Duration duration = (Duration) obj;
        int compare = Long.compare(this.f1004a, duration.f1004a);
        if (compare != 0) {
            return compare;
        }
        return this.f1005b - duration.f1005b;
    }

    static {
        BigInteger.valueOf(C.NANOS_PER_SECOND);
    }

    public static Duration ofMillis(long j5) {
        long j6 = j5 / 1000;
        int i5 = (int) (j5 % 1000);
        if (i5 < 0) {
            i5 += 1000;
            j6--;
        }
        return e(j6, i5 * 1000000);
    }

    public static Duration f(long j5) {
        long j6 = j5 / C.NANOS_PER_SECOND;
        int i5 = (int) (j5 % C.NANOS_PER_SECOND);
        if (i5 < 0) {
            i5 = (int) (((long) i5) + C.NANOS_PER_SECOND);
            j6--;
        }
        return e(j6, i5);
    }

    public static Duration e(long j5, int i5) {
        if ((((long) i5) | j5) == 0) {
            return f1003c;
        }
        return new Duration(j5, i5);
    }

    public Duration(long j5, int i5) {
        this.f1004a = j5;
        this.f1005b = i5;
    }

    public long toMillis() {
        long j5 = this.f1004a;
        long j6 = (long) this.f1005b;
        if (j5 < 0) {
            j5++;
            j6 -= C.NANOS_PER_SECOND;
        }
        return a.x(a.w(j5, 1000), j6 / 1000000);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Duration) {
            Duration duration = (Duration) obj;
            return this.f1004a == duration.f1004a && this.f1005b == duration.f1005b;
        }
    }

    public int hashCode() {
        long j5 = this.f1004a;
        return (this.f1005b * 51) + ((int) (j5 ^ (j5 >>> 32)));
    }

    public final String toString() {
        if (this == f1003c) {
            return "PT0S";
        }
        long j5 = this.f1004a;
        if (j5 < 0 && this.f1005b > 0) {
            j5++;
        }
        long j6 = j5 / 3600;
        int i5 = (int) ((j5 % 3600) / 60);
        int i6 = (int) (j5 % 60);
        StringBuilder sb = new StringBuilder(24);
        sb.append("PT");
        if (j6 != 0) {
            sb.append(j6);
            sb.append('H');
        }
        if (i5 != 0) {
            sb.append(i5);
            sb.append('M');
        }
        if (i6 == 0 && this.f1005b == 0 && sb.length() > 2) {
            return sb.toString();
        }
        if (this.f1004a >= 0 || this.f1005b <= 0) {
            sb.append(i6);
        } else if (i6 == 0) {
            sb.append("-0");
        } else {
            sb.append(i6);
        }
        if (this.f1005b > 0) {
            int length = sb.length();
            if (this.f1004a < 0) {
                sb.append(2000000000 - ((long) this.f1005b));
            } else {
                sb.append(((long) this.f1005b) + C.NANOS_PER_SECOND);
            }
            while (sb.charAt(sb.length() - 1) == '0') {
                sb.setLength(sb.length() - 1);
            }
            sb.setCharAt(length, '.');
        }
        sb.append('S');
        return sb.toString();
    }

    private Object writeReplace() {
        return new r((byte) 1, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
