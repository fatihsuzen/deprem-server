package e1;

import T2.a;
import d1.C1625b;

public final class k implements C1625b {

    /* renamed from: a  reason: collision with root package name */
    private final a f15281a;

    /* renamed from: b  reason: collision with root package name */
    private final a f15282b;

    public k(a aVar, a aVar2) {
        this.f15281a = aVar;
        this.f15282b = aVar2;
    }

    public static k a(a aVar, a aVar2) {
        return new k(aVar, aVar2);
    }

    public static j c(o oVar, o oVar2) {
        return new j(oVar, oVar2);
    }

    /* renamed from: b */
    public j get() {
        return c((o) this.f15281a.get(), (o) this.f15282b.get());
    }
}
