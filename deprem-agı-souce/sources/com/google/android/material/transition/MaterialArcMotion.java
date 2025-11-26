package com.google.android.material.transition;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.transition.PathMotion;

public final class MaterialArcMotion extends PathMotion {
    private static PointF getControlPoint(float f5, float f6, float f7, float f8) {
        if (f6 > f8) {
            return new PointF(f7, f6);
        }
        return new PointF(f5, f8);
    }

    @NonNull
    public Path getPath(float f5, float f6, float f7, float f8) {
        Path path = new Path();
        path.moveTo(f5, f6);
        PointF controlPoint = getControlPoint(f5, f6, f7, f8);
        path.quadTo(controlPoint.x, controlPoint.y, f7, f8);
        return path;
    }
}
