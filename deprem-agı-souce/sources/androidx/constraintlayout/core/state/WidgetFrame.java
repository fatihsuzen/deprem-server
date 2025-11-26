package androidx.constraintlayout.core.state;

import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.state.Transition;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.core.os.EnvironmentCompat;
import java.util.HashMap;
import java.util.Set;

public class WidgetFrame {
    public static float phone_orientation = Float.NaN;
    public float alpha = Float.NaN;
    public int bottom = 0;
    public float interpolatedPos = Float.NaN;
    public int left = 0;
    private final HashMap<String, CustomVariable> mCustom = new HashMap<>();
    TypedBundle mMotionProperties;
    public String name = null;
    public float pivotX = Float.NaN;
    public float pivotY = Float.NaN;
    public int right = 0;
    public float rotationX = Float.NaN;
    public float rotationY = Float.NaN;
    public float rotationZ = Float.NaN;
    public float scaleX = Float.NaN;
    public float scaleY = Float.NaN;
    public int top = 0;
    public float translationX = Float.NaN;
    public float translationY = Float.NaN;
    public float translationZ = Float.NaN;
    public int visibility = 0;
    public ConstraintWidget widget = null;

    public WidgetFrame() {
    }

    private static void add(StringBuilder sb, String str, int i5) {
        sb.append(str);
        sb.append(": ");
        sb.append(i5);
        sb.append(",\n");
    }

