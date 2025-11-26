package M;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.common.util.n;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: M.c  reason: case insensitive filesystem */
public final class C0683c implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* renamed from: e  reason: collision with root package name */
    private static final C0683c f2885e = new C0683c();

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f2886a = new AtomicBoolean();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicBoolean f2887b = new AtomicBoolean();

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList f2888c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private boolean f2889d = false;

    /* renamed from: M.c$a */
    public interface a {
        void a(boolean z4);
    }

    private C0683c() {
    }

    public static C0683c b() {
        return f2885e;
    }

    public static void c(Application application) {
        C0683c cVar = f2885e;
        synchronized (cVar) {
            try {
                if (!cVar.f2889d) {
                    application.registerActivityLifecycleCallbacks(cVar);
                    application.registerComponentCallbacks(cVar);
                    cVar.f2889d = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void f(boolean z4) {
        synchronized (f2885e) {
            try {
                ArrayList arrayList = this.f2888c;
                int size = arrayList.size();
                int i5 = 0;
                while (i5 < size) {
                    Object obj = arrayList.get(i5);
                    i5++;
                    ((a) obj).a(z4);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(a aVar) {
        synchronized (f2885e) {
            this.f2888c.add(aVar);
        }
    }

    public boolean d() {
        return this.f2886a.get();
    }

    public boolean e(boolean z4) {
        if (!this.f2887b.get()) {
            if (n.b()) {
                return z4;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.f2887b.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.f2886a.set(true);
            }
        }
        return d();
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        AtomicBoolean atomicBoolean = this.f2887b;
        boolean compareAndSet = this.f2886a.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (compareAndSet) {
            f(false);
        }
    }

    public final void onActivityResumed(Activity activity) {
        AtomicBoolean atomicBoolean = this.f2887b;
        boolean compareAndSet = this.f2886a.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (compareAndSet) {
            f(false);
        }
    }

    public final void onTrimMemory(int i5) {
        if (i5 == 20 && this.f2886a.compareAndSet(false, true)) {
            this.f2887b.set(true);
            f(true);
        }
    }

    public final void onLowMemory() {
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
