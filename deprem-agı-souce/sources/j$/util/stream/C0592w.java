package j$.util.stream;

import java.util.function.DoubleConsumer;

/* renamed from: j$.util.stream.w  reason: case insensitive filesystem */
public final class C0592w extends C0607z {

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f1812s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ Object f1813t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0592w(C0483a aVar, int i5, Object obj, int i6) {
        super(aVar, i5);
        this.f1812s = i6;
        this.f1813t = obj;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0592w(A a5, DoubleConsumer doubleConsumer) {
        super(a5, 0);
        this.f1812s = 1;
        this.f1813t = doubleConsumer;
    }

    public final C0546m2 Q0(int i5, C0546m2 m2Var) {
        switch (this.f1812s) {
            case 0:
                return new C0587v(this, m2Var);
            case 1:
                return new C0563q(this, m2Var, 5);
            case 2:
                return new C0543m(this, m2Var, 6);
            default:
                return new Z1(this, m2Var);
        }
    }
}
