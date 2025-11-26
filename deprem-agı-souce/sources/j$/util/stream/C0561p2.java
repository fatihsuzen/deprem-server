package j$.util.stream;

/* renamed from: j$.util.stream.p2  reason: case insensitive filesystem */
public final class C0561p2 extends C0516g2 {

    /* renamed from: b  reason: collision with root package name */
    public long f1761b;

    /* renamed from: c  reason: collision with root package name */
    public long f1762c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ C0566q2 f1763d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0561p2(C0566q2 q2Var, C0546m2 m2Var) {
        super(m2Var);
        this.f1763d = q2Var;
        this.f1761b = q2Var.f1767s;
        long j5 = q2Var.f1768t;
        this.f1762c = j5 < 0 ? Long.MAX_VALUE : j5;
    }

    public final void c(long j5) {
        this.f1710a.c(C0594w1.W(j5, this.f1763d.f1767s, this.f1762c));
    }

    public final void accept(int i5) {
        long j5 = this.f1761b;
        if (j5 == 0) {
            long j6 = this.f1762c;
            if (j6 > 0) {
                this.f1762c = j6 - 1;
                this.f1710a.accept(i5);
                return;
            }
            return;
        }
        this.f1761b = j5 - 1;
    }

    public final boolean e() {
        return this.f1762c == 0 || this.f1710a.e();
    }
}
