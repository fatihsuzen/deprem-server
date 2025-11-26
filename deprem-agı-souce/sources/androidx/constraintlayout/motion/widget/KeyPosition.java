package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;

public class KeyPosition extends KeyPositionBase {
    public static final String DRAWPATH = "drawPath";
    static final int KEY_TYPE = 2;
    static final String NAME = "KeyPosition";
    public static final String PERCENT_HEIGHT = "percentHeight";
    public static final String PERCENT_WIDTH = "percentWidth";
    public static final String PERCENT_X = "percentX";
    public static final String PERCENT_Y = "percentY";
    public static final String SIZE_PERCENT = "sizePercent";
    private static final String TAG = "KeyPosition";
    public static final String TRANSITION_EASING = "transitionEasing";
    public static final int TYPE_AXIS = 3;
    public static final int TYPE_CARTESIAN = 0;
    public static final int TYPE_PATH = 1;
    public static final int TYPE_SCREEN = 2;
    float mAltPercentX = Float.NaN;
    float mAltPercentY = Float.NaN;
    private float mCalculatedPositionX = Float.NaN;
    private float mCalculatedPositionY = Float.NaN;
    int mDrawPath = 0;
    int mPathMotionArc = Key.UNSET;
    float mPercentHeight = Float.NaN;
    float mPercentWidth = Float.NaN;
    float mPercentX = Float.NaN;
    float mPercentY = Float.NaN;
    int mPositionType = 0;
    String mTransitionEasing = null;

