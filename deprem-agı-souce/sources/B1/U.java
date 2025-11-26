package b1;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import kotlin.jvm.internal.t;

public final class U implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private final W f4585a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f4586b = true;

    public U(W w4) {
        t.e(w4, "sharedSessionRepository");
        this.f4585a = w4;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        t.e(activity, "activity");
    }

    public void onActivityDestroyed(Activity activity) {
        t.e(activity, "activity");
    }

    public void onActivityPaused(Activity activity) {
        t.e(activity, "activity");
        if (this.f4586b) {
            this.f4585a.b();
        }
    }

    public void onActivityResumed(Activity activity) {
        t.e(activity, "activity");
        if (this.f4586b) {
            this.f4585a.c();
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        t.e(activity, "activity");
        t.e(bundle, "outState");
    }

    public void onActivityStarted(Activity activity) {
        t.e(activity, "activity");
    }

    public void onActivityStopped(Activity activity) {
        t.e(activity, "activity");
    }
}
