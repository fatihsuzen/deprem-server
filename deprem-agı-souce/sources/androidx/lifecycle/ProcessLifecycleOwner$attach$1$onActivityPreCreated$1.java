package androidx.lifecycle;

import android.app.Activity;
import kotlin.jvm.internal.t;

public final class ProcessLifecycleOwner$attach$1$onActivityPreCreated$1 extends EmptyActivityLifecycleCallbacks {
    final /* synthetic */ ProcessLifecycleOwner this$0;

    ProcessLifecycleOwner$attach$1$onActivityPreCreated$1(ProcessLifecycleOwner processLifecycleOwner) {
        this.this$0 = processLifecycleOwner;
    }

    public void onActivityPostResumed(Activity activity) {
        t.e(activity, "activity");
        this.this$0.activityResumed$lifecycle_process_release();
    }

    public void onActivityPostStarted(Activity activity) {
        t.e(activity, "activity");
        this.this$0.activityStarted$lifecycle_process_release();
    }
}
