package j$.time.temporal;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public final class u implements Serializable {
    private static final long serialVersionUID = -7317881728594519368L;

    /* renamed from: a  reason: collision with root package name */
    public final long f1206a;

    /* renamed from: b  reason: collision with root package name */
    public final long f1207b;

    /* renamed from: c  reason: collision with root package name */
    public final long f1208c;

    /* renamed from: d  reason: collision with root package name */
    public final long f1209d;

    public static u e(long j5, long j6) {
        if (j5 <= j6) {
            return new u(j5, j5, j6, j6);
        }
        throw new IllegalArgumentException("Minimum value must be less than maximum value");
    }

    public static u f(long j5, long j6) {
        if (j5 > j6) {
            throw new IllegalArgumentException("Smallest maximum value must be less than largest maximum value");
        } else if (1 <= j6) {
            return new u(1, 1, j5, j6);
        } else {
            throw new IllegalArgumentException("Minimum value must be less than maximum value");
        }
    }

    public u(long j5, long j6, long j7, long j8) {
        this.f1206a = j5;
        this.f1207b = j6;
        this.f1208c = j7;
        this.f1209d = j8;
    }

    public final int a(long j5, q qVar) {
        if (this.f1206a >= -2147483648L && this.f1209d <= 2147483647L && d(j5)) {
            return (int) j5;
        }
        throw new RuntimeException(c(j5, qVar));
    }

    public final boolean d(long j5) {
        return j5 >= this.f1206a && j5 <= this.f1209d;
    }

    public final void b(long j5, q qVar) {
        if (!d(j5)) {
            throw new RuntimeException(c(j5, qVar));
        }
    }

    public final String c(long j5, q qVar) {
        if (qVar != null) {
            return "Invalid value for " + qVar + " (valid values " + this + "): " + j5;
        }
        return "Invalid value (valid values " + this + "): " + j5;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        long j5 = this.f1206a;
        long j6 = this.f1207b;
        if (j5 <= j6) {
            long j7 = this.f1208c;
            long j8 = this.f1209d;
            if (j7 > j8) {
                throw new InvalidObjectException("Smallest maximum value must be less than largest maximum value");
            } else if (j6 > j8) {
                throw new InvalidObjectException("Minimum value must be less than maximum value");
            }
        } else {
            throw new InvalidObjectException("Smallest minimum value must be less than largest minimum value");
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof u) {
            u uVar = (u) obj;
            return this.f1206a == uVar.f1206a && this.f1207b == uVar.f1207b && this.f1208c == uVar.f1208c && this.f1209d == uVar.f1209d;
        }
    }

    public final int hashCode() {
        long j5 = this.f1206a;
        long j6 = this.f1207b;
        long j7 = j5 + (j6 << 16) + (j6 >> 48);
        long j8 = this.f1208c;
        long j9 = j7 + (j8 << 32) + (j8 >> 32);
        long j10 = this.f1209d;
        long j11 = j9 + (j10 << 48) + (j10 >> 16);
        return (int) (j11 ^ (j11 >>> 32));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1206a);
        if (this.f1206a != this.f1207b) {
            sb.append('/');
            sb.append(this.f1207b);
        }
        sb.append(" - ");
        sb.append(this.f1208c);
        if (this.f1208c != this.f1209d) {
            sb.append('/');
            sb.append(this.f1209d);
        }
        return sb.toString();
    }
}
