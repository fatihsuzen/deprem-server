package C2;

import B2.v;
import D2.n;
import R1.L;
import S1.k;
import Y1.C2257a;
import Y1.C2259c;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import b2.C2291k;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import java.util.ArrayList;
import k2.J;
import kotlin.jvm.internal.t;
import l2.C2655d;
import l2.C2668q;
import l2.r;
import t3.s;
import z2.C2940B;
import z2.C2962v;
import z2.P;

/* renamed from: C2.x1  reason: case insensitive filesystem */
public final class C2069x1 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final J f17924a;

    /* renamed from: b  reason: collision with root package name */
    private final ImageView f17925b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f17926c;

    /* renamed from: d  reason: collision with root package name */
    private final ProgressBar f17927d;

    /* renamed from: e  reason: collision with root package name */
    private final TextView f17928e;

    /* renamed from: f  reason: collision with root package name */
    private final TextView f17929f;

    /* renamed from: g  reason: collision with root package name */
    private final TextView f17930g;

    /* renamed from: h  reason: collision with root package name */
    private final TextView f17931h;

    /* renamed from: i  reason: collision with root package name */
    private final TextView f17932i;

    /* renamed from: j  reason: collision with root package name */
    private final RelativeLayout f17933j;

    /* renamed from: k  reason: collision with root package name */
    private final TextView f17934k;

    /* renamed from: l  reason: collision with root package name */
    private final ImageView f17935l;

    /* renamed from: m  reason: collision with root package name */
    private final RelativeLayout f17936m;

    /* renamed from: n  reason: collision with root package name */
    private final TextView f17937n;

    /* renamed from: o  reason: collision with root package name */
    private final RelativeLayout f17938o;

    /* renamed from: p  reason: collision with root package name */
    private final RelativeLayout f17939p;

    /* renamed from: q  reason: collision with root package name */
    private final TextView f17940q;

    /* renamed from: r  reason: collision with root package name */
    private final ImageView f17941r;

    /* renamed from: s  reason: collision with root package name */
    private String f17942s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f17943t;

    /* renamed from: u  reason: collision with root package name */
    private Object f17944u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2069x1(View view, J j5) {
        super(view);
        t.e(view, "itemView");
        this.f17924a = j5;
        View findViewById = view.findViewById(R.id.iv_icon_update_item);
        t.d(findViewById, "findViewById(...)");
        ImageView imageView = (ImageView) findViewById;
        this.f17925b = imageView;
        View findViewById2 = view.findViewById(R.id.tv_name_update_item);
        t.d(findViewById2, "findViewById(...)");
        TextView textView = (TextView) findViewById2;
        this.f17926c = textView;
        View findViewById3 = view.findViewById(R.id.pb_progress_update_item);
        t.d(findViewById3, "findViewById(...)");
        this.f17927d = (ProgressBar) findViewById3;
        View findViewById4 = view.findViewById(R.id.tv_version_update_item);
        t.d(findViewById4, "findViewById(...)");
        TextView textView2 = (TextView) findViewById4;
        this.f17928e = textView2;
        View findViewById5 = view.findViewById(R.id.tv_size_update_item);
        t.d(findViewById5, "findViewById(...)");
        TextView textView3 = (TextView) findViewById5;
        this.f17929f = textView3;
        View findViewById6 = view.findViewById(R.id.tv_last_update_item);
        t.d(findViewById6, "findViewById(...)");
        TextView textView4 = (TextView) findViewById6;
        this.f17930g = textView4;
        View findViewById7 = view.findViewById(R.id.tv_verified_by_uptodown_update_item);
        t.d(findViewById7, "findViewById(...)");
        TextView textView5 = (TextView) findViewById7;
        this.f17931h = textView5;
        View findViewById8 = view.findViewById(R.id.tv_action_update_item);
        t.d(findViewById8, "findViewById(...)");
        TextView textView6 = (TextView) findViewById8;
        this.f17932i = textView6;
        View findViewById9 = view.findViewById(R.id.rl_actions_update_item);
        t.d(findViewById9, "findViewById(...)");
        this.f17933j = (RelativeLayout) findViewById9;
        View findViewById10 = view.findViewById(R.id.tv_excluded_update_item);
        t.d(findViewById10, "findViewById(...)");
        TextView textView7 = (TextView) findViewById10;
        this.f17934k = textView7;
        View findViewById11 = view.findViewById(R.id.iv_version_details_update_item);
        t.d(findViewById11, "findViewById(...)");
        this.f17935l = (ImageView) findViewById11;
        View findViewById12 = view.findViewById(R.id.rl_version_details_update_item);
        t.d(findViewById12, "findViewById(...)");
        this.f17936m = (RelativeLayout) findViewById12;
        View findViewById13 = view.findViewById(R.id.tv_version_details_update_item);
        t.d(findViewById13, "findViewById(...)");
        TextView textView8 = (TextView) findViewById13;
        this.f17937n = textView8;
        View findViewById14 = view.findViewById(R.id.rl_container_update_item);
        t.d(findViewById14, "findViewById(...)");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById14;
        this.f17938o = relativeLayout;
        View findViewById15 = view.findViewById(R.id.rl_cancel_update_item);
        t.d(findViewById15, "findViewById(...)");
        this.f17939p = (RelativeLayout) findViewById15;
        View findViewById16 = view.findViewById(R.id.tv_pending_update_item);
        t.d(findViewById16, "findViewById(...)");
        TextView textView9 = (TextView) findViewById16;
        this.f17940q = textView9;
        View findViewById17 = view.findViewById(R.id.iv_cancel_update_item);
        t.d(findViewById17, "findViewById(...)");
        ImageView imageView2 = (ImageView) findViewById17;
        this.f17941r = imageView2;
        relativeLayout.setOnClickListener(new C2049q1(this));
        imageView.setOnClickListener(new C2051r1(this));
        textView6.setOnClickListener(new C2054s1(this));
        imageView2.setOnClickListener(new C2057t1(this));
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        textView2.setTypeface(aVar.w());
        textView3.setTypeface(aVar.x());
        textView5.setTypeface(aVar.x());
        textView9.setTypeface(aVar.w());
        textView8.setTypeface(aVar.x());
        textView7.setTypeface(aVar.w());
        textView6.setTypeface(aVar.w());
        textView4.setTypeface(aVar.x());
    }

    private final void A(int i5) {
        this.f17928e.setVisibility(0);
        this.f17933j.setVisibility(0);
        this.f17939p.setVisibility(0);
        this.f17940q.setVisibility(0);
        this.f17940q.setText(this.itemView.getContext().getString(R.string.unzipping_status, new Object[]{Integer.valueOf(i5)}));
        this.f17941r.setVisibility(0);
        this.f17941r.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_cross_disabled));
        this.f17941r.setClickable(false);
        this.f17931h.setVisibility(0);
        this.f17930g.setVisibility(8);
        this.f17929f.setVisibility(8);
        this.f17931h.setVisibility(0);
        if (this.f17927d.isIndeterminate()) {
            this.f17927d.setIndeterminate(false);
        }
        this.f17927d.setProgress(i5);
    }

    private final void B() {
        this.f17932i.setText(this.itemView.getContext().getString(R.string.updates_button_update_app));
        v.b(this.f17932i);
        this.f17932i.setVisibility(0);
        this.f17931h.setVisibility(8);
        this.f17930g.setVisibility(0);
    }

    private final void C(ProgressBar progressBar, ImageView imageView, L.a aVar) {
        if (t.a(this.f17942s, aVar.a().o())) {
            if (!aVar.d() && !aVar.e()) {
                progressBar.setVisibility(0);
                aVar.h(true);
                this.f17943t = true;
                Context context = this.itemView.getContext();
                t.d(context, "getContext(...)");
                new n(context).l(imageView, new C2063v1(this, aVar));
                this.f17944u = W2.J.f19942a;
            } else if (aVar.d() && progressBar.getVisibility() != 0) {
                imageView.setScaleX(0.6f);
                imageView.setScaleY(0.6f);
                progressBar.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final W2.J D(C2069x1 x1Var, L.a aVar) {
        if (t.a(x1Var.f17942s, aVar.a().o())) {
            aVar.h(false);
            aVar.g(true);
        }
        x1Var.f17943t = false;
        x1Var.f17944u = null;
        return W2.J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final void h(C2069x1 x1Var, View view) {
        int bindingAdapterPosition;
        if (x1Var.f17924a != null && (bindingAdapterPosition = x1Var.getBindingAdapterPosition()) != -1) {
            x1Var.f17924a.a(bindingAdapterPosition);
        }
    }

    /* access modifiers changed from: private */
    public static final void i(C2069x1 x1Var, View view) {
        int bindingAdapterPosition;
        if (x1Var.f17924a != null && (bindingAdapterPosition = x1Var.getBindingAdapterPosition()) != -1) {
            x1Var.f17924a.b(bindingAdapterPosition);
        }
    }

    /* access modifiers changed from: private */
    public static final void j(C2069x1 x1Var, View view) {
        J j5 = x1Var.f17924a;
        if (j5 != null) {
            j5.d(x1Var.getBindingAdapterPosition());
        }
    }

    /* access modifiers changed from: private */
    public static final void k(C2069x1 x1Var, View view) {
        J j5 = x1Var.f17924a;
        if (j5 != null) {
            j5.e(x1Var.getBindingAdapterPosition());
        }
    }

    private final void l(L.a aVar, boolean z4, boolean z5) {
        C2668q qVar;
        String str;
        String a5;
        String o5 = aVar.a().o();
        if (!t.a(this.f17942s, o5)) {
            o();
        }
        this.f17942s = o5;
        v();
        p(aVar.a());
        P p5 = P.f26510a;
        Context context = this.itemView.getContext();
        t.d(context, "getContext(...)");
        this.f17925b.setImageDrawable(p5.j(context, aVar.a().o()));
        this.f17926c.setText(aVar.a().m());
        TextView textView = this.f17929f;
        C2291k kVar = new C2291k();
        long t5 = aVar.a().t();
        Context context2 = this.itemView.getContext();
        t.d(context2, "getContext(...)");
        textView.setText(kVar.d(t5, context2));
        this.f17930g.setText(new C2962v().n(aVar.a().j()));
        C2940B.a aVar2 = C2940B.f26458v;
        Context context3 = this.itemView.getContext();
        t.d(context3, "getContext(...)");
        C2940B a6 = aVar2.a(context3);
        a6.a();
        String str2 = null;
        if (aVar.b().a() != null) {
            C2668q a7 = aVar.b().a();
            t.b(a7);
            qVar = a6.i0(a7.q());
        } else {
            qVar = null;
        }
        a6.m();
        if (qVar == null || qVar.o().size() != 1 || !qVar.f() || (a5 = ((r) qVar.o().get(0)).a()) == null || !s.D(a5, ".xapk", false, 2, (Object) null)) {
            str = null;
        } else {
            str = ((r) qVar.o().get(0)).a();
        }
        this.f17928e.setText(aVar.b().k());
        if (!aVar.b().m()) {
            k.a aVar3 = k.f32g;
            C2257a i5 = aVar3.i();
            if (i5 != null) {
                str2 = i5.b();
            }
            if (s.E(str2, aVar.a().o(), true) || z4) {
                z();
                C(this.f17927d, this.f17925b, aVar);
            } else {
                if (aVar3.j() != null) {
                    C2259c j5 = aVar3.j();
                    t.b(j5);
                    if (s.E(str, j5.a(), true)) {
                        C2259c j6 = aVar3.j();
                        t.b(j6);
                        A(j6.b());
                        C(this.f17927d, this.f17925b, aVar);
                    }
                }
                if (aVar.b().c()) {
                    if (qVar != null) {
                        TextView textView2 = this.f17928e;
                        Context context4 = this.itemView.getContext();
                        Integer valueOf = Integer.valueOf(qVar.x());
                        C2291k kVar2 = new C2291k();
                        long z6 = qVar.z();
                        Context context5 = this.itemView.getContext();
                        t.d(context5, "getContext(...)");
                        textView2.setText(context4.getString(R.string.percent_of_total_size, new Object[]{valueOf, kVar2.d(z6, context5)}));
                    }
                    w();
                    C(this.f17927d, this.f17925b, aVar);
                } else {
                    UptodownApp.a aVar4 = UptodownApp.f13477F;
                    String o6 = aVar.a().o();
                    t.b(o6);
                    if (aVar4.O(o6)) {
                        u();
                        r(this.f17927d, this.f17925b, aVar);
                    } else if (z5) {
                        u();
                        r(this.f17927d, this.f17925b, aVar);
                    } else {
                        B();
                        r(this.f17927d, this.f17925b, aVar);
                    }
                }
                if (qVar != null) {
                    this.f17927d.setProgress(qVar.x());
                }
            }
        } else if (aVar.b().e() == 1) {
            String string = this.itemView.getContext().getString(R.string.skipped_update);
            t.d(string, "getString(...)");
            y(string);
        } else {
            x();
        }
        String f5 = aVar.b().f();
        if (f5 == null || f5.length() == 0) {
            this.f17937n.setVisibility(8);
            this.f17936m.setVisibility(8);
            this.f17935l.setVisibility(8);
        } else {
            this.f17936m.setVisibility(0);
            this.f17935l.setVisibility(0);
            if (aVar.a().s()) {
                this.f17937n.setText(aVar.b().f());
                t();
            } else {
                q();
            }
        }
        this.f17935l.setOnClickListener(new C2060u1(aVar, this));
    }

    /* access modifiers changed from: private */
    public static final void m(L.a aVar, C2069x1 x1Var, View view) {
        if (!UptodownApp.f13477F.Z()) {
            return;
        }
        if (!aVar.a().s()) {
            J j5 = x1Var.f17924a;
            if (j5 != null) {
                j5.c(x1Var.getBindingAdapterPosition());
                return;
            }
            return;
        }
        J j6 = x1Var.f17924a;
        if (j6 != null) {
            j6.f(x1Var.getBindingAdapterPosition());
        }
    }

    private final void o() {
        this.f17925b.clearAnimation();
        this.f17927d.clearAnimation();
        this.f17944u = null;
        this.f17943t = false;
        this.f17927d.setVisibility(8);
        this.f17925b.setAlpha(1.0f);
        this.f17925b.setScaleX(1.0f);
        this.f17925b.setScaleY(1.0f);
    }

    private final void p(C2655d dVar) {
        if (dVar.d()) {
            this.itemView.setAlpha(0.3f);
        } else {
            this.itemView.setAlpha(1.0f);
        }
    }

    private final void q() {
        this.f17937n.setVisibility(8);
        this.f17936m.setVisibility(8);
        this.f17935l.setScaleY(1.0f);
        this.f17935l.setContentDescription(this.itemView.getContext().getString(R.string.cd_expand_version_details));
    }

    private final void r(ProgressBar progressBar, ImageView imageView, L.a aVar) {
        String str;
        C2259c j5;
        String a5;
        C2668q qVar;
        ArrayList o5;
        String a6;
        if (!t.a(this.f17942s, aVar.a().o())) {
            progressBar.setVisibility(8);
            return;
        }
        boolean c5 = aVar.b().c();
        k.a aVar2 = k.f32g;
        C2257a i5 = aVar2.i();
        if (i5 != null) {
            str = i5.b();
        } else {
            str = null;
        }
        boolean E4 = s.E(str, aVar.a().o(), true);
        boolean z4 = false;
        if (aVar2.j() != null) {
            C2259c j6 = aVar2.j();
            t.b(j6);
            if (!(j6.a() == null || (j5 = aVar2.j()) == null || (a5 = j5.a()) == null)) {
                C2940B.a aVar3 = C2940B.f26458v;
                Context context = this.itemView.getContext();
                t.d(context, "getContext(...)");
                C2940B a7 = aVar3.a(context);
                a7.a();
                C2668q a8 = aVar.b().a();
                if (a8 != null) {
                    qVar = a7.i0(a8.q());
                } else {
                    qVar = null;
                }
                a7.m();
                if (qVar != null && (o5 = qVar.o()) != null && o5.size() == 1 && qVar.f() && (a6 = ((r) qVar.o().get(0)).a()) != null && s.D(a6, ".xapk", false, 2, (Object) null) && s.E(a5, ((r) qVar.o().get(0)).a(), true)) {
                    z4 = true;
                }
            }
        }
        if (!c5 && !E4 && !z4) {
            if (progressBar.getVisibility() == 0 && !aVar.c() && aVar.d()) {
                aVar.f(true);
                this.f17943t = true;
                Context context2 = this.itemView.getContext();
                t.d(context2, "getContext(...)");
                new n(context2).j(imageView, new C2066w1(this, aVar, progressBar));
                this.f17944u = W2.J.f19942a;
            } else if (!aVar.d() && progressBar.getVisibility() == 0) {
                progressBar.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final W2.J s(C2069x1 x1Var, L.a aVar, ProgressBar progressBar) {
        if (t.a(x1Var.f17942s, aVar.a().o())) {
            progressBar.setVisibility(8);
            aVar.f(false);
            aVar.g(false);
        }
        x1Var.f17943t = false;
        x1Var.f17944u = null;
        return W2.J.f19942a;
    }

    private final void t() {
        this.f17936m.setVisibility(0);
        this.f17937n.setVisibility(0);
        this.f17935l.setScaleY(-1.0f);
        this.f17935l.setContentDescription(this.itemView.getContext().getString(R.string.cd_collapse_version_details));
    }

    private final void u() {
        this.f17940q.setVisibility(0);
        this.f17940q.setText(this.itemView.getContext().getString(R.string.notification_line_downloading));
        this.f17939p.setVisibility(0);
    }

    private final void v() {
        this.f17932i.setVisibility(8);
        this.f17933j.setVisibility(0);
        if (!this.f17927d.isIndeterminate()) {
            this.f17927d.setIndeterminate(true);
        }
        this.f17941r.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.core_vector_cross));
        this.f17941r.setClickable(true);
        this.f17934k.setVisibility(8);
        this.f17939p.setVisibility(8);
        this.f17929f.setVisibility(0);
        this.f17940q.setVisibility(8);
    }

    private final void w() {
        this.f17939p.setVisibility(0);
        this.f17928e.setVisibility(0);
        this.f17934k.setVisibility(8);
        this.f17931h.setVisibility(0);
        this.f17930g.setVisibility(8);
        this.f17929f.setVisibility(8);
        if (this.f17927d.isIndeterminate()) {
            this.f17927d.setIndeterminate(false);
        }
    }

    private final void x() {
        this.f17934k.setVisibility(8);
        this.f17931h.setVisibility(8);
        this.f17929f.setVisibility(8);
        this.f17933j.setVisibility(8);
    }

    private final void y(String str) {
        this.f17934k.setText(str);
        this.f17934k.setVisibility(0);
        this.f17931h.setVisibility(8);
        this.f17930g.setVisibility(0);
        this.f17933j.setVisibility(8);
    }

    private final void z() {
        this.f17928e.setVisibility(0);
        this.f17933j.setVisibility(0);
        this.f17939p.setVisibility(0);
        this.f17941r.setVisibility(0);
        this.f17941r.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_cross_disabled));
        this.f17941r.setClickable(false);
        this.f17940q.setVisibility(0);
        this.f17940q.setText(this.itemView.getContext().getString(R.string.installing));
        this.f17931h.setVisibility(0);
        this.f17930g.setVisibility(8);
        this.f17929f.setVisibility(8);
    }

    public final void n(L.a aVar, boolean z4, boolean z5) {
        t.e(aVar, "appUpdateData");
        l(aVar, z4, z5);
    }
}
