package j$.util.stream;

public final class W extends C0516g2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f1597b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ W(int i5, C0546m2 m2Var) {
        super(m2Var);
        this.f1597b = i5;
    }

    public final void accept(int i5) {
        switch (this.f1597b) {
            case 0:
                this.f1710a.accept((long) i5);
                return;
            default:
                this.f1710a.accept((double) i5);
                return;
        }
    }
}
