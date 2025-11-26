package j$.util.stream;

public final class J3 extends C0526i2 implements V3 {

    /* renamed from: b  reason: collision with root package name */
    public long f1512b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1513c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f1514d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ K3 f1515e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public J3(K3 k32, C0546m2 m2Var, boolean z4) {
        super(m2Var);
        this.f1515e = k32;
        this.f1514d = z4;
    }

    public final void accept(Object obj) {
        boolean z4;
        boolean z5;
        if (!this.f1513c) {
            boolean test = this.f1515e.f1525s.test(obj);
            this.f1513c = !test;
            if (test) {
                z4 = false;
                z5 = this.f1514d;
                if (z5 && !z4) {
                    this.f1512b++;
                }
                if (!z5 || z4) {
                    this.f1716a.accept(obj);
                }
                return;
            }
        }
        z4 = true;
        z5 = this.f1514d;
        this.f1512b++;
        if (!z5) {
        }
        this.f1716a.accept(obj);
    }

    public final long h() {
        return this.f1512b;
    }
}
