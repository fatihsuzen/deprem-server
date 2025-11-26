package androidx.work.impl.workers;

import W2.J;
import W2.u;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.model.WorkSpec;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;

@f(c = "androidx.work.impl.workers.ConstraintTrackingWorkerKt$awaitConstraintsNotMet$2", f = "ConstraintTrackingWorker.kt", l = {}, m = "invokeSuspend")
final class ConstraintTrackingWorkerKt$awaitConstraintsNotMet$2 extends l implements p {
    final /* synthetic */ WorkSpec $workSpec;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConstraintTrackingWorkerKt$awaitConstraintsNotMet$2(WorkSpec workSpec, C2308e eVar) {
        super(2, eVar);
        this.$workSpec = workSpec;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new ConstraintTrackingWorkerKt$awaitConstraintsNotMet$2(this.$workSpec, eVar);
    }

    public final Object invoke(ConstraintsState constraintsState, C2308e eVar) {
        return ((ConstraintTrackingWorkerKt$awaitConstraintsNotMet$2) create(constraintsState, eVar)).invokeSuspend(J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        C2316b.f();
        if (this.label == 0) {
            u.b(obj);
            String access$getTAG$p = ConstraintTrackingWorkerKt.TAG;
            WorkSpec workSpec = this.$workSpec;
            Logger logger = Logger.get();
            logger.debug(access$getTAG$p, "Constraints changed for " + workSpec);
            return J.f19942a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
