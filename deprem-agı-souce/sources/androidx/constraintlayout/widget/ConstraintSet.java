package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import androidx.core.os.EnvironmentCompat;
import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ConstraintSet {
    private static final int ALPHA = 43;
    private static final int ANIMATE_CIRCLE_ANGLE_TO = 82;
    private static final int ANIMATE_RELATIVE_TO = 64;
    private static final int BARRIER_ALLOWS_GONE_WIDGETS = 75;
    private static final int BARRIER_DIRECTION = 72;
    private static final int BARRIER_MARGIN = 73;
    private static final int BARRIER_TYPE = 1;
    public static final int BASELINE = 5;
    private static final int BASELINE_MARGIN = 93;
    private static final int BASELINE_TO_BASELINE = 1;
    private static final int BASELINE_TO_BOTTOM = 92;
    private static final int BASELINE_TO_TOP = 91;
    public static final int BOTTOM = 4;
    private static final int BOTTOM_MARGIN = 2;
    private static final int BOTTOM_TO_BOTTOM = 3;
    private static final int BOTTOM_TO_TOP = 4;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    private static final int CHAIN_USE_RTL = 71;
    private static final int CIRCLE = 61;
    private static final int CIRCLE_ANGLE = 63;
    private static final int CIRCLE_RADIUS = 62;
    public static final int CIRCLE_REFERENCE = 8;
    private static final int CONSTRAINED_HEIGHT = 81;
    private static final int CONSTRAINED_WIDTH = 80;
    private static final int CONSTRAINT_REFERENCED_IDS = 74;
    private static final int CONSTRAINT_TAG = 77;
    private static final boolean DEBUG = false;
    private static final int DIMENSION_RATIO = 5;
    private static final int DRAW_PATH = 66;
    private static final int EDITOR_ABSOLUTE_X = 6;
    private static final int EDITOR_ABSOLUTE_Y = 7;
    private static final int ELEVATION = 44;
    public static final int END = 7;
    private static final int END_MARGIN = 8;
    private static final int END_TO_END = 9;
    private static final int END_TO_START = 10;
    private static final String ERROR_MESSAGE = "XML parser error must be within a Constraint ";
    public static final int GONE = 8;
    private static final int GONE_BASELINE_MARGIN = 94;
    private static final int GONE_BOTTOM_MARGIN = 11;
    private static final int GONE_END_MARGIN = 12;
    private static final int GONE_LEFT_MARGIN = 13;
    private static final int GONE_RIGHT_MARGIN = 14;
    private static final int GONE_START_MARGIN = 15;
    private static final int GONE_TOP_MARGIN = 16;
    private static final int GUIDELINE_USE_RTL = 99;
    private static final int GUIDE_BEGIN = 17;
    private static final int GUIDE_END = 18;
    private static final int GUIDE_PERCENT = 19;
    private static final int HEIGHT_DEFAULT = 55;
    private static final int HEIGHT_MAX = 57;
    private static final int HEIGHT_MIN = 59;
    private static final int HEIGHT_PERCENT = 70;
    public static final int HORIZONTAL = 0;
    private static final int HORIZONTAL_BIAS = 20;
    public static final int HORIZONTAL_GUIDELINE = 0;
    private static final int HORIZONTAL_STYLE = 41;
    private static final int HORIZONTAL_WEIGHT = 39;
    private static final int INTERNAL_MATCH_CONSTRAINT = -3;
    private static final int INTERNAL_MATCH_PARENT = -1;
    private static final int INTERNAL_WRAP_CONTENT = -2;
    private static final int INTERNAL_WRAP_CONTENT_CONSTRAINED = -4;
    public static final int INVISIBLE = 4;
    private static final String KEY_PERCENT_PARENT = "parent";
    private static final String KEY_RATIO = "ratio";
    private static final String KEY_WEIGHT = "weight";
    private static final int LAYOUT_CONSTRAINT_HEIGHT = 96;
    private static final int LAYOUT_CONSTRAINT_WIDTH = 95;
    private static final int LAYOUT_HEIGHT = 21;
    private static final int LAYOUT_VISIBILITY = 22;
    private static final int LAYOUT_WIDTH = 23;
    private static final int LAYOUT_WRAP_BEHAVIOR = 97;
    public static final int LEFT = 1;
    private static final int LEFT_MARGIN = 24;
    private static final int LEFT_TO_LEFT = 25;
    private static final int LEFT_TO_RIGHT = 26;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    private static final int MOTION_STAGGER = 79;
    private static final int MOTION_TARGET = 98;
    private static final int ORIENTATION = 27;
    public static final int PARENT_ID = 0;
    private static final int PATH_MOTION_ARC = 76;
    private static final int PROGRESS = 68;
    private static final int QUANTIZE_MOTION_INTERPOLATOR = 86;
    private static final int QUANTIZE_MOTION_INTERPOLATOR_ID = 89;
    private static final int QUANTIZE_MOTION_INTERPOLATOR_STR = 90;
    private static final int QUANTIZE_MOTION_INTERPOLATOR_TYPE = 88;
    private static final int QUANTIZE_MOTION_PHASE = 85;
    private static final int QUANTIZE_MOTION_STEPS = 84;
    public static final int RIGHT = 2;
    private static final int RIGHT_MARGIN = 28;
    private static final int RIGHT_TO_LEFT = 29;
    private static final int RIGHT_TO_RIGHT = 30;
    public static final int ROTATE_LEFT_OF_PORTRATE = 4;
    public static final int ROTATE_NONE = 0;
    public static final int ROTATE_PORTRATE_OF_LEFT = 2;
    public static final int ROTATE_PORTRATE_OF_RIGHT = 1;
    public static final int ROTATE_RIGHT_OF_PORTRATE = 3;
    private static final int ROTATION = 60;
    private static final int ROTATION_X = 45;
    private static final int ROTATION_Y = 46;
    private static final int SCALE_X = 47;
    private static final int SCALE_Y = 48;
    public static final int START = 6;
    private static final int START_MARGIN = 31;
    private static final int START_TO_END = 32;
    private static final int START_TO_START = 33;
    private static final String TAG = "ConstraintSet";
    public static final int TOP = 3;
    private static final int TOP_MARGIN = 34;
    private static final int TOP_TO_BOTTOM = 35;
    private static final int TOP_TO_TOP = 36;
    private static final int TRANSFORM_PIVOT_TARGET = 83;
    private static final int TRANSFORM_PIVOT_X = 49;
    private static final int TRANSFORM_PIVOT_Y = 50;
    private static final int TRANSITION_EASING = 65;
    private static final int TRANSITION_PATH_ROTATE = 67;
    private static final int TRANSLATION_X = 51;
    private static final int TRANSLATION_Y = 52;
    private static final int TRANSLATION_Z = 53;
    public static final int UNSET = -1;
    private static final int UNUSED = 87;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_BIAS = 37;
    public static final int VERTICAL_GUIDELINE = 1;
    private static final int VERTICAL_STYLE = 42;
    private static final int VERTICAL_WEIGHT = 40;
    private static final int VIEW_ID = 38;
    /* access modifiers changed from: private */
    public static final int[] VISIBILITY_FLAGS = {0, 4, 8};
    private static final int VISIBILITY_MODE = 78;
    public static final int VISIBILITY_MODE_IGNORE = 1;
    public static final int VISIBILITY_MODE_NORMAL = 0;
    public static final int VISIBLE = 0;
    private static final int WIDTH_DEFAULT = 54;
    private static final int WIDTH_MAX = 56;
    private static final int WIDTH_MIN = 58;
    private static final int WIDTH_PERCENT = 69;
    public static final int WRAP_CONTENT = -2;
    private static SparseIntArray sMapToConstant = new SparseIntArray();
    private static SparseIntArray sOverrideMapToConstant = new SparseIntArray();
    public String derivedState = "";
    /* access modifiers changed from: private */
    public HashMap<Integer, Constraint> mConstraints = new HashMap<>();
    private boolean mForceId = true;
    public String mIdString;
    private String[] mMatchLabels = new String[0];
    public int mRotate = 0;
    private HashMap<String, ConstraintAttribute> mSavedAttributes = new HashMap<>();
    private boolean mValidate;

    public static class Constraint {
        public final Layout layout = new Layout();
        public HashMap<String, ConstraintAttribute> mCustomConstraints = new HashMap<>();
        Delta mDelta;
        String mTargetString;
        int mViewId;
        public final Motion motion = new Motion();
        public final PropertySet propertySet = new PropertySet();
        public final Transform transform = new Transform();

        /* access modifiers changed from: private */
        public void fillFrom(int i5, ConstraintLayout.LayoutParams layoutParams) {
            this.mViewId = i5;
            Layout layout2 = this.layout;
            layout2.leftToLeft = layoutParams.leftToLeft;
            layout2.leftToRight = layoutParams.leftToRight;
            layout2.rightToLeft = layoutParams.rightToLeft;
            layout2.rightToRight = layoutParams.rightToRight;
            layout2.topToTop = layoutParams.topToTop;
            layout2.topToBottom = layoutParams.topToBottom;
            layout2.bottomToTop = layoutParams.bottomToTop;
            layout2.bottomToBottom = layoutParams.bottomToBottom;
            layout2.baselineToBaseline = layoutParams.baselineToBaseline;
            layout2.baselineToTop = layoutParams.baselineToTop;
            layout2.baselineToBottom = layoutParams.baselineToBottom;
            layout2.startToEnd = layoutParams.startToEnd;
            layout2.startToStart = layoutParams.startToStart;
            layout2.endToStart = layoutParams.endToStart;
            layout2.endToEnd = layoutParams.endToEnd;
            layout2.horizontalBias = layoutParams.horizontalBias;
            layout2.verticalBias = layoutParams.verticalBias;
            layout2.dimensionRatio = layoutParams.dimensionRatio;
            layout2.circleConstraint = layoutParams.circleConstraint;
            layout2.circleRadius = layoutParams.circleRadius;
            layout2.circleAngle = layoutParams.circleAngle;
            layout2.editorAbsoluteX = layoutParams.editorAbsoluteX;
            layout2.editorAbsoluteY = layoutParams.editorAbsoluteY;
            layout2.orientation = layoutParams.orientation;
            layout2.guidePercent = layoutParams.guidePercent;
            layout2.guideBegin = layoutParams.guideBegin;
            layout2.guideEnd = layoutParams.guideEnd;
            layout2.mWidth = layoutParams.width;
            layout2.mHeight = layoutParams.height;
            layout2.leftMargin = layoutParams.leftMargin;
            layout2.rightMargin = layoutParams.rightMargin;
            layout2.topMargin = layoutParams.topMargin;
            layout2.bottomMargin = layoutParams.bottomMargin;
            layout2.baselineMargin = layoutParams.baselineMargin;
            layout2.verticalWeight = layoutParams.verticalWeight;
            layout2.horizontalWeight = layoutParams.horizontalWeight;
            layout2.verticalChainStyle = layoutParams.verticalChainStyle;
            layout2.horizontalChainStyle = layoutParams.horizontalChainStyle;
            layout2.constrainedWidth = layoutParams.constrainedWidth;
            layout2.constrainedHeight = layoutParams.constrainedHeight;
            layout2.widthDefault = layoutParams.matchConstraintDefaultWidth;
            layout2.heightDefault = layoutParams.matchConstraintDefaultHeight;
            layout2.widthMax = layoutParams.matchConstraintMaxWidth;
            layout2.heightMax = layoutParams.matchConstraintMaxHeight;
            layout2.widthMin = layoutParams.matchConstraintMinWidth;
            layout2.heightMin = layoutParams.matchConstraintMinHeight;
            layout2.widthPercent = layoutParams.matchConstraintPercentWidth;
            layout2.heightPercent = layoutParams.matchConstraintPercentHeight;
            layout2.mConstraintTag = layoutParams.constraintTag;
            layout2.goneTopMargin = layoutParams.goneTopMargin;
            layout2.goneBottomMargin = layoutParams.goneBottomMargin;
            layout2.goneLeftMargin = layoutParams.goneLeftMargin;
            layout2.goneRightMargin = layoutParams.goneRightMargin;
            layout2.goneStartMargin = layoutParams.goneStartMargin;
            layout2.goneEndMargin = layoutParams.goneEndMargin;
            layout2.goneBaselineMargin = layoutParams.goneBaselineMargin;
            layout2.mWrapBehavior = layoutParams.wrapBehaviorInParent;
            layout2.endMargin = layoutParams.getMarginEnd();
            this.layout.startMargin = layoutParams.getMarginStart();
        }

        /* access modifiers changed from: private */
        public void fillFromConstraints(ConstraintHelper constraintHelper, int i5, Constraints.LayoutParams layoutParams) {
            fillFromConstraints(i5, layoutParams);
            if (constraintHelper instanceof Barrier) {
                Layout layout2 = this.layout;
                layout2.mHelperType = 1;
                Barrier barrier = (Barrier) constraintHelper;
                layout2.mBarrierDirection = barrier.getType();
                this.layout.mReferenceIds = barrier.getReferencedIds();
                this.layout.mBarrierMargin = barrier.getMargin();
            }
        }

        private ConstraintAttribute get(String str, ConstraintAttribute.AttributeType attributeType) {
            if (this.mCustomConstraints.containsKey(str)) {
                ConstraintAttribute constraintAttribute = this.mCustomConstraints.get(str);
                if (constraintAttribute.getType() == attributeType) {
                    return constraintAttribute;
                }
                throw new IllegalArgumentException("ConstraintAttribute is already a " + constraintAttribute.getType().name());
            }
            ConstraintAttribute constraintAttribute2 = new ConstraintAttribute(str, attributeType);
            this.mCustomConstraints.put(str, constraintAttribute2);
            return constraintAttribute2;
        }

        /* access modifiers changed from: private */
        public void setColorValue(String str, int i5) {
            get(str, ConstraintAttribute.AttributeType.COLOR_TYPE).setColorValue(i5);
        }

        /* access modifiers changed from: private */
        public void setFloatValue(String str, float f5) {
            get(str, ConstraintAttribute.AttributeType.FLOAT_TYPE).setFloatValue(f5);
        }

        /* access modifiers changed from: private */
        public void setIntValue(String str, int i5) {
            get(str, ConstraintAttribute.AttributeType.INT_TYPE).setIntValue(i5);
        }

        /* access modifiers changed from: private */
        public void setStringValue(String str, String str2) {
            get(str, ConstraintAttribute.AttributeType.STRING_TYPE).setStringValue(str2);
        }

        public void applyDelta(Constraint constraint) {
            Delta delta = this.mDelta;
            if (delta != null) {
                delta.applyDelta(constraint);
            }
        }

        public void applyTo(ConstraintLayout.LayoutParams layoutParams) {
            Layout layout2 = this.layout;
            layoutParams.leftToLeft = layout2.leftToLeft;
            layoutParams.leftToRight = layout2.leftToRight;
            layoutParams.rightToLeft = layout2.rightToLeft;
            layoutParams.rightToRight = layout2.rightToRight;
            layoutParams.topToTop = layout2.topToTop;
            layoutParams.topToBottom = layout2.topToBottom;
            layoutParams.bottomToTop = layout2.bottomToTop;
            layoutParams.bottomToBottom = layout2.bottomToBottom;
            layoutParams.baselineToBaseline = layout2.baselineToBaseline;
            layoutParams.baselineToTop = layout2.baselineToTop;
            layoutParams.baselineToBottom = layout2.baselineToBottom;
            layoutParams.startToEnd = layout2.startToEnd;
            layoutParams.startToStart = layout2.startToStart;
            layoutParams.endToStart = layout2.endToStart;
            layoutParams.endToEnd = layout2.endToEnd;
            layoutParams.leftMargin = layout2.leftMargin;
            layoutParams.rightMargin = layout2.rightMargin;
            layoutParams.topMargin = layout2.topMargin;
            layoutParams.bottomMargin = layout2.bottomMargin;
            layoutParams.goneStartMargin = layout2.goneStartMargin;
            layoutParams.goneEndMargin = layout2.goneEndMargin;
            layoutParams.goneTopMargin = layout2.goneTopMargin;
            layoutParams.goneBottomMargin = layout2.goneBottomMargin;
            layoutParams.horizontalBias = layout2.horizontalBias;
            layoutParams.verticalBias = layout2.verticalBias;
            layoutParams.circleConstraint = layout2.circleConstraint;
            layoutParams.circleRadius = layout2.circleRadius;
            layoutParams.circleAngle = layout2.circleAngle;
            layoutParams.dimensionRatio = layout2.dimensionRatio;
            layoutParams.editorAbsoluteX = layout2.editorAbsoluteX;
            layoutParams.editorAbsoluteY = layout2.editorAbsoluteY;
            layoutParams.verticalWeight = layout2.verticalWeight;
            layoutParams.horizontalWeight = layout2.horizontalWeight;
            layoutParams.verticalChainStyle = layout2.verticalChainStyle;
            layoutParams.horizontalChainStyle = layout2.horizontalChainStyle;
            layoutParams.constrainedWidth = layout2.constrainedWidth;
            layoutParams.constrainedHeight = layout2.constrainedHeight;
            layoutParams.matchConstraintDefaultWidth = layout2.widthDefault;
            layoutParams.matchConstraintDefaultHeight = layout2.heightDefault;
            layoutParams.matchConstraintMaxWidth = layout2.widthMax;
            layoutParams.matchConstraintMaxHeight = layout2.heightMax;
            layoutParams.matchConstraintMinWidth = layout2.widthMin;
            layoutParams.matchConstraintMinHeight = layout2.heightMin;
            layoutParams.matchConstraintPercentWidth = layout2.widthPercent;
            layoutParams.matchConstraintPercentHeight = layout2.heightPercent;
            layoutParams.orientation = layout2.orientation;
            layoutParams.guidePercent = layout2.guidePercent;
            layoutParams.guideBegin = layout2.guideBegin;
            layoutParams.guideEnd = layout2.guideEnd;
            layoutParams.width = layout2.mWidth;
            layoutParams.height = layout2.mHeight;
            String str = layout2.mConstraintTag;
            if (str != null) {
                layoutParams.constraintTag = str;
            }
            layoutParams.wrapBehaviorInParent = layout2.mWrapBehavior;
            layoutParams.setMarginStart(layout2.startMargin);
            layoutParams.setMarginEnd(this.layout.endMargin);
            layoutParams.validate();
        }

        public void printDelta(String str) {
            Delta delta = this.mDelta;
            if (delta != null) {
                delta.printDelta(str);
            } else {
                Log.v(str, "DELTA IS NULL");
            }
        }

        public Constraint clone() {
            Constraint constraint = new Constraint();
            constraint.layout.copyFrom(this.layout);
            constraint.motion.copyFrom(this.motion);
            constraint.propertySet.copyFrom(this.propertySet);
            constraint.transform.copyFrom(this.transform);
            constraint.mViewId = this.mViewId;
            constraint.mDelta = this.mDelta;
            return constraint;
        }

        static class Delta {
            private static final int INITIAL_BOOLEAN = 4;
            private static final int INITIAL_FLOAT = 10;
            private static final int INITIAL_INT = 10;
            private static final int INITIAL_STRING = 5;
            int mCountBoolean = 0;
            int mCountFloat = 0;
            int mCountInt = 0;
            int mCountString = 0;
            int[] mTypeBoolean = new int[4];
            int[] mTypeFloat = new int[10];
            int[] mTypeInt = new int[10];
            int[] mTypeString = new int[5];
            boolean[] mValueBoolean = new boolean[4];
            float[] mValueFloat = new float[10];
            int[] mValueInt = new int[10];
            String[] mValueString = new String[5];

            Delta() {
            }

            /* access modifiers changed from: package-private */
            public void add(int i5, int i6) {
                int i7 = this.mCountInt;
                int[] iArr = this.mTypeInt;
                if (i7 >= iArr.length) {
                    this.mTypeInt = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.mValueInt;
                    this.mValueInt = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.mTypeInt;
                int i8 = this.mCountInt;
                iArr3[i8] = i5;
                int[] iArr4 = this.mValueInt;
                this.mCountInt = i8 + 1;
                iArr4[i8] = i6;
            }

            /* access modifiers changed from: package-private */
            public void applyDelta(Constraint constraint) {
                for (int i5 = 0; i5 < this.mCountInt; i5++) {
                    ConstraintSet.setDeltaValue(constraint, this.mTypeInt[i5], this.mValueInt[i5]);
                }
                for (int i6 = 0; i6 < this.mCountFloat; i6++) {
                    ConstraintSet.setDeltaValue(constraint, this.mTypeFloat[i6], this.mValueFloat[i6]);
                }
                for (int i7 = 0; i7 < this.mCountString; i7++) {
                    ConstraintSet.setDeltaValue(constraint, this.mTypeString[i7], this.mValueString[i7]);
                }
                for (int i8 = 0; i8 < this.mCountBoolean; i8++) {
                    ConstraintSet.setDeltaValue(constraint, this.mTypeBoolean[i8], this.mValueBoolean[i8]);
                }
            }

            /* access modifiers changed from: package-private */
            @SuppressLint({"LogConditional"})
            public void printDelta(String str) {
                Log.v(str, "int");
                for (int i5 = 0; i5 < this.mCountInt; i5++) {
                    Log.v(str, this.mTypeInt[i5] + " = " + this.mValueInt[i5]);
                }
                Log.v(str, TypedValues.Custom.S_FLOAT);
                for (int i6 = 0; i6 < this.mCountFloat; i6++) {
                    Log.v(str, this.mTypeFloat[i6] + " = " + this.mValueFloat[i6]);
                }
                Log.v(str, "strings");
                for (int i7 = 0; i7 < this.mCountString; i7++) {
                    Log.v(str, this.mTypeString[i7] + " = " + this.mValueString[i7]);
                }
                Log.v(str, TypedValues.Custom.S_BOOLEAN);
                for (int i8 = 0; i8 < this.mCountBoolean; i8++) {
                    Log.v(str, this.mTypeBoolean[i8] + " = " + this.mValueBoolean[i8]);
                }
            }

            /* access modifiers changed from: package-private */
            public void add(int i5, float f5) {
                int i6 = this.mCountFloat;
                int[] iArr = this.mTypeFloat;
                if (i6 >= iArr.length) {
                    this.mTypeFloat = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.mValueFloat;
                    this.mValueFloat = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.mTypeFloat;
                int i7 = this.mCountFloat;
                iArr2[i7] = i5;
                float[] fArr2 = this.mValueFloat;
                this.mCountFloat = i7 + 1;
                fArr2[i7] = f5;
            }

            /* access modifiers changed from: package-private */
            public void add(int i5, String str) {
                int i6 = this.mCountString;
                int[] iArr = this.mTypeString;
                if (i6 >= iArr.length) {
                    this.mTypeString = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.mValueString;
                    this.mValueString = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.mTypeString;
                int i7 = this.mCountString;
                iArr2[i7] = i5;
                String[] strArr2 = this.mValueString;
                this.mCountString = i7 + 1;
                strArr2[i7] = str;
            }

            /* access modifiers changed from: package-private */
            public void add(int i5, boolean z4) {
                int i6 = this.mCountBoolean;
                int[] iArr = this.mTypeBoolean;
                if (i6 >= iArr.length) {
                    this.mTypeBoolean = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.mValueBoolean;
                    this.mValueBoolean = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.mTypeBoolean;
                int i7 = this.mCountBoolean;
                iArr2[i7] = i5;
                boolean[] zArr2 = this.mValueBoolean;
                this.mCountBoolean = i7 + 1;
                zArr2[i7] = z4;
            }
        }

        /* access modifiers changed from: private */
        public void fillFromConstraints(int i5, Constraints.LayoutParams layoutParams) {
            fillFrom(i5, layoutParams);
            this.propertySet.alpha = layoutParams.alpha;
            Transform transform2 = this.transform;
            transform2.rotation = layoutParams.rotation;
            transform2.rotationX = layoutParams.rotationX;
            transform2.rotationY = layoutParams.rotationY;
            transform2.scaleX = layoutParams.scaleX;
            transform2.scaleY = layoutParams.scaleY;
            transform2.transformPivotX = layoutParams.transformPivotX;
            transform2.transformPivotY = layoutParams.transformPivotY;
            transform2.translationX = layoutParams.translationX;
            transform2.translationY = layoutParams.translationY;
            transform2.translationZ = layoutParams.translationZ;
            transform2.elevation = layoutParams.elevation;
            transform2.applyElevation = layoutParams.applyElevation;
        }
    }

    public static class Layout {
        private static final int BARRIER_ALLOWS_GONE_WIDGETS = 75;
        private static final int BARRIER_DIRECTION = 72;
        private static final int BARRIER_MARGIN = 73;
        private static final int BASELINE_MARGIN = 80;
        private static final int BASELINE_TO_BASELINE = 1;
        private static final int BASELINE_TO_BOTTOM = 78;
        private static final int BASELINE_TO_TOP = 77;
        private static final int BOTTOM_MARGIN = 2;
        private static final int BOTTOM_TO_BOTTOM = 3;
        private static final int BOTTOM_TO_TOP = 4;
        private static final int CHAIN_USE_RTL = 71;
        private static final int CIRCLE = 61;
        private static final int CIRCLE_ANGLE = 63;
        private static final int CIRCLE_RADIUS = 62;
        private static final int CONSTRAINED_HEIGHT = 88;
        private static final int CONSTRAINED_WIDTH = 87;
        private static final int CONSTRAINT_REFERENCED_IDS = 74;
        private static final int CONSTRAINT_TAG = 89;
        private static final int DIMENSION_RATIO = 5;
        private static final int EDITOR_ABSOLUTE_X = 6;
        private static final int EDITOR_ABSOLUTE_Y = 7;
        private static final int END_MARGIN = 8;
        private static final int END_TO_END = 9;
        private static final int END_TO_START = 10;
        private static final int GONE_BASELINE_MARGIN = 79;
        private static final int GONE_BOTTOM_MARGIN = 11;
        private static final int GONE_END_MARGIN = 12;
        private static final int GONE_LEFT_MARGIN = 13;
        private static final int GONE_RIGHT_MARGIN = 14;
        private static final int GONE_START_MARGIN = 15;
        private static final int GONE_TOP_MARGIN = 16;
        private static final int GUIDE_BEGIN = 17;
        private static final int GUIDE_END = 18;
        private static final int GUIDE_PERCENT = 19;
        private static final int GUIDE_USE_RTL = 90;
        private static final int HEIGHT_DEFAULT = 82;
        private static final int HEIGHT_MAX = 83;
        private static final int HEIGHT_MIN = 85;
        private static final int HEIGHT_PERCENT = 70;
        private static final int HORIZONTAL_BIAS = 20;
        private static final int HORIZONTAL_STYLE = 39;
        private static final int HORIZONTAL_WEIGHT = 37;
        private static final int LAYOUT_CONSTRAINT_HEIGHT = 42;
        private static final int LAYOUT_CONSTRAINT_WIDTH = 41;
        private static final int LAYOUT_HEIGHT = 21;
        private static final int LAYOUT_WIDTH = 22;
        private static final int LAYOUT_WRAP_BEHAVIOR = 76;
        private static final int LEFT_MARGIN = 23;
        private static final int LEFT_TO_LEFT = 24;
        private static final int LEFT_TO_RIGHT = 25;
        private static final int ORIENTATION = 26;
        private static final int RIGHT_MARGIN = 27;
        private static final int RIGHT_TO_LEFT = 28;
        private static final int RIGHT_TO_RIGHT = 29;
        private static final int START_MARGIN = 30;
        private static final int START_TO_END = 31;
        private static final int START_TO_START = 32;
        private static final int TOP_MARGIN = 33;
        private static final int TOP_TO_BOTTOM = 34;
        private static final int TOP_TO_TOP = 35;
        public static final int UNSET = -1;
        public static final int UNSET_GONE_MARGIN = Integer.MIN_VALUE;
        private static final int UNUSED = 91;
        private static final int VERTICAL_BIAS = 36;
        private static final int VERTICAL_STYLE = 40;
        private static final int VERTICAL_WEIGHT = 38;
        private static final int WIDTH_DEFAULT = 81;
        private static final int WIDTH_MAX = 84;
        private static final int WIDTH_MIN = 86;
        private static final int WIDTH_PERCENT = 69;
        private static SparseIntArray sMapToConstant;
        public int baselineMargin = 0;
        public int baselineToBaseline = -1;
        public int baselineToBottom = -1;
        public int baselineToTop = -1;
        public int bottomMargin = 0;
        public int bottomToBottom = -1;
        public int bottomToTop = -1;
        public float circleAngle = 0.0f;
        public int circleConstraint = -1;
        public int circleRadius = 0;
        public boolean constrainedHeight = false;
        public boolean constrainedWidth = false;
        public String dimensionRatio = null;
        public int editorAbsoluteX = -1;
        public int editorAbsoluteY = -1;
        public int endMargin = 0;
        public int endToEnd = -1;
        public int endToStart = -1;
        public int goneBaselineMargin = Integer.MIN_VALUE;
        public int goneBottomMargin = Integer.MIN_VALUE;
        public int goneEndMargin = Integer.MIN_VALUE;
        public int goneLeftMargin = Integer.MIN_VALUE;
        public int goneRightMargin = Integer.MIN_VALUE;
        public int goneStartMargin = Integer.MIN_VALUE;
        public int goneTopMargin = Integer.MIN_VALUE;
        public int guideBegin = -1;
        public int guideEnd = -1;
        public float guidePercent = -1.0f;
        public boolean guidelineUseRtl = true;
        public int heightDefault = 0;
        public int heightMax = 0;
        public int heightMin = 0;
        public float heightPercent = 1.0f;
        public float horizontalBias = 0.5f;
        public int horizontalChainStyle = 0;
        public float horizontalWeight = -1.0f;
        public int leftMargin = 0;
        public int leftToLeft = -1;
        public int leftToRight = -1;
        public boolean mApply = false;
        public boolean mBarrierAllowsGoneWidgets = true;
        public int mBarrierDirection = -1;
        public int mBarrierMargin = 0;
        public String mConstraintTag;
        public int mHeight;
        public int mHelperType = -1;
        public boolean mIsGuideline = false;
        public boolean mOverride = false;
        public String mReferenceIdString;
        public int[] mReferenceIds;
        public int mWidth;
        public int mWrapBehavior = 0;
        public int orientation = -1;
        public int rightMargin = 0;
        public int rightToLeft = -1;
        public int rightToRight = -1;
        public int startMargin = 0;
        public int startToEnd = -1;
        public int startToStart = -1;
        public int topMargin = 0;
        public int topToBottom = -1;
        public int topToTop = -1;
        public float verticalBias = 0.5f;
        public int verticalChainStyle = 0;
        public float verticalWeight = -1.0f;
        public int widthDefault = 0;
        public int widthMax = 0;
        public int widthMin = 0;
        public float widthPercent = 1.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            sMapToConstant = sparseIntArray;
            sparseIntArray.append(R.styleable.Layout_layout_constraintLeft_toLeftOf, 24);
            sMapToConstant.append(R.styleable.Layout_layout_constraintLeft_toRightOf, 25);
            sMapToConstant.append(R.styleable.Layout_layout_constraintRight_toLeftOf, 28);
            sMapToConstant.append(R.styleable.Layout_layout_constraintRight_toRightOf, 29);
            sMapToConstant.append(R.styleable.Layout_layout_constraintTop_toTopOf, 35);
            sMapToConstant.append(R.styleable.Layout_layout_constraintTop_toBottomOf, 34);
            sMapToConstant.append(R.styleable.Layout_layout_constraintBottom_toTopOf, 4);
            sMapToConstant.append(R.styleable.Layout_layout_constraintBottom_toBottomOf, 3);
            sMapToConstant.append(R.styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
            sMapToConstant.append(R.styleable.Layout_layout_editor_absoluteX, 6);
            sMapToConstant.append(R.styleable.Layout_layout_editor_absoluteY, 7);
            sMapToConstant.append(R.styleable.Layout_layout_constraintGuide_begin, 17);
            sMapToConstant.append(R.styleable.Layout_layout_constraintGuide_end, 18);
            sMapToConstant.append(R.styleable.Layout_layout_constraintGuide_percent, 19);
            SparseIntArray sparseIntArray2 = sMapToConstant;
            int i5 = R.styleable.Layout_guidelineUseRtl;
            sparseIntArray2.append(i5, 90);
            sMapToConstant.append(R.styleable.Layout_android_orientation, 26);
            sMapToConstant.append(R.styleable.Layout_layout_constraintStart_toEndOf, 31);
            sMapToConstant.append(R.styleable.Layout_layout_constraintStart_toStartOf, 32);
            sMapToConstant.append(R.styleable.Layout_layout_constraintEnd_toStartOf, 10);
            sMapToConstant.append(R.styleable.Layout_layout_constraintEnd_toEndOf, 9);
            sMapToConstant.append(R.styleable.Layout_layout_goneMarginLeft, 13);
            sMapToConstant.append(R.styleable.Layout_layout_goneMarginTop, 16);
            sMapToConstant.append(R.styleable.Layout_layout_goneMarginRight, 14);
            sMapToConstant.append(R.styleable.Layout_layout_goneMarginBottom, 11);
            sMapToConstant.append(R.styleable.Layout_layout_goneMarginStart, 15);
            sMapToConstant.append(R.styleable.Layout_layout_goneMarginEnd, 12);
            sMapToConstant.append(R.styleable.Layout_layout_constraintVertical_weight, 38);
            sMapToConstant.append(R.styleable.Layout_layout_constraintHorizontal_weight, 37);
            sMapToConstant.append(R.styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
            sMapToConstant.append(R.styleable.Layout_layout_constraintVertical_chainStyle, 40);
            sMapToConstant.append(R.styleable.Layout_layout_constraintHorizontal_bias, 20);
            sMapToConstant.append(R.styleable.Layout_layout_constraintVertical_bias, 36);
            sMapToConstant.append(R.styleable.Layout_layout_constraintDimensionRatio, 5);
            sMapToConstant.append(R.styleable.Layout_layout_constraintLeft_creator, 91);
            sMapToConstant.append(R.styleable.Layout_layout_constraintTop_creator, 91);
            sMapToConstant.append(R.styleable.Layout_layout_constraintRight_creator, 91);
            sMapToConstant.append(R.styleable.Layout_layout_constraintBottom_creator, 91);
            sMapToConstant.append(R.styleable.Layout_layout_constraintBaseline_creator, 91);
            sMapToConstant.append(R.styleable.Layout_android_layout_marginLeft, 23);
            sMapToConstant.append(R.styleable.Layout_android_layout_marginRight, 27);
            sMapToConstant.append(R.styleable.Layout_android_layout_marginStart, 30);
            sMapToConstant.append(R.styleable.Layout_android_layout_marginEnd, 8);
            sMapToConstant.append(R.styleable.Layout_android_layout_marginTop, 33);
            sMapToConstant.append(R.styleable.Layout_android_layout_marginBottom, 2);
            sMapToConstant.append(R.styleable.Layout_android_layout_width, 22);
            sMapToConstant.append(R.styleable.Layout_android_layout_height, 21);
            SparseIntArray sparseIntArray3 = sMapToConstant;
            int i6 = R.styleable.Layout_layout_constraintWidth;
            sparseIntArray3.append(i6, 41);
            SparseIntArray sparseIntArray4 = sMapToConstant;
            int i7 = R.styleable.Layout_layout_constraintHeight;
            sparseIntArray4.append(i7, 42);
            sMapToConstant.append(R.styleable.Layout_layout_constrainedWidth, 87);
            sMapToConstant.append(R.styleable.Layout_layout_constrainedHeight, 88);
            sMapToConstant.append(R.styleable.Layout_layout_wrapBehaviorInParent, 76);
            sMapToConstant.append(R.styleable.Layout_layout_constraintCircle, 61);
            sMapToConstant.append(R.styleable.Layout_layout_constraintCircleRadius, 62);
            sMapToConstant.append(R.styleable.Layout_layout_constraintCircleAngle, 63);
            sMapToConstant.append(R.styleable.Layout_layout_constraintWidth_percent, 69);
            sMapToConstant.append(R.styleable.Layout_layout_constraintHeight_percent, 70);
            sMapToConstant.append(R.styleable.Layout_chainUseRtl, 71);
            sMapToConstant.append(R.styleable.Layout_barrierDirection, 72);
            sMapToConstant.append(R.styleable.Layout_barrierMargin, 73);
            sMapToConstant.append(R.styleable.Layout_constraint_referenced_ids, 74);
            sMapToConstant.append(R.styleable.Layout_barrierAllowsGoneWidgets, 75);
            SparseIntArray sparseIntArray5 = sMapToConstant;
            int i8 = R.styleable.Layout_layout_constraintWidth_max;
            sparseIntArray5.append(i8, 84);
            sMapToConstant.append(R.styleable.Layout_layout_constraintWidth_min, 86);
            sMapToConstant.append(i8, 83);
            sMapToConstant.append(R.styleable.Layout_layout_constraintHeight_min, 85);
            sMapToConstant.append(i6, 87);
            sMapToConstant.append(i7, 88);
            sMapToConstant.append(R.styleable.ConstraintLayout_Layout_layout_constraintTag, 89);
            sMapToConstant.append(i5, 90);
        }

        public void copyFrom(Layout layout) {
            this.mIsGuideline = layout.mIsGuideline;
            this.mWidth = layout.mWidth;
            this.mApply = layout.mApply;
            this.mHeight = layout.mHeight;
            this.guideBegin = layout.guideBegin;
            this.guideEnd = layout.guideEnd;
            this.guidePercent = layout.guidePercent;
            this.guidelineUseRtl = layout.guidelineUseRtl;
            this.leftToLeft = layout.leftToLeft;
            this.leftToRight = layout.leftToRight;
            this.rightToLeft = layout.rightToLeft;
            this.rightToRight = layout.rightToRight;
            this.topToTop = layout.topToTop;
            this.topToBottom = layout.topToBottom;
            this.bottomToTop = layout.bottomToTop;
            this.bottomToBottom = layout.bottomToBottom;
            this.baselineToBaseline = layout.baselineToBaseline;
            this.baselineToTop = layout.baselineToTop;
            this.baselineToBottom = layout.baselineToBottom;
            this.startToEnd = layout.startToEnd;
            this.startToStart = layout.startToStart;
            this.endToStart = layout.endToStart;
            this.endToEnd = layout.endToEnd;
            this.horizontalBias = layout.horizontalBias;
            this.verticalBias = layout.verticalBias;
            this.dimensionRatio = layout.dimensionRatio;
            this.circleConstraint = layout.circleConstraint;
            this.circleRadius = layout.circleRadius;
            this.circleAngle = layout.circleAngle;
            this.editorAbsoluteX = layout.editorAbsoluteX;
            this.editorAbsoluteY = layout.editorAbsoluteY;
            this.orientation = layout.orientation;
            this.leftMargin = layout.leftMargin;
            this.rightMargin = layout.rightMargin;
            this.topMargin = layout.topMargin;
            this.bottomMargin = layout.bottomMargin;
            this.endMargin = layout.endMargin;
            this.startMargin = layout.startMargin;
            this.baselineMargin = layout.baselineMargin;
            this.goneLeftMargin = layout.goneLeftMargin;
            this.goneTopMargin = layout.goneTopMargin;
            this.goneRightMargin = layout.goneRightMargin;
            this.goneBottomMargin = layout.goneBottomMargin;
            this.goneEndMargin = layout.goneEndMargin;
            this.goneStartMargin = layout.goneStartMargin;
            this.goneBaselineMargin = layout.goneBaselineMargin;
            this.verticalWeight = layout.verticalWeight;
            this.horizontalWeight = layout.horizontalWeight;
            this.horizontalChainStyle = layout.horizontalChainStyle;
            this.verticalChainStyle = layout.verticalChainStyle;
            this.widthDefault = layout.widthDefault;
            this.heightDefault = layout.heightDefault;
            this.widthMax = layout.widthMax;
            this.heightMax = layout.heightMax;
            this.widthMin = layout.widthMin;
            this.heightMin = layout.heightMin;
            this.widthPercent = layout.widthPercent;
            this.heightPercent = layout.heightPercent;
            this.mBarrierDirection = layout.mBarrierDirection;
            this.mBarrierMargin = layout.mBarrierMargin;
            this.mHelperType = layout.mHelperType;
            this.mConstraintTag = layout.mConstraintTag;
            int[] iArr = layout.mReferenceIds;
            if (iArr == null || layout.mReferenceIdString != null) {
                this.mReferenceIds = null;
            } else {
                this.mReferenceIds = Arrays.copyOf(iArr, iArr.length);
            }
            this.mReferenceIdString = layout.mReferenceIdString;
            this.constrainedWidth = layout.constrainedWidth;
            this.constrainedHeight = layout.constrainedHeight;
            this.mBarrierAllowsGoneWidgets = layout.mBarrierAllowsGoneWidgets;
            this.mWrapBehavior = layout.mWrapBehavior;
        }

        /* JADX WARNING: type inference failed for: r2v8, types: [java.lang.String] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void dump(androidx.constraintlayout.motion.widget.MotionScene r10, java.lang.StringBuilder r11) {
            /*
                r9 = this;
                java.lang.Class r0 = r9.getClass()
                java.lang.reflect.Field[] r0 = r0.getDeclaredFields()
                java.lang.String r1 = "\n"
                r11.append(r1)
                r1 = 0
            L_0x000e:
                int r2 = r0.length
                if (r1 >= r2) goto L_0x0085
                r2 = r0[r1]
                java.lang.String r3 = r2.getName()
                int r4 = r2.getModifiers()
                boolean r4 = java.lang.reflect.Modifier.isStatic(r4)
                if (r4 == 0) goto L_0x0022
                goto L_0x0082
            L_0x0022:
                java.lang.Object r4 = r2.get(r9)     // Catch:{ IllegalAccessException -> 0x0059 }
                java.lang.Class r2 = r2.getType()     // Catch:{ IllegalAccessException -> 0x0059 }
                java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ IllegalAccessException -> 0x0059 }
                java.lang.String r6 = "\"\n"
                java.lang.String r7 = " = \""
                java.lang.String r8 = "    "
                if (r2 != r5) goto L_0x005b
                java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ IllegalAccessException -> 0x0059 }
                int r2 = r4.intValue()     // Catch:{ IllegalAccessException -> 0x0059 }
                r5 = -1
                if (r2 == r5) goto L_0x0082
                int r2 = r4.intValue()     // Catch:{ IllegalAccessException -> 0x0059 }
                java.lang.String r2 = r10.lookUpConstraintName(r2)     // Catch:{ IllegalAccessException -> 0x0059 }
                r11.append(r8)     // Catch:{ IllegalAccessException -> 0x0059 }
                r11.append(r3)     // Catch:{ IllegalAccessException -> 0x0059 }
                r11.append(r7)     // Catch:{ IllegalAccessException -> 0x0059 }
                if (r2 != 0) goto L_0x0051
                goto L_0x0052
            L_0x0051:
                r4 = r2
            L_0x0052:
                r11.append(r4)     // Catch:{ IllegalAccessException -> 0x0059 }
                r11.append(r6)     // Catch:{ IllegalAccessException -> 0x0059 }
                goto L_0x0082
            L_0x0059:
                r2 = move-exception
                goto L_0x007b
            L_0x005b:
                java.lang.Class r5 = java.lang.Float.TYPE     // Catch:{ IllegalAccessException -> 0x0059 }
                if (r2 != r5) goto L_0x0082
                java.lang.Float r4 = (java.lang.Float) r4     // Catch:{ IllegalAccessException -> 0x0059 }
                float r2 = r4.floatValue()     // Catch:{ IllegalAccessException -> 0x0059 }
                r5 = -1082130432(0xffffffffbf800000, float:-1.0)
                int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
                if (r2 == 0) goto L_0x0082
                r11.append(r8)     // Catch:{ IllegalAccessException -> 0x0059 }
                r11.append(r3)     // Catch:{ IllegalAccessException -> 0x0059 }
                r11.append(r7)     // Catch:{ IllegalAccessException -> 0x0059 }
                r11.append(r4)     // Catch:{ IllegalAccessException -> 0x0059 }
                r11.append(r6)     // Catch:{ IllegalAccessException -> 0x0059 }
                goto L_0x0082
            L_0x007b:
                java.lang.String r3 = "ConstraintSet"
                java.lang.String r4 = "Error accessing ConstraintSet field"
                android.util.Log.e(r3, r4, r2)
            L_0x0082:
                int r1 = r1 + 1
                goto L_0x000e
            L_0x0085:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintSet.Layout.dump(androidx.constraintlayout.motion.widget.MotionScene, java.lang.StringBuilder):void");
        }

        /* access modifiers changed from: package-private */
        public void fillFromAttributeList(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Layout);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = obtainStyledAttributes.getIndex(i5);
                int i6 = sMapToConstant.get(index);
                switch (i6) {
                    case 1:
                        this.baselineToBaseline = ConstraintSet.lookupID(obtainStyledAttributes, index, this.baselineToBaseline);
                        break;
                    case 2:
                        this.bottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.bottomMargin);
                        break;
                    case 3:
                        this.bottomToBottom = ConstraintSet.lookupID(obtainStyledAttributes, index, this.bottomToBottom);
                        break;
                    case 4:
                        this.bottomToTop = ConstraintSet.lookupID(obtainStyledAttributes, index, this.bottomToTop);
                        break;
                    case 5:
                        this.dimensionRatio = obtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.editorAbsoluteX = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteX);
                        break;
                    case 7:
                        this.editorAbsoluteY = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteY);
                        break;
                    case 8:
                        this.endMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.endMargin);
                        break;
                    case 9:
                        this.endToEnd = ConstraintSet.lookupID(obtainStyledAttributes, index, this.endToEnd);
                        break;
                    case 10:
                        this.endToStart = ConstraintSet.lookupID(obtainStyledAttributes, index, this.endToStart);
                        break;
                    case 11:
                        this.goneBottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneBottomMargin);
                        break;
                    case 12:
                        this.goneEndMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneEndMargin);
                        break;
                    case 13:
                        this.goneLeftMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneLeftMargin);
                        break;
                    case 14:
                        this.goneRightMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneRightMargin);
                        break;
                    case 15:
                        this.goneStartMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneStartMargin);
                        break;
                    case 16:
                        this.goneTopMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneTopMargin);
                        break;
                    case 17:
                        this.guideBegin = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideBegin);
                        break;
                    case 18:
                        this.guideEnd = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideEnd);
                        break;
                    case 19:
                        this.guidePercent = obtainStyledAttributes.getFloat(index, this.guidePercent);
                        break;
                    case 20:
                        this.horizontalBias = obtainStyledAttributes.getFloat(index, this.horizontalBias);
                        break;
                    case 21:
                        this.mHeight = obtainStyledAttributes.getLayoutDimension(index, this.mHeight);
                        break;
                    case 22:
                        this.mWidth = obtainStyledAttributes.getLayoutDimension(index, this.mWidth);
                        break;
                    case 23:
                        this.leftMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.leftMargin);
                        break;
                    case 24:
                        this.leftToLeft = ConstraintSet.lookupID(obtainStyledAttributes, index, this.leftToLeft);
                        break;
                    case 25:
                        this.leftToRight = ConstraintSet.lookupID(obtainStyledAttributes, index, this.leftToRight);
                        break;
                    case 26:
                        this.orientation = obtainStyledAttributes.getInt(index, this.orientation);
                        break;
                    case 27:
                        this.rightMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.rightMargin);
                        break;
                    case 28:
                        this.rightToLeft = ConstraintSet.lookupID(obtainStyledAttributes, index, this.rightToLeft);
                        break;
                    case 29:
                        this.rightToRight = ConstraintSet.lookupID(obtainStyledAttributes, index, this.rightToRight);
                        break;
                    case 30:
                        this.startMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.startMargin);
                        break;
                    case 31:
                        this.startToEnd = ConstraintSet.lookupID(obtainStyledAttributes, index, this.startToEnd);
                        break;
                    case 32:
                        this.startToStart = ConstraintSet.lookupID(obtainStyledAttributes, index, this.startToStart);
                        break;
                    case 33:
                        this.topMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.topMargin);
                        break;
                    case 34:
                        this.topToBottom = ConstraintSet.lookupID(obtainStyledAttributes, index, this.topToBottom);
                        break;
                    case 35:
                        this.topToTop = ConstraintSet.lookupID(obtainStyledAttributes, index, this.topToTop);
                        break;
                    case 36:
                        this.verticalBias = obtainStyledAttributes.getFloat(index, this.verticalBias);
                        break;
                    case 37:
                        this.horizontalWeight = obtainStyledAttributes.getFloat(index, this.horizontalWeight);
                        break;
                    case 38:
                        this.verticalWeight = obtainStyledAttributes.getFloat(index, this.verticalWeight);
                        break;
                    case 39:
                        this.horizontalChainStyle = obtainStyledAttributes.getInt(index, this.horizontalChainStyle);
                        break;
                    case 40:
                        this.verticalChainStyle = obtainStyledAttributes.getInt(index, this.verticalChainStyle);
                        break;
                    case 41:
                        ConstraintSet.parseDimensionConstraints(this, obtainStyledAttributes, index, 0);
                        break;
                    case 42:
                        ConstraintSet.parseDimensionConstraints(this, obtainStyledAttributes, index, 1);
                        break;
                    default:
                        switch (i6) {
                            case 61:
                                this.circleConstraint = ConstraintSet.lookupID(obtainStyledAttributes, index, this.circleConstraint);
                                break;
                            case 62:
                                this.circleRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.circleRadius);
                                break;
                            case 63:
                                this.circleAngle = obtainStyledAttributes.getFloat(index, this.circleAngle);
                                break;
                            default:
                                switch (i6) {
                                    case 69:
                                        this.widthPercent = obtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 70:
                                        this.heightPercent = obtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 71:
                                        Log.e(ConstraintSet.TAG, "CURRENTLY UNSUPPORTED");
                                        break;
                                    case 72:
                                        this.mBarrierDirection = obtainStyledAttributes.getInt(index, this.mBarrierDirection);
                                        break;
                                    case 73:
                                        this.mBarrierMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.mBarrierMargin);
                                        break;
                                    case 74:
                                        this.mReferenceIdString = obtainStyledAttributes.getString(index);
                                        break;
                                    case 75:
                                        this.mBarrierAllowsGoneWidgets = obtainStyledAttributes.getBoolean(index, this.mBarrierAllowsGoneWidgets);
                                        break;
                                    case 76:
                                        this.mWrapBehavior = obtainStyledAttributes.getInt(index, this.mWrapBehavior);
                                        break;
                                    case 77:
                                        this.baselineToTop = ConstraintSet.lookupID(obtainStyledAttributes, index, this.baselineToTop);
                                        break;
                                    case 78:
                                        this.baselineToBottom = ConstraintSet.lookupID(obtainStyledAttributes, index, this.baselineToBottom);
                                        break;
                                    case 79:
                                        this.goneBaselineMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneBaselineMargin);
                                        break;
                                    case 80:
                                        this.baselineMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.baselineMargin);
                                        break;
                                    case 81:
                                        this.widthDefault = obtainStyledAttributes.getInt(index, this.widthDefault);
                                        break;
                                    case 82:
                                        this.heightDefault = obtainStyledAttributes.getInt(index, this.heightDefault);
                                        break;
                                    case 83:
                                        this.heightMax = obtainStyledAttributes.getDimensionPixelSize(index, this.heightMax);
                                        break;
                                    case 84:
                                        this.widthMax = obtainStyledAttributes.getDimensionPixelSize(index, this.widthMax);
                                        break;
                                    case 85:
                                        this.heightMin = obtainStyledAttributes.getDimensionPixelSize(index, this.heightMin);
                                        break;
                                    case 86:
                                        this.widthMin = obtainStyledAttributes.getDimensionPixelSize(index, this.widthMin);
                                        break;
                                    case 87:
                                        this.constrainedWidth = obtainStyledAttributes.getBoolean(index, this.constrainedWidth);
                                        break;
                                    case 88:
                                        this.constrainedHeight = obtainStyledAttributes.getBoolean(index, this.constrainedHeight);
                                        break;
                                    case 89:
                                        this.mConstraintTag = obtainStyledAttributes.getString(index);
                                        break;
                                    case 90:
                                        this.guidelineUseRtl = obtainStyledAttributes.getBoolean(index, this.guidelineUseRtl);
                                        break;
                                    case 91:
                                        Log.w(ConstraintSet.TAG, "unused attribute 0x" + Integer.toHexString(index) + "   " + sMapToConstant.get(index));
                                        break;
                                    default:
                                        Log.w(ConstraintSet.TAG, "Unknown attribute 0x" + Integer.toHexString(index) + "   " + sMapToConstant.get(index));
                                        break;
                                }
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class Motion {
        private static final int ANIMATE_CIRCLE_ANGLE_TO = 6;
        private static final int ANIMATE_RELATIVE_TO = 5;
        private static final int INTERPOLATOR_REFERENCE_ID = -2;
        private static final int INTERPOLATOR_UNDEFINED = -3;
        private static final int MOTION_DRAW_PATH = 4;
        private static final int MOTION_STAGGER = 7;
        private static final int PATH_MOTION_ARC = 2;
        private static final int QUANTIZE_MOTION_INTERPOLATOR = 10;
        private static final int QUANTIZE_MOTION_PHASE = 9;
        private static final int QUANTIZE_MOTION_STEPS = 8;
        private static final int SPLINE_STRING = -1;
        private static final int TRANSITION_EASING = 3;
        private static final int TRANSITION_PATH_ROTATE = 1;
        private static SparseIntArray sMapToConstant;
        public int mAnimateCircleAngleTo = 0;
        public int mAnimateRelativeTo = -1;
        public boolean mApply = false;
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

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            sMapToConstant = sparseIntArray;
            sparseIntArray.append(R.styleable.Motion_motionPathRotate, 1);
            sMapToConstant.append(R.styleable.Motion_pathMotionArc, 2);
            sMapToConstant.append(R.styleable.Motion_transitionEasing, 3);
            sMapToConstant.append(R.styleable.Motion_drawPath, 4);
            sMapToConstant.append(R.styleable.Motion_animateRelativeTo, 5);
            sMapToConstant.append(R.styleable.Motion_animateCircleAngleTo, 6);
            sMapToConstant.append(R.styleable.Motion_motionStagger, 7);
            sMapToConstant.append(R.styleable.Motion_quantizeMotionSteps, 8);
            sMapToConstant.append(R.styleable.Motion_quantizeMotionPhase, 9);
            sMapToConstant.append(R.styleable.Motion_quantizeMotionInterpolator, 10);
        }

        public void copyFrom(Motion motion) {
            this.mApply = motion.mApply;
            this.mAnimateRelativeTo = motion.mAnimateRelativeTo;
            this.mTransitionEasing = motion.mTransitionEasing;
            this.mPathMotionArc = motion.mPathMotionArc;
            this.mDrawPath = motion.mDrawPath;
            this.mPathRotate = motion.mPathRotate;
            this.mMotionStagger = motion.mMotionStagger;
            this.mPolarRelativeTo = motion.mPolarRelativeTo;
        }

        /* access modifiers changed from: package-private */
        public void fillFromAttributeList(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Motion);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = obtainStyledAttributes.getIndex(i5);
                switch (sMapToConstant.get(index)) {
                    case 1:
                        this.mPathRotate = obtainStyledAttributes.getFloat(index, this.mPathRotate);
                        break;
                    case 2:
                        this.mPathMotionArc = obtainStyledAttributes.getInt(index, this.mPathMotionArc);
                        break;
                    case 3:
                        if (obtainStyledAttributes.peekValue(index).type != 3) {
                            this.mTransitionEasing = Easing.NAMED_EASING[obtainStyledAttributes.getInteger(index, 0)];
                            break;
                        } else {
                            this.mTransitionEasing = obtainStyledAttributes.getString(index);
                            break;
                        }
                    case 4:
                        this.mDrawPath = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.mAnimateRelativeTo = ConstraintSet.lookupID(obtainStyledAttributes, index, this.mAnimateRelativeTo);
                        break;
                    case 6:
                        this.mAnimateCircleAngleTo = obtainStyledAttributes.getInteger(index, this.mAnimateCircleAngleTo);
                        break;
                    case 7:
                        this.mMotionStagger = obtainStyledAttributes.getFloat(index, this.mMotionStagger);
                        break;
                    case 8:
                        this.mQuantizeMotionSteps = obtainStyledAttributes.getInteger(index, this.mQuantizeMotionSteps);
                        break;
                    case 9:
                        this.mQuantizeMotionPhase = obtainStyledAttributes.getFloat(index, this.mQuantizeMotionPhase);
                        break;
                    case 10:
                        int i6 = obtainStyledAttributes.peekValue(index).type;
                        if (i6 != 1) {
                            if (i6 != 3) {
                                this.mQuantizeInterpolatorType = obtainStyledAttributes.getInteger(index, this.mQuantizeInterpolatorID);
                                break;
                            } else {
                                String string = obtainStyledAttributes.getString(index);
                                this.mQuantizeInterpolatorString = string;
                                if (string.indexOf("/") <= 0) {
                                    this.mQuantizeInterpolatorType = -1;
                                    break;
                                } else {
                                    this.mQuantizeInterpolatorID = obtainStyledAttributes.getResourceId(index, -1);
                                    this.mQuantizeInterpolatorType = -2;
                                    break;
                                }
                            }
                        } else {
                            int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                            this.mQuantizeInterpolatorID = resourceId;
                            if (resourceId == -1) {
                                break;
                            } else {
                                this.mQuantizeInterpolatorType = -2;
                                break;
                            }
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class PropertySet {
        public float alpha = 1.0f;
        public boolean mApply = false;
        public float mProgress = Float.NaN;
        public int mVisibilityMode = 0;
        public int visibility = 0;

        public void copyFrom(PropertySet propertySet) {
            this.mApply = propertySet.mApply;
            this.visibility = propertySet.visibility;
            this.alpha = propertySet.alpha;
            this.mProgress = propertySet.mProgress;
            this.mVisibilityMode = propertySet.mVisibilityMode;
        }

        /* access modifiers changed from: package-private */
        public void fillFromAttributeList(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PropertySet);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = obtainStyledAttributes.getIndex(i5);
                if (index == R.styleable.PropertySet_android_alpha) {
                    this.alpha = obtainStyledAttributes.getFloat(index, this.alpha);
                } else if (index == R.styleable.PropertySet_android_visibility) {
                    this.visibility = obtainStyledAttributes.getInt(index, this.visibility);
                    this.visibility = ConstraintSet.VISIBILITY_FLAGS[this.visibility];
                } else if (index == R.styleable.PropertySet_visibilityMode) {
                    this.mVisibilityMode = obtainStyledAttributes.getInt(index, this.mVisibilityMode);
                } else if (index == R.styleable.PropertySet_motionProgress) {
                    this.mProgress = obtainStyledAttributes.getFloat(index, this.mProgress);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class Transform {
        private static final int ELEVATION = 11;
        private static final int ROTATION = 1;
        private static final int ROTATION_X = 2;
        private static final int ROTATION_Y = 3;
        private static final int SCALE_X = 4;
        private static final int SCALE_Y = 5;
        private static final int TRANSFORM_PIVOT_TARGET = 12;
        private static final int TRANSFORM_PIVOT_X = 6;
        private static final int TRANSFORM_PIVOT_Y = 7;
        private static final int TRANSLATION_X = 8;
        private static final int TRANSLATION_Y = 9;
        private static final int TRANSLATION_Z = 10;
        private static SparseIntArray sMapToConstant;
        public boolean applyElevation = false;
        public float elevation = 0.0f;
        public boolean mApply = false;
        public float rotation = 0.0f;
        public float rotationX = 0.0f;
        public float rotationY = 0.0f;
        public float scaleX = 1.0f;
        public float scaleY = 1.0f;
        public int transformPivotTarget = -1;
        public float transformPivotX = Float.NaN;
        public float transformPivotY = Float.NaN;
        public float translationX = 0.0f;
        public float translationY = 0.0f;
        public float translationZ = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            sMapToConstant = sparseIntArray;
            sparseIntArray.append(R.styleable.Transform_android_rotation, 1);
            sMapToConstant.append(R.styleable.Transform_android_rotationX, 2);
            sMapToConstant.append(R.styleable.Transform_android_rotationY, 3);
            sMapToConstant.append(R.styleable.Transform_android_scaleX, 4);
            sMapToConstant.append(R.styleable.Transform_android_scaleY, 5);
            sMapToConstant.append(R.styleable.Transform_android_transformPivotX, 6);
            sMapToConstant.append(R.styleable.Transform_android_transformPivotY, 7);
            sMapToConstant.append(R.styleable.Transform_android_translationX, 8);
            sMapToConstant.append(R.styleable.Transform_android_translationY, 9);
            sMapToConstant.append(R.styleable.Transform_android_translationZ, 10);
            sMapToConstant.append(R.styleable.Transform_android_elevation, 11);
            sMapToConstant.append(R.styleable.Transform_transformPivotTarget, 12);
        }

        public void copyFrom(Transform transform) {
            this.mApply = transform.mApply;
            this.rotation = transform.rotation;
            this.rotationX = transform.rotationX;
            this.rotationY = transform.rotationY;
            this.scaleX = transform.scaleX;
            this.scaleY = transform.scaleY;
            this.transformPivotX = transform.transformPivotX;
            this.transformPivotY = transform.transformPivotY;
            this.transformPivotTarget = transform.transformPivotTarget;
            this.translationX = transform.translationX;
            this.translationY = transform.translationY;
            this.translationZ = transform.translationZ;
            this.applyElevation = transform.applyElevation;
            this.elevation = transform.elevation;
        }

        /* access modifiers changed from: package-private */
        public void fillFromAttributeList(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Transform);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = obtainStyledAttributes.getIndex(i5);
                switch (sMapToConstant.get(index)) {
                    case 1:
                        this.rotation = obtainStyledAttributes.getFloat(index, this.rotation);
                        break;
                    case 2:
                        this.rotationX = obtainStyledAttributes.getFloat(index, this.rotationX);
                        break;
                    case 3:
                        this.rotationY = obtainStyledAttributes.getFloat(index, this.rotationY);
                        break;
                    case 4:
                        this.scaleX = obtainStyledAttributes.getFloat(index, this.scaleX);
                        break;
                    case 5:
                        this.scaleY = obtainStyledAttributes.getFloat(index, this.scaleY);
                        break;
                    case 6:
                        this.transformPivotX = obtainStyledAttributes.getDimension(index, this.transformPivotX);
                        break;
                    case 7:
                        this.transformPivotY = obtainStyledAttributes.getDimension(index, this.transformPivotY);
                        break;
                    case 8:
                        this.translationX = obtainStyledAttributes.getDimension(index, this.translationX);
                        break;
                    case 9:
                        this.translationY = obtainStyledAttributes.getDimension(index, this.translationY);
                        break;
                    case 10:
                        this.translationZ = obtainStyledAttributes.getDimension(index, this.translationZ);
                        break;
                    case 11:
                        this.applyElevation = true;
                        this.elevation = obtainStyledAttributes.getDimension(index, this.elevation);
                        break;
                    case 12:
                        this.transformPivotTarget = ConstraintSet.lookupID(obtainStyledAttributes, index, this.transformPivotTarget);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    class WriteXmlEngine {
        private static final String SPACE = "\n       ";
        final String mBASELINE = "'baseline'";
        final String mBOTTOM = "'bottom'";
        Context mContext;
        final String mEND = "'end'";
        int mFlags;
        HashMap<Integer, String> mIdMap = new HashMap<>();
        final String mLEFT = "'left'";
        ConstraintLayout mLayout;
        final String mRIGHT = "'right'";
        final String mSTART = "'start'";
        final String mTOP = "'top'";
        int mUnknownCount = 0;
        Writer mWriter;

        WriteXmlEngine(Writer writer, ConstraintLayout constraintLayout, int i5) throws IOException {
            this.mWriter = writer;
            this.mLayout = constraintLayout;
            this.mContext = constraintLayout.getContext();
            this.mFlags = i5;
        }

        private void writeBaseDimension(String str, int i5, int i6) throws IOException {
            if (i5 == i6) {
                return;
            }
            if (i5 == -2) {
                Writer writer = this.mWriter;
                writer.write(SPACE + str + "=\"wrap_content\"");
            } else if (i5 == -1) {
                Writer writer2 = this.mWriter;
                writer2.write(SPACE + str + "=\"match_parent\"");
            } else {
                Writer writer3 = this.mWriter;
                writer3.write(SPACE + str + "=\"" + i5 + "dp\"");
            }
        }

        private void writeBoolen(String str, boolean z4, boolean z5) throws IOException {
            if (z4 != z5) {
                Writer writer = this.mWriter;
                writer.write(SPACE + str + "=\"" + z4 + "dp\"");
            }
        }

        private void writeDimension(String str, int i5, int i6) throws IOException {
            if (i5 != i6) {
                Writer writer = this.mWriter;
                writer.write(SPACE + str + "=\"" + i5 + "dp\"");
            }
        }

        private void writeEnum(String str, int i5, String[] strArr, int i6) throws IOException {
            if (i5 != i6) {
                Writer writer = this.mWriter;
                writer.write(SPACE + str + "=\"" + strArr[i5] + "\"");
            }
        }

        /* access modifiers changed from: package-private */
        public String getName(int i5) {
            if (this.mIdMap.containsKey(Integer.valueOf(i5))) {
                return "@+id/" + this.mIdMap.get(Integer.valueOf(i5)) + "";
            } else if (i5 == 0) {
                return ConstraintSet.KEY_PERCENT_PARENT;
            } else {
                String lookup = lookup(i5);
                this.mIdMap.put(Integer.valueOf(i5), lookup);
                return "@+id/" + lookup + "";
            }
        }

        /* access modifiers changed from: package-private */
        public String lookup(int i5) {
            if (i5 != -1) {
                try {
                    return this.mContext.getResources().getResourceEntryName(i5);
                } catch (Exception unused) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(EnvironmentCompat.MEDIA_UNKNOWN);
                    int i6 = this.mUnknownCount + 1;
                    this.mUnknownCount = i6;
                    sb.append(i6);
                    return sb.toString();
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(EnvironmentCompat.MEDIA_UNKNOWN);
                int i7 = this.mUnknownCount + 1;
                this.mUnknownCount = i7;
                sb2.append(i7);
                return sb2.toString();
            }
        }

        /* access modifiers changed from: package-private */
        public void writeCircle(int i5, float f5, int i6) throws IOException {
            if (i5 != -1) {
                this.mWriter.write("circle");
                this.mWriter.write(":[");
                this.mWriter.write(getName(i5));
                Writer writer = this.mWriter;
                writer.write(", " + f5);
                Writer writer2 = this.mWriter;
                writer2.write(i6 + "]");
            }
        }

        /* access modifiers changed from: package-private */
        public void writeConstraint(String str, int i5, String str2, int i6, int i7) throws IOException {
            if (i5 != -1) {
                Writer writer = this.mWriter;
                writer.write(SPACE + str);
                this.mWriter.write(":[");
                this.mWriter.write(getName(i5));
                this.mWriter.write(" , ");
                this.mWriter.write(str2);
                if (i6 != 0) {
                    Writer writer2 = this.mWriter;
                    writer2.write(" , " + i6);
                }
                this.mWriter.write("],\n");
            }
        }

        /* access modifiers changed from: package-private */
        public void writeLayout() throws IOException {
            this.mWriter.write("\n<ConstraintSet>\n");
            for (Integer num : ConstraintSet.this.mConstraints.keySet()) {
                String name = getName(num.intValue());
                this.mWriter.write("  <Constraint");
                Writer writer = this.mWriter;
                writer.write("\n       android:id=\"" + name + "\"");
                Layout layout = ((Constraint) ConstraintSet.this.mConstraints.get(num)).layout;
                writeBaseDimension("android:layout_width", layout.mWidth, -5);
                writeBaseDimension("android:layout_height", layout.mHeight, -5);
                writeVariable("app:layout_constraintGuide_begin", (float) layout.guideBegin, -1.0f);
                writeVariable("app:layout_constraintGuide_end", (float) layout.guideEnd, -1.0f);
                writeVariable("app:layout_constraintGuide_percent", layout.guidePercent, -1.0f);
                writeVariable("app:layout_constraintHorizontal_bias", layout.horizontalBias, 0.5f);
                writeVariable("app:layout_constraintVertical_bias", layout.verticalBias, 0.5f);
                writeVariable("app:layout_constraintDimensionRatio", layout.dimensionRatio, (String) null);
                writeXmlConstraint("app:layout_constraintCircle", layout.circleConstraint);
                writeVariable("app:layout_constraintCircleRadius", (float) layout.circleRadius, 0.0f);
                writeVariable("app:layout_constraintCircleAngle", layout.circleAngle, 0.0f);
                writeVariable("android:orientation", (float) layout.orientation, -1.0f);
                writeVariable("app:layout_constraintVertical_weight", layout.verticalWeight, -1.0f);
                writeVariable("app:layout_constraintHorizontal_weight", layout.horizontalWeight, -1.0f);
                writeVariable("app:layout_constraintHorizontal_chainStyle", (float) layout.horizontalChainStyle, 0.0f);
                writeVariable("app:layout_constraintVertical_chainStyle", (float) layout.verticalChainStyle, 0.0f);
                writeVariable("app:barrierDirection", (float) layout.mBarrierDirection, -1.0f);
                writeVariable("app:barrierMargin", (float) layout.mBarrierMargin, 0.0f);
                writeDimension("app:layout_marginLeft", layout.leftMargin, 0);
                writeDimension("app:layout_goneMarginLeft", layout.goneLeftMargin, Integer.MIN_VALUE);
                writeDimension("app:layout_marginRight", layout.rightMargin, 0);
                writeDimension("app:layout_goneMarginRight", layout.goneRightMargin, Integer.MIN_VALUE);
                writeDimension("app:layout_marginStart", layout.startMargin, 0);
                writeDimension("app:layout_goneMarginStart", layout.goneStartMargin, Integer.MIN_VALUE);
                writeDimension("app:layout_marginEnd", layout.endMargin, 0);
                writeDimension("app:layout_goneMarginEnd", layout.goneEndMargin, Integer.MIN_VALUE);
                writeDimension("app:layout_marginTop", layout.topMargin, 0);
                writeDimension("app:layout_goneMarginTop", layout.goneTopMargin, Integer.MIN_VALUE);
                writeDimension("app:layout_marginBottom", layout.bottomMargin, 0);
                writeDimension("app:layout_goneMarginBottom", layout.goneBottomMargin, Integer.MIN_VALUE);
                writeDimension("app:goneBaselineMargin", layout.goneBaselineMargin, Integer.MIN_VALUE);
                writeDimension("app:baselineMargin", layout.baselineMargin, 0);
                writeBoolen("app:layout_constrainedWidth", layout.constrainedWidth, false);
                writeBoolen("app:layout_constrainedHeight", layout.constrainedHeight, false);
                writeBoolen("app:barrierAllowsGoneWidgets", layout.mBarrierAllowsGoneWidgets, true);
                writeVariable("app:layout_wrapBehaviorInParent", (float) layout.mWrapBehavior, 0.0f);
                writeXmlConstraint("app:baselineToBaseline", layout.baselineToBaseline);
                writeXmlConstraint("app:baselineToBottom", layout.baselineToBottom);
                writeXmlConstraint("app:baselineToTop", layout.baselineToTop);
                writeXmlConstraint("app:layout_constraintBottom_toBottomOf", layout.bottomToBottom);
                writeXmlConstraint("app:layout_constraintBottom_toTopOf", layout.bottomToTop);
                writeXmlConstraint("app:layout_constraintEnd_toEndOf", layout.endToEnd);
                writeXmlConstraint("app:layout_constraintEnd_toStartOf", layout.endToStart);
                writeXmlConstraint("app:layout_constraintLeft_toLeftOf", layout.leftToLeft);
                writeXmlConstraint("app:layout_constraintLeft_toRightOf", layout.leftToRight);
                writeXmlConstraint("app:layout_constraintRight_toLeftOf", layout.rightToLeft);
                writeXmlConstraint("app:layout_constraintRight_toRightOf", layout.rightToRight);
                writeXmlConstraint("app:layout_constraintStart_toEndOf", layout.startToEnd);
                writeXmlConstraint("app:layout_constraintStart_toStartOf", layout.startToStart);
                writeXmlConstraint("app:layout_constraintTop_toBottomOf", layout.topToBottom);
                writeXmlConstraint("app:layout_constraintTop_toTopOf", layout.topToTop);
                String[] strArr = {"spread", "wrap", "percent"};
                writeEnum("app:layout_constraintHeight_default", layout.heightDefault, strArr, 0);
                writeVariable("app:layout_constraintHeight_percent", layout.heightPercent, 1.0f);
                writeDimension("app:layout_constraintHeight_min", layout.heightMin, 0);
                writeDimension("app:layout_constraintHeight_max", layout.heightMax, 0);
                writeBoolen("android:layout_constrainedHeight", layout.constrainedHeight, false);
                writeEnum("app:layout_constraintWidth_default", layout.widthDefault, strArr, 0);
                writeVariable("app:layout_constraintWidth_percent", layout.widthPercent, 1.0f);
                writeDimension("app:layout_constraintWidth_min", layout.widthMin, 0);
                writeDimension("app:layout_constraintWidth_max", layout.widthMax, 0);
                writeBoolen("android:layout_constrainedWidth", layout.constrainedWidth, false);
                writeVariable("app:layout_constraintVertical_weight", layout.verticalWeight, -1.0f);
                writeVariable("app:layout_constraintHorizontal_weight", layout.horizontalWeight, -1.0f);
                writeVariable("app:layout_constraintHorizontal_chainStyle", layout.horizontalChainStyle);
                writeVariable("app:layout_constraintVertical_chainStyle", layout.verticalChainStyle);
                writeEnum("app:barrierDirection", layout.mBarrierDirection, new String[]{TtmlNode.LEFT, TtmlNode.RIGHT, "top", "bottom", "start", TtmlNode.END}, -1);
                writeVariable("app:layout_constraintTag", layout.mConstraintTag, (String) null);
                int[] iArr = layout.mReferenceIds;
                if (iArr != null) {
                    writeVariable("'ReferenceIds'", iArr);
                }
                this.mWriter.write(" />\n");
            }
            this.mWriter.write("</ConstraintSet>\n");
        }

        /* access modifiers changed from: package-private */
        public void writeVariable(String str, int i5) throws IOException {
            if (i5 != 0 && i5 != -1) {
                Writer writer = this.mWriter;
                writer.write(SPACE + str + "=\"" + i5 + "\"\n");
            }
        }

        /* access modifiers changed from: package-private */
        public void writeXmlConstraint(String str, int i5) throws IOException {
            if (i5 != -1) {
                Writer writer = this.mWriter;
                writer.write(SPACE + str);
                Writer writer2 = this.mWriter;
                writer2.write("=\"" + getName(i5) + "\"");
            }
        }

        /* access modifiers changed from: package-private */
        public void writeVariable(String str, float f5, float f6) throws IOException {
            if (f5 != f6) {
                Writer writer = this.mWriter;
                writer.write(SPACE + str);
                Writer writer2 = this.mWriter;
                writer2.write("=\"" + f5 + "\"");
            }
        }

        /* access modifiers changed from: package-private */
        public void writeVariable(String str, String str2, String str3) throws IOException {
            if (str2 != null && !str2.equals(str3)) {
                Writer writer = this.mWriter;
                writer.write(SPACE + str);
                Writer writer2 = this.mWriter;
                writer2.write("=\"" + str2 + "\"");
            }
        }

        /* access modifiers changed from: package-private */
        public void writeVariable(String str, int[] iArr) throws IOException {
            if (iArr != null) {
                Writer writer = this.mWriter;
                writer.write(SPACE + str);
                this.mWriter.write(":");
                int i5 = 0;
                while (i5 < iArr.length) {
                    Writer writer2 = this.mWriter;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i5 == 0 ? "[" : ", ");
                    sb.append(getName(iArr[i5]));
                    writer2.write(sb.toString());
                    i5++;
                }
                this.mWriter.write("],\n");
            }
        }

        /* access modifiers changed from: package-private */
        public void writeVariable(String str, String str2) throws IOException {
            if (str2 != null) {
                this.mWriter.write(str);
                this.mWriter.write(":");
                Writer writer = this.mWriter;
                writer.write(", " + str2);
                this.mWriter.write("\n");
            }
        }
    }

    static {
        sMapToConstant.append(R.styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintRight_toRightOf, 30);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintTop_toTopOf, 36);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_toTopOf, 91);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_toBottomOf, 92);
        sMapToConstant.append(R.styleable.Constraint_layout_editor_absoluteX, 6);
        sMapToConstant.append(R.styleable.Constraint_layout_editor_absoluteY, 7);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintGuide_begin, 17);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintGuide_end, 18);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintGuide_percent, 19);
        sMapToConstant.append(R.styleable.Constraint_guidelineUseRtl, 99);
        sMapToConstant.append(R.styleable.Constraint_android_orientation, 27);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintStart_toEndOf, 32);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintStart_toStartOf, 33);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        sMapToConstant.append(R.styleable.Constraint_layout_goneMarginLeft, 13);
        sMapToConstant.append(R.styleable.Constraint_layout_goneMarginTop, 16);
        sMapToConstant.append(R.styleable.Constraint_layout_goneMarginRight, 14);
        sMapToConstant.append(R.styleable.Constraint_layout_goneMarginBottom, 11);
        sMapToConstant.append(R.styleable.Constraint_layout_goneMarginStart, 15);
        sMapToConstant.append(R.styleable.Constraint_layout_goneMarginEnd, 12);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintVertical_weight, 40);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintHorizontal_weight, 39);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintHorizontal_bias, 20);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintVertical_bias, 37);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintDimensionRatio, 5);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintLeft_creator, 87);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintTop_creator, 87);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintRight_creator, 87);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintBottom_creator, 87);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_creator, 87);
        sMapToConstant.append(R.styleable.Constraint_android_layout_marginLeft, 24);
        sMapToConstant.append(R.styleable.Constraint_android_layout_marginRight, 28);
        sMapToConstant.append(R.styleable.Constraint_android_layout_marginStart, 31);
        sMapToConstant.append(R.styleable.Constraint_android_layout_marginEnd, 8);
        sMapToConstant.append(R.styleable.Constraint_android_layout_marginTop, 34);
        sMapToConstant.append(R.styleable.Constraint_android_layout_marginBottom, 2);
        sMapToConstant.append(R.styleable.Constraint_android_layout_width, 23);
        sMapToConstant.append(R.styleable.Constraint_android_layout_height, 21);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintWidth, 95);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintHeight, 96);
        sMapToConstant.append(R.styleable.Constraint_android_visibility, 22);
        sMapToConstant.append(R.styleable.Constraint_android_alpha, 43);
        sMapToConstant.append(R.styleable.Constraint_android_elevation, 44);
        sMapToConstant.append(R.styleable.Constraint_android_rotationX, 45);
        sMapToConstant.append(R.styleable.Constraint_android_rotationY, 46);
        sMapToConstant.append(R.styleable.Constraint_android_rotation, 60);
        sMapToConstant.append(R.styleable.Constraint_android_scaleX, 47);
        sMapToConstant.append(R.styleable.Constraint_android_scaleY, 48);
        sMapToConstant.append(R.styleable.Constraint_android_transformPivotX, 49);
        sMapToConstant.append(R.styleable.Constraint_android_transformPivotY, 50);
        sMapToConstant.append(R.styleable.Constraint_android_translationX, 51);
        sMapToConstant.append(R.styleable.Constraint_android_translationY, 52);
        sMapToConstant.append(R.styleable.Constraint_android_translationZ, 53);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintWidth_default, 54);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintHeight_default, 55);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintWidth_max, 56);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintHeight_max, 57);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintWidth_min, 58);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintHeight_min, 59);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintCircle, 61);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintCircleRadius, 62);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintCircleAngle, 63);
        sMapToConstant.append(R.styleable.Constraint_animateRelativeTo, 64);
        sMapToConstant.append(R.styleable.Constraint_transitionEasing, 65);
        sMapToConstant.append(R.styleable.Constraint_drawPath, 66);
        sMapToConstant.append(R.styleable.Constraint_transitionPathRotate, 67);
        sMapToConstant.append(R.styleable.Constraint_motionStagger, 79);
        sMapToConstant.append(R.styleable.Constraint_android_id, 38);
        sMapToConstant.append(R.styleable.Constraint_motionProgress, 68);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintWidth_percent, 69);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintHeight_percent, 70);
        sMapToConstant.append(R.styleable.Constraint_layout_wrapBehaviorInParent, 97);
        sMapToConstant.append(R.styleable.Constraint_chainUseRtl, 71);
        sMapToConstant.append(R.styleable.Constraint_barrierDirection, 72);
        sMapToConstant.append(R.styleable.Constraint_barrierMargin, 73);
        sMapToConstant.append(R.styleable.Constraint_constraint_referenced_ids, 74);
        sMapToConstant.append(R.styleable.Constraint_barrierAllowsGoneWidgets, 75);
        sMapToConstant.append(R.styleable.Constraint_pathMotionArc, 76);
        sMapToConstant.append(R.styleable.Constraint_layout_constraintTag, 77);
        sMapToConstant.append(R.styleable.Constraint_visibilityMode, 78);
        sMapToConstant.append(R.styleable.Constraint_layout_constrainedWidth, 80);
        sMapToConstant.append(R.styleable.Constraint_layout_constrainedHeight, 81);
        sMapToConstant.append(R.styleable.Constraint_polarRelativeTo, 82);
        sMapToConstant.append(R.styleable.Constraint_transformPivotTarget, 83);
        sMapToConstant.append(R.styleable.Constraint_quantizeMotionSteps, 84);
        sMapToConstant.append(R.styleable.Constraint_quantizeMotionPhase, 85);
        sMapToConstant.append(R.styleable.Constraint_quantizeMotionInterpolator, 86);
        SparseIntArray sparseIntArray = sOverrideMapToConstant;
        int i5 = R.styleable.ConstraintOverride_layout_editor_absoluteY;
        sparseIntArray.append(i5, 6);
        sOverrideMapToConstant.append(i5, 7);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_orientation, 27);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginLeft, 13);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginTop, 16);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginRight, 14);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginBottom, 11);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginStart, 15);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginEnd, 12);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintVertical_weight, 40);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_weight, 39);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_chainStyle, 41);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintVertical_chainStyle, 42);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_bias, 20);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintVertical_bias, 37);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintDimensionRatio, 5);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintLeft_creator, 87);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintTop_creator, 87);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintRight_creator, 87);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintBottom_creator, 87);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintBaseline_creator, 87);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginLeft, 24);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginRight, 28);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginStart, 31);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginEnd, 8);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginTop, 34);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginBottom, 2);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_width, 23);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_height, 21);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth, 95);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight, 96);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_visibility, 22);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_alpha, 43);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_elevation, 44);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_rotationX, 45);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_rotationY, 46);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_rotation, 60);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_scaleX, 47);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_scaleY, 48);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_transformPivotX, 49);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_transformPivotY, 50);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_translationX, 51);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_translationY, 52);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_translationZ, 53);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth_default, 54);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight_default, 55);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth_max, 56);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight_max, 57);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth_min, 58);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight_min, 59);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintCircleRadius, 62);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintCircleAngle, 63);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_animateRelativeTo, 64);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_transitionEasing, 65);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_drawPath, 66);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_transitionPathRotate, 67);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_motionStagger, 79);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_android_id, 38);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_motionTarget, 98);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_motionProgress, 68);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth_percent, 69);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight_percent, 70);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_chainUseRtl, 71);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_barrierDirection, 72);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_barrierMargin, 73);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_constraint_referenced_ids, 74);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_barrierAllowsGoneWidgets, 75);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_pathMotionArc, 76);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintTag, 77);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_visibilityMode, 78);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constrainedWidth, 80);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constrainedHeight, 81);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_polarRelativeTo, 82);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_transformPivotTarget, 83);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_quantizeMotionSteps, 84);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_quantizeMotionPhase, 85);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_quantizeMotionInterpolator, 86);
        sOverrideMapToConstant.append(R.styleable.ConstraintOverride_layout_wrapBehaviorInParent, 97);
    }

    private void addAttributes(ConstraintAttribute.AttributeType attributeType, String... strArr) {
        for (int i5 = 0; i5 < strArr.length; i5++) {
            if (this.mSavedAttributes.containsKey(strArr[i5])) {
                ConstraintAttribute constraintAttribute = this.mSavedAttributes.get(strArr[i5]);
                if (!(constraintAttribute == null || constraintAttribute.getType() == attributeType)) {
                    throw new IllegalArgumentException("ConstraintAttribute is already a " + constraintAttribute.getType().name());
                }
            } else {
                this.mSavedAttributes.put(strArr[i5], new ConstraintAttribute(strArr[i5], attributeType));
            }
        }
    }

    public static Constraint buildDelta(Context context, XmlPullParser xmlPullParser) {
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        Constraint constraint = new Constraint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(asAttributeSet, R.styleable.ConstraintOverride);
        populateOverride(constraint, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return constraint;
    }

    private int[] convertReferenceString(View view, String str) {
        int i5;
        Object designInformation;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i6 = 0;
        int i7 = 0;
        while (i6 < split.length) {
            String trim = split[i6].trim();
            try {
                i5 = R.id.class.getField(trim).getInt((Object) null);
            } catch (Exception unused) {
                i5 = 0;
            }
            if (i5 == 0) {
                i5 = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i5 == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (designInformation = ((ConstraintLayout) view.getParent()).getDesignInformation(0, trim)) != null && (designInformation instanceof Integer)) {
                i5 = ((Integer) designInformation).intValue();
            }
            iArr[i7] = i5;
            i6++;
            i7++;
        }
        if (i7 != split.length) {
            return Arrays.copyOf(iArr, i7);
        }
        return iArr;
    }

    private Constraint fillFromAttributeList(Context context, AttributeSet attributeSet, boolean z4) {
        int[] iArr;
        Constraint constraint = new Constraint();
        if (z4) {
            iArr = R.styleable.ConstraintOverride;
        } else {
            iArr = R.styleable.Constraint;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        populateConstraint(constraint, obtainStyledAttributes, z4);
        obtainStyledAttributes.recycle();
        return constraint;
    }

    private Constraint get(int i5) {
        if (!this.mConstraints.containsKey(Integer.valueOf(i5))) {
            this.mConstraints.put(Integer.valueOf(i5), new Constraint());
        }
        return this.mConstraints.get(Integer.valueOf(i5));
    }

    static String getDebugName(int i5) {
        for (Field field : ConstraintSet.class.getDeclaredFields()) {
            if (field.getName().contains("_") && field.getType() == Integer.TYPE && Modifier.isStatic(field.getModifiers()) && Modifier.isFinal(field.getModifiers())) {
                try {
                    if (field.getInt((Object) null) == i5) {
                        return field.getName();
                    }
                } catch (IllegalAccessException e5) {
                    Log.e(TAG, "Error accessing ConstraintSet field", e5);
                }
            }
        }
        return "UNKNOWN";
    }

    static String getLine(Context context, int i5, XmlPullParser xmlPullParser) {
        return ".(" + Debug.getName(context, i5) + ".xml:" + xmlPullParser.getLineNumber() + ") \"" + xmlPullParser.getName() + "\"";
    }

    /* access modifiers changed from: private */
    public static int lookupID(TypedArray typedArray, int i5, int i6) {
        int resourceId = typedArray.getResourceId(i5, i6);
        if (resourceId == -1) {
            return typedArray.getInt(i5, -1);
        }
        return resourceId;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0042  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void parseDimensionConstraints(java.lang.Object r4, android.content.res.TypedArray r5, int r6, int r7) {
        /*
            if (r4 != 0) goto L_0x0004
            goto L_0x0071
        L_0x0004:
            android.util.TypedValue r0 = r5.peekValue(r6)
            int r0 = r0.type
            r1 = 3
            if (r0 == r1) goto L_0x0072
            r1 = 5
            r2 = 0
            if (r0 == r1) goto L_0x002b
            int r5 = r5.getInt(r6, r2)
            r6 = -4
            r0 = -2
            if (r5 == r6) goto L_0x0027
            r6 = -3
            if (r5 == r6) goto L_0x0021
            if (r5 == r0) goto L_0x0023
            r6 = -1
            if (r5 == r6) goto L_0x0023
        L_0x0021:
            r5 = r2
            goto L_0x0030
        L_0x0023:
            r3 = r2
            r2 = r5
            r5 = r3
            goto L_0x0030
        L_0x0027:
            r2 = 1
            r5 = r2
            r2 = r0
            goto L_0x0030
        L_0x002b:
            int r5 = r5.getDimensionPixelSize(r6, r2)
            goto L_0x0023
        L_0x0030:
            boolean r6 = r4 instanceof androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
            if (r6 == 0) goto L_0x0042
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r4 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r4
            if (r7 != 0) goto L_0x003d
            r4.width = r2
            r4.constrainedWidth = r5
            return
        L_0x003d:
            r4.height = r2
            r4.constrainedHeight = r5
            return
        L_0x0042:
            boolean r6 = r4 instanceof androidx.constraintlayout.widget.ConstraintSet.Layout
            if (r6 == 0) goto L_0x0054
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = (androidx.constraintlayout.widget.ConstraintSet.Layout) r4
            if (r7 != 0) goto L_0x004f
            r4.mWidth = r2
            r4.constrainedWidth = r5
            return
        L_0x004f:
            r4.mHeight = r2
            r4.constrainedHeight = r5
            return
        L_0x0054:
            boolean r6 = r4 instanceof androidx.constraintlayout.widget.ConstraintSet.Constraint.Delta
            if (r6 == 0) goto L_0x0071
            androidx.constraintlayout.widget.ConstraintSet$Constraint$Delta r4 = (androidx.constraintlayout.widget.ConstraintSet.Constraint.Delta) r4
            if (r7 != 0) goto L_0x0067
            r6 = 23
            r4.add((int) r6, (int) r2)
            r6 = 80
            r4.add((int) r6, (boolean) r5)
            return
        L_0x0067:
            r6 = 21
            r4.add((int) r6, (int) r2)
            r6 = 81
            r4.add((int) r6, (boolean) r5)
        L_0x0071:
            return
        L_0x0072:
            java.lang.String r5 = r5.getString(r6)
            parseDimensionConstraintsString(r4, r5, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintSet.parseDimensionConstraints(java.lang.Object, android.content.res.TypedArray, int, int):void");
    }

    static void parseDimensionConstraintsString(Object obj, String str, int i5) {
        if (str != null) {
            int indexOf = str.indexOf(61);
            int length = str.length();
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                String substring2 = str.substring(indexOf + 1);
                if (substring2.length() > 0) {
                    String trim = substring.trim();
                    String trim2 = substring2.trim();
                    if (KEY_RATIO.equalsIgnoreCase(trim)) {
                        if (obj instanceof ConstraintLayout.LayoutParams) {
                            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) obj;
                            if (i5 == 0) {
                                layoutParams.width = 0;
                            } else {
                                layoutParams.height = 0;
                            }
                            parseDimensionRatioString(layoutParams, trim2);
                        } else if (obj instanceof Layout) {
                            ((Layout) obj).dimensionRatio = trim2;
                        } else if (obj instanceof Constraint.Delta) {
                            ((Constraint.Delta) obj).add(5, trim2);
                        }
                    } else if (KEY_WEIGHT.equalsIgnoreCase(trim)) {
                        try {
                            float parseFloat = Float.parseFloat(trim2);
                            if (obj instanceof ConstraintLayout.LayoutParams) {
                                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) obj;
                                if (i5 == 0) {
                                    layoutParams2.width = 0;
                                    layoutParams2.horizontalWeight = parseFloat;
                                    return;
                                }
                                layoutParams2.height = 0;
                                layoutParams2.verticalWeight = parseFloat;
                            } else if (obj instanceof Layout) {
                                Layout layout = (Layout) obj;
                                if (i5 == 0) {
                                    layout.mWidth = 0;
                                    layout.horizontalWeight = parseFloat;
                                    return;
                                }
                                layout.mHeight = 0;
                                layout.verticalWeight = parseFloat;
                            } else if (obj instanceof Constraint.Delta) {
                                Constraint.Delta delta = (Constraint.Delta) obj;
                                if (i5 == 0) {
                                    delta.add(23, 0);
                                    delta.add(39, parseFloat);
                                    return;
                                }
                                delta.add(21, 0);
                                delta.add(40, parseFloat);
                            }
                        } catch (NumberFormatException unused) {
                        }
                    } else if (KEY_PERCENT_PARENT.equalsIgnoreCase(trim)) {
                        float max = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(trim2)));
                        if (obj instanceof ConstraintLayout.LayoutParams) {
                            ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) obj;
                            if (i5 == 0) {
                                layoutParams3.width = 0;
                                layoutParams3.matchConstraintPercentWidth = max;
                                layoutParams3.matchConstraintDefaultWidth = 2;
                                return;
                            }
                            layoutParams3.height = 0;
                            layoutParams3.matchConstraintPercentHeight = max;
                            layoutParams3.matchConstraintDefaultHeight = 2;
                        } else if (obj instanceof Layout) {
                            Layout layout2 = (Layout) obj;
                            if (i5 == 0) {
                                layout2.mWidth = 0;
                                layout2.widthPercent = max;
                                layout2.widthDefault = 2;
                                return;
                            }
                            layout2.mHeight = 0;
                            layout2.heightPercent = max;
                            layout2.heightDefault = 2;
                        } else if (obj instanceof Constraint.Delta) {
                            Constraint.Delta delta2 = (Constraint.Delta) obj;
                            if (i5 == 0) {
                                delta2.add(23, 0);
                                delta2.add(54, 2);
                                return;
                            }
                            delta2.add(21, 0);
                            delta2.add(55, 2);
                        }
                    }
                }
            }
        }
    }

    static void parseDimensionRatioString(ConstraintLayout.LayoutParams layoutParams, String str) {
        float f5 = Float.NaN;
        int i5 = -1;
        if (str != null) {
            int length = str.length();
            int indexOf = str.indexOf(44);
            int i6 = 0;
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                if (substring.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST)) {
                    i5 = 0;
                } else if (substring.equalsIgnoreCase("H")) {
                    i5 = 1;
                }
                i6 = indexOf + 1;
            }
            int indexOf2 = str.indexOf(58);
            if (indexOf2 < 0 || indexOf2 >= length - 1) {
                String substring2 = str.substring(i6);
                if (substring2.length() > 0) {
                    f5 = Float.parseFloat(substring2);
                }
            } else {
                String substring3 = str.substring(i6, indexOf2);
                String substring4 = str.substring(indexOf2 + 1);
                if (substring3.length() > 0 && substring4.length() > 0) {
                    try {
                        float parseFloat = Float.parseFloat(substring3);
                        float parseFloat2 = Float.parseFloat(substring4);
                        if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                            f5 = i5 == 1 ? Math.abs(parseFloat2 / parseFloat) : Math.abs(parseFloat / parseFloat2);
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
        layoutParams.dimensionRatio = str;
        layoutParams.mDimensionRatioValue = f5;
        layoutParams.mDimensionRatioSide = i5;
    }

    private void populateConstraint(Constraint constraint, TypedArray typedArray, boolean z4) {
        if (z4) {
            populateOverride(constraint, typedArray);
            return;
        }
        int indexCount = typedArray.getIndexCount();
        for (int i5 = 0; i5 < indexCount; i5++) {
            int index = typedArray.getIndex(i5);
            if (!(index == R.styleable.Constraint_android_id || R.styleable.Constraint_android_layout_marginStart == index || R.styleable.Constraint_android_layout_marginEnd == index)) {
                constraint.motion.mApply = true;
                constraint.layout.mApply = true;
                constraint.propertySet.mApply = true;
                constraint.transform.mApply = true;
            }
            switch (sMapToConstant.get(index)) {
                case 1:
                    Layout layout = constraint.layout;
                    layout.baselineToBaseline = lookupID(typedArray, index, layout.baselineToBaseline);
                    break;
                case 2:
                    Layout layout2 = constraint.layout;
                    layout2.bottomMargin = typedArray.getDimensionPixelSize(index, layout2.bottomMargin);
                    break;
                case 3:
                    Layout layout3 = constraint.layout;
                    layout3.bottomToBottom = lookupID(typedArray, index, layout3.bottomToBottom);
                    break;
                case 4:
                    Layout layout4 = constraint.layout;
                    layout4.bottomToTop = lookupID(typedArray, index, layout4.bottomToTop);
                    break;
                case 5:
                    constraint.layout.dimensionRatio = typedArray.getString(index);
                    break;
                case 6:
                    Layout layout5 = constraint.layout;
                    layout5.editorAbsoluteX = typedArray.getDimensionPixelOffset(index, layout5.editorAbsoluteX);
                    break;
                case 7:
                    Layout layout6 = constraint.layout;
                    layout6.editorAbsoluteY = typedArray.getDimensionPixelOffset(index, layout6.editorAbsoluteY);
                    break;
                case 8:
                    Layout layout7 = constraint.layout;
                    layout7.endMargin = typedArray.getDimensionPixelSize(index, layout7.endMargin);
                    break;
                case 9:
                    Layout layout8 = constraint.layout;
                    layout8.endToEnd = lookupID(typedArray, index, layout8.endToEnd);
                    break;
                case 10:
                    Layout layout9 = constraint.layout;
                    layout9.endToStart = lookupID(typedArray, index, layout9.endToStart);
                    break;
                case 11:
                    Layout layout10 = constraint.layout;
                    layout10.goneBottomMargin = typedArray.getDimensionPixelSize(index, layout10.goneBottomMargin);
                    break;
                case 12:
                    Layout layout11 = constraint.layout;
                    layout11.goneEndMargin = typedArray.getDimensionPixelSize(index, layout11.goneEndMargin);
                    break;
                case 13:
                    Layout layout12 = constraint.layout;
                    layout12.goneLeftMargin = typedArray.getDimensionPixelSize(index, layout12.goneLeftMargin);
                    break;
                case 14:
                    Layout layout13 = constraint.layout;
                    layout13.goneRightMargin = typedArray.getDimensionPixelSize(index, layout13.goneRightMargin);
                    break;
                case 15:
                    Layout layout14 = constraint.layout;
                    layout14.goneStartMargin = typedArray.getDimensionPixelSize(index, layout14.goneStartMargin);
                    break;
                case 16:
                    Layout layout15 = constraint.layout;
                    layout15.goneTopMargin = typedArray.getDimensionPixelSize(index, layout15.goneTopMargin);
                    break;
                case 17:
                    Layout layout16 = constraint.layout;
                    layout16.guideBegin = typedArray.getDimensionPixelOffset(index, layout16.guideBegin);
                    break;
                case 18:
                    Layout layout17 = constraint.layout;
                    layout17.guideEnd = typedArray.getDimensionPixelOffset(index, layout17.guideEnd);
                    break;
                case 19:
                    Layout layout18 = constraint.layout;
                    layout18.guidePercent = typedArray.getFloat(index, layout18.guidePercent);
                    break;
                case 20:
                    Layout layout19 = constraint.layout;
                    layout19.horizontalBias = typedArray.getFloat(index, layout19.horizontalBias);
                    break;
                case 21:
                    Layout layout20 = constraint.layout;
                    layout20.mHeight = typedArray.getLayoutDimension(index, layout20.mHeight);
                    break;
                case 22:
                    PropertySet propertySet = constraint.propertySet;
                    propertySet.visibility = typedArray.getInt(index, propertySet.visibility);
                    PropertySet propertySet2 = constraint.propertySet;
                    propertySet2.visibility = VISIBILITY_FLAGS[propertySet2.visibility];
                    break;
                case 23:
                    Layout layout21 = constraint.layout;
                    layout21.mWidth = typedArray.getLayoutDimension(index, layout21.mWidth);
                    break;
                case 24:
                    Layout layout22 = constraint.layout;
                    layout22.leftMargin = typedArray.getDimensionPixelSize(index, layout22.leftMargin);
                    break;
                case 25:
                    Layout layout23 = constraint.layout;
                    layout23.leftToLeft = lookupID(typedArray, index, layout23.leftToLeft);
                    break;
                case 26:
                    Layout layout24 = constraint.layout;
                    layout24.leftToRight = lookupID(typedArray, index, layout24.leftToRight);
                    break;
                case 27:
                    Layout layout25 = constraint.layout;
                    layout25.orientation = typedArray.getInt(index, layout25.orientation);
                    break;
                case 28:
                    Layout layout26 = constraint.layout;
                    layout26.rightMargin = typedArray.getDimensionPixelSize(index, layout26.rightMargin);
                    break;
                case 29:
                    Layout layout27 = constraint.layout;
                    layout27.rightToLeft = lookupID(typedArray, index, layout27.rightToLeft);
                    break;
                case 30:
                    Layout layout28 = constraint.layout;
                    layout28.rightToRight = lookupID(typedArray, index, layout28.rightToRight);
                    break;
                case 31:
                    Layout layout29 = constraint.layout;
                    layout29.startMargin = typedArray.getDimensionPixelSize(index, layout29.startMargin);
                    break;
                case 32:
                    Layout layout30 = constraint.layout;
                    layout30.startToEnd = lookupID(typedArray, index, layout30.startToEnd);
                    break;
                case 33:
                    Layout layout31 = constraint.layout;
                    layout31.startToStart = lookupID(typedArray, index, layout31.startToStart);
                    break;
                case 34:
                    Layout layout32 = constraint.layout;
                    layout32.topMargin = typedArray.getDimensionPixelSize(index, layout32.topMargin);
                    break;
                case 35:
                    Layout layout33 = constraint.layout;
                    layout33.topToBottom = lookupID(typedArray, index, layout33.topToBottom);
                    break;
                case 36:
                    Layout layout34 = constraint.layout;
                    layout34.topToTop = lookupID(typedArray, index, layout34.topToTop);
                    break;
                case 37:
                    Layout layout35 = constraint.layout;
                    layout35.verticalBias = typedArray.getFloat(index, layout35.verticalBias);
                    break;
                case 38:
                    constraint.mViewId = typedArray.getResourceId(index, constraint.mViewId);
                    break;
                case 39:
                    Layout layout36 = constraint.layout;
                    layout36.horizontalWeight = typedArray.getFloat(index, layout36.horizontalWeight);
                    break;
                case 40:
                    Layout layout37 = constraint.layout;
                    layout37.verticalWeight = typedArray.getFloat(index, layout37.verticalWeight);
                    break;
                case 41:
                    Layout layout38 = constraint.layout;
                    layout38.horizontalChainStyle = typedArray.getInt(index, layout38.horizontalChainStyle);
                    break;
                case 42:
                    Layout layout39 = constraint.layout;
                    layout39.verticalChainStyle = typedArray.getInt(index, layout39.verticalChainStyle);
                    break;
                case 43:
                    PropertySet propertySet3 = constraint.propertySet;
                    propertySet3.alpha = typedArray.getFloat(index, propertySet3.alpha);
                    break;
                case 44:
                    Transform transform = constraint.transform;
                    transform.applyElevation = true;
                    transform.elevation = typedArray.getDimension(index, transform.elevation);
                    break;
                case 45:
                    Transform transform2 = constraint.transform;
                    transform2.rotationX = typedArray.getFloat(index, transform2.rotationX);
                    break;
                case 46:
                    Transform transform3 = constraint.transform;
                    transform3.rotationY = typedArray.getFloat(index, transform3.rotationY);
                    break;
                case 47:
                    Transform transform4 = constraint.transform;
                    transform4.scaleX = typedArray.getFloat(index, transform4.scaleX);
                    break;
                case 48:
                    Transform transform5 = constraint.transform;
                    transform5.scaleY = typedArray.getFloat(index, transform5.scaleY);
                    break;
                case 49:
                    Transform transform6 = constraint.transform;
                    transform6.transformPivotX = typedArray.getDimension(index, transform6.transformPivotX);
                    break;
                case 50:
                    Transform transform7 = constraint.transform;
                    transform7.transformPivotY = typedArray.getDimension(index, transform7.transformPivotY);
                    break;
                case 51:
                    Transform transform8 = constraint.transform;
                    transform8.translationX = typedArray.getDimension(index, transform8.translationX);
                    break;
                case 52:
                    Transform transform9 = constraint.transform;
                    transform9.translationY = typedArray.getDimension(index, transform9.translationY);
                    break;
                case 53:
                    Transform transform10 = constraint.transform;
                    transform10.translationZ = typedArray.getDimension(index, transform10.translationZ);
                    break;
                case 54:
                    Layout layout40 = constraint.layout;
                    layout40.widthDefault = typedArray.getInt(index, layout40.widthDefault);
                    break;
                case 55:
                    Layout layout41 = constraint.layout;
                    layout41.heightDefault = typedArray.getInt(index, layout41.heightDefault);
                    break;
                case 56:
                    Layout layout42 = constraint.layout;
                    layout42.widthMax = typedArray.getDimensionPixelSize(index, layout42.widthMax);
                    break;
                case 57:
                    Layout layout43 = constraint.layout;
                    layout43.heightMax = typedArray.getDimensionPixelSize(index, layout43.heightMax);
                    break;
                case 58:
                    Layout layout44 = constraint.layout;
                    layout44.widthMin = typedArray.getDimensionPixelSize(index, layout44.widthMin);
                    break;
                case 59:
                    Layout layout45 = constraint.layout;
                    layout45.heightMin = typedArray.getDimensionPixelSize(index, layout45.heightMin);
                    break;
                case 60:
                    Transform transform11 = constraint.transform;
                    transform11.rotation = typedArray.getFloat(index, transform11.rotation);
                    break;
                case 61:
                    Layout layout46 = constraint.layout;
                    layout46.circleConstraint = lookupID(typedArray, index, layout46.circleConstraint);
                    break;
                case 62:
                    Layout layout47 = constraint.layout;
                    layout47.circleRadius = typedArray.getDimensionPixelSize(index, layout47.circleRadius);
                    break;
                case 63:
                    Layout layout48 = constraint.layout;
                    layout48.circleAngle = typedArray.getFloat(index, layout48.circleAngle);
                    break;
                case 64:
                    Motion motion = constraint.motion;
                    motion.mAnimateRelativeTo = lookupID(typedArray, index, motion.mAnimateRelativeTo);
                    break;
                case 65:
                    if (typedArray.peekValue(index).type != 3) {
                        constraint.motion.mTransitionEasing = Easing.NAMED_EASING[typedArray.getInteger(index, 0)];
                        break;
                    } else {
                        constraint.motion.mTransitionEasing = typedArray.getString(index);
                        break;
                    }
                case 66:
                    constraint.motion.mDrawPath = typedArray.getInt(index, 0);
                    break;
                case 67:
                    Motion motion2 = constraint.motion;
                    motion2.mPathRotate = typedArray.getFloat(index, motion2.mPathRotate);
                    break;
                case 68:
                    PropertySet propertySet4 = constraint.propertySet;
                    propertySet4.mProgress = typedArray.getFloat(index, propertySet4.mProgress);
                    break;
                case 69:
                    constraint.layout.widthPercent = typedArray.getFloat(index, 1.0f);
                    break;
                case 70:
                    constraint.layout.heightPercent = typedArray.getFloat(index, 1.0f);
                    break;
                case 71:
                    Log.e(TAG, "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    Layout layout49 = constraint.layout;
                    layout49.mBarrierDirection = typedArray.getInt(index, layout49.mBarrierDirection);
                    break;
                case 73:
                    Layout layout50 = constraint.layout;
                    layout50.mBarrierMargin = typedArray.getDimensionPixelSize(index, layout50.mBarrierMargin);
                    break;
                case 74:
                    constraint.layout.mReferenceIdString = typedArray.getString(index);
                    break;
                case 75:
                    Layout layout51 = constraint.layout;
                    layout51.mBarrierAllowsGoneWidgets = typedArray.getBoolean(index, layout51.mBarrierAllowsGoneWidgets);
                    break;
                case 76:
                    Motion motion3 = constraint.motion;
                    motion3.mPathMotionArc = typedArray.getInt(index, motion3.mPathMotionArc);
                    break;
                case 77:
                    constraint.layout.mConstraintTag = typedArray.getString(index);
                    break;
                case 78:
                    PropertySet propertySet5 = constraint.propertySet;
                    propertySet5.mVisibilityMode = typedArray.getInt(index, propertySet5.mVisibilityMode);
                    break;
                case 79:
                    Motion motion4 = constraint.motion;
                    motion4.mMotionStagger = typedArray.getFloat(index, motion4.mMotionStagger);
                    break;
                case 80:
                    Layout layout52 = constraint.layout;
                    layout52.constrainedWidth = typedArray.getBoolean(index, layout52.constrainedWidth);
                    break;
                case 81:
                    Layout layout53 = constraint.layout;
                    layout53.constrainedHeight = typedArray.getBoolean(index, layout53.constrainedHeight);
                    break;
                case 82:
                    Motion motion5 = constraint.motion;
                    motion5.mAnimateCircleAngleTo = typedArray.getInteger(index, motion5.mAnimateCircleAngleTo);
                    break;
                case 83:
                    Transform transform12 = constraint.transform;
                    transform12.transformPivotTarget = lookupID(typedArray, index, transform12.transformPivotTarget);
                    break;
                case 84:
                    Motion motion6 = constraint.motion;
                    motion6.mQuantizeMotionSteps = typedArray.getInteger(index, motion6.mQuantizeMotionSteps);
                    break;
                case 85:
                    Motion motion7 = constraint.motion;
                    motion7.mQuantizeMotionPhase = typedArray.getFloat(index, motion7.mQuantizeMotionPhase);
                    break;
                case 86:
                    int i6 = typedArray.peekValue(index).type;
                    if (i6 != 1) {
                        if (i6 != 3) {
                            Motion motion8 = constraint.motion;
                            motion8.mQuantizeInterpolatorType = typedArray.getInteger(index, motion8.mQuantizeInterpolatorID);
                            break;
                        } else {
                            constraint.motion.mQuantizeInterpolatorString = typedArray.getString(index);
                            if (constraint.motion.mQuantizeInterpolatorString.indexOf("/") <= 0) {
                                constraint.motion.mQuantizeInterpolatorType = -1;
                                break;
                            } else {
                                constraint.motion.mQuantizeInterpolatorID = typedArray.getResourceId(index, -1);
                                constraint.motion.mQuantizeInterpolatorType = -2;
                                break;
                            }
                        }
                    } else {
                        constraint.motion.mQuantizeInterpolatorID = typedArray.getResourceId(index, -1);
                        Motion motion9 = constraint.motion;
                        if (motion9.mQuantizeInterpolatorID == -1) {
                            break;
                        } else {
                            motion9.mQuantizeInterpolatorType = -2;
                            break;
                        }
                    }
                case 87:
                    Log.w(TAG, "unused attribute 0x" + Integer.toHexString(index) + "   " + sMapToConstant.get(index));
                    break;
                case 91:
                    Layout layout54 = constraint.layout;
                    layout54.baselineToTop = lookupID(typedArray, index, layout54.baselineToTop);
                    break;
                case 92:
                    Layout layout55 = constraint.layout;
                    layout55.baselineToBottom = lookupID(typedArray, index, layout55.baselineToBottom);
                    break;
                case 93:
                    Layout layout56 = constraint.layout;
                    layout56.baselineMargin = typedArray.getDimensionPixelSize(index, layout56.baselineMargin);
                    break;
                case 94:
                    Layout layout57 = constraint.layout;
                    layout57.goneBaselineMargin = typedArray.getDimensionPixelSize(index, layout57.goneBaselineMargin);
                    break;
                case 95:
                    parseDimensionConstraints(constraint.layout, typedArray, index, 0);
                    break;
                case 96:
                    parseDimensionConstraints(constraint.layout, typedArray, index, 1);
                    break;
                case 97:
                    Layout layout58 = constraint.layout;
                    layout58.mWrapBehavior = typedArray.getInt(index, layout58.mWrapBehavior);
                    break;
                default:
                    Log.w(TAG, "Unknown attribute 0x" + Integer.toHexString(index) + "   " + sMapToConstant.get(index));
                    break;
            }
        }
        Layout layout59 = constraint.layout;
        if (layout59.mReferenceIdString != null) {
            layout59.mReferenceIds = null;
        }
    }

    private static void populateOverride(Constraint constraint, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        Constraint.Delta delta = new Constraint.Delta();
        constraint.mDelta = delta;
        constraint.motion.mApply = false;
        constraint.layout.mApply = false;
        constraint.propertySet.mApply = false;
        constraint.transform.mApply = false;
        for (int i5 = 0; i5 < indexCount; i5++) {
            int index = typedArray.getIndex(i5);
            switch (sOverrideMapToConstant.get(index)) {
                case 2:
                    delta.add(2, typedArray.getDimensionPixelSize(index, constraint.layout.bottomMargin));
                    break;
                case 5:
                    delta.add(5, typedArray.getString(index));
                    break;
                case 6:
                    delta.add(6, typedArray.getDimensionPixelOffset(index, constraint.layout.editorAbsoluteX));
                    break;
                case 7:
                    delta.add(7, typedArray.getDimensionPixelOffset(index, constraint.layout.editorAbsoluteY));
                    break;
                case 8:
                    delta.add(8, typedArray.getDimensionPixelSize(index, constraint.layout.endMargin));
                    break;
                case 11:
                    delta.add(11, typedArray.getDimensionPixelSize(index, constraint.layout.goneBottomMargin));
                    break;
                case 12:
                    delta.add(12, typedArray.getDimensionPixelSize(index, constraint.layout.goneEndMargin));
                    break;
                case 13:
                    delta.add(13, typedArray.getDimensionPixelSize(index, constraint.layout.goneLeftMargin));
                    break;
                case 14:
                    delta.add(14, typedArray.getDimensionPixelSize(index, constraint.layout.goneRightMargin));
                    break;
                case 15:
                    delta.add(15, typedArray.getDimensionPixelSize(index, constraint.layout.goneStartMargin));
                    break;
                case 16:
                    delta.add(16, typedArray.getDimensionPixelSize(index, constraint.layout.goneTopMargin));
                    break;
                case 17:
                    delta.add(17, typedArray.getDimensionPixelOffset(index, constraint.layout.guideBegin));
                    break;
                case 18:
                    delta.add(18, typedArray.getDimensionPixelOffset(index, constraint.layout.guideEnd));
                    break;
                case 19:
                    delta.add(19, typedArray.getFloat(index, constraint.layout.guidePercent));
                    break;
                case 20:
                    delta.add(20, typedArray.getFloat(index, constraint.layout.horizontalBias));
                    break;
                case 21:
                    delta.add(21, typedArray.getLayoutDimension(index, constraint.layout.mHeight));
                    break;
                case 22:
                    delta.add(22, VISIBILITY_FLAGS[typedArray.getInt(index, constraint.propertySet.visibility)]);
                    break;
                case 23:
                    delta.add(23, typedArray.getLayoutDimension(index, constraint.layout.mWidth));
                    break;
                case 24:
                    delta.add(24, typedArray.getDimensionPixelSize(index, constraint.layout.leftMargin));
                    break;
                case 27:
                    delta.add(27, typedArray.getInt(index, constraint.layout.orientation));
                    break;
                case 28:
                    delta.add(28, typedArray.getDimensionPixelSize(index, constraint.layout.rightMargin));
                    break;
                case 31:
                    delta.add(31, typedArray.getDimensionPixelSize(index, constraint.layout.startMargin));
                    break;
                case 34:
                    delta.add(34, typedArray.getDimensionPixelSize(index, constraint.layout.topMargin));
                    break;
                case 37:
                    delta.add(37, typedArray.getFloat(index, constraint.layout.verticalBias));
                    break;
                case 38:
                    int resourceId = typedArray.getResourceId(index, constraint.mViewId);
                    constraint.mViewId = resourceId;
                    delta.add(38, resourceId);
                    break;
                case 39:
                    delta.add(39, typedArray.getFloat(index, constraint.layout.horizontalWeight));
                    break;
                case 40:
                    delta.add(40, typedArray.getFloat(index, constraint.layout.verticalWeight));
                    break;
                case 41:
                    delta.add(41, typedArray.getInt(index, constraint.layout.horizontalChainStyle));
                    break;
                case 42:
                    delta.add(42, typedArray.getInt(index, constraint.layout.verticalChainStyle));
                    break;
                case 43:
                    delta.add(43, typedArray.getFloat(index, constraint.propertySet.alpha));
                    break;
                case 44:
                    delta.add(44, true);
                    delta.add(44, typedArray.getDimension(index, constraint.transform.elevation));
                    break;
                case 45:
                    delta.add(45, typedArray.getFloat(index, constraint.transform.rotationX));
                    break;
                case 46:
                    delta.add(46, typedArray.getFloat(index, constraint.transform.rotationY));
                    break;
                case 47:
                    delta.add(47, typedArray.getFloat(index, constraint.transform.scaleX));
                    break;
                case 48:
                    delta.add(48, typedArray.getFloat(index, constraint.transform.scaleY));
                    break;
                case 49:
                    delta.add(49, typedArray.getDimension(index, constraint.transform.transformPivotX));
                    break;
                case 50:
                    delta.add(50, typedArray.getDimension(index, constraint.transform.transformPivotY));
                    break;
                case 51:
                    delta.add(51, typedArray.getDimension(index, constraint.transform.translationX));
                    break;
                case 52:
                    delta.add(52, typedArray.getDimension(index, constraint.transform.translationY));
                    break;
                case 53:
                    delta.add(53, typedArray.getDimension(index, constraint.transform.translationZ));
                    break;
                case 54:
                    delta.add(54, typedArray.getInt(index, constraint.layout.widthDefault));
                    break;
                case 55:
                    delta.add(55, typedArray.getInt(index, constraint.layout.heightDefault));
                    break;
                case 56:
                    delta.add(56, typedArray.getDimensionPixelSize(index, constraint.layout.widthMax));
                    break;
                case 57:
                    delta.add(57, typedArray.getDimensionPixelSize(index, constraint.layout.heightMax));
                    break;
                case 58:
                    delta.add(58, typedArray.getDimensionPixelSize(index, constraint.layout.widthMin));
                    break;
                case 59:
                    delta.add(59, typedArray.getDimensionPixelSize(index, constraint.layout.heightMin));
                    break;
                case 60:
                    delta.add(60, typedArray.getFloat(index, constraint.transform.rotation));
                    break;
                case 62:
                    delta.add(62, typedArray.getDimensionPixelSize(index, constraint.layout.circleRadius));
                    break;
                case 63:
                    delta.add(63, typedArray.getFloat(index, constraint.layout.circleAngle));
                    break;
                case 64:
                    delta.add(64, lookupID(typedArray, index, constraint.motion.mAnimateRelativeTo));
                    break;
                case 65:
                    if (typedArray.peekValue(index).type != 3) {
                        delta.add(65, Easing.NAMED_EASING[typedArray.getInteger(index, 0)]);
                        break;
                    } else {
                        delta.add(65, typedArray.getString(index));
                        break;
                    }
                case 66:
                    delta.add(66, typedArray.getInt(index, 0));
                    break;
                case 67:
                    delta.add(67, typedArray.getFloat(index, constraint.motion.mPathRotate));
                    break;
                case 68:
                    delta.add(68, typedArray.getFloat(index, constraint.propertySet.mProgress));
                    break;
                case 69:
                    delta.add(69, typedArray.getFloat(index, 1.0f));
                    break;
                case 70:
                    delta.add(70, typedArray.getFloat(index, 1.0f));
                    break;
                case 71:
                    Log.e(TAG, "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    delta.add(72, typedArray.getInt(index, constraint.layout.mBarrierDirection));
                    break;
                case 73:
                    delta.add(73, typedArray.getDimensionPixelSize(index, constraint.layout.mBarrierMargin));
                    break;
                case 74:
                    delta.add(74, typedArray.getString(index));
                    break;
                case 75:
                    delta.add(75, typedArray.getBoolean(index, constraint.layout.mBarrierAllowsGoneWidgets));
                    break;
                case 76:
                    delta.add(76, typedArray.getInt(index, constraint.motion.mPathMotionArc));
                    break;
                case 77:
                    delta.add(77, typedArray.getString(index));
                    break;
                case 78:
                    delta.add(78, typedArray.getInt(index, constraint.propertySet.mVisibilityMode));
                    break;
                case 79:
                    delta.add(79, typedArray.getFloat(index, constraint.motion.mMotionStagger));
                    break;
                case 80:
                    delta.add(80, typedArray.getBoolean(index, constraint.layout.constrainedWidth));
                    break;
                case 81:
                    delta.add(81, typedArray.getBoolean(index, constraint.layout.constrainedHeight));
                    break;
                case 82:
                    delta.add(82, typedArray.getInteger(index, constraint.motion.mAnimateCircleAngleTo));
                    break;
                case 83:
                    delta.add(83, lookupID(typedArray, index, constraint.transform.transformPivotTarget));
                    break;
                case 84:
                    delta.add(84, typedArray.getInteger(index, constraint.motion.mQuantizeMotionSteps));
                    break;
                case 85:
                    delta.add(85, typedArray.getFloat(index, constraint.motion.mQuantizeMotionPhase));
                    break;
                case 86:
                    int i6 = typedArray.peekValue(index).type;
                    if (i6 != 1) {
                        if (i6 != 3) {
                            Motion motion = constraint.motion;
                            motion.mQuantizeInterpolatorType = typedArray.getInteger(index, motion.mQuantizeInterpolatorID);
                            delta.add(88, constraint.motion.mQuantizeInterpolatorType);
                            break;
                        } else {
                            constraint.motion.mQuantizeInterpolatorString = typedArray.getString(index);
                            delta.add(90, constraint.motion.mQuantizeInterpolatorString);
                            if (constraint.motion.mQuantizeInterpolatorString.indexOf("/") <= 0) {
                                constraint.motion.mQuantizeInterpolatorType = -1;
                                delta.add(88, -1);
                                break;
                            } else {
                                constraint.motion.mQuantizeInterpolatorID = typedArray.getResourceId(index, -1);
                                delta.add(89, constraint.motion.mQuantizeInterpolatorID);
                                constraint.motion.mQuantizeInterpolatorType = -2;
                                delta.add(88, -2);
                                break;
                            }
                        }
                    } else {
                        constraint.motion.mQuantizeInterpolatorID = typedArray.getResourceId(index, -1);
                        delta.add(89, constraint.motion.mQuantizeInterpolatorID);
                        Motion motion2 = constraint.motion;
                        if (motion2.mQuantizeInterpolatorID == -1) {
                            break;
                        } else {
                            motion2.mQuantizeInterpolatorType = -2;
                            delta.add(88, -2);
                            break;
                        }
                    }
                case 87:
                    Log.w(TAG, "unused attribute 0x" + Integer.toHexString(index) + "   " + sMapToConstant.get(index));
                    break;
                case 93:
                    delta.add(93, typedArray.getDimensionPixelSize(index, constraint.layout.baselineMargin));
                    break;
                case 94:
                    delta.add(94, typedArray.getDimensionPixelSize(index, constraint.layout.goneBaselineMargin));
                    break;
                case 95:
                    parseDimensionConstraints(delta, typedArray, index, 0);
                    break;
                case 96:
                    parseDimensionConstraints(delta, typedArray, index, 1);
                    break;
                case 97:
                    delta.add(97, typedArray.getInt(index, constraint.layout.mWrapBehavior));
                    break;
                case 98:
                    if (!MotionLayout.IS_IN_EDIT_MODE) {
                        if (typedArray.peekValue(index).type != 3) {
                            constraint.mViewId = typedArray.getResourceId(index, constraint.mViewId);
                            break;
                        } else {
                            constraint.mTargetString = typedArray.getString(index);
                            break;
                        }
                    } else {
                        int resourceId2 = typedArray.getResourceId(index, constraint.mViewId);
                        constraint.mViewId = resourceId2;
                        if (resourceId2 != -1) {
                            break;
                        } else {
                            constraint.mTargetString = typedArray.getString(index);
                            break;
                        }
                    }
                case 99:
                    delta.add(99, typedArray.getBoolean(index, constraint.layout.guidelineUseRtl));
                    break;
                default:
                    Log.w(TAG, "Unknown attribute 0x" + Integer.toHexString(index) + "   " + sMapToConstant.get(index));
                    break;
            }
        }
    }

    /* access modifiers changed from: private */
    public static void setDeltaValue(Constraint constraint, int i5, float f5) {
        if (i5 == 19) {
            constraint.layout.guidePercent = f5;
        } else if (i5 == 20) {
            constraint.layout.horizontalBias = f5;
        } else if (i5 == 37) {
            constraint.layout.verticalBias = f5;
        } else if (i5 == 60) {
            constraint.transform.rotation = f5;
        } else if (i5 == 63) {
            constraint.layout.circleAngle = f5;
        } else if (i5 == 79) {
            constraint.motion.mMotionStagger = f5;
        } else if (i5 == 85) {
            constraint.motion.mQuantizeMotionPhase = f5;
        } else if (i5 == 87) {
        } else {
            if (i5 == 39) {
                constraint.layout.horizontalWeight = f5;
            } else if (i5 != 40) {
                switch (i5) {
                    case 43:
                        constraint.propertySet.alpha = f5;
                        return;
                    case 44:
                        Transform transform = constraint.transform;
                        transform.elevation = f5;
                        transform.applyElevation = true;
                        return;
                    case 45:
                        constraint.transform.rotationX = f5;
                        return;
                    case 46:
                        constraint.transform.rotationY = f5;
                        return;
                    case 47:
                        constraint.transform.scaleX = f5;
                        return;
                    case 48:
                        constraint.transform.scaleY = f5;
                        return;
                    case 49:
                        constraint.transform.transformPivotX = f5;
                        return;
                    case 50:
                        constraint.transform.transformPivotY = f5;
                        return;
                    case 51:
                        constraint.transform.translationX = f5;
                        return;
                    case 52:
                        constraint.transform.translationY = f5;
                        return;
                    case 53:
                        constraint.transform.translationZ = f5;
                        return;
                    default:
                        switch (i5) {
                            case 67:
                                constraint.motion.mPathRotate = f5;
                                return;
                            case 68:
                                constraint.propertySet.mProgress = f5;
                                return;
                            case 69:
                                constraint.layout.widthPercent = f5;
                                return;
                            case 70:
                                constraint.layout.heightPercent = f5;
                                return;
                            default:
                                Log.w(TAG, "Unknown attribute 0x");
                                return;
                        }
                }
            } else {
                constraint.layout.verticalWeight = f5;
            }
        }
    }

    private String sideToString(int i5) {
        switch (i5) {
            case 1:
                return TtmlNode.LEFT;
            case 2:
                return TtmlNode.RIGHT;
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return TtmlNode.END;
            default:
                return "undefined";
        }
    }

    private static String[] splitString(String str) {
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        boolean z4 = false;
        for (int i6 = 0; i6 < charArray.length; i6++) {
            char c5 = charArray[i6];
            if (c5 == ',' && !z4) {
                arrayList.add(new String(charArray, i5, i6 - i5));
                i5 = i6 + 1;
            } else if (c5 == '\"') {
                z4 = !z4;
            }
        }
        arrayList.add(new String(charArray, i5, charArray.length - i5));
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public void addColorAttributes(String... strArr) {
        addAttributes(ConstraintAttribute.AttributeType.COLOR_TYPE, strArr);
    }

    public void addFloatAttributes(String... strArr) {
        addAttributes(ConstraintAttribute.AttributeType.FLOAT_TYPE, strArr);
    }

    public void addIntAttributes(String... strArr) {
        addAttributes(ConstraintAttribute.AttributeType.INT_TYPE, strArr);
    }

    public void addStringAttributes(String... strArr) {
        addAttributes(ConstraintAttribute.AttributeType.STRING_TYPE, strArr);
    }

    public void addToHorizontalChain(int i5, int i6, int i7) {
        int i8;
        int i9;
        if (i6 == 0) {
            i8 = 1;
        } else {
            i8 = 2;
        }
        connect(i5, 1, i6, i8, 0);
        if (i7 == 0) {
            i9 = 2;
        } else {
            i9 = 1;
        }
        connect(i5, 2, i7, i9, 0);
        if (i6 != 0) {
            connect(i6, 2, i5, 1, 0);
        }
        if (i7 != 0) {
            connect(i7, 1, i5, 2, 0);
        }
    }

    public void addToHorizontalChainRTL(int i5, int i6, int i7) {
        int i8;
        int i9;
        if (i6 == 0) {
            i8 = 6;
        } else {
            i8 = 7;
        }
        connect(i5, 6, i6, i8, 0);
        if (i7 == 0) {
            i9 = 7;
        } else {
            i9 = 6;
        }
        connect(i5, 7, i7, i9, 0);
        if (i6 != 0) {
            connect(i6, 7, i5, 6, 0);
        }
        if (i7 != 0) {
            connect(i7, 6, i5, 7, 0);
        }
    }

    public void addToVerticalChain(int i5, int i6, int i7) {
        int i8;
        int i9;
        if (i6 == 0) {
            i8 = 3;
        } else {
            i8 = 4;
        }
        connect(i5, 3, i6, i8, 0);
        if (i7 == 0) {
            i9 = 4;
        } else {
            i9 = 3;
        }
        connect(i5, 4, i7, i9, 0);
        if (i6 != 0) {
            connect(i6, 4, i5, 3, 0);
        }
        if (i7 != 0) {
            connect(i7, 3, i5, 4, 0);
        }
    }

    public void applyCustomAttributes(ConstraintLayout constraintLayout) {
        Constraint constraint;
        int childCount = constraintLayout.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = constraintLayout.getChildAt(i5);
            int id = childAt.getId();
            if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
                Log.w(TAG, "id unknown " + Debug.getName(childAt));
            } else if (this.mForceId && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else if (this.mConstraints.containsKey(Integer.valueOf(id)) && (constraint = this.mConstraints.get(Integer.valueOf(id))) != null) {
                ConstraintAttribute.setAttributes(childAt, constraint.mCustomConstraints);
            }
        }
    }

    public void applyDeltaFrom(ConstraintSet constraintSet) {
        for (Constraint next : constraintSet.mConstraints.values()) {
            if (next.mDelta != null) {
                if (next.mTargetString == null) {
                    next.mDelta.applyDelta(getConstraint(next.mViewId));
                } else {
                    for (Integer intValue : this.mConstraints.keySet()) {
                        Constraint constraint = getConstraint(intValue.intValue());
                        String str = constraint.layout.mConstraintTag;
                        if (str != null && next.mTargetString.matches(str)) {
                            next.mDelta.applyDelta(constraint);
                            constraint.mCustomConstraints.putAll((HashMap) next.mCustomConstraints.clone());
                        }
                    }
                }
            }
        }
    }

    public void applyTo(ConstraintLayout constraintLayout) {
        applyToInternal(constraintLayout, true);
        constraintLayout.setConstraintSet((ConstraintSet) null);
        constraintLayout.requestLayout();
    }

    public void applyToHelper(ConstraintHelper constraintHelper, ConstraintWidget constraintWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        Constraint constraint;
        int id = constraintHelper.getId();
        if (this.mConstraints.containsKey(Integer.valueOf(id)) && (constraint = this.mConstraints.get(Integer.valueOf(id))) != null && (constraintWidget instanceof HelperWidget)) {
            constraintHelper.loadParameters(constraint, (HelperWidget) constraintWidget, layoutParams, sparseArray);
        }
    }

    /* access modifiers changed from: package-private */
    public void applyToInternal(ConstraintLayout constraintLayout, boolean z4) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.mConstraints.keySet());
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = constraintLayout.getChildAt(i5);
            int id = childAt.getId();
            if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
                Log.w(TAG, "id unknown " + Debug.getName(childAt));
            } else if (this.mForceId && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else if (id != -1) {
                if (this.mConstraints.containsKey(Integer.valueOf(id))) {
                    hashSet.remove(Integer.valueOf(id));
                    Constraint constraint = this.mConstraints.get(Integer.valueOf(id));
                    if (constraint != null) {
                        if (childAt instanceof Barrier) {
                            constraint.layout.mHelperType = 1;
                            Barrier barrier = (Barrier) childAt;
                            barrier.setId(id);
                            barrier.setType(constraint.layout.mBarrierDirection);
                            barrier.setMargin(constraint.layout.mBarrierMargin);
                            barrier.setAllowsGoneWidget(constraint.layout.mBarrierAllowsGoneWidgets);
                            Layout layout = constraint.layout;
                            int[] iArr = layout.mReferenceIds;
                            if (iArr != null) {
                                barrier.setReferencedIds(iArr);
                            } else {
                                String str = layout.mReferenceIdString;
                                if (str != null) {
                                    layout.mReferenceIds = convertReferenceString(barrier, str);
                                    barrier.setReferencedIds(constraint.layout.mReferenceIds);
                                }
                            }
                        }
                        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                        layoutParams.validate();
                        constraint.applyTo(layoutParams);
                        if (z4) {
                            ConstraintAttribute.setAttributes(childAt, constraint.mCustomConstraints);
                        }
                        childAt.setLayoutParams(layoutParams);
                        PropertySet propertySet = constraint.propertySet;
                        if (propertySet.mVisibilityMode == 0) {
                            childAt.setVisibility(propertySet.visibility);
                        }
                        childAt.setAlpha(constraint.propertySet.alpha);
                        childAt.setRotation(constraint.transform.rotation);
                        childAt.setRotationX(constraint.transform.rotationX);
                        childAt.setRotationY(constraint.transform.rotationY);
                        childAt.setScaleX(constraint.transform.scaleX);
                        childAt.setScaleY(constraint.transform.scaleY);
                        Transform transform = constraint.transform;
                        if (transform.transformPivotTarget != -1) {
                            View findViewById = ((View) childAt.getParent()).findViewById(constraint.transform.transformPivotTarget);
                            if (findViewById != null) {
                                float top = ((float) (findViewById.getTop() + findViewById.getBottom())) / 2.0f;
                                float left = ((float) (findViewById.getLeft() + findViewById.getRight())) / 2.0f;
                                if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                    childAt.setPivotX(left - ((float) childAt.getLeft()));
                                    childAt.setPivotY(top - ((float) childAt.getTop()));
                                }
                            }
                        } else {
                            if (!Float.isNaN(transform.transformPivotX)) {
                                childAt.setPivotX(constraint.transform.transformPivotX);
                            }
                            if (!Float.isNaN(constraint.transform.transformPivotY)) {
                                childAt.setPivotY(constraint.transform.transformPivotY);
                            }
                        }
                        childAt.setTranslationX(constraint.transform.translationX);
                        childAt.setTranslationY(constraint.transform.translationY);
                        childAt.setTranslationZ(constraint.transform.translationZ);
                        Transform transform2 = constraint.transform;
                        if (transform2.applyElevation) {
                            childAt.setElevation(transform2.elevation);
                        }
                    }
                } else {
                    Log.v(TAG, "WARNING NO CONSTRAINTS for view " + id);
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            Constraint constraint2 = this.mConstraints.get(num);
            if (constraint2 != null) {
                if (constraint2.layout.mHelperType == 1) {
                    Barrier barrier2 = new Barrier(constraintLayout.getContext());
                    barrier2.setId(num.intValue());
                    Layout layout2 = constraint2.layout;
                    int[] iArr2 = layout2.mReferenceIds;
                    if (iArr2 != null) {
                        barrier2.setReferencedIds(iArr2);
                    } else {
                        String str2 = layout2.mReferenceIdString;
                        if (str2 != null) {
                            layout2.mReferenceIds = convertReferenceString(barrier2, str2);
                            barrier2.setReferencedIds(constraint2.layout.mReferenceIds);
                        }
                    }
                    barrier2.setType(constraint2.layout.mBarrierDirection);
                    barrier2.setMargin(constraint2.layout.mBarrierMargin);
                    ConstraintLayout.LayoutParams generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                    barrier2.validateParams();
                    constraint2.applyTo(generateDefaultLayoutParams);
                    constraintLayout.addView(barrier2, generateDefaultLayoutParams);
                }
                if (constraint2.layout.mIsGuideline) {
                    Guideline guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    ConstraintLayout.LayoutParams generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                    constraint2.applyTo(generateDefaultLayoutParams2);
                    constraintLayout.addView(guideline, generateDefaultLayoutParams2);
                }
            }
        }
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt2 = constraintLayout.getChildAt(i6);
            if (childAt2 instanceof ConstraintHelper) {
                ((ConstraintHelper) childAt2).applyLayoutFeaturesInConstraintSet(constraintLayout);
            }
        }
    }

    public void applyToLayoutParams(int i5, ConstraintLayout.LayoutParams layoutParams) {
        Constraint constraint;
        if (this.mConstraints.containsKey(Integer.valueOf(i5)) && (constraint = this.mConstraints.get(Integer.valueOf(i5))) != null) {
            constraint.applyTo(layoutParams);
        }
    }

    public void applyToWithoutCustom(ConstraintLayout constraintLayout) {
        applyToInternal(constraintLayout, false);
        constraintLayout.setConstraintSet((ConstraintSet) null);
    }

    public void center(int i5, int i6, int i7, int i8, int i9, int i10, int i11, float f5) {
        if (i8 < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        } else if (i11 < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        } else if (f5 <= 0.0f || f5 > 1.0f) {
            throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
        } else if (i7 == 1 || i7 == 2) {
            int i12 = i10;
            int i13 = i11;
            int i14 = i8;
            int i15 = i9;
            int i16 = i6;
            int i17 = i5;
            connect(i17, 1, i16, i7, i14);
            connect(i17, 2, i15, i12, i13);
            Constraint constraint = this.mConstraints.get(Integer.valueOf(i17));
            if (constraint != null) {
                constraint.layout.horizontalBias = f5;
            }
        } else if (i7 == 6 || i7 == 7) {
            int i18 = i10;
            int i19 = i11;
            int i20 = i8;
            int i21 = i9;
            int i22 = i6;
            int i23 = i5;
            connect(i23, 6, i22, i7, i20);
            connect(i23, 7, i21, i18, i19);
            Constraint constraint2 = this.mConstraints.get(Integer.valueOf(i23));
            if (constraint2 != null) {
                constraint2.layout.horizontalBias = f5;
            }
        } else {
            int i24 = i5;
            connect(i24, 3, i6, i7, i8);
            int i25 = i24;
            connect(i25, 4, i9, i10, i11);
            Constraint constraint3 = this.mConstraints.get(Integer.valueOf(i25));
            if (constraint3 != null) {
                constraint3.layout.verticalBias = f5;
            }
        }
    }

    public void centerHorizontally(int i5, int i6, int i7, int i8, int i9, int i10, int i11, float f5) {
        int i12 = i5;
        connect(i12, 1, i6, i7, i8);
        int i13 = i12;
        connect(i13, 2, i9, i10, i11);
        Constraint constraint = this.mConstraints.get(Integer.valueOf(i13));
        if (constraint != null) {
            constraint.layout.horizontalBias = f5;
        }
    }

    public void centerHorizontallyRtl(int i5, int i6, int i7, int i8, int i9, int i10, int i11, float f5) {
        int i12 = i5;
        connect(i12, 6, i6, i7, i8);
        int i13 = i12;
        connect(i13, 7, i9, i10, i11);
        Constraint constraint = this.mConstraints.get(Integer.valueOf(i13));
        if (constraint != null) {
            constraint.layout.horizontalBias = f5;
        }
    }

    public void centerVertically(int i5, int i6, int i7, int i8, int i9, int i10, int i11, float f5) {
        int i12 = i5;
        connect(i12, 3, i6, i7, i8);
        int i13 = i12;
        connect(i13, 4, i9, i10, i11);
        Constraint constraint = this.mConstraints.get(Integer.valueOf(i13));
        if (constraint != null) {
            constraint.layout.verticalBias = f5;
        }
    }

    public void clear(int i5) {
        this.mConstraints.remove(Integer.valueOf(i5));
    }

    public void clone(Context context, int i5) {
        clone((ConstraintLayout) LayoutInflater.from(context).inflate(i5, (ViewGroup) null));
    }

    public void connect(int i5, int i6, int i7, int i8, int i9) {
        if (!this.mConstraints.containsKey(Integer.valueOf(i5))) {
            this.mConstraints.put(Integer.valueOf(i5), new Constraint());
        }
        Constraint constraint = this.mConstraints.get(Integer.valueOf(i5));
        if (constraint != null) {
            switch (i6) {
                case 1:
                    if (i8 == 1) {
                        Layout layout = constraint.layout;
                        layout.leftToLeft = i7;
                        layout.leftToRight = -1;
                    } else if (i8 == 2) {
                        Layout layout2 = constraint.layout;
                        layout2.leftToRight = i7;
                        layout2.leftToLeft = -1;
                    } else {
                        throw new IllegalArgumentException("Left to " + sideToString(i8) + " undefined");
                    }
                    constraint.layout.leftMargin = i9;
                    return;
                case 2:
                    if (i8 == 1) {
                        Layout layout3 = constraint.layout;
                        layout3.rightToLeft = i7;
                        layout3.rightToRight = -1;
                    } else if (i8 == 2) {
                        Layout layout4 = constraint.layout;
                        layout4.rightToRight = i7;
                        layout4.rightToLeft = -1;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i8) + " undefined");
                    }
                    constraint.layout.rightMargin = i9;
                    return;
                case 3:
                    if (i8 == 3) {
                        Layout layout5 = constraint.layout;
                        layout5.topToTop = i7;
                        layout5.topToBottom = -1;
                        layout5.baselineToBaseline = -1;
                        layout5.baselineToTop = -1;
                        layout5.baselineToBottom = -1;
                    } else if (i8 == 4) {
                        Layout layout6 = constraint.layout;
                        layout6.topToBottom = i7;
                        layout6.topToTop = -1;
                        layout6.baselineToBaseline = -1;
                        layout6.baselineToTop = -1;
                        layout6.baselineToBottom = -1;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i8) + " undefined");
                    }
                    constraint.layout.topMargin = i9;
                    return;
                case 4:
                    if (i8 == 4) {
                        Layout layout7 = constraint.layout;
                        layout7.bottomToBottom = i7;
                        layout7.bottomToTop = -1;
                        layout7.baselineToBaseline = -1;
                        layout7.baselineToTop = -1;
                        layout7.baselineToBottom = -1;
                    } else if (i8 == 3) {
                        Layout layout8 = constraint.layout;
                        layout8.bottomToTop = i7;
                        layout8.bottomToBottom = -1;
                        layout8.baselineToBaseline = -1;
                        layout8.baselineToTop = -1;
                        layout8.baselineToBottom = -1;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i8) + " undefined");
                    }
                    constraint.layout.bottomMargin = i9;
                    return;
                case 5:
                    if (i8 == 5) {
                        Layout layout9 = constraint.layout;
                        layout9.baselineToBaseline = i7;
                        layout9.bottomToBottom = -1;
                        layout9.bottomToTop = -1;
                        layout9.topToTop = -1;
                        layout9.topToBottom = -1;
                        return;
                    } else if (i8 == 3) {
                        Layout layout10 = constraint.layout;
                        layout10.baselineToTop = i7;
                        layout10.bottomToBottom = -1;
                        layout10.bottomToTop = -1;
                        layout10.topToTop = -1;
                        layout10.topToBottom = -1;
                        return;
                    } else if (i8 == 4) {
                        Layout layout11 = constraint.layout;
                        layout11.baselineToBottom = i7;
                        layout11.bottomToBottom = -1;
                        layout11.bottomToTop = -1;
                        layout11.topToTop = -1;
                        layout11.topToBottom = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i8) + " undefined");
                    }
                case 6:
                    if (i8 == 6) {
                        Layout layout12 = constraint.layout;
                        layout12.startToStart = i7;
                        layout12.startToEnd = -1;
                    } else if (i8 == 7) {
                        Layout layout13 = constraint.layout;
                        layout13.startToEnd = i7;
                        layout13.startToStart = -1;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i8) + " undefined");
                    }
                    constraint.layout.startMargin = i9;
                    return;
                case 7:
                    if (i8 == 7) {
                        Layout layout14 = constraint.layout;
                        layout14.endToEnd = i7;
                        layout14.endToStart = -1;
                    } else if (i8 == 6) {
                        Layout layout15 = constraint.layout;
                        layout15.endToStart = i7;
                        layout15.endToEnd = -1;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i8) + " undefined");
                    }
                    constraint.layout.endMargin = i9;
                    return;
                default:
                    throw new IllegalArgumentException(sideToString(i6) + " to " + sideToString(i8) + " unknown");
            }
        }
    }

    public void constrainCircle(int i5, int i6, int i7, float f5) {
        Layout layout = get(i5).layout;
        layout.circleConstraint = i6;
        layout.circleRadius = i7;
        layout.circleAngle = f5;
    }

    public void constrainDefaultHeight(int i5, int i6) {
        get(i5).layout.heightDefault = i6;
    }

    public void constrainDefaultWidth(int i5, int i6) {
        get(i5).layout.widthDefault = i6;
    }

    public void constrainHeight(int i5, int i6) {
        get(i5).layout.mHeight = i6;
    }

    public void constrainMaxHeight(int i5, int i6) {
        get(i5).layout.heightMax = i6;
    }

    public void constrainMaxWidth(int i5, int i6) {
        get(i5).layout.widthMax = i6;
    }

    public void constrainMinHeight(int i5, int i6) {
        get(i5).layout.heightMin = i6;
    }

    public void constrainMinWidth(int i5, int i6) {
        get(i5).layout.widthMin = i6;
    }

    public void constrainPercentHeight(int i5, float f5) {
        get(i5).layout.heightPercent = f5;
    }

    public void constrainPercentWidth(int i5, float f5) {
        get(i5).layout.widthPercent = f5;
    }

    public void constrainWidth(int i5, int i6) {
        get(i5).layout.mWidth = i6;
    }

    public void constrainedHeight(int i5, boolean z4) {
        get(i5).layout.constrainedHeight = z4;
    }

    public void constrainedWidth(int i5, boolean z4) {
        get(i5).layout.constrainedWidth = z4;
    }

    public void create(int i5, int i6) {
        Layout layout = get(i5).layout;
        layout.mIsGuideline = true;
        layout.orientation = i6;
    }

    public void createBarrier(int i5, int i6, int i7, int... iArr) {
        Layout layout = get(i5).layout;
        layout.mHelperType = 1;
        layout.mBarrierDirection = i6;
        layout.mBarrierMargin = i7;
        layout.mIsGuideline = false;
        layout.mReferenceIds = iArr;
    }

    public void createHorizontalChain(int i5, int i6, int i7, int i8, int[] iArr, float[] fArr, int i9) {
        createHorizontalChain(i5, i6, i7, i8, iArr, fArr, i9, 1, 2);
    }

    public void createHorizontalChainRtl(int i5, int i6, int i7, int i8, int[] iArr, float[] fArr, int i9) {
        createHorizontalChain(i5, i6, i7, i8, iArr, fArr, i9, 6, 7);
    }

    public void createVerticalChain(int i5, int i6, int i7, int i8, int[] iArr, float[] fArr, int i9) {
        int[] iArr2 = iArr;
        float[] fArr2 = fArr;
        if (iArr2.length < 2) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        } else if (fArr2 == null || fArr2.length == iArr2.length) {
            if (fArr2 != null) {
                get(iArr2[0]).layout.verticalWeight = fArr2[0];
            }
            get(iArr2[0]).layout.verticalChainStyle = i9;
            connect(iArr2[0], 3, i5, i6, 0);
            for (int i10 = 1; i10 < iArr2.length; i10++) {
                int i11 = i10 - 1;
                connect(iArr2[i10], 3, iArr2[i11], 4, 0);
                connect(iArr2[i11], 4, iArr2[i10], 3, 0);
                if (fArr2 != null) {
                    get(iArr2[i10]).layout.verticalWeight = fArr2[i10];
                }
            }
            connect(iArr2[iArr2.length - 1], 4, i7, i8, 0);
        } else {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
    }

    public void dump(MotionScene motionScene, int... iArr) {
        HashSet hashSet;
        Set<Integer> keySet = this.mConstraints.keySet();
        if (iArr.length != 0) {
            hashSet = new HashSet();
            for (int valueOf : iArr) {
                hashSet.add(Integer.valueOf(valueOf));
            }
        } else {
            hashSet = new HashSet(keySet);
        }
        System.out.println(hashSet.size() + " constraints");
        StringBuilder sb = new StringBuilder();
        for (Integer num : (Integer[]) hashSet.toArray(new Integer[0])) {
            Constraint constraint = this.mConstraints.get(num);
            if (constraint != null) {
                sb.append("<Constraint id=");
                sb.append(num);
                sb.append(" \n");
                constraint.layout.dump(motionScene, sb);
                sb.append("/>\n");
            }
        }
        System.out.println(sb.toString());
    }

    public boolean getApplyElevation(int i5) {
        return get(i5).transform.applyElevation;
    }

    public Constraint getConstraint(int i5) {
        if (this.mConstraints.containsKey(Integer.valueOf(i5))) {
            return this.mConstraints.get(Integer.valueOf(i5));
        }
        return null;
    }

    public HashMap<String, ConstraintAttribute> getCustomAttributeSet() {
        return this.mSavedAttributes;
    }

    public int getHeight(int i5) {
        return get(i5).layout.mHeight;
    }

    public int[] getKnownIds() {
        Integer[] numArr = (Integer[]) this.mConstraints.keySet().toArray(new Integer[0]);
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i5 = 0; i5 < length; i5++) {
            iArr[i5] = numArr[i5].intValue();
        }
        return iArr;
    }

    public Constraint getParameters(int i5) {
        return get(i5);
    }

    public int[] getReferencedIds(int i5) {
        int[] iArr = get(i5).layout.mReferenceIds;
        if (iArr == null) {
            return new int[0];
        }
        return Arrays.copyOf(iArr, iArr.length);
    }

    public String[] getStateLabels() {
        String[] strArr = this.mMatchLabels;
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    public int getVisibility(int i5) {
        return get(i5).propertySet.visibility;
    }

    public int getVisibilityMode(int i5) {
        return get(i5).propertySet.mVisibilityMode;
    }

    public int getWidth(int i5) {
        return get(i5).layout.mWidth;
    }

    public boolean isForceId() {
        return this.mForceId;
    }

    public boolean isValidateOnParse() {
        return this.mValidate;
    }

    public void load(Context context, int i5) {
        XmlResourceParser xml = context.getResources().getXml(i5);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 2) {
                    String name = xml.getName();
                    Constraint fillFromAttributeList = fillFromAttributeList(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        fillFromAttributeList.layout.mIsGuideline = true;
                    }
                    this.mConstraints.put(Integer.valueOf(fillFromAttributeList.mViewId), fillFromAttributeList);
                }
            }
        } catch (XmlPullParserException e5) {
            Log.e(TAG, "Error parsing resource: " + i5, e5);
        } catch (IOException e6) {
            Log.e(TAG, "Error parsing resource: " + i5, e6);
        }
    }

    public boolean matchesLabels(String... strArr) {
        int length = strArr.length;
        int i5 = 0;
        while (i5 < length) {
            String str = strArr[i5];
            String[] strArr2 = this.mMatchLabels;
            int length2 = strArr2.length;
            int i6 = 0;
            while (i6 < length2) {
                if (strArr2[i6].equals(str)) {
                    i5++;
                } else {
                    i6++;
                }
            }
            return false;
        }
        return true;
    }

    public void parseColorAttributes(Constraint constraint, String str) {
        String[] split = str.split(",");
        for (int i5 = 0; i5 < split.length; i5++) {
            String[] split2 = split[i5].split("=");
            if (split2.length != 2) {
                Log.w(TAG, " Unable to parse " + split[i5]);
            } else {
                constraint.setColorValue(split2[0], Color.parseColor(split2[1]));
            }
        }
    }

    public void parseFloatAttributes(Constraint constraint, String str) {
        String[] split = str.split(",");
        for (int i5 = 0; i5 < split.length; i5++) {
            String[] split2 = split[i5].split("=");
            if (split2.length != 2) {
                Log.w(TAG, " Unable to parse " + split[i5]);
            } else {
                constraint.setFloatValue(split2[0], Float.parseFloat(split2[1]));
            }
        }
    }

    public void parseIntAttributes(Constraint constraint, String str) {
        String[] split = str.split(",");
        for (int i5 = 0; i5 < split.length; i5++) {
            String[] split2 = split[i5].split("=");
            if (split2.length != 2) {
                Log.w(TAG, " Unable to parse " + split[i5]);
            } else {
                constraint.setFloatValue(split2[0], (float) Integer.decode(split2[1]).intValue());
            }
        }
    }

    public void parseStringAttributes(Constraint constraint, String str) {
        String[] splitString = splitString(str);
        for (int i5 = 0; i5 < splitString.length; i5++) {
            String[] split = splitString[i5].split("=");
            Log.w(TAG, " Unable to parse " + splitString[i5]);
            constraint.setStringValue(split[0], split[1]);
        }
    }

    public void readFallback(ConstraintSet constraintSet) {
        for (Integer next : constraintSet.mConstraints.keySet()) {
            next.intValue();
            Constraint constraint = constraintSet.mConstraints.get(next);
            if (!this.mConstraints.containsKey(next)) {
                this.mConstraints.put(next, new Constraint());
            }
            Constraint constraint2 = this.mConstraints.get(next);
            if (constraint2 != null) {
                Layout layout = constraint2.layout;
                if (!layout.mApply) {
                    layout.copyFrom(constraint.layout);
                }
                PropertySet propertySet = constraint2.propertySet;
                if (!propertySet.mApply) {
                    propertySet.copyFrom(constraint.propertySet);
                }
                Transform transform = constraint2.transform;
                if (!transform.mApply) {
                    transform.copyFrom(constraint.transform);
                }
                Motion motion = constraint2.motion;
                if (!motion.mApply) {
                    motion.copyFrom(constraint.motion);
                }
                for (String next2 : constraint.mCustomConstraints.keySet()) {
                    if (!constraint2.mCustomConstraints.containsKey(next2)) {
                        constraint2.mCustomConstraints.put(next2, constraint.mCustomConstraints.get(next2));
                    }
                }
            }
        }
    }

    public void removeAttribute(String str) {
        this.mSavedAttributes.remove(str);
    }

    public void removeFromHorizontalChain(int i5) {
        Constraint constraint;
        if (!this.mConstraints.containsKey(Integer.valueOf(i5)) || (constraint = this.mConstraints.get(Integer.valueOf(i5))) == null) {
            return;
        }
        Layout layout = constraint.layout;
        int i6 = layout.leftToRight;
        int i7 = layout.rightToLeft;
        if (i6 == -1 && i7 == -1) {
            int i8 = layout.startToEnd;
            int i9 = layout.endToStart;
            if (!(i8 == -1 && i9 == -1)) {
                if (i8 != -1 && i9 != -1) {
                    connect(i8, 7, i9, 6, 0);
                    connect(i9, 6, i6, 7, 0);
                } else if (i9 != -1) {
                    int i10 = layout.rightToRight;
                    if (i10 != -1) {
                        connect(i6, 7, i10, 7, 0);
                    } else {
                        int i11 = layout.leftToLeft;
                        if (i11 != -1) {
                            connect(i9, 6, i11, 6, 0);
                            clear(i5, 6);
                            clear(i5, 7);
                            return;
                        }
                    }
                }
            }
            clear(i5, 6);
            clear(i5, 7);
            return;
        }
        if (i6 == -1 || i7 == -1) {
            int i12 = i7;
            int i13 = layout.rightToRight;
            if (i13 != -1) {
                connect(i6, 2, i13, 2, 0);
            } else {
                int i14 = layout.leftToLeft;
                if (i14 != -1) {
                    int i15 = i12;
                    connect(i15, 1, i14, 1, 0);
                }
            }
        } else {
            connect(i6, 2, i7, 1, 0);
            int i16 = i7;
            int i17 = i6;
            connect(i16, 1, i17, 2, 0);
        }
        clear(i5, 1);
        clear(i5, 2);
    }

    public void removeFromVerticalChain(int i5) {
        if (this.mConstraints.containsKey(Integer.valueOf(i5))) {
            Constraint constraint = this.mConstraints.get(Integer.valueOf(i5));
            if (constraint != null) {
                Layout layout = constraint.layout;
                int i6 = layout.topToBottom;
                int i7 = layout.bottomToTop;
                if (!(i6 == -1 && i7 == -1)) {
                    if (i6 == -1 || i7 == -1) {
                        int i8 = i7;
                        int i9 = layout.bottomToBottom;
                        if (i9 != -1) {
                            connect(i6, 4, i9, 4, 0);
                        } else {
                            int i10 = layout.topToTop;
                            if (i10 != -1) {
                                int i11 = i8;
                                connect(i11, 3, i10, 3, 0);
                            }
                        }
                        clear(i5, 3);
                        clear(i5, 4);
                    }
                    connect(i6, 4, i7, 3, 0);
                    int i12 = i7;
                    int i13 = i6;
                    connect(i12, 3, i13, 4, 0);
                    clear(i5, 3);
                    clear(i5, 4);
                }
            } else {
                return;
            }
        }
        clear(i5, 3);
        clear(i5, 4);
    }

    public void setAlpha(int i5, float f5) {
        get(i5).propertySet.alpha = f5;
    }

    public void setApplyElevation(int i5, boolean z4) {
        get(i5).transform.applyElevation = z4;
    }

    public void setBarrierType(int i5, int i6) {
        get(i5).layout.mHelperType = i6;
    }

    public void setColorValue(int i5, String str, int i6) {
        get(i5).setColorValue(str, i6);
    }

    public void setDimensionRatio(int i5, String str) {
        get(i5).layout.dimensionRatio = str;
    }

    public void setEditorAbsoluteX(int i5, int i6) {
        get(i5).layout.editorAbsoluteX = i6;
    }

    public void setEditorAbsoluteY(int i5, int i6) {
        get(i5).layout.editorAbsoluteY = i6;
    }

    public void setElevation(int i5, float f5) {
        get(i5).transform.elevation = f5;
        get(i5).transform.applyElevation = true;
    }

    public void setFloatValue(int i5, String str, float f5) {
        get(i5).setFloatValue(str, f5);
    }

    public void setForceId(boolean z4) {
        this.mForceId = z4;
    }

    public void setGoneMargin(int i5, int i6, int i7) {
        Constraint constraint = get(i5);
        switch (i6) {
            case 1:
                constraint.layout.goneLeftMargin = i7;
                return;
            case 2:
                constraint.layout.goneRightMargin = i7;
                return;
            case 3:
                constraint.layout.goneTopMargin = i7;
                return;
            case 4:
                constraint.layout.goneBottomMargin = i7;
                return;
            case 5:
                constraint.layout.goneBaselineMargin = i7;
                return;
            case 6:
                constraint.layout.goneStartMargin = i7;
                return;
            case 7:
                constraint.layout.goneEndMargin = i7;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void setGuidelineBegin(int i5, int i6) {
        get(i5).layout.guideBegin = i6;
        get(i5).layout.guideEnd = -1;
        get(i5).layout.guidePercent = -1.0f;
    }

    public void setGuidelineEnd(int i5, int i6) {
        get(i5).layout.guideEnd = i6;
        get(i5).layout.guideBegin = -1;
        get(i5).layout.guidePercent = -1.0f;
    }

    public void setGuidelinePercent(int i5, float f5) {
        get(i5).layout.guidePercent = f5;
        get(i5).layout.guideEnd = -1;
        get(i5).layout.guideBegin = -1;
    }

    public void setHorizontalBias(int i5, float f5) {
        get(i5).layout.horizontalBias = f5;
    }

    public void setHorizontalChainStyle(int i5, int i6) {
        get(i5).layout.horizontalChainStyle = i6;
    }

    public void setHorizontalWeight(int i5, float f5) {
        get(i5).layout.horizontalWeight = f5;
    }

    public void setIntValue(int i5, String str, int i6) {
        get(i5).setIntValue(str, i6);
    }

    public void setLayoutWrapBehavior(int i5, int i6) {
        if (i6 >= 0 && i6 <= 3) {
            get(i5).layout.mWrapBehavior = i6;
        }
    }

    public void setMargin(int i5, int i6, int i7) {
        Constraint constraint = get(i5);
        switch (i6) {
            case 1:
                constraint.layout.leftMargin = i7;
                return;
            case 2:
                constraint.layout.rightMargin = i7;
                return;
            case 3:
                constraint.layout.topMargin = i7;
                return;
            case 4:
                constraint.layout.bottomMargin = i7;
                return;
            case 5:
                constraint.layout.baselineMargin = i7;
                return;
            case 6:
                constraint.layout.startMargin = i7;
                return;
            case 7:
                constraint.layout.endMargin = i7;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void setReferencedIds(int i5, int... iArr) {
        get(i5).layout.mReferenceIds = iArr;
    }

    public void setRotation(int i5, float f5) {
        get(i5).transform.rotation = f5;
    }

    public void setRotationX(int i5, float f5) {
        get(i5).transform.rotationX = f5;
    }

    public void setRotationY(int i5, float f5) {
        get(i5).transform.rotationY = f5;
    }

    public void setScaleX(int i5, float f5) {
        get(i5).transform.scaleX = f5;
    }

    public void setScaleY(int i5, float f5) {
        get(i5).transform.scaleY = f5;
    }

    public void setStateLabels(String str) {
        this.mMatchLabels = str.split(",");
        int i5 = 0;
        while (true) {
            String[] strArr = this.mMatchLabels;
            if (i5 < strArr.length) {
                strArr[i5] = strArr[i5].trim();
                i5++;
            } else {
                return;
            }
        }
    }

    public void setStateLabelsList(String... strArr) {
        this.mMatchLabels = strArr;
        int i5 = 0;
        while (true) {
            String[] strArr2 = this.mMatchLabels;
            if (i5 < strArr2.length) {
                strArr2[i5] = strArr2[i5].trim();
                i5++;
            } else {
                return;
            }
        }
    }

    public void setStringValue(int i5, String str, String str2) {
        get(i5).setStringValue(str, str2);
    }

    public void setTransformPivot(int i5, float f5, float f6) {
        Transform transform = get(i5).transform;
        transform.transformPivotY = f6;
        transform.transformPivotX = f5;
    }

    public void setTransformPivotX(int i5, float f5) {
        get(i5).transform.transformPivotX = f5;
    }

    public void setTransformPivotY(int i5, float f5) {
        get(i5).transform.transformPivotY = f5;
    }

    public void setTranslation(int i5, float f5, float f6) {
        Transform transform = get(i5).transform;
        transform.translationX = f5;
        transform.translationY = f6;
    }

    public void setTranslationX(int i5, float f5) {
        get(i5).transform.translationX = f5;
    }

    public void setTranslationY(int i5, float f5) {
        get(i5).transform.translationY = f5;
    }

    public void setTranslationZ(int i5, float f5) {
        get(i5).transform.translationZ = f5;
    }

    public void setValidateOnParse(boolean z4) {
        this.mValidate = z4;
    }

    public void setVerticalBias(int i5, float f5) {
        get(i5).layout.verticalBias = f5;
    }

    public void setVerticalChainStyle(int i5, int i6) {
        get(i5).layout.verticalChainStyle = i6;
    }

    public void setVerticalWeight(int i5, float f5) {
        get(i5).layout.verticalWeight = f5;
    }

    public void setVisibility(int i5, int i6) {
        get(i5).propertySet.visibility = i6;
    }

    public void setVisibilityMode(int i5, int i6) {
        get(i5).propertySet.mVisibilityMode = i6;
    }

    public void writeState(Writer writer, ConstraintLayout constraintLayout, int i5) throws IOException {
        writer.write("\n---------------------------------------------\n");
        if ((i5 & 1) == 1) {
            new WriteXmlEngine(writer, constraintLayout, i5).writeLayout();
        } else {
            new WriteJsonEngine(writer, constraintLayout, i5).writeLayout();
        }
        writer.write("\n---------------------------------------------\n");
    }

    private void createHorizontalChain(int i5, int i6, int i7, int i8, int[] iArr, float[] fArr, int i9, int i10, int i11) {
        int[] iArr2 = iArr;
        float[] fArr2 = fArr;
        if (iArr2.length < 2) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        } else if (fArr2 == null || fArr2.length == iArr2.length) {
            if (fArr2 != null) {
                get(iArr2[0]).layout.horizontalWeight = fArr2[0];
            }
            get(iArr2[0]).layout.horizontalChainStyle = i9;
            connect(iArr2[0], i10, i5, i6, -1);
            for (int i12 = 1; i12 < iArr2.length; i12++) {
                int i13 = i12 - 1;
                connect(iArr2[i12], i10, iArr2[i13], i11, -1);
                connect(iArr2[i13], i11, iArr2[i12], i10, -1);
                if (fArr2 != null) {
                    get(iArr2[i12]).layout.horizontalWeight = fArr2[i12];
                }
            }
            connect(iArr2[iArr2.length - 1], i11, i7, i8, -1);
        } else {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
    }

    public void clear(int i5, int i6) {
        Constraint constraint;
        if (this.mConstraints.containsKey(Integer.valueOf(i5)) && (constraint = this.mConstraints.get(Integer.valueOf(i5))) != null) {
            switch (i6) {
                case 1:
                    Layout layout = constraint.layout;
                    layout.leftToRight = -1;
                    layout.leftToLeft = -1;
                    layout.leftMargin = -1;
                    layout.goneLeftMargin = Integer.MIN_VALUE;
                    return;
                case 2:
                    Layout layout2 = constraint.layout;
                    layout2.rightToRight = -1;
                    layout2.rightToLeft = -1;
                    layout2.rightMargin = -1;
                    layout2.goneRightMargin = Integer.MIN_VALUE;
                    return;
                case 3:
                    Layout layout3 = constraint.layout;
                    layout3.topToBottom = -1;
                    layout3.topToTop = -1;
                    layout3.topMargin = 0;
                    layout3.goneTopMargin = Integer.MIN_VALUE;
                    return;
                case 4:
                    Layout layout4 = constraint.layout;
                    layout4.bottomToTop = -1;
                    layout4.bottomToBottom = -1;
                    layout4.bottomMargin = 0;
                    layout4.goneBottomMargin = Integer.MIN_VALUE;
                    return;
                case 5:
                    Layout layout5 = constraint.layout;
                    layout5.baselineToBaseline = -1;
                    layout5.baselineToTop = -1;
                    layout5.baselineToBottom = -1;
                    layout5.baselineMargin = 0;
                    layout5.goneBaselineMargin = Integer.MIN_VALUE;
                    return;
                case 6:
                    Layout layout6 = constraint.layout;
                    layout6.startToEnd = -1;
                    layout6.startToStart = -1;
                    layout6.startMargin = 0;
                    layout6.goneStartMargin = Integer.MIN_VALUE;
                    return;
                case 7:
                    Layout layout7 = constraint.layout;
                    layout7.endToStart = -1;
                    layout7.endToEnd = -1;
                    layout7.endMargin = 0;
                    layout7.goneEndMargin = Integer.MIN_VALUE;
                    return;
                case 8:
                    Layout layout8 = constraint.layout;
                    layout8.circleAngle = -1.0f;
                    layout8.circleRadius = -1;
                    layout8.circleConstraint = -1;
                    return;
                default:
                    throw new IllegalArgumentException("unknown constraint");
            }
        }
    }

    public void clone(ConstraintSet constraintSet) {
        this.mConstraints.clear();
        for (Integer next : constraintSet.mConstraints.keySet()) {
            Constraint constraint = constraintSet.mConstraints.get(next);
            if (constraint != null) {
                this.mConstraints.put(next, constraint.clone());
            }
        }
    }

    class WriteJsonEngine {
        private static final String SPACE = "       ";
        final String mBASELINE = "'baseline'";
        final String mBOTTOM = "'bottom'";
        Context mContext;
        final String mEND = "'end'";
        int mFlags;
        HashMap<Integer, String> mIdMap = new HashMap<>();
        final String mLEFT = "'left'";
        ConstraintLayout mLayout;
        final String mRIGHT = "'right'";
        final String mSTART = "'start'";
        final String mTOP = "'top'";
        int mUnknownCount = 0;
        Writer mWriter;

        WriteJsonEngine(Writer writer, ConstraintLayout constraintLayout, int i5) throws IOException {
            this.mWriter = writer;
            this.mLayout = constraintLayout;
            this.mContext = constraintLayout.getContext();
            this.mFlags = i5;
        }

        private void writeDimension(String str, int i5, int i6, float f5, int i7, int i8, boolean z4) throws IOException {
            if (i5 == 0) {
                if (i8 == -1 && i7 == -1) {
                    if (i6 == 1) {
                        Writer writer = this.mWriter;
                        writer.write(SPACE + str + ": '???????????',\n");
                    } else if (i6 == 2) {
                        Writer writer2 = this.mWriter;
                        writer2.write(SPACE + str + ": '" + f5 + "%',\n");
                    }
                } else if (i6 == 0) {
                    Writer writer3 = this.mWriter;
                    writer3.write(SPACE + str + ": {'spread' ," + i7 + ", " + i8 + "}\n");
                } else if (i6 == 1) {
                    Writer writer4 = this.mWriter;
                    writer4.write(SPACE + str + ": {'wrap' ," + i7 + ", " + i8 + "}\n");
                } else if (i6 == 2) {
                    Writer writer5 = this.mWriter;
                    writer5.write(SPACE + str + ": {'" + f5 + "'% ," + i7 + ", " + i8 + "}\n");
                }
            } else if (i5 == -2) {
                Writer writer6 = this.mWriter;
                writer6.write(SPACE + str + ": 'wrap'\n");
            } else if (i5 == -1) {
                Writer writer7 = this.mWriter;
                writer7.write(SPACE + str + ": 'parent'\n");
            } else {
                Writer writer8 = this.mWriter;
                writer8.write(SPACE + str + ": " + i5 + ",\n");
            }
        }

        private void writeGuideline(int i5, int i6, int i7, float f5) throws IOException {
            writeVariable("'orientation'", i5);
            writeVariable("'guideBegin'", i6);
            writeVariable("'guideEnd'", i7);
            writeVariable("'guidePercent'", f5);
        }

        /* access modifiers changed from: package-private */
        public String getName(int i5) {
            if (this.mIdMap.containsKey(Integer.valueOf(i5))) {
                return "'" + this.mIdMap.get(Integer.valueOf(i5)) + "'";
            } else if (i5 == 0) {
                return "'parent'";
            } else {
                String lookup = lookup(i5);
                this.mIdMap.put(Integer.valueOf(i5), lookup);
                return "'" + lookup + "'";
            }
        }

        /* access modifiers changed from: package-private */
        public String lookup(int i5) {
            if (i5 != -1) {
                try {
                    return this.mContext.getResources().getResourceEntryName(i5);
                } catch (Exception unused) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(EnvironmentCompat.MEDIA_UNKNOWN);
                    int i6 = this.mUnknownCount + 1;
                    this.mUnknownCount = i6;
                    sb.append(i6);
                    return sb.toString();
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(EnvironmentCompat.MEDIA_UNKNOWN);
                int i7 = this.mUnknownCount + 1;
                this.mUnknownCount = i7;
                sb2.append(i7);
                return sb2.toString();
            }
        }

        /* access modifiers changed from: package-private */
        public void writeCircle(int i5, float f5, int i6) throws IOException {
            if (i5 != -1) {
                this.mWriter.write("       circle");
                this.mWriter.write(":[");
                this.mWriter.write(getName(i5));
                Writer writer = this.mWriter;
                writer.write(", " + f5);
                Writer writer2 = this.mWriter;
                writer2.write(i6 + "]");
            }
        }

        /* access modifiers changed from: package-private */
        public void writeConstraint(String str, int i5, String str2, int i6, int i7) throws IOException {
            if (i5 != -1) {
                Writer writer = this.mWriter;
                writer.write(SPACE + str);
                this.mWriter.write(":[");
                this.mWriter.write(getName(i5));
                this.mWriter.write(" , ");
                this.mWriter.write(str2);
                if (i6 != 0) {
                    Writer writer2 = this.mWriter;
                    writer2.write(" , " + i6);
                }
                this.mWriter.write("],\n");
            }
        }

        /* access modifiers changed from: package-private */
        public void writeLayout() throws IOException {
            this.mWriter.write("\n'ConstraintSet':{\n");
            for (Integer num : ConstraintSet.this.mConstraints.keySet()) {
                String name = getName(num.intValue());
                Writer writer = this.mWriter;
                writer.write(name + ":{\n");
                Layout layout = ((Constraint) ConstraintSet.this.mConstraints.get(num)).layout;
                writeDimension("height", layout.mHeight, layout.heightDefault, layout.heightPercent, layout.heightMin, layout.heightMax, layout.constrainedHeight);
                writeDimension("width", layout.mWidth, layout.widthDefault, layout.widthPercent, layout.widthMin, layout.widthMax, layout.constrainedWidth);
                writeConstraint("'left'", layout.leftToLeft, "'left'", layout.leftMargin, layout.goneLeftMargin);
                writeConstraint("'left'", layout.leftToRight, "'right'", layout.leftMargin, layout.goneLeftMargin);
                writeConstraint("'right'", layout.rightToLeft, "'left'", layout.rightMargin, layout.goneRightMargin);
                writeConstraint("'right'", layout.rightToRight, "'right'", layout.rightMargin, layout.goneRightMargin);
                writeConstraint("'baseline'", layout.baselineToBaseline, "'baseline'", -1, layout.goneBaselineMargin);
                writeConstraint("'baseline'", layout.baselineToTop, "'top'", -1, layout.goneBaselineMargin);
                writeConstraint("'baseline'", layout.baselineToBottom, "'bottom'", -1, layout.goneBaselineMargin);
                writeConstraint("'top'", layout.topToBottom, "'bottom'", layout.topMargin, layout.goneTopMargin);
                writeConstraint("'top'", layout.topToTop, "'top'", layout.topMargin, layout.goneTopMargin);
                writeConstraint("'bottom'", layout.bottomToBottom, "'bottom'", layout.bottomMargin, layout.goneBottomMargin);
                writeConstraint("'bottom'", layout.bottomToTop, "'top'", layout.bottomMargin, layout.goneBottomMargin);
                writeConstraint("'start'", layout.startToStart, "'start'", layout.startMargin, layout.goneStartMargin);
                writeConstraint("'start'", layout.startToEnd, "'end'", layout.startMargin, layout.goneStartMargin);
                writeConstraint("'end'", layout.endToStart, "'start'", layout.endMargin, layout.goneEndMargin);
                writeConstraint("'end'", layout.endToEnd, "'end'", layout.endMargin, layout.goneEndMargin);
                writeVariable("'horizontalBias'", layout.horizontalBias, 0.5f);
                writeVariable("'verticalBias'", layout.verticalBias, 0.5f);
                writeCircle(layout.circleConstraint, layout.circleAngle, layout.circleRadius);
                writeGuideline(layout.orientation, layout.guideBegin, layout.guideEnd, layout.guidePercent);
                writeVariable("'dimensionRatio'", layout.dimensionRatio);
                writeVariable("'barrierMargin'", layout.mBarrierMargin);
                writeVariable("'type'", layout.mHelperType);
                writeVariable("'ReferenceId'", layout.mReferenceIdString);
                writeVariable("'mBarrierAllowsGoneWidgets'", layout.mBarrierAllowsGoneWidgets, true);
                writeVariable("'WrapBehavior'", layout.mWrapBehavior);
                writeVariable("'verticalWeight'", layout.verticalWeight);
                writeVariable("'horizontalWeight'", layout.horizontalWeight);
                writeVariable("'horizontalChainStyle'", layout.horizontalChainStyle);
                writeVariable("'verticalChainStyle'", layout.verticalChainStyle);
                writeVariable("'barrierDirection'", layout.mBarrierDirection);
                int[] iArr = layout.mReferenceIds;
                if (iArr != null) {
                    writeVariable("'ReferenceIds'", iArr);
                }
                this.mWriter.write("}\n");
            }
            this.mWriter.write("}\n");
        }

        /* access modifiers changed from: package-private */
        public void writeVariable(String str, int i5) throws IOException {
            if (i5 != 0 && i5 != -1) {
                Writer writer = this.mWriter;
                writer.write(SPACE + str);
                this.mWriter.write(":");
                Writer writer2 = this.mWriter;
                writer2.write(", " + i5);
                this.mWriter.write("\n");
            }
        }

        /* access modifiers changed from: package-private */
        public void writeVariable(String str, float f5) throws IOException {
            if (f5 != -1.0f) {
                Writer writer = this.mWriter;
                writer.write(SPACE + str);
                Writer writer2 = this.mWriter;
                writer2.write(": " + f5);
                this.mWriter.write(",\n");
            }
        }

        /* access modifiers changed from: package-private */
        public void writeVariable(String str, float f5, float f6) throws IOException {
            if (f5 != f6) {
                Writer writer = this.mWriter;
                writer.write(SPACE + str);
                Writer writer2 = this.mWriter;
                writer2.write(": " + f5);
                this.mWriter.write(",\n");
            }
        }

        /* access modifiers changed from: package-private */
        public void writeVariable(String str, boolean z4) throws IOException {
            if (z4) {
                Writer writer = this.mWriter;
                writer.write(SPACE + str);
                Writer writer2 = this.mWriter;
                writer2.write(": " + z4);
                this.mWriter.write(",\n");
            }
        }

        /* access modifiers changed from: package-private */
        public void writeVariable(String str, boolean z4, boolean z5) throws IOException {
            if (z4 != z5) {
                Writer writer = this.mWriter;
                writer.write(SPACE + str);
                Writer writer2 = this.mWriter;
                writer2.write(": " + z4);
                this.mWriter.write(",\n");
            }
        }

        /* access modifiers changed from: package-private */
        public void writeVariable(String str, int[] iArr) throws IOException {
            if (iArr != null) {
                Writer writer = this.mWriter;
                writer.write(SPACE + str);
                this.mWriter.write(": ");
                int i5 = 0;
                while (i5 < iArr.length) {
                    Writer writer2 = this.mWriter;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i5 == 0 ? "[" : ", ");
                    sb.append(getName(iArr[i5]));
                    writer2.write(sb.toString());
                    i5++;
                }
                this.mWriter.write("],\n");
            }
        }

        /* access modifiers changed from: package-private */
        public void writeVariable(String str, String str2) throws IOException {
            if (str2 != null) {
                Writer writer = this.mWriter;
                writer.write(SPACE + str);
                this.mWriter.write(":");
                Writer writer2 = this.mWriter;
                writer2.write(", " + str2);
                this.mWriter.write("\n");
            }
        }
    }

    public void centerHorizontally(int i5, int i6) {
        if (i6 == 0) {
            center(i5, 0, 1, 0, 0, 2, 0, 0.5f);
            return;
        }
        center(i5, i6, 2, 0, i6, 1, 0, 0.5f);
    }

    public void centerHorizontallyRtl(int i5, int i6) {
        if (i6 == 0) {
            center(i5, 0, 6, 0, 0, 7, 0, 0.5f);
            return;
        }
        center(i5, i6, 7, 0, i6, 6, 0, 0.5f);
    }

    public void centerVertically(int i5, int i6) {
        if (i6 == 0) {
            center(i5, 0, 3, 0, 0, 4, 0, 0.5f);
            return;
        }
        center(i5, i6, 4, 0, i6, 3, 0, 0.5f);
    }

    public void clone(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.mConstraints.clear();
        int i5 = 0;
        while (i5 < childCount) {
            View childAt = constraintLayout.getChildAt(i5);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (!this.mForceId || id != -1) {
                if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
                    this.mConstraints.put(Integer.valueOf(id), new Constraint());
                }
                Constraint constraint = this.mConstraints.get(Integer.valueOf(id));
                if (constraint != null) {
                    constraint.mCustomConstraints = ConstraintAttribute.extractAttributes(this.mSavedAttributes, childAt);
                    constraint.fillFrom(id, layoutParams);
                    constraint.propertySet.visibility = childAt.getVisibility();
                    constraint.propertySet.alpha = childAt.getAlpha();
                    constraint.transform.rotation = childAt.getRotation();
                    constraint.transform.rotationX = childAt.getRotationX();
                    constraint.transform.rotationY = childAt.getRotationY();
                    constraint.transform.scaleX = childAt.getScaleX();
                    constraint.transform.scaleY = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (!(((double) pivotX) == 0.0d && ((double) pivotY) == 0.0d)) {
                        Transform transform = constraint.transform;
                        transform.transformPivotX = pivotX;
                        transform.transformPivotY = pivotY;
                    }
                    constraint.transform.translationX = childAt.getTranslationX();
                    constraint.transform.translationY = childAt.getTranslationY();
                    constraint.transform.translationZ = childAt.getTranslationZ();
                    Transform transform2 = constraint.transform;
                    if (transform2.applyElevation) {
                        transform2.elevation = childAt.getElevation();
                    }
                    if (childAt instanceof Barrier) {
                        Barrier barrier = (Barrier) childAt;
                        constraint.layout.mBarrierAllowsGoneWidgets = barrier.getAllowsGoneWidget();
                        constraint.layout.mReferenceIds = barrier.getReferencedIds();
                        constraint.layout.mBarrierDirection = barrier.getType();
                        constraint.layout.mBarrierMargin = barrier.getMargin();
                    }
                }
                i5++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:119:0x01d2, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void load(android.content.Context r12, org.xmlpull.v1.XmlPullParser r13) {
        /*
            r11 = this;
            java.lang.String r0 = "Error parsing XML resource"
            java.lang.String r1 = "ConstraintSet"
            int r2 = r13.getEventType()     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            r3 = 0
            r4 = r3
        L_0x000a:
            r5 = 1
            if (r2 == r5) goto L_0x01df
            if (r2 == 0) goto L_0x01cf
            r6 = -1
            r7 = 3
            r8 = 2
            r9 = 0
            if (r2 == r8) goto L_0x0070
            if (r2 == r7) goto L_0x0019
            goto L_0x01d2
        L_0x0019:
            java.lang.String r2 = r13.getName()     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            java.util.Locale r10 = java.util.Locale.ROOT     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            java.lang.String r2 = r2.toLowerCase(r10)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            int r10 = r2.hashCode()     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            switch(r10) {
                case -2075718416: goto L_0x004f;
                case -190376483: goto L_0x0045;
                case 426575017: goto L_0x003b;
                case 2146106725: goto L_0x002b;
                default: goto L_0x002a;
            }     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
        L_0x002a:
            goto L_0x0058
        L_0x002b:
            java.lang.String r10 = "constraintset"
            boolean r2 = r2.equals(r10)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            if (r2 == 0) goto L_0x0058
            r6 = r9
            goto L_0x0058
        L_0x0035:
            r12 = move-exception
            goto L_0x01d8
        L_0x0038:
            r12 = move-exception
            goto L_0x01dc
        L_0x003b:
            java.lang.String r9 = "constraintoverride"
            boolean r2 = r2.equals(r9)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            if (r2 == 0) goto L_0x0058
            r6 = r8
            goto L_0x0058
        L_0x0045:
            java.lang.String r9 = "constraint"
            boolean r2 = r2.equals(r9)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            if (r2 == 0) goto L_0x0058
            r6 = r5
            goto L_0x0058
        L_0x004f:
            java.lang.String r9 = "guideline"
            boolean r2 = r2.equals(r9)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            if (r2 == 0) goto L_0x0058
            r6 = r7
        L_0x0058:
            if (r6 == 0) goto L_0x01df
            if (r6 == r5) goto L_0x0062
            if (r6 == r8) goto L_0x0062
            if (r6 == r7) goto L_0x0062
            goto L_0x01d2
        L_0x0062:
            java.util.HashMap<java.lang.Integer, androidx.constraintlayout.widget.ConstraintSet$Constraint> r2 = r11.mConstraints     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            int r5 = r4.mViewId     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            r2.put(r5, r4)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            r4 = r3
            goto L_0x01d2
        L_0x0070:
            java.lang.String r2 = r13.getName()     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            int r10 = r2.hashCode()     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            switch(r10) {
                case -2025855158: goto L_0x00d9;
                case -1984451626: goto L_0x00cf;
                case -1962203927: goto L_0x00c5;
                case -1269513683: goto L_0x00bb;
                case -1238332596: goto L_0x00b1;
                case -71750448: goto L_0x00a7;
                case 366511058: goto L_0x009c;
                case 1331510167: goto L_0x0092;
                case 1791837707: goto L_0x0087;
                case 1803088381: goto L_0x007d;
                default: goto L_0x007b;
            }     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
        L_0x007b:
            goto L_0x00e2
        L_0x007d:
            java.lang.String r7 = "Constraint"
            boolean r2 = r2.equals(r7)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            if (r2 == 0) goto L_0x00e2
            r6 = r9
            goto L_0x00e2
        L_0x0087:
            java.lang.String r7 = "CustomAttribute"
            boolean r2 = r2.equals(r7)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            if (r2 == 0) goto L_0x00e2
            r6 = 8
            goto L_0x00e2
        L_0x0092:
            java.lang.String r8 = "Barrier"
            boolean r2 = r2.equals(r8)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            if (r2 == 0) goto L_0x00e2
            r6 = r7
            goto L_0x00e2
        L_0x009c:
            java.lang.String r7 = "CustomMethod"
            boolean r2 = r2.equals(r7)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            if (r2 == 0) goto L_0x00e2
            r6 = 9
            goto L_0x00e2
        L_0x00a7:
            java.lang.String r7 = "Guideline"
            boolean r2 = r2.equals(r7)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            if (r2 == 0) goto L_0x00e2
            r6 = r8
            goto L_0x00e2
        L_0x00b1:
            java.lang.String r7 = "Transform"
            boolean r2 = r2.equals(r7)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            if (r2 == 0) goto L_0x00e2
            r6 = 5
            goto L_0x00e2
        L_0x00bb:
            java.lang.String r7 = "PropertySet"
            boolean r2 = r2.equals(r7)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            if (r2 == 0) goto L_0x00e2
            r6 = 4
            goto L_0x00e2
        L_0x00c5:
            java.lang.String r7 = "ConstraintOverride"
            boolean r2 = r2.equals(r7)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            if (r2 == 0) goto L_0x00e2
            r6 = r5
            goto L_0x00e2
        L_0x00cf:
            java.lang.String r7 = "Motion"
            boolean r2 = r2.equals(r7)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            if (r2 == 0) goto L_0x00e2
            r6 = 7
            goto L_0x00e2
        L_0x00d9:
            java.lang.String r7 = "Layout"
            boolean r2 = r2.equals(r7)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            if (r2 == 0) goto L_0x00e2
            r6 = 6
        L_0x00e2:
            java.lang.String r2 = "XML parser error must be within a Constraint "
            switch(r6) {
                case 0: goto L_0x01c6;
                case 1: goto L_0x01bd;
                case 2: goto L_0x01ae;
                case 3: goto L_0x01a1;
                case 4: goto L_0x017c;
                case 5: goto L_0x0157;
                case 6: goto L_0x0131;
                case 7: goto L_0x010b;
                case 8: goto L_0x00e9;
                case 9: goto L_0x00e9;
                default: goto L_0x00e7;
            }
        L_0x00e7:
            goto L_0x01d2
        L_0x00e9:
            if (r4 == 0) goto L_0x00f2
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r2 = r4.mCustomConstraints     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            androidx.constraintlayout.widget.ConstraintAttribute.parse(r12, r13, r2)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            goto L_0x01d2
        L_0x00f2:
            java.lang.RuntimeException r12 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            r3.<init>()     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            r3.append(r2)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            int r13 = r13.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            r3.append(r13)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            java.lang.String r13 = r3.toString()     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            r12.<init>(r13)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            throw r12     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
        L_0x010b:
            if (r4 == 0) goto L_0x0118
            androidx.constraintlayout.widget.ConstraintSet$Motion r2 = r4.motion     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            android.util.AttributeSet r5 = android.util.Xml.asAttributeSet(r13)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            r2.fillFromAttributeList(r12, r5)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            goto L_0x01d2
        L_0x0118:
            java.lang.RuntimeException r12 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            r3.<init>()     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            r3.append(r2)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            int r13 = r13.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            r3.append(r13)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            java.lang.String r13 = r3.toString()     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            r12.<init>(r13)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            throw r12     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
        L_0x0131:
            if (r4 == 0) goto L_0x013e
            androidx.constraintlayout.widget.ConstraintSet$Layout r2 = r4.layout     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            android.util.AttributeSet r5 = android.util.Xml.asAttributeSet(r13)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            r2.fillFromAttributeList(r12, r5)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            goto L_0x01d2
        L_0x013e:
            java.lang.RuntimeException r12 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            r3.<init>()     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            r3.append(r2)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            int r13 = r13.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            r3.append(r13)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            java.lang.String r13 = r3.toString()     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            r12.<init>(r13)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            throw r12     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
        L_0x0157:
            if (r4 == 0) goto L_0x0163
            androidx.constraintlayout.widget.ConstraintSet$Transform r2 = r4.transform     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            android.util.AttributeSet r5 = android.util.Xml.asAttributeSet(r13)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            r2.fillFromAttributeList(r12, r5)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            goto L_0x01d2
        L_0x0163:
            java.lang.RuntimeException r12 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            r3.<init>()     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            r3.append(r2)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            int r13 = r13.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            r3.append(r13)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            java.lang.String r13 = r3.toString()     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            r12.<init>(r13)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            throw r12     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
        L_0x017c:
            if (r4 == 0) goto L_0x0188
            androidx.constraintlayout.widget.ConstraintSet$PropertySet r2 = r4.propertySet     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            android.util.AttributeSet r5 = android.util.Xml.asAttributeSet(r13)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            r2.fillFromAttributeList(r12, r5)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            goto L_0x01d2
        L_0x0188:
            java.lang.RuntimeException r12 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            r3.<init>()     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            r3.append(r2)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            int r13 = r13.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            r3.append(r13)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            java.lang.String r13 = r3.toString()     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            r12.<init>(r13)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            throw r12     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
        L_0x01a1:
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r13)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            androidx.constraintlayout.widget.ConstraintSet$Constraint r4 = r11.fillFromAttributeList(r12, r2, r9)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            androidx.constraintlayout.widget.ConstraintSet$Layout r2 = r4.layout     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            r2.mHelperType = r5     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            goto L_0x01d2
        L_0x01ae:
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r13)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            androidx.constraintlayout.widget.ConstraintSet$Constraint r4 = r11.fillFromAttributeList(r12, r2, r9)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            androidx.constraintlayout.widget.ConstraintSet$Layout r2 = r4.layout     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            r2.mIsGuideline = r5     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            r2.mApply = r5     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            goto L_0x01d2
        L_0x01bd:
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r13)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            androidx.constraintlayout.widget.ConstraintSet$Constraint r4 = r11.fillFromAttributeList(r12, r2, r5)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            goto L_0x01d2
        L_0x01c6:
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r13)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            androidx.constraintlayout.widget.ConstraintSet$Constraint r4 = r11.fillFromAttributeList(r12, r2, r9)     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            goto L_0x01d2
        L_0x01cf:
            r13.getName()     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
        L_0x01d2:
            int r2 = r13.next()     // Catch:{ XmlPullParserException -> 0x0038, IOException -> 0x0035 }
            goto L_0x000a
        L_0x01d8:
            android.util.Log.e(r1, r0, r12)
            goto L_0x01df
        L_0x01dc:
            android.util.Log.e(r1, r0, r12)
        L_0x01df:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintSet.load(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public void readFallback(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        int i5 = 0;
        while (i5 < childCount) {
            View childAt = constraintLayout.getChildAt(i5);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (!this.mForceId || id != -1) {
                if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
                    this.mConstraints.put(Integer.valueOf(id), new Constraint());
                }
                Constraint constraint = this.mConstraints.get(Integer.valueOf(id));
                if (constraint != null) {
                    if (!constraint.layout.mApply) {
                        constraint.fillFrom(id, layoutParams);
                        if (childAt instanceof ConstraintHelper) {
                            constraint.layout.mReferenceIds = ((ConstraintHelper) childAt).getReferencedIds();
                            if (childAt instanceof Barrier) {
                                Barrier barrier = (Barrier) childAt;
                                constraint.layout.mBarrierAllowsGoneWidgets = barrier.getAllowsGoneWidget();
                                constraint.layout.mBarrierDirection = barrier.getType();
                                constraint.layout.mBarrierMargin = barrier.getMargin();
                            }
                        }
                        constraint.layout.mApply = true;
                    }
                    PropertySet propertySet = constraint.propertySet;
                    if (!propertySet.mApply) {
                        propertySet.visibility = childAt.getVisibility();
                        constraint.propertySet.alpha = childAt.getAlpha();
                        constraint.propertySet.mApply = true;
                    }
                    Transform transform = constraint.transform;
                    if (!transform.mApply) {
                        transform.mApply = true;
                        transform.rotation = childAt.getRotation();
                        constraint.transform.rotationX = childAt.getRotationX();
                        constraint.transform.rotationY = childAt.getRotationY();
                        constraint.transform.scaleX = childAt.getScaleX();
                        constraint.transform.scaleY = childAt.getScaleY();
                        float pivotX = childAt.getPivotX();
                        float pivotY = childAt.getPivotY();
                        if (!(((double) pivotX) == 0.0d && ((double) pivotY) == 0.0d)) {
                            Transform transform2 = constraint.transform;
                            transform2.transformPivotX = pivotX;
                            transform2.transformPivotY = pivotY;
                        }
                        constraint.transform.translationX = childAt.getTranslationX();
                        constraint.transform.translationY = childAt.getTranslationY();
                        constraint.transform.translationZ = childAt.getTranslationZ();
                        Transform transform3 = constraint.transform;
                        if (transform3.applyElevation) {
                            transform3.elevation = childAt.getElevation();
                        }
                    }
                }
                i5++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    /* access modifiers changed from: private */
    public static void setDeltaValue(Constraint constraint, int i5, int i6) {
        if (i5 == 6) {
            constraint.layout.editorAbsoluteX = i6;
        } else if (i5 == 7) {
            constraint.layout.editorAbsoluteY = i6;
        } else if (i5 == 8) {
            constraint.layout.endMargin = i6;
        } else if (i5 == 27) {
            constraint.layout.orientation = i6;
        } else if (i5 == 28) {
            constraint.layout.rightMargin = i6;
        } else if (i5 == 41) {
            constraint.layout.horizontalChainStyle = i6;
        } else if (i5 == 42) {
            constraint.layout.verticalChainStyle = i6;
        } else if (i5 == 61) {
            constraint.layout.circleConstraint = i6;
        } else if (i5 == 62) {
            constraint.layout.circleRadius = i6;
        } else if (i5 == 72) {
            constraint.layout.mBarrierDirection = i6;
        } else if (i5 != 73) {
            switch (i5) {
                case 2:
                    constraint.layout.bottomMargin = i6;
                    return;
                case 11:
                    constraint.layout.goneBottomMargin = i6;
                    return;
                case 12:
                    constraint.layout.goneEndMargin = i6;
                    return;
                case 13:
                    constraint.layout.goneLeftMargin = i6;
                    return;
                case 14:
                    constraint.layout.goneRightMargin = i6;
                    return;
                case 15:
                    constraint.layout.goneStartMargin = i6;
                    return;
                case 16:
                    constraint.layout.goneTopMargin = i6;
                    return;
                case 17:
                    constraint.layout.guideBegin = i6;
                    return;
                case 18:
                    constraint.layout.guideEnd = i6;
                    return;
                case 31:
                    constraint.layout.startMargin = i6;
                    return;
                case 34:
                    constraint.layout.topMargin = i6;
                    return;
                case 38:
                    constraint.mViewId = i6;
                    return;
                case 64:
                    constraint.motion.mAnimateRelativeTo = i6;
                    return;
                case 66:
                    constraint.motion.mDrawPath = i6;
                    return;
                case 76:
                    constraint.motion.mPathMotionArc = i6;
                    return;
                case 78:
                    constraint.propertySet.mVisibilityMode = i6;
                    return;
                case 93:
                    constraint.layout.baselineMargin = i6;
                    return;
                case 94:
                    constraint.layout.goneBaselineMargin = i6;
                    return;
                case 97:
                    constraint.layout.mWrapBehavior = i6;
                    return;
                default:
                    switch (i5) {
                        case 21:
                            constraint.layout.mHeight = i6;
                            return;
                        case 22:
                            constraint.propertySet.visibility = i6;
                            return;
                        case 23:
                            constraint.layout.mWidth = i6;
                            return;
                        case 24:
                            constraint.layout.leftMargin = i6;
                            return;
                        default:
                            switch (i5) {
                                case 54:
                                    constraint.layout.widthDefault = i6;
                                    return;
                                case 55:
                                    constraint.layout.heightDefault = i6;
                                    return;
                                case 56:
                                    constraint.layout.widthMax = i6;
                                    return;
                                case 57:
                                    constraint.layout.heightMax = i6;
                                    return;
                                case 58:
                                    constraint.layout.widthMin = i6;
                                    return;
                                case 59:
                                    constraint.layout.heightMin = i6;
                                    return;
                                default:
                                    switch (i5) {
                                        case 82:
                                            constraint.motion.mAnimateCircleAngleTo = i6;
                                            return;
                                        case 83:
                                            constraint.transform.transformPivotTarget = i6;
                                            return;
                                        case 84:
                                            constraint.motion.mQuantizeMotionSteps = i6;
                                            return;
                                        default:
                                            switch (i5) {
                                                case 87:
                                                    return;
                                                case 88:
                                                    constraint.motion.mQuantizeInterpolatorType = i6;
                                                    return;
                                                case 89:
                                                    constraint.motion.mQuantizeInterpolatorID = i6;
                                                    return;
                                                default:
                                                    Log.w(TAG, "Unknown attribute 0x");
                                                    return;
                                            }
                                    }
                            }
                    }
            }
        } else {
            constraint.layout.mBarrierMargin = i6;
        }
    }

    public void clone(Constraints constraints) {
        int childCount = constraints.getChildCount();
        this.mConstraints.clear();
        int i5 = 0;
        while (i5 < childCount) {
            View childAt = constraints.getChildAt(i5);
            Constraints.LayoutParams layoutParams = (Constraints.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (!this.mForceId || id != -1) {
                if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
                    this.mConstraints.put(Integer.valueOf(id), new Constraint());
                }
                Constraint constraint = this.mConstraints.get(Integer.valueOf(id));
                if (constraint != null) {
                    if (childAt instanceof ConstraintHelper) {
                        constraint.fillFromConstraints((ConstraintHelper) childAt, id, layoutParams);
                    }
                    constraint.fillFromConstraints(id, layoutParams);
                }
                i5++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    /* access modifiers changed from: private */
    public static void setDeltaValue(Constraint constraint, int i5, String str) {
        if (i5 == 5) {
            constraint.layout.dimensionRatio = str;
        } else if (i5 == 65) {
            constraint.motion.mTransitionEasing = str;
        } else if (i5 == 74) {
            Layout layout = constraint.layout;
            layout.mReferenceIdString = str;
            layout.mReferenceIds = null;
        } else if (i5 == 77) {
            constraint.layout.mConstraintTag = str;
        } else if (i5 == 87) {
        } else {
            if (i5 != 90) {
                Log.w(TAG, "Unknown attribute 0x");
            } else {
                constraint.motion.mQuantizeInterpolatorString = str;
            }
        }
    }

    public void connect(int i5, int i6, int i7, int i8) {
        if (!this.mConstraints.containsKey(Integer.valueOf(i5))) {
            this.mConstraints.put(Integer.valueOf(i5), new Constraint());
        }
        Constraint constraint = this.mConstraints.get(Integer.valueOf(i5));
        if (constraint != null) {
            switch (i6) {
                case 1:
                    if (i8 == 1) {
                        Layout layout = constraint.layout;
                        layout.leftToLeft = i7;
                        layout.leftToRight = -1;
                        return;
                    } else if (i8 == 2) {
                        Layout layout2 = constraint.layout;
                        layout2.leftToRight = i7;
                        layout2.leftToLeft = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("left to " + sideToString(i8) + " undefined");
                    }
                case 2:
                    if (i8 == 1) {
                        Layout layout3 = constraint.layout;
                        layout3.rightToLeft = i7;
                        layout3.rightToRight = -1;
                        return;
                    } else if (i8 == 2) {
                        Layout layout4 = constraint.layout;
                        layout4.rightToRight = i7;
                        layout4.rightToLeft = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i8) + " undefined");
                    }
                case 3:
                    if (i8 == 3) {
                        Layout layout5 = constraint.layout;
                        layout5.topToTop = i7;
                        layout5.topToBottom = -1;
                        layout5.baselineToBaseline = -1;
                        layout5.baselineToTop = -1;
                        layout5.baselineToBottom = -1;
                        return;
                    } else if (i8 == 4) {
                        Layout layout6 = constraint.layout;
                        layout6.topToBottom = i7;
                        layout6.topToTop = -1;
                        layout6.baselineToBaseline = -1;
                        layout6.baselineToTop = -1;
                        layout6.baselineToBottom = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i8) + " undefined");
                    }
                case 4:
                    if (i8 == 4) {
                        Layout layout7 = constraint.layout;
                        layout7.bottomToBottom = i7;
                        layout7.bottomToTop = -1;
                        layout7.baselineToBaseline = -1;
                        layout7.baselineToTop = -1;
                        layout7.baselineToBottom = -1;
                        return;
                    } else if (i8 == 3) {
                        Layout layout8 = constraint.layout;
                        layout8.bottomToTop = i7;
                        layout8.bottomToBottom = -1;
                        layout8.baselineToBaseline = -1;
                        layout8.baselineToTop = -1;
                        layout8.baselineToBottom = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i8) + " undefined");
                    }
                case 5:
                    if (i8 == 5) {
                        Layout layout9 = constraint.layout;
                        layout9.baselineToBaseline = i7;
                        layout9.bottomToBottom = -1;
                        layout9.bottomToTop = -1;
                        layout9.topToTop = -1;
                        layout9.topToBottom = -1;
                        return;
                    } else if (i8 == 3) {
                        Layout layout10 = constraint.layout;
                        layout10.baselineToTop = i7;
                        layout10.bottomToBottom = -1;
                        layout10.bottomToTop = -1;
                        layout10.topToTop = -1;
                        layout10.topToBottom = -1;
                        return;
                    } else if (i8 == 4) {
                        Layout layout11 = constraint.layout;
                        layout11.baselineToBottom = i7;
                        layout11.bottomToBottom = -1;
                        layout11.bottomToTop = -1;
                        layout11.topToTop = -1;
                        layout11.topToBottom = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i8) + " undefined");
                    }
                case 6:
                    if (i8 == 6) {
                        Layout layout12 = constraint.layout;
                        layout12.startToStart = i7;
                        layout12.startToEnd = -1;
                        return;
                    } else if (i8 == 7) {
                        Layout layout13 = constraint.layout;
                        layout13.startToEnd = i7;
                        layout13.startToStart = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i8) + " undefined");
                    }
                case 7:
                    if (i8 == 7) {
                        Layout layout14 = constraint.layout;
                        layout14.endToEnd = i7;
                        layout14.endToStart = -1;
                        return;
                    } else if (i8 == 6) {
                        Layout layout15 = constraint.layout;
                        layout15.endToStart = i7;
                        layout15.endToEnd = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i8) + " undefined");
                    }
                default:
                    throw new IllegalArgumentException(sideToString(i6) + " to " + sideToString(i8) + " unknown");
            }
        }
    }

    /* access modifiers changed from: private */
    public static void setDeltaValue(Constraint constraint, int i5, boolean z4) {
        if (i5 == 44) {
            constraint.transform.applyElevation = z4;
        } else if (i5 == 75) {
            constraint.layout.mBarrierAllowsGoneWidgets = z4;
        } else if (i5 == 87) {
        } else {
            if (i5 == 80) {
                constraint.layout.constrainedWidth = z4;
            } else if (i5 != 81) {
                Log.w(TAG, "Unknown attribute 0x");
            } else {
                constraint.layout.constrainedHeight = z4;
            }
        }
    }
}
