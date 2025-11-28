package com.finazzi.distquake;

import P1.C0624o;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.common.collect.k;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.Iterator;
import java.util.List;
import m1.C1587a;
import m1.C1594h;
import m1.m;
import u2.A1;
import u2.B1;
import u2.C1;
import u2.D1;
import u2.E1;
import u2.F1;
import u2.G1;
import u2.H1;

public class InAppActivity extends C0768d implements m {

    /* renamed from: O  reason: collision with root package name */
    private final ArrayList f13231O = new ArrayList();

    /* renamed from: P  reason: collision with root package name */
    private final ArrayList f13232P = new ArrayList();

    /* renamed from: Q  reason: collision with root package name */
    private final ArrayList f13233Q = new ArrayList();

    /* renamed from: R  reason: collision with root package name */
    private final ArrayList f13234R = new ArrayList();

    /* renamed from: S  reason: collision with root package name */
    private final ArrayList f13235S = new ArrayList();

    /* renamed from: T  reason: collision with root package name */
    private final ArrayList f13236T = new ArrayList();

    /* renamed from: U  reason: collision with root package name */
    private String f13237U = "top_10k_v2";

    /* renamed from: V  reason: collision with root package name */
    private String f13238V;

    /* renamed from: W  reason: collision with root package name */
    private C1050a f13239W;
    /* access modifiers changed from: private */

    /* renamed from: X  reason: collision with root package name */
    public boolean f13240X;

    /* renamed from: Y  reason: collision with root package name */
    private boolean f13241Y = false;

    /* renamed from: Z  reason: collision with root package name */
    private boolean f13242Z = false;

    class a implements C1594h {
        a() {
        }

        public void a(C1053d dVar) {
            if (dVar.b() == 0) {
                boolean unused = InAppActivity.this.f13240X = true;
                InAppActivity.this.o0();
            }
        }

        public void b() {
            boolean unused = InAppActivity.this.f13240X = false;
        }
    }

    private class b extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private final String f13244a;

        /* renamed from: b  reason: collision with root package name */
        private final String f13245b;

        /* renamed from: c  reason: collision with root package name */
        private final String f13246c;

        /* renamed from: d  reason: collision with root package name */
        private final String f13247d;

        /* renamed from: e  reason: collision with root package name */
        private int f13248e;

