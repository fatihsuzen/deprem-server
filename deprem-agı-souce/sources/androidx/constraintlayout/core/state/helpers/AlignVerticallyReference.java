package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;
import java.util.ArrayList;

public class AlignVerticallyReference extends HelperReference {
    private float mBias = 0.5f;

    public AlignVerticallyReference(State state) {
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
            constraints.clearVertical();
            Object obj2 = this.mTopToTop;
            if (obj2 != null) {
                constraints.topToTop(obj2);
            } else {
                Object obj3 = this.mTopToBottom;
                if (obj3 != null) {
                    constraints.topToBottom(obj3);
                } else {
                    constraints.topToTop(State.PARENT);
                }
            }
            Object obj4 = this.mBottomToTop;
            if (obj4 != null) {
                constraints.bottomToTop(obj4);
            } else {
                Object obj5 = this.mBottomToBottom;
                if (obj5 != null) {
                    constraints.bottomToBottom(obj5);
                } else {
                    constraints.bottomToBottom(State.PARENT);
                }
            }
            float f5 = this.mBias;
            if (f5 != 0.5f) {
                constraints.verticalBias(f5);
            }
        }
    }
}
