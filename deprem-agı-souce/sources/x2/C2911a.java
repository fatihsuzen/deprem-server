package x2;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import com.uptodown.tv.utils.CropImageViewTv;
import kotlin.jvm.internal.t;

/* renamed from: x2.a  reason: case insensitive filesystem */
public final class C2911a {

    /* renamed from: a  reason: collision with root package name */
    private final CropImageViewTv f26328a;

    public C2911a(CropImageViewTv cropImageViewTv) {
        t.e(cropImageViewTv, "cropImageView");
        this.f26328a = cropImageViewTv;
    }

    private final Matrix b() {
        Matrix imageMatrix = this.f26328a.getImageMatrix();
        t.d(imageMatrix, "getImageMatrix(...)");
        return imageMatrix;
    }

    private final float c(int i5, int i6, float f5, boolean z4) {
        if (z4) {
            return 0.0f;
        }
        if (i5 == 3 || i5 == 4 || i5 == 5) {
            return ((float) i6) - f5;
        }
        if (i5 == 6 || i5 == 7) {
            return (((float) i6) - f5) / 2.0f;
        }
        return 0.0f;
    }

    private final float d(int i5, int i6, float f5, boolean z4) {
        if (!z4) {
            return 0.0f;
        }
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 != 4) {
                    if (!(i5 == 5 || i5 == 7)) {
                        return 0.0f;
                    }
                }
            }
            return ((float) i6) - f5;
        }
        return (((float) i6) - f5) / 2.0f;
    }

    public final void a() {
        boolean z4;
        int width = (this.f26328a.getWidth() - this.f26328a.getPaddingLeft()) - this.f26328a.getPaddingRight();
        int height = (this.f26328a.getHeight() - this.f26328a.getPaddingTop()) - this.f26328a.getPaddingBottom();
        int cropType = this.f26328a.getCropType();
        Drawable drawable = this.f26328a.getDrawable();
        if (cropType != -1 && height > 0 && width > 0 && drawable != null) {
            Matrix b5 = b();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            float intrinsicHeight = (float) drawable.getIntrinsicHeight();
            float f5 = ((float) height) / intrinsicHeight;
            float f6 = (float) intrinsicWidth;
            float f7 = ((float) width) / f6;
            int i5 = (f7 > f5 ? 1 : (f7 == f5 ? 0 : -1));
            if (i5 > 0) {
                f5 = f7;
            }
            b5.setScale(f5, f5);
            if (i5 > 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            b5.postTranslate(c(cropType, width, f6 * f5, z4), d(cropType, height, intrinsicHeight * f5, z4));
            this.f26328a.setImageMatrix(b5);
        }
    }
}
