package A0;

import A0.F;

final class s extends F.e.d.a.b.C0031e.C0033b {

    /* renamed from: a  reason: collision with root package name */
    private final long f2223a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2224b;

    /* renamed from: c  reason: collision with root package name */
    private final String f2225c;

    /* renamed from: d  reason: collision with root package name */
    private final long f2226d;

    /* renamed from: e  reason: collision with root package name */
    private final int f2227e;

    static final class b extends F.e.d.a.b.C0031e.C0033b.C0034a {

        /* renamed from: a  reason: collision with root package name */
        private long f2228a;

        /* renamed from: b  reason: collision with root package name */
        private String f2229b;

        /* renamed from: c  reason: collision with root package name */
        private String f2230c;

        /* renamed from: d  reason: collision with root package name */
        private long f2231d;

        /* renamed from: e  reason: collision with root package name */
        private int f2232e;

        /* renamed from: f  reason: collision with root package name */
        private byte f2233f;

        b() {
        }

        public F.e.d.a.b.C0031e.C0033b a() {
            String str;
            if (this.f2233f == 7 && (str = this.f2229b) != null) {
                return new s(this.f2228a, str, this.f2230c, this.f2231d, this.f2232e);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f2233f & 1) == 0) {
                sb.append(" pc");
            }
            if (this.f2229b == null) {
                sb.append(" symbol");
            }
            if ((this.f2233f & 2) == 0) {
                sb.append(" offset");
            }
            if ((this.f2233f & 4) == 0) {
                sb.append(" importance");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.e.d.a.b.C0031e.C0033b.C0034a b(String str) {
            this.f2230c = str;
            return this;
        }

        public F.e.d.a.b.C0031e.C0033b.C0034a c(int i5) {
            this.f2232e = i5;
            this.f2233f = (byte) (this.f2233f | 4);
            return this;
        }

        public F.e.d.a.b.C0031e.C0033b.C0034a d(long j5) {
            this.f2231d = j5;
            this.f2233f = (byte) (this.f2233f | 2);
            return this;
        }

        public F.e.d.a.b.C0031e.C0033b.C0034a e(long j5) {
            this.f2228a = j5;
            this.f2233f = (byte) (this.f2233f | 1);
            return this;
        }

        public F.e.d.a.b.C0031e.C0033b.C0034a f(String str) {
            if (str != null) {
                this.f2229b = str;
                return this;
            }
            throw new NullPointerException("Null symbol");
        }
    }

    public String b() {
        return this.f2225c;
    }

    public int c() {
        return this.f2227e;
    }

    public long d() {
        return this.f2226d;
    }

    public long e() {
        return this.f2223a;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.e.d.a.b.C0031e.C0033b) {
            F.e.d.a.b.C0031e.C0033b bVar = (F.e.d.a.b.C0031e.C0033b) obj;
            if (this.f2223a == bVar.e() && this.f2224b.equals(bVar.f()) && ((str = this.f2225c) != null ? str.equals(bVar.b()) : bVar.b() == null) && this.f2226d == bVar.d() && this.f2227e == bVar.c()) {
                return true;
            }
            return false;
        }
        return false;
    }

    public String f() {
        return this.f2224b;
    }

    public int hashCode() {
        int i5;
        long j5 = this.f2223a;
        int hashCode = (((((int) (j5 ^ (j5 >>> 32))) ^ 1000003) * 1000003) ^ this.f2224b.hashCode()) * 1000003;
        String str = this.f2225c;
        if (str == null) {
            i5 = 0;
        } else {
            i5 = str.hashCode();
        }
        long j6 = this.f2226d;
        return ((((hashCode ^ i5) * 1000003) ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003) ^ this.f2227e;
    }

    public String toString() {
        return "Frame{pc=" + this.f2223a + ", symbol=" + this.f2224b + ", file=" + this.f2225c + ", offset=" + this.f2226d + ", importance=" + this.f2227e + "}";
    }

    private s(long j5, String str, String str2, long j6, int i5) {
        this.f2223a = j5;
        this.f2224b = str;
        this.f2225c = str2;
        this.f2226d = j6;
        this.f2227e = i5;
    }
}
