package j$.util;

public final class D {

    /* renamed from: c  reason: collision with root package name */
    public static final D f1258c = new D();

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1259a;

    /* renamed from: b  reason: collision with root package name */
    public final int f1260b;

    public D() {
        this.f1259a = false;
        this.f1260b = 0;
    }

    public D(int i5) {
        this.f1259a = true;
        this.f1260b = i5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof D)) {
            return false;
        }
        D d5 = (D) obj;
        boolean z4 = this.f1259a;
        return (!z4 || !d5.f1259a) ? z4 == d5.f1259a : this.f1260b == d5.f1260b;
    }

    public final int hashCode() {
        if (this.f1259a) {
            return this.f1260b;
        }
        return 0;
    }

    public final String toString() {
        if (!this.f1259a) {
            return "OptionalInt.empty";
        }
        return "OptionalInt[" + this.f1260b + "]";
    }
}
