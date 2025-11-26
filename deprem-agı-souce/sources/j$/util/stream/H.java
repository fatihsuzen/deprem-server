package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.E;
import java.util.function.LongConsumer;

public final class H extends J implements C0541l2 {

    /* renamed from: c  reason: collision with root package name */
    public static final E f1483c;

    /* renamed from: d  reason: collision with root package name */
    public static final E f1484d;

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return a.f(this, longConsumer);
    }

    public final void accept(long j5) {
        n((Object) Long.valueOf(j5));
    }

    public final Object get() {
        if (this.f1502a) {
            return new E(((Long) this.f1503b).longValue());
        }
        return null;
    }

    static {
        C0487a3 a3Var = C0487a3.LONG_VALUE;
        C0553o oVar = new C0553o(11);
        C0553o oVar2 = new C0553o(12);
        E e5 = E.f1261c;
        f1483c = new E(true, a3Var, e5, oVar, oVar2);
        E e6 = e5;
        f1484d = new E(false, a3Var, e6, new C0553o(11), new C0553o(12));
    }
}
