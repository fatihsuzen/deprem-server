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
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import java.util.Arrays;
import java.util.Locale;
import k2.C2591a;
import k2.C2594d;
import k2.C2595e;
import kotlin.jvm.internal.Q;
import kotlin.jvm.internal.t;
import l2.C2657f;
import l2.C2666o;
import z2.C2940B;

public final class Y0 extends C2029k {

    /* renamed from: b  reason: collision with root package name */
    private final C2594d f17660b;

    /* renamed from: c  reason: collision with root package name */
    private final C2595e f17661c;

    /* renamed from: d  reason: collision with root package name */
    private final C2591a f17662d;

    /* renamed from: e  reason: collision with root package name */
    private RelativeLayout f17663e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f17664f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f17665g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f17666h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f17667i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f17668j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f17669k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f17670l;

    /* renamed from: m  reason: collision with root package name */
    private LinearLayout f17671m;

    /* renamed from: n  reason: collision with root package name */
    private LinearLayout f17672n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f17673o;

    /* renamed from: p  reason: collision with root package name */
    private ProgressBar f17674p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f17675q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f17676r;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Y0(android.view.View r3, k2.C2594d r4, k2.C2595e r5, k2.C2591a r6) {
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
            r2.f17660b = r4
            r2.f17661c = r5
            r2.f17662d = r6
            r4 = 2131363205(0x7f0a0585, float:1.8346212E38)
            android.view.View r4 = r3.findViewById(r4)
            java.lang.String r5 = "findViewById(...)"
            kotlin.jvm.internal.t.d(r4, r5)
            android.widget.RelativeLayout r4 = (android.widget.RelativeLayout) r4
            r2.f17663e = r4
            r4 = 2131362407(0x7f0a0267, float:1.8344594E38)
            android.view.View r4 = r3.findViewById(r4)
            kotlin.jvm.internal.t.d(r4, r5)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            r2.f17664f = r4
            r4 = 2131364073(0x7f0a08e9, float:1.8347973E38)
            android.view.View r4 = r3.findViewById(r4)
            kotlin.jvm.internal.t.d(r4, r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r2.f17665g = r4
            r4 = 2131364147(0x7f0a0933, float:1.8348123E38)
            android.view.View r4 = r3.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r2.f17666h = r4
            r4 = 2131363825(0x7f0a07f1, float:1.834747E38)
            android.view.View r4 = r3.findViewById(r4)
            kotlin.jvm.internal.t.d(r4, r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r2.f17667i = r4
            r4 = 2131363689(0x7f0a0769, float:1.8347194E38)
            android.view.View r4 = r3.findViewById(r4)
            kotlin.jvm.internal.t.d(r4, r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r2.f17668j = r4
            r4 = 2131364548(0x7f0a0ac4, float:1.8348936E38)
            android.view.View r4 = r3.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r2.f17669k = r4
            r4 = 2131363896(0x7f0a0838, float:1.8347614E38)
            android.view.View r4 = r3.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r2.f17670l = r4
            r4 = 2131362645(0x7f0a0355, float:1.8345076E38)
            android.view.View r4 = r3.findViewById(r4)
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            r2.f17671m = r4
            r4 = 2131362625(0x7f0a0341, float:1.8345036E38)
            android.view.View r4 = r3.findViewById(r4)
            kotlin.jvm.internal.t.d(r4, r5)
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            r2.f17672n = r4
            r4 = 2131364225(0x7f0a0981, float:1.8348281E38)
            android.view.View r4 = r3.findViewById(r4)
            kotlin.jvm.internal.t.d(r4, r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r2.f17673o = r4
            r4 = 2131363106(0x7f0a0522, float:1.8346011E38)
            android.view.View r4 = r3.findViewById(r4)
            kotlin.jvm.internal.t.d(r4, r5)
            android.widget.ProgressBar r4 = (android.widget.ProgressBar) r4
            r2.f17674p = r4
            r4 = 2131364554(0x7f0a0aca, float:1.8348948E38)
            android.view.View r4 = r3.findViewById(r4)
            kotlin.jvm.internal.t.d(r4, r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r2.f17675q = r4
            r4 = 2131363744(0x7f0a07a0, float:1.8347305E38)
            android.view.View r3 = r3.findViewById(r4)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r2.f17676r = r3
            android.widget.TextView r3 = r2.f17665g
            S1.k$a r4 = S1.k.f32g
            android.graphics.Typeface r5 = r4.w()
            r3.setTypeface(r5)
            android.widget.TextView r3 = r2.f17666h
            if (r3 == 0) goto L_0x00f3
            android.graphics.Typeface r5 = r4.w()
            r3.setTypeface(r5)
        L_0x00f3:
            android.widget.TextView r3 = r2.f17669k
            if (r3 == 0) goto L_0x00fe
            android.graphics.Typeface r5 = r4.x()
            r3.setTypeface(r5)
        L_0x00fe:
            android.widget.TextView r3 = r2.f17670l
            if (r3 == 0) goto L_0x0109
            android.graphics.Typeface r5 = r4.x()
            r3.setTypeface(r5)
        L_0x0109:
            android.widget.TextView r3 = r2.f17667i
            android.graphics.Typeface r5 = r4.x()
            r3.setTypeface(r5)
            android.widget.TextView r3 = r2.f17668j
            android.graphics.Typeface r5 = r4.w()
            r3.setTypeface(r5)
            android.widget.TextView r3 = r2.f17675q
            android.graphics.Typeface r5 = r4.x()
            r3.setTypeface(r5)
            android.widget.TextView r3 = r2.f17673o
            android.graphics.Typeface r5 = r4.x()
            r3.setTypeface(r5)
            android.widget.TextView r3 = r2.f17676r
            if (r3 == 0) goto L_0x0138
            android.graphics.Typeface r4 = r4.x()
            r3.setTypeface(r4)
        L_0x0138:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: C2.Y0.<init>(android.view.View, k2.d, k2.e, k2.a):void");
    }

    /* access modifiers changed from: private */
    public static final boolean p(Y0 y02, C2657f fVar, int i5, View view) {
        y02.f17662d.a(fVar, i5);
        return true;
    }

    /* access modifiers changed from: private */
    public static final void q(Y0 y02, C2657f fVar, int i5, View view) {
        y02.f17661c.a(fVar, i5);
    }

    private final String r(long j5) {
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

    private final void s(C2657f fVar, int i5) {
        c.f17333a.c(this.f17674p, this.f17664f);
        this.f17668j.setOnClickListener(new X0(this, fVar, i5));
        this.f17672n.setVisibility(8);
        this.f17667i.setVisibility(0);
        this.f17668j.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public static final void t(Y0 y02, C2657f fVar, int i5, View view) {
        y02.f17661c.a(fVar, i5);
    }

    public final void o(C2657f fVar, int i5, int i6) {
        t.e(fVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        this.f17663e.setOnLongClickListener(new V0(this, fVar, i6));
        c(this.f17663e, this.f17660b, fVar);
        TextView textView = this.f17666h;
        if (textView != null) {
            textView.setText(this.itemView.getContext().getResources().getString(R.string.top_index_format, new Object[]{String.valueOf(i5)}));
        }
        if (fVar.a0() <= 0 || fVar.q() <= 0) {
            LinearLayout linearLayout = this.f17671m;
            if (linearLayout != null) {
                linearLayout.setVisibility(4);
            }
        } else {
            TextView textView2 = this.f17669k;
            if (textView2 != null) {
                textView2.setText(String.valueOf(((double) fVar.a0()) / 10.0d));
            }
            TextView textView3 = this.f17670l;
            if (textView3 != null) {
                textView3.setText(this.itemView.getContext().getString(R.string.pre_registration_counter, new Object[]{r((long) fVar.q())}));
            }
            LinearLayout linearLayout2 = this.f17671m;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
        }
        this.f17665g.setText(fVar.N());
        String k5 = fVar.k();
        if (k5 == null || k5.length() == 0) {
            this.f17667i.setText(fVar.g());
        } else {
            TextView textView4 = this.f17667i;
            C2666o.a aVar = C2666o.f25106g;
            String k6 = fVar.k();
            t.b(k6);
            textView4.setText(aVar.j(new SpannableStringBuilder(k6)));
        }
        this.f17668j.setOnClickListener(new W0(this, fVar, i6));
        h(this.f17664f, fVar.G());
        s(fVar, i6);
        if (this.itemView.getContext() != null) {
            C2940B.a aVar2 = C2940B.f26458v;
            Context context = this.itemView.getContext();
            t.d(context, "getContext(...)");
            C2940B a5 = aVar2.a(context);
            a5.a();
            if (a5.y0(fVar.e()) == null) {
                this.f17668j.setText(R.string.pre_registration_title);
                v.a(this.f17668j);
            } else {
                this.f17668j.setText(R.string.cancel_registration);
                v.d(this.f17668j);
            }
            a5.m();
        }
    }
}
