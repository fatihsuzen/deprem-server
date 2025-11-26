package z;

import z.C1953e;

/* renamed from: z.a  reason: case insensitive filesystem */
final class C1949a extends C1953e {

    /* renamed from: b  reason: collision with root package name */
    private final long f17133b;

    /* renamed from: c  reason: collision with root package name */
    private final int f17134c;

    /* renamed from: d  reason: collision with root package name */
    private final int f17135d;

    /* renamed from: e  reason: collision with root package name */
    private final long f17136e;

    /* renamed from: f  reason: collision with root package name */
    private final int f17137f;

    /* renamed from: z.a$b */
    static final class b extends C1953e.a {

        /* renamed from: a  reason: collision with root package name */
        private Long f17138a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f17139b;

        /* renamed from: c  reason: collision with root package name */
        private Integer f17140c;

        /* renamed from: d  reason: collision with root package name */
        private Long f17141d;

        /* renamed from: e  reason: collision with root package name */
        private Integer f17142e;

        b() {
        }

        /* access modifiers changed from: package-private */
        public C1953e a() {
            String str = "";
            if (this.f17138a == null) {
                str = str + " maxStorageSizeInBytes";
            }
            if (this.f17139b == null) {
                str = str + " loadBatchSize";
            }
            if (this.f17140c == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.f17141d == null) {
                str = str + " eventCleanUpAge";
            }
            if (this.f17142e == null) {
                str = str + " maxBlobByteSizePerRow";
            }
            if (str.isEmpty()) {
                return new C1949a(this.f17138a.longValue(), this.f17139b.intValue(), this.f17140c.intValue(), this.f17141d.longValue(), this.f17142e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        /* access modifiers changed from: package-private */
        public C1953e.a b(int i5) {
            this.f17140c = Integer.valueOf(i5);
            return this;
        }

        /* access modifiers changed from: package-private */
        public C1953e.a c(long j5) {
            this.f17141d = Long.valueOf(j5);
            return this;
        }

        /* access modifiers changed from: package-private */
        public C1953e.a d(int i5) {
            this.f17139b = Integer.valueOf(i5);
            return this;
        }

        /* access modifiers changed from: package-private */
        public C1953e.a e(int i5) {
            this.f17142e = Integer.valueOf(i5);
            return this;
        }

        /* access modifiers changed from: package-private */
        public C1953e.a f(long j5) {
            this.f17138a = Long.valueOf(j5);
            return this;
        }
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f17135d;
    }

    /* access modifiers changed from: package-private */
    public long c() {
        return this.f17136e;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.f17134c;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.f17137f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1953e) {
            C1953e eVar = (C1953e) obj;
            if (this.f17133b == eVar.f() && this.f17134c == eVar.d() && this.f17135d == eVar.b() && this.f17136e == eVar.c() && this.f17137f == eVar.e()) {
                return true;
            }
            return false;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public long f() {
        return this.f17133b;
    }

    public int hashCode() {
        long j5 = this.f17133b;
        long j6 = this.f17136e;
        return ((((((((((int) (j5 ^ (j5 >>> 32))) ^ 1000003) * 1000003) ^ this.f17134c) * 1000003) ^ this.f17135d) * 1000003) ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003) ^ this.f17137f;
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.f17133b + ", loadBatchSize=" + this.f17134c + ", criticalSectionEnterTimeoutMs=" + this.f17135d + ", eventCleanUpAge=" + this.f17136e + ", maxBlobByteSizePerRow=" + this.f17137f + "}";
    }

    private C1949a(long j5, int i5, int i6, long j6, int i7) {
        this.f17133b = j5;
        this.f17134c = i5;
        this.f17135d = i6;
        this.f17136e = j6;
        this.f17137f = i7;
    }
}
