package com.google.firebase.messaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import java.io.IOException;

class g0 implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    private static final Object f7424f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private static Boolean f7425g;

    /* renamed from: h  reason: collision with root package name */
    private static Boolean f7426h;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f7427a;

    /* renamed from: b  reason: collision with root package name */
    private final I f7428b;

    /* renamed from: c  reason: collision with root package name */
    private final PowerManager.WakeLock f7429c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final f0 f7430d;

    /* renamed from: e  reason: collision with root package name */
    private final long f7431e;

    class a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private g0 f7432a;

        public a(g0 g0Var) {
            this.f7432a = g0Var;
        }

        public void a() {
            if (g0.j()) {
                Log.d("FirebaseMessaging", "Connectivity change received registered");
            }
            g0.this.f7427a.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }

        public synchronized void onReceive(Context context, Intent intent) {
            try {
                g0 g0Var = this.f7432a;
                if (g0Var != null) {
                    if (g0Var.i()) {
                        if (g0.j()) {
                            Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
                        }
                        this.f7432a.f7430d.k(this.f7432a, 0);
                        context.unregisterReceiver(this);
                        this.f7432a = null;
                    }
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    g0(f0 f0Var, Context context, I i5, long j5) {
        this.f7430d = f0Var;
        this.f7427a = context;
        this.f7431e = j5;
        this.f7428b = i5;
        this.f7429c = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:com.google.firebase.messaging");
    }

    private static String e(String str) {
        return "Missing Permission: " + str + ". This permission should normally be included by the manifest merger, but may needed to be manually added to your manifest";
    }

    private static boolean f(Context context) {
        boolean z4;
        boolean booleanValue;
        synchronized (f7424f) {
            try {
                Boolean bool = f7426h;
                if (bool == null) {
                    z4 = g(context, "android.permission.ACCESS_NETWORK_STATE", bool);
                } else {
                    z4 = bool.booleanValue();
                }
                Boolean valueOf = Boolean.valueOf(z4);
                f7426h = valueOf;
                booleanValue = valueOf.booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return booleanValue;
    }

    private static boolean g(Context context, String str, Boolean bool) {
        boolean z4;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (context.checkCallingOrSelfPermission(str) == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z4 && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", e(str));
        }
        return z4;
    }

    private static boolean h(Context context) {
        boolean z4;
        boolean booleanValue;
        synchronized (f7424f) {
            try {
                Boolean bool = f7425g;
                if (bool == null) {
                    z4 = g(context, "android.permission.WAKE_LOCK", bool);
                } else {
                    z4 = bool.booleanValue();
                }
                Boolean valueOf = Boolean.valueOf(z4);
                f7425g = valueOf;
                booleanValue = valueOf.booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return booleanValue;
    }

    /* access modifiers changed from: private */
    public synchronized boolean i() {
        NetworkInfo networkInfo;
        boolean z4;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f7427a.getSystemService("connectivity");
            if (connectivityManager != null) {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } else {
                networkInfo = null;
            }
            if (networkInfo == null || !networkInfo.isConnected()) {
                z4 = false;
            } else {
                z4 = true;
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return z4;
    }

    /* access modifiers changed from: private */
    public static boolean j() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            return true;
        }
        if (Build.VERSION.SDK_INT != 23 || !Log.isLoggable("FirebaseMessaging", 3)) {
            return false;
        }
        return true;
    }

    public void run() {
        if (h(this.f7427a)) {
            this.f7429c.acquire(C1556e.f7404a);
        }
        try {
            this.f7430d.l(true);
            if (!this.f7428b.g()) {
                this.f7430d.l(false);
                if (h(this.f7427a)) {
                    try {
                        this.f7429c.release();
                    } catch (RuntimeException unused) {
                        Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                    }
                }
            } else if (!f(this.f7427a) || i()) {
                if (this.f7430d.o()) {
                    this.f7430d.l(false);
                } else {
                    this.f7430d.p(this.f7431e);
                }
                if (h(this.f7427a)) {
                    try {
                        this.f7429c.release();
                    } catch (RuntimeException unused2) {
                        Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                    }
                }
            } else {
                new a(this).a();
                if (h(this.f7427a)) {
                    try {
                        this.f7429c.release();
                    } catch (RuntimeException unused3) {
                        Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                    }
                }
            }
        } catch (IOException e5) {
            Log.e("FirebaseMessaging", "Failed to sync topics. Won't retry sync. " + e5.getMessage());
            this.f7430d.l(false);
            if (h(this.f7427a)) {
                this.f7429c.release();
            }
        } catch (Throwable th) {
            if (h(this.f7427a)) {
                try {
                    this.f7429c.release();
                } catch (RuntimeException unused4) {
                    Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                }
            }
            throw th;
        }
    }
}
