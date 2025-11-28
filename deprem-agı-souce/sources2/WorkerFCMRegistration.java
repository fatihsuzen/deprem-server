package com.finazzi.distquake;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import androidx.concurrent.futures.c;
import androidx.work.WorkerParameters;
import androidx.work.c;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.f;
import com.google.firebase.messaging.FirebaseMessaging;
import u2.J4;
import u2.K4;
import u2.L4;

public class WorkerFCMRegistration extends c {

    private class a extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private boolean f13560a;

        /* renamed from: b  reason: collision with root package name */
        private String f13561b = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;

        /* renamed from: c  reason: collision with root package name */
        private final String f13562c;

        /* renamed from: d  reason: collision with root package name */
        private final String f13563d;

        /* renamed from: e  reason: collision with root package name */
        private final b f13564e;

        /* renamed from: f  reason: collision with root package name */
        float f13565f;

        /* renamed from: g  reason: collision with root package name */
        float f13566g;

        a(String str, String str2, float f8, float f9, b bVar) {
            this.f13563d = str;
            this.f13562c = str2;
            this.f13565f = f8;
            this.f13566g = f9;
            this.f13564e = bVar;
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
                java.lang.String r1 = r6.f13563d
                r7.put(r0, r1)
                java.lang.String r0 = "r_id"
                java.lang.String r1 = r6.f13562c
                r7.put(r0, r1)
                float r0 = r6.f13565f
                java.lang.String r0 = java.lang.Float.toString(r0)
                java.lang.String r1 = "lat"
                r7.put(r1, r0)
                float r0 = r6.f13566g
                java.lang.String r0 = java.lang.Float.toString(r0)
                java.lang.String r1 = "lon"
                r7.put(r1, r0)
                java.lang.String r7 = u2.C1737L.a(r7)
                r0 = 1
                r1 = 0
                java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x00c7 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00c7 }
                r3.<init>()     // Catch:{ IOException -> 0x00c7 }
                com.finazzi.distquake.WorkerFCMRegistration r4 = com.finazzi.distquake.WorkerFCMRegistration.this     // Catch:{ IOException -> 0x00c7 }
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
                r6.f13561b = r7     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r7 = 0
                r6.f13560a = r7     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r2.disconnect()
                goto L_0x00ce
            L_0x00c5:
                r7 = move-exception
                goto L_0x00d1
            L_0x00c7:
                r6.f13560a = r0     // Catch:{ all -> 0x00c5 }
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
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.WorkerFCMRegistration.a.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            SharedPreferences.Editor edit = WorkerFCMRegistration.this.getApplicationContext().getSharedPreferences(MainActivity.class.getSimpleName(), 0).edit();
            if (this.f13560a) {
                this.f13564e.a(2);
            } else if (this.f13561b.equalsIgnoreCase("nok")) {
                this.f13564e.a(2);
            } else {
                try {
                    if (Integer.parseInt(this.f13561b) != 0) {
                        edit.putString("android_id_eqn", this.f13561b);
                        edit.putBoolean("FCM_refresh", false);
                        edit.putString("last_FCM_registered_token", this.f13562c);
                        edit.putLong("last_FCM_registered_token_time", System.currentTimeMillis());
                        edit.apply();
                        this.f13564e.a(0);
                        return;
                    }
                    this.f13564e.a(2);
                } catch (NumberFormatException unused) {
                    this.f13564e.a(2);
                }
            }
        }
    }

    public interface b {
        void a(int i8);
    }

    public WorkerFCMRegistration(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public static /* synthetic */ void b(c.a aVar, int i8) {
        if (i8 == 0) {
            aVar.c(c.a.c());
        } else if (i8 == 1) {
            aVar.c(c.a.a());
        } else if (i8 == 2) {
            aVar.c(c.a.b());
        }
    }

    public static /* synthetic */ void c(WorkerFCMRegistration workerFCMRegistration, b bVar, String str, float f8, float f9, Task task) {
        workerFCMRegistration.getClass();
        if (!task.isSuccessful()) {
            bVar.a(1);
            return;
        }
        String str2 = (String) task.getResult();
        if (str2 == null) {
            bVar.a(2);
        } else if (str2.equalsIgnoreCase(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED)) {
            bVar.a(2);
        } else if (workerFCMRegistration.e()) {
            WorkerFCMRegistration workerFCMRegistration2 = workerFCMRegistration;
            new a(str, str2, f8, f9, bVar).execute(new Context[]{workerFCMRegistration2.getApplicationContext()});
        } else {
            bVar.a(2);
        }
    }

    public static /* synthetic */ Object d(WorkerFCMRegistration workerFCMRegistration, c.a aVar) {
        boolean z7;
        workerFCMRegistration.getClass();
        K4 k42 = new K4(aVar);
        SharedPreferences sharedPreferences = workerFCMRegistration.getApplicationContext().getSharedPreferences(MainActivity.class.getSimpleName(), 0);
        boolean z8 = sharedPreferences.getBoolean("FCM_refresh", false);
        float f8 = sharedPreferences.getFloat("current_latitude", BitmapDescriptorFactory.HUE_RED);
        float f9 = sharedPreferences.getFloat("current_longitude", BitmapDescriptorFactory.HUE_RED);
        String string = sharedPreferences.getString("android_id_eqn", "0");
        if (System.currentTimeMillis() - sharedPreferences.getLong("last_FCM_registered_token_time", 0) > 2600000000L) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (string.equals("0") || z8 || z7) {
            FirebaseMessaging.p().s().addOnCompleteListener(new L4(workerFCMRegistration, k42, string, f8, f9));
            return "forDebug";
        }
        k42.a(0);
        return "forDebug";
    }

    private boolean e() {
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

    public f startWork() {
        return androidx.concurrent.futures.c.a(new J4(this));
    }
}
