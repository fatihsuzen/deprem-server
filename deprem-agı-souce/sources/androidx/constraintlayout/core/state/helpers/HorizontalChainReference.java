package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.State;
import java.util.ArrayList;

public class HorizontalChainReference extends ChainReference {

    /* renamed from: androidx.constraintlayout.core.state.helpers.HorizontalChainReference$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$state$State$Chain;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                androidx.constraintlayout.core.state.State$Chain[] r0 = androidx.constraintlayout.core.state.State.Chain.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$androidx$constraintlayout$core$state$State$Chain = r0
                androidx.constraintlayout.core.state.State$Chain r1 = androidx.constraintlayout.core.state.State.Chain.SPREAD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$androidx$constraintlayout$core$state$State$Chain     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.state.State$Chain r1 = androidx.constraintlayout.core.state.State.Chain.SPREAD_INSIDE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$androidx$constraintlayout$core$state$State$Chain     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.state.State$Chain r1 = androidx.constraintlayout.core.state.State.Chain.PACKED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.helpers.HorizontalChainReference.AnonymousClass1.<clinit>():void");
        }
    }

    public HorizontalChainReference(State state) {
        super(state, State.Helper.HORIZONTAL_CHAIN);
    }

    public void apply() {
        ArrayList<Object> arrayList = this.mReferences;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            this.mHelperState.constraints(obj).clearHorizontal();
        }
        ArrayList<Object> arrayList2 = this.mReferences;
        int size2 = arrayList2.size();
        ConstraintReference constraintReference = null;
        int i6 = 0;
        ConstraintReference constraintReference2 = null;
        while (i6 < size2) {
            Object obj2 = arrayList2.get(i6);
            i6++;
            ConstraintReference constraints = this.mHelperState.constraints(obj2);
            if (constraintReference2 == null) {
                Object obj3 = this.mStartToStart;
                if (obj3 != null) {
                    constraints.startToStart(obj3).margin(this.mMarginStart).marginGone(this.mMarginStartGone);
                } else {
                    Object obj4 = this.mStartToEnd;
                    if (obj4 != null) {
                        constraints.startToEnd(obj4).margin(this.mMarginStart).marginGone(this.mMarginStartGone);
                    } else {
                        Object obj5 = this.mLeftToLeft;
                        if (obj5 != null) {
                            constraints.startToStart(obj5).margin(this.mMarginLeft).marginGone(this.mMarginLeftGone);
                        } else {
                            Object obj6 = this.mLeftToRight;
                            if (obj6 != null) {
                                constraints.startToEnd(obj6).margin(this.mMarginLeft).marginGone(this.mMarginLeftGone);
                            } else {
                                String obj7 = constraints.getKey().toString();
                                constraints.startToStart(State.PARENT).margin((Object) Float.valueOf(getPreMargin(obj7))).marginGone((Object) Float.valueOf(getPreGoneMargin(obj7)));
                            }
                        }
                    }
                }
                constraintReference2 = constraints;
            }
            if (constraintReference != null) {
                String obj8 = constraintReference.getKey().toString();
                String obj9 = constraints.getKey().toString();
                constraintReference.endToStart(constraints.getKey()).margin((Object) Float.valueOf(getPostMargin(obj8))).marginGone((Object) Float.valueOf(getPostGoneMargin(obj8)));
                constraints.startToEnd(constraintReference.getKey()).margin((Object) Float.valueOf(getPreMargin(obj9))).marginGone((Object) Float.valueOf(getPreGoneMargin(obj9)));
            }
            float weight = getWeight(obj2.toString());
            if (weight != -1.0f) {
                constraints.setHorizontalChainWeight(weight);
            }
            constraintReference = constraints;
        }
        if (constraintReference != null) {
            Object obj10 = this.mEndToStart;
            if (obj10 != null) {
                constraintReference.endToStart(obj10).margin(this.mMarginEnd).marginGone(this.mMarginEndGone);
            } else {
                Object obj11 = this.mEndToEnd;
                if (obj11 != null) {
                    constraintReference.endToEnd(obj11).margin(this.mMarginEnd).marginGone(this.mMarginEndGone);
                } else {
                    Object obj12 = this.mRightToLeft;
                    if (obj12 != null) {
                        constraintReference.endToStart(obj12).margin(this.mMarginRight).marginGone(this.mMarginRightGone);
                    } else {
                        Object obj13 = this.mRightToRight;
                        if (obj13 != null) {
                            constraintReference.endToEnd(obj13).margin(this.mMarginRight).marginGone(this.mMarginRightGone);
                        } else {
                            String obj14 = constraintReference.getKey().toString();
                            constraintReference.endToEnd(State.PARENT).margin((Object) Float.valueOf(getPostMargin(obj14))).marginGone((Object) Float.valueOf(getPostGoneMargin(obj14)));
                        }
                    }
                }
            }
        }
        if (constraintReference2 != null) {
            float f5 = this.mBias;
            if (f5 != 0.5f) {
                constraintReference2.horizontalBias(f5);
            }
            int i7 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$state$State$Chain[this.mStyle.ordinal()];
            if (i7 == 1) {
                constraintReference2.setHorizontalChainStyle(0);
            } else if (i7 == 2) {
                constraintReference2.setHorizontalChainStyle(1);
            } else if (i7 == 3) {
                constraintReference2.setHorizontalChainStyle(2);
            }
        }
    }
}
