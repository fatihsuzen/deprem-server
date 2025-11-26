package A0;

import A0.F;

final class k extends F.e.c {

    /* renamed from: a  reason: collision with root package name */
    private final int f2132a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2133b;

    /* renamed from: c  reason: collision with root package name */
    private final int f2134c;

    /* renamed from: d  reason: collision with root package name */
    private final long f2135d;

    /* renamed from: e  reason: collision with root package name */
    private final long f2136e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f2137f;

    /* renamed from: g  reason: collision with root package name */
    private final int f2138g;

    /* renamed from: h  reason: collision with root package name */
    private final String f2139h;

    /* renamed from: i  reason: collision with root package name */
    private final String f2140i;

    static final class b extends F.e.c.a {

        /* renamed from: a  reason: collision with root package name */
        private int f2141a;

        /* renamed from: b  reason: collision with root package name */
        private String f2142b;

        /* renamed from: c  reason: collision with root package name */
        private int f2143c;

        /* renamed from: d  reason: collision with root package name */
        private long f2144d;

        /* renamed from: e  reason: collision with root package name */
        private long f2145e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f2146f;

        /* renamed from: g  reason: collision with root package name */
        private int f2147g;

        /* renamed from: h  reason: collision with root package name */
        private String f2148h;

        /* renamed from: i  reason: collision with root package name */
        private String f2149i;

        /* renamed from: j  reason: collision with root package name */
        private byte f2150j;

        b() {
        }

        public F.e.c a() {
            String str;
            String str2;
            String str3;
            if (this.f2150j == 63 && (str = this.f2142b) != null && (str2 = this.f2148h) != null && (str3 = this.f2149i) != null) {
                return new k(this.f2141a, str, this.f2143c, this.f2144d, this.f2145e, this.f2146f, this.f2147g, str2, str3);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f2150j & 1) == 0) {
                sb.append(" arch");
            }
            if (this.f2142b == null) {
                sb.append(" model");
            }
            if ((this.f2150j & 2) == 0) {
                sb.append(" cores");
            }
            if ((this.f2150j & 4) == 0) {
                sb.append(" ram");
            }
            if ((this.f2150j & 8) == 0) {
                sb.append(" diskSpace");
            }
            if ((this.f2150j & 16) == 0) {
                sb.append(" simulator");
            }
            if ((this.f2150j & 32) == 0) {
                sb.append(" state");
            }
            if (this.f2148h == null) {
                sb.append(" manufacturer");
            }
            if (this.f2149i == null) {
                sb.append(" modelClass");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.e.c.a b(int i5) {
            this.f2141a = i5;
            this.f2150j = (byte) (this.f2150j | 1);
            return this;
        }

        public F.e.c.a c(int i5) {
            this.f2143c = i5;
            this.f2150j = (byte) (this.f2150j | 2);
            return this;
        }

        public F.e.c.a d(long j5) {
            this.f2145e = j5;
            this.f2150j = (byte) (this.f2150j | 8);
            return this;
        }

        public F.e.c.a e(String str) {
            if (str != null) {
                this.f2148h = str;
                return this;
            }
            throw new NullPointerException("Null manufacturer");
        }

        public F.e.c.a f(String str) {
            if (str != null) {
                this.f2142b = str;
                return this;
            }
            throw new NullPointerException("Null model");
        }

        public F.e.c.a g(String str) {
            if (str != null) {
                this.f2149i = str;
                return this;
            }
            throw new NullPointerException("Null modelClass");
        }

        public F.e.c.a h(long j5) {
            this.f2144d = j5;
            this.f2150j = (byte) (this.f2150j | 4);
            return this;
        }

        public F.e.c.a i(boolean z4) {
            this.f2146f = z4;
            this.f2150j = (byte) (this.f2150j | 16);
            return this;
        }

        public F.e.c.a j(int i5) {
            this.f2147g = i5;
            this.f2150j = (byte) (this.f2150j | 32);
            return this;
        }
    }

    public int b() {
        return this.f2132a;
    }

    public int c() {
        return this.f2134c;
    }

    public long d() {
        return this.f2136e;
    }

    public String e() {
        return this.f2139h;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.e.c) {
            F.e.c cVar = (F.e.c) obj;
            if (this.f2132a == cVar.b() && this.f2133b.equals(cVar.f()) && this.f2134c == cVar.c() && this.f2135d == cVar.h() && this.f2136e == cVar.d() && this.f2137f == cVar.j() && this.f2138g == cVar.i() && this.f2139h.equals(cVar.e()) && this.f2140i.equals(cVar.g())) {
                return true;
            }
            return false;
        }
        return false;
    }

    public String f() {
        return this.f2133b;
    }

    public String g() {
        return this.f2140i;
    }

    public long h() {
        return this.f2135d;
    }

    public int hashCode() {
        int i5;
        long j5 = this.f2135d;
        long j6 = this.f2136e;
        int hashCode = (((((((((this.f2132a ^ 1000003) * 1000003) ^ this.f2133b.hashCode()) * 1000003) ^ this.f2134c) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003) ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003;
        if (this.f2137f) {
            i5 = 1231;
        } else {
            i5 = 1237;
        }
        return ((((((hashCode ^ i5) * 1000003) ^ this.f2138g) * 1000003) ^ this.f2139h.hashCode()) * 1000003) ^ this.f2140i.hashCode();
    }

    public int i() {
        return this.f2138g;
    }

    public boolean j() {
        return this.f2137f;
    }

    public String toString() {
        return "Device{arch=" + this.f2132a + ", model=" + this.f2133b + ", cores=" + this.f2134c + ", ram=" + this.f2135d + ", diskSpace=" + this.f2136e + ", simulator=" + this.f2137f + ", state=" + this.f2138g + ", manufacturer=" + this.f2139h + ", modelClass=" + this.f2140i + "}";
    }

    private k(int i5, String str, int i6, long j5, long j6, boolean z4, int i7, String str2, String str3) {
        this.f2132a = i5;
        this.f2133b = str;
        this.f2134c = i6;
        this.f2135d = j5;
        this.f2136e = j6;
        this.f2137f = z4;
        this.f2138g = i7;
        this.f2139h = str2;
        this.f2140i = str3;
    }
}
