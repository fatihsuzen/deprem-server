package com.finazzi.distquake;

import H3.d;
import P1.C0624o;
import Z0.C0693a;
import Z0.C0696d;
import Z0.C0700h;
import Z0.C0714w;
import Z0.F;
import Z0.O;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.location.Location;
import android.media.AudioAttributes;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.C0766b;
import androidx.appcompat.app.C0768d;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.C0887n;
import androidx.fragment.app.C0891s;
import androidx.viewpager2.widget.ViewPager2;
import com.android.billingclient.api.C1050a;
import com.android.billingclient.api.C1053d;
import com.android.billingclient.api.C1055f;
import com.android.billingclient.api.C1056g;
import com.android.billingclient.api.Purchase;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.FirebaseMessaging;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import m1.C1587a;
import m1.C1594h;
import m1.n;
import u2.A2;
import u2.B2;
import u2.C1754a2;
import u2.C1760b2;
import u2.C1766c2;
import u2.C1772d2;
import u2.C1778e2;
import u2.C1784f2;
import u2.C1790g2;
import u2.C1796h2;
import u2.C1802i2;
import u2.C1808j2;
import u2.C1814k2;
import u2.C1820l2;
import u2.C1826m2;
import u2.C1832n2;
import u2.C1838o2;
import u2.C1844p2;
import u2.C1850q2;
import u2.C1856r2;
import u2.C1862s2;
import u2.C1868t2;
import u2.C1874u2;
import u2.C1880v2;
import u2.C1886w2;
import u2.C1892x2;
import u2.C1898y2;
import u2.C1904z2;
import u2.C2;
import u2.D2;
import u2.E2;
import u2.F2;
import u2.G2;
import u2.H2;
import u2.I2;
import u2.J2;
import u2.K2;
import u2.L2;
import u2.M2;
import u2.N2;
import u2.O2;
import u2.P2;
import u2.Q2;
import u2.U1;
import u2.V1;
import u2.W1;
import u2.X1;
import u2.Y1;
import u2.Z1;
import x0.C1946a;

public class MainActivity extends C0768d implements m1.m, NavigationView.d {

    /* renamed from: O  reason: collision with root package name */
    private C0766b f13264O;

    /* renamed from: P  reason: collision with root package name */
    private FrameLayout f13265P;

    /* renamed from: Q  reason: collision with root package name */
    private AdView f13266Q;
    /* access modifiers changed from: private */

    /* renamed from: R  reason: collision with root package name */
    public InterstitialAd f13267R;

    /* renamed from: S  reason: collision with root package name */
    private ViewPager2 f13268S;

    /* renamed from: T  reason: collision with root package name */
    private final long[] f13269T = {0, 200, 200, 200};
    /* access modifiers changed from: private */

    /* renamed from: U  reason: collision with root package name */
    public SharedPreferences f13270U;
    /* access modifiers changed from: private */

    /* renamed from: V  reason: collision with root package name */
    public SharedPreferences f13271V;
    /* access modifiers changed from: private */

    /* renamed from: W  reason: collision with root package name */
    public SharedPreferences.Editor f13272W;

    /* renamed from: X  reason: collision with root package name */
    private String f13273X;

    /* renamed from: Y  reason: collision with root package name */
    private boolean f13274Y = false;

    /* renamed from: Z  reason: collision with root package name */
    private boolean f13275Z = false;

    /* renamed from: a0  reason: collision with root package name */
    private boolean f13276a0 = false;

    /* renamed from: b0  reason: collision with root package name */
    private boolean f13277b0 = false;

    /* renamed from: c0  reason: collision with root package name */
    private C1050a f13278c0;

    /* renamed from: d0  reason: collision with root package name */
    private CancellationTokenSource f13279d0;

    /* renamed from: e0  reason: collision with root package name */
    private int f13280e0 = 0;

    /* renamed from: f0  reason: collision with root package name */
    private AlertDialog f13281f0 = null;

    /* renamed from: g0  reason: collision with root package name */
    private H3.c f13282g0;

    /* renamed from: h0  reason: collision with root package name */
    private final AtomicBoolean f13283h0 = new AtomicBoolean(false);

    /* renamed from: i0  reason: collision with root package name */
    private boolean f13284i0 = false;

    class a extends AdListener {
        a() {
        }

        public void onAdClicked() {
        }

        public void onAdClosed() {
        }

        public void onAdFailedToLoad(LoadAdError loadAdError) {
        }

        public void onAdLoaded() {
        }

        public void onAdOpened() {
        }
    }

    class b extends InterstitialAdLoadCallback {

        class a extends FullScreenContentCallback {
            a() {
            }

            public void onAdDismissedFullScreenContent() {
                InterstitialAd unused = MainActivity.this.f13267R = null;
            }

            public void onAdFailedToShowFullScreenContent(AdError adError) {
                InterstitialAd unused = MainActivity.this.f13267R = null;
            }

            public void onAdShowedFullScreenContent() {
                SharedPreferences.Editor edit = MainActivity.this.f13270U.edit();
                edit.putLong("last_interstitial", System.currentTimeMillis());
                edit.apply();
            }
        }

        b() {
        }

        /* renamed from: a */
        public void onAdLoaded(InterstitialAd interstitialAd) {
            interstitialAd.setFullScreenContentCallback(new a());
            InterstitialAd unused = MainActivity.this.f13267R = interstitialAd;
            MainActivity.this.f13267R.show(MainActivity.this);
        }

        public void onAdFailedToLoad(LoadAdError loadAdError) {
            InterstitialAd unused = MainActivity.this.f13267R = null;
        }
    }

    class c extends C0766b {
        c(Activity activity, DrawerLayout drawerLayout, Toolbar toolbar, int i8, int i9) {
            super(activity, drawerLayout, toolbar, i8, i9);
        }

        public void a(View view) {
            super.a(view);
        }

        public void b(View view) {
            super.b(view);
        }
    }

    class d implements C1594h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f13289a;

        d(String str) {
            this.f13289a = str;
        }

        public void a(C1053d dVar) {
            if (dVar.b() == 0) {
                MainActivity.this.g1(this.f13289a);
            }
        }

