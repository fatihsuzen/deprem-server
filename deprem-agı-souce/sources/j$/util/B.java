package j$.util;

public final class B {

    /* renamed from: b  reason: collision with root package name */
    public static final B f1253b = new B();

    /* renamed from: a  reason: collision with root package name */
    public final Object f1254a;

    public B() {
        this.f1254a = null;
    }

    public B(Object obj) {
        this.f1254a = Objects.requireNonNull(obj);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof B)) {
            return false;
        }
        return Objects.equals(this.f1254a, ((B) obj).f1254a);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f1254a);
    }

    public final String toString() {
        Object obj = this.f1254a;
        if (obj == null) {
            return "Optional.empty";
        }
        return String.format("Optional[%s]", new Object[]{obj});
    }
}
