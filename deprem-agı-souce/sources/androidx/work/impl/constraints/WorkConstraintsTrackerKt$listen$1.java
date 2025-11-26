package androidx.work.impl.constraints;

import W2.J;
import W2.u;
import androidx.work.impl.model.WorkSpec;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.M;
import z3.C2972e;
import z3.C2973f;

@f(c = "androidx.work.impl.constraints.WorkConstraintsTrackerKt$listen$1", f = "WorkConstraintsTracker.kt", l = {67}, m = "invokeSuspend")
final class WorkConstraintsTrackerKt$listen$1 extends l implements p {
    final /* synthetic */ OnConstraintsStateChangedListener $listener;
    final /* synthetic */ WorkSpec $spec;
    final /* synthetic */ WorkConstraintsTracker $this_listen;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WorkConstraintsTrackerKt$listen$1(WorkConstraintsTracker workConstraintsTracker, WorkSpec workSpec, OnConstraintsStateChangedListener onConstraintsStateChangedListener, C2308e eVar) {
        super(2, eVar);
        this.$this_listen = workConstraintsTracker;
        this.$spec = workSpec;
        this.$listener = onConstraintsStateChangedListener;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new WorkConstraintsTrackerKt$listen$1(this.$this_listen, this.$spec, this.$listener, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            C2972e track = this.$this_listen.track(this.$spec);
            final OnConstraintsStateChangedListener onConstraintsStateChangedListener = this.$listener;
            final WorkSpec workSpec = this.$spec;
            AnonymousClass1 r12 = new C2973f() {
                public final Object emit(ConstraintsState constraintsState, C2308e eVar) {
                    onConstraintsStateChangedListener.onConstraintsStateChanged(workSpec, constraintsState);
                    return J.f19942a;
                }
            };
            this.label = 1;
            if (track.collect(r12, this) == f5) {
                return f5;
            }
        } else if (i5 == 1) {
            u.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return J.f19942a;
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((WorkConstraintsTrackerKt$listen$1) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
