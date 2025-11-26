package u;

public final class f {

    /* renamed from: c  reason: collision with root package name */
    private static final f f16641c = new a().a();

    /* renamed from: a  reason: collision with root package name */
    private final long f16642a;

    /* renamed from: b  reason: collision with root package name */
    private final long f16643b;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private long f16644a = 0;

        /* renamed from: b  reason: collision with root package name */
        private long f16645b = 0;

        a() {
        }

        public f a() {
            return new f(this.f16644a, this.f16645b);
        }

        public a b(long j5) {
            this.f16645b = j5;
            return this;
        }

        public a c(long j5) {
            this.f16644a = j5;
            return this;
        }
    }

    f(long j5, long j6) {
        this.f16642a = j5;
        this.f16643b = j6;
    }

    public static a c() {
        return new a();
    }

    public long a() {
        return this.f16643b;
    }

    public long b() {
        return this.f16642a;
    }
}
