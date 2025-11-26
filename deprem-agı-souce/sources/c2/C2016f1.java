package C2;

import B2.c;
import B2.v;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import b2.C2291k;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.workers.DownloadWorker;
import java.util.Arrays;
import java.util.Locale;
import k2.C2591a;
import k2.C2594d;
import k2.C2595e;
import kotlin.jvm.internal.Q;
import kotlin.jvm.internal.t;
import l2.C2657f;
import l2.C2666o;
import l2.C2668q;
import l2.T;
import z2.C2940B;
import z2.C2954m;

/* renamed from: C2.f1  reason: case insensitive filesystem */
public final class C2016f1 extends C2029k {

    /* renamed from: b  reason: collision with root package name */
    private final C2594d f17753b;

    /* renamed from: c  reason: collision with root package name */
    private final C2595e f17754c;

    /* renamed from: d  reason: collision with root package name */
    private final C2591a f17755d;

    /* renamed from: e  reason: collision with root package name */
    private RelativeLayout f17756e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f17757f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f17758g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f17759h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f17760i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f17761j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f17762k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f17763l;

    /* renamed from: m  reason: collision with root package name */
    private LinearLayout f17764m;

    /* renamed from: n  reason: collision with root package name */
    private LinearLayout f17765n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f17766o;

    /* renamed from: p  reason: collision with root package name */
    private ProgressBar f17767p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f17768q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f17769r;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C2016f1(android.view.View r3, k2.C2594d r4, k2.C2595e r5, k2.C2591a r6) {
        /*
            r2 = this;
            java.lang.String r0 = "itemView"
            kotlin.jvm.internal.t.e(r3, r0)
            java.lang.String r0 = "listener"
            kotlin.jvm.internal.t.e(r4, r0)
            java.lang.String r0 = "topItemsListener"
            kotlin.jvm.internal.t.e(r5, r0)
            java.lang.String r0 = "actionsClickListener"
            kotlin.jvm.internal.t.e(r6, r0)
            android.content.Context r0 = r3.getContext()
            java.lang.String r1 = "getContext(...)"
            kotlin.jvm.internal.t.d(r0, r1)
            r2.<init>(r3, r0)
            r2.f17753b = r4
            r2.f17754c = r5
            r2.f17755d = r6
            r4 = 2131363205(0x7f0a0585, float:1.8346212E38)
            android.view.View r4 = r3.findViewById(r4)
            java.lang.String r5 = "findViewById(...)"
            kotlin.jvm.internal.t.d(r4, r5)
            android.widget.RelativeLayout r4 = (android.widget.RelativeLayout) r4
            r2.f17756e = r4
            r4 = 2131362407(0x7f0a0267, float:1.8344594E38)
            android.view.View r4 = r3.findViewById(r4)
            kotlin.jvm.internal.t.d(r4, r5)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            r2.f17757f = r4
            r4 = 2131364073(0x7f0a08e9, float:1.8347973E38)
            android.view.View r4 = r3.findViewById(r4)
            kotlin.jvm.internal.t.d(r4, r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r2.f17758g = r4
            r4 = 2131364147(0x7f0a0933, float:1.8348123E38)
            android.view.View r4 = r3.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r2.f17759h = r4
            r4 = 2131363825(0x7f0a07f1, float:1.834747E38)
            android.view.View r4 = r3.findViewById(r4)
            kotlin.jvm.internal.t.d(r4, r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r2.f17760i = r4
            r4 = 2131363689(0x7f0a0769, float:1.8347194E38)
            android.view.View r4 = r3.findViewById(r4)
            kotlin.jvm.internal.t.d(r4, r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r2.f17761j = r4
            r4 = 2131364548(0x7f0a0ac4, float:1.8348936E38)
            android.view.View r4 = r3.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r2.f17762k = r4
            r4 = 2131363896(0x7f0a0838, float:1.8347614E38)
            android.view.View r4 = r3.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r2.f17763l = r4
            r4 = 2131362645(0x7f0a0355, float:1.8345076E38)
            android.view.View r4 = r3.findViewById(r4)
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            r2.f17764m = r4
            r4 = 2131362625(0x7f0a0341, float:1.8345036E38)
            android.view.View r4 = r3.findViewById(r4)
            kotlin.jvm.internal.t.d(r4, r5)
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            r2.f17765n = r4
            r4 = 2131364225(0x7f0a0981, float:1.8348281E38)
            android.view.View r4 = r3.findViewById(r4)
            kotlin.jvm.internal.t.d(r4, r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r2.f17766o = r4
            r4 = 2131363106(0x7f0a0522, float:1.8346011E38)
            android.view.View r4 = r3.findViewById(r4)
            kotlin.jvm.internal.t.d(r4, r5)
            android.widget.ProgressBar r4 = (android.widget.ProgressBar) r4
            r2.f17767p = r4
            r4 = 2131364554(0x7f0a0aca, float:1.8348948E38)
            android.view.View r4 = r3.findViewById(r4)
            kotlin.jvm.internal.t.d(r4, r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r2.f17768q = r4
            r4 = 2131363744(0x7f0a07a0, float:1.8347305E38)
            android.view.View r3 = r3.findViewById(r4)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r2.f17769r = r3
            android.widget.TextView r3 = r2.f17758g
            S1.k$a r4 = S1.k.f32g
            android.graphics.Typeface r5 = r4.w()
            r3.setTypeface(r5)
            android.widget.TextView r3 = r2.f17759h
            if (r3 == 0) goto L_0x00f3
            android.graphics.Typeface r5 = r4.w()
            r3.setTypeface(r5)
        L_0x00f3:
            android.widget.TextView r3 = r2.f17762k
            if (r3 == 0) goto L_0x00fe
            android.graphics.Typeface r5 = r4.x()
            r3.setTypeface(r5)
        L_0x00fe:
            android.widget.TextView r3 = r2.f17763l
            if (r3 == 0) goto L_0x0109
            android.graphics.Typeface r5 = r4.x()
            r3.setTypeface(r5)
        L_0x0109:
            android.widget.TextView r3 = r2.f17760i
            android.graphics.Typeface r5 = r4.x()
            r3.setTypeface(r5)
            android.widget.TextView r3 = r2.f17761j
            android.graphics.Typeface r5 = r4.w()
            r3.setTypeface(r5)
            android.widget.TextView r3 = r2.f17768q
            android.graphics.Typeface r5 = r4.x()
            r3.setTypeface(r5)
            android.widget.TextView r3 = r2.f17766o
            android.graphics.Typeface r5 = r4.x()
            r3.setTypeface(r5)
            android.widget.TextView r3 = r2.f17769r
            if (r3 == 0) goto L_0x0138
            android.graphics.Typeface r4 = r4.x()
            r3.setTypeface(r4)
        L_0x0138:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: C2.C2016f1.<init>(android.view.View, k2.d, k2.e, k2.a):void");
    }

    /* access modifiers changed from: private */
    public static final void A(C2016f1 f1Var, C2657f fVar, int i5, View view) {
        f1Var.f17754c.b(fVar, i5);
    }

    private final void B(C2657f fVar, int i5) {
        v(fVar, i5);
        this.f17761j.setText(R.string.option_button_install);
        this.f17761j.setOnClickListener(new C2004b1(this, fVar, i5));
        v.a(this.f17761j);
    }

    /* access modifiers changed from: private */
    public static final void C(C2016f1 f1Var, C2657f fVar, int i5, View view) {
        f1Var.f17754c.a(fVar, i5);
        f1Var.D();
    }

    private final void D() {
        c.f17333a.e(this.f17767p, this.f17757f);
        LinearLayout linearLayout = this.f17764m;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        this.f17761j.setVisibility(8);
        this.f17760i.setVisibility(8);
        this.f17765n.setVisibility(0);
        this.f17766o.setText(this.itemView.getContext().getString(R.string.installing));
        this.f17767p.setIndeterminate(true);
    }

    private final void E(C2657f fVar, int i5) {
        v(fVar, i5);
        this.f17761j.setText(R.string.open);
        v.a(this.f17761j);
    }

    private final void F(C2657f fVar, int i5) {
        v(fVar, i5);
        this.f17761j.setText(this.itemView.getContext().getString(R.string.status_download_update));
        this.f17761j.setOnClickListener(new C2013e1(this, fVar, i5));
        v.a(this.f17761j);
    }

    /* access modifiers changed from: private */
    public static final void G(C2016f1 f1Var, C2657f fVar, int i5, View view) {
        f1Var.f17754c.a(fVar, i5);
        f1Var.D();
    }

    /* access modifiers changed from: private */
    public static final boolean s(C2016f1 f1Var, C2657f fVar, int i5, View view) {
        f1Var.f17755d.a(fVar, i5);
        return true;
    }

    /* access modifiers changed from: private */
    public static final void t(C2016f1 f1Var, C2657f fVar, int i5, View view) {
        f1Var.f17754c.a(fVar, i5);
    }

    private final String u(long j5) {
        if (j5 < 1000) {
            return String.valueOf(j5);
        }
        if (j5 < 1000000) {
            Q q5 = Q.f24695a;
            String format = String.format(Locale.getDefault(), "%dK", Arrays.copyOf(new Object[]{Integer.valueOf(((int) j5) / 1000)}, 1));
            t.d(format, "format(...)");
            return format;
        }
        Q q6 = Q.f24695a;
        String format2 = String.format(Locale.getDefault(), "%dM", Arrays.copyOf(new Object[]{Integer.valueOf(((int) j5) / 1000000)}, 1));
        t.d(format2, "format(...)");
        return format2;
    }

    private final void v(C2657f fVar, int i5) {
        c.f17333a.c(this.f17767p, this.f17757f);
        this.f17761j.setOnClickListener(new C2007c1(this, fVar, i5));
        this.f17765n.setVisibility(8);
        this.f17760i.setVisibility(0);
        this.f17761j.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public static final void w(C2016f1 f1Var, C2657f fVar, int i5, View view) {
        f1Var.f17754c.a(fVar, i5);
    }

    private final void x(C2657f fVar, int i5) {
        C2668q qVar;
        boolean z4;
        boolean z5;
        String S4;
        C2940B.a aVar = C2940B.f26458v;
        Context context = this.itemView.getContext();
        t.d(context, "getContext(...)");
        C2940B a5 = aVar.a(context);
        a5.a();
        T t5 = null;
        if (fVar.A() > 0) {
            qVar = a5.h0(String.valueOf(fVar.A()));
            if (!(qVar != null || (S4 = fVar.S()) == null || S4.length() == 0)) {
                String S5 = fVar.S();
                t.b(S5);
                qVar = a5.j0(S5);
            }
        } else {
            String S6 = fVar.S();
            if (S6 == null || S6.length() == 0) {
                qVar = null;
            } else {
                String S7 = fVar.S();
                t.b(S7);
                qVar = a5.k0(S7, fVar.J());
            }
        }
        String S8 = fVar.S();
        if (!(S8 == null || S8.length() == 0)) {
            String S9 = fVar.S();
            t.b(S9);
            t5 = a5.G0(S9);
        }
        a5.m();
        boolean v5 = new C2954m().v(fVar.S(), this.itemView.getContext());
        UptodownApp.a aVar2 = UptodownApp.f13477F;
        Context context2 = this.itemView.getContext();
        t.d(context2, "getContext(...)");
        boolean S10 = aVar2.S("downloadApkWorker", context2);
        boolean z6 = false;
        if (!S10 || !DownloadWorker.f21359d.j(fVar.e())) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (qVar == null || !qVar.f()) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (qVar != null && qVar.M()) {
            z6 = true;
        }
        if (qVar == null || (!z4 && !z6)) {
            C2657f fVar2 = fVar;
            int i6 = i5;
            if (v5) {
                if (t5 == null || t5.m()) {
                    E(fVar2, i6);
                } else if (qVar == null || !qVar.f()) {
                    y(fVar2, i6);
                } else {
                    F(fVar2, i6);
                }
            } else if (z5) {
                B(fVar2, i6);
            } else {
                y(fVar2, i6);
            }
        } else {
            z(qVar.x(), qVar.z(), fVar, i5);
        }
    }

    private final void y(C2657f fVar, int i5) {
        v(fVar, i5);
        this.f17761j.setText(R.string.option_button_install);
        v.a(this.f17761j);
    }

    private final void z(int i5, long j5, C2657f fVar, int i6) {
        c.f17333a.e(this.f17767p, this.f17757f);
        LinearLayout linearLayout = this.f17764m;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        this.f17761j.setText(R.string.option_button_cancel);
        this.f17761j.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.shape_stroke_blue_primary));
        this.f17761j.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.blue_primary));
        this.f17761j.setOnClickListener(new C2010d1(this, fVar, i6));
        this.f17760i.setVisibility(8);
        this.f17765n.setVisibility(0);
        if (i5 == 0) {
            this.f17766o.setText(this.itemView.getContext().getString(R.string.status_download_update_pending));
            this.f17767p.setIndeterminate(true);
            return;
        }
        this.f17767p.setIndeterminate(false);
        TextView textView = this.f17766o;
        Context context = this.itemView.getContext();
        Integer valueOf = Integer.valueOf(i5);
        C2291k kVar = new C2291k();
        Context context2 = this.itemView.getContext();
        t.d(context2, "getContext(...)");
        textView.setText(context.getString(R.string.percent_of_total_size, new Object[]{valueOf, kVar.d(j5, context2)}));
        this.f17767p.setProgress(i5);
    }

    public final void r(C2657f fVar, int i5, int i6) {
        t.e(fVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        this.f17756e.setOnLongClickListener(new Z0(this, fVar, i6));
        c(this.f17756e, this.f17753b, fVar);
        TextView textView = this.f17759h;
        if (textView != null) {
            textView.setText(this.itemView.getContext().getResources().getString(R.string.top_index_format, new Object[]{String.valueOf(i5)}));
        }
        if (fVar.a0() <= 0 || fVar.q() <= 0) {
            LinearLayout linearLayout = this.f17764m;
            if (linearLayout != null) {
                linearLayout.setVisibility(4);
            }
        } else {
            TextView textView2 = this.f17762k;
            if (textView2 != null) {
                textView2.setText(String.valueOf(((double) fVar.a0()) / 10.0d));
            }
            TextView textView3 = this.f17763l;
            if (textView3 != null) {
                textView3.setText(this.itemView.getContext().getString(R.string.downloads_counter_multiple, new Object[]{u((long) fVar.q())}));
            }
            LinearLayout linearLayout2 = this.f17764m;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
        }
        this.f17758g.setText(fVar.N());
        String k5 = fVar.k();
        if (k5 == null || k5.length() == 0) {
            this.f17760i.setText(fVar.g());
        } else {
            TextView textView4 = this.f17760i;
            C2666o.a aVar = C2666o.f25106g;
            String k6 = fVar.k();
            t.b(k6);
            textView4.setText(aVar.j(new SpannableStringBuilder(k6)));
        }
        this.f17761j.setOnClickListener(new C2001a1(this, fVar, i6));
        h(this.f17757f, fVar.G());
        x(fVar, i6);
    }
}
