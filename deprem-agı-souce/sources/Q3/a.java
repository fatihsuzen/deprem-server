package Q3;

import android.text.Html;
import android.text.Spanned;
import androidx.core.text.HtmlCompat;
import kotlin.jvm.internal.t;
import t3.s;

public abstract class a {
    public static final Spanned a(String str) {
        t.e(str, "source");
        Spanned fromHtml = HtmlCompat.fromHtml(s.J(s.J(s.J(s.J(s.J(s.J(str, "<ul>", "<customUl>", true), "</ul>", "</customUl>", true), "<ol>", "<customOl>", true), "<ol>", "</customOl>", true), "<li>", "<customLi>", true), "</li>", "</customLi>", true), 0, (Html.ImageGetter) null, new b());
        t.d(fromHtml, "fromHtml(customTagsSourc…, null, HtmlTagHandler())");
        return fromHtml;
    }
}
