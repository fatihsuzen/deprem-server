package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;

public class CustomVariable {
    private static final String TAG = "TransitionLayout";
    boolean mBooleanValue;
    private float mFloatValue;
    private int mIntegerValue;
    String mName;
    private String mStringValue;
    private int mType;

    public CustomVariable(CustomVariable customVariable) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = customVariable.mName;
        this.mType = customVariable.mType;
        this.mIntegerValue = customVariable.mIntegerValue;
        this.mFloatValue = customVariable.mFloatValue;
        this.mStringValue = customVariable.mStringValue;
        this.mBooleanValue = customVariable.mBooleanValue;
    }

    private static int clamp(int i5) {
        int i6 = (i5 & (~(i5 >> 31))) - 255;
        return (i6 & (i6 >> 31)) + 255;
    }

    public static String colorString(int i5) {
        String str = "00000000" + Integer.toHexString(i5);
        return "#" + str.substring(str.length() - 8);
    }

    public static int hsvToRgb(float f5, float f6, float f7) {
        float f8 = f5 * 6.0f;
        int i5 = (int) f8;
        float f9 = f8 - ((float) i5);
        float f10 = f7 * 255.0f;
        int i6 = (int) (((1.0f - f6) * f10) + 0.5f);
        int i7 = (int) (((1.0f - (f9 * f6)) * f10) + 0.5f);
        int i8 = (int) (((1.0f - ((1.0f - f9) * f6)) * f10) + 0.5f);
        int i9 = (int) (f10 + 0.5f);
        if (i5 == 0) {
            return ((i9 << 16) + (i8 << 8) + i6) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i5 == 1) {
            return ((i7 << 16) + (i9 << 8) + i6) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i5 == 2) {
            return ((i6 << 16) + (i9 << 8) + i8) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i5 == 3) {
            return ((i6 << 16) + (i7 << 8) + i9) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i5 == 4) {
            return ((i8 << 16) + (i6 << 8) + i9) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i5 != 5) {
            return 0;
        }
        return ((i9 << 16) + (i6 << 8) + i7) | ViewCompat.MEASURED_STATE_MASK;
    }

    public static int rgbaTocColor(float f5, float f6, float f7, float f8) {
        int clamp = clamp((int) (f5 * 255.0f));
        int clamp2 = clamp((int) (f6 * 255.0f));
        return (clamp << 16) | (clamp((int) (f8 * 255.0f)) << 24) | (clamp2 << 8) | clamp((int) (f7 * 255.0f));
    }

    public void applyToWidget(MotionWidget motionWidget) {
        int i5 = this.mType;
        switch (i5) {
            case 900:
            case TypedValues.Custom.TYPE_COLOR /*902*/:
            case TypedValues.Custom.TYPE_REFERENCE /*906*/:
                motionWidget.setCustomAttribute(this.mName, i5, this.mIntegerValue);
                return;
            case TypedValues.Custom.TYPE_FLOAT /*901*/:
            case TypedValues.Custom.TYPE_DIMENSION /*905*/:
                motionWidget.setCustomAttribute(this.mName, i5, this.mFloatValue);
                return;
            case TypedValues.Custom.TYPE_STRING /*903*/:
                motionWidget.setCustomAttribute(this.mName, i5, this.mStringValue);
                return;
            case TypedValues.Custom.TYPE_BOOLEAN /*904*/:
                motionWidget.setCustomAttribute(this.mName, i5, this.mBooleanValue);
                return;
            default:
                return;
        }
    }

    public CustomVariable copy() {
        return new CustomVariable(this);
    }

    public boolean diff(CustomVariable customVariable) {
        int i5;
        if (customVariable != null && (i5 = this.mType) == customVariable.mType) {
            switch (i5) {
                case 900:
                case TypedValues.Custom.TYPE_REFERENCE /*906*/:
                    if (this.mIntegerValue == customVariable.mIntegerValue) {
                        return true;
                    }
                    break;
                case TypedValues.Custom.TYPE_FLOAT /*901*/:
                    if (this.mFloatValue == customVariable.mFloatValue) {
                        return true;
                    }
                    return false;
                case TypedValues.Custom.TYPE_COLOR /*902*/:
                    if (this.mIntegerValue == customVariable.mIntegerValue) {
                        return true;
                    }
                    return false;
                case TypedValues.Custom.TYPE_STRING /*903*/:
                    if (this.mIntegerValue == customVariable.mIntegerValue) {
                        return true;
                    }
                    return false;
                case TypedValues.Custom.TYPE_BOOLEAN /*904*/:
                    if (this.mBooleanValue == customVariable.mBooleanValue) {
                        return true;
                    }
                    return false;
                case TypedValues.Custom.TYPE_DIMENSION /*905*/:
                    if (this.mFloatValue == customVariable.mFloatValue) {
                        return true;
                    }
                    return false;
                default:
                    return false;
            }
        }
        return false;
    }

    public boolean getBooleanValue() {
        return this.mBooleanValue;
    }

    public int getColorValue() {
        return this.mIntegerValue;
    }

    public float getFloatValue() {
        return this.mFloatValue;
    }

    public int getIntegerValue() {
        return this.mIntegerValue;
    }

    public int getInterpolatedColor(float[] fArr) {
        int clamp = clamp((int) (((float) Math.pow((double) fArr[0], 0.45454545454545453d)) * 255.0f));
        int clamp2 = clamp((int) (((float) Math.pow((double) fArr[1], 0.45454545454545453d)) * 255.0f));
        return (clamp((int) (fArr[3] * 255.0f)) << 24) | (clamp << 16) | (clamp2 << 8) | clamp((int) (((float) Math.pow((double) fArr[2], 0.45454545454545453d)) * 255.0f));
    }

    public String getName() {
        return this.mName;
    }

    public String getStringValue() {
        return this.mStringValue;
    }

    public int getType() {
        return this.mType;
    }

    public float getValueToInterpolate() {
        switch (this.mType) {
            case 900:
                return (float) this.mIntegerValue;
            case TypedValues.Custom.TYPE_FLOAT /*901*/:
                return this.mFloatValue;
            case TypedValues.Custom.TYPE_COLOR /*902*/:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case TypedValues.Custom.TYPE_STRING /*903*/:
                throw new RuntimeException("Cannot interpolate String");
            case TypedValues.Custom.TYPE_BOOLEAN /*904*/:
                if (this.mBooleanValue) {
                    return 1.0f;
                }
                return 0.0f;
            case TypedValues.Custom.TYPE_DIMENSION /*905*/:
                return this.mFloatValue;
            default:
                return Float.NaN;
        }
    }

    public void getValuesToInterpolate(float[] fArr) {
        float f5;
        switch (this.mType) {
            case 900:
                fArr[0] = (float) this.mIntegerValue;
                return;
            case TypedValues.Custom.TYPE_FLOAT /*901*/:
                fArr[0] = this.mFloatValue;
                return;
            case TypedValues.Custom.TYPE_COLOR /*902*/:
                int i5 = this.mIntegerValue;
                float pow = (float) Math.pow((double) (((float) ((i5 >> 16) & 255)) / 255.0f), 2.2d);
                float pow2 = (float) Math.pow((double) (((float) ((i5 >> 8) & 255)) / 255.0f), 2.2d);
                fArr[0] = pow;
                fArr[1] = pow2;
                fArr[2] = (float) Math.pow((double) (((float) (i5 & 255)) / 255.0f), 2.2d);
                fArr[3] = ((float) ((i5 >> 24) & 255)) / 255.0f;
                return;
            case TypedValues.Custom.TYPE_STRING /*903*/:
                throw new RuntimeException("Cannot interpolate String");
            case TypedValues.Custom.TYPE_BOOLEAN /*904*/:
                if (this.mBooleanValue) {
                    f5 = 1.0f;
                } else {
                    f5 = 0.0f;
                }
                fArr[0] = f5;
                return;
            case TypedValues.Custom.TYPE_DIMENSION /*905*/:
                fArr[0] = this.mFloatValue;
                return;
            default:
                return;
        }
    }

    public boolean isContinuous() {
        int i5 = this.mType;
        if (i5 == 903 || i5 == 904 || i5 == 906) {
            return false;
        }
        return true;
    }

    public int numberOfInterpolatedValues() {
        if (this.mType != 902) {
            return 1;
        }
        return 4;
    }

    public void setBooleanValue(boolean z4) {
        this.mBooleanValue = z4;
    }

    public void setFloatValue(float f5) {
        this.mFloatValue = f5;
    }

    public void setIntValue(int i5) {
        this.mIntegerValue = i5;
    }

    public void setInterpolatedValue(MotionWidget motionWidget, float[] fArr) {
        int i5 = this.mType;
        boolean z4 = true;
        switch (i5) {
            case 900:
                motionWidget.setCustomAttribute(this.mName, i5, (int) fArr[0]);
                return;
            case TypedValues.Custom.TYPE_FLOAT /*901*/:
            case TypedValues.Custom.TYPE_DIMENSION /*905*/:
                motionWidget.setCustomAttribute(this.mName, i5, fArr[0]);
                return;
            case TypedValues.Custom.TYPE_COLOR /*902*/:
                int clamp = clamp((int) (((float) Math.pow((double) fArr[0], 0.45454545454545453d)) * 255.0f));
                int clamp2 = clamp((int) (((float) Math.pow((double) fArr[1], 0.45454545454545453d)) * 255.0f));
                motionWidget.setCustomAttribute(this.mName, this.mType, (clamp((int) (fArr[3] * 255.0f)) << 24) | (clamp << 16) | (clamp2 << 8) | clamp((int) (((float) Math.pow((double) fArr[2], 0.45454545454545453d)) * 255.0f)));
                return;
            case TypedValues.Custom.TYPE_STRING /*903*/:
            case TypedValues.Custom.TYPE_REFERENCE /*906*/:
                throw new RuntimeException("unable to interpolate " + this.mName);
            case TypedValues.Custom.TYPE_BOOLEAN /*904*/:
                String str = this.mName;
                if (fArr[0] <= 0.5f) {
                    z4 = false;
                }
                motionWidget.setCustomAttribute(str, i5, z4);
                return;
            default:
                return;
        }
    }

    public void setStringValue(String str) {
        this.mStringValue = str;
    }

    public void setValue(float[] fArr) {
        boolean z4 = true;
        switch (this.mType) {
            case 900:
            case TypedValues.Custom.TYPE_REFERENCE /*906*/:
                this.mIntegerValue = (int) fArr[0];
                return;
            case TypedValues.Custom.TYPE_FLOAT /*901*/:
            case TypedValues.Custom.TYPE_DIMENSION /*905*/:
                this.mFloatValue = fArr[0];
                return;
            case TypedValues.Custom.TYPE_COLOR /*902*/:
                this.mIntegerValue = ((Math.round(fArr[3] * 255.0f) & 255) << 24) | ((Math.round(((float) Math.pow((double) fArr[0], 0.5d)) * 255.0f) & 255) << 16) | ((Math.round(((float) Math.pow((double) fArr[1], 0.5d)) * 255.0f) & 255) << 8) | (Math.round(((float) Math.pow((double) fArr[2], 0.5d)) * 255.0f) & 255);
                return;
            case TypedValues.Custom.TYPE_STRING /*903*/:
                throw new RuntimeException("Cannot interpolate String");
            case TypedValues.Custom.TYPE_BOOLEAN /*904*/:
                if (((double) fArr[0]) <= 0.5d) {
                    z4 = false;
                }
                this.mBooleanValue = z4;
                return;
            default:
                return;
        }
    }

    public String toString() {
        String str = this.mName + ':';
        switch (this.mType) {
            case 900:
                return str + this.mIntegerValue;
            case TypedValues.Custom.TYPE_FLOAT /*901*/:
                return str + this.mFloatValue;
            case TypedValues.Custom.TYPE_COLOR /*902*/:
                return str + colorString(this.mIntegerValue);
            case TypedValues.Custom.TYPE_STRING /*903*/:
                return str + this.mStringValue;
            case TypedValues.Custom.TYPE_BOOLEAN /*904*/:
                return str + Boolean.valueOf(this.mBooleanValue);
            case TypedValues.Custom.TYPE_DIMENSION /*905*/:
                return str + this.mFloatValue;
            default:
                return str + "????";
        }
    }

    public CustomVariable(String str, int i5, String str2) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mName = str;
        this.mType = i5;
        this.mStringValue = str2;
    }

    public void setValue(Object obj) {
        switch (this.mType) {
            case 900:
            case TypedValues.Custom.TYPE_REFERENCE /*906*/:
                this.mIntegerValue = ((Integer) obj).intValue();
                return;
            case TypedValues.Custom.TYPE_FLOAT /*901*/:
                this.mFloatValue = ((Float) obj).floatValue();
                return;
            case TypedValues.Custom.TYPE_COLOR /*902*/:
                this.mIntegerValue = ((Integer) obj).intValue();
                return;
            case TypedValues.Custom.TYPE_STRING /*903*/:
                this.mStringValue = (String) obj;
                return;
            case TypedValues.Custom.TYPE_BOOLEAN /*904*/:
                this.mBooleanValue = ((Boolean) obj).booleanValue();
                return;
            case TypedValues.Custom.TYPE_DIMENSION /*905*/:
                this.mFloatValue = ((Float) obj).floatValue();
                return;
            default:
                return;
        }
    }

    public CustomVariable(String str, int i5, int i6) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = str;
        this.mType = i5;
        if (i5 == 901) {
            this.mFloatValue = (float) i6;
        } else {
            this.mIntegerValue = i6;
        }
    }

    public CustomVariable(String str, int i5, float f5) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mStringValue = null;
        this.mName = str;
        this.mType = i5;
        this.mFloatValue = f5;
    }

    public CustomVariable(String str, int i5, boolean z4) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = str;
        this.mType = i5;
        this.mBooleanValue = z4;
    }

    public CustomVariable(String str, int i5) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = str;
        this.mType = i5;
    }

    public CustomVariable(String str, int i5, Object obj) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = str;
        this.mType = i5;
        setValue(obj);
    }

    public CustomVariable(CustomVariable customVariable, Object obj) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = customVariable.mName;
        this.mType = customVariable.mType;
        setValue(obj);
    }
}
