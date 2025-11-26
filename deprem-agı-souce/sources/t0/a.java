package T0;

import T0.c;
import T0.d;

final class a extends d {

    /* renamed from: b  reason: collision with root package name */
    private final String f4354b;

    /* renamed from: c  reason: collision with root package name */
    private final c.a f4355c;

    /* renamed from: d  reason: collision with root package name */
    private final String f4356d;

    /* renamed from: e  reason: collision with root package name */
    private final String f4357e;

    /* renamed from: f  reason: collision with root package name */
    private final long f4358f;

    /* renamed from: g  reason: collision with root package name */
    private final long f4359g;

    /* renamed from: h  reason: collision with root package name */
    private final String f4360h;

    static final class b extends d.a {

        /* renamed from: a  reason: collision with root package name */
        private String f4361a;

        /* renamed from: b  reason: collision with root package name */
        private c.a f4362b;

        /* renamed from: c  reason: collision with root package name */
        private String f4363c;

        /* renamed from: d  reason: collision with root package name */
        private String f4364d;

        /* renamed from: e  reason: collision with root package name */
        private long f4365e;

        /* renamed from: f  reason: collision with root package name */
        private long f4366f;

        /* renamed from: g  reason: collision with root package name */
        private String f4367g;

        /* renamed from: h  reason: collision with root package name */
        private byte f4368h;

        public d a() {
            if (this.f4368h == 3 && this.f4362b != null) {
                return new a(this.f4361a, this.f4362b, this.f4363c, this.f4364d, this.f4365e, this.f4366f, this.f4367g);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f4362b == null) {
                sb.append(" registrationStatus");
            }
            if ((this.f4368h & 1) == 0) {
                sb.append(" expiresInSecs");
            }
            if ((this.f4368h & 2) == 0) {
                sb.append(" tokenCreationEpochInSecs");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public d.a b(String str) {
            this.f4363c = str;
            return this;
        }

        public d.a c(long j5) {
            this.f4365e = j5;
            this.f4368h = (byte) (this.f4368h | 1);
            return this;
        }

        public d.a d(String str) {
            this.f4361a = str;
            return this;
        }

        public d.a e(String str) {
            this.f4367g = str;
            return this;
        }

        public d.a f(String str) {
            this.f4364d = str;
            return this;
        }

        public d.a g(c.a aVar) {
            if (aVar != null) {
                this.f4362b = aVar;
                return this;
            }
            throw new NullPointerException("Null registrationStatus");
        }

        public d.a h(long j5) {
            this.f4366f = j5;
            this.f4368h = (byte) (this.f4368h | 2);
            return this;
        }

        b() {
        }

        private b(d dVar) {
            this.f4361a = dVar.d();
            this.f4362b = dVar.g();
            this.f4363c = dVar.b();
            this.f4364d = dVar.f();
            this.f4365e = dVar.c();
            this.f4366f = dVar.h();
            this.f4367g = dVar.e();
            this.f4368h = 3;
        }
    }

    public String b() {
        return this.f4356d;
    }

    public long c() {
        return this.f4358f;
    }

    public String d() {
        return this.f4354b;
    }

    public String e() {
        return this.f4360h;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            String str4 = this.f4354b;
            if (str4 != null ? str4.equals(dVar.d()) : dVar.d() == null) {
                if (!this.f4355c.equals(dVar.g()) || ((str = this.f4356d) != null ? !str.equals(dVar.b()) : dVar.b() != null) || ((str2 = this.f4357e) != null ? !str2.equals(dVar.f()) : dVar.f() != null) || this.f4358f != dVar.c() || this.f4359g != dVar.h() || ((str3 = this.f4360h) != null ? !str3.equals(dVar.e()) : dVar.e() != null)) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public String f() {
        return this.f4357e;
    }

    public c.a g() {
        return this.f4355c;
    }

    public long h() {
        return this.f4359g;
    }

    public int hashCode() {
        int i5;
        int i6;
        int i7;
        String str = this.f4354b;
        int i8 = 0;
        if (str == null) {
            i5 = 0;
        } else {
            i5 = str.hashCode();
        }
        int hashCode = (((i5 ^ 1000003) * 1000003) ^ this.f4355c.hashCode()) * 1000003;
        String str2 = this.f4356d;
        if (str2 == null) {
            i6 = 0;
        } else {
            i6 = str2.hashCode();
        }
        int i9 = (hashCode ^ i6) * 1000003;
        String str3 = this.f4357e;
        if (str3 == null) {
            i7 = 0;
        } else {
            i7 = str3.hashCode();
        }
        long j5 = this.f4358f;
        long j6 = this.f4359g;
        int i10 = (((((i9 ^ i7) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003) ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003;
        String str4 = this.f4360h;
        if (str4 != null) {
            i8 = str4.hashCode();
        }
        return i10 ^ i8;
    }

    public d.a n() {
        return new b(this);
    }

    public String toString() {
        return "PersistedInstallationEntry{firebaseInstallationId=" + this.f4354b + ", registrationStatus=" + this.f4355c + ", authToken=" + this.f4356d + ", refreshToken=" + this.f4357e + ", expiresInSecs=" + this.f4358f + ", tokenCreationEpochInSecs=" + this.f4359g + ", fisError=" + this.f4360h + "}";
    }

    private a(String str, c.a aVar, String str2, String str3, long j5, long j6, String str4) {
        this.f4354b = str;
        this.f4355c = aVar;
        this.f4356d = str2;
        this.f4357e = str3;
        this.f4358f = j5;
        this.f4359g = j6;
        this.f4360h = str4;
    }
}
