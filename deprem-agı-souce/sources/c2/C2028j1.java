package C2;

import B2.s;
import S1.k;
import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import k2.C2599i;
import kotlin.jvm.internal.t;
import l2.C2666o;

/* renamed from: C2.j1  reason: case insensitive filesystem */
public final class C2028j1 extends RecyclerView.ViewHolder {

    /* renamed from: C2.j1$a */
    public static final class a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f17818a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f17819b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f17820c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f17821d;

        a(TextView textView, View view, String str, String str2) {
            this.f17818a = textView;
            this.f17819b = view;
            this.f17820c = str;
            this.f17821d = str2;
        }

        /* access modifiers changed from: private */
        public static final void b(TextView textView, View view, TextView textView2, String str, String str2, View view2) {
            if (textView.getMaxLines() == 3) {
                textView.setMaxLines(Integer.MAX_VALUE);
                view.setVisibility(8);
                textView2.setText(str);
                return;
            }
            textView.setMaxLines(3);
            view.setVisibility(0);
            textView2.setText(str2);
        }

        public boolean onPreDraw() {
            this.f17818a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (!s.a(this.f17818a)) {
                return true;
            }
            View findViewById = this.f17819b.findViewById(R.id.shadow_description_category_description);
            TextView textView = (TextView) this.f17819b.findViewById(R.id.tv_read_more_category_description);
            textView.setTypeface(k.f32g.w());
            textView.setVisibility(0);
            textView.setOnClickListener(new C2025i1(this.f17818a, findViewById, textView, this.f17820c, this.f17821d));
            findViewById.setVisibility(0);
            return true;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2028j1(View view, String str, String str2, String str3, String str4, C2599i iVar) {
        super(view);
        t.e(view, "itemView");
        t.e(str3, "readMore");
        t.e(str4, "readLess");
        if (str == null || str.length() == 0) {
            view.setVisibility(8);
            return;
        }
        View findViewById = view.findViewById(R.id.tv_top_by_category_description);
        t.d(findViewById, "findViewById(...)");
        TextView textView = (TextView) findViewById;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.x());
        if (iVar != null) {
            B2.k.f17347a.a(textView);
            C2666o.a aVar2 = C2666o.f25106g;
            Context context = view.getContext();
            t.d(context, "getContext(...)");
            textView.setText(aVar2.m(str, context, iVar));
        } else {
            textView.setText(str);
        }
        textView.getViewTreeObserver().addOnPreDrawListener(new a(textView, view, str4, str3));
        if (str2 != null && str2.length() != 0) {
            View findViewById2 = view.findViewById(R.id.tv_top_by_category_title);
            t.d(findViewById2, "findViewById(...)");
            TextView textView2 = (TextView) findViewById2;
            textView2.setTypeface(aVar.w());
            textView2.setText(str2);
            textView2.setVisibility(0);
        }
    }
}
