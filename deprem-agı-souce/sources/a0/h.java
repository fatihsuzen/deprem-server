package A0;

import A0.F;
import java.util.List;

final class h extends F.e {

    /* renamed from: a  reason: collision with root package name */
    private final String f2095a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2096b;

    /* renamed from: c  reason: collision with root package name */
    private final String f2097c;

    /* renamed from: d  reason: collision with root package name */
    private final long f2098d;

    /* renamed from: e  reason: collision with root package name */
    private final Long f2099e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f2100f;

    /* renamed from: g  reason: collision with root package name */
    private final F.e.a f2101g;

    /* renamed from: h  reason: collision with root package name */
    private final F.e.f f2102h;

    /* renamed from: i  reason: collision with root package name */
    private final F.e.C0038e f2103i;

    /* renamed from: j  reason: collision with root package name */
    private final F.e.c f2104j;

    /* renamed from: k  reason: collision with root package name */
    private final List f2105k;

    /* renamed from: l  reason: collision with root package name */
    private final int f2106l;

    static final class b extends F.e.b {

        /* renamed from: a  reason: collision with root package name */
        private String f2107a;

        /* renamed from: b  reason: collision with root package name */
        private String f2108b;

        /* renamed from: c  reason: collision with root package name */
        private String f2109c;

        /* renamed from: d  reason: collision with root package name */
        private long f2110d;

        /* renamed from: e  reason: collision with root package name */
        private Long f2111e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f2112f;

        /* renamed from: g  reason: collision with root package name */
        private F.e.a f2113g;

        /* renamed from: h  reason: collision with root package name */
        private F.e.f f2114h;

        /* renamed from: i  reason: collision with root package name */
        private F.e.C0038e f2115i;

        /* renamed from: j  reason: collision with root package name */
        private F.e.c f2116j;

        /* renamed from: k  reason: collision with root package name */
        private List f2117k;

        /* renamed from: l  reason: collision with root package name */
        private int f2118l;

        /* renamed from: m  reason: collision with root package name */
        private byte f2119m;

