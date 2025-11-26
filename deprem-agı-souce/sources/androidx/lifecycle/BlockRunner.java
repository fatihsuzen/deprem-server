package androidx.lifecycle;

import androidx.annotation.MainThread;
import b3.C2308e;
import b3.C2312i;
import java.util.concurrent.CancellationException;
import k3.C2616a;
import k3.p;
import kotlin.jvm.internal.t;
import w3.C2865c0;
import w3.C2908y0;
import w3.M;
import w3.O;

public final class BlockRunner<T> {
    /* access modifiers changed from: private */
    public final p block;
    private C2908y0 cancellationJob;
    /* access modifiers changed from: private */
    public final CoroutineLiveData<T> liveData;
    /* access modifiers changed from: private */
    public final C2616a onDone;
    /* access modifiers changed from: private */
    public C2908y0 runningJob;
    private final M scope;
    /* access modifiers changed from: private */
    public final long timeoutInMs;

    public BlockRunner(CoroutineLiveData<T> coroutineLiveData, p pVar, long j5, M m5, C2616a aVar) {
        t.e(coroutineLiveData, "liveData");
        t.e(pVar, "block");
        t.e(m5, "scope");
        t.e(aVar, "onDone");
        this.liveData = coroutineLiveData;
        this.block = pVar;
        this.timeoutInMs = j5;
        this.scope = m5;
        this.onDone = aVar;
    }

    @MainThread
    public final void cancel() {
        if (this.cancellationJob == null) {
            this.cancellationJob = C2876i.d(this.scope, C2865c0.c().F(), (O) null, new BlockRunner$cancel$1(this, (C2308e) null), 2, (Object) null);
            return;
        }
        throw new IllegalStateException("Cancel call cannot happen without a maybeRun");
    }

    @MainThread
    public final void maybeRun() {
        C2908y0 y0Var = this.cancellationJob;
        if (y0Var != null) {
            C2908y0.a.a(y0Var, (CancellationException) null, 1, (Object) null);
        }
        this.cancellationJob = null;
        if (this.runningJob == null) {
            this.runningJob = C2876i.d(this.scope, (C2312i) null, (O) null, new BlockRunner$maybeRun$1(this, (C2308e) null), 3, (Object) null);
        }
    }
}
