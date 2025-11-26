package j0;

import N.C0722p;
import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.support.v4.media.a;
import android.text.TextUtils;
import android.util.Log;
import c0.C1042b;
import c0.C1043c;
import c0.h;
import c0.i;
import com.google.android.gms.common.util.d;
import com.google.android.gms.common.util.g;
import com.google.android.gms.common.util.o;
import com.google.android.gms.common.util.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: j0.a  reason: case insensitive filesystem */
public class C1678a {

    /* renamed from: r  reason: collision with root package name */
    private static final long f15387r = TimeUnit.DAYS.toMillis(366);

    /* renamed from: s  reason: collision with root package name */
    private static volatile ScheduledExecutorService f15388s = null;

    /* renamed from: t  reason: collision with root package name */
    private static final Object f15389t = new Object();

    /* renamed from: u  reason: collision with root package name */
    private static volatile e f15390u = new c();

    /* renamed from: a  reason: collision with root package name */
    private final Object f15391a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final PowerManager.WakeLock f15392b;

    /* renamed from: c  reason: collision with root package name */
    private int f15393c = 0;

    /* renamed from: d  reason: collision with root package name */
    private Future f15394d;

    /* renamed from: e  reason: collision with root package name */
    private long f15395e;

    /* renamed from: f  reason: collision with root package name */
    private final Set f15396f = new HashSet();

    /* renamed from: g  reason: collision with root package name */
    private boolean f15397g = true;

    /* renamed from: h  reason: collision with root package name */
    private int f15398h;

    /* renamed from: i  reason: collision with root package name */
    C1042b f15399i;

    /* renamed from: j  reason: collision with root package name */
    private d f15400j = g.b();

    /* renamed from: k  reason: collision with root package name */
    private WorkSource f15401k;

    /* renamed from: l  reason: collision with root package name */
    private final String f15402l;

    /* renamed from: m  reason: collision with root package name */
    private final String f15403m;

    /* renamed from: n  reason: collision with root package name */
    private final Context f15404n;

    /* renamed from: o  reason: collision with root package name */
    private final Map f15405o = new HashMap();

    /* renamed from: p  reason: collision with root package name */
    private AtomicInteger f15406p = new AtomicInteger(0);

    /* renamed from: q  reason: collision with root package name */
    private final ScheduledExecutorService f15407q;

