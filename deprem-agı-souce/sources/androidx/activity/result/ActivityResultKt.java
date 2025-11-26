package androidx.activity.result;

import android.content.Intent;

public final class ActivityResultKt {
    public static final int component1(ActivityResult activityResult) {
        return activityResult.getResultCode();
    }

    public static final Intent component2(ActivityResult activityResult) {
        return activityResult.getData();
    }
}
