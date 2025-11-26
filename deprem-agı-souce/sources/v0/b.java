package V0;

public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private static b f4418a;

    private b() {
    }

    public static b a() {
        if (f4418a == null) {
            f4418a = new b();
        }
        return f4418a;
    }

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}
