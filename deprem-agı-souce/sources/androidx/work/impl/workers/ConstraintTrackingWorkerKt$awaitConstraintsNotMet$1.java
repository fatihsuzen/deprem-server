package androidx.work.impl.workers;

import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import b3.C2308e;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.work.impl.workers.ConstraintTrackingWorkerKt", f = "ConstraintTrackingWorker.kt", l = {160}, m = "awaitConstraintsNotMet")
final class ConstraintTrackingWorkerKt$awaitConstraintsNotMet$1 extends d {
    int label;
    /* synthetic */ Object result;

    ConstraintTrackingWorkerKt$awaitConstraintsNotMet$1(C2308e eVar) {
        super(eVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ConstraintTrackingWorkerKt.awaitConstraintsNotMet((WorkConstraintsTracker) null, (WorkSpec) null, this);
    }
}
