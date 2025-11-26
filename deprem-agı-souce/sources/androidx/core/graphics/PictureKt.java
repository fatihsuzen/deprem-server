package androidx.core.graphics;

import android.graphics.Picture;
import k3.l;
import kotlin.jvm.internal.r;

public final class PictureKt {
    public static final Picture record(Picture picture, int i5, int i6, l lVar) {
        try {
            lVar.invoke(picture.beginRecording(i5, i6));
            return picture;
        } finally {
            r.b(1);
            picture.endRecording();
            r.a(1);
        }
    }
}
