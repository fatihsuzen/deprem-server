package com.uptodown.activities.preferences;

import Q1.C0945a;
import Q1.C0946b;
import Q1.C0947c;
import Q1.C0948d;
import Q1.C0949e;
import Q1.C0950f;
import Q1.C0951g;
import Q1.C0952h;
import Q1.C0953i;
import Q1.C0954j;
import Q1.C0955k;
import Q1.C0956l;
import Q1.C0957m;
import Q1.C0958n;
import Q1.C0959o;
import Q1.C0960p;
import Q1.C0961q;
import Q1.C0962s;
import Q1.C0963t;
import Q1.C0964u;
import Q1.C0965v;
import Q1.C0966w;
import Q1.C0967x;
import Q1.C0968y;
import Q1.r;
import S1.k;
import U1.C2201a;
import W2.C2223l;
import W2.m;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.C1598a;
import com.uptodown.activities.ContactUsActivity;
import h2.A0;
import h2.C2401a;
import h2.C2447x0;
import h2.C2449y0;
import h2.D0;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.J;
import kotlin.jvm.internal.t;
import l2.V;
import z2.C2962v;

public final class AdvancedPreferencesActivity extends C1598a {

    /* renamed from: M  reason: collision with root package name */
    public static final a f15141M = new a((C2633k) null);

    /* renamed from: K  reason: collision with root package name */
    private final C2223l f15142K = m.b(new C0956l(this));

