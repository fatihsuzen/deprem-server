package U0;

import U0.d;

final class a extends d {

    /* renamed from: a  reason: collision with root package name */
    private final String f4382a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4383b;

    /* renamed from: c  reason: collision with root package name */
    private final String f4384c;

    /* renamed from: d  reason: collision with root package name */
    private final f f4385d;

    /* renamed from: e  reason: collision with root package name */
    private final d.b f4386e;

    static final class b extends d.a {

        /* renamed from: a  reason: collision with root package name */
        private String f4387a;

        /* renamed from: b  reason: collision with root package name */
        private String f4388b;

        /* renamed from: c  reason: collision with root package name */
        private String f4389c;

        /* renamed from: d  reason: collision with root package name */
        private f f4390d;

        /* renamed from: e  reason: collision with root package name */
        private d.b f4391e;

        b() {
        }

        public d a() {
            return new a(this.f4387a, this.f4388b, this.f4389c, this.f4390d, this.f4391e);
        }

        public d.a b(f fVar) {
            this.f4390d = fVar;
            return this;
        }

        public d.a c(String str) {
            this.f4388b = str;
            return this;
        }

        public d.a d(String str) {
            this.f4389c = str;
            return this;
        }

        public d.a e(d.b bVar) {
            this.f4391e = bVar;
            return this;
        }

        public d.a f(String str) {
            this.f4387a = str;
            return this;
        }
    }

    public f b() {
        return this.f4385d;
    }

    public String c() {
        return this.f4383b;
    }

    public String d() {
        return this.f4384c;
    }

    public d.b e() {
        return this.f4386e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            String str = this.f4382a;
            if (str != null ? str.equals(dVar.f()) : dVar.f() == null) {
                String str2 = this.f4383b;
                if (str2 != null ? str2.equals(dVar.c()) : dVar.c() == null) {
                    String str3 = this.f4384c;
                    if (str3 != null ? str3.equals(dVar.d()) : dVar.d() == null) {
                        f fVar = this.f4385d;
                        if (fVar != null ? fVar.equals(dVar.b()) : dVar.b() == null) {
                            d.b bVar = this.f4386e;
                            if (bVar != null ? !bVar.equals(dVar.e()) : dVar.e() != null) {
                                return false;
                            }
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public String f() {
        return this.f4382a;
    }

    public int hashCode() {
        int i5;
        int i6;
        int i7;
        int i8;
        String str = this.f4382a;
        int i9 = 0;
        if (str == null) {
            i5 = 0;
        } else {
            i5 = str.hashCode();
        }
        int i10 = (i5 ^ 1000003) * 1000003;
        String str2 = this.f4383b;
        if (str2 == null) {
            i6 = 0;
        } else {
            i6 = str2.hashCode();
        }
        int i11 = (i10 ^ i6) * 1000003;
        String str3 = this.f4384c;
        if (str3 == null) {
            i7 = 0;
        } else {
            i7 = str3.hashCode();
        }
        int i12 = (i11 ^ i7) * 1000003;
        f fVar = this.f4385d;
        if (fVar == null) {
            i8 = 0;
        } else {
            i8 = fVar.hashCode();
        }
        int i13 = (i12 ^ i8) * 1000003;
        d.b bVar = this.f4386e;
        if (bVar != null) {
            i9 = bVar.hashCode();
        }
        return i13 ^ i9;
    }

    public String toString() {
        return "InstallationResponse{uri=" + this.f4382a + ", fid=" + this.f4383b + ", refreshToken=" + this.f4384c + ", authToken=" + this.f4385d + ", responseCode=" + this.f4386e + "}";
    }

    private a(String str, String str2, String str3, f fVar, d.b bVar) {
        this.f4382a = str;
        this.f4383b = str2;
        this.f4384c = str3;
        this.f4385d = fVar;
        this.f4386e = bVar;
    }
}
