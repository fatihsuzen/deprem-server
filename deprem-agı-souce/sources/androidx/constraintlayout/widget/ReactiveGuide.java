package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.SharedValues;

public class ReactiveGuide extends View implements SharedValues.SharedValuesListener {
    private boolean mAnimateChange = false;
    private boolean mApplyToAllConstraintSets = true;
    private int mApplyToConstraintSetId = 0;
    private int mAttributeId = -1;

    public ReactiveGuide(Context context) {
        super(context);
        super.setVisibility(8);
        init((AttributeSet) null);
    }

    private void changeValue(int i5, int i6, MotionLayout motionLayout, int i7) {
        ConstraintSet constraintSet = motionLayout.getConstraintSet(i7);
        constraintSet.setGuidelineEnd(i6, i5);
        motionLayout.updateState(i7, constraintSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_ReactiveGuide);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = obtainStyledAttributes.getIndex(i5);
                if (index == R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_valueId) {
                    this.mAttributeId = obtainStyledAttributes.getResourceId(index, this.mAttributeId);
                } else if (index == R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_animateChange) {
                    this.mAnimateChange = obtainStyledAttributes.getBoolean(index, this.mAnimateChange);
                } else if (index == R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToConstraintSet) {
                    this.mApplyToConstraintSetId = obtainStyledAttributes.getResourceId(index, this.mApplyToConstraintSetId);
                } else if (index == R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToAllConstraintSets) {
                    this.mApplyToAllConstraintSets = obtainStyledAttributes.getBoolean(index, this.mApplyToAllConstraintSets);
                }
            }
            obtainStyledAttributes.recycle();
        }
        if (this.mAttributeId != -1) {
            ConstraintLayout.getSharedValues().addListener(this.mAttributeId, this);
        }
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(@NonNull Canvas canvas) {
    }

    public int getApplyToConstraintSetId() {
        return this.mApplyToConstraintSetId;
    }

    public int getAttributeId() {
        return this.mAttributeId;
    }

    public boolean isAnimatingChange() {
        return this.mAnimateChange;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        setMeasuredDimension(0, 0);
    }

    public void onNewValue(int i5, int i6, int i7) {
        setGuidelineBegin(i6);
        int id = getId();
        if (id > 0 && (getParent() instanceof MotionLayout)) {
            MotionLayout motionLayout = (MotionLayout) getParent();
            int currentState = motionLayout.getCurrentState();
            int i8 = this.mApplyToConstraintSetId;
            if (i8 != 0) {
                currentState = i8;
            }
            int i9 = 0;
            if (this.mAnimateChange) {
                if (this.mApplyToAllConstraintSets) {
                    int[] constraintSetIds = motionLayout.getConstraintSetIds();
                    while (i9 < constraintSetIds.length) {
                        int i10 = constraintSetIds[i9];
                        if (i10 != currentState) {
                            changeValue(i6, id, motionLayout, i10);
                        }
                        i9++;
                    }
                }
                ConstraintSet cloneConstraintSet = motionLayout.cloneConstraintSet(currentState);
                cloneConstraintSet.setGuidelineEnd(id, i6);
                motionLayout.updateStateAnimate(currentState, cloneConstraintSet, 1000);
            } else if (this.mApplyToAllConstraintSets) {
                int[] constraintSetIds2 = motionLayout.getConstraintSetIds();
                while (i9 < constraintSetIds2.length) {
                    changeValue(i6, id, motionLayout, constraintSetIds2[i9]);
                    i9++;
                }
            } else {
                changeValue(i6, id, motionLayout, currentState);
            }
        }
    }

    public void setAnimateChange(boolean z4) {
        this.mAnimateChange = z4;
    }

    public void setApplyToConstraintSetId(int i5) {
        this.mApplyToConstraintSetId = i5;
    }

    public void setAttributeId(int i5) {
        SharedValues sharedValues = ConstraintLayout.getSharedValues();
        int i6 = this.mAttributeId;
        if (i6 != -1) {
            sharedValues.removeListener(i6, this);
        }
        this.mAttributeId = i5;
        if (i5 != -1) {
            sharedValues.addListener(i5, this);
        }
    }

    public void setGuidelineBegin(int i5) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.guideBegin = i5;
        setLayoutParams(layoutParams);
    }

    public void setGuidelineEnd(int i5) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.guideEnd = i5;
        setLayoutParams(layoutParams);
    }

    public void setGuidelinePercent(float f5) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.guidePercent = f5;
        setLayoutParams(layoutParams);
    }

    public void setVisibility(int i5) {
    }

    public ReactiveGuide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
        init(attributeSet);
    }

    public ReactiveGuide(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        super.setVisibility(8);
        init(attributeSet);
    }

    public ReactiveGuide(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5);
        super.setVisibility(8);
        init(attributeSet);
    }
}
