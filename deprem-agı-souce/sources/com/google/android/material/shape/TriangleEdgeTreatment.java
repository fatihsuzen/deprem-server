package com.google.android.material.shape;

import androidx.annotation.NonNull;

public class TriangleEdgeTreatment extends EdgeTreatment {
    private final boolean inside;
    private final float size;

    public TriangleEdgeTreatment(float f5, boolean z4) {
        this.size = f5;
        this.inside = z4;
    }

    public void getEdgePath(float f5, float f6, float f7, @NonNull ShapePath shapePath) {
        if (this.inside) {
            shapePath.lineTo(f6 - (this.size * f7), 0.0f);
            float f8 = this.size;
            shapePath.lineTo(f6, f8 * f7, (f8 * f7) + f6, 0.0f);
            shapePath.lineTo(f5, 0.0f);
            return;
        }
        float f9 = this.size;
        shapePath.lineTo(f6 - (f9 * f7), 0.0f, f6, (-f9) * f7);
        shapePath.lineTo(f6 + (this.size * f7), 0.0f, f5, 0.0f);
    }
}
