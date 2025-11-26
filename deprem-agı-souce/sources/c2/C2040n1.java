package C2;

import R1.L;
import S1.k;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b2.C2291k;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import k2.C2592b;
import kotlin.jvm.internal.t;
import l2.C2655d;
import z2.C2954m;
import z2.C2962v;
import z2.P;

/* renamed from: C2.n1  reason: case insensitive filesystem */
public final class C2040n1 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final C2592b f17842a;

    /* renamed from: b  reason: collision with root package name */
    private final ImageView f17843b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f17844c;

    /* renamed from: d  reason: collision with root package name */
    private final TextView f17845d;

    /* renamed from: e  reason: collision with root package name */
    private final TextView f17846e;

    /* renamed from: f  reason: collision with root package name */
    private final TextView f17847f;

    /* renamed from: g  reason: collision with root package name */
    private final TextView f17848g;

    /* renamed from: h  reason: collision with root package name */
    private final RelativeLayout f17849h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2040n1(View view, C2592b bVar) {
        super(view);
        t.e(view, "itemView");
        this.f17842a = bVar;
        View findViewById = view.findViewById(R.id.iv_icon_installed_app_item);
        t.d(findViewById, "findViewById(...)");
        this.f17843b = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_name_installed_app_item);
        t.d(findViewById2, "findViewById(...)");
        TextView textView = (TextView) findViewById2;
        this.f17844c = textView;
        View findViewById3 = view.findViewById(R.id.tv_version_installed_app_item);
        t.d(findViewById3, "findViewById(...)");
        TextView textView2 = (TextView) findViewById3;
        this.f17845d = textView2;
        View findViewById4 = view.findViewById(R.id.tv_size_installed_app_item);
        t.d(findViewById4, "findViewById(...)");
        TextView textView3 = (TextView) findViewById4;
        this.f17846e = textView3;
        View findViewById5 = view.findViewById(R.id.tv_last_update_installed_app_item);
        t.d(findViewById5, "findViewById(...)");
        TextView textView4 = (TextView) findViewById5;
        this.f17847f = textView4;
        View findViewById6 = view.findViewById(R.id.tv_excluded_installed_app_item);
        t.d(findViewById6, "findViewById(...)");
        TextView textView5 = (TextView) findViewById6;
        this.f17848g = textView5;
        View findViewById7 = view.findViewById(R.id.rl_installed_app_item);
        t.d(findViewById7, "findViewById(...)");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById7;
        this.f17849h = relativeLayout;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        textView2.setTypeface(aVar.w());
        textView3.setTypeface(aVar.x());
        textView4.setTypeface(aVar.x());
        textView5.setTypeface(aVar.w());
        relativeLayout.setOnClickListener(new C2037m1(this));
    }

    /* access modifiers changed from: private */
    public static final void b(C2040n1 n1Var, View view) {
        int bindingAdapterPosition;
        if (n1Var.f17842a != null && (bindingAdapterPosition = n1Var.getBindingAdapterPosition()) != -1) {
            n1Var.f17842a.a(bindingAdapterPosition);
        }
    }

    private final void d(C2655d dVar) {
        if (dVar.d()) {
            this.itemView.setAlpha(0.3f);
        } else {
            this.itemView.setAlpha(1.0f);
        }
    }

    public final void c(L.a aVar) {
        t.e(aVar, "appUpdateData");
        d(aVar.a());
        P p5 = P.f26510a;
        Context context = this.itemView.getContext();
        t.d(context, "getContext(...)");
        this.f17843b.setImageDrawable(p5.j(context, aVar.a().o()));
        this.f17844c.setText(aVar.a().m());
        this.f17845d.setText(aVar.a().B());
        TextView textView = this.f17846e;
        C2291k kVar = new C2291k();
        long t5 = aVar.a().t();
        Context context2 = this.itemView.getContext();
        t.d(context2, "getContext(...)");
        textView.setText(kVar.d(t5, context2));
        this.f17847f.setText(new C2962v().n(aVar.a().j()));
        if (UptodownApp.f13477F.K()) {
            String n5 = new C2962v().n(aVar.a().j());
            C2954m mVar = new C2954m();
            Context context3 = this.itemView.getContext();
            t.d(context3, "getContext(...)");
            String o5 = aVar.a().o();
            t.b(o5);
            String h5 = mVar.h(context3, o5);
            if (h5 != null) {
                n5 = new C2962v().n(aVar.a().j()) + " (" + h5 + ')';
            }
            this.f17847f.setText(n5);
        }
        if (aVar.b().e() == 1) {
            this.f17848g.setText(this.itemView.getContext().getString(R.string.skipped_update));
            this.f17848g.setVisibility(0);
            return;
        }
        this.f17848g.setVisibility(8);
        this.f17846e.setVisibility(8);
    }
}
