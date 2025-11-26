package androidx.constraintlayout.core.state;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLArray;
import androidx.constraintlayout.core.parser.CLContainer;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.state.Transition;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.foundation.entity.b;
import java.lang.reflect.Array;

public class TransitionParser {
    private static int map(String str, String... strArr) {
        for (int i5 = 0; i5 < strArr.length; i5++) {
            if (strArr[i5].equals(str)) {
                return i5;
            }
        }
        return 0;
    }

    @Deprecated
    public static void parse(CLObject cLObject, Transition transition, CorePixelDp corePixelDp) throws CLParsingException {
        parse(cLObject, transition);
    }

    private static void parseKeyAttribute(CLObject cLObject, Transition transition) throws CLParsingException {
        CLArray arrayOrNull;
        CustomVariable[][] customVariableArr;
        CustomVariable[] customVariableArr2;
        CLObject cLObject2;
        int i5;
        String[] strArr;
        CLObject cLObject3 = cLObject;
        Transition transition2 = transition;
        CLArray arrayOrNull2 = cLObject3.getArrayOrNull(TypedValues.AttributesType.S_TARGET);
        if (arrayOrNull2 != null && (arrayOrNull = cLObject3.getArrayOrNull(b.JSON_KEY_FRAME_ADS)) != null) {
            String stringOrNull = cLObject3.getStringOrNull("transitionEasing");
            String[] strArr2 = {"scaleX", "scaleY", "translationX", "translationY", "translationZ", "rotationX", "rotationY", "rotationZ", "alpha"};
            int i6 = 9;
            int[] iArr = {311, 312, 304, 305, 306, 308, 309, 310, 303};
            boolean[] zArr = {false, false, true, true, true, false, false, false, false};
            int size = arrayOrNull.size();
            TypedBundle[] typedBundleArr = new TypedBundle[size];
            for (int i7 = 0; i7 < arrayOrNull.size(); i7++) {
                typedBundleArr[i7] = new TypedBundle();
            }
            int i8 = 0;
            while (i8 < i6) {
                String str = strArr2[i8];
                int i9 = iArr[i8];
                boolean z4 = zArr[i8];
                CLArray arrayOrNull3 = cLObject3.getArrayOrNull(str);
                if (arrayOrNull3 == null || arrayOrNull3.size() == size) {
                    if (arrayOrNull3 != null) {
                        int i10 = 0;
                        while (i10 < size) {
                            float f5 = arrayOrNull3.getFloat(i10);
                            String[] strArr3 = strArr2;
                            if (z4) {
                                f5 = transition2.mToPixel.toPixels(f5);
                            }
                            typedBundleArr[i10].add(i9, f5);
                            i10++;
                            strArr2 = strArr3;
                        }
                        strArr = strArr2;
                    } else {
                        strArr = strArr2;
                        float floatOrNaN = cLObject3.getFloatOrNaN(str);
                        if (!Float.isNaN(floatOrNaN)) {
                            if (z4) {
                                floatOrNaN = transition2.mToPixel.toPixels(floatOrNaN);
                            }
                            for (int i11 = 0; i11 < size; i11++) {
                                typedBundleArr[i11].add(i9, floatOrNaN);
                            }
                        }
                    }
                    i8++;
                    strArr2 = strArr;
                    i6 = 9;
                } else {
                    throw new CLParsingException("incorrect size for " + str + " array, not matching targets array!", cLObject3);
                }
            }
            int i12 = 0;
            CLElement orNull = cLObject3.getOrNull("custom");
            if (orNull == null || !(orNull instanceof CLObject)) {
                customVariableArr = null;
            } else {
                CLObject cLObject4 = (CLObject) orNull;
                int size2 = cLObject4.size();
                int size3 = arrayOrNull.size();
                int[] iArr2 = new int[2];
                iArr2[1] = size2;
                iArr2[0] = size3;
                customVariableArr = (CustomVariable[][]) Array.newInstance(CustomVariable.class, iArr2);
                int i13 = 0;
                while (i13 < size2) {
                    CLKey cLKey = (CLKey) cLObject4.get(i13);
                    String content = cLKey.content();
                    if (cLKey.getValue() instanceof CLArray) {
                        CLArray cLArray = (CLArray) cLKey.getValue();
                        int size4 = cLArray.size();
                        if (size4 == size && size4 > 0) {
                            int i14 = i12;
                            if (cLArray.get(i14) instanceof CLNumber) {
                                int i15 = i14;
                                while (i15 < size) {
                                    customVariableArr[i15][i13] = new CustomVariable(content, (int) TypedValues.Custom.TYPE_FLOAT, cLArray.get(i15).getFloat());
                                    i15++;
                                    cLObject4 = cLObject4;
                                }
                            } else {
                                cLObject2 = cLObject4;
                                int i16 = 0;
                                while (i16 < size) {
                                    long parseColorString = ConstraintSetParser.parseColorString(cLArray.get(i16).content());
                                    if (parseColorString != -1) {
                                        i5 = i16;
                                        customVariableArr[i16][i13] = new CustomVariable(content, (int) TypedValues.Custom.TYPE_COLOR, (int) parseColorString);
                                    } else {
                                        i5 = i16;
                                    }
                                    i16 = i5 + 1;
                                }
                            }
                        }
                        cLObject2 = cLObject4;
                    } else {
                        cLObject2 = cLObject4;
                        CLElement value = cLKey.getValue();
                        if (value instanceof CLNumber) {
                            float f6 = value.getFloat();
                            for (int i17 = 0; i17 < size; i17++) {
                                customVariableArr[i17][i13] = new CustomVariable(content, (int) TypedValues.Custom.TYPE_FLOAT, f6);
                            }
                        } else {
                            long parseColorString2 = ConstraintSetParser.parseColorString(value.content());
                            if (parseColorString2 != -1) {
                                int i18 = 0;
                                while (i18 < size) {
                                    customVariableArr[i18][i13] = new CustomVariable(content, (int) TypedValues.Custom.TYPE_COLOR, (int) parseColorString2);
                                    i18++;
                                    size2 = size2;
                                    parseColorString2 = parseColorString2;
                                }
                            }
                        }
                    }
                    i13++;
                    size2 = size2;
                    cLObject4 = cLObject2;
                    i12 = 0;
                }
            }
            String stringOrNull2 = cLObject3.getStringOrNull("curveFit");
            for (int i19 = 0; i19 < arrayOrNull2.size(); i19++) {
                for (int i20 = 0; i20 < size; i20++) {
                    String string = arrayOrNull2.getString(i19);
                    TypedBundle typedBundle = typedBundleArr[i20];
                    if (stringOrNull2 != null) {
                        typedBundle.add((int) TypedValues.PositionType.TYPE_CURVE_FIT, map(stringOrNull2, "spline", "linear"));
                    }
                    typedBundle.addIfNotNull(TypedValues.PositionType.TYPE_TRANSITION_EASING, stringOrNull);
                    typedBundle.add(100, arrayOrNull.getInt(i20));
                    if (customVariableArr != null) {
                        customVariableArr2 = customVariableArr[i20];
                    } else {
                        customVariableArr2 = null;
                    }
                    transition2.addKeyAttribute(string, typedBundle, customVariableArr2);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x014b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void parseKeyCycle(androidx.constraintlayout.core.parser.CLObject r19, androidx.constraintlayout.core.state.Transition r20) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            r0 = r19
            r1 = r20
            java.lang.String r2 = "target"
            androidx.constraintlayout.core.parser.CLArray r2 = r0.getArray((java.lang.String) r2)
            java.lang.String r3 = "frames"
            androidx.constraintlayout.core.parser.CLArray r3 = r0.getArray((java.lang.String) r3)
            java.lang.String r4 = "transitionEasing"
            java.lang.String r4 = r0.getStringOrNull((java.lang.String) r4)
            java.lang.String r15 = "offset"
            java.lang.String r16 = "phase"
            java.lang.String r5 = "scaleX"
            java.lang.String r6 = "scaleY"
            java.lang.String r7 = "translationX"
            java.lang.String r8 = "translationY"
            java.lang.String r9 = "translationZ"
            java.lang.String r10 = "rotationX"
            java.lang.String r11 = "rotationY"
            java.lang.String r12 = "rotationZ"
            java.lang.String r13 = "alpha"
            java.lang.String r14 = "period"
            java.lang.String[] r5 = new java.lang.String[]{r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16}
            r6 = 12
            int[] r7 = new int[r6]
            r7 = {311, 312, 304, 305, 306, 308, 309, 310, 403, 423, 424, 425} // fill-array
            int[] r8 = new int[r6]
            r8 = {0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 2, 0} // fill-array
            int r9 = r3.size()
            androidx.constraintlayout.core.motion.utils.TypedBundle[] r10 = new androidx.constraintlayout.core.motion.utils.TypedBundle[r9]
            r12 = 0
        L_0x0045:
            if (r12 >= r9) goto L_0x0051
            androidx.constraintlayout.core.motion.utils.TypedBundle r13 = new androidx.constraintlayout.core.motion.utils.TypedBundle
            r13.<init>()
            r10[r12] = r13
            int r12 = r12 + 1
            goto L_0x0045
        L_0x0051:
            r12 = 0
            r13 = 0
        L_0x0053:
            r14 = 1
            if (r12 >= r6) goto L_0x0066
            r15 = r5[r12]
            boolean r15 = r0.has(r15)
            if (r15 == 0) goto L_0x0063
            r15 = r8[r12]
            if (r15 != r14) goto L_0x0063
            r13 = r14
        L_0x0063:
            int r12 = r12 + 1
            goto L_0x0053
        L_0x0066:
            r12 = 0
        L_0x0067:
            if (r12 >= r6) goto L_0x00ea
            r15 = r5[r12]
            r6 = r7[r12]
            r11 = r8[r12]
            androidx.constraintlayout.core.parser.CLArray r14 = r0.getArrayOrNull(r15)
            r17 = r5
            if (r14 == 0) goto L_0x0086
            int r5 = r14.size()
            if (r5 != r9) goto L_0x007e
            goto L_0x0086
        L_0x007e:
            androidx.constraintlayout.core.parser.CLParsingException r1 = new androidx.constraintlayout.core.parser.CLParsingException
            java.lang.String r2 = "incorrect size for $attrName array, not matching targets array!"
            r1.<init>(r2, r0)
            throw r1
        L_0x0086:
            if (r14 == 0) goto L_0x00b3
            r15 = 0
        L_0x0089:
            if (r15 >= r9) goto L_0x00b0
            float r5 = r14.getFloat((int) r15)
            r18 = r7
            r7 = 1
            if (r11 != r7) goto L_0x009b
            androidx.constraintlayout.core.state.CorePixelDp r7 = r1.mToPixel
            float r5 = r7.toPixels(r5)
            goto L_0x00a6
        L_0x009b:
            r7 = 2
            if (r11 != r7) goto L_0x00a6
            if (r13 == 0) goto L_0x00a6
            androidx.constraintlayout.core.state.CorePixelDp r7 = r1.mToPixel
            float r5 = r7.toPixels(r5)
        L_0x00a6:
            r7 = r10[r15]
            r7.add((int) r6, (float) r5)
            int r15 = r15 + 1
            r7 = r18
            goto L_0x0089
        L_0x00b0:
            r18 = r7
            goto L_0x00df
        L_0x00b3:
            r18 = r7
            float r5 = r0.getFloatOrNaN(r15)
            boolean r7 = java.lang.Float.isNaN(r5)
            if (r7 != 0) goto L_0x00df
            r7 = 1
            if (r11 != r7) goto L_0x00c9
            androidx.constraintlayout.core.state.CorePixelDp r7 = r1.mToPixel
            float r5 = r7.toPixels(r5)
            goto L_0x00d4
        L_0x00c9:
            r7 = 2
            if (r11 != r7) goto L_0x00d4
            if (r13 == 0) goto L_0x00d4
            androidx.constraintlayout.core.state.CorePixelDp r7 = r1.mToPixel
            float r5 = r7.toPixels(r5)
        L_0x00d4:
            r7 = 0
        L_0x00d5:
            if (r7 >= r9) goto L_0x00df
            r11 = r10[r7]
            r11.add((int) r6, (float) r5)
            int r7 = r7 + 1
            goto L_0x00d5
        L_0x00df:
            int r12 = r12 + 1
            r5 = r17
            r7 = r18
            r6 = 12
            r14 = 1
            goto L_0x0067
        L_0x00ea:
            java.lang.String r5 = "curveFit"
            java.lang.String r5 = r0.getStringOrNull((java.lang.String) r5)
            java.lang.String r6 = "easing"
            java.lang.String r6 = r0.getStringOrNull((java.lang.String) r6)
            java.lang.String r7 = "waveShape"
            java.lang.String r7 = r0.getStringOrNull((java.lang.String) r7)
            java.lang.String r8 = "customWave"
            java.lang.String r0 = r0.getStringOrNull((java.lang.String) r8)
            r8 = 0
        L_0x0103:
            int r11 = r2.size()
            if (r8 >= r11) goto L_0x015d
            r11 = 0
        L_0x010a:
            if (r11 >= r9) goto L_0x015a
            java.lang.String r12 = r2.getString((int) r8)
            r13 = r10[r11]
            if (r5 == 0) goto L_0x0126
            java.lang.String r14 = "linear"
            boolean r14 = r5.equals(r14)
            r15 = 401(0x191, float:5.62E-43)
            if (r14 != 0) goto L_0x012d
            java.lang.String r14 = "spline"
            boolean r14 = r5.equals(r14)
            if (r14 != 0) goto L_0x0128
        L_0x0126:
            r14 = 1
            goto L_0x0131
        L_0x0128:
            r14 = 0
            r13.add((int) r15, (int) r14)
            goto L_0x0126
        L_0x012d:
            r14 = 1
            r13.add((int) r15, (int) r14)
        L_0x0131:
            r15 = 501(0x1f5, float:7.02E-43)
            r13.addIfNotNull(r15, r4)
            if (r6 == 0) goto L_0x013d
            r15 = 420(0x1a4, float:5.89E-43)
            r13.add((int) r15, (java.lang.String) r6)
        L_0x013d:
            if (r7 == 0) goto L_0x0144
            r15 = 421(0x1a5, float:5.9E-43)
            r13.add((int) r15, (java.lang.String) r7)
        L_0x0144:
            if (r0 == 0) goto L_0x014b
            r15 = 422(0x1a6, float:5.91E-43)
            r13.add((int) r15, (java.lang.String) r0)
        L_0x014b:
            int r15 = r3.getInt((int) r11)
            r14 = 100
            r13.add((int) r14, (int) r15)
            r1.addKeyCycle(r12, r13)
            int r11 = r11 + 1
            goto L_0x010a
        L_0x015a:
            int r8 = r8 + 1
            goto L_0x0103
        L_0x015d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.TransitionParser.parseKeyCycle(androidx.constraintlayout.core.parser.CLObject, androidx.constraintlayout.core.state.Transition):void");
    }

    public static void parseKeyFrames(CLObject cLObject, Transition transition) throws CLParsingException {
        CLObject objectOrNull = cLObject.getObjectOrNull("KeyFrames");
        if (objectOrNull != null) {
            CLArray arrayOrNull = objectOrNull.getArrayOrNull("KeyPositions");
            if (arrayOrNull != null) {
                for (int i5 = 0; i5 < arrayOrNull.size(); i5++) {
                    CLElement cLElement = arrayOrNull.get(i5);
                    if (cLElement instanceof CLObject) {
                        parseKeyPosition((CLObject) cLElement, transition);
                    }
                }
            }
            CLArray arrayOrNull2 = objectOrNull.getArrayOrNull(TypedValues.AttributesType.NAME);
            if (arrayOrNull2 != null) {
                for (int i6 = 0; i6 < arrayOrNull2.size(); i6++) {
                    CLElement cLElement2 = arrayOrNull2.get(i6);
                    if (cLElement2 instanceof CLObject) {
                        parseKeyAttribute((CLObject) cLElement2, transition);
                    }
                }
            }
            CLArray arrayOrNull3 = objectOrNull.getArrayOrNull("KeyCycles");
            if (arrayOrNull3 != null) {
                for (int i7 = 0; i7 < arrayOrNull3.size(); i7++) {
                    CLElement cLElement3 = arrayOrNull3.get(i7);
                    if (cLElement3 instanceof CLObject) {
                        parseKeyCycle((CLObject) cLElement3, transition);
                    }
                }
            }
        }
    }

    private static void parseKeyPosition(CLObject cLObject, Transition transition) throws CLParsingException {
        CLObject cLObject2 = cLObject;
        TypedBundle typedBundle = new TypedBundle();
        CLArray array = cLObject2.getArray(TypedValues.AttributesType.S_TARGET);
        CLArray array2 = cLObject2.getArray(b.JSON_KEY_FRAME_ADS);
        CLArray arrayOrNull = cLObject2.getArrayOrNull("percentX");
        CLArray arrayOrNull2 = cLObject2.getArrayOrNull("percentY");
        CLArray arrayOrNull3 = cLObject2.getArrayOrNull("percentWidth");
        CLArray arrayOrNull4 = cLObject2.getArrayOrNull("percentHeight");
        String stringOrNull = cLObject2.getStringOrNull(TypedValues.TransitionType.S_PATH_MOTION_ARC);
        String stringOrNull2 = cLObject2.getStringOrNull("transitionEasing");
        String stringOrNull3 = cLObject2.getStringOrNull("curveFit");
        String stringOrNull4 = cLObject2.getStringOrNull(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
        if (stringOrNull4 == null) {
            stringOrNull4 = "parentRelative";
        }
        if (arrayOrNull != null && array2.size() != arrayOrNull.size()) {
            return;
        }
        if (arrayOrNull2 == null || array2.size() == arrayOrNull2.size()) {
            int i5 = 0;
            while (i5 < array.size()) {
                String string = array.getString(i5);
                int map = map(stringOrNull4, "deltaRelative", "pathRelative", "parentRelative");
                typedBundle.clear();
                typedBundle.add((int) TypedValues.PositionType.TYPE_POSITION_TYPE, map);
                if (stringOrNull3 != null) {
                    map(typedBundle, TypedValues.PositionType.TYPE_CURVE_FIT, stringOrNull3, "spline", "linear");
                }
                typedBundle.addIfNotNull(TypedValues.PositionType.TYPE_TRANSITION_EASING, stringOrNull2);
                if (stringOrNull != null) {
                    map(typedBundle, 509, stringOrNull, "none", "startVertical", "startHorizontal", "flip", "below", "above");
                }
                int i6 = 0;
                while (i6 < array2.size()) {
                    typedBundle.add(100, array2.getInt(i6));
                    set(typedBundle, TypedValues.PositionType.TYPE_PERCENT_X, arrayOrNull, i6);
                    set(typedBundle, TypedValues.PositionType.TYPE_PERCENT_Y, arrayOrNull2, i6);
                    set(typedBundle, TypedValues.PositionType.TYPE_PERCENT_WIDTH, arrayOrNull3, i6);
                    set(typedBundle, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, arrayOrNull4, i6);
                    transition.addKeyPosition(string, typedBundle);
                    i6++;
                    stringOrNull4 = stringOrNull4;
                }
                String str = stringOrNull4;
                Transition transition2 = transition;
                i5++;
                stringOrNull4 = str;
            }
        }
    }

    private static void parseOnSwipe(CLContainer cLContainer, Transition transition) {
        CLContainer cLContainer2 = cLContainer;
        String stringOrNull = cLContainer2.getStringOrNull("anchor");
        int map = map(cLContainer2.getStringOrNull("side"), Transition.OnSwipe.SIDES);
        int map2 = map(cLContainer2.getStringOrNull("direction"), Transition.OnSwipe.DIRECTIONS);
        float floatOrNaN = cLContainer2.getFloatOrNaN("scale");
        float floatOrNaN2 = cLContainer2.getFloatOrNaN("threshold");
        float floatOrNaN3 = cLContainer2.getFloatOrNaN("maxVelocity");
        float floatOrNaN4 = cLContainer2.getFloatOrNaN("maxAccel");
        String stringOrNull2 = cLContainer2.getStringOrNull("limitBounds");
        int map3 = map(cLContainer2.getStringOrNull("mode"), Transition.OnSwipe.MODE);
        int map4 = map(cLContainer2.getStringOrNull("touchUp"), Transition.OnSwipe.TOUCH_UP);
        float floatOrNaN5 = cLContainer2.getFloatOrNaN("springMass");
        float floatOrNaN6 = cLContainer2.getFloatOrNaN("springStiffness");
        float floatOrNaN7 = cLContainer2.getFloatOrNaN("springDamping");
        float floatOrNaN8 = cLContainer2.getFloatOrNaN("stopThreshold");
        int map5 = map(cLContainer2.getStringOrNull("springBoundary"), Transition.OnSwipe.BOUNDARY);
        String stringOrNull3 = cLContainer2.getStringOrNull("around");
        Transition.OnSwipe createOnSwipe = transition.createOnSwipe();
        createOnSwipe.setAnchorId(stringOrNull);
        createOnSwipe.setAnchorSide(map);
        createOnSwipe.setDragDirection(map2);
        createOnSwipe.setDragScale(floatOrNaN);
        createOnSwipe.setDragThreshold(floatOrNaN2);
        createOnSwipe.setMaxVelocity(floatOrNaN3);
        createOnSwipe.setMaxAcceleration(floatOrNaN4);
        createOnSwipe.setLimitBoundsTo(stringOrNull2);
        createOnSwipe.setAutoCompleteMode(map3);
        createOnSwipe.setOnTouchUp(map4);
        createOnSwipe.setSpringMass(floatOrNaN5);
        createOnSwipe.setSpringStiffness(floatOrNaN6);
        createOnSwipe.setSpringDamping(floatOrNaN7);
        createOnSwipe.setSpringStopThreshold(floatOrNaN8);
        createOnSwipe.setSpringBoundary(map5);
        createOnSwipe.setRotationCenterId(stringOrNull3);
    }

    private static void set(TypedBundle typedBundle, int i5, CLArray cLArray, int i6) throws CLParsingException {
        if (cLArray != null) {
            typedBundle.add(i5, cLArray.getFloat(i6));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void parse(@NonNull CLObject cLObject, @NonNull Transition transition) throws CLParsingException {
        transition.resetProperties();
        String stringOrNull = cLObject.getStringOrNull(TypedValues.TransitionType.S_PATH_MOTION_ARC);
        TypedBundle typedBundle = new TypedBundle();
        boolean z4 = true;
        boolean z5 = false;
        if (stringOrNull != null) {
            char c5 = 65535;
            switch (stringOrNull.hashCode()) {
                case -1857024520:
                    if (stringOrNull.equals("startVertical")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case -1007052250:
                    if (stringOrNull.equals("startHorizontal")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case 3145837:
                    if (stringOrNull.equals("flip")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case 3387192:
                    if (stringOrNull.equals("none")) {
                        c5 = 3;
                        break;
                    }
                    break;
                case 92611485:
                    if (stringOrNull.equals("above")) {
                        c5 = 4;
                        break;
                    }
                    break;
                case 93621297:
                    if (stringOrNull.equals("below")) {
                        c5 = 5;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    typedBundle.add(509, 1);
                    break;
                case 1:
                    typedBundle.add(509, 2);
                    break;
                case 2:
                    typedBundle.add(509, 3);
                    break;
                case 3:
                    typedBundle.add(509, 0);
                    break;
                case 4:
                    typedBundle.add(509, 5);
                    break;
                case 5:
                    typedBundle.add(509, 4);
                    break;
            }
            z5 = true;
        }
        String stringOrNull2 = cLObject.getStringOrNull("interpolator");
        if (stringOrNull2 != null) {
            typedBundle.add((int) TypedValues.TransitionType.TYPE_INTERPOLATOR, stringOrNull2);
            z5 = true;
        }
        float floatOrNaN = cLObject.getFloatOrNaN(TypedValues.TransitionType.S_STAGGERED);
        if (!Float.isNaN(floatOrNaN)) {
            typedBundle.add((int) TypedValues.TransitionType.TYPE_STAGGERED, floatOrNaN);
        } else {
            z4 = z5;
        }
        if (z4) {
            transition.setTransitionProperties(typedBundle);
        }
        CLObject objectOrNull = cLObject.getObjectOrNull("onSwipe");
        if (objectOrNull != null) {
            parseOnSwipe(objectOrNull, transition);
        }
        parseKeyFrames(cLObject, transition);
    }

    private static void map(TypedBundle typedBundle, int i5, String str, String... strArr) {
        for (int i6 = 0; i6 < strArr.length; i6++) {
            if (strArr[i6].equals(str)) {
                typedBundle.add(i5, i6);
            }
        }
    }
}
