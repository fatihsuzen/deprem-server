package z2;

public final class H {

    /* renamed from: a  reason: collision with root package name */
    public static final H f26488a = new H();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f26489b;

    /* renamed from: c  reason: collision with root package name */
    private static int f26490c;

    /* renamed from: d  reason: collision with root package name */
    private static int f26491d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f26492e;

    private H() {
    }

    public final int a() {
        return f26490c;
    }

    public final int b() {
        return f26491d;
    }

    public final boolean c() {
        int i5 = f26490c;
        if (i5 == 0) {
            return true;
        }
        if (!f26489b) {
            return false;
        }
        if (f26492e || i5 >= 4300) {
            return true;
        }
        return false;
    }

    public final boolean d() {
        return f26489b;
    }

    public final boolean e() {
        if (!f26489b) {
            return false;
        }
        if (f26492e || f26491d >= 9152) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        return f26492e;
    }

    public final void g(int i5) {
        f26490c = i5;
    }

    public final void h(boolean z4) {
        f26489b = z4;
    }

    public final void i(int i5) {
        f26491d = i5;
    }

    public final void j(boolean z4) {
        f26492e = z4;
    }
}
