package j$.util.stream;

import java.util.function.LongConsumer;

/* renamed from: j$.util.stream.g0  reason: case insensitive filesystem */
public final class C0514g0 extends C0529j0 {

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f1708s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ Object f1709t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0514g0(C0483a aVar, int i5, Object obj, int i6) {
        super(aVar, i5);
        this.f1708s = i6;
        this.f1709t = obj;
    }

    public final C0546m2 Q0(int i5, C0546m2 m2Var) {
        switch (this.f1708s) {
            case 0:
                return new C0509f0(this, m2Var);
            case 1:
                return new C0499d0(this, m2Var, 5);
            case 2:
                return new Z1(this, m2Var);
            default:
                return new C0543m(this, m2Var, 5);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0514g0(C0534k0 k0Var, LongConsumer longConsumer) {
        super(k0Var, 0);
        this.f1708s = 1;
        this.f1709t = longConsumer;
    }
}
