package com.finazzi.distquake;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import androidx.concurrent.futures.c;
import androidx.work.WorkerParameters;
import androidx.work.c;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.f;
import com.google.firebase.messaging.FirebaseMessaging;
import u2.M4;
import u2.N4;
import u2.O4;
import u2.P4;
import u2.Q4;
import u2.R4;
import u2.S4;
import u2.T4;

public class WorkerLocation extends androidx.work.c {

    /* renamed from: e  reason: collision with root package name */
    private CancellationTokenSource f13568e;

    private class a extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private boolean f13569a;

        /* renamed from: b  reason: collision with root package name */
        private String f13570b = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;

        /* renamed from: c  reason: collision with root package name */
        private final String f13571c;

        /* renamed from: d  reason: collision with root package name */
        private final String f13572d;

        /* renamed from: e  reason: collision with root package name */
        private final d f13573e;

        /* renamed from: f  reason: collision with root package name */
        float f13574f;

        /* renamed from: g  reason: collision with root package name */
        float f13575g;

        a(String str, String str2, float f8, float f9, d dVar) {
            this.f13572d = str;
            this.f13571c = str2;
            this.f13574f = f8;
            this.f13575g = f9;
            this.f13573e = dVar;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x00cb, code lost:
            r1.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x00c7 */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x00cb  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00d3  */
        /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r7) {
            /*
                r6 = this;
                java.util.HashMap r7 = new java.util.HashMap
                r7.<init>()
                java.lang.String r0 = "u_id"
                java.lang.String r1 = r6.f13572d
                r7.put(r0, r1)
                java.lang.String r0 = "r_id"
                java.lang.String r1 = r6.f13571c
                r7.put(r0, r1)
                float r0 = r6.f13574f
                java.lang.String r0 = java.lang.Float.toString(r0)
                java.lang.String r1 = "lat"
                r7.put(r1, r0)
                float r0 = r6.f13575g
                java.lang.String r0 = java.lang.Float.toString(r0)
                java.lang.String r1 = "lon"
                r7.put(r1, r0)
                java.lang.String r7 = u2.C1737L.a(r7)
                r0 = 1
                r1 = 0
                java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x00c7 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00c7 }
                r3.<init>()     // Catch:{ IOException -> 0x00c7 }
                com.finazzi.distquake.WorkerLocation r4 = com.finazzi.distquake.WorkerLocation.this     // Catch:{ IOException -> 0x00c7 }
                android.content.Context r4 = r4.getApplicationContext()     // Catch:{ IOException -> 0x00c7 }
                r5 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r4 = r4.getString(r5)     // Catch:{ IOException -> 0x00c7 }
                r3.append(r4)     // Catch:{ IOException -> 0x00c7 }
                java.lang.String r4 = "distquake_upload_gcm_regid2.php"
                r3.append(r4)     // Catch:{ IOException -> 0x00c7 }
                java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x00c7 }
                r2.<init>(r3)     // Catch:{ IOException -> 0x00c7 }
                java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IOException -> 0x00c7 }
                java.lang.Object r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r2)     // Catch:{ IOException -> 0x00c7 }
                java.net.URLConnection r2 = (java.net.URLConnection) r2     // Catch:{ IOException -> 0x00c7 }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x00c7 }
                r2.setDoOutput(r0)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r1 = 10000(0x2710, float:1.4013E-41)
                r2.setConnectTimeout(r1)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r2.setReadTimeout(r1)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.lang.String r1 = "Content-Type"
                java.lang.String r3 = "application/x-www-form-urlencoded;charset=utf-8"
                r2.setRequestProperty(r1, r3)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.lang.String r1 = "POST"
                r2.setRequestMethod(r1)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                byte[] r1 = r7.getBytes()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                int r1 = r1.length     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r2.setFixedLengthStreamingMode(r1)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.io.PrintWriter r1 = new java.io.PrintWriter     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.io.OutputStream r3 = r2.getOutputStream()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r1.<init>(r3)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r1.print(r7)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r1.close()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.io.InputStream r1 = r2.getInputStream()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r7.<init>(r1)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r3.<init>(r7, r4)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r1.<init>(r3)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r3.<init>()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
            L_0x00a6:
                java.lang.String r4 = r1.readLine()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                if (r4 == 0) goto L_0x00b5
                r3.append(r4)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                goto L_0x00a6
            L_0x00b0:
                r7 = move-exception
                r1 = r2
                goto L_0x00d1
            L_0x00b3:
                r1 = r2
                goto L_0x00c7
            L_0x00b5:
                r7.close()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.lang.String r7 = r3.toString()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r6.f13570b = r7     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r7 = 0
                r6.f13569a = r7     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r2.disconnect()
                goto L_0x00ce
            L_0x00c5:
                r7 = move-exception
                goto L_0x00d1
            L_0x00c7:
                r6.f13569a = r0     // Catch:{ all -> 0x00c5 }
                if (r1 == 0) goto L_0x00ce
                r1.disconnect()
            L_0x00ce:
                java.lang.String r7 = "COMPLETE!"
                return r7
            L_0x00d1:
                if (r1 == 0) goto L_0x00d6
                r1.disconnect()
            L_0x00d6:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.WorkerLocation.a.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            SharedPreferences.Editor edit = WorkerLocation.this.getApplicationContext().getSharedPreferences(MainActivity.class.getSimpleName(), 0).edit();
            if (this.f13569a) {
                this.f13573e.a(2);
            } else if (this.f13570b.equalsIgnoreCase("nok")) {
                this.f13573e.a(2);
            } else {
                try {
                    if (Integer.parseInt(this.f13570b) != 0) {
                        edit.putString("android_id_eqn", this.f13570b);
                        edit.putBoolean("FCM_refresh", false);
                        edit.putString("last_FCM_registered_token", this.f13571c);
                        edit.putLong("last_FCM_registered_token_time", System.currentTimeMillis());
                        edit.apply();
                        this.f13573e.a(0);
                        return;
                    }
                    this.f13573e.a(2);
                } catch (NumberFormatException unused) {
                    this.f13573e.a(2);
                }
            }
        }
    }

    private class b extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private final String f13577a;

        /* renamed from: b  reason: collision with root package name */
        private final String f13578b;

        b(String str, String str2) {
            this.f13577a = str;
            this.f13578b = str2;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x00a1  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x00a7  */
        /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r6) {
            /*
                r5 = this;
                java.util.HashMap r6 = new java.util.HashMap
                r6.<init>()
                java.lang.String r0 = "u_id"
                java.lang.String r1 = r5.f13577a
                r6.put(r0, r1)
                java.lang.String r0 = "tile"
                java.lang.String r1 = r5.f13578b
                r6.put(r0, r1)
                java.lang.String r6 = u2.C1737L.a(r6)
                r0 = 0
                java.net.URL r1 = new java.net.URL     // Catch:{ IOException -> 0x00a5, all -> 0x009e }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00a5, all -> 0x009e }
                r2.<init>()     // Catch:{ IOException -> 0x00a5, all -> 0x009e }
                com.finazzi.distquake.WorkerLocation r3 = com.finazzi.distquake.WorkerLocation.this     // Catch:{ IOException -> 0x00a5, all -> 0x009e }
                android.content.Context r3 = r3.getApplicationContext()     // Catch:{ IOException -> 0x00a5, all -> 0x009e }
                r4 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r3 = r3.getString(r4)     // Catch:{ IOException -> 0x00a5, all -> 0x009e }
                r2.append(r3)     // Catch:{ IOException -> 0x00a5, all -> 0x009e }
                java.lang.String r3 = "distquake_update_tile.php"
                r2.append(r3)     // Catch:{ IOException -> 0x00a5, all -> 0x009e }
                java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x00a5, all -> 0x009e }
                r1.<init>(r2)     // Catch:{ IOException -> 0x00a5, all -> 0x009e }
                java.net.URLConnection r1 = r1.openConnection()     // Catch:{ IOException -> 0x00a5, all -> 0x009e }
                java.lang.Object r1 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r1)     // Catch:{ IOException -> 0x00a5, all -> 0x009e }
                java.net.URLConnection r1 = (java.net.URLConnection) r1     // Catch:{ IOException -> 0x00a5, all -> 0x009e }
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ IOException -> 0x00a5, all -> 0x009e }
                r0 = 1
                r1.setDoOutput(r0)     // Catch:{ IOException -> 0x009c, all -> 0x0099 }
                r0 = 15000(0x3a98, float:2.102E-41)
                r1.setConnectTimeout(r0)     // Catch:{ IOException -> 0x009c, all -> 0x0099 }
                r1.setReadTimeout(r0)     // Catch:{ IOException -> 0x009c, all -> 0x0099 }
                java.lang.String r0 = "Content-Type"
                java.lang.String r2 = "application/x-www-form-urlencoded;charset=utf-8"
                r1.setRequestProperty(r0, r2)     // Catch:{ IOException -> 0x009c, all -> 0x0099 }
                java.lang.String r0 = "POST"
                r1.setRequestMethod(r0)     // Catch:{ IOException -> 0x009c, all -> 0x0099 }
                byte[] r0 = r6.getBytes()     // Catch:{ IOException -> 0x009c, all -> 0x0099 }
                int r0 = r0.length     // Catch:{ IOException -> 0x009c, all -> 0x0099 }
                r1.setFixedLengthStreamingMode(r0)     // Catch:{ IOException -> 0x009c, all -> 0x0099 }
                java.io.PrintWriter r0 = new java.io.PrintWriter     // Catch:{ IOException -> 0x009c, all -> 0x0099 }
                java.io.OutputStream r2 = r1.getOutputStream()     // Catch:{ IOException -> 0x009c, all -> 0x0099 }
                r0.<init>(r2)     // Catch:{ IOException -> 0x009c, all -> 0x0099 }
                r0.print(r6)     // Catch:{ IOException -> 0x009c, all -> 0x0099 }
                r0.close()     // Catch:{ IOException -> 0x009c, all -> 0x0099 }
                java.io.BufferedInputStream r6 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x009c, all -> 0x0099 }
                java.io.InputStream r0 = r1.getInputStream()     // Catch:{ IOException -> 0x009c, all -> 0x0099 }
                r6.<init>(r0)     // Catch:{ IOException -> 0x009c, all -> 0x0099 }
                java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ IOException -> 0x009c, all -> 0x0099 }
                java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x009c, all -> 0x0099 }
                java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x009c, all -> 0x0099 }
                r2.<init>(r6, r3)     // Catch:{ IOException -> 0x009c, all -> 0x0099 }
                r0.<init>(r2)     // Catch:{ IOException -> 0x009c, all -> 0x0099 }
            L_0x008b:
                java.lang.String r2 = r0.readLine()     // Catch:{ IOException -> 0x009c, all -> 0x0099 }
                if (r2 == 0) goto L_0x0092
                goto L_0x008b
            L_0x0092:
                r6.close()     // Catch:{ IOException -> 0x009c, all -> 0x0099 }
                r1.disconnect()
                goto L_0x00aa
            L_0x0099:
                r6 = move-exception
                r0 = r1
                goto L_0x009f
            L_0x009c:
                r0 = r1
                goto L_0x00a5
            L_0x009e:
                r6 = move-exception
            L_0x009f:
                if (r0 == 0) goto L_0x00a4
                r0.disconnect()
            L_0x00a4:
                throw r6
            L_0x00a5:
                if (r0 == 0) goto L_0x00aa
                r0.disconnect()
            L_0x00aa:
                java.lang.String r6 = "COMPLETE!"
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.WorkerLocation.b.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
        }
    }

    private class c extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private boolean f13580a;

        /* renamed from: b  reason: collision with root package name */
        private String f13581b = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;

        /* renamed from: c  reason: collision with root package name */
        private final String f13582c;

        /* renamed from: d  reason: collision with root package name */
        private final d f13583d;

        /* renamed from: e  reason: collision with root package name */
        private final float f13584e;

        /* renamed from: f  reason: collision with root package name */
        private final float f13585f;

        /* renamed from: g  reason: collision with root package name */
        private final float f13586g;

        /* renamed from: h  reason: collision with root package name */
        private final float f13587h;

        /* renamed from: i  reason: collision with root package name */
        private final float f13588i;

        c(String str, float f8, float f9, float f10, float f11, float f12, d dVar) {
            this.f13582c = str;
            this.f13584e = f8;
            this.f13585f = f9;
            this.f13586g = f10;
            this.f13587h = f11;
            this.f13588i = f12;
            this.f13583d = dVar;
        }

        public static /* synthetic */ void a(c cVar, Task task) {
            cVar.getClass();
            if (task.isSuccessful()) {
                String str = (String) task.getResult();
                if (str.equalsIgnoreCase(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED)) {
                    cVar.f13583d.a(2);
                } else if (WorkerLocation.this.n()) {
                    new a(cVar.f13582c, str, cVar.f13584e, cVar.f13585f, cVar.f13583d).execute(new Context[]{WorkerLocation.this.getApplicationContext()});
                } else {
                    cVar.f13583d.a(2);
                }
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00fd, code lost:
            r1.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x00f9 */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x00fd  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0105  */
        /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r7) {
            /*
                r6 = this;
                java.util.HashMap r7 = new java.util.HashMap
                r7.<init>()
                java.lang.String r0 = "u_id"
                java.lang.String r1 = r6.f13582c
                r7.put(r0, r1)
                float r0 = r6.f13584e
                java.lang.String r0 = java.lang.Float.toString(r0)
                java.lang.String r1 = "lat"
                r7.put(r1, r0)
                float r0 = r6.f13585f
                java.lang.String r0 = java.lang.Float.toString(r0)
                java.lang.String r1 = "lon"
                r7.put(r1, r0)
                float r0 = r6.f13586g
                java.lang.String r0 = java.lang.Float.toString(r0)
                java.lang.String r1 = "acc"
                r7.put(r1, r0)
                float r0 = r6.f13584e
                float r1 = r6.f13587h
                float r0 = r0 - r1
                float r0 = java.lang.Math.abs(r0)
                double r0 = (double) r0
                r2 = 4591870180066957722(0x3fb999999999999a, double:0.1)
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                java.lang.String r1 = "upd"
                if (r0 >= 0) goto L_0x0056
                float r0 = r6.f13585f
                float r4 = r6.f13588i
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
                java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x00f9 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00f9 }
                r3.<init>()     // Catch:{ IOException -> 0x00f9 }
                com.finazzi.distquake.WorkerLocation r4 = com.finazzi.distquake.WorkerLocation.this     // Catch:{ IOException -> 0x00f9 }
                android.content.Context r4 = r4.getApplicationContext()     // Catch:{ IOException -> 0x00f9 }
                r5 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r4 = r4.getString(r5)     // Catch:{ IOException -> 0x00f9 }
                r3.append(r4)     // Catch:{ IOException -> 0x00f9 }
                java.lang.String r4 = "distquake_upload_gcm_latlon.php"
                r3.append(r4)     // Catch:{ IOException -> 0x00f9 }
                java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x00f9 }
                r2.<init>(r3)     // Catch:{ IOException -> 0x00f9 }
                java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IOException -> 0x00f9 }
                java.lang.Object r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r2)     // Catch:{ IOException -> 0x00f9 }
                java.net.URLConnection r2 = (java.net.URLConnection) r2     // Catch:{ IOException -> 0x00f9 }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x00f9 }
                r2.setDoOutput(r0)     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                r1 = 10000(0x2710, float:1.4013E-41)
                r2.setConnectTimeout(r1)     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                r2.setReadTimeout(r1)     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                java.lang.String r1 = "Content-Type"
                java.lang.String r3 = "application/x-www-form-urlencoded;charset=utf-8"
                r2.setRequestProperty(r1, r3)     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                java.lang.String r1 = "POST"
                r2.setRequestMethod(r1)     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                byte[] r1 = r7.getBytes()     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                int r1 = r1.length     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                r2.setFixedLengthStreamingMode(r1)     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                java.io.PrintWriter r1 = new java.io.PrintWriter     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                java.io.OutputStream r3 = r2.getOutputStream()     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                r1.<init>(r3)     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                r1.print(r7)     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                r1.close()     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                java.io.InputStream r1 = r2.getInputStream()     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                r7.<init>(r1)     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                r3.<init>(r7, r4)     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                r1.<init>(r3)     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                r3.<init>()     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
            L_0x00d8:
                java.lang.String r4 = r1.readLine()     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                if (r4 == 0) goto L_0x00e7
                r3.append(r4)     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                goto L_0x00d8
            L_0x00e2:
                r7 = move-exception
                r1 = r2
                goto L_0x0103
            L_0x00e5:
                r1 = r2
                goto L_0x00f9
            L_0x00e7:
                r7.close()     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                java.lang.String r7 = r3.toString()     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                r6.f13581b = r7     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                r7 = 0
                r6.f13580a = r7     // Catch:{ IOException -> 0x00e5, all -> 0x00e2 }
                r2.disconnect()
                goto L_0x0100
            L_0x00f7:
                r7 = move-exception
                goto L_0x0103
            L_0x00f9:
                r6.f13580a = r0     // Catch:{ all -> 0x00f7 }
                if (r1 == 0) goto L_0x0100
                r1.disconnect()
            L_0x0100:
                java.lang.String r7 = "COMPLETE!"
                return r7
            L_0x0103:
                if (r1 == 0) goto L_0x0108
                r1.disconnect()
            L_0x0108:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.WorkerLocation.c.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            if (!this.f13580a) {
                SharedPreferences.Editor edit = WorkerLocation.this.getApplicationContext().getSharedPreferences(MainActivity.class.getSimpleName(), 0).edit();
                String str2 = this.f13581b;
                str2.getClass();
                char c8 = 65535;
                switch (str2.hashCode()) {
                    case 3548:
                        if (str2.equals("ok")) {
                            c8 = 0;
                            break;
                        }
                        break;
                    case 109258:
                        if (str2.equals("nok")) {
                            c8 = 1;
                            break;
                        }
                        break;
                    case 112788:
                        if (str2.equals("reg")) {
                            c8 = 2;
                            break;
                        }
                        break;
                    case 3532159:
                        if (str2.equals("skip")) {
                            c8 = 3;
                            break;
                        }
                        break;
                }
                switch (c8) {
                    case 0:
                        edit.putFloat("last_db_saved_lat", this.f13584e);
                        edit.putFloat("last_db_saved_lon", this.f13585f);
                        edit.apply();
                        this.f13583d.a(0);
                        return;
                    case 1:
                        this.f13583d.a(2);
                        return;
                    case 2:
                        edit.putBoolean("FCM_refresh", true);
                        edit.apply();
                        FirebaseMessaging.p().s().addOnCompleteListener(new f0(this));
                        return;
                    case 3:
                        this.f13583d.a(0);
                        return;
                    default:
                        return;
                }
            } else {
                this.f13583d.a(2);
            }
        }
    }

    public interface d {
        void a(int i8);
    }

    public WorkerLocation(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public static /* synthetic */ void b(WorkerLocation workerLocation, SharedPreferences.Editor editor, String str, double d8, double d9, Task task) {
        workerLocation.getClass();
        Class<MainActivity> cls = MainActivity.class;
        if (task.isSuccessful()) {
            editor.putString("topic_last_tile_subscribed", str);
            editor.putBoolean("topic_tile_subscribed_successfully", true);
            editor.putFloat("topic_last_latitude_subscribed", (float) d8);
            editor.putFloat("topic_last_longitude_subscribed", (float) d9);
            new b(workerLocation.getApplicationContext().getSharedPreferences(cls.getSimpleName(), 0).getString("android_id_eqn", "0"), str).execute(new Context[]{workerLocation.getApplicationContext()});
        } else {
            editor.putBoolean("topic_tile_subscribed_successfully", false);
            new b(workerLocation.getApplicationContext().getSharedPreferences(cls.getSimpleName(), 0).getString("android_id_eqn", "0"), RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).execute(new Context[]{workerLocation.getApplicationContext()});
        }
        editor.apply();
    }

    public static /* synthetic */ void c(WorkerLocation workerLocation, c.a aVar, int i8) {
        workerLocation.getClass();
        if (i8 == 0) {
            aVar.c(c.a.c());
        } else if (i8 == 1) {
            aVar.c(c.a.a());
        } else if (i8 == 2) {
            aVar.c(c.a.b());
        }
        CancellationTokenSource cancellationTokenSource = workerLocation.f13568e;
        if (cancellationTokenSource != null) {
            cancellationTokenSource.cancel();
        }
    }

    public static /* synthetic */ void d(WorkerLocation workerLocation, SharedPreferences.Editor editor, String str, double d8, double d9, String str2, Task task) {
        workerLocation.getClass();
        if (task.isSuccessful()) {
            editor.putString("topic_last_tile_subscribed", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
            editor.putBoolean("topic_tile_unsubscribed_successfully", true);
            editor.apply();
            FirebaseMessaging.p().E(str).addOnCompleteListener(new T4(workerLocation, editor, str, d8, d9));
            return;
        }
        editor.putBoolean("topic_tile_unsubscribed_successfully", false);
        editor.putBoolean("topic_tile_subscribed_successfully", false);
        editor.putString("topic_tile_unsubscribed_unsuccessfully", str2);
        editor.apply();
    }

    public static /* synthetic */ void f(WorkerLocation workerLocation, d dVar, c.a aVar, FusedLocationProviderClient fusedLocationProviderClient, Location location) {
        WorkerLocation workerLocation2 = workerLocation;
        c.a aVar2 = aVar;
        if (location != null) {
            SharedPreferences sharedPreferences = workerLocation2.getApplicationContext().getSharedPreferences(MainActivity.class.getSimpleName(), 0);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            String string = sharedPreferences.getString("android_id_eqn", "0");
            float f8 = sharedPreferences.getFloat("last_db_saved_lat", BitmapDescriptorFactory.HUE_RED);
            float f9 = sharedPreferences.getFloat("last_db_saved_lon", BitmapDescriptorFactory.HUE_RED);
            float latitude = (float) location.getLatitude();
            float longitude = (float) location.getLongitude();
            float accuracy = location.getAccuracy();
            long time = location.getTime();
            if (latitude == BitmapDescriptorFactory.HUE_RED || longitude == BitmapDescriptorFactory.HUE_RED) {
                aVar2.c(c.a.a());
                return;
            }
            edit.putFloat("current_latitude", latitude);
            edit.putFloat("current_longitude", longitude);
            edit.putFloat("current_accuracy", accuracy);
            edit.putLong("current_location_time", time);
            edit.apply();
            workerLocation2.m((double) latitude, (double) longitude);
            if (string.equalsIgnoreCase("0")) {
                aVar2.c(c.a.a());
            } else if (workerLocation2.n()) {
                new c(string, latitude, longitude, accuracy, f8, f9, dVar).execute(new Context[0]);
            } else {
                aVar2.c(c.a.b());
            }
        } else if (!workerLocation2.o()) {
            CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
            workerLocation2.f13568e = cancellationTokenSource;
            fusedLocationProviderClient.getCurrentLocation(102, cancellationTokenSource.getToken()).addOnSuccessListener(new Q4(workerLocation2, dVar, aVar2));
        } else {
            aVar2.c(c.a.a());
        }
    }

    public static /* synthetic */ Object g(WorkerLocation workerLocation, c.a aVar) {
        workerLocation.getClass();
        N4 n42 = new N4(workerLocation, aVar);
        if (androidx.core.content.a.checkSelfPermission(workerLocation.getApplicationContext(), "android.permission.ACCESS_COARSE_LOCATION") == 0 || androidx.core.content.a.checkSelfPermission(workerLocation.getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION") == 0) {
            FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(workerLocation.getApplicationContext());
            fusedLocationProviderClient.getLastLocation().addOnFailureListener(new O4(aVar)).addOnSuccessListener(new P4(workerLocation, n42, aVar, fusedLocationProviderClient));
            return "forDebug";
        }
        aVar.c(c.a.a());
        return "forDebug";
    }

    public static /* synthetic */ void h(WorkerLocation workerLocation, SharedPreferences.Editor editor, String str, double d8, double d9, Task task) {
        workerLocation.getClass();
        Class<MainActivity> cls = MainActivity.class;
        if (task.isSuccessful()) {
            editor.putString("topic_last_tile_subscribed", str);
            editor.putBoolean("topic_tile_subscribed_successfully", true);
            editor.putFloat("topic_last_latitude_subscribed", (float) d8);
            editor.putFloat("topic_last_longitude_subscribed", (float) d9);
            new b(workerLocation.getApplicationContext().getSharedPreferences(cls.getSimpleName(), 0).getString("android_id_eqn", "0"), str).execute(new Context[]{workerLocation.getApplicationContext()});
        } else {
            editor.putBoolean("topic_tile_subscribed_successfully", false);
            new b(workerLocation.getApplicationContext().getSharedPreferences(cls.getSimpleName(), 0).getString("android_id_eqn", "0"), RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).execute(new Context[]{workerLocation.getApplicationContext()});
        }
        editor.apply();
    }

    public static /* synthetic */ void i(WorkerLocation workerLocation, d dVar, c.a aVar, Location location) {
        c.a aVar2 = aVar;
        if (location != null) {
            SharedPreferences sharedPreferences = workerLocation.getApplicationContext().getSharedPreferences(MainActivity.class.getSimpleName(), 0);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            String string = sharedPreferences.getString("android_id_eqn", "0");
            float f8 = sharedPreferences.getFloat("last_db_saved_lat", BitmapDescriptorFactory.HUE_RED);
            float f9 = sharedPreferences.getFloat("last_db_saved_lon", BitmapDescriptorFactory.HUE_RED);
            float latitude = (float) location.getLatitude();
            float longitude = (float) location.getLongitude();
            float accuracy = location.getAccuracy();
            long time = location.getTime();
            if (latitude == BitmapDescriptorFactory.HUE_RED || longitude == BitmapDescriptorFactory.HUE_RED) {
                aVar2.c(c.a.a());
                return;
            }
            edit.putFloat("current_latitude", latitude);
            edit.putFloat("current_longitude", longitude);
            edit.putFloat("current_accuracy", accuracy);
            edit.putLong("current_location_time", time);
            edit.apply();
            WorkerLocation workerLocation2 = workerLocation;
            workerLocation2.m((double) latitude, (double) longitude);
            if (string.equalsIgnoreCase("0")) {
                aVar2.c(c.a.a());
            } else if (workerLocation2.n()) {
                new c(string, latitude, longitude, accuracy, f8, f9, dVar).execute(new Context[0]);
            } else {
                aVar2.c(c.a.b());
            }
        } else {
            workerLocation.getClass();
            aVar2.c(c.a.a());
        }
    }

    private String k(double d8, double d9) {
        return "x" + Integer.toString((int) Math.floor((d9 + 180.0d) / 10.0d)) + "y" + Integer.toString((int) Math.floor((d8 + 90.0d) / 10.0d));
    }

    private double l(double d8, double d9, double d10, double d11) {
        double pow = Math.pow(Math.sin(((((d8 - d10) / 360.0d) * 2.0d) * 3.141592653589793d) / 2.0d), 2.0d) + (Math.cos((d8 / 360.0d) * 2.0d * 3.141592653589793d) * Math.cos((d10 / 360.0d) * 2.0d * 3.141592653589793d) * Math.pow(Math.sin(((((d9 - d11) / 360.0d) * 2.0d) * 3.141592653589793d) / 2.0d), 2.0d));
        return Math.atan2(Math.sqrt(pow), Math.sqrt(1.0d - pow)) * 2.0d * 6371.0d;
    }

    private void m(double d8, double d9) {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("no_backup_pref", 0);
        double d10 = d8;
        double d11 = d9;
        double l7 = l(d10, d11, (double) sharedPreferences.getFloat("topic_last_latitude_subscribed", BitmapDescriptorFactory.HUE_RED), (double) sharedPreferences.getFloat("topic_last_longitude_subscribed", BitmapDescriptorFactory.HUE_RED));
        String string = sharedPreferences.getString("topic_last_tile_subscribed", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        if ((l7 > 100.0d || string.isEmpty()) && !string.equals(k(d8, d9))) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean("topic_tile_unsubscribed_successfully", false);
            edit.apply();
            p(d8, d9);
        }
    }

    /* access modifiers changed from: private */
    public boolean n() {
        boolean z7;
        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService("connectivity");
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

    private boolean o() {
        boolean z7;
        boolean z8;
        boolean z9 = false;
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(MainActivity.class.getSimpleName(), 0);
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

    private void p(double d8, double d9) {
        String str = "x" + Integer.toString((int) Math.floor((180.0d + d9) / 10.0d)) + "y" + Integer.toString((int) Math.floor((90.0d + d8) / 10.0d));
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("no_backup_pref", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        String string = sharedPreferences.getString("topic_last_tile_subscribed", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        if (!string.isEmpty()) {
            FirebaseMessaging.p().H(string).addOnCompleteListener(new R4(this, edit, str, d8, d9, string));
        } else {
            FirebaseMessaging.p().E(str).addOnCompleteListener(new S4(this, edit, str, d8, d9));
        }
    }

    public f startWork() {
        return androidx.concurrent.futures.c.a(new M4(this));
    }
}
