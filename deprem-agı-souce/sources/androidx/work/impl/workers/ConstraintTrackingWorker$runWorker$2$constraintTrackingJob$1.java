package androidx.work.impl.workers;

import W2.J;
import W2.u;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import b3.C2308e;
import c3.C2316b;
import java.util.concurrent.atomic.AtomicInteger;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import n0.C1722d;
import w3.M;

@f(c = "androidx.work.impl.workers.ConstraintTrackingWorker$runWorker$2$constraintTrackingJob$1", f = "ConstraintTrackingWorker.kt", l = {129}, m = "invokeSuspend")
final class ConstraintTrackingWorker$runWorker$2$constraintTrackingJob$1 extends l implements p {
    final /* synthetic */ AtomicInteger $atomicReason;
    final /* synthetic */ C1722d $future;
    final /* synthetic */ WorkConstraintsTracker $workConstraintsTracker;
    final /* synthetic */ WorkSpec $workSpec;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConstraintTrackingWorker$runWorker$2$constraintTrackingJob$1(WorkConstraintsTracker workConstraintsTracker, WorkSpec workSpec, AtomicInteger atomicInteger, C1722d dVar, C2308e eVar) {
        super(2, eVar);
        this.$workConstraintsTracker = workConstraintsTracker;
        this.$workSpec = workSpec;
        this.$atomicReason = atomicInteger;
        this.$future = dVar;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new ConstraintTrackingWorker$runWorker$2$constraintTrackingJob$1(this.$workConstraintsTracker, this.$workSpec, this.$atomicReason, this.$future, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            WorkConstraintsTracker workConstraintsTracker = this.$workConstraintsTracker;
            WorkSpec workSpec = this.$workSpec;
            this.label = 1;
            obj = ConstraintTrackingWorkerKt.awaitConstraintsNotMet(workConstraintsTracker, workSpec, this);
            if (obj == f5) {
                return f5;
            }
        } else if (i5 == 1) {
            u.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$atomicReason.set(((Number) obj).intValue());
        this.$future.cancel(true);
        return J.f19942a;
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((ConstraintTrackingWorker$runWorker$2$constraintTrackingJob$1) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
