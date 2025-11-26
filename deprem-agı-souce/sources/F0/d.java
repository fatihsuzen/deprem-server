package F0;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public final b f2421a;

    /* renamed from: b  reason: collision with root package name */
    public final a f2422b;

    /* renamed from: c  reason: collision with root package name */
    public final long f2423c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2424d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2425e;

    /* renamed from: f  reason: collision with root package name */
    public final double f2426f;

    /* renamed from: g  reason: collision with root package name */
    public final double f2427g;

    /* renamed from: h  reason: collision with root package name */
    public final int f2428h;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f2429a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f2430b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f2431c;

        public a(boolean z4, boolean z5, boolean z6) {
            this.f2429a = z4;
            this.f2430b = z5;
            this.f2431c = z6;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f2432a;

        /* renamed from: b  reason: collision with root package name */
        public final int f2433b;

        public b(int i5, int i6) {
            this.f2432a = i5;
            this.f2433b = i6;
        }
    }

    public d(long j5, b bVar, a aVar, int i5, int i6, double d5, double d6, int i7) {
        this.f2423c = j5;
        this.f2421a = bVar;
        this.f2422b = aVar;
        this.f2424d = i5;
        this.f2425e = i6;
        this.f2426f = d5;
        this.f2427g = d6;
        this.f2428h = i7;
    }

    public boolean a(long j5) {
        if (this.f2423c < j5) {
            return true;
        }
        return false;
    }
}
