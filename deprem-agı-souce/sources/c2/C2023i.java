package C2;

import S1.k;
import Y1.C2257a;
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
import l2.T;
import t3.s;
import z2.C2940B;
import z2.C2954m;
import z2.C2962v;
import z2.P;

/* renamed from: C2.i  reason: case insensitive filesystem */
public final class C2023i extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final C2592b f17790a;

    /* renamed from: b  reason: collision with root package name */
    private final ImageView f17791b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f17792c;

    /* renamed from: d  reason: collision with root package name */
    private final TextView f17793d;

    /* renamed from: e  reason: collision with root package name */
    private final TextView f17794e;

    /* renamed from: f  reason: collision with root package name */
    private final TextView f17795f;

    /* renamed from: g  reason: collision with root package name */
    private final TextView f17796g;

    /* renamed from: h  reason: collision with root package name */
    private final RelativeLayout f17797h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2023i(View view, C2592b bVar) {
        super(view);
        t.e(view, "itemView");
        this.f17790a = bVar;
        View findViewById = view.findViewById(R.id.iv_icon_installed_app_item);
        t.d(findViewById, "findViewById(...)");
        ImageView imageView = (ImageView) findViewById;
        this.f17791b = imageView;
        View findViewById2 = view.findViewById(R.id.tv_name_installed_app_item);
        t.d(findViewById2, "findViewById(...)");
        TextView textView = (TextView) findViewById2;
        this.f17792c = textView;
        View findViewById3 = view.findViewById(R.id.tv_version_installed_app_item);
        t.d(findViewById3, "findViewById(...)");
        TextView textView2 = (TextView) findViewById3;
        this.f17793d = textView2;
        View findViewById4 = view.findViewById(R.id.tv_size_installed_app_item);
        t.d(findViewById4, "findViewById(...)");
        TextView textView3 = (TextView) findViewById4;
        this.f17794e = textView3;
        View findViewById5 = view.findViewById(R.id.tv_last_update_installed_app_item);
        t.d(findViewById5, "findViewById(...)");
        TextView textView4 = (TextView) findViewById5;
        this.f17795f = textView4;
        View findViewById6 = view.findViewById(R.id.tv_excluded_installed_app_item);
        t.d(findViewById6, "findViewById(...)");
        TextView textView5 = (TextView) findViewById6;
        this.f17796g = textView5;
        View findViewById7 = view.findViewById(R.id.rl_installed_app_item);
        t.d(findViewById7, "findViewById(...)");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById7;
        this.f17797h = relativeLayout;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        textView2.setTypeface(aVar.w());
        textView3.setTypeface(aVar.x());
        textView4.setTypeface(aVar.x());
        textView5.setTypeface(aVar.w());
        relativeLayout.setOnClickListener(new C2017g(this));
        imageView.setOnClickListener(new C2020h(this));
    }

    /* access modifiers changed from: private */
    public static final void c(C2023i iVar, View view) {
        int bindingAdapterPosition;
        if (iVar.f17790a != null && (bindingAdapterPosition = iVar.getBindingAdapterPosition()) != -1) {
            iVar.f17790a.a(bindingAdapterPosition);
        }
    }

    /* access modifiers changed from: private */
    public static final void d(C2023i iVar, View view) {
        int bindingAdapterPosition;
        if (iVar.f17790a != null && (bindingAdapterPosition = iVar.getBindingAdapterPosition()) != -1) {
            iVar.f17790a.b(bindingAdapterPosition);
        }
    }

    private final void f(C2655d dVar) {
        if (dVar.d()) {
            this.itemView.setAlpha(0.3f);
        } else {
            this.itemView.setAlpha(1.0f);
        }
    }

    public final void e(C2655d dVar) {
        String str;
        if (dVar != null) {
            f(dVar);
            C2940B.a aVar = C2940B.f26458v;
            Context context = this.itemView.getContext();
            t.d(context, "getContext(...)");
            C2940B a5 = aVar.a(context);
            a5.a();
            String o5 = dVar.o();
            t.b(o5);
            T G02 = a5.G0(o5);
            a5.m();
            P p5 = P.f26510a;
            Context context2 = this.itemView.getContext();
            t.d(context2, "getContext(...)");
            this.f17791b.setImageDrawable(p5.j(context2, dVar.o()));
            this.f17792c.setText(dVar.m());
            this.f17793d.setText(dVar.B());
            TextView textView = this.f17794e;
            C2291k kVar = new C2291k();
            long t5 = dVar.t();
            Context context3 = this.itemView.getContext();
            t.d(context3, "getContext(...)");
            textView.setText(kVar.d(t5, context3));
            this.f17795f.setText(new C2962v().n(dVar.j()));
            if (UptodownApp.f13477F.K()) {
                String n5 = new C2962v().n(dVar.j());
                C2954m mVar = new C2954m();
                Context context4 = this.itemView.getContext();
                t.d(context4, "getContext(...)");
                String o6 = dVar.o();
                t.b(o6);
                String h5 = mVar.h(context4, o6);
                if (h5 != null) {
                    n5 = new C2962v().n(dVar.j()) + " (" + h5 + ')';
                }
                this.f17795f.setText(n5);
            }
            C2257a i5 = k.f32g.i();
            if (i5 != null) {
                str = i5.b();
            } else {
                str = null;
            }
            if (s.E(str, dVar.o(), true)) {
                this.f17793d.setText(R.string.installing);
            }
            if (dVar.e() == 1) {
                this.f17796g.setText(this.itemView.getContext().getString(R.string.disabled_updates));
                this.f17796g.setVisibility(0);
            } else if (G02 == null || G02.e() != 1) {
                this.f17796g.setVisibility(8);
            } else {
                this.f17796g.setText(this.itemView.getContext().getString(R.string.skipped_update));
                this.f17796g.setVisibility(0);
            }
        }
    }
}
