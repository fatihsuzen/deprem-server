package r0;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    private final F f16373a;

    /* renamed from: b  reason: collision with root package name */
    private final int f16374b;

    /* renamed from: c  reason: collision with root package name */
    private final int f16375c;

    private r(Class cls, int i5, int i6) {
        this(F.b(cls), i5, i6);
    }

    public static r a(Class cls) {
        return new r(cls, 0, 2);
    }

    private static String b(int i5) {
        if (i5 == 0) {
            return "direct";
        }
        if (i5 == 1) {
            return "provider";
        }
        if (i5 == 2) {
            return "deferred";
        }
        throw new AssertionError("Unsupported injection: " + i5);
    }

    public static r h(Class cls) {
        return new r(cls, 0, 0);
    }

    public static r i(Class cls) {
        return new r(cls, 0, 1);
    }

    public static r j(F f5) {
        return new r(f5, 0, 1);
    }

    public static r k(Class cls) {
        return new r(cls, 1, 0);
    }

    public static r l(F f5) {
        return new r(f5, 1, 0);
    }

    public static r m(Class cls) {
        return new r(cls, 1, 1);
    }

    public static r n(F f5) {
        return new r(f5, 1, 1);
    }

    public static r o(Class cls) {
        return new r(cls, 2, 0);
    }

    public F c() {
        return this.f16373a;
    }

    public boolean d() {
        if (this.f16375c == 2) {
            return true;
        }
        return false;
    }

    public boolean e() {
        if (this.f16375c == 0) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj instanceof r) {
            r rVar = (r) obj;
            if (this.f16373a.equals(rVar.f16373a) && this.f16374b == rVar.f16374b && this.f16375c == rVar.f16375c) {
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean f() {
        if (this.f16374b == 1) {
            return true;
        }
        return false;
    }

    public boolean g() {
        if (this.f16374b == 2) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f16373a.hashCode() ^ 1000003) * 1000003) ^ this.f16374b) * 1000003) ^ this.f16375c;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.f16373a);
        sb.append(", type=");
        int i5 = this.f16374b;
        if (i5 == 1) {
            str = "required";
        } else if (i5 == 0) {
            str = "optional";
        } else {
            str = "set";
        }
        sb.append(str);
        sb.append(", injection=");
        sb.append(b(this.f16375c));
        sb.append("}");
        return sb.toString();
    }

    private r(F f5, int i5, int i6) {
        this.f16373a = (F) E.c(f5, "Null dependency anInterface.");
        this.f16374b = i5;
        this.f16375c = i6;
    }
}
