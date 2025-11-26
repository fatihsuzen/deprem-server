package androidx.core.text;

import android.text.Html;
import android.text.Spanned;

public final class HtmlKt {
    public static final Spanned parseAsHtml(String str, int i5, Html.ImageGetter imageGetter, Html.TagHandler tagHandler) {
        return HtmlCompat.fromHtml(str, i5, imageGetter, tagHandler);
    }

    public static /* synthetic */ Spanned parseAsHtml$default(String str, int i5, Html.ImageGetter imageGetter, Html.TagHandler tagHandler, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i5 = 0;
        }
        if ((i6 & 2) != 0) {
            imageGetter = null;
        }
        if ((i6 & 4) != 0) {
            tagHandler = null;
        }
        return HtmlCompat.fromHtml(str, i5, imageGetter, tagHandler);
    }

    public static final String toHtml(Spanned spanned, int i5) {
        return HtmlCompat.toHtml(spanned, i5);
    }

    public static /* synthetic */ String toHtml$default(Spanned spanned, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i5 = 0;
        }
        return HtmlCompat.toHtml(spanned, i5);
    }
}
