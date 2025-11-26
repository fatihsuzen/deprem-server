package x1;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

public class d implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private boolean f16975a;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f16976b;

    /* renamed from: c  reason: collision with root package name */
    private a f16977c;

    public interface a {
        void a(boolean z4);
    }

    private void c(boolean z4) {
        if (this.f16976b != z4) {
            this.f16976b = z4;
            if (this.f16975a) {
                f(z4);
                a aVar = this.f16977c;
                if (aVar != null) {
                    aVar.a(z4);
                }
            }
        }
    }

    private boolean d() {
        if (e().importance != 100 && !h()) {
            return false;
        }
        return true;
    }

    public void a(Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(this);
        }
    }

    public void b(a aVar) {
        this.f16977c = aVar;
    }

    /* access modifiers changed from: package-private */
    public ActivityManager.RunningAppProcessInfo e() {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        return runningAppProcessInfo;
    }

    public boolean g() {
        return this.f16976b;
    }

    /* access modifiers changed from: protected */
    public boolean h() {
        return false;
    }

    public void i() {
        this.f16975a = true;
        boolean d5 = d();
        this.f16976b = d5;
        f(d5);
    }

    public void j() {
        this.f16975a = false;
        this.f16977c = null;
    }

    public void onActivityStarted(Activity activity) {
        c(true);
    }

    public void onActivityStopped(Activity activity) {
        c(d());
    }

    /* access modifiers changed from: protected */
    public void f(boolean z4) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
