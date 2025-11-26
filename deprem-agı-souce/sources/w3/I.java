package w3;

import B3.C1988h;
import B3.C1991k;
import B3.C1992l;
import b3.C2304a;
import b3.C2305b;
import b3.C2308e;
import b3.C2309f;
import b3.C2312i;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public abstract class I extends C2304a implements C2309f {
    public static final a Key = new a((C2633k) null);

    public static final class a extends C2305b {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        /* access modifiers changed from: private */
        public static final I d(C2312i.b bVar) {
            if (bVar instanceof I) {
                return (I) bVar;
            }
            return null;
        }

        private a() {
            super(C2309f.f20792a0, new H());
        }
    }

    public I() {
        super(C2309f.f20792a0);
    }

    public static /* synthetic */ I limitedParallelism$default(I i5, int i6, String str, int i7, Object obj) {
        if (obj == null) {
            if ((i7 & 2) != 0) {
                str = null;
            }
            return i5.limitedParallelism(i6, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: limitedParallelism");
    }

    public abstract void dispatch(C2312i iVar, Runnable runnable);

    public void dispatchYield(C2312i iVar, Runnable runnable) {
        dispatch(iVar, runnable);
    }

    public <E extends C2312i.b> E get(C2312i.c cVar) {
        return C2309f.a.a(this, cVar);
    }

    public final <T> C2308e interceptContinuation(C2308e eVar) {
        return new C1988h(this, eVar);
    }

    public boolean isDispatchNeeded(C2312i iVar) {
        return true;
    }

    public I limitedParallelism(int i5, String str) {
        C1992l.a(i5);
        return new C1991k(this, i5, str);
    }

    public C2312i minusKey(C2312i.c cVar) {
        return C2309f.a.b(this, cVar);
    }

    public final void releaseInterceptedContinuation(C2308e eVar) {
        t.c(eVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        ((C1988h) eVar).t();
    }

    public String toString() {
        return Q.a(this) + '@' + Q.b(this);
    }

    public /* synthetic */ I limitedParallelism(int i5) {
        return limitedParallelism(i5, (String) null);
    }

    public final I plus(I i5) {
        return i5;
    }
}
