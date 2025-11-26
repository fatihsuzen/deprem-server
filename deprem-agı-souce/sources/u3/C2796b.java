package u3;

/* renamed from: u3.b  reason: case insensitive filesystem */
public abstract class C2796b {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f25999a = false;

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal[] f26000b;

    static {
        ThreadLocal[] threadLocalArr = new ThreadLocal[4];
        for (int i5 = 0; i5 < 4; i5++) {
            threadLocalArr[i5] = new ThreadLocal();
        }
        f26000b = threadLocalArr;
    }

    public static final boolean a() {
        return f25999a;
    }
}
