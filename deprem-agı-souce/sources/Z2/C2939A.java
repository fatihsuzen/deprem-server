package z2;

import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import android.text.style.StyleSpan;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.text.HtmlCompat;
import java.util.Iterator;
import kotlin.jvm.internal.C2625c;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

/* renamed from: z2.A  reason: case insensitive filesystem */
public final class C2939A extends MetricAffectingSpan {

    /* renamed from: b  reason: collision with root package name */
    public static final a f26456b = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final Typeface f26457a;

    /* renamed from: z2.A$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final SpannableString a(String str, Typeface typeface) {
            t.e(str, TypedValues.Custom.S_STRING);
            t.e(typeface, "typeface");
            Spanned fromHtml = HtmlCompat.fromHtml(str, 0);
            t.d(fromHtml, "fromHtml(...)");
            SpannableString spannableString = new SpannableString(fromHtml);
            Iterator a5 = C2625c.a((StyleSpan[]) spannableString.getSpans(0, spannableString.length(), StyleSpan.class));
            while (a5.hasNext()) {
                StyleSpan styleSpan = (StyleSpan) a5.next();
                if (styleSpan.getStyle() == 1) {
                    int spanStart = spannableString.getSpanStart(styleSpan);
                    int spanEnd = spannableString.getSpanEnd(styleSpan);
                    spannableString.removeSpan(styleSpan);
                    spannableString.setSpan(new C2939A(typeface), spanStart, spanEnd, 33);
                }
            }
            return spannableString;
        }

        private a() {
        }
    }

    public C2939A(Typeface typeface) {
        t.e(typeface, "typeface");
        this.f26457a = typeface;
    }

    public void updateDrawState(TextPaint textPaint) {
        t.e(textPaint, TtmlNode.TAG_P);
        textPaint.setTypeface(this.f26457a);
    }

    public void updateMeasureState(TextPaint textPaint) {
        t.e(textPaint, TtmlNode.TAG_P);
        textPaint.setTypeface(this.f26457a);
    }
}
