package j$.util;

public abstract class u0 {

    /* renamed from: a  reason: collision with root package name */
    public static final q0 f1848a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static final o0 f1849b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public static final p0 f1850c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public static final n0 f1851d = new Object();

    public static void a(int i5, int i6, int i7) {
        if (i6 > i7) {
            throw new ArrayIndexOutOfBoundsException("origin(" + i6 + ") > fence(" + i7 + ")");
        } else if (i6 < 0) {
            throw new ArrayIndexOutOfBoundsException(i6);
        } else if (i7 > i5) {
            throw new ArrayIndexOutOfBoundsException(i7);
        }
    }
}
