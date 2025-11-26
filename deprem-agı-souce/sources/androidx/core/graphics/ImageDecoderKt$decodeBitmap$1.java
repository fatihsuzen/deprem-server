package androidx.core.graphics;

import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder$OnHeaderDecodedListener;
import k3.q;

public final class ImageDecoderKt$decodeBitmap$1 implements ImageDecoder$OnHeaderDecodedListener {
    final /* synthetic */ q $action;

    public ImageDecoderKt$decodeBitmap$1(q qVar) {
        this.$action = qVar;
    }

    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        this.$action.invoke(imageDecoder, imageInfo, source);
    }
}
