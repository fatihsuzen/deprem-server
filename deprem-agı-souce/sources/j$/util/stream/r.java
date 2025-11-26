package j$.util.stream;

import java.util.function.Consumer;

public final class r extends C0501d2 {

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f1769s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ Object f1770t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(C0483a aVar, int i5, Object obj, int i6) {
        super(aVar, i5);
        this.f1769s = i6;
        this.f1770t = obj;
    }

    public final C0546m2 Q0(int i5, C0546m2 m2Var) {
        switch (this.f1769s) {
            case 0:
                return new C0563q(this, m2Var, 0);
            case 1:
                return new U(this, m2Var, 0);
            case 2:
                return new C0499d0(this, m2Var, 0);
            case 3:
                return new C0543m(this, m2Var, 1);
            case 4:
                return new C0543m(this, m2Var, 2);
            case 5:
                return new C0543m(this, m2Var, 3);
            default:
                return new C0538l(this, m2Var);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(C0506e2 e2Var, Consumer consumer) {
        super(e2Var, 0);
        this.f1769s = 3;
        this.f1770t = consumer;
    }
}
