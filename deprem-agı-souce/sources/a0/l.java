package A0;

import A0.F;

final class l extends F.e.d {

    /* renamed from: a  reason: collision with root package name */
    private final long f2151a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2152b;

    /* renamed from: c  reason: collision with root package name */
    private final F.e.d.a f2153c;

    /* renamed from: d  reason: collision with root package name */
    private final F.e.d.c f2154d;

    /* renamed from: e  reason: collision with root package name */
    private final F.e.d.C0036d f2155e;

    /* renamed from: f  reason: collision with root package name */
    private final F.e.d.f f2156f;

    static final class b extends F.e.d.b {

        /* renamed from: a  reason: collision with root package name */
        private long f2157a;

        /* renamed from: b  reason: collision with root package name */
        private String f2158b;

        /* renamed from: c  reason: collision with root package name */
        private F.e.d.a f2159c;

        /* renamed from: d  reason: collision with root package name */
        private F.e.d.c f2160d;

        /* renamed from: e  reason: collision with root package name */
        private F.e.d.C0036d f2161e;

        /* renamed from: f  reason: collision with root package name */
        private F.e.d.f f2162f;

        /* renamed from: g  reason: collision with root package name */
        private byte f2163g;

        public F.e.d a() {
            String str;
            F.e.d.a aVar;
            F.e.d.c cVar;
            if (this.f2163g == 1 && (str = this.f2158b) != null && (aVar = this.f2159c) != null && (cVar = this.f2160d) != null) {
                return new l(this.f2157a, str, aVar, cVar, this.f2161e, this.f2162f);
            }
            StringBuilder sb = new StringBuilder();
            if ((1 & this.f2163g) == 0) {
                sb.append(" timestamp");
            }
            if (this.f2158b == null) {
                sb.append(" type");
            }
            if (this.f2159c == null) {
                sb.append(" app");
            }
            if (this.f2160d == null) {
                sb.append(" device");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.e.d.b b(F.e.d.a aVar) {
            if (aVar != null) {
                this.f2159c = aVar;
                return this;
            }
            throw new NullPointerException("Null app");
        }

        public F.e.d.b c(F.e.d.c cVar) {
            if (cVar != null) {
                this.f2160d = cVar;
                return this;
            }
            throw new NullPointerException("Null device");
        }

        public F.e.d.b d(F.e.d.C0036d dVar) {
            this.f2161e = dVar;
            return this;
        }

        public F.e.d.b e(F.e.d.f fVar) {
            this.f2162f = fVar;
            return this;
        }

        public F.e.d.b f(long j5) {
            this.f2157a = j5;
            this.f2163g = (byte) (this.f2163g | 1);
            return this;
        }

        public F.e.d.b g(String str) {
            if (str != null) {
                this.f2158b = str;
                return this;
            }
            throw new NullPointerException("Null type");
        }

        b() {
        }

        private b(F.e.d dVar) {
            this.f2157a = dVar.f();
            this.f2158b = dVar.g();
            this.f2159c = dVar.b();
            this.f2160d = dVar.c();
            this.f2161e = dVar.d();
            this.f2162f = dVar.e();
            this.f2163g = 1;
        }
    }

    public F.e.d.a b() {
        return this.f2153c;
    }

    public F.e.d.c c() {
        return this.f2154d;
    }

    public F.e.d.C0036d d() {
        return this.f2155e;
    }

    public F.e.d.f e() {
        return this.f2156f;
    }

    public boolean equals(Object obj) {
        F.e.d.C0036d dVar;
        F.e.d.f fVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.e.d) {
            F.e.d dVar2 = (F.e.d) obj;
            if (this.f2151a != dVar2.f() || !this.f2152b.equals(dVar2.g()) || !this.f2153c.equals(dVar2.b()) || !this.f2154d.equals(dVar2.c()) || ((dVar = this.f2155e) != null ? !dVar.equals(dVar2.d()) : dVar2.d() != null) || ((fVar = this.f2156f) != null ? !fVar.equals(dVar2.e()) : dVar2.e() != null)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public long f() {
        return this.f2151a;
    }

    public String g() {
        return this.f2152b;
    }

    public F.e.d.b h() {
        return new b(this);
    }

    public int hashCode() {
        int i5;
        long j5 = this.f2151a;
        int hashCode = (((((((((int) (j5 ^ (j5 >>> 32))) ^ 1000003) * 1000003) ^ this.f2152b.hashCode()) * 1000003) ^ this.f2153c.hashCode()) * 1000003) ^ this.f2154d.hashCode()) * 1000003;
        F.e.d.C0036d dVar = this.f2155e;
        int i6 = 0;
        if (dVar == null) {
            i5 = 0;
        } else {
            i5 = dVar.hashCode();
        }
        int i7 = (hashCode ^ i5) * 1000003;
        F.e.d.f fVar = this.f2156f;
        if (fVar != null) {
            i6 = fVar.hashCode();
        }
        return i7 ^ i6;
    }

    public String toString() {
        return "Event{timestamp=" + this.f2151a + ", type=" + this.f2152b + ", app=" + this.f2153c + ", device=" + this.f2154d + ", log=" + this.f2155e + ", rollouts=" + this.f2156f + "}";
    }

    private l(long j5, String str, F.e.d.a aVar, F.e.d.c cVar, F.e.d.C0036d dVar, F.e.d.f fVar) {
        this.f2151a = j5;
        this.f2152b = str;
        this.f2153c = aVar;
        this.f2154d = cVar;
        this.f2155e = dVar;
        this.f2156f = fVar;
    }
}
