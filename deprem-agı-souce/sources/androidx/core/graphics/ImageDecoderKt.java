package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import androidx.annotation.RequiresApi;
import k3.q;

@SuppressLint({"ClassVerificationFailure"})
public final class ImageDecoderKt {
    @RequiresApi(28)
    public static final Bitmap decodeBitmap(ImageDecoder.Source source, q qVar) {
        return ImageDecoder.decodeBitmap(source, u.a(new ImageDecoderKt$decodeBitmap$1(qVar)));
    }

    @RequiresApi(28)
    public static final Drawable decodeDrawable(ImageDecoder.Source source, q qVar) {
        return ImageDecoder.decodeDrawable(source, u.a(new ImageDecoderKt$decodeDrawable$1(qVar)));
    }
}
