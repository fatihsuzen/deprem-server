package com.google.android.material.shape;

import androidx.annotation.NonNull;

public class CutCornerTreatment extends CornerTreatment {
    float size;

    public CutCornerTreatment() {
        this.size = -1.0f;
    }

    public void getCornerPath(@NonNull ShapePath shapePath, float f5, float f6, float f7) {
        float f8 = f7 * f6;
        shapePath.reset(0.0f, f8, 180.0f, 180.0f - f5);
        double d5 = (double) f8;
        shapePath.lineTo((float) (Math.sin(Math.toRadians((double) f5)) * d5), (float) (Math.sin(Math.toRadians((double) (90.0f - f5))) * d5));
    }

    @Deprecated
    public CutCornerTreatment(float f5) {
        this.size = f5;
    }
}
