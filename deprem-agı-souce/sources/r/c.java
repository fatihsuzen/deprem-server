package r;

import p.C1745c;
import p.C1746d;
import p.h;
import r.o;

final class c extends o {

    /* renamed from: a  reason: collision with root package name */
    private final p f16255a;

    /* renamed from: b  reason: collision with root package name */
    private final String f16256b;

    /* renamed from: c  reason: collision with root package name */
    private final C1746d f16257c;

    /* renamed from: d  reason: collision with root package name */
    private final h f16258d;

    /* renamed from: e  reason: collision with root package name */
    private final C1745c f16259e;

    static final class b extends o.a {

        /* renamed from: a  reason: collision with root package name */
        private p f16260a;

        /* renamed from: b  reason: collision with root package name */
        private String f16261b;

        /* renamed from: c  reason: collision with root package name */
        private C1746d f16262c;

        /* renamed from: d  reason: collision with root package name */
        private h f16263d;

        /* renamed from: e  reason: collision with root package name */
        private C1745c f16264e;

        b() {
        }

        public o a() {
            String str = "";
            if (this.f16260a == null) {
                str = str + " transportContext";
            }
            if (this.f16261b == null) {
                str = str + " transportName";
            }
            if (this.f16262c == null) {
                str = str + " event";
            }
            if (this.f16263d == null) {
                str = str + " transformer";
            }
            if (this.f16264e == null) {
                str = str + " encoding";
            }
            if (str.isEmpty()) {
                return new c(this.f16260a, this.f16261b, this.f16262c, this.f16263d, this.f16264e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        /* access modifiers changed from: package-private */
        public o.a b(C1745c cVar) {
            if (cVar != null) {
                this.f16264e = cVar;
                return this;
            }
            throw new NullPointerException("Null encoding");
        }

        /* access modifiers changed from: package-private */
        public o.a c(C1746d dVar) {
            if (dVar != null) {
                this.f16262c = dVar;
                return this;
            }
            throw new NullPointerException("Null event");
        }

        /* access modifiers changed from: package-private */
        public o.a d(h hVar) {
            if (hVar != null) {
                this.f16263d = hVar;
                return this;
            }
            throw new NullPointerException("Null transformer");
        }

        public o.a e(p pVar) {
            if (pVar != null) {
                this.f16260a = pVar;
                return this;
            }
            throw new NullPointerException("Null transportContext");
        }

        public o.a f(String str) {
            if (str != null) {
                this.f16261b = str;
                return this;
            }
            throw new NullPointerException("Null transportName");
        }
    }

    public C1745c b() {
        return this.f16259e;
    }

    /* access modifiers changed from: package-private */
    public C1746d c() {
        return this.f16257c;
    }

    /* access modifiers changed from: package-private */
    public h e() {
        return this.f16258d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            if (!this.f16255a.equals(oVar.f()) || !this.f16256b.equals(oVar.g()) || !this.f16257c.equals(oVar.c()) || !this.f16258d.equals(oVar.e()) || !this.f16259e.equals(oVar.b())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public p f() {
        return this.f16255a;
    }

    public String g() {
        return this.f16256b;
    }

    public int hashCode() {
        return ((((((((this.f16255a.hashCode() ^ 1000003) * 1000003) ^ this.f16256b.hashCode()) * 1000003) ^ this.f16257c.hashCode()) * 1000003) ^ this.f16258d.hashCode()) * 1000003) ^ this.f16259e.hashCode();
    }

    public String toString() {
        return "SendRequest{transportContext=" + this.f16255a + ", transportName=" + this.f16256b + ", event=" + this.f16257c + ", transformer=" + this.f16258d + ", encoding=" + this.f16259e + "}";
    }

    private c(p pVar, String str, C1746d dVar, h hVar, C1745c cVar) {
        this.f16255a = pVar;
        this.f16256b = str;
        this.f16257c = dVar;
        this.f16258d = hVar;
        this.f16259e = cVar;
    }
}
