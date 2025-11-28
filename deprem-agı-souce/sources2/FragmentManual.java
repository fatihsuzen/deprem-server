package com.finazzi.distquake;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.core.view.B;
import androidx.core.view.C;
import androidx.fragment.app.C0887n;
import androidx.fragment.app.C0891s;
import androidx.lifecycle.C0910l;
import androidx.preference.g;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.tasks.Task;
import com.robinhood.ticker.TickerView;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import u2.A0;
import u2.C1830n0;
import u2.C1836o0;
import u2.C1842p0;
import u2.C1848q0;
import u2.C1854r0;
import u2.C1860s0;
import u2.C1866t0;
import u2.C1872u0;
import u2.C1878v0;
import u2.C1884w0;
import u2.C1890x0;
import u2.C1896y0;
import u2.C1902z0;

public class FragmentManual extends C0887n {

    /* renamed from: A0  reason: collision with root package name */
    private Calendar f12839A0;

    /* renamed from: B0  reason: collision with root package name */
    private CountDownTimer f12840B0;
    /* access modifiers changed from: private */

    /* renamed from: n0  reason: collision with root package name */
    public Intent f12841n0;
    /* access modifiers changed from: private */

    /* renamed from: o0  reason: collision with root package name */
    public int f12842o0;
    /* access modifiers changed from: private */

    /* renamed from: p0  reason: collision with root package name */
    public int f12843p0;

    /* renamed from: q0  reason: collision with root package name */
    private boolean f12844q0 = false;
    /* access modifiers changed from: private */

    /* renamed from: r0  reason: collision with root package name */
    public long f12845r0;
    /* access modifiers changed from: private */

    /* renamed from: s0  reason: collision with root package name */
    public View f12846s0;
    /* access modifiers changed from: private */

    /* renamed from: t0  reason: collision with root package name */
    public SharedPreferences f12847t0;
    /* access modifiers changed from: private */

    /* renamed from: u0  reason: collision with root package name */
    public boolean f12848u0;

    /* renamed from: v0  reason: collision with root package name */
    private final int f12849v0 = 2;

    /* renamed from: w0  reason: collision with root package name */
    private TimeZone f12850w0;

    /* renamed from: x0  reason: collision with root package name */
    private TimeZone f12851x0;

    /* renamed from: y0  reason: collision with root package name */
    private SimpleDateFormat f12852y0;

    /* renamed from: z0  reason: collision with root package name */
    private SimpleDateFormat f12853z0;

    class a extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        private int f12854a = 4;

        /* renamed from: b  reason: collision with root package name */
        private int f12855b = 0;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TextView f12856c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(long j8, long j9, TextView textView) {
            super(j8, j9);
            this.f12856c = textView;
        }

        public void onFinish() {
        }