    public static void interpolate(int i5, int i6, WidgetFrame widgetFrame, WidgetFrame widgetFrame2, WidgetFrame widgetFrame3, Transition transition, float f5) {
        float f6;
        int i7;
        int i8;
        int i9;
        int i10;
        float f7;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16 = i5;
        int i17 = i6;
        WidgetFrame widgetFrame4 = widgetFrame;
        WidgetFrame widgetFrame5 = widgetFrame2;
        WidgetFrame widgetFrame6 = widgetFrame3;
        Transition transition2 = transition;
        float f8 = f5;
        float f9 = 100.0f * f8;
        int i18 = (int) f9;
        int i19 = widgetFrame5.left;
        int i20 = widgetFrame5.top;
        int i21 = widgetFrame6.left;
        int i22 = widgetFrame6.top;
        int i23 = widgetFrame5.right - i19;
        int i24 = widgetFrame5.bottom - i20;
        int i25 = widgetFrame6.right - i21;
        float f10 = f9;
        int i26 = widgetFrame6.bottom - i22;
        int i27 = i19;
        float f11 = widgetFrame5.alpha;
        float f12 = widgetFrame6.alpha;
        int i28 = i20;
        if (widgetFrame5.visibility == 8) {
            int i29 = i27 - ((int) (((float) i25) / 2.0f));
            i9 = i28 - ((int) (((float) i26) / 2.0f));
            if (Float.isNaN(f11)) {
                i7 = i26;
                i27 = i29;
                i8 = i25;
                f6 = 0.0f;
            } else {
                i27 = i29;
                i8 = i25;
                f6 = f11;
                i7 = i26;
            }
        } else {
            float f13 = f11;
            i7 = i26;
            i26 = i24;
            i8 = i23;
            i9 = i28;
            f6 = f13;
        }
        if (widgetFrame6.visibility == 8) {
            i21 -= (int) (((float) i8) / 2.0f);
            i22 -= (int) (((float) i26) / 2.0f);
            if (Float.isNaN(f12)) {
                i10 = i26;
                i25 = i8;
                f12 = 0.0f;
            } else {
                i10 = i26;
                i25 = i8;
            }
        } else {
            i10 = i7;
        }
        if (Float.isNaN(f6) && !Float.isNaN(f12)) {
            f6 = 1.0f;
        }
        if (!Float.isNaN(f6) && Float.isNaN(f12)) {
            f12 = 1.0f;
        }
        int i30 = i21;
        float f14 = widgetFrame5.visibility == 4 ? 0.0f : f6;
        int i31 = i22;
        float f15 = widgetFrame6.visibility == 4 ? 0.0f : f12;
        if (widgetFrame4.widget == null || !transition2.hasPositionKeyframes()) {
            f7 = f8;
            i11 = i30;
            i12 = i31;
            i13 = i9;
        } else {
            Transition.KeyPosition findPreviousPosition = transition2.findPreviousPosition(widgetFrame4.widget.stringId, i18);
            int i32 = i9;
            Transition.KeyPosition findNextPosition = transition2.findNextPosition(widgetFrame4.widget.stringId, i18);
            if (findPreviousPosition == findNextPosition) {
                findNextPosition = null;
            }
            if (findPreviousPosition != null) {
                i27 = (int) (findPreviousPosition.mX * ((float) i16));
                i13 = (int) (findPreviousPosition.mY * ((float) i17));
                i14 = findPreviousPosition.mFrame;
            } else {
                i14 = 0;
                i13 = i32;
            }
            if (findNextPosition != null) {
                i11 = (int) (findNextPosition.mX * ((float) i16));
                i12 = (int) (findNextPosition.mY * ((float) i17));
                i15 = findNextPosition.mFrame;
            } else {
                i15 = 100;
                i11 = i30;
                i12 = i31;
            }
            f7 = (f10 - ((float) i14)) / ((float) (i15 - i14));
        }
        int i33 = i27;
        widgetFrame4.widget = widgetFrame5.widget;
        int i34 = (int) (((float) i33) + (((float) (i11 - i33)) * f7));
        widgetFrame4.left = i34;
        int i35 = (int) (((float) i13) + (f7 * ((float) (i12 - i13))));
        widgetFrame4.top = i35;
        float f16 = 1.0f - f8;
        widgetFrame4.right = i34 + ((int) ((((float) i8) * f16) + (((float) i25) * f8)));
        widgetFrame4.bottom = i35 + ((int) ((f16 * ((float) i26)) + (((float) i10) * f8)));
        widgetFrame4.pivotX = interpolate(widgetFrame5.pivotX, widgetFrame6.pivotX, 0.5f, f8);
        widgetFrame4.pivotY = interpolate(widgetFrame5.pivotY, widgetFrame6.pivotY, 0.5f, f8);
        widgetFrame4.rotationX = interpolate(widgetFrame5.rotationX, widgetFrame6.rotationX, 0.0f, f8);
        widgetFrame4.rotationY = interpolate(widgetFrame5.rotationY, widgetFrame6.rotationY, 0.0f, f8);
        widgetFrame4.rotationZ = interpolate(widgetFrame5.rotationZ, widgetFrame6.rotationZ, 0.0f, f8);
        widgetFrame4.scaleX = interpolate(widgetFrame5.scaleX, widgetFrame6.scaleX, 1.0f, f8);
        widgetFrame4.scaleY = interpolate(widgetFrame5.scaleY, widgetFrame6.scaleY, 1.0f, f8);
        widgetFrame4.translationX = interpolate(widgetFrame5.translationX, widgetFrame6.translationX, 0.0f, f8);
        widgetFrame4.translationY = interpolate(widgetFrame5.translationY, widgetFrame6.translationY, 0.0f, f8);
        widgetFrame4.translationZ = interpolate(widgetFrame5.translationZ, widgetFrame6.translationZ, 0.0f, f8);
        widgetFrame4.alpha = interpolate(f14, f15, 1.0f, f8);
        Set<String> keySet = widgetFrame6.mCustom.keySet();
        widgetFrame4.mCustom.clear();
        for (String next : keySet) {
            if (widgetFrame5.mCustom.containsKey(next)) {
                CustomVariable customVariable = widgetFrame5.mCustom.get(next);
                CustomVariable customVariable2 = widgetFrame6.mCustom.get(next);
                CustomVariable customVariable3 = new CustomVariable(customVariable);
                widgetFrame4.mCustom.put(next, customVariable3);
                if (customVariable.numberOfInterpolatedValues() == 1) {
                    customVariable3.setValue((Object) Float.valueOf(interpolate(customVariable.getValueToInterpolate(), customVariable2.getValueToInterpolate(), 0.0f, f8)));
                } else {
                    int numberOfInterpolatedValues = customVariable.numberOfInterpolatedValues();
                    float[] fArr = new float[numberOfInterpolatedValues];
                    float[] fArr2 = new float[numberOfInterpolatedValues];
                    customVariable.getValuesToInterpolate(fArr);
                    customVariable2.getValuesToInterpolate(fArr2);
                    for (int i36 = 0; i36 < numberOfInterpolatedValues; i36++) {
                        fArr[i36] = interpolate(fArr[i36], fArr2[i36], 0.0f, f8);
                        customVariable3.setValue(fArr);
                    }
                }
            }
        }
    }

