package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.motion.utils.a;
import androidx.constraintlayout.core.motion.utils.e;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.Set;

public class MotionWidget implements TypedValues {
    public static final int FILL_PARENT = -1;
    public static final int GONE_UNSET = Integer.MIN_VALUE;
    private static final int INTERNAL_MATCH_CONSTRAINT = -3;
    private static final int INTERNAL_MATCH_PARENT = -1;
    private static final int INTERNAL_WRAP_CONTENT = -2;
    private static final int INTERNAL_WRAP_CONTENT_CONSTRAINED = -4;
    public static final int INVISIBLE = 0;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int MATCH_PARENT = -1;
    public static final int PARENT_ID = 0;
    public static final int ROTATE_LEFT_OF_PORTRATE = 4;
    public static final int ROTATE_NONE = 0;
    public static final int ROTATE_PORTRATE_OF_LEFT = 2;
    public static final int ROTATE_PORTRATE_OF_RIGHT = 1;
    public static final int ROTATE_RIGHT_OF_PORTRATE = 3;
    public static final int UNSET = -1;
    public static final int VISIBILITY_MODE_IGNORE = 1;
    public static final int VISIBILITY_MODE_NORMAL = 0;
    public static final int VISIBLE = 4;
    public static final int WRAP_CONTENT = -2;
    Motion mMotion = new Motion();
    private float mProgress;
    PropertySet mPropertySet = new PropertySet();
    float mTransitionPathRotate;
    WidgetFrame mWidgetFrame = new WidgetFrame();

    public static class Motion {
        private static final int INTERPOLATOR_REFERENCE_ID = -2;
        private static final int INTERPOLATOR_UNDEFINED = -3;
        private static final int SPLINE_STRING = -1;
        public int mAnimateCircleAngleTo = 0;
        public String mAnimateRelativeTo = null;
        public int mDrawPath = 0;
        public float mMotionStagger = Float.NaN;
        public int mPathMotionArc = -1;
        public float mPathRotate = Float.NaN;
        public int mPolarRelativeTo = -1;
        public int mQuantizeInterpolatorID = -1;
        public String mQuantizeInterpolatorString = null;
        public int mQuantizeInterpolatorType = -3;
        public float mQuantizeMotionPhase = Float.NaN;
        public int mQuantizeMotionSteps = -1;
        public String mTransitionEasing = null;
    }

    public static class PropertySet {
        public float alpha = 1.0f;
        public float mProgress = Float.NaN;
        public int mVisibilityMode = 0;
        public int visibility = 4;
    }

    public MotionWidget() {
    }

    public MotionWidget findViewById(int i5) {
        return null;
    }

    public float getAlpha() {
        return this.mWidgetFrame.alpha;
    }

    public int getBottom() {
        return this.mWidgetFrame.bottom;
    }

    public CustomVariable getCustomAttribute(String str) {
        return this.mWidgetFrame.getCustomAttribute(str);
    }

    public Set<String> getCustomAttributeNames() {
        return this.mWidgetFrame.getCustomAttributeNames();
    }

    public int getHeight() {
        WidgetFrame widgetFrame = this.mWidgetFrame;
        return widgetFrame.bottom - widgetFrame.top;
    }

    public int getId(String str) {
        int a5 = a.a(str);
        if (a5 != -1) {
            return a5;
        }
        return e.a(str);
    }

    public int getLeft() {
        return this.mWidgetFrame.left;
    }

    public String getName() {
        return this.mWidgetFrame.getId();
    }

    public MotionWidget getParent() {
        return null;
    }

    public float getPivotX() {
        return this.mWidgetFrame.pivotX;
    }

    public float getPivotY() {
        return this.mWidgetFrame.pivotY;
    }

    public int getRight() {
        return this.mWidgetFrame.right;
    }

    public float getRotationX() {
        return this.mWidgetFrame.rotationX;
    }

    public float getRotationY() {
        return this.mWidgetFrame.rotationY;
    }

    public float getRotationZ() {
        return this.mWidgetFrame.rotationZ;
    }

    public float getScaleX() {
        return this.mWidgetFrame.scaleX;
    }

