package com.google.android.material.shape;

import androidx.annotation.NonNull;

public class RoundedCornerTreatment extends CornerTreatment {
    float radius;

    public RoundedCornerTreatment() {
        this.radius = -1.0f;
    }

    public void getCornerPath(@NonNull ShapePath shapePath, float f5, float f6, float f7) {
        float f8 = f7 * f6;
        shapePath.reset(0.0f, f8, 180.0f, 180.0f - f5);
        float f9 = f8 * 2.0f;
        shapePath.addArc(0.0f, 0.0f, f9, f9, 180.0f, f5);
    }

    @Deprecated
    public RoundedCornerTreatment(float f5) {
        this.radius = f5;
    }
}
