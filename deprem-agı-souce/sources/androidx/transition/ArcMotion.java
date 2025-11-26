package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.core.content.res.TypedArrayUtils;
import org.xmlpull.v1.XmlPullParser;

public class ArcMotion extends PathMotion {
    private static final float DEFAULT_MAX_ANGLE_DEGREES = 70.0f;
    private static final float DEFAULT_MAX_TANGENT = ((float) Math.tan(Math.toRadians(35.0d)));
    private static final float DEFAULT_MIN_ANGLE_DEGREES = 0.0f;
    private float mMaximumAngle = DEFAULT_MAX_ANGLE_DEGREES;
    private float mMaximumTangent = DEFAULT_MAX_TANGENT;
    private float mMinimumHorizontalAngle = 0.0f;
    private float mMinimumHorizontalTangent = 0.0f;
    private float mMinimumVerticalAngle = 0.0f;
    private float mMinimumVerticalTangent = 0.0f;

    public ArcMotion() {
    }

    private static float toTangent(float f5) {
        if (f5 >= 0.0f && f5 <= 90.0f) {
            return (float) Math.tan(Math.toRadians((double) (f5 / 2.0f)));
        }
        throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
    }

    public float getMaximumAngle() {
        return this.mMaximumAngle;
    }

    public float getMinimumHorizontalAngle() {
        return this.mMinimumHorizontalAngle;
    }

    public float getMinimumVerticalAngle() {
        return this.mMinimumVerticalAngle;
    }

    @NonNull
    public Path getPath(float f5, float f6, float f7, float f8) {
        boolean z4;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        Path path = new Path();
        path.moveTo(f5, f6);
        float f14 = f7 - f5;
        float f15 = f8 - f6;
        float f16 = (f14 * f14) + (f15 * f15);
        float f17 = (f5 + f7) / 2.0f;
        float f18 = (f6 + f8) / 2.0f;
        float f19 = 0.25f * f16;
        if (f6 > f8) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (Math.abs(f14) < Math.abs(f15)) {
            float abs = Math.abs(f16 / (f15 * 2.0f));
            if (z4) {
                f10 = abs + f8;
                f9 = f7;
            } else {
                f10 = abs + f6;
                f9 = f5;
            }
            f11 = this.mMinimumVerticalTangent;
        } else {
            float f20 = f16 / (f14 * 2.0f);
            if (z4) {
                f13 = f6;
                f12 = f20 + f5;
            } else {
                f12 = f7 - f20;
                f13 = f8;
            }
            f11 = this.mMinimumHorizontalTangent;
        }
        float f21 = f19 * f11 * f11;
        float f22 = f17 - f9;
        float f23 = f18 - f10;
        float f24 = (f22 * f22) + (f23 * f23);
        float f25 = this.mMaximumTangent;
        float f26 = f19 * f25 * f25;
        if (f24 >= f21) {
            if (f24 > f26) {
                f21 = f26;
            } else {
                f21 = 0.0f;
            }
        }
        if (f21 != 0.0f) {
            float sqrt = (float) Math.sqrt((double) (f21 / f24));
            f9 = ((f9 - f17) * sqrt) + f17;
            f10 = f18 + (sqrt * (f10 - f18));
        }
        path.cubicTo((f5 + f9) / 2.0f, (f6 + f10) / 2.0f, (f9 + f7) / 2.0f, (f10 + f8) / 2.0f, f7, f8);
        return path;
    }

    public void setMaximumAngle(float f5) {
        this.mMaximumAngle = f5;
        this.mMaximumTangent = toTangent(f5);
    }

    public void setMinimumHorizontalAngle(float f5) {
        this.mMinimumHorizontalAngle = f5;
        this.mMinimumHorizontalTangent = toTangent(f5);
    }

    public void setMinimumVerticalAngle(float f5) {
        this.mMinimumVerticalAngle = f5;
        this.mMinimumVerticalTangent = toTangent(f5);
    }

    public ArcMotion(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.ARC_MOTION);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        setMinimumVerticalAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "minimumVerticalAngle", 1, 0.0f));
        setMinimumHorizontalAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "minimumHorizontalAngle", 0, 0.0f));
        setMaximumAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "maximumAngle", 2, DEFAULT_MAX_ANGLE_DEGREES));
        obtainStyledAttributes.recycle();
    }
}