    private void serializeAnchor(StringBuilder sb, ConstraintAnchor.Type type) {
        ConstraintAnchor anchor = this.widget.getAnchor(type);
        if (anchor != null && anchor.mTarget != null) {
            sb.append("Anchor");
            sb.append(type.name());
            sb.append(": ['");
            String str = anchor.mTarget.getOwner().stringId;
            if (str == null) {
                str = "#PARENT";
            }
            sb.append(str);
            sb.append("', '");
            sb.append(anchor.mTarget.getType().name());
            sb.append("', '");
            sb.append(anchor.mMargin);
            sb.append("'],\n");
        }
    }

    public void addCustomColor(String str, int i5) {
        setCustomAttribute(str, (int) TypedValues.Custom.TYPE_COLOR, i5);
    }

    public void addCustomFloat(String str, float f5) {
        setCustomAttribute(str, (int) TypedValues.Custom.TYPE_FLOAT, f5);
    }

    public float centerX() {
        int i5 = this.left;
        return ((float) i5) + (((float) (this.right - i5)) / 2.0f);
    }

    public float centerY() {
        int i5 = this.top;
        return ((float) i5) + (((float) (this.bottom - i5)) / 2.0f);
    }

    public boolean containsCustom(@NonNull String str) {
        return this.mCustom.containsKey(str);
    }

    public CustomVariable getCustomAttribute(String str) {
        return this.mCustom.get(str);
    }

    public Set<String> getCustomAttributeNames() {
        return this.mCustom.keySet();
    }

    public int getCustomColor(String str) {
        if (this.mCustom.containsKey(str)) {
            return this.mCustom.get(str).getColorValue();
        }
        return -21880;
    }

    public float getCustomFloat(String str) {
        if (this.mCustom.containsKey(str)) {
            return this.mCustom.get(str).getFloatValue();
        }
        return Float.NaN;
    }

