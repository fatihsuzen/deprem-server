package A0;

import A0.F;
import java.util.List;

/* renamed from: A0.f  reason: case insensitive filesystem */
final class C0626f extends F.d {

    /* renamed from: a  reason: collision with root package name */
    private final List f2087a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2088b;

    /* renamed from: A0.f$b */
    static final class b extends F.d.a {

        /* renamed from: a  reason: collision with root package name */
        private List f2089a;

        /* renamed from: b  reason: collision with root package name */
        private String f2090b;

        b() {
        }

        public F.d a() {
            List list = this.f2089a;
            if (list != null) {
                return new C0626f(list, this.f2090b);
            }
            throw new IllegalStateException("Missing required properties:" + " files");
        }

        public F.d.a b(List list) {
            if (list != null) {
                this.f2089a = list;
                return this;
            }
            throw new NullPointerException("Null files");
        }

        public F.d.a c(String str) {
            this.f2090b = str;
            return this;
        }
    }

    public List b() {
        return this.f2087a;
    }

    public String c() {
        return this.f2088b;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.d) {
            F.d dVar = (F.d) obj;
            if (!this.f2087a.equals(dVar.b()) || ((str = this.f2088b) != null ? !str.equals(dVar.c()) : dVar.c() != null)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i5;
        int hashCode = (this.f2087a.hashCode() ^ 1000003) * 1000003;
        String str = this.f2088b;
        if (str == null) {
            i5 = 0;
        } else {
            i5 = str.hashCode();
        }
        return hashCode ^ i5;
    }

    public String toString() {
        return "FilesPayload{files=" + this.f2087a + ", orgId=" + this.f2088b + "}";
    }

    private C0626f(List list, String str) {
        this.f2087a = list;
        this.f2088b = str;
    }
}
