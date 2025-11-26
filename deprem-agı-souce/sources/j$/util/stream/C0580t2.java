package j$.util.stream;

/* renamed from: j$.util.stream.t2  reason: case insensitive filesystem */
public final class C0580t2 extends C0511f2 {

    /* renamed from: b  reason: collision with root package name */
    public long f1788b;

    /* renamed from: c  reason: collision with root package name */
    public long f1789c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ C0585u2 f1790d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0580t2(C0585u2 u2Var, C0546m2 m2Var) {
        super(m2Var);
        this.f1790d = u2Var;
        this.f1788b = u2Var.f1795s;
        long j5 = u2Var.f1796t;
        this.f1789c = j5 < 0 ? Long.MAX_VALUE : j5;
    }

    public final void c(long j5) {
        this.f1706a.c(C0594w1.W(j5, this.f1790d.f1795s, this.f1789c));
    }

    public final void accept(double d5) {
        long j5 = this.f1788b;
        if (j5 == 0) {
            long j6 = this.f1789c;
            if (j6 > 0) {
                this.f1789c = j6 - 1;
                this.f1706a.accept(d5);
                return;
            }
            return;
        }
        this.f1788b = j5 - 1;
    }

    public final boolean e() {
        return this.f1789c == 0 || this.f1706a.e();
    }
}
