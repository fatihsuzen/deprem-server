package androidx.work.impl.constraints;

import X2.C2250q;
import android.os.Build;
import androidx.work.Logger;
import androidx.work.impl.constraints.controllers.BatteryChargingController;
import androidx.work.impl.constraints.controllers.BatteryNotLowController;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.constraints.controllers.NetworkConnectedController;
import androidx.work.impl.constraints.controllers.NetworkMeteredController;
import androidx.work.impl.constraints.controllers.NetworkNotRoamingController;
import androidx.work.impl.constraints.controllers.NetworkUnmeteredController;
import androidx.work.impl.constraints.controllers.StorageNotLowController;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;
import z3.C2972e;
import z3.C2974g;

public final class WorkConstraintsTracker {
    private final List<ConstraintController> controllers;

    public WorkConstraintsTracker(List<? extends ConstraintController> list) {
        t.e(list, "controllers");
        this.controllers = list;
    }

    /* access modifiers changed from: private */
    public static final CharSequence areAllConstraintsMet$lambda$5(ConstraintController constraintController) {
        t.e(constraintController, "it");
        String simpleName = constraintController.getClass().getSimpleName();
        t.d(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public final boolean areAllConstraintsMet(WorkSpec workSpec) {
        t.e(workSpec, "workSpec");
        ArrayList arrayList = new ArrayList();
        for (Object next : this.controllers) {
            if (((ConstraintController) next).isCurrentlyConstrained(workSpec)) {
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            Logger logger = Logger.get();
            String access$getTAG$p = WorkConstraintsTrackerKt.TAG;
            logger.debug(access$getTAG$p, "Work " + workSpec.id + " constrained by " + C2250q.V(arrayList, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new g(), 31, (Object) null));
        }
        return arrayList.isEmpty();
    }

    public final C2972e track(WorkSpec workSpec) {
        t.e(workSpec, "spec");
        ArrayList arrayList = new ArrayList();
        for (Object next : this.controllers) {
            if (((ConstraintController) next).hasConstraint(workSpec)) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(C2250q.p(arrayList, 10));
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            arrayList2.add(((ConstraintController) obj).track(workSpec.constraints));
        }
        return C2974g.j(new WorkConstraintsTracker$track$$inlined$combine$1((C2972e[]) C2250q.n0(arrayList2).toArray(new C2972e[0])));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WorkConstraintsTracker(Trackers trackers) {
        this((List<? extends ConstraintController>) C2250q.k(new BatteryChargingController(trackers.getBatteryChargingTracker()), new BatteryNotLowController(trackers.getBatteryNotLowTracker()), new StorageNotLowController(trackers.getStorageNotLowTracker()), new NetworkConnectedController(trackers.getNetworkStateTracker()), new NetworkUnmeteredController(trackers.getNetworkStateTracker()), new NetworkNotRoamingController(trackers.getNetworkStateTracker()), new NetworkMeteredController(trackers.getNetworkStateTracker()), Build.VERSION.SDK_INT >= 28 ? WorkConstraintsTrackerKt.NetworkRequestConstraintController(trackers.getContext()) : null));
        t.e(trackers, "trackers");
    }
}
