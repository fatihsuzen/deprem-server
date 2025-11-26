package j$.util.stream;

/* renamed from: j$.util.stream.t  reason: case insensitive filesystem */
public final class C0577t extends C0484a0 {

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f1785s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0577t(C0483a aVar, int i5, int i6) {
        super(aVar, i5);
        this.f1785s = i6;
    }

    public final C0546m2 Q0(int i5, C0546m2 m2Var) {
        switch (this.f1785s) {
            case 0:
                return new C0563q(this, m2Var, 2);
            case 1:
                return new U(this, m2Var, 2);
            case 2:
                return m2Var;
            case 3:
                return new U(this, m2Var, 5);
            default:
                return new C0499d0(this, m2Var, 2);
        }
    }
}
