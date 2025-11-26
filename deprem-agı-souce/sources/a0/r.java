package A0;

import A0.F;
import java.util.List;

final class r extends F.e.d.a.b.C0031e {

    /* renamed from: a  reason: collision with root package name */
    private final String f2216a;

    /* renamed from: b  reason: collision with root package name */
    private final int f2217b;

    /* renamed from: c  reason: collision with root package name */
    private final List f2218c;

    static final class b extends F.e.d.a.b.C0031e.C0032a {

        /* renamed from: a  reason: collision with root package name */
        private String f2219a;

        /* renamed from: b  reason: collision with root package name */
        private int f2220b;

        /* renamed from: c  reason: collision with root package name */
        private List f2221c;

        /* renamed from: d  reason: collision with root package name */
        private byte f2222d;

        b() {
        }

        public F.e.d.a.b.C0031e a() {
            String str;
            List list;
            if (this.f2222d == 1 && (str = this.f2219a) != null && (list = this.f2221c) != null) {
                return new r(str, this.f2220b, list);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f2219a == null) {
                sb.append(" name");
            }
            if ((1 & this.f2222d) == 0) {
                sb.append(" importance");
            }
            if (this.f2221c == null) {
                sb.append(" frames");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.e.d.a.b.C0031e.C0032a b(List list) {
            if (list != null) {
                this.f2221c = list;
                return this;
            }
            throw new NullPointerException("Null frames");
        }

        public F.e.d.a.b.C0031e.C0032a c(int i5) {
            this.f2220b = i5;
            this.f2222d = (byte) (this.f2222d | 1);
            return this;
        }

        public F.e.d.a.b.C0031e.C0032a d(String str) {
            if (str != null) {
                this.f2219a = str;
                return this;
            }
            throw new NullPointerException("Null name");
        }
    }

    public List b() {
        return this.f2218c;
    }

    public int c() {
        return this.f2217b;
    }

    public String d() {
        return this.f2216a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.e.d.a.b.C0031e) {
            F.e.d.a.b.C0031e eVar = (F.e.d.a.b.C0031e) obj;
            if (!this.f2216a.equals(eVar.d()) || this.f2217b != eVar.c() || !this.f2218c.equals(eVar.b())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f2216a.hashCode() ^ 1000003) * 1000003) ^ this.f2217b) * 1000003) ^ this.f2218c.hashCode();
    }

    public String toString() {
        return "Thread{name=" + this.f2216a + ", importance=" + this.f2217b + ", frames=" + this.f2218c + "}";
    }

    private r(String str, int i5, List list) {
        this.f2216a = str;
        this.f2217b = i5;
        this.f2218c = list;
    }
}
