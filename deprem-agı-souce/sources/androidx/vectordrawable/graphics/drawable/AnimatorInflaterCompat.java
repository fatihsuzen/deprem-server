package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import androidx.annotation.AnimatorRes;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class AnimatorInflaterCompat {
    private static final boolean DBG_ANIMATOR_INFLATER = false;
    private static final int MAX_NUM_POINTS = 100;
    private static final String TAG = "AnimatorInflater";
    private static final int TOGETHER = 0;
    private static final int VALUE_TYPE_COLOR = 3;
    private static final int VALUE_TYPE_FLOAT = 0;
    private static final int VALUE_TYPE_INT = 1;
    private static final int VALUE_TYPE_PATH = 2;
    private static final int VALUE_TYPE_UNDEFINED = 4;

    private static class PathDataEvaluator implements TypeEvaluator<PathParser.PathDataNode[]> {
        private PathParser.PathDataNode[] mNodeArray;

        PathDataEvaluator() {
        }

        PathDataEvaluator(PathParser.PathDataNode[] pathDataNodeArr) {
            this.mNodeArray = pathDataNodeArr;
        }

        public PathParser.PathDataNode[] evaluate(float f5, PathParser.PathDataNode[] pathDataNodeArr, PathParser.PathDataNode[] pathDataNodeArr2) {
            if (PathParser.canMorph(pathDataNodeArr, pathDataNodeArr2)) {
                if (!PathParser.canMorph(this.mNodeArray, pathDataNodeArr)) {
                    this.mNodeArray = PathParser.deepCopyNodes(pathDataNodeArr);
                }
                for (int i5 = 0; i5 < pathDataNodeArr.length; i5++) {
                    this.mNodeArray[i5].interpolatePathDataNode(pathDataNodeArr[i5], pathDataNodeArr2[i5], f5);
                }
                return this.mNodeArray;
            }
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    private AnimatorInflaterCompat() {
    }

    private static Animator createAnimatorFromXml(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, float f5) throws XmlPullParserException, IOException {
        return createAnimatorFromXml(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser), (AnimatorSet) null, 0, f5);
    }

    private static Keyframe createNewKeyframe(Keyframe keyframe, float f5) {
        if (keyframe.getType() == Float.TYPE) {
            return Keyframe.ofFloat(f5);
        }
        if (keyframe.getType() == Integer.TYPE) {
            return Keyframe.ofInt(f5);
        }
        return Keyframe.ofObject(f5);
    }

    private static void distributeKeyframes(Keyframe[] keyframeArr, float f5, int i5, int i6) {
        float f6 = f5 / ((float) ((i6 - i5) + 2));
        while (i5 <= i6) {
            keyframeArr[i5].setFraction(keyframeArr[i5 - 1].getFraction() + f6);
            i5++;
        }
    }

    private static void dumpKeyframes(Object[] objArr, String str) {
        Object obj;
        if (objArr != null && objArr.length != 0) {
            Log.d(TAG, str);
            int length = objArr.length;
            for (int i5 = 0; i5 < length; i5++) {
                Keyframe keyframe = objArr[i5];
                StringBuilder sb = new StringBuilder();
                sb.append("Keyframe ");
                sb.append(i5);
                sb.append(": fraction ");
                Object obj2 = "null";
                if (keyframe.getFraction() < 0.0f) {
                    obj = obj2;
                } else {
                    obj = Float.valueOf(keyframe.getFraction());
                }
                sb.append(obj);
                sb.append(", , value : ");
                if (keyframe.hasValue()) {
                    obj2 = keyframe.getValue();
                }
                sb.append(obj2);
                Log.d(TAG, sb.toString());
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v28, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v31, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.animation.PropertyValuesHolder getPVH(android.content.res.TypedArray r11, int r12, int r13, int r14, java.lang.String r15) {
        /*
            android.util.TypedValue r0 = r11.peekValue(r13)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x000a
            r3 = r1
            goto L_0x000b
        L_0x000a:
            r3 = r2
        L_0x000b:
            if (r3 == 0) goto L_0x0010
            int r0 = r0.type
            goto L_0x0011
        L_0x0010:
            r0 = r2
        L_0x0011:
            android.util.TypedValue r4 = r11.peekValue(r14)
            if (r4 == 0) goto L_0x0019
            r5 = r1
            goto L_0x001a
        L_0x0019:
            r5 = r2
        L_0x001a:
            if (r5 == 0) goto L_0x001f
            int r4 = r4.type
            goto L_0x0020
        L_0x001f:
            r4 = r2
        L_0x0020:
            r6 = 4
            r7 = 3
            if (r12 != r6) goto L_0x0037
            if (r3 == 0) goto L_0x002c
            boolean r12 = isColorType(r0)
            if (r12 != 0) goto L_0x0034
        L_0x002c:
            if (r5 == 0) goto L_0x0036
            boolean r12 = isColorType(r4)
            if (r12 == 0) goto L_0x0036
        L_0x0034:
            r12 = r7
            goto L_0x0037
        L_0x0036:
            r12 = r2
        L_0x0037:
            if (r12 != 0) goto L_0x003b
            r6 = r1
            goto L_0x003c
        L_0x003b:
            r6 = r2
        L_0x003c:
            r8 = 2
            r9 = 0
            if (r12 != r8) goto L_0x00a7
            java.lang.String r12 = r11.getString(r13)
            java.lang.String r11 = r11.getString(r14)
            androidx.core.graphics.PathParser$PathDataNode[] r13 = androidx.core.graphics.PathParser.createNodesFromPathData(r12)
            androidx.core.graphics.PathParser$PathDataNode[] r14 = androidx.core.graphics.PathParser.createNodesFromPathData(r11)
            if (r13 != 0) goto L_0x0054
            if (r14 == 0) goto L_0x00a6
        L_0x0054:
            if (r13 == 0) goto L_0x0096
            androidx.vectordrawable.graphics.drawable.AnimatorInflaterCompat$PathDataEvaluator r0 = new androidx.vectordrawable.graphics.drawable.AnimatorInflaterCompat$PathDataEvaluator
            r0.<init>()
            if (r14 == 0) goto L_0x008d
            boolean r3 = androidx.core.graphics.PathParser.canMorph(r13, r14)
            if (r3 == 0) goto L_0x006e
            java.lang.Object[] r11 = new java.lang.Object[r8]
            r11[r2] = r13
            r11[r1] = r14
            android.animation.PropertyValuesHolder r11 = android.animation.PropertyValuesHolder.ofObject(r15, r0, r11)
            return r11
        L_0x006e:
            android.view.InflateException r13 = new android.view.InflateException
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = " Can't morph from "
            r14.append(r15)
            r14.append(r12)
            java.lang.String r12 = " to "
            r14.append(r12)
            r14.append(r11)
            java.lang.String r11 = r14.toString()
            r13.<init>(r11)
            throw r13
        L_0x008d:
            java.lang.Object[] r11 = new java.lang.Object[r1]
            r11[r2] = r13
            android.animation.PropertyValuesHolder r11 = android.animation.PropertyValuesHolder.ofObject(r15, r0, r11)
            return r11
        L_0x0096:
            if (r14 == 0) goto L_0x00a6
            androidx.vectordrawable.graphics.drawable.AnimatorInflaterCompat$PathDataEvaluator r11 = new androidx.vectordrawable.graphics.drawable.AnimatorInflaterCompat$PathDataEvaluator
            r11.<init>()
            java.lang.Object[] r12 = new java.lang.Object[r1]
            r12[r2] = r14
            android.animation.PropertyValuesHolder r11 = android.animation.PropertyValuesHolder.ofObject(r15, r11, r12)
            return r11
        L_0x00a6:
            return r9
        L_0x00a7:
            if (r12 != r7) goto L_0x00ae
            androidx.vectordrawable.graphics.drawable.ArgbEvaluator r12 = androidx.vectordrawable.graphics.drawable.ArgbEvaluator.getInstance()
            goto L_0x00af
        L_0x00ae:
            r12 = r9
        L_0x00af:
            r7 = 5
            r10 = 0
            if (r6 == 0) goto L_0x00f7
            if (r3 == 0) goto L_0x00e3
            if (r0 != r7) goto L_0x00bc
            float r13 = r11.getDimension(r13, r10)
            goto L_0x00c0
        L_0x00bc:
            float r13 = r11.getFloat(r13, r10)
        L_0x00c0:
            if (r5 == 0) goto L_0x00da
            if (r4 != r7) goto L_0x00c9
            float r11 = r11.getDimension(r14, r10)
            goto L_0x00cd
        L_0x00c9:
            float r11 = r11.getFloat(r14, r10)
        L_0x00cd:
            float[] r14 = new float[r8]
            r14[r2] = r13
            r14[r1] = r11
            android.animation.PropertyValuesHolder r11 = android.animation.PropertyValuesHolder.ofFloat(r15, r14)
        L_0x00d7:
            r9 = r11
            goto L_0x015c
        L_0x00da:
            float[] r11 = new float[r1]
            r11[r2] = r13
            android.animation.PropertyValuesHolder r11 = android.animation.PropertyValuesHolder.ofFloat(r15, r11)
            goto L_0x00d7
        L_0x00e3:
            if (r4 != r7) goto L_0x00ea
            float r11 = r11.getDimension(r14, r10)
            goto L_0x00ee
        L_0x00ea:
            float r11 = r11.getFloat(r14, r10)
        L_0x00ee:
            float[] r13 = new float[r1]
            r13[r2] = r11
            android.animation.PropertyValuesHolder r11 = android.animation.PropertyValuesHolder.ofFloat(r15, r13)
            goto L_0x00d7
        L_0x00f7:
            if (r3 == 0) goto L_0x013b
            if (r0 != r7) goto L_0x0101
            float r13 = r11.getDimension(r13, r10)
            int r13 = (int) r13
            goto L_0x0110
        L_0x0101:
            boolean r0 = isColorType(r0)
            if (r0 == 0) goto L_0x010c
            int r13 = r11.getColor(r13, r2)
            goto L_0x0110
        L_0x010c:
            int r13 = r11.getInt(r13, r2)
        L_0x0110:
            if (r5 == 0) goto L_0x0132
            if (r4 != r7) goto L_0x011a
            float r11 = r11.getDimension(r14, r10)
            int r11 = (int) r11
            goto L_0x0129
        L_0x011a:
            boolean r0 = isColorType(r4)
            if (r0 == 0) goto L_0x0125
            int r11 = r11.getColor(r14, r2)
            goto L_0x0129
        L_0x0125:
            int r11 = r11.getInt(r14, r2)
        L_0x0129:
            int[] r11 = new int[]{r13, r11}
            android.animation.PropertyValuesHolder r9 = android.animation.PropertyValuesHolder.ofInt(r15, r11)
            goto L_0x015c
        L_0x0132:
            int[] r11 = new int[]{r13}
            android.animation.PropertyValuesHolder r9 = android.animation.PropertyValuesHolder.ofInt(r15, r11)
            goto L_0x015c
        L_0x013b:
            if (r5 == 0) goto L_0x015c
            if (r4 != r7) goto L_0x0145
            float r11 = r11.getDimension(r14, r10)
            int r11 = (int) r11
            goto L_0x0154
        L_0x0145:
            boolean r13 = isColorType(r4)
            if (r13 == 0) goto L_0x0150
            int r11 = r11.getColor(r14, r2)
            goto L_0x0154
        L_0x0150:
            int r11 = r11.getInt(r14, r2)
        L_0x0154:
            int[] r11 = new int[]{r11}
            android.animation.PropertyValuesHolder r9 = android.animation.PropertyValuesHolder.ofInt(r15, r11)
        L_0x015c:
            if (r9 == 0) goto L_0x0163
            if (r12 == 0) goto L_0x0163
            r9.setEvaluator(r12)
        L_0x0163:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.AnimatorInflaterCompat.getPVH(android.content.res.TypedArray, int, int, int, java.lang.String):android.animation.PropertyValuesHolder");
    }

    private static int inferValueTypeFromValues(TypedArray typedArray, int i5, int i6) {
        boolean z4;
        int i7;
        int i8;
        TypedValue peekValue = typedArray.peekValue(i5);
        boolean z5 = true;
        if (peekValue != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            i7 = peekValue.type;
        } else {
            i7 = 0;
        }
        TypedValue peekValue2 = typedArray.peekValue(i6);
        if (peekValue2 == null) {
            z5 = false;
        }
        if (z5) {
            i8 = peekValue2.type;
        } else {
            i8 = 0;
        }
        if (z4 && isColorType(i7)) {
            return 3;
        }
        if (!z5 || !isColorType(i8)) {
            return 0;
        }
        return 3;
    }

    private static int inferValueTypeOfKeyframe(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_KEYFRAME);
        int i5 = 0;
        TypedValue peekNamedValue = TypedArrayUtils.peekNamedValue(obtainAttributes, xmlPullParser, "value", 0);
        if (peekNamedValue != null && isColorType(peekNamedValue.type)) {
            i5 = 3;
        }
        obtainAttributes.recycle();
        return i5;
    }

    private static boolean isColorType(int i5) {
        return i5 >= 28 && i5 <= 31;
    }

    public static Animator loadAnimator(Context context, @AnimatorRes int i5) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 24) {
            return AnimatorInflater.loadAnimator(context, i5);
        }
        return loadAnimator(context, context.getResources(), context.getTheme(), i5);
    }

    private static Keyframe loadKeyframe(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, int i5, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        boolean z4;
        Keyframe keyframe;
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_KEYFRAME);
        float namedFloat = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "fraction", 3, -1.0f);
        TypedValue peekNamedValue = TypedArrayUtils.peekNamedValue(obtainAttributes, xmlPullParser, "value", 0);
        if (peekNamedValue != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (i5 == 4) {
            if (!z4 || !isColorType(peekNamedValue.type)) {
                i5 = 0;
            } else {
                i5 = 3;
            }
        }
        if (z4) {
            if (i5 == 0) {
                keyframe = Keyframe.ofFloat(namedFloat, TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "value", 0, 0.0f));
            } else if (i5 == 1 || i5 == 3) {
                keyframe = Keyframe.ofInt(namedFloat, TypedArrayUtils.getNamedInt(obtainAttributes, xmlPullParser, "value", 0, 0));
            } else {
                keyframe = null;
            }
        } else if (i5 == 0) {
            keyframe = Keyframe.ofFloat(namedFloat);
        } else {
            keyframe = Keyframe.ofInt(namedFloat);
        }
        int namedResourceId = TypedArrayUtils.getNamedResourceId(obtainAttributes, xmlPullParser, "interpolator", 1, 0);
        if (namedResourceId > 0) {
            keyframe.setInterpolator(AnimationUtilsCompat.loadInterpolator(context, namedResourceId));
        }
        obtainAttributes.recycle();
        return keyframe;
    }

    private static ObjectAnimator loadObjectAnimator(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, float f5, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        loadAnimator(context, resources, theme, attributeSet, objectAnimator, f5, xmlPullParser);
        return objectAnimator;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00f2 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.animation.PropertyValuesHolder loadPvh(android.content.Context r9, android.content.res.Resources r10, android.content.res.Resources.Theme r11, org.xmlpull.v1.XmlPullParser r12, java.lang.String r13, int r14) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r0 = 0
            r1 = r0
        L_0x0002:
            int r2 = r12.next()
            r3 = 3
            if (r2 == r3) goto L_0x0048
            r4 = 1
            if (r2 == r4) goto L_0x0048
            java.lang.String r2 = r12.getName()
            java.lang.String r3 = "keyframe"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0041
            r2 = 4
            if (r14 != r2) goto L_0x0023
            android.util.AttributeSet r14 = android.util.Xml.asAttributeSet(r12)
            int r14 = inferValueTypeOfKeyframe(r10, r11, r14, r12)
        L_0x0023:
            r6 = r14
            android.util.AttributeSet r5 = android.util.Xml.asAttributeSet(r12)
            r2 = r9
            r3 = r10
            r4 = r11
            r7 = r12
            android.animation.Keyframe r9 = loadKeyframe(r2, r3, r4, r5, r6, r7)
            if (r9 == 0) goto L_0x003c
            if (r1 != 0) goto L_0x0039
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
        L_0x0039:
            r1.add(r9)
        L_0x003c:
            r7.next()
            r14 = r6
            goto L_0x0044
        L_0x0041:
            r2 = r9
            r4 = r11
            r7 = r12
        L_0x0044:
            r9 = r2
            r11 = r4
            r12 = r7
            goto L_0x0002
        L_0x0048:
            if (r1 == 0) goto L_0x00f2
            int r9 = r1.size()
            if (r9 <= 0) goto L_0x00f2
            r10 = 0
            java.lang.Object r11 = r1.get(r10)
            android.animation.Keyframe r11 = (android.animation.Keyframe) r11
            int r12 = r9 + -1
            java.lang.Object r12 = r1.get(r12)
            android.animation.Keyframe r12 = (android.animation.Keyframe) r12
            float r0 = r12.getFraction()
            r2 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r5 = 0
            if (r4 >= 0) goto L_0x007f
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0072
            r12.setFraction(r2)
            goto L_0x007f
        L_0x0072:
            int r0 = r1.size()
            android.animation.Keyframe r12 = createNewKeyframe(r12, r2)
            r1.add(r0, r12)
            int r9 = r9 + 1
        L_0x007f:
            float r12 = r11.getFraction()
            int r0 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0098
            int r12 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r12 >= 0) goto L_0x008f
            r11.setFraction(r5)
            goto L_0x0098
        L_0x008f:
            android.animation.Keyframe r11 = createNewKeyframe(r11, r5)
            r1.add(r10, r11)
            int r9 = r9 + 1
        L_0x0098:
            android.animation.Keyframe[] r11 = new android.animation.Keyframe[r9]
            r1.toArray(r11)
        L_0x009d:
            if (r10 >= r9) goto L_0x00e4
            r12 = r11[r10]
            float r0 = r12.getFraction()
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x00e1
            if (r10 != 0) goto L_0x00af
            r12.setFraction(r5)
            goto L_0x00e1
        L_0x00af:
            int r0 = r9 + -1
            if (r10 != r0) goto L_0x00b7
            r12.setFraction(r2)
            goto L_0x00e1
        L_0x00b7:
            int r12 = r10 + 1
            r1 = r10
        L_0x00ba:
            if (r12 >= r0) goto L_0x00cd
            r4 = r11[r12]
            float r4 = r4.getFraction()
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 < 0) goto L_0x00c7
            goto L_0x00cd
        L_0x00c7:
            int r1 = r12 + 1
            r8 = r1
            r1 = r12
            r12 = r8
            goto L_0x00ba
        L_0x00cd:
            int r12 = r1 + 1
            r12 = r11[r12]
            float r12 = r12.getFraction()
            int r0 = r10 + -1
            r0 = r11[r0]
            float r0 = r0.getFraction()
            float r12 = r12 - r0
            distributeKeyframes(r11, r12, r10, r1)
        L_0x00e1:
            int r10 = r10 + 1
            goto L_0x009d
        L_0x00e4:
            android.animation.PropertyValuesHolder r9 = android.animation.PropertyValuesHolder.ofKeyframe(r13, r11)
            if (r14 != r3) goto L_0x00f1
            androidx.vectordrawable.graphics.drawable.ArgbEvaluator r10 = androidx.vectordrawable.graphics.drawable.ArgbEvaluator.getInstance()
            r9.setEvaluator(r10)
        L_0x00f1:
            return r9
        L_0x00f2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.AnimatorInflaterCompat.loadPvh(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, org.xmlpull.v1.XmlPullParser, java.lang.String, int):android.animation.PropertyValuesHolder");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0072 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.animation.PropertyValuesHolder[] loadValues(android.content.Context r13, android.content.res.Resources r14, android.content.res.Resources.Theme r15, org.xmlpull.v1.XmlPullParser r16, android.util.AttributeSet r17) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r3 = r16
            r6 = 0
            r7 = r6
        L_0x0004:
            int r0 = r3.getEventType()
            r8 = 0
            r1 = 3
            if (r0 == r1) goto L_0x005c
            r9 = 1
            if (r0 == r9) goto L_0x005c
            r2 = 2
            if (r0 == r2) goto L_0x0016
            r3.next()
            goto L_0x0004
        L_0x0016:
            java.lang.String r0 = r3.getName()
            java.lang.String r4 = "propertyValuesHolder"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0054
            int[] r0 = androidx.vectordrawable.graphics.drawable.AndroidResources.STYLEABLE_PROPERTY_VALUES_HOLDER
            r10 = r17
            android.content.res.TypedArray r11 = androidx.core.content.res.TypedArrayUtils.obtainAttributes(r14, r15, r10, r0)
            java.lang.String r0 = "propertyName"
            java.lang.String r4 = androidx.core.content.res.TypedArrayUtils.getNamedString(r11, r3, r0, r1)
            java.lang.String r0 = "valueType"
            r1 = 4
            int r5 = androidx.core.content.res.TypedArrayUtils.getNamedInt(r11, r3, r0, r2, r1)
            r0 = r13
            r1 = r14
            r2 = r15
            android.animation.PropertyValuesHolder r12 = loadPvh(r0, r1, r2, r3, r4, r5)
            if (r12 != 0) goto L_0x0044
            android.animation.PropertyValuesHolder r12 = getPVH(r11, r5, r8, r9, r4)
        L_0x0044:
            if (r12 == 0) goto L_0x0050
            if (r7 != 0) goto L_0x004d
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
        L_0x004d:
            r7.add(r12)
        L_0x0050:
            r11.recycle()
            goto L_0x0056
        L_0x0054:
            r10 = r17
        L_0x0056:
            r16.next()
            r3 = r16
            goto L_0x0004
        L_0x005c:
            if (r7 == 0) goto L_0x0072
            int r13 = r7.size()
            android.animation.PropertyValuesHolder[] r14 = new android.animation.PropertyValuesHolder[r13]
        L_0x0064:
            if (r8 >= r13) goto L_0x0071
            java.lang.Object r15 = r7.get(r8)
            android.animation.PropertyValuesHolder r15 = (android.animation.PropertyValuesHolder) r15
            r14[r8] = r15
            int r8 = r8 + 1
            goto L_0x0064
        L_0x0071:
            return r14
        L_0x0072:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.AnimatorInflaterCompat.loadValues(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet):android.animation.PropertyValuesHolder[]");
    }

    private static void parseAnimatorFromTypeArray(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f5, XmlPullParser xmlPullParser) {
        long namedInt = (long) TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, TypedValues.TransitionType.S_DURATION, 1, MaterialCardViewHelper.DEFAULT_FADE_ANIM_DURATION);
        long namedInt2 = (long) TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "startOffset", 2, 0);
        int namedInt3 = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "valueType", 7, 4);
        if (TypedArrayUtils.hasAttribute(xmlPullParser, "valueFrom") && TypedArrayUtils.hasAttribute(xmlPullParser, "valueTo")) {
            if (namedInt3 == 4) {
                namedInt3 = inferValueTypeFromValues(typedArray, 5, 6);
            }
            PropertyValuesHolder pvh = getPVH(typedArray, namedInt3, 5, 6, "");
            if (pvh != null) {
                valueAnimator.setValues(new PropertyValuesHolder[]{pvh});
            }
        }
        valueAnimator.setDuration(namedInt);
        valueAnimator.setStartDelay(namedInt2);
        valueAnimator.setRepeatCount(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "repeatCount", 3, 0));
        valueAnimator.setRepeatMode(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "repeatMode", 4, 1));
        if (typedArray2 != null) {
            setupObjectAnimator(valueAnimator, typedArray2, namedInt3, f5, xmlPullParser);
        }
    }

    private static void setupObjectAnimator(ValueAnimator valueAnimator, TypedArray typedArray, int i5, float f5, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator;
        String namedString = TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "pathData", 1);
        if (namedString != null) {
            String namedString2 = TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "propertyXName", 2);
            String namedString3 = TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "propertyYName", 3);
            if (i5 != 2) {
            }
            if (namedString2 == null && namedString3 == null) {
                throw new InflateException(typedArray.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
            }
            setupPathMotion(PathParser.createPathFromPathData(namedString), objectAnimator, f5 * 0.5f, namedString2, namedString3);
            return;
        }
        objectAnimator.setPropertyName(TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "propertyName", 0));
    }

    private static void setupPathMotion(Path path, ObjectAnimator objectAnimator, float f5, String str, String str2) {
        PropertyValuesHolder propertyValuesHolder;
        PropertyValuesHolder propertyValuesHolder2;
        Path path2 = path;
        ObjectAnimator objectAnimator2 = objectAnimator;
        String str3 = str;
        String str4 = str2;
        PathMeasure pathMeasure = new PathMeasure(path2, false);
        ArrayList arrayList = new ArrayList();
        float f6 = 0.0f;
        arrayList.add(Float.valueOf(0.0f));
        float f7 = 0.0f;
        do {
            f7 += pathMeasure.getLength();
            arrayList.add(Float.valueOf(f7));
        } while (pathMeasure.nextContour());
        PathMeasure pathMeasure2 = new PathMeasure(path2, false);
        int min = Math.min(100, ((int) (f7 / f5)) + 1);
        float[] fArr = new float[min];
        float[] fArr2 = new float[min];
        float[] fArr3 = new float[2];
        float f8 = f7 / ((float) (min - 1));
        int i5 = 0;
        int i6 = 0;
        while (true) {
            propertyValuesHolder = null;
            if (i5 >= min) {
                break;
            }
            pathMeasure2.getPosTan(f6 - ((Float) arrayList.get(i6)).floatValue(), fArr3, (float[]) null);
            fArr[i5] = fArr3[0];
            fArr2[i5] = fArr3[1];
            f6 += f8;
            int i7 = i6 + 1;
            if (i7 < arrayList.size() && f6 > ((Float) arrayList.get(i7)).floatValue()) {
                pathMeasure2.nextContour();
                i6 = i7;
            }
            i5++;
        }
        if (str3 != null) {
            propertyValuesHolder2 = PropertyValuesHolder.ofFloat(str3, fArr);
        } else {
            propertyValuesHolder2 = null;
        }
        if (str4 != null) {
            propertyValuesHolder = PropertyValuesHolder.ofFloat(str4, fArr2);
        }
        if (propertyValuesHolder2 == null) {
            objectAnimator2.setValues(new PropertyValuesHolder[]{propertyValuesHolder});
        } else if (propertyValuesHolder == null) {
            objectAnimator2.setValues(new PropertyValuesHolder[]{propertyValuesHolder2});
        } else {
            objectAnimator2.setValues(new PropertyValuesHolder[]{propertyValuesHolder2, propertyValuesHolder});
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: android.animation.ValueAnimator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: android.animation.ValueAnimator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: android.animation.ValueAnimator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: android.animation.ValueAnimator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: android.animation.AnimatorSet} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: android.animation.ValueAnimator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: android.animation.ValueAnimator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: android.animation.ValueAnimator} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.animation.Animator createAnimatorFromXml(android.content.Context r13, android.content.res.Resources r14, android.content.res.Resources.Theme r15, org.xmlpull.v1.XmlPullParser r16, android.util.AttributeSet r17, android.animation.AnimatorSet r18, int r19, float r20) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r8 = r18
            int r9 = r16.getDepth()
            r0 = 0
            r6 = r0
            r10 = r6
        L_0x0009:
            int r0 = r16.next()
            r1 = 3
            r11 = 0
            if (r0 != r1) goto L_0x0017
            int r1 = r16.getDepth()
            if (r1 <= r9) goto L_0x00c6
        L_0x0017:
            r7 = 1
            if (r0 == r7) goto L_0x00c6
            r1 = 2
            if (r0 == r1) goto L_0x001e
            goto L_0x0009
        L_0x001e:
            java.lang.String r12 = r16.getName()
            java.lang.String r0 = "objectAnimator"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x003b
            r0 = r13
            r1 = r14
            r2 = r15
            r5 = r16
            r3 = r17
            r4 = r20
            android.animation.ObjectAnimator r6 = loadObjectAnimator(r0, r1, r2, r3, r4, r5)
            r3 = r16
            goto L_0x009b
        L_0x003b:
            java.lang.String r0 = "animator"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x0054
            r4 = 0
            r0 = r13
            r1 = r14
            r2 = r15
            r6 = r16
            r3 = r17
            r5 = r20
            android.animation.ValueAnimator r4 = loadAnimator(r0, r1, r2, r3, r4, r5, r6)
            r3 = r6
            r6 = r4
            goto L_0x009b
        L_0x0054:
            r3 = r16
            java.lang.String r0 = "set"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x007e
            android.animation.AnimatorSet r5 = new android.animation.AnimatorSet
            r5.<init>()
            int[] r0 = androidx.vectordrawable.graphics.drawable.AndroidResources.STYLEABLE_ANIMATOR_SET
            r4 = r17
            android.content.res.TypedArray r12 = androidx.core.content.res.TypedArrayUtils.obtainAttributes(r14, r15, r4, r0)
            java.lang.String r0 = "ordering"
            int r6 = androidx.core.content.res.TypedArrayUtils.getNamedInt(r12, r3, r0, r11, r11)
            r0 = r13
            r1 = r14
            r2 = r15
            r7 = r20
            createAnimatorFromXml(r0, r1, r2, r3, r4, r5, r6, r7)
            r12.recycle()
            r6 = r5
            goto L_0x009b
        L_0x007e:
            java.lang.String r4 = "propertyValuesHolder"
            boolean r4 = r12.equals(r4)
            if (r4 == 0) goto L_0x00ab
            android.util.AttributeSet r4 = android.util.Xml.asAttributeSet(r3)
            android.animation.PropertyValuesHolder[] r4 = loadValues(r13, r14, r15, r3, r4)
            if (r4 == 0) goto L_0x009a
            boolean r5 = r6 instanceof android.animation.ValueAnimator
            if (r5 == 0) goto L_0x009a
            r5 = r6
            android.animation.ValueAnimator r5 = (android.animation.ValueAnimator) r5
            r5.setValues(r4)
        L_0x009a:
            r11 = r7
        L_0x009b:
            if (r8 == 0) goto L_0x0009
            if (r11 != 0) goto L_0x0009
            if (r10 != 0) goto L_0x00a6
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
        L_0x00a6:
            r10.add(r6)
            goto L_0x0009
        L_0x00ab:
            java.lang.RuntimeException r13 = new java.lang.RuntimeException
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "Unknown animator name: "
            r14.append(r15)
            java.lang.String r15 = r3.getName()
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            r13.<init>(r14)
            throw r13
        L_0x00c6:
            if (r8 == 0) goto L_0x00ee
            if (r10 == 0) goto L_0x00ee
            int r13 = r10.size()
            android.animation.Animator[] r13 = new android.animation.Animator[r13]
            int r14 = r10.size()
            r15 = r11
        L_0x00d5:
            if (r15 >= r14) goto L_0x00e5
            java.lang.Object r0 = r10.get(r15)
            int r15 = r15 + 1
            android.animation.Animator r0 = (android.animation.Animator) r0
            int r1 = r11 + 1
            r13[r11] = r0
            r11 = r1
            goto L_0x00d5
        L_0x00e5:
            if (r19 != 0) goto L_0x00eb
            r8.playTogether(r13)
            return r6
        L_0x00eb:
            r8.playSequentially(r13)
        L_0x00ee:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.AnimatorInflaterCompat.createAnimatorFromXml(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.animation.AnimatorSet, int, float):android.animation.Animator");
    }

    public static Animator loadAnimator(Context context, Resources resources, Resources.Theme theme, @AnimatorRes int i5) throws Resources.NotFoundException {
        return loadAnimator(context, resources, theme, i5, 1.0f);
    }

    public static Animator loadAnimator(Context context, Resources resources, Resources.Theme theme, @AnimatorRes int i5, float f5) throws Resources.NotFoundException {
        XmlResourceParser xmlResourceParser = null;
        try {
            XmlResourceParser animation = resources.getAnimation(i5);
            Animator createAnimatorFromXml = createAnimatorFromXml(context, resources, theme, animation, f5);
            if (animation != null) {
                animation.close();
            }
            return createAnimatorFromXml;
        } catch (XmlPullParserException e5) {
            Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i5));
            notFoundException.initCause(e5);
            throw notFoundException;
        } catch (IOException e6) {
            Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i5));
            notFoundException2.initCause(e6);
            throw notFoundException2;
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }

    private static ValueAnimator loadAnimator(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f5, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_ANIMATOR);
        TypedArray obtainAttributes2 = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_PROPERTY_ANIMATOR);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        parseAnimatorFromTypeArray(valueAnimator, obtainAttributes, obtainAttributes2, f5, xmlPullParser);
        int namedResourceId = TypedArrayUtils.getNamedResourceId(obtainAttributes, xmlPullParser, "interpolator", 0, 0);
        if (namedResourceId > 0) {
            valueAnimator.setInterpolator(AnimationUtilsCompat.loadInterpolator(context, namedResourceId));
        }
        obtainAttributes.recycle();
        if (obtainAttributes2 != null) {
            obtainAttributes2.recycle();
        }
        return valueAnimator;
    }
}
