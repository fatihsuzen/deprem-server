package androidx.core.text;

import android.text.Spanned;
import android.text.SpannedString;
import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.internal.t;

public final class SpannedStringKt {
    public static /* synthetic */ Object[] getSpans$default(Spanned spanned, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i5 = 0;
        }
        if ((i7 & 2) != 0) {
            i6 = spanned.length();
        }
        t.k(4, ExifInterface.GPS_DIRECTION_TRUE);
        return spanned.getSpans(i5, i6, Object.class);
    }

    public static final Spanned toSpanned(CharSequence charSequence) {
        return SpannedString.valueOf(charSequence);
    }
}
