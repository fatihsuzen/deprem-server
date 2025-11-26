package androidx.work.impl.constraints.controllers;

import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.constraints.ConstraintsState;
import y3.v;

public final class BaseConstraintController$track$1$listener$1 implements ConstraintListener<T> {
    final /* synthetic */ v $$this$callbackFlow;
    final /* synthetic */ BaseConstraintController<T> this$0;

    BaseConstraintController$track$1$listener$1(BaseConstraintController<T> baseConstraintController, v vVar) {
        this.this$0 = baseConstraintController;
        this.$$this$callbackFlow = vVar;
    }

    public void onConstraintChanged(T t5) {
        Object obj;
        if (this.this$0.isConstrained(t5)) {
            obj = new ConstraintsState.ConstraintsNotMet(this.this$0.getReason());
        } else {
            obj = ConstraintsState.ConstraintsMet.INSTANCE;
        }
        this.$$this$callbackFlow.o().r(obj);
    }
}
