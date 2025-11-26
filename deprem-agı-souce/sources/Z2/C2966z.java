package z2;

import android.graphics.Typeface;
import android.os.Build;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

/* renamed from: z2.z  reason: case insensitive filesystem */
public final class C2966z extends MetricAffectingSpan {

    /* renamed from: d  reason: collision with root package name */
    public static final a f26564d = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final float f26565a;

    /* renamed from: b  reason: collision with root package name */
    private final Typeface f26566b;

    /* renamed from: c  reason: collision with root package name */
    private final int f26567c;

    /* renamed from: z2.z$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final SpannableString a(String str) {
            t.e(str, MimeTypes.BASE_TYPE_TEXT);
            if (Build.VERSION.SDK_INT >= 24) {
                return new SpannableString(Html.fromHtml(str, 0));
            }
            return new SpannableString(Html.fromHtml(str));
        }

        private a() {
        }
    }

    public C2966z(float f5, Typeface typeface, int i5) {
        t.e(typeface, "typeface");
        this.f26565a = f5;
        this.f26566b = typeface;
        this.f26567c = i5;
    }

    public void updateDrawState(TextPaint textPaint) {
        t.e(textPaint, TtmlNode.TAG_P);
        textPaint.setTextSize(this.f26565a);
        textPaint.setTypeface(this.f26566b);
        textPaint.setColor(this.f26567c);
    }

    public void updateMeasureState(TextPaint textPaint) {
        t.e(textPaint, TtmlNode.TAG_P);
        textPaint.setTextSize(this.f26565a);
        textPaint.setTypeface(this.f26566b);
        textPaint.setColor(this.f26567c);
    }
}
