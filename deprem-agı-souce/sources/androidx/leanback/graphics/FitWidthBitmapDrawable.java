package androidx.leanback.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.IntProperty;
import android.util.Property;
import androidx.annotation.RequiresApi;

public class FitWidthBitmapDrawable extends Drawable {
    public static final Property<FitWidthBitmapDrawable, Integer> PROPERTY_VERTICAL_OFFSET;
    BitmapState mBitmapState;
    final Rect mDest;
    boolean mMutated;

    static {
        if (Build.VERSION.SDK_INT >= 24) {
            PROPERTY_VERTICAL_OFFSET = getVerticalOffsetIntProperty();
        } else {
            PROPERTY_VERTICAL_OFFSET = new Property<FitWidthBitmapDrawable, Integer>(Integer.class, "verticalOffset") {
                public Integer get(FitWidthBitmapDrawable fitWidthBitmapDrawable) {
                    return Integer.valueOf(fitWidthBitmapDrawable.getVerticalOffset());
                }

                public void set(FitWidthBitmapDrawable fitWidthBitmapDrawable, Integer num) {
                    fitWidthBitmapDrawable.setVerticalOffset(num.intValue());
                }
            };
        }
    }

    public FitWidthBitmapDrawable() {
        this.mDest = new Rect();
        this.mMutated = false;
        this.mBitmapState = new BitmapState();
    }

    @RequiresApi(24)
    static IntProperty getVerticalOffsetIntProperty() {
        return new IntProperty("verticalOffset") {
            public Integer get(FitWidthBitmapDrawable fitWidthBitmapDrawable) {
                return Integer.valueOf(fitWidthBitmapDrawable.getVerticalOffset());
            }

            public void setValue(FitWidthBitmapDrawable fitWidthBitmapDrawable, int i5) {
                fitWidthBitmapDrawable.setVerticalOffset(i5);
            }
        };
    }

    private Rect validateSource() {
        BitmapState bitmapState = this.mBitmapState;
        Rect rect = bitmapState.mSource;
        if (rect == null) {
            return bitmapState.mDefaultSource;
        }
        return rect;
    }

    public void draw(Canvas canvas) {
        if (this.mBitmapState.mBitmap != null) {
            Rect bounds = getBounds();
            Rect rect = this.mDest;
            rect.left = 0;
            rect.top = this.mBitmapState.mOffset;
            rect.right = bounds.width();
            Rect validateSource = validateSource();
            float width = ((float) bounds.width()) / ((float) validateSource.width());
            Rect rect2 = this.mDest;
            rect2.bottom = rect2.top + ((int) (((float) validateSource.height()) * width));
            int save = canvas.save();
            canvas.clipRect(bounds);
            BitmapState bitmapState = this.mBitmapState;
            canvas.drawBitmap(bitmapState.mBitmap, validateSource, this.mDest, bitmapState.mPaint);
            canvas.restoreToCount(save);
        }
    }

    public int getAlpha() {
        return this.mBitmapState.mPaint.getAlpha();
    }

    public Bitmap getBitmap() {
        return this.mBitmapState.mBitmap;
    }

    public Drawable.ConstantState getConstantState() {
        return this.mBitmapState;
    }

    public int getOpacity() {
        Bitmap bitmap = this.mBitmapState.mBitmap;
        if (bitmap == null || bitmap.hasAlpha() || this.mBitmapState.mPaint.getAlpha() < 255) {
            return -3;
        }
        return -1;
    }

    public Rect getSource() {
        return this.mBitmapState.mSource;
    }

    public int getVerticalOffset() {
        return this.mBitmapState.mOffset;
    }

    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            this.mBitmapState = new BitmapState(this.mBitmapState);
            this.mMutated = true;
        }
        return this;
    }

    public void setAlpha(int i5) {
        if (i5 != this.mBitmapState.mPaint.getAlpha()) {
            this.mBitmapState.mPaint.setAlpha(i5);
            invalidateSelf();
        }
    }

    public void setBitmap(Bitmap bitmap) {
        BitmapState bitmapState = this.mBitmapState;
        bitmapState.mBitmap = bitmap;
        if (bitmap != null) {
            bitmapState.mDefaultSource.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        } else {
            bitmapState.mDefaultSource.set(0, 0, 0, 0);
        }
        this.mBitmapState.mSource = null;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mBitmapState.mPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setSource(Rect rect) {
        this.mBitmapState.mSource = rect;
    }

    public void setVerticalOffset(int i5) {
        this.mBitmapState.mOffset = i5;
        invalidateSelf();
    }

    static class BitmapState extends Drawable.ConstantState {
        Bitmap mBitmap;
        final Rect mDefaultSource;
        int mOffset;
        Paint mPaint;
        Rect mSource;

        BitmapState() {
            this.mDefaultSource = new Rect();
            this.mPaint = new Paint();
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            return new FitWidthBitmapDrawable(this);
        }

        BitmapState(BitmapState bitmapState) {
            Rect rect = new Rect();
            this.mDefaultSource = rect;
            this.mBitmap = bitmapState.mBitmap;
            this.mPaint = new Paint(bitmapState.mPaint);
            this.mSource = bitmapState.mSource != null ? new Rect(bitmapState.mSource) : null;
            rect.set(bitmapState.mDefaultSource);
            this.mOffset = bitmapState.mOffset;
        }
    }

    FitWidthBitmapDrawable(BitmapState bitmapState) {
        this.mDest = new Rect();
        this.mMutated = false;
        this.mBitmapState = bitmapState;
    }
}