    public float getScaleY() {
        return this.mWidgetFrame.scaleY;
    }

    public int getTop() {
        return this.mWidgetFrame.top;
    }

    public float getTranslationX() {
        return this.mWidgetFrame.translationX;
    }

    public float getTranslationY() {
        return this.mWidgetFrame.translationY;
    }

    public float getTranslationZ() {
        return this.mWidgetFrame.translationZ;
    }

    public float getValueAttributes(int i5) {
        switch (i5) {
            case 303:
                return this.mWidgetFrame.alpha;
            case 304:
                return this.mWidgetFrame.translationX;
            case 305:
                return this.mWidgetFrame.translationY;
            case 306:
                return this.mWidgetFrame.translationZ;
            case 308:
                return this.mWidgetFrame.rotationX;
            case 309:
                return this.mWidgetFrame.rotationY;
            case 310:
                return this.mWidgetFrame.rotationZ;
            case 311:
                return this.mWidgetFrame.scaleX;
            case 312:
                return this.mWidgetFrame.scaleY;
            case 313:
                return this.mWidgetFrame.pivotX;
            case 314:
                return this.mWidgetFrame.pivotY;
            case 315:
                return this.mProgress;
            case TypedValues.AttributesType.TYPE_PATH_ROTATE:
                return this.mTransitionPathRotate;
            default:
                return Float.NaN;
        }
    }

    public int getVisibility() {
        return this.mPropertySet.visibility;
    }

    public WidgetFrame getWidgetFrame() {
        return this.mWidgetFrame;
    }

    public int getWidth() {
        WidgetFrame widgetFrame = this.mWidgetFrame;
        return widgetFrame.right - widgetFrame.left;
    }

    public int getX() {
        return this.mWidgetFrame.left;
    }

    public int getY() {
        return this.mWidgetFrame.top;
    }

    public void layout(int i5, int i6, int i7, int i8) {
        setBounds(i5, i6, i7, i8);
    }

    public void setBounds(int i5, int i6, int i7, int i8) {
        if (this.mWidgetFrame == null) {
            this.mWidgetFrame = new WidgetFrame((ConstraintWidget) null);
        }
        WidgetFrame widgetFrame = this.mWidgetFrame;
        widgetFrame.top = i6;
        widgetFrame.left = i5;
        widgetFrame.right = i7;
        widgetFrame.bottom = i8;
    }

    public void setCustomAttribute(String str, int i5, float f5) {
        this.mWidgetFrame.setCustomAttribute(str, i5, f5);
    }

    public void setInterpolatedValue(CustomAttribute customAttribute, float[] fArr) {
        this.mWidgetFrame.setCustomAttribute(customAttribute.mName, (int) TypedValues.Custom.TYPE_FLOAT, fArr[0]);
    }

    public void setPivotX(float f5) {
        this.mWidgetFrame.pivotX = f5;
    }

    public void setPivotY(float f5) {
        this.mWidgetFrame.pivotY = f5;
    }

    public void setRotationX(float f5) {
        this.mWidgetFrame.rotationX = f5;
    }

    public void setRotationY(float f5) {
        this.mWidgetFrame.rotationY = f5;
    }

    public void setRotationZ(float f5) {
        this.mWidgetFrame.rotationZ = f5;
    }

    public void setScaleX(float f5) {
        this.mWidgetFrame.scaleX = f5;
    }

    public void setScaleY(float f5) {
        this.mWidgetFrame.scaleY = f5;
    }

    public void setTranslationX(float f5) {
        this.mWidgetFrame.translationX = f5;
    }

    public void setTranslationY(float f5) {
        this.mWidgetFrame.translationY = f5;
    }

    public void setTranslationZ(float f5) {
        this.mWidgetFrame.translationZ = f5;
    }

    public boolean setValue(int i5, boolean z4) {
        return false;
    }

