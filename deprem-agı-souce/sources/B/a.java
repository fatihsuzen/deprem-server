package b;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.inmobi.cmp.ChoiceCmp;
import kotlin.jvm.internal.t;

public final class a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    public int f795a;

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        t.e(activity, "p0");
    }

    public final void onActivityDestroyed(Activity activity) {
        t.e(activity, "p0");
    }

    public final void onActivityPaused(Activity activity) {
        t.e(activity, "p0");
    }

    public final void onActivityResumed(Activity activity) {
        t.e(activity, "p0");
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        t.e(activity, "p0");
        t.e(bundle, "p1");
    }

    public final void onActivityStarted(Activity activity) {
        t.e(activity, "p0");
        this.f795a++;
    }

    public final void onActivityStopped(Activity activity) {
        t.e(activity, "p0");
        int i5 = this.f795a - 1;
        this.f795a = i5;
        if (i5 < 0) {
            ChoiceCmp.INSTANCE.onAppClosing();
        }
    }
}
