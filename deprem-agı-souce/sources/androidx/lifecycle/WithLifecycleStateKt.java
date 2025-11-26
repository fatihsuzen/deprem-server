package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import b3.C2308e;
import b3.C2313j;
import c3.C2316b;
import k3.C2616a;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.r;
import w3.C2865c0;
import w3.C2886n;
import w3.I;
import w3.I0;

public final class WithLifecycleStateKt {
    public static final <R> Object suspendWithStateAtLeastUnchecked(Lifecycle lifecycle, Lifecycle.State state, boolean z4, I i5, C2616a aVar, C2308e eVar) {
        C2886n nVar = new C2886n(C2316b.c(eVar), 1);
        nVar.D();
        WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 = new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1(state, lifecycle, nVar, aVar);
        if (z4) {
            i5.dispatch(C2313j.f20794a, new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$1(lifecycle, withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1));
        } else {
            lifecycle.addObserver(withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1);
        }
        nVar.g(new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2(i5, lifecycle, withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1));
        Object x4 = nVar.x();
        if (x4 == C2316b.f()) {
            h.c(eVar);
        }
        return x4;
    }

    public static final <R> Object withCreated(Lifecycle lifecycle, C2616a aVar, C2308e eVar) {
        Lifecycle.State state = Lifecycle.State.CREATED;
        I0 F4 = C2865c0.c().F();
        boolean isDispatchNeeded = F4.isDispatchNeeded(eVar.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            } else if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, F4, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), eVar);
    }

    private static final <R> Object withCreated$$forInline(Lifecycle lifecycle, C2616a aVar, C2308e eVar) {
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        C2865c0.c().F();
        r.c(3);
        throw null;
    }

    public static final <R> Object withResumed(Lifecycle lifecycle, C2616a aVar, C2308e eVar) {
        Lifecycle.State state = Lifecycle.State.RESUMED;
        I0 F4 = C2865c0.c().F();
        boolean isDispatchNeeded = F4.isDispatchNeeded(eVar.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            } else if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, F4, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), eVar);
    }

    private static final <R> Object withResumed$$forInline(Lifecycle lifecycle, C2616a aVar, C2308e eVar) {
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        C2865c0.c().F();
        r.c(3);
        throw null;
    }

    public static final <R> Object withStarted(Lifecycle lifecycle, C2616a aVar, C2308e eVar) {
        Lifecycle.State state = Lifecycle.State.STARTED;
        I0 F4 = C2865c0.c().F();
        boolean isDispatchNeeded = F4.isDispatchNeeded(eVar.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            } else if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, F4, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), eVar);
    }

    private static final <R> Object withStarted$$forInline(Lifecycle lifecycle, C2616a aVar, C2308e eVar) {
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        C2865c0.c().F();
        r.c(3);
        throw null;
    }

    public static final <R> Object withStateAtLeast(Lifecycle lifecycle, Lifecycle.State state, C2616a aVar, C2308e eVar) {
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            I0 F4 = C2865c0.c().F();
            boolean isDispatchNeeded = F4.isDispatchNeeded(eVar.getContext());
            if (!isDispatchNeeded) {
                if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                    throw new LifecycleDestroyedException();
                } else if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            }
            return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, F4, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), eVar);
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }

    private static final <R> Object withStateAtLeast$$forInline(Lifecycle lifecycle, Lifecycle.State state, C2616a aVar, C2308e eVar) {
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            C2865c0.c().F();
            r.c(3);
            throw null;
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }

    public static final <R> Object withStateAtLeastUnchecked(Lifecycle lifecycle, Lifecycle.State state, C2616a aVar, C2308e eVar) {
        I0 F4 = C2865c0.c().F();
        boolean isDispatchNeeded = F4.isDispatchNeeded(eVar.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            } else if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, F4, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), eVar);
    }

    private static final <R> Object withStateAtLeastUnchecked$$forInline(Lifecycle lifecycle, Lifecycle.State state, C2616a aVar, C2308e eVar) {
        C2865c0.c().F();
        r.c(3);
        throw null;
    }

    private static final <R> Object withCreated$$forInline(LifecycleOwner lifecycleOwner, C2616a aVar, C2308e eVar) {
        lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        C2865c0.c().F();
        r.c(3);
        throw null;
    }

    private static final <R> Object withResumed$$forInline(LifecycleOwner lifecycleOwner, C2616a aVar, C2308e eVar) {
        lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        C2865c0.c().F();
        r.c(3);
        throw null;
    }

    private static final <R> Object withStarted$$forInline(LifecycleOwner lifecycleOwner, C2616a aVar, C2308e eVar) {
        lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        C2865c0.c().F();
        r.c(3);
        throw null;
    }

    private static final <R> Object withStateAtLeast$$forInline(LifecycleOwner lifecycleOwner, Lifecycle.State state, C2616a aVar, C2308e eVar) {
        lifecycleOwner.getLifecycle();
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            C2865c0.c().F();
            r.c(3);
            throw null;
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }

    public static final <R> Object withCreated(LifecycleOwner lifecycleOwner, C2616a aVar, C2308e eVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.CREATED;
        I0 F4 = C2865c0.c().F();
        boolean isDispatchNeeded = F4.isDispatchNeeded(eVar.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            } else if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, F4, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), eVar);
    }

    public static final <R> Object withResumed(LifecycleOwner lifecycleOwner, C2616a aVar, C2308e eVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.RESUMED;
        I0 F4 = C2865c0.c().F();
        boolean isDispatchNeeded = F4.isDispatchNeeded(eVar.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            } else if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, F4, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), eVar);
    }

    public static final <R> Object withStarted(LifecycleOwner lifecycleOwner, C2616a aVar, C2308e eVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.STARTED;
        I0 F4 = C2865c0.c().F();
        boolean isDispatchNeeded = F4.isDispatchNeeded(eVar.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            } else if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, F4, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), eVar);
    }

    public static final <R> Object withStateAtLeast(LifecycleOwner lifecycleOwner, Lifecycle.State state, C2616a aVar, C2308e eVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            I0 F4 = C2865c0.c().F();
            boolean isDispatchNeeded = F4.isDispatchNeeded(eVar.getContext());
            if (!isDispatchNeeded) {
                if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                    throw new LifecycleDestroyedException();
                } else if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            }
            return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, F4, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), eVar);
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }
}
