package com.finazzi.distquake;

import P1.C0624o;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.C0768d;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.C0832r0;
import com.android.billingclient.api.C1050a;
import com.android.billingclient.api.C1052c;
import com.android.billingclient.api.C1053d;
import com.android.billingclient.api.C1055f;
import com.android.billingclient.api.C1056g;
import com.android.billingclient.api.Purchase;
import com.google.android.material.button.MaterialButton;
import com.google.common.collect.k;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Iterator;
import java.util.List;
import m1.C1587a;
import m1.C1594h;
import m1.m;
import u2.F4;
import u2.G4;
import u2.H4;
import u2.I4;

public class ToProActivity extends C0768d implements m {

    /* renamed from: O  reason: collision with root package name */
    private String f13540O;
    /* access modifiers changed from: private */

    /* renamed from: P  reason: collision with root package name */
    public boolean f13541P;
    /* access modifiers changed from: private */

    /* renamed from: Q  reason: collision with root package name */
    public boolean f13542Q = false;

    /* renamed from: R  reason: collision with root package name */
    private boolean f13543R;
    /* access modifiers changed from: private */

    /* renamed from: S  reason: collision with root package name */
    public C1050a f13544S;
    /* access modifiers changed from: private */

    /* renamed from: T  reason: collision with root package name */
    public String f13545T;
    /* access modifiers changed from: private */

    /* renamed from: U  reason: collision with root package name */
    public long f13546U;

    class a implements C1594h {
        a() {
        }