    public C1678a(Context context, int i5, String str) {
        String str2;
        String packageName = context.getPackageName();
        C0722p.l(context, "WakeLock: context must not be null");
        C0722p.f(str, "WakeLock: wakeLockName must not be empty");
        this.f15404n = context.getApplicationContext();
        this.f15403m = str;
        this.f15399i = null;
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str2 = "*gcore*:".concat(valueOf);
            } else {
                str2 = new String("*gcore*:");
            }
            this.f15402l = str2;
        } else {
            this.f15402l = str;
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager != null) {
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(i5, str);
            this.f15392b = newWakeLock;
            if (q.c(context)) {
                WorkSource b5 = q.b(context, o.a(packageName) ? context.getPackageName() : packageName);
                this.f15401k = b5;
                if (b5 != null) {
                    i(newWakeLock, b5);
                }
            }
            ScheduledExecutorService scheduledExecutorService = f15388s;
            if (scheduledExecutorService == null) {
                synchronized (f15389t) {
                    try {
                        scheduledExecutorService = f15388s;
                        if (scheduledExecutorService == null) {
                            h.a();
                            scheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
                            f15388s = scheduledExecutorService;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            this.f15407q = scheduledExecutorService;
            return;
        }
        StringBuilder sb = new StringBuilder(29);
        sb.append("expected a non-null reference", 0, 29);
        throw new i(sb.toString());
    }

    public static /* synthetic */ void e(C1678a aVar) {
        synchronized (aVar.f15391a) {
            try {
                if (aVar.b()) {
                    Log.e("WakeLock", String.valueOf(aVar.f15402l).concat(" ** IS FORCE-RELEASED ON TIMEOUT **"));
                    aVar.g();
                    if (aVar.b()) {
                        aVar.f15393c = 1;
                        aVar.h(0);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final String f(String str) {
        if (this.f15397g) {
            TextUtils.isEmpty((CharSequence) null);
        }
        return null;
    }

    private final void g() {
        if (!this.f15396f.isEmpty()) {
            ArrayList arrayList = new ArrayList(this.f15396f);
            this.f15396f.clear();
            if (arrayList.size() > 0) {
                a.a(arrayList.get(0));
                throw null;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00a6, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void h(int r6) {
        /*
            r5 = this;
            java.lang.Object r6 = r5.f15391a
            monitor-enter(r6)
            boolean r0 = r5.b()     // Catch:{ all -> 0x000b }
            if (r0 != 0) goto L_0x000e
            monitor-exit(r6)     // Catch:{ all -> 0x000b }
            return
        L_0x000b:
            r0 = move-exception
            goto L_0x00a7
        L_0x000e:
            boolean r0 = r5.f15397g     // Catch:{ all -> 0x000b }
            r1 = 0
            if (r0 == 0) goto L_0x001e
            int r0 = r5.f15393c     // Catch:{ all -> 0x000b }
            int r0 = r0 + -1
            r5.f15393c = r0     // Catch:{ all -> 0x000b }
            if (r0 > 0) goto L_0x001c
            goto L_0x0020
        L_0x001c:
            monitor-exit(r6)     // Catch:{ all -> 0x000b }
            return
        L_0x001e:
            r5.f15393c = r1     // Catch:{ all -> 0x000b }
        L_0x0020:
            r5.g()     // Catch:{ all -> 0x000b }
            java.util.Map r0 = r5.f15405o     // Catch:{ all -> 0x000b }
            java.util.Collection r0 = r0.values()     // Catch:{ all -> 0x000b }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x000b }
        L_0x002d:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x000b }
            if (r2 == 0) goto L_0x003c
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x000b }
            j0.d r2 = (j0.d) r2     // Catch:{ all -> 0x000b }
            r2.f15409a = r1     // Catch:{ all -> 0x000b }
            goto L_0x002d
        L_0x003c:
            java.util.Map r0 = r5.f15405o     // Catch:{ all -> 0x000b }
            r0.clear()     // Catch:{ all -> 0x000b }
            java.util.concurrent.Future r0 = r5.f15394d     // Catch:{ all -> 0x000b }
            r2 = 0
            if (r0 == 0) goto L_0x004f
            r0.cancel(r1)     // Catch:{ all -> 0x000b }
            r5.f15394d = r2     // Catch:{ all -> 0x000b }
            r3 = 0
            r5.f15395e = r3     // Catch:{ all -> 0x000b }
        L_0x004f:
            r5.f15398h = r1     // Catch:{ all -> 0x000b }
            android.os.PowerManager$WakeLock r0 = r5.f15392b     // Catch:{ all -> 0x000b }
            boolean r0 = r0.isHeld()     // Catch:{ all -> 0x000b }
            if (r0 == 0) goto L_0x0094
            android.os.PowerManager$WakeLock r0 = r5.f15392b     // Catch:{ RuntimeException -> 0x0067 }
            r0.release()     // Catch:{ RuntimeException -> 0x0067 }
            c0.b r0 = r5.f15399i     // Catch:{ all -> 0x000b }
            if (r0 == 0) goto L_0x00a5
            r5.f15399i = r2     // Catch:{ all -> 0x000b }
            goto L_0x00a5
        L_0x0065:
            r0 = move-exception
            goto L_0x008d
        L_0x0067:
            r0 = move-exception
            java.lang.Class r1 = r0.getClass()     // Catch:{ all -> 0x0065 }
            java.lang.Class<java.lang.RuntimeException> r3 = java.lang.RuntimeException.class
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x008c
            java.lang.String r1 = "WakeLock"
            java.lang.String r3 = r5.f15402l     // Catch:{ all -> 0x0065 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0065 }
            java.lang.String r4 = " failed to release!"
            java.lang.String r3 = r3.concat(r4)     // Catch:{ all -> 0x0065 }
            android.util.Log.e(r1, r3, r0)     // Catch:{ all -> 0x0065 }
            c0.b r0 = r5.f15399i     // Catch:{ all -> 0x000b }
            if (r0 == 0) goto L_0x00a5
            r5.f15399i = r2     // Catch:{ all -> 0x000b }
            goto L_0x00a5
        L_0x008c:
            throw r0     // Catch:{ all -> 0x0065 }
        L_0x008d:
            c0.b r1 = r5.f15399i     // Catch:{ all -> 0x000b }
            if (r1 == 0) goto L_0x0093
            r5.f15399i = r2     // Catch:{ all -> 0x000b }
        L_0x0093:
            throw r0     // Catch:{ all -> 0x000b }
        L_0x0094:
            java.lang.String r0 = "WakeLock"
            java.lang.String r1 = r5.f15402l     // Catch:{ all -> 0x000b }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x000b }
            java.lang.String r2 = " should be held!"
            java.lang.String r1 = r1.concat(r2)     // Catch:{ all -> 0x000b }
            android.util.Log.e(r0, r1)     // Catch:{ all -> 0x000b }
        L_0x00a5:
            monitor-exit(r6)     // Catch:{ all -> 0x000b }
            return
        L_0x00a7:
            monitor-exit(r6)     // Catch:{ all -> 0x000b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.C1678a.h(int):void");
    }

    private static void i(PowerManager.WakeLock wakeLock, WorkSource workSource) {
        try {
            wakeLock.setWorkSource(workSource);
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e5) {
            Log.wtf("WakeLock", e5.toString());
        }
    }

    public void a(long j5) {
        this.f15406p.incrementAndGet();
        long j6 = Long.MAX_VALUE;
        long max = Math.max(Math.min(Long.MAX_VALUE, f15387r), 1);
        if (j5 > 0) {
            max = Math.min(j5, max);
        }
        synchronized (this.f15391a) {
            try {
                if (!b()) {
                    this.f15399i = C1042b.a(false, (C1043c) null);
                    this.f15392b.acquire();
                    this.f15400j.elapsedRealtime();
                }
                this.f15393c++;
                this.f15398h++;
                f((String) null);
                d dVar = (d) this.f15405o.get((Object) null);
                if (dVar == null) {
                    dVar = new d((c) null);
                    this.f15405o.put((Object) null, dVar);
                }
                dVar.f15409a++;
                long elapsedRealtime = this.f15400j.elapsedRealtime();
                if (Long.MAX_VALUE - elapsedRealtime > max) {
                    j6 = elapsedRealtime + max;
                }
                if (j6 > this.f15395e) {
                    this.f15395e = j6;
                    Future future = this.f15394d;
                    if (future != null) {
                        future.cancel(false);
                    }
                    this.f15394d = this.f15407q.schedule(new b(this), max, TimeUnit.MILLISECONDS);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean b() {
        boolean z4;
        synchronized (this.f15391a) {
            if (this.f15393c > 0) {
                z4 = true;
            } else {
                z4 = false;
            }
        }
        return z4;
    }

    public void c() {
        if (this.f15406p.decrementAndGet() < 0) {
            Log.e("WakeLock", String.valueOf(this.f15402l).concat(" release without a matched acquire!"));
        }
        synchronized (this.f15391a) {
            try {
                f((String) null);
                if (this.f15405o.containsKey((Object) null)) {
                    d dVar = (d) this.f15405o.get((Object) null);
                    if (dVar != null) {
                        int i5 = dVar.f15409a - 1;
                        dVar.f15409a = i5;
                        if (i5 == 0) {
                            this.f15405o.remove((Object) null);
                        }
                    }
                } else {
                    Log.w("WakeLock", String.valueOf(this.f15402l).concat(" counter does not exist"));
                }
                h(0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void d(boolean z4) {
        synchronized (this.f15391a) {
            this.f15397g = z4;
        }
    }
}
