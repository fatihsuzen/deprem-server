package j$.util.stream;

/* renamed from: j$.util.stream.u  reason: case insensitive filesystem */
public final class C0582u extends C0529j0 {

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f1791s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0582u(C0483a aVar, int i5, int i6) {
        super(aVar, i5);
        this.f1791s = i6;
    }

    public final C0546m2 Q0(int i5, C0546m2 m2Var) {
        switch (this.f1791s) {
            case 0:
                return new C0563q(this, m2Var, 3);
            case 1:
                return new W(0, m2Var);
            case 2:
                return new U(this, m2Var, 3);
            case 3:
                return new C0499d0(this, m2Var, 1);
            case 4:
                return m2Var;
            default:
                return new C0499d0(this, m2Var, 4);
        }
    }
}
