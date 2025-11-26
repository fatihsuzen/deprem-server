package N;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.HashMap;
import java.util.Map;

final class n0 implements ServiceConnection, r0 {

    /* renamed from: a  reason: collision with root package name */
    private final Map f3123a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private int f3124b = 2;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3125c;

    /* renamed from: d  reason: collision with root package name */
    private IBinder f3126d;

    /* renamed from: e  reason: collision with root package name */
    private final m0 f3127e;

    /* renamed from: f  reason: collision with root package name */
    private ComponentName f3128f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ q0 f3129g;

    public n0(q0 q0Var, m0 m0Var) {
        this.f3129g = q0Var;
        this.f3127e = m0Var;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:11|12|13|14|15|16|17|18|24) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x005f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* bridge */ /* synthetic */ K.C0655b d(N.n0 r9, java.lang.String r10, java.util.concurrent.Executor r11) {
        /*
            N.m0 r0 = r9.f3127e     // Catch:{ a0 -> 0x006e }
            N.q0 r1 = r9.f3129g     // Catch:{ a0 -> 0x006e }
            android.content.Context r1 = r1.f3136h     // Catch:{ a0 -> 0x006e }
            android.content.Intent r5 = r0.b(r1)     // Catch:{ a0 -> 0x006e }
            r0 = 3
            r9.f3124b = r0
            android.os.StrictMode$VmPolicy r1 = com.google.android.gms.common.util.u.a()
            N.q0 r0 = r9.f3129g     // Catch:{ all -> 0x004c }
            R.b r2 = r0.f3139k     // Catch:{ all -> 0x004c }
            android.content.Context r3 = r0.f3136h     // Catch:{ all -> 0x004c }
            r7 = 4225(0x1081, float:5.92E-42)
            r6 = r9
            r4 = r10
            r8 = r11
            boolean r9 = r2.d(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x004c }
            r6.f3125c = r9     // Catch:{ all -> 0x004c }
            if (r9 == 0) goto L_0x004f
            N.q0 r9 = r6.f3129g     // Catch:{ all -> 0x004c }
            android.os.Handler r9 = r9.f3137i     // Catch:{ all -> 0x004c }
            N.m0 r10 = r6.f3127e     // Catch:{ all -> 0x004c }
            r11 = 1
            android.os.Message r9 = r9.obtainMessage(r11, r10)     // Catch:{ all -> 0x004c }
            N.q0 r10 = r6.f3129g     // Catch:{ all -> 0x004c }
            android.os.Handler r10 = r10.f3137i     // Catch:{ all -> 0x004c }
            N.q0 r11 = r6.f3129g     // Catch:{ all -> 0x004c }
            long r2 = r11.f3141m     // Catch:{ all -> 0x004c }
            r10.sendMessageDelayed(r9, r2)     // Catch:{ all -> 0x004c }
            K.b r9 = K.C0655b.f2701e     // Catch:{ all -> 0x004c }
            android.os.StrictMode.setVmPolicy(r1)
            return r9
        L_0x004c:
            r0 = move-exception
            r9 = r0
            goto L_0x006a
        L_0x004f:
            r9 = 2
            r6.f3124b = r9     // Catch:{ all -> 0x004c }
            N.q0 r9 = r6.f3129g     // Catch:{ IllegalArgumentException -> 0x005f }
            R.b r10 = r9.f3139k     // Catch:{ IllegalArgumentException -> 0x005f }
            android.content.Context r9 = r9.f3136h     // Catch:{ IllegalArgumentException -> 0x005f }
            r10.c(r9, r6)     // Catch:{ IllegalArgumentException -> 0x005f }
        L_0x005f:
            K.b r9 = new K.b     // Catch:{ all -> 0x004c }
            r10 = 16
            r9.<init>(r10)     // Catch:{ all -> 0x004c }
            android.os.StrictMode.setVmPolicy(r1)
            goto L_0x0072
        L_0x006a:
            android.os.StrictMode.setVmPolicy(r1)
            throw r9
        L_0x006e:
            r0 = move-exception
            r9 = r0
            K.b r9 = r9.f3010a
        L_0x0072:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: N.n0.d(N.n0, java.lang.String, java.util.concurrent.Executor):K.b");
    }

    public final int a() {
        return this.f3124b;
    }

    public final ComponentName b() {
        return this.f3128f;
    }

    public final IBinder c() {
        return this.f3126d;
    }

    public final void e(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.f3123a.put(serviceConnection, serviceConnection2);
    }

    public final void f(ServiceConnection serviceConnection, String str) {
        this.f3123a.remove(serviceConnection);
    }

    public final void g(String str) {
        this.f3129g.f3137i.removeMessages(1, this.f3127e);
        q0 q0Var = this.f3129g;
        q0Var.f3139k.c(q0Var.f3136h, this);
        this.f3125c = false;
        this.f3124b = 2;
    }

    public final boolean h(ServiceConnection serviceConnection) {
        return this.f3123a.containsKey(serviceConnection);
    }

    public final boolean i() {
        return this.f3123a.isEmpty();
    }

    public final boolean j() {
        return this.f3125c;
    }

    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f3129g.f3135g) {
            try {
                this.f3129g.f3137i.removeMessages(1, this.f3127e);
                this.f3126d = iBinder;
                this.f3128f = componentName;
                for (ServiceConnection onServiceConnected : this.f3123a.values()) {
                    onServiceConnected.onServiceConnected(componentName, iBinder);
                }
                this.f3124b = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f3129g.f3135g) {
            try {
                this.f3129g.f3137i.removeMessages(1, this.f3127e);
                this.f3126d = null;
                this.f3128f = componentName;
                for (ServiceConnection onServiceDisconnected : this.f3123a.values()) {
                    onServiceDisconnected.onServiceDisconnected(componentName);
                }
                this.f3124b = 2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
