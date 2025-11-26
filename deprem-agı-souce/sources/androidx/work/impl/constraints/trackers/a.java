package androidx.work.impl.constraints.trackers;

import java.util.List;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f551a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ConstraintTracker f552b;

    public /* synthetic */ a(List list, ConstraintTracker constraintTracker) {
        this.f551a = list;
        this.f552b = constraintTracker;
    }

    public final void run() {
        ConstraintTracker._set_state_$lambda$4$lambda$3(this.f551a, this.f552b);
    }
}
