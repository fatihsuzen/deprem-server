package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import b3.C2308e;
import k3.p;
import w3.C2865c0;
import w3.C2872g;

public final class PausingDispatcherKt {
    public static final <T> Object whenCreated(LifecycleOwner lifecycleOwner, p pVar, C2308e eVar) {
        return whenCreated(lifecycleOwner.getLifecycle(), pVar, eVar);
    }

    public static final <T> Object whenResumed(LifecycleOwner lifecycleOwner, p pVar, C2308e eVar) {
        return whenResumed(lifecycleOwner.getLifecycle(), pVar, eVar);
    }

    public static final <T> Object whenStarted(LifecycleOwner lifecycleOwner, p pVar, C2308e eVar) {
        return whenStarted(lifecycleOwner.getLifecycle(), pVar, eVar);
    }

    public static final <T> Object whenStateAtLeast(Lifecycle lifecycle, Lifecycle.State state, p pVar, C2308e eVar) {
        return C2872g.g(C2865c0.c().F(), new PausingDispatcherKt$whenStateAtLeast$2(lifecycle, state, pVar, (C2308e) null), eVar);
    }

    public static final <T> Object whenCreated(Lifecycle lifecycle, p pVar, C2308e eVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.CREATED, pVar, eVar);
    }

    public static final <T> Object whenResumed(Lifecycle lifecycle, p pVar, C2308e eVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.RESUMED, pVar, eVar);
    }

    public static final <T> Object whenStarted(Lifecycle lifecycle, p pVar, C2308e eVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.STARTED, pVar, eVar);
    }
}
