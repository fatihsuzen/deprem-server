package N;

import L.g;
import L.j;
import k0.C1698l;
import k0.C1699m;

/* renamed from: N.o  reason: case insensitive filesystem */
public abstract class C0721o {

    /* renamed from: a  reason: collision with root package name */
    private static final L f3130a = new I();

    /* renamed from: N.o$a */
    public interface a {
        Object a(j jVar);
    }

    public static C1698l a(g gVar, a aVar) {
        L l5 = f3130a;
        C1699m mVar = new C1699m();
        gVar.a(new J(gVar, mVar, aVar, l5));
        return mVar.a();
    }

    public static C1698l b(g gVar) {
        return a(gVar, new K());
    }
}
