package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.FloatRect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.motion.utils.f;
import java.util.HashMap;
import java.util.HashSet;

public class MotionKeyPosition extends MotionKey {
    static final int KEY_TYPE = 2;
    static final String NAME = "KeyPosition";
    protected static final float SELECTION_SLOPE = 20.0f;
    public static final int TYPE_CARTESIAN = 0;
    public static final int TYPE_PATH = 1;
    public static final int TYPE_SCREEN = 2;
    public float mAltPercentX;
    public float mAltPercentY;
    private float mCalculatedPositionX;
    private float mCalculatedPositionY;
    public int mCurveFit;
    public int mDrawPath;
    public int mPathMotionArc;
    public float mPercentHeight;
    public float mPercentWidth;
    public float mPercentX;
    public float mPercentY;
    public int mPositionType;
    public String mTransitionEasing = null;

    public MotionKeyPosition() {
        int i5 = MotionKey.UNSET;
        this.mCurveFit = i5;
        this.mPathMotionArc = i5;
        this.mDrawPath = 0;
        this.mPercentWidth = Float.NaN;
        this.mPercentHeight = Float.NaN;
        this.mPercentX = Float.NaN;
        this.mPercentY = Float.NaN;
        this.mAltPercentX = Float.NaN;
        this.mAltPercentY = Float.NaN;
        this.mPositionType = 0;
        this.mCalculatedPositionX = Float.NaN;
        this.mCalculatedPositionY = Float.NaN;
        this.mType = 2;
    }

    private void calcCartesianPosition(float f5, float f6, float f7, float f8) {
        float f9;
        float f10;
        float f11;
        float f12 = f7 - f5;
        float f13 = f8 - f6;
        float f14 = 0.0f;
        if (Float.isNaN(this.mPercentX)) {
            f9 = 0.0f;
        } else {
            f9 = this.mPercentX;
        }
        if (Float.isNaN(this.mAltPercentY)) {
            f10 = 0.0f;
        } else {
            f10 = this.mAltPercentY;
        }
        if (Float.isNaN(this.mPercentY)) {
            f11 = 0.0f;
        } else {
            f11 = this.mPercentY;
        }
        if (!Float.isNaN(this.mAltPercentX)) {
            f14 = this.mAltPercentX;
        }
        this.mCalculatedPositionX = (float) ((int) (f5 + (f9 * f12) + (f14 * f13)));
        this.mCalculatedPositionY = (float) ((int) (f6 + (f12 * f10) + (f13 * f11)));
    }

    private void calcPathPosition(float f5, float f6, float f7, float f8) {
        float f9 = f7 - f5;
        float f10 = f8 - f6;
        float f11 = this.mPercentX;
        float f12 = this.mPercentY;
        this.mCalculatedPositionX = f5 + (f9 * f11) + ((-f10) * f12);
        this.mCalculatedPositionY = f6 + (f10 * f11) + (f9 * f12);
    }

    private void calcScreenPosition(int i5, int i6) {
        float f5 = this.mPercentX;
        float f6 = (float) 0;
        this.mCalculatedPositionX = (((float) i5) * f5) + f6;
        this.mCalculatedPositionY = (((float) i6) * f5) + f6;
    }

    public void addValues(HashMap<String, SplineSet> hashMap) {
    }

    /* access modifiers changed from: package-private */
    public void calcPosition(int i5, int i6, float f5, float f6, float f7, float f8) {
        int i7 = this.mPositionType;
        if (i7 == 1) {
            calcPathPosition(f5, f6, f7, f8);
        } else if (i7 != 2) {
            calcCartesianPosition(f5, f6, f7, f8);
        } else {
            calcScreenPosition(i5, i6);
        }
    }

    public MotionKey copy(MotionKey motionKey) {
        super.copy(motionKey);
        MotionKeyPosition motionKeyPosition = (MotionKeyPosition) motionKey;
        this.mTransitionEasing = motionKeyPosition.mTransitionEasing;
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        this.mPercentWidth = motionKeyPosition.mPercentWidth;
        this.mPercentHeight = Float.NaN;
        this.mPercentX = motionKeyPosition.mPercentX;
        this.mPercentY = motionKeyPosition.mPercentY;
        this.mAltPercentX = motionKeyPosition.mAltPercentX;
        this.mAltPercentY = motionKeyPosition.mAltPercentY;
        this.mCalculatedPositionX = motionKeyPosition.mCalculatedPositionX;
        this.mCalculatedPositionY = motionKeyPosition.mCalculatedPositionY;
        return this;
    }

    public void getAttributeNames(HashSet<String> hashSet) {
    }

    public int getId(String str) {
        return f.a(str);
    }

    /* access modifiers changed from: package-private */
    public float getPositionX() {
        return this.mCalculatedPositionX;
    }

    /* access modifiers changed from: package-private */
    public float getPositionY() {
        return this.mCalculatedPositionY;
    }

    public boolean intersects(int i5, int i6, FloatRect floatRect, FloatRect floatRect2, float f5, float f6) {
        calcPosition(i5, i6, floatRect.centerX(), floatRect.centerY(), floatRect2.centerX(), floatRect2.centerY());
        if (Math.abs(f5 - this.mCalculatedPositionX) >= SELECTION_SLOPE || Math.abs(f6 - this.mCalculatedPositionY) >= SELECTION_SLOPE) {
            return false;
        }
        return true;
    }

