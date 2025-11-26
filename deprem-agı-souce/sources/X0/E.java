package x0;

public enum E {
    DEVELOPER(1),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);
    

    /* renamed from: a  reason: collision with root package name */
    private final int f16804a;

    private E(int i5) {
        this.f16804a = i5;
    }

    public static E b(String str) {
        if (str != null) {
            return APP_STORE;
        }
        return DEVELOPER;
    }

    public int c() {
        return this.f16804a;
    }

    public String toString() {
        return Integer.toString(this.f16804a);
    }
}
