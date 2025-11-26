package com.google.android.material.shape;

import androidx.annotation.NonNull;

public final class MarkerEdgeTreatment extends EdgeTreatment {
    private final float radius;

    public MarkerEdgeTreatment(float f5) {
        this.radius = f5 - 0.001f;
    }

    /* access modifiers changed from: package-private */
    public boolean forceIntersection() {
        return true;
    }

    public void getEdgePath(float f5, float f6, float f7, @NonNull ShapePath shapePath) {
        float sqrt = (float) ((((double) this.radius) * Math.sqrt(2.0d)) / 2.0d);
        float sqrt2 = (float) Math.sqrt(Math.pow((double) this.radius, 2.0d) - Math.pow((double) sqrt, 2.0d));
        shapePath.reset(f6 - sqrt, ((float) (-((((double) this.radius) * Math.sqrt(2.0d)) - ((double) this.radius)))) + sqrt2);
        shapePath.lineTo(f6, (float) (-((((double) this.radius) * Math.sqrt(2.0d)) - ((double) this.radius))));
        shapePath.lineTo(f6 + sqrt, ((float) (-((((double) this.radius) * Math.sqrt(2.0d)) - ((double) this.radius)))) + sqrt2);
    }
}
