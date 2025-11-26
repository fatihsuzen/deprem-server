package com.google.android.material.shadow;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ShadowRenderer {
    private static final int COLOR_ALPHA_END = 0;
    private static final int COLOR_ALPHA_MIDDLE = 20;
    private static final int COLOR_ALPHA_START = 68;
    private static final int[] cornerColors = new int[4];
    private static final float[] cornerPositions = {0.0f, 0.0f, 0.5f, 1.0f};
    private static final int[] edgeColors = new int[3];
    private static final float[] edgePositions = {0.0f, 0.5f, 1.0f};
    @NonNull
    private final Paint cornerShadowPaint;
    @NonNull
    private final Paint edgeShadowPaint;
    private final Path scratch;
    private int shadowEndColor;
    private int shadowMiddleColor;
    @NonNull
    private final Paint shadowPaint;
    private int shadowStartColor;
    private final Paint transparentPaint;

    public ShadowRenderer() {
        this(ViewCompat.MEASURED_STATE_MASK);
    }

    public void drawCornerShadow(@NonNull Canvas canvas, @Nullable Matrix matrix, @NonNull RectF rectF, int i5, float f5, float f6) {
        boolean z4;
        float f7;
        Canvas canvas2 = canvas;
        RectF rectF2 = rectF;
        int i6 = i5;
        float f8 = f6;
        if (f8 < 0.0f) {
            z4 = true;
        } else {
            z4 = false;
        }
        Path path = this.scratch;
        if (z4) {
            int[] iArr = cornerColors;
            iArr[0] = 0;
            iArr[1] = this.shadowEndColor;
            iArr[2] = this.shadowMiddleColor;
            iArr[3] = this.shadowStartColor;
            f7 = f5;
        } else {
            path.rewind();
            path.moveTo(rectF2.centerX(), rectF2.centerY());
            f7 = f5;
            path.arcTo(rectF2, f7, f8);
            path.close();
            float f9 = (float) (-i6);
            rectF2.inset(f9, f9);
            int[] iArr2 = cornerColors;
            iArr2[0] = 0;
            iArr2[1] = this.shadowStartColor;
            iArr2[2] = this.shadowMiddleColor;
            iArr2[3] = this.shadowEndColor;
        }
        float width = rectF2.width() / 2.0f;
        if (width > 0.0f) {
            float f10 = 1.0f - (((float) i6) / width);
            float[] fArr = cornerPositions;
            fArr[1] = f10;
            fArr[2] = ((1.0f - f10) / 2.0f) + f10;
            this.cornerShadowPaint.setShader(new RadialGradient(rectF2.centerX(), rectF2.centerY(), width, cornerColors, fArr, Shader.TileMode.CLAMP));
            canvas2.save();
            canvas.concat(matrix);
            canvas2.scale(1.0f, rectF2.height() / rectF2.width());
            if (!z4) {
                canvas2.clipPath(path, Region.Op.DIFFERENCE);
                canvas2.drawPath(path, this.transparentPaint);
            }
            canvas2.drawArc(rectF2, f7, f8, true, this.cornerShadowPaint);
            canvas.restore();
        }
    }

    public void drawEdgeShadow(@NonNull Canvas canvas, @Nullable Matrix matrix, @NonNull RectF rectF, int i5) {
        rectF.bottom += (float) i5;
        rectF.offset(0.0f, (float) (-i5));
        int[] iArr = edgeColors;
        iArr[0] = this.shadowEndColor;
        iArr[1] = this.shadowMiddleColor;
        iArr[2] = this.shadowStartColor;
        Paint paint = this.edgeShadowPaint;
        float f5 = rectF.left;
        paint.setShader(new LinearGradient(f5, rectF.top, f5, rectF.bottom, iArr, edgePositions, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.edgeShadowPaint);
        canvas.restore();
    }

    public void drawInnerCornerShadow(@NonNull Canvas canvas, @Nullable Matrix matrix, @NonNull RectF rectF, int i5, float f5, float f6, @NonNull float[] fArr) {
        if (f6 > 0.0f) {
            f5 += f6;
            f6 = -f6;
        }
        Canvas canvas2 = canvas;
        Matrix matrix2 = matrix;
        RectF rectF2 = rectF;
        float f7 = f5;
        float f8 = f6;
        drawCornerShadow(canvas2, matrix2, rectF2, i5, f7, f8);
        Path path = this.scratch;
        path.rewind();
        path.moveTo(fArr[0], fArr[1]);
        path.arcTo(rectF2, f7, f8);
        path.close();
        canvas2.save();
        canvas2.concat(matrix2);
        canvas2.scale(1.0f, rectF2.height() / rectF2.width());
        canvas2.drawPath(path, this.transparentPaint);
        canvas2.drawPath(path, this.shadowPaint);
        canvas2.restore();
    }

    @NonNull
    public Paint getShadowPaint() {
        return this.shadowPaint;
    }

    public void setShadowColor(int i5) {
        this.shadowStartColor = ColorUtils.setAlphaComponent(i5, 68);
        this.shadowMiddleColor = ColorUtils.setAlphaComponent(i5, 20);
        this.shadowEndColor = ColorUtils.setAlphaComponent(i5, 0);
        this.shadowPaint.setColor(this.shadowStartColor);
    }

    public ShadowRenderer(int i5) {
        this.scratch = new Path();
        Paint paint = new Paint();
        this.transparentPaint = paint;
        this.shadowPaint = new Paint();
        setShadowColor(i5);
        paint.setColor(0);
        Paint paint2 = new Paint(4);
        this.cornerShadowPaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.edgeShadowPaint = new Paint(paint2);
    }
}
