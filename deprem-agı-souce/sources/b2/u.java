package B2;

import S1.k;
import X2.C2250q;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Editable;
import android.text.Html;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.text.style.MetricAffectingSpan;
import androidx.core.content.ContextCompat;
import com.uptodown.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import org.xml.sax.XMLReader;
import t3.s;

public final class u implements Html.TagHandler {

    /* renamed from: c  reason: collision with root package name */
    public static final a f17360c = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final Context f17361a;

    /* renamed from: b  reason: collision with root package name */
    private final List f17362b = new ArrayList();

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final Spanned a(Context context, String str) {
            t.e(context, "context");
            t.e(str, "rawText");
            if (Build.VERSION.SDK_INT >= 24) {
                Spanned a5 = Html.fromHtml(str, 0, (Html.ImageGetter) null, new u(context));
                t.b(a5);
                return a5;
            }
            Spanned fromHtml = Html.fromHtml(str, (Html.ImageGetter) null, new u(context));
            t.b(fromHtml);
            return fromHtml;
        }

        private a() {
        }
    }

    public final class b extends MetricAffectingSpan {

        /* renamed from: a  reason: collision with root package name */
        private final Typeface f17363a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ u f17364b;

        public b(u uVar, Typeface typeface) {
            t.e(typeface, "customTypeface");
            this.f17364b = uVar;
            this.f17363a = typeface;
        }

        private final void a(Paint paint, Typeface typeface) {
            paint.setTypeface(typeface);
        }

        public void updateDrawState(TextPaint textPaint) {
            t.e(textPaint, "tp");
            a(textPaint, this.f17363a);
        }

        public void updateMeasureState(TextPaint textPaint) {
            t.e(textPaint, "tp");
            a(textPaint, this.f17363a);
        }
    }

    public u(Context context) {
        t.e(context, "context");
        this.f17361a = context;
    }

    public void handleTag(boolean z4, String str, Editable editable, XMLReader xMLReader) {
        t.e(str, "tag");
        t.e(editable, "output");
        t.e(xMLReader, "xmlReader");
        if (!s.E(str, "turbo", true)) {
            return;
        }
        if (z4) {
            this.f17362b.add(Integer.valueOf(editable.length()));
        } else if (!this.f17362b.isEmpty()) {
            List list = this.f17362b;
            int intValue = ((Number) list.remove(C2250q.i(list))).intValue();
            int length = editable.length();
            editable.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.f17361a, R.color.turbo_main)), intValue, length, 33);
            k.a aVar = k.f32g;
            if (aVar.w() != null) {
                Typeface w4 = aVar.w();
                t.b(w4);
                editable.setSpan(new b(this, w4), intValue, length, 33);
            }
        }
    }
}
