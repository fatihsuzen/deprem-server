package A0;

import A0.F;
import java.util.List;

final class p extends F.e.d.a.b.c {

    /* renamed from: a  reason: collision with root package name */
    private final String f2198a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2199b;

    /* renamed from: c  reason: collision with root package name */
    private final List f2200c;

    /* renamed from: d  reason: collision with root package name */
    private final F.e.d.a.b.c f2201d;

    /* renamed from: e  reason: collision with root package name */
    private final int f2202e;

    static final class b extends F.e.d.a.b.c.C0028a {

        /* renamed from: a  reason: collision with root package name */
        private String f2203a;

        /* renamed from: b  reason: collision with root package name */
        private String f2204b;

        /* renamed from: c  reason: collision with root package name */
        private List f2205c;

        /* renamed from: d  reason: collision with root package name */
        private F.e.d.a.b.c f2206d;

        /* renamed from: e  reason: collision with root package name */
        private int f2207e;

        /* renamed from: f  reason: collision with root package name */
        private byte f2208f;

        b() {
        }

        public F.e.d.a.b.c a() {
            String str;
            List list;
            if (this.f2208f == 1 && (str = this.f2203a) != null && (list = this.f2205c) != null) {
                return new p(str, this.f2204b, list, this.f2206d, this.f2207e);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f2203a == null) {
                sb.append(" type");
            }
            if (this.f2205c == null) {
                sb.append(" frames");
            }
            if ((1 & this.f2208f) == 0) {
                sb.append(" overflowCount");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.e.d.a.b.c.C0028a b(F.e.d.a.b.c cVar) {
            this.f2206d = cVar;
            return this;
        }

        public F.e.d.a.b.c.C0028a c(List list) {
            if (list != null) {
                this.f2205c = list;
                return this;
            }
            throw new NullPointerException("Null frames");
        }

        public F.e.d.a.b.c.C0028a d(int i5) {
            this.f2207e = i5;
            this.f2208f = (byte) (this.f2208f | 1);
            return this;
        }

        public F.e.d.a.b.c.C0028a e(String str) {
            this.f2204b = str;
            return this;
        }

        public F.e.d.a.b.c.C0028a f(String str) {
            if (str != null) {
                this.f2203a = str;
                return this;
            }
            throw new NullPointerException("Null type");
        }
    }

    public F.e.d.a.b.c b() {
        return this.f2201d;
    }

    public List c() {
        return this.f2200c;
    }

    public int d() {
        return this.f2202e;
    }

    public String e() {
        return this.f2199b;
    }

    public boolean equals(Object obj) {
        String str;
        F.e.d.a.b.c cVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.e.d.a.b.c) {
            F.e.d.a.b.c cVar2 = (F.e.d.a.b.c) obj;
            if (!this.f2198a.equals(cVar2.f()) || ((str = this.f2199b) != null ? !str.equals(cVar2.e()) : cVar2.e() != null) || !this.f2200c.equals(cVar2.c()) || ((cVar = this.f2201d) != null ? !cVar.equals(cVar2.b()) : cVar2.b() != null) || this.f2202e != cVar2.d()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public String f() {
        return this.f2198a;
    }

    public int hashCode() {
        int i5;
        int hashCode = (this.f2198a.hashCode() ^ 1000003) * 1000003;
        String str = this.f2199b;
        int i6 = 0;
        if (str == null) {
            i5 = 0;
        } else {
            i5 = str.hashCode();
        }
        int hashCode2 = (((hashCode ^ i5) * 1000003) ^ this.f2200c.hashCode()) * 1000003;
        F.e.d.a.b.c cVar = this.f2201d;
        if (cVar != null) {
            i6 = cVar.hashCode();
        }
        return ((hashCode2 ^ i6) * 1000003) ^ this.f2202e;
    }

    public String toString() {
        return "Exception{type=" + this.f2198a + ", reason=" + this.f2199b + ", frames=" + this.f2200c + ", causedBy=" + this.f2201d + ", overflowCount=" + this.f2202e + "}";
    }

    private p(String str, String str2, List list, F.e.d.a.b.c cVar, int i5) {
        this.f2198a = str;
        this.f2199b = str2;
        this.f2200c = list;
        this.f2201d = cVar;
        this.f2202e = i5;
    }
}
