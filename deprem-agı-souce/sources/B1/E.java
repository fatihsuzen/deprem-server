package b1;

import T2.a;
import android.content.Context;
import d1.C1625b;

public final class E implements C1625b {

    /* renamed from: a  reason: collision with root package name */
    private final a f4525a;

    /* renamed from: b  reason: collision with root package name */
    private final a f4526b;

    public E(a aVar, a aVar2) {
        this.f4525a = aVar;
        this.f4526b = aVar2;
    }

    public static E a(a aVar, a aVar2) {
        return new E(aVar, aVar2);
    }

    public static C1015D c(Context context, c0 c0Var) {
        return new C1015D(context, c0Var);
    }

    /* renamed from: b */
    public C1015D get() {
        return c((Context) this.f4525a.get(), (c0) this.f4526b.get());
    }
}