        b(String str, String str2, String str3, String str4) {
            this.f13244a = str;
            this.f13245b = str2;
            this.f13246c = str3;
            this.f13247d = str4;
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
                java.lang.String r1 = r5.f13244a
                r6.put(r0, r1)
                java.lang.String r0 = "token_sub"
                java.lang.String r1 = r5.f13245b
                r6.put(r0, r1)
                java.lang.String r0 = "wallet_sub"
                java.lang.String r1 = r5.f13246c
                r6.put(r0, r1)
                java.lang.String r0 = "sku"
                java.lang.String r1 = r5.f13247d
                r6.put(r0, r1)
                java.lang.String r6 = u2.C1737L.a(r6)
                r0 = 0
                java.net.URL r1 = new java.net.URL     // Catch:{ IOException -> 0x00c5 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00c5 }
                r2.<init>()     // Catch:{ IOException -> 0x00c5 }
                com.finazzi.distquake.InAppActivity r3 = com.finazzi.distquake.InAppActivity.this     // Catch:{ IOException -> 0x00c5 }
                r4 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r3 = r3.getString(r4)     // Catch:{ IOException -> 0x00c5 }
                r2.append(r3)     // Catch:{ IOException -> 0x00c5 }
                java.lang.String r3 = "distquake_upload_subscription.php"
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
                r5.f13248e = r6     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                goto L_0x00bf
            L_0x00bd:
                r5.f13248e = r0     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
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
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.InAppActivity.b.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            boolean z7 = false;
            SharedPreferences.Editor edit = InAppActivity.this.getSharedPreferences("no_backup_pref", 0).edit();
            if (this.f13248e != 0) {
                z7 = true;
            }
            edit.putBoolean("update_server2", z7);
            edit.apply();
        }
    }

    public static /* synthetic */ void f0(InAppActivity inAppActivity, View view) {
        String str;
        C1056g gVar;
        String str2;
        int checkedRadioButtonId = ((RadioGroup) inAppActivity.findViewById(C2030R.id.radioGroup2)).getCheckedRadioButtonId();
        if (checkedRadioButtonId == C2030R.id.radioButton3) {
            inAppActivity.f13237U = (String) ((RadioButton) inAppActivity.findViewById(C2030R.id.radioButton3)).getTag();
        } else if (checkedRadioButtonId == C2030R.id.radioButton4) {
            inAppActivity.f13237U = (String) ((RadioButton) inAppActivity.findViewById(C2030R.id.radioButton4)).getTag();
        } else if (checkedRadioButtonId == C2030R.id.radioButton5) {
            inAppActivity.f13237U = (String) ((RadioButton) inAppActivity.findViewById(C2030R.id.radioButton5)).getTag();
        }
        if (!inAppActivity.r0()) {
            Toast makeText = Toast.makeText(inAppActivity.getApplicationContext(), inAppActivity.getString(C2030R.string.main_nointernet), 1);
            makeText.setGravity(17, 0, 0);
            makeText.show();
        } else if (inAppActivity.f13238V.equals("0")) {
            Toast makeText2 = Toast.makeText(inAppActivity.getApplicationContext(), inAppActivity.getString(C2030R.string.main_device_not_supported), 1);
            makeText2.setGravity(17, 0, 0);
            makeText2.show();
        } else if (!inAppActivity.f13240X || (str = inAppActivity.f13237U) == null) {
            Toast makeText3 = Toast.makeText(inAppActivity.getApplicationContext(), inAppActivity.getString(C2030R.string.inapp_wrong), 1);
            makeText3.setGravity(17, 0, 0);
            makeText3.show();
        } else {
            if (str.contains("lifetime")) {
                str2 = "inapp";
                gVar = C1056g.a().b(k.t(C1056g.b.a().b(inAppActivity.f13237U).c(str2).a())).a();
            } else {
                str2 = "subs";
                gVar = C1056g.a().b(k.t(C1056g.b.a().b(inAppActivity.f13237U).c(str2).a())).a();
            }
            inAppActivity.f13239W.d(gVar, new F1(inAppActivity, str2));
        }
    }

    public static /* synthetic */ void g0(InAppActivity inAppActivity, View view) {
        inAppActivity.getClass();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://play.google.com/store/account/subscriptions"));
        inAppActivity.startActivity(intent);
    }

    public static /* synthetic */ void h0(InAppActivity inAppActivity, String str, SharedPreferences.Editor editor, String str2, String str3, C1053d dVar) {
        int i8 = 0;
        inAppActivity.getClass();
        if (dVar.b() == 0) {
            if (str.equals("top_10k_v2")) {
                inAppActivity.f13241Y = true;
                editor.putBoolean("top10k_owned", true);
                editor.apply();
            }
            if (str.equals("top_100k_v2")) {
                inAppActivity.f13242Z = true;
                editor.putBoolean("top100k_owned", true);
                editor.apply();
            }
            if (str.equals("top_10k_annual_v2")) {
                inAppActivity.f13241Y = true;
                editor.putBoolean("top10k_owned", true);
                editor.apply();
            }
            if (str.equals("top_100k_annual_v2")) {
                inAppActivity.f13242Z = true;
                editor.putBoolean("top100k_owned", true);
                editor.apply();
            }
            if (str.equals("top_10k_annual_v3")) {
                inAppActivity.f13241Y = true;
                editor.putBoolean("top10k_owned", true);
                editor.apply();
            }
            if (str.equals("top_100k_annual_v3")) {
                inAppActivity.f13242Z = true;
                editor.putBoolean("top100k_owned", true);
                editor.apply();
            }
            if (str.equals("top_10k_lifetime")) {
                inAppActivity.f13241Y = true;
                editor.putBoolean("top10k_owned", true);
                editor.apply();
            }
            if (str.equals("top_100k_lifetime")) {
                inAppActivity.f13242Z = true;
                editor.putBoolean("top100k_owned", true);
                editor.apply();
            }
            InAppActivity inAppActivity2 = inAppActivity;
            String str4 = str;
            new b(inAppActivity.f13238V, str2, str3, str4).execute(new Context[]{inAppActivity2});
            Iterator it = inAppActivity2.f13231O.iterator();
            int i9 = 0;
            while (it.hasNext()) {
                if (((String) it.next()).contains(str4)) {
                    i8 = i9;
                }
                i9++;
            }
            C0624o e8 = C0624o.e(inAppActivity2);
            e8.d(BigDecimal.valueOf(((double) ((Long) inAppActivity2.f13234R.get(i8)).longValue()) / 1000000.0d), Currency.getInstance((String) inAppActivity2.f13236T.get(i8)));
            e8.b();
        }
    }

    public static /* synthetic */ void i0(InAppActivity inAppActivity, String str, C1053d dVar, List list) {
        k kVar;
        inAppActivity.getClass();
        if (str.equals("subs")) {
            List d8 = ((C1055f) list.get(0)).d();
            if (d8 == null || d8.size() <= 0) {
                kVar = null;
            } else {
                kVar = k.t(C1052c.b.a().c((C1055f) list.get(0)).b(((C1055f.e) d8.get(0)).a()).a());
                if (inAppActivity.f13239W.b(inAppActivity, C1052c.a().b(kVar).a()).b() != 0) {
                    Toast makeText = Toast.makeText(inAppActivity.getApplicationContext(), inAppActivity.getString(C2030R.string.network_wrong), 1);
                    makeText.setGravity(17, 0, 0);
                    makeText.show();
                }
            }
        } else {
            kVar = k.t(C1052c.b.a().c((C1055f) list.get(0)).a());
        }
        if (kVar != null) {
            if (inAppActivity.f13239W.b(inAppActivity, C1052c.a().b(kVar).a()).b() != 0) {
                Toast makeText2 = Toast.makeText(inAppActivity.getApplicationContext(), inAppActivity.getString(C2030R.string.network_wrong), 1);
                makeText2.setGravity(17, 0, 0);
                makeText2.show();
                return;
            }
            return;
        }
        Toast makeText3 = Toast.makeText(inAppActivity.getApplicationContext(), inAppActivity.getString(C2030R.string.network_wrong), 1);
        makeText3.setGravity(17, 0, 0);
        makeText3.show();
    }

    public static /* synthetic */ void j0(InAppActivity inAppActivity, C1053d dVar, List list) {
        List d8;
        C1055f.e eVar;
        inAppActivity.getClass();
        if (list.size() > 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                C1055f fVar = (C1055f) it.next();
                if (fVar.c().equals("subs") && (d8 = fVar.d()) != null && d8.size() > 0 && (eVar = (C1055f.e) d8.get(0)) != null) {
                    String b8 = fVar.b();
                    String a8 = ((C1055f.c) eVar.b().a().get(0)).a();
                    long b9 = ((C1055f.c) eVar.b().a().get(0)).b();
                    String c8 = ((C1055f.c) eVar.b().a().get(0)).c();
                    if (b8.contains("annual")) {
                        ArrayList arrayList = inAppActivity.f13232P;
                        arrayList.add(a8 + inAppActivity.getString(C2030R.string.inapp_year) + " " + inAppActivity.getString(C2030R.string.inapp_bonus));
                    } else {
                        ArrayList arrayList2 = inAppActivity.f13232P;
                        arrayList2.add(a8 + inAppActivity.getString(C2030R.string.inapp_month) + " " + inAppActivity.getString(C2030R.string.inapp_bonus));
                    }
                    inAppActivity.f13231O.add(b8);
                    inAppActivity.f13235S.add("sub");
                    inAppActivity.f13233Q.add(a8);
                    inAppActivity.f13234R.add(Long.valueOf(b9));
                    inAppActivity.f13236T.add(c8);
                }
            }
        }
        inAppActivity.p0();
    }

    public static /* synthetic */ void k0(InAppActivity inAppActivity, C1053d dVar, List list) {
        C1055f.b a8;
        inAppActivity.getClass();
        if (list.size() > 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                C1055f fVar = (C1055f) it.next();
                if (fVar.c().equals("inapp") && (a8 = fVar.a()) != null) {
                    String b8 = fVar.b();
                    String a9 = a8.a();
                    long b9 = a8.b();
                    String c8 = a8.c();
                    ArrayList arrayList = inAppActivity.f13232P;
                    arrayList.add(a9 + " " + inAppActivity.getString(C2030R.string.inapp_lifetime) + " " + inAppActivity.getString(C2030R.string.inapp_bonus));
                    inAppActivity.f13231O.add(b8);
                    inAppActivity.f13235S.add("inapp");
                    inAppActivity.f13233Q.add(a9);
                    inAppActivity.f13234R.add(Long.valueOf(b9));
                    inAppActivity.f13236T.add(c8);
                }
            }
        }
    }

    public static /* synthetic */ void l0(InAppActivity inAppActivity, View view) {
        if (!inAppActivity.s0()) {
            Toast makeText = Toast.makeText(inAppActivity.getApplicationContext(), inAppActivity.getString(C2030R.string.main_areacheck_geo), 1);
            makeText.setGravity(17, 0, 0);
            makeText.show();
            return;
        }
        Intent intent = new Intent().setClass(inAppActivity.getApplicationContext(), GlobeActivityAll.class);
        intent.putExtra("com.finazzi.distquake.map_type", 3);
        inAppActivity.startActivity(intent);
    }

    /* access modifiers changed from: private */
    public void o0() {
        this.f13232P.clear();
        this.f13231O.clear();
        this.f13233Q.clear();
        this.f13234R.clear();
        this.f13236T.clear();
        this.f13235S.clear();
        List asList = Arrays.asList(new String[]{"top_10k_v2", "top_100k_v2", "top_10k_annual_v2", "top_100k_annual_v2"});
        List asList2 = Arrays.asList(new String[]{"subs", "subs", "subs", "subs"});
        ArrayList arrayList = new ArrayList();
        for (int i8 = 0; i8 < asList.size(); i8++) {
            arrayList.add(C1056g.b.a().b((String) asList.get(i8)).c((String) asList2.get(i8)).a());
        }
        this.f13239W.d(C1056g.a().b(arrayList).a(), new G1(this));
    }

    private void p0() {
        List asList = Arrays.asList(new String[]{"top_10k_lifetime", "top_100k_lifetime"});
        List asList2 = Arrays.asList(new String[]{"inapp", "inapp"});
        ArrayList arrayList = new ArrayList();
        for (int i8 = 0; i8 < asList.size(); i8++) {
            arrayList.add(C1056g.b.a().b((String) asList.get(i8)).c((String) asList2.get(i8)).a());
        }
        this.f13239W.d(C1056g.a().b(arrayList).a(), new H1(this));
    }

    /* access modifiers changed from: private */
    public void q0() {
        if (this.f13231O != null) {
            int checkedRadioButtonId = ((RadioGroup) findViewById(C2030R.id.radioGroup1)).getCheckedRadioButtonId();
            ((RadioGroup) findViewById(C2030R.id.radioGroup2)).setVisibility(0);
            ((Button) findViewById(C2030R.id.button1)).setVisibility(0);
            if (checkedRadioButtonId == C2030R.id.radioButton1) {
                for (int i8 = 0; i8 < this.f13231O.size(); i8++) {
                    if (((String) this.f13231O.get(i8)).contains("annual") && ((String) this.f13231O.get(i8)).contains("10k")) {
                        RadioButton radioButton = (RadioButton) findViewById(C2030R.id.radioButton4);
                        radioButton.setText((CharSequence) this.f13232P.get(i8));
                        radioButton.setTag(this.f13231O.get(i8));
                        radioButton.setVisibility(0);
                    } else if (((String) this.f13231O.get(i8)).contains("lifetime") && ((String) this.f13231O.get(i8)).contains("10k")) {
                        RadioButton radioButton2 = (RadioButton) findViewById(C2030R.id.radioButton5);
                        radioButton2.setText((CharSequence) this.f13232P.get(i8));
                        radioButton2.setTag(this.f13231O.get(i8));
                        radioButton2.setVisibility(0);
                    } else if (((String) this.f13231O.get(i8)).contains("10k")) {
                        RadioButton radioButton3 = (RadioButton) findViewById(C2030R.id.radioButton3);
                        radioButton3.setText((CharSequence) this.f13232P.get(i8));
                        radioButton3.setTag(this.f13231O.get(i8));
                        radioButton3.setVisibility(0);
                    }
                }
            } else if (checkedRadioButtonId == C2030R.id.radioButton2) {
                for (int i9 = 0; i9 < this.f13231O.size(); i9++) {
                    if (((String) this.f13231O.get(i9)).contains("annual") && ((String) this.f13231O.get(i9)).contains("100k")) {
                        RadioButton radioButton4 = (RadioButton) findViewById(C2030R.id.radioButton4);
                        radioButton4.setText((CharSequence) this.f13232P.get(i9));
                        radioButton4.setTag(this.f13231O.get(i9));
                        radioButton4.setVisibility(0);
                    } else if (((String) this.f13231O.get(i9)).contains("lifetime") && ((String) this.f13231O.get(i9)).contains("100k")) {
                        RadioButton radioButton5 = (RadioButton) findViewById(C2030R.id.radioButton5);
                        radioButton5.setText((CharSequence) this.f13232P.get(i9));
                        radioButton5.setTag(this.f13231O.get(i9));
                        radioButton5.setVisibility(0);
                    } else if (((String) this.f13231O.get(i9)).contains("100k")) {
                        RadioButton radioButton6 = (RadioButton) findViewById(C2030R.id.radioButton3);
                        radioButton6.setText((CharSequence) this.f13232P.get(i9));
                        radioButton6.setTag(this.f13231O.get(i9));
                        radioButton6.setVisibility(0);
                    }
                }
            }
        }
    }

    private boolean r0() {
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

    private boolean s0() {
        boolean z7;
        boolean z8;
        boolean z9 = false;
        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.class.getSimpleName(), 0);
        float f8 = sharedPreferences.getFloat("current_latitude", BitmapDescriptorFactory.HUE_RED);
        float f9 = sharedPreferences.getFloat("current_longitude", BitmapDescriptorFactory.HUE_RED);
        double currentTimeMillis = ((double) (System.currentTimeMillis() - sharedPreferences.getLong("current_location_time", 0))) / 1000.0d;
        if (f8 != BitmapDescriptorFactory.HUE_RED) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (f9 != BitmapDescriptorFactory.HUE_RED) {
            z8 = true;
        } else {
            z8 = false;
        }
        boolean z10 = z7 & z8;
        if (currentTimeMillis < 43200.0d) {
            z9 = true;
        }
        return z10 & z9;
    }

    private void t0() {
        C1050a a8 = C1050a.c(this).d(this).b().a();
        this.f13239W = a8;
        a8.f(new a());
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
                    edit.putString("order_id_sub", a8);
                    edit.apply();
                }
                String str2 = a8;
                if (purchase.d() == 1) {
                    if (!purchase.g()) {
                        this.f13239W.a(C1587a.b().b(purchase.e()).a(), new E1(this, str, edit, e8, str2));
                    } else {
                        if (str.equals("top_10k_v2")) {
                            this.f13241Y = true;
                            edit.putBoolean("top10k_owned", true);
                            edit.apply();
                        }
                        if (str.equals("top_100k_v2")) {
                            this.f13242Z = true;
                            edit.putBoolean("top100k_owned", true);
                            edit.apply();
                        }
                        if (str.equals("top_10k_annual_v2")) {
                            this.f13241Y = true;
                            edit.putBoolean("top10k_owned", true);
                            edit.apply();
                        }
                        if (str.equals("top_100k_annual_v2")) {
                            this.f13242Z = true;
                            edit.putBoolean("top100k_owned", true);
                            edit.apply();
                        }
                        if (str.equals("top_10k_annual_v3")) {
                            this.f13241Y = true;
                            edit.putBoolean("top10k_owned", true);
                            edit.apply();
                        }
                        if (str.equals("top_100k_annual_v3")) {
                            this.f13242Z = true;
                            edit.putBoolean("top100k_owned", true);
                            edit.apply();
                        }
                        if (str.equals("top_10k_lifetime")) {
                            this.f13241Y = true;
                            edit.putBoolean("top10k_owned", true);
                            edit.apply();
                        }
                        if (str.equals("top_100k_lifetime")) {
                            this.f13242Z = true;
                            edit.putBoolean("top100k_owned", true);
                            edit.apply();
                        }
                        String str3 = str2;
                        new b(this.f13238V, e8, str3, str).execute(new Context[]{this});
                        Iterator it2 = this.f13231O.iterator();
                        int i8 = 0;
                        int i9 = 0;
                        while (it2.hasNext()) {
                            if (((String) it2.next()).contains(str)) {
                                i8 = i9;
                            }
                            i9++;
                        }
                        C0624o e9 = C0624o.e(this);
                        e9.d(BigDecimal.valueOf(((double) ((Long) this.f13234R.get(i8)).longValue()) / 1000000.0d), Currency.getInstance((String) this.f13236T.get(i8)));
                        e9.b();
                    }
                }
            }
        }
    }

    public void onCreate(Bundle bundle) {
        boolean z7;
        super.onCreate(bundle);
        setContentView((int) C2030R.layout.inapp_card);
        int i8 = getResources().getConfiguration().uiMode & 48;
        if (Build.VERSION.SDK_INT >= 35 && i8 == 16) {
            Window window = getWindow();
            C0832r0.a(window, window.getDecorView()).d(true);
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            z7 = extras.getBoolean("show_map_button");
        } else {
            z7 = true;
        }
        Class<MainActivity> cls = MainActivity.class;
        SharedPreferences sharedPreferences = getSharedPreferences(cls.getSimpleName(), 0);
        this.f13238V = sharedPreferences.getString("android_id_eqn", "0");
        this.f13241Y = sharedPreferences.getBoolean("top10k_owned", false);
        this.f13242Z = sharedPreferences.getBoolean("top100k_owned", false);
        boolean z8 = sharedPreferences.getBoolean("pro_features", false);
        Toolbar toolbar = (Toolbar) findViewById(C2030R.id.toolbar);
        b0(toolbar);
        if (!z8) {
            toolbar.setLogo(2131230872);
        } else {
            toolbar.setLogo(2131230875);
        }
        ((Button) findViewById(C2030R.id.button1)).setOnClickListener(new A1(this));
        Button button = (Button) findViewById(C2030R.id.button2);
        button.setOnClickListener(new B1(this));
        if (z7) {
            button.setVisibility(0);
        } else {
            button.setVisibility(8);
        }
        ((Button) findViewById(C2030R.id.button3)).setOnClickListener(new C1(this));
        ((RadioGroup) findViewById(C2030R.id.radioGroup1)).setOnCheckedChangeListener(new D1(this));
        SharedPreferences sharedPreferences2 = getSharedPreferences(cls.getSimpleName(), 0);
        int i9 = sharedPreferences2.getInt("top_10k_available", -1);
        int i10 = sharedPreferences2.getInt("top_100k_available", -1);
        if (!(i9 == -1 || i10 == -1)) {
            ((TextView) findViewById(C2030R.id.textView6)).setText(String.format(getString(C2030R.string.inapp_available_10k), new Object[]{NumberFormat.getIntegerInstance().format((long) i9)}));
            ((TextView) findViewById(C2030R.id.textView7)).setText(String.format(getString(C2030R.string.inapp_available_100k), new Object[]{NumberFormat.getIntegerInstance().format((long) i10)}));
        }
        t0();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        TextView textView = (TextView) findViewById(C2030R.id.textView2);
        if (this.f13241Y) {
            ImageView imageView = (ImageView) findViewById(C2030R.id.imageView1);
            imageView.setImageDrawable(androidx.core.content.a.getDrawable(getApplicationContext(), 2131231378));
            imageView.setVisibility(0);
            textView.setText(getString(C2030R.string.inapp_congratulation_10k));
        } else if (this.f13242Z) {
            ImageView imageView2 = (ImageView) findViewById(C2030R.id.imageView1);
            imageView2.setImageDrawable(androidx.core.content.a.getDrawable(getApplicationContext(), 2131231377));
            imageView2.setVisibility(0);
            textView.setText(getString(C2030R.string.inapp_congratulation_100k));
        }
    }
}
