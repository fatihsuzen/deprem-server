package A0;

import A0.F;

final class i extends F.e.a {

    /* renamed from: a  reason: collision with root package name */
    private final String f2120a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2121b;

    /* renamed from: c  reason: collision with root package name */
    private final String f2122c;

    /* renamed from: d  reason: collision with root package name */
    private final String f2123d;

    /* renamed from: e  reason: collision with root package name */
    private final String f2124e;

    /* renamed from: f  reason: collision with root package name */
    private final String f2125f;

    static final class b extends F.e.a.C0023a {

        /* renamed from: a  reason: collision with root package name */
        private String f2126a;

        /* renamed from: b  reason: collision with root package name */
        private String f2127b;

        /* renamed from: c  reason: collision with root package name */
        private String f2128c;

        /* renamed from: d  reason: collision with root package name */
        private String f2129d;

        /* renamed from: e  reason: collision with root package name */
        private String f2130e;

        /* renamed from: f  reason: collision with root package name */
        private String f2131f;

        b() {
        }

        public F.e.a a() {
            String str;
            String str2 = this.f2126a;
            if (str2 != null && (str = this.f2127b) != null) {
                return new i(str2, str, this.f2128c, (F.e.a.b) null, this.f2129d, this.f2130e, this.f2131f);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f2126a == null) {
                sb.append(" identifier");
            }
            if (this.f2127b == null) {
                sb.append(" version");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.e.a.C0023a b(String str) {
            this.f2130e = str;
            return this;
        }

        public F.e.a.C0023a c(String str) {
            this.f2131f = str;
            return this;
        }

        public F.e.a.C0023a d(String str) {
            this.f2128c = str;
            return this;
        }

        public F.e.a.C0023a e(String str) {
            if (str != null) {
                this.f2126a = str;
                return this;
            }
            throw new NullPointerException("Null identifier");
        }

        public F.e.a.C0023a f(String str) {
            this.f2129d = str;
            return this;
        }

        public F.e.a.C0023a g(String str) {
            if (str != null) {
                this.f2127b = str;
                return this;
            }
            throw new NullPointerException("Null version");
        }
    }

    public String b() {
        return this.f2124e;
    }

    public String c() {
        return this.f2125f;
    }

    public String d() {
        return this.f2122c;
    }

    public String e() {
        return this.f2120a;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.e.a) {
            F.e.a aVar = (F.e.a) obj;
            if (this.f2120a.equals(aVar.e()) && this.f2121b.equals(aVar.h()) && ((str = this.f2122c) != null ? str.equals(aVar.d()) : aVar.d() == null)) {
                aVar.g();
                String str2 = this.f2123d;
                if (str2 != null ? str2.equals(aVar.f()) : aVar.f() == null) {
                    String str3 = this.f2124e;
                    if (str3 != null ? str3.equals(aVar.b()) : aVar.b() == null) {
                        String str4 = this.f2125f;
                        if (str4 != null ? !str4.equals(aVar.c()) : aVar.c() != null) {
                            return false;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String f() {
        return this.f2123d;
    }

    public F.e.a.b g() {
        return null;
    }

    public String h() {
        return this.f2121b;
    }

    public int hashCode() {
        int i5;
        int i6;
        int i7;
        int hashCode = (((this.f2120a.hashCode() ^ 1000003) * 1000003) ^ this.f2121b.hashCode()) * 1000003;
        String str = this.f2122c;
        int i8 = 0;
        if (str == null) {
            i5 = 0;
        } else {
            i5 = str.hashCode();
        }
        int i9 = (hashCode ^ i5) * -721379959;
        String str2 = this.f2123d;
        if (str2 == null) {
            i6 = 0;
        } else {
            i6 = str2.hashCode();
        }
        int i10 = (i9 ^ i6) * 1000003;
        String str3 = this.f2124e;
        if (str3 == null) {
            i7 = 0;
        } else {
            i7 = str3.hashCode();
        }
        int i11 = (i10 ^ i7) * 1000003;
        String str4 = this.f2125f;
        if (str4 != null) {
            i8 = str4.hashCode();
        }
        return i11 ^ i8;
    }

    public String toString() {
        return "Application{identifier=" + this.f2120a + ", version=" + this.f2121b + ", displayVersion=" + this.f2122c + ", organization=" + null + ", installationUuid=" + this.f2123d + ", developmentPlatform=" + this.f2124e + ", developmentPlatformVersion=" + this.f2125f + "}";
    }

    private i(String str, String str2, String str3, F.e.a.b bVar, String str4, String str5, String str6) {
        this.f2120a = str;
        this.f2121b = str2;
        this.f2122c = str3;
        this.f2123d = str4;
        this.f2124e = str5;
        this.f2125f = str6;
    }
}