    public void positionAttributes(MotionWidget motionWidget, FloatRect floatRect, FloatRect floatRect2, float f5, float f6, String[] strArr, float[] fArr) {
        int i5 = this.mPositionType;
        if (i5 == 1) {
            positionPathAttributes(floatRect, floatRect2, f5, f6, strArr, fArr);
        } else if (i5 != 2) {
            positionCartAttributes(floatRect, floatRect2, f5, f6, strArr, fArr);
        } else {
            positionScreenAttributes(motionWidget, floatRect, floatRect2, f5, f6, strArr, fArr);
        }
    }

    /* access modifiers changed from: package-private */
    public void positionCartAttributes(FloatRect floatRect, FloatRect floatRect2, float f5, float f6, String[] strArr, float[] fArr) {
        float centerX = floatRect.centerX();
        float centerY = floatRect.centerY();
        float centerX2 = floatRect2.centerX() - centerX;
        float centerY2 = floatRect2.centerY() - centerY;
        String str = strArr[0];
        if (str == null) {
            strArr[0] = "percentX";
            fArr[0] = (f5 - centerX) / centerX2;
            strArr[1] = "percentY";
            fArr[1] = (f6 - centerY) / centerY2;
        } else if ("percentX".equals(str)) {
            fArr[0] = (f5 - centerX) / centerX2;
            fArr[1] = (f6 - centerY) / centerY2;
        } else {
            fArr[1] = (f5 - centerX) / centerX2;
            fArr[0] = (f6 - centerY) / centerY2;
        }
    }

    /* access modifiers changed from: package-private */
    public void positionPathAttributes(FloatRect floatRect, FloatRect floatRect2, float f5, float f6, String[] strArr, float[] fArr) {
        float centerX = floatRect.centerX();
        float centerY = floatRect.centerY();
        float centerX2 = floatRect2.centerX() - centerX;
        float centerY2 = floatRect2.centerY() - centerY;
        float hypot = (float) Math.hypot((double) centerX2, (double) centerY2);
        if (((double) hypot) < 1.0E-4d) {
            System.out.println("distance ~ 0");
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            return;
        }
        float f7 = centerX2 / hypot;
        float f8 = centerY2 / hypot;
        float f9 = f6 - centerY;
        float f10 = f5 - centerX;
        float f11 = ((f7 * f9) - (f10 * f8)) / hypot;
        float f12 = ((f7 * f10) + (f8 * f9)) / hypot;
        String str = strArr[0];
        if (str == null) {
            strArr[0] = "percentX";
            strArr[1] = "percentY";
            fArr[0] = f12;
            fArr[1] = f11;
        } else if ("percentX".equals(str)) {
            fArr[0] = f12;
            fArr[1] = f11;
        }
    }

    /* access modifiers changed from: package-private */
    public void positionScreenAttributes(MotionWidget motionWidget, FloatRect floatRect, FloatRect floatRect2, float f5, float f6, String[] strArr, float[] fArr) {
        floatRect.centerX();
        floatRect.centerY();
        floatRect2.centerX();
        floatRect2.centerY();
        MotionWidget parent = motionWidget.getParent();
        int width = parent.getWidth();
        int height = parent.getHeight();
        String str = strArr[0];
        if (str == null) {
            strArr[0] = "percentX";
            fArr[0] = f5 / ((float) width);
            strArr[1] = "percentY";
            fArr[1] = f6 / ((float) height);
        } else if ("percentX".equals(str)) {
            fArr[0] = f5 / ((float) width);
            fArr[1] = f6 / ((float) height);
        } else {
            fArr[1] = f5 / ((float) width);
            fArr[0] = f6 / ((float) height);
        }
    }

    public boolean setValue(int i5, int i6) {
        if (i5 == 100) {
            this.mFramePosition = i6;
            return true;
        } else if (i5 == 508) {
            this.mCurveFit = i6;
            return true;
        } else if (i5 != 510) {
            return super.setValue(i5, i6);
        } else {
            this.mPositionType = i6;
            return true;
        }
    }

    public MotionKey clone() {
        return new MotionKeyPosition().copy(this);
    }

    public boolean setValue(int i5, float f5) {
        switch (i5) {
            case TypedValues.PositionType.TYPE_PERCENT_WIDTH /*503*/:
                this.mPercentWidth = f5;
                return true;
            case TypedValues.PositionType.TYPE_PERCENT_HEIGHT /*504*/:
                this.mPercentHeight = f5;
                return true;
            case TypedValues.PositionType.TYPE_SIZE_PERCENT /*505*/:
                this.mPercentWidth = f5;
                this.mPercentHeight = f5;
                return true;
            case TypedValues.PositionType.TYPE_PERCENT_X /*506*/:
                this.mPercentX = f5;
                return true;
            case TypedValues.PositionType.TYPE_PERCENT_Y /*507*/:
                this.mPercentY = f5;
                return true;
            default:
                return super.setValue(i5, f5);
        }
    }

    public boolean setValue(int i5, String str) {
        if (i5 != 501) {
            return super.setValue(i5, str);
        }
        this.mTransitionEasing = str.toString();
        return true;
    }
}