    private static class Loader {
        private static final int CURVE_FIT = 4;
        private static final int DRAW_PATH = 5;
        private static final int FRAME_POSITION = 2;
        private static final int PATH_MOTION_ARC = 10;
        private static final int PERCENT_HEIGHT = 12;
        private static final int PERCENT_WIDTH = 11;
        private static final int PERCENT_X = 6;
        private static final int PERCENT_Y = 7;
        private static final int SIZE_PERCENT = 8;
        private static final int TARGET_ID = 1;
        private static final int TRANSITION_EASING = 3;
        private static final int TYPE = 9;
        private static SparseIntArray sAttrMap;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            sAttrMap = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyPosition_motionTarget, 1);
            sAttrMap.append(R.styleable.KeyPosition_framePosition, 2);
            sAttrMap.append(R.styleable.KeyPosition_transitionEasing, 3);
            sAttrMap.append(R.styleable.KeyPosition_curveFit, 4);
            sAttrMap.append(R.styleable.KeyPosition_drawPath, 5);
            sAttrMap.append(R.styleable.KeyPosition_percentX, 6);
            sAttrMap.append(R.styleable.KeyPosition_percentY, 7);
            sAttrMap.append(R.styleable.KeyPosition_keyPositionType, 9);
            sAttrMap.append(R.styleable.KeyPosition_sizePercent, 8);
            sAttrMap.append(R.styleable.KeyPosition_percentWidth, 11);
            sAttrMap.append(R.styleable.KeyPosition_percentHeight, 12);
            sAttrMap.append(R.styleable.KeyPosition_pathMotionArc, 10);
        }

        private Loader() {
        }

        /* access modifiers changed from: private */
        public static void read(KeyPosition keyPosition, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = typedArray.getIndex(i5);
                switch (sAttrMap.get(index)) {
                    case 1:
                        if (!MotionLayout.IS_IN_EDIT_MODE) {
                            if (typedArray.peekValue(index).type != 3) {
                                keyPosition.mTargetId = typedArray.getResourceId(index, keyPosition.mTargetId);
                                break;
                            } else {
                                keyPosition.mTargetString = typedArray.getString(index);
                                break;
                            }
                        } else {
                            int resourceId = typedArray.getResourceId(index, keyPosition.mTargetId);
                            keyPosition.mTargetId = resourceId;
                            if (resourceId != -1) {
                                break;
                            } else {
                                keyPosition.mTargetString = typedArray.getString(index);
                                break;
                            }
                        }
                    case 2:
                        keyPosition.mFramePosition = typedArray.getInt(index, keyPosition.mFramePosition);
                        break;
                    case 3:
                        if (typedArray.peekValue(index).type != 3) {
                            keyPosition.mTransitionEasing = Easing.NAMED_EASING[typedArray.getInteger(index, 0)];
                            break;
                        } else {
                            keyPosition.mTransitionEasing = typedArray.getString(index);
                            break;
                        }
                    case 4:
                        keyPosition.mCurveFit = typedArray.getInteger(index, keyPosition.mCurveFit);
                        break;
                    case 5:
                        keyPosition.mDrawPath = typedArray.getInt(index, keyPosition.mDrawPath);
                        break;
                    case 6:
                        keyPosition.mPercentX = typedArray.getFloat(index, keyPosition.mPercentX);
                        break;
                    case 7:
                        keyPosition.mPercentY = typedArray.getFloat(index, keyPosition.mPercentY);
                        break;
                    case 8:
                        float f5 = typedArray.getFloat(index, keyPosition.mPercentHeight);
                        keyPosition.mPercentWidth = f5;
                        keyPosition.mPercentHeight = f5;
                        break;
                    case 9:
                        keyPosition.mPositionType = typedArray.getInt(index, keyPosition.mPositionType);
                        break;
                    case 10:
                        keyPosition.mPathMotionArc = typedArray.getInt(index, keyPosition.mPathMotionArc);
                        break;
                    case 11:
                        keyPosition.mPercentWidth = typedArray.getFloat(index, keyPosition.mPercentWidth);
                        break;
                    case 12:
                        keyPosition.mPercentHeight = typedArray.getFloat(index, keyPosition.mPercentHeight);
                        break;
                    default:
                        Log.e(TypedValues.PositionType.NAME, "unused attribute 0x" + Integer.toHexString(index) + "   " + sAttrMap.get(index));
                        break;
                }
            }
            if (keyPosition.mFramePosition == -1) {
                Log.e(TypedValues.PositionType.NAME, "no frame position");
            }
        }
    }

    public KeyPosition() {
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

    public void addValues(HashMap<String, ViewSpline> hashMap) {
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

    public Key copy(Key key) {
        super.copy(key);
        KeyPosition keyPosition = (KeyPosition) key;
        this.mTransitionEasing = keyPosition.mTransitionEasing;
        this.mPathMotionArc = keyPosition.mPathMotionArc;
        this.mDrawPath = keyPosition.mDrawPath;
        this.mPercentWidth = keyPosition.mPercentWidth;
        this.mPercentHeight = Float.NaN;
        this.mPercentX = keyPosition.mPercentX;
        this.mPercentY = keyPosition.mPercentY;
        this.mAltPercentX = keyPosition.mAltPercentX;
        this.mAltPercentY = keyPosition.mAltPercentY;
        this.mCalculatedPositionX = keyPosition.mCalculatedPositionX;
        this.mCalculatedPositionY = keyPosition.mCalculatedPositionY;
        return this;
    }

    /* access modifiers changed from: package-private */
    public float getPositionX() {
        return this.mCalculatedPositionX;
    }

    /* access modifiers changed from: package-private */
    public float getPositionY() {
        return this.mCalculatedPositionY;
    }

    public boolean intersects(int i5, int i6, RectF rectF, RectF rectF2, float f5, float f6) {
        calcPosition(i5, i6, rectF.centerX(), rectF.centerY(), rectF2.centerX(), rectF2.centerY());
        if (Math.abs(f5 - this.mCalculatedPositionX) >= 20.0f || Math.abs(f6 - this.mCalculatedPositionY) >= 20.0f) {
            return false;
        }
        return true;
    }

    public void load(Context context, AttributeSet attributeSet) {
        Loader.read(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyPosition));
    }

    public void positionAttributes(View view, RectF rectF, RectF rectF2, float f5, float f6, String[] strArr, float[] fArr) {
        int i5 = this.mPositionType;
        if (i5 == 1) {
            positionPathAttributes(rectF, rectF2, f5, f6, strArr, fArr);
        } else if (i5 == 2) {
            positionScreenAttributes(view, rectF, rectF2, f5, f6, strArr, fArr);
        } else if (i5 != 3) {
            positionCartAttributes(rectF, rectF2, f5, f6, strArr, fArr);
        } else {
            positionAxisAttributes(rectF, rectF2, f5, f6, strArr, fArr);
        }
    }

    /* access modifiers changed from: package-private */
    public void positionAxisAttributes(RectF rectF, RectF rectF2, float f5, float f6, String[] strArr, float[] fArr) {
        float centerX = rectF.centerX();
        float centerY = rectF.centerY();
        float centerX2 = rectF2.centerX();
        float centerY2 = rectF2.centerY();
        if (centerX > centerX2) {
            float f7 = centerX2;
            centerX2 = centerX;
            centerX = f7;
        }
        if (centerY <= centerY2) {
            float f8 = centerY2;
            centerY2 = centerY;
            centerY = f8;
        }
        float f9 = centerX2 - centerX;
        float f10 = centerY - centerY2;
        String str = strArr[0];
        if (str == null) {
            strArr[0] = "percentX";
            fArr[0] = (f5 - centerX) / f9;
            strArr[1] = "percentY";
            fArr[1] = (f6 - centerY2) / f10;
        } else if ("percentX".equals(str)) {
            fArr[0] = (f5 - centerX) / f9;
            fArr[1] = (f6 - centerY2) / f10;
        } else {
            fArr[1] = (f5 - centerX) / f9;
            fArr[0] = (f6 - centerY2) / f10;
        }
    }

    /* access modifiers changed from: package-private */
    public void positionCartAttributes(RectF rectF, RectF rectF2, float f5, float f6, String[] strArr, float[] fArr) {
        float centerX = rectF.centerX();
        float centerY = rectF.centerY();
        float centerX2 = rectF2.centerX() - centerX;
        float centerY2 = rectF2.centerY() - centerY;
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
    public void positionPathAttributes(RectF rectF, RectF rectF2, float f5, float f6, String[] strArr, float[] fArr) {
        float centerX = rectF.centerX();
        float centerY = rectF.centerY();
        float centerX2 = rectF2.centerX() - centerX;
        float centerY2 = rectF2.centerY() - centerY;
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
    public void positionScreenAttributes(View view, RectF rectF, RectF rectF2, float f5, float f6, String[] strArr, float[] fArr) {
        rectF.centerX();
        rectF.centerY();
        rectF2.centerX();
        rectF2.centerY();
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int width = viewGroup.getWidth();
        int height = viewGroup.getHeight();
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

    public void setType(int i5) {
        this.mPositionType = i5;
    }

    public void setValue(String str, Object obj) {
        str.getClass();
        char c5 = 65535;
        switch (str.hashCode()) {
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    c5 = 0;
                    break;
                }
                break;
            case -1127236479:
                if (str.equals("percentWidth")) {
                    c5 = 1;
                    break;
                }
                break;
            case -1017587252:
                if (str.equals("percentHeight")) {
                    c5 = 2;
                    break;
                }
                break;
            case -827014263:
                if (str.equals("drawPath")) {
                    c5 = 3;
                    break;
                }
                break;
            case -200259324:
                if (str.equals("sizePercent")) {
                    c5 = 4;
                    break;
                }
                break;
            case 428090547:
                if (str.equals("percentX")) {
                    c5 = 5;
                    break;
                }
                break;
            case 428090548:
                if (str.equals("percentY")) {
                    c5 = 6;
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
                this.mTransitionEasing = obj.toString();
                return;
            case 1:
                this.mPercentWidth = toFloat(obj);
                return;
            case 2:
                this.mPercentHeight = toFloat(obj);
                return;
            case 3:
                this.mDrawPath = toInt(obj);
                return;
            case 4:
                float f5 = toFloat(obj);
                this.mPercentWidth = f5;
                this.mPercentHeight = f5;
                return;
            case 5:
                this.mPercentX = toFloat(obj);
                return;
            case 6:
                this.mPercentY = toFloat(obj);
                return;
            default:
                return;
        }
    }

    public Key clone() {
        return new KeyPosition().copy(this);
    }
}
