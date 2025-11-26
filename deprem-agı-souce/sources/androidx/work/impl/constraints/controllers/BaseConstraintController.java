package androidx.work.impl.constraints.controllers;

import androidx.work.Constraints;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import b3.C2308e;
import kotlin.jvm.internal.t;
import z3.C2972e;
import z3.C2974g;

public abstract class BaseConstraintController<T> implements ConstraintController {
    /* access modifiers changed from: private */
    public final ConstraintTracker<T> tracker;

    public BaseConstraintController(ConstraintTracker<T> constraintTracker) {
        t.e(constraintTracker, "tracker");
        this.tracker = constraintTracker;
    }

    protected static /* synthetic */ void getReason$annotations() {
    }

    /* access modifiers changed from: protected */
    public abstract int getReason();

    /* access modifiers changed from: protected */
    public boolean isConstrained(T t5) {
        return false;
    }

    public boolean isCurrentlyConstrained(WorkSpec workSpec) {
        t.e(workSpec, "workSpec");
        if (!hasConstraint(workSpec) || !isConstrained(this.tracker.readSystemState())) {
            return false;
        }
        return true;
    }

    public C2972e track(Constraints constraints) {
        t.e(constraints, "constraints");
        return C2974g.d(new BaseConstraintController$track$1(this, (C2308e) null));
    }
}
