package w3;

import b3.C2308e;
import b3.C2309f;
import b3.C2312i;
import b3.C2313j;
import kotlin.coroutines.jvm.internal.e;
import kotlin.jvm.internal.L;

public abstract class G {
    private static final C2312i d(C2312i iVar, C2312i iVar2, boolean z4) {
        boolean h5 = h(iVar);
        boolean h6 = h(iVar2);
        if (!h5 && !h6) {
            return iVar.plus(iVar2);
        }
        L l5 = new L();
        l5.f24690a = iVar2;
        C2313j jVar = C2313j.f20794a;
        C2312i iVar3 = (C2312i) iVar.fold(jVar, new C2858E(l5, z4));
        if (h6) {
            l5.f24690a = ((C2312i) l5.f24690a).fold(jVar, new C2859F());
        }
        return iVar3.plus((C2312i) l5.f24690a);
    }

    /* access modifiers changed from: private */
    public static final C2312i e(L l5, boolean z4, C2312i iVar, C2312i.b bVar) {
        return iVar.plus(bVar);
    }

    /* access modifiers changed from: private */
    public static final C2312i f(C2312i iVar, C2312i.b bVar) {
        return iVar.plus(bVar);
    }

    public static final String g(C2312i iVar) {
        return null;
    }

    private static final boolean h(C2312i iVar) {
        return ((Boolean) iVar.fold(Boolean.FALSE, new C2857D())).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final boolean i(boolean z4, C2312i.b bVar) {
        if (!z4) {
            return false;
        }
        return true;
    }

    public static final C2312i j(C2312i iVar, C2312i iVar2) {
        if (!h(iVar2)) {
            return iVar.plus(iVar2);
        }
        return d(iVar, iVar2, false);
    }

    public static final C2312i k(M m5, C2312i iVar) {
        C2312i d5 = d(m5.getCoroutineContext(), iVar, true);
        if (d5 == C2865c0.a() || d5.get(C2309f.f20792a0) != null) {
            return d5;
        }
        return d5.plus(C2865c0.a());
    }

    public static final b1 l(e eVar) {
        while (!(eVar instanceof Y) && (eVar = eVar.getCallerFrame()) != null) {
            if (eVar instanceof b1) {
                return (b1) eVar;
            }
        }
        return null;
    }

    public static final b1 m(C2308e eVar, C2312i iVar, Object obj) {
        if (!(eVar instanceof e) || iVar.get(c1.f26275a) == null) {
            return null;
        }
        b1 l5 = l((e) eVar);
        if (l5 != null) {
            l5.R0(iVar, obj);
        }
        return l5;
    }
}
