package A0;

import A0.F;

/* renamed from: A0.b  reason: case insensitive filesystem */
final class C0622b extends F {

    /* renamed from: b  reason: collision with root package name */
    private final String f2033b;

    /* renamed from: c  reason: collision with root package name */
    private final String f2034c;

    /* renamed from: d  reason: collision with root package name */
    private final int f2035d;

    /* renamed from: e  reason: collision with root package name */
    private final String f2036e;

    /* renamed from: f  reason: collision with root package name */
    private final String f2037f;

    /* renamed from: g  reason: collision with root package name */
    private final String f2038g;

    /* renamed from: h  reason: collision with root package name */
    private final String f2039h;

    /* renamed from: i  reason: collision with root package name */
    private final String f2040i;

    /* renamed from: j  reason: collision with root package name */
    private final String f2041j;

    /* renamed from: k  reason: collision with root package name */
    private final F.e f2042k;

    /* renamed from: l  reason: collision with root package name */
    private final F.d f2043l;

    /* renamed from: m  reason: collision with root package name */
    private final F.a f2044m;

    /* renamed from: A0.b$b  reason: collision with other inner class name */
    static final class C0040b extends F.b {

        /* renamed from: a  reason: collision with root package name */
        private String f2045a;

        /* renamed from: b  reason: collision with root package name */
        private String f2046b;

        /* renamed from: c  reason: collision with root package name */
        private int f2047c;

        /* renamed from: d  reason: collision with root package name */
        private String f2048d;

        /* renamed from: e  reason: collision with root package name */
        private String f2049e;

        /* renamed from: f  reason: collision with root package name */
        private String f2050f;

        /* renamed from: g  reason: collision with root package name */
        private String f2051g;

        /* renamed from: h  reason: collision with root package name */
        private String f2052h;

        /* renamed from: i  reason: collision with root package name */
        private String f2053i;

        /* renamed from: j  reason: collision with root package name */
        private F.e f2054j;

        /* renamed from: k  reason: collision with root package name */
        private F.d f2055k;

        /* renamed from: l  reason: collision with root package name */
        private F.a f2056l;

        /* renamed from: m  reason: collision with root package name */
        private byte f2057m;

