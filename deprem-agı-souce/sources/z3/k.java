package z3;

import A3.h;
import A3.o;
import b3.C2312i;
import b3.C2313j;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import w3.C2908y0;
import y3.C2928a;

abstract /* synthetic */ class k {
    public static final C2972e a(C2972e eVar, int i5, C2928a aVar) {
        if (i5 < 0 && i5 != -2 && i5 != -1) {
            throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + i5).toString());
        } else if (i5 != -1 || aVar == C2928a.SUSPEND) {
            if (i5 == -1) {
                aVar = C2928a.DROP_OLDEST;
                i5 = 0;
            }
            int i6 = i5;
            C2928a aVar2 = aVar;
            if (eVar instanceof o) {
                return o.a.a((o) eVar, (C2312i) null, i6, aVar2, 1, (Object) null);
            }
            return new h(eVar, (C2312i) null, i6, aVar2, 2, (C2633k) null);
        } else {
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
        }
    }

    public static /* synthetic */ C2972e b(C2972e eVar, int i5, C2928a aVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i5 = -2;
        }
        if ((i6 & 2) != 0) {
            aVar = C2928a.SUSPEND;
        }
        return C2974g.b(eVar, i5, aVar);
    }

    private static final void c(C2312i iVar) {
        if (iVar.get(C2908y0.f26320k0) != null) {
            throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + iVar).toString());
        }
    }

    public static final C2972e d(C2972e eVar) {
        return b(eVar, -1, (C2928a) null, 2, (Object) null);
    }

    public static final C2972e e(C2972e eVar, C2312i iVar) {
        c(iVar);
        if (t.a(iVar, C2313j.f20794a)) {
            return eVar;
        }
        if (eVar instanceof o) {
            return o.a.a((o) eVar, iVar, 0, (C2928a) null, 6, (Object) null);
        }
        return new h(eVar, iVar, 0, (C2928a) null, 12, (C2633k) null);
    }
}