        public F.e a() {
            String str;
            String str2;
            F.e.a aVar;
            if (this.f2119m == 7 && (str = this.f2107a) != null && (str2 = this.f2108b) != null && (aVar = this.f2113g) != null) {
                return new h(str, str2, this.f2109c, this.f2110d, this.f2111e, this.f2112f, aVar, this.f2114h, this.f2115i, this.f2116j, this.f2117k, this.f2118l);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f2107a == null) {
                sb.append(" generator");
            }
            if (this.f2108b == null) {
                sb.append(" identifier");
            }
            if ((this.f2119m & 1) == 0) {
                sb.append(" startedAt");
            }
            if ((this.f2119m & 2) == 0) {
                sb.append(" crashed");
            }
            if (this.f2113g == null) {
                sb.append(" app");
            }
            if ((this.f2119m & 4) == 0) {
                sb.append(" generatorType");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.e.b b(F.e.a aVar) {
            if (aVar != null) {
                this.f2113g = aVar;
                return this;
            }
            throw new NullPointerException("Null app");
        }

        public F.e.b c(String str) {
            this.f2109c = str;
            return this;
        }

        public F.e.b d(boolean z4) {
            this.f2112f = z4;
            this.f2119m = (byte) (this.f2119m | 2);
            return this;
        }

        public F.e.b e(F.e.c cVar) {
            this.f2116j = cVar;
            return this;
        }

        public F.e.b f(Long l5) {
            this.f2111e = l5;
            return this;
        }

        public F.e.b g(List list) {
            this.f2117k = list;
            return this;
        }

        public F.e.b h(String str) {
            if (str != null) {
                this.f2107a = str;
                return this;
            }
            throw new NullPointerException("Null generator");
        }

        public F.e.b i(int i5) {
            this.f2118l = i5;
            this.f2119m = (byte) (this.f2119m | 4);
            return this;
        }

        public F.e.b j(String str) {
            if (str != null) {
                this.f2108b = str;
                return this;
            }
            throw new NullPointerException("Null identifier");
        }

        public F.e.b l(F.e.C0038e eVar) {
            this.f2115i = eVar;
            return this;
        }

        public F.e.b m(long j5) {
            this.f2110d = j5;
            this.f2119m = (byte) (this.f2119m | 1);
            return this;
        }

        public F.e.b n(F.e.f fVar) {
            this.f2114h = fVar;
            return this;
        }

        b() {
        }

        private b(F.e eVar) {
            this.f2107a = eVar.g();
            this.f2108b = eVar.i();
            this.f2109c = eVar.c();
            this.f2110d = eVar.l();
            this.f2111e = eVar.e();
            this.f2112f = eVar.n();
            this.f2113g = eVar.b();
            this.f2114h = eVar.m();
            this.f2115i = eVar.k();
            this.f2116j = eVar.d();
            this.f2117k = eVar.f();
            this.f2118l = eVar.h();
            this.f2119m = 7;
        }
    }

    public F.e.a b() {
        return this.f2101g;
    }

    public String c() {
        return this.f2097c;
    }

    public F.e.c d() {
        return this.f2104j;
    }

    public Long e() {
        return this.f2099e;
    }

    public boolean equals(Object obj) {
        String str;
        Long l5;
        F.e.f fVar;
        F.e.C0038e eVar;
        F.e.c cVar;
        List list;
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.e) {
            F.e eVar2 = (F.e) obj;
            if (!this.f2095a.equals(eVar2.g()) || !this.f2096b.equals(eVar2.i()) || ((str = this.f2097c) != null ? !str.equals(eVar2.c()) : eVar2.c() != null) || this.f2098d != eVar2.l() || ((l5 = this.f2099e) != null ? !l5.equals(eVar2.e()) : eVar2.e() != null) || this.f2100f != eVar2.n() || !this.f2101g.equals(eVar2.b()) || ((fVar = this.f2102h) != null ? !fVar.equals(eVar2.m()) : eVar2.m() != null) || ((eVar = this.f2103i) != null ? !eVar.equals(eVar2.k()) : eVar2.k() != null) || ((cVar = this.f2104j) != null ? !cVar.equals(eVar2.d()) : eVar2.d() != null) || ((list = this.f2105k) != null ? !list.equals(eVar2.f()) : eVar2.f() != null) || this.f2106l != eVar2.h()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public List f() {
        return this.f2105k;
    }

    public String g() {
        return this.f2095a;
    }

    public int h() {
        return this.f2106l;
    }

    public int hashCode() {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int hashCode = (((this.f2095a.hashCode() ^ 1000003) * 1000003) ^ this.f2096b.hashCode()) * 1000003;
        String str = this.f2097c;
        int i11 = 0;
        if (str == null) {
            i5 = 0;
        } else {
            i5 = str.hashCode();
        }
        long j5 = this.f2098d;
        int i12 = (((hashCode ^ i5) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003;
        Long l5 = this.f2099e;
        if (l5 == null) {
            i6 = 0;
        } else {
            i6 = l5.hashCode();
        }
        int i13 = (i12 ^ i6) * 1000003;
        if (this.f2100f) {
            i7 = 1231;
        } else {
            i7 = 1237;
        }
        int hashCode2 = (((i13 ^ i7) * 1000003) ^ this.f2101g.hashCode()) * 1000003;
        F.e.f fVar = this.f2102h;
        if (fVar == null) {
            i8 = 0;
        } else {
            i8 = fVar.hashCode();
        }
        int i14 = (hashCode2 ^ i8) * 1000003;
        F.e.C0038e eVar = this.f2103i;
        if (eVar == null) {
            i9 = 0;
        } else {
            i9 = eVar.hashCode();
        }
        int i15 = (i14 ^ i9) * 1000003;
        F.e.c cVar = this.f2104j;
        if (cVar == null) {
            i10 = 0;
        } else {
            i10 = cVar.hashCode();
        }
        int i16 = (i15 ^ i10) * 1000003;
        List list = this.f2105k;
        if (list != null) {
            i11 = list.hashCode();
        }
        return ((i16 ^ i11) * 1000003) ^ this.f2106l;
    }

    public String i() {
        return this.f2096b;
    }

    public F.e.C0038e k() {
        return this.f2103i;
    }

    public long l() {
        return this.f2098d;
    }

    public F.e.f m() {
        return this.f2102h;
    }

    public boolean n() {
        return this.f2100f;
    }

    public F.e.b o() {
        return new b(this);
    }

    public String toString() {
        return "Session{generator=" + this.f2095a + ", identifier=" + this.f2096b + ", appQualitySessionId=" + this.f2097c + ", startedAt=" + this.f2098d + ", endedAt=" + this.f2099e + ", crashed=" + this.f2100f + ", app=" + this.f2101g + ", user=" + this.f2102h + ", os=" + this.f2103i + ", device=" + this.f2104j + ", events=" + this.f2105k + ", generatorType=" + this.f2106l + "}";
    }

    private h(String str, String str2, String str3, long j5, Long l5, boolean z4, F.e.a aVar, F.e.f fVar, F.e.C0038e eVar, F.e.c cVar, List list, int i5) {
        this.f2095a = str;
        this.f2096b = str2;
        this.f2097c = str3;
        this.f2098d = j5;
        this.f2099e = l5;
        this.f2100f = z4;
        this.f2101g = aVar;
        this.f2102h = fVar;
        this.f2103i = eVar;
        this.f2104j = cVar;
        this.f2105k = list;
        this.f2106l = i5;
    }
}
