package s;

public abstract class g {

    public enum a {
        OK,
        TRANSIENT_ERROR,
        FATAL_ERROR,
        INVALID_PAYLOAD
    }

    public static g a() {
        return new C1816b(a.FATAL_ERROR, -1);
    }

    public static g d() {
        return new C1816b(a.INVALID_PAYLOAD, -1);
    }

    public static g e(long j5) {
        return new C1816b(a.OK, j5);
    }

    public static g f() {
        return new C1816b(a.TRANSIENT_ERROR, -1);
    }

    public abstract long b();

    public abstract a c();
}
