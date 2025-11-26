package A0;

import A0.F;

final class z extends F.e.C0038e {

    /* renamed from: a  reason: collision with root package name */
    private final int f2273a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2274b;

    /* renamed from: c  reason: collision with root package name */
    private final String f2275c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f2276d;

    static final class b extends F.e.C0038e.a {

        /* renamed from: a  reason: collision with root package name */
        private int f2277a;

        /* renamed from: b  reason: collision with root package name */
        private String f2278b;

        /* renamed from: c  reason: collision with root package name */
        private String f2279c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f2280d;

        /* renamed from: e  reason: collision with root package name */
        private byte f2281e;

        b() {
        }

        public F.e.C0038e a() {
            String str;
            String str2;
            if (this.f2281e == 3 && (str = this.f2278b) != null && (str2 = this.f2279c) != null) {
                return new z(this.f2277a, str, str2, this.f2280d);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f2281e & 1) == 0) {
                sb.append(" platform");
            }
            if (this.f2278b == null) {
                sb.append(" version");
            }
            if (this.f2279c == null) {
                sb.append(" buildVersion");
            }
            if ((this.f2281e & 2) == 0) {
                sb.append(" jailbroken");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.e.C0038e.a b(String str) {
            if (str != null) {
                this.f2279c = str;
                return this;
            }
            throw new NullPointerException("Null buildVersion");
        }

        public F.e.C0038e.a c(boolean z4) {
            this.f2280d = z4;
            this.f2281e = (byte) (this.f2281e | 2);
            return this;
        }

        public F.e.C0038e.a d(int i5) {
            this.f2277a = i5;
            this.f2281e = (byte) (this.f2281e | 1);
            return this;
        }

        public F.e.C0038e.a e(String str) {
            if (str != null) {
                this.f2278b = str;
                return this;
            }
            throw new NullPointerException("Null version");
        }
    }

    public String b() {
        return this.f2275c;
    }

    public int c() {
        return this.f2273a;
    }

    public String d() {
        return this.f2274b;
    }

    public boolean e() {
        return this.f2276d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.e.C0038e) {
            F.e.C0038e eVar = (F.e.C0038e) obj;
            if (this.f2273a != eVar.c() || !this.f2274b.equals(eVar.d()) || !this.f2275c.equals(eVar.b()) || this.f2276d != eVar.e()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i5;
        int hashCode = (((((this.f2273a ^ 1000003) * 1000003) ^ this.f2274b.hashCode()) * 1000003) ^ this.f2275c.hashCode()) * 1000003;
        if (this.f2276d) {
            i5 = 1231;
        } else {
            i5 = 1237;
        }
        return hashCode ^ i5;
    }

    public String toString() {
        return "OperatingSystem{platform=" + this.f2273a + ", version=" + this.f2274b + ", buildVersion=" + this.f2275c + ", jailbroken=" + this.f2276d + "}";
    }

    private z(int i5, String str, String str2, boolean z4) {
        this.f2273a = i5;
        this.f2274b = str;
        this.f2275c = str2;
        this.f2276d = z4;
    }
}
