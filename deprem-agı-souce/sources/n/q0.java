package N;

import R.b;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import androidx.work.PeriodicWorkRequest;
import b0.C1007f;
import java.util.HashMap;
import java.util.concurrent.Executor;

final class q0 extends C0714h {
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final HashMap f3135g = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final Context f3136h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public volatile Handler f3137i;

    /* renamed from: j  reason: collision with root package name */
    private final o0 f3138j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final b f3139k;

    /* renamed from: l  reason: collision with root package name */
    private final long f3140l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final long f3141m;

    /* renamed from: n  reason: collision with root package name */
    private volatile Executor f3142n;

    q0(Context context, Looper looper, Executor executor) {
        o0 o0Var = new o0(this, (p0) null);
        this.f3138j = o0Var;
        this.f3136h = context.getApplicationContext();
        this.f3137i = new C1007f(looper, o0Var);
        this.f3139k = b.b();
        this.f3140l = 5000;
        this.f3141m = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
        this.f3142n = executor;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006c, code lost:
        return r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final K.C0655b c(N.m0 r5, android.content.ServiceConnection r6, java.lang.String r7, java.util.concurrent.Executor r8) {
        /*
            r4 = this;
            java.lang.String r0 = "ServiceConnection must not be null"
            N.C0722p.l(r6, r0)
            java.util.HashMap r0 = r4.f3135g
            monitor-enter(r0)
            java.util.HashMap r1 = r4.f3135g     // Catch:{ all -> 0x0015 }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x0015 }
            N.n0 r1 = (N.n0) r1     // Catch:{ all -> 0x0015 }
            if (r8 != 0) goto L_0x0018
            java.util.concurrent.Executor r8 = r4.f3142n     // Catch:{ all -> 0x0015 }
            goto L_0x0018
        L_0x0015:
            r5 = move-exception
            goto L_0x0088
        L_0x0018:
            if (r1 != 0) goto L_0x002c
            N.n0 r1 = new N.n0     // Catch:{ all -> 0x0015 }
            r1.<init>(r4, r5)     // Catch:{ all -> 0x0015 }
            r1.e(r6, r6, r7)     // Catch:{ all -> 0x0015 }
            K.b r6 = N.n0.d(r1, r7, r8)     // Catch:{ all -> 0x0015 }
            java.util.HashMap r7 = r4.f3135g     // Catch:{ all -> 0x0015 }
            r7.put(r5, r1)     // Catch:{ all -> 0x0015 }
            goto L_0x0059
        L_0x002c:
            android.os.Handler r2 = r4.f3137i     // Catch:{ all -> 0x0015 }
            r3 = 0
            r2.removeMessages(r3, r5)     // Catch:{ all -> 0x0015 }
            boolean r2 = r1.h(r6)     // Catch:{ all -> 0x0015 }
            if (r2 != 0) goto L_0x006d
            r1.e(r6, r6, r7)     // Catch:{ all -> 0x0015 }
            int r5 = r1.a()     // Catch:{ all -> 0x0015 }
            r2 = 1
            r3 = 0
            if (r5 == r2) goto L_0x004d
            r6 = 2
            if (r5 == r6) goto L_0x0048
        L_0x0046:
            r6 = r3
            goto L_0x0059
        L_0x0048:
            K.b r6 = N.n0.d(r1, r7, r8)     // Catch:{ all -> 0x0015 }
            goto L_0x0059
        L_0x004d:
            android.content.ComponentName r5 = r1.b()     // Catch:{ all -> 0x0015 }
            android.os.IBinder r7 = r1.c()     // Catch:{ all -> 0x0015 }
            r6.onServiceConnected(r5, r7)     // Catch:{ all -> 0x0015 }
            goto L_0x0046
        L_0x0059:
            boolean r5 = r1.j()     // Catch:{ all -> 0x0015 }
            if (r5 == 0) goto L_0x0063
            K.b r5 = K.C0655b.f2701e     // Catch:{ all -> 0x0015 }
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            return r5
        L_0x0063:
            if (r6 != 0) goto L_0x006b
            K.b r6 = new K.b     // Catch:{ all -> 0x0015 }
            r5 = -1
            r6.<init>(r5)     // Catch:{ all -> 0x0015 }
        L_0x006b:
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            return r6
        L_0x006d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0015 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0015 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0015 }
            r7.<init>()     // Catch:{ all -> 0x0015 }
            java.lang.String r8 = "Trying to bind a GmsServiceConnection that was already connected before.  config="
            r7.append(r8)     // Catch:{ all -> 0x0015 }
            r7.append(r5)     // Catch:{ all -> 0x0015 }
            java.lang.String r5 = r7.toString()     // Catch:{ all -> 0x0015 }
            r6.<init>(r5)     // Catch:{ all -> 0x0015 }
            throw r6     // Catch:{ all -> 0x0015 }
        L_0x0088:
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: N.q0.c(N.m0, android.content.ServiceConnection, java.lang.String, java.util.concurrent.Executor):K.b");
    }

    /* access modifiers changed from: protected */
    public final void d(m0 m0Var, ServiceConnection serviceConnection, String str) {
        C0722p.l(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f3135g) {
            try {
                n0 n0Var = (n0) this.f3135g.get(m0Var);
                if (n0Var == null) {
                    String obj = m0Var.toString();
                    throw new IllegalStateException("Nonexistent connection status for service config: " + obj);
                } else if (n0Var.h(serviceConnection)) {
                    n0Var.f(serviceConnection, str);
                    if (n0Var.i()) {
                        this.f3137i.sendMessageDelayed(this.f3137i.obtainMessage(0, m0Var), this.f3140l);
                    }
                } else {
                    String obj2 = m0Var.toString();
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + obj2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
