package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ClippableRoundedCornerLayout extends FrameLayout {
    @NonNull
    private float[] cornerRadii = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    @Nullable
    private Path path;

    public ClippableRoundedCornerLayout(@NonNull Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (this.path == null) {
            super.dispatchDraw(canvas);
            return;
        }
        int save = canvas.save();
        canvas.clipPath(this.path);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
    }

    @NonNull
    public float[] getCornerRadii() {
        return this.cornerRadii;
    }

    public void resetClipBoundsAndCornerRadii() {
        this.path = null;
        this.cornerRadii = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        invalidate();
    }

    public void updateClipBoundsAndCornerRadii(@NonNull Rect rect, @NonNull float[] fArr) {
        updateClipBoundsAndCornerRadii((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom, fArr);
    }

    public void updateCornerRadii(@NonNull float[] fArr) {
        updateClipBoundsAndCornerRadii((float) getLeft(), (float) getTop(), (float) getRight(), (float) getBottom(), fArr);
    }

    public void updateClipBoundsAndCornerRadii(float f5, float f6, float f7, float f8, @NonNull float[] fArr) {
        updateClipBoundsAndCornerRadii(new RectF(f5, f6, f7, f8), fArr);
    }

    public ClippableRoundedCornerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void updateClipBoundsAndCornerRadii(@NonNull RectF rectF, @NonNull float[] fArr) {
        if (this.path == null) {
            this.path = new Path();
        }
        this.cornerRadii = fArr;
        this.path.reset();
        this.path.addRoundRect(rectF, fArr, Path.Direction.CW);
        this.path.close();
        invalidate();
    }

    public ClippableRoundedCornerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }
}
