package androidx.constraintlayout.core.dsl;

import androidx.constraintlayout.core.motion.utils.TypedValues;

public class KeyAttribute extends Keys {
    protected String TYPE = TypedValues.AttributesType.NAME;
    private float mAlpha = Float.NaN;
    private Fit mCurveFit = null;
    private int mFrame;
    private float mPivotX = Float.NaN;
    private float mPivotY = Float.NaN;
    private float mRotation = Float.NaN;
    private float mRotationX = Float.NaN;
    private float mRotationY = Float.NaN;
    private float mScaleX = Float.NaN;
    private float mScaleY = Float.NaN;
    private String mTarget;
    private String mTransitionEasing;
    private float mTransitionPathRotate = Float.NaN;
    private float mTranslationX = Float.NaN;
    private float mTranslationY = Float.NaN;
    private float mTranslationZ = Float.NaN;
    private Visibility mVisibility = null;

    public enum Fit {
        SPLINE,
        LINEAR
    }

    public enum Visibility {
        VISIBLE,
        INVISIBLE,
        GONE
    }

    public KeyAttribute(int i5, String str) {
        this.mTarget = str;
        this.mFrame = i5;
    }

    /* access modifiers changed from: protected */
    public void attributesToString(StringBuilder sb) {
        append(sb, TypedValues.AttributesType.S_TARGET, this.mTarget);
        sb.append("frame:");
        sb.append(this.mFrame);
        sb.append(",\n");
        append(sb, "easing", this.mTransitionEasing);
        if (this.mCurveFit != null) {
            sb.append("fit:'");
            sb.append(this.mCurveFit);
            sb.append("',\n");
        }
        if (this.mVisibility != null) {
            sb.append("visibility:'");
            sb.append(this.mVisibility);
            sb.append("',\n");
        }
        append(sb, "alpha", this.mAlpha);
        append(sb, "rotationX", this.mRotationX);
        append(sb, "rotationY", this.mRotationY);
        append(sb, "rotationZ", this.mRotation);
        append(sb, "pivotX", this.mPivotX);
        append(sb, "pivotY", this.mPivotY);
        append(sb, "pathRotate", this.mTransitionPathRotate);
        append(sb, "scaleX", this.mScaleX);
        append(sb, "scaleY", this.mScaleY);
        append(sb, "translationX", this.mTranslationX);
        append(sb, "translationY", this.mTranslationY);
        append(sb, "translationZ", this.mTranslationZ);
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public Fit getCurveFit() {
        return this.mCurveFit;
    }

    public float getPivotX() {
        return this.mPivotX;
    }

    public float getPivotY() {
        return this.mPivotY;
    }

    public float getRotation() {
        return this.mRotation;
    }

    public float getRotationX() {
        return this.mRotationX;
    }

    public float getRotationY() {
        return this.mRotationY;
    }

    public float getScaleX() {
        return this.mScaleX;
    }

    public float getScaleY() {
        return this.mScaleY;
    }

    public String getTarget() {
        return this.mTarget;
    }

    public String getTransitionEasing() {
        return this.mTransitionEasing;
    }

    public float getTransitionPathRotate() {
        return this.mTransitionPathRotate;
    }

    public float getTranslationX() {
        return this.mTranslationX;
    }

    public float getTranslationY() {
        return this.mTranslationY;
    }

    public float getTranslationZ() {
        return this.mTranslationZ;
    }

    public Visibility getVisibility() {
        return this.mVisibility;
    }

    public void setAlpha(float f5) {
        this.mAlpha = f5;
    }

    public void setCurveFit(Fit fit) {
        this.mCurveFit = fit;
    }

    public void setPivotX(float f5) {
        this.mPivotX = f5;
    }

    public void setPivotY(float f5) {
        this.mPivotY = f5;
    }

    public void setRotation(float f5) {
        this.mRotation = f5;
    }

    public void setRotationX(float f5) {
        this.mRotationX = f5;
    }

    public void setRotationY(float f5) {
        this.mRotationY = f5;
    }

    public void setScaleX(float f5) {
        this.mScaleX = f5;
    }

    public void setScaleY(float f5) {
        this.mScaleY = f5;
    }

    public void setTarget(String str) {
        this.mTarget = str;
    }

    public void setTransitionEasing(String str) {
        this.mTransitionEasing = str;
    }

    public void setTransitionPathRotate(float f5) {
        this.mTransitionPathRotate = f5;
    }

    public void setTranslationX(float f5) {
        this.mTranslationX = f5;
    }

    public void setTranslationY(float f5) {
        this.mTranslationY = f5;
    }

    public void setTranslationZ(float f5) {
        this.mTranslationZ = f5;
    }

    public void setVisibility(Visibility visibility) {
        this.mVisibility = visibility;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.TYPE);
        sb.append(":{\n");
        attributesToString(sb);
        sb.append("},\n");
        return sb.toString();
    }
}
