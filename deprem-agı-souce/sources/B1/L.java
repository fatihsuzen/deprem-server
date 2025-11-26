package b1;

import kotlin.jvm.internal.t;

public final class L {

    /* renamed from: a  reason: collision with root package name */
    private final C1026k f4544a;

    /* renamed from: b  reason: collision with root package name */
    private final T f4545b;

    /* renamed from: c  reason: collision with root package name */
    private final C1017b f4546c;

    public L(C1026k kVar, T t5, C1017b bVar) {
        t.e(kVar, "eventType");
        t.e(t5, "sessionData");
        t.e(bVar, "applicationInfo");
        this.f4544a = kVar;
        this.f4545b = t5;
        this.f4546c = bVar;
    }

    public final C1017b a() {
        return this.f4546c;
    }

    public final C1026k b() {
        return this.f4544a;
    }

    public final T c() {
        return this.f4545b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof L)) {
            return false;
        }
        L l5 = (L) obj;
        if (this.f4544a == l5.f4544a && t.a(this.f4545b, l5.f4545b) && t.a(this.f4546c, l5.f4546c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.f4544a.hashCode() * 31) + this.f4545b.hashCode()) * 31) + this.f4546c.hashCode();
    }

    public String toString() {
        return "SessionEvent(eventType=" + this.f4544a + ", sessionData=" + this.f4545b + ", applicationInfo=" + this.f4546c + ')';
    }
}
