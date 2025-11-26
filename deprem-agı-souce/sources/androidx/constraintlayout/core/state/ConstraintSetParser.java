package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLArray;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParser;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.parser.CLString;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstraintSetParser {
    private static final boolean PARSER_DEBUG = false;

    public static class DesignElement {
        String mId;
        HashMap<String, String> mParams;
        String mType;

        DesignElement(String str, String str2, HashMap<String, String> hashMap) {
            this.mId = str;
            this.mType = str2;
            this.mParams = hashMap;
        }

        public String getId() {
            return this.mId;
        }

        public HashMap<String, String> getParams() {
            return this.mParams;
        }

        public String getType() {
            return this.mType;
        }
    }

    static class FiniteGenerator implements GeneratedValue {
        float mCurrent = 0.0f;
        float mFrom;
        float mInitial;
        float mMax;
        String mPostfix;
        String mPrefix;
        float mStep;
        boolean mStop = false;
        float mTo;

        FiniteGenerator(float f5, float f6, float f7, String str, String str2) {
            this.mFrom = f5;
            this.mTo = f6;
            this.mStep = f7;
            this.mPrefix = str == null ? "" : str;
            this.mPostfix = str2 == null ? "" : str2;
            this.mMax = f6;
            this.mInitial = f5;
        }

        public ArrayList<String> array() {
            ArrayList<String> arrayList = new ArrayList<>();
            int i5 = (int) this.mInitial;
            int i6 = (int) this.mMax;
            int i7 = i5;
            while (i5 <= i6) {
                arrayList.add(this.mPrefix + i7 + this.mPostfix);
                i7 += (int) this.mStep;
                i5++;
            }
            return arrayList;
        }

        public float value() {
            float f5 = this.mCurrent;
            if (f5 >= this.mMax) {
                this.mStop = true;
            }
            if (!this.mStop) {
                this.mCurrent = f5 + this.mStep;
            }
            return this.mCurrent;
        }
    }

    interface GeneratedValue {
        float value();
    }

    static class Generator implements GeneratedValue {
        float mCurrent;
        float mIncrementBy;
        float mStart;
        boolean mStop = false;

        Generator(float f5, float f6) {
            this.mStart = f5;
            this.mIncrementBy = f6;
            this.mCurrent = f5;
        }

        public float value() {
            if (!this.mStop) {
                this.mCurrent += this.mIncrementBy;
            }
            return this.mCurrent;
        }
    }

    public static class LayoutVariables {
        HashMap<String, ArrayList<String>> mArrayIds = new HashMap<>();
        HashMap<String, GeneratedValue> mGenerators = new HashMap<>();
        HashMap<String, Integer> mMargins = new HashMap<>();

        /* access modifiers changed from: package-private */
        public float get(Object obj) {
            if (obj instanceof CLString) {
                String content = ((CLString) obj).content();
                if (this.mGenerators.containsKey(content)) {
                    return this.mGenerators.get(content).value();
                }
                if (this.mMargins.containsKey(content)) {
                    return this.mMargins.get(content).floatValue();
                }
                return 0.0f;
            } else if (obj instanceof CLNumber) {
                return ((CLNumber) obj).getFloat();
            } else {
                return 0.0f;
            }
        }

        /* access modifiers changed from: package-private */
        public ArrayList<String> getList(String str) {
            if (this.mArrayIds.containsKey(str)) {
                return this.mArrayIds.get(str);
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public void put(String str, int i5) {
            this.mMargins.put(str, Integer.valueOf(i5));
        }

        public void putOverride(String str, float f5) {
            this.mGenerators.put(str, new OverrideValue(f5));
        }

        /* access modifiers changed from: package-private */
        public void put(String str, float f5, float f6) {
            if (!this.mGenerators.containsKey(str) || !(this.mGenerators.get(str) instanceof OverrideValue)) {
                this.mGenerators.put(str, new Generator(f5, f6));
            }
        }

        /* access modifiers changed from: package-private */
        public void put(String str, float f5, float f6, float f7, String str2, String str3) {
            if (!this.mGenerators.containsKey(str) || !(this.mGenerators.get(str) instanceof OverrideValue)) {
                FiniteGenerator finiteGenerator = new FiniteGenerator(f5, f6, f7, str2, str3);
                this.mGenerators.put(str, finiteGenerator);
                this.mArrayIds.put(str, finiteGenerator.array());
            }
        }

        /* access modifiers changed from: package-private */
        public void put(String str, ArrayList<String> arrayList) {
            this.mArrayIds.put(str, arrayList);
        }
    }

    public enum MotionLayoutDebugFlags {
        NONE,
        SHOW_ALL,
        UNKNOWN
    }

    static class OverrideValue implements GeneratedValue {
        float mValue;

        OverrideValue(float f5) {
            this.mValue = f5;
        }

        public float value() {
            return this.mValue;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0168, code lost:
        if (r8.equals("visible") == false) goto L_0x0160;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void applyAttribute(androidx.constraintlayout.core.state.State r8, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r9, androidx.constraintlayout.core.state.ConstraintReference r10, androidx.constraintlayout.core.parser.CLObject r11, java.lang.String r12) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            r12.getClass()
            int r0 = r12.hashCode()
            r1 = 8
            r2 = 4
            r3 = 2
            r4 = 1
            r5 = 0
            r6 = -1
            switch(r0) {
                case -1448775240: goto L_0x013e;
                case -1364013995: goto L_0x0132;
                case -1349088399: goto L_0x0126;
                case -1249320806: goto L_0x011a;
                case -1249320805: goto L_0x010e;
                case -1249320804: goto L_0x0102;
                case -1225497657: goto L_0x00f6;
                case -1225497656: goto L_0x00ea;
                case -1225497655: goto L_0x00dd;
                case -1221029593: goto L_0x00cf;
                case -1068318794: goto L_0x00c1;
                case -987906986: goto L_0x00b3;
                case -987906985: goto L_0x00a5;
                case -908189618: goto L_0x0097;
                case -908189617: goto L_0x0089;
                case -247669061: goto L_0x007c;
                case -61505906: goto L_0x006f;
                case 92909918: goto L_0x0062;
                case 98116417: goto L_0x0055;
                case 111045711: goto L_0x0048;
                case 113126854: goto L_0x003b;
                case 398344448: goto L_0x002e;
                case 1404070310: goto L_0x0021;
                case 1941332754: goto L_0x0014;
                default: goto L_0x0011;
            }
        L_0x0011:
            r0 = r6
            goto L_0x0149
        L_0x0014:
            java.lang.String r0 = "visibility"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x001d
            goto L_0x0011
        L_0x001d:
            r0 = 23
            goto L_0x0149
        L_0x0021:
            java.lang.String r0 = "centerHorizontally"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x002a
            goto L_0x0011
        L_0x002a:
            r0 = 22
            goto L_0x0149
        L_0x002e:
            java.lang.String r0 = "hWeight"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x0037
            goto L_0x0011
        L_0x0037:
            r0 = 21
            goto L_0x0149
        L_0x003b:
            java.lang.String r0 = "width"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x0044
            goto L_0x0011
        L_0x0044:
            r0 = 20
            goto L_0x0149
        L_0x0048:
            java.lang.String r0 = "vBias"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x0051
            goto L_0x0011
        L_0x0051:
            r0 = 19
            goto L_0x0149
        L_0x0055:
            java.lang.String r0 = "hBias"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x005e
            goto L_0x0011
        L_0x005e:
            r0 = 18
            goto L_0x0149
        L_0x0062:
            java.lang.String r0 = "alpha"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x006b
            goto L_0x0011
        L_0x006b:
            r0 = 17
            goto L_0x0149
        L_0x006f:
            java.lang.String r0 = "vWeight"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x0078
            goto L_0x0011
        L_0x0078:
            r0 = 16
            goto L_0x0149
        L_0x007c:
            java.lang.String r0 = "hRtlBias"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x0085
            goto L_0x0011
        L_0x0085:
            r0 = 15
            goto L_0x0149
        L_0x0089:
            java.lang.String r0 = "scaleY"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x0093
            goto L_0x0011
        L_0x0093:
            r0 = 14
            goto L_0x0149
        L_0x0097:
            java.lang.String r0 = "scaleX"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x00a1
            goto L_0x0011
        L_0x00a1:
            r0 = 13
            goto L_0x0149
        L_0x00a5:
            java.lang.String r0 = "pivotY"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x00af
            goto L_0x0011
        L_0x00af:
            r0 = 12
            goto L_0x0149
        L_0x00b3:
            java.lang.String r0 = "pivotX"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x00bd
            goto L_0x0011
        L_0x00bd:
            r0 = 11
            goto L_0x0149
        L_0x00c1:
            java.lang.String r0 = "motion"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x00cb
            goto L_0x0011
        L_0x00cb:
            r0 = 10
            goto L_0x0149
        L_0x00cf:
            java.lang.String r0 = "height"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x00d9
            goto L_0x0011
        L_0x00d9:
            r0 = 9
            goto L_0x0149
        L_0x00dd:
            java.lang.String r0 = "translationZ"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x00e7
            goto L_0x0011
        L_0x00e7:
            r0 = r1
            goto L_0x0149
        L_0x00ea:
            java.lang.String r0 = "translationY"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x00f4
            goto L_0x0011
        L_0x00f4:
            r0 = 7
            goto L_0x0149
        L_0x00f6:
            java.lang.String r0 = "translationX"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x0100
            goto L_0x0011
        L_0x0100:
            r0 = 6
            goto L_0x0149
        L_0x0102:
            java.lang.String r0 = "rotationZ"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x010c
            goto L_0x0011
        L_0x010c:
            r0 = 5
            goto L_0x0149
        L_0x010e:
            java.lang.String r0 = "rotationY"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x0118
            goto L_0x0011
        L_0x0118:
            r0 = r2
            goto L_0x0149
        L_0x011a:
            java.lang.String r0 = "rotationX"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x0124
            goto L_0x0011
        L_0x0124:
            r0 = 3
            goto L_0x0149
        L_0x0126:
            java.lang.String r0 = "custom"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x0130
            goto L_0x0011
        L_0x0130:
            r0 = r3
            goto L_0x0149
        L_0x0132:
            java.lang.String r0 = "center"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x013c
            goto L_0x0011
        L_0x013c:
            r0 = r4
            goto L_0x0149
        L_0x013e:
            java.lang.String r0 = "centerVertically"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x0148
            goto L_0x0011
        L_0x0148:
            r0 = r5
        L_0x0149:
            java.lang.String r7 = "parent"
            switch(r0) {
                case 0: goto L_0x02c7;
                case 1: goto L_0x02a5;
                case 2: goto L_0x02a1;
                case 3: goto L_0x0295;
                case 4: goto L_0x0289;
                case 5: goto L_0x027d;
                case 6: goto L_0x026d;
                case 7: goto L_0x025d;
                case 8: goto L_0x024d;
                case 9: goto L_0x0241;
                case 10: goto L_0x0239;
                case 11: goto L_0x022d;
                case 12: goto L_0x0221;
                case 13: goto L_0x0215;
                case 14: goto L_0x0209;
                case 15: goto L_0x01f3;
                case 16: goto L_0x01e7;
                case 17: goto L_0x01db;
                case 18: goto L_0x01cf;
                case 19: goto L_0x01c3;
                case 20: goto L_0x01b7;
                case 21: goto L_0x01ab;
                case 22: goto L_0x0194;
                case 23: goto L_0x0152;
                default: goto L_0x014e;
            }
        L_0x014e:
            parseConstraint(r8, r9, r11, r10, r12)
            return
        L_0x0152:
            java.lang.String r8 = r11.getString((java.lang.String) r12)
            r8.getClass()
            int r9 = r8.hashCode()
            switch(r9) {
                case -1901805651: goto L_0x0176;
                case 3178655: goto L_0x016b;
                case 466743410: goto L_0x0162;
                default: goto L_0x0160;
            }
        L_0x0160:
            r3 = r6
            goto L_0x0180
        L_0x0162:
            java.lang.String r9 = "visible"
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x0180
            goto L_0x0160
        L_0x016b:
            java.lang.String r9 = "gone"
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x0174
            goto L_0x0160
        L_0x0174:
            r3 = r4
            goto L_0x0180
        L_0x0176:
            java.lang.String r9 = "invisible"
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x017f
            goto L_0x0160
        L_0x017f:
            r3 = r5
        L_0x0180:
            switch(r3) {
                case 0: goto L_0x018c;
                case 1: goto L_0x0188;
                case 2: goto L_0x0184;
                default: goto L_0x0183;
            }
        L_0x0183:
            return
        L_0x0184:
            r10.visibility(r5)
            return
        L_0x0188:
            r10.visibility(r1)
            return
        L_0x018c:
            r10.visibility(r2)
            r8 = 0
            r10.alpha(r8)
            return
        L_0x0194:
            java.lang.String r9 = r11.getString((java.lang.String) r12)
            boolean r11 = r9.equals(r7)
            if (r11 == 0) goto L_0x01a0
            java.lang.Integer r9 = androidx.constraintlayout.core.state.State.PARENT
        L_0x01a0:
            androidx.constraintlayout.core.state.ConstraintReference r8 = r8.constraints(r9)
            r10.startToStart(r8)
            r10.endToEnd(r8)
            return
        L_0x01ab:
            androidx.constraintlayout.core.parser.CLElement r8 = r11.get((java.lang.String) r12)
            float r8 = r9.get(r8)
            r10.setHorizontalChainWeight(r8)
            return
        L_0x01b7:
            androidx.constraintlayout.core.state.CorePixelDp r9 = r8.getDpToPixel()
            androidx.constraintlayout.core.state.Dimension r8 = parseDimension(r11, r12, r8, r9)
            r10.setWidth(r8)
            return
        L_0x01c3:
            androidx.constraintlayout.core.parser.CLElement r8 = r11.get((java.lang.String) r12)
            float r8 = r9.get(r8)
            r10.verticalBias(r8)
            return
        L_0x01cf:
            androidx.constraintlayout.core.parser.CLElement r8 = r11.get((java.lang.String) r12)
            float r8 = r9.get(r8)
            r10.horizontalBias(r8)
            return
        L_0x01db:
            androidx.constraintlayout.core.parser.CLElement r8 = r11.get((java.lang.String) r12)
            float r8 = r9.get(r8)
            r10.alpha(r8)
            return
        L_0x01e7:
            androidx.constraintlayout.core.parser.CLElement r8 = r11.get((java.lang.String) r12)
            float r8 = r9.get(r8)
            r10.setVerticalChainWeight(r8)
            return
        L_0x01f3:
            androidx.constraintlayout.core.parser.CLElement r11 = r11.get((java.lang.String) r12)
            float r9 = r9.get(r11)
            boolean r8 = r8.isRtl()
            if (r8 == 0) goto L_0x0205
            r8 = 1065353216(0x3f800000, float:1.0)
            float r9 = r8 - r9
        L_0x0205:
            r10.horizontalBias(r9)
            return
        L_0x0209:
            androidx.constraintlayout.core.parser.CLElement r8 = r11.get((java.lang.String) r12)
            float r8 = r9.get(r8)
            r10.scaleY(r8)
            return
        L_0x0215:
            androidx.constraintlayout.core.parser.CLElement r8 = r11.get((java.lang.String) r12)
            float r8 = r9.get(r8)
            r10.scaleX(r8)
            return
        L_0x0221:
            androidx.constraintlayout.core.parser.CLElement r8 = r11.get((java.lang.String) r12)
            float r8 = r9.get(r8)
            r10.pivotY(r8)
            return
        L_0x022d:
            androidx.constraintlayout.core.parser.CLElement r8 = r11.get((java.lang.String) r12)
            float r8 = r9.get(r8)
            r10.pivotX(r8)
            return
        L_0x0239:
            androidx.constraintlayout.core.parser.CLElement r8 = r11.get((java.lang.String) r12)
            parseMotionProperties(r8, r10)
            return
        L_0x0241:
            androidx.constraintlayout.core.state.CorePixelDp r9 = r8.getDpToPixel()
            androidx.constraintlayout.core.state.Dimension r8 = parseDimension(r11, r12, r8, r9)
            r10.setHeight(r8)
            return
        L_0x024d:
            androidx.constraintlayout.core.parser.CLElement r11 = r11.get((java.lang.String) r12)
            float r9 = r9.get(r11)
            float r8 = toPix(r8, r9)
            r10.translationZ(r8)
            return
        L_0x025d:
            androidx.constraintlayout.core.parser.CLElement r11 = r11.get((java.lang.String) r12)
            float r9 = r9.get(r11)
            float r8 = toPix(r8, r9)
            r10.translationY(r8)
            return
        L_0x026d:
            androidx.constraintlayout.core.parser.CLElement r11 = r11.get((java.lang.String) r12)
            float r9 = r9.get(r11)
            float r8 = toPix(r8, r9)
            r10.translationX(r8)
            return
        L_0x027d:
            androidx.constraintlayout.core.parser.CLElement r8 = r11.get((java.lang.String) r12)
            float r8 = r9.get(r8)
            r10.rotationZ(r8)
            return
        L_0x0289:
            androidx.constraintlayout.core.parser.CLElement r8 = r11.get((java.lang.String) r12)
            float r8 = r9.get(r8)
            r10.rotationY(r8)
            return
        L_0x0295:
            androidx.constraintlayout.core.parser.CLElement r8 = r11.get((java.lang.String) r12)
            float r8 = r9.get(r8)
            r10.rotationX(r8)
            return
        L_0x02a1:
            parseCustomProperties(r11, r10, r12)
            return
        L_0x02a5:
            java.lang.String r9 = r11.getString((java.lang.String) r12)
            boolean r11 = r9.equals(r7)
            if (r11 == 0) goto L_0x02b6
            java.lang.Integer r9 = androidx.constraintlayout.core.state.State.PARENT
            androidx.constraintlayout.core.state.ConstraintReference r8 = r8.constraints(r9)
            goto L_0x02ba
        L_0x02b6:
            androidx.constraintlayout.core.state.ConstraintReference r8 = r8.constraints(r9)
        L_0x02ba:
            r10.startToStart(r8)
            r10.endToEnd(r8)
            r10.topToTop(r8)
            r10.bottomToBottom(r8)
            return
        L_0x02c7:
            java.lang.String r9 = r11.getString((java.lang.String) r12)
            boolean r11 = r9.equals(r7)
            if (r11 == 0) goto L_0x02d3
            java.lang.Integer r9 = androidx.constraintlayout.core.state.State.PARENT
        L_0x02d3:
            androidx.constraintlayout.core.state.ConstraintReference r8 = r8.constraints(r9)
            r10.topToTop(r8)
            r10.bottomToBottom(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.applyAttribute(androidx.constraintlayout.core.state.State, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.parser.CLObject, java.lang.String):void");
    }

    private static int indexOf(String str, String... strArr) {
        for (int i5 = 0; i5 < strArr.length; i5++) {
            if (strArr[i5].equals(str)) {
                return i5;
            }
        }
        return -1;
    }

    static String lookForType(CLObject cLObject) throws CLParsingException {
        ArrayList<String> names = cLObject.names();
        int size = names.size();
        int i5 = 0;
        while (i5 < size) {
            String str = names.get(i5);
            i5++;
            if (str.equals(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY)) {
                return cLObject.getString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
            }
        }
        return null;
    }

    static void override(CLObject cLObject, String str, CLObject cLObject2) throws CLParsingException {
        if (!cLObject.has(str)) {
            cLObject.put(str, cLObject2);
            return;
        }
        CLObject object = cLObject.getObject(str);
        ArrayList<String> names = cLObject2.names();
        int size = names.size();
        int i5 = 0;
        while (i5 < size) {
            String str2 = names.get(i5);
            i5++;
            String str3 = str2;
            if (!str3.equals("clear")) {
                object.put(str3, cLObject2.get(str3));
            } else {
                CLArray array = cLObject2.getArray("clear");
                for (int i6 = 0; i6 < array.size(); i6++) {
                    String stringOrNull = array.getStringOrNull(i6);
                    if (stringOrNull != null) {
                        char c5 = 65535;
                        switch (stringOrNull.hashCode()) {
                            case -1727069561:
                                if (stringOrNull.equals("transforms")) {
                                    c5 = 0;
                                    break;
                                }
                                break;
                            case -1606703562:
                                if (stringOrNull.equals("constraints")) {
                                    c5 = 1;
                                    break;
                                }
                                break;
                            case 414334925:
                                if (stringOrNull.equals("dimensions")) {
                                    c5 = 2;
                                    break;
                                }
                                break;
                        }
                        switch (c5) {
                            case 0:
                                object.remove("visibility");
                                object.remove("alpha");
                                object.remove("pivotX");
                                object.remove("pivotY");
                                object.remove("rotationX");
                                object.remove("rotationY");
                                object.remove("rotationZ");
                                object.remove("scaleX");
                                object.remove("scaleY");
                                object.remove("translationX");
                                object.remove("translationY");
                                break;
                            case 1:
                                object.remove("start");
                                object.remove(TtmlNode.END);
                                object.remove("top");
                                object.remove("bottom");
                                object.remove("baseline");
                                object.remove(TtmlNode.CENTER);
                                object.remove("centerHorizontally");
                                object.remove("centerVertically");
                                break;
                            case 2:
                                object.remove("width");
                                object.remove("height");
                                break;
                            default:
                                object.remove(stringOrNull);
                                break;
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00af, code lost:
        if (r5.equals("top") == false) goto L_0x0086;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void parseBarrier(androidx.constraintlayout.core.state.State r10, java.lang.String r11, androidx.constraintlayout.core.parser.CLObject r12) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            boolean r0 = r10.isRtl()
            androidx.constraintlayout.core.state.State$Direction r1 = androidx.constraintlayout.core.state.State.Direction.END
            androidx.constraintlayout.core.state.helpers.BarrierReference r11 = r10.barrier(r11, r1)
            java.util.ArrayList r1 = r12.names()
            if (r1 != 0) goto L_0x0012
            goto L_0x011f
        L_0x0012:
            int r2 = r1.size()
            r3 = 0
            r4 = r3
        L_0x0018:
            if (r4 >= r2) goto L_0x011f
            java.lang.Object r5 = r1.get(r4)
            int r4 = r4 + 1
            java.lang.String r5 = (java.lang.String) r5
            r5.getClass()
            int r6 = r5.hashCode()
            r7 = 2
            r8 = -1
            r9 = 1
            switch(r6) {
                case -1081309778: goto L_0x0047;
                case -962590849: goto L_0x003c;
                case -567445985: goto L_0x0031;
                default: goto L_0x002f;
            }
        L_0x002f:
            r6 = r8
            goto L_0x0051
        L_0x0031:
            java.lang.String r6 = "contains"
            boolean r6 = r5.equals(r6)
            if (r6 != 0) goto L_0x003a
            goto L_0x002f
        L_0x003a:
            r6 = r7
            goto L_0x0051
        L_0x003c:
            java.lang.String r6 = "direction"
            boolean r6 = r5.equals(r6)
            if (r6 != 0) goto L_0x0045
            goto L_0x002f
        L_0x0045:
            r6 = r9
            goto L_0x0051
        L_0x0047:
            java.lang.String r6 = "margin"
            boolean r6 = r5.equals(r6)
            if (r6 != 0) goto L_0x0050
            goto L_0x002f
        L_0x0050:
            r6 = r3
        L_0x0051:
            switch(r6) {
                case 0: goto L_0x0108;
                case 1: goto L_0x0078;
                case 2: goto L_0x0055;
                default: goto L_0x0054;
            }
        L_0x0054:
            goto L_0x0018
        L_0x0055:
            androidx.constraintlayout.core.parser.CLArray r5 = r12.getArrayOrNull(r5)
            if (r5 == 0) goto L_0x0018
            r6 = r3
        L_0x005c:
            int r7 = r5.size()
            if (r6 >= r7) goto L_0x0018
            androidx.constraintlayout.core.parser.CLElement r7 = r5.get((int) r6)
            java.lang.String r7 = r7.content()
            androidx.constraintlayout.core.state.ConstraintReference r7 = r10.constraints(r7)
            java.lang.Object[] r8 = new java.lang.Object[r9]
            r8[r3] = r7
            r11.add(r8)
            int r6 = r6 + 1
            goto L_0x005c
        L_0x0078:
            java.lang.String r5 = r12.getString((java.lang.String) r5)
            r5.getClass()
            int r6 = r5.hashCode()
            switch(r6) {
                case -1383228885: goto L_0x00bd;
                case 100571: goto L_0x00b2;
                case 115029: goto L_0x00a9;
                case 3317767: goto L_0x009e;
                case 108511772: goto L_0x0093;
                case 109757538: goto L_0x0088;
                default: goto L_0x0086;
            }
        L_0x0086:
            r7 = r8
            goto L_0x00c7
        L_0x0088:
            java.lang.String r6 = "start"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x0091
            goto L_0x0086
        L_0x0091:
            r7 = 5
            goto L_0x00c7
        L_0x0093:
            java.lang.String r6 = "right"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x009c
            goto L_0x0086
        L_0x009c:
            r7 = 4
            goto L_0x00c7
        L_0x009e:
            java.lang.String r6 = "left"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x00a7
            goto L_0x0086
        L_0x00a7:
            r7 = 3
            goto L_0x00c7
        L_0x00a9:
            java.lang.String r6 = "top"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x00c7
            goto L_0x0086
        L_0x00b2:
            java.lang.String r6 = "end"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x00bb
            goto L_0x0086
        L_0x00bb:
            r7 = r9
            goto L_0x00c7
        L_0x00bd:
            java.lang.String r6 = "bottom"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x00c6
            goto L_0x0086
        L_0x00c6:
            r7 = r3
        L_0x00c7:
            switch(r7) {
                case 0: goto L_0x0101;
                case 1: goto L_0x00f1;
                case 2: goto L_0x00ea;
                case 3: goto L_0x00e3;
                case 4: goto L_0x00dc;
                case 5: goto L_0x00cc;
                default: goto L_0x00ca;
            }
        L_0x00ca:
            goto L_0x0018
        L_0x00cc:
            if (r0 != 0) goto L_0x00d5
            androidx.constraintlayout.core.state.State$Direction r5 = androidx.constraintlayout.core.state.State.Direction.LEFT
            r11.setBarrierDirection(r5)
            goto L_0x0018
        L_0x00d5:
            androidx.constraintlayout.core.state.State$Direction r5 = androidx.constraintlayout.core.state.State.Direction.RIGHT
            r11.setBarrierDirection(r5)
            goto L_0x0018
        L_0x00dc:
            androidx.constraintlayout.core.state.State$Direction r5 = androidx.constraintlayout.core.state.State.Direction.RIGHT
            r11.setBarrierDirection(r5)
            goto L_0x0018
        L_0x00e3:
            androidx.constraintlayout.core.state.State$Direction r5 = androidx.constraintlayout.core.state.State.Direction.LEFT
            r11.setBarrierDirection(r5)
            goto L_0x0018
        L_0x00ea:
            androidx.constraintlayout.core.state.State$Direction r5 = androidx.constraintlayout.core.state.State.Direction.TOP
            r11.setBarrierDirection(r5)
            goto L_0x0018
        L_0x00f1:
            if (r0 != 0) goto L_0x00fa
            androidx.constraintlayout.core.state.State$Direction r5 = androidx.constraintlayout.core.state.State.Direction.RIGHT
            r11.setBarrierDirection(r5)
            goto L_0x0018
        L_0x00fa:
            androidx.constraintlayout.core.state.State$Direction r5 = androidx.constraintlayout.core.state.State.Direction.LEFT
            r11.setBarrierDirection(r5)
            goto L_0x0018
        L_0x0101:
            androidx.constraintlayout.core.state.State$Direction r5 = androidx.constraintlayout.core.state.State.Direction.BOTTOM
            r11.setBarrierDirection(r5)
            goto L_0x0018
        L_0x0108:
            float r5 = r12.getFloatOrNaN(r5)
            boolean r6 = java.lang.Float.isNaN(r5)
            if (r6 != 0) goto L_0x0018
            float r5 = toPix(r10, r5)
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            r11.margin((java.lang.Object) r5)
            goto L_0x0018
        L_0x011f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseBarrier(androidx.constraintlayout.core.state.State, java.lang.String, androidx.constraintlayout.core.parser.CLObject):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void parseChain(int r8, androidx.constraintlayout.core.state.State r9, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r10, androidx.constraintlayout.core.parser.CLArray r11) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            if (r8 != 0) goto L_0x0007
            androidx.constraintlayout.core.state.helpers.HorizontalChainReference r8 = r9.horizontalChain()
            goto L_0x000b
        L_0x0007:
            androidx.constraintlayout.core.state.helpers.VerticalChainReference r8 = r9.verticalChain()
        L_0x000b:
            r0 = 1
            androidx.constraintlayout.core.parser.CLElement r1 = r11.get((int) r0)
            boolean r2 = r1 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r2 == 0) goto L_0x00ae
            androidx.constraintlayout.core.parser.CLArray r1 = (androidx.constraintlayout.core.parser.CLArray) r1
            int r2 = r1.size()
            if (r2 >= r0) goto L_0x001e
            goto L_0x00ae
        L_0x001e:
            r2 = 0
            r3 = r2
        L_0x0020:
            int r4 = r1.size()
            if (r3 >= r4) goto L_0x0034
            java.lang.String r4 = r1.getString((int) r3)
            java.lang.Object[] r5 = new java.lang.Object[r0]
            r5[r2] = r4
            r8.add(r5)
            int r3 = r3 + 1
            goto L_0x0020
        L_0x0034:
            int r1 = r11.size()
            r3 = 2
            if (r1 <= r3) goto L_0x00ae
            androidx.constraintlayout.core.parser.CLElement r11 = r11.get((int) r3)
            boolean r1 = r11 instanceof androidx.constraintlayout.core.parser.CLObject
            if (r1 != 0) goto L_0x0044
            goto L_0x00ae
        L_0x0044:
            androidx.constraintlayout.core.parser.CLObject r11 = (androidx.constraintlayout.core.parser.CLObject) r11
            java.util.ArrayList r1 = r11.names()
            int r3 = r1.size()
            r4 = r2
        L_0x004f:
            if (r4 >= r3) goto L_0x00ae
            java.lang.Object r5 = r1.get(r4)
            int r4 = r4 + 1
            java.lang.String r5 = (java.lang.String) r5
            r5.getClass()
            java.lang.String r6 = "style"
            boolean r6 = r5.equals(r6)
            if (r6 != 0) goto L_0x0068
            parseConstraint(r9, r10, r11, r8, r5)
            goto L_0x004f
        L_0x0068:
            androidx.constraintlayout.core.parser.CLElement r5 = r11.get((java.lang.String) r5)
            boolean r6 = r5 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r6 == 0) goto L_0x0085
            r6 = r5
            androidx.constraintlayout.core.parser.CLArray r6 = (androidx.constraintlayout.core.parser.CLArray) r6
            int r7 = r6.size()
            if (r7 <= r0) goto L_0x0085
            java.lang.String r5 = r6.getString((int) r2)
            float r6 = r6.getFloat((int) r0)
            r8.bias((float) r6)
            goto L_0x0089
        L_0x0085:
            java.lang.String r5 = r5.content()
        L_0x0089:
            r5.getClass()
            java.lang.String r6 = "packed"
            boolean r6 = r5.equals(r6)
            if (r6 != 0) goto L_0x00a8
            java.lang.String r6 = "spread_inside"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x00a2
            androidx.constraintlayout.core.state.State$Chain r5 = androidx.constraintlayout.core.state.State.Chain.SPREAD
            r8.style(r5)
            goto L_0x004f
        L_0x00a2:
            androidx.constraintlayout.core.state.State$Chain r5 = androidx.constraintlayout.core.state.State.Chain.SPREAD_INSIDE
            r8.style(r5)
            goto L_0x004f
        L_0x00a8:
            androidx.constraintlayout.core.state.State$Chain r5 = androidx.constraintlayout.core.state.State.Chain.PACKED
            r8.style(r5)
            goto L_0x004f
        L_0x00ae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseChain(int, androidx.constraintlayout.core.state.State, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables, androidx.constraintlayout.core.parser.CLArray):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ee  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void parseChainType(java.lang.String r21, androidx.constraintlayout.core.state.State r22, java.lang.String r23, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r24, androidx.constraintlayout.core.parser.CLObject r25) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            r0 = r22
            r1 = r23
            r2 = r25
            r3 = 0
            r4 = r21
            char r4 = r4.charAt(r3)
            r5 = 104(0x68, float:1.46E-43)
            if (r4 != r5) goto L_0x0017
            androidx.constraintlayout.core.state.helpers.HorizontalChainReference r4 = r0.horizontalChain()
        L_0x0015:
            r5 = r4
            goto L_0x001c
        L_0x0017:
            androidx.constraintlayout.core.state.helpers.VerticalChainReference r4 = r0.verticalChain()
            goto L_0x0015
        L_0x001c:
            r5.setKey(r1)
            java.util.ArrayList r4 = r2.names()
            int r12 = r4.size()
            r6 = r3
        L_0x0028:
            if (r6 >= r12) goto L_0x0231
            java.lang.Object r7 = r4.get(r6)
            int r13 = r6 + 1
            java.lang.String r7 = (java.lang.String) r7
            r7.getClass()
            int r6 = r7.hashCode()
            r14 = 6
            r8 = 4
            r9 = 3
            r10 = 2
            r11 = 1
            r16 = -1
            switch(r6) {
                case -1383228885: goto L_0x009a;
                case -567445985: goto L_0x008e;
                case 100571: goto L_0x0082;
                case 115029: goto L_0x0076;
                case 3317767: goto L_0x006a;
                case 108511772: goto L_0x005e;
                case 109757538: goto L_0x0052;
                case 109780401: goto L_0x0045;
                default: goto L_0x0043;
            }
        L_0x0043:
            goto L_0x00a5
        L_0x0045:
            java.lang.String r6 = "style"
            boolean r6 = r7.equals(r6)
            if (r6 != 0) goto L_0x004f
            goto L_0x00a5
        L_0x004f:
            r16 = 7
            goto L_0x00a5
        L_0x0052:
            java.lang.String r6 = "start"
            boolean r6 = r7.equals(r6)
            if (r6 != 0) goto L_0x005b
            goto L_0x00a5
        L_0x005b:
            r16 = r14
            goto L_0x00a5
        L_0x005e:
            java.lang.String r6 = "right"
            boolean r6 = r7.equals(r6)
            if (r6 != 0) goto L_0x0067
            goto L_0x00a5
        L_0x0067:
            r16 = 5
            goto L_0x00a5
        L_0x006a:
            java.lang.String r6 = "left"
            boolean r6 = r7.equals(r6)
            if (r6 != 0) goto L_0x0073
            goto L_0x00a5
        L_0x0073:
            r16 = r8
            goto L_0x00a5
        L_0x0076:
            java.lang.String r6 = "top"
            boolean r6 = r7.equals(r6)
            if (r6 != 0) goto L_0x007f
            goto L_0x00a5
        L_0x007f:
            r16 = r9
            goto L_0x00a5
        L_0x0082:
            java.lang.String r6 = "end"
            boolean r6 = r7.equals(r6)
            if (r6 != 0) goto L_0x008b
            goto L_0x00a5
        L_0x008b:
            r16 = r10
            goto L_0x00a5
        L_0x008e:
            java.lang.String r6 = "contains"
            boolean r6 = r7.equals(r6)
            if (r6 != 0) goto L_0x0097
            goto L_0x00a5
        L_0x0097:
            r16 = r11
            goto L_0x00a5
        L_0x009a:
            java.lang.String r6 = "bottom"
            boolean r6 = r7.equals(r6)
            if (r6 != 0) goto L_0x00a3
            goto L_0x00a5
        L_0x00a3:
            r16 = r3
        L_0x00a5:
            switch(r16) {
                case 0: goto L_0x0225;
                case 1: goto L_0x00f4;
                case 2: goto L_0x0225;
                case 3: goto L_0x0225;
                case 4: goto L_0x0225;
                case 5: goto L_0x0225;
                case 6: goto L_0x0225;
                case 7: goto L_0x00ae;
                default: goto L_0x00a8;
            }
        L_0x00a8:
            r17 = r3
            r3 = r24
            goto L_0x022c
        L_0x00ae:
            androidx.constraintlayout.core.parser.CLElement r6 = r2.get((java.lang.String) r7)
            boolean r7 = r6 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r7 == 0) goto L_0x00cb
            r7 = r6
            androidx.constraintlayout.core.parser.CLArray r7 = (androidx.constraintlayout.core.parser.CLArray) r7
            int r8 = r7.size()
            if (r8 <= r11) goto L_0x00cb
            java.lang.String r6 = r7.getString((int) r3)
            float r7 = r7.getFloat((int) r11)
            r5.bias((float) r7)
            goto L_0x00cf
        L_0x00cb:
            java.lang.String r6 = r6.content()
        L_0x00cf:
            r6.getClass()
            java.lang.String r7 = "packed"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x00ee
            java.lang.String r7 = "spread_inside"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x00e8
            androidx.constraintlayout.core.state.State$Chain r6 = androidx.constraintlayout.core.state.State.Chain.SPREAD
            r5.style(r6)
            goto L_0x00a8
        L_0x00e8:
            androidx.constraintlayout.core.state.State$Chain r6 = androidx.constraintlayout.core.state.State.Chain.SPREAD_INSIDE
            r5.style(r6)
            goto L_0x00a8
        L_0x00ee:
            androidx.constraintlayout.core.state.State$Chain r6 = androidx.constraintlayout.core.state.State.Chain.PACKED
            r5.style(r6)
            goto L_0x00a8
        L_0x00f4:
            androidx.constraintlayout.core.parser.CLElement r6 = r2.get((java.lang.String) r7)
            boolean r7 = r6 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r7 == 0) goto L_0x0202
            r7 = r6
            androidx.constraintlayout.core.parser.CLArray r7 = (androidx.constraintlayout.core.parser.CLArray) r7
            int r15 = r7.size()
            if (r15 >= r11) goto L_0x0107
            goto L_0x0202
        L_0x0107:
            r15 = r3
        L_0x0108:
            int r6 = r7.size()
            if (r15 >= r6) goto L_0x00a8
            androidx.constraintlayout.core.parser.CLElement r6 = r7.get((int) r15)
            boolean r11 = r6 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r11 == 0) goto L_0x01e1
            androidx.constraintlayout.core.parser.CLArray r6 = (androidx.constraintlayout.core.parser.CLArray) r6
            int r11 = r6.size()
            if (r11 <= 0) goto L_0x01d8
            androidx.constraintlayout.core.parser.CLElement r11 = r6.get((int) r3)
            java.lang.String r11 = r11.content()
            r17 = r3
            int r3 = r6.size()
            r18 = 2143289344(0x7fc00000, float:NaN)
            if (r3 == r10) goto L_0x01bf
            if (r3 == r9) goto L_0x01a2
            if (r3 == r8) goto L_0x017c
            if (r3 == r14) goto L_0x0145
            r3 = r7
            r19 = r8
            r20 = r9
            r6 = r11
            r7 = r18
            r8 = r7
            r9 = r8
            r10 = r9
            r11 = r10
            r14 = 1
            goto L_0x01d4
        L_0x0145:
            r3 = 1
            float r18 = r6.getFloat((int) r3)
            float r14 = r6.getFloat((int) r10)
            float r14 = toPix(r0, r14)
            float r10 = r6.getFloat((int) r9)
            float r10 = toPix(r0, r10)
            float r9 = r6.getFloat((int) r8)
            float r9 = toPix(r0, r9)
            r3 = 5
            float r6 = r6.getFloat((int) r3)
            float r6 = toPix(r0, r6)
            r3 = r11
            r11 = r6
            r6 = r3
            r3 = r10
            r10 = r9
            r9 = r3
            r3 = r7
            r19 = r8
            r8 = r14
            r7 = r18
            r14 = 1
            r20 = 3
            goto L_0x01d4
        L_0x017c:
            r3 = 5
            r9 = 1
            float r10 = r6.getFloat((int) r9)
            r14 = 2
            float r3 = r6.getFloat((int) r14)
            float r3 = toPix(r0, r3)
            r8 = 3
            float r6 = r6.getFloat((int) r8)
            float r6 = toPix(r0, r6)
            r20 = r8
            r14 = r9
            r19 = 4
            r8 = r3
            r9 = r6
            r3 = r7
            r7 = r10
            r6 = r11
            r10 = r18
        L_0x01a0:
            r11 = r10
            goto L_0x01d4
        L_0x01a2:
            r8 = r9
            r14 = r10
            r9 = 1
            float r3 = r6.getFloat((int) r9)
            float r6 = r6.getFloat((int) r14)
            float r6 = toPix(r0, r6)
            r10 = r7
            r7 = r3
            r3 = r10
            r20 = r8
            r14 = r9
            r10 = r18
            r19 = 4
            r8 = r6
            r9 = r8
            r6 = r11
            goto L_0x01a0
        L_0x01bf:
            r8 = r9
            r14 = r10
            r9 = 1
            float r3 = r6.getFloat((int) r9)
            r6 = r7
            r7 = r3
            r3 = r6
            r20 = r8
            r14 = r9
            r6 = r11
            r8 = r18
            r9 = r8
            r10 = r9
            r11 = r10
            r19 = 4
        L_0x01d4:
            r5.addChainElement(r6, r7, r8, r9, r10, r11)
            goto L_0x01f4
        L_0x01d8:
            r17 = r3
            r3 = r7
            r19 = r8
            r20 = r9
            r14 = 1
            goto L_0x01f4
        L_0x01e1:
            r17 = r3
            r3 = r7
            r19 = r8
            r20 = r9
            r14 = 1
            java.lang.String r6 = r6.content()
            java.lang.Object[] r7 = new java.lang.Object[r14]
            r7[r17] = r6
            r5.add(r7)
        L_0x01f4:
            int r15 = r15 + 1
            r7 = r3
            r11 = r14
            r3 = r17
            r8 = r19
            r9 = r20
            r10 = 2
            r14 = 6
            goto L_0x0108
        L_0x0202:
            java.io.PrintStream r0 = java.lang.System.err
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r1 = " contains should be an array \""
            r2.append(r1)
            java.lang.String r1 = r6.content()
            r2.append(r1)
            java.lang.String r1 = "\""
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.println(r1)
            return
        L_0x0225:
            r17 = r3
            r3 = r24
            parseConstraint(r0, r3, r2, r5, r7)
        L_0x022c:
            r6 = r13
            r3 = r17
            goto L_0x0028
        L_0x0231:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseChainType(java.lang.String, androidx.constraintlayout.core.state.State, java.lang.String, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables, androidx.constraintlayout.core.parser.CLObject):void");
    }

    static long parseColorString(String str) {
        if (!str.startsWith("#")) {
            return -1;
        }
        String substring = str.substring(1);
        if (substring.length() == 6) {
            substring = "FF" + substring;
        }
        return Long.parseLong(substring, 16);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01d7, code lost:
        r0 = r4;
        r20 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01da, code lost:
        if (r20 == false) goto L_0x0231;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01dc, code lost:
        r5.getClass();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01e3, code lost:
        switch(r5.hashCode()) {
            case 100571: goto L_0x0207;
            case 3317767: goto L_0x01fd;
            case 108511772: goto L_0x01f3;
            case 109757538: goto L_0x01e9;
            default: goto L_0x01e6;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01e6, code lost:
        r16 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01ed, code lost:
        if (r5.equals("start") != false) goto L_0x01f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x01f0, code lost:
        r16 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x01f7, code lost:
        if (r5.equals(com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode.RIGHT) != false) goto L_0x01fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01fa, code lost:
        r16 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0201, code lost:
        if (r5.equals(com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode.LEFT) != false) goto L_0x0204;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0204, code lost:
        r16 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x020b, code lost:
        if (r5.equals(com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode.END) != false) goto L_0x020e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x020e, code lost:
        r16 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0210, code lost:
        switch(r16) {
            case 0: goto L_0x021a;
            case 1: goto L_0x0213;
            case 2: goto L_0x0218;
            case 3: goto L_0x0215;
            default: goto L_0x0213;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0213, code lost:
        r5 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0215, code lost:
        r5 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0218, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x021a, code lost:
        r5 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x021c, code lost:
        if (r0 == false) goto L_0x0228;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x021e, code lost:
        if (r5 == false) goto L_0x0224;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0220, code lost:
        r3.leftToLeft(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0224, code lost:
        r3.leftToRight(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0228, code lost:
        if (r5 == false) goto L_0x022e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x022a, code lost:
        r3.rightToLeft(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x022e, code lost:
        r3.rightToRight(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0231, code lost:
        r3.margin((java.lang.Object) java.lang.Float.valueOf(r24)).marginGone((java.lang.Object) java.lang.Float.valueOf(r14));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0240, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00d3, code lost:
        r4 = true;
        r15 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d9, code lost:
        r4 = true;
        r15 = 2;
        r20 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void parseConstraint(androidx.constraintlayout.core.state.State r22, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r23, androidx.constraintlayout.core.parser.CLObject r24, androidx.constraintlayout.core.state.ConstraintReference r25, java.lang.String r26) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r25
            r4 = r26
            boolean r5 = r0.isRtl()
            r6 = r5 ^ 1
            androidx.constraintlayout.core.parser.CLArray r7 = r2.getArrayOrNull(r4)
            java.lang.String r9 = "start"
            java.lang.String r10 = "end"
            java.lang.String r11 = "top"
            java.lang.String r12 = "bottom"
            java.lang.String r13 = "baseline"
            java.lang.String r15 = "parent"
            r8 = 0
            r14 = 1
            r18 = r5
            if (r7 == 0) goto L_0x0241
            int r5 = r7.size()
            if (r5 <= r14) goto L_0x0241
            java.lang.String r2 = r7.getString((int) r8)
            java.lang.String r5 = r7.getStringOrNull((int) r14)
            int r8 = r7.size()
            r19 = 0
            r14 = 2
            if (r8 <= r14) goto L_0x004a
            androidx.constraintlayout.core.parser.CLElement r8 = r7.getOrNull((int) r14)
            float r8 = r1.get(r8)
            float r8 = toPix(r0, r8)
            goto L_0x004c
        L_0x004a:
            r8 = r19
        L_0x004c:
            int r14 = r7.size()
            r21 = r6
            r6 = 3
            if (r14 <= r6) goto L_0x0062
            androidx.constraintlayout.core.parser.CLElement r14 = r7.getOrNull((int) r6)
            float r14 = r1.get(r14)
            float r14 = toPix(r0, r14)
            goto L_0x0064
        L_0x0062:
            r14 = r19
        L_0x0064:
            boolean r15 = r2.equals(r15)
            if (r15 == 0) goto L_0x0071
            java.lang.Integer r2 = androidx.constraintlayout.core.state.State.PARENT
            androidx.constraintlayout.core.state.ConstraintReference r2 = r0.constraints(r2)
            goto L_0x0075
        L_0x0071:
            androidx.constraintlayout.core.state.ConstraintReference r2 = r0.constraints(r2)
        L_0x0075:
            r4.getClass()
            int r15 = r4.hashCode()
            java.lang.String r6 = "right"
            r24 = r8
            java.lang.String r8 = "left"
            switch(r15) {
                case -1720785339: goto L_0x00c8;
                case -1498085729: goto L_0x00bd;
                case -1383228885: goto L_0x00b4;
                case 100571: goto L_0x00ab;
                case 115029: goto L_0x00a2;
                case 3317767: goto L_0x0099;
                case 108511772: goto L_0x0090;
                case 109757538: goto L_0x0087;
                default: goto L_0x0085;
            }
        L_0x0085:
            r4 = -1
            goto L_0x00d0
        L_0x0087:
            boolean r4 = r4.equals(r9)
            if (r4 != 0) goto L_0x008e
            goto L_0x0085
        L_0x008e:
            r4 = 7
            goto L_0x00d0
        L_0x0090:
            boolean r4 = r4.equals(r6)
            if (r4 != 0) goto L_0x0097
            goto L_0x0085
        L_0x0097:
            r4 = 6
            goto L_0x00d0
        L_0x0099:
            boolean r4 = r4.equals(r8)
            if (r4 != 0) goto L_0x00a0
            goto L_0x0085
        L_0x00a0:
            r4 = 5
            goto L_0x00d0
        L_0x00a2:
            boolean r4 = r4.equals(r11)
            if (r4 != 0) goto L_0x00a9
            goto L_0x0085
        L_0x00a9:
            r4 = 4
            goto L_0x00d0
        L_0x00ab:
            boolean r4 = r4.equals(r10)
            if (r4 != 0) goto L_0x00b2
            goto L_0x0085
        L_0x00b2:
            r4 = 3
            goto L_0x00d0
        L_0x00b4:
            boolean r4 = r4.equals(r12)
            if (r4 != 0) goto L_0x00bb
            goto L_0x0085
        L_0x00bb:
            r4 = 2
            goto L_0x00d0
        L_0x00bd:
            java.lang.String r15 = "circular"
            boolean r4 = r4.equals(r15)
            if (r4 != 0) goto L_0x00c6
            goto L_0x0085
        L_0x00c6:
            r4 = 1
            goto L_0x00d0
        L_0x00c8:
            boolean r4 = r4.equals(r13)
            if (r4 != 0) goto L_0x00cf
            goto L_0x0085
        L_0x00cf:
            r4 = 0
        L_0x00d0:
            switch(r4) {
                case 0: goto L_0x0184;
                case 1: goto L_0x0162;
                case 2: goto L_0x0123;
                case 3: goto L_0x0120;
                case 4: goto L_0x00e3;
                case 5: goto L_0x00e1;
                case 6: goto L_0x00df;
                case 7: goto L_0x00d7;
                default: goto L_0x00d3;
            }
        L_0x00d3:
            r4 = 1
            r15 = 2
            goto L_0x01d7
        L_0x00d7:
            r0 = r21
        L_0x00d9:
            r4 = 1
            r15 = 2
            r20 = 1
            goto L_0x01da
        L_0x00df:
            r0 = 0
            goto L_0x00d9
        L_0x00e1:
            r0 = 1
            goto L_0x00d9
        L_0x00e3:
            r5.getClass()
            int r1 = r5.hashCode()
            switch(r1) {
                case -1720785339: goto L_0x0101;
                case -1383228885: goto L_0x00f8;
                case 115029: goto L_0x00ef;
                default: goto L_0x00ed;
            }
        L_0x00ed:
            r1 = -1
            goto L_0x0109
        L_0x00ef:
            boolean r1 = r5.equals(r11)
            if (r1 != 0) goto L_0x00f6
            goto L_0x00ed
        L_0x00f6:
            r1 = 2
            goto L_0x0109
        L_0x00f8:
            boolean r1 = r5.equals(r12)
            if (r1 != 0) goto L_0x00ff
            goto L_0x00ed
        L_0x00ff:
            r1 = 1
            goto L_0x0109
        L_0x0101:
            boolean r1 = r5.equals(r13)
            if (r1 != 0) goto L_0x0108
            goto L_0x00ed
        L_0x0108:
            r1 = 0
        L_0x0109:
            switch(r1) {
                case 0: goto L_0x0115;
                case 1: goto L_0x0111;
                case 2: goto L_0x010d;
                default: goto L_0x010c;
            }
        L_0x010c:
            goto L_0x00d3
        L_0x010d:
            r3.topToTop(r2)
            goto L_0x00d3
        L_0x0111:
            r3.topToBottom(r2)
            goto L_0x00d3
        L_0x0115:
            java.lang.Object r1 = r2.getKey()
            r0.baselineNeededFor(r1)
            r3.topToBaseline(r2)
            goto L_0x00d3
        L_0x0120:
            r0 = r18
            goto L_0x00d9
        L_0x0123:
            r5.getClass()
            int r1 = r5.hashCode()
            switch(r1) {
                case -1720785339: goto L_0x0141;
                case -1383228885: goto L_0x0138;
                case 115029: goto L_0x012f;
                default: goto L_0x012d;
            }
        L_0x012d:
            r1 = -1
            goto L_0x0149
        L_0x012f:
            boolean r1 = r5.equals(r11)
            if (r1 != 0) goto L_0x0136
            goto L_0x012d
        L_0x0136:
            r1 = 2
            goto L_0x0149
        L_0x0138:
            boolean r1 = r5.equals(r12)
            if (r1 != 0) goto L_0x013f
            goto L_0x012d
        L_0x013f:
            r1 = 1
            goto L_0x0149
        L_0x0141:
            boolean r1 = r5.equals(r13)
            if (r1 != 0) goto L_0x0148
            goto L_0x012d
        L_0x0148:
            r1 = 0
        L_0x0149:
            switch(r1) {
                case 0: goto L_0x0156;
                case 1: goto L_0x0151;
                case 2: goto L_0x014d;
                default: goto L_0x014c;
            }
        L_0x014c:
            goto L_0x00d3
        L_0x014d:
            r3.bottomToTop(r2)
            goto L_0x00d3
        L_0x0151:
            r3.bottomToBottom(r2)
            goto L_0x00d3
        L_0x0156:
            java.lang.Object r1 = r2.getKey()
            r0.baselineNeededFor(r1)
            r3.bottomToBaseline(r2)
            goto L_0x00d3
        L_0x0162:
            r4 = 1
            androidx.constraintlayout.core.parser.CLElement r11 = r7.get((int) r4)
            float r11 = r1.get(r11)
            int r12 = r7.size()
            r15 = 2
            if (r12 <= r15) goto L_0x017e
            androidx.constraintlayout.core.parser.CLElement r7 = r7.getOrNull((int) r15)
            float r1 = r1.get(r7)
            float r19 = toPix(r0, r1)
        L_0x017e:
            r0 = r19
            r3.circularConstraint(r2, r11, r0)
            goto L_0x01d7
        L_0x0184:
            r4 = 1
            r15 = 2
            r5.getClass()
            int r1 = r5.hashCode()
            switch(r1) {
                case -1720785339: goto L_0x01a4;
                case -1383228885: goto L_0x019b;
                case 115029: goto L_0x0192;
                default: goto L_0x0190;
            }
        L_0x0190:
            r1 = -1
            goto L_0x01ac
        L_0x0192:
            boolean r1 = r5.equals(r11)
            if (r1 != 0) goto L_0x0199
            goto L_0x0190
        L_0x0199:
            r1 = r15
            goto L_0x01ac
        L_0x019b:
            boolean r1 = r5.equals(r12)
            if (r1 != 0) goto L_0x01a2
            goto L_0x0190
        L_0x01a2:
            r1 = r4
            goto L_0x01ac
        L_0x01a4:
            boolean r1 = r5.equals(r13)
            if (r1 != 0) goto L_0x01ab
            goto L_0x0190
        L_0x01ab:
            r1 = 0
        L_0x01ac:
            switch(r1) {
                case 0: goto L_0x01c6;
                case 1: goto L_0x01bb;
                case 2: goto L_0x01b0;
                default: goto L_0x01af;
            }
        L_0x01af:
            goto L_0x01d7
        L_0x01b0:
            java.lang.Object r1 = r3.getKey()
            r0.baselineNeededFor(r1)
            r3.baselineToTop(r2)
            goto L_0x01d7
        L_0x01bb:
            java.lang.Object r1 = r3.getKey()
            r0.baselineNeededFor(r1)
            r3.baselineToBottom(r2)
            goto L_0x01d7
        L_0x01c6:
            java.lang.Object r1 = r3.getKey()
            r0.baselineNeededFor(r1)
            java.lang.Object r1 = r2.getKey()
            r0.baselineNeededFor(r1)
            r3.baselineToBaseline(r2)
        L_0x01d7:
            r0 = r4
            r20 = 0
        L_0x01da:
            if (r20 == 0) goto L_0x0231
            r5.getClass()
            int r1 = r5.hashCode()
            switch(r1) {
                case 100571: goto L_0x0207;
                case 3317767: goto L_0x01fd;
                case 108511772: goto L_0x01f3;
                case 109757538: goto L_0x01e9;
                default: goto L_0x01e6;
            }
        L_0x01e6:
            r16 = -1
            goto L_0x0210
        L_0x01e9:
            boolean r1 = r5.equals(r9)
            if (r1 != 0) goto L_0x01f0
            goto L_0x01e6
        L_0x01f0:
            r16 = 3
            goto L_0x0210
        L_0x01f3:
            boolean r1 = r5.equals(r6)
            if (r1 != 0) goto L_0x01fa
            goto L_0x01e6
        L_0x01fa:
            r16 = r15
            goto L_0x0210
        L_0x01fd:
            boolean r1 = r5.equals(r8)
            if (r1 != 0) goto L_0x0204
            goto L_0x01e6
        L_0x0204:
            r16 = r4
            goto L_0x0210
        L_0x0207:
            boolean r1 = r5.equals(r10)
            if (r1 != 0) goto L_0x020e
            goto L_0x01e6
        L_0x020e:
            r16 = 0
        L_0x0210:
            switch(r16) {
                case 0: goto L_0x021a;
                case 1: goto L_0x0213;
                case 2: goto L_0x0218;
                case 3: goto L_0x0215;
                default: goto L_0x0213;
            }
        L_0x0213:
            r5 = r4
            goto L_0x021c
        L_0x0215:
            r5 = r21
            goto L_0x021c
        L_0x0218:
            r5 = 0
            goto L_0x021c
        L_0x021a:
            r5 = r18
        L_0x021c:
            if (r0 == 0) goto L_0x0228
            if (r5 == 0) goto L_0x0224
            r3.leftToLeft(r2)
            goto L_0x0231
        L_0x0224:
            r3.leftToRight(r2)
            goto L_0x0231
        L_0x0228:
            if (r5 == 0) goto L_0x022e
            r3.rightToLeft(r2)
            goto L_0x0231
        L_0x022e:
            r3.rightToRight(r2)
        L_0x0231:
            java.lang.Float r0 = java.lang.Float.valueOf(r24)
            androidx.constraintlayout.core.state.ConstraintReference r0 = r3.margin((java.lang.Object) r0)
            java.lang.Float r1 = java.lang.Float.valueOf(r14)
            r0.marginGone((java.lang.Object) r1)
            return
        L_0x0241:
            r20 = r14
            r17 = 2
            java.lang.String r1 = r2.getStringOrNull((java.lang.String) r4)
            if (r1 == 0) goto L_0x02c7
            boolean r2 = r1.equals(r15)
            if (r2 == 0) goto L_0x0258
            java.lang.Integer r1 = androidx.constraintlayout.core.state.State.PARENT
            androidx.constraintlayout.core.state.ConstraintReference r1 = r0.constraints(r1)
            goto L_0x025c
        L_0x0258:
            androidx.constraintlayout.core.state.ConstraintReference r1 = r0.constraints(r1)
        L_0x025c:
            r4.getClass()
            int r2 = r4.hashCode()
            switch(r2) {
                case -1720785339: goto L_0x028e;
                case -1383228885: goto L_0x0284;
                case 100571: goto L_0x027a;
                case 115029: goto L_0x0271;
                case 109757538: goto L_0x0268;
                default: goto L_0x0266;
            }
        L_0x0266:
            r8 = -1
            goto L_0x0296
        L_0x0268:
            boolean r2 = r4.equals(r9)
            if (r2 != 0) goto L_0x026f
            goto L_0x0266
        L_0x026f:
            r8 = 4
            goto L_0x0296
        L_0x0271:
            boolean r2 = r4.equals(r11)
            if (r2 != 0) goto L_0x0278
            goto L_0x0266
        L_0x0278:
            r8 = 3
            goto L_0x0296
        L_0x027a:
            boolean r2 = r4.equals(r10)
            if (r2 != 0) goto L_0x0281
            goto L_0x0266
        L_0x0281:
            r8 = r17
            goto L_0x0296
        L_0x0284:
            boolean r2 = r4.equals(r12)
            if (r2 != 0) goto L_0x028b
            goto L_0x0266
        L_0x028b:
            r8 = r20
            goto L_0x0296
        L_0x028e:
            boolean r2 = r4.equals(r13)
            if (r2 != 0) goto L_0x0295
            goto L_0x0266
        L_0x0295:
            r8 = 0
        L_0x0296:
            switch(r8) {
                case 0: goto L_0x02b6;
                case 1: goto L_0x02b2;
                case 2: goto L_0x02a8;
                case 3: goto L_0x02a4;
                case 4: goto L_0x029a;
                default: goto L_0x0299;
            }
        L_0x0299:
            goto L_0x02c7
        L_0x029a:
            if (r18 != 0) goto L_0x02a0
            r3.leftToLeft(r1)
            return
        L_0x02a0:
            r3.rightToRight(r1)
            return
        L_0x02a4:
            r3.topToTop(r1)
            return
        L_0x02a8:
            if (r18 != 0) goto L_0x02ae
            r3.rightToRight(r1)
            return
        L_0x02ae:
            r3.leftToLeft(r1)
            return
        L_0x02b2:
            r3.bottomToBottom(r1)
            return
        L_0x02b6:
            java.lang.Object r2 = r3.getKey()
            r0.baselineNeededFor(r2)
            java.lang.Object r2 = r1.getKey()
            r0.baselineNeededFor(r2)
            r3.baselineToBaseline(r1)
        L_0x02c7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseConstraint(androidx.constraintlayout.core.state.State, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables, androidx.constraintlayout.core.parser.CLObject, androidx.constraintlayout.core.state.ConstraintReference, java.lang.String):void");
    }

    static void parseConstraintSets(CoreMotionScene coreMotionScene, CLObject cLObject) throws CLParsingException {
        ArrayList<String> names = cLObject.names();
        if (names != null) {
            int size = names.size();
            int i5 = 0;
            while (i5 < size) {
                String str = names.get(i5);
                i5++;
                String str2 = str;
                CLObject object = cLObject.getObject(str2);
                String stringOrNull = object.getStringOrNull("Extends");
                if (stringOrNull == null || stringOrNull.isEmpty()) {
                    coreMotionScene.setConstraintSetContent(str2, object.toJSON());
                } else {
                    String constraintSet = coreMotionScene.getConstraintSet(stringOrNull);
                    if (constraintSet != null) {
                        CLObject parse = CLParser.parse(constraintSet);
                        ArrayList<String> names2 = object.names();
                        if (names2 != null) {
                            int size2 = names2.size();
                            int i6 = 0;
                            while (i6 < size2) {
                                String str3 = names2.get(i6);
                                i6++;
                                String str4 = str3;
                                CLElement cLElement = object.get(str4);
                                if (cLElement instanceof CLObject) {
                                    override(parse, str4, (CLObject) cLElement);
                                }
                            }
                            coreMotionScene.setConstraintSetContent(str2, parse.toJSON());
                        }
                    }
                }
            }
        }
    }

    static void parseCustomProperties(CLObject cLObject, ConstraintReference constraintReference, String str) throws CLParsingException {
        ArrayList<String> names;
        CLObject objectOrNull = cLObject.getObjectOrNull(str);
        if (objectOrNull != null && (names = objectOrNull.names()) != null) {
            int size = names.size();
            int i5 = 0;
            while (i5 < size) {
                String str2 = names.get(i5);
                i5++;
                String str3 = str2;
                CLElement cLElement = objectOrNull.get(str3);
                if (cLElement instanceof CLNumber) {
                    constraintReference.addCustomFloat(str3, cLElement.getFloat());
                } else if (cLElement instanceof CLString) {
                    long parseColorString = parseColorString(cLElement.content());
                    if (parseColorString != -1) {
                        constraintReference.addCustomColor(str3, (int) parseColorString);
                    }
                }
            }
        }
    }

    public static void parseDesignElementsJSON(String str, ArrayList<DesignElement> arrayList) throws CLParsingException {
        CLObject parse = CLParser.parse(str);
        ArrayList<String> names = parse.names();
        if (names != null && names.size() > 0) {
            String str2 = names.get(0);
            CLElement cLElement = parse.get(str2);
            str2.getClass();
            if (str2.equals("Design") && (cLElement instanceof CLObject)) {
                CLObject cLObject = (CLObject) cLElement;
                ArrayList<String> names2 = cLObject.names();
                for (int i5 = 0; i5 < names2.size(); i5++) {
                    String str3 = names2.get(i5);
                    CLObject cLObject2 = (CLObject) cLObject.get(str3);
                    System.out.printf("element found " + str3 + "", new Object[0]);
                    String stringOrNull = cLObject2.getStringOrNull(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
                    if (stringOrNull != null) {
                        HashMap hashMap = new HashMap();
                        int size = cLObject2.size();
                        for (int i6 = 0; i6 < size; i6++) {
                            CLKey cLKey = (CLKey) cLObject2.get(i5);
                            String content = cLKey.content();
                            String content2 = cLKey.getValue().content();
                            if (content2 != null) {
                                hashMap.put(content, content2);
                            }
                        }
                        arrayList.add(new DesignElement(str2, stringOrNull, hashMap));
                    }
                }
            }
        }
    }

    static Dimension parseDimension(CLObject cLObject, String str, State state, CorePixelDp corePixelDp) throws CLParsingException {
        CLElement cLElement = cLObject.get(str);
        Dimension createFixed = Dimension.createFixed(0);
        if (cLElement instanceof CLString) {
            return parseDimensionMode(cLElement.content());
        }
        if (cLElement instanceof CLNumber) {
            return Dimension.createFixed(state.convertDimension(Float.valueOf(corePixelDp.toPixels(cLObject.getFloat(str)))));
        }
        if (cLElement instanceof CLObject) {
            CLObject cLObject2 = (CLObject) cLElement;
            String stringOrNull = cLObject2.getStringOrNull("value");
            if (stringOrNull != null) {
                createFixed = parseDimensionMode(stringOrNull);
            }
            CLElement orNull = cLObject2.getOrNull("min");
            if (orNull != null) {
                if (orNull instanceof CLNumber) {
                    createFixed.min(state.convertDimension(Float.valueOf(corePixelDp.toPixels(((CLNumber) orNull).getFloat()))));
                } else if (orNull instanceof CLString) {
                    createFixed.min(Dimension.WRAP_DIMENSION);
                }
            }
            CLElement orNull2 = cLObject2.getOrNull("max");
            if (orNull2 != null) {
                if (orNull2 instanceof CLNumber) {
                    createFixed.max(state.convertDimension(Float.valueOf(corePixelDp.toPixels(((CLNumber) orNull2).getFloat()))));
                    return createFixed;
                } else if (orNull2 instanceof CLString) {
                    createFixed.max(Dimension.WRAP_DIMENSION);
                }
            }
        }
        return createFixed;
    }

    static Dimension parseDimensionMode(String str) {
        Dimension createFixed = Dimension.createFixed(0);
        str.getClass();
        char c5 = 65535;
        switch (str.hashCode()) {
            case -1460244870:
                if (str.equals("preferWrap")) {
                    c5 = 0;
                    break;
                }
                break;
            case -995424086:
                if (str.equals("parent")) {
                    c5 = 1;
                    break;
                }
                break;
            case -895684237:
                if (str.equals("spread")) {
                    c5 = 2;
                    break;
                }
                break;
            case 3657802:
                if (str.equals("wrap")) {
                    c5 = 3;
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
                return Dimension.createSuggested(Dimension.WRAP_DIMENSION);
            case 1:
                return Dimension.createParent();
            case 2:
                return Dimension.createSuggested(Dimension.SPREAD_DIMENSION);
            case 3:
                return Dimension.createWrap();
            default:
                if (str.endsWith("%")) {
                    return Dimension.createPercent(0, Float.parseFloat(str.substring(0, str.indexOf(37))) / 100.0f).suggested(0);
                }
                if (str.contains(":")) {
                    return Dimension.createRatio(str).suggested(Dimension.SPREAD_DIMENSION);
                }
                return createFixed;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ec, code lost:
        r11 = r8;
        r8 = r5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0266 A[Catch:{ NumberFormatException -> 0x026d }] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0316  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0323  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0330  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x03db A[Catch:{ NumberFormatException -> 0x026d }] */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x03ea A[Catch:{ NumberFormatException -> 0x026d }] */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x042a  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x0437  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x0444  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0257 A[Catch:{ NumberFormatException -> 0x026d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void parseFlowType(java.lang.String r19, androidx.constraintlayout.core.state.State r20, java.lang.String r21, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r22, androidx.constraintlayout.core.parser.CLObject r23) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            r0 = r20
            r1 = r21
            r2 = r23
            r3 = 1056964608(0x3f000000, float:0.5)
            java.lang.Float r4 = java.lang.Float.valueOf(r3)
            r5 = 0
            r6 = r19
            char r6 = r6.charAt(r5)
            r7 = 118(0x76, float:1.65E-43)
            r8 = 1
            if (r6 != r7) goto L_0x001a
            r6 = r8
            goto L_0x001b
        L_0x001a:
            r6 = r5
        L_0x001b:
            androidx.constraintlayout.core.state.helpers.FlowReference r6 = r0.getFlow(r1, r6)
            java.util.ArrayList r7 = r2.names()
            int r9 = r7.size()
            r10 = r5
        L_0x0028:
            if (r10 >= r9) goto L_0x0481
            java.lang.Object r11 = r7.get(r10)
            int r10 = r10 + 1
            java.lang.String r11 = (java.lang.String) r11
            r11.getClass()
            int r12 = r11.hashCode()
            r15 = 3
            r16 = r3
            r3 = 2
            switch(r12) {
                case -1254185091: goto L_0x00d3;
                case -1237307863: goto L_0x00c7;
                case -1198076529: goto L_0x00bb;
                case -853376977: goto L_0x00b0;
                case -836499749: goto L_0x00a5;
                case -806339567: goto L_0x009a;
                case -732635235: goto L_0x008f;
                case -567445985: goto L_0x0084;
                case -488900360: goto L_0x0077;
                case 3169614: goto L_0x006a;
                case 3575610: goto L_0x005d;
                case 3586688: goto L_0x0050;
                case 3657802: goto L_0x0043;
                default: goto L_0x0040;
            }
        L_0x0040:
            r12 = -1
            goto L_0x00de
        L_0x0043:
            java.lang.String r12 = "wrap"
            boolean r12 = r11.equals(r12)
            if (r12 != 0) goto L_0x004c
            goto L_0x0040
        L_0x004c:
            r12 = 12
            goto L_0x00de
        L_0x0050:
            java.lang.String r12 = "vGap"
            boolean r12 = r11.equals(r12)
            if (r12 != 0) goto L_0x0059
            goto L_0x0040
        L_0x0059:
            r12 = 11
            goto L_0x00de
        L_0x005d:
            java.lang.String r12 = "type"
            boolean r12 = r11.equals(r12)
            if (r12 != 0) goto L_0x0066
            goto L_0x0040
        L_0x0066:
            r12 = 10
            goto L_0x00de
        L_0x006a:
            java.lang.String r12 = "hGap"
            boolean r12 = r11.equals(r12)
            if (r12 != 0) goto L_0x0073
            goto L_0x0040
        L_0x0073:
            r12 = 9
            goto L_0x00de
        L_0x0077:
            java.lang.String r12 = "maxElement"
            boolean r12 = r11.equals(r12)
            if (r12 != 0) goto L_0x0080
            goto L_0x0040
        L_0x0080:
            r12 = 8
            goto L_0x00de
        L_0x0084:
            java.lang.String r12 = "contains"
            boolean r12 = r11.equals(r12)
            if (r12 != 0) goto L_0x008d
            goto L_0x0040
        L_0x008d:
            r12 = 7
            goto L_0x00de
        L_0x008f:
            java.lang.String r12 = "vFlowBias"
            boolean r12 = r11.equals(r12)
            if (r12 != 0) goto L_0x0098
            goto L_0x0040
        L_0x0098:
            r12 = 6
            goto L_0x00de
        L_0x009a:
            java.lang.String r12 = "padding"
            boolean r12 = r11.equals(r12)
            if (r12 != 0) goto L_0x00a3
            goto L_0x0040
        L_0x00a3:
            r12 = 5
            goto L_0x00de
        L_0x00a5:
            java.lang.String r12 = "vStyle"
            boolean r12 = r11.equals(r12)
            if (r12 != 0) goto L_0x00ae
            goto L_0x0040
        L_0x00ae:
            r12 = 4
            goto L_0x00de
        L_0x00b0:
            java.lang.String r12 = "vAlign"
            boolean r12 = r11.equals(r12)
            if (r12 != 0) goto L_0x00b9
            goto L_0x0040
        L_0x00b9:
            r12 = r15
            goto L_0x00de
        L_0x00bb:
            java.lang.String r12 = "hFlowBias"
            boolean r12 = r11.equals(r12)
            if (r12 != 0) goto L_0x00c5
            goto L_0x0040
        L_0x00c5:
            r12 = r3
            goto L_0x00de
        L_0x00c7:
            java.lang.String r12 = "hStyle"
            boolean r12 = r11.equals(r12)
            if (r12 != 0) goto L_0x00d1
            goto L_0x0040
        L_0x00d1:
            r12 = r8
            goto L_0x00de
        L_0x00d3:
            java.lang.String r12 = "hAlign"
            boolean r12 = r11.equals(r12)
            if (r12 != 0) goto L_0x00dd
            goto L_0x0040
        L_0x00dd:
            r12 = r5
        L_0x00de:
            java.lang.String r14 = ""
            switch(r12) {
                case 0: goto L_0x044d;
                case 1: goto L_0x03f3;
                case 2: goto L_0x038b;
                case 3: goto L_0x0339;
                case 4: goto L_0x02df;
                case 5: goto L_0x0271;
                case 6: goto L_0x0204;
                case 7: goto L_0x0146;
                case 8: goto L_0x0138;
                case 9: goto L_0x012a;
                case 10: goto L_0x0110;
                case 11: goto L_0x0102;
                case 12: goto L_0x00f0;
                default: goto L_0x00e3;
            }
        L_0x00e3:
            androidx.constraintlayout.core.state.ConstraintReference r3 = r20.constraints(r21)
            r12 = r22
            applyAttribute(r0, r12, r3, r2, r11)
        L_0x00ec:
            r11 = r8
            r8 = r5
            goto L_0x047b
        L_0x00f0:
            r12 = r22
            androidx.constraintlayout.core.parser.CLElement r3 = r2.get((java.lang.String) r11)
            java.lang.String r3 = r3.content()
            int r3 = androidx.constraintlayout.core.state.State.Wrap.getValueByString(r3)
            r6.setWrapMode(r3)
            goto L_0x00ec
        L_0x0102:
            r12 = r22
            androidx.constraintlayout.core.parser.CLElement r3 = r2.get((java.lang.String) r11)
            int r3 = r3.getInt()
            r6.setVerticalGap(r3)
            goto L_0x00ec
        L_0x0110:
            r12 = r22
            androidx.constraintlayout.core.parser.CLElement r3 = r2.get((java.lang.String) r11)
            java.lang.String r3 = r3.content()
            java.lang.String r11 = "hFlow"
            boolean r3 = r3.equals(r11)
            if (r3 == 0) goto L_0x0126
            r6.setOrientation(r5)
            goto L_0x00ec
        L_0x0126:
            r6.setOrientation(r8)
            goto L_0x00ec
        L_0x012a:
            r12 = r22
            androidx.constraintlayout.core.parser.CLElement r3 = r2.get((java.lang.String) r11)
            int r3 = r3.getInt()
            r6.setHorizontalGap(r3)
            goto L_0x00ec
        L_0x0138:
            r12 = r22
            androidx.constraintlayout.core.parser.CLElement r3 = r2.get((java.lang.String) r11)
            int r3 = r3.getInt()
            r6.setMaxElementsWrap(r3)
            goto L_0x00ec
        L_0x0146:
            r12 = r22
            androidx.constraintlayout.core.parser.CLElement r11 = r2.get((java.lang.String) r11)
            boolean r14 = r11 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r14 == 0) goto L_0x01e1
            r14 = r11
            androidx.constraintlayout.core.parser.CLArray r14 = (androidx.constraintlayout.core.parser.CLArray) r14
            int r13 = r14.size()
            if (r13 >= r8) goto L_0x015b
            goto L_0x01e1
        L_0x015b:
            r11 = r5
        L_0x015c:
            int r13 = r14.size()
            if (r11 >= r13) goto L_0x00ec
            androidx.constraintlayout.core.parser.CLElement r13 = r14.get((int) r11)
            boolean r8 = r13 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r8 == 0) goto L_0x01ca
            androidx.constraintlayout.core.parser.CLArray r13 = (androidx.constraintlayout.core.parser.CLArray) r13
            int r8 = r13.size()
            if (r8 <= 0) goto L_0x01c6
            androidx.constraintlayout.core.parser.CLElement r8 = r13.get((int) r5)
            java.lang.String r8 = r8.content()
            r17 = r5
            int r5 = r13.size()
            r18 = 2143289344(0x7fc00000, float:NaN)
            if (r5 == r3) goto L_0x01ba
            if (r5 == r15) goto L_0x01a9
            r15 = 4
            if (r5 == r15) goto L_0x018f
            r3 = r18
            r13 = r3
            r15 = r13
            r5 = 1
            goto L_0x01c2
        L_0x018f:
            r5 = 1
            float r18 = r13.getFloat((int) r5)
            float r15 = r13.getFloat((int) r3)
            float r15 = toPix(r0, r15)
            r3 = 3
            float r13 = r13.getFloat((int) r3)
            float r3 = toPix(r0, r13)
            r13 = r3
        L_0x01a6:
            r3 = r18
            goto L_0x01c2
        L_0x01a9:
            r5 = 1
            float r18 = r13.getFloat((int) r5)
            r3 = 2
            float r13 = r13.getFloat((int) r3)
            float r3 = toPix(r0, r13)
            r13 = r3
            r15 = r13
            goto L_0x01a6
        L_0x01ba:
            r5 = 1
            float r3 = r13.getFloat((int) r5)
            r13 = r18
            r15 = r13
        L_0x01c2:
            r6.addFlowElement(r8, r3, r15, r13)
            goto L_0x01d8
        L_0x01c6:
            r17 = r5
            r5 = 1
            goto L_0x01d8
        L_0x01ca:
            r17 = r5
            r5 = 1
            java.lang.String r3 = r13.content()
            java.lang.Object[] r8 = new java.lang.Object[r5]
            r8[r17] = r3
            r6.add(r8)
        L_0x01d8:
            int r11 = r11 + 1
            r5 = r17
            r3 = 2
            r8 = 1
            r15 = 3
            goto L_0x015c
        L_0x01e1:
            java.io.PrintStream r0 = java.lang.System.err
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r1 = " contains should be an array \""
            r2.append(r1)
            java.lang.String r1 = r11.content()
            r2.append(r1)
            java.lang.String r1 = "\""
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.println(r1)
            return
        L_0x0204:
            r12 = r22
            r17 = r5
            androidx.constraintlayout.core.parser.CLElement r3 = r2.get((java.lang.String) r11)
            boolean r5 = r3 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r5 == 0) goto L_0x023e
            r5 = r3
            androidx.constraintlayout.core.parser.CLArray r5 = (androidx.constraintlayout.core.parser.CLArray) r5
            int r8 = r5.size()
            r11 = 1
            if (r8 <= r11) goto L_0x023e
            r8 = r17
            float r3 = r5.getFloat((int) r8)
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            float r8 = r5.getFloat((int) r11)
            java.lang.Float r8 = java.lang.Float.valueOf(r8)
            int r11 = r5.size()
            r13 = 2
            if (r11 <= r13) goto L_0x023c
            float r5 = r5.getFloat((int) r13)
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            goto L_0x0248
        L_0x023c:
            r5 = r4
            goto L_0x0248
        L_0x023e:
            float r3 = r3.getFloat()
            java.lang.Float r8 = java.lang.Float.valueOf(r3)
            r3 = r4
            r5 = r3
        L_0x0248:
            float r8 = r8.floatValue()     // Catch:{ NumberFormatException -> 0x026d }
            r6.verticalBias(r8)     // Catch:{ NumberFormatException -> 0x026d }
            float r8 = r3.floatValue()     // Catch:{ NumberFormatException -> 0x026d }
            int r8 = (r8 > r16 ? 1 : (r8 == r16 ? 0 : -1))
            if (r8 == 0) goto L_0x025e
            float r3 = r3.floatValue()     // Catch:{ NumberFormatException -> 0x026d }
            r6.setFirstVerticalBias(r3)     // Catch:{ NumberFormatException -> 0x026d }
        L_0x025e:
            float r3 = r5.floatValue()     // Catch:{ NumberFormatException -> 0x026d }
            int r3 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            if (r3 == 0) goto L_0x026d
            float r3 = r5.floatValue()     // Catch:{ NumberFormatException -> 0x026d }
            r6.setLastVerticalBias(r3)     // Catch:{ NumberFormatException -> 0x026d }
        L_0x026d:
            r8 = 0
        L_0x026e:
            r11 = 1
            goto L_0x047b
        L_0x0271:
            r12 = r22
            androidx.constraintlayout.core.parser.CLElement r3 = r2.get((java.lang.String) r11)
            boolean r5 = r3 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r5 == 0) goto L_0x02aa
            r5 = r3
            androidx.constraintlayout.core.parser.CLArray r5 = (androidx.constraintlayout.core.parser.CLArray) r5
            int r8 = r5.size()
            r11 = 1
            if (r8 <= r11) goto L_0x02aa
            r8 = 0
            int r13 = r5.getInt((int) r8)
            float r8 = (float) r13
            int r13 = r5.getInt((int) r11)
            float r11 = (float) r13
            int r13 = r5.size()
            r14 = 2
            if (r13 <= r14) goto L_0x02a7
            int r5 = r5.getInt((int) r14)
            float r5 = (float) r5
            androidx.constraintlayout.core.parser.CLArray r3 = (androidx.constraintlayout.core.parser.CLArray) r3     // Catch:{ ArrayIndexOutOfBoundsException -> 0x02a5 }
            r13 = 3
            int r3 = r3.getInt((int) r13)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x02a5 }
            float r3 = (float) r3
            goto L_0x02b2
        L_0x02a5:
            r3 = 0
            goto L_0x02b2
        L_0x02a7:
            r5 = r8
            r3 = r11
            goto L_0x02b2
        L_0x02aa:
            int r3 = r3.getInt()
            float r8 = (float) r3
            r3 = r8
            r5 = r3
            r11 = r5
        L_0x02b2:
            float r8 = toPix(r0, r8)
            int r8 = java.lang.Math.round(r8)
            r6.setPaddingLeft(r8)
            float r8 = toPix(r0, r11)
            int r8 = java.lang.Math.round(r8)
            r6.setPaddingTop(r8)
            float r5 = toPix(r0, r5)
            int r5 = java.lang.Math.round(r5)
            r6.setPaddingRight(r5)
            float r3 = toPix(r0, r3)
            int r3 = java.lang.Math.round(r3)
            r6.setPaddingBottom(r3)
            goto L_0x026d
        L_0x02df:
            r12 = r22
            androidx.constraintlayout.core.parser.CLElement r3 = r2.get((java.lang.String) r11)
            boolean r5 = r3 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r5 == 0) goto L_0x030a
            r5 = r3
            androidx.constraintlayout.core.parser.CLArray r5 = (androidx.constraintlayout.core.parser.CLArray) r5
            int r8 = r5.size()
            r11 = 1
            if (r8 <= r11) goto L_0x030a
            r8 = 0
            java.lang.String r3 = r5.getString((int) r8)
            java.lang.String r8 = r5.getString((int) r11)
            int r11 = r5.size()
            r13 = 2
            if (r11 <= r13) goto L_0x0308
            java.lang.String r5 = r5.getString((int) r13)
            goto L_0x0310
        L_0x0308:
            r5 = r14
            goto L_0x0310
        L_0x030a:
            java.lang.String r8 = r3.content()
            r3 = r14
            r5 = r3
        L_0x0310:
            boolean r11 = r8.equals(r14)
            if (r11 != 0) goto L_0x031d
            int r8 = androidx.constraintlayout.core.state.State.Chain.getValueByString(r8)
            r6.setVerticalStyle(r8)
        L_0x031d:
            boolean r8 = r3.equals(r14)
            if (r8 != 0) goto L_0x032a
            int r3 = androidx.constraintlayout.core.state.State.Chain.getValueByString(r3)
            r6.setFirstVerticalStyle(r3)
        L_0x032a:
            boolean r3 = r5.equals(r14)
            if (r3 != 0) goto L_0x026d
            int r3 = androidx.constraintlayout.core.state.State.Chain.getValueByString(r5)
            r6.setLastVerticalStyle(r3)
            goto L_0x026d
        L_0x0339:
            r12 = r22
            androidx.constraintlayout.core.parser.CLElement r3 = r2.get((java.lang.String) r11)
            java.lang.String r3 = r3.content()
            r3.getClass()
            int r5 = r3.hashCode()
            switch(r5) {
                case -1720785339: goto L_0x0365;
                case -1383228885: goto L_0x035a;
                case 115029: goto L_0x034f;
                default: goto L_0x034d;
            }
        L_0x034d:
            r14 = -1
            goto L_0x036f
        L_0x034f:
            java.lang.String r5 = "top"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x0358
            goto L_0x034d
        L_0x0358:
            r14 = 2
            goto L_0x036f
        L_0x035a:
            java.lang.String r5 = "bottom"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x0363
            goto L_0x034d
        L_0x0363:
            r14 = 1
            goto L_0x036f
        L_0x0365:
            java.lang.String r5 = "baseline"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x036e
            goto L_0x034d
        L_0x036e:
            r14 = 0
        L_0x036f:
            switch(r14) {
                case 0: goto L_0x0382;
                case 1: goto L_0x037d;
                case 2: goto L_0x0378;
                default: goto L_0x0372;
            }
        L_0x0372:
            r13 = 2
            r6.setVerticalAlign(r13)
        L_0x0376:
            r5 = 1
            goto L_0x0387
        L_0x0378:
            r8 = 0
            r6.setVerticalAlign(r8)
            goto L_0x0376
        L_0x037d:
            r5 = 1
            r6.setVerticalAlign(r5)
            goto L_0x0387
        L_0x0382:
            r5 = 1
            r13 = 3
            r6.setVerticalAlign(r13)
        L_0x0387:
            r11 = r5
            r8 = 0
            goto L_0x047b
        L_0x038b:
            r12 = r22
            r5 = r8
            androidx.constraintlayout.core.parser.CLElement r3 = r2.get((java.lang.String) r11)
            boolean r8 = r3 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r8 == 0) goto L_0x03c2
            r8 = r3
            androidx.constraintlayout.core.parser.CLArray r8 = (androidx.constraintlayout.core.parser.CLArray) r8
            int r11 = r8.size()
            if (r11 <= r5) goto L_0x03c2
            r11 = 0
            float r3 = r8.getFloat((int) r11)
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            float r11 = r8.getFloat((int) r5)
            java.lang.Float r5 = java.lang.Float.valueOf(r11)
            int r11 = r8.size()
            r13 = 2
            if (r11 <= r13) goto L_0x03c0
            float r8 = r8.getFloat((int) r13)
            java.lang.Float r8 = java.lang.Float.valueOf(r8)
            goto L_0x03cc
        L_0x03c0:
            r8 = r4
            goto L_0x03cc
        L_0x03c2:
            float r3 = r3.getFloat()
            java.lang.Float r5 = java.lang.Float.valueOf(r3)
            r3 = r4
            r8 = r3
        L_0x03cc:
            float r5 = r5.floatValue()     // Catch:{ NumberFormatException -> 0x026d }
            r6.horizontalBias(r5)     // Catch:{ NumberFormatException -> 0x026d }
            float r5 = r3.floatValue()     // Catch:{ NumberFormatException -> 0x026d }
            int r5 = (r5 > r16 ? 1 : (r5 == r16 ? 0 : -1))
            if (r5 == 0) goto L_0x03e2
            float r3 = r3.floatValue()     // Catch:{ NumberFormatException -> 0x026d }
            r6.setFirstHorizontalBias(r3)     // Catch:{ NumberFormatException -> 0x026d }
        L_0x03e2:
            float r3 = r8.floatValue()     // Catch:{ NumberFormatException -> 0x026d }
            int r3 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            if (r3 == 0) goto L_0x026d
            float r3 = r8.floatValue()     // Catch:{ NumberFormatException -> 0x026d }
            r6.setLastHorizontalBias(r3)     // Catch:{ NumberFormatException -> 0x026d }
            goto L_0x026d
        L_0x03f3:
            r12 = r22
            androidx.constraintlayout.core.parser.CLElement r3 = r2.get((java.lang.String) r11)
            boolean r5 = r3 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r5 == 0) goto L_0x041e
            r5 = r3
            androidx.constraintlayout.core.parser.CLArray r5 = (androidx.constraintlayout.core.parser.CLArray) r5
            int r8 = r5.size()
            r11 = 1
            if (r8 <= r11) goto L_0x041e
            r8 = 0
            java.lang.String r3 = r5.getString((int) r8)
            java.lang.String r8 = r5.getString((int) r11)
            int r11 = r5.size()
            r13 = 2
            if (r11 <= r13) goto L_0x041c
            java.lang.String r5 = r5.getString((int) r13)
            goto L_0x0424
        L_0x041c:
            r5 = r14
            goto L_0x0424
        L_0x041e:
            java.lang.String r8 = r3.content()
            r3 = r14
            r5 = r3
        L_0x0424:
            boolean r11 = r8.equals(r14)
            if (r11 != 0) goto L_0x0431
            int r8 = androidx.constraintlayout.core.state.State.Chain.getValueByString(r8)
            r6.setHorizontalStyle(r8)
        L_0x0431:
            boolean r8 = r3.equals(r14)
            if (r8 != 0) goto L_0x043e
            int r3 = androidx.constraintlayout.core.state.State.Chain.getValueByString(r3)
            r6.setFirstHorizontalStyle(r3)
        L_0x043e:
            boolean r3 = r5.equals(r14)
            if (r3 != 0) goto L_0x026d
            int r3 = androidx.constraintlayout.core.state.State.Chain.getValueByString(r5)
            r6.setLastHorizontalStyle(r3)
            goto L_0x026d
        L_0x044d:
            r12 = r22
            androidx.constraintlayout.core.parser.CLElement r3 = r2.get((java.lang.String) r11)
            java.lang.String r3 = r3.content()
            r3.getClass()
            java.lang.String r5 = "end"
            boolean r5 = r3.equals(r5)
            if (r5 != 0) goto L_0x0476
            java.lang.String r5 = "start"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x0470
            r13 = 2
            r6.setHorizontalAlign(r13)
            goto L_0x026d
        L_0x0470:
            r8 = 0
            r6.setHorizontalAlign(r8)
            goto L_0x026e
        L_0x0476:
            r8 = 0
            r11 = 1
            r6.setHorizontalAlign(r11)
        L_0x047b:
            r5 = r8
            r8 = r11
            r3 = r16
            goto L_0x0028
        L_0x0481:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseFlowType(java.lang.String, androidx.constraintlayout.core.state.State, java.lang.String, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables, androidx.constraintlayout.core.parser.CLObject):void");
    }

    static void parseGenerate(State state, LayoutVariables layoutVariables, CLObject cLObject) throws CLParsingException {
        ArrayList<String> names = cLObject.names();
        if (names != null) {
            int size = names.size();
            int i5 = 0;
            while (i5 < size) {
                String str = names.get(i5);
                i5++;
                String str2 = str;
                CLElement cLElement = cLObject.get(str2);
                ArrayList<String> list = layoutVariables.getList(str2);
                if (list != null && (cLElement instanceof CLObject)) {
                    int size2 = list.size();
                    int i6 = 0;
                    while (i6 < size2) {
                        String str3 = list.get(i6);
                        i6++;
                        parseWidget(state, layoutVariables, str3, (CLObject) cLElement);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:79:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0164  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void parseGridType(java.lang.String r11, androidx.constraintlayout.core.state.State r12, java.lang.String r13, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r14, androidx.constraintlayout.core.parser.CLObject r15) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            androidx.constraintlayout.core.state.helpers.GridReference r11 = r12.getGrid(r13, r11)
            java.util.ArrayList r0 = r15.names()
            int r1 = r0.size()
            r2 = 0
            r3 = r2
        L_0x000e:
            if (r3 >= r1) goto L_0x0233
            java.lang.Object r4 = r0.get(r3)
            int r3 = r3 + 1
            java.lang.String r4 = (java.lang.String) r4
            r4.getClass()
            int r5 = r4.hashCode()
            r6 = 3
            r7 = 2
            r8 = 1
            r9 = -1
            switch(r5) {
                case -1439500848: goto L_0x00ad;
                case -806339567: goto L_0x00a2;
                case -567445985: goto L_0x0097;
                case 3169614: goto L_0x008c;
                case 3506649: goto L_0x0081;
                case 3586688: goto L_0x0076;
                case 97513095: goto L_0x006b;
                case 109497044: goto L_0x0060;
                case 109638249: goto L_0x0052;
                case 144441793: goto L_0x0044;
                case 949721053: goto L_0x0036;
                case 2033353925: goto L_0x0028;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x00b7
        L_0x0028:
            java.lang.String r5 = "columnWeights"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L_0x0032
            goto L_0x00b7
        L_0x0032:
            r9 = 11
            goto L_0x00b7
        L_0x0036:
            java.lang.String r5 = "columns"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L_0x0040
            goto L_0x00b7
        L_0x0040:
            r9 = 10
            goto L_0x00b7
        L_0x0044:
            java.lang.String r5 = "rowWeights"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L_0x004e
            goto L_0x00b7
        L_0x004e:
            r9 = 9
            goto L_0x00b7
        L_0x0052:
            java.lang.String r5 = "spans"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L_0x005c
            goto L_0x00b7
        L_0x005c:
            r9 = 8
            goto L_0x00b7
        L_0x0060:
            java.lang.String r5 = "skips"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L_0x0069
            goto L_0x00b7
        L_0x0069:
            r9 = 7
            goto L_0x00b7
        L_0x006b:
            java.lang.String r5 = "flags"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L_0x0074
            goto L_0x00b7
        L_0x0074:
            r9 = 6
            goto L_0x00b7
        L_0x0076:
            java.lang.String r5 = "vGap"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L_0x007f
            goto L_0x00b7
        L_0x007f:
            r9 = 5
            goto L_0x00b7
        L_0x0081:
            java.lang.String r5 = "rows"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L_0x008a
            goto L_0x00b7
        L_0x008a:
            r9 = 4
            goto L_0x00b7
        L_0x008c:
            java.lang.String r5 = "hGap"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L_0x0095
            goto L_0x00b7
        L_0x0095:
            r9 = r6
            goto L_0x00b7
        L_0x0097:
            java.lang.String r5 = "contains"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L_0x00a0
            goto L_0x00b7
        L_0x00a0:
            r9 = r7
            goto L_0x00b7
        L_0x00a2:
            java.lang.String r5 = "padding"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L_0x00ab
            goto L_0x00b7
        L_0x00ab:
            r9 = r8
            goto L_0x00b7
        L_0x00ad:
            java.lang.String r5 = "orientation"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L_0x00b6
            goto L_0x00b7
        L_0x00b6:
            r9 = r2
        L_0x00b7:
            java.lang.String r5 = ":"
            java.lang.String r10 = ","
            switch(r9) {
                case 0: goto L_0x0226;
                case 1: goto L_0x01bd;
                case 2: goto L_0x019a;
                case 3: goto L_0x0189;
                case 4: goto L_0x017a;
                case 5: goto L_0x0169;
                case 6: goto L_0x012a;
                case 7: goto L_0x0115;
                case 8: goto L_0x0100;
                case 9: goto L_0x00eb;
                case 10: goto L_0x00dc;
                case 11: goto L_0x00c7;
                default: goto L_0x00be;
            }
        L_0x00be:
            androidx.constraintlayout.core.state.ConstraintReference r5 = r12.constraints(r13)
            applyAttribute(r12, r14, r5, r15, r4)
            goto L_0x000e
        L_0x00c7:
            androidx.constraintlayout.core.parser.CLElement r4 = r15.get((java.lang.String) r4)
            java.lang.String r4 = r4.content()
            if (r4 == 0) goto L_0x000e
            boolean r5 = r4.contains(r10)
            if (r5 == 0) goto L_0x000e
            r11.setColumnWeights(r4)
            goto L_0x000e
        L_0x00dc:
            androidx.constraintlayout.core.parser.CLElement r4 = r15.get((java.lang.String) r4)
            int r4 = r4.getInt()
            if (r4 <= 0) goto L_0x000e
            r11.setColumnsSet(r4)
            goto L_0x000e
        L_0x00eb:
            androidx.constraintlayout.core.parser.CLElement r4 = r15.get((java.lang.String) r4)
            java.lang.String r4 = r4.content()
            if (r4 == 0) goto L_0x000e
            boolean r5 = r4.contains(r10)
            if (r5 == 0) goto L_0x000e
            r11.setRowWeights(r4)
            goto L_0x000e
        L_0x0100:
            androidx.constraintlayout.core.parser.CLElement r4 = r15.get((java.lang.String) r4)
            java.lang.String r4 = r4.content()
            if (r4 == 0) goto L_0x000e
            boolean r5 = r4.contains(r5)
            if (r5 == 0) goto L_0x000e
            r11.setSpans(r4)
            goto L_0x000e
        L_0x0115:
            androidx.constraintlayout.core.parser.CLElement r4 = r15.get((java.lang.String) r4)
            java.lang.String r4 = r4.content()
            if (r4 == 0) goto L_0x000e
            boolean r5 = r4.contains(r5)
            if (r5 == 0) goto L_0x000e
            r11.setSkips(r4)
            goto L_0x000e
        L_0x012a:
            java.lang.String r5 = ""
            androidx.constraintlayout.core.parser.CLElement r4 = r15.get((java.lang.String) r4)     // Catch:{ Exception -> 0x0139 }
            boolean r6 = r4 instanceof androidx.constraintlayout.core.parser.CLNumber     // Catch:{ Exception -> 0x0139 }
            if (r6 == 0) goto L_0x013b
            int r4 = r4.getInt()     // Catch:{ Exception -> 0x0139 }
            goto L_0x0157
        L_0x0139:
            r4 = move-exception
            goto L_0x0140
        L_0x013b:
            java.lang.String r5 = r4.content()     // Catch:{ Exception -> 0x0139 }
            goto L_0x0156
        L_0x0140:
            java.io.PrintStream r6 = java.lang.System.err
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Error parsing grid flags "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r4 = r7.toString()
            r6.println(r4)
        L_0x0156:
            r4 = r2
        L_0x0157:
            if (r5 == 0) goto L_0x0164
            boolean r6 = r5.isEmpty()
            if (r6 != 0) goto L_0x0164
            r11.setFlags((java.lang.String) r5)
            goto L_0x000e
        L_0x0164:
            r11.setFlags((int) r4)
            goto L_0x000e
        L_0x0169:
            androidx.constraintlayout.core.parser.CLElement r4 = r15.get((java.lang.String) r4)
            float r4 = r4.getFloat()
            float r4 = toPix(r12, r4)
            r11.setVerticalGaps(r4)
            goto L_0x000e
        L_0x017a:
            androidx.constraintlayout.core.parser.CLElement r4 = r15.get((java.lang.String) r4)
            int r4 = r4.getInt()
            if (r4 <= 0) goto L_0x000e
            r11.setRowsSet(r4)
            goto L_0x000e
        L_0x0189:
            androidx.constraintlayout.core.parser.CLElement r4 = r15.get((java.lang.String) r4)
            float r4 = r4.getFloat()
            float r4 = toPix(r12, r4)
            r11.setHorizontalGaps(r4)
            goto L_0x000e
        L_0x019a:
            androidx.constraintlayout.core.parser.CLArray r4 = r15.getArrayOrNull(r4)
            if (r4 == 0) goto L_0x000e
            r5 = r2
        L_0x01a1:
            int r6 = r4.size()
            if (r5 >= r6) goto L_0x000e
            androidx.constraintlayout.core.parser.CLElement r6 = r4.get((int) r5)
            java.lang.String r6 = r6.content()
            androidx.constraintlayout.core.state.ConstraintReference r6 = r12.constraints(r6)
            java.lang.Object[] r7 = new java.lang.Object[r8]
            r7[r2] = r6
            r11.add(r7)
            int r5 = r5 + 1
            goto L_0x01a1
        L_0x01bd:
            androidx.constraintlayout.core.parser.CLElement r4 = r15.get((java.lang.String) r4)
            boolean r5 = r4 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r5 == 0) goto L_0x01f0
            r5 = r4
            androidx.constraintlayout.core.parser.CLArray r5 = (androidx.constraintlayout.core.parser.CLArray) r5
            int r9 = r5.size()
            if (r9 <= r8) goto L_0x01f0
            int r9 = r5.getInt((int) r2)
            float r9 = (float) r9
            int r8 = r5.getInt((int) r8)
            float r8 = (float) r8
            int r10 = r5.size()
            if (r10 <= r7) goto L_0x01ed
            int r5 = r5.getInt((int) r7)
            float r5 = (float) r5
            androidx.constraintlayout.core.parser.CLArray r4 = (androidx.constraintlayout.core.parser.CLArray) r4     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01eb }
            int r4 = r4.getInt((int) r6)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01eb }
            float r4 = (float) r4
            goto L_0x01f8
        L_0x01eb:
            r4 = 0
            goto L_0x01f8
        L_0x01ed:
            r4 = r8
            r5 = r9
            goto L_0x01f8
        L_0x01f0:
            int r4 = r4.getInt()
            float r9 = (float) r4
            r4 = r9
            r5 = r4
            r8 = r5
        L_0x01f8:
            float r6 = toPix(r12, r9)
            int r6 = java.lang.Math.round(r6)
            r11.setPaddingStart(r6)
            float r6 = toPix(r12, r8)
            int r6 = java.lang.Math.round(r6)
            r11.setPaddingTop(r6)
            float r5 = toPix(r12, r5)
            int r5 = java.lang.Math.round(r5)
            r11.setPaddingEnd(r5)
            float r4 = toPix(r12, r4)
            int r4 = java.lang.Math.round(r4)
            r11.setPaddingBottom(r4)
            goto L_0x000e
        L_0x0226:
            androidx.constraintlayout.core.parser.CLElement r4 = r15.get((java.lang.String) r4)
            int r4 = r4.getInt()
            r11.setOrientation(r4)
            goto L_0x000e
        L_0x0233:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseGridType(java.lang.String, androidx.constraintlayout.core.state.State, java.lang.String, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables, androidx.constraintlayout.core.parser.CLObject):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r3 = (androidx.constraintlayout.core.parser.CLObject) r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void parseGuideline(int r1, androidx.constraintlayout.core.state.State r2, androidx.constraintlayout.core.parser.CLArray r3) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            r0 = 1
            androidx.constraintlayout.core.parser.CLElement r3 = r3.get((int) r0)
            boolean r0 = r3 instanceof androidx.constraintlayout.core.parser.CLObject
            if (r0 != 0) goto L_0x000a
            goto L_0x0014
        L_0x000a:
            androidx.constraintlayout.core.parser.CLObject r3 = (androidx.constraintlayout.core.parser.CLObject) r3
            java.lang.String r0 = "id"
            java.lang.String r0 = r3.getStringOrNull((java.lang.String) r0)
            if (r0 != 0) goto L_0x0015
        L_0x0014:
            return
        L_0x0015:
            parseGuidelineParams(r1, r2, r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseGuideline(int, androidx.constraintlayout.core.state.State, androidx.constraintlayout.core.parser.CLArray):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0093, code lost:
        r8 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a9, code lost:
        r10 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void parseGuidelineParams(int r19, androidx.constraintlayout.core.state.State r20, java.lang.String r21, androidx.constraintlayout.core.parser.CLObject r22) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            r0 = r20
            r1 = r22
            java.util.ArrayList r2 = r1.names()
            if (r2 != 0) goto L_0x000b
            return
        L_0x000b:
            androidx.constraintlayout.core.state.ConstraintReference r3 = r20.constraints(r21)
            if (r19 != 0) goto L_0x0015
            r20.horizontalGuideline(r21)
            goto L_0x0018
        L_0x0015:
            r20.verticalGuideline(r21)
        L_0x0018:
            boolean r4 = r0.isRtl()
            if (r4 == 0) goto L_0x0023
            if (r19 != 0) goto L_0x0021
            goto L_0x0023
        L_0x0021:
            r4 = 0
            goto L_0x0024
        L_0x0023:
            r4 = 1
        L_0x0024:
            androidx.constraintlayout.core.state.helpers.Facade r3 = r3.getFacade()
            androidx.constraintlayout.core.state.helpers.GuidelineReference r3 = (androidx.constraintlayout.core.state.helpers.GuidelineReference) r3
            int r7 = r2.size()
            r8 = 0
            r9 = 0
            r10 = 1
            r11 = 0
        L_0x0032:
            if (r11 >= r7) goto L_0x011a
            java.lang.Object r12 = r2.get(r11)
            int r11 = r11 + 1
            java.lang.String r12 = (java.lang.String) r12
            r12.getClass()
            int r13 = r12.hashCode()
            java.lang.String r14 = "start"
            java.lang.String r15 = "right"
            r16 = 2
            java.lang.String r5 = "left"
            java.lang.String r6 = "end"
            r18 = -1
            switch(r13) {
                case -678927291: goto L_0x007a;
                case 100571: goto L_0x0071;
                case 3317767: goto L_0x0067;
                case 108511772: goto L_0x005e;
                case 109757538: goto L_0x0055;
                default: goto L_0x0052;
            }
        L_0x0052:
            r13 = r18
            goto L_0x0084
        L_0x0055:
            boolean r13 = r12.equals(r14)
            if (r13 != 0) goto L_0x005c
            goto L_0x0052
        L_0x005c:
            r13 = 4
            goto L_0x0084
        L_0x005e:
            boolean r13 = r12.equals(r15)
            if (r13 != 0) goto L_0x0065
            goto L_0x0052
        L_0x0065:
            r13 = 3
            goto L_0x0084
        L_0x0067:
            boolean r13 = r12.equals(r5)
            if (r13 != 0) goto L_0x006e
            goto L_0x0052
        L_0x006e:
            r13 = r16
            goto L_0x0084
        L_0x0071:
            boolean r13 = r12.equals(r6)
            if (r13 != 0) goto L_0x0078
            goto L_0x0052
        L_0x0078:
            r13 = 1
            goto L_0x0084
        L_0x007a:
            java.lang.String r13 = "percent"
            boolean r13 = r12.equals(r13)
            if (r13 != 0) goto L_0x0083
            goto L_0x0052
        L_0x0083:
            r13 = 0
        L_0x0084:
            switch(r13) {
                case 0: goto L_0x00b6;
                case 1: goto L_0x00ab;
                case 2: goto L_0x00a0;
                case 3: goto L_0x0095;
                case 4: goto L_0x008a;
                default: goto L_0x0087;
            }
        L_0x0087:
            r12 = 0
            r13 = 1
            goto L_0x0032
        L_0x008a:
            float r5 = r1.getFloat((java.lang.String) r12)
            float r5 = toPix(r0, r5)
            r10 = r4
        L_0x0093:
            r8 = r5
            goto L_0x0087
        L_0x0095:
            float r5 = r1.getFloat((java.lang.String) r12)
            float r5 = toPix(r0, r5)
            r8 = r5
            r10 = 0
            goto L_0x0087
        L_0x00a0:
            float r5 = r1.getFloat((java.lang.String) r12)
            float r5 = toPix(r0, r5)
            r8 = r5
        L_0x00a9:
            r10 = 1
            goto L_0x0087
        L_0x00ab:
            float r5 = r1.getFloat((java.lang.String) r12)
            float r5 = toPix(r0, r5)
            r10 = r4 ^ 1
            goto L_0x0093
        L_0x00b6:
            androidx.constraintlayout.core.parser.CLArray r9 = r1.getArrayOrNull(r12)
            if (r9 != 0) goto L_0x00c3
            float r5 = r1.getFloat((java.lang.String) r12)
            r8 = r5
            r9 = 1
            goto L_0x00a9
        L_0x00c3:
            int r12 = r9.size()
            r13 = 1
            if (r12 <= r13) goto L_0x0118
            r12 = 0
            java.lang.String r8 = r9.getString((int) r12)
            float r9 = r9.getFloat((int) r13)
            r8.getClass()
            int r17 = r8.hashCode()
            switch(r17) {
                case 100571: goto L_0x00fc;
                case 3317767: goto L_0x00f3;
                case 108511772: goto L_0x00e9;
                case 109757538: goto L_0x00e0;
                default: goto L_0x00dd;
            }
        L_0x00dd:
            r15 = r18
            goto L_0x0104
        L_0x00e0:
            boolean r5 = r8.equals(r14)
            if (r5 != 0) goto L_0x00e7
            goto L_0x00dd
        L_0x00e7:
            r15 = 3
            goto L_0x0104
        L_0x00e9:
            boolean r5 = r8.equals(r15)
            if (r5 != 0) goto L_0x00f0
            goto L_0x00dd
        L_0x00f0:
            r15 = r16
            goto L_0x0104
        L_0x00f3:
            boolean r5 = r8.equals(r5)
            if (r5 != 0) goto L_0x00fa
            goto L_0x00dd
        L_0x00fa:
            r15 = r13
            goto L_0x0104
        L_0x00fc:
            boolean r5 = r8.equals(r6)
            if (r5 != 0) goto L_0x0103
            goto L_0x00dd
        L_0x0103:
            r15 = r12
        L_0x0104:
            switch(r15) {
                case 0: goto L_0x0115;
                case 1: goto L_0x0110;
                case 2: goto L_0x010d;
                case 3: goto L_0x010b;
                default: goto L_0x0107;
            }
        L_0x0107:
            r8 = r9
        L_0x0108:
            r9 = r13
            goto L_0x0032
        L_0x010b:
            r10 = r4
            goto L_0x0107
        L_0x010d:
            r8 = r9
            r10 = r12
            goto L_0x0108
        L_0x0110:
            r8 = r9
            r9 = r13
            r10 = r9
            goto L_0x0032
        L_0x0115:
            r10 = r4 ^ 1
            goto L_0x0107
        L_0x0118:
            r12 = 0
            goto L_0x0108
        L_0x011a:
            if (r9 == 0) goto L_0x0129
            if (r10 == 0) goto L_0x0122
            r3.percent(r8)
            return
        L_0x0122:
            r0 = 1065353216(0x3f800000, float:1.0)
            float r0 = r0 - r8
            r3.percent(r0)
            return
        L_0x0129:
            if (r10 == 0) goto L_0x0133
            java.lang.Float r0 = java.lang.Float.valueOf(r8)
            r3.start(r0)
            return
        L_0x0133:
            java.lang.Float r0 = java.lang.Float.valueOf(r8)
            r3.end(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseGuidelineParams(int, androidx.constraintlayout.core.state.State, java.lang.String, androidx.constraintlayout.core.parser.CLObject):void");
    }

    static void parseHeader(CoreMotionScene coreMotionScene, CLObject cLObject) {
        String stringOrNull = cLObject.getStringOrNull("export");
        if (stringOrNull != null) {
            coreMotionScene.setDebugName(stringOrNull);
        }
    }

    static void parseHelpers(State state, LayoutVariables layoutVariables, CLArray cLArray) throws CLParsingException {
        for (int i5 = 0; i5 < cLArray.size(); i5++) {
            CLElement cLElement = cLArray.get(i5);
            if (cLElement instanceof CLArray) {
                CLArray cLArray2 = (CLArray) cLElement;
                if (cLArray2.size() > 1) {
                    String string = cLArray2.getString(0);
                    string.getClass();
                    char c5 = 65535;
                    switch (string.hashCode()) {
                        case -1785507558:
                            if (string.equals("vGuideline")) {
                                c5 = 0;
                                break;
                            }
                            break;
                        case -1252464839:
                            if (string.equals("hChain")) {
                                c5 = 1;
                                break;
                            }
                            break;
                        case -851656725:
                            if (string.equals("vChain")) {
                                c5 = 2;
                                break;
                            }
                            break;
                        case 965681512:
                            if (string.equals("hGuideline")) {
                                c5 = 3;
                                break;
                            }
                            break;
                    }
                    switch (c5) {
                        case 0:
                            parseGuideline(1, state, cLArray2);
                            break;
                        case 1:
                            parseChain(0, state, layoutVariables, cLArray2);
                            break;
                        case 2:
                            parseChain(1, state, layoutVariables, cLArray2);
                            break;
                        case 3:
                            parseGuideline(0, state, cLArray2);
                            break;
                    }
                }
            }
        }
    }

    public static void parseJSON(String str, Transition transition, int i5) {
        CLObject objectOrNull;
        Transition transition2 = transition;
        int i6 = i5;
        try {
            CLObject parse = CLParser.parse(str);
            ArrayList<String> names = parse.names();
            if (names != null) {
                int size = names.size();
                int i7 = 0;
                while (i7 < size) {
                    String str2 = names.get(i7);
                    i7++;
                    String str3 = str2;
                    CLElement cLElement = parse.get(str3);
                    if ((cLElement instanceof CLObject) && (objectOrNull = ((CLObject) cLElement).getObjectOrNull("custom")) != null) {
                        ArrayList<String> names2 = objectOrNull.names();
                        int size2 = names2.size();
                        int i8 = 0;
                        while (i8 < size2) {
                            String str4 = names2.get(i8);
                            i8++;
                            String str5 = str4;
                            CLElement cLElement2 = objectOrNull.get(str5);
                            if (cLElement2 instanceof CLNumber) {
                                transition2.addCustomFloat(i6, str3, str5, cLElement2.getFloat());
                            } else if (cLElement2 instanceof CLString) {
                                long parseColorString = parseColorString(cLElement2.content());
                                if (parseColorString != -1) {
                                    transition2.addCustomColor(i6, str3, str5, (int) parseColorString);
                                }
                            }
                        }
                    }
                }
            }
        } catch (CLParsingException e5) {
            System.err.println("Error parsing JSON " + e5);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void parseMotionProperties(androidx.constraintlayout.core.parser.CLElement r14, androidx.constraintlayout.core.state.ConstraintReference r15) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            boolean r0 = r14 instanceof androidx.constraintlayout.core.parser.CLObject
            if (r0 != 0) goto L_0x0005
            goto L_0x0012
        L_0x0005:
            androidx.constraintlayout.core.parser.CLObject r14 = (androidx.constraintlayout.core.parser.CLObject) r14
            androidx.constraintlayout.core.motion.utils.TypedBundle r0 = new androidx.constraintlayout.core.motion.utils.TypedBundle
            r0.<init>()
            java.util.ArrayList r1 = r14.names()
            if (r1 != 0) goto L_0x0013
        L_0x0012:
            return
        L_0x0013:
            int r2 = r1.size()
            r3 = 0
            r4 = r3
        L_0x0019:
            if (r4 >= r2) goto L_0x010b
            java.lang.Object r5 = r1.get(r4)
            int r4 = r4 + 1
            java.lang.String r5 = (java.lang.String) r5
            r5.getClass()
            int r6 = r5.hashCode()
            r7 = -1
            r8 = 2
            r9 = 1
            switch(r6) {
                case -1897525331: goto L_0x005e;
                case -1310311125: goto L_0x0053;
                case -1285003983: goto L_0x0048;
                case -791482387: goto L_0x003d;
                case -236944793: goto L_0x0032;
                default: goto L_0x0030;
            }
        L_0x0030:
            r6 = r7
            goto L_0x0068
        L_0x0032:
            java.lang.String r6 = "relativeTo"
            boolean r6 = r5.equals(r6)
            if (r6 != 0) goto L_0x003b
            goto L_0x0030
        L_0x003b:
            r6 = 4
            goto L_0x0068
        L_0x003d:
            java.lang.String r6 = "pathArc"
            boolean r6 = r5.equals(r6)
            if (r6 != 0) goto L_0x0046
            goto L_0x0030
        L_0x0046:
            r6 = 3
            goto L_0x0068
        L_0x0048:
            java.lang.String r6 = "quantize"
            boolean r6 = r5.equals(r6)
            if (r6 != 0) goto L_0x0051
            goto L_0x0030
        L_0x0051:
            r6 = r8
            goto L_0x0068
        L_0x0053:
            java.lang.String r6 = "easing"
            boolean r6 = r5.equals(r6)
            if (r6 != 0) goto L_0x005c
            goto L_0x0030
        L_0x005c:
            r6 = r9
            goto L_0x0068
        L_0x005e:
            java.lang.String r6 = "stagger"
            boolean r6 = r5.equals(r6)
            if (r6 != 0) goto L_0x0067
            goto L_0x0030
        L_0x0067:
            r6 = r3
        L_0x0068:
            switch(r6) {
                case 0: goto L_0x0100;
                case 1: goto L_0x00f5;
                case 2: goto L_0x00bb;
                case 3: goto L_0x0076;
                case 4: goto L_0x006c;
                default: goto L_0x006b;
            }
        L_0x006b:
            goto L_0x0019
        L_0x006c:
            r6 = 605(0x25d, float:8.48E-43)
            java.lang.String r5 = r14.getString((java.lang.String) r5)
            r0.add((int) r6, (java.lang.String) r5)
            goto L_0x0019
        L_0x0076:
            java.lang.String r5 = r14.getString((java.lang.String) r5)
            java.lang.String r12 = "below"
            java.lang.String r13 = "above"
            java.lang.String r8 = "none"
            java.lang.String r9 = "startVertical"
            java.lang.String r10 = "startHorizontal"
            java.lang.String r11 = "flip"
            java.lang.String[] r6 = new java.lang.String[]{r8, r9, r10, r11, r12, r13}
            int r6 = indexOf(r5, r6)
            if (r6 != r7) goto L_0x00b4
            java.io.PrintStream r6 = java.lang.System.err
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            int r8 = r14.getLine()
            r7.append(r8)
            java.lang.String r8 = " pathArc = '"
            r7.append(r8)
            r7.append(r5)
            java.lang.String r5 = "'"
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r6.println(r5)
            goto L_0x0019
        L_0x00b4:
            r5 = 607(0x25f, float:8.5E-43)
            r0.add((int) r5, (int) r6)
            goto L_0x0019
        L_0x00bb:
            androidx.constraintlayout.core.parser.CLElement r6 = r14.get((java.lang.String) r5)
            boolean r7 = r6 instanceof androidx.constraintlayout.core.parser.CLArray
            r10 = 610(0x262, float:8.55E-43)
            if (r7 == 0) goto L_0x00ec
            androidx.constraintlayout.core.parser.CLArray r6 = (androidx.constraintlayout.core.parser.CLArray) r6
            int r5 = r6.size()
            if (r5 <= 0) goto L_0x0019
            int r7 = r6.getInt((int) r3)
            r0.add((int) r10, (int) r7)
            if (r5 <= r9) goto L_0x0019
            r7 = 611(0x263, float:8.56E-43)
            java.lang.String r9 = r6.getString((int) r9)
            r0.add((int) r7, (java.lang.String) r9)
            if (r5 <= r8) goto L_0x0019
            r5 = 602(0x25a, float:8.44E-43)
            float r6 = r6.getFloat((int) r8)
            r0.add((int) r5, (float) r6)
            goto L_0x0019
        L_0x00ec:
            int r5 = r14.getInt((java.lang.String) r5)
            r0.add((int) r10, (int) r5)
            goto L_0x0019
        L_0x00f5:
            r6 = 603(0x25b, float:8.45E-43)
            java.lang.String r5 = r14.getString((java.lang.String) r5)
            r0.add((int) r6, (java.lang.String) r5)
            goto L_0x0019
        L_0x0100:
            r6 = 600(0x258, float:8.41E-43)
            float r5 = r14.getFloat((java.lang.String) r5)
            r0.add((int) r6, (float) r5)
            goto L_0x0019
        L_0x010b:
            r15.mMotionProperties = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseMotionProperties(androidx.constraintlayout.core.parser.CLElement, androidx.constraintlayout.core.state.ConstraintReference):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x005d A[Catch:{ CLParsingException -> 0x006f }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006a A[Catch:{ CLParsingException -> 0x006f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void parseMotionSceneJSON(androidx.constraintlayout.core.state.CoreMotionScene r10, java.lang.String r11) {
        /*
            androidx.constraintlayout.core.parser.CLObject r11 = androidx.constraintlayout.core.parser.CLParser.parse(r11)     // Catch:{ CLParsingException -> 0x006f }
            java.util.ArrayList r0 = r11.names()     // Catch:{ CLParsingException -> 0x006f }
            if (r0 != 0) goto L_0x000c
            goto L_0x006e
        L_0x000c:
            int r1 = r0.size()     // Catch:{ CLParsingException -> 0x006f }
            r2 = 0
            r3 = r2
        L_0x0012:
            if (r3 >= r1) goto L_0x006e
            java.lang.Object r4 = r0.get(r3)     // Catch:{ CLParsingException -> 0x006f }
            int r3 = r3 + 1
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ CLParsingException -> 0x006f }
            androidx.constraintlayout.core.parser.CLElement r5 = r11.get((java.lang.String) r4)     // Catch:{ CLParsingException -> 0x006f }
            boolean r6 = r5 instanceof androidx.constraintlayout.core.parser.CLObject     // Catch:{ CLParsingException -> 0x006f }
            if (r6 == 0) goto L_0x0012
            androidx.constraintlayout.core.parser.CLObject r5 = (androidx.constraintlayout.core.parser.CLObject) r5     // Catch:{ CLParsingException -> 0x006f }
            int r6 = r4.hashCode()     // Catch:{ CLParsingException -> 0x006f }
            r7 = -2137403731(0xffffffff8099cead, float:-1.4124972E-38)
            r8 = 2
            r9 = 1
            if (r6 == r7) goto L_0x0050
            r7 = -241441378(0xfffffffff19be59e, float:-1.5439285E30)
            if (r6 == r7) goto L_0x0046
            r7 = 1101852654(0x41acefee, float:21.617153)
            if (r6 == r7) goto L_0x003c
            goto L_0x005a
        L_0x003c:
            java.lang.String r6 = "ConstraintSets"
            boolean r4 = r4.equals(r6)     // Catch:{ CLParsingException -> 0x006f }
            if (r4 == 0) goto L_0x005a
            r4 = r2
            goto L_0x005b
        L_0x0046:
            java.lang.String r6 = "Transitions"
            boolean r4 = r4.equals(r6)     // Catch:{ CLParsingException -> 0x006f }
            if (r4 == 0) goto L_0x005a
            r4 = r9
            goto L_0x005b
        L_0x0050:
            java.lang.String r6 = "Header"
            boolean r4 = r4.equals(r6)     // Catch:{ CLParsingException -> 0x006f }
            if (r4 == 0) goto L_0x005a
            r4 = r8
            goto L_0x005b
        L_0x005a:
            r4 = -1
        L_0x005b:
            if (r4 == 0) goto L_0x006a
            if (r4 == r9) goto L_0x0066
            if (r4 == r8) goto L_0x0062
            goto L_0x0012
        L_0x0062:
            parseHeader(r10, r5)     // Catch:{ CLParsingException -> 0x006f }
            goto L_0x0012
        L_0x0066:
            parseTransitions(r10, r5)     // Catch:{ CLParsingException -> 0x006f }
            goto L_0x0012
        L_0x006a:
            parseConstraintSets(r10, r5)     // Catch:{ CLParsingException -> 0x006f }
            goto L_0x0012
        L_0x006e:
            return
        L_0x006f:
            r10 = move-exception
            java.io.PrintStream r11 = java.lang.System.err
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Error parsing JSON "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r10 = r0.toString()
            r11.println(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseMotionSceneJSON(androidx.constraintlayout.core.state.CoreMotionScene, java.lang.String):void");
    }

    static void parseTransitions(CoreMotionScene coreMotionScene, CLObject cLObject) throws CLParsingException {
        ArrayList<String> names = cLObject.names();
        if (names != null) {
            int size = names.size();
            int i5 = 0;
            while (i5 < size) {
                String str = names.get(i5);
                i5++;
                String str2 = str;
                coreMotionScene.setTransitionContent(str2, cLObject.getObject(str2).toJSON());
            }
        }
    }

    private static void parseVariables(State state, LayoutVariables layoutVariables, CLObject cLObject) throws CLParsingException {
        ArrayList<String> names = cLObject.names();
        if (names != null) {
            int size = names.size();
            int i5 = 0;
            while (i5 < size) {
                String str = names.get(i5);
                i5++;
                String str2 = str;
                CLElement cLElement = cLObject.get(str2);
                if (cLElement instanceof CLNumber) {
                    layoutVariables.put(str2, cLElement.getInt());
                } else if (cLElement instanceof CLObject) {
                    CLObject cLObject2 = (CLObject) cLElement;
                    if (cLObject2.has(TypedValues.TransitionType.S_FROM) && cLObject2.has(TypedValues.TransitionType.S_TO)) {
                        layoutVariables.put(str2, layoutVariables.get(cLObject2.get(TypedValues.TransitionType.S_FROM)), layoutVariables.get(cLObject2.get(TypedValues.TransitionType.S_TO)), 1.0f, cLObject2.getStringOrNull("prefix"), cLObject2.getStringOrNull("postfix"));
                    } else if (cLObject2.has(TypedValues.TransitionType.S_FROM) && cLObject2.has("step")) {
                        layoutVariables.put(str2, layoutVariables.get(cLObject2.get(TypedValues.TransitionType.S_FROM)), layoutVariables.get(cLObject2.get("step")));
                    } else if (cLObject2.has("ids")) {
                        CLArray array = cLObject2.getArray("ids");
                        ArrayList arrayList = new ArrayList();
                        for (int i6 = 0; i6 < array.size(); i6++) {
                            arrayList.add(array.getString(i6));
                        }
                        layoutVariables.put(str2, (ArrayList<String>) arrayList);
                    } else if (cLObject2.has("tag")) {
                        layoutVariables.put(str2, state.getIdsForTag(cLObject2.getString("tag")));
                    }
                }
            }
        }
    }

    static void parseWidget(State state, LayoutVariables layoutVariables, String str, CLObject cLObject) throws CLParsingException {
        parseWidget(state, layoutVariables, state.constraints(str), cLObject);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00bb, code lost:
        if (r6.equals("hChain") == false) goto L_0x0061;
     */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void populateState(@androidx.annotation.NonNull androidx.constraintlayout.core.parser.CLObject r11, @androidx.annotation.NonNull androidx.constraintlayout.core.state.State r12, @androidx.annotation.NonNull androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r13) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            java.util.ArrayList r0 = r11.names()
            if (r0 != 0) goto L_0x0008
            goto L_0x0129
        L_0x0008:
            int r1 = r0.size()
            r2 = 0
            r3 = r2
        L_0x000e:
            if (r3 >= r1) goto L_0x0129
            java.lang.Object r4 = r0.get(r3)
            int r3 = r3 + 1
            java.lang.String r4 = (java.lang.String) r4
            androidx.constraintlayout.core.parser.CLElement r5 = r11.get((java.lang.String) r4)
            r4.getClass()
            int r6 = r4.hashCode()
            r7 = 2
            r8 = -1
            r9 = 1
            switch(r6) {
                case -1824489883: goto L_0x0041;
                case 1875016085: goto L_0x0036;
                case 1921490263: goto L_0x002b;
                default: goto L_0x0029;
            }
        L_0x0029:
            r6 = r8
            goto L_0x004b
        L_0x002b:
            java.lang.String r6 = "Variables"
            boolean r6 = r4.equals(r6)
            if (r6 != 0) goto L_0x0034
            goto L_0x0029
        L_0x0034:
            r6 = r7
            goto L_0x004b
        L_0x0036:
            java.lang.String r6 = "Generate"
            boolean r6 = r4.equals(r6)
            if (r6 != 0) goto L_0x003f
            goto L_0x0029
        L_0x003f:
            r6 = r9
            goto L_0x004b
        L_0x0041:
            java.lang.String r6 = "Helpers"
            boolean r6 = r4.equals(r6)
            if (r6 != 0) goto L_0x004a
            goto L_0x0029
        L_0x004a:
            r6 = r2
        L_0x004b:
            switch(r6) {
                case 0: goto L_0x011e;
                case 1: goto L_0x0113;
                case 2: goto L_0x0108;
                default: goto L_0x004e;
            }
        L_0x004e:
            boolean r6 = r5 instanceof androidx.constraintlayout.core.parser.CLObject
            if (r6 == 0) goto L_0x00fb
            androidx.constraintlayout.core.parser.CLObject r5 = (androidx.constraintlayout.core.parser.CLObject) r5
            java.lang.String r6 = lookForType(r5)
            if (r6 == 0) goto L_0x00f6
            int r10 = r6.hashCode()
            switch(r10) {
                case -1785507558: goto L_0x00c9;
                case -1354837162: goto L_0x00be;
                case -1252464839: goto L_0x00b5;
                case -851656725: goto L_0x00aa;
                case -333143113: goto L_0x009f;
                case 113114: goto L_0x0094;
                case 3181382: goto L_0x0089;
                case 98238902: goto L_0x007e;
                case 111168196: goto L_0x0071;
                case 965681512: goto L_0x0064;
                default: goto L_0x0061;
            }
        L_0x0061:
            r7 = r8
            goto L_0x00d3
        L_0x0064:
            java.lang.String r7 = "hGuideline"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x006d
            goto L_0x0061
        L_0x006d:
            r7 = 9
            goto L_0x00d3
        L_0x0071:
            java.lang.String r7 = "vFlow"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x007a
            goto L_0x0061
        L_0x007a:
            r7 = 8
            goto L_0x00d3
        L_0x007e:
            java.lang.String r7 = "hFlow"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x0087
            goto L_0x0061
        L_0x0087:
            r7 = 7
            goto L_0x00d3
        L_0x0089:
            java.lang.String r7 = "grid"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x0092
            goto L_0x0061
        L_0x0092:
            r7 = 6
            goto L_0x00d3
        L_0x0094:
            java.lang.String r7 = "row"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x009d
            goto L_0x0061
        L_0x009d:
            r7 = 5
            goto L_0x00d3
        L_0x009f:
            java.lang.String r7 = "barrier"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x00a8
            goto L_0x0061
        L_0x00a8:
            r7 = 4
            goto L_0x00d3
        L_0x00aa:
            java.lang.String r7 = "vChain"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x00b3
            goto L_0x0061
        L_0x00b3:
            r7 = 3
            goto L_0x00d3
        L_0x00b5:
            java.lang.String r10 = "hChain"
            boolean r10 = r6.equals(r10)
            if (r10 != 0) goto L_0x00d3
            goto L_0x0061
        L_0x00be:
            java.lang.String r7 = "column"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x00c7
            goto L_0x0061
        L_0x00c7:
            r7 = r9
            goto L_0x00d3
        L_0x00c9:
            java.lang.String r7 = "vGuideline"
            boolean r7 = r6.equals(r7)
            if (r7 != 0) goto L_0x00d2
            goto L_0x0061
        L_0x00d2:
            r7 = r2
        L_0x00d3:
            switch(r7) {
                case 0: goto L_0x00f1;
                case 1: goto L_0x00ec;
                case 2: goto L_0x00e7;
                case 3: goto L_0x00e7;
                case 4: goto L_0x00e2;
                case 5: goto L_0x00ec;
                case 6: goto L_0x00ec;
                case 7: goto L_0x00dd;
                case 8: goto L_0x00dd;
                case 9: goto L_0x00d8;
                default: goto L_0x00d6;
            }
        L_0x00d6:
            goto L_0x000e
        L_0x00d8:
            parseGuidelineParams(r2, r12, r4, r5)
            goto L_0x000e
        L_0x00dd:
            parseFlowType(r6, r12, r4, r13, r5)
            goto L_0x000e
        L_0x00e2:
            parseBarrier(r12, r4, r5)
            goto L_0x000e
        L_0x00e7:
            parseChainType(r6, r12, r4, r13, r5)
            goto L_0x000e
        L_0x00ec:
            parseGridType(r6, r12, r4, r13, r5)
            goto L_0x000e
        L_0x00f1:
            parseGuidelineParams(r9, r12, r4, r5)
            goto L_0x000e
        L_0x00f6:
            parseWidget((androidx.constraintlayout.core.state.State) r12, (androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables) r13, (java.lang.String) r4, (androidx.constraintlayout.core.parser.CLObject) r5)
            goto L_0x000e
        L_0x00fb:
            boolean r6 = r5 instanceof androidx.constraintlayout.core.parser.CLNumber
            if (r6 == 0) goto L_0x000e
            int r5 = r5.getInt()
            r13.put((java.lang.String) r4, (int) r5)
            goto L_0x000e
        L_0x0108:
            boolean r4 = r5 instanceof androidx.constraintlayout.core.parser.CLObject
            if (r4 == 0) goto L_0x000e
            androidx.constraintlayout.core.parser.CLObject r5 = (androidx.constraintlayout.core.parser.CLObject) r5
            parseVariables(r12, r13, r5)
            goto L_0x000e
        L_0x0113:
            boolean r4 = r5 instanceof androidx.constraintlayout.core.parser.CLObject
            if (r4 == 0) goto L_0x000e
            androidx.constraintlayout.core.parser.CLObject r5 = (androidx.constraintlayout.core.parser.CLObject) r5
            parseGenerate(r12, r13, r5)
            goto L_0x000e
        L_0x011e:
            boolean r4 = r5 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r4 == 0) goto L_0x000e
            androidx.constraintlayout.core.parser.CLArray r5 = (androidx.constraintlayout.core.parser.CLArray) r5
            parseHelpers(r12, r13, r5)
            goto L_0x000e
        L_0x0129:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.populateState(androidx.constraintlayout.core.parser.CLObject, androidx.constraintlayout.core.state.State, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables):void");
    }

    private static float toPix(State state, float f5) {
        return state.getDpToPixel().toPixels(f5);
    }

    static void parseWidget(State state, LayoutVariables layoutVariables, ConstraintReference constraintReference, CLObject cLObject) throws CLParsingException {
        if (constraintReference.getWidth() == null) {
            constraintReference.setWidth(Dimension.createWrap());
        }
        if (constraintReference.getHeight() == null) {
            constraintReference.setHeight(Dimension.createWrap());
        }
        ArrayList<String> names = cLObject.names();
        if (names != null) {
            int size = names.size();
            int i5 = 0;
            while (i5 < size) {
                String str = names.get(i5);
                i5++;
                applyAttribute(state, layoutVariables, constraintReference, cLObject, str);
            }
        }
    }

    public static void parseJSON(String str, State state, LayoutVariables layoutVariables) throws CLParsingException {
        try {
            populateState(CLParser.parse(str), state, layoutVariables);
        } catch (CLParsingException e5) {
            PrintStream printStream = System.err;
            printStream.println("Error parsing JSON " + e5);
        }
    }
}
