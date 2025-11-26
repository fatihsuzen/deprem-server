package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;
import java.util.ArrayList;

public class AlignHorizontallyReference extends HelperReference {
    private float mBias = 0.5f;

    public AlignHorizontallyReference(State state) {
        super(state, State.Helper.ALIGN_VERTICALLY);
    }

    public void apply() {
        ArrayList<Object> arrayList = this.mReferences;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            ConstraintReference constraints = this.mHelperState.constraints(obj);
            constraints.clearHorizontal();
            Object obj2 = this.mStartToStart;
            if (obj2 != null) {
                constraints.startToStart(obj2);
            } else {
                Object obj3 = this.mStartToEnd;
                if (obj3 != null) {
                    constraints.startToEnd(obj3);
                } else {
                    constraints.startToStart(State.PARENT);
                }
            }
            Object obj4 = this.mEndToStart;
            if (obj4 != null) {
                constraints.endToStart(obj4);
            } else {
                Object obj5 = this.mEndToEnd;
                if (obj5 != null) {
                    constraints.endToEnd(obj5);
                } else {
                    constraints.endToEnd(State.PARENT);
                }
            }
            float f5 = this.mBias;
            if (f5 != 0.5f) {
                constraints.horizontalBias(f5);
            }
        }
    }
}