    public boolean setValueAttributes(int i5, float f5) {
        switch (i5) {
            case 303:
                this.mWidgetFrame.alpha = f5;
                return true;
            case 304:
                this.mWidgetFrame.translationX = f5;
                return true;
            case 305:
                this.mWidgetFrame.translationY = f5;
                return true;
            case 306:
                this.mWidgetFrame.translationZ = f5;
                return true;
            case 308:
                this.mWidgetFrame.rotationX = f5;
                return true;
            case 309:
                this.mWidgetFrame.rotationY = f5;
                return true;
            case 310:
                this.mWidgetFrame.rotationZ = f5;
                return true;
            case 311:
                this.mWidgetFrame.scaleX = f5;
                return true;
            case 312:
                this.mWidgetFrame.scaleY = f5;
                return true;
            case 313:
                this.mWidgetFrame.pivotX = f5;
                return true;
            case 314:
                this.mWidgetFrame.pivotY = f5;
                return true;
            case 315:
                this.mProgress = f5;
                return true;
            case TypedValues.AttributesType.TYPE_PATH_ROTATE:
                this.mTransitionPathRotate = f5;
                return true;
            default:
                return false;
        }
    }

    public boolean setValueMotion(int i5, int i6) {
        switch (i5) {
            case TypedValues.MotionType.TYPE_ANIMATE_CIRCLEANGLE_TO:
                this.mMotion.mAnimateCircleAngleTo = i6;
                return true;
            case TypedValues.MotionType.TYPE_PATHMOTION_ARC:
                this.mMotion.mPathMotionArc = i6;
                return true;
            case TypedValues.MotionType.TYPE_DRAW_PATH:
                this.mMotion.mDrawPath = i6;
                return true;
            case TypedValues.MotionType.TYPE_POLAR_RELATIVETO:
                this.mMotion.mPolarRelativeTo = i6;
                return true;
            case TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS:
                this.mMotion.mQuantizeMotionSteps = i6;
                return true;
            case TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_TYPE:
                this.mMotion.mQuantizeInterpolatorType = i6;
                return true;
            case TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_ID:
                this.mMotion.mQuantizeInterpolatorID = i6;
                return true;
            default:
                return false;
        }
    }

    public void setVisibility(int i5) {
        this.mPropertySet.visibility = i5;
    }

    public String toString() {
        return this.mWidgetFrame.left + ", " + this.mWidgetFrame.top + ", " + this.mWidgetFrame.right + ", " + this.mWidgetFrame.bottom;
    }

    public void updateMotion(TypedValues typedValues) {
        if (this.mWidgetFrame.getMotionProperties() != null) {
            this.mWidgetFrame.getMotionProperties().applyDelta(typedValues);
        }
    }

    public void setCustomAttribute(String str, int i5, int i6) {
        this.mWidgetFrame.setCustomAttribute(str, i5, i6);
    }

    public boolean setValue(int i5, int i6) {
        if (setValueAttributes(i5, (float) i6)) {
            return true;
        }
        return setValueMotion(i5, i6);
    }

    public void setCustomAttribute(String str, int i5, boolean z4) {
        this.mWidgetFrame.setCustomAttribute(str, i5, z4);
    }

    public void setCustomAttribute(String str, int i5, String str2) {
        this.mWidgetFrame.setCustomAttribute(str, i5, str2);
    }

    public boolean setValue(int i5, float f5) {
        if (setValueAttributes(i5, f5)) {
            return true;
        }
        return setValueMotion(i5, f5);
    }

    public MotionWidget(WidgetFrame widgetFrame) {
        this.mWidgetFrame = widgetFrame;
    }

    public boolean setValue(int i5, String str) {
        if (i5 != 605) {
            return setValueMotion(i5, str);
        }
        this.mMotion.mAnimateRelativeTo = str;
        return true;
    }

    public boolean setValueMotion(int i5, String str) {
        if (i5 == 603) {
            this.mMotion.mTransitionEasing = str;
            return true;
        } else if (i5 != 604) {
            return false;
        } else {
            this.mMotion.mQuantizeInterpolatorString = str;
            return true;
        }
    }

    public boolean setValueMotion(int i5, float f5) {
        switch (i5) {
            case 600:
                this.mMotion.mMotionStagger = f5;
                return true;
            case 601:
                this.mMotion.mPathRotate = f5;
                return true;
            case TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE:
                this.mMotion.mQuantizeMotionPhase = f5;
                return true;
            default:
                return false;
        }
    }
}
