package J;

import S.a;
import a0.C0999e;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import k0.C1698l;

public final class D {

    /* renamed from: e  reason: collision with root package name */
    private static D f2604e;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f2605a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final ScheduledExecutorService f2606b;

    /* renamed from: c  reason: collision with root package name */
    private x f2607c = new x(this, (w) null);

    /* renamed from: d  reason: collision with root package name */
    private int f2608d = 1;

    D(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f2606b = scheduledExecutorService;
        this.f2605a = context.getApplicationContext();
    }

    public static synchronized D b(Context context) {
        D d5;
        synchronized (D.class) {
            try {
                if (f2604e == null) {
                    C0999e.a();
                    f2604e = new D(context, Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, new a("MessengerIpcClient"))));
                }
                d5 = f2604e;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return d5;
    }

    private final synchronized int f() {
        int i5;
        i5 = this.f2608d;
        this.f2608d = i5 + 1;
        return i5;
    }

    private final synchronized C1698l g(C0644A a5) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                Log.d("MessengerIpcClient", "Queueing ".concat(a5.toString()));
            }
            if (!this.f2607c.g(a5)) {
                x xVar = new x(this, (w) null);
                this.f2607c = xVar;
                xVar.g(a5);
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return a5.f2601b.a();
    }

    public final C1698l c(int i5, Bundle bundle) {
        return g(new z(f(), i5, bundle));
    }

    public final C1698l d(int i5, Bundle bundle) {
        return g(new C(f(), i5, bundle));
    }
}
