package j$.util;

public final class C {

    /* renamed from: c  reason: collision with root package name */
    public static final C f1255c = new C();

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1256a;

    /* renamed from: b  reason: collision with root package name */
    public final double f1257b;

    public C() {
        this.f1256a = false;
        this.f1257b = Double.NaN;
    }

    public C(double d5) {
        this.f1256a = true;
        this.f1257b = d5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C)) {
            return false;
        }
        C c5 = (C) obj;
        boolean z4 = this.f1256a;
        return (!z4 || !c5.f1256a) ? z4 == c5.f1256a : Double.compare(this.f1257b, c5.f1257b) == 0;
    }

    public final int hashCode() {
        if (!this.f1256a) {
            return 0;
        }
        long doubleToLongBits = Double.doubleToLongBits(this.f1257b);
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }

    public final String toString() {
        if (!this.f1256a) {
            return "OptionalDouble.empty";
        }
        return "OptionalDouble[" + this.f1257b + "]";
    }
}
