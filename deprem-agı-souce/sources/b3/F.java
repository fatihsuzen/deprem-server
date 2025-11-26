package B3;

abstract /* synthetic */ class F {

    /* renamed from: a  reason: collision with root package name */
    private static final int f17372a = Runtime.getRuntime().availableProcessors();

    public static final int a() {
        return f17372a;
    }

    public static final String b(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
