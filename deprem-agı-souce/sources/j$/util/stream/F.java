package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.C;
import java.util.function.DoubleConsumer;

public final class F extends J implements C0531j2 {

    /* renamed from: c  reason: collision with root package name */
    public static final E f1472c;

    /* renamed from: d  reason: collision with root package name */
    public static final E f1473d;

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return a.d(this, doubleConsumer);
    }

    public final void accept(double d5) {
        n((Object) Double.valueOf(d5));
    }

    public final Object get() {
        if (this.f1502a) {
            return new C(((Double) this.f1503b).doubleValue());
        }
        return null;
    }

    static {
        C0487a3 a3Var = C0487a3.DOUBLE_VALUE;
        C0553o oVar = new C0553o(7);
        C0553o oVar2 = new C0553o(8);
        C c5 = C.f1255c;
        f1472c = new E(true, a3Var, c5, oVar, oVar2);
        C c6 = c5;
        f1473d = new E(false, a3Var, c6, new C0553o(7), new C0553o(8));
    }
}
