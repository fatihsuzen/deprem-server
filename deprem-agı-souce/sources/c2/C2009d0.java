package C2;

import S1.k;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.AlignmentSpan;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import k2.C2613x;
import kotlin.jvm.internal.t;
import l2.C2675y;
import t3.s;

/* renamed from: C2.d0  reason: case insensitive filesystem */
public final class C2009d0 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private C2613x f17726a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f17727b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f17728c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2009d0(View view, C2613x xVar) {
        super(view);
        t.e(view, "itemView");
        t.e(xVar, "listener");
        this.f17726a = xVar;
        View findViewById = view.findViewById(R.id.tv_language_name_original);
        t.d(findViewById, "findViewById(...)");
        this.f17727b = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_language_name_localized);
        t.d(findViewById2, "findViewById(...)");
        this.f17728c = (TextView) findViewById2;
        TextView textView = this.f17727b;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.x());
        this.f17728c.setTypeface(aVar.x());
    }

    /* access modifiers changed from: private */
    public static final void c(C2009d0 d0Var, C2675y yVar, View view) {
        d0Var.f17726a.a(yVar);
    }

    public final void b(C2675y yVar, String str) {
        t.e(yVar, "lang");
        t.e(str, "currentLanguageCode");
        this.f17727b.setText(yVar.c());
        this.f17728c.setText(yVar.b());
        this.itemView.setOnClickListener(new C2006c0(this, yVar));
        if (s.E(yVar.a(), "ar", false)) {
            if (!t.a(str, "ar")) {
                SpannableString spannableString = new SpannableString(yVar.c());
                spannableString.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_OPPOSITE), 0, spannableString.length(), 33);
                this.f17727b.setText(spannableString);
            }
        } else if (t.a(str, "ar")) {
            SpannableString spannableString2 = new SpannableString(yVar.c());
            spannableString2.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_OPPOSITE), 0, spannableString2.length(), 33);
            this.f17727b.setText(spannableString2);
        }
    }
}
