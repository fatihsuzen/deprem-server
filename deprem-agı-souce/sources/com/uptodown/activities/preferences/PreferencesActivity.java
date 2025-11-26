package com.uptodown.activities.preferences;

import D2.n;
import Q1.A;
import Q1.B;
import Q1.C;
import Q1.D;
import Q1.E;
import Q1.F;
import Q1.G;
import Q1.H;
import Q1.I;
import Q1.K;
import Q1.L;
import Q1.N;
import Q1.O;
import Q1.P;
import Q1.S;
import Q1.T;
import Q1.U;
import Q1.V;
import Q1.W;
import Q1.X;
import Q1.Y;
import Q1.Z;
import Q1.a0;
import Q1.b0;
import Q1.c0;
import Q1.d0;
import Q1.e0;
import Q1.f0;
import Q1.g0;
import Q1.h0;
import Q1.i0;
import Q1.j0;
import Q1.k0;
import Q1.l0;
import Q1.m0;
import Q1.n0;
import Q1.o0;
import Q1.p0;
import Q1.q0;
import S1.k;
import U1.C2201a;
import W2.C2223l;
import W2.m;
import W2.y;
import Y1.g;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.core.view.PointerIconCompat;
import b2.C2277I;
import b2.C2291k;
import b2.C2302v;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.C1598a;
import com.uptodown.activities.GdprPrivacySettings;
import com.uptodown.activities.LanguageSettingsActivity;
import com.uptodown.activities.preferences.a;
import com.uptodown.tv.preferences.TvPrivacyPreferences;
import h2.C0;
import h2.C2399C;
import h2.C2451z0;
import h2.U0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import k3.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.J;
import kotlin.jvm.internal.t;
import l2.C2667p;
import l2.Q;
import z2.C2962v;
import z2.M;

public final class PreferencesActivity extends C1598a {

    /* renamed from: P  reason: collision with root package name */
    public static final a f15144P = new a((C2633k) null);

    /* renamed from: K  reason: collision with root package name */
    private final C2223l f15145K = m.b(new A(this));

    /* renamed from: L  reason: collision with root package name */
    private final C2201a f15146L = new C2201a(this);

    /* renamed from: M  reason: collision with root package name */
    private Q f15147M;

    /* renamed from: N  reason: collision with root package name */
    private final ActivityResultLauncher f15148N;

