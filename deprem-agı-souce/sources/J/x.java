package J;

import N.C0722p;
import R.b;
import a0.C1000f;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.util.Log;
import android.util.SparseArray;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

final class x implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    int f2656a = 0;

    /* renamed from: b  reason: collision with root package name */
    final Messenger f2657b = new Messenger(new C1000f(Looper.getMainLooper(), new u(this)));

    /* renamed from: c  reason: collision with root package name */
    y f2658c;

    /* renamed from: d  reason: collision with root package name */
    final Queue f2659d = new ArrayDeque();

    /* renamed from: e  reason: collision with root package name */
    final SparseArray f2660e = new SparseArray();

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ D f2661f;

    /* synthetic */ x(D d5, w wVar) {
        this.f2661f = d5;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(int i5, String str) {
        b(i5, str, (Throwable) null);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void b(int i5, String str, Throwable th) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                Log.d("MessengerIpcClient", "Disconnected: ".concat(String.valueOf(str)));
            }
            int i6 = this.f2656a;
            if (i6 == 0) {
                throw new IllegalStateException();
            } else if (i6 == 1 || i6 == 2) {
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Unbinding service");
                }
                this.f2656a = 4;
                b.b().c(this.f2661f.f2605a, this);
                B b5 = new B(i5, str, th);
                for (C0644A c5 : this.f2659d) {
                    c5.c(b5);
                }
                this.f2659d.clear();
                for (int i7 = 0; i7 < this.f2660e.size(); i7++) {
                    ((C0644A) this.f2660e.valueAt(i7)).c(b5);
                }
                this.f2660e.clear();
            } else if (i6 == 3) {
                this.f2656a = 4;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        this.f2661f.f2606b.execute(new r(this));
    }

    /* access modifiers changed from: package-private */
    public final synchronized void d() {
        if (this.f2656a == 1) {
            a(1, "Timed out while binding");
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void e(int i5) {
        C0644A a5 = (C0644A) this.f2660e.get(i5);
        if (a5 != null) {
            Log.w("MessengerIpcClient", "Timing out request: " + i5);
            this.f2660e.remove(i5);
            a5.c(new B(3, "Timed out waiting for response", (Throwable) null));
            f();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void f() {
        /*
            r2 = this;
            monitor-enter(r2)
            int r0 = r2.f2656a     // Catch:{ all -> 0x0026 }
            r1 = 2
            if (r0 != r1) goto L_0x003a
            java.util.Queue r0 = r2.f2659d     // Catch:{ all -> 0x0026 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x003a
            android.util.SparseArray r0 = r2.f2660e     // Catch:{ all -> 0x0026 }
            int r0 = r0.size()     // Catch:{ all -> 0x0026 }
            if (r0 != 0) goto L_0x003a
            java.lang.String r0 = "MessengerIpcClient"
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x0028
            java.lang.String r0 = "MessengerIpcClient"
            java.lang.String r1 = "Finished handling requests, unbinding"
            android.util.Log.v(r0, r1)     // Catch:{ all -> 0x0026 }
            goto L_0x0028
        L_0x0026:
            r0 = move-exception
            goto L_0x003c
        L_0x0028:
            r0 = 3
            r2.f2656a = r0     // Catch:{ all -> 0x0026 }
            J.D r0 = r2.f2661f     // Catch:{ all -> 0x0026 }
            R.b r1 = R.b.b()     // Catch:{ all -> 0x0026 }
            android.content.Context r0 = r0.f2605a     // Catch:{ all -> 0x0026 }
            r1.c(r0, r2)     // Catch:{ all -> 0x0026 }
            monitor-exit(r2)
            return
        L_0x003a:
            monitor-exit(r2)
            return
        L_0x003c:
            monitor-exit(r2)     // Catch:{ all -> 0x0026 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: J.x.f():void");
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean g(C0644A a5) {
        boolean z4;
        int i5 = this.f2656a;
        if (i5 == 0) {
            this.f2659d.add(a5);
            if (this.f2656a == 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            C0722p.n(z4);
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Starting bind to GmsCore");
            }
            this.f2656a = 1;
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            try {
                if (!b.b().a(this.f2661f.f2605a, intent, this, 1)) {
                    a(0, "Unable to bind to service");
                } else {
                    this.f2661f.f2606b.schedule(new s(this), 30, TimeUnit.SECONDS);
                }
            } catch (SecurityException e5) {
                b(0, "Unable to bind to service", e5);
            }
        } else if (i5 == 1) {
            this.f2659d.add(a5);
            return true;
        } else if (i5 != 2) {
            return false;
        } else {
            this.f2659d.add(a5);
            c();
            return true;
        }
        return true;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        this.f2661f.f2606b.execute(new q(this, iBinder));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        this.f2661f.f2606b.execute(new t(this));
    }
}
