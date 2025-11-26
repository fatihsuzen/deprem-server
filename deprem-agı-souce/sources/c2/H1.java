package C2;

import B2.s;
import D2.n;
import S1.k;
import android.content.Context;
import android.text.Spanned;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import k2.M;
import kotlin.jvm.internal.t;
import l2.O;
import l2.V;

public final class H1 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final M f17494a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f17495b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f17496c;

    /* renamed from: d  reason: collision with root package name */
    private final ImageView f17497d;

    /* renamed from: e  reason: collision with root package name */
    private final TextView f17498e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final TextView f17499f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final TextView f17500g;

    /* renamed from: h  reason: collision with root package name */
    private final TextView f17501h;

    /* renamed from: i  reason: collision with root package name */
    private final LinearLayout f17502i;

    /* renamed from: j  reason: collision with root package name */
    private final LinearLayout f17503j;

    /* renamed from: k  reason: collision with root package name */
    private final TextView f17504k;

    /* renamed from: l  reason: collision with root package name */
    private final ImageView f17505l;

    /* renamed from: m  reason: collision with root package name */
    private final ImageView f17506m;

    /* renamed from: n  reason: collision with root package name */
    private final ImageView f17507n;

    /* renamed from: o  reason: collision with root package name */
    private final ImageView f17508o;

    /* renamed from: p  reason: collision with root package name */
    private final ImageView f17509p;

    /* renamed from: q  reason: collision with root package name */
    private final ImageView f17510q;

    /* renamed from: r  reason: collision with root package name */
    private final ImageView f17511r;

    public static final class a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ H1 f17512a;

        a(H1 h12) {
            this.f17512a = h12;
        }

        public boolean onPreDraw() {
            this.f17512a.f17499f.getViewTreeObserver().removeOnPreDrawListener(this);
            if (!s.a(this.f17512a.f17499f)) {
                return true;
            }
            this.f17512a.f17500g.setVisibility(0);
            this.f17512a.f17500g.setTypeface(k.f32g.w());
            return true;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public H1(View view, M m5, Context context) {
        super(view);
        t.e(view, "itemView");
        t.e(m5, "listener");
        t.e(context, "context");
        this.f17494a = m5;
        this.f17495b = context;
        View findViewById = view.findViewById(R.id.tv_username_review);
        t.d(findViewById, "findViewById(...)");
        TextView textView = (TextView) findViewById;
        this.f17496c = textView;
        View findViewById2 = view.findViewById(R.id.iv_avatar_review);
        t.d(findViewById2, "findViewById(...)");
        this.f17497d = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(R.id.tv_date_review);
        t.d(findViewById3, "findViewById(...)");
        TextView textView2 = (TextView) findViewById3;
        this.f17498e = textView2;
        View findViewById4 = view.findViewById(R.id.tv_body_review);
        t.d(findViewById4, "findViewById(...)");
        TextView textView3 = (TextView) findViewById4;
        this.f17499f = textView3;
        View findViewById5 = view.findViewById(R.id.tv_show_more_review);
        t.d(findViewById5, "findViewById(...)");
        this.f17500g = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.tv_likes_counter_review);
        t.d(findViewById6, "findViewById(...)");
        TextView textView4 = (TextView) findViewById6;
        this.f17501h = textView4;
        View findViewById7 = view.findViewById(R.id.ll_likes_review);
        t.d(findViewById7, "findViewById(...)");
        this.f17502i = (LinearLayout) findViewById7;
        View findViewById8 = view.findViewById(R.id.ll_reviews_counter_review);
        t.d(findViewById8, "findViewById(...)");
        this.f17503j = (LinearLayout) findViewById8;
        View findViewById9 = view.findViewById(R.id.tv_reviews_counter_review);
        t.d(findViewById9, "findViewById(...)");
        TextView textView5 = (TextView) findViewById9;
        this.f17504k = textView5;
        View findViewById10 = view.findViewById(R.id.iv_likes_counter_review);
        t.d(findViewById10, "findViewById(...)");
        this.f17505l = (ImageView) findViewById10;
        View findViewById11 = view.findViewById(R.id.iv_star1_review);
        t.d(findViewById11, "findViewById(...)");
        this.f17506m = (ImageView) findViewById11;
        View findViewById12 = view.findViewById(R.id.iv_star2_review);
        t.d(findViewById12, "findViewById(...)");
        this.f17507n = (ImageView) findViewById12;
        View findViewById13 = view.findViewById(R.id.iv_star3_review);
        t.d(findViewById13, "findViewById(...)");
        this.f17508o = (ImageView) findViewById13;
        View findViewById14 = view.findViewById(R.id.iv_star4_review);
        t.d(findViewById14, "findViewById(...)");
        this.f17509p = (ImageView) findViewById14;
        View findViewById15 = view.findViewById(R.id.iv_star5_review);
        t.d(findViewById15, "findViewById(...)");
        this.f17510q = (ImageView) findViewById15;
        View findViewById16 = view.findViewById(R.id.iv_follow_user_review);
        t.d(findViewById16, "findViewById(...)");
        ImageView imageView = (ImageView) findViewById16;
        this.f17511r = imageView;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        textView2.setTypeface(aVar.x());
        textView3.setTypeface(aVar.x());
        textView4.setTypeface(aVar.x());
        textView5.setTypeface(aVar.x());
        imageView.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public static final void i(H1 h12, int i5, View view) {
        h12.f17494a.c(i5);
    }

    /* access modifiers changed from: private */
    public static final void j(H1 h12, int i5, View view) {
        h12.f17494a.c(i5);
    }

    /* access modifiers changed from: private */
    public static final void k(H1 h12, O o5, int i5, View view) {
        new n(h12.f17495b).n(h12.f17505l);
        if (!O.f24814p.d(o5.g())) {
            h12.f17494a.b(i5);
            h12.f17501h.setText(String.valueOf(o5.h() + 1));
        }
    }

    /* access modifiers changed from: private */
    public static final void l(H1 h12, int i5, View view) {
        h12.f17494a.a(i5);
    }

    /* access modifiers changed from: private */
    public static final void m(H1 h12, View view) {
        if (h12.f17499f.getMaxLines() == Integer.MAX_VALUE) {
            h12.f17499f.setMaxLines(4);
            h12.f17500g.setText(h12.f17495b.getString(R.string.read_more_desc_app_detail));
            return;
        }
        h12.f17499f.setMaxLines(Integer.MAX_VALUE);
        h12.f17500g.setText(h12.f17495b.getString(R.string.read_less_desc_app_detail));
    }

    public final void h(O o5, int i5) {
        CharSequence charSequence;
        t.e(o5, "item");
        String c5 = o5.c();
        if (!(c5 == null || c5.length() == 0)) {
            this.f17496c.setText(o5.c());
        }
        V.b bVar = V.f24870q;
        if (bVar.d(o5.e()) != null) {
            com.squareup.picasso.s.h().l(bVar.d(o5.e())).n(UptodownApp.f13477F.g0(this.f17495b)).i(this.f17497d);
        } else {
            com.squareup.picasso.s.h().j(R.drawable.vector_user_default).n(UptodownApp.f13477F.g0(this.f17495b)).i(this.f17497d);
        }
        if (o5.l() != null) {
            this.f17498e.setText(o5.l());
        }
        Spanned k5 = o5.k();
        if (k5 == null || k5.length() == 0) {
            this.f17499f.setVisibility(8);
            this.f17502i.setVisibility(8);
            this.f17503j.setVisibility(8);
        } else {
            this.f17499f.setText(o5.k());
            this.f17499f.setVisibility(0);
            this.f17502i.setVisibility(0);
            this.f17503j.setVisibility(0);
        }
        this.f17501h.setText(String.valueOf(o5.h()));
        if (O.f24814p.d(o5.g())) {
            this.f17505l.setImageDrawable(ContextCompat.getDrawable(this.f17495b, R.drawable.vector_heart_red));
        } else {
            this.f17505l.setImageDrawable(ContextCompat.getDrawable(this.f17495b, R.drawable.vector_heart));
        }
        if (o5.a() == 0) {
            this.f17504k.setText(this.f17495b.getString(R.string.reply));
        } else {
            this.f17504k.setText(String.valueOf(o5.a()));
        }
        this.f17496c.setOnClickListener(new C1(this, i5));
        this.f17497d.setOnClickListener(new D1(this, i5));
        this.f17502i.setOnClickListener(new E1(this, o5, i5));
        this.f17503j.setOnClickListener(new F1(this, i5));
        TextView textView = this.f17499f;
        Spanned k6 = o5.k();
        if (k6 != null) {
            charSequence = t3.s.W0(k6);
        } else {
            charSequence = null;
        }
        textView.setText(charSequence);
        this.f17499f.getViewTreeObserver().addOnPreDrawListener(new a(this));
        this.f17500g.setOnClickListener(new G1(this));
        this.f17506m.setImageDrawable(ContextCompat.getDrawable(this.f17495b, R.drawable.vector_star_on));
        this.f17507n.setImageDrawable(ContextCompat.getDrawable(this.f17495b, R.drawable.vector_star_off));
        this.f17508o.setImageDrawable(ContextCompat.getDrawable(this.f17495b, R.drawable.vector_star_off));
        this.f17509p.setImageDrawable(ContextCompat.getDrawable(this.f17495b, R.drawable.vector_star_off));
        this.f17510q.setImageDrawable(ContextCompat.getDrawable(this.f17495b, R.drawable.vector_star_off));
        if (o5.i() >= 2) {
            this.f17507n.setImageDrawable(ContextCompat.getDrawable(this.f17495b, R.drawable.vector_star_on));
        }
        if (o5.i() >= 3) {
            this.f17508o.setImageDrawable(ContextCompat.getDrawable(this.f17495b, R.drawable.vector_star_on));
        }
        if (o5.i() >= 4) {
            this.f17509p.setImageDrawable(ContextCompat.getDrawable(this.f17495b, R.drawable.vector_star_on));
        }
        if (o5.i() == 5) {
            this.f17510q.setImageDrawable(ContextCompat.getDrawable(this.f17495b, R.drawable.vector_star_on));
        }
    }
}
