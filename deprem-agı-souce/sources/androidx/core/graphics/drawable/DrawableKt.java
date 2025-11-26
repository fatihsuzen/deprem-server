package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.Px;

public final class DrawableKt {
    public static final Bitmap toBitmap(Drawable drawable, @Px int i5, @Px int i6, Bitmap.Config config) {
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() == null) {
                throw new IllegalArgumentException("bitmap is null");
            } else if (config == null || bitmapDrawable.getBitmap().getConfig() == config) {
                if (i5 == bitmapDrawable.getBitmap().getWidth() && i6 == bitmapDrawable.getBitmap().getHeight()) {
                    return bitmapDrawable.getBitmap();
                }
                return Bitmap.createScaledBitmap(bitmapDrawable.getBitmap(), i5, i6, true);
            }
        }
        Rect bounds = drawable.getBounds();
        int i7 = bounds.left;
        int i8 = bounds.top;
        int i9 = bounds.right;
        int i10 = bounds.bottom;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i5, i6, config);
        drawable.setBounds(0, 0, i5, i6);
        drawable.draw(new Canvas(createBitmap));
        drawable.setBounds(i7, i8, i9, i10);
        return createBitmap;
    }

    public static /* synthetic */ Bitmap toBitmap$default(Drawable drawable, int i5, int i6, Bitmap.Config config, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i5 = drawable.getIntrinsicWidth();
        }
        if ((i7 & 2) != 0) {
            i6 = drawable.getIntrinsicHeight();
        }
        if ((i7 & 4) != 0) {
            config = null;
        }
        return toBitmap(drawable, i5, i6, config);
    }

    public static final Bitmap toBitmapOrNull(Drawable drawable, @Px int i5, @Px int i6, Bitmap.Config config) {
        if (!(drawable instanceof BitmapDrawable) || ((BitmapDrawable) drawable).getBitmap() != null) {
            return toBitmap(drawable, i5, i6, config);
        }
        return null;
    }

    public static /* synthetic */ Bitmap toBitmapOrNull$default(Drawable drawable, int i5, int i6, Bitmap.Config config, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i5 = drawable.getIntrinsicWidth();
        }
        if ((i7 & 2) != 0) {
            i6 = drawable.getIntrinsicHeight();
        }
        if ((i7 & 4) != 0) {
            config = null;
        }
        return toBitmapOrNull(drawable, i5, i6, config);
    }

    public static final void updateBounds(Drawable drawable, @Px int i5, @Px int i6, @Px int i7, @Px int i8) {
        drawable.setBounds(i5, i6, i7, i8);
    }

    public static /* synthetic */ void updateBounds$default(Drawable drawable, int i5, int i6, int i7, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i5 = drawable.getBounds().left;
        }
        if ((i9 & 2) != 0) {
            i6 = drawable.getBounds().top;
        }
        if ((i9 & 4) != 0) {
            i7 = drawable.getBounds().right;
        }
        if ((i9 & 8) != 0) {
            i8 = drawable.getBounds().bottom;
        }
        updateBounds(drawable, i5, i6, i7, i8);
    }
}
