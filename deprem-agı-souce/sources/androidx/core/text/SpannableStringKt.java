package androidx.core.text;

import android.text.Spannable;
import android.text.SpannableString;
import q3.C2728d;

public final class SpannableStringKt {
    public static final void clearSpans(Spannable spannable) {
        for (Object removeSpan : spannable.getSpans(0, spannable.length(), Object.class)) {
            spannable.removeSpan(removeSpan);
        }
    }

    public static final void set(Spannable spannable, int i5, int i6, Object obj) {
        spannable.setSpan(obj, i5, i6, 17);
    }

    public static final Spannable toSpannable(CharSequence charSequence) {
        return SpannableString.valueOf(charSequence);
    }

    public static final void set(Spannable spannable, C2728d dVar, Object obj) {
        spannable.setSpan(obj, dVar.getStart().intValue(), dVar.getEndInclusive().intValue(), 17);
    }
}
