package u;

public final class e {

    /* renamed from: c  reason: collision with root package name */
    private static final e f16636c = new a().a();

    /* renamed from: a  reason: collision with root package name */
    private final long f16637a;

    /* renamed from: b  reason: collision with root package name */
    private final long f16638b;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private long f16639a = 0;

        /* renamed from: b  reason: collision with root package name */
        private long f16640b = 0;

        a() {
        }

        public e a() {
            return new e(this.f16639a, this.f16640b);
        }

        public a b(long j5) {
            this.f16639a = j5;
            return this;
        }

        public a c(long j5) {
            this.f16640b = j5;
            return this;
        }
    }

    e(long j5, long j6) {
        this.f16637a = j5;
        this.f16638b = j6;
    }

    public static a c() {
        return new a();
    }

    public long a() {
        return this.f16637a;
    }

    public long b() {
        return this.f16638b;
    }
}
