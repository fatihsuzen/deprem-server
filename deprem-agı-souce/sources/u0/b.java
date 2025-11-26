package U0;

import U0.f;

final class b extends f {

    /* renamed from: a  reason: collision with root package name */
    private final String f4392a;

    /* renamed from: b  reason: collision with root package name */
    private final long f4393b;

    /* renamed from: c  reason: collision with root package name */
    private final f.b f4394c;

    /* renamed from: U0.b$b  reason: collision with other inner class name */
    static final class C0062b extends f.a {

        /* renamed from: a  reason: collision with root package name */
        private String f4395a;

        /* renamed from: b  reason: collision with root package name */
        private long f4396b;

        /* renamed from: c  reason: collision with root package name */
        private f.b f4397c;

        /* renamed from: d  reason: collision with root package name */
        private byte f4398d;

        C0062b() {
        }

        public f a() {
            if (this.f4398d == 1) {
                return new b(this.f4395a, this.f4396b, this.f4397c);
            }
            throw new IllegalStateException("Missing required properties:" + " tokenExpirationTimestamp");
        }

        public f.a b(f.b bVar) {
            this.f4397c = bVar;
            return this;
        }

        public f.a c(String str) {
            this.f4395a = str;
            return this;
        }

        public f.a d(long j5) {
            this.f4396b = j5;
            this.f4398d = (byte) (this.f4398d | 1);
            return this;
        }
    }

    public f.b b() {
        return this.f4394c;
    }

    public String c() {
        return this.f4392a;
    }

    public long d() {
        return this.f4393b;
    }

    public boolean equals(Object obj) {
        f.b bVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            String str = this.f4392a;
            if (str != null ? str.equals(fVar.c()) : fVar.c() == null) {
                if (this.f4393b != fVar.d() || ((bVar = this.f4394c) != null ? !bVar.equals(fVar.b()) : fVar.b() != null)) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i5;
        String str = this.f4392a;
        int i6 = 0;
        if (str == null) {
            i5 = 0;
        } else {
            i5 = str.hashCode();
        }
        long j5 = this.f4393b;
        int i7 = (((i5 ^ 1000003) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003;
        f.b bVar = this.f4394c;
        if (bVar != null) {
            i6 = bVar.hashCode();
        }
        return i7 ^ i6;
    }

    public String toString() {
        return "TokenResult{token=" + this.f4392a + ", tokenExpirationTimestamp=" + this.f4393b + ", responseCode=" + this.f4394c + "}";
    }

    private b(String str, long j5, f.b bVar) {
        this.f4392a = str;
        this.f4393b = j5;
        this.f4394c = bVar;
    }
}
