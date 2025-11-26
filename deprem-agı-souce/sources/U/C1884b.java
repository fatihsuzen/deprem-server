package u;

/* renamed from: u.b  reason: case insensitive filesystem */
public final class C1884b {

    /* renamed from: b  reason: collision with root package name */
    private static final C1884b f16614b = new a().a();

    /* renamed from: a  reason: collision with root package name */
    private final e f16615a;

    /* renamed from: u.b$a */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private e f16616a = null;

        a() {
        }

        public C1884b a() {
            return new C1884b(this.f16616a);
        }

        public a b(e eVar) {
            this.f16616a = eVar;
            return this;
        }
    }

    C1884b(e eVar) {
        this.f16615a = eVar;
    }

    public static a b() {
        return new a();
    }

    public e a() {
        return this.f16615a;
    }
}
