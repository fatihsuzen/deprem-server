package androidx.work.impl.workers;

import androidx.work.Logger;
import kotlin.jvm.internal.t;

public final class ConstraintTrackingWorkerKt {
    public static final String ARGUMENT_CLASS_NAME = "androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME";
    /* access modifiers changed from: private */
    public static final String TAG;

    static {
        String tagWithPrefix = Logger.tagWithPrefix("ConstraintTrkngWrkr");
        t.d(tagWithPrefix, "tagWithPrefix(...)");
        TAG = tagWithPrefix;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object awaitConstraintsNotMet(androidx.work.impl.constraints.WorkConstraintsTracker r4, androidx.work.impl.model.WorkSpec r5, b3.C2308e r6) {
        /*
            boolean r0 = r6 instanceof androidx.work.impl.workers.ConstraintTrackingWorkerKt$awaitConstraintsNotMet$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            androidx.work.impl.workers.ConstraintTrackingWorkerKt$awaitConstraintsNotMet$1 r0 = (androidx.work.impl.workers.ConstraintTrackingWorkerKt$awaitConstraintsNotMet$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.work.impl.workers.ConstraintTrackingWorkerKt$awaitConstraintsNotMet$1 r0 = new androidx.work.impl.workers.ConstraintTrackingWorkerKt$awaitConstraintsNotMet$1
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            W2.u.b(r6)
            goto L_0x0050
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            W2.u.b(r6)
            z3.e r4 = r4.track(r5)
            androidx.work.impl.workers.ConstraintTrackingWorkerKt$awaitConstraintsNotMet$2 r6 = new androidx.work.impl.workers.ConstraintTrackingWorkerKt$awaitConstraintsNotMet$2
            r2 = 0
            r6.<init>(r5, r2)
            z3.e r4 = z3.C2974g.w(r4, r6)
            androidx.work.impl.workers.ConstraintTrackingWorkerKt$awaitConstraintsNotMet$$inlined$filterIsInstance$1 r5 = new androidx.work.impl.workers.ConstraintTrackingWorkerKt$awaitConstraintsNotMet$$inlined$filterIsInstance$1
            r5.<init>(r4)
            r0.label = r3
            java.lang.Object r6 = z3.C2974g.o(r5, r0)
            if (r6 != r1) goto L_0x0050
            return r1
        L_0x0050:
            androidx.work.impl.constraints.ConstraintsState$ConstraintsNotMet r6 = (androidx.work.impl.constraints.ConstraintsState.ConstraintsNotMet) r6
            int r4 = r6.getReason()
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.b.b(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.workers.ConstraintTrackingWorkerKt.awaitConstraintsNotMet(androidx.work.impl.constraints.WorkConstraintsTracker, androidx.work.impl.model.WorkSpec, b3.e):java.lang.Object");
    }
}
