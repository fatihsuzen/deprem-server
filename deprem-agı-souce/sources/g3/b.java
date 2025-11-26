package G3;

import W2.J;
import W2.t;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import java.util.concurrent.CancellationException;
import k0.C1688b;
import k0.C1692f;
import k0.C1698l;
import k3.l;
import kotlin.coroutines.jvm.internal.h;
import w3.C2882l;
import w3.C2886n;

public abstract class b {

    static final class a implements C1692f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2882l f18184a;

        a(C2882l lVar) {
            this.f18184a = lVar;
        }

        public final void a(C1698l lVar) {
            Exception i5 = lVar.i();
            if (i5 != null) {
                C2882l lVar2 = this.f18184a;
                t.a aVar = t.f19966b;
                lVar2.resumeWith(t.b(u.a(i5)));
            } else if (lVar.l()) {
                C2882l.a.a(this.f18184a, (Throwable) null, 1, (Object) null);
            } else {
                C2882l lVar3 = this.f18184a;
                t.a aVar2 = t.f19966b;
                lVar3.resumeWith(t.b(lVar.j()));
            }
        }
    }

    /* renamed from: G3.b$b  reason: collision with other inner class name */
    static final class C0177b implements l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1688b f18185a;

        C0177b(C1688b bVar) {
            this.f18185a = bVar;
        }

        public final void a(Throwable th) {
            this.f18185a.a();
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return J.f19942a;
        }
    }

    public static final Object a(C1698l lVar, C2308e eVar) {
        return b(lVar, (C1688b) null, eVar);
    }

    private static final Object b(C1698l lVar, C1688b bVar, C2308e eVar) {
        if (lVar.m()) {
            Exception i5 = lVar.i();
            if (i5 != null) {
                throw i5;
            } else if (!lVar.l()) {
                return lVar.j();
            } else {
                throw new CancellationException("Task " + lVar + " was cancelled normally.");
            }
        } else {
            C2886n nVar = new C2886n(C2316b.c(eVar), 1);
            nVar.D();
            lVar.b(a.f18183a, new a(nVar));
            if (bVar != null) {
                nVar.g(new C0177b(bVar));
            }
            Object x4 = nVar.x();
            if (x4 == C2316b.f()) {
                h.c(eVar);
            }
            return x4;
        }
    }
}