        public void onTick(long j8) {
            int i8 = this.f12855b;
            int i9 = this.f12854a;
            int i10 = i8 + i9;
            this.f12855b = i10;
            if (i10 > 255) {
                this.f12854a = i9 * -1;
                this.f12855b = 255;
            }
            if (this.f12855b < 0) {
                this.f12854a *= -1;
                this.f12855b = 0;
            }
            TextView textView = this.f12856c;
            int i11 = this.f12855b;
            textView.setBackgroundColor(Color.rgb(255, i11, i11));
        }
    }

    class b implements C {
        b() {
        }

        public boolean a(MenuItem menuItem) {
            if (menuItem.getItemId() != C2030R.id.menu_update) {
                return false;
            }
            if (FragmentManual.this.f1()) {
                if (System.currentTimeMillis() - FragmentManual.this.f12847t0.getLong("network_count_last_updated", 0) > 3000) {
                    FragmentManual.this.W0();
                    C0891s activity = FragmentManual.this.getActivity();
                    if (activity != null) {
                        String str = activity.getApplicationInfo().dataDir;
                        if (!new File(str + "/files/cache_manual4.txt").delete()) {
                            Log.d("EQN", "Cannot delete");
                        }
                    }
                }
            } else {
                C0891s activity2 = FragmentManual.this.getActivity();
                if (activity2 != null) {
                    Toast makeText = Toast.makeText(activity2, FragmentManual.this.getString(C2030R.string.main_nointernet), 1);
                    makeText.setGravity(17, 0, 0);
                    makeText.show();
                }
            }
            return true;
        }

        public /* synthetic */ void b(Menu menu) {
            B.a(this, menu);
        }

        public void c(Menu menu, MenuInflater menuInflater) {
            menuInflater.inflate(C2030R.menu.manual_menu, menu);
        }

        public /* synthetic */ void d(Menu menu) {
            B.b(this, menu);
        }
    }

    private class c extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private String f12859a;

        /* renamed from: b  reason: collision with root package name */
        private final double f12860b;

        /* renamed from: c  reason: collision with root package name */
        private final double f12861c;

        /* synthetic */ c(FragmentManual fragmentManual, double d8, double d9, a aVar) {
            this(d8, d9);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(Context... contextArr) {
            C0891s activity = FragmentManual.this.getActivity();
            if (activity != null) {
                try {
                    List<Address> fromLocation = new Geocoder(activity, Locale.getDefault()).getFromLocation(this.f12860b, this.f12861c, 1);
                    if (fromLocation == null || fromLocation.size() <= 0) {
                        this.f12859a = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                        return "COMPLETE!";
                    }
                    if (fromLocation.get(0).getLocality() != null) {
                        this.f12859a = fromLocation.get(0).getLocality() + " - " + fromLocation.get(0).getCountryName();
                    } else {
                        this.f12859a = fromLocation.get(0).getCountryName();
                    }
                    return "COMPLETE!";
                } catch (IOException | IllegalArgumentException unused) {
                    this.f12859a = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                    return "COMPLETE!";
                }
            } else {
                this.f12859a = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                return "COMPLETE!";
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            if (FragmentManual.this.f12848u0) {
                FragmentManual fragmentManual = FragmentManual.this;
                fragmentManual.j1(this.f12860b, this.f12861c, fragmentManual.f12843p0, this.f12859a);
            }
        }

        private c(double d8, double d9) {
            this.f12860b = d8;
            this.f12861c = d9;
        }
    }

    private class d extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private final double f12863a;

        /* renamed from: b  reason: collision with root package name */
        private final double f12864b;

        /* renamed from: c  reason: collision with root package name */
        private final int f12865c;

        /* renamed from: d  reason: collision with root package name */
        private final String f12866d;

        /* synthetic */ d(FragmentManual fragmentManual, double d8, double d9, int i8, String str, a aVar) {
            this(d8, d9, i8, str);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x01bf  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x01c5  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x01cf  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x01d5  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r14) {
            /*
                r13 = this;
                java.lang.String r14 = "nok"
                com.finazzi.distquake.FragmentManual r0 = com.finazzi.distquake.FragmentManual.this
                boolean r0 = r0.isAdded()
                com.finazzi.distquake.FragmentManual r1 = com.finazzi.distquake.FragmentManual.this
                androidx.fragment.app.s r1 = r1.getActivity()
                r2 = 1
                if (r1 == 0) goto L_0x01dc
                if (r0 == 0) goto L_0x01dc
                com.finazzi.distquake.FragmentManual r0 = com.finazzi.distquake.FragmentManual.this
                java.lang.String r0 = r0.Y0()
                double r3 = java.lang.Double.parseDouble(r0)
                r5 = 4616189618054758400(0x4010000000000000, double:4.0)
                double r3 = r3 * r5
                r5 = 4652007308841189376(0x408f400000000000, double:1000.0)
                double r7 = r3 / r5
                double r7 = java.lang.Math.floor(r7)
                double r7 = r7 * r5
                double r3 = r3 - r7
                long r3 = java.lang.Math.round(r3)
                java.util.Random r1 = new java.util.Random
                r1.<init>()
                r5 = 189(0xbd, float:2.65E-43)
                int r1 = r1.nextInt(r5)
                int r1 = r1 + 1000
                java.util.Random r5 = new java.util.Random
                r5.<init>()
                r6 = 309(0x135, float:4.33E-43)
                int r5 = r5.nextInt(r6)
                int r5 = r5 + 1000
                java.util.Random r6 = new java.util.Random
                r6.<init>()
                r7 = 8309(0x2075, float:1.1643E-41)
                int r6 = r6.nextInt(r7)
                int r6 = r6 + 1000
                java.util.Random r7 = new java.util.Random
                r7.<init>()
                r8 = 5309(0x14bd, float:7.44E-42)
                int r7 = r7.nextInt(r8)
                int r7 = r7 + 1000
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                java.lang.String r6 = java.lang.Integer.toString(r6)
                r8.append(r6)
                double r9 = r13.f12863a
                r11 = 4620205703022466040(0x401e449ba5e353f8, double:7.567)
                double r9 = r9 * r11
                double r9 = java.lang.Math.abs(r9)
                long r9 = java.lang.Math.round(r9)
                r8.append(r9)
                java.lang.String r6 = r8.toString()
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                java.lang.String r1 = java.lang.Integer.toString(r1)
                r8.append(r1)
                java.lang.String r1 = java.lang.Long.toString(r3)
                r8.append(r1)
                java.lang.String r1 = java.lang.Integer.toString(r5)
                r8.append(r1)
                java.lang.String r1 = r8.toString()
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = java.lang.Integer.toString(r7)
                r3.append(r4)
                double r4 = r13.f12864b
                r7 = 4621394090374138429(0x40227d70a3d70a3d, double:9.245)
                double r4 = r4 * r7
                double r4 = java.lang.Math.abs(r4)
                long r4 = java.lang.Math.round(r4)
                r3.append(r4)
                java.lang.String r3 = r3.toString()
                java.util.HashMap r4 = new java.util.HashMap
                r4.<init>()
                java.lang.String r5 = "u_id"
                r4.put(r5, r0)
                double r7 = r13.f12863a
                java.lang.String r0 = java.lang.Double.toString(r7)
                java.lang.String r5 = "lat"
                r4.put(r5, r0)
                double r7 = r13.f12864b
                java.lang.String r0 = java.lang.Double.toString(r7)
                java.lang.String r5 = "lon"
                r4.put(r5, r0)
                int r0 = r13.f12865c
                java.lang.String r0 = java.lang.Integer.toString(r0)
                java.lang.String r5 = "mag"
                r4.put(r5, r0)
                java.lang.String r0 = "address"
                java.lang.String r5 = r13.f12866d
                r4.put(r0, r5)
                java.lang.String r0 = "cp1"
                r4.put(r0, r6)
                java.lang.String r0 = "cp2"
                r4.put(r0, r1)
                java.lang.String r0 = "cp3"
                r4.put(r0, r3)
                java.lang.String r0 = u2.C1737L.a(r4)
                r1 = 0
                java.net.URL r3 = new java.net.URL     // Catch:{ IOException -> 0x01c3, all -> 0x01bc }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01c3, all -> 0x01bc }
                r4.<init>()     // Catch:{ IOException -> 0x01c3, all -> 0x01bc }
                com.finazzi.distquake.FragmentManual r5 = com.finazzi.distquake.FragmentManual.this     // Catch:{ IOException -> 0x01c3, all -> 0x01bc }
                r6 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r5 = r5.getString(r6)     // Catch:{ IOException -> 0x01c3, all -> 0x01bc }
                r4.append(r5)     // Catch:{ IOException -> 0x01c3, all -> 0x01bc }
                java.lang.String r5 = "distquake_upload_manual5.php"
                r4.append(r5)     // Catch:{ IOException -> 0x01c3, all -> 0x01bc }
                java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x01c3, all -> 0x01bc }
                r3.<init>(r4)     // Catch:{ IOException -> 0x01c3, all -> 0x01bc }
                java.net.URLConnection r3 = r3.openConnection()     // Catch:{ IOException -> 0x01c3, all -> 0x01bc }
                java.lang.Object r3 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r3)     // Catch:{ IOException -> 0x01c3, all -> 0x01bc }
                java.net.URLConnection r3 = (java.net.URLConnection) r3     // Catch:{ IOException -> 0x01c3, all -> 0x01bc }
                java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ IOException -> 0x01c3, all -> 0x01bc }
                r3.setDoOutput(r2)     // Catch:{ IOException -> 0x0194, all -> 0x0191 }
                r1 = 10000(0x2710, float:1.4013E-41)
                r3.setConnectTimeout(r1)     // Catch:{ IOException -> 0x0194, all -> 0x0191 }
                r3.setReadTimeout(r1)     // Catch:{ IOException -> 0x0194, all -> 0x0191 }
                java.lang.String r1 = "Content-Type"
                java.lang.String r4 = "application/x-www-form-urlencoded;charset=utf-8"
                r3.setRequestProperty(r1, r4)     // Catch:{ IOException -> 0x0194, all -> 0x0191 }
                java.lang.String r1 = "POST"
                r3.setRequestMethod(r1)     // Catch:{ IOException -> 0x0194, all -> 0x0191 }
                byte[] r1 = r0.getBytes()     // Catch:{ IOException -> 0x0194, all -> 0x0191 }
                int r1 = r1.length     // Catch:{ IOException -> 0x0194, all -> 0x0191 }
                r3.setFixedLengthStreamingMode(r1)     // Catch:{ IOException -> 0x0194, all -> 0x0191 }
                java.io.PrintWriter r1 = new java.io.PrintWriter     // Catch:{ IOException -> 0x0194, all -> 0x0191 }
                java.io.OutputStream r4 = r3.getOutputStream()     // Catch:{ IOException -> 0x0194, all -> 0x0191 }
                r1.<init>(r4)     // Catch:{ IOException -> 0x0194, all -> 0x0191 }
                r1.print(r0)     // Catch:{ IOException -> 0x0194, all -> 0x0191 }
                r1.close()     // Catch:{ IOException -> 0x0194, all -> 0x0191 }
                java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0194, all -> 0x0191 }
                java.io.InputStream r1 = r3.getInputStream()     // Catch:{ IOException -> 0x0194, all -> 0x0191 }
                r0.<init>(r1)     // Catch:{ IOException -> 0x0194, all -> 0x0191 }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0194, all -> 0x0191 }
                java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0194, all -> 0x0191 }
                java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x0194, all -> 0x0191 }
                r4.<init>(r0, r5)     // Catch:{ IOException -> 0x0194, all -> 0x0191 }
                r1.<init>(r4)     // Catch:{ IOException -> 0x0194, all -> 0x0191 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0194, all -> 0x0191 }
                r4.<init>()     // Catch:{ IOException -> 0x0194, all -> 0x0191 }
            L_0x0182:
                java.lang.String r5 = r1.readLine()     // Catch:{ IOException -> 0x0194, all -> 0x0191 }
                if (r5 == 0) goto L_0x0196
                r4.append(r5)     // Catch:{ IOException -> 0x0194, all -> 0x0191 }
                java.lang.String r5 = "\n"
                r4.append(r5)     // Catch:{ IOException -> 0x0194, all -> 0x0191 }
                goto L_0x0182
            L_0x0191:
                r14 = move-exception
                r1 = r3
                goto L_0x01bd
            L_0x0194:
                r1 = r3
                goto L_0x01c3
            L_0x0196:
                r0.close()     // Catch:{ IOException -> 0x0194, all -> 0x0191 }
                java.lang.String r0 = r4.toString()     // Catch:{ IOException -> 0x0194, all -> 0x0191 }
                int r1 = r0.length()     // Catch:{ IOException -> 0x0194, all -> 0x0191 }
                r4 = 9
                if (r1 < r4) goto L_0x01aa
                r1 = 2
                java.lang.String r0 = r0.substring(r1, r4)     // Catch:{ IOException -> 0x0194, all -> 0x0191 }
            L_0x01aa:
                com.finazzi.distquake.FragmentManual r1 = com.finazzi.distquake.FragmentManual.this     // Catch:{ NumberFormatException -> 0x01b7 }
                int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x01b7 }
                long r4 = (long) r0     // Catch:{ NumberFormatException -> 0x01b7 }
                long unused = r1.f12845r0 = r4     // Catch:{ NumberFormatException -> 0x01b7 }
                java.lang.String r0 = "ok"
                goto L_0x01b8
            L_0x01b7:
                r0 = r14
            L_0x01b8:
                r3.disconnect()
                goto L_0x01c9
            L_0x01bc:
                r14 = move-exception
            L_0x01bd:
                if (r1 == 0) goto L_0x01c2
                r1.disconnect()
            L_0x01c2:
                throw r14
            L_0x01c3:
                if (r1 == 0) goto L_0x01c8
                r1.disconnect()
            L_0x01c8:
                r0 = r14
            L_0x01c9:
                boolean r14 = r0.equals(r14)
                if (r14 == 0) goto L_0x01d5
                com.finazzi.distquake.FragmentManual r14 = com.finazzi.distquake.FragmentManual.this
                int unused = r14.f12842o0 = r2
                goto L_0x01e1
            L_0x01d5:
                com.finazzi.distquake.FragmentManual r14 = com.finazzi.distquake.FragmentManual.this
                r0 = 0
                int unused = r14.f12842o0 = r0
                goto L_0x01e1
            L_0x01dc:
                com.finazzi.distquake.FragmentManual r14 = com.finazzi.distquake.FragmentManual.this
                int unused = r14.f12842o0 = r2
            L_0x01e1:
                java.lang.String r14 = "COMPLETE!"
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.FragmentManual.d.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            C0891s activity = FragmentManual.this.getActivity();
            if (activity == null) {
                return;
            }
            if (FragmentManual.this.f12842o0 == 1) {
                Toast makeText = Toast.makeText(activity, FragmentManual.this.getString(C2030R.string.manual_error), 0);
                makeText.setGravity(17, 0, 0);
                makeText.show();
                return;
            }
            try {
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(activity.openFileOutput("last_notification.txt", 0), StandardCharsets.UTF_8);
                String l7 = Long.toString(System.currentTimeMillis());
                outputStreamWriter.write(l7 + "\r\n");
                outputStreamWriter.write(FragmentManual.this.f12845r0 + "\r\n");
                outputStreamWriter.flush();
                outputStreamWriter.close();
            } catch (IOException e8) {
                if (e8.getMessage() != null) {
                    Log.d("EQN", e8.getMessage());
                }
            }
            Toast makeText2 = Toast.makeText(activity, FragmentManual.this.getString(C2030R.string.manual_ok), 1);
            makeText2.setGravity(17, 0, 0);
            makeText2.show();
            ((RadioGroup) FragmentManual.this.f12846s0.findViewById(C2030R.id.radioGroup1)).clearCheck();
        }

        private d(double d8, double d9, int i8, String str) {
            this.f12863a = d8;
            this.f12864b = d9;
            this.f12865c = i8;
            this.f12866d = str;
        }
    }

    private class f extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private String f12871a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f12872b;

        /* renamed from: c  reason: collision with root package name */
        private final double f12873c;

        /* renamed from: d  reason: collision with root package name */
        private final double f12874d;

        /* synthetic */ f(FragmentManual fragmentManual, double d8, double d9, a aVar) {
            this(d8, d9);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00b5, code lost:
            r0.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x00b1 */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x00b5  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x00bb  */
        /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r7) {
            /*
                r6 = this;
                r7 = 0
                com.finazzi.distquake.FragmentManual r0 = com.finazzi.distquake.FragmentManual.this
                boolean r0 = r0.isAdded()
                com.finazzi.distquake.FragmentManual r1 = com.finazzi.distquake.FragmentManual.this
                androidx.fragment.app.s r1 = r1.getActivity()
                r2 = 1
                if (r1 == 0) goto L_0x00bf
                if (r0 == 0) goto L_0x00bf
                r0 = 0
                com.finazzi.distquake.FragmentManual r1 = com.finazzi.distquake.FragmentManual.this     // Catch:{ IOException -> 0x00b1 }
                android.content.SharedPreferences r1 = r1.f12847t0     // Catch:{ IOException -> 0x00b1 }
                java.lang.String r3 = "sub_domain"
                com.finazzi.distquake.FragmentManual r4 = com.finazzi.distquake.FragmentManual.this     // Catch:{ IOException -> 0x00b1 }
                r5 = 2131887099(0x7f1203fb, float:1.9408796E38)
                java.lang.String r4 = r4.getString(r5)     // Catch:{ IOException -> 0x00b1 }
                java.lang.String r1 = r1.getString(r3, r4)     // Catch:{ IOException -> 0x00b1 }
                com.finazzi.distquake.FragmentManual r3 = com.finazzi.distquake.FragmentManual.this     // Catch:{ IOException -> 0x00b1 }
                r4 = 2131887098(0x7f1203fa, float:1.9408793E38)
                java.lang.String r3 = r3.getString(r4)     // Catch:{ IOException -> 0x00b1 }
                java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ IOException -> 0x00b1 }
                r4[r7] = r1     // Catch:{ IOException -> 0x00b1 }
                java.lang.String r1 = java.lang.String.format(r3, r4)     // Catch:{ IOException -> 0x00b1 }
                java.net.URL r3 = new java.net.URL     // Catch:{ IOException -> 0x00b1 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00b1 }
                r4.<init>()     // Catch:{ IOException -> 0x00b1 }
                r4.append(r1)     // Catch:{ IOException -> 0x00b1 }
                java.lang.String r1 = "distquake_download_manual3.php"
                r4.append(r1)     // Catch:{ IOException -> 0x00b1 }
                java.lang.String r1 = r4.toString()     // Catch:{ IOException -> 0x00b1 }
                r3.<init>(r1)     // Catch:{ IOException -> 0x00b1 }
                java.net.URLConnection r1 = r3.openConnection()     // Catch:{ IOException -> 0x00b1 }
                java.lang.Object r1 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r1)     // Catch:{ IOException -> 0x00b1 }
                java.net.URLConnection r1 = (java.net.URLConnection) r1     // Catch:{ IOException -> 0x00b1 }
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ IOException -> 0x00b1 }
                r1.setDoOutput(r7)     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                r0 = 10000(0x2710, float:1.4013E-41)
                r1.setConnectTimeout(r0)     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                r1.setReadTimeout(r0)     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                java.lang.String r0 = "Content-Type"
                java.lang.String r3 = "application/x-www-form-urlencoded;charset=utf-8"
                r1.setRequestProperty(r0, r3)     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                java.lang.String r0 = "GET"
                r1.setRequestMethod(r0)     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                java.io.InputStream r3 = r1.getInputStream()     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                r0.<init>(r3)     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                r4.<init>(r0, r5)     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                r3.<init>(r4)     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                r4.<init>()     // Catch:{ IOException -> 0x009e, all -> 0x009b }
            L_0x008c:
                java.lang.String r5 = r3.readLine()     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                if (r5 == 0) goto L_0x00a0
                r4.append(r5)     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                java.lang.String r5 = "\n"
                r4.append(r5)     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                goto L_0x008c
            L_0x009b:
                r7 = move-exception
                r0 = r1
                goto L_0x00b9
            L_0x009e:
                r0 = r1
                goto L_0x00b1
            L_0x00a0:
                r0.close()     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                java.lang.String r0 = r4.toString()     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                r6.f12871a = r0     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                r6.f12872b = r7     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                r1.disconnect()
                goto L_0x00c1
            L_0x00af:
                r7 = move-exception
                goto L_0x00b9
            L_0x00b1:
                r6.f12872b = r2     // Catch:{ all -> 0x00af }
                if (r0 == 0) goto L_0x00c1
                r0.disconnect()
                goto L_0x00c1
            L_0x00b9:
                if (r0 == 0) goto L_0x00be
                r0.disconnect()
            L_0x00be:
                throw r7
            L_0x00bf:
                r6.f12872b = r2
            L_0x00c1:
                java.lang.String r7 = "COMPLETE!"
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.FragmentManual.f.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            if (!this.f12872b) {
                try {
                    JSONArray jSONArray = new JSONArray(this.f12871a);
                    int length = jSONArray.length();
                    double[] dArr = new double[length];
                    double[] dArr2 = new double[length];
                    int[] iArr = new int[length];
                    String[] strArr = new String[length];
                    C0891s activity = FragmentManual.this.getActivity();
                    if (activity != null) {
                        for (int i8 = 0; i8 < length; i8++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i8);
                            dArr[i8] = Double.parseDouble(jSONObject.getString("la"));
                            dArr2[i8] = Double.parseDouble(jSONObject.getString("lo"));
                            iArr[i8] = Integer.parseInt(jSONObject.getString("ma"));
                            strArr[i8] = jSONObject.getString("dt");
                        }
                        try {
                            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(activity.openFileOutput("cache_manual4.txt", 0), StandardCharsets.UTF_8);
                            outputStreamWriter.write(Long.toString(System.currentTimeMillis()) + "\r\n");
                            outputStreamWriter.write(length + "\r\n");
                            int i9 = 0;
                            while (i9 < length) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(dArr[i9]);
                                sb.append("#");
                                sb.append(dArr2[i9]);
                                sb.append("#");
                                sb.append(iArr[i9]);
                                sb.append("#");
                                sb.append(strArr[i9]);
                                outputStreamWriter.write(sb.toString() + "\r\n");
                                i9++;
                                length = length;
                            }
                            outputStreamWriter.flush();
                            outputStreamWriter.close();
                        } catch (IOException e8) {
                            if (e8.getMessage() != null) {
                                Log.d("EQN", e8.getMessage());
                            }
                        }
                        Intent unused = FragmentManual.this.f12841n0 = new Intent().setClass(activity, GlobeActivityAll.class);
                        FragmentManual.this.f12841n0.putExtra("com.finazzi.distquake.latitude_vector", dArr);
                        FragmentManual.this.f12841n0.putExtra("com.finazzi.distquake.longitude_vector", dArr2);
                        FragmentManual.this.f12841n0.putExtra("com.finazzi.distquake.intensity_vector", iArr);
                        FragmentManual.this.f12841n0.putExtra("com.finazzi.distquake.date_vector", strArr);
                        FragmentManual.this.f12841n0.putExtra("com.finazzi.distquake.latitude_notification", this.f12873c);
                        FragmentManual.this.f12841n0.putExtra("com.finazzi.distquake.longitude_notification", this.f12874d);
                        FragmentManual.this.f12841n0.putExtra("com.finazzi.distquake.map_type", 1);
                        FragmentManual fragmentManual = FragmentManual.this;
                        fragmentManual.startActivityForResult(fragmentManual.f12841n0, 2);
                    }
                } catch (JSONException unused2) {
                    ((ProgressBar) FragmentManual.this.f12846s0.findViewById(C2030R.id.progressBar1)).setVisibility(8);
                    C0891s activity2 = FragmentManual.this.getActivity();
                    if (activity2 != null) {
                        Toast makeText = Toast.makeText(activity2, FragmentManual.this.getString(C2030R.string.manual_no_notifications), 0);
                        makeText.setGravity(17, 0, 0);
                        makeText.show();
                    }
                }
            } else {
                ((ProgressBar) FragmentManual.this.f12846s0.findViewById(C2030R.id.progressBar1)).setVisibility(8);
                C0891s activity3 = FragmentManual.this.getActivity();
                if (activity3 != null) {
                    Toast makeText2 = Toast.makeText(activity3, FragmentManual.this.getString(C2030R.string.manual_error), 0);
                    makeText2.setGravity(17, 0, 0);
                    makeText2.show();
                }
            }
        }

        private f(double d8, double d9) {
            this.f12871a = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
            this.f12873c = d8;
            this.f12874d = d9;
        }
    }

    public static /* synthetic */ void A0(FragmentManual fragmentManual, View view) {
        fragmentManual.getClass();
        try {
            C0891s activity = fragmentManual.getActivity();
            if (activity != null) {
                activity.getPackageManager().getPackageInfo("com.twitter.android", 0);
                fragmentManual.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("twitter://user?user_id=1707171247")));
            }
        } catch (Exception unused) {
            fragmentManual.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://twitter.com/SismoDetector")));
        }
    }

    public static /* synthetic */ void B0(DialogInterface dialogInterface, int i8) {
    }

    public static /* synthetic */ void C0(FragmentManual fragmentManual, RadioGroup radioGroup, DialogInterface dialogInterface, int i8) {
        fragmentManual.i1();
        radioGroup.clearCheck();
        fragmentManual.f12844q0 = false;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:2|3|4|5|6|7|10|11) */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0027, code lost:
        r4 = new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse("http://www.telegram.me/eqn_realtime"));
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void D0(com.finazzi.distquake.FragmentManual r3, android.app.Activity r4, android.view.View r5) {
        /*
            r3.getClass()
            java.lang.String r5 = "android.intent.action.VIEW"
            if (r4 == 0) goto L_0x0035
            r0 = 0
            android.content.pm.PackageManager r1 = r4.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0012 }
            java.lang.String r2 = "org.telegram.messenger"
            r1.getPackageInfo(r2, r0)     // Catch:{ NameNotFoundException -> 0x0012 }
            goto L_0x001b
        L_0x0012:
            android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0027 }
            java.lang.String r1 = "org.thunderdog.challegram"
            r4.getPackageInfo(r1, r0)     // Catch:{ NameNotFoundException -> 0x0027 }
        L_0x001b:
            android.content.Intent r4 = new android.content.Intent     // Catch:{ NameNotFoundException -> 0x0027 }
            java.lang.String r0 = "tg://resolve?domain=eqn_realtime"
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ NameNotFoundException -> 0x0027 }
            r4.<init>(r5, r0)     // Catch:{ NameNotFoundException -> 0x0027 }
            goto L_0x0032
        L_0x0027:
            android.content.Intent r4 = new android.content.Intent
            java.lang.String r0 = "http://www.telegram.me/eqn_realtime"
            android.net.Uri r0 = android.net.Uri.parse(r0)
            r4.<init>(r5, r0)
        L_0x0032:
            r3.startActivity(r4)
        L_0x0035:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.FragmentManual.D0(com.finazzi.distquake.FragmentManual, android.app.Activity, android.view.View):void");
    }

    public static /* synthetic */ void E0(FragmentManual fragmentManual, RadioGroup radioGroup, RadioGroup radioGroup2, int i8) {
        fragmentManual.getClass();
        int indexOfChild = radioGroup.indexOfChild(radioGroup.findViewById(i8));
        if (!fragmentManual.f12844q0 && indexOfChild >= 0) {
            fragmentManual.f12843p0 = (indexOfChild + 2) * 10;
            fragmentManual.f12844q0 = true;
            AlertDialog.Builder builder = new AlertDialog.Builder(fragmentManual.getActivity());
            builder.setMessage(fragmentManual.getString(C2030R.string.manual_sure));
            builder.setCancelable(false);
            builder.setNegativeButton(fragmentManual.getString(C2030R.string.status_cancel), new C1848q0(fragmentManual, radioGroup));
            builder.setPositiveButton(fragmentManual.getString(C2030R.string.manual_send), new C1854r0(fragmentManual, radioGroup));
            builder.create().show();
        }
    }

    public static /* synthetic */ void F0(E3.c cVar, Activity activity, Task task) {
        if (task.isSuccessful()) {
            cVar.b(activity, (E3.b) task.getResult()).addOnCompleteListener(new C1842p0());
        }
    }

    /* access modifiers changed from: private */
    public void V0() {
        FragmentManual fragmentManual = this;
        int i8 = fragmentManual.f12847t0.getInt("network_count_manual", 0);
        TickerView tickerView = (TickerView) fragmentManual.f12846s0.findViewById(C2030R.id.tickerView1);
        tickerView.setCharacterLists(D5.c.b());
        tickerView.setAnimationDuration(2000);
        tickerView.setAnimationInterpolator(new OvershootInterpolator());
        tickerView.setText(String.format(Locale.getDefault(), "%d", new Object[]{Integer.valueOf(i8)}));
        CardView cardView = (CardView) fragmentManual.f12846s0.findViewById(C2030R.id.cardPreliminary);
        String string = fragmentManual.f12847t0.getString("preliminary_location", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        if (string.equals("_") || string.equals(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED)) {
            cardView.setVisibility(8);
            return;
        }
        cardView.setVisibility(0);
        float f8 = fragmentManual.f12847t0.getFloat("preliminary_magnitude", BitmapDescriptorFactory.HUE_RED);
        float f9 = fragmentManual.f12847t0.getFloat("preliminary_latitude", BitmapDescriptorFactory.HUE_RED);
        float f10 = fragmentManual.f12847t0.getFloat("preliminary_longitude", BitmapDescriptorFactory.HUE_RED);
        int i9 = fragmentManual.f12847t0.getInt("preliminary_reports", 0);
        String string2 = fragmentManual.f12847t0.getString("preliminary_date", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        int i10 = fragmentManual.f12847t0.getInt("preliminary_updates", 0);
        cardView.setOnClickListener(new C1878v0(fragmentManual, f9, f10));
        TextView textView = (TextView) fragmentManual.f12846s0.findViewById(C2030R.id.textView02);
        if (i10 >= 16) {
            CountDownTimer countDownTimer = fragmentManual.f12840B0;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            textView.setText(fragmentManual.getString(C2030R.string.manual_preliminary_final));
        } else if (fragmentManual.f12840B0 == null) {
            textView.setText(fragmentManual.getString(C2030R.string.manual_preliminary_inprogress));
            fragmentManual = this;
            fragmentManual.f12840B0 = new a(240000, 10, textView).start();
        }
        TextView textView2 = (TextView) fragmentManual.f12846s0.findViewById(C2030R.id.textView03);
        textView2.setText("M" + Float.toString(f8));
        View findViewById = fragmentManual.f12846s0.findViewById(C2030R.id.divider);
        double d8 = (double) f8;
        if (d8 < 2.0d) {
            textView2.setTextColor(Color.rgb(12, 115, 160));
            findViewById.setBackgroundColor(Color.rgb(12, 115, 160));
        }
        if (d8 >= 2.0d && d8 < 3.5d) {
            textView2.setTextColor(Color.rgb(12, 160, 35));
            findViewById.setBackgroundColor(Color.rgb(12, 160, 35));
        }
        if (d8 >= 3.5d && d8 < 4.5d) {
            textView2.setTextColor(Color.rgb(244, 195, 0));
            findViewById.setBackgroundColor(Color.rgb(244, 195, 0));
        }
        if (d8 >= 4.5d && d8 < 5.5d) {
            textView2.setTextColor(Color.rgb(255, 0, 0));
            findViewById.setBackgroundColor(Color.rgb(255, 0, 0));
        }
        if (d8 >= 5.5d) {
            textView2.setTextColor(Color.rgb(183, 60, 252));
            findViewById.setBackgroundColor(Color.rgb(183, 60, 252));
        }
        ((TextView) fragmentManual.f12846s0.findViewById(C2030R.id.textView04)).setText(string);
        ((TextView) fragmentManual.f12846s0.findViewById(C2030R.id.textView05)).setText(fragmentManual.d1(string2) + " - " + fragmentManual.b1(string2));
        TextView textView3 = (TextView) fragmentManual.f12846s0.findViewById(C2030R.id.textView06);
        if (fragmentManual.g1()) {
            C0891s activity = fragmentManual.getActivity();
            if (activity != null) {
                String string3 = g.b(activity).getString("eqn_system_of_units", "0");
                float[] c12 = fragmentManual.c1();
                long round = Math.round(fragmentManual.e1((double) c12[0], (double) c12[1], (double) f9, (double) f10));
                if (string3.equals("1")) {
                    textView3.setText(String.format(fragmentManual.getString(C2030R.string.official_distance_imperial_nodirection), new Object[]{Integer.valueOf((int) ((long) (((double) round) * 0.621371192d)))}));
                } else {
                    textView3.setText(String.format(fragmentManual.getString(C2030R.string.official_distance_nodirection), new Object[]{Integer.valueOf((int) round)}));
                }
                textView3.setVisibility(0);
            } else {
                textView3.setVisibility(8);
            }
        } else {
            textView3.setVisibility(8);
        }
        ((TextView) fragmentManual.f12846s0.findViewById(C2030R.id.textView07)).setText(String.format(fragmentManual.getString(C2030R.string.official_reports), new Object[]{Integer.toString(i9)}));
    }

    /* access modifiers changed from: private */
    public void W0() {
        C0891s activity = getActivity();
        if (activity != null) {
            new e(this, (a) null).execute(new Context[]{activity});
        }
    }

    private void X0(double d8, double d9) {
        C0891s activity = getActivity();
        if (activity != null) {
            ((ProgressBar) this.f12846s0.findViewById(C2030R.id.progressBar1)).setVisibility(0);
            new f(this, d8, d9, (a) null).execute(new Context[]{activity});
        }
    }

    /* access modifiers changed from: private */
    public String Y0() {
        return this.f12847t0.getString("android_id_eqn", "0");
    }

    private int Z0(int i8, int i9) {
        int i10 = i9 + (i8 * 60);
        if (i10 <= 15) {
            return 128347;
        }
        if (i10 <= 45) {
            return 128359;
        }
        if (i10 <= 75) {
            return 128336;
        }
        if (i10 <= 105) {
            return 128348;
        }
        if (i10 <= 135) {
            return 128337;
        }
        if (i10 <= 165) {
            return 128349;
        }
        if (i10 <= 195) {
            return 128338;
        }
        if (i10 <= 225) {
            return 128350;
        }
        if (i10 <= 255) {
            return 128339;
        }
        if (i10 <= 285) {
            return 128351;
        }
        if (i10 <= 315) {
            return 128340;
        }
        if (i10 <= 345) {
            return 128352;
        }
        if (i10 <= 375) {
            return 128341;
        }
        if (i10 <= 405) {
            return 128353;
        }
        if (i10 <= 435) {
            return 128342;
        }
        if (i10 <= 465) {
            return 128354;
        }
        if (i10 <= 495) {
            return 128343;
        }
        if (i10 <= 525) {
            return 128355;
        }
        if (i10 <= 555) {
            return 128344;
        }
        if (i10 <= 585) {
            return 128356;
        }
        if (i10 <= 615) {
            return 128345;
        }
        if (i10 <= 645) {
            return 128357;
        }
        if (i10 <= 675) {
            return 128346;
        }
        if (i10 <= 705) {
            return 128358;
        }
        if (i10 <= 735) {
            return 128347;
        }
        return i10 <= 765 ? 128359 : 128336;
    }

    private int a1(String str) {
        if (str == null) {
            return 0;
        }
        Date date = new Date();
        try {
            date = this.f12852y0.parse(str);
        } catch (ParseException e8) {
            if (e8.getMessage() != null) {
                Log.d("EQN", e8.getMessage());
            }
        }
        return (int) Math.round((((double) (new Date().getTime() - new Date(date.getTime() - ((long) (this.f12850w0.getOffset(date.getTime()) - this.f12851x0.getOffset(date.getTime())))).getTime())) / 1000.0d) / 60.0d);
    }

    private String b1(String str) {
        int a12 = a1(str);
        if (a12 < 60) {
            float f8 = (float) a12;
            return getResources().getQuantityString(C2030R.plurals.manual_minutes_ago, Math.round(f8), new Object[]{Integer.valueOf(Math.round(f8))});
        } else if (a12 < 1440) {
            double d8 = ((double) a12) / 60.0d;
            return getResources().getQuantityString(C2030R.plurals.manual_hours_ago, (int) Math.round(d8), new Object[]{Integer.valueOf((int) Math.round(d8))});
        } else {
            double d9 = (((double) a12) / 60.0d) / 24.0d;
            return getResources().getQuantityString(C2030R.plurals.manual_days_ago, (int) Math.round(d9), new Object[]{Integer.valueOf((int) Math.round(d9))});
        }
    }

    private float[] c1() {
        C0891s activity = getActivity();
        if (activity == null) {
            return new float[]{BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, -1.0f};
        }
        SharedPreferences sharedPreferences = activity.getSharedPreferences(MainActivity.class.getSimpleName(), 0);
        return new float[]{sharedPreferences.getFloat("current_latitude", BitmapDescriptorFactory.HUE_RED), sharedPreferences.getFloat("current_longitude", BitmapDescriptorFactory.HUE_RED), sharedPreferences.getFloat("current_accuracy", -1.0f)};
    }

    private String d1(String str) {
        if (str == null) {
            return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
        }
        Date date = new Date();
        try {
            date = this.f12852y0.parse(str);
        } catch (ParseException e8) {
            if (e8.getMessage() != null) {
                Log.d("EQN", e8.getMessage());
            }
        }
        Date date2 = new Date(date.getTime() - ((long) (this.f12850w0.getOffset(date.getTime()) - this.f12851x0.getOffset(date.getTime()))));
        this.f12839A0.setTime(date2);
        Z0(this.f12839A0.get(10), this.f12839A0.get(12));
        return this.f12853z0.format(date2);
    }

    private double e1(double d8, double d9, double d10, double d11) {
        double pow = Math.pow(Math.sin(((((d8 - d10) / 360.0d) * 2.0d) * 3.141592653589793d) / 2.0d), 2.0d) + (Math.cos((d8 / 360.0d) * 2.0d * 3.141592653589793d) * Math.cos((d10 / 360.0d) * 2.0d * 3.141592653589793d) * Math.pow(Math.sin(((((d9 - d11) / 360.0d) * 2.0d) * 3.141592653589793d) / 2.0d), 2.0d));
        return Math.atan2(Math.sqrt(pow), Math.sqrt(1.0d - pow)) * 2.0d * 6371.0d;
    }

    /* access modifiers changed from: private */
    public boolean f1() {
        boolean z7 = true;
        if (getActivity() == null) {
            return true;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            z7 = activeNetworkInfo.isConnected();
            if (!activeNetworkInfo.isAvailable()) {
                z7 = false;
            }
        }
        if (activeNetworkInfo == null) {
            return false;
        }
        return z7;
    }

    private boolean g1() {
        boolean z7;
        boolean z8;
        C0891s activity = getActivity();
        boolean z9 = false;
        if (activity == null) {
            return false;
        }
        SharedPreferences sharedPreferences = activity.getSharedPreferences(MainActivity.class.getSimpleName(), 0);
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

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0060 A[SYNTHETIC, Splitter:B:32:0x0060] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0120  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void h1(double r15, double r17) {
        /*
            r14 = this;
            java.lang.String r1 = "cache_manual4.txt"
            java.lang.String r2 = "EQN"
            r3 = 1
            r4 = 0
            androidx.fragment.app.s r0 = r14.getActivity()     // Catch:{ IOException -> 0x0043 }
            if (r0 == 0) goto L_0x004b
            java.io.FileInputStream r0 = r0.openFileInput(r1)     // Catch:{ IOException -> 0x0043 }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0043 }
            r5.<init>(r0)     // Catch:{ IOException -> 0x0043 }
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0043 }
            r0.<init>(r5)     // Catch:{ IOException -> 0x0043 }
            java.lang.String r0 = r0.readLine()     // Catch:{ IOException -> 0x0034 }
            if (r0 == 0) goto L_0x0045
            long r6 = java.lang.Long.parseLong(r0)     // Catch:{ IOException -> 0x0034 }
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x0034 }
            long r8 = r8 - r6
            r6 = 15000(0x3a98, double:7.411E-320)
            int r0 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r0 >= 0) goto L_0x0031
            r0 = r4
            goto L_0x0032
        L_0x0031:
            r0 = r3
        L_0x0032:
            r6 = r3
            goto L_0x0047
        L_0x0034:
            r0 = move-exception
            java.lang.String r6 = r0.getMessage()     // Catch:{ IOException -> 0x0043 }
            if (r6 == 0) goto L_0x0045
            java.lang.String r0 = r0.getMessage()     // Catch:{ IOException -> 0x0043 }
            android.util.Log.d(r2, r0)     // Catch:{ IOException -> 0x0043 }
            goto L_0x0045
        L_0x0043:
            r6 = r4
            goto L_0x004e
        L_0x0045:
            r0 = r3
            r6 = r4
        L_0x0047:
            r5.close()     // Catch:{ IOException -> 0x004e }
            goto L_0x004f
        L_0x004b:
            r0 = r3
            r6 = r4
            goto L_0x004f
        L_0x004e:
            r0 = r3
        L_0x004f:
            boolean r5 = r14.f1()
            if (r5 == 0) goto L_0x005e
            if (r0 == 0) goto L_0x005e
            r0 = 0
            r14.X0(r0, r0)
            goto L_0x0139
        L_0x005e:
            if (r6 == 0) goto L_0x0120
            androidx.fragment.app.s r0 = r14.getActivity()     // Catch:{ IOException -> 0x010c }
            java.io.FileInputStream r0 = r0.openFileInput(r1)     // Catch:{ IOException -> 0x010c }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x010c }
            r1.<init>(r0)     // Catch:{ IOException -> 0x010c }
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ IOException -> 0x010c }
            r0.<init>(r1)     // Catch:{ IOException -> 0x010c }
            r0.readLine()     // Catch:{ IOException -> 0x010c }
            java.lang.String r5 = r0.readLine()     // Catch:{ IOException -> 0x010c }
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ IOException -> 0x010c }
            double[] r6 = new double[r5]     // Catch:{ IOException -> 0x010c }
            double[] r7 = new double[r5]     // Catch:{ IOException -> 0x010c }
            int[] r8 = new int[r5]     // Catch:{ IOException -> 0x010c }
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ IOException -> 0x010c }
            r9 = r4
        L_0x0086:
            java.lang.String r10 = r0.readLine()     // Catch:{ IOException -> 0x00b3 }
            r11 = 2
            if (r10 == 0) goto L_0x00b5
            java.lang.String r12 = "#"
            java.lang.String[] r10 = r10.split(r12)     // Catch:{ IOException -> 0x00b3 }
            r12 = r10[r4]     // Catch:{ IOException -> 0x00b3 }
            double r12 = java.lang.Double.parseDouble(r12)     // Catch:{ IOException -> 0x00b3 }
            r6[r9] = r12     // Catch:{ IOException -> 0x00b3 }
            r12 = r10[r3]     // Catch:{ IOException -> 0x00b3 }
            double r12 = java.lang.Double.parseDouble(r12)     // Catch:{ IOException -> 0x00b3 }
            r7[r9] = r12     // Catch:{ IOException -> 0x00b3 }
            r11 = r10[r11]     // Catch:{ IOException -> 0x00b3 }
            int r11 = java.lang.Integer.parseInt(r11)     // Catch:{ IOException -> 0x00b3 }
            r8[r9] = r11     // Catch:{ IOException -> 0x00b3 }
            r11 = 3
            r10 = r10[r11]     // Catch:{ IOException -> 0x00b3 }
            r5[r9] = r10     // Catch:{ IOException -> 0x00b3 }
            int r9 = r9 + 1
            goto L_0x0086
        L_0x00b3:
            r0 = move-exception
            goto L_0x00fe
        L_0x00b5:
            android.content.Intent r0 = new android.content.Intent     // Catch:{ IOException -> 0x00b3 }
            r0.<init>()     // Catch:{ IOException -> 0x00b3 }
            androidx.fragment.app.s r4 = r14.getActivity()     // Catch:{ IOException -> 0x00b3 }
            java.lang.Class<com.finazzi.distquake.GlobeActivityAll> r9 = com.finazzi.distquake.GlobeActivityAll.class
            android.content.Intent r0 = r0.setClass(r4, r9)     // Catch:{ IOException -> 0x00b3 }
            r14.f12841n0 = r0     // Catch:{ IOException -> 0x00b3 }
            java.lang.String r4 = "com.finazzi.distquake.latitude_vector"
            r0.putExtra(r4, r6)     // Catch:{ IOException -> 0x00b3 }
            android.content.Intent r0 = r14.f12841n0     // Catch:{ IOException -> 0x00b3 }
            java.lang.String r4 = "com.finazzi.distquake.longitude_vector"
            r0.putExtra(r4, r7)     // Catch:{ IOException -> 0x00b3 }
            android.content.Intent r0 = r14.f12841n0     // Catch:{ IOException -> 0x00b3 }
            java.lang.String r4 = "com.finazzi.distquake.intensity_vector"
            r0.putExtra(r4, r8)     // Catch:{ IOException -> 0x00b3 }
            android.content.Intent r0 = r14.f12841n0     // Catch:{ IOException -> 0x00b3 }
            java.lang.String r4 = "com.finazzi.distquake.date_vector"
            r0.putExtra(r4, r5)     // Catch:{ IOException -> 0x00b3 }
            android.content.Intent r0 = r14.f12841n0     // Catch:{ IOException -> 0x00b3 }
            java.lang.String r4 = "com.finazzi.distquake.latitude_notification"
            r5 = r15
            r0.putExtra(r4, r5)     // Catch:{ IOException -> 0x00b3 }
            android.content.Intent r0 = r14.f12841n0     // Catch:{ IOException -> 0x00b3 }
            java.lang.String r4 = "com.finazzi.distquake.longitude_notification"
            r5 = r17
            r0.putExtra(r4, r5)     // Catch:{ IOException -> 0x00b3 }
            android.content.Intent r0 = r14.f12841n0     // Catch:{ IOException -> 0x00b3 }
            java.lang.String r4 = "com.finazzi.distquake.map_type"
            r0.putExtra(r4, r3)     // Catch:{ IOException -> 0x00b3 }
            android.content.Intent r0 = r14.f12841n0     // Catch:{ IOException -> 0x00b3 }
            r14.startActivityForResult(r0, r11)     // Catch:{ IOException -> 0x00b3 }
            goto L_0x010e
        L_0x00fe:
            java.lang.String r3 = r0.getMessage()     // Catch:{ IOException -> 0x010c }
            if (r3 == 0) goto L_0x010e
            java.lang.String r0 = r0.getMessage()     // Catch:{ IOException -> 0x010c }
            android.util.Log.d(r2, r0)     // Catch:{ IOException -> 0x010c }
            goto L_0x010e
        L_0x010c:
            r0 = move-exception
            goto L_0x0112
        L_0x010e:
            r1.close()     // Catch:{ IOException -> 0x010c }
            goto L_0x0139
        L_0x0112:
            java.lang.String r1 = r0.getMessage()
            if (r1 == 0) goto L_0x0139
            java.lang.String r0 = r0.getMessage()
            android.util.Log.d(r2, r0)
            goto L_0x0139
        L_0x0120:
            androidx.fragment.app.s r0 = r14.getActivity()
            if (r0 == 0) goto L_0x0139
            r1 = 2131886648(0x7f120238, float:1.940788E38)
            java.lang.String r1 = r14.getString(r1)
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r1, r3)
            r1 = 17
            r0.setGravity(r1, r4, r4)
            r0.show()
        L_0x0139:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.FragmentManual.h1(double, double):void");
    }

    private void i1() {
        C0891s activity = getActivity();
        if (activity == null) {
            return;
        }
        if (androidx.core.content.a.checkSelfPermission(activity, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            LocationServices.getFusedLocationProviderClient(activity.getApplicationContext()).getLastLocation().addOnSuccessListener(new C1860s0(this, activity));
            return;
        }
        Toast makeText = Toast.makeText(activity, getString(C2030R.string.manual_nolocation), 0);
        makeText.setGravity(17, 0, 0);
        makeText.show();
    }

    /* access modifiers changed from: private */
    public void j1(double d8, double d9, int i8, String str) {
        boolean z7;
        long j8;
        if (f1()) {
            try {
                C0891s activity = getActivity();
                if (activity != null) {
                    InputStreamReader inputStreamReader = new InputStreamReader(activity.openFileInput("last_notification.txt"));
                    try {
                        String readLine = new BufferedReader(inputStreamReader).readLine();
                        if (readLine == null) {
                            j8 = System.currentTimeMillis();
                        } else {
                            j8 = Long.parseLong(readLine);
                        }
                        if (System.currentTimeMillis() - j8 <= 120000) {
                            z7 = false;
                            inputStreamReader.close();
                        }
                    } catch (IOException unused) {
                    }
                    z7 = true;
                    inputStreamReader.close();
                } else {
                    z7 = false;
                }
            } catch (IOException unused2) {
                z7 = true;
            }
            if (z7) {
                new d(this, d8, d9, i8, str, (a) null).execute(new Context[0]);
                return;
            }
            C0891s activity2 = getActivity();
            if (activity2 != null) {
                Toast makeText = Toast.makeText(activity2, getString(C2030R.string.manual_wait), 1);
                makeText.setGravity(17, 0, 0);
                makeText.show();
                return;
            }
            return;
        }
        C0891s activity3 = getActivity();
        if (activity3 != null) {
            Toast makeText2 = Toast.makeText(activity3, getString(C2030R.string.main_nointernet), 1);
            makeText2.setGravity(17, 0, 0);
            makeText2.show();
        }
    }

    public static /* synthetic */ void t0(Task task) {
    }

    public static /* synthetic */ void v0(FragmentManual fragmentManual, RadioGroup radioGroup, DialogInterface dialogInterface, int i8) {
        fragmentManual.getClass();
        radioGroup.clearCheck();
        fragmentManual.f12844q0 = false;
    }

    public static /* synthetic */ void w0(FragmentManual fragmentManual, Activity activity, View view) {
        SharedPreferences.Editor edit = fragmentManual.f12847t0.edit();
        edit.putBoolean("show_widget_preview2", false);
        edit.apply();
        ((CardView) fragmentManual.f12846s0.findViewById(C2030R.id.cardWidget)).setVisibility(8);
        if (Build.VERSION.SDK_INT >= 26) {
            AppWidgetManager appWidgetManager = (AppWidgetManager) activity.getSystemService(AppWidgetManager.class);
            ComponentName componentName = new ComponentName(activity, AppWidgetProviderActivity.class);
            if (appWidgetManager.isRequestPinAppWidgetSupported()) {
                boolean unused = appWidgetManager.requestPinAppWidget(componentName, (Bundle) null, (PendingIntent) null);
            }
        }
    }

    public static /* synthetic */ void x0(FragmentManual fragmentManual, View view) {
        fragmentManual.getClass();
        AlertDialog.Builder builder = new AlertDialog.Builder(fragmentManual.getActivity());
        builder.setMessage(fragmentManual.getString(C2030R.string.manual_preliminary));
        builder.setCancelable(true);
        builder.setNegativeButton(fragmentManual.getString(C2030R.string.main_understood), new C1836o0());
        builder.create().show();
    }

    public static /* synthetic */ void y0(FragmentManual fragmentManual, Activity activity, Location location) {
        if (location != null) {
            fragmentManual.getClass();
            SharedPreferences.Editor edit = activity.getSharedPreferences(MainActivity.class.getSimpleName(), 0).edit();
            edit.putFloat("current_latitude", (float) location.getLatitude());
            edit.putFloat("current_longitude", (float) location.getLongitude());
            edit.putFloat("current_accuracy", location.getAccuracy());
            edit.putLong("current_location_time", location.getTime());
            edit.apply();
            new c(fragmentManual, location.getLatitude(), location.getLongitude(), (a) null).execute(new Context[0]);
            return;
        }
        FragmentManual fragmentManual2 = fragmentManual;
        if (fragmentManual2.g1()) {
            float[] c12 = fragmentManual2.c1();
            new c(fragmentManual2, (double) c12[0], (double) c12[1], (a) null).execute(new Context[0]);
            return;
        }
        Toast makeText = Toast.makeText(activity, fragmentManual2.getString(C2030R.string.manual_nolocation), 0);
        makeText.setGravity(17, 0, 0);
        makeText.show();
    }

    public static /* synthetic */ void z0(DialogInterface dialogInterface, int i8) {
    }

    public void onActivityResult(int i8, int i9, Intent intent) {
        String stringExtra;
        C0891s activity;
        C0891s activity2;
        super.onActivityResult(i8, i9, intent);
        if (i8 == 2) {
            SharedPreferences.Editor edit = this.f12847t0.edit();
            int i10 = this.f12847t0.getInt("access_counter_rating", 0) + 1;
            edit.putInt("access_counter_rating", i10);
            edit.apply();
            if (i10 % 400 == 0 && (activity2 = getActivity()) != null) {
                E3.c a8 = E3.d.a(activity2.getApplicationContext());
                a8.a().addOnCompleteListener(new C1866t0(a8, activity2));
            }
            if (i9 == 0 && intent != null && (stringExtra = intent.getStringExtra("memory")) != null && stringExtra.equalsIgnoreCase("low") && (activity = getActivity()) != null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setMessage(getString(C2030R.string.low_memory));
                builder.setCancelable(true);
                builder.setNegativeButton(getString(C2030R.string.official_close), new C1872u0());
                builder.create().show();
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f12846s0 = layoutInflater.inflate(C2030R.layout.manual_card, viewGroup, false);
        this.f12850w0 = TimeZone.getTimeZone("Europe/Paris");
        this.f12851x0 = TimeZone.getDefault();
        this.f12852y0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        this.f12853z0 = new SimpleDateFormat("HH:mm:ss dd-MMM", Locale.getDefault());
        this.f12839A0 = Calendar.getInstance();
        C0891s activity = getActivity();
        if (activity != null) {
            this.f12847t0 = activity.getSharedPreferences(MainActivity.class.getSimpleName(), 0);
        }
        boolean z7 = this.f12847t0.getBoolean("show_widget_preview2", true);
        CardView cardView = (CardView) this.f12846s0.findViewById(C2030R.id.cardWidget);
        if (!z7 || Build.VERSION.SDK_INT < 26) {
            cardView.setVisibility(8);
        } else {
            cardView.setVisibility(0);
        }
        ((Button) this.f12846s0.findViewById(C2030R.id.button02)).setOnClickListener(new C1884w0(this));
        ((Button) this.f12846s0.findViewById(C2030R.id.button04)).setOnClickListener(new C1890x0(this, activity));
        ((Button) this.f12846s0.findViewById(C2030R.id.button01)).setOnClickListener(new C1896y0(this));
        ((Button) this.f12846s0.findViewById(C2030R.id.button03)).setOnClickListener(new C1902z0(this, activity));
        ((ImageView) this.f12846s0.findViewById(C2030R.id.help)).setOnClickListener(new A0(this));
        RadioGroup radioGroup = (RadioGroup) this.f12846s0.findViewById(C2030R.id.radioGroup1);
        radioGroup.setOnCheckedChangeListener(new C1830n0(this, radioGroup));
        requireActivity().addMenuProvider(new b(), getViewLifecycleOwner(), C0910l.b.RESUMED);
        return this.f12846s0;
    }

    public void onPause() {
        this.f12848u0 = false;
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        boolean z7 = false;
        if (this.f12847t0.getBoolean("open_report_map", false)) {
            SharedPreferences.Editor edit = this.f12847t0.edit();
            edit.putBoolean("open_report_map", false);
            edit.apply();
            double d8 = (double) this.f12847t0.getFloat("latitude_notification", BitmapDescriptorFactory.HUE_RED);
            double d9 = (double) this.f12847t0.getFloat("longitude_notification", BitmapDescriptorFactory.HUE_RED);
            V0();
            if (f1()) {
                X0(d8, d9);
            } else {
                C0891s activity = getActivity();
                if (activity != null) {
                    Toast makeText = Toast.makeText(activity, getString(C2030R.string.main_nointernet), 1);
                    makeText.setGravity(17, 0, 0);
                    makeText.show();
                }
            }
        } else {
            if (System.currentTimeMillis() - this.f12847t0.getLong("network_count_last_updated", 0) > DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT) {
                z7 = true;
            }
            if (!f1() || !z7) {
                V0();
            } else {
                W0();
            }
        }
        this.f12848u0 = true;
    }

    public void onStop() {
        super.onStop();
        ((ProgressBar) this.f12846s0.findViewById(C2030R.id.progressBar1)).setVisibility(8);
    }

    private class e extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private String f12868a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f12869b;

        private e() {
            this.f12868a = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00b5, code lost:
            r0.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x00b1 */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x00b5  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x00bb  */
        /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r7) {
            /*
                r6 = this;
                r7 = 0
                com.finazzi.distquake.FragmentManual r0 = com.finazzi.distquake.FragmentManual.this
                boolean r0 = r0.isAdded()
                com.finazzi.distquake.FragmentManual r1 = com.finazzi.distquake.FragmentManual.this
                androidx.fragment.app.s r1 = r1.getActivity()
                r2 = 1
                if (r1 == 0) goto L_0x00bf
                if (r0 == 0) goto L_0x00bf
                r0 = 0
                com.finazzi.distquake.FragmentManual r1 = com.finazzi.distquake.FragmentManual.this     // Catch:{ IOException -> 0x00b1 }
                android.content.SharedPreferences r1 = r1.f12847t0     // Catch:{ IOException -> 0x00b1 }
                java.lang.String r3 = "sub_domain"
                com.finazzi.distquake.FragmentManual r4 = com.finazzi.distquake.FragmentManual.this     // Catch:{ IOException -> 0x00b1 }
                r5 = 2131887099(0x7f1203fb, float:1.9408796E38)
                java.lang.String r4 = r4.getString(r5)     // Catch:{ IOException -> 0x00b1 }
                java.lang.String r1 = r1.getString(r3, r4)     // Catch:{ IOException -> 0x00b1 }
                com.finazzi.distquake.FragmentManual r3 = com.finazzi.distquake.FragmentManual.this     // Catch:{ IOException -> 0x00b1 }
                r4 = 2131887098(0x7f1203fa, float:1.9408793E38)
                java.lang.String r3 = r3.getString(r4)     // Catch:{ IOException -> 0x00b1 }
                java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ IOException -> 0x00b1 }
                r4[r7] = r1     // Catch:{ IOException -> 0x00b1 }
                java.lang.String r1 = java.lang.String.format(r3, r4)     // Catch:{ IOException -> 0x00b1 }
                java.net.URL r3 = new java.net.URL     // Catch:{ IOException -> 0x00b1 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00b1 }
                r4.<init>()     // Catch:{ IOException -> 0x00b1 }
                r4.append(r1)     // Catch:{ IOException -> 0x00b1 }
                java.lang.String r1 = "distquake_count_redis3.php"
                r4.append(r1)     // Catch:{ IOException -> 0x00b1 }
                java.lang.String r1 = r4.toString()     // Catch:{ IOException -> 0x00b1 }
                r3.<init>(r1)     // Catch:{ IOException -> 0x00b1 }
                java.net.URLConnection r1 = r3.openConnection()     // Catch:{ IOException -> 0x00b1 }
                java.lang.Object r1 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r1)     // Catch:{ IOException -> 0x00b1 }
                java.net.URLConnection r1 = (java.net.URLConnection) r1     // Catch:{ IOException -> 0x00b1 }
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ IOException -> 0x00b1 }
                r1.setDoOutput(r7)     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                r0 = 10000(0x2710, float:1.4013E-41)
                r1.setConnectTimeout(r0)     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                r1.setReadTimeout(r0)     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                java.lang.String r0 = "Content-Type"
                java.lang.String r3 = "application/x-www-form-urlencoded;charset=utf-8"
                r1.setRequestProperty(r0, r3)     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                java.lang.String r0 = "GET"
                r1.setRequestMethod(r0)     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                java.io.InputStream r3 = r1.getInputStream()     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                r0.<init>(r3)     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                r4.<init>(r0, r5)     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                r3.<init>(r4)     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                r4.<init>()     // Catch:{ IOException -> 0x009e, all -> 0x009b }
            L_0x008c:
                java.lang.String r5 = r3.readLine()     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                if (r5 == 0) goto L_0x00a0
                r4.append(r5)     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                java.lang.String r5 = "\n"
                r4.append(r5)     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                goto L_0x008c
            L_0x009b:
                r7 = move-exception
                r0 = r1
                goto L_0x00b9
            L_0x009e:
                r0 = r1
                goto L_0x00b1
            L_0x00a0:
                r0.close()     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                java.lang.String r0 = r4.toString()     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                r6.f12868a = r0     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                r6.f12869b = r7     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                r1.disconnect()
                goto L_0x00c1
            L_0x00af:
                r7 = move-exception
                goto L_0x00b9
            L_0x00b1:
                r6.f12869b = r2     // Catch:{ all -> 0x00af }
                if (r0 == 0) goto L_0x00c1
                r0.disconnect()
                goto L_0x00c1
            L_0x00b9:
                if (r0 == 0) goto L_0x00be
                r0.disconnect()
            L_0x00be:
                throw r7
            L_0x00bf:
                r6.f12869b = r2
            L_0x00c1:
                java.lang.String r7 = "COMPLETE!"
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.FragmentManual.e.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x02db A[Catch:{ JSONException -> 0x02e7 }] */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x02f6  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x0306  */
        /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onPostExecute(java.lang.String r40) {
            /*
                r39 = this;
                r1 = r39
                java.lang.String r2 = "EQN"
                super.onPostExecute(r40)
                boolean r0 = r1.f12869b
                if (r0 != 0) goto L_0x02eb
                org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ JSONException -> 0x02ee }
                java.lang.String r3 = r1.f12868a     // Catch:{ JSONException -> 0x02ee }
                r0.<init>(r3)     // Catch:{ JSONException -> 0x02ee }
                int r3 = r0.length()     // Catch:{ JSONException -> 0x02ee }
                if (r3 <= 0) goto L_0x02eb
                r3 = 0
                org.json.JSONObject r4 = r0.getJSONObject(r3)     // Catch:{ JSONException -> 0x0091 }
                java.lang.String r5 = "eq"
                int r4 = r4.getInt(r5)     // Catch:{ JSONException -> 0x0091 }
                r5 = 1
                org.json.JSONObject r6 = r0.getJSONObject(r5)     // Catch:{ JSONException -> 0x0091 }
                java.lang.String r7 = "eq_p"
                int r6 = r6.getInt(r7)     // Catch:{ JSONException -> 0x0091 }
                r7 = 2
                org.json.JSONObject r7 = r0.getJSONObject(r7)     // Catch:{ JSONException -> 0x0091 }
                java.lang.String r8 = "green"
                int r7 = r7.getInt(r8)     // Catch:{ JSONException -> 0x0091 }
                r8 = 3
                org.json.JSONObject r8 = r0.getJSONObject(r8)     // Catch:{ JSONException -> 0x0091 }
                java.lang.String r9 = "man"
                int r8 = r8.getInt(r9)     // Catch:{ JSONException -> 0x0091 }
                r9 = 4
                org.json.JSONObject r9 = r0.getJSONObject(r9)     // Catch:{ JSONException -> 0x0091 }
                java.lang.String r10 = "diff"
                int r9 = r9.getInt(r10)     // Catch:{ JSONException -> 0x0091 }
                r10 = 6
                org.json.JSONObject r10 = r0.getJSONObject(r10)     // Catch:{ JSONException -> 0x0091 }
                java.lang.String r11 = "lc"
                java.lang.String r11 = r10.getString(r11)     // Catch:{ JSONException -> 0x0091 }
                java.lang.String r12 = ""
                java.lang.String r13 = "_"
                boolean r13 = r11.equals(r13)     // Catch:{ JSONException -> 0x0091 }
                if (r13 != 0) goto L_0x0096
                java.lang.String r12 = "ma"
                double r12 = r10.getDouble(r12)     // Catch:{ JSONException -> 0x0091 }
                float r12 = (float) r12     // Catch:{ JSONException -> 0x0091 }
                java.lang.String r13 = "la"
                double r13 = r10.getDouble(r13)     // Catch:{ JSONException -> 0x0091 }
                float r13 = (float) r13     // Catch:{ JSONException -> 0x0091 }
                java.lang.String r14 = "lo"
                double r14 = r10.getDouble(r14)     // Catch:{ JSONException -> 0x0091 }
                float r14 = (float) r14     // Catch:{ JSONException -> 0x0091 }
                java.lang.String r15 = "re"
                int r15 = r10.getInt(r15)     // Catch:{ JSONException -> 0x0091 }
                java.lang.String r5 = "dt"
                java.lang.String r5 = r10.getString(r5)     // Catch:{ JSONException -> 0x0091 }
                java.lang.String r3 = "up"
                int r3 = r10.getInt(r3)     // Catch:{ JSONException -> 0x0091 }
                r38 = r12
                r12 = r5
                r5 = r38
                goto L_0x009c
            L_0x0091:
                r0 = move-exception
                r16 = r2
                goto L_0x02d5
            L_0x0096:
                r3 = 0
                r5 = r3
                r13 = r5
                r14 = r13
                r3 = 0
                r15 = 0
            L_0x009c:
                r10 = 7
                org.json.JSONObject r10 = r0.getJSONObject(r10)     // Catch:{ JSONException -> 0x0091 }
                r16 = r2
                java.lang.String r2 = "at"
                double r17 = r10.getDouble(r2)     // Catch:{ JSONException -> 0x023b }
                r2 = 8
                org.json.JSONObject r2 = r0.getJSONObject(r2)     // Catch:{ JSONException -> 0x023b }
                java.lang.String r10 = "t10k"
                int r2 = r2.getInt(r10)     // Catch:{ JSONException -> 0x023b }
                r10 = 9
                org.json.JSONObject r10 = r0.getJSONObject(r10)     // Catch:{ JSONException -> 0x023b }
                r19 = r2
                java.lang.String r2 = "t100k"
                int r2 = r10.getInt(r2)     // Catch:{ JSONException -> 0x023b }
                r10 = 10
                org.json.JSONObject r10 = r0.getJSONObject(r10)     // Catch:{ JSONException -> 0x023b }
                r20 = r2
                java.lang.String r2 = "c_it"
                int r2 = r10.getInt(r2)     // Catch:{ JSONException -> 0x023b }
                r10 = 11
                org.json.JSONObject r10 = r0.getJSONObject(r10)     // Catch:{ JSONException -> 0x023b }
                r21 = r2
                java.lang.String r2 = "c_es"
                int r2 = r10.getInt(r2)     // Catch:{ JSONException -> 0x023b }
                r10 = 12
                org.json.JSONObject r10 = r0.getJSONObject(r10)     // Catch:{ JSONException -> 0x023b }
                r22 = r2
                java.lang.String r2 = "c_en"
                int r2 = r10.getInt(r2)     // Catch:{ JSONException -> 0x023b }
                r10 = 13
                org.json.JSONObject r10 = r0.getJSONObject(r10)     // Catch:{ JSONException -> 0x023b }
                r23 = r2
                java.lang.String r2 = "c_fr"
                int r2 = r10.getInt(r2)     // Catch:{ JSONException -> 0x023b }
                r10 = 14
                org.json.JSONObject r10 = r0.getJSONObject(r10)     // Catch:{ JSONException -> 0x023b }
                r24 = r2
                java.lang.String r2 = "c_el"
                int r2 = r10.getInt(r2)     // Catch:{ JSONException -> 0x023b }
                r10 = 15
                org.json.JSONObject r10 = r0.getJSONObject(r10)     // Catch:{ JSONException -> 0x023b }
                r25 = r2
                java.lang.String r2 = "c_tr"
                int r2 = r10.getInt(r2)     // Catch:{ JSONException -> 0x023b }
                r10 = 16
                org.json.JSONObject r10 = r0.getJSONObject(r10)     // Catch:{ JSONException -> 0x023b }
                r26 = r2
                java.lang.String r2 = "c_in"
                int r2 = r10.getInt(r2)     // Catch:{ JSONException -> 0x023b }
                r10 = 17
                org.json.JSONObject r10 = r0.getJSONObject(r10)     // Catch:{ JSONException -> 0x023b }
                r27 = r2
                java.lang.String r2 = "c_ta"
                int r2 = r10.getInt(r2)     // Catch:{ JSONException -> 0x023b }
                r10 = 18
                org.json.JSONObject r10 = r0.getJSONObject(r10)     // Catch:{ JSONException -> 0x023b }
                r28 = r2
                java.lang.String r2 = "c_jp"
                int r2 = r10.getInt(r2)     // Catch:{ JSONException -> 0x023b }
                r10 = 19
                org.json.JSONObject r10 = r0.getJSONObject(r10)     // Catch:{ JSONException -> 0x023b }
                r29 = r2
                java.lang.String r2 = "c_pt"
                int r2 = r10.getInt(r2)     // Catch:{ JSONException -> 0x023b }
                r10 = 20
                org.json.JSONObject r10 = r0.getJSONObject(r10)     // Catch:{ JSONException -> 0x023b }
                r30 = r2
                java.lang.String r2 = "c_blk"
                int r2 = r10.getInt(r2)     // Catch:{ JSONException -> 0x023b }
                r10 = 21
                org.json.JSONObject r10 = r0.getJSONObject(r10)     // Catch:{ JSONException -> 0x023b }
                r31 = r2
                java.lang.String r2 = "c_hu"
                int r2 = r10.getInt(r2)     // Catch:{ JSONException -> 0x023b }
                r10 = 22
                org.json.JSONObject r10 = r0.getJSONObject(r10)     // Catch:{ JSONException -> 0x023b }
                r32 = r2
                java.lang.String r2 = "c_mo"
                int r2 = r10.getInt(r2)     // Catch:{ JSONException -> 0x023b }
                r10 = 23
                org.json.JSONObject r10 = r0.getJSONObject(r10)     // Catch:{ JSONException -> 0x023b }
                r33 = r2
                java.lang.String r2 = "c_ar"
                int r2 = r10.getInt(r2)     // Catch:{ JSONException -> 0x023b }
                r10 = 24
                org.json.JSONObject r10 = r0.getJSONObject(r10)     // Catch:{ JSONException -> 0x023b }
                r34 = r2
                java.lang.String r2 = "c_ro"
                int r2 = r10.getInt(r2)     // Catch:{ JSONException -> 0x023b }
                r10 = 25
                org.json.JSONObject r10 = r0.getJSONObject(r10)     // Catch:{ JSONException -> 0x023b }
                r35 = r2
                java.lang.String r2 = "lk"
                java.lang.String r2 = r10.getString(r2)     // Catch:{ JSONException -> 0x023b }
                r10 = 26
                org.json.JSONObject r10 = r0.getJSONObject(r10)     // Catch:{ JSONException -> 0x023b }
                r36 = r2
                java.lang.String r2 = "c_th"
                int r2 = r10.getInt(r2)     // Catch:{ JSONException -> 0x023b }
                r10 = 27
                org.json.JSONObject r0 = r0.getJSONObject(r10)     // Catch:{ JSONException -> 0x023b }
                java.lang.String r10 = "c_my"
                int r0 = r0.getInt(r10)     // Catch:{ JSONException -> 0x023b }
                int r10 = r21 + r22
                int r10 = r10 + r23
                int r10 = r10 + r24
                int r10 = r10 + r25
                int r10 = r10 + r26
                int r10 = r10 + r27
                int r10 = r10 + r28
                int r10 = r10 + r29
                int r10 = r10 + r30
                int r10 = r10 + r31
                int r10 = r10 + r32
                int r10 = r10 + r33
                int r10 = r10 + r34
                int r10 = r10 + r35
                int r10 = r10 + r2
                int r10 = r10 + r0
                r37 = r10
                com.finazzi.distquake.FragmentManual r10 = com.finazzi.distquake.FragmentManual.this     // Catch:{ JSONException -> 0x023b }
                android.content.SharedPreferences r10 = r10.f12847t0     // Catch:{ JSONException -> 0x023b }
                android.content.SharedPreferences$Editor r10 = r10.edit()     // Catch:{ JSONException -> 0x023b }
                java.lang.String r1 = "network_count_quakes"
                r10.putInt(r1, r4)     // Catch:{ JSONException -> 0x023b }
                java.lang.String r1 = "network_count_quakes_past"
                r10.putInt(r1, r6)     // Catch:{ JSONException -> 0x023b }
                java.lang.String r1 = "network_count_green"
                r10.putInt(r1, r7)     // Catch:{ JSONException -> 0x023b }
                java.lang.String r1 = "network_count_manual"
                r10.putInt(r1, r8)     // Catch:{ JSONException -> 0x023b }
                java.lang.String r1 = "network_count_last_updated"
                long r6 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x023b }
                r10.putLong(r1, r6)     // Catch:{ JSONException -> 0x023b }
                java.lang.String r1 = "network_last_sub_minutes"
                r10.putInt(r1, r9)     // Catch:{ JSONException -> 0x023b }
                java.lang.String r1 = "preliminary_location"
                r10.putString(r1, r11)     // Catch:{ JSONException -> 0x023b }
                java.lang.String r1 = "preliminary_date"
                r10.putString(r1, r12)     // Catch:{ JSONException -> 0x023b }
                java.lang.String r1 = "preliminary_reports"
                r10.putInt(r1, r15)     // Catch:{ JSONException -> 0x023b }
                java.lang.String r1 = "preliminary_magnitude"
                r10.putFloat(r1, r5)     // Catch:{ JSONException -> 0x023b }
                java.lang.String r1 = "preliminary_latitude"
                r10.putFloat(r1, r13)     // Catch:{ JSONException -> 0x023b }
                java.lang.String r1 = "preliminary_longitude"
                r10.putFloat(r1, r14)     // Catch:{ JSONException -> 0x023b }
                java.lang.String r1 = "preliminary_updates"
                r10.putInt(r1, r3)     // Catch:{ JSONException -> 0x023b }
                double r3 = java.lang.Math.random()     // Catch:{ JSONException -> 0x023b }
                int r1 = (r3 > r17 ? 1 : (r3 == r17 ? 0 : -1))
                java.lang.String r3 = "ads_type"
                if (r1 <= 0) goto L_0x023e
                r1 = 0
                r10.putInt(r3, r1)     // Catch:{ JSONException -> 0x023b }
                goto L_0x0242
            L_0x023b:
                r0 = move-exception
                goto L_0x02d5
            L_0x023e:
                r1 = 1
                r10.putInt(r3, r1)     // Catch:{ JSONException -> 0x023b }
            L_0x0242:
                java.lang.String r1 = "top_10k_available"
                r3 = r19
                r10.putInt(r1, r3)     // Catch:{ JSONException -> 0x023b }
                java.lang.String r1 = "top_100k_available"
                r3 = r20
                r10.putInt(r1, r3)     // Catch:{ JSONException -> 0x023b }
                java.lang.String r1 = "online_chat_ita"
                r3 = r21
                r10.putInt(r1, r3)     // Catch:{ JSONException -> 0x023b }
                java.lang.String r1 = "online_chat_es"
                r3 = r22
                r10.putInt(r1, r3)     // Catch:{ JSONException -> 0x023b }
                java.lang.String r1 = "online_chat_eng"
                r3 = r23
                r10.putInt(r1, r3)     // Catch:{ JSONException -> 0x023b }
                java.lang.String r1 = "online_chat_fr"
                r3 = r24
                r10.putInt(r1, r3)     // Catch:{ JSONException -> 0x023b }
                java.lang.String r1 = "online_chat_el"
                r3 = r25
                r10.putInt(r1, r3)     // Catch:{ JSONException -> 0x023b }
                java.lang.String r1 = "online_chat_tr"
                r3 = r26
                r10.putInt(r1, r3)     // Catch:{ JSONException -> 0x023b }
                java.lang.String r1 = "online_chat_in"
                r3 = r27
                r10.putInt(r1, r3)     // Catch:{ JSONException -> 0x023b }
                java.lang.String r1 = "online_chat_tag"
                r3 = r28
                r10.putInt(r1, r3)     // Catch:{ JSONException -> 0x023b }
                java.lang.String r1 = "online_chat_jp"
                r3 = r29
                r10.putInt(r1, r3)     // Catch:{ JSONException -> 0x023b }
                java.lang.String r1 = "online_chat_pt"
                r3 = r30
                r10.putInt(r1, r3)     // Catch:{ JSONException -> 0x023b }
                java.lang.String r1 = "online_chat_blk"
                r3 = r31
                r10.putInt(r1, r3)     // Catch:{ JSONException -> 0x023b }
                java.lang.String r1 = "online_chat_hu"
                r3 = r32
                r10.putInt(r1, r3)     // Catch:{ JSONException -> 0x023b }
                java.lang.String r1 = "online_chat_mo"
                r3 = r33
                r10.putInt(r1, r3)     // Catch:{ JSONException -> 0x023b }
                java.lang.String r1 = "online_chat_ar"
                r3 = r34
                r10.putInt(r1, r3)     // Catch:{ JSONException -> 0x023b }
                java.lang.String r1 = "online_chat_ro"
                r3 = r35
                r10.putInt(r1, r3)     // Catch:{ JSONException -> 0x023b }
                java.lang.String r1 = "online_chat_th"
                r10.putInt(r1, r2)     // Catch:{ JSONException -> 0x023b }
                java.lang.String r1 = "online_chat_my"
                r10.putInt(r1, r0)     // Catch:{ JSONException -> 0x023b }
                java.lang.String r0 = "online_chat_total"
                r1 = r37
                r10.putInt(r0, r1)     // Catch:{ JSONException -> 0x023b }
                java.lang.String r0 = "sub_domain"
                r1 = r36
                r10.putString(r0, r1)     // Catch:{ JSONException -> 0x023b }
                r10.apply()     // Catch:{ JSONException -> 0x023b }
                goto L_0x02eb
            L_0x02d5:
                java.lang.String r1 = r0.getMessage()     // Catch:{ JSONException -> 0x02e7 }
                if (r1 == 0) goto L_0x02eb
                java.lang.String r0 = r0.getMessage()     // Catch:{ JSONException -> 0x02e7 }
                r1 = r16
                android.util.Log.d(r1, r0)     // Catch:{ JSONException -> 0x02e5 }
                goto L_0x02eb
            L_0x02e5:
                r0 = move-exception
                goto L_0x02f0
            L_0x02e7:
                r0 = move-exception
                r1 = r16
                goto L_0x02f0
            L_0x02eb:
                r1 = r39
                goto L_0x02fe
            L_0x02ee:
                r0 = move-exception
                r1 = r2
            L_0x02f0:
                java.lang.String r2 = r0.getMessage()
                if (r2 == 0) goto L_0x02eb
                java.lang.String r0 = r0.getMessage()
                android.util.Log.d(r1, r0)
                goto L_0x02eb
            L_0x02fe:
                com.finazzi.distquake.FragmentManual r0 = com.finazzi.distquake.FragmentManual.this
                boolean r0 = r0.f12848u0
                if (r0 == 0) goto L_0x030b
                com.finazzi.distquake.FragmentManual r0 = com.finazzi.distquake.FragmentManual.this
                r0.V0()
            L_0x030b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.FragmentManual.e.onPostExecute(java.lang.String):void");
        }

        /* synthetic */ e(FragmentManual fragmentManual, a aVar) {
            this();
        }
    }
}
