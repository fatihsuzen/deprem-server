package com.google.android.material.shadow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.appcompat.graphics.drawable.DrawableWrapperCompat;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;

@Deprecated
public class ShadowDrawableWrapper extends DrawableWrapperCompat {
    static final double COS_45 = Math.cos(Math.toRadians(45.0d));
    static final float SHADOW_BOTTOM_SCALE = 1.0f;
    static final float SHADOW_HORIZ_SCALE = 0.5f;
    static final float SHADOW_MULTIPLIER = 1.5f;
    static final float SHADOW_TOP_SCALE = 0.25f;
    private boolean addPaddingForCorners = true;
    @NonNull
    final RectF contentBounds;
    float cornerRadius;
    @NonNull
    final Paint cornerShadowPaint;
    Path cornerShadowPath;
    private boolean dirty = true;
    @NonNull
    final Paint edgeShadowPaint;
    float maxShadowSize;
    private boolean printedShadowClipWarning = false;
    float rawMaxShadowSize;
    float rawShadowSize;
    private float rotation;
    private final int shadowEndColor;
    private final int shadowMiddleColor;
    float shadowSize;
    private final int shadowStartColor;

    public ShadowDrawableWrapper(Context context, Drawable drawable, float f5, float f6, float f7) {
        super(drawable);
        this.shadowStartColor = ContextCompat.getColor(context, R.color.design_fab_shadow_start_color);
        this.shadowMiddleColor = ContextCompat.getColor(context, R.color.design_fab_shadow_mid_color);
        this.shadowEndColor = ContextCompat.getColor(context, R.color.design_fab_shadow_end_color);
        Paint paint = new Paint(5);
        this.cornerShadowPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.cornerRadius = (float) Math.round(f5);
        this.contentBounds = new RectF();
        Paint paint2 = new Paint(paint);
        this.edgeShadowPaint = paint2;
        paint2.setAntiAlias(false);
        setShadowSize(f6, f7);
    }

    private void buildComponents(@NonNull Rect rect) {
        float f5 = this.rawMaxShadowSize;
        float f6 = SHADOW_MULTIPLIER * f5;
        this.contentBounds.set(((float) rect.left) + f5, ((float) rect.top) + f6, ((float) rect.right) - f5, ((float) rect.bottom) - f6);
        Drawable drawable = getDrawable();
        RectF rectF = this.contentBounds;
        drawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        buildShadowCorners();
    }

