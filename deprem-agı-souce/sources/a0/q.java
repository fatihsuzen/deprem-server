package A0;

import A0.F;

final class q extends F.e.d.a.b.C0029d {

    /* renamed from: a  reason: collision with root package name */
    private final String f2209a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2210b;

    /* renamed from: c  reason: collision with root package name */
    private final long f2211c;

    static final class b extends F.e.d.a.b.C0029d.C0030a {

        /* renamed from: a  reason: collision with root package name */
        private String f2212a;

        /* renamed from: b  reason: collision with root package name */
        private String f2213b;

        /* renamed from: c  reason: collision with root package name */
        private long f2214c;

        /* renamed from: d  reason: collision with root package name */
        private byte f2215d;

        b() {
        }

        public F.e.d.a.b.C0029d a() {
            String str;
            String str2;
            if (this.f2215d == 1 && (str = this.f2212a) != null && (str2 = this.f2213b) != null) {
                return new q(str, str2, this.f2214c);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f2212a == null) {
                sb.append(" name");
            }
            if (this.f2213b == null) {
                sb.append(" code");
            }
            if ((1 & this.f2215d) == 0) {
                sb.append(" address");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.e.d.a.b.C0029d.C0030a b(long j5) {
            this.f2214c = j5;
            this.f2215d = (byte) (this.f2215d | 1);
            return this;
        }

        public F.e.d.a.b.C0029d.C0030a c(String str) {
            if (str != null) {
                this.f2213b = str;
                return this;
            }
            throw new NullPointerException("Null code");
        }

        public F.e.d.a.b.C0029d.C0030a d(String str) {
            if (str != null) {
                this.f2212a = str;
                return this;
            }
            throw new NullPointerException("Null name");
        }
    }

    public long b() {
        return this.f2211c;
    }

    public String c() {
        return this.f2210b;
    }

    public String d() {
        return this.f2209a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.e.d.a.b.C0029d) {
            F.e.d.a.b.C0029d dVar = (F.e.d.a.b.C0029d) obj;
            if (!this.f2209a.equals(dVar.d()) || !this.f2210b.equals(dVar.c()) || this.f2211c != dVar.b()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j5 = this.f2211c;
        return ((((this.f2209a.hashCode() ^ 1000003) * 1000003) ^ this.f2210b.hashCode()) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)));
    }

    public String toString() {
        return "Signal{name=" + this.f2209a + ", code=" + this.f2210b + ", address=" + this.f2211c + "}";
    }

    private q(String str, String str2, long j5) {
        this.f2209a = str;
        this.f2210b = str2;
        this.f2211c = j5;
    }
}
