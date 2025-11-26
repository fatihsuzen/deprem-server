package C2;

import S1.k;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b2.C2291k;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import k2.C2592b;
import kotlin.jvm.internal.t;
import l2.C2655d;
import z2.C2954m;
import z2.C2962v;
import z2.P;

/* renamed from: C2.b  reason: case insensitive filesystem */
public final class C2002b extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final C2592b f17697a;

    /* renamed from: b  reason: collision with root package name */
    private final ImageView f17698b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f17699c;

    /* renamed from: d  reason: collision with root package name */
    private final TextView f17700d;

    /* renamed from: e  reason: collision with root package name */
    private final TextView f17701e;

    /* renamed from: f  reason: collision with root package name */
    private final TextView f17702f;

    /* renamed from: g  reason: collision with root package name */
    private final TextView f17703g;

    /* renamed from: h  reason: collision with root package name */
    private final RelativeLayout f17704h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2002b(View view, C2592b bVar) {
        super(view);
        t.e(view, "itemView");
        this.f17697a = bVar;
        View findViewById = view.findViewById(R.id.iv_icon_installed_app_item);
        t.d(findViewById, "findViewById(...)");
        this.f17698b = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_name_installed_app_item);
        t.d(findViewById2, "findViewById(...)");
        TextView textView = (TextView) findViewById2;
        this.f17699c = textView;
        View findViewById3 = view.findViewById(R.id.tv_version_installed_app_item);
        t.d(findViewById3, "findViewById(...)");
        TextView textView2 = (TextView) findViewById3;
        this.f17700d = textView2;
        View findViewById4 = view.findViewById(R.id.tv_size_installed_app_item);
        t.d(findViewById4, "findViewById(...)");
        TextView textView3 = (TextView) findViewById4;
        this.f17701e = textView3;
        View findViewById5 = view.findViewById(R.id.tv_last_update_installed_app_item);
        t.d(findViewById5, "findViewById(...)");
        TextView textView4 = (TextView) findViewById5;
        this.f17702f = textView4;
        View findViewById6 = view.findViewById(R.id.tv_excluded_installed_app_item);
        t.d(findViewById6, "findViewById(...)");
        TextView textView5 = (TextView) findViewById6;
        this.f17703g = textView5;
        View findViewById7 = view.findViewById(R.id.rl_installed_app_item);
        t.d(findViewById7, "findViewById(...)");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById7;
        this.f17704h = relativeLayout;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        textView2.setTypeface(aVar.w());
        textView3.setTypeface(aVar.x());
        textView4.setTypeface(aVar.x());
        textView5.setTypeface(aVar.w());
        relativeLayout.setOnClickListener(new C1999a(this));
    }

    /* access modifiers changed from: private */
    public static final void b(C2002b bVar, View view) {
        int bindingAdapterPosition;
        if (bVar.f17697a != null && (bindingAdapterPosition = bVar.getBindingAdapterPosition()) != -1) {
            bVar.f17697a.a(bindingAdapterPosition);
        }
    }

    private final void d(C2655d dVar) {
        if (dVar.d()) {
            this.itemView.setAlpha(0.3f);
        } else {
            this.itemView.setAlpha(1.0f);
        }
    }

    public final void c(C2655d dVar) {
        t.e(dVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        d(dVar);
        P p5 = P.f26510a;
        Context context = this.itemView.getContext();
        t.d(context, "getContext(...)");
        this.f17698b.setImageDrawable(p5.j(context, dVar.o()));
        this.f17699c.setText(dVar.m());
        this.f17700d.setText(dVar.B());
        TextView textView = this.f17701e;
        C2291k kVar = new C2291k();
        long t5 = dVar.t();
        Context context2 = this.itemView.getContext();
        t.d(context2, "getContext(...)");
        textView.setText(kVar.d(t5, context2));
        this.f17702f.setText(new C2962v().n(dVar.j()));
        if (UptodownApp.f13477F.K()) {
            String n5 = new C2962v().n(dVar.j());
            C2954m mVar = new C2954m();
            Context context3 = this.itemView.getContext();
            t.d(context3, "getContext(...)");
            String o5 = dVar.o();
            t.b(o5);
            String h5 = mVar.h(context3, o5);
            if (h5 != null) {
                n5 = new C2962v().n(dVar.j()) + " (" + h5 + ')';
            }
            this.f17702f.setText(n5);
        }
        this.f17703g.setText(this.itemView.getContext().getString(R.string.disabled_updates));
        this.f17703g.setVisibility(0);
    }
}
