package androidx.lifecycle;

import b3.C2308e;
import kotlin.jvm.internal.t;
import w3.C2865c0;
import w3.C2908y0;
import w3.T0;
import z3.C2972e;
import z3.C2974g;

public final class LifecycleKt {
    public static final LifecycleCoroutineScope getCoroutineScope(Lifecycle lifecycle) {
        LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl;
        t.e(lifecycle, "<this>");
        do {
            LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl2 = (LifecycleCoroutineScopeImpl) lifecycle.getInternalScopeRef().get();
            if (lifecycleCoroutineScopeImpl2 != null) {
                return lifecycleCoroutineScopeImpl2;
            }
            lifecycleCoroutineScopeImpl = new LifecycleCoroutineScopeImpl(lifecycle, T0.b((C2908y0) null, 1, (Object) null).plus(C2865c0.c().F()));
        } while (!lifecycle.getInternalScopeRef().compareAndSet(null, lifecycleCoroutineScopeImpl));
        lifecycleCoroutineScopeImpl.register();
        return lifecycleCoroutineScopeImpl;
    }

    public static final C2972e getEventFlow(Lifecycle lifecycle) {
        t.e(lifecycle, "<this>");
        return C2974g.r(C2974g.d(new LifecycleKt$eventFlow$1(lifecycle, (C2308e) null)), C2865c0.c().F());
    }
}
