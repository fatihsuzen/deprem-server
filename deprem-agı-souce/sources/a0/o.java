package A0;

import A0.F;

final class o extends F.e.d.a.b.C0025a {

    /* renamed from: a  reason: collision with root package name */
    private final long f2189a;

    /* renamed from: b  reason: collision with root package name */
    private final long f2190b;

    /* renamed from: c  reason: collision with root package name */
    private final String f2191c;

    /* renamed from: d  reason: collision with root package name */
    private final String f2192d;

    static final class b extends F.e.d.a.b.C0025a.C0026a {

        /* renamed from: a  reason: collision with root package name */
        private long f2193a;

        /* renamed from: b  reason: collision with root package name */
        private long f2194b;

        /* renamed from: c  reason: collision with root package name */
        private String f2195c;

        /* renamed from: d  reason: collision with root package name */
        private String f2196d;

        /* renamed from: e  reason: collision with root package name */
        private byte f2197e;

        b() {
        }

        public F.e.d.a.b.C0025a a() {
            String str;
            if (this.f2197e == 3 && (str = this.f2195c) != null) {
                return new o(this.f2193a, this.f2194b, str, this.f2196d);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f2197e & 1) == 0) {
                sb.append(" baseAddress");
            }
            if ((this.f2197e & 2) == 0) {
                sb.append(" size");
            }
            if (this.f2195c == null) {
                sb.append(" name");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.e.d.a.b.C0025a.C0026a b(long j5) {
            this.f2193a = j5;
            this.f2197e = (byte) (this.f2197e | 1);
            return this;
        }

        public F.e.d.a.b.C0025a.C0026a c(String str) {
            if (str != null) {
                this.f2195c = str;
                return this;
            }
            throw new NullPointerException("Null name");
        }

        public F.e.d.a.b.C0025a.C0026a d(long j5) {
            this.f2194b = j5;
            this.f2197e = (byte) (this.f2197e | 2);
            return this;
        }

        public F.e.d.a.b.C0025a.C0026a e(String str) {
            this.f2196d = str;
            return this;
        }
    }

    public long b() {
        return this.f2189a;
    }

    public String c() {
        return this.f2191c;
    }

    public long d() {
        return this.f2190b;
    }

    public String e() {
        return this.f2192d;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.e.d.a.b.C0025a) {
            F.e.d.a.b.C0025a aVar = (F.e.d.a.b.C0025a) obj;
            if (this.f2189a != aVar.b() || this.f2190b != aVar.d() || !this.f2191c.equals(aVar.c()) || ((str = this.f2192d) != null ? !str.equals(aVar.e()) : aVar.e() != null)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i5;
        long j5 = this.f2189a;
        long j6 = this.f2190b;
        int hashCode = (((((((int) (j5 ^ (j5 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003) ^ this.f2191c.hashCode()) * 1000003;
        String str = this.f2192d;
        if (str == null) {
            i5 = 0;
        } else {
            i5 = str.hashCode();
        }
        return hashCode ^ i5;
    }

    public String toString() {
        return "BinaryImage{baseAddress=" + this.f2189a + ", size=" + this.f2190b + ", name=" + this.f2191c + ", uuid=" + this.f2192d + "}";
    }

    private o(long j5, long j6, String str, String str2) {
        this.f2189a = j5;
        this.f2190b = j6;
        this.f2191c = str;
        this.f2192d = str2;
    }
}
