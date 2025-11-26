package l2;

/* renamed from: l2.I  reason: case insensitive filesystem */
public final class C2649I {

    /* renamed from: a  reason: collision with root package name */
    private String f24773a;

    /* renamed from: b  reason: collision with root package name */
    private String f24774b;

    public final String a() {
        return this.f24773a;
    }

    public final String b() {
        return this.f24774b;
    }

    public final void c(String str) {
        this.f24773a = str;
    }

    public final void d(String str) {
        this.f24774b = str;
    }

    public String toString() {
        return "{query='" + this.f24773a + "', timestamp='" + this.f24774b + "'}";
    }
}
