package b1;

import T2.a;
import d1.C1625b;

public final class S implements C1625b {

    /* renamed from: a  reason: collision with root package name */
    private final a f4576a;

    /* renamed from: b  reason: collision with root package name */
    private final a f4577b;

    public S(a aVar, a aVar2) {
        this.f4576a = aVar;
        this.f4577b = aVar2;
    }

    public static S a(a aVar, a aVar2) {
        return new S(aVar, aVar2);
    }

    public static Q c(a0 a0Var, c0 c0Var) {
        return new Q(a0Var, c0Var);
    }

    /* renamed from: b */
    public Q get() {
        return c((a0) this.f4576a.get(), (c0) this.f4577b.get());
    }
}
