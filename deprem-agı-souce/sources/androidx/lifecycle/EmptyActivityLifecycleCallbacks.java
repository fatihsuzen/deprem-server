package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import kotlin.jvm.internal.t;

public class EmptyActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    public void onActivityCreated(Activity activity, Bundle bundle) {
        t.e(activity, "activity");
    }

    public void onActivityDestroyed(Activity activity) {
        t.e(activity, "activity");
    }

    public void onActivityPaused(Activity activity) {
        t.e(activity, "activity");
    }

    public void onActivityResumed(Activity activity) {
        t.e(activity, "activity");
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