    public String getId() {
        ConstraintWidget constraintWidget = this.widget;
        if (constraintWidget == null) {
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
        return constraintWidget.stringId;
    }

    public TypedBundle getMotionProperties() {
        return this.mMotionProperties;
    }

    public int height() {
        return Math.max(0, this.bottom - this.top);
    }

    public boolean isDefaultTransform() {
        if (!Float.isNaN(this.rotationX) || !Float.isNaN(this.rotationY) || !Float.isNaN(this.rotationZ) || !Float.isNaN(this.translationX) || !Float.isNaN(this.translationY) || !Float.isNaN(this.translationZ) || !Float.isNaN(this.scaleX) || !Float.isNaN(this.scaleY) || !Float.isNaN(this.alpha)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void logv(String str) {
        String str2;
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str3 = (".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName()) + " " + (hashCode() % 1000);
        if (this.widget != null) {
            str2 = str3 + "/" + (this.widget.hashCode() % 1000);
        } else {
            str2 = str3 + "/NULL";
        }
        System.out.println(str2 + " " + str);
    }

    /* access modifiers changed from: package-private */
    public void parseCustom(CLElement cLElement) throws CLParsingException {
        CLObject cLObject = (CLObject) cLElement;
        int size = cLObject.size();
        for (int i5 = 0; i5 < size; i5++) {
            CLElement value = ((CLKey) cLObject.get(i5)).getValue();
            String content = value.content();
            if (content.matches("#[0-9a-fA-F]+")) {
                setCustomAttribute(this.name, (int) TypedValues.Custom.TYPE_COLOR, Integer.parseInt(content.substring(1), 16));
            } else if (value instanceof CLNumber) {
                setCustomAttribute(this.name, (int) TypedValues.Custom.TYPE_FLOAT, value.getFloat());
            } else {
                setCustomAttribute(this.name, (int) TypedValues.Custom.TYPE_STRING, content);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void printCustomAttributes() {
        String str;
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str2 = (".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName()) + " " + (hashCode() % 1000);
        if (this.widget != null) {
            str = str2 + "/" + (this.widget.hashCode() % 1000) + " ";
        } else {
            str = str2 + "/NULL ";
        }
        HashMap<String, CustomVariable> hashMap = this.mCustom;
        if (hashMap != null) {
            for (String str3 : hashMap.keySet()) {
                System.out.println(str + this.mCustom.get(str3).toString());
            }
        }
    }

    public StringBuilder serialize(StringBuilder sb) {
        return serialize(sb, false);
    }

    public void setCustomAttribute(String str, int i5, float f5) {
        if (this.mCustom.containsKey(str)) {
            this.mCustom.get(str).setFloatValue(f5);
        } else {
            this.mCustom.put(str, new CustomVariable(str, i5, f5));
        }
    }

    public void setCustomValue(CustomAttribute customAttribute, float[] fArr) {
    }

    /* access modifiers changed from: package-private */
    public void setMotionAttributes(TypedBundle typedBundle) {
        this.mMotionProperties = typedBundle;
    }

    public boolean setValue(String str, CLElement cLElement) throws CLParsingException {
        str.getClass();
        char c5 = 65535;
        switch (str.hashCode()) {
            case -1881940865:
                if (str.equals("phone_orientation")) {
                    c5 = 0;
                    break;
                }
                break;
            case -1383228885:
                if (str.equals("bottom")) {
                    c5 = 1;
                    break;
                }
                break;
            case -1349088399:
                if (str.equals("custom")) {
                    c5 = 2;
                    break;
                }
                break;
            case -1249320806:
                if (str.equals("rotationX")) {
                    c5 = 3;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c5 = 4;
                    break;
                }
                break;
            case -1249320804:
                if (str.equals("rotationZ")) {
                    c5 = 5;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c5 = 6;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c5 = 7;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c5 = 8;
                    break;
                }
                break;
            case -987906986:
                if (str.equals("pivotX")) {
                    c5 = 9;
                    break;
                }
                break;
            case -987906985:
                if (str.equals("pivotY")) {
                    c5 = 10;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c5 = 11;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c5 = 12;
                    break;
                }
                break;
            case 115029:
                if (str.equals("top")) {
                    c5 = 13;
                    break;
                }
                break;
            case 3317767:
                if (str.equals(TtmlNode.LEFT)) {
                    c5 = 14;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c5 = 15;
                    break;
                }
                break;
            case 108511772:
                if (str.equals(TtmlNode.RIGHT)) {
                    c5 = 16;
                    break;
                }
                break;
            case 642850769:
                if (str.equals("interpolatedPos")) {
                    c5 = 17;
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
                phone_orientation = cLElement.getFloat();
                break;
            case 1:
                this.bottom = cLElement.getInt();
                break;
            case 2:
                parseCustom(cLElement);
                break;
            case 3:
                this.rotationX = cLElement.getFloat();
                break;
            case 4:
                this.rotationY = cLElement.getFloat();
                break;
            case 5:
                this.rotationZ = cLElement.getFloat();
                break;
            case 6:
                this.translationX = cLElement.getFloat();
                break;
            case 7:
                this.translationY = cLElement.getFloat();
                break;
            case 8:
                this.translationZ = cLElement.getFloat();
                break;
            case 9:
                this.pivotX = cLElement.getFloat();
                break;
            case 10:
                this.pivotY = cLElement.getFloat();
                break;
            case 11:
                this.scaleX = cLElement.getFloat();
                break;
            case 12:
                this.scaleY = cLElement.getFloat();
                break;
            case 13:
                this.top = cLElement.getInt();
                break;
            case 14:
                this.left = cLElement.getInt();
                break;
            case 15:
                this.alpha = cLElement.getFloat();
                break;
            case 16:
                this.right = cLElement.getInt();
                break;
            case 17:
                this.interpolatedPos = cLElement.getFloat();
                break;
            default:
                return false;
        }
        return true;
    }

    public WidgetFrame update() {
        ConstraintWidget constraintWidget = this.widget;
        if (constraintWidget != null) {
            this.left = constraintWidget.getLeft();
            this.top = this.widget.getTop();
            this.right = this.widget.getRight();
            this.bottom = this.widget.getBottom();
            updateAttributes(this.widget.frame);
        }
        return this;
    }

    public void updateAttributes(WidgetFrame widgetFrame) {
        if (widgetFrame != null) {
            this.pivotX = widgetFrame.pivotX;
            this.pivotY = widgetFrame.pivotY;
            this.rotationX = widgetFrame.rotationX;
            this.rotationY = widgetFrame.rotationY;
            this.rotationZ = widgetFrame.rotationZ;
            this.translationX = widgetFrame.translationX;
            this.translationY = widgetFrame.translationY;
            this.translationZ = widgetFrame.translationZ;
            this.scaleX = widgetFrame.scaleX;
            this.scaleY = widgetFrame.scaleY;
            this.alpha = widgetFrame.alpha;
            this.visibility = widgetFrame.visibility;
            setMotionAttributes(widgetFrame.mMotionProperties);
            this.mCustom.clear();
            for (CustomVariable next : widgetFrame.mCustom.values()) {
                this.mCustom.put(next.getName(), next.copy());
            }
        }
    }

    public int width() {
        return Math.max(0, this.right - this.left);
    }

    public StringBuilder serialize(StringBuilder sb, boolean z4) {
        sb.append("{\n");
        add(sb, TtmlNode.LEFT, this.left);
        add(sb, "top", this.top);
        add(sb, TtmlNode.RIGHT, this.right);
        add(sb, "bottom", this.bottom);
        add(sb, "pivotX", this.pivotX);
        add(sb, "pivotY", this.pivotY);
        add(sb, "rotationX", this.rotationX);
        add(sb, "rotationY", this.rotationY);
        add(sb, "rotationZ", this.rotationZ);
        add(sb, "translationX", this.translationX);
        add(sb, "translationY", this.translationY);
        add(sb, "translationZ", this.translationZ);
        add(sb, "scaleX", this.scaleX);
        add(sb, "scaleY", this.scaleY);
        add(sb, "alpha", this.alpha);
        add(sb, "visibility", this.visibility);
        add(sb, "interpolatedPos", this.interpolatedPos);
        if (this.widget != null) {
            for (ConstraintAnchor.Type serializeAnchor : ConstraintAnchor.Type.values()) {
                serializeAnchor(sb, serializeAnchor);
            }
        }
        if (z4) {
            add(sb, "phone_orientation", phone_orientation);
        }
        if (z4) {
            add(sb, "phone_orientation", phone_orientation);
        }
        if (this.mCustom.size() != 0) {
            sb.append("custom : {\n");
            for (String next : this.mCustom.keySet()) {
                CustomVariable customVariable = this.mCustom.get(next);
                sb.append(next);
                sb.append(": ");
                switch (customVariable.getType()) {
                    case 900:
                        sb.append(customVariable.getIntegerValue());
                        sb.append(",\n");
                        break;
                    case TypedValues.Custom.TYPE_FLOAT:
                    case TypedValues.Custom.TYPE_DIMENSION:
                        sb.append(customVariable.getFloatValue());
                        sb.append(",\n");
                        break;
                    case TypedValues.Custom.TYPE_COLOR:
                        sb.append("'");
                        sb.append(CustomVariable.colorString(customVariable.getIntegerValue()));
                        sb.append("',\n");
                        break;
                    case TypedValues.Custom.TYPE_STRING:
                        sb.append("'");
                        sb.append(customVariable.getStringValue());
                        sb.append("',\n");
                        break;
                    case TypedValues.Custom.TYPE_BOOLEAN:
                        sb.append("'");
                        sb.append(customVariable.getBooleanValue());
                        sb.append("',\n");
                        break;
                }
            }
            sb.append("}\n");
        }
        sb.append("}\n");
        return sb;
    }

    public void setCustomAttribute(String str, int i5, int i6) {
        if (this.mCustom.containsKey(str)) {
            this.mCustom.get(str).setIntValue(i6);
        } else {
            this.mCustom.put(str, new CustomVariable(str, i5, i6));
        }
    }

    private static void add(StringBuilder sb, String str, float f5) {
        if (!Float.isNaN(f5)) {
            sb.append(str);
            sb.append(": ");
            sb.append(f5);
            sb.append(",\n");
        }
    }

    public void setCustomAttribute(String str, int i5, boolean z4) {
        if (this.mCustom.containsKey(str)) {
            this.mCustom.get(str).setBooleanValue(z4);
        } else {
            this.mCustom.put(str, new CustomVariable(str, i5, z4));
        }
    }

    public WidgetFrame update(ConstraintWidget constraintWidget) {
        if (constraintWidget == null) {
            return this;
        }
        this.widget = constraintWidget;
        update();
        return this;
    }

    public void setCustomAttribute(String str, int i5, String str2) {
        if (this.mCustom.containsKey(str)) {
            this.mCustom.get(str).setStringValue(str2);
        } else {
            this.mCustom.put(str, new CustomVariable(str, i5, str2));
        }
    }

    public WidgetFrame(ConstraintWidget constraintWidget) {
        this.widget = constraintWidget;
    }

    public WidgetFrame(WidgetFrame widgetFrame) {
        this.widget = widgetFrame.widget;
        this.left = widgetFrame.left;
        this.top = widgetFrame.top;
        this.right = widgetFrame.right;
        this.bottom = widgetFrame.bottom;
        updateAttributes(widgetFrame);
    }

    private static float interpolate(float f5, float f6, float f7, float f8) {
        boolean isNaN = Float.isNaN(f5);
        boolean isNaN2 = Float.isNaN(f6);
        if (isNaN && isNaN2) {
            return Float.NaN;
        }
        if (isNaN) {
            f5 = f7;
        }
        if (isNaN2) {
            f6 = f7;
        }
        return f5 + (f8 * (f6 - f5));
    }
}
