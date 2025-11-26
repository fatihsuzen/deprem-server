package androidx.work.impl;

import W2.J;
import androidx.work.ListenableWorker;
import k3.l;
import n0.C1722d;

final class WorkerWrapperKt$awaitWithin$2$1 implements l {
    final /* synthetic */ C1722d $this_awaitWithin;
    final /* synthetic */ ListenableWorker $worker;

    WorkerWrapperKt$awaitWithin$2$1(ListenableWorker listenableWorker, C1722d dVar) {
        this.$worker = listenableWorker;
        this.$this_awaitWithin = dVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return J.f19942a;
    }

    public final void invoke(Throwable th) {
        if (th instanceof WorkerStoppedException) {
            this.$worker.stop(((WorkerStoppedException) th).getReason());
        }
        this.$this_awaitWithin.cancel(false);
    }
}
