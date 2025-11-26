package j$.util;

public final class E {

    /* renamed from: c  reason: collision with root package name */
    public static final E f1261c = new E();

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1262a;

    /* renamed from: b  reason: collision with root package name */
    public final long f1263b;

    public E() {
        this.f1262a = false;
        this.f1263b = 0;
    }

    public E(long j5) {
        this.f1262a = true;
        this.f1263b = j5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof E)) {
            return false;
        }
        E e5 = (E) obj;
        boolean z4 = this.f1262a;
        return (!z4 || !e5.f1262a) ? z4 == e5.f1262a : this.f1263b == e5.f1263b;
    }

    public final int hashCode() {
        if (!this.f1262a) {
            return 0;
        }
        long j5 = this.f1263b;
        return (int) (j5 ^ (j5 >>> 32));
    }

    public final String toString() {
        if (!this.f1262a) {
            return "OptionalLong.empty";
        }
        return "OptionalLong[" + this.f1263b + "]";
    }
}
