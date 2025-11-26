package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.HashMap;

public class Barrier extends HelperWidget {
    public static final int BOTTOM = 3;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int TOP = 2;
    private static final boolean USE_RELAX_GONE = false;
    private static final boolean USE_RESOLUTION = true;
    private boolean mAllowsGoneWidget = true;
    private int mBarrierType = 0;
    private int mMargin = 0;
    boolean mResolved = false;

    public Barrier() {
    }

    public void addToSolver(LinearSystem linearSystem, boolean z4) {
        ConstraintAnchor[] constraintAnchorArr;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        ConstraintAnchor[] constraintAnchorArr2 = this.mListAnchors;
        constraintAnchorArr2[0] = this.mLeft;
        constraintAnchorArr2[2] = this.mTop;
        constraintAnchorArr2[1] = this.mRight;
        constraintAnchorArr2[3] = this.mBottom;
        int i10 = 0;
        while (true) {
            constraintAnchorArr = this.mListAnchors;
            if (i10 >= constraintAnchorArr.length) {
                break;
            }
            ConstraintAnchor constraintAnchor = constraintAnchorArr[i10];
            constraintAnchor.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor);
            i10++;
        }
        int i11 = this.mBarrierType;
        if (i11 >= 0 && i11 < 4) {
            ConstraintAnchor constraintAnchor2 = constraintAnchorArr[i11];
            if (!this.mResolved) {
                allSolved();
            }
            if (this.mResolved) {
                this.mResolved = false;
                int i12 = this.mBarrierType;
                if (i12 == 0 || i12 == 1) {
                    linearSystem.addEquality(this.mLeft.mSolverVariable, this.mX);
                    linearSystem.addEquality(this.mRight.mSolverVariable, this.mX);
                } else if (i12 == 2 || i12 == 3) {
                    linearSystem.addEquality(this.mTop.mSolverVariable, this.mY);
                    linearSystem.addEquality(this.mBottom.mSolverVariable, this.mY);
                }
            } else {
                int i13 = 0;
                while (true) {
                    if (i13 >= this.mWidgetsCount) {
                        z5 = false;
                        break;
                    }
                    ConstraintWidget constraintWidget = this.mWidgets[i13];
                    if ((this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) && ((((i8 = this.mBarrierType) == 0 || i8 == 1) && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mLeft.mTarget != null && constraintWidget.mRight.mTarget != null) || (((i9 = this.mBarrierType) == 2 || i9 == 3) && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget != null))) {
                        z5 = true;
                    } else {
                        i13++;
                    }
                }
                z5 = true;
                if (this.mLeft.hasCenteredDependents() || this.mRight.hasCenteredDependents()) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (this.mTop.hasCenteredDependents() || this.mBottom.hasCenteredDependents()) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z5 || (((i7 = this.mBarrierType) != 0 || !z6) && ((i7 != 2 || !z7) && ((i7 != 1 || !z6) && (i7 != 3 || !z7))))) {
                    z8 = false;
                } else {
                    z8 = true;
                }
                if (!z8) {
                    i5 = 4;
                } else {
                    i5 = 5;
                }
                for (int i14 = 0; i14 < this.mWidgetsCount; i14++) {
                    ConstraintWidget constraintWidget2 = this.mWidgets[i14];
                    if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                        SolverVariable createObjectVariable = linearSystem.createObjectVariable(constraintWidget2.mListAnchors[this.mBarrierType]);
                        ConstraintAnchor[] constraintAnchorArr3 = constraintWidget2.mListAnchors;
                        int i15 = this.mBarrierType;
                        ConstraintAnchor constraintAnchor3 = constraintAnchorArr3[i15];
                        constraintAnchor3.mSolverVariable = createObjectVariable;
                        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
                        if (constraintAnchor4 == null || constraintAnchor4.mOwner != this) {
                            i6 = 0;
                        } else {
                            i6 = constraintAnchor3.mMargin;
                        }
                        if (i15 == 0 || i15 == 2) {
                            linearSystem.addLowerBarrier(constraintAnchor2.mSolverVariable, createObjectVariable, this.mMargin - i6, z5);
                        } else {
                            linearSystem.addGreaterBarrier(constraintAnchor2.mSolverVariable, createObjectVariable, this.mMargin + i6, z5);
                        }
                        linearSystem.addEquality(constraintAnchor2.mSolverVariable, createObjectVariable, this.mMargin + i6, i5);
                    }
                }
                int i16 = this.mBarrierType;
                if (i16 == 0) {
                    linearSystem.addEquality(this.mRight.mSolverVariable, this.mLeft.mSolverVariable, 0, 8);
                    linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 4);
                    linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 0);
                } else if (i16 == 1) {
                    linearSystem.addEquality(this.mLeft.mSolverVariable, this.mRight.mSolverVariable, 0, 8);
                    linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 4);
                    linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 0);
                } else if (i16 == 2) {
                    linearSystem.addEquality(this.mBottom.mSolverVariable, this.mTop.mSolverVariable, 0, 8);
                    linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 4);
                    linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 0);
                } else if (i16 == 3) {
                    linearSystem.addEquality(this.mTop.mSolverVariable, this.mBottom.mSolverVariable, 0, 8);
                    linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 4);
                    linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 0);
                }
            }
        }
    }

    public boolean allSolved() {
        int i5;
        int i6;
        int i7;
        boolean z4 = true;
        int i8 = 0;
        while (true) {
            i5 = this.mWidgetsCount;
            if (i8 >= i5) {
                break;
            }
            ConstraintWidget constraintWidget = this.mWidgets[i8];
            if ((this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) && ((((i6 = this.mBarrierType) == 0 || i6 == 1) && !constraintWidget.isResolvedHorizontally()) || (((i7 = this.mBarrierType) == 2 || i7 == 3) && !constraintWidget.isResolvedVertically()))) {
                z4 = false;
            }
            i8++;
        }
        if (!z4 || i5 <= 0) {
            return false;
        }
        int i9 = 0;
        boolean z5 = false;
        for (int i10 = 0; i10 < this.mWidgetsCount; i10++) {
            ConstraintWidget constraintWidget2 = this.mWidgets[i10];
            if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                if (!z5) {
                    int i11 = this.mBarrierType;
                    if (i11 == 0) {
                        i9 = constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT).getFinalValue();
                    } else if (i11 == 1) {
                        i9 = constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getFinalValue();
                    } else if (i11 == 2) {
                        i9 = constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP).getFinalValue();
                    } else if (i11 == 3) {
                        i9 = constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getFinalValue();
                    }
                    z5 = true;
                }
                int i12 = this.mBarrierType;
                if (i12 == 0) {
                    i9 = Math.min(i9, constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT).getFinalValue());
                } else if (i12 == 1) {
                    i9 = Math.max(i9, constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getFinalValue());
                } else if (i12 == 2) {
                    i9 = Math.min(i9, constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP).getFinalValue());
                } else if (i12 == 3) {
                    i9 = Math.max(i9, constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getFinalValue());
                }
            }
        }
        int i13 = i9 + this.mMargin;
        int i14 = this.mBarrierType;
        if (i14 == 0 || i14 == 1) {
            setFinalHorizontal(i13, i13);
        } else {
            setFinalVertical(i13, i13);
        }
        this.mResolved = true;
        return true;
    }

    public boolean allowedInBarrier() {
        return true;
    }

    @Deprecated
    public boolean allowsGoneWidget() {
        return this.mAllowsGoneWidget;
    }

    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        Barrier barrier = (Barrier) constraintWidget;
        this.mBarrierType = barrier.mBarrierType;
        this.mAllowsGoneWidget = barrier.mAllowsGoneWidget;
        this.mMargin = barrier.mMargin;
    }

    public boolean getAllowsGoneWidget() {
        return this.mAllowsGoneWidget;
    }

    public int getBarrierType() {
        return this.mBarrierType;
    }

    public int getMargin() {
        return this.mMargin;
    }

    public int getOrientation() {
        int i5 = this.mBarrierType;
        if (i5 == 0 || i5 == 1) {
            return 0;
        }
        if (i5 == 2 || i5 == 3) {
            return 1;
        }
        return -1;
    }

    public boolean isResolvedHorizontally() {
        return this.mResolved;
    }

    public boolean isResolvedVertically() {
        return this.mResolved;
    }

    /* access modifiers changed from: protected */
    public void markWidgets() {
        for (int i5 = 0; i5 < this.mWidgetsCount; i5++) {
            ConstraintWidget constraintWidget = this.mWidgets[i5];
            if (this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) {
                int i6 = this.mBarrierType;
                if (i6 == 0 || i6 == 1) {
                    constraintWidget.setInBarrier(0, true);
                } else if (i6 == 2 || i6 == 3) {
                    constraintWidget.setInBarrier(1, true);
                }
            }
        }
    }

    public void setAllowsGoneWidget(boolean z4) {
        this.mAllowsGoneWidget = z4;
    }

    public void setBarrierType(int i5) {
        this.mBarrierType = i5;
    }

    public void setMargin(int i5) {
        this.mMargin = i5;
    }

    public String toString() {
        String str = "[Barrier] " + getDebugName() + " {";
        for (int i5 = 0; i5 < this.mWidgetsCount; i5++) {
            ConstraintWidget constraintWidget = this.mWidgets[i5];
            if (i5 > 0) {
                str = str + ", ";
            }
            str = str + constraintWidget.getDebugName();
        }
        return str + "}";
    }

    public Barrier(String str) {
        setDebugName(str);
    }
}
