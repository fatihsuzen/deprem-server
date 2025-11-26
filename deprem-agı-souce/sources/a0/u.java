package A0;

import A0.F;

final class u extends F.e.d.c {

    /* renamed from: a  reason: collision with root package name */
    private final Double f2243a;

    /* renamed from: b  reason: collision with root package name */
    private final int f2244b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f2245c;

    /* renamed from: d  reason: collision with root package name */
    private final int f2246d;

    /* renamed from: e  reason: collision with root package name */
    private final long f2247e;

    /* renamed from: f  reason: collision with root package name */
    private final long f2248f;

    static final class b extends F.e.d.c.a {

        /* renamed from: a  reason: collision with root package name */
        private Double f2249a;

        /* renamed from: b  reason: collision with root package name */
        private int f2250b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f2251c;

        /* renamed from: d  reason: collision with root package name */
        private int f2252d;

        /* renamed from: e  reason: collision with root package name */
        private long f2253e;

        /* renamed from: f  reason: collision with root package name */
        private long f2254f;

        /* renamed from: g  reason: collision with root package name */
        private byte f2255g;

        b() {
        }

        public F.e.d.c a() {
            if (this.f2255g == 31) {
                return new u(this.f2249a, this.f2250b, this.f2251c, this.f2252d, this.f2253e, this.f2254f);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f2255g & 1) == 0) {
                sb.append(" batteryVelocity");
            }
            if ((this.f2255g & 2) == 0) {
                sb.append(" proximityOn");
            }
            if ((this.f2255g & 4) == 0) {
                sb.append(" orientation");
            }
            if ((this.f2255g & 8) == 0) {
                sb.append(" ramUsed");
            }
            if ((this.f2255g & 16) == 0) {
                sb.append(" diskUsed");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.e.d.c.a b(Double d5) {
            this.f2249a = d5;
            return this;
        }

        public F.e.d.c.a c(int i5) {
            this.f2250b = i5;
            this.f2255g = (byte) (this.f2255g | 1);
            return this;
        }

        public F.e.d.c.a d(long j5) {
            this.f2254f = j5;
            this.f2255g = (byte) (this.f2255g | 16);
            return this;
        }

        public F.e.d.c.a e(int i5) {
            this.f2252d = i5;
            this.f2255g = (byte) (this.f2255g | 4);
            return this;
        }

        public F.e.d.c.a f(boolean z4) {
            this.f2251c = z4;
            this.f2255g = (byte) (this.f2255g | 2);
            return this;
        }

        public F.e.d.c.a g(long j5) {
            this.f2253e = j5;
            this.f2255g = (byte) (this.f2255g | 8);
            return this;
        }
    }

    public Double b() {
        return this.f2243a;
    }

    public int c() {
        return this.f2244b;
    }

    public long d() {
        return this.f2248f;
    }

    public int e() {
        return this.f2246d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.e.d.c) {
            F.e.d.c cVar = (F.e.d.c) obj;
            Double d5 = this.f2243a;
            if (d5 != null ? d5.equals(cVar.b()) : cVar.b() == null) {
                if (this.f2244b == cVar.c() && this.f2245c == cVar.g() && this.f2246d == cVar.e() && this.f2247e == cVar.f() && this.f2248f == cVar.d()) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public long f() {
        return this.f2247e;
    }

    public boolean g() {
        return this.f2245c;
    }

    public int hashCode() {
        int i5;
        int i6;
        Double d5 = this.f2243a;
        if (d5 == null) {
            i5 = 0;
        } else {
            i5 = d5.hashCode();
        }
        int i7 = (((i5 ^ 1000003) * 1000003) ^ this.f2244b) * 1000003;
        if (this.f2245c) {
            i6 = 1231;
        } else {
            i6 = 1237;
        }
        long j5 = this.f2247e;
        long j6 = this.f2248f;
        return ((((((i7 ^ i6) * 1000003) ^ this.f2246d) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003) ^ ((int) (j6 ^ (j6 >>> 32)));
    }

    public String toString() {
        return "Device{batteryLevel=" + this.f2243a + ", batteryVelocity=" + this.f2244b + ", proximityOn=" + this.f2245c + ", orientation=" + this.f2246d + ", ramUsed=" + this.f2247e + ", diskUsed=" + this.f2248f + "}";
    }

    private u(Double d5, int i5, boolean z4, int i6, long j5, long j6) {
        this.f2243a = d5;
        this.f2244b = i5;
        this.f2245c = z4;
        this.f2246d = i6;
        this.f2247e = j5;
        this.f2248f = j6;
    }
}
