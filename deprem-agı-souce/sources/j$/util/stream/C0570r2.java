package j$.util.stream;

/* renamed from: j$.util.stream.r2  reason: case insensitive filesystem */
public final class C0570r2 extends C0521h2 {

    /* renamed from: b  reason: collision with root package name */
    public long f1772b;

    /* renamed from: c  reason: collision with root package name */
    public long f1773c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ C0575s2 f1774d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0570r2(C0575s2 s2Var, C0546m2 m2Var) {
        super(m2Var);
        this.f1774d = s2Var;
        this.f1772b = s2Var.f1783s;
        long j5 = s2Var.f1784t;
        this.f1773c = j5 < 0 ? Long.MAX_VALUE : j5;
    }

    public final void c(long j5) {
        this.f1713a.c(C0594w1.W(j5, this.f1774d.f1783s, this.f1773c));
    }

    public final void accept(long j5) {
        long j6 = this.f1772b;
        if (j6 == 0) {
            long j7 = this.f1773c;
            if (j7 > 0) {
                this.f1773c = j7 - 1;
                this.f1713a.accept(j5);
                return;
            }
            return;
        }
        this.f1772b = j6 - 1;
    }

    public final boolean e() {
        return this.f1773c == 0 || this.f1713a.e();
    }
}
