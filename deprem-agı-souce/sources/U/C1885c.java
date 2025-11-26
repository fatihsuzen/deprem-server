package u;

import N0.c;

/* renamed from: u.c  reason: case insensitive filesystem */
public final class C1885c {

    /* renamed from: c  reason: collision with root package name */
    private static final C1885c f16617c = new a().a();

    /* renamed from: a  reason: collision with root package name */
    private final long f16618a;

    /* renamed from: b  reason: collision with root package name */
    private final b f16619b;

    /* renamed from: u.c$a */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private long f16620a = 0;

        /* renamed from: b  reason: collision with root package name */
        private b f16621b = b.REASON_UNKNOWN;

        a() {
        }

        public C1885c a() {
            return new C1885c(this.f16620a, this.f16621b);
        }

        public a b(long j5) {
            this.f16620a = j5;
            return this;
        }

        public a c(b bVar) {
            this.f16621b = bVar;
            return this;
        }
    }

    /* renamed from: u.c$b */
    public enum b implements c {
        REASON_UNKNOWN(0),
        MESSAGE_TOO_OLD(1),
        CACHE_FULL(2),
        PAYLOAD_TOO_BIG(3),
        MAX_RETRIES_REACHED(4),
        INVALID_PAYLOD(5),
        SERVER_ERROR(6);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f16630a;

        private b(int i5) {
            this.f16630a = i5;
        }

        public int getNumber() {
            return this.f16630a;
        }
    }

    C1885c(long j5, b bVar) {
        this.f16618a = j5;
        this.f16619b = bVar;
    }

    public static a c() {
        return new a();
    }

    public long a() {
        return this.f16618a;
    }

    public b b() {
        return this.f16619b;
    }
}
