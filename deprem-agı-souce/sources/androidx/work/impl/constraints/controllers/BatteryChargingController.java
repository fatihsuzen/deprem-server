package androidx.work.impl.constraints.controllers;

import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import kotlin.jvm.internal.t;

public final class BatteryChargingController extends BaseConstraintController<Boolean> {
    private final int reason = 6;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BatteryChargingController(ConstraintTracker<Boolean> constraintTracker) {
        super(constraintTracker);
        t.e(constraintTracker, "tracker");
    }

    /* access modifiers changed from: protected */
    public int getReason() {
        return this.reason;
    }

    public boolean hasConstraint(WorkSpec workSpec) {
        t.e(workSpec, "workSpec");
        return workSpec.constraints.requiresCharging();
    }

    /* access modifiers changed from: protected */
    public boolean isConstrained(boolean z4) {
        return !z4;
    }

    public /* bridge */ /* synthetic */ boolean isConstrained(Object obj) {
        return isConstrained(((Boolean) obj).booleanValue());
    }
}
