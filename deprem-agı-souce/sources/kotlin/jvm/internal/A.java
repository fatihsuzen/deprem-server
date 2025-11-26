package kotlin.jvm.internal;

public final class A implements C2630h {

    /* renamed from: a  reason: collision with root package name */
    private final Class f24685a;

    /* renamed from: b  reason: collision with root package name */
    private final String f24686b;

    public A(Class cls, String str) {
        t.e(cls, "jClass");
        t.e(str, "moduleName");
        this.f24685a = cls;
        this.f24686b = str;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof A) || !t.a(g(), ((A) obj).g())) {
            return false;
        }
        return true;
    }

    public Class g() {
        return this.f24685a;
    }

    public int hashCode() {
        return g().hashCode();
    }

    public String toString() {
        return g() + " (Kotlin reflection is not available)";
    }
}
