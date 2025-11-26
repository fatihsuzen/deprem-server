package y3;

import B3.S;
import B3.w;
import W2.C2216e;
import W2.J;
import b3.C2308e;
import k3.l;
import kotlin.jvm.internal.M;
import y3.C2938k;

public class s extends C2932e {

    /* renamed from: m  reason: collision with root package name */
    private final int f26447m;

    /* renamed from: n  reason: collision with root package name */
    private final C2928a f26448n;

    public s(int i5, C2928a aVar, l lVar) {
        super(i5, lVar);
        this.f26447m = i5;
        this.f26448n = aVar;
        if (aVar == C2928a.SUSPEND) {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + M.b(C2932e.class).c() + " instead").toString());
        } else if (i5 < 1) {
            throw new IllegalArgumentException(("Buffered channel capacity must be at least 1, but " + i5 + " was specified").toString());
        }
    }

    static /* synthetic */ Object o1(s sVar, Object obj, C2308e eVar) {
        S c5;
        Object q12 = sVar.q1(obj, true);
        if (!(q12 instanceof C2938k.a)) {
            return J.f19942a;
        }
        C2938k.e(q12);
        l lVar = sVar.f26398b;
        if (lVar == null || (c5 = w.c(lVar, obj, (S) null, 2, (Object) null)) == null) {
            throw sVar.j0();
        }
        C2216e.a(c5, sVar.j0());
        throw c5;
    }

    private final Object p1(Object obj, boolean z4) {
        l lVar;
        S c5;
        Object r5 = super.r(obj);
        if (C2938k.i(r5) || C2938k.h(r5)) {
            return r5;
        }
        if (!z4 || (lVar = this.f26398b) == null || (c5 = w.c(lVar, obj, (S) null, 2, (Object) null)) == null) {
            return C2938k.f26437b.c(J.f19942a);
        }
        throw c5;
    }

    private final Object q1(Object obj, boolean z4) {
        if (this.f26448n == C2928a.DROP_LATEST) {
            return p1(obj, z4);
        }
        return e1(obj);
    }

    public Object e(Object obj, C2308e eVar) {
        return o1(this, obj, eVar);
    }

    public Object r(Object obj) {
        return q1(obj, false);
    }

    /* access modifiers changed from: protected */
    public boolean x0() {
        if (this.f26448n == C2928a.DROP_OLDEST) {
            return true;
        }
        return false;
    }
}
