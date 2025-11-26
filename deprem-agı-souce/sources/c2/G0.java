package C2;

import D2.n;
import S1.k;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import com.uptodown.util.views.UsernameTextView;
import k2.C2588E;
import kotlin.jvm.internal.t;
import l2.C2651K;

public final class G0 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final Context f17476a;

    /* renamed from: b  reason: collision with root package name */
    private final C2588E f17477b;

    /* renamed from: c  reason: collision with root package name */
    private final ImageView f17478c;

    /* renamed from: d  reason: collision with root package name */
    private final UsernameTextView f17479d;

    /* renamed from: e  reason: collision with root package name */
    private final ImageView f17480e;

    /* renamed from: f  reason: collision with root package name */
    private final TextView f17481f;

    /* renamed from: g  reason: collision with root package name */
    private final TextView f17482g;

    /* renamed from: h  reason: collision with root package name */
    private final LinearLayout f17483h;

    /* renamed from: i  reason: collision with root package name */
    private final ImageView f17484i;

    /* renamed from: j  reason: collision with root package name */
    private final TextView f17485j;

    /* renamed from: k  reason: collision with root package name */
    private final ImageView f17486k;

    /* renamed from: l  reason: collision with root package name */
    private final ImageView f17487l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public G0(View view, Context context, C2588E e5) {
        super(view);
        t.e(view, "itemView");
        t.e(context, "context");
        t.e(e5, "listener");
        this.f17476a = context;
        this.f17477b = e5;
        View findViewById = view.findViewById(R.id.iv_avatar_review);
        t.d(findViewById, "findViewById(...)");
        this.f17478c = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_username_review);
        t.d(findViewById2, "findViewById(...)");
        UsernameTextView usernameTextView = (UsernameTextView) findViewById2;
        this.f17479d = usernameTextView;
        View findViewById3 = view.findViewById(R.id.iv_author_verified_review);
        t.d(findViewById3, "findViewById(...)");
        this.f17480e = (ImageView) findViewById3;
        View findViewById4 = view.findViewById(R.id.tv_date_review);
        t.d(findViewById4, "findViewById(...)");
        TextView textView = (TextView) findViewById4;
        this.f17481f = textView;
        View findViewById5 = view.findViewById(R.id.tv_body_review);
        t.d(findViewById5, "findViewById(...)");
        TextView textView2 = (TextView) findViewById5;
        this.f17482g = textView2;
        View findViewById6 = view.findViewById(R.id.ll_likes_review);
        t.d(findViewById6, "findViewById(...)");
        this.f17483h = (LinearLayout) findViewById6;
        View findViewById7 = view.findViewById(R.id.iv_likes_counter_review);
        t.d(findViewById7, "findViewById(...)");
        this.f17484i = (ImageView) findViewById7;
        View findViewById8 = view.findViewById(R.id.tv_likes_counter_review);
        t.d(findViewById8, "findViewById(...)");
        TextView textView3 = (TextView) findViewById8;
        this.f17485j = textView3;
        View findViewById9 = view.findViewById(R.id.iv_turbo_mark_review);
        t.d(findViewById9, "findViewById(...)");
        ImageView imageView = (ImageView) findViewById9;
        this.f17486k = imageView;
        View findViewById10 = view.findViewById(R.id.iv_follow_user_review);
        t.d(findViewById10, "findViewById(...)");
        this.f17487l = (ImageView) findViewById10;
        k.a aVar = k.f32g;
        usernameTextView.setTypeface(aVar.w());
        textView.setTypeface(aVar.x());
        textView2.setTypeface(aVar.x());
        textView3.setTypeface(aVar.x());
        imageView.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public static final void g(G0 g02, C2651K k5, View view) {
        new n(g02.f17476a).n(g02.f17484i);
        if (!C2651K.f24779m.c(k5.d())) {
            g02.f17477b.d(k5);
            g02.f17485j.setText(String.valueOf(k5.e() + 1));
        }
    }

    /* access modifiers changed from: private */
    public static final void h(G0 g02, int i5, View view) {
        g02.f17477b.a(i5);
    }

    /* access modifiers changed from: private */
    public static final void i(G0 g02, C2651K k5, View view) {
        g02.f17477b.e(k5);
    }

    /* access modifiers changed from: private */
    public static final void j(G0 g02, C2651K k5, View view) {
        g02.f17477b.e(k5);
    }

    /* access modifiers changed from: private */
    public static final void k(G0 g02, View view) {
        g02.f17477b.c();
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(l2.C2651K r6, int r7) {
        /*
            r5 = this;
            java.lang.String r0 = "item"
            kotlin.jvm.internal.t.e(r6, r0)
            java.lang.String r0 = r6.i()
            if (r0 == 0) goto L_0x0039
            l2.V$b r0 = l2.V.f24870q
            java.lang.String r1 = r6.b()
            java.lang.String r1 = r0.f(r1)
            if (r1 == 0) goto L_0x0039
            com.squareup.picasso.s r1 = com.squareup.picasso.s.h()
            java.lang.String r2 = r6.b()
            java.lang.String r0 = r0.f(r2)
            com.squareup.picasso.w r0 = r1.l(r0)
            com.uptodown.UptodownApp$a r1 = com.uptodown.UptodownApp.f13477F
            android.content.Context r2 = r5.f17476a
            D2.h r1 = r1.i0(r2)
            com.squareup.picasso.w r0 = r0.n(r1)
            android.widget.ImageView r1 = r5.f17478c
            r0.i(r1)
            goto L_0x0055
        L_0x0039:
            com.squareup.picasso.s r0 = com.squareup.picasso.s.h()
            r1 = 2131231605(0x7f080375, float:1.8079296E38)
            com.squareup.picasso.w r0 = r0.j(r1)
            com.uptodown.UptodownApp$a r1 = com.uptodown.UptodownApp.f13477F
            android.content.Context r2 = r5.f17476a
            D2.h r1 = r1.g0(r2)
            com.squareup.picasso.w r0 = r0.n(r1)
            android.widget.ImageView r1 = r5.f17478c
            r0.i(r1)
        L_0x0055:
            java.lang.String r0 = r6.i()
            if (r0 == 0) goto L_0x0073
            com.uptodown.util.views.UsernameTextView r0 = r5.f17479d
            java.lang.String r1 = r6.i()
            r0.setText(r1)
            com.uptodown.util.views.UsernameTextView$a r0 = com.uptodown.util.views.UsernameTextView.f21329k
            com.uptodown.util.views.UsernameTextView r1 = r5.f17479d
            boolean r2 = r6.k()
            java.lang.String r3 = r6.j()
            r0.a(r1, r2, r3)
        L_0x0073:
            int r0 = r6.a()
            r1 = 0
            r2 = 1
            if (r0 != r2) goto L_0x0081
            android.widget.ImageView r0 = r5.f17480e
            r0.setVisibility(r1)
            goto L_0x0087
        L_0x0081:
            android.widget.ImageView r0 = r5.f17480e
            r3 = 4
            r0.setVisibility(r3)
        L_0x0087:
            l2.K$b r0 = l2.C2651K.f24779m
            long r3 = r6.d()
            boolean r0 = r0.c(r3)
            if (r0 == 0) goto L_0x00a2
            android.widget.ImageView r0 = r5.f17484i
            android.content.Context r3 = r5.f17476a
            r4 = 2131231451(0x7f0802db, float:1.8078983E38)
            android.graphics.drawable.Drawable r3 = androidx.core.content.ContextCompat.getDrawable(r3, r4)
            r0.setImageDrawable(r3)
            goto L_0x00b0
        L_0x00a2:
            android.widget.ImageView r0 = r5.f17484i
            android.content.Context r3 = r5.f17476a
            r4 = 2131231449(0x7f0802d9, float:1.807898E38)
            android.graphics.drawable.Drawable r3 = androidx.core.content.ContextCompat.getDrawable(r3, r4)
            r0.setImageDrawable(r3)
        L_0x00b0:
            java.lang.String r0 = r6.g()
            if (r0 == 0) goto L_0x00bf
            android.widget.TextView r0 = r5.f17481f
            java.lang.String r3 = r6.g()
            r0.setText(r3)
        L_0x00bf:
            android.widget.TextView r0 = r5.f17482g
            android.text.Spanned r3 = r6.f()
            r0.setText(r3)
            android.widget.TextView r0 = r5.f17482g
            r3 = 2147483647(0x7fffffff, float:NaN)
            r0.setMaxLines(r3)
            android.widget.TextView r0 = r5.f17485j
            int r3 = r6.e()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r0.setText(r3)
            android.widget.LinearLayout r0 = r5.f17483h
            C2.B0 r3 = new C2.B0
            r3.<init>(r5, r6)
            r0.setOnClickListener(r3)
            l2.V$b r0 = l2.V.f24870q
            android.content.Context r3 = r5.f17476a
            l2.V r0 = r0.h(r3)
            if (r0 == 0) goto L_0x00f6
            java.lang.String r0 = r0.j()
            goto L_0x00f7
        L_0x00f6:
            r0 = 0
        L_0x00f7:
            java.lang.String r3 = r6.h()
            boolean r0 = kotlin.jvm.internal.t.a(r0, r3)
            if (r0 != 0) goto L_0x012f
            int r0 = r6.c()
            if (r0 != r2) goto L_0x0116
            android.widget.ImageView r0 = r5.f17487l
            android.content.Context r2 = r5.f17476a
            r3 = 2131231448(0x7f0802d8, float:1.8078977E38)
            android.graphics.drawable.Drawable r2 = androidx.core.content.ContextCompat.getDrawable(r2, r3)
            r0.setImageDrawable(r2)
            goto L_0x0124
        L_0x0116:
            android.widget.ImageView r0 = r5.f17487l
            android.content.Context r2 = r5.f17476a
            r3 = 2131231447(0x7f0802d7, float:1.8078975E38)
            android.graphics.drawable.Drawable r2 = androidx.core.content.ContextCompat.getDrawable(r2, r3)
            r0.setImageDrawable(r2)
        L_0x0124:
            android.widget.ImageView r0 = r5.f17487l
            C2.C0 r2 = new C2.C0
            r2.<init>(r5, r7)
            r0.setOnClickListener(r2)
            goto L_0x0136
        L_0x012f:
            android.widget.ImageView r7 = r5.f17487l
            r0 = 8
            r7.setVisibility(r0)
        L_0x0136:
            java.lang.String r7 = r6.h()
            if (r7 == 0) goto L_0x0157
            int r7 = r7.length()
            if (r7 != 0) goto L_0x0143
            goto L_0x0157
        L_0x0143:
            com.uptodown.util.views.UsernameTextView r7 = r5.f17479d
            C2.D0 r0 = new C2.D0
            r0.<init>(r5, r6)
            r7.setOnClickListener(r0)
            android.widget.ImageView r7 = r5.f17478c
            C2.E0 r0 = new C2.E0
            r0.<init>(r5, r6)
            r7.setOnClickListener(r0)
        L_0x0157:
            boolean r6 = r6.k()
            if (r6 == 0) goto L_0x0181
            android.view.View r6 = r5.itemView
            android.content.Context r7 = r5.f17476a
            r0 = 2131231329(0x7f080261, float:1.8078736E38)
            android.graphics.drawable.Drawable r7 = androidx.core.content.ContextCompat.getDrawable(r7, r0)
            r6.setBackground(r7)
            android.widget.ImageView r6 = r5.f17486k
            r6.setVisibility(r1)
            android.widget.ImageView r6 = r5.f17486k
            C2.F0 r7 = new C2.F0
            r7.<init>(r5)
            r6.setOnClickListener(r7)
            z2.v$a r6 = z2.C2962v.f26557a
            android.widget.ImageView r7 = r5.f17478c
            r6.c(r7)
        L_0x0181:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: C2.G0.f(l2.K, int):void");
    }
}
