package com.finazzi.distquake;

import android.app.NotificationManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.provider.Settings;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.C0768d;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.app.b;
import androidx.core.content.a;
import androidx.core.view.C0832r0;
import com.google.common.util.concurrent.f;
import java.util.concurrent.atomic.AtomicBoolean;
import u2.H3;
import u2.I3;
import u2.J3;
import u2.K3;
import u2.L3;
import u2.N3;
import u2.O3;
import u2.P3;
import u2.Q3;
import u2.R3;
import u2.S3;
import u2.T3;
import u2.U3;
import u2.V3;

public class ProblemsActivity extends C0768d {
    public static /* synthetic */ void e0(ProblemsActivity problemsActivity, View view) {
        problemsActivity.getClass();
        if (b.i(problemsActivity, "android.permission.ACCESS_FINE_LOCATION")) {
            b.f(problemsActivity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
            return;
        }
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", problemsActivity.getPackageName(), (String) null));
        problemsActivity.startActivity(intent);
    }

    public static /* synthetic */ void f0(ProblemsActivity problemsActivity, View view) {
        problemsActivity.getClass();
        Intent intent = new Intent();
        intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
        intent.putExtra("android.provider.extra.APP_PACKAGE", problemsActivity.getPackageName());
        problemsActivity.startActivity(intent);
    }

    public static /* synthetic */ void g0(ProblemsActivity problemsActivity, View view) {
        problemsActivity.getClass();
        problemsActivity.startActivity(new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS", Uri.parse("package:" + problemsActivity.getPackageName())));
    }

    public static /* synthetic */ void h0(ProblemsActivity problemsActivity, View view) {
        problemsActivity.getClass();
        if (b.i(problemsActivity, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
            b.f(problemsActivity, new String[]{"android.permission.ACCESS_BACKGROUND_LOCATION"}, 1);
            return;
        }
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", problemsActivity.getPackageName(), (String) null));
        problemsActivity.startActivity(intent);
    }

    public static /* synthetic */ void i0(ProblemsActivity problemsActivity, View view) {
        problemsActivity.getClass();
        problemsActivity.startActivityForResult(androidx.core.content.b.a(problemsActivity, "com.finazzi.distquake"), 1919);
    }

    public static /* synthetic */ void j0(ProblemsActivity problemsActivity, View view) {
        problemsActivity.getClass();
        if (b.i(problemsActivity, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
            b.f(problemsActivity, new String[]{"android.permission.ACCESS_BACKGROUND_LOCATION"}, 1);
            return;
        }
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", problemsActivity.getPackageName(), (String) null));
        problemsActivity.startActivity(intent);
    }

    public static /* synthetic */ void k0(ProblemsActivity problemsActivity, View view) {
        problemsActivity.getClass();
        if (b.i(problemsActivity, "android.permission.ACCESS_FINE_LOCATION")) {
            b.f(problemsActivity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
            return;
        }
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", problemsActivity.getPackageName(), (String) null));
        problemsActivity.startActivity(intent);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ad  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void l0(com.finazzi.distquake.ProblemsActivity r4, com.google.common.util.concurrent.f r5, java.util.concurrent.atomic.AtomicBoolean r6, java.util.concurrent.atomic.AtomicBoolean r7) {
        /*
            r0 = 1
            r1 = 0
            r4.getClass()
            java.lang.Object r5 = r5.get()     // Catch:{ ExecutionException -> 0x001d, InterruptedException -> 0x001b }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ ExecutionException -> 0x001d, InterruptedException -> 0x001b }
            int r5 = r5.intValue()     // Catch:{ ExecutionException -> 0x001d, InterruptedException -> 0x001b }
            r2 = 3
            if (r5 == r2) goto L_0x0019
            r2 = 4
            if (r5 == r2) goto L_0x0019
            r2 = 5
            if (r5 == r2) goto L_0x0019
            goto L_0x0021
        L_0x0019:
            r5 = r0
            goto L_0x0022
        L_0x001b:
            r5 = move-exception
            goto L_0x001e
        L_0x001d:
            r5 = move-exception
        L_0x001e:
            r5.printStackTrace()
        L_0x0021:
            r5 = r1
        L_0x0022:
            r2 = 2131296450(0x7f0900c2, float:1.8210817E38)
            android.view.View r2 = r4.findViewById(r2)
            androidx.cardview.widget.CardView r2 = (androidx.cardview.widget.CardView) r2
            if (r5 == 0) goto L_0x00ad
            r2.setVisibility(r1)
            int r5 = android.os.Build.VERSION.SDK_INT
            r2 = 30
            if (r5 > r2) goto L_0x003e
            r5 = 2131886631(0x7f120227, float:1.9407846E38)
            java.lang.String r5 = r4.getString(r5)
            goto L_0x005d
        L_0x003e:
            r2 = 32
            if (r5 > r2) goto L_0x004a
            r5 = 2131886632(0x7f120228, float:1.9407848E38)
            java.lang.String r5 = r4.getString(r5)
            goto L_0x005d
        L_0x004a:
            r2 = 34
            if (r5 > r2) goto L_0x0056
            r5 = 2131886635(0x7f12022b, float:1.9407854E38)
            java.lang.String r5 = r4.getString(r5)
            goto L_0x005d
        L_0x0056:
            r5 = 2131886633(0x7f120229, float:1.940785E38)
            java.lang.String r5 = r4.getString(r5)
        L_0x005d:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "<b><font color=#ff0000>"
            r2.append(r3)
            r2.append(r5)
            java.lang.String r5 = "</font></b>"
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            r2 = 2131886634(0x7f12022a, float:1.9407852E38)
            java.lang.String r2 = r4.getString(r2)
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r1] = r5
            java.lang.String r5 = java.lang.String.format(r2, r0)
            android.text.Spanned r5 = android.text.Html.fromHtml(r5)
            r0 = 2131297071(0x7f09032f, float:1.8212077E38)
            android.view.View r0 = r4.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r0.setText(r5)
            r5 = 2131296399(0x7f09008f, float:1.8210714E38)
            android.view.View r5 = r4.findViewById(r5)
            android.widget.Button r5 = (android.widget.Button) r5
            u2.M3 r0 = new u2.M3
            r0.<init>(r4)
            r5.setOnClickListener(r0)
            r4.w0()
            r6.set(r1)
            r7.set(r1)
            goto L_0x00b2
        L_0x00ad:
            r4 = 8
            r2.setVisibility(r4)
        L_0x00b2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.ProblemsActivity.l0(com.finazzi.distquake.ProblemsActivity, com.google.common.util.concurrent.f, java.util.concurrent.atomic.AtomicBoolean, java.util.concurrent.atomic.AtomicBoolean):void");
    }

    public static /* synthetic */ void m0(ProblemsActivity problemsActivity, View view) {
        problemsActivity.getClass();
        Intent intent = new Intent();
        intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
        intent.setFlags(268435456);
        problemsActivity.startActivity(intent);
    }

    public static /* synthetic */ void n0(ProblemsActivity problemsActivity, View view) {
        problemsActivity.getClass();
        if (b.i(problemsActivity, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
            b.f(problemsActivity, new String[]{"android.permission.ACCESS_BACKGROUND_LOCATION"}, 1);
            return;
        }
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", problemsActivity.getPackageName(), (String) null));
        problemsActivity.startActivity(intent);
    }

    public static /* synthetic */ void o0(ProblemsActivity problemsActivity, View view) {
        problemsActivity.getClass();
        if (b.i(problemsActivity, "android.permission.ACCESS_FINE_LOCATION")) {
            b.f(problemsActivity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
            return;
        }
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", problemsActivity.getPackageName(), (String) null));
        problemsActivity.startActivity(intent);
    }

    public static /* synthetic */ void p0(ProblemsActivity problemsActivity, View view) {
        problemsActivity.getClass();
        problemsActivity.startActivity(new Intent("android.settings.MANAGE_APP_USE_FULL_SCREEN_INTENT", Uri.parse("package:" + problemsActivity.getPackageName())));
    }

    public static /* synthetic */ void q0(ProblemsActivity problemsActivity, View view) {
        problemsActivity.getClass();
        problemsActivity.startActivity(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + problemsActivity.getPackageName())));
    }

    public static /* synthetic */ void r0(ProblemsActivity problemsActivity, View view) {
        problemsActivity.getClass();
        if (b.i(problemsActivity, "android.permission.ACCESS_FINE_LOCATION")) {
            b.f(problemsActivity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
            return;
        }
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", problemsActivity.getPackageName(), (String) null));
        problemsActivity.startActivity(intent);
    }

    public static /* synthetic */ void s0(ProblemsActivity problemsActivity, View view) {
        problemsActivity.getClass();
        if (b.i(problemsActivity, "android.permission.ACCESS_FINE_LOCATION")) {
            b.f(problemsActivity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
            return;
        }
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", problemsActivity.getPackageName(), (String) null));
        problemsActivity.startActivity(intent);
    }

    private boolean t0() {
        int i8;
        try {
            i8 = Settings.Secure.getInt(getContentResolver(), "location_mode");
        } catch (Settings.SettingNotFoundException unused) {
            i8 = 0;
        }
        if (i8 != 0) {
            return true;
        }
        return false;
    }

    private void u0() {
        ((LinearLayout) findViewById(C2030R.id.layoutMandatory)).setVisibility(8);
        ((LinearLayout) findViewById(C2030R.id.layoutSuggested)).setVisibility(8);
        ((TextView) findViewById(C2030R.id.textView1)).setVisibility(8);
        ((TextView) findViewById(C2030R.id.textView7)).setVisibility(0);
        ((NotificationManager) getApplicationContext().getSystemService("notification")).cancel(999000);
    }

    private void v0() {
        ((LinearLayout) findViewById(C2030R.id.layoutMandatory)).setVisibility(0);
        ((TextView) findViewById(C2030R.id.textView7)).setVisibility(8);
    }

    private void w0() {
        ((LinearLayout) findViewById(C2030R.id.layoutSuggested)).setVisibility(0);
        ((TextView) findViewById(C2030R.id.textView7)).setVisibility(8);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2030R.layout.problems_card);
        int i8 = getResources().getConfiguration().uiMode & 48;
        if (Build.VERSION.SDK_INT >= 35 && i8 == 16) {
            Window window = getWindow();
            C0832r0.a(window, window.getDecorView()).d(true);
        }
        boolean z7 = getSharedPreferences(MainActivity.class.getSimpleName(), 0).getBoolean("pro_features", false);
        Toolbar toolbar = (Toolbar) findViewById(C2030R.id.toolbar);
        b0(toolbar);
        if (!z7) {
            toolbar.setLogo(2131230872);
        } else {
            toolbar.setLogo(2131230875);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        int i8;
        super.onResume();
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(true);
        AtomicBoolean atomicBoolean3 = new AtomicBoolean(true);
        CardView cardView = (CardView) findViewById(C2030R.id.cardNoLocation);
        if (!t0()) {
            cardView.setVisibility(0);
            ((TextView) findViewById(C2030R.id.textView2)).setText(getString(C2030R.string.main_nogeo));
            ((Button) findViewById(C2030R.id.button1)).setOnClickListener(new N3(this));
            v0();
            atomicBoolean.set(false);
            atomicBoolean2.set(false);
        } else {
            int i9 = Build.VERSION.SDK_INT;
            if (i9 >= 31) {
                if (a.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") != 0 && a.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
                    cardView.setVisibility(0);
                    ((TextView) findViewById(C2030R.id.textView2)).setText(getString(C2030R.string.permission_location_no));
                    ((Button) findViewById(C2030R.id.button1)).setOnClickListener(new U3(this));
                    v0();
                    atomicBoolean.set(false);
                    atomicBoolean2.set(false);
                } else if (a.checkSelfPermission(this, "android.permission.ACCESS_BACKGROUND_LOCATION") != 0) {
                    cardView.setVisibility(0);
                    String charSequence = getPackageManager().getBackgroundPermissionOptionLabel().toString();
                    ((TextView) findViewById(C2030R.id.textView2)).setText(Html.fromHtml(String.format(getString(C2030R.string.permission_location_rationale_12_background), new Object[]{getString(C2030R.string.app_name), getString(C2030R.string.app_name), "<b><font color=#ff0000>" + charSequence + "</font></b>", "<b><font color=#ff0000>" + getString(C2030R.string.permission_location_rationale_12_precise_details) + "</font></b>"})));
                    ((Button) findViewById(C2030R.id.button1)).setOnClickListener(new V3(this));
                    v0();
                    atomicBoolean.set(false);
                    atomicBoolean2.set(false);
                } else if (a.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || a.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
                    cardView.setVisibility(8);
                } else {
                    cardView.setVisibility(0);
                    ((TextView) findViewById(C2030R.id.textView2)).setText(Html.fromHtml(String.format(getString(C2030R.string.permission_location_rationale_12_precise), new Object[]{"<b><font color=#ff0000>" + getString(C2030R.string.permission_location_rationale_12_precise_details) + "</font></b>"})));
                    ((Button) findViewById(C2030R.id.button1)).setOnClickListener(new H3(this));
                    v0();
                    atomicBoolean.set(false);
                    atomicBoolean2.set(false);
                }
            } else if (i9 == 30) {
                if (a.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") != 0) {
                    cardView.setVisibility(0);
                    ((TextView) findViewById(C2030R.id.textView2)).setText(getString(C2030R.string.permission_location_no));
                    ((Button) findViewById(C2030R.id.button1)).setOnClickListener(new I3(this));
                    v0();
                    atomicBoolean.set(false);
                    atomicBoolean2.set(false);
                } else if (a.checkSelfPermission(this, "android.permission.ACCESS_BACKGROUND_LOCATION") != 0) {
                    cardView.setVisibility(0);
                    ((TextView) findViewById(C2030R.id.textView2)).setText(Html.fromHtml(String.format(getString(C2030R.string.permission_location_rationale_11_background), new Object[]{getString(C2030R.string.app_name), getString(C2030R.string.app_name), "<b><font color=#ff0000>" + getPackageManager().getBackgroundPermissionOptionLabel().toString() + "</font></b>"})));
                    ((Button) findViewById(C2030R.id.button1)).setOnClickListener(new J3(this));
                    v0();
                    atomicBoolean.set(false);
                    atomicBoolean2.set(false);
                } else {
                    cardView.setVisibility(8);
                }
            } else if (i9 == 29) {
                if (a.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") != 0) {
                    cardView.setVisibility(0);
                    ((TextView) findViewById(C2030R.id.textView2)).setText(getString(C2030R.string.permission_location_no));
                    ((Button) findViewById(C2030R.id.button1)).setOnClickListener(new K3(this));
                    v0();
                    atomicBoolean.set(false);
                    atomicBoolean2.set(false);
                } else if (a.checkSelfPermission(this, "android.permission.ACCESS_BACKGROUND_LOCATION") != 0) {
                    cardView.setVisibility(0);
                    ((TextView) findViewById(C2030R.id.textView2)).setText(getString(C2030R.string.permission_location_no_background));
                    ((Button) findViewById(C2030R.id.button1)).setOnClickListener(new L3(this));
                    v0();
                    atomicBoolean.set(false);
                    atomicBoolean2.set(false);
                } else {
                    cardView.setVisibility(8);
                }
            } else if (a.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") != 0) {
                cardView.setVisibility(0);
                ((TextView) findViewById(C2030R.id.textView2)).setText(getString(C2030R.string.permission_location_no));
                ((Button) findViewById(C2030R.id.button1)).setOnClickListener(new O3(this));
                v0();
                atomicBoolean.set(false);
                atomicBoolean2.set(false);
            } else {
                cardView.setVisibility(8);
            }
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26) {
            CardView cardView2 = (CardView) findViewById(C2030R.id.cardNotificationsDisabled);
            if (!((NotificationManager) getSystemService("notification")).areNotificationsEnabled()) {
                cardView2.setVisibility(0);
                ((Button) findViewById(C2030R.id.button5)).setOnClickListener(new P3(this));
                v0();
                atomicBoolean.set(false);
                atomicBoolean2.set(false);
            } else {
                cardView2.setVisibility(8);
            }
        }
        f c8 = androidx.core.content.f.c(this);
        c8.addListener(new Q3(this, c8, atomicBoolean, atomicBoolean3), a.getMainExecutor(this));
        CardView cardView3 = (CardView) findViewById(C2030R.id.cardNoOverlay);
        if (!Settings.canDrawOverlays(getApplicationContext())) {
            cardView3.setVisibility(0);
            ((Button) findViewById(C2030R.id.button4)).setOnClickListener(new R3(this));
            v0();
            atomicBoolean.set(false);
            atomicBoolean3.set(false);
        } else {
            cardView3.setVisibility(8);
        }
        CardView cardView4 = (CardView) findViewById(C2030R.id.cardBattery);
        if (!((PowerManager) getSystemService("power")).isIgnoringBatteryOptimizations(getApplicationContext().getPackageName())) {
            cardView4.setVisibility(0);
            v0();
            atomicBoolean.set(false);
            atomicBoolean2.set(false);
            ((Button) findViewById(C2030R.id.button7)).setOnClickListener(new S3(this));
        } else {
            cardView4.setVisibility(8);
        }
        if (i10 >= 34 && !((NotificationManager) getSystemService("notification")).canUseFullScreenIntent()) {
            ((CardView) findViewById(C2030R.id.cardFullScreenNotification)).setVisibility(0);
            ((Button) findViewById(C2030R.id.button6)).setOnClickListener(new T3(this));
            w0();
            atomicBoolean.set(false);
            atomicBoolean3.set(false);
        }
        if (atomicBoolean.get()) {
            u0();
        }
        if (atomicBoolean2.get()) {
            i8 = 8;
            ((LinearLayout) findViewById(C2030R.id.layoutMandatory)).setVisibility(8);
        } else {
            i8 = 8;
        }
        if (atomicBoolean3.get()) {
            ((LinearLayout) findViewById(C2030R.id.layoutSuggested)).setVisibility(i8);
        }
    }
}
