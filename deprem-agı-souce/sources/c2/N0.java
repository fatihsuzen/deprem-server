package C2;

import D2.n;
import S1.k;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import com.uptodown.util.views.UsernameTextView;
import k2.C2589F;
import kotlin.jvm.internal.t;
import l2.O;
import z2.C2962v;

public final class N0 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final Context f17544a;

    /* renamed from: b  reason: collision with root package name */
    private final C2589F f17545b;

    /* renamed from: c  reason: collision with root package name */
    private final ImageView f17546c;

    /* renamed from: d  reason: collision with root package name */
    private final UsernameTextView f17547d;

    /* renamed from: e  reason: collision with root package name */
    private final ImageView f17548e;

    /* renamed from: f  reason: collision with root package name */
    private final TextView f17549f;

    /* renamed from: g  reason: collision with root package name */
    private final TextView f17550g;

    /* renamed from: h  reason: collision with root package name */
    private final TextView f17551h;

    /* renamed from: i  reason: collision with root package name */
    private final TextView f17552i;

    /* renamed from: j  reason: collision with root package name */
    private final ImageView f17553j;

    /* renamed from: k  reason: collision with root package name */
    private final LinearLayout f17554k;

    /* renamed from: l  reason: collision with root package name */
    private final LinearLayout f17555l;

    /* renamed from: m  reason: collision with root package name */
    private final ImageView f17556m;

    /* renamed from: n  reason: collision with root package name */
    private final ImageView f17557n;

    /* renamed from: o  reason: collision with root package name */
    private final ImageView f17558o;

    /* renamed from: p  reason: collision with root package name */
    private final ImageView f17559p;

    /* renamed from: q  reason: collision with root package name */
    private final ImageView f17560q;

    /* renamed from: r  reason: collision with root package name */
    private final ImageView f17561r;

    /* renamed from: s  reason: collision with root package name */
    private final ImageView f17562s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public N0(View view, Context context, C2589F f5) {
        super(view);
        t.e(view, "itemView");
        t.e(context, "context");
        t.e(f5, "listener");
        this.f17544a = context;
        this.f17545b = f5;
        View findViewById = view.findViewById(R.id.iv_avatar_review);
        t.d(findViewById, "findViewById(...)");
        this.f17546c = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_username_review);
        t.d(findViewById2, "findViewById(...)");
        UsernameTextView usernameTextView = (UsernameTextView) findViewById2;
        this.f17547d = usernameTextView;
        View findViewById3 = view.findViewById(R.id.iv_author_verified_review);
        t.d(findViewById3, "findViewById(...)");
        this.f17548e = (ImageView) findViewById3;
        View findViewById4 = view.findViewById(R.id.tv_date_review);
        t.d(findViewById4, "findViewById(...)");
        TextView textView = (TextView) findViewById4;
        this.f17549f = textView;
        View findViewById5 = view.findViewById(R.id.tv_body_review);
        t.d(findViewById5, "findViewById(...)");
        TextView textView2 = (TextView) findViewById5;
        this.f17550g = textView2;
        View findViewById6 = view.findViewById(R.id.tv_reviews_counter_review);
        t.d(findViewById6, "findViewById(...)");
        TextView textView3 = (TextView) findViewById6;
        this.f17551h = textView3;
        View findViewById7 = view.findViewById(R.id.tv_likes_counter_review);
        t.d(findViewById7, "findViewById(...)");
        TextView textView4 = (TextView) findViewById7;
        this.f17552i = textView4;
        View findViewById8 = view.findViewById(R.id.iv_likes_counter_review);
        t.d(findViewById8, "findViewById(...)");
        this.f17553j = (ImageView) findViewById8;
        View findViewById9 = view.findViewById(R.id.ll_reviews_counter_review);
        t.d(findViewById9, "findViewById(...)");
        this.f17554k = (LinearLayout) findViewById9;
        View findViewById10 = view.findViewById(R.id.ll_likes_review);
        t.d(findViewById10, "findViewById(...)");
        this.f17555l = (LinearLayout) findViewById10;
        View findViewById11 = view.findViewById(R.id.iv_star1_review);
        t.d(findViewById11, "findViewById(...)");
        this.f17556m = (ImageView) findViewById11;
        View findViewById12 = view.findViewById(R.id.iv_star2_review);
        t.d(findViewById12, "findViewById(...)");
        this.f17557n = (ImageView) findViewById12;
        View findViewById13 = view.findViewById(R.id.iv_star3_review);
        t.d(findViewById13, "findViewById(...)");
        this.f17558o = (ImageView) findViewById13;
        View findViewById14 = view.findViewById(R.id.iv_star4_review);
        t.d(findViewById14, "findViewById(...)");
        this.f17559p = (ImageView) findViewById14;
        View findViewById15 = view.findViewById(R.id.iv_star5_review);
        t.d(findViewById15, "findViewById(...)");
        this.f17560q = (ImageView) findViewById15;
        View findViewById16 = view.findViewById(R.id.iv_turbo_mark_review);
        t.d(findViewById16, "findViewById(...)");
        ImageView imageView = (ImageView) findViewById16;
        this.f17561r = imageView;
        View findViewById17 = view.findViewById(R.id.iv_follow_user_review);
        t.d(findViewById17, "findViewById(...)");
        this.f17562s = (ImageView) findViewById17;
        k.a aVar = k.f32g;
        usernameTextView.setTypeface(aVar.w());
        textView.setTypeface(aVar.x());
        textView2.setTypeface(aVar.x());
        textView3.setTypeface(aVar.x());
        textView4.setTypeface(aVar.x());
        imageView.setVisibility(8);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0056  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void i(l2.O r7, int r8) {
        /*
            r6 = this;
            java.lang.String r0 = r7.n()
            if (r0 == 0) goto L_0x0034
            l2.V$b r0 = l2.V.f24870q
            java.lang.String r1 = r7.e()
            java.lang.String r1 = r0.d(r1)
            if (r1 == 0) goto L_0x0034
            com.squareup.picasso.s r1 = com.squareup.picasso.s.h()
            java.lang.String r2 = r7.e()
            java.lang.String r0 = r0.d(r2)
            com.squareup.picasso.w r0 = r1.l(r0)
            com.uptodown.UptodownApp$a r1 = com.uptodown.UptodownApp.f13477F
            android.content.Context r2 = r6.f17544a
            D2.h r1 = r1.g0(r2)
            com.squareup.picasso.w r0 = r0.n(r1)
            android.widget.ImageView r1 = r6.f17546c
            r0.i(r1)
            goto L_0x0050
        L_0x0034:
            com.squareup.picasso.s r0 = com.squareup.picasso.s.h()
            r1 = 2131231605(0x7f080375, float:1.8079296E38)
            com.squareup.picasso.w r0 = r0.j(r1)
            com.uptodown.UptodownApp$a r1 = com.uptodown.UptodownApp.f13477F
            android.content.Context r2 = r6.f17544a
            D2.h r1 = r1.i0(r2)
            com.squareup.picasso.w r0 = r0.n(r1)
            android.widget.ImageView r1 = r6.f17546c
            r0.i(r1)
        L_0x0050:
            java.lang.String r0 = r7.n()
            if (r0 == 0) goto L_0x006e
            com.uptodown.util.views.UsernameTextView r0 = r6.f17547d
            java.lang.String r1 = r7.n()
            r0.setText(r1)
            com.uptodown.util.views.UsernameTextView$a r0 = com.uptodown.util.views.UsernameTextView.f21329k
            com.uptodown.util.views.UsernameTextView r1 = r6.f17547d
            boolean r2 = r7.p()
            java.lang.String r3 = r7.o()
            r0.a(r1, r2, r3)
        L_0x006e:
            com.uptodown.util.views.UsernameTextView r0 = r6.f17547d
            C2.H0 r1 = new C2.H0
            r1.<init>(r6, r8)
            r0.setOnClickListener(r1)
            android.widget.ImageView r0 = r6.f17546c
            C2.I0 r1 = new C2.I0
            r1.<init>(r6, r8)
            r0.setOnClickListener(r1)
            l2.O$b r0 = l2.O.f24814p
            long r1 = r7.g()
            boolean r0 = r0.d(r1)
            if (r0 == 0) goto L_0x009d
            android.widget.ImageView r0 = r6.f17553j
            android.content.Context r1 = r6.f17544a
            r2 = 2131231451(0x7f0802db, float:1.8078983E38)
            android.graphics.drawable.Drawable r1 = androidx.core.content.ContextCompat.getDrawable(r1, r2)
            r0.setImageDrawable(r1)
            goto L_0x00ab
        L_0x009d:
            android.widget.ImageView r0 = r6.f17553j
            android.content.Context r1 = r6.f17544a
            r2 = 2131231449(0x7f0802d9, float:1.807898E38)
            android.graphics.drawable.Drawable r1 = androidx.core.content.ContextCompat.getDrawable(r1, r2)
            r0.setImageDrawable(r1)
        L_0x00ab:
            java.lang.String r0 = r7.n()
            r1 = 1
            r2 = 0
            r3 = 8
            if (r0 == 0) goto L_0x00c1
            int r0 = r7.d()
            if (r0 != r1) goto L_0x00c1
            android.widget.ImageView r0 = r6.f17548e
            r0.setVisibility(r2)
            goto L_0x00c6
        L_0x00c1:
            android.widget.ImageView r0 = r6.f17548e
            r0.setVisibility(r3)
        L_0x00c6:
            java.lang.String r0 = r7.l()
            if (r0 == 0) goto L_0x00d5
            android.widget.TextView r0 = r6.f17549f
            java.lang.String r4 = r7.l()
            r0.setText(r4)
        L_0x00d5:
            l2.V$b r0 = l2.V.f24870q
            android.content.Context r4 = r6.f17544a
            l2.V r0 = r0.h(r4)
            r4 = 0
            if (r0 == 0) goto L_0x00e5
            java.lang.String r0 = r0.j()
            goto L_0x00e6
        L_0x00e5:
            r0 = r4
        L_0x00e6:
            java.lang.String r5 = r7.m()
            boolean r0 = kotlin.jvm.internal.t.a(r0, r5)
            if (r0 != 0) goto L_0x011e
            int r0 = r7.f()
            if (r0 != r1) goto L_0x0105
            android.widget.ImageView r0 = r6.f17562s
            android.content.Context r1 = r6.f17544a
            r5 = 2131231448(0x7f0802d8, float:1.8078977E38)
            android.graphics.drawable.Drawable r1 = androidx.core.content.ContextCompat.getDrawable(r1, r5)
            r0.setImageDrawable(r1)
            goto L_0x0113
        L_0x0105:
            android.widget.ImageView r0 = r6.f17562s
            android.content.Context r1 = r6.f17544a
            r5 = 2131231447(0x7f0802d7, float:1.8078975E38)
            android.graphics.drawable.Drawable r1 = androidx.core.content.ContextCompat.getDrawable(r1, r5)
            r0.setImageDrawable(r1)
        L_0x0113:
            android.widget.ImageView r0 = r6.f17562s
            C2.J0 r1 = new C2.J0
            r1.<init>(r6, r8)
            r0.setOnClickListener(r1)
            goto L_0x0123
        L_0x011e:
            android.widget.ImageView r0 = r6.f17562s
            r0.setVisibility(r3)
        L_0x0123:
            android.text.Spanned r0 = r7.k()
            if (r0 == 0) goto L_0x01a7
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0130
            goto L_0x01a7
        L_0x0130:
            android.widget.TextView r0 = r6.f17550g
            r1 = 2147483647(0x7fffffff, float:NaN)
            r0.setMaxLines(r1)
            android.widget.TextView r0 = r6.f17550g
            android.text.Spanned r1 = r7.k()
            if (r1 == 0) goto L_0x0144
            java.lang.CharSequence r4 = t3.s.W0(r1)
        L_0x0144:
            r0.setText(r4)
            android.widget.TextView r0 = r6.f17550g
            r0.setVisibility(r2)
            android.widget.LinearLayout r0 = r6.f17554k
            r0.setVisibility(r2)
            android.widget.LinearLayout r0 = r6.f17555l
            r0.setVisibility(r2)
            android.widget.LinearLayout r0 = r6.f17554k
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)
            r0.setTag(r1)
            android.widget.LinearLayout r0 = r6.f17554k
            C2.K0 r1 = new C2.K0
            r1.<init>(r6)
            r0.setOnClickListener(r1)
            int r0 = r7.a()
            if (r0 <= 0) goto L_0x017c
            android.widget.TextView r0 = r6.f17551h
            int r1 = r7.a()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r0.setText(r1)
        L_0x017c:
            android.widget.TextView r0 = r6.f17552i
            int r1 = r7.h()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r0.setText(r1)
            android.widget.LinearLayout r0 = r6.f17555l
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r0.setTag(r8)
            android.widget.LinearLayout r8 = r6.f17555l
            C2.L0 r0 = new C2.L0
            r0.<init>(r6, r7)
            r8.setOnClickListener(r0)
            android.widget.ImageView r7 = r6.f17561r
            C2.M0 r8 = new C2.M0
            r8.<init>(r6)
            r7.setOnClickListener(r8)
            return
        L_0x01a7:
            android.widget.TextView r7 = r6.f17550g
            r7.setVisibility(r3)
            android.widget.LinearLayout r7 = r6.f17554k
            r7.setVisibility(r3)
            android.widget.LinearLayout r7 = r6.f17555l
            r7.setVisibility(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: C2.N0.i(l2.O, int):void");
    }

    /* access modifiers changed from: private */
    public static final void j(N0 n02, int i5, View view) {
        n02.f17545b.d(i5);
    }

    /* access modifiers changed from: private */
    public static final void k(N0 n02, int i5, View view) {
        n02.f17545b.d(i5);
    }

    /* access modifiers changed from: private */
    public static final void l(N0 n02, int i5, View view) {
        n02.f17545b.a(i5);
    }

    /* access modifiers changed from: private */
    public static final void m(N0 n02, View view) {
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        C2589F f5 = n02.f17545b;
        Object tag = view.getTag();
        t.c(tag, "null cannot be cast to non-null type kotlin.Int");
        f5.e(((Integer) tag).intValue());
    }

    /* access modifiers changed from: private */
    public static final void n(N0 n02, O o5, View view) {
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        new n(n02.f17544a).n(n02.f17553j);
        if (!O.f24814p.d(o5.g())) {
            C2589F f5 = n02.f17545b;
            Object tag = view.getTag();
            t.c(tag, "null cannot be cast to non-null type kotlin.Int");
            f5.b(((Integer) tag).intValue());
            n02.f17552i.setText(String.valueOf(o5.h() + 1));
        }
    }

    /* access modifiers changed from: private */
    public static final void o(N0 n02, View view) {
        n02.f17545b.c();
    }

    public final void g(O o5, int i5) {
        t.e(o5, "item");
        i(o5, i5);
        this.f17556m.setImageDrawable(ContextCompat.getDrawable(this.f17544a, R.drawable.vector_star_on));
        this.f17557n.setImageDrawable(ContextCompat.getDrawable(this.f17544a, R.drawable.vector_star_off));
        this.f17558o.setImageDrawable(ContextCompat.getDrawable(this.f17544a, R.drawable.vector_star_off));
        this.f17559p.setImageDrawable(ContextCompat.getDrawable(this.f17544a, R.drawable.vector_star_off));
        this.f17560q.setImageDrawable(ContextCompat.getDrawable(this.f17544a, R.drawable.vector_star_off));
        if (o5.i() >= 2) {
            this.f17557n.setImageDrawable(ContextCompat.getDrawable(this.f17544a, R.drawable.vector_star_on));
        }
        if (o5.i() >= 3) {
            this.f17558o.setImageDrawable(ContextCompat.getDrawable(this.f17544a, R.drawable.vector_star_on));
        }
        if (o5.i() >= 4) {
            this.f17559p.setImageDrawable(ContextCompat.getDrawable(this.f17544a, R.drawable.vector_star_on));
        }
        if (o5.i() == 5) {
            this.f17560q.setImageDrawable(ContextCompat.getDrawable(this.f17544a, R.drawable.vector_star_on));
        }
    }

    public final void h(O o5, int i5) {
        t.e(o5, "item");
        i(o5, i5);
        this.f17556m.setImageDrawable(ContextCompat.getDrawable(this.f17544a, R.drawable.vector_star_on_turbo));
        this.f17557n.setImageDrawable(ContextCompat.getDrawable(this.f17544a, R.drawable.vector_star_off_turbo));
        this.f17558o.setImageDrawable(ContextCompat.getDrawable(this.f17544a, R.drawable.vector_star_off_turbo));
        this.f17559p.setImageDrawable(ContextCompat.getDrawable(this.f17544a, R.drawable.vector_star_off_turbo));
        this.f17560q.setImageDrawable(ContextCompat.getDrawable(this.f17544a, R.drawable.vector_star_off_turbo));
        if (o5.i() >= 2) {
            this.f17557n.setImageDrawable(ContextCompat.getDrawable(this.f17544a, R.drawable.vector_star_on_turbo));
        }
        if (o5.i() >= 3) {
            this.f17558o.setImageDrawable(ContextCompat.getDrawable(this.f17544a, R.drawable.vector_star_on_turbo));
        }
        if (o5.i() >= 4) {
            this.f17559p.setImageDrawable(ContextCompat.getDrawable(this.f17544a, R.drawable.vector_star_on_turbo));
        }
        if (o5.i() == 5) {
            this.f17560q.setImageDrawable(ContextCompat.getDrawable(this.f17544a, R.drawable.vector_star_on_turbo));
        }
        this.f17561r.setVisibility(0);
        C2962v.f26557a.b(this.f17546c);
    }
}
