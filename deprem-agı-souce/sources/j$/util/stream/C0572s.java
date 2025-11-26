package j$.util.stream;

/* renamed from: j$.util.stream.s  reason: case insensitive filesystem */
public final class C0572s extends C0607z {

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f1775s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0572s(C0483a aVar, int i5, int i6) {
        super(aVar, i5);
        this.f1775s = i6;
    }

    public final C0546m2 Q0(int i5, C0546m2 m2Var) {
        switch (this.f1775s) {
            case 0:
                return new C0563q(this, m2Var, 1);
            case 1:
                return m2Var;
            case 2:
                return new C0563q(this, m2Var, 4);
            case 3:
                return new W(1, m2Var);
            case 4:
                return new U(this, m2Var, 4);
            case 5:
                return new C0521h2(m2Var);
            default:
                return new C0499d0(this, m2Var, 3);
        }
    }
}
