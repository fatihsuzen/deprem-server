package D;

import K.C0654a;
import K.C0661h;
import K.C0662i;
import K.C0665l;
import N.C0722p;
import R.b;
import W.e;
import W.f;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import androidx.work.WorkRequest;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* renamed from: D.a  reason: case insensitive filesystem */
public class C0635a {

    /* renamed from: a  reason: collision with root package name */
    C0654a f2341a;

    /* renamed from: b  reason: collision with root package name */
    f f2342b;

    /* renamed from: c  reason: collision with root package name */
    boolean f2343c;

    /* renamed from: d  reason: collision with root package name */
    final Object f2344d = new Object();

    /* renamed from: e  reason: collision with root package name */
    c f2345e;

    /* renamed from: f  reason: collision with root package name */
    private final Context f2346f;

    /* renamed from: g  reason: collision with root package name */
    final long f2347g;

    /* renamed from: D.a$a  reason: collision with other inner class name */
    public static final class C0043a {

        /* renamed from: a  reason: collision with root package name */
        private final String f2348a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f2349b;

        public C0043a(String str, boolean z4) {
            this.f2348a = str;
            this.f2349b = z4;
        }

        public String a() {
            return this.f2348a;
        }

        public boolean b() {
            return this.f2349b;
        }

        public String toString() {
            String str = this.f2348a;
            boolean z4 = this.f2349b;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7);
            sb.append("{");
            sb.append(str);
            sb.append("}");
            sb.append(z4);
            return sb.toString();
        }
    }

    public C0635a(Context context, long j5, boolean z4, boolean z5) {
        Context applicationContext;
        C0722p.k(context);
        if (z4 && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        this.f2346f = context;
        this.f2343c = false;
        this.f2347g = j5;
    }

    public static C0043a a(Context context) {
        C0635a aVar = new C0635a(context, -1, true, false);
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            aVar.d(false);
            C0043a f5 = aVar.f(-1);
            aVar.e(f5, true, 0.0f, SystemClock.elapsedRealtime() - elapsedRealtime, "", (Throwable) null);
            aVar.c();
            return f5;
        } catch (Throwable th) {
            Throwable th2 = th;
            aVar.c();
            throw th2;
        }
    }

    private final C0043a f(int i5) {
        C0043a aVar;
        C0722p.j("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (!this.f2343c) {
                    synchronized (this.f2344d) {
                        c cVar = this.f2345e;
                        if (cVar == null || !cVar.f2354d) {
                            throw new IOException("AdvertisingIdClient is not connected.");
                        }
                    }
                    d(false);
                    if (!this.f2343c) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                }
                C0722p.k(this.f2341a);
                C0722p.k(this.f2342b);
                aVar = new C0043a(this.f2342b.b(), this.f2342b.s(true));
            } catch (RemoteException e5) {
                Log.i("AdvertisingIdClient", "GMS remote exception ", e5);
                throw new IOException("Remote exception");
            } catch (Exception e6) {
                throw new IOException("AdvertisingIdClient cannot reconnect.", e6);
            } catch (Throwable th) {
                throw th;
            }
        }
        g();
        return aVar;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:2|3|(3:5|6|7)|9|10|(1:12)|13) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0014 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void g() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f2344d
            monitor-enter(r0)
            D.c r1 = r5.f2345e     // Catch:{ all -> 0x0012 }
            if (r1 == 0) goto L_0x0014
            java.util.concurrent.CountDownLatch r1 = r1.f2353c     // Catch:{ all -> 0x0012 }
            r1.countDown()     // Catch:{ all -> 0x0012 }
            D.c r1 = r5.f2345e     // Catch:{ InterruptedException -> 0x0014 }
            r1.join()     // Catch:{ InterruptedException -> 0x0014 }
            goto L_0x0014
        L_0x0012:
            r1 = move-exception
            goto L_0x0025
        L_0x0014:
            long r1 = r5.f2347g     // Catch:{ all -> 0x0012 }
            r3 = 0
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x0023
            D.c r3 = new D.c     // Catch:{ all -> 0x0012 }
            r3.<init>(r5, r1)     // Catch:{ all -> 0x0012 }
            r5.f2345e = r3     // Catch:{ all -> 0x0012 }
        L_0x0023:
            monitor-exit(r0)     // Catch:{ all -> 0x0012 }
            return
        L_0x0025:
            monitor-exit(r0)     // Catch:{ all -> 0x0012 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: D.C0635a.g():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c() {
        /*
            r3 = this;
            java.lang.String r0 = "Calling this from your main thread can lead to deadlock"
            N.C0722p.j(r0)
            monitor-enter(r3)
            android.content.Context r0 = r3.f2346f     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x0033
            K.a r0 = r3.f2341a     // Catch:{ all -> 0x0031 }
            if (r0 != 0) goto L_0x000f
            goto L_0x0033
        L_0x000f:
            boolean r0 = r3.f2343c     // Catch:{ all -> 0x001f }
            if (r0 == 0) goto L_0x0027
            R.b r0 = R.b.b()     // Catch:{ all -> 0x001f }
            android.content.Context r1 = r3.f2346f     // Catch:{ all -> 0x001f }
            K.a r2 = r3.f2341a     // Catch:{ all -> 0x001f }
            r0.c(r1, r2)     // Catch:{ all -> 0x001f }
            goto L_0x0027
        L_0x001f:
            r0 = move-exception
            java.lang.String r1 = "AdvertisingIdClient"
            java.lang.String r2 = "AdvertisingIdClient unbindService failed."
            android.util.Log.i(r1, r2, r0)     // Catch:{ all -> 0x0031 }
        L_0x0027:
            r0 = 0
            r3.f2343c = r0     // Catch:{ all -> 0x0031 }
            r0 = 0
            r3.f2342b = r0     // Catch:{ all -> 0x0031 }
            r3.f2341a = r0     // Catch:{ all -> 0x0031 }
            monitor-exit(r3)     // Catch:{ all -> 0x0031 }
            return
        L_0x0031:
            r0 = move-exception
            goto L_0x0035
        L_0x0033:
            monitor-exit(r3)     // Catch:{ all -> 0x0031 }
            return
        L_0x0035:
            monitor-exit(r3)     // Catch:{ all -> 0x0031 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: D.C0635a.c():void");
    }

    /* access modifiers changed from: protected */
    public final void d(boolean z4) {
        C0722p.j("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.f2343c) {
                    c();
                }
                Context context = this.f2346f;
                context.getPackageManager().getPackageInfo("com.android.vending", 0);
                int h5 = C0661h.f().h(context, C0665l.f2721a);
                if (h5 != 0) {
                    if (h5 != 2) {
                        throw new IOException("Google Play services not available");
                    }
                }
                C0654a aVar = new C0654a();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                if (b.b().a(context, intent, aVar, 1)) {
                    this.f2341a = aVar;
                    this.f2342b = e.i(aVar.a(WorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS));
                    this.f2343c = true;
                    if (z4) {
                        g();
                    }
                } else {
                    throw new IOException("Connection failure");
                }
            } catch (PackageManager.NameNotFoundException unused) {
                throw new C0662i(9);
            } catch (InterruptedException unused2) {
                throw new IOException("Interrupted exception");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean e(C0043a aVar, boolean z4, float f5, long j5, String str, Throwable th) {
        if (Math.random() > 0.0d) {
            return false;
        }
        HashMap hashMap = new HashMap();
        String str2 = "1";
        hashMap.put("app_context", str2);
        if (aVar != null) {
            if (true != aVar.b()) {
                str2 = "0";
            }
            hashMap.put("limit_ad_tracking", str2);
            String a5 = aVar.a();
            if (a5 != null) {
                hashMap.put("ad_id_size", Integer.toString(a5.length()));
            }
        }
        if (th != null) {
            hashMap.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, th.getClass().getName());
        }
        hashMap.put("tag", "AdvertisingIdClient");
        hashMap.put("time_spent", Long.toString(j5));
        new C0636b(this, hashMap).start();
        return true;
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
        c();
        super.finalize();
    }

    public static void b(boolean z4) {
    }
}
