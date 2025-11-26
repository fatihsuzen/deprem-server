package j$.util.stream;

import java.util.function.Supplier;

/* renamed from: j$.util.stream.o0  reason: case insensitive filesystem */
public final /* synthetic */ class C0554o0 implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1751a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C0583u0 f1752b;

    public /* synthetic */ C0554o0(C0583u0 u0Var, int i5) {
        this.f1751a = i5;
        this.f1752b = u0Var;
    }

    public final Object get() {
        switch (this.f1751a) {
            case 0:
                return new C0578t0(this.f1752b);
            case 1:
                return new C0578t0(this.f1752b);
            default:
                return new C0578t0(this.f1752b);
        }
    }
}
