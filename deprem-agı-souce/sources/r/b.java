package R;

import N.C0722p;
import N.r0;
import T.e;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.util.k;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;

public class b {

    /* renamed from: b  reason: collision with root package name */
    private static final Object f3985b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static volatile b f3986c;

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentHashMap f3987a = new ConcurrentHashMap();

    private b() {
    }

    public static b b() {
        if (f3986c == null) {
            synchronized (f3985b) {
                try {
                    if (f3986c == null) {
                        f3986c = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        b bVar = f3986c;
        C0722p.k(bVar);
        return bVar;
    }

    private static void e(Context context, ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
        } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
        }
    }

    private final boolean f(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i5, boolean z4, Executor executor) {
        ComponentName component = intent.getComponent();
        if (component != null) {
            String packageName = component.getPackageName();
            "com.google.android.gms".equals(packageName);
            try {
                if ((e.a(context).c(packageName, 0).flags & 2097152) != 0) {
                    Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (!g(serviceConnection)) {
            return h(context, intent, serviceConnection, i5, executor);
        }
        ServiceConnection serviceConnection2 = (ServiceConnection) this.f3987a.putIfAbsent(serviceConnection, serviceConnection);
        if (!(serviceConnection2 == null || serviceConnection == serviceConnection2)) {
            Log.w("ConnectionTracker", String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", new Object[]{serviceConnection, str, intent.getAction()}));
        }
        try {
            boolean h5 = h(context, intent, serviceConnection, i5, executor);
            if (h5) {
                return h5;
            }
            return false;
        } finally {
            this.f3987a.remove(serviceConnection, serviceConnection);
        }
    }

    private static boolean g(ServiceConnection serviceConnection) {
        if (!(serviceConnection instanceof r0)) {
            return true;
        }
        return false;
    }

    private static final boolean h(Context context, Intent intent, ServiceConnection serviceConnection, int i5, Executor executor) {
        if (executor == null) {
            executor = null;
        }
        if (!k.g() || executor == null) {
            return context.bindService(intent, serviceConnection, i5);
        }
        return context.bindService(intent, i5, executor, serviceConnection);
    }

    public boolean a(Context context, Intent intent, ServiceConnection serviceConnection, int i5) {
        return f(context, context.getClass().getName(), intent, serviceConnection, i5, true, (Executor) null);
    }

    public void c(Context context, ServiceConnection serviceConnection) {
        if (!g(serviceConnection) || !this.f3987a.containsKey(serviceConnection)) {
            e(context, serviceConnection);
            return;
        }
        try {
            e(context, (ServiceConnection) this.f3987a.get(serviceConnection));
        } finally {
            this.f3987a.remove(serviceConnection);
        }
    }

    public final boolean d(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i5, Executor executor) {
        return f(context, str, intent, serviceConnection, 4225, true, executor);
    }
}