    /* renamed from: L  reason: collision with root package name */
    private RelativeLayout.LayoutParams f15143L;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    private final void E3() {
        C2449y0 c5 = C2449y0.c(getLayoutInflater());
        t.d(c5, "inflate(...)");
        RelativeLayout b5 = c5.getRoot();
        RelativeLayout.LayoutParams layoutParams = this.f15143L;
        RelativeLayout.LayoutParams layoutParams2 = null;
        if (layoutParams == null) {
            t.w("lp");
            layoutParams = null;
        }
        b5.setLayoutParams(layoutParams);
        TextView textView = c5.f23683e;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        c5.f23683e.setText(getString(R.string.version_label));
        c5.f23682d.setTypeface(aVar.x());
        c5.f23682d.setText(getString(R.string.version, new Object[]{getString(R.string.app_name), "6.94", "694"}));
        c5.f23682d.setVisibility(0);
        c5.f23680b.setVisibility(8);
        c5.getRoot().setOnClickListener(new C0953i(new J(), this, c5));
        Z3().f22736b.addView(c5.getRoot());
        C2449y0 c6 = C2449y0.c(getLayoutInflater());
        t.d(c6, "inflate(...)");
        RelativeLayout b6 = c6.getRoot();
        RelativeLayout.LayoutParams layoutParams3 = this.f15143L;
        if (layoutParams3 == null) {
            t.w("lp");
            layoutParams3 = null;
        }
        b6.setLayoutParams(layoutParams3);
        c6.f23683e.setTypeface(aVar.w());
        c6.f23683e.setText(getString(R.string.publication_date));
        c6.f23682d.setTypeface(aVar.x());
        c6.f23682d.setText("Nov 25, 2025 04:07");
        c6.f23682d.setVisibility(0);
        c6.f23680b.setVisibility(8);
        c6.getRoot().setOnClickListener(new C0954j());
        Z3().f22736b.addView(c6.getRoot());
        C2449y0 c7 = C2449y0.c(getLayoutInflater());
        t.d(c7, "inflate(...)");
        RelativeLayout b7 = c7.getRoot();
        RelativeLayout.LayoutParams layoutParams4 = this.f15143L;
        if (layoutParams4 == null) {
            t.w("lp");
            layoutParams4 = null;
        }
        b7.setLayoutParams(layoutParams4);
        c7.f23683e.setTypeface(aVar.w());
        c7.f23683e.setText("Uptodown Core");
        c7.f23682d.setTypeface(aVar.x());
        c7.f23682d.setText("0.2.66");
        c7.f23682d.setVisibility(0);
        c7.f23680b.setVisibility(8);
        c7.getRoot().setOnClickListener(new C0955k());
        Z3().f22736b.addView(c7.getRoot());
        if (UptodownApp.f13477F.K()) {
            C2449y0 c8 = C2449y0.c(getLayoutInflater());
            t.d(c8, "inflate(...)");
            RelativeLayout b8 = c8.getRoot();
            RelativeLayout.LayoutParams layoutParams5 = this.f15143L;
            if (layoutParams5 == null) {
                t.w("lp");
                layoutParams5 = null;
            }
            b8.setLayoutParams(layoutParams5);
            c8.f23683e.setTypeface(aVar.w());
            c8.f23683e.setText("Console");
            c8.getRoot().setOnClickListener(new C0957m(this));
            Z3().f22736b.addView(c8.getRoot());
            V h5 = V.f24870q.h(this);
            if (h5 != null) {
                C2449y0 c9 = C2449y0.c(getLayoutInflater());
                t.d(c9, "inflate(...)");
                RelativeLayout b9 = c9.getRoot();
                RelativeLayout.LayoutParams layoutParams6 = this.f15143L;
                if (layoutParams6 == null) {
                    t.w("lp");
                } else {
                    layoutParams2 = layoutParams6;
                }
                b9.setLayoutParams(layoutParams2);
                c9.f23683e.setTypeface(aVar.w());
                c9.f23680b.setVisibility(8);
                c9.f23683e.setText("userID: " + h5.j());
                c9.getRoot().setOnClickListener(new C0958n(this, h5));
                Z3().f22736b.addView(c9.getRoot());
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void F3(View view) {
    }

    /* access modifiers changed from: private */
    public static final void G3(AdvancedPreferencesActivity advancedPreferencesActivity, View view) {
        advancedPreferencesActivity.startActivity(new Intent(advancedPreferencesActivity, P1.a.class), UptodownApp.f13477F.a(advancedPreferencesActivity));
    }

    /* access modifiers changed from: private */
    public static final void H3(AdvancedPreferencesActivity advancedPreferencesActivity, V v5, View view) {
        Object systemService = advancedPreferencesActivity.getSystemService("clipboard");
        t.c(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("userID", v5.j()));
        advancedPreferencesActivity.u0("userID copiado al portapapeles");
    }

    /* access modifiers changed from: private */
    public static final void I3(J j5, AdvancedPreferencesActivity advancedPreferencesActivity, C2449y0 y0Var, View view) {
        if (j5.f24688a == 4) {
            String string = Settings.Secure.getString(advancedPreferencesActivity.getContentResolver(), "android_id");
            TextView textView = y0Var.f23682d;
            textView.setText(y0Var.f23682d.getText() + " id:" + string);
            y0Var.getRoot().setOnLongClickListener(new C0961q(advancedPreferencesActivity, string));
        }
        int i5 = j5.f24688a;
        if (i5 < 5) {
            j5.f24688a = i5 + 1;
        }
    }

    /* access modifiers changed from: private */
    public static final boolean J3(AdvancedPreferencesActivity advancedPreferencesActivity, String str, View view) {
        Object systemService = advancedPreferencesActivity.getSystemService("clipboard");
        t.c(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("identifier", str));
        advancedPreferencesActivity.u0("identifier copiado al portapapeles");
        return true;
    }

    /* access modifiers changed from: private */
    public static final void K3(View view) {
    }

    private final void L3() {
        C2449y0 c5 = C2449y0.c(getLayoutInflater());
        t.d(c5, "inflate(...)");
        RelativeLayout b5 = c5.getRoot();
        RelativeLayout.LayoutParams layoutParams = this.f15143L;
        RelativeLayout.LayoutParams layoutParams2 = null;
        if (layoutParams == null) {
            t.w("lp");
            layoutParams = null;
        }
        b5.setLayoutParams(layoutParams);
        TextView textView = c5.f23683e;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        c5.f23683e.setText("Website");
        c5.f23682d.setTypeface(aVar.x());
        c5.f23682d.setText(getString(R.string.url));
        c5.f23682d.setVisibility(0);
        c5.getRoot().setOnClickListener(new r(this));
        Z3().f22736b.addView(c5.getRoot());
        C2449y0 c6 = C2449y0.c(getLayoutInflater());
        t.d(c6, "inflate(...)");
        RelativeLayout b6 = c6.getRoot();
        RelativeLayout.LayoutParams layoutParams3 = this.f15143L;
        if (layoutParams3 == null) {
            t.w("lp");
            layoutParams3 = null;
        }
        b6.setLayoutParams(layoutParams3);
        c6.f23683e.setTypeface(aVar.w());
        c6.f23683e.setText("Developers");
        c6.f23682d.setTypeface(aVar.x());
        c6.f23682d.setText(getString(R.string.url_developers));
        c6.f23682d.setVisibility(0);
        c6.getRoot().setOnClickListener(new C0962s(this));
        Z3().f22736b.addView(c6.getRoot());
        C2447x0 c7 = C2447x0.c(getLayoutInflater());
        t.d(c7, "inflate(...)");
        c7.f23669b.setTypeface(aVar.w());
        c7.f23669b.setText(getString(R.string.social_networks));
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.setMargins(0, (int) getResources().getDimension(R.dimen.margin_m), 0, 0);
        c7.getRoot().setLayoutParams(layoutParams4);
        Z3().f22736b.addView(c7.getRoot());
        D0 c8 = D0.c(getLayoutInflater());
        t.d(c8, "inflate(...)");
        LinearLayout b7 = c8.getRoot();
        RelativeLayout.LayoutParams layoutParams5 = this.f15143L;
        if (layoutParams5 == null) {
            t.w("lp");
        } else {
            layoutParams2 = layoutParams5;
        }
        b7.setLayoutParams(layoutParams2);
        c8.f22326g.setOnClickListener(new C0963t(this));
        c8.f22324e.setOnClickListener(new C0964u(this));
        c8.f22325f.setOnClickListener(new C0965v(this));
        c8.f22322c.setOnClickListener(new C0966w(this));
        c8.f22323d.setOnClickListener(new C0967x(this));
        c8.f22321b.setOnClickListener(new C0968y(this));
        Z3().f22736b.addView(c8.getRoot());
    }

    /* access modifiers changed from: private */
    public static final void M3(AdvancedPreferencesActivity advancedPreferencesActivity, View view) {
        C2962v vVar = new C2962v();
        C2962v.u(vVar, advancedPreferencesActivity, advancedPreferencesActivity.getString(R.string.url) + "/android", (String) null, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void N3(AdvancedPreferencesActivity advancedPreferencesActivity, View view) {
        C2962v vVar = new C2962v();
        String string = advancedPreferencesActivity.getString(R.string.url_developers);
        t.d(string, "getString(...)");
        C2962v.u(vVar, advancedPreferencesActivity, string, (String) null, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void O3(AdvancedPreferencesActivity advancedPreferencesActivity, View view) {
        C2962v vVar = new C2962v();
        String string = advancedPreferencesActivity.getString(R.string.url_youtube);
        t.d(string, "getString(...)");
        C2962v.u(vVar, advancedPreferencesActivity, string, (String) null, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void P3(AdvancedPreferencesActivity advancedPreferencesActivity, View view) {
        C2962v vVar = new C2962v();
        String string = advancedPreferencesActivity.getString(R.string.url_tiktok);
        t.d(string, "getString(...)");
        C2962v.u(vVar, advancedPreferencesActivity, string, (String) null, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void Q3(AdvancedPreferencesActivity advancedPreferencesActivity, View view) {
        C2962v vVar = new C2962v();
        String string = advancedPreferencesActivity.getString(R.string.url_x);
        t.d(string, "getString(...)");
        C2962v.u(vVar, advancedPreferencesActivity, string, (String) null, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void R3(AdvancedPreferencesActivity advancedPreferencesActivity, View view) {
        C2962v vVar = new C2962v();
        String string = advancedPreferencesActivity.getString(R.string.url_instagram);
        t.d(string, "getString(...)");
        C2962v.u(vVar, advancedPreferencesActivity, string, (String) null, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void S3(AdvancedPreferencesActivity advancedPreferencesActivity, View view) {
        C2962v vVar = new C2962v();
        String string = advancedPreferencesActivity.getString(R.string.url_linkedin);
        t.d(string, "getString(...)");
        C2962v.u(vVar, advancedPreferencesActivity, string, (String) null, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void T3(AdvancedPreferencesActivity advancedPreferencesActivity, View view) {
        C2962v vVar = new C2962v();
        String string = advancedPreferencesActivity.getString(R.string.url_facebook);
        t.d(string, "getString(...)");
        C2962v.u(vVar, advancedPreferencesActivity, string, (String) null, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final C2401a U3(AdvancedPreferencesActivity advancedPreferencesActivity) {
        return C2401a.c(advancedPreferencesActivity.getLayoutInflater());
    }

    private final void V3() {
        C2449y0 c5 = C2449y0.c(getLayoutInflater());
        t.d(c5, "inflate(...)");
        RelativeLayout b5 = c5.getRoot();
        RelativeLayout.LayoutParams layoutParams = this.f15143L;
        RelativeLayout.LayoutParams layoutParams2 = null;
        if (layoutParams == null) {
            t.w("lp");
            layoutParams = null;
        }
        b5.setLayoutParams(layoutParams);
        TextView textView = c5.f23683e;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        c5.f23683e.setText(getString(R.string.help));
        c5.getRoot().setOnClickListener(new C0950f(this));
        Z3().f22736b.addView(c5.getRoot());
        C2449y0 c6 = C2449y0.c(getLayoutInflater());
        t.d(c6, "inflate(...)");
        RelativeLayout b6 = c6.getRoot();
        RelativeLayout.LayoutParams layoutParams3 = this.f15143L;
        if (layoutParams3 == null) {
            t.w("lp");
            layoutParams3 = null;
        }
        b6.setLayoutParams(layoutParams3);
        c6.f23683e.setTypeface(aVar.w());
        c6.f23683e.setText(getString(R.string.dmca_title));
        c6.getRoot().setOnClickListener(new C0951g(this));
        Z3().f22736b.addView(c6.getRoot());
        C2449y0 c7 = C2449y0.c(getLayoutInflater());
        t.d(c7, "inflate(...)");
        RelativeLayout b7 = c7.getRoot();
        RelativeLayout.LayoutParams layoutParams4 = this.f15143L;
        if (layoutParams4 == null) {
            t.w("lp");
        } else {
            layoutParams2 = layoutParams4;
        }
        b7.setLayoutParams(layoutParams2);
        c7.f23683e.setTypeface(aVar.w());
        c7.f23683e.setText(getString(R.string.contact_us));
        c7.getRoot().setOnClickListener(new C0952h(this));
        Z3().f22736b.addView(c7.getRoot());
    }

    /* access modifiers changed from: private */
    public static final void W3(AdvancedPreferencesActivity advancedPreferencesActivity, View view) {
        String string = advancedPreferencesActivity.getString(R.string.url_support);
        t.d(string, "getString(...)");
        new C2962v().t(advancedPreferencesActivity, string, advancedPreferencesActivity.getString(R.string.support_title));
    }

    /* access modifiers changed from: private */
    public static final void X3(AdvancedPreferencesActivity advancedPreferencesActivity, View view) {
        String string = advancedPreferencesActivity.getString(R.string.dmca_title);
        t.d(string, "getString(...)");
        String string2 = advancedPreferencesActivity.getString(R.string.url_dmca);
        t.d(string2, "getString(...)");
        new C2962v().t(advancedPreferencesActivity, string2, string);
    }

    /* access modifiers changed from: private */
    public static final void Y3(AdvancedPreferencesActivity advancedPreferencesActivity, View view) {
        advancedPreferencesActivity.startActivity(new Intent(advancedPreferencesActivity, ContactUsActivity.class), UptodownApp.f13477F.a(advancedPreferencesActivity));
    }

    private final C2401a Z3() {
        return (C2401a) this.f15142K.getValue();
    }

    private final void a4() {
        C2201a aVar = new C2201a(this);
        A0 c5 = A0.c(getLayoutInflater());
        t.d(c5, "inflate(...)");
        RelativeLayout b5 = c5.getRoot();
        RelativeLayout.LayoutParams layoutParams = this.f15143L;
        RelativeLayout.LayoutParams layoutParams2 = null;
        if (layoutParams == null) {
            t.w("lp");
            layoutParams = null;
        }
        b5.setLayoutParams(layoutParams);
        TextView textView = c5.f22261e;
        k.a aVar2 = k.f32g;
        textView.setTypeface(aVar2.w());
        c5.f22261e.setText(getString(R.string.show_splits_dialog));
        c5.f22260d.setVisibility(8);
        c5.f22259c.setChecked(aVar.s());
        c5.f22259c.setOnCheckedChangeListener(new C0946b(aVar));
        c5.getRoot().setOnClickListener(new C0947c(c5));
        Z3().f22736b.addView(c5.getRoot());
        A0 c6 = A0.c(getLayoutInflater());
        t.d(c6, "inflate(...)");
        RelativeLayout b6 = c6.getRoot();
        RelativeLayout.LayoutParams layoutParams3 = this.f15143L;
        if (layoutParams3 == null) {
            t.w("lp");
        } else {
            layoutParams2 = layoutParams3;
        }
        b6.setLayoutParams(layoutParams2);
        c6.f22261e.setTypeface(aVar2.w());
        c6.f22261e.setText(getString(R.string.show_warning_installed));
        c6.f22260d.setVisibility(8);
        c6.f22259c.setChecked(aVar.P());
        c6.f22259c.setOnCheckedChangeListener(new C0948d(aVar));
        c6.getRoot().setOnClickListener(new C0949e(c6));
        Z3().f22736b.addView(c6.getRoot());
    }

    /* access modifiers changed from: private */
    public static final void b4(C2201a aVar, CompoundButton compoundButton, boolean z4) {
        aVar.K(z4);
    }

    /* access modifiers changed from: private */
    public static final void c4(A0 a02, View view) {
        a02.f22259c.performClick();
    }

    /* access modifiers changed from: private */
    public static final void d4(C2201a aVar, CompoundButton compoundButton, boolean z4) {
        aVar.L(z4);
    }

    /* access modifiers changed from: private */
    public static final void e4(A0 a02, View view) {
        a02.f22259c.performClick();
    }

    /* access modifiers changed from: private */
    public static final void f4(AdvancedPreferencesActivity advancedPreferencesActivity, View view) {
        advancedPreferencesActivity.finish();
    }

    private final void g4() {
        C2449y0 c5 = C2449y0.c(getLayoutInflater());
        t.d(c5, "inflate(...)");
        RelativeLayout b5 = c5.getRoot();
        RelativeLayout.LayoutParams layoutParams = this.f15143L;
        RelativeLayout.LayoutParams layoutParams2 = null;
        if (layoutParams == null) {
            t.w("lp");
            layoutParams = null;
        }
        b5.setLayoutParams(layoutParams);
        TextView textView = c5.f23683e;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        c5.f23683e.setText(getString(R.string.tos_title));
        c5.getRoot().setOnClickListener(new C0959o(this));
        Z3().f22736b.addView(c5.getRoot());
        C2449y0 c6 = C2449y0.c(getLayoutInflater());
        t.d(c6, "inflate(...)");
        RelativeLayout b6 = c6.getRoot();
        RelativeLayout.LayoutParams layoutParams3 = this.f15143L;
        if (layoutParams3 == null) {
            t.w("lp");
        } else {
            layoutParams2 = layoutParams3;
        }
        b6.setLayoutParams(layoutParams2);
        c6.f23683e.setTypeface(aVar.w());
        c6.f23683e.setText(getString(R.string.privacy_policy_title));
        c6.getRoot().setOnClickListener(new C0960p(this));
        Z3().f22736b.addView(c6.getRoot());
    }

    /* access modifiers changed from: private */
    public static final void h4(AdvancedPreferencesActivity advancedPreferencesActivity, View view) {
        String string = advancedPreferencesActivity.getString(R.string.tos_title);
        t.d(string, "getString(...)");
        String string2 = advancedPreferencesActivity.getString(R.string.url_tos);
        t.d(string2, "getString(...)");
        new C2962v().t(advancedPreferencesActivity, string2, string);
    }

    /* access modifiers changed from: private */
    public static final void i4(AdvancedPreferencesActivity advancedPreferencesActivity, View view) {
        String string = advancedPreferencesActivity.getString(R.string.privacy_policy_title);
        t.d(string, "getString(...)");
        String string2 = advancedPreferencesActivity.getString(R.string.url_privacy);
        t.d(string2, "getString(...)");
        new C2962v().t(advancedPreferencesActivity, string2, string);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) Z3().getRoot());
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            Z3().f22738d.setNavigationIcon(drawable);
            Z3().f22738d.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        Z3().f22738d.setNavigationOnClickListener(new C0945a(this));
        Z3().f22739e.setTypeface(k.f32g.w());
        int dimension = (int) getResources().getDimension(R.dimen.margin_s);
        int i5 = -1;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        this.f15143L = layoutParams;
        layoutParams.setMargins(0, dimension, 0, dimension);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("advanced_settings_title")) {
                Z3().f22739e.setText(extras.getString("advanced_settings_title"));
            }
            if (extras.containsKey("advanced_settings_index")) {
                i5 = extras.getInt("advanced_settings_index");
            }
        }
        if (i5 == 0) {
            g4();
        } else if (i5 == 1) {
            V3();
        } else if (i5 == 2) {
            E3();
        } else if (i5 == 3) {
            a4();
        } else if (i5 == 4) {
            L3();
        }
    }
}
