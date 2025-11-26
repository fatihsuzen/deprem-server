package A0;

import A0.F;

final class w extends F.e.d.C0037e {

    /* renamed from: a  reason: collision with root package name */
    private final F.e.d.C0037e.b f2258a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2259b;

    /* renamed from: c  reason: collision with root package name */
    private final String f2260c;

    /* renamed from: d  reason: collision with root package name */
    private final long f2261d;

    static final class b extends F.e.d.C0037e.a {

        /* renamed from: a  reason: collision with root package name */
        private F.e.d.C0037e.b f2262a;

        /* renamed from: b  reason: collision with root package name */
        private String f2263b;

        /* renamed from: c  reason: collision with root package name */
        private String f2264c;

        /* renamed from: d  reason: collision with root package name */
        private long f2265d;

        /* renamed from: e  reason: collision with root package name */
        private byte f2266e;

        b() {
        }

        public F.e.d.C0037e a() {
            F.e.d.C0037e.b bVar;
            String str;
            String str2;
            if (this.f2266e == 1 && (bVar = this.f2262a) != null && (str = this.f2263b) != null && (str2 = this.f2264c) != null) {
                return new w(bVar, str, str2, this.f2265d);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f2262a == null) {
                sb.append(" rolloutVariant");
            }
            if (this.f2263b == null) {
                sb.append(" parameterKey");
            }
            if (this.f2264c == null) {
                sb.append(" parameterValue");
            }
            if ((1 & this.f2266e) == 0) {
                sb.append(" templateVersion");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.e.d.C0037e.a b(String str) {
            if (str != null) {
                this.f2263b = str;
                return this;
            }
            throw new NullPointerException("Null parameterKey");
        }

        public F.e.d.C0037e.a c(String str) {
            if (str != null) {
                this.f2264c = str;
                return this;
            }
            throw new NullPointerException("Null parameterValue");
        }

        public F.e.d.C0037e.a d(F.e.d.C0037e.b bVar) {
            if (bVar != null) {
                this.f2262a = bVar;
                return this;
            }
            throw new NullPointerException("Null rolloutVariant");
        }

        public F.e.d.C0037e.a e(long j5) {
            this.f2265d = j5;
            this.f2266e = (byte) (this.f2266e | 1);
            return this;
        }
    }

    public String b() {
        return this.f2259b;
    }

    public String c() {
        return this.f2260c;
    }

    public F.e.d.C0037e.b d() {
        return this.f2258a;
    }

    public long e() {
        return this.f2261d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.e.d.C0037e) {
            F.e.d.C0037e eVar = (F.e.d.C0037e) obj;
            if (!this.f2258a.equals(eVar.d()) || !this.f2259b.equals(eVar.b()) || !this.f2260c.equals(eVar.c()) || this.f2261d != eVar.e()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j5 = this.f2261d;
        return ((((((this.f2258a.hashCode() ^ 1000003) * 1000003) ^ this.f2259b.hashCode()) * 1000003) ^ this.f2260c.hashCode()) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)));
    }

    public String toString() {
        return "RolloutAssignment{rolloutVariant=" + this.f2258a + ", parameterKey=" + this.f2259b + ", parameterValue=" + this.f2260c + ", templateVersion=" + this.f2261d + "}";
    }

    private w(F.e.d.C0037e.b bVar, String str, String str2, long j5) {
        this.f2258a = bVar;
        this.f2259b = str;
        this.f2260c = str2;
        this.f2261d = j5;
    }
}
