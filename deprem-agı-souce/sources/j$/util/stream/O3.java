package j$.util.stream;

public final class O3 extends C0521h2 {

    /* renamed from: b  reason: collision with root package name */
    public final boolean f1558b = true;

    public O3(G2 g22, C0546m2 m2Var) {
        super(m2Var);
    }

    public final void c(long j5) {
        this.f1713a.c(-1);
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [java.lang.Throwable, java.util.function.LongPredicate] */
    public final void accept(long j5) {
        if (this.f1558b) {
            ? r02 = 0;
            r02.test(j5);
            throw r02;
        }
    }

    public final boolean e() {
        return !this.f1558b || this.f1713a.e();
    }
}
