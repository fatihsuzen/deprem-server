package com.google.firebase.messaging;

import R.b;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import k0.C1698l;
import k0.C1699m;

class n0 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private final Context f7460a;

    /* renamed from: b  reason: collision with root package name */
    private final Intent f7461b;

    /* renamed from: c  reason: collision with root package name */
    private final ScheduledExecutorService f7462c;

    /* renamed from: d  reason: collision with root package name */
    private final Queue f7463d;

    /* renamed from: e  reason: collision with root package name */
    private k0 f7464e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f7465f;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final Intent f7466a;

        /* renamed from: b  reason: collision with root package name */
        private final C1699m f7467b = new C1699m();

        a(Intent intent) {
            this.f7466a = intent;
        }

        public static /* synthetic */ void b(a aVar) {
            aVar.getClass();
            Log.w("FirebaseMessaging", "Service took too long to process intent: " + aVar.f7466a.getAction() + " finishing.");
            aVar.d();
        }

        /* access modifiers changed from: package-private */
        public void c(ScheduledExecutorService scheduledExecutorService) {
            e().b(scheduledExecutorService, new m0(scheduledExecutorService.schedule(new l0(this), 20, TimeUnit.SECONDS)));
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.f7467b.e((Object) null);
        }

        /* access modifiers changed from: package-private */
        public C1698l e() {
            return this.f7467b.a();
        }
    }

    n0(Context context, String str) {
        this(context, str, a());
    }

    private static ScheduledThreadPoolExecutor a() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new S.a("Firebase-FirebaseInstanceIdServiceConnection"));
        scheduledThreadPoolExecutor.setKeepAliveTime(40, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        return scheduledThreadPoolExecutor;
    }

    private void b() {
        while (!this.f7463d.isEmpty()) {
            ((a) this.f7463d.poll()).d();
        }
    }

    private synchronized void c() {
        try {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "flush queue called");
            }
            while (!this.f7463d.isEmpty()) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "found intent to be delivered");
                }
                k0 k0Var = this.f7464e;
                if (k0Var == null || !k0Var.isBinderAlive()) {
                    e();
                    return;
                }
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "binder is alive, sending the intent.");
                }
                this.f7464e.b((a) this.f7463d.poll());
            }
        } finally {
            while (true) {
            }
        }
    }

    private void e() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("binder is dead. start connection? ");
            sb.append(!this.f7465f);
            Log.d("FirebaseMessaging", sb.toString());
        }
        if (!this.f7465f) {
            this.f7465f = true;
            try {
                if (!b.b().a(this.f7460a, this.f7461b, this, 65)) {
                    Log.e("FirebaseMessaging", "binding to the service failed");
                    this.f7465f = false;
                    b();
                }
            } catch (SecurityException e5) {
                Log.e("FirebaseMessaging", "Exception while binding the service", e5);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized C1698l d(Intent intent) {
        a aVar;
        try {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "new intent queued in the bind-strategy delivery");
            }
            aVar = new a(intent);
            aVar.c(this.f7462c);
            this.f7463d.add(aVar);
            c();
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return aVar.e();
    }

    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "onServiceConnected: " + componentName);
            }
            this.f7465f = false;
            if (!(iBinder instanceof k0)) {
                Log.e("FirebaseMessaging", "Invalid service connection: " + iBinder);
                b();
                return;
            }
            this.f7464e = (k0) iBinder;
            c();
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "onServiceDisconnected: " + componentName);
        }
        c();
    }

    n0(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.f7463d = new ArrayDeque();
        this.f7465f = false;
        Context applicationContext = context.getApplicationContext();
        this.f7460a = applicationContext;
        this.f7461b = new Intent(str).setPackage(applicationContext.getPackageName());
        this.f7462c = scheduledExecutorService;
    }
}
