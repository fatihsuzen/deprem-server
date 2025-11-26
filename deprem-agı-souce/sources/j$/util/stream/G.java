package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.D;
import java.util.function.IntConsumer;

public final class G extends J implements C0536k2 {

    /* renamed from: c  reason: collision with root package name */
    public static final E f1477c;

    /* renamed from: d  reason: collision with root package name */
    public static final E f1478d;

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return a.e(this, intConsumer);
    }

    public final void accept(int i5) {
        n((Object) Integer.valueOf(i5));
    }

    public final Object get() {
        if (this.f1502a) {
            return new D(((Integer) this.f1503b).intValue());
        }
        return null;
    }

    static {
        C0487a3 a3Var = C0487a3.INT_VALUE;
        C0553o oVar = new C0553o(9);
        C0553o oVar2 = new C0553o(10);
        D d5 = D.f1258c;
        f1477c = new E(true, a3Var, d5, oVar, oVar2);
        D d6 = d5;
        f1478d = new E(false, a3Var, d6, new C0553o(9), new C0553o(10));
    }
}
