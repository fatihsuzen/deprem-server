package androidx.lifecycle;

import W2.J;
import androidx.lifecycle.Lifecycle;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import w3.N;

public final class RepeatOnLifecycleKt {
    public static final Object repeatOnLifecycle(Lifecycle lifecycle, Lifecycle.State state, p pVar, C2308e eVar) {
        if (state == Lifecycle.State.INITIALIZED) {
            throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.");
        } else if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            return J.f19942a;
        } else {
            Object d5 = N.d(new RepeatOnLifecycleKt$repeatOnLifecycle$3(lifecycle, state, pVar, (C2308e) null), eVar);
            return d5 == C2316b.f() ? d5 : J.f19942a;
        }
    }

    public static final Object repeatOnLifecycle(LifecycleOwner lifecycleOwner, Lifecycle.State state, p pVar, C2308e eVar) {
        Object repeatOnLifecycle = repeatOnLifecycle(lifecycleOwner.getLifecycle(), state, pVar, eVar);
        return repeatOnLifecycle == C2316b.f() ? repeatOnLifecycle : J.f19942a;
    }
}
