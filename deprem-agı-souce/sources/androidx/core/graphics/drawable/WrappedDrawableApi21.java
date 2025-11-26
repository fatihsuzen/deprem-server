package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

@RequiresApi(21)
class WrappedDrawableApi21 extends WrappedDrawableApi14 {
    private static final String TAG = "WrappedDrawableApi21";
    private static Method sIsProjectedDrawableMethod;

    WrappedDrawableApi21(Drawable drawable) {
        super(drawable);
        findAndCacheIsProjectedDrawableMethod();
    }

    private void findAndCacheIsProjectedDrawableMethod() {
        if (sIsProjectedDrawableMethod == null) {
            try {
                sIsProjectedDrawableMethod = Drawable.class.getDeclaredMethod("isProjected", (Class[]) null);
            } catch (Exception e5) {
                Log.w(TAG, "Failed to retrieve Drawable#isProjected() method", e5);
            }
        }
    }

    @NonNull
    public Rect getDirtyBounds() {
        return this.mDrawable.getDirtyBounds();
    }

    public void getOutline(@NonNull Outline outline) {
        this.mDrawable.getOutline(outline);
    }

    /* access modifiers changed from: protected */
    public boolean isCompatTintEnabled() {
        return false;
    }

    public boolean isProjected() {
        Method method;
        Drawable drawable = this.mDrawable;
        if (drawable == null || (method = sIsProjectedDrawableMethod) == null) {
            return false;
        }
        try {
            return ((Boolean) method.invoke(drawable, (Object[]) null)).booleanValue();
        } catch (Exception e5) {
            Log.w(TAG, "Error calling Drawable#isProjected() method", e5);
            return false;
        }
    }

    public void setHotspot(float f5, float f6) {
        this.mDrawable.setHotspot(f5, f6);
    }

    public void setHotspotBounds(int i5, int i6, int i7, int i8) {
        this.mDrawable.setHotspotBounds(i5, i6, i7, i8);
    }

    public boolean setState(@NonNull int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    public void setTint(int i5) {
        if (isCompatTintEnabled()) {
            super.setTint(i5);
        } else {
            this.mDrawable.setTint(i5);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (isCompatTintEnabled()) {
            super.setTintList(colorStateList);
        } else {
            this.mDrawable.setTintList(colorStateList);
        }
    }

    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        if (isCompatTintEnabled()) {
            super.setTintMode(mode);
        } else {
            this.mDrawable.setTintMode(mode);
        }
    }

    WrappedDrawableApi21(WrappedDrawableState wrappedDrawableState, Resources resources) {
        super(wrappedDrawableState, resources);
        findAndCacheIsProjectedDrawableMethod();
    }
}
