package j$.util.stream;

public final class R3 extends C0511f2 {

    /* renamed from: b  reason: collision with root package name */
    public final boolean f1568b = true;

    public R3(E2 e22, C0546m2 m2Var) {
        super(m2Var);
    }

    public final void c(long j5) {
        this.f1706a.c(-1);
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [java.lang.Throwable, java.util.function.DoublePredicate] */
    public final void accept(double d5) {
        if (this.f1568b) {
            ? r02 = 0;
            r02.test(d5);
            throw r02;
        }
    }

    public final boolean e() {
        return !this.f1568b || this.f1706a.e();
    }
}