        public F a() {
            if (this.f2057m == 1 && this.f2045a != null && this.f2046b != null && this.f2048d != null && this.f2052h != null && this.f2053i != null) {
                return new C0622b(this.f2045a, this.f2046b, this.f2047c, this.f2048d, this.f2049e, this.f2050f, this.f2051g, this.f2052h, this.f2053i, this.f2054j, this.f2055k, this.f2056l);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f2045a == null) {
                sb.append(" sdkVersion");
            }
            if (this.f2046b == null) {
                sb.append(" gmpAppId");
            }
            if ((1 & this.f2057m) == 0) {
                sb.append(" platform");
            }
            if (this.f2048d == null) {
                sb.append(" installationUuid");
            }
            if (this.f2052h == null) {
                sb.append(" buildVersion");
            }
            if (this.f2053i == null) {
                sb.append(" displayVersion");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.b b(F.a aVar) {
            this.f2056l = aVar;
            return this;
        }

        public F.b c(String str) {
            this.f2051g = str;
            return this;
        }

        public F.b d(String str) {
            if (str != null) {
                this.f2052h = str;
                return this;
            }
            throw new NullPointerException("Null buildVersion");
        }

        public F.b e(String str) {
            if (str != null) {
                this.f2053i = str;
                return this;
            }
            throw new NullPointerException("Null displayVersion");
        }

        public F.b f(String str) {
            this.f2050f = str;
            return this;
        }

        public F.b g(String str) {
            this.f2049e = str;
            return this;
        }

        public F.b h(String str) {
            if (str != null) {
                this.f2046b = str;
                return this;
            }
            throw new NullPointerException("Null gmpAppId");
        }

        public F.b i(String str) {
            if (str != null) {
                this.f2048d = str;
                return this;
            }
            throw new NullPointerException("Null installationUuid");
        }

        public F.b j(F.d dVar) {
            this.f2055k = dVar;
            return this;
        }

        public F.b k(int i5) {
            this.f2047c = i5;
            this.f2057m = (byte) (this.f2057m | 1);
            return this;
        }

        public F.b l(String str) {
            if (str != null) {
                this.f2045a = str;
                return this;
            }
            throw new NullPointerException("Null sdkVersion");
        }

        public F.b m(F.e eVar) {
            this.f2054j = eVar;
            return this;
        }

        C0040b() {
        }

        private C0040b(F f5) {
            this.f2045a = f5.m();
            this.f2046b = f5.i();
            this.f2047c = f5.l();
            this.f2048d = f5.j();
            this.f2049e = f5.h();
            this.f2050f = f5.g();
            this.f2051g = f5.d();
            this.f2052h = f5.e();
            this.f2053i = f5.f();
            this.f2054j = f5.n();
            this.f2055k = f5.k();
            this.f2056l = f5.c();
            this.f2057m = 1;
        }
    }

    public F.a c() {
        return this.f2044m;
    }

    public String d() {
        return this.f2039h;
    }

    public String e() {
        return this.f2040i;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        F.e eVar;
        F.d dVar;
        F.a aVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof F) {
            F f5 = (F) obj;
            if (!this.f2033b.equals(f5.m()) || !this.f2034c.equals(f5.i()) || this.f2035d != f5.l() || !this.f2036e.equals(f5.j()) || ((str = this.f2037f) != null ? !str.equals(f5.h()) : f5.h() != null) || ((str2 = this.f2038g) != null ? !str2.equals(f5.g()) : f5.g() != null) || ((str3 = this.f2039h) != null ? !str3.equals(f5.d()) : f5.d() != null) || !this.f2040i.equals(f5.e()) || !this.f2041j.equals(f5.f()) || ((eVar = this.f2042k) != null ? !eVar.equals(f5.n()) : f5.n() != null) || ((dVar = this.f2043l) != null ? !dVar.equals(f5.k()) : f5.k() != null) || ((aVar = this.f2044m) != null ? !aVar.equals(f5.c()) : f5.c() != null)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public String f() {
        return this.f2041j;
    }

    public String g() {
        return this.f2038g;
    }

    public String h() {
        return this.f2037f;
    }

    public int hashCode() {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int hashCode = (((((((this.f2033b.hashCode() ^ 1000003) * 1000003) ^ this.f2034c.hashCode()) * 1000003) ^ this.f2035d) * 1000003) ^ this.f2036e.hashCode()) * 1000003;
        String str = this.f2037f;
        int i10 = 0;
        if (str == null) {
            i5 = 0;
        } else {
            i5 = str.hashCode();
        }
        int i11 = (hashCode ^ i5) * 1000003;
        String str2 = this.f2038g;
        if (str2 == null) {
            i6 = 0;
        } else {
            i6 = str2.hashCode();
        }
        int i12 = (i11 ^ i6) * 1000003;
        String str3 = this.f2039h;
        if (str3 == null) {
            i7 = 0;
        } else {
            i7 = str3.hashCode();
        }
        int hashCode2 = (((((i12 ^ i7) * 1000003) ^ this.f2040i.hashCode()) * 1000003) ^ this.f2041j.hashCode()) * 1000003;
        F.e eVar = this.f2042k;
        if (eVar == null) {
            i8 = 0;
        } else {
            i8 = eVar.hashCode();
        }
        int i13 = (hashCode2 ^ i8) * 1000003;
        F.d dVar = this.f2043l;
        if (dVar == null) {
            i9 = 0;
        } else {
            i9 = dVar.hashCode();
        }
        int i14 = (i13 ^ i9) * 1000003;
        F.a aVar = this.f2044m;
        if (aVar != null) {
            i10 = aVar.hashCode();
        }
        return i14 ^ i10;
    }

    public String i() {
        return this.f2034c;
    }

    public String j() {
        return this.f2036e;
    }

    public F.d k() {
        return this.f2043l;
    }

    public int l() {
        return this.f2035d;
    }

    public String m() {
        return this.f2033b;
    }

    public F.e n() {
        return this.f2042k;
    }

    /* access modifiers changed from: protected */
    public F.b o() {
        return new C0040b(this);
    }

    public String toString() {
        return "CrashlyticsReport{sdkVersion=" + this.f2033b + ", gmpAppId=" + this.f2034c + ", platform=" + this.f2035d + ", installationUuid=" + this.f2036e + ", firebaseInstallationId=" + this.f2037f + ", firebaseAuthenticationToken=" + this.f2038g + ", appQualitySessionId=" + this.f2039h + ", buildVersion=" + this.f2040i + ", displayVersion=" + this.f2041j + ", session=" + this.f2042k + ", ndkPayload=" + this.f2043l + ", appExitInfo=" + this.f2044m + "}";
    }

    private C0622b(String str, String str2, int i5, String str3, String str4, String str5, String str6, String str7, String str8, F.e eVar, F.d dVar, F.a aVar) {
        this.f2033b = str;
        this.f2034c = str2;
        this.f2035d = i5;
        this.f2036e = str3;
        this.f2037f = str4;
        this.f2038g = str5;
        this.f2039h = str6;
        this.f2040i = str7;
        this.f2041j = str8;
        this.f2042k = eVar;
        this.f2043l = dVar;
        this.f2044m = aVar;
    }
}
