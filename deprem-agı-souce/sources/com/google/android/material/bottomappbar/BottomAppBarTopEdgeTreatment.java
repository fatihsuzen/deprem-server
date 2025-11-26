package com.google.android.material.bottomappbar;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;

public class BottomAppBarTopEdgeTreatment extends EdgeTreatment implements Cloneable {
    private static final int ANGLE_LEFT = 180;
    private static final int ANGLE_UP = 270;
    private static final int ARC_HALF = 180;
    private static final int ARC_QUARTER = 90;
    private static final float ROUNDED_CORNER_FAB_OFFSET = 1.75f;
    private float cradleVerticalOffset;
    private float fabCornerSize = -1.0f;
    private float fabDiameter;
    private float fabMargin;
    private float horizontalOffset;
    private float roundedCornerRadius;

    public BottomAppBarTopEdgeTreatment(float f5, float f6, float f7) {
        this.fabMargin = f5;
        this.roundedCornerRadius = f6;
        setCradleVerticalOffset(f7);
        this.horizontalOffset = 0.0f;
    }

    /* access modifiers changed from: package-private */
    public float getCradleVerticalOffset() {
        return this.cradleVerticalOffset;
    }

    public void getEdgePath(float f5, float f6, float f7, @NonNull ShapePath shapePath) {
        boolean z4;
        float f8;
        float f9;
        float f10 = f5;
        ShapePath shapePath2 = shapePath;
        float f11 = this.fabDiameter;
        if (f11 == 0.0f) {
            shapePath2.lineTo(f10, 0.0f);
            return;
        }
        float f12 = ((this.fabMargin * 2.0f) + f11) / 2.0f;
        float f13 = f7 * this.roundedCornerRadius;
        float f14 = f6 + this.horizontalOffset;
        float f15 = (this.cradleVerticalOffset * f7) + ((1.0f - f7) * f12);
        if (f15 / f12 >= 1.0f) {
            shapePath2.lineTo(f10, 0.0f);
            return;
        }
        float f16 = this.fabCornerSize;
        float f17 = f16 * f7;
        if (f16 == -1.0f || Math.abs((f16 * 2.0f) - f11) < 0.1f) {
            z4 = true;
        } else {
            z4 = false;
        }
        boolean z5 = z4;
        if (!z5) {
            f9 = ROUNDED_CORNER_FAB_OFFSET;
            f8 = 0.0f;
        } else {
            f8 = f15;
            f9 = 0.0f;
        }
        float f18 = f12 + f13;
        float f19 = f8 + f13;
        float sqrt = (float) Math.sqrt((double) ((f18 * f18) - (f19 * f19)));
        float f20 = f14 - sqrt;
        float f21 = f14 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan((double) (sqrt / f19)));
        float f22 = (90.0f - degrees) + f9;
        shapePath2.lineTo(f20, 0.0f);
        float f23 = f20 - f13;
        float f24 = f20 + f13;
        float f25 = f13 * 2.0f;
        shapePath2.addArc(f23, 0.0f, f24, f25, 270.0f, degrees);
        float f26 = f25;
        float f27 = degrees;
        if (z5) {
            shapePath.addArc(f14 - f12, (-f12) - f8, f14 + f12, f12 - f8, 180.0f - f22, (f22 * 2.0f) - 180.0f);
        } else {
            float f28 = this.fabMargin;
            float f29 = f17 * 2.0f;
            float f30 = f28 + f29;
            float f31 = f28;
            float f32 = f14 - f12;
            float f33 = f31 + f17;
            float f34 = f33;
            ShapePath shapePath3 = shapePath;
            shapePath3.addArc(f32, -(f17 + f31), f30 + f32, f34, 180.0f - f22, ((f22 * 2.0f) - 180.0f) / 2.0f);
            float f35 = f14 + f12;
            float f36 = this.fabMargin;
            shapePath3.lineTo(f35 - ((f36 / 2.0f) + f17), f36 + f17);
            float f37 = this.fabMargin;
            shapePath3.addArc(f35 - (f29 + f37), -(f17 + f37), f35, f37 + f17, 90.0f, f22 - 0.049804688f);
        }
        ShapePath shapePath4 = shapePath;
        shapePath4.addArc(f21 - f13, 0.0f, f21 + f13, f26, 270.0f - f27, f27);
        shapePath4.lineTo(f10, 0.0f);
    }

    public float getFabCornerRadius() {
        return this.fabCornerSize;
    }

    /* access modifiers changed from: package-private */
    public float getFabCradleMargin() {
        return this.fabMargin;
    }

    /* access modifiers changed from: package-private */
    public float getFabCradleRoundedCornerRadius() {
        return this.roundedCornerRadius;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getFabDiameter() {
        return this.fabDiameter;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getHorizontalOffset() {
        return this.horizontalOffset;
    }

    /* access modifiers changed from: package-private */
    public void setCradleVerticalOffset(@FloatRange(from = 0.0d) float f5) {
        if (f5 >= 0.0f) {
            this.cradleVerticalOffset = f5;
            return;
        }
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }

    public void setFabCornerSize(float f5) {
        this.fabCornerSize = f5;
    }

    /* access modifiers changed from: package-private */
    public void setFabCradleMargin(float f5) {
        this.fabMargin = f5;
    }

    /* access modifiers changed from: package-private */
    public void setFabCradleRoundedCornerRadius(float f5) {
        this.roundedCornerRadius = f5;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setFabDiameter(float f5) {
        this.fabDiameter = f5;
    }

    /* access modifiers changed from: package-private */
    public void setHorizontalOffset(float f5) {
        this.horizontalOffset = f5;
    }
}
