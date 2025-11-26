package j$.util.stream;

/* renamed from: j$.util.stream.n2  reason: case insensitive filesystem */
public final class C0551n2 extends C0526i2 {

    /* renamed from: b  reason: collision with root package name */
    public long f1745b;

    /* renamed from: c  reason: collision with root package name */
    public long f1746c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ C0556o2 f1747d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0551n2(C0556o2 o2Var, C0546m2 m2Var) {
        super(m2Var);
        this.f1747d = o2Var;
        this.f1745b = o2Var.f1754s;
        long j5 = o2Var.f1755t;
        this.f1746c = j5 < 0 ? Long.MAX_VALUE : j5;
    }

    public final void c(long j5) {
        this.f1716a.c(C0594w1.W(j5, this.f1747d.f1754s, this.f1746c));
    }

    public final void accept(Object obj) {
        long j5 = this.f1745b;
        if (j5 == 0) {
            long j6 = this.f1746c;
            if (j6 > 0) {
                this.f1746c = j6 - 1;
                this.f1716a.accept(obj);
                return;
            }
            return;
        }
        this.f1745b = j5 - 1;
    }

    public final boolean e() {
        return this.f1746c == 0 || this.f1716a.e();
    }
}
