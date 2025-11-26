package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.NonNull;

public class CornerTreatment {
    @Deprecated
    public void getCornerPath(float f5, float f6, @NonNull ShapePath shapePath) {
    }

    public void getCornerPath(@NonNull ShapePath shapePath, float f5, float f6, float f7) {
        getCornerPath(f5, f6, shapePath);
    }

    public void getCornerPath(@NonNull ShapePath shapePath, float f5, float f6, @NonNull RectF rectF, @NonNull CornerSize cornerSize) {
        getCornerPath(shapePath, f5, f6, cornerSize.getCornerSize(rectF));
    }
}
