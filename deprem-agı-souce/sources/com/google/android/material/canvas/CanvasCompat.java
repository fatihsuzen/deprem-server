package com.google.android.material.canvas;

import android.graphics.Canvas;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class CanvasCompat {

    public interface CanvasOperation {
        void run(@NonNull Canvas canvas);
    }

    private CanvasCompat() {
    }

    public static int saveLayerAlpha(@NonNull Canvas canvas, @Nullable RectF rectF, int i5) {
        return canvas.saveLayerAlpha(rectF, i5);
    }

    public static int saveLayerAlpha(@NonNull Canvas canvas, float f5, float f6, float f7, float f8, int i5) {
        return canvas.saveLayerAlpha(f5, f6, f7, f8, i5);
    }
}