        public void b() {
        }
    }

    private class e extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private final String f13291a;

        /* renamed from: b  reason: collision with root package name */
        private final String f13292b;

        /* renamed from: c  reason: collision with root package name */
        private final String f13293c;

        /* renamed from: d  reason: collision with root package name */
        private final String f13294d;

        /* renamed from: e  reason: collision with root package name */
        private int f13295e;

        e(String str, String str2, String str3, String str4) {
            this.f13291a = str;
            this.f13292b = str2;
            this.f13293c = str3;
            this.f13294d = str4;
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
                java.lang.String r1 = r5.f13291a
                r6.put(r0, r1)
                java.lang.String r0 = "token_sub"
                java.lang.String r1 = r5.f13292b
                r6.put(r0, r1)
                java.lang.String r0 = "wallet_sub"
                java.lang.String r1 = r5.f13293c
                r6.put(r0, r1)
                java.lang.String r0 = "sku"
                java.lang.String r1 = r5.f13294d
                r6.put(r0, r1)
                java.lang.String r6 = u2.C1737L.a(r6)
                r0 = 0
                java.net.URL r1 = new java.net.URL     // Catch:{ IOException -> 0x00c5 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00c5 }
                r2.<init>()     // Catch:{ IOException -> 0x00c5 }
                com.finazzi.distquake.MainActivity r3 = com.finazzi.distquake.MainActivity.this     // Catch:{ IOException -> 0x00c5 }
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
                r5.f13295e = r6     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                goto L_0x00bf
            L_0x00bd:
                r5.f13295e = r0     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
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
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.MainActivity.e.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            boolean z7 = false;
            SharedPreferences.Editor edit = MainActivity.this.getSharedPreferences("no_backup_pref", 0).edit();
            if (this.f13295e != 0) {
                z7 = true;
            }
            edit.putBoolean("update_server2_pro", z7);
            edit.apply();
        }
    }

    private class f extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private final String f13297a;

        /* renamed from: b  reason: collision with root package name */
        private final String f13298b;

        /* renamed from: c  reason: collision with root package name */
        private final String f13299c;

        /* renamed from: d  reason: collision with root package name */
        private final String f13300d;

        f(String str, String str2, String str3, String str4) {
            this.f13297a = str;
            this.f13298b = str2;
            this.f13299c = str3;
            this.f13300d = str4;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00b2 A[Catch:{ all -> 0x00a9 }] */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x00bd  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x00c5  */
        /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r6) {
            /*
                r5 = this;
                java.util.HashMap r6 = new java.util.HashMap
                r6.<init>()
                java.lang.String r0 = "u_id"
                java.lang.String r1 = r5.f13297a
                r6.put(r0, r1)
                java.lang.String r0 = "token_sub"
                java.lang.String r1 = r5.f13298b
                r6.put(r0, r1)
                java.lang.String r0 = "wallet_sub"
                java.lang.String r1 = r5.f13299c
                r6.put(r0, r1)
                java.lang.String r0 = "sku"
                java.lang.String r1 = r5.f13300d
                r6.put(r0, r1)
                java.lang.String r6 = u2.C1737L.a(r6)
                r0 = 0
                java.net.URL r1 = new java.net.URL     // Catch:{ IOException -> 0x00ab }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00ab }
                r2.<init>()     // Catch:{ IOException -> 0x00ab }
                com.finazzi.distquake.MainActivity r3 = com.finazzi.distquake.MainActivity.this     // Catch:{ IOException -> 0x00ab }
                r4 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r3 = r3.getString(r4)     // Catch:{ IOException -> 0x00ab }
                r2.append(r3)     // Catch:{ IOException -> 0x00ab }
                java.lang.String r3 = "distquake_upload_pro_upgraded.php"
                r2.append(r3)     // Catch:{ IOException -> 0x00ab }
                java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x00ab }
                r1.<init>(r2)     // Catch:{ IOException -> 0x00ab }
                java.net.URLConnection r1 = r1.openConnection()     // Catch:{ IOException -> 0x00ab }
                java.lang.Object r1 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r1)     // Catch:{ IOException -> 0x00ab }
                java.net.URLConnection r1 = (java.net.URLConnection) r1     // Catch:{ IOException -> 0x00ab }
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ IOException -> 0x00ab }
                r0 = 1
                r1.setDoOutput(r0)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                r0 = 10000(0x2710, float:1.4013E-41)
                r1.setConnectTimeout(r0)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                r1.setReadTimeout(r0)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.lang.String r0 = "Content-Type"
                java.lang.String r2 = "application/x-www-form-urlencoded;charset=utf-8"
                r1.setRequestProperty(r0, r2)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.lang.String r0 = "POST"
                r1.setRequestMethod(r0)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                byte[] r0 = r6.getBytes()     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                int r0 = r0.length     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                r1.setFixedLengthStreamingMode(r0)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.io.PrintWriter r0 = new java.io.PrintWriter     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.io.OutputStream r2 = r1.getOutputStream()     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                r0.<init>(r2)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                r0.print(r6)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                r0.close()     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.io.BufferedInputStream r6 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.io.InputStream r0 = r1.getInputStream()     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                r6.<init>(r0)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                r2.<init>(r6, r3)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                r0.<init>(r2)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
            L_0x0095:
                java.lang.String r2 = r0.readLine()     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                if (r2 == 0) goto L_0x009c
                goto L_0x0095
            L_0x009c:
                r6.close()     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                r1.disconnect()
                goto L_0x00c0
            L_0x00a3:
                r6 = move-exception
                r0 = r1
                goto L_0x00c3
            L_0x00a6:
                r6 = move-exception
                r0 = r1
                goto L_0x00ac
            L_0x00a9:
                r6 = move-exception
                goto L_0x00c3
            L_0x00ab:
                r6 = move-exception
            L_0x00ac:
                java.lang.String r1 = r6.getMessage()     // Catch:{ all -> 0x00a9 }
                if (r1 == 0) goto L_0x00bb
                java.lang.String r1 = "EQN"
                java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x00a9 }
                android.util.Log.d(r1, r6)     // Catch:{ all -> 0x00a9 }
            L_0x00bb:
                if (r0 == 0) goto L_0x00c0
                r0.disconnect()
            L_0x00c0:
                java.lang.String r6 = "COMPLETE!"
                return r6
            L_0x00c3:
                if (r0 == 0) goto L_0x00c8
                r0.disconnect()
            L_0x00c8:
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.MainActivity.f.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
        }
    }

    private class g extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private final String f13302a;

        /* renamed from: b  reason: collision with root package name */
        private final String f13303b;

        /* renamed from: c  reason: collision with root package name */
        private final String f13304c;

        /* renamed from: d  reason: collision with root package name */
        private final String f13305d;

        g(String str, String str2, String str3, String str4) {
            this.f13302a = str;
            this.f13303b = str2;
            this.f13304c = str3;
            this.f13305d = str4;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00b2 A[Catch:{ all -> 0x00a9 }] */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x00bd  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x00c5  */
        /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r6) {
            /*
                r5 = this;
                java.util.HashMap r6 = new java.util.HashMap
                r6.<init>()
                java.lang.String r0 = "u_id"
                java.lang.String r1 = r5.f13302a
                r6.put(r0, r1)
                java.lang.String r0 = "token_sub"
                java.lang.String r1 = r5.f13303b
                r6.put(r0, r1)
                java.lang.String r0 = "wallet_sub"
                java.lang.String r1 = r5.f13304c
                r6.put(r0, r1)
                java.lang.String r0 = "sku"
                java.lang.String r1 = r5.f13305d
                r6.put(r0, r1)
                java.lang.String r6 = u2.C1737L.a(r6)
                r0 = 0
                java.net.URL r1 = new java.net.URL     // Catch:{ IOException -> 0x00ab }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00ab }
                r2.<init>()     // Catch:{ IOException -> 0x00ab }
                com.finazzi.distquake.MainActivity r3 = com.finazzi.distquake.MainActivity.this     // Catch:{ IOException -> 0x00ab }
                r4 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r3 = r3.getString(r4)     // Catch:{ IOException -> 0x00ab }
                r2.append(r3)     // Catch:{ IOException -> 0x00ab }
                java.lang.String r3 = "distquake_upload_subscription.php"
                r2.append(r3)     // Catch:{ IOException -> 0x00ab }
                java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x00ab }
                r1.<init>(r2)     // Catch:{ IOException -> 0x00ab }
                java.net.URLConnection r1 = r1.openConnection()     // Catch:{ IOException -> 0x00ab }
                java.lang.Object r1 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r1)     // Catch:{ IOException -> 0x00ab }
                java.net.URLConnection r1 = (java.net.URLConnection) r1     // Catch:{ IOException -> 0x00ab }
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ IOException -> 0x00ab }
                r0 = 1
                r1.setDoOutput(r0)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                r0 = 10000(0x2710, float:1.4013E-41)
                r1.setConnectTimeout(r0)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                r1.setReadTimeout(r0)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.lang.String r0 = "Content-Type"
                java.lang.String r2 = "application/x-www-form-urlencoded;charset=utf-8"
                r1.setRequestProperty(r0, r2)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.lang.String r0 = "POST"
                r1.setRequestMethod(r0)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                byte[] r0 = r6.getBytes()     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                int r0 = r0.length     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                r1.setFixedLengthStreamingMode(r0)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.io.PrintWriter r0 = new java.io.PrintWriter     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.io.OutputStream r2 = r1.getOutputStream()     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                r0.<init>(r2)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                r0.print(r6)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                r0.close()     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.io.BufferedInputStream r6 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.io.InputStream r0 = r1.getInputStream()     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                r6.<init>(r0)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                r2.<init>(r6, r3)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                r0.<init>(r2)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
            L_0x0095:
                java.lang.String r2 = r0.readLine()     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                if (r2 == 0) goto L_0x009c
                goto L_0x0095
            L_0x009c:
                r6.close()     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                r1.disconnect()
                goto L_0x00c0
            L_0x00a3:
                r6 = move-exception
                r0 = r1
                goto L_0x00c3
            L_0x00a6:
                r6 = move-exception
                r0 = r1
                goto L_0x00ac
            L_0x00a9:
                r6 = move-exception
                goto L_0x00c3
            L_0x00ab:
                r6 = move-exception
            L_0x00ac:
                java.lang.String r1 = r6.getMessage()     // Catch:{ all -> 0x00a9 }
                if (r1 == 0) goto L_0x00bb
                java.lang.String r1 = "EQN"
                java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x00a9 }
                android.util.Log.d(r1, r6)     // Catch:{ all -> 0x00a9 }
            L_0x00bb:
                if (r0 == 0) goto L_0x00c0
                r0.disconnect()
            L_0x00c0:
                java.lang.String r6 = "COMPLETE!"
                return r6
            L_0x00c3:
                if (r0 == 0) goto L_0x00c8
                r0.disconnect()
            L_0x00c8:
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.MainActivity.g.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
        }
    }

    private class h extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private final String f13307a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f13308b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f13309c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f13310d;

        /* renamed from: e  reason: collision with root package name */
        private int f13311e;

        h(String str, boolean z7, boolean z8, boolean z9) {
            this.f13307a = str;
            this.f13308b = z7;
            this.f13309c = z8;
            this.f13310d = z9;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00e2 A[Catch:{ all -> 0x00d9 }] */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00ed  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00f5  */
        /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r6) {
            /*
                r5 = this;
                java.util.HashMap r6 = new java.util.HashMap
                r6.<init>()
                java.lang.String r0 = "u_id"
                java.lang.String r1 = r5.f13307a
                r6.put(r0, r1)
                boolean r0 = r5.f13308b
                java.lang.String r1 = "pro"
                java.lang.String r2 = "0"
                java.lang.String r3 = "1"
                if (r0 == 0) goto L_0x001a
                r6.put(r1, r3)
                goto L_0x001d
            L_0x001a:
                r6.put(r1, r2)
            L_0x001d:
                boolean r0 = r5.f13309c
                java.lang.String r1 = "top10k"
                if (r0 == 0) goto L_0x0027
                r6.put(r1, r3)
                goto L_0x002a
            L_0x0027:
                r6.put(r1, r2)
            L_0x002a:
                boolean r0 = r5.f13310d
                java.lang.String r1 = "top100k"
                if (r0 == 0) goto L_0x0034
                r6.put(r1, r3)
                goto L_0x0037
            L_0x0034:
                r6.put(r1, r2)
            L_0x0037:
                java.lang.String r6 = u2.C1737L.a(r6)
                r0 = 0
                java.net.URL r1 = new java.net.URL     // Catch:{ IOException -> 0x00db }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00db }
                r2.<init>()     // Catch:{ IOException -> 0x00db }
                com.finazzi.distquake.MainActivity r3 = com.finazzi.distquake.MainActivity.this     // Catch:{ IOException -> 0x00db }
                r4 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r3 = r3.getString(r4)     // Catch:{ IOException -> 0x00db }
                r2.append(r3)     // Catch:{ IOException -> 0x00db }
                java.lang.String r3 = "distquake_update_subscription_and_pro_status.php"
                r2.append(r3)     // Catch:{ IOException -> 0x00db }
                java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x00db }
                r1.<init>(r2)     // Catch:{ IOException -> 0x00db }
                java.net.URLConnection r1 = r1.openConnection()     // Catch:{ IOException -> 0x00db }
                java.lang.Object r1 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r1)     // Catch:{ IOException -> 0x00db }
                java.net.URLConnection r1 = (java.net.URLConnection) r1     // Catch:{ IOException -> 0x00db }
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ IOException -> 0x00db }
                r0 = 1
                r1.setDoOutput(r0)     // Catch:{ IOException -> 0x00bd, all -> 0x00ba }
                r2 = 15000(0x3a98, float:2.102E-41)
                r1.setConnectTimeout(r2)     // Catch:{ IOException -> 0x00bd, all -> 0x00ba }
                r1.setReadTimeout(r2)     // Catch:{ IOException -> 0x00bd, all -> 0x00ba }
                java.lang.String r2 = "Content-Type"
                java.lang.String r3 = "application/x-www-form-urlencoded;charset=utf-8"
                r1.setRequestProperty(r2, r3)     // Catch:{ IOException -> 0x00bd, all -> 0x00ba }
                java.lang.String r2 = "POST"
                r1.setRequestMethod(r2)     // Catch:{ IOException -> 0x00bd, all -> 0x00ba }
                byte[] r2 = r6.getBytes()     // Catch:{ IOException -> 0x00bd, all -> 0x00ba }
                int r2 = r2.length     // Catch:{ IOException -> 0x00bd, all -> 0x00ba }
                r1.setFixedLengthStreamingMode(r2)     // Catch:{ IOException -> 0x00bd, all -> 0x00ba }
                java.io.PrintWriter r2 = new java.io.PrintWriter     // Catch:{ IOException -> 0x00bd, all -> 0x00ba }
                java.io.OutputStream r3 = r1.getOutputStream()     // Catch:{ IOException -> 0x00bd, all -> 0x00ba }
                r2.<init>(r3)     // Catch:{ IOException -> 0x00bd, all -> 0x00ba }
                r2.print(r6)     // Catch:{ IOException -> 0x00bd, all -> 0x00ba }
                r2.close()     // Catch:{ IOException -> 0x00bd, all -> 0x00ba }
                java.io.BufferedInputStream r6 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00bd, all -> 0x00ba }
                java.io.InputStream r2 = r1.getInputStream()     // Catch:{ IOException -> 0x00bd, all -> 0x00ba }
                r6.<init>(r2)     // Catch:{ IOException -> 0x00bd, all -> 0x00ba }
                java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00bd, all -> 0x00ba }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00bd, all -> 0x00ba }
                java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00bd, all -> 0x00ba }
                r3.<init>(r6, r4)     // Catch:{ IOException -> 0x00bd, all -> 0x00ba }
                r2.<init>(r3)     // Catch:{ IOException -> 0x00bd, all -> 0x00ba }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00bd, all -> 0x00ba }
                r3.<init>()     // Catch:{ IOException -> 0x00bd, all -> 0x00ba }
            L_0x00b0:
                java.lang.String r4 = r2.readLine()     // Catch:{ IOException -> 0x00bd, all -> 0x00ba }
                if (r4 == 0) goto L_0x00c0
                r3.append(r4)     // Catch:{ IOException -> 0x00bd, all -> 0x00ba }
                goto L_0x00b0
            L_0x00ba:
                r6 = move-exception
                r0 = r1
                goto L_0x00f3
            L_0x00bd:
                r6 = move-exception
                r0 = r1
                goto L_0x00dc
            L_0x00c0:
                r6.close()     // Catch:{ IOException -> 0x00bd, all -> 0x00ba }
                java.lang.String r6 = r3.toString()     // Catch:{ IOException -> 0x00bd, all -> 0x00ba }
                java.lang.String r2 = "ok"
                boolean r6 = r6.equals(r2)     // Catch:{ IOException -> 0x00bd, all -> 0x00ba }
                if (r6 == 0) goto L_0x00d3
                r6 = 0
                r5.f13311e = r6     // Catch:{ IOException -> 0x00bd, all -> 0x00ba }
                goto L_0x00d5
            L_0x00d3:
                r5.f13311e = r0     // Catch:{ IOException -> 0x00bd, all -> 0x00ba }
            L_0x00d5:
                r1.disconnect()
                goto L_0x00f0
            L_0x00d9:
                r6 = move-exception
                goto L_0x00f3
            L_0x00db:
                r6 = move-exception
            L_0x00dc:
                java.lang.String r1 = r6.getMessage()     // Catch:{ all -> 0x00d9 }
                if (r1 == 0) goto L_0x00eb
                java.lang.String r1 = "EQN"
                java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x00d9 }
                android.util.Log.d(r1, r6)     // Catch:{ all -> 0x00d9 }
            L_0x00eb:
                if (r0 == 0) goto L_0x00f0
                r0.disconnect()
            L_0x00f0:
                java.lang.String r6 = "COMPLETE!"
                return r6
            L_0x00f3:
                if (r0 == 0) goto L_0x00f8
                r0.disconnect()
            L_0x00f8:
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.MainActivity.h.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            if (this.f13311e == 0) {
                MainActivity.this.f13272W.putBoolean("last_pro_owned", this.f13308b);
                MainActivity.this.f13272W.putBoolean("last_top10k_owned", this.f13309c);
                MainActivity.this.f13272W.putBoolean("last_top100k_owned", this.f13310d);
                MainActivity.this.f13272W.apply();
            }
        }
    }

    private class i extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private final String f13313a;

        /* renamed from: b  reason: collision with root package name */
        private final String f13314b;

        i(String str, String str2) {
            this.f13313a = str;
            this.f13314b = str2;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00a4 A[Catch:{ all -> 0x009b }] */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x00af  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x00b7  */
        /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r6) {
            /*
                r5 = this;
                java.util.HashMap r6 = new java.util.HashMap
                r6.<init>()
                java.lang.String r0 = "u_id"
                java.lang.String r1 = r5.f13313a
                r6.put(r0, r1)
                java.lang.String r0 = "tile"
                java.lang.String r1 = r5.f13314b
                r6.put(r0, r1)
                java.lang.String r6 = u2.C1737L.a(r6)
                r0 = 0
                java.net.URL r1 = new java.net.URL     // Catch:{ IOException -> 0x009d }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x009d }
                r2.<init>()     // Catch:{ IOException -> 0x009d }
                com.finazzi.distquake.MainActivity r3 = com.finazzi.distquake.MainActivity.this     // Catch:{ IOException -> 0x009d }
                r4 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r3 = r3.getString(r4)     // Catch:{ IOException -> 0x009d }
                r2.append(r3)     // Catch:{ IOException -> 0x009d }
                java.lang.String r3 = "distquake_update_tile.php"
                r2.append(r3)     // Catch:{ IOException -> 0x009d }
                java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x009d }
                r1.<init>(r2)     // Catch:{ IOException -> 0x009d }
                java.net.URLConnection r1 = r1.openConnection()     // Catch:{ IOException -> 0x009d }
                java.lang.Object r1 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r1)     // Catch:{ IOException -> 0x009d }
                java.net.URLConnection r1 = (java.net.URLConnection) r1     // Catch:{ IOException -> 0x009d }
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ IOException -> 0x009d }
                r0 = 1
                r1.setDoOutput(r0)     // Catch:{ IOException -> 0x0098, all -> 0x0095 }
                r0 = 15000(0x3a98, float:2.102E-41)
                r1.setConnectTimeout(r0)     // Catch:{ IOException -> 0x0098, all -> 0x0095 }
                r1.setReadTimeout(r0)     // Catch:{ IOException -> 0x0098, all -> 0x0095 }
                java.lang.String r0 = "Content-Type"
                java.lang.String r2 = "application/x-www-form-urlencoded;charset=utf-8"
                r1.setRequestProperty(r0, r2)     // Catch:{ IOException -> 0x0098, all -> 0x0095 }
                java.lang.String r0 = "POST"
                r1.setRequestMethod(r0)     // Catch:{ IOException -> 0x0098, all -> 0x0095 }
                byte[] r0 = r6.getBytes()     // Catch:{ IOException -> 0x0098, all -> 0x0095 }
                int r0 = r0.length     // Catch:{ IOException -> 0x0098, all -> 0x0095 }
                r1.setFixedLengthStreamingMode(r0)     // Catch:{ IOException -> 0x0098, all -> 0x0095 }
                java.io.PrintWriter r0 = new java.io.PrintWriter     // Catch:{ IOException -> 0x0098, all -> 0x0095 }
                java.io.OutputStream r2 = r1.getOutputStream()     // Catch:{ IOException -> 0x0098, all -> 0x0095 }
                r0.<init>(r2)     // Catch:{ IOException -> 0x0098, all -> 0x0095 }
                r0.print(r6)     // Catch:{ IOException -> 0x0098, all -> 0x0095 }
                r0.close()     // Catch:{ IOException -> 0x0098, all -> 0x0095 }
                java.io.BufferedInputStream r6 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0098, all -> 0x0095 }
                java.io.InputStream r0 = r1.getInputStream()     // Catch:{ IOException -> 0x0098, all -> 0x0095 }
                r6.<init>(r0)     // Catch:{ IOException -> 0x0098, all -> 0x0095 }
                java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0098, all -> 0x0095 }
                java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0098, all -> 0x0095 }
                java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x0098, all -> 0x0095 }
                r2.<init>(r6, r3)     // Catch:{ IOException -> 0x0098, all -> 0x0095 }
                r0.<init>(r2)     // Catch:{ IOException -> 0x0098, all -> 0x0095 }
            L_0x0087:
                java.lang.String r2 = r0.readLine()     // Catch:{ IOException -> 0x0098, all -> 0x0095 }
                if (r2 == 0) goto L_0x008e
                goto L_0x0087
            L_0x008e:
                r6.close()     // Catch:{ IOException -> 0x0098, all -> 0x0095 }
                r1.disconnect()
                goto L_0x00b2
            L_0x0095:
                r6 = move-exception
                r0 = r1
                goto L_0x00b5
            L_0x0098:
                r6 = move-exception
                r0 = r1
                goto L_0x009e
            L_0x009b:
                r6 = move-exception
                goto L_0x00b5
            L_0x009d:
                r6 = move-exception
            L_0x009e:
                java.lang.String r1 = r6.getMessage()     // Catch:{ all -> 0x009b }
                if (r1 == 0) goto L_0x00ad
                java.lang.String r1 = "EQN"
                java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x009b }
                android.util.Log.d(r1, r6)     // Catch:{ all -> 0x009b }
            L_0x00ad:
                if (r0 == 0) goto L_0x00b2
                r0.disconnect()
            L_0x00b2:
                java.lang.String r6 = "COMPLETE!"
                return r6
            L_0x00b5:
                if (r0 == 0) goto L_0x00ba
                r0.disconnect()
            L_0x00ba:
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.MainActivity.i.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
        }
    }

    private class j extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private boolean f13316a;

        /* renamed from: b  reason: collision with root package name */
        private final String f13317b;

        /* renamed from: c  reason: collision with root package name */
        private String f13318c = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;

        /* renamed from: d  reason: collision with root package name */
        private final float f13319d;

        /* renamed from: e  reason: collision with root package name */
        private final float f13320e;

        /* renamed from: f  reason: collision with root package name */
        private final float f13321f;

        /* renamed from: g  reason: collision with root package name */
        private final float f13322g;

        /* renamed from: h  reason: collision with root package name */
        private final float f13323h;

        j(String str, float f8, float f9, float f10, float f11, float f12) {
            this.f13317b = str;
            this.f13319d = f8;
            this.f13320e = f9;
            this.f13321f = f10;
            this.f13322g = f11;
            this.f13323h = f12;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(5:17|16|21|22|(0)(0)) */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x00f3, code lost:
            r7 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00f9, code lost:
            r1.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0101, code lost:
            r1.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x00f5 */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x00f9  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0101  */
        /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r7) {
            /*
                r6 = this;
                java.util.HashMap r7 = new java.util.HashMap
                r7.<init>()
                java.lang.String r0 = "u_id"
                java.lang.String r1 = r6.f13317b
                r7.put(r0, r1)
                float r0 = r6.f13319d
                java.lang.String r0 = java.lang.Float.toString(r0)
                java.lang.String r1 = "lat"
                r7.put(r1, r0)
                float r0 = r6.f13320e
                java.lang.String r0 = java.lang.Float.toString(r0)
                java.lang.String r1 = "lon"
                r7.put(r1, r0)
                float r0 = r6.f13321f
                java.lang.String r0 = java.lang.Float.toString(r0)
                java.lang.String r1 = "acc"
                r7.put(r1, r0)
                float r0 = r6.f13319d
                float r1 = r6.f13322g
                float r0 = r0 - r1
                float r0 = java.lang.Math.abs(r0)
                double r0 = (double) r0
                r2 = 4591870180066957722(0x3fb999999999999a, double:0.1)
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                java.lang.String r1 = "upd"
                if (r0 >= 0) goto L_0x0056
                float r0 = r6.f13320e
                float r4 = r6.f13323h
                float r0 = r0 - r4
                float r0 = java.lang.Math.abs(r0)
                double r4 = (double) r0
                int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
                if (r0 >= 0) goto L_0x0056
                java.lang.String r0 = "0"
                r7.put(r1, r0)
                goto L_0x005b
            L_0x0056:
                java.lang.String r0 = "1"
                r7.put(r1, r0)
            L_0x005b:
                java.lang.String r7 = u2.C1737L.a(r7)
                r0 = 1
                r1 = 0
                java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x00f5 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00f5 }
                r3.<init>()     // Catch:{ IOException -> 0x00f5 }
                com.finazzi.distquake.MainActivity r4 = com.finazzi.distquake.MainActivity.this     // Catch:{ IOException -> 0x00f5 }
                r5 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r4 = r4.getString(r5)     // Catch:{ IOException -> 0x00f5 }
                r3.append(r4)     // Catch:{ IOException -> 0x00f5 }
                java.lang.String r4 = "distquake_upload_gcm_latlon.php"
                r3.append(r4)     // Catch:{ IOException -> 0x00f5 }
                java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x00f5 }
                r2.<init>(r3)     // Catch:{ IOException -> 0x00f5 }
                java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IOException -> 0x00f5 }
                java.lang.Object r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r2)     // Catch:{ IOException -> 0x00f5 }
                java.net.URLConnection r2 = (java.net.URLConnection) r2     // Catch:{ IOException -> 0x00f5 }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x00f5 }
                r2.setDoOutput(r0)     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
                r1 = 10000(0x2710, float:1.4013E-41)
                r2.setConnectTimeout(r1)     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
                r2.setReadTimeout(r1)     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
                java.lang.String r1 = "Content-Type"
                java.lang.String r3 = "application/x-www-form-urlencoded;charset=utf-8"
                r2.setRequestProperty(r1, r3)     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
                java.lang.String r1 = "POST"
                r2.setRequestMethod(r1)     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
                byte[] r1 = r7.getBytes()     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
                int r1 = r1.length     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
                r2.setFixedLengthStreamingMode(r1)     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
                java.io.PrintWriter r1 = new java.io.PrintWriter     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
                java.io.OutputStream r3 = r2.getOutputStream()     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
                r1.<init>(r3)     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
                r1.print(r7)     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
                r1.close()     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
                java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
                java.io.InputStream r1 = r2.getInputStream()     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
                r7.<init>(r1)     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
                java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
                r3.<init>(r7, r4)     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
                r1.<init>(r3)     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
                r3.<init>()     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
            L_0x00d4:
                java.lang.String r4 = r1.readLine()     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
                if (r4 == 0) goto L_0x00e3
                r3.append(r4)     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
                goto L_0x00d4
            L_0x00de:
                r7 = move-exception
                r1 = r2
                goto L_0x00ff
            L_0x00e1:
                r1 = r2
                goto L_0x00f5
            L_0x00e3:
                r7.close()     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
                java.lang.String r7 = r3.toString()     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
                r6.f13318c = r7     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
                r7 = 0
                r6.f13316a = r7     // Catch:{ IOException -> 0x00e1, all -> 0x00de }
                r2.disconnect()
                goto L_0x00fc
            L_0x00f3:
                r7 = move-exception
                goto L_0x00ff
            L_0x00f5:
                r6.f13316a = r0     // Catch:{ all -> 0x00f3 }
                if (r1 == 0) goto L_0x00fc
                r1.disconnect()
            L_0x00fc:
                java.lang.String r7 = "COMPLETE!"
                return r7
            L_0x00ff:
                if (r1 == 0) goto L_0x0104
                r1.disconnect()
            L_0x0104:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.MainActivity.j.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            if (!this.f13316a) {
                SharedPreferences.Editor edit = MainActivity.this.getSharedPreferences(MainActivity.class.getSimpleName(), 0).edit();
                edit.putBoolean("location_first_time", false);
                if (this.f13318c.equalsIgnoreCase("ok")) {
                    edit.putFloat("last_db_saved_lat", this.f13319d);
                    edit.putFloat("last_db_saved_lon", this.f13320e);
                }
                edit.apply();
            }
        }
    }

    private class k extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private final String f13325a;

        /* renamed from: b  reason: collision with root package name */
        private final String f13326b;

        /* renamed from: c  reason: collision with root package name */
        private final String f13327c;

        /* renamed from: d  reason: collision with root package name */
        private final String f13328d;

        /* renamed from: e  reason: collision with root package name */
        private int f13329e;

        k(String str, String str2, String str3, String str4) {
            this.f13325a = str;
            this.f13326b = str2;
            this.f13327c = str3;
            this.f13328d = str4;
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
                java.lang.String r1 = r5.f13325a
                r6.put(r0, r1)
                java.lang.String r0 = "token_sub"
                java.lang.String r1 = r5.f13326b
                r6.put(r0, r1)
                java.lang.String r0 = "wallet_sub"
                java.lang.String r1 = r5.f13327c
                r6.put(r0, r1)
                java.lang.String r0 = "sku"
                java.lang.String r1 = r5.f13328d
                r6.put(r0, r1)
                java.lang.String r6 = u2.C1737L.a(r6)
                r0 = 0
                java.net.URL r1 = new java.net.URL     // Catch:{ IOException -> 0x00c5 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00c5 }
                r2.<init>()     // Catch:{ IOException -> 0x00c5 }
                com.finazzi.distquake.MainActivity r3 = com.finazzi.distquake.MainActivity.this     // Catch:{ IOException -> 0x00c5 }
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
                r5.f13329e = r6     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                goto L_0x00bf
            L_0x00bd:
                r5.f13329e = r0     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
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
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.MainActivity.k.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            if (this.f13328d != null) {
                boolean z7 = false;
                SharedPreferences.Editor edit = MainActivity.this.getSharedPreferences("no_backup_pref", 0).edit();
                if (this.f13328d.contains("lifetime")) {
                    if (this.f13329e != 0) {
                        z7 = true;
                    }
                    edit.putBoolean("update_server2_lifetime", z7);
                } else {
                    if (this.f13329e != 0) {
                        z7 = true;
                    }
                    edit.putBoolean("update_server2", z7);
                }
                edit.apply();
            }
        }
    }

    private class l extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private boolean f13331a;

        /* renamed from: b  reason: collision with root package name */
        private String f13332b;

        /* renamed from: c  reason: collision with root package name */
        private final String f13333c;

        /* renamed from: d  reason: collision with root package name */
        private final String f13334d;

        /* renamed from: e  reason: collision with root package name */
        private final float f13335e;

        /* renamed from: f  reason: collision with root package name */
        private final float f13336f;

        /* synthetic */ l(MainActivity mainActivity, String str, String str2, float f8, float f9, a aVar) {
            this(str, str2, f8, f9);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(5:11|10|15|16|(0)(0)) */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x00c1, code lost:
            r7 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x00c7, code lost:
            r1.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x00cf, code lost:
            r1.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x00c3 */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x00c7  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00cf  */
        /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r7) {
            /*
                r6 = this;
                java.util.HashMap r7 = new java.util.HashMap
                r7.<init>()
                java.lang.String r0 = "u_id"
                java.lang.String r1 = r6.f13334d
                r7.put(r0, r1)
                java.lang.String r0 = "r_id"
                java.lang.String r1 = r6.f13333c
                r7.put(r0, r1)
                float r0 = r6.f13335e
                java.lang.String r0 = java.lang.Float.toString(r0)
                java.lang.String r1 = "lat"
                r7.put(r1, r0)
                float r0 = r6.f13336f
                java.lang.String r0 = java.lang.Float.toString(r0)
                java.lang.String r1 = "lon"
                r7.put(r1, r0)
                java.lang.String r7 = u2.C1737L.a(r7)
                r0 = 1
                r1 = 0
                java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x00c3 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00c3 }
                r3.<init>()     // Catch:{ IOException -> 0x00c3 }
                com.finazzi.distquake.MainActivity r4 = com.finazzi.distquake.MainActivity.this     // Catch:{ IOException -> 0x00c3 }
                r5 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r4 = r4.getString(r5)     // Catch:{ IOException -> 0x00c3 }
                r3.append(r4)     // Catch:{ IOException -> 0x00c3 }
                java.lang.String r4 = "distquake_upload_gcm_regid2.php"
                r3.append(r4)     // Catch:{ IOException -> 0x00c3 }
                java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x00c3 }
                r2.<init>(r3)     // Catch:{ IOException -> 0x00c3 }
                java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IOException -> 0x00c3 }
                java.lang.Object r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r2)     // Catch:{ IOException -> 0x00c3 }
                java.net.URLConnection r2 = (java.net.URLConnection) r2     // Catch:{ IOException -> 0x00c3 }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x00c3 }
                r2.setDoOutput(r0)     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                r1 = 10000(0x2710, float:1.4013E-41)
                r2.setConnectTimeout(r1)     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                r2.setReadTimeout(r1)     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                java.lang.String r1 = "Content-Type"
                java.lang.String r3 = "application/x-www-form-urlencoded;charset=utf-8"
                r2.setRequestProperty(r1, r3)     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                java.lang.String r1 = "POST"
                r2.setRequestMethod(r1)     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                byte[] r1 = r7.getBytes()     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                int r1 = r1.length     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                r2.setFixedLengthStreamingMode(r1)     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                java.io.PrintWriter r1 = new java.io.PrintWriter     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                java.io.OutputStream r3 = r2.getOutputStream()     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                r1.<init>(r3)     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                r1.print(r7)     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                r1.close()     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                java.io.InputStream r1 = r2.getInputStream()     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                r7.<init>(r1)     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                r3.<init>(r7, r4)     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                r1.<init>(r3)     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                r3.<init>()     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
            L_0x00a2:
                java.lang.String r4 = r1.readLine()     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                if (r4 == 0) goto L_0x00b1
                r3.append(r4)     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                goto L_0x00a2
            L_0x00ac:
                r7 = move-exception
                r1 = r2
                goto L_0x00cd
            L_0x00af:
                r1 = r2
                goto L_0x00c3
            L_0x00b1:
                r7.close()     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                java.lang.String r7 = r3.toString()     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                r6.f13332b = r7     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                r7 = 0
                r6.f13331a = r7     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                r2.disconnect()
                goto L_0x00ca
            L_0x00c1:
                r7 = move-exception
                goto L_0x00cd
            L_0x00c3:
                r6.f13331a = r0     // Catch:{ all -> 0x00c1 }
                if (r1 == 0) goto L_0x00ca
                r1.disconnect()
            L_0x00ca:
                java.lang.String r7 = "COMPLETE!"
                return r7
            L_0x00cd:
                if (r1 == 0) goto L_0x00d2
                r1.disconnect()
            L_0x00d2:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.MainActivity.l.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            SharedPreferences.Editor edit = MainActivity.this.getSharedPreferences(MainActivity.class.getSimpleName(), 0).edit();
            if (this.f13331a) {
                edit.putBoolean("FCM_refresh", true);
            } else if (this.f13332b.equalsIgnoreCase("nok")) {
                edit.putBoolean("FCM_refresh", true);
            } else {
                try {
                    if (Integer.parseInt(this.f13332b) != 0) {
                        edit.putString("android_id_eqn", this.f13332b);
                        edit.putBoolean("FCM_refresh", false);
                        edit.putString("last_FCM_registered_token", this.f13333c);
                        edit.putLong("last_FCM_registered_token_time", System.currentTimeMillis());
                    } else {
                        edit.putBoolean("FCM_refresh", true);
                    }
                } catch (NumberFormatException unused) {
                    edit.putBoolean("FCM_refresh", true);
                }
            }
            edit.apply();
        }

        private l(String str, String str2, float f8, float f9) {
            this.f13332b = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
            this.f13334d = str;
            this.f13333c = str2;
            this.f13335e = f8;
            this.f13336f = f9;
        }
    }

    private class m extends V0.a {

        /* renamed from: m  reason: collision with root package name */
        int f13338m = 4;

        public m(C0891s sVar) {
            super(sVar);
        }

        public C0887n E(int i8) {
            String string = MainActivity.this.f13271V.getString("eqn_first_tab", "0");
            if (string.equalsIgnoreCase("0")) {
                if (i8 == 0) {
                    return new FragmentNetwork();
                }
                if (i8 == 1) {
                    return new FragmentManual();
                }
                if (i8 == 2) {
                    return new FragmentOfficial();
                }
                if (i8 == 3) {
                    return new FragmentChatMenu();
                }
            }
            if (string.equalsIgnoreCase("1")) {
                if (i8 == 0) {
                    return new FragmentManual();
                }
                if (i8 == 1) {
                    return new FragmentNetwork();
                }
                if (i8 == 2) {
                    return new FragmentOfficial();
                }
                if (i8 == 3) {
                    return new FragmentChatMenu();
                }
            }
            if (string.equalsIgnoreCase("2")) {
                if (i8 == 0) {
                    return new FragmentOfficial();
                }
                if (i8 == 1) {
                    return new FragmentNetwork();
                }
                if (i8 == 2) {
                    return new FragmentManual();
                }
                if (i8 == 3) {
                    return new FragmentChatMenu();
                }
            }
            if (!string.equalsIgnoreCase("3")) {
                return null;
            }
            if (i8 == 0) {
                return new FragmentChatMenu();
            }
            if (i8 == 1) {
                return new FragmentNetwork();
            }
            if (i8 == 2) {
                return new FragmentManual();
            }
            if (i8 != 3) {
                return null;
            }
            return new FragmentOfficial();
        }

        public int j() {
            return this.f13338m;
        }
    }

    public static /* synthetic */ void A0(MainActivity mainActivity, DialogInterface dialogInterface, int i8) {
        mainActivity.getClass();
        androidx.core.app.b.f(mainActivity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
    }

    private boolean A1() {
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

    public static /* synthetic */ void B0(MainActivity mainActivity, String str, View view) {
        int i8 = mainActivity.f13280e0 + 1;
        mainActivity.f13280e0 = i8;
        if (i8 > 10) {
            new AlertDialog.Builder(mainActivity).setMessage(str).setCancelable(false).setPositiveButton(17039370, new A2()).show();
            mainActivity.f13280e0 = 0;
        }
    }

    public static /* synthetic */ void C0(MainActivity mainActivity, SharedPreferences sharedPreferences, TabLayout.e eVar, int i8) {
        mainActivity.getClass();
        String string = sharedPreferences.getString("eqn_first_tab", "0");
        if (string.equalsIgnoreCase("0")) {
            if (i8 == 0) {
                eVar.n(mainActivity.getString(C2030R.string.tab_network));
            } else if (i8 == 1) {
                eVar.n(mainActivity.getString(C2030R.string.tab_manual));
            } else if (i8 == 2) {
                eVar.n(mainActivity.getString(C2030R.string.tab_official));
            } else if (i8 == 3) {
                eVar.n(mainActivity.getString(C2030R.string.tab_chat));
            }
        }
        if (string.equalsIgnoreCase("1")) {
            if (i8 == 0) {
                eVar.n(mainActivity.getString(C2030R.string.tab_manual));
            } else if (i8 == 1) {
                eVar.n(mainActivity.getString(C2030R.string.tab_network));
            } else if (i8 == 2) {
                eVar.n(mainActivity.getString(C2030R.string.tab_official));
            } else if (i8 == 3) {
                eVar.n(mainActivity.getString(C2030R.string.tab_chat));
            }
        }
        if (string.equalsIgnoreCase("2")) {
            if (i8 == 0) {
                eVar.n(mainActivity.getString(C2030R.string.tab_official));
            } else if (i8 == 1) {
                eVar.n(mainActivity.getString(C2030R.string.tab_network));
            } else if (i8 == 2) {
                eVar.n(mainActivity.getString(C2030R.string.tab_manual));
            } else if (i8 == 3) {
                eVar.n(mainActivity.getString(C2030R.string.tab_chat));
            }
        }
        if (!string.equalsIgnoreCase("3")) {
            return;
        }
        if (i8 == 0) {
            eVar.n(mainActivity.getString(C2030R.string.tab_chat));
        } else if (i8 == 1) {
            eVar.n(mainActivity.getString(C2030R.string.tab_network));
        } else if (i8 == 2) {
            eVar.n(mainActivity.getString(C2030R.string.tab_manual));
        } else if (i8 == 3) {
            eVar.n(mainActivity.getString(C2030R.string.tab_official));
        }
    }

    private boolean C1() {
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

    public static /* synthetic */ void D0(MainActivity mainActivity, FusedLocationProviderClient fusedLocationProviderClient, Location location) {
        if (location != null) {
            SharedPreferences.Editor edit = mainActivity.getSharedPreferences(MainActivity.class.getSimpleName(), 0).edit();
            float latitude = (float) location.getLatitude();
            float longitude = (float) location.getLongitude();
            float accuracy = location.getAccuracy();
            long time = location.getTime();
            edit.putFloat("current_latitude", latitude);
            edit.putFloat("current_longitude", longitude);
            edit.putFloat("current_accuracy", accuracy);
            edit.putLong("current_location_time", time);
            edit.apply();
            mainActivity.v1((double) latitude, (double) longitude);
            return;
        }
        mainActivity.getClass();
        CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        mainActivity.f13279d0 = cancellationTokenSource;
        fusedLocationProviderClient.getCurrentLocation(102, cancellationTokenSource.getToken()).addOnSuccessListener(new C1898y2(mainActivity));
    }

    private void D1() {
        AdView adView = new AdView(this);
        this.f13266Q = adView;
        adView.setAdUnitId("ca-app-pub-4050044861382446/6189681827");
        this.f13265P.removeAllViews();
        this.f13265P.addView(this.f13266Q);
        this.f13266Q.setAdSize(o1());
        AdRequest build = new AdRequest.Builder().build();
        this.f13266Q.setAdListener(new a());
        this.f13266Q.loadAd(build);
    }

    public static /* synthetic */ void E0(MainActivity mainActivity, boolean z7, FusedLocationProviderClient fusedLocationProviderClient, Location location) {
        if (location != null) {
            SharedPreferences sharedPreferences = mainActivity.getSharedPreferences(MainActivity.class.getSimpleName(), 0);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            String string = sharedPreferences.getString("android_id_eqn", "0");
            float f8 = sharedPreferences.getFloat("last_db_saved_lat", BitmapDescriptorFactory.HUE_RED);
            float f9 = sharedPreferences.getFloat("last_db_saved_lon", BitmapDescriptorFactory.HUE_RED);
            float latitude = (float) location.getLatitude();
            float longitude = (float) location.getLongitude();
            float accuracy = location.getAccuracy();
            long time = location.getTime();
            if (latitude != BitmapDescriptorFactory.HUE_RED && longitude != BitmapDescriptorFactory.HUE_RED) {
                edit.putFloat("current_latitude", latitude);
                edit.putFloat("current_longitude", longitude);
                edit.putFloat("current_accuracy", accuracy);
                edit.putLong("current_location_time", time);
                edit.apply();
                mainActivity.v1((double) latitude, (double) longitude);
                if (!string.equalsIgnoreCase("0") && z7 && mainActivity.A1()) {
                    new j(string, latitude, longitude, accuracy, f8, f9).execute(new Context[0]);
                    return;
                }
                return;
            }
            return;
        }
        MainActivity mainActivity2 = mainActivity;
        mainActivity2.getClass();
        CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        mainActivity2.f13279d0 = cancellationTokenSource;
        fusedLocationProviderClient.getCurrentLocation(102, cancellationTokenSource.getToken()).addOnSuccessListener(new C1904z2(mainActivity2));
    }

    private void E1() {
        InterstitialAd.load(this, "ca-app-pub-4050044861382446/3948977934", new AdRequest.Builder().build(), new b());
    }

    public static /* synthetic */ void F0(MainActivity mainActivity) {
        if (!mainActivity.isFinishing()) {
            new AlertDialog.Builder(mainActivity).setMessage(mainActivity.getString(C2030R.string.ads_no_consent)).setTitle(C2030R.string.app_name).setIcon(2131230872).setCancelable(false).setNegativeButton(mainActivity.getString(C2030R.string.ads_buy_pro), new D2(mainActivity)).setPositiveButton(mainActivity.getString(C2030R.string.ads_give_consent), new E2(mainActivity)).show();
        }
    }

    private void F1(String str) {
        C1050a a8 = C1050a.c(this).d(this).b().a();
        this.f13278c0 = a8;
        a8.f(new d(str));
    }

    public static /* synthetic */ void G0(MainActivity mainActivity, String str, String str2, Purchase purchase, C1053d dVar) {
        mainActivity.getClass();
        if (dVar.b() == 0 && str != null) {
            if (str.equals("pro") || str.equals("pro_discount")) {
                new e(str2, purchase.e(), purchase.a(), (String) purchase.c().get(0)).execute(new Context[]{mainActivity});
            }
            if (str.equalsIgnoreCase("top_10k_lifetime") || str.equalsIgnoreCase("top_100k_lifetime")) {
                new k(str2, purchase.e(), purchase.a(), str).execute(new Context[]{mainActivity});
            }
        }
    }

    private void G1() {
        SharedPreferences sharedPreferences = getSharedPreferences("no_backup_pref", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (!sharedPreferences.getBoolean("permission_message_shown", false) || androidx.core.app.b.i(this, "android.permission.ACCESS_FINE_LOCATION")) {
            int i8 = Build.VERSION.SDK_INT;
            if (i8 >= 30) {
                if (androidx.core.content.a.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") != 0) {
                    new AlertDialog.Builder(this).setTitle(C2030R.string.app_name).setMessage(C2030R.string.permission_location_rationale).setPositiveButton(17039370, new C1838o2(this)).setIcon(2131230872).show();
                }
            } else if (i8 == 29) {
                new AlertDialog.Builder(this).setTitle(C2030R.string.app_name).setMessage(C2030R.string.permission_location_rationale_pie).setPositiveButton(17039370, new C1844p2(this)).setIcon(2131230872).show();
            } else {
                new AlertDialog.Builder(this).setTitle(C2030R.string.app_name).setMessage(C2030R.string.permission_location_rationale).setPositiveButton(17039370, new C1850q2(this)).setIcon(2131230872).show();
            }
            edit.putBoolean("permission_message_shown", true);
            edit.apply();
        }
    }

    public static /* synthetic */ void H0(MainActivity mainActivity) {
        if (!mainActivity.f13284i0) {
            mainActivity.m1();
        }
    }

    private void H1() {
        if (Build.VERSION.SDK_INT >= 33) {
            if (androidx.core.content.a.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS") != 0) {
                androidx.core.app.b.f(this, new String[]{"android.permission.POST_NOTIFICATIONS"}, 991);
            } else if (androidx.core.content.a.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") != 0) {
                G1();
            } else {
                u1();
            }
        } else if (androidx.core.content.a.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") != 0) {
            G1();
        } else {
            u1();
        }
    }

    public static /* synthetic */ void I0(MainActivity mainActivity, DialogInterface dialogInterface, int i8) {
        mainActivity.getClass();
        H3.f.c(mainActivity, new L2(mainActivity), new M2());
        mainActivity.f13284i0 = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void I1() {
        /*
            r11 = this;
            r0 = 1
            r1 = 0
            android.content.SharedPreferences$Editor r2 = r11.f13272W
            if (r2 == 0) goto L_0x0062
            java.lang.String r3 = "pro_owned"
            boolean r4 = r11.f13274Y
            r2.putBoolean(r3, r4)
            android.content.SharedPreferences$Editor r2 = r11.f13272W
            java.lang.String r3 = "top10k_owned"
            boolean r4 = r11.f13275Z
            r2.putBoolean(r3, r4)
            android.content.SharedPreferences$Editor r2 = r11.f13272W
            java.lang.String r3 = "top100k_owned"
            boolean r4 = r11.f13276a0
            r2.putBoolean(r3, r4)
            boolean r2 = r11.f13274Y
            if (r2 != 0) goto L_0x002e
            boolean r2 = r11.f13275Z
            if (r2 != 0) goto L_0x002e
            boolean r2 = r11.f13276a0
            if (r2 == 0) goto L_0x002c
            goto L_0x002e
        L_0x002c:
            r2 = r1
            goto L_0x002f
        L_0x002e:
            r2 = r0
        L_0x002f:
            r11.f13277b0 = r2
            android.content.SharedPreferences$Editor r3 = r11.f13272W
            java.lang.String r4 = "pro_features"
            r3.putBoolean(r4, r2)
            android.content.SharedPreferences$Editor r2 = r11.f13272W
            r2.apply()
            android.content.SharedPreferences r2 = r11.f13270U
            java.lang.String r3 = "last_pro_owned"
            boolean r2 = r2.getBoolean(r3, r1)
            android.content.SharedPreferences r3 = r11.f13270U
            java.lang.String r4 = "last_top10k_owned"
            boolean r3 = r3.getBoolean(r4, r1)
            android.content.SharedPreferences r4 = r11.f13270U
            java.lang.String r5 = "last_top100k_owned"
            boolean r4 = r4.getBoolean(r5, r1)
            boolean r5 = r11.f13274Y
            if (r5 != r2) goto L_0x0064
            boolean r2 = r11.f13275Z
            if (r2 != r3) goto L_0x0064
            boolean r2 = r11.f13276a0
            if (r2 == r4) goto L_0x0062
            goto L_0x0064
        L_0x0062:
            r6 = r11
            goto L_0x0081
        L_0x0064:
            android.content.SharedPreferences r2 = r11.f13270U
            java.lang.String r3 = "android_id_eqn"
            java.lang.String r4 = "0"
            java.lang.String r7 = r2.getString(r3, r4)
            com.finazzi.distquake.MainActivity$h r5 = new com.finazzi.distquake.MainActivity$h
            boolean r8 = r11.f13274Y
            boolean r9 = r11.f13275Z
            boolean r10 = r11.f13276a0
            r6 = r11
            r5.<init>(r7, r8, r9, r10)
            android.content.Context[] r0 = new android.content.Context[r0]
            r0[r1] = r6
            r5.execute(r0)
        L_0x0081:
            com.google.android.gms.ads.AdView r0 = r6.f13266Q
            if (r0 == 0) goto L_0x0090
            boolean r0 = r6.f13277b0
            if (r0 == 0) goto L_0x0090
            android.widget.FrameLayout r0 = r6.f13265P
            if (r0 == 0) goto L_0x0090
            r0.removeAllViews()
        L_0x0090:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.MainActivity.I1():void");
    }

    public static /* synthetic */ void J0(MainActivity mainActivity, String str, Purchase purchase, C1053d dVar) {
        mainActivity.getClass();
        if (dVar.b() == 0) {
            MainActivity mainActivity2 = mainActivity;
            new k(str, purchase.e(), purchase.a(), (String) purchase.c().get(0)).execute(new Context[]{mainActivity2});
        }
    }

    private void J1(String str) {
        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.class.getSimpleName(), 0);
        new l(this, sharedPreferences.getString("android_id_eqn", "0"), str, sharedPreferences.getFloat("current_latitude", BitmapDescriptorFactory.HUE_RED), sharedPreferences.getFloat("current_longitude", BitmapDescriptorFactory.HUE_RED), (a) null).execute(new Context[]{this});
    }

    public static /* synthetic */ void K0(DialogInterface dialogInterface, int i8) {
    }

    private void K1() {
        FirebaseMessaging.p().E("global").addOnCompleteListener(new C2(this));
    }

    public static /* synthetic */ void L0(MainActivity mainActivity, SharedPreferences.Editor editor, String str, double d8, double d9, Task task) {
        mainActivity.getClass();
        Class<MainActivity> cls = MainActivity.class;
        if (task.isSuccessful()) {
            editor.putString("topic_last_tile_subscribed", str);
            editor.putBoolean("topic_tile_subscribed_successfully", true);
            editor.putFloat("topic_last_latitude_subscribed", (float) d8);
            editor.putFloat("topic_last_longitude_subscribed", (float) d9);
            editor.putLong("last_FCM_registered_topic_tile_time", System.currentTimeMillis());
            new i(mainActivity.getSharedPreferences(cls.getSimpleName(), 0).getString("android_id_eqn", "0"), str).execute(new Context[]{mainActivity});
        } else {
            editor.putBoolean("topic_tile_subscribed_successfully", false);
            new i(mainActivity.getSharedPreferences(cls.getSimpleName(), 0).getString("android_id_eqn", "0"), RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).execute(new Context[]{mainActivity});
        }
        editor.apply();
    }

    private void L1(double d8, double d9) {
        String str = "x" + Integer.toString((int) Math.floor((180.0d + d9) / 10.0d)) + "y" + Integer.toString((int) Math.floor((90.0d + d8) / 10.0d));
        SharedPreferences sharedPreferences = getSharedPreferences("no_backup_pref", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        String string = sharedPreferences.getString("topic_last_tile_subscribed", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        if (!string.isEmpty()) {
            FirebaseMessaging.p().H(string).addOnCompleteListener(new H2(this, edit, str, d8, d9, string));
        } else {
            FirebaseMessaging.p().E(str).addOnCompleteListener(new I2(this, edit, str, d8, d9));
        }
    }

    public static /* synthetic */ void M0(MainActivity mainActivity, H3.e eVar) {
        if (eVar != null) {
            mainActivity.getClass();
            Log.w("EQN", String.format("%s: %s", new Object[]{Integer.valueOf(eVar.a()), eVar.b()}));
        }
        mainActivity.m1();
        if (mainActivity.f13282g0.canRequestAds()) {
            mainActivity.z1();
        }
    }

    public static /* synthetic */ void N0(MainActivity mainActivity, Location location) {
        if (location != null) {
            SharedPreferences.Editor edit = mainActivity.getSharedPreferences(MainActivity.class.getSimpleName(), 0).edit();
            float latitude = (float) location.getLatitude();
            float longitude = (float) location.getLongitude();
            float accuracy = location.getAccuracy();
            long time = location.getTime();
            edit.putFloat("current_latitude", latitude);
            edit.putFloat("current_longitude", longitude);
            edit.putFloat("current_accuracy", accuracy);
            edit.putLong("current_location_time", time);
            edit.apply();
            mainActivity.v1((double) latitude, (double) longitude);
            return;
        }
        mainActivity.getClass();
    }

    public static /* synthetic */ void O0(MainActivity mainActivity, SharedPreferences.Editor editor, String str, double d8, double d9, String str2, Task task) {
        mainActivity.getClass();
        if (task.isSuccessful()) {
            editor.putString("topic_last_tile_subscribed", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
            editor.putBoolean("topic_tile_unsubscribed_successfully", true);
            editor.apply();
            FirebaseMessaging.p().E(str).addOnCompleteListener(new K2(mainActivity, editor, str, d8, d9));
            return;
        }
        editor.putBoolean("topic_tile_unsubscribed_successfully", false);
        editor.putBoolean("topic_tile_subscribed_successfully", false);
        editor.putString("topic_tile_unsubscribed_unsuccessfully", str2);
        editor.apply();
    }

    public static /* synthetic */ void P0(MainActivity mainActivity, TabLayout.e eVar, int i8) {
        String string = mainActivity.f13271V.getString("eqn_first_tab", "0");
        if (string.equalsIgnoreCase("0")) {
            if (i8 == 0) {
                eVar.n(mainActivity.getString(C2030R.string.tab_network));
            } else if (i8 == 1) {
                eVar.n(mainActivity.getString(C2030R.string.tab_manual));
            } else if (i8 == 2) {
                eVar.n(mainActivity.getString(C2030R.string.tab_official));
            } else if (i8 == 3) {
                eVar.n(mainActivity.getString(C2030R.string.tab_chat));
            }
        }
        if (string.equalsIgnoreCase("1")) {
            if (i8 == 0) {
                eVar.n(mainActivity.getString(C2030R.string.tab_manual));
            } else if (i8 == 1) {
                eVar.n(mainActivity.getString(C2030R.string.tab_network));
            } else if (i8 == 2) {
                eVar.n(mainActivity.getString(C2030R.string.tab_official));
            } else if (i8 == 3) {
                eVar.n(mainActivity.getString(C2030R.string.tab_chat));
            }
        }
        if (string.equalsIgnoreCase("2")) {
            if (i8 == 0) {
                eVar.n(mainActivity.getString(C2030R.string.tab_official));
            } else if (i8 == 1) {
                eVar.n(mainActivity.getString(C2030R.string.tab_network));
            } else if (i8 == 2) {
                eVar.n(mainActivity.getString(C2030R.string.tab_manual));
            } else if (i8 == 3) {
                eVar.n(mainActivity.getString(C2030R.string.tab_chat));
            }
        }
        if (!string.equalsIgnoreCase("3")) {
            return;
        }
        if (i8 == 0) {
            eVar.n(mainActivity.getString(C2030R.string.tab_chat));
        } else if (i8 == 1) {
            eVar.n(mainActivity.getString(C2030R.string.tab_network));
        } else if (i8 == 2) {
            eVar.n(mainActivity.getString(C2030R.string.tab_manual));
        } else if (i8 == 3) {
            eVar.n(mainActivity.getString(C2030R.string.tab_official));
        }
    }

    public static /* synthetic */ void Q0(DialogInterface dialogInterface, int i8) {
    }

    public static /* synthetic */ void R0(MainActivity mainActivity, Location location) {
        if (location != null) {
            SharedPreferences.Editor edit = mainActivity.getSharedPreferences(MainActivity.class.getSimpleName(), 0).edit();
            float latitude = (float) location.getLatitude();
            float longitude = (float) location.getLongitude();
            float accuracy = location.getAccuracy();
            long time = location.getTime();
            edit.putFloat("current_latitude", latitude);
            edit.putFloat("current_longitude", longitude);
            edit.putFloat("current_accuracy", accuracy);
            edit.putLong("current_location_time", time);
            edit.apply();
            mainActivity.v1((double) latitude, (double) longitude);
            return;
        }
        mainActivity.getClass();
    }

    public static /* synthetic */ void S0(MainActivity mainActivity, DialogInterface dialogInterface, int i8) {
        mainActivity.getClass();
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 30) {
            androidx.core.app.b.f(mainActivity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
        } else if (i9 == 29) {
            androidx.core.app.b.f(mainActivity, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_BACKGROUND_LOCATION"}, 1);
        } else {
            androidx.core.app.b.f(mainActivity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
        }
    }

    public static /* synthetic */ void T0(MainActivity mainActivity, DialogInterface dialogInterface, int i8) {
        mainActivity.getClass();
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 30) {
            androidx.core.app.b.f(mainActivity, new String[]{"android.permission.ACCESS_BACKGROUND_LOCATION"}, 1);
        } else if (i9 == 29) {
            androidx.core.app.b.f(mainActivity, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_BACKGROUND_LOCATION"}, 1);
        } else {
            androidx.core.app.b.f(mainActivity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
        }
    }

    public static /* synthetic */ void U0(MainActivity mainActivity, Task task) {
        SharedPreferences.Editor edit = mainActivity.getSharedPreferences("no_backup_pref", 0).edit();
        edit.putBoolean("topic_global_subscribed", task.isSuccessful());
        if (task.isSuccessful()) {
            edit.putLong("last_FCM_registered_topic_global_time", System.currentTimeMillis());
        }
        edit.apply();
    }

    public static /* synthetic */ void V0(MainActivity mainActivity, View view) {
        mainActivity.getClass();
        Intent intent = new Intent(mainActivity, WebViewActivity.class);
        intent.putExtra("com.finazzi.distquake.map_type", 5);
        intent.putExtra("com.finazzi.distquake.url", mainActivity.getString(C2030R.string.website) + "privacy/");
        mainActivity.startActivity(intent);
    }

    public static /* synthetic */ void W0(MainActivity mainActivity, SharedPreferences.Editor editor, String str, double d8, double d9, Task task) {
        mainActivity.getClass();
        Class<MainActivity> cls = MainActivity.class;
        if (task.isSuccessful()) {
            editor.putString("topic_last_tile_subscribed", str);
            editor.putBoolean("topic_tile_subscribed_successfully", true);
            editor.putFloat("topic_last_latitude_subscribed", (float) d8);
            editor.putFloat("topic_last_longitude_subscribed", (float) d9);
            editor.putLong("last_FCM_registered_topic_tile_time", System.currentTimeMillis());
            new i(mainActivity.getSharedPreferences(cls.getSimpleName(), 0).getString("android_id_eqn", "0"), str).execute(new Context[]{mainActivity});
        } else {
            editor.putBoolean("topic_tile_subscribed_successfully", false);
            new i(mainActivity.getSharedPreferences(cls.getSimpleName(), 0).getString("android_id_eqn", "0"), RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).execute(new Context[]{mainActivity});
        }
        editor.apply();
    }

    public static /* synthetic */ void Z0(DialogInterface dialogInterface, int i8) {
    }

    public static /* synthetic */ void e0(DialogInterface dialogInterface, int i8) {
    }

    public static /* synthetic */ void f0(DialogInterface dialogInterface, int i8) {
    }

    public static /* synthetic */ void g0(MainActivity mainActivity, String str, C1053d dVar, List list) {
        mainActivity.getClass();
        if (list.size() > 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                C1055f.b a8 = ((C1055f) it.next()).a();
                if (a8 != null) {
                    mainActivity.f13272W.putString("pro_conversion_price", a8.a());
                    mainActivity.f13272W.apply();
                }
            }
        }
        mainActivity.h1(str);
    }

    /* access modifiers changed from: private */
    public void g1(String str) {
        this.f13278c0.d(C1056g.a().b(com.google.common.collect.k.t(C1056g.b.a().b("pro").c("inapp").a())).a(), new C1868t2(this, str));
    }

    public static /* synthetic */ void h0(MainActivity mainActivity, String str, C1053d dVar, List list) {
        String str2;
        MainActivity mainActivity2;
        mainActivity.getClass();
        if (dVar.b() == 0) {
            boolean z7 = mainActivity.getSharedPreferences("no_backup_pref", 0).getBoolean("update_server2", true);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Purchase purchase = (Purchase) it.next();
                String str3 = (String) purchase.c().get(0);
                String a8 = purchase.a();
                if (a8 != null) {
                    if (a8.length() > 24) {
                        a8 = a8.substring(0, 23);
                    }
                    mainActivity.f13272W.putString("order_id_sub", a8);
                    mainActivity.f13272W.apply();
                }
                if (purchase.d() == 1 && purchase.g()) {
                    if (str3.equalsIgnoreCase("top_100") || str3.equalsIgnoreCase("top_100a") || str3.equalsIgnoreCase("top_1000") || str3.equalsIgnoreCase("top_1000a") || str3.equalsIgnoreCase("top_100a_annual") || str3.equalsIgnoreCase("top_1000a_annual") || str3.equalsIgnoreCase("top_10000") || str3.equalsIgnoreCase("top_10000a") || str3.equalsIgnoreCase("top_10000a_annual") || str3.equalsIgnoreCase("top_10k") || str3.equalsIgnoreCase("top_10k_v2") || str3.equalsIgnoreCase("top_10k_annual") || str3.equalsIgnoreCase("top_10k_annual_v2") || str3.equalsIgnoreCase("top_10k_annual_v3")) {
                        mainActivity.f13275Z = true;
                    }
                    if (str3.equalsIgnoreCase("top_100k") || str3.equalsIgnoreCase("top_100k_v2") || str3.equalsIgnoreCase("top_100k_annual") || str3.equalsIgnoreCase("top_100k_annual_v2") || str3.equalsIgnoreCase("top_100k_annual_v3")) {
                        mainActivity.f13276a0 = true;
                    }
                }
                if (!purchase.g()) {
                    mainActivity.f13278c0.a(C1587a.b().b(purchase.e()).a(), new Q2(mainActivity, str, purchase));
                } else if (z7 && !str.equalsIgnoreCase("0")) {
                    mainActivity2 = mainActivity;
                    str2 = str;
                    new k(str2, purchase.e(), purchase.a(), (String) purchase.c().get(0)).execute(new Context[]{mainActivity2});
                    mainActivity = mainActivity2;
                    str = str2;
                }
                mainActivity2 = mainActivity;
                str2 = str;
                mainActivity = mainActivity2;
                str = str2;
            }
            mainActivity.I1();
            return;
        }
        mainActivity.I1();
    }

    private void h1(String str) {
        this.f13278c0.e(n.a().b("inapp").a(), new G2(this, str));
    }

    public static /* synthetic */ void i0(MainActivity mainActivity, H3.b bVar) {
        mainActivity.getClass();
        bVar.show(mainActivity, new O2(mainActivity));
    }

    private void i1(String str) {
        this.f13278c0.e(n.a().b("subs").a(), new P2(this, str));
    }

    public static /* synthetic */ void j0(MainActivity mainActivity, String str, C1053d dVar, List list) {
        MainActivity mainActivity2 = mainActivity;
        String str2 = str;
        mainActivity2.getClass();
        if (dVar.b() == 0) {
            SharedPreferences sharedPreferences = mainActivity2.getSharedPreferences("no_backup_pref", 0);
            boolean z7 = sharedPreferences.getBoolean("update_server2_pro", true);
            boolean z8 = sharedPreferences.getBoolean("update_server2_lifetime", true);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Purchase purchase = (Purchase) it.next();
                String str3 = (String) purchase.c().get(0);
                String a8 = purchase.a();
                if (a8 != null) {
                    if (a8.length() > 24) {
                        a8 = a8.substring(0, 23);
                    }
                    mainActivity2.f13272W.putString("order_id_pro", a8);
                    mainActivity2.f13272W.apply();
                }
                if (purchase.d() == 1 && purchase.g() && str3 != null) {
                    if (str3.equals("pro") || str3.equals("pro_discount")) {
                        mainActivity2.f13274Y = true;
                        mainActivity2.f13277b0 = true;
                    }
                    if (str3.equalsIgnoreCase("top_10k_lifetime")) {
                        mainActivity2.f13275Z = true;
                        mainActivity2.f13277b0 = true;
                    }
                    if (str3.equalsIgnoreCase("top_100k_lifetime")) {
                        mainActivity2.f13276a0 = true;
                        mainActivity2.f13277b0 = true;
                    }
                }
                if (!purchase.g()) {
                    mainActivity2.f13278c0.a(C1587a.b().b(purchase.e()).a(), new N2(mainActivity2, str3, str2, purchase));
                } else if (str3 != null) {
                    if ((str3.equals("pro") || str3.equals("pro_discount")) && z7 && !str2.equalsIgnoreCase("0")) {
                        new e(str2, purchase.e(), purchase.a(), (String) purchase.c().get(0)).execute(new Context[]{mainActivity});
                    }
                    if ((str3.equalsIgnoreCase("top_10k_lifetime") || str3.equalsIgnoreCase("top_100k_lifetime")) && z8 && !str2.equalsIgnoreCase("0")) {
                        new k(str2, purchase.e(), purchase.a(), str3).execute(new Context[]{mainActivity});
                    }
                }
                mainActivity2 = mainActivity;
                str2 = str;
            }
            mainActivity.i1(str);
        }
    }

    public static /* synthetic */ void l0(MainActivity mainActivity, View view) {
        mainActivity.getClass();
        Intent intent = new Intent(mainActivity, WebViewActivity.class);
        intent.putExtra("com.finazzi.distquake.map_type", 5);
        intent.putExtra("com.finazzi.distquake.url", mainActivity.getString(C2030R.string.website) + "terms-conditions/");
        mainActivity.startActivity(intent);
    }

    private void l1() {
        ActivityManager activityManager;
        if (Build.VERSION.SDK_INT >= 28 && (activityManager = (ActivityManager) getSystemService("activity")) != null && activityManager.isBackgroundRestricted()) {
            new AlertDialog.Builder(this).setIcon(17301543).setMessage(getString(C2030R.string.main_background9)).setPositiveButton(17039370, new B2()).show();
        }
    }

    public static /* synthetic */ void m0(MainActivity mainActivity, DialogInterface dialogInterface, int i8) {
        mainActivity.f13272W.putBoolean("conditions_accepted", true);
        mainActivity.f13272W.apply();
        mainActivity.H1();
        dialogInterface.cancel();
    }

    public static /* synthetic */ void n0(MainActivity mainActivity, DialogInterface dialogInterface, int i8) {
        mainActivity.getClass();
        androidx.core.app.b.f(mainActivity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
    }

    private void n1() {
        LocationServices.getSettingsClient((Activity) this).checkLocationSettings(new LocationSettingsRequest.Builder().addLocationRequest(new LocationRequest.Builder(102, 1200000).setMinUpdateIntervalMillis(120000).setMinUpdateDistanceMeters(BitmapDescriptorFactory.HUE_RED).build()).build()).addOnCompleteListener(new C1856r2(this));
    }

    public static /* synthetic */ void o0(MainActivity mainActivity, Task task) {
        mainActivity.getClass();
        if (!task.isSuccessful()) {
            Log.w("EQN", "Fetching FCM registration token failed", task.getException());
            return;
        }
        String str = (String) task.getResult();
        if (str != null && !str.equalsIgnoreCase(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED)) {
            mainActivity.J1(str);
        }
    }

    private AdSize o1() {
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this, (int) (((float) displayMetrics.widthPixels) / displayMetrics.density));
    }

    public static /* synthetic */ void p0(MainActivity mainActivity, H3.e eVar) {
        mainActivity.getClass();
        Log.w("EQN", String.format("%s: %s", new Object[]{Integer.valueOf(eVar.a()), eVar.b()}));
        mainActivity.f13284i0 = false;
    }

    private static String p1(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.getPackageInfo(context.getPackageName(), 0).versionName;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    }

    public static /* synthetic */ void q0(MainActivity mainActivity, InitializationStatus initializationStatus) {
        mainActivity.f13265P = (FrameLayout) mainActivity.findViewById(C2030R.id.ad_view_container);
        mainActivity.D1();
    }

    private void q1() {
        if (androidx.core.content.a.checkSelfPermission(getApplicationContext(), "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient((Activity) this);
            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new C1784f2(this, fusedLocationProviderClient));
        }
    }

    public static /* synthetic */ void r0(MainActivity mainActivity) {
        mainActivity.getClass();
        H3.f.b(mainActivity, new F2(mainActivity));
    }

    private String r1(double d8, double d9) {
        return "x" + Integer.toString((int) Math.floor((d9 + 180.0d) / 10.0d)) + "y" + Integer.toString((int) Math.floor((d8 + 90.0d) / 10.0d));
    }

    public static /* synthetic */ void s0(MainActivity mainActivity, DialogInterface dialogInterface, int i8) {
        mainActivity.getClass();
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 30) {
            androidx.core.app.b.f(mainActivity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
        } else if (i9 == 29) {
            androidx.core.app.b.f(mainActivity, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_BACKGROUND_LOCATION"}, 1);
        } else {
            androidx.core.app.b.f(mainActivity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
        }
    }

    private double s1(double d8, double d9, double d10, double d11) {
        double pow = Math.pow(Math.sin(((((d8 - d10) / 360.0d) * 2.0d) * 3.141592653589793d) / 2.0d), 2.0d) + (Math.cos((d8 / 360.0d) * 2.0d * 3.141592653589793d) * Math.cos((d10 / 360.0d) * 2.0d * 3.141592653589793d) * Math.pow(Math.sin(((((d9 - d11) / 360.0d) * 2.0d) * 3.141592653589793d) / 2.0d), 2.0d));
        return Math.atan2(Math.sqrt(pow), Math.sqrt(1.0d - pow)) * 2.0d * 6371.0d;
    }

    public static /* synthetic */ void t0(MainActivity mainActivity, H3.e eVar) {
        if (eVar != null) {
            mainActivity.getClass();
            Log.w("EQN", String.format("%s: %s", new Object[]{Integer.valueOf(eVar.a()), eVar.b()}));
        }
        if (!mainActivity.f13284i0) {
            mainActivity.m1();
        }
        if (mainActivity.f13282g0.canRequestAds()) {
            mainActivity.z1();
        }
    }

    private void t1() {
        H3.d a8 = new d.a().b(false).a();
        H3.c a9 = H3.f.a(this);
        this.f13282g0 = a9;
        a9.requestConsentInfoUpdate(this, a8, new C1874u2(this), new C1880v2());
        if (this.f13282g0.canRequestAds()) {
            z1();
        }
    }

    public static /* synthetic */ void u0(H3.e eVar) {
    }

    private void u1() {
        n1();
        boolean z7 = this.f13270U.getBoolean("location_first_time", true);
        if (z7 || !C1()) {
            FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient((Activity) this);
            if (androidx.core.content.a.checkSelfPermission(getApplicationContext(), "android.permission.ACCESS_COARSE_LOCATION") == 0 || androidx.core.content.a.checkSelfPermission(getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION") == 0) {
                fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new C1790g2(this, z7, fusedLocationProviderClient));
            }
        }
        if (!getSharedPreferences("no_backup_pref", 0).getBoolean("topic_global_subscribed", false)) {
            K1();
        }
        if (!this.f13277b0) {
            t1();
        }
    }

    public static /* synthetic */ void v0(MainActivity mainActivity, DialogInterface dialogInterface, int i8) {
        mainActivity.getClass();
        androidx.core.app.b.f(mainActivity, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_BACKGROUND_LOCATION"}, 1);
    }

    private void v1(double d8, double d9) {
        SharedPreferences sharedPreferences = getSharedPreferences("no_backup_pref", 0);
        double d10 = d8;
        double d11 = d9;
        double s12 = s1(d10, d11, (double) sharedPreferences.getFloat("topic_last_latitude_subscribed", BitmapDescriptorFactory.HUE_RED), (double) sharedPreferences.getFloat("topic_last_longitude_subscribed", BitmapDescriptorFactory.HUE_RED));
        String string = sharedPreferences.getString("topic_last_tile_subscribed", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        if ((s12 > 100.0d || string.isEmpty()) && !string.equals(r1(d8, d9))) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean("topic_tile_unsubscribed_successfully", false);
            edit.apply();
            L1(d8, d9);
        }
    }

    public static /* synthetic */ void w0(MainActivity mainActivity, DialogInterface dialogInterface, int i8) {
        mainActivity.f13284i0 = false;
        mainActivity.startActivity(new Intent().setClass(mainActivity, ToProActivity.class));
    }

    private static boolean w1(String str, int i8) {
        if (str.length() < i8 || str.charAt(i8 - 1) != '1') {
            return false;
        }
        return true;
    }

    public static /* synthetic */ void x0(MainActivity mainActivity, String str, String str2, String str3, C1053d dVar) {
        mainActivity.getClass();
        if (dVar.b() == 0) {
            Class<MainActivity> cls = MainActivity.class;
            if (str.startsWith("pro")) {
                SharedPreferences sharedPreferences = mainActivity.getSharedPreferences(cls.getSimpleName(), 0);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putBoolean("pro_owned", true);
                edit.apply();
                mainActivity.f13274Y = true;
                mainActivity.f13277b0 = true;
                new f(sharedPreferences.getString("android_id_eqn", "0"), str2, str3, str).execute(new Context[]{mainActivity});
            }
            if (str.startsWith("top")) {
                String string = mainActivity.getSharedPreferences(cls.getSimpleName(), 0).getString("android_id_eqn", "0");
                mainActivity.f13277b0 = true;
                new g(string, str2, str3, str).execute(new Context[]{mainActivity});
            }
        }
    }

    private static boolean x1(List list, String str, boolean z7) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!w1(str, ((Integer) it.next()).intValue())) {
                return false;
            }
        }
        return z7;
    }

    public static /* synthetic */ void y0(DialogInterface dialogInterface, int i8) {
    }

    private static boolean y1(List list, String str, String str2, boolean z7, boolean z8) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            if (w1(str2, intValue) && z8) {
                return true;
            }
            if (w1(str, intValue) && z7) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ void z0(MainActivity mainActivity, Task task) {
        mainActivity.getClass();
        try {
            LocationSettingsResponse locationSettingsResponse = (LocationSettingsResponse) task.getResult(ApiException.class);
            if (locationSettingsResponse != null) {
                locationSettingsResponse.getLocationSettingsStates();
            }
            mainActivity.q1();
        } catch (ApiException e8) {
            if (e8.getStatusCode() == 6) {
                try {
                    ((ResolvableApiException) e8).startResolutionForResult(mainActivity, 1002);
                } catch (IntentSender.SendIntentException | ClassCastException unused) {
                }
            }
        }
    }

    private void z1() {
        if (!this.f13283h0.getAndSet(true)) {
            MobileAds.initialize(this, new J2(this));
        }
    }

    public boolean B1() {
        if (androidx.preference.g.b(getApplicationContext()).getInt("IABTCF_gdprApplies", 0) == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        C1946a.l(this);
    }

    public boolean b(MenuItem menuItem) {
        Class<WebViewActivity> cls = WebViewActivity.class;
        switch (menuItem.getItemId()) {
            case C2030R.id.drawer_chat /*2131296575*/:
                Intent intent = new Intent(this, cls);
                intent.putExtra("com.finazzi.distquake.map_type", 6);
                intent.putExtra("com.finazzi.distquake.url", getString(C2030R.string.website) + "chatroom-rules/");
                startActivity(intent);
                return false;
            case C2030R.id.drawer_credits /*2131296576*/:
                Intent intent2 = new Intent(this, cls);
                intent2.putExtra("com.finazzi.distquake.map_type", 5);
                intent2.putExtra("com.finazzi.distquake.url", getString(C2030R.string.website) + "credits/");
                startActivity(intent2);
                return false;
            case C2030R.id.drawer_faq /*2131296577*/:
                Intent intent3 = new Intent(this, cls);
                intent3.putExtra("com.finazzi.distquake.map_type", 5);
                intent3.putExtra("com.finazzi.distquake.url", getString(C2030R.string.website) + "f-a-q/");
                startActivity(intent3);
                return false;
            case C2030R.id.drawer_help /*2131296578*/:
                Intent intent4 = new Intent(this, cls);
                intent4.putExtra("com.finazzi.distquake.map_type", 5);
                intent4.putExtra("com.finazzi.distquake.url", getString(C2030R.string.website) + "help/");
                startActivity(intent4);
                return false;
            case C2030R.id.drawer_info /*2131296579*/:
                Intent intent5 = new Intent(this, cls);
                intent5.putExtra("com.finazzi.distquake.map_type", 5);
                intent5.putExtra("com.finazzi.distquake.url", getString(C2030R.string.website));
                startActivity(intent5);
                return false;
            case C2030R.id.drawer_privacy /*2131296580*/:
                Intent intent6 = new Intent(this, cls);
                intent6.putExtra("com.finazzi.distquake.map_type", 5);
                intent6.putExtra("com.finazzi.distquake.url", getString(C2030R.string.website) + "privacy/");
                startActivity(intent6);
                return false;
            case C2030R.id.drawer_settings /*2131296581*/:
                startActivity(new Intent().setClass(this, Preferences.class));
                return false;
            case C2030R.id.drawer_sponsors /*2131296582*/:
                Intent intent7 = new Intent(this, cls);
                intent7.putExtra("com.finazzi.distquake.map_type", 5);
                intent7.putExtra("com.finazzi.distquake.url", getString(C2030R.string.website) + "sponsors/");
                startActivity(intent7);
                return false;
            case C2030R.id.drawer_terms /*2131296583*/:
                Intent intent8 = new Intent(this, cls);
                intent8.putExtra("com.finazzi.distquake.map_type", 5);
                intent8.putExtra("com.finazzi.distquake.url", getString(C2030R.string.website) + "terms-conditions/");
                startActivity(intent8);
                return false;
            default:
                return false;
        }
    }

    public boolean j1() {
        SharedPreferences b8 = androidx.preference.g.b(getApplicationContext());
        String string = b8.getString("IABTCF_PurposeConsents", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        String string2 = b8.getString("IABTCF_VendorConsents", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        String string3 = b8.getString("IABTCF_VendorLegitimateInterests", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        String string4 = b8.getString("IABTCF_PurposeLegitimateInterests", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        boolean w12 = w1(string2, 755);
        boolean w13 = w1(string3, 755);
        if (x1(Arrays.asList(new Integer[]{1}), string, w12)) {
            if (y1(Arrays.asList(new Integer[]{2, 7, 9, 10}), string, string4, w12, w13)) {
                return true;
            }
        }
        return false;
    }

    public boolean k1() {
        SharedPreferences b8 = androidx.preference.g.b(getApplicationContext());
        String string = b8.getString("IABTCF_PurposeConsents", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        String string2 = b8.getString("IABTCF_VendorConsents", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        String string3 = b8.getString("IABTCF_VendorLegitimateInterests", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        String string4 = b8.getString("IABTCF_PurposeLegitimateInterests", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        boolean w12 = w1(string2, 755);
        boolean w13 = w1(string3, 755);
        if (x1(Arrays.asList(new Integer[]{1, 3, 4}), string, w12)) {
            if (y1(Arrays.asList(new Integer[]{2, 7, 9, 10}), string, string4, w12, w13)) {
                return true;
            }
        }
        return false;
    }

    public void m1() {
        boolean k12 = k1();
        boolean j12 = j1();
        if (B1() && !k12 && !j12 && !this.f13284i0) {
            this.f13284i0 = true;
            H3.d a8 = new d.a().b(false).a();
            H3.c a9 = H3.f.a(this);
            this.f13282g0 = a9;
            a9.requestConsentInfoUpdate(this, a8, new C1886w2(this), new C1892x2(this));
        }
    }

    public void o(C1053d dVar, List list) {
        if (dVar.b() == 0 && list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Purchase purchase = (Purchase) it.next();
                String str = (String) purchase.c().get(0);
                String e8 = purchase.e();
                String a8 = purchase.a();
                if (purchase.d() == 1 && !purchase.g()) {
                    this.f13278c0.a(C1587a.b().b(purchase.e()).a(), new C1862s2(this, str, e8, a8));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i8, int i9, Intent intent) {
        if (i8 == 1001) {
            if (i9 == 0) {
                Toast.makeText(this, getString(C2030R.string.main_update), 0).show();
            }
            if (i9 == -1) {
                u1();
            }
        } else if (i8 != 1002) {
            super.onActivityResult(i8, i9, intent);
        } else if (i9 == -1) {
            q1();
        } else if (i9 == 0) {
            Toast.makeText(this, getString(C2030R.string.main_enable_geo), 1).show();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f13264O.g(configuration);
    }

    public void onCreate(Bundle bundle) {
        String str;
        Intent intent;
        String str2;
        boolean z7;
        String str3;
        String str4;
        boolean z8;
        Bundle extras;
        boolean z9;
        int i8;
        int i9;
        Bundle extras2;
        int i10;
        Bundle extras3;
        super.onCreate(bundle);
        I.c.c(this);
        setTheme(2131952296);
        setContentView((int) C2030R.layout.main);
        this.f13270U = getSharedPreferences(MainActivity.class.getSimpleName(), 0);
        this.f13271V = androidx.preference.g.b(getApplicationContext());
        this.f13272W = this.f13270U.edit();
        String string = this.f13270U.getString("android_id_eqn", "0");
        boolean z10 = this.f13270U.getBoolean("FCM_refresh", false);
        this.f13277b0 = this.f13270U.getBoolean("pro_features", false);
        this.f13273X = this.f13271V.getString("eqn_first_tab", "0");
        C0696d a8 = new C0696d.a().b(C0714w.CONNECTED).a();
        TimeUnit timeUnit = TimeUnit.MINUTES;
        C0693a aVar = C0693a.EXPONENTIAL;
        TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
        O h8 = O.h(this);
        C0700h hVar = C0700h.KEEP;
        h8.e("worker_location", hVar, (F) ((F.a) ((F.a) ((F.a) new F.a(WorkerLocation.class, 30, timeUnit).j(a8)).m(10, timeUnit)).i(aVar, 60000, timeUnit2)).b());
        TimeUnit timeUnit3 = TimeUnit.HOURS;
        String str5 = "firsttime2.txt";
        O.h(this).e("worker_FCM", hVar, (F) ((F.a) ((F.a) ((F.a) new F.a(WorkerFCMRegistration.class, 8, timeUnit3).j(a8)).m(8, timeUnit3)).i(aVar, 60000, timeUnit2)).b());
        String str6 = "EQN";
        O.h(this).e("worker_topic", hVar, (F) ((F.a) ((F.a) ((F.a) new F.a(WorkerTopic.class, 180, timeUnit).j(a8)).m(60, timeUnit)).i(aVar, 60000, timeUnit2)).b());
        O.h(this).e("worker_permission", hVar, (F) ((F.a) ((F.a) new F.a(WorkerPermission.class, 3, timeUnit3).m(20, timeUnit)).i(aVar, 600000, timeUnit2)).b());
        O.h(this).e("worker_sensors", hVar, (F) ((F.a) ((F.a) new F.a(WorkerSensors.class, 15, timeUnit).m(15, timeUnit)).i(aVar, 60000, timeUnit2)).b());
        F1(string);
        if (z10) {
            FirebaseMessaging.p().s().addOnCompleteListener(new W1(this));
        }
        androidx.preference.g.n(this, C2030R.xml.preferences_alerts, false);
        androidx.preference.g.n(this, C2030R.xml.preferences_networks, false);
        androidx.preference.g.n(this, C2030R.xml.preferences_reports, false);
        androidx.preference.g.n(this, C2030R.xml.preferences_map, false);
        androidx.preference.g.n(this, C2030R.xml.preferences_privatechat, false);
        Toolbar toolbar = (Toolbar) findViewById(C2030R.id.toolbar);
        b0(toolbar);
        NavigationView navigationView = (NavigationView) findViewById(C2030R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ((TextView) navigationView.n(0).findViewById(C2030R.id.textView1)).setText(getString(C2030R.string.main_version) + ": " + p1(getApplicationContext()));
        ImageView imageView = (ImageView) navigationView.n(0).findViewById(C2030R.id.header_image);
        if (!this.f13277b0) {
            toolbar.setLogo(2131230872);
            imageView.setImageResource(2131230873);
        } else {
            toolbar.setLogo(2131230875);
            imageView.setImageResource(2131230874);
        }
        imageView.setOnClickListener(new X1(this, string));
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(C2030R.id.drawerLayout);
        c cVar = new c(this, drawerLayout, toolbar, C2030R.string.drawer_open, C2030R.string.drawer_close);
        this.f13264O = cVar;
        drawerLayout.a(cVar);
        this.f13264O.e().c(getResources().getColor(C2030R.color.md_theme_primary));
        this.f13268S = (ViewPager2) findViewById(C2030R.id.pager);
        m mVar = new m(this);
        this.f13268S.setOffscreenPageLimit(1);
        this.f13268S.setAdapter(mVar);
        TabLayout tabLayout = (TabLayout) findViewById(C2030R.id.tab_layout);
        tabLayout.setTabMode(0);
        new com.google.android.material.tabs.d(tabLayout, this.f13268S, new Y1(this)).a();
        LinearLayout linearLayout = (LinearLayout) tabLayout.getChildAt(0);
        linearLayout.setShowDividers(2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-3355444);
        gradientDrawable.setSize(1, 1);
        linearLayout.setDividerPadding(20);
        linearLayout.setDividerDrawable(gradientDrawable);
        String string2 = this.f13271V.getString("eqn_first_tab", "0");
        Intent intent2 = getIntent();
        if (intent2.hasExtra("com.finazzi.distquake.realtime")) {
            if (string2.equalsIgnoreCase("0")) {
                this.f13268S.j(0, true);
            } else {
                this.f13268S.j(1, true);
            }
        }
        if (intent2.hasExtra("com.finazzi.distquake.fix")) {
            if (string2.equalsIgnoreCase("0")) {
                this.f13268S.j(0, true);
            } else {
                this.f13268S.j(1, true);
            }
            startActivity(new Intent().setClass(this, ProblemsActivity.class));
        }
        if (!intent2.hasExtra("com.finazzi.distquake.report") || (extras3 = intent2.getExtras()) == null) {
            str = str6;
        } else {
            double d8 = extras3.getDouble("com.finazzi.distquake.report_lat");
            str = str6;
            double d9 = extras3.getDouble("com.finazzi.distquake.report_lon");
            this.f13272W.putFloat("latitude_notification", (float) d8);
            this.f13272W.putFloat("longitude_notification", (float) d9);
            this.f13272W.putBoolean("open_report_map", true);
            this.f13272W.apply();
            if (string2.equalsIgnoreCase("0")) {
                this.f13268S.j(1, true);
            }
            if (string2.equalsIgnoreCase("1")) {
                this.f13268S.j(0, true);
            }
            if (string2.equalsIgnoreCase("2")) {
                this.f13268S.j(2, true);
            }
            if (string2.equalsIgnoreCase("3")) {
                this.f13268S.j(2, true);
            }
        }
        if (intent2.hasExtra("com.finazzi.distquake.send_report")) {
            if (string2.equalsIgnoreCase("0")) {
                this.f13268S.j(1, true);
            }
            if (string2.equalsIgnoreCase("1")) {
                this.f13268S.j(0, true);
            }
            if (string2.equalsIgnoreCase("2")) {
                this.f13268S.j(2, true);
            }
            if (string2.equalsIgnoreCase("3")) {
                this.f13268S.j(2, true);
            }
        }
        if (!intent2.hasExtra("com.finazzi.distquake.official") || (extras2 = intent2.getExtras()) == null) {
            intent = intent2;
            str2 = string;
            str4 = "2";
            z7 = true;
            str3 = "3";
        } else {
            String string3 = extras2.getString("com.finazzi.distquake.official_provider");
            double d10 = extras2.getDouble("com.finazzi.distquake.official_lat");
            double d11 = extras2.getDouble("com.finazzi.distquake.official_lon");
            String string4 = extras2.getString("com.finazzi.distquake.official_date");
            String str7 = "3";
            double d12 = extras2.getDouble("com.finazzi.distquake.official_mag");
            str2 = string;
            boolean z11 = extras2.getBoolean("com.finazzi.distquake.official_isstrong");
            intent = intent2;
            boolean z12 = extras2.getBoolean("com.finazzi.distquake.official_isnear");
            String str8 = "2";
            this.f13272W.putString("official_provider_notification", string3);
            this.f13272W.putFloat("official_lat_notification", (float) d10);
            this.f13272W.putFloat("official_lon_notification", (float) d11);
            this.f13272W.putString("official_date_notification", string4);
            this.f13272W.putFloat("official_mag_notification", (float) d12);
            this.f13272W.putBoolean("official_isstrong_notification", z11);
            this.f13272W.putBoolean("official_isnear_notification", z12);
            z7 = true;
            this.f13272W.putBoolean("official_notification", true);
            this.f13272W.apply();
            if (string2.equalsIgnoreCase("0")) {
                i10 = 2;
                this.f13268S.j(2, true);
            } else {
                i10 = 2;
            }
            if (string2.equalsIgnoreCase("1")) {
                this.f13268S.j(i10, true);
            }
            str4 = str8;
            if (string2.equalsIgnoreCase(str4)) {
                this.f13268S.j(0, true);
            }
            str3 = str7;
            if (string2.equalsIgnoreCase(str3)) {
                this.f13268S.j(3, true);
            }
        }
        Intent intent3 = intent;
        if (intent3.hasExtra("com.finazzi.distquake.friendship_type")) {
            this.f13272W.putBoolean("open_friendship", z7);
            this.f13272W.apply();
            if (string2.equalsIgnoreCase("0")) {
                i9 = 3;
                this.f13268S.j(3, z7);
            } else {
                i9 = 3;
            }
            if (string2.equalsIgnoreCase("1")) {
                this.f13268S.j(i9, z7);
            }
            if (string2.equalsIgnoreCase(str4)) {
                this.f13268S.j(i9, z7);
            }
            if (string2.equalsIgnoreCase(str3)) {
                this.f13268S.j(0, z7);
            }
        }
        if (intent3.hasExtra("com.finazzi.distquake.personal_chat") && (extras = intent3.getExtras()) != null) {
            int i11 = extras.getInt("com.finazzi.distquake.personal_chat_user_code");
            String string5 = extras.getString("com.finazzi.distquake.personal_chat_user_nick");
            this.f13272W.putBoolean("open_personal_chat", true);
            this.f13272W.putInt("personal_chat_user_code", i11);
            this.f13272W.putString("personal_chat_nick", string5);
            this.f13272W.apply();
            if (string2.equalsIgnoreCase("0")) {
                i8 = 3;
                z9 = true;
                this.f13268S.j(3, true);
            } else {
                i8 = 3;
                z9 = true;
            }
            if (string2.equalsIgnoreCase("1")) {
                this.f13268S.j(i8, z9);
            }
            if (string2.equalsIgnoreCase(str4)) {
                this.f13268S.j(i8, z9);
            }
            if (string2.equalsIgnoreCase(str3)) {
                this.f13268S.j(0, z9);
            }
        }
        if (intent3.hasExtra("from_alert_window")) {
            getWindow().addFlags(524288);
        }
        String str9 = str5;
        try {
            openFileInput(str9).close();
        } catch (FileNotFoundException unused) {
            String str10 = str;
            try {
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput(str9, 0), StandardCharsets.UTF_8);
                outputStreamWriter.write("void");
                outputStreamWriter.flush();
                outputStreamWriter.close();
            } catch (IOException e8) {
                if (e8.getMessage() != null) {
                    Log.d(str10, e8.getMessage());
                }
            }
        } catch (IOException e9) {
            if (e9.getMessage() != null) {
                Log.d(str, e9.getMessage());
            }
        }
        FirebaseAnalytics instance = FirebaseAnalytics.getInstance(this);
        String str11 = str2;
        if (!str11.equalsIgnoreCase("0")) {
            instance.a(str11);
            com.google.firebase.crashlytics.a.b().d(str11);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            String string6 = getString(C2030R.string.channel_realtime_name);
            String string7 = getString(C2030R.string.channel_realtime_description);
            NotificationChannel a9 = U1.a(getString(C2030R.string.channel_realtime), string6, 4);
            a9.setDescription(string7);
            a9.enableLights(true);
            a9.setLightColor(-65536);
            a9.enableVibration(true);
            a9.setLockscreenVisibility(1);
            a9.setBypassDnd(true);
            a9.setVibrationPattern(this.f13269T);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(a9);
            }
            String string8 = getString(C2030R.string.channel_countdown_name);
            String string9 = getString(C2030R.string.channel_countdown_description);
            NotificationChannel a10 = U1.a(getString(C2030R.string.channel_countdown), string8, 4);
            a10.setDescription(string9);
            a10.enableLights(true);
            a10.setLightColor(-65536);
            a10.enableVibration(false);
            a10.setLockscreenVisibility(1);
            a10.setBypassDnd(true);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(a10);
            }
            String string10 = getString(C2030R.string.channel_reports_name);
            String string11 = getString(C2030R.string.channel_reports_description);
            NotificationChannel a11 = U1.a(getString(C2030R.string.channel_reports), string10, 4);
            a11.setDescription(string11);
            a11.enableLights(true);
            a11.setLightColor(-65536);
            a11.enableVibration(true);
            a11.setBypassDnd(false);
            a11.setLockscreenVisibility(1);
            a11.setVibrationPattern(this.f13269T);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(a11);
            }
            String string12 = getString(C2030R.string.channel_official_name);
            String string13 = getString(C2030R.string.channel_official_description);
            NotificationChannel a12 = U1.a(getString(C2030R.string.channel_official), string12, 3);
            a12.setDescription(string13);
            a12.enableLights(true);
            a12.setLightColor(-65536);
            a12.enableVibration(true);
            a12.setBypassDnd(false);
            a12.setLockscreenVisibility(1);
            a12.setVibrationPattern(this.f13269T);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(a12);
            }
            String string14 = getString(C2030R.string.channel_chat_private_name);
            String string15 = getString(C2030R.string.channel_chat_private_description);
            NotificationChannel a13 = U1.a(getString(C2030R.string.channel_chat_private), string14, 3);
            a13.setDescription(string15);
            a13.enableLights(true);
            a13.setLightColor(-65536);
            a13.enableVibration(true);
            a13.setBypassDnd(false);
            a13.setLockscreenVisibility(0);
            a13.setVibrationPattern(this.f13269T);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(a13);
            }
            String string16 = getString(C2030R.string.channel_friendship_name);
            String string17 = getString(C2030R.string.channel_friendship_description);
            NotificationChannel a14 = U1.a(getString(C2030R.string.channel_friendship), string16, 2);
            a14.setDescription(string17);
            a14.enableLights(false);
            a14.enableVibration(false);
            a14.setBypassDnd(false);
            a14.setLockscreenVisibility(0);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(a14);
            }
            String string18 = getString(C2030R.string.channel_permanent_name);
            String string19 = getString(C2030R.string.channel_permanent_description);
            NotificationChannel a15 = U1.a(getString(C2030R.string.channel_permanent), string18, 2);
            a15.setDescription(string19);
            a15.enableLights(false);
            a15.enableVibration(false);
            a15.setSound((Uri) null, (AudioAttributes) null);
            a15.setBypassDnd(false);
            a15.setLockscreenVisibility(1);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(a15);
            }
            String string20 = getString(C2030R.string.channel_permission_name);
            String string21 = getString(C2030R.string.channel_permission_description);
            NotificationChannel a16 = U1.a(getString(C2030R.string.channel_permission), string20, 2);
            a16.setDescription(string21);
            z8 = false;
            a16.enableLights(false);
            a16.enableVibration(false);
            a16.setSound((Uri) null, (AudioAttributes) null);
            a16.setBypassDnd(false);
            a16.setLockscreenVisibility(1);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(a16);
            }
        } else {
            z8 = false;
        }
        if (!this.f13270U.getBoolean("conditions_accepted", z8)) {
            View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(C2030R.layout.dialog_acceptance, (ViewGroup) null);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            CheckBox checkBox = (CheckBox) inflate.findViewById(C2030R.id.checkBox1);
            checkBox.setChecked(false);
            checkBox.setOnClickListener(new Z1(this));
            int i12 = getResources().getConfiguration().uiMode & 48;
            TextView textView = (TextView) inflate.findViewById(C2030R.id.textView1);
            textView.setPaintFlags(textView.getPaintFlags() | 8);
            if (i12 == 16) {
                textView.setTextColor(-16776961);
            } else {
                textView.setTextColor(-1);
            }
            textView.setOnClickListener(new C1754a2(this));
            TextView textView2 = (TextView) inflate.findViewById(C2030R.id.textView2);
            textView2.setPaintFlags(textView2.getPaintFlags() | 8);
            if (i12 == 16) {
                textView2.setTextColor(-16776961);
            } else {
                textView2.setTextColor(-1);
            }
            textView2.setOnClickListener(new C1760b2(this));
            builder.setCancelable(false);
            builder.setIcon(2131230872);
            builder.setPositiveButton(getString(C2030R.string.main_terms_and_conditions_confirm), new C1766c2(this));
            builder.setNegativeButton(getString(C2030R.string.main_exit), new C1772d2(this));
            builder.setTitle(C2030R.string.app_name);
            AlertDialog create = builder.create();
            this.f13281f0 = create;
            create.setView(inflate, 20, 20, 20, 20);
            this.f13281f0.show();
            Button button = this.f13281f0.getButton(-1);
            if (button != null) {
                button.setEnabled(false);
            }
        } else {
            H1();
        }
        if (!this.f13277b0) {
            new Handler().postDelayed(new C1778e2(this), 5000);
            AdView adView = this.f13266Q;
            if (adView != null) {
                adView.resume();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        AdView adView = this.f13266Q;
        if (adView != null) {
            adView.destroy();
        }
        if (this.f13267R != null) {
            this.f13267R = null;
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x021b  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x022b  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0241  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x024f  */
    /* JADX WARNING: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onNewIntent(android.content.Intent r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            super.onNewIntent(r19)
            android.content.SharedPreferences r2 = r0.f13271V
            java.lang.String r3 = "eqn_first_tab"
            java.lang.String r4 = "0"
            java.lang.String r2 = r2.getString(r3, r4)
            java.lang.String r3 = "com.finazzi.distquake.realtime"
            boolean r3 = r1.hasExtra(r3)
            r5 = 0
            r6 = 1
            if (r3 == 0) goto L_0x002c
            boolean r3 = r2.equalsIgnoreCase(r4)
            if (r3 == 0) goto L_0x0027
            androidx.viewpager2.widget.ViewPager2 r3 = r0.f13268S
            r3.j(r5, r6)
            goto L_0x002c
        L_0x0027:
            androidx.viewpager2.widget.ViewPager2 r3 = r0.f13268S
            r3.j(r6, r6)
        L_0x002c:
            java.lang.String r3 = "com.finazzi.distquake.fix"
            boolean r3 = r1.hasExtra(r3)
            if (r3 == 0) goto L_0x0053
            boolean r3 = r2.equalsIgnoreCase(r4)
            if (r3 == 0) goto L_0x0040
            androidx.viewpager2.widget.ViewPager2 r3 = r0.f13268S
            r3.j(r5, r6)
            goto L_0x0045
        L_0x0040:
            androidx.viewpager2.widget.ViewPager2 r3 = r0.f13268S
            r3.j(r6, r6)
        L_0x0045:
            android.content.Intent r3 = new android.content.Intent
            r3.<init>()
            java.lang.Class<com.finazzi.distquake.ProblemsActivity> r7 = com.finazzi.distquake.ProblemsActivity.class
            android.content.Intent r3 = r3.setClass(r0, r7)
            r0.startActivity(r3)
        L_0x0053:
            java.lang.String r3 = "com.finazzi.distquake.report"
            boolean r3 = r1.hasExtra(r3)
            java.lang.String r7 = "3"
            java.lang.String r8 = "2"
            java.lang.String r9 = "1"
            r10 = 2
            if (r3 == 0) goto L_0x00bc
            android.os.Bundle r3 = r1.getExtras()
            if (r3 == 0) goto L_0x00bc
            java.lang.String r11 = "com.finazzi.distquake.report_lat"
            double r11 = r3.getDouble(r11)
            java.lang.String r13 = "com.finazzi.distquake.report_lon"
            double r13 = r3.getDouble(r13)
            android.content.SharedPreferences$Editor r3 = r0.f13272W
            java.lang.String r15 = "latitude_notification"
            float r11 = (float) r11
            r3.putFloat(r15, r11)
            android.content.SharedPreferences$Editor r3 = r0.f13272W
            java.lang.String r11 = "longitude_notification"
            float r12 = (float) r13
            r3.putFloat(r11, r12)
            android.content.SharedPreferences$Editor r3 = r0.f13272W
            java.lang.String r11 = "open_report_map"
            r3.putBoolean(r11, r6)
            android.content.SharedPreferences$Editor r3 = r0.f13272W
            r3.apply()
            boolean r3 = r2.equalsIgnoreCase(r4)
            if (r3 == 0) goto L_0x009b
            androidx.viewpager2.widget.ViewPager2 r3 = r0.f13268S
            r3.j(r6, r6)
        L_0x009b:
            boolean r3 = r2.equalsIgnoreCase(r9)
            if (r3 == 0) goto L_0x00a6
            androidx.viewpager2.widget.ViewPager2 r3 = r0.f13268S
            r3.j(r5, r6)
        L_0x00a6:
            boolean r3 = r2.equalsIgnoreCase(r8)
            if (r3 == 0) goto L_0x00b1
            androidx.viewpager2.widget.ViewPager2 r3 = r0.f13268S
            r3.j(r10, r6)
        L_0x00b1:
            boolean r3 = r2.equalsIgnoreCase(r7)
            if (r3 == 0) goto L_0x00bc
            androidx.viewpager2.widget.ViewPager2 r3 = r0.f13268S
            r3.j(r10, r6)
        L_0x00bc:
            java.lang.String r3 = "com.finazzi.distquake.send_report"
            boolean r3 = r1.hasExtra(r3)
            if (r3 == 0) goto L_0x00f0
            boolean r3 = r2.equalsIgnoreCase(r4)
            if (r3 == 0) goto L_0x00cf
            androidx.viewpager2.widget.ViewPager2 r3 = r0.f13268S
            r3.j(r6, r6)
        L_0x00cf:
            boolean r3 = r2.equalsIgnoreCase(r9)
            if (r3 == 0) goto L_0x00da
            androidx.viewpager2.widget.ViewPager2 r3 = r0.f13268S
            r3.j(r5, r6)
        L_0x00da:
            boolean r3 = r2.equalsIgnoreCase(r8)
            if (r3 == 0) goto L_0x00e5
            androidx.viewpager2.widget.ViewPager2 r3 = r0.f13268S
            r3.j(r10, r6)
        L_0x00e5:
            boolean r3 = r2.equalsIgnoreCase(r7)
            if (r3 == 0) goto L_0x00f0
            androidx.viewpager2.widget.ViewPager2 r3 = r0.f13268S
            r3.j(r10, r6)
        L_0x00f0:
            java.lang.String r3 = "com.finazzi.distquake.official"
            boolean r3 = r1.hasExtra(r3)
            if (r3 == 0) goto L_0x01a5
            android.os.Bundle r3 = r1.getExtras()
            if (r3 == 0) goto L_0x01a5
            java.lang.String r12 = "com.finazzi.distquake.official_provider"
            java.lang.String r12 = r3.getString(r12)
            java.lang.String r13 = "com.finazzi.distquake.official_lat"
            double r13 = r3.getDouble(r13)
            java.lang.String r15 = "com.finazzi.distquake.official_lon"
            double r10 = r3.getDouble(r15)
            java.lang.String r15 = "com.finazzi.distquake.official_date"
            java.lang.String r15 = r3.getString(r15)
            java.lang.String r5 = "com.finazzi.distquake.official_mag"
            r16 = r7
            double r6 = r3.getDouble(r5)
            java.lang.String r5 = "com.finazzi.distquake.official_isstrong"
            boolean r5 = r3.getBoolean(r5)
            java.lang.String r1 = "com.finazzi.distquake.official_isnear"
            boolean r1 = r3.getBoolean(r1)
            android.content.SharedPreferences$Editor r3 = r0.f13272W
            r17 = r8
            java.lang.String r8 = "official_provider_notification"
            r3.putString(r8, r12)
            android.content.SharedPreferences$Editor r3 = r0.f13272W
            java.lang.String r8 = "official_lat_notification"
            float r12 = (float) r13
            r3.putFloat(r8, r12)
            android.content.SharedPreferences$Editor r3 = r0.f13272W
            java.lang.String r8 = "official_lon_notification"
            float r10 = (float) r10
            r3.putFloat(r8, r10)
            android.content.SharedPreferences$Editor r3 = r0.f13272W
            java.lang.String r8 = "official_date_notification"
            r3.putString(r8, r15)
            android.content.SharedPreferences$Editor r3 = r0.f13272W
            java.lang.String r8 = "official_mag_notification"
            float r6 = (float) r6
            r3.putFloat(r8, r6)
            android.content.SharedPreferences$Editor r3 = r0.f13272W
            java.lang.String r6 = "official_isstrong_notification"
            r3.putBoolean(r6, r5)
            android.content.SharedPreferences$Editor r3 = r0.f13272W
            java.lang.String r5 = "official_isnear_notification"
            r3.putBoolean(r5, r1)
            android.content.SharedPreferences$Editor r1 = r0.f13272W
            java.lang.String r3 = "official_notification"
            r5 = 1
            r1.putBoolean(r3, r5)
            android.content.SharedPreferences$Editor r1 = r0.f13272W
            r1.apply()
            boolean r1 = r2.equalsIgnoreCase(r4)
            if (r1 == 0) goto L_0x017a
            androidx.viewpager2.widget.ViewPager2 r1 = r0.f13268S
            r3 = 2
            r1.j(r3, r5)
            goto L_0x017b
        L_0x017a:
            r3 = 2
        L_0x017b:
            boolean r1 = r2.equalsIgnoreCase(r9)
            if (r1 == 0) goto L_0x0186
            androidx.viewpager2.widget.ViewPager2 r1 = r0.f13268S
            r1.j(r3, r5)
        L_0x0186:
            r1 = r17
            boolean r3 = r2.equalsIgnoreCase(r1)
            if (r3 == 0) goto L_0x0194
            androidx.viewpager2.widget.ViewPager2 r3 = r0.f13268S
            r6 = 0
            r3.j(r6, r5)
        L_0x0194:
            r3 = r16
            boolean r6 = r2.equalsIgnoreCase(r3)
            if (r6 == 0) goto L_0x01a3
            androidx.viewpager2.widget.ViewPager2 r6 = r0.f13268S
            r7 = 3
            r6.j(r7, r5)
            goto L_0x01a9
        L_0x01a3:
            r7 = 3
            goto L_0x01a9
        L_0x01a5:
            r5 = r6
            r3 = r7
            r1 = r8
            goto L_0x01a3
        L_0x01a9:
            java.lang.String r6 = "com.finazzi.distquake.friendship_type"
            r8 = r19
            boolean r6 = r8.hasExtra(r6)
            if (r6 == 0) goto L_0x01e0
            boolean r6 = r2.equalsIgnoreCase(r4)
            if (r6 == 0) goto L_0x01be
            androidx.viewpager2.widget.ViewPager2 r6 = r0.f13268S
            r6.j(r7, r5)
        L_0x01be:
            boolean r6 = r2.equalsIgnoreCase(r9)
            if (r6 == 0) goto L_0x01c9
            androidx.viewpager2.widget.ViewPager2 r6 = r0.f13268S
            r6.j(r7, r5)
        L_0x01c9:
            boolean r6 = r2.equalsIgnoreCase(r1)
            if (r6 == 0) goto L_0x01d4
            androidx.viewpager2.widget.ViewPager2 r6 = r0.f13268S
            r6.j(r7, r5)
        L_0x01d4:
            boolean r6 = r2.equalsIgnoreCase(r3)
            if (r6 == 0) goto L_0x01e0
            androidx.viewpager2.widget.ViewPager2 r6 = r0.f13268S
            r7 = 0
            r6.j(r7, r5)
        L_0x01e0:
            java.lang.String r5 = "com.finazzi.distquake.personal_chat"
            boolean r5 = r8.hasExtra(r5)
            if (r5 == 0) goto L_0x0247
            android.os.Bundle r5 = r8.getExtras()
            if (r5 == 0) goto L_0x0247
            java.lang.String r6 = "com.finazzi.distquake.personal_chat_user_code"
            int r6 = r5.getInt(r6)
            java.lang.String r7 = "com.finazzi.distquake.personal_chat_user_nick"
            java.lang.String r5 = r5.getString(r7)
            android.content.SharedPreferences$Editor r7 = r0.f13272W
            java.lang.String r10 = "open_personal_chat"
            r11 = 1
            r7.putBoolean(r10, r11)
            android.content.SharedPreferences$Editor r7 = r0.f13272W
            java.lang.String r10 = "personal_chat_user_code"
            r7.putInt(r10, r6)
            android.content.SharedPreferences$Editor r6 = r0.f13272W
            java.lang.String r7 = "personal_chat_nick"
            r6.putString(r7, r5)
            android.content.SharedPreferences$Editor r5 = r0.f13272W
            r5.apply()
            boolean r4 = r2.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x0223
            androidx.viewpager2.widget.ViewPager2 r4 = r0.f13268S
            r5 = 1
            r7 = 3
            r4.j(r7, r5)
            goto L_0x0225
        L_0x0223:
            r5 = 1
            r7 = 3
        L_0x0225:
            boolean r4 = r2.equalsIgnoreCase(r9)
            if (r4 == 0) goto L_0x0230
            androidx.viewpager2.widget.ViewPager2 r4 = r0.f13268S
            r4.j(r7, r5)
        L_0x0230:
            boolean r1 = r2.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x023b
            androidx.viewpager2.widget.ViewPager2 r1 = r0.f13268S
            r1.j(r7, r5)
        L_0x023b:
            boolean r1 = r2.equalsIgnoreCase(r3)
            if (r1 == 0) goto L_0x0247
            androidx.viewpager2.widget.ViewPager2 r1 = r0.f13268S
            r6 = 0
            r1.j(r6, r5)
        L_0x0247:
            java.lang.String r1 = "from_alert_window"
            boolean r1 = r8.hasExtra(r1)
            if (r1 == 0) goto L_0x0258
            android.view.Window r1 = r0.getWindow()
            r2 = 524288(0x80000, float:7.34684E-40)
            r1.addFlags(r2)
        L_0x0258:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.MainActivity.onNewIntent(android.content.Intent):void");
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = this.f13272W;
        if (editor != null) {
            editor.putLong("last_app_used", System.currentTimeMillis());
            this.f13272W.apply();
        }
        AdView adView = this.f13266Q;
        if (adView != null) {
            adView.pause();
        }
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.f13264O.l();
    }

    public void onRequestPermissionsResult(int i8, String[] strArr, int[] iArr) {
        if (i8 == 1) {
            if (iArr.length == 1) {
                if (iArr[0] == 0) {
                    u1();
                } else if (androidx.core.app.b.i(this, "android.permission.ACCESS_FINE_LOCATION")) {
                    new AlertDialog.Builder(this).setIcon(17301543).setMessage(getString(C2030R.string.permission_location_no)).setNegativeButton(C2030R.string.permission_location_no_background_close, new C1796h2()).setPositiveButton(C2030R.string.permission_location_no_background_solve, new C1802i2(this)).show();
                }
            }
            if (iArr.length == 2) {
                int i9 = iArr[0];
                if (i9 == 0 && iArr[1] == 0) {
                    u1();
                } else if (i9 == 0 && iArr[1] == -1) {
                    if (androidx.core.app.b.i(this, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                        new AlertDialog.Builder(this).setIcon(17301543).setMessage(getString(C2030R.string.permission_location_no_background)).setNegativeButton(C2030R.string.permission_location_no_background_close, new C1808j2()).setPositiveButton(C2030R.string.permission_location_no_background_solve, new C1814k2(this)).show();
                        u1();
                    }
                } else if (androidx.core.app.b.i(this, "android.permission.ACCESS_FINE_LOCATION")) {
                    new AlertDialog.Builder(this).setIcon(17301543).setMessage(getString(C2030R.string.permission_location_no)).setNegativeButton(C2030R.string.permission_location_no_background_close, new C1820l2()).setPositiveButton(C2030R.string.permission_location_no_background_solve, new C1826m2(this)).show();
                } else {
                    new AlertDialog.Builder(this).setIcon(17301543).setMessage(getString(C2030R.string.permission_location_no)).setNegativeButton(C2030R.string.permission_location_no_background_close, new C1832n2()).show();
                }
            }
        } else if (i8 != 991) {
            super.onRequestPermissionsResult(i8, strArr, iArr);
        } else if (androidx.core.content.a.checkSelfPermission(getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION") != 0) {
            G1();
        } else {
            u1();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        H3.c cVar;
        FrameLayout frameLayout;
        super.onResume();
        C0624o.a(getApplication());
        if (this.f13277b0 && (frameLayout = this.f13265P) != null) {
            frameLayout.removeAllViews();
        }
        SharedPreferences b8 = androidx.preference.g.b(getApplicationContext());
        String string = b8.getString("eqn_first_tab", "0");
        if (!string.equalsIgnoreCase(this.f13273X)) {
            this.f13268S.setAdapter(new m(this));
            this.f13268S.setOffscreenPageLimit(1);
            if (this.f13268S.getAdapter() != null) {
                this.f13268S.getAdapter().o();
            }
            new com.google.android.material.tabs.d((TabLayout) findViewById(C2030R.id.tab_layout), this.f13268S, new V1(this, b8)).a();
        }
        this.f13273X = string;
        if (!this.f13277b0) {
            long currentTimeMillis = System.currentTimeMillis();
            long j8 = this.f13270U.getLong("last_map_time", 0);
            long j9 = this.f13270U.getLong("map_spent_time", 0);
            long j10 = this.f13270U.getLong("last_interstitial", 0);
            if (currentTimeMillis - this.f13270U.getLong("last_app_used", 0) > 10800000) {
                this.f13272W.putBoolean("can_show_inter_add", false);
                this.f13272W.apply();
            }
            if (currentTimeMillis - j8 < 2000 && j9 > 3000) {
                if (!this.f13270U.getBoolean("can_show_inter_add", false)) {
                    this.f13272W.putBoolean("can_show_inter_add", true);
                    this.f13272W.apply();
                } else if (currentTimeMillis - j10 > 2000000 && (cVar = this.f13282g0) != null && cVar.canRequestAds()) {
                    E1();
                }
            }
        }
        l1();
        if (Build.VERSION.SDK_INT >= 29) {
            if (androidx.core.content.a.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0 && androidx.core.content.a.checkSelfPermission(this, "android.permission.ACCESS_BACKGROUND_LOCATION") == 0) {
                this.f13272W.putLong("permission_check_time", -1);
                this.f13272W.putInt("permission_notification_shown", 0);
                this.f13272W.apply();
            }
        } else if (androidx.core.content.a.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            this.f13272W.putLong("permission_check_time", -1);
            this.f13272W.putInt("permission_notification_shown", 0);
            this.f13272W.apply();
        }
    }

    public void onStop() {
        super.onStop();
        CancellationTokenSource cancellationTokenSource = this.f13279d0;
        if (cancellationTokenSource != null) {
            cancellationTokenSource.cancel();
        }
    }
}