    private void buildShadowCorners() {
        float f5 = this.cornerRadius;
        RectF rectF = new RectF(-f5, -f5, f5, f5);
        RectF rectF2 = new RectF(rectF);
        float f6 = this.shadowSize;
        rectF2.inset(-f6, -f6);
        Path path = this.cornerShadowPath;
        if (path == null) {
            this.cornerShadowPath = new Path();
        } else {
            path.reset();
        }
        this.cornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
        this.cornerShadowPath.moveTo(-this.cornerRadius, 0.0f);
        this.cornerShadowPath.rLineTo(-this.shadowSize, 0.0f);
        this.cornerShadowPath.arcTo(rectF2, 180.0f, 90.0f, false);
        this.cornerShadowPath.arcTo(rectF, 270.0f, -90.0f, false);
        this.cornerShadowPath.close();
        float f7 = -rectF2.top;
        if (f7 > 0.0f) {
            float f8 = this.cornerRadius / f7;
            this.cornerShadowPaint.setShader(new RadialGradient(0.0f, 0.0f, f7, new int[]{0, this.shadowStartColor, this.shadowMiddleColor, this.shadowEndColor}, new float[]{0.0f, f8, ((1.0f - f8) / 2.0f) + f8, 1.0f}, Shader.TileMode.CLAMP));
        }
        this.edgeShadowPaint.setShader(new LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, new int[]{this.shadowStartColor, this.shadowMiddleColor, this.shadowEndColor}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.edgeShadowPaint.setAntiAlias(false);
    }

    public static float calculateHorizontalPadding(float f5, float f6, boolean z4) {
        if (z4) {
            return (float) (((double) f5) + ((1.0d - COS_45) * ((double) f6)));
        }
        return f5;
    }

    public static float calculateVerticalPadding(float f5, float f6, boolean z4) {
        if (z4) {
            return (float) (((double) (f5 * SHADOW_MULTIPLIER)) + ((1.0d - COS_45) * ((double) f6)));
        }
        return f5 * SHADOW_MULTIPLIER;
    }

    private void drawShadow(@NonNull Canvas canvas) {
        boolean z4;
        boolean z5;
        float f5;
        int i5;
        Canvas canvas2 = canvas;
        int save = canvas2.save();
        canvas2.rotate(this.rotation, this.contentBounds.centerX(), this.contentBounds.centerY());
        float f6 = this.cornerRadius;
        float f7 = (-f6) - this.shadowSize;
        float f8 = f6 * 2.0f;
        if (this.contentBounds.width() - f8 > 0.0f) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (this.contentBounds.height() - f8 > 0.0f) {
            z5 = true;
        } else {
            z5 = false;
        }
        float f9 = this.rawShadowSize;
        float f10 = f6 / ((f9 - (0.5f * f9)) + f6);
        float f11 = f6 / ((f9 - (SHADOW_TOP_SCALE * f9)) + f6);
        float f12 = f6 / ((f9 - (f9 * 1.0f)) + f6);
        int save2 = canvas2.save();
        RectF rectF = this.contentBounds;
        canvas2.translate(rectF.left + f6, rectF.top + f6);
        canvas2.scale(f10, f11);
        canvas2.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z4) {
            canvas2.scale(1.0f / f10, 1.0f);
            f5 = 1.0f;
            i5 = save2;
            canvas2.drawRect(0.0f, f7, this.contentBounds.width() - f8, -this.cornerRadius, this.edgeShadowPaint);
        } else {
            f5 = 1.0f;
            i5 = save2;
        }
        canvas2.restoreToCount(i5);
        int save3 = canvas2.save();
        RectF rectF2 = this.contentBounds;
        canvas2.translate(rectF2.right - f6, rectF2.bottom - f6);
        canvas2.scale(f10, f12);
        canvas2.rotate(180.0f);
        canvas2.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z4) {
            canvas2.scale(f5 / f10, f5);
            canvas2.drawRect(0.0f, f7, this.contentBounds.width() - f8, this.shadowSize + (-this.cornerRadius), this.edgeShadowPaint);
        }
        canvas2.restoreToCount(save3);
        int save4 = canvas2.save();
        RectF rectF3 = this.contentBounds;
        canvas2.translate(rectF3.left + f6, rectF3.bottom - f6);
        canvas2.scale(f10, f12);
        canvas2.rotate(270.0f);
        canvas2.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z5) {
            canvas2.scale(1.0f / f12, 1.0f);
            canvas2.drawRect(0.0f, f7, this.contentBounds.height() - f8, -this.cornerRadius, this.edgeShadowPaint);
        }
        canvas2.restoreToCount(save4);
        int save5 = canvas2.save();
        RectF rectF4 = this.contentBounds;
        canvas2.translate(rectF4.right - f6, rectF4.top + f6);
        canvas2.scale(f10, f11);
        canvas2.rotate(90.0f);
        canvas2.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z5) {
            canvas2.scale(1.0f / f11, 1.0f);
            canvas2.drawRect(0.0f, f7, this.contentBounds.height() - f8, -this.cornerRadius, this.edgeShadowPaint);
        }
        canvas2.restoreToCount(save5);
        canvas2.restoreToCount(save);
    }

    private static int toEven(float f5) {
        int round = Math.round(f5);
        if (round % 2 == 1) {
            return round - 1;
        }
        return round;
    }

    public void draw(@NonNull Canvas canvas) {
        if (this.dirty) {
            buildComponents(getBounds());
            this.dirty = false;
        }
        drawShadow(canvas);
        super.draw(canvas);
    }

    public float getCornerRadius() {
        return this.cornerRadius;
    }

    public float getMaxShadowSize() {
        return this.rawMaxShadowSize;
    }

    public float getMinHeight() {
        float f5 = this.rawMaxShadowSize;
        return (Math.max(f5, this.cornerRadius + ((f5 * SHADOW_MULTIPLIER) / 2.0f)) * 2.0f) + (this.rawMaxShadowSize * SHADOW_MULTIPLIER * 2.0f);
    }

    public float getMinWidth() {
        float f5 = this.rawMaxShadowSize;
        return (Math.max(f5, this.cornerRadius + (f5 / 2.0f)) * 2.0f) + (this.rawMaxShadowSize * 2.0f);
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(@NonNull Rect rect) {
        int ceil = (int) Math.ceil((double) calculateVerticalPadding(this.rawMaxShadowSize, this.cornerRadius, this.addPaddingForCorners));
        int ceil2 = (int) Math.ceil((double) calculateHorizontalPadding(this.rawMaxShadowSize, this.cornerRadius, this.addPaddingForCorners));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public float getShadowSize() {
        return this.rawShadowSize;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.dirty = true;
    }

    public void setAddPaddingForCorners(boolean z4) {
        this.addPaddingForCorners = z4;
        invalidateSelf();
    }

    public void setAlpha(int i5) {
        super.setAlpha(i5);
        this.cornerShadowPaint.setAlpha(i5);
        this.edgeShadowPaint.setAlpha(i5);
    }

    public void setCornerRadius(float f5) {
        float round = (float) Math.round(f5);
        if (this.cornerRadius != round) {
            this.cornerRadius = round;
            this.dirty = true;
            invalidateSelf();
        }
    }

    public void setMaxShadowSize(float f5) {
        setShadowSize(this.rawShadowSize, f5);
    }

    public final void setRotation(float f5) {
        if (this.rotation != f5) {
            this.rotation = f5;
            invalidateSelf();
        }
    }

    public void setShadowSize(float f5, float f6) {
        if (f5 < 0.0f || f6 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float even = (float) toEven(f5);
        float even2 = (float) toEven(f6);
        if (even > even2) {
            if (!this.printedShadowClipWarning) {
                this.printedShadowClipWarning = true;
            }
            even = even2;
        }
        if (this.rawShadowSize != even || this.rawMaxShadowSize != even2) {
            this.rawShadowSize = even;
            this.rawMaxShadowSize = even2;
            this.shadowSize = (float) Math.round(even * SHADOW_MULTIPLIER);
            this.maxShadowSize = even2;
            this.dirty = true;
            invalidateSelf();
        }
    }

    public void setShadowSize(float f5) {
        setShadowSize(f5, this.rawMaxShadowSize);
    }
}
