package j$.util.stream;

public final class L3 extends C0516g2 {

    /* renamed from: b  reason: collision with root package name */
    public final boolean f1533b = true;

    public L3(F2 f22, C0546m2 m2Var) {
        super(m2Var);
    }

    public final void c(long j5) {
        this.f1710a.c(-1);
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [java.lang.Throwable, java.util.function.IntPredicate] */
    public final void accept(int i5) {
        if (this.f1533b) {
            ? r02 = 0;
            r02.test(i5);
            throw r02;
        }
    }

    public final boolean e() {
        return !this.f1533b || this.f1710a.e();
    }
}
