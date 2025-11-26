package y0;

import androidx.privacysandbox.ads.adservices.adid.i;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import k0.C1688b;
import k0.C1698l;
import k0.C1699m;
import k0.C1701o;

/* renamed from: y0.b  reason: case insensitive filesystem */
public abstract class C1938b {

    /* renamed from: a  reason: collision with root package name */
    private static final Executor f17076a = new i();

    public static /* synthetic */ C1698l a(C1699m mVar, AtomicBoolean atomicBoolean, C1688b bVar, C1698l lVar) {
        if (lVar.n()) {
            mVar.e(lVar.j());
        } else if (lVar.i() != null) {
            mVar.d(lVar.i());
        } else if (atomicBoolean.getAndSet(true)) {
            bVar.a();
        }
        return C1701o.e((Object) null);
    }

    public static C1698l b(C1698l lVar, C1698l lVar2) {
        C1688b bVar = new C1688b();
        C1699m mVar = new C1699m(bVar.b());
        C1937a aVar = new C1937a(mVar, new AtomicBoolean(false), bVar);
        Executor executor = f17076a;
        lVar.h(executor, aVar);
        lVar2.h(executor, aVar);
        return mVar.a();
    }
}
