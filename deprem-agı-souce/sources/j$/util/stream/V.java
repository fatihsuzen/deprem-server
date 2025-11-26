package j$.util.stream;

import java.util.function.IntConsumer;

public final class V extends C0484a0 {

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f1593s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ Object f1594t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ V(C0483a aVar, int i5, Object obj, int i6) {
        super(aVar, i5);
        this.f1593s = i6;
        this.f1594t = obj;
    }

    public final C0546m2 Q0(int i5, C0546m2 m2Var) {
        switch (this.f1593s) {
            case 0:
                return new U(this, m2Var, 1);
            case 1:
                return new X(this, m2Var);
            case 2:
                return new C0543m(this, m2Var, 4);
            default:
                return new Z1(this, m2Var);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public V(C0489b0 b0Var, IntConsumer intConsumer) {
        super(b0Var, 0);
        this.f1593s = 0;
        this.f1594t = intConsumer;
    }
}
