package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;

public class Layer extends ConstraintHelper {
    private static final String TAG = "Layer";
    private boolean mApplyElevationOnAttach;
    private boolean mApplyVisibilityOnAttach;
    protected float mComputedCenterX = Float.NaN;
    protected float mComputedCenterY = Float.NaN;
    protected float mComputedMaxX = Float.NaN;
    protected float mComputedMaxY = Float.NaN;
    protected float mComputedMinX = Float.NaN;
    protected float mComputedMinY = Float.NaN;
    ConstraintLayout mContainer;
    private float mGroupRotateAngle = Float.NaN;
    boolean mNeedBounds = true;
    private float mRotationCenterX = Float.NaN;
    private float mRotationCenterY = Float.NaN;
    private float mScaleX = 1.0f;
    private float mScaleY = 1.0f;
    private float mShiftX = 0.0f;
    private float mShiftY = 0.0f;
    View[] mViews = null;

    public Layer(Context context) {
        super(context);
    }

    private void reCacheViews() {
        int i5;
        if (this.mContainer != null && (i5 = this.mCount) != 0) {
            View[] viewArr = this.mViews;
            if (viewArr == null || viewArr.length != i5) {
                this.mViews = new View[i5];
            }
            for (int i6 = 0; i6 < this.mCount; i6++) {
                this.mViews[i6] = this.mContainer.getViewById(this.mIds[i6]);
            }
        }
    }

    private void transform() {
        double d5;
        if (this.mContainer != null) {
            if (this.mViews == null) {
                reCacheViews();
            }
            calcCenters();
            if (Float.isNaN(this.mGroupRotateAngle)) {
                d5 = 0.0d;
            } else {
                d5 = Math.toRadians((double) this.mGroupRotateAngle);
            }
            float sin = (float) Math.sin(d5);
            float cos = (float) Math.cos(d5);
            float f5 = this.mScaleX;
            float f6 = f5 * cos;
            float f7 = this.mScaleY;
            float f8 = (-f7) * sin;
            float f9 = f5 * sin;
            float f10 = f7 * cos;
            for (int i5 = 0; i5 < this.mCount; i5++) {
                View view = this.mViews[i5];
                float left = ((float) ((view.getLeft() + view.getRight()) / 2)) - this.mComputedCenterX;
                float top = ((float) ((view.getTop() + view.getBottom()) / 2)) - this.mComputedCenterY;
                view.setTranslationX((((f6 * left) + (f8 * top)) - left) + this.mShiftX);
                view.setTranslationY((((left * f9) + (f10 * top)) - top) + this.mShiftY);
                view.setScaleY(this.mScaleY);
                view.setScaleX(this.mScaleX);
                if (!Float.isNaN(this.mGroupRotateAngle)) {
                    view.setRotation(this.mGroupRotateAngle);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void applyLayoutFeaturesInConstraintSet(ConstraintLayout constraintLayout) {
        applyLayoutFeatures(constraintLayout);
    }

    /* access modifiers changed from: protected */
    public void calcCenters() {
        if (this.mContainer != null) {
            if (!this.mNeedBounds && !Float.isNaN(this.mComputedCenterX) && !Float.isNaN(this.mComputedCenterY)) {
                return;
            }
            if (Float.isNaN(this.mRotationCenterX) || Float.isNaN(this.mRotationCenterY)) {
                View[] views = getViews(this.mContainer);
                int left = views[0].getLeft();
                int top = views[0].getTop();
                int right = views[0].getRight();
                int bottom = views[0].getBottom();
                for (int i5 = 0; i5 < this.mCount; i5++) {
                    View view = views[i5];
                    left = Math.min(left, view.getLeft());
                    top = Math.min(top, view.getTop());
                    right = Math.max(right, view.getRight());
                    bottom = Math.max(bottom, view.getBottom());
                }
                this.mComputedMaxX = (float) right;
                this.mComputedMaxY = (float) bottom;
                this.mComputedMinX = (float) left;
                this.mComputedMinY = (float) top;
                if (Float.isNaN(this.mRotationCenterX)) {
                    this.mComputedCenterX = (float) ((left + right) / 2);
                } else {
                    this.mComputedCenterX = this.mRotationCenterX;
                }
                if (Float.isNaN(this.mRotationCenterY)) {
                    this.mComputedCenterY = (float) ((top + bottom) / 2);
                } else {
                    this.mComputedCenterY = this.mRotationCenterY;
                }
            } else {
                this.mComputedCenterY = this.mRotationCenterY;
                this.mComputedCenterX = this.mRotationCenterX;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.mUseViewMeasure = false;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = obtainStyledAttributes.getIndex(i5);
                if (index == R.styleable.ConstraintLayout_Layout_android_visibility) {
                    this.mApplyVisibilityOnAttach = true;
                } else if (index == R.styleable.ConstraintLayout_Layout_android_elevation) {
                    this.mApplyElevationOnAttach = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mContainer = (ConstraintLayout) getParent();
        if (this.mApplyVisibilityOnAttach || this.mApplyElevationOnAttach) {
            int visibility = getVisibility();
            float elevation = getElevation();
            for (int i5 = 0; i5 < this.mCount; i5++) {
                View viewById = this.mContainer.getViewById(this.mIds[i5]);
                if (viewById != null) {
                    if (this.mApplyVisibilityOnAttach) {
                        viewById.setVisibility(visibility);
                    }
                    if (this.mApplyElevationOnAttach && elevation > 0.0f) {
                        viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    public void setElevation(float f5) {
        super.setElevation(f5);
        applyLayoutFeatures();
    }

    public void setPivotX(float f5) {
        this.mRotationCenterX = f5;
        transform();
    }

    public void setPivotY(float f5) {
        this.mRotationCenterY = f5;
        transform();
    }

    public void setRotation(float f5) {
        this.mGroupRotateAngle = f5;
        transform();
    }

    public void setScaleX(float f5) {
        this.mScaleX = f5;
        transform();
    }

    public void setScaleY(float f5) {
        this.mScaleY = f5;
        transform();
    }

    public void setTranslationX(float f5) {
        this.mShiftX = f5;
        transform();
    }

    public void setTranslationY(float f5) {
        this.mShiftY = f5;
        transform();
    }

    public void setVisibility(int i5) {
        super.setVisibility(i5);
        applyLayoutFeatures();
    }

    public void updatePostLayout(ConstraintLayout constraintLayout) {
        reCacheViews();
        this.mComputedCenterX = Float.NaN;
        this.mComputedCenterY = Float.NaN;
        ConstraintWidget constraintWidget = ((ConstraintLayout.LayoutParams) getLayoutParams()).getConstraintWidget();
        constraintWidget.setWidth(0);
        constraintWidget.setHeight(0);
        calcCenters();
        layout(((int) this.mComputedMinX) - getPaddingLeft(), ((int) this.mComputedMinY) - getPaddingTop(), ((int) this.mComputedMaxX) + getPaddingRight(), ((int) this.mComputedMaxY) + getPaddingBottom());
        transform();
    }

    public void updatePreDraw(ConstraintLayout constraintLayout) {
        this.mContainer = constraintLayout;
        float rotation = getRotation();
        if (rotation != 0.0f) {
            this.mGroupRotateAngle = rotation;
        } else if (!Float.isNaN(this.mGroupRotateAngle)) {
            this.mGroupRotateAngle = rotation;
        }
    }

    public Layer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Layer(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }
}
