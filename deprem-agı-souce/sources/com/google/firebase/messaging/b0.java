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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class b0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final long f7386a;

    /* renamed from: b  reason: collision with root package name */
    private final PowerManager.WakeLock f7387b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final FirebaseMessaging f7388c;

    /* renamed from: d  reason: collision with root package name */
    ExecutorService f7389d = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new S.a("firebase-iid-executor"));

    static class a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private b0 f7390a;

        /* renamed from: b  reason: collision with root package name */
        private Context f7391b;

        public a(b0 b0Var) {
            this.f7390a = b0Var;
        }

        public void a() {
            if (b0.c()) {
                Log.d("FirebaseMessaging", "Connectivity change received registered");
            }
            IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
            b0 b0Var = this.f7390a;
            if (b0Var != null) {
                Context b5 = b0Var.b();
                this.f7391b = b5;
                b5.registerReceiver(this, intentFilter);
            }
        }

        public void onReceive(Context context, Intent intent) {
            b0 b0Var = this.f7390a;
            if (b0Var != null && b0Var.d()) {
                if (b0.c()) {
                    Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
                }
                this.f7390a.f7388c.l(this.f7390a, 0);
                Context context2 = this.f7391b;
                if (context2 != null) {
                    context2.unregisterReceiver(this);
                }
                this.f7390a = null;
            }
        }
    }

    public b0(FirebaseMessaging firebaseMessaging, long j5) {
        this.f7388c = firebaseMessaging;
        this.f7386a = j5;
        PowerManager.WakeLock newWakeLock = ((PowerManager) b().getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.f7387b = newWakeLock;
        newWakeLock.setReferenceCounted(false);
    }

    static boolean c() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            return true;
        }
        if (Build.VERSION.SDK_INT != 23 || !Log.isLoggable("FirebaseMessaging", 3)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public Context b() {
        return this.f7388c.m();
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) b().getSystemService("connectivity");
        if (connectivityManager != null) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } else {
            networkInfo = null;
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        try {
            if (this.f7388c.k() == null) {
                Log.e("FirebaseMessaging", "Token retrieval failed: null");
                return false;
            } else if (!Log.isLoggable("FirebaseMessaging", 3)) {
                return true;
            } else {
                Log.d("FirebaseMessaging", "Token successfully retrieved");
                return true;
            }
        } catch (IOException e5) {
            if (D.h(e5.getMessage())) {
                Log.w("FirebaseMessaging", "Token retrieval failed: " + e5.getMessage() + ". Will retry token retrieval");
                return false;
            } else if (e5.getMessage() == null) {
                Log.w("FirebaseMessaging", "Token retrieval failed without exception message. Will retry token retrieval");
                return false;
            } else {
                throw e5;
            }
        } catch (SecurityException unused) {
            Log.w("FirebaseMessaging", "Token retrieval failed with SecurityException. Will retry token retrieval");
            return false;
        }
    }

    public void run() {
        if (X.b().e(b())) {
            this.f7387b.acquire();
        }
        try {
            this.f7388c.y(true);
            if (!this.f7388c.x()) {
                this.f7388c.y(false);
                if (!X.b().e(b())) {
                    return;
                }
            } else if (!X.b().d(b()) || d()) {
                if (e()) {
                    this.f7388c.y(false);
                } else {
                    this.f7388c.C(this.f7386a);
                }
                if (!X.b().e(b())) {
                    return;
                }
            } else {
                new a(this).a();
                if (!X.b().e(b())) {
                    return;
                }
            }
            this.f7387b.release();
        } catch (IOException e5) {
            Log.e("FirebaseMessaging", "Topic sync or token retrieval failed on hard failure exceptions: " + e5.getMessage() + ". Won't retry the operation.");
            this.f7388c.y(false);
            if (X.b().e(b())) {
                this.f7387b.release();
            }
        } catch (Throwable th) {
            if (X.b().e(b())) {
                this.f7387b.release();
            }
            throw th;
        }
    }
}