        public static /* synthetic */ void c(a aVar, C1053d dVar, List list) {
            C1055f.b a8;
            aVar.getClass();
            if (list.size() > 0) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    C1055f fVar = (C1055f) it.next();
                    if (ToProActivity.this.f13541P && (a8 = fVar.a()) != null) {
                        String a9 = a8.a();
                        long unused = ToProActivity.this.f13546U = a8.b();
                        String unused2 = ToProActivity.this.f13545T = a8.c();
                        ((MaterialButton) ToProActivity.this.findViewById(C2030R.id.button1)).setText(ToProActivity.this.getString(C2030R.string.network_pro_convert) + " " + a9 + " " + ToProActivity.this.getString(C2030R.string.inapp_onetime));
                    }
                }
            }
        }

        public void a(C1053d dVar) {
            if (dVar.b() == 0) {
                boolean unused = ToProActivity.this.f13542Q = true;
                ToProActivity.this.f13544S.d(C1056g.a().b(k.t(C1056g.b.a().b("pro").c("inapp").a())).a(), new c0(this));
            }
        }

        public void b() {
            boolean unused = ToProActivity.this.f13542Q = false;
        }
    }

    private class b extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private final String f13548a;

        /* renamed from: b  reason: collision with root package name */
        private final String f13549b;

        /* renamed from: c  reason: collision with root package name */
        private final String f13550c;

        /* renamed from: d  reason: collision with root package name */
        private final String f13551d;

        /* renamed from: e  reason: collision with root package name */
        private int f13552e;

        b(String str, String str2, String str3, String str4) {
            this.f13548a = str;
            this.f13549b = str2;
            this.f13550c = str3;
            this.f13551d = str4;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x00cc A[Catch:{ all -> 0x00c3 }] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x00d7  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x00df  */
        /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r6) {
            /*
                r5 = this;
                java.util.HashMap r6 = new java.util.HashMap
                r6.<init>()
                java.lang.String r0 = "u_id"
                java.lang.String r1 = r5.f13548a
                r6.put(r0, r1)
                java.lang.String r0 = "token_sub"
                java.lang.String r1 = r5.f13549b
                r6.put(r0, r1)
                java.lang.String r0 = "wallet_sub"
                java.lang.String r1 = r5.f13550c
                r6.put(r0, r1)
                java.lang.String r0 = "sku"
                java.lang.String r1 = r5.f13551d
                r6.put(r0, r1)
                java.lang.String r6 = u2.C1737L.a(r6)
                r0 = 0
                java.net.URL r1 = new java.net.URL     // Catch:{ IOException -> 0x00c5 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00c5 }
                r2.<init>()     // Catch:{ IOException -> 0x00c5 }
                com.finazzi.distquake.ToProActivity r3 = com.finazzi.distquake.ToProActivity.this     // Catch:{ IOException -> 0x00c5 }
                r4 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r3 = r3.getString(r4)     // Catch:{ IOException -> 0x00c5 }
                r2.append(r3)     // Catch:{ IOException -> 0x00c5 }
                java.lang.String r3 = "distquake_upload_pro_upgraded.php"
                r2.append(r3)     // Catch:{ IOException -> 0x00c5 }
                java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x00c5 }
                r1.<init>(r2)     // Catch:{ IOException -> 0x00c5 }
                java.net.URLConnection r1 = r1.openConnection()     // Catch:{ IOException -> 0x00c5 }
                java.lang.Object r1 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r1)     // Catch:{ IOException -> 0x00c5 }
                java.net.URLConnection r1 = (java.net.URLConnection) r1     // Catch:{ IOException -> 0x00c5 }
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ IOException -> 0x00c5 }
                r0 = 1
                r1.setDoOutput(r0)     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                r2 = 10000(0x2710, float:1.4013E-41)
                r1.setConnectTimeout(r2)     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                r1.setReadTimeout(r2)     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                java.lang.String r2 = "Content-Type"
                java.lang.String r3 = "application/x-www-form-urlencoded;charset=utf-8"
                r1.setRequestProperty(r2, r3)     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                java.lang.String r2 = "POST"
                r1.setRequestMethod(r2)     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                byte[] r2 = r6.getBytes()     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                int r2 = r2.length     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                r1.setFixedLengthStreamingMode(r2)     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                java.io.PrintWriter r2 = new java.io.PrintWriter     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                java.io.OutputStream r3 = r1.getOutputStream()     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                r2.<init>(r3)     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                r2.print(r6)     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                r2.close()     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                java.io.BufferedInputStream r6 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                java.io.InputStream r2 = r1.getInputStream()     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                r6.<init>(r2)     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                r3.<init>(r6, r4)     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                r2.<init>(r3)     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                r3.<init>()     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
            L_0x009a:
                java.lang.String r4 = r2.readLine()     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                if (r4 == 0) goto L_0x00aa
                r3.append(r4)     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                goto L_0x009a
            L_0x00a4:
                r6 = move-exception
                r0 = r1
                goto L_0x00dd
            L_0x00a7:
                r6 = move-exception
                r0 = r1
                goto L_0x00c6
            L_0x00aa:
                r6.close()     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                java.lang.String r6 = r3.toString()     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                java.lang.String r2 = "ok"
                boolean r6 = r6.equals(r2)     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                if (r6 == 0) goto L_0x00bd
                r6 = 0
                r5.f13552e = r6     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                goto L_0x00bf
            L_0x00bd:
                r5.f13552e = r0     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
            L_0x00bf:
                r1.disconnect()
                goto L_0x00da
            L_0x00c3:
                r6 = move-exception
                goto L_0x00dd
            L_0x00c5:
                r6 = move-exception
            L_0x00c6:
                java.lang.String r1 = r6.getMessage()     // Catch:{ all -> 0x00c3 }
                if (r1 == 0) goto L_0x00d5
                java.lang.String r1 = "EQN"
                java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x00c3 }
                android.util.Log.d(r1, r6)     // Catch:{ all -> 0x00c3 }
            L_0x00d5:
                if (r0 == 0) goto L_0x00da
                r0.disconnect()
            L_0x00da:
                java.lang.String r6 = "COMPLETE!"
                return r6
            L_0x00dd:
                if (r0 == 0) goto L_0x00e2
                r0.disconnect()
            L_0x00e2:
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.ToProActivity.b.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            boolean z7 = false;
            SharedPreferences.Editor edit = ToProActivity.this.getSharedPreferences("no_backup_pref", 0).edit();
            if (this.f13552e != 0) {
                z7 = true;
            }
            edit.putBoolean("update_server2", z7);
            edit.apply();
        }
    }

    public static /* synthetic */ void e0(ToProActivity toProActivity, View view) {
        toProActivity.getClass();
        Intent intent = new Intent().setClass(toProActivity, InAppActivity.class);
        intent.putExtra("show_map_button", true);
        toProActivity.startActivity(intent);
    }

    public static /* synthetic */ void f0(ToProActivity toProActivity, View view) {
        if (!toProActivity.n0()) {
            Toast makeText = Toast.makeText(toProActivity.getApplicationContext(), toProActivity.getString(C2030R.string.main_nointernet), 1);
            makeText.setGravity(17, 0, 0);
            makeText.show();
        } else if (toProActivity.f13540O.equals("0")) {
            Toast makeText2 = Toast.makeText(toProActivity.getApplicationContext(), toProActivity.getString(C2030R.string.main_device_not_supported), 1);
            makeText2.setGravity(17, 0, 0);
            makeText2.show();
        } else if (toProActivity.f13542Q) {
            toProActivity.f13544S.d(C1056g.a().b(k.t(C1056g.b.a().b("pro").c("inapp").a())).a(), new I4(toProActivity));
        } else {
            Toast makeText3 = Toast.makeText(toProActivity.getApplicationContext(), toProActivity.getString(C2030R.string.network_wrong), 1);
            makeText3.setGravity(17, 0, 0);
            makeText3.show();
        }
    }

    public static /* synthetic */ void g0(ToProActivity toProActivity, SharedPreferences.Editor editor, String str, String str2, String str3, C1053d dVar) {
        toProActivity.getClass();
        if (dVar.b() == 0) {
            editor.putBoolean("pro_owned", true);
            editor.putBoolean("last_pro_owned", true);
            editor.putBoolean("pro_features", true);
            editor.apply();
            toProActivity.f13543R = true;
            ToProActivity toProActivity2 = toProActivity;
            new b(toProActivity.f13540O, str, str2, str3).execute(new Context[0]);
            C0624o e8 = C0624o.e(toProActivity2);
            e8.d(BigDecimal.valueOf(((double) toProActivity2.f13546U) / 1000000.0d), Currency.getInstance(toProActivity2.f13545T));
            e8.b();
            if (toProActivity2.f13541P) {
                ((TextView) toProActivity2.findViewById(C2030R.id.textView1)).setVisibility(0);
                ((TextView) toProActivity2.findViewById(C2030R.id.textView3)).setVisibility(8);
                ((Button) toProActivity2.findViewById(C2030R.id.button1)).setVisibility(8);
                ((Button) toProActivity2.findViewById(C2030R.id.button2)).setVisibility(8);
            }
        }
    }

    public static /* synthetic */ void h0(ToProActivity toProActivity, C1053d dVar, List list) {
        toProActivity.getClass();
        if (list.size() > 0) {
            if (toProActivity.f13544S.b(toProActivity, C1052c.a().b(k.t(C1052c.b.a().c((C1055f) list.get(0)).a())).a()).b() != 0) {
                Toast makeText = Toast.makeText(toProActivity.getApplicationContext(), toProActivity.getString(C2030R.string.network_wrong), 1);
                makeText.setGravity(17, 0, 0);
                makeText.show();
                return;
            }
            return;
        }
        Toast makeText2 = Toast.makeText(toProActivity.getApplicationContext(), toProActivity.getString(C2030R.string.network_wrong), 1);
        makeText2.setGravity(17, 0, 0);
        makeText2.show();
    }

    private boolean n0() {
        boolean z7;
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            z7 = activeNetworkInfo.isConnected();
            if (!activeNetworkInfo.isAvailable()) {
                z7 = false;
            }
        } else {
            z7 = true;
        }
        if (activeNetworkInfo == null) {
            return false;
        }
        return z7;
    }

    public void o(C1053d dVar, List list) {
        if (dVar.b() == 0 && list != null) {
            SharedPreferences.Editor edit = getSharedPreferences(MainActivity.class.getSimpleName(), 0).edit();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Purchase purchase = (Purchase) it.next();
                String str = (String) purchase.c().get(0);
                String e8 = purchase.e();
                String a8 = purchase.a();
                if (a8 != null) {
                    if (a8.length() > 24) {
                        a8 = a8.substring(0, 23);
                    }
                    edit.putString("order_id_pro", a8);
                    edit.apply();
                }
                String str2 = a8;
                if (purchase.d() == 1 && !purchase.g()) {
                    this.f13544S.a(C1587a.b().b(purchase.e()).a(), new H4(this, edit, e8, str2, str));
                }
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2030R.layout.topro_card);
        int i8 = getResources().getConfiguration().uiMode & 48;
        if (Build.VERSION.SDK_INT >= 35 && i8 == 16) {
            Window window = getWindow();
            C0832r0.a(window, window.getDecorView()).d(true);
        }
        Toolbar toolbar = (Toolbar) findViewById(C2030R.id.toolbar);
        b0(toolbar);
        toolbar.setLogo(2131230872);
        C1050a a8 = C1050a.c(this).d(this).b().a();
        this.f13544S = a8;
        a8.f(new a());
        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.class.getSimpleName(), 0);
        this.f13540O = sharedPreferences.getString("android_id_eqn", "0");
        boolean z7 = sharedPreferences.getBoolean("pro_features", false);
        this.f13543R = z7;
        if (z7) {
            ((TextView) findViewById(C2030R.id.textView1)).setVisibility(0);
            ((TextView) findViewById(C2030R.id.textView3)).setVisibility(8);
            ((Button) findViewById(C2030R.id.button1)).setVisibility(8);
            ((Button) findViewById(C2030R.id.button2)).setVisibility(8);
            return;
        }
        ((TextView) findViewById(C2030R.id.textView1)).setVisibility(8);
        ((TextView) findViewById(C2030R.id.textView3)).setVisibility(0);
        Button button = (Button) findViewById(C2030R.id.button1);
        button.setVisibility(0);
        button.setOnClickListener(new F4(this));
        Button button2 = (Button) findViewById(C2030R.id.button2);
        button2.setVisibility(0);
        button2.setOnClickListener(new G4(this));
    }

    public void onPause() {
        super.onPause();
        this.f13541P = false;
    }

    public void onResume() {
        super.onResume();
        this.f13541P = true;
    }
}
