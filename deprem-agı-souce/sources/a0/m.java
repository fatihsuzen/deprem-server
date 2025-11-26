package A0;

import A0.F;
import java.util.List;

final class m extends F.e.d.a {

    /* renamed from: a  reason: collision with root package name */
    private final F.e.d.a.b f2164a;

    /* renamed from: b  reason: collision with root package name */
    private final List f2165b;

    /* renamed from: c  reason: collision with root package name */
    private final List f2166c;

    /* renamed from: d  reason: collision with root package name */
    private final Boolean f2167d;

    /* renamed from: e  reason: collision with root package name */
    private final F.e.d.a.c f2168e;

    /* renamed from: f  reason: collision with root package name */
    private final List f2169f;

    /* renamed from: g  reason: collision with root package name */
    private final int f2170g;

    static final class b extends F.e.d.a.C0024a {

        /* renamed from: a  reason: collision with root package name */
        private F.e.d.a.b f2171a;

        /* renamed from: b  reason: collision with root package name */
        private List f2172b;

        /* renamed from: c  reason: collision with root package name */
        private List f2173c;

        /* renamed from: d  reason: collision with root package name */
        private Boolean f2174d;

        /* renamed from: e  reason: collision with root package name */
        private F.e.d.a.c f2175e;

        /* renamed from: f  reason: collision with root package name */
        private List f2176f;

        /* renamed from: g  reason: collision with root package name */
        private int f2177g;

        /* renamed from: h  reason: collision with root package name */
        private byte f2178h;

        public F.e.d.a a() {
            F.e.d.a.b bVar;
            if (this.f2178h == 1 && (bVar = this.f2171a) != null) {
                return new m(bVar, this.f2172b, this.f2173c, this.f2174d, this.f2175e, this.f2176f, this.f2177g);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f2171a == null) {
                sb.append(" execution");
            }
            if ((1 & this.f2178h) == 0) {
                sb.append(" uiOrientation");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.e.d.a.C0024a b(List list) {
            this.f2176f = list;
            return this;
        }

        public F.e.d.a.C0024a c(Boolean bool) {
            this.f2174d = bool;
            return this;
        }

        public F.e.d.a.C0024a d(F.e.d.a.c cVar) {
            this.f2175e = cVar;
            return this;
        }

        public F.e.d.a.C0024a e(List list) {
            this.f2172b = list;
            return this;
        }

        public F.e.d.a.C0024a f(F.e.d.a.b bVar) {
            if (bVar != null) {
                this.f2171a = bVar;
                return this;
            }
            throw new NullPointerException("Null execution");
        }

        public F.e.d.a.C0024a g(List list) {
            this.f2173c = list;
            return this;
        }

        public F.e.d.a.C0024a h(int i5) {
            this.f2177g = i5;
            this.f2178h = (byte) (this.f2178h | 1);
            return this;
        }

        b() {
        }

        private b(F.e.d.a aVar) {
            this.f2171a = aVar.f();
            this.f2172b = aVar.e();
            this.f2173c = aVar.g();
            this.f2174d = aVar.c();
            this.f2175e = aVar.d();
            this.f2176f = aVar.b();
            this.f2177g = aVar.h();
            this.f2178h = 1;
        }
    }

    public List b() {
        return this.f2169f;
    }

    public Boolean c() {
        return this.f2167d;
    }

    public F.e.d.a.c d() {
        return this.f2168e;
    }

    public List e() {
        return this.f2165b;
    }

    public boolean equals(Object obj) {
        List list;
        List list2;
        Boolean bool;
        F.e.d.a.c cVar;
        List list3;
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.e.d.a) {
            F.e.d.a aVar = (F.e.d.a) obj;
            if (!this.f2164a.equals(aVar.f()) || ((list = this.f2165b) != null ? !list.equals(aVar.e()) : aVar.e() != null) || ((list2 = this.f2166c) != null ? !list2.equals(aVar.g()) : aVar.g() != null) || ((bool = this.f2167d) != null ? !bool.equals(aVar.c()) : aVar.c() != null) || ((cVar = this.f2168e) != null ? !cVar.equals(aVar.d()) : aVar.d() != null) || ((list3 = this.f2169f) != null ? !list3.equals(aVar.b()) : aVar.b() != null) || this.f2170g != aVar.h()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public F.e.d.a.b f() {
        return this.f2164a;
    }

    public List g() {
        return this.f2166c;
    }

    public int h() {
        return this.f2170g;
    }

    public int hashCode() {
        int i5;
        int i6;
        int i7;
        int i8;
        int hashCode = (this.f2164a.hashCode() ^ 1000003) * 1000003;
        List list = this.f2165b;
        int i9 = 0;
        if (list == null) {
            i5 = 0;
        } else {
            i5 = list.hashCode();
        }
        int i10 = (hashCode ^ i5) * 1000003;
        List list2 = this.f2166c;
        if (list2 == null) {
            i6 = 0;
        } else {
            i6 = list2.hashCode();
        }
        int i11 = (i10 ^ i6) * 1000003;
        Boolean bool = this.f2167d;
        if (bool == null) {
            i7 = 0;
        } else {
            i7 = bool.hashCode();
        }
        int i12 = (i11 ^ i7) * 1000003;
        F.e.d.a.c cVar = this.f2168e;
        if (cVar == null) {
            i8 = 0;
        } else {
            i8 = cVar.hashCode();
        }
        int i13 = (i12 ^ i8) * 1000003;
        List list3 = this.f2169f;
        if (list3 != null) {
            i9 = list3.hashCode();
        }
        return ((i13 ^ i9) * 1000003) ^ this.f2170g;
    }

    public F.e.d.a.C0024a i() {
        return new b(this);
    }

    public String toString() {
        return "Application{execution=" + this.f2164a + ", customAttributes=" + this.f2165b + ", internalKeys=" + this.f2166c + ", background=" + this.f2167d + ", currentProcessDetails=" + this.f2168e + ", appProcessDetails=" + this.f2169f + ", uiOrientation=" + this.f2170g + "}";
    }

    private m(F.e.d.a.b bVar, List list, List list2, Boolean bool, F.e.d.a.c cVar, List list3, int i5) {
        this.f2164a = bVar;
        this.f2165b = list;
        this.f2166c = list2;
        this.f2167d = bool;
        this.f2168e = cVar;
        this.f2169f = list3;
        this.f2170g = i5;
    }
}
