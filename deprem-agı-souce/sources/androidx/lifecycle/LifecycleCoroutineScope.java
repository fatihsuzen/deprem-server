package androidx.lifecycle;

import b3.C2308e;
import b3.C2312i;
import k3.p;
import kotlin.jvm.internal.t;
import w3.C2908y0;
import w3.M;
import w3.O;

public abstract class LifecycleCoroutineScope implements M {
    public abstract /* synthetic */ C2312i getCoroutineContext();

    public abstract Lifecycle getLifecycle$lifecycle_common();

    public final C2908y0 launchWhenCreated(p pVar) {
        t.e(pVar, "block");
        return C2876i.d(this, (C2312i) null, (O) null, new LifecycleCoroutineScope$launchWhenCreated$1(this, pVar, (C2308e) null), 3, (Object) null);
    }

    public final C2908y0 launchWhenResumed(p pVar) {
        t.e(pVar, "block");
        return C2876i.d(this, (C2312i) null, (O) null, new LifecycleCoroutineScope$launchWhenResumed$1(this, pVar, (C2308e) null), 3, (Object) null);
    }

    public final C2908y0 launchWhenStarted(p pVar) {
        t.e(pVar, "block");
        return C2876i.d(this, (C2312i) null, (O) null, new LifecycleCoroutineScope$launchWhenStarted$1(this, pVar, (C2308e) null), 3, (Object) null);
    }
}
