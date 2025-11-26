package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
class RoundedBitmapDrawable21 extends RoundedBitmapDrawable {
    protected RoundedBitmapDrawable21(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    public void getOutline(@NonNull Outline outline) {
        updateDstRect();
        outline.setRoundRect(this.mDstRect, getCornerRadius());
    }

    /* access modifiers changed from: package-private */
    public void gravityCompatApply(int i5, int i6, int i7, Rect rect, Rect rect2) {
        Gravity.apply(i5, i6, i7, rect, rect2, 0);
    }

    public boolean hasMipMap() {
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null || !bitmap.hasMipMap()) {
            return false;
        }
        return true;
    }

    public void setMipMap(boolean z4) {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            bitmap.setHasMipMap(z4);
            invalidateSelf();
        }
    }
}
