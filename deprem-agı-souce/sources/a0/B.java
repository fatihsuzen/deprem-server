package A0;

import A0.G;

final class B extends G {

    /* renamed from: a  reason: collision with root package name */
    private final G.a f1864a;

    /* renamed from: b  reason: collision with root package name */
    private final G.c f1865b;

    /* renamed from: c  reason: collision with root package name */
    private final G.b f1866c;

    B(G.a aVar, G.c cVar, G.b bVar) {
        if (aVar != null) {
            this.f1864a = aVar;
            if (cVar != null) {
                this.f1865b = cVar;
                if (bVar != null) {
                    this.f1866c = bVar;
                    return;
                }
                throw new NullPointerException("Null deviceData");
            }
            throw new NullPointerException("Null osData");
        }
        throw new NullPointerException("Null appData");
    }

    public G.a a() {
        return this.f1864a;
    }

    public G.b c() {
        return this.f1866c;
    }

    public G.c d() {
        return this.f1865b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof G) {
            G g5 = (G) obj;
            if (!this.f1864a.equals(g5.a()) || !this.f1865b.equals(g5.d()) || !this.f1866c.equals(g5.c())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f1864a.hashCode() ^ 1000003) * 1000003) ^ this.f1865b.hashCode()) * 1000003) ^ this.f1866c.hashCode();
    }

    public String toString() {
        return "StaticSessionData{appData=" + this.f1864a + ", osData=" + this.f1865b + ", deviceData=" + this.f1866c + "}";
    }
}
