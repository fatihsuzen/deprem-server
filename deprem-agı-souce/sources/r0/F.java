package r0;

public final class F {

    /* renamed from: a  reason: collision with root package name */
    private final Class f16316a;

    /* renamed from: b  reason: collision with root package name */
    private final Class f16317b;

    private @interface a {
    }

    public F(Class cls, Class cls2) {
        this.f16316a = cls;
        this.f16317b = cls2;
    }

    public static F a(Class cls, Class cls2) {
        return new F(cls, cls2);
    }

    public static F b(Class cls) {
        return new F(a.class, cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || F.class != obj.getClass()) {
            return false;
        }
        F f5 = (F) obj;
        if (!this.f16317b.equals(f5.f16317b)) {
            return false;
        }
        return this.f16316a.equals(f5.f16316a);
    }

    public int hashCode() {
        return (this.f16317b.hashCode() * 31) + this.f16316a.hashCode();
    }

    public String toString() {
        if (this.f16316a == a.class) {
            return this.f16317b.getName();
        }
        return "@" + this.f16316a.getName() + " " + this.f16317b.getName();
    }
}
