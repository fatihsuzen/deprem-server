package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract class RoundedBitmapDrawable extends Drawable {
    private static final int DEFAULT_PAINT_FLAGS = 3;
    private boolean mApplyGravity = true;
    final Bitmap mBitmap;
    private int mBitmapHeight;
    private final BitmapShader mBitmapShader;
    private int mBitmapWidth;
    private float mCornerRadius;
    final Rect mDstRect = new Rect();
    private final RectF mDstRectF = new RectF();
    private int mGravity = 119;
    private boolean mIsCircular;
    private final Paint mPaint = new Paint(3);
    private final Matrix mShaderMatrix = new Matrix();
    private int mTargetDensity = 160;

    RoundedBitmapDrawable(Resources resources, Bitmap bitmap) {
        if (resources != null) {
            this.mTargetDensity = resources.getDisplayMetrics().densityDpi;
        }
        this.mBitmap = bitmap;
        if (bitmap != null) {
            computeBitmapSize();
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.mBitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            return;
        }
        this.mBitmapHeight = -1;
        this.mBitmapWidth = -1;
        this.mBitmapShader = null;
    }

    private void computeBitmapSize() {
        this.mBitmapWidth = this.mBitmap.getScaledWidth(this.mTargetDensity);
        this.mBitmapHeight = this.mBitmap.getScaledHeight(this.mTargetDensity);
    }

    private static boolean isGreaterThanZero(float f5) {
        return f5 > 0.05f;
    }

    private void updateCircularCornerRadius() {
        this.mCornerRadius = (float) (Math.min(this.mBitmapHeight, this.mBitmapWidth) / 2);
    }

    public void draw(@NonNull Canvas canvas) {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            updateDstRect();
            if (this.mPaint.getShader() == null) {
                canvas.drawBitmap(bitmap, (Rect) null, this.mDstRect, this.mPaint);
                return;
            }
            RectF rectF = this.mDstRectF;
            float f5 = this.mCornerRadius;
            canvas.drawRoundRect(rectF, f5, f5, this.mPaint);
        }
    }

    public int getAlpha() {
        return this.mPaint.getAlpha();
    }

    @Nullable
    public final Bitmap getBitmap() {
        return this.mBitmap;
    }

    public ColorFilter getColorFilter() {
        return this.mPaint.getColorFilter();
    }

    public float getCornerRadius() {
        return this.mCornerRadius;
    }

    public int getGravity() {
        return this.mGravity;
    }

    public int getIntrinsicHeight() {
        return this.mBitmapHeight;
    }

    public int getIntrinsicWidth() {
        return this.mBitmapWidth;
    }

    public int getOpacity() {
        Bitmap bitmap;
        if (this.mGravity != 119 || this.mIsCircular || (bitmap = this.mBitmap) == null || bitmap.hasAlpha() || this.mPaint.getAlpha() < 255 || isGreaterThanZero(this.mCornerRadius)) {
            return -3;
        }
        return -1;
    }

    @NonNull
    public final Paint getPaint() {
        return this.mPaint;
    }

    /* access modifiers changed from: package-private */
    public void gravityCompatApply(int i5, int i6, int i7, Rect rect, Rect rect2) {
        throw new UnsupportedOperationException();
    }

    public boolean hasAntiAlias() {
        return this.mPaint.isAntiAlias();
    }

    public boolean hasMipMap() {
        throw new UnsupportedOperationException();
    }

    public boolean isCircular() {
        return this.mIsCircular;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(@NonNull Rect rect) {
        super.onBoundsChange(rect);
        if (this.mIsCircular) {
            updateCircularCornerRadius();
        }
        this.mApplyGravity = true;
    }

    public void setAlpha(int i5) {
        if (i5 != this.mPaint.getAlpha()) {
            this.mPaint.setAlpha(i5);
            invalidateSelf();
        }
    }

    public void setAntiAlias(boolean z4) {
        this.mPaint.setAntiAlias(z4);
        invalidateSelf();
    }

    public void setCircular(boolean z4) {
        this.mIsCircular = z4;
        this.mApplyGravity = true;
        if (z4) {
            updateCircularCornerRadius();
            this.mPaint.setShader(this.mBitmapShader);
            invalidateSelf();
            return;
        }
        setCornerRadius(0.0f);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setCornerRadius(float f5) {
        if (this.mCornerRadius != f5) {
            this.mIsCircular = false;
            if (isGreaterThanZero(f5)) {
                this.mPaint.setShader(this.mBitmapShader);
            } else {
                this.mPaint.setShader((Shader) null);
            }
            this.mCornerRadius = f5;
            invalidateSelf();
        }
    }

    public void setDither(boolean z4) {
        this.mPaint.setDither(z4);
        invalidateSelf();
    }

    public void setFilterBitmap(boolean z4) {
        this.mPaint.setFilterBitmap(z4);
        invalidateSelf();
    }

    public void setGravity(int i5) {
        if (this.mGravity != i5) {
            this.mGravity = i5;
            this.mApplyGravity = true;
            invalidateSelf();
        }
    }

    public void setMipMap(boolean z4) {
        throw new UnsupportedOperationException();
    }

    public void setTargetDensity(@NonNull Canvas canvas) {
        setTargetDensity(canvas.getDensity());
    }

    /* access modifiers changed from: package-private */
    public void updateDstRect() {
        RoundedBitmapDrawable roundedBitmapDrawable;
        if (this.mApplyGravity) {
            if (this.mIsCircular) {
                int min = Math.min(this.mBitmapWidth, this.mBitmapHeight);
                roundedBitmapDrawable = this;
                roundedBitmapDrawable.gravityCompatApply(this.mGravity, min, min, getBounds(), this.mDstRect);
                int min2 = Math.min(roundedBitmapDrawable.mDstRect.width(), roundedBitmapDrawable.mDstRect.height());
                roundedBitmapDrawable.mDstRect.inset(Math.max(0, (roundedBitmapDrawable.mDstRect.width() - min2) / 2), Math.max(0, (roundedBitmapDrawable.mDstRect.height() - min2) / 2));
                roundedBitmapDrawable.mCornerRadius = ((float) min2) * 0.5f;
            } else {
                roundedBitmapDrawable = this;
                roundedBitmapDrawable.gravityCompatApply(roundedBitmapDrawable.mGravity, roundedBitmapDrawable.mBitmapWidth, roundedBitmapDrawable.mBitmapHeight, getBounds(), roundedBitmapDrawable.mDstRect);
            }
            roundedBitmapDrawable.mDstRectF.set(roundedBitmapDrawable.mDstRect);
            if (roundedBitmapDrawable.mBitmapShader != null) {
                Matrix matrix = roundedBitmapDrawable.mShaderMatrix;
                RectF rectF = roundedBitmapDrawable.mDstRectF;
                matrix.setTranslate(rectF.left, rectF.top);
                roundedBitmapDrawable.mShaderMatrix.preScale(roundedBitmapDrawable.mDstRectF.width() / ((float) roundedBitmapDrawable.mBitmap.getWidth()), roundedBitmapDrawable.mDstRectF.height() / ((float) roundedBitmapDrawable.mBitmap.getHeight()));
                roundedBitmapDrawable.mBitmapShader.setLocalMatrix(roundedBitmapDrawable.mShaderMatrix);
                roundedBitmapDrawable.mPaint.setShader(roundedBitmapDrawable.mBitmapShader);
            }
            roundedBitmapDrawable.mApplyGravity = false;
            return;
        }
    }

    public void setTargetDensity(@NonNull DisplayMetrics displayMetrics) {
        setTargetDensity(displayMetrics.densityDpi);
    }

    public void setTargetDensity(int i5) {
        if (this.mTargetDensity != i5) {
            if (i5 == 0) {
                i5 = 160;
            }
            this.mTargetDensity = i5;
            if (this.mBitmap != null) {
                computeBitmapSize();
            }
            invalidateSelf();
        }
    }
}
