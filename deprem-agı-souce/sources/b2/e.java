package B2;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import com.uptodown.util.views.CropImageView;
import kotlin.jvm.internal.t;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final CropImageView f17336a;

    public e(CropImageView cropImageView) {
        t.e(cropImageView, "cropImageView");
        this.f17336a = cropImageView;
    }

    private final Matrix b() {
        Matrix imageMatrix = this.f17336a.getImageMatrix();
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
        int width = (this.f17336a.getWidth() - this.f17336a.getPaddingLeft()) - this.f17336a.getPaddingRight();
        int height = (this.f17336a.getHeight() - this.f17336a.getPaddingTop()) - this.f17336a.getPaddingBottom();
        int cropType = this.f17336a.getCropType();
        Drawable drawable = this.f17336a.getDrawable();
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
            this.f17336a.setImageMatrix(b5);
        }
    }
}
