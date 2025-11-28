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
import u2.X4;
import u2.Y4;
import u2.Z4;
import u2.a5;
import u2.b5;
import u2.c5;
import u2.d5;
import u2.e5;
import u2.f5;

public class WorkerTopic extends c {

    private class a extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private final String f13681a;

        /* renamed from: b  reason: collision with root package name */
        private final String f13682b;

        a(String str, String str2) {
            this.f13681a = str;
            this.f13682b = str2;
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
                java.lang.String r1 = r5.f13681a
                r6.put(r0, r1)
                java.lang.String r0 = "tile"
                java.lang.String r1 = r5.f13682b
                r6.put(r0, r1)
                java.lang.String r6 = u2.C1737L.a(r6)
                r0 = 0
                java.net.URL r1 = new java.net.URL     // Catch:{ IOException -> 0x00a5, all -> 0x009e }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00a5, all -> 0x009e }
                r2.<init>()     // Catch:{ IOException -> 0x00a5, all -> 0x009e }
                com.finazzi.distquake.WorkerTopic r3 = com.finazzi.distquake.WorkerTopic.this     // Catch:{ IOException -> 0x00a5, all -> 0x009e }
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
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.WorkerTopic.a.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
        }
    }

    public interface b {
        void a(int i8);
    }

    public WorkerTopic(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public static /* synthetic */ void b(WorkerTopic workerTopic, SharedPreferences.Editor editor, String str, float[] fArr, Task task) {
        workerTopic.getClass();
        Class<MainActivity> cls = MainActivity.class;
        if (task.isSuccessful()) {
            editor.putString("topic_last_tile_subscribed", str);
            editor.putBoolean("topic_tile_subscribed_successfully", true);
            editor.putFloat("topic_last_latitude_subscribed", fArr[0]);
            editor.putFloat("topic_last_longitude_subscribed", fArr[1]);
            editor.putLong("last_FCM_registered_topic_tile_time", System.currentTimeMillis());
            new a(workerTopic.getApplicationContext().getSharedPreferences(cls.getSimpleName(), 0).getString("android_id_eqn", "0"), str).execute(new Context[]{workerTopic.getApplicationContext()});
        } else {
            editor.putBoolean("topic_tile_subscribed_successfully", false);
            new a(workerTopic.getApplicationContext().getSharedPreferences(cls.getSimpleName(), 0).getString("android_id_eqn", "0"), RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).execute(new Context[]{workerTopic.getApplicationContext()});
        }
        editor.apply();
    }

    public static /* synthetic */ void c(c.a aVar, int i8) {
        if (i8 == 0) {
            aVar.c(c.a.c());
        } else if (i8 == 1) {
            aVar.c(c.a.a());
        } else if (i8 == 2) {
            aVar.c(c.a.b());
        }
    }

    public static /* synthetic */ void d(WorkerTopic workerTopic, SharedPreferences.Editor editor, String str, float[] fArr, Task task) {
        workerTopic.getClass();
        Class<MainActivity> cls = MainActivity.class;
        if (task.isSuccessful()) {
            editor.putString("topic_last_tile_subscribed", str);
            editor.putBoolean("topic_tile_subscribed_successfully", true);
            editor.putFloat("topic_last_latitude_subscribed", fArr[0]);
            editor.putFloat("topic_last_longitude_subscribed", fArr[1]);
            editor.putLong("last_FCM_registered_topic_tile_time", System.currentTimeMillis());
            new a(workerTopic.getApplicationContext().getSharedPreferences(cls.getSimpleName(), 0).getString("android_id_eqn", "0"), str).execute(new Context[]{workerTopic.getApplicationContext()});
        } else {
            editor.putBoolean("topic_tile_subscribed_successfully", false);
            new a(workerTopic.getApplicationContext().getSharedPreferences(cls.getSimpleName(), 0).getString("android_id_eqn", "0"), RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).execute(new Context[]{workerTopic.getApplicationContext()});
        }
        editor.apply();
    }

    public static /* synthetic */ Object e(WorkerTopic workerTopic, c.a aVar) {
        boolean z7;
        boolean z8;
        SharedPreferences.Editor editor;
        WorkerTopic workerTopic2 = workerTopic;
        workerTopic2.getClass();
        Y4 y42 = new Y4(aVar);
        if (workerTopic2.m()) {
            SharedPreferences sharedPreferences = workerTopic2.getApplicationContext().getSharedPreferences("no_backup_pref", 0);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            boolean z9 = sharedPreferences.getBoolean("topic_tile_subscribed_successfully", false);
            boolean z10 = sharedPreferences.getBoolean("topic_tile_unsubscribed_successfully", false);
            long j8 = sharedPreferences.getLong("last_FCM_registered_topic_tile_time", 0);
            long j9 = sharedPreferences.getLong("last_FCM_registered_topic_global_time", 0);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - j8 > 2600000000L) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (currentTimeMillis - j9 > 2600000000L) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z9 || z10) {
                editor = edit;
                if (!z9) {
                    float[] k8 = workerTopic2.k();
                    String l7 = workerTopic2.l((double) k8[0], (double) k8[1]);
                    FirebaseMessaging.p().E(l7).addOnCompleteListener(new c5(workerTopic2, editor, l7, k8));
                } else if (!z10) {
                    String string = sharedPreferences.getString("topic_tile_unsubscribed_unsuccessfully", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                    FirebaseMessaging.p().H(string).addOnCompleteListener(new d5(editor, string));
                } else if (z7) {
                    float[] k9 = workerTopic2.k();
                    String l8 = workerTopic2.l((double) k9[0], (double) k9[1]);
                    FirebaseMessaging.p().E(l8).addOnCompleteListener(new e5(workerTopic2, editor, l8, k9));
                }
            } else {
                float[] k10 = workerTopic2.k();
                editor = edit;
                String l9 = workerTopic2.l((double) k10[0], (double) k10[1]);
                String string2 = sharedPreferences.getString("topic_tile_unsubscribed_unsuccessfully", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                if (!string2.equals(l9)) {
                    FirebaseMessaging.p().E(l9).addOnCompleteListener(new Z4(workerTopic2, editor, l9, k10));
                    FirebaseMessaging.p().H(string2).addOnCompleteListener(new a5(editor, string2));
                } else {
                    editor.putBoolean("topic_tile_unsubscribed_successfully", true);
                    editor.apply();
                    FirebaseMessaging.p().E(l9).addOnCompleteListener(new b5(workerTopic2, editor, l9, k10));
                }
            }
            if (!sharedPreferences.getBoolean("topic_global_subscribed", false) || z8) {
                FirebaseMessaging.p().E("global").addOnCompleteListener(new f5(editor));
            }
            y42.a(0);
            return "forDebug";
        }
        y42.a(1);
        return "forDebug";
    }

    public static /* synthetic */ void f(SharedPreferences.Editor editor, String str, Task task) {
        if (task.isSuccessful()) {
            editor.putBoolean("topic_tile_unsubscribed_successfully", true);
            editor.apply();
            return;
        }
        editor.putBoolean("topic_tile_unsubscribed_successfully", false);
        editor.putString("topic_tile_unsubscribed_unsuccessfully", str);
        editor.apply();
    }

    public static /* synthetic */ void g(WorkerTopic workerTopic, SharedPreferences.Editor editor, String str, float[] fArr, Task task) {
        workerTopic.getClass();
        Class<MainActivity> cls = MainActivity.class;
        if (task.isSuccessful()) {
            editor.putString("topic_last_tile_subscribed", str);
            editor.putBoolean("topic_tile_subscribed_successfully", true);
            editor.putFloat("topic_last_latitude_subscribed", fArr[0]);
            editor.putFloat("topic_last_longitude_subscribed", fArr[1]);
            editor.putLong("last_FCM_registered_topic_tile_time", System.currentTimeMillis());
            new a(workerTopic.getApplicationContext().getSharedPreferences(cls.getSimpleName(), 0).getString("android_id_eqn", "0"), str).execute(new Context[]{workerTopic.getApplicationContext()});
        } else {
            editor.putBoolean("topic_tile_subscribed_successfully", false);
            new a(workerTopic.getApplicationContext().getSharedPreferences(cls.getSimpleName(), 0).getString("android_id_eqn", "0"), RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).execute(new Context[]{workerTopic.getApplicationContext()});
        }
        editor.apply();
    }

    public static /* synthetic */ void h(SharedPreferences.Editor editor, Task task) {
        editor.putBoolean("topic_global_subscribed", task.isSuccessful());
        if (task.isSuccessful()) {
            editor.putLong("last_FCM_registered_topic_global_time", System.currentTimeMillis());
        }
        editor.apply();
    }

    public static /* synthetic */ void i(WorkerTopic workerTopic, SharedPreferences.Editor editor, String str, float[] fArr, Task task) {
        workerTopic.getClass();
        Class<MainActivity> cls = MainActivity.class;
        if (task.isSuccessful()) {
            editor.putString("topic_last_tile_subscribed", str);
            editor.putBoolean("topic_tile_subscribed_successfully", true);
            editor.putFloat("topic_last_latitude_subscribed", fArr[0]);
            editor.putFloat("topic_last_longitude_subscribed", fArr[1]);
            editor.putLong("last_FCM_registered_topic_tile_time", System.currentTimeMillis());
            new a(workerTopic.getApplicationContext().getSharedPreferences(cls.getSimpleName(), 0).getString("android_id_eqn", "0"), str).execute(new Context[]{workerTopic.getApplicationContext()});
        } else {
            editor.putBoolean("topic_tile_subscribed_successfully", false);
            new a(workerTopic.getApplicationContext().getSharedPreferences(cls.getSimpleName(), 0).getString("android_id_eqn", "0"), RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).execute(new Context[]{workerTopic.getApplicationContext()});
        }
        editor.apply();
    }

    public static /* synthetic */ void j(SharedPreferences.Editor editor, String str, Task task) {
        if (task.isSuccessful()) {
            editor.putBoolean("topic_tile_unsubscribed_successfully", true);
            editor.apply();
            return;
        }
        editor.putBoolean("topic_tile_unsubscribed_successfully", false);
        editor.putString("topic_tile_unsubscribed_unsuccessfully", str);
        editor.apply();
    }

    private float[] k() {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(MainActivity.class.getSimpleName(), 0);
        return new float[]{sharedPreferences.getFloat("current_latitude", BitmapDescriptorFactory.HUE_RED), sharedPreferences.getFloat("current_longitude", BitmapDescriptorFactory.HUE_RED), sharedPreferences.getFloat("current_accuracy", -1.0f)};
    }

    private String l(double d8, double d9) {
        return "x" + Integer.toString((int) Math.floor((d9 + 180.0d) / 10.0d)) + "y" + Integer.toString((int) Math.floor((d8 + 90.0d) / 10.0d));
    }

    private boolean m() {
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
        return androidx.concurrent.futures.c.a(new X4(this));
    }
}