    /* renamed from: O  reason: collision with root package name */
    private final ActivityResultLauncher f15149O;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public PreferencesActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new L(this));
        t.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f15148N = registerForActivityResult;
        ActivityResultLauncher registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new X(this));
        t.d(registerForActivityResult2, "registerForActivityResult(...)");
        this.f15149O = registerForActivityResult2;
    }

    /* access modifiers changed from: private */
    public static final void A4(PreferencesActivity preferencesActivity, HashMap hashMap, J j5, C2451z0 z0Var, View view) {
        String string = preferencesActivity.getString(R.string.select_downloads_path);
        t.d(string, "getString(...)");
        preferencesActivity.W3(string, hashMap, j5.f24688a, new d0(preferencesActivity, z0Var));
    }

    /* access modifiers changed from: private */
    public static final W2.J B4(PreferencesActivity preferencesActivity, C2451z0 z0Var, int i5) {
        boolean z4;
        a.C0147a aVar = a.f15150a;
        if (i5 != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        aVar.g1(preferencesActivity, z4);
        if (i5 == 0) {
            z0Var.f23698c.setText(preferencesActivity.getString(R.string.internal_storage));
        } else {
            z0Var.f23698c.setText(preferencesActivity.getString(R.string.sd_card));
        }
        return W2.J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final void C4(PreferencesActivity preferencesActivity, View view) {
        UptodownApp.a aVar = UptodownApp.f13477F;
        if (aVar.R(preferencesActivity)) {
            preferencesActivity.startActivity(new Intent(preferencesActivity, TvPrivacyPreferences.class));
        } else {
            preferencesActivity.startActivity(new Intent(preferencesActivity, GdprPrivacySettings.class), aVar.a(preferencesActivity));
        }
    }

    /* access modifiers changed from: private */
    public static final void D4(PreferencesActivity preferencesActivity, View view) {
        Intent intent = new Intent(preferencesActivity, AdvancedPreferencesActivity.class);
        intent.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.advanced_settings));
        intent.putExtra("advanced_settings_index", 3);
        preferencesActivity.startActivity(intent, UptodownApp.f13477F.a(preferencesActivity));
    }

    /* access modifiers changed from: private */
    public static final void E4(PreferencesActivity preferencesActivity, View view) {
        Intent intent = new Intent(preferencesActivity, AdvancedPreferencesActivity.class);
        intent.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.tos_title));
        intent.putExtra("advanced_settings_index", 0);
        preferencesActivity.startActivity(intent, UptodownApp.f13477F.a(preferencesActivity));
    }

    /* access modifiers changed from: private */
    public static final void F4(PreferencesActivity preferencesActivity, View view) {
        Intent intent = new Intent(preferencesActivity, AdvancedPreferencesActivity.class);
        intent.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.feedback));
        intent.putExtra("advanced_settings_index", 1);
        preferencesActivity.startActivity(intent, UptodownApp.f13477F.a(preferencesActivity));
    }

    /* access modifiers changed from: private */
    public static final void G4(PreferencesActivity preferencesActivity, View view) {
        String string = preferencesActivity.getString(R.string.privacy_policy_title);
        t.d(string, "getString(...)");
        String string2 = preferencesActivity.getString(R.string.url_advertising);
        t.d(string2, "getString(...)");
        new C2962v().t(preferencesActivity, string2, string);
    }

    /* access modifiers changed from: private */
    public static final void H4(PreferencesActivity preferencesActivity, View view) {
        Intent intent = new Intent(preferencesActivity, AdvancedPreferencesActivity.class);
        intent.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.about));
        intent.putExtra("advanced_settings_index", 2);
        preferencesActivity.startActivity(intent, UptodownApp.f13477F.a(preferencesActivity));
    }

    /* access modifiers changed from: private */
    public static final void I4(PreferencesActivity preferencesActivity, View view) {
        Intent intent = new Intent(preferencesActivity, AdvancedPreferencesActivity.class);
        intent.putExtra("advanced_settings_title", preferencesActivity.getString(R.string.about_uptodown));
        intent.putExtra("advanced_settings_index", 4);
        preferencesActivity.startActivity(intent, UptodownApp.f13477F.a(preferencesActivity));
    }

    /* access modifiers changed from: private */
    public static final void J4(PreferencesActivity preferencesActivity, HashMap hashMap, View view) {
        if (preferencesActivity.a4().f22288F.f22276c.isChecked()) {
            String string = preferencesActivity.getString(R.string.download_updates_automatically_title);
            t.d(string, "getString(...)");
            preferencesActivity.W3(string, hashMap, Integer.parseInt(a.f15150a.j(preferencesActivity)), new c0(preferencesActivity));
        }
    }

    /* access modifiers changed from: private */
    public static final W2.J K4(PreferencesActivity preferencesActivity, int i5) {
        a.f15150a.D0(preferencesActivity, String.valueOf(i5));
        preferencesActivity.a4().f22288F.f22277d.setText(preferencesActivity.b4());
        return W2.J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final void L4(PreferencesActivity preferencesActivity, CompoundButton compoundButton, boolean z4) {
        if (z4) {
            n nVar = new n(preferencesActivity);
            RelativeLayout b5 = preferencesActivity.a4().f22288F.getRoot();
            t.d(b5, "getRoot(...)");
            nVar.d(b5, 1.0f);
            n nVar2 = new n(preferencesActivity);
            RelativeLayout b6 = preferencesActivity.a4().f22287E.getRoot();
            t.d(b6, "getRoot(...)");
            nVar2.d(b6, 1.0f);
            a.f15150a.D0(preferencesActivity, "2");
            preferencesActivity.a4().f22288F.f22277d.setText(preferencesActivity.b4());
            return;
        }
        n nVar3 = new n(preferencesActivity);
        RelativeLayout b7 = preferencesActivity.a4().f22288F.getRoot();
        t.d(b7, "getRoot(...)");
        nVar3.d(b7, 0.3f);
        n nVar4 = new n(preferencesActivity);
        RelativeLayout b8 = preferencesActivity.a4().f22287E.getRoot();
        t.d(b8, "getRoot(...)");
        nVar4.d(b8, 0.3f);
        a.f15150a.D0(preferencesActivity, "0");
        preferencesActivity.a4().f22288F.f22277d.setText(preferencesActivity.getString(R.string.preference_updates_disabled));
    }

    /* access modifiers changed from: private */
    public static final void M4(PreferencesActivity preferencesActivity, View view) {
        preferencesActivity.a4().f22301m.f22259c.performClick();
    }

    /* access modifiers changed from: private */
    public static final void N4(PreferencesActivity preferencesActivity, CompoundButton compoundButton, boolean z4) {
        new C2201a(preferencesActivity).I(z4);
    }

    /* access modifiers changed from: private */
    public static final void O4(PreferencesActivity preferencesActivity, View view) {
        preferencesActivity.a4().f22294f.f22259c.performClick();
    }

    private final void P4() {
        Intent intent = new Intent();
        intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
        intent.putExtra("android.provider.extra.APP_PACKAGE", getPackageName());
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 646);
        }
    }

    private final void Q4() {
        if (Build.VERSION.SDK_INT >= 33) {
            this.f15149O.launch("android.permission.POST_NOTIFICATIONS");
            return;
        }
        a.f15150a.c1(this, true);
        S4();
    }

    /* access modifiers changed from: private */
    public static final void R4(PreferencesActivity preferencesActivity, boolean z4) {
        if (z4) {
            a.f15150a.c1(preferencesActivity, true);
            preferencesActivity.S4();
            return;
        }
        preferencesActivity.a4().f22314z.f22259c.setChecked(false);
        preferencesActivity.d4();
        a.C0147a aVar = a.f15150a;
        int D4 = aVar.D(preferencesActivity) + 1;
        aVar.b1(preferencesActivity, D4);
        if (Build.VERSION.SDK_INT >= 33 && D4 >= 2 && !M.f26506a.v(preferencesActivity)) {
            preferencesActivity.T4();
        }
    }

    private final void S4() {
        a4().f22314z.f22260d.setText(getString(R.string.enabled));
        if (t.a(a.f15150a.j(this), "0")) {
            n nVar = new n(this);
            RelativeLayout b5 = a4().f22287E.getRoot();
            t.d(b5, "getRoot(...)");
            nVar.d(b5, 0.3f);
        } else {
            n nVar2 = new n(this);
            RelativeLayout b6 = a4().f22287E.getRoot();
            t.d(b6, "getRoot(...)");
            nVar2.d(b6, 1.0f);
        }
        n nVar3 = new n(this);
        RelativeLayout b7 = a4().f22298j.getRoot();
        t.d(b7, "getRoot(...)");
        nVar3.d(b7, 1.0f);
        a4().f22298j.f22259c.setClickable(true);
        n nVar4 = new n(this);
        RelativeLayout b8 = a4().f22302n.getRoot();
        t.d(b8, "getRoot(...)");
        nVar4.d(b8, 1.0f);
        a4().f22302n.f22259c.setClickable(true);
        n nVar5 = new n(this);
        RelativeLayout b9 = a4().f22301m.getRoot();
        t.d(b9, "getRoot(...)");
        nVar5.d(b9, 1.0f);
        a4().f22301m.f22259c.setClickable(true);
    }

    private final void T4() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.title_notification_dialog_permission);
        builder.setMessage(R.string.description_notification_dialog_permission);
        builder.setPositiveButton(R.string.button_notification_dialog_permission, new f0(this));
        builder.create().show();
    }

    /* access modifiers changed from: private */
    public static final void U4(PreferencesActivity preferencesActivity, DialogInterface dialogInterface, int i5) {
        preferencesActivity.P4();
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    public static final C0 V3(PreferencesActivity preferencesActivity) {
        return C0.c(preferencesActivity.getLayoutInflater());
    }

    private final void W3(String str, HashMap hashMap, int i5, l lVar) {
        if (!isFinishing()) {
            AlertDialog p22 = p2();
            if (p22 != null) {
                p22.dismiss();
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            C2399C c5 = C2399C.c(getLayoutInflater());
            t.d(c5, "inflate(...)");
            J j5 = new J();
            j5.f24688a = i5;
            c5.f22282d.setTypeface(k.f32g.w());
            c5.f22282d.setText(str);
            for (Map.Entry entry : hashMap.entrySet()) {
                U0 c6 = U0.c(getLayoutInflater());
                t.d(c6, "inflate(...)");
                c6.getRoot().setId(((Number) entry.getKey()).intValue());
                c6.f22656b.setTypeface(k.f32g.x());
                c6.f22656b.setText((CharSequence) entry.getValue());
                c6.getRoot().setOnClickListener(new j0(j5, entry));
                if (((Number) entry.getKey()).intValue() == i5) {
                    c6.f22656b.setChecked(true);
                }
                c5.f22280b.addView(c6.getRoot());
            }
            c5.f22281c.setTypeface(k.f32g.w());
            c5.f22281c.setOnClickListener(new k0(lVar, j5, this));
            builder.setView(c5.getRoot());
            P2(builder.create());
            if (!isFinishing() && p2() != null) {
                AlertDialog p23 = p2();
                t.b(p23);
                p23.setCancelable(true);
                b3();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void X3(J j5, Map.Entry entry, View view) {
        j5.f24688a = ((Number) entry.getKey()).intValue();
    }

    /* access modifiers changed from: private */
    public static final void Y3(l lVar, J j5, PreferencesActivity preferencesActivity, View view) {
        lVar.invoke(Integer.valueOf(j5.f24688a));
        preferencesActivity.o2();
    }

    private final String Z3() {
        int c5 = a.f15150a.c(this);
        if (c5 == -1) {
            String string = getString(R.string.setting_play_video_array_never);
            t.d(string, "getString(...)");
            return string;
        } else if (c5 == 0) {
            String string2 = getString(R.string.setting_play_video_array_only_wifi);
            t.d(string2, "getString(...)");
            return string2;
        } else if (c5 != 1) {
            return "";
        } else {
            String string3 = getString(R.string.setting_play_video_array_wifi_and_data);
            t.d(string3, "getString(...)");
            return string3;
        }
    }

    private final C0 a4() {
        return (C0) this.f15145K.getValue();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String b4() {
        /*
            r7 = this;
            com.uptodown.activities.preferences.a$a r0 = com.uptodown.activities.preferences.a.f15150a
            java.lang.String r1 = r0.j(r7)
            int r2 = r1.hashCode()
            r3 = 2131952553(0x7f1303a9, float:1.9541552E38)
            java.lang.String r4 = "2"
            switch(r2) {
                case 48: goto L_0x0030;
                case 49: goto L_0x001f;
                case 50: goto L_0x0013;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x0038
        L_0x0013:
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x001a
            goto L_0x0038
        L_0x001a:
            java.lang.String r0 = r7.getString(r3)
            goto L_0x0047
        L_0x001f:
            java.lang.String r2 = "1"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0028
            goto L_0x0038
        L_0x0028:
            r0 = 2131952561(0x7f1303b1, float:1.9541568E38)
            java.lang.String r0 = r7.getString(r0)
            goto L_0x0047
        L_0x0030:
            java.lang.String r2 = "0"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0040
        L_0x0038:
            r0.D0(r7, r4)
            java.lang.String r0 = r7.getString(r3)
            goto L_0x0047
        L_0x0040:
            r0 = 2131952566(0x7f1303b6, float:1.9541578E38)
            java.lang.String r0 = r7.getString(r0)
        L_0x0047:
            r1 = 0
            java.io.File r2 = r7.getExternalFilesDir(r1)
            if (r2 == 0) goto L_0x0056
            long r1 = r2.getUsableSpace()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
        L_0x0056:
            java.lang.String r2 = "\n⚠ "
            if (r1 != 0) goto L_0x0074
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r2)
            r0 = 2131952019(0x7f130193, float:1.9540469E38)
            java.lang.String r0 = r7.getString(r0)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            return r0
        L_0x0074:
            long r3 = r1.longValue()
            r5 = 262144000(0xfa00000, double:1.295163447E-315)
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L_0x0098
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r2)
            r0 = 2131952030(0x7f13019e, float:1.9540491E38)
            java.lang.String r0 = r7.getString(r0)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L_0x0098:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.preferences.PreferencesActivity.b4():java.lang.String");
    }

    private final String c4() {
        int parseInt = Integer.parseInt(a.f15150a.B(this));
        if (parseInt == 1) {
            return getString(R.string.updates_notification_description_always);
        }
        if (parseInt == 2) {
            return getString(R.string.updates_notification_description_daily);
        }
        if (parseInt == 3) {
            return getString(R.string.updates_notification_description_weekly);
        }
        if (parseInt != 4) {
            return "";
        }
        return getString(R.string.updates_notification_description_never);
    }

    private final void d4() {
        a4().f22314z.f22260d.setText(getString(R.string.disabled));
        n nVar = new n(this);
        RelativeLayout b5 = a4().f22287E.getRoot();
        t.d(b5, "getRoot(...)");
        nVar.d(b5, 0.3f);
        n nVar2 = new n(this);
        RelativeLayout b6 = a4().f22298j.getRoot();
        t.d(b6, "getRoot(...)");
        nVar2.d(b6, 0.3f);
        a4().f22298j.f22259c.setClickable(false);
        n nVar3 = new n(this);
        RelativeLayout b7 = a4().f22302n.getRoot();
        t.d(b7, "getRoot(...)");
        nVar3.d(b7, 0.3f);
        a4().f22302n.f22259c.setClickable(false);
        n nVar4 = new n(this);
        RelativeLayout b8 = a4().f22301m.getRoot();
        t.d(b8, "getRoot(...)");
        nVar4.d(b8, 0.3f);
        a4().f22301m.f22259c.setClickable(false);
    }

    /* access modifiers changed from: private */
    public static final void e4(PreferencesActivity preferencesActivity, ActivityResult activityResult) {
        if (activityResult.getResultCode() == 1003) {
            preferencesActivity.setResult(PointerIconCompat.TYPE_HELP);
            preferencesActivity.finish();
            preferencesActivity.startActivity(preferencesActivity.getIntent());
        }
    }

    /* access modifiers changed from: private */
    public static final void f4(PreferencesActivity preferencesActivity, CompoundButton compoundButton, boolean z4) {
        a.f15150a.s0(preferencesActivity, z4);
    }

    /* access modifiers changed from: private */
    public static final void g4(PreferencesActivity preferencesActivity, HashMap hashMap, View view) {
        String string = preferencesActivity.getString(R.string.setting_title_play_video_app_details);
        t.d(string, "getString(...)");
        preferencesActivity.W3(string, hashMap, a.f15150a.c(preferencesActivity), new e0(preferencesActivity));
    }

    /* access modifiers changed from: private */
    public static final W2.J h4(PreferencesActivity preferencesActivity, int i5) {
        a.f15150a.u0(preferencesActivity, String.valueOf(i5));
        preferencesActivity.a4().f22295g.f23698c.setText(preferencesActivity.Z3());
        return W2.J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final void i4(PreferencesActivity preferencesActivity, HashMap hashMap, View view) {
        String string = preferencesActivity.getString(R.string.data_saver_preference_subtitle);
        t.d(string, "getString(...)");
        preferencesActivity.W3(string, hashMap, a.f15150a.g(preferencesActivity), new h0(preferencesActivity));
    }

    /* access modifiers changed from: private */
    public static final W2.J j4(PreferencesActivity preferencesActivity, int i5) {
        a.C0147a aVar = a.f15150a;
        if (aVar.g(preferencesActivity) != i5) {
            aVar.y0(preferencesActivity, String.valueOf(i5));
            preferencesActivity.setResult(PointerIconCompat.TYPE_WAIT);
        }
        return W2.J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final void k4(PreferencesActivity preferencesActivity, View view) {
        preferencesActivity.a4().f22307s.f22259c.performClick();
    }

    /* access modifiers changed from: private */
    public static final void l4(PreferencesActivity preferencesActivity, CompoundButton compoundButton, boolean z4) {
        a.f15150a.e1(preferencesActivity, z4);
    }

    /* access modifiers changed from: private */
    public static final void m4(PreferencesActivity preferencesActivity, View view) {
        preferencesActivity.a4().f22296h.f22259c.performClick();
    }

    /* access modifiers changed from: private */
    public static final void n4(PreferencesActivity preferencesActivity, CompoundButton compoundButton, boolean z4) {
        a.f15150a.K0(preferencesActivity, z4);
        if (z4) {
            try {
                C2302v.f20755a.d();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void o4(PreferencesActivity preferencesActivity, View view) {
        preferencesActivity.a4().f22311w.f22259c.performClick();
    }

    /* access modifiers changed from: private */
    public static final void p4(PreferencesActivity preferencesActivity, View view) {
        preferencesActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void q4(PreferencesActivity preferencesActivity, CompoundButton compoundButton, boolean z4) {
        a.f15150a.f1(preferencesActivity, z4);
        if (z4) {
            preferencesActivity.f15146L.O(true);
        }
    }

    /* access modifiers changed from: private */
    public static final void r4(PreferencesActivity preferencesActivity, View view) {
        preferencesActivity.a4().f22314z.f22259c.performClick();
    }

    /* access modifiers changed from: private */
    public static final void s4(PreferencesActivity preferencesActivity, CompoundButton compoundButton, boolean z4) {
        if (z4) {
            preferencesActivity.S4();
            preferencesActivity.Q4();
            return;
        }
        preferencesActivity.d4();
        a.f15150a.c1(preferencesActivity, false);
    }

    /* access modifiers changed from: private */
    public static final void t4(PreferencesActivity preferencesActivity, HashMap hashMap, View view) {
        String string = preferencesActivity.getString(R.string.updates);
        t.d(string, "getString(...)");
        preferencesActivity.W3(string, hashMap, Integer.parseInt(a.f15150a.B(preferencesActivity)), new g0(preferencesActivity));
    }

    /* access modifiers changed from: private */
    public static final W2.J u4(PreferencesActivity preferencesActivity, int i5) {
        a.f15150a.a1(preferencesActivity, String.valueOf(i5));
        preferencesActivity.a4().f22287E.f23698c.setText(preferencesActivity.c4());
        return W2.J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final void v4(PreferencesActivity preferencesActivity, View view) {
        preferencesActivity.a4().f22298j.f22259c.performClick();
    }

    /* access modifiers changed from: private */
    public static final void w4(PreferencesActivity preferencesActivity, CompoundButton compoundButton, boolean z4) {
        a.f15150a.C0(preferencesActivity, z4);
    }

    /* access modifiers changed from: private */
    public static final void x4(PreferencesActivity preferencesActivity, View view) {
        preferencesActivity.a4().f22302n.f22259c.performClick();
    }

    /* access modifiers changed from: private */
    public static final void y4(PreferencesActivity preferencesActivity, CompoundButton compoundButton, boolean z4) {
        a.f15150a.L0(preferencesActivity, z4);
    }

    /* access modifiers changed from: private */
    public static final void z4(PreferencesActivity preferencesActivity, View view) {
        preferencesActivity.f15148N.launch(new Intent(preferencesActivity, LanguageSettingsActivity.class), UptodownApp.f13477F.b(preferencesActivity));
    }

    public void finish() {
        Q q5 = new Q(this);
        if (!q5.b(this.f15147M)) {
            C2667p pVar = new C2667p();
            pVar.j(this);
            q5.j(this, pVar);
        }
        super.finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView((View) a4().getRoot());
        this.f15147M = new Q(this);
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            a4().f22283A.setNavigationIcon(drawable);
            a4().f22283A.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        a4().f22283A.setNavigationOnClickListener(new i0(this));
        TextView textView = a4().f22285C;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        a4().f22303o.f23683e.setTypeface(aVar.w());
        a4().f22303o.f23683e.setText(getString(R.string.item_menu_idioma));
        a4().f22303o.f23682d.setTypeface(aVar.x());
        a4().f22303o.f23682d.setVisibility(0);
        String n5 = a.f15150a.n(this);
        String[] stringArray = getResources().getStringArray(R.array.languageCodes);
        t.d(stringArray, "getStringArray(...)");
        String[] stringArray2 = getResources().getStringArray(R.array.localizedLang);
        t.d(stringArray2, "getStringArray(...)");
        int length = stringArray.length;
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                str = "";
                break;
            } else if (stringArray[i5].equals(n5)) {
                str = stringArray2[i5];
                break;
            } else {
                i5++;
            }
        }
        a4().f22303o.f23682d.setText(str);
        a4().f22303o.getRoot().setOnClickListener(new F(this));
        TextView textView2 = a4().f22286D.f23669b;
        k.a aVar2 = k.f32g;
        textView2.setTypeface(aVar2.w());
        a4().f22286D.f23669b.setText(getString(R.string.updates));
        a4().f22288F.f22278e.setTypeface(aVar2.w());
        a4().f22288F.f22278e.setText(getString(R.string.updates));
        a4().f22288F.f22277d.setTypeface(aVar2.x());
        a4().f22288F.f22277d.setText(b4());
        a4().f22288F.getRoot().setOnClickListener(new S(this, X2.M.j(y.a(Integer.valueOf(Integer.parseInt("1")), getString(R.string.preference_only_notify)), y.a(Integer.valueOf(Integer.parseInt("2")), getString(R.string.pref_auto_update_title)))));
        a.C0147a aVar3 = a.f15150a;
        if (t.a(aVar3.j(this), "0")) {
            n nVar = new n(this);
            RelativeLayout b5 = a4().f22288F.getRoot();
            t.d(b5, "getRoot(...)");
            nVar.d(b5, 0.3f);
            n nVar2 = new n(this);
            RelativeLayout b6 = a4().f22287E.getRoot();
            t.d(b6, "getRoot(...)");
            nVar2.d(b6, 0.3f);
            a4().f22288F.f22276c.setChecked(false);
        } else {
            n nVar3 = new n(this);
            RelativeLayout b7 = a4().f22288F.getRoot();
            t.d(b7, "getRoot(...)");
            nVar3.d(b7, 1.0f);
            n nVar4 = new n(this);
            RelativeLayout b8 = a4().f22287E.getRoot();
            t.d(b8, "getRoot(...)");
            nVar4.d(b8, 1.0f);
            a4().f22288F.f22276c.setChecked(true);
        }
        a4().f22288F.f22276c.setOnCheckedChangeListener(new U(this));
        a4().f22300l.f23669b.setTypeface(aVar2.w());
        a4().f22300l.f23669b.setText(getString(R.string.preference_file_management));
        a4().f22301m.getRoot().setOnClickListener(new V(this));
        a4().f22301m.f22261e.setTypeface(aVar2.w());
        a4().f22301m.f22261e.setText(getString(R.string.search_apk_file_worker_preference_title));
        a4().f22301m.f22260d.setTypeface(aVar2.x());
        a4().f22301m.f22260d.setText(getString(R.string.preference_locate_files_in_storage));
        a4().f22301m.f22259c.setChecked(new C2201a(this).q());
        a4().f22301m.f22259c.setOnCheckedChangeListener(new W(this));
        a4().f22308t.f23669b.setTypeface(aVar2.w());
        a4().f22308t.f23669b.setText(getString(R.string.preference_performance_and_data_saver));
        a4().f22294f.getRoot().setOnClickListener(new Y(this));
        a4().f22294f.f22261e.setTypeface(aVar2.w());
        a4().f22294f.f22261e.setText(getString(R.string.preference_title_allow_animations));
        a4().f22294f.f22260d.setVisibility(8);
        a4().f22294f.f22259c.setChecked(aVar3.P(this));
        a4().f22294f.f22259c.setOnCheckedChangeListener(new Z(this));
        if (UptodownApp.f13477F.P()) {
            a4().f22294f.getRoot().setVisibility(8);
        }
        a4().f22295g.f23699d.setTypeface(aVar2.w());
        a4().f22295g.f23699d.setText(getString(R.string.setting_title_play_video_app_details));
        a4().f22295g.f23698c.setTypeface(aVar2.x());
        a4().f22295g.f23698c.setText(Z3());
        a4().f22295g.getRoot().setOnClickListener(new a0(this, X2.M.j(y.a(-1, getString(R.string.setting_play_video_array_never)), y.a(0, getString(R.string.setting_play_video_array_only_wifi)), y.a(1, getString(R.string.setting_play_video_array_wifi_and_data)))));
        a4().f22297i.f23699d.setTypeface(aVar2.w());
        a4().f22297i.f23699d.setText(getString(R.string.data_saver_preference_title));
        a4().f22297i.f23698c.setTypeface(aVar2.x());
        a4().f22297i.f23698c.setText(getString(R.string.data_saver_preference_summary));
        a4().f22297i.getRoot().setOnClickListener(new b0(this, X2.M.j(y.a(0, getString(R.string.data_saver_preference_save_option)), y.a(1, getString(R.string.data_saver_preference_auto_option)), y.a(2, getString(R.string.data_saver_preference_hd_option)))));
        a4().f22307s.getRoot().setOnClickListener(new l0(this));
        a4().f22307s.f22261e.setTypeface(aVar2.w());
        a4().f22307s.f22261e.setText(getString(R.string.solo_wifi));
        a4().f22307s.f22260d.setTypeface(aVar2.x());
        a4().f22307s.f22260d.setText(getString(R.string.solo_wifi_desc));
        a4().f22307s.f22259c.setChecked(aVar3.b0(this));
        a4().f22307s.f22259c.setOnCheckedChangeListener(new m0(this));
        if (this.f15146L.t() || C2302v.f20755a.d()) {
            a4().f22313y.f23669b.setTypeface(aVar2.w());
            a4().f22313y.f23669b.setText(getString(R.string.pref_category_title_install_as_root_system));
            a4().f22296h.getRoot().setOnClickListener(new n0(this));
            a4().f22296h.f22261e.setTypeface(aVar2.w());
            a4().f22296h.f22261e.setText(getString(R.string.pref_auto_update_title));
            a4().f22296h.f22260d.setTypeface(aVar2.x());
            a4().f22296h.f22260d.setText(getString(R.string.pref_auto_update_sumary));
            a4().f22296h.f22259c.setChecked(aVar3.Y(this));
            a4().f22296h.f22259c.setOnCheckedChangeListener(new o0(this));
            a4().f22311w.getRoot().setOnClickListener(new p0(this));
            a4().f22311w.f22261e.setTypeface(aVar2.w());
            a4().f22311w.f22261e.setText(getString(R.string.pref_install_apk_as_root_system_title));
            a4().f22311w.f22260d.setTypeface(aVar2.x());
            a4().f22311w.f22260d.setText(getString(R.string.pref_install_apk_as_root_system_summary));
            a4().f22311w.f22259c.setChecked(aVar3.c0(this));
            a4().f22311w.f22259c.setOnCheckedChangeListener(new q0(this));
        } else {
            a4().f22313y.f23669b.setVisibility(8);
            a4().f22296h.getRoot().setVisibility(8);
            a4().f22311w.getRoot().setVisibility(8);
        }
        a4().f22306r.f23669b.setTypeface(aVar2.w());
        a4().f22306r.f23669b.setText(getString(R.string.recibir_notificaciones));
        a4().f22314z.getRoot().setOnClickListener(new B(this));
        a4().f22314z.f22261e.setTypeface(aVar2.w());
        a4().f22314z.f22261e.setText(getString(R.string.preference_notifications));
        a4().f22314z.f22260d.setTypeface(aVar2.x());
        if (aVar3.a0(this)) {
            a4().f22314z.f22260d.setText(getString(R.string.enabled));
        } else {
            a4().f22314z.f22260d.setText(getString(R.string.disabled));
        }
        a4().f22314z.f22259c.setOnCheckedChangeListener(new C(this));
        a4().f22287E.f23699d.setTypeface(aVar2.w());
        a4().f22287E.f23699d.setText(getString(R.string.updates));
        a4().f22287E.f23698c.setTypeface(aVar2.x());
        a4().f22287E.f23698c.setText(c4());
        a4().f22287E.getRoot().setOnClickListener(new D(this, X2.M.j(y.a(1, getString(R.string.answer_always)), y.a(2, getString(R.string.answer_daily)), y.a(3, getString(R.string.answer_weekly)), y.a(4, getString(R.string.answer_never)))));
        a4().f22298j.getRoot().setOnClickListener(new E(this));
        a4().f22298j.f22261e.setTypeface(aVar2.w());
        a4().f22298j.f22261e.setText(getString(R.string.downloads_title));
        a4().f22298j.f22260d.setTypeface(aVar2.x());
        a4().f22298j.f22260d.setText(getString(R.string.downloads_notification_permission_description));
        a4().f22298j.f22259c.setChecked(aVar3.S(this));
        a4().f22298j.f22259c.setOnCheckedChangeListener(new G(this));
        a4().f22302n.getRoot().setOnClickListener(new H(this));
        a4().f22302n.f22261e.setTypeface(aVar2.w());
        a4().f22302n.f22261e.setText(getString(R.string.installations));
        a4().f22302n.f22260d.setTypeface(aVar2.x());
        a4().f22302n.f22260d.setText(getString(R.string.installs_notification_permission_description));
        a4().f22302n.f22259c.setChecked(aVar3.Z(this));
        a4().f22302n.f22259c.setOnCheckedChangeListener(new I(this));
        if (M.f26506a.a(this)) {
            S4();
            a4().f22314z.f22259c.setChecked(true);
        } else {
            d4();
            a4().f22314z.f22259c.setChecked(false);
        }
        J j5 = new J();
        String string = getString(R.string.internal_storage);
        t.d(string, "getString(...)");
        if (!aVar3.e0(this)) {
            string = getString(R.string.internal_storage);
            j5.f24688a = 0;
        } else if (aVar3.d0(this)) {
            string = getString(R.string.sd_card);
            j5.f24688a = 1;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(0, getString(R.string.internal_memory_free, new Object[]{new C2291k().d(new z2.E().h(this).getFreeSpace(), this)}));
        ArrayList c5 = new C2277I().c(this);
        if (!c5.isEmpty()) {
            hashMap.put(1, getString(R.string.sd_card_free, new Object[]{new C2291k().d(((g) c5.get(0)).a(), this)}));
        }
        if (hashMap.size() > 1) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry entry : hashMap.entrySet()) {
                hashMap2.put(entry.getKey(), entry.getValue());
            }
            C2451z0 c6 = C2451z0.c(getLayoutInflater());
            t.d(c6, "inflate(...)");
            c6.f23699d.setTypeface(k.f32g.w());
            c6.f23699d.setText(getString(R.string.download_path));
            c6.f23698c.setText(string);
            c6.getRoot().setOnClickListener(new Q1.J(this, hashMap2, j5, c6));
            a4().f22304p.addView(c6.getRoot(), a4().f22304p.indexOfChild(a4().f22301m.getRoot()));
        }
        TextView textView3 = a4().f22309u.f23669b;
        k.a aVar4 = k.f32g;
        textView3.setTypeface(aVar4.w());
        a4().f22309u.f23669b.setText(getString(R.string.preference_privacy_and_security));
        a4().f22310v.f23683e.setTypeface(aVar4.w());
        a4().f22310v.f23683e.setText(getString(R.string.gdpr_title));
        a4().f22310v.getRoot().setOnClickListener(new K(this));
        if (!a.f15150a.W(this)) {
            a4().f22310v.getRoot().setVisibility(8);
        }
        a4().f22293e.f23683e.setTypeface(aVar4.w());
        a4().f22293e.f23683e.setText(getString(R.string.advanced_settings));
        a4().f22293e.getRoot().setOnClickListener(new Q1.M(this));
        a4().f22305q.f23669b.setTypeface(aVar4.w());
        a4().f22305q.f23669b.setText(getString(R.string.app_detail_more_info_title));
        a4().f22284B.f23683e.setTypeface(aVar4.w());
        a4().f22284B.f23683e.setText(getString(R.string.preference_tos_and_pp));
        a4().f22284B.getRoot().setOnClickListener(new N(this));
        a4().f22299k.f23683e.setTypeface(aVar4.w());
        a4().f22299k.f23683e.setText(getString(R.string.feedback));
        a4().f22299k.getRoot().setOnClickListener(new O(this));
        a4().f22292d.f23683e.setTypeface(aVar4.w());
        a4().f22292d.f23683e.setText(getString(R.string.advertising));
        a4().f22292d.getRoot().setOnClickListener(new P(this));
        a4().f22290b.f23683e.setTypeface(aVar4.w());
        a4().f22290b.f23683e.setText(getString(R.string.about));
        a4().f22290b.getRoot().setOnClickListener(new Q1.Q(this));
        a4().f22291c.f23683e.setTypeface(aVar4.w());
        a4().f22291c.f23683e.setText(getString(R.string.about_uptodown));
        a4().f22291c.getRoot().setOnClickListener(new T(this));
    }
}
