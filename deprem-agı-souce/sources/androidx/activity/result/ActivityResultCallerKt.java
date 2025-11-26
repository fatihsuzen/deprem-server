package androidx.activity.result;

import W2.J;
import androidx.activity.result.contract.ActivityResultContract;
import k3.l;

public final class ActivityResultCallerKt {
    public static final <I, O> ActivityResultLauncher<J> registerForActivityResult(ActivityResultCaller activityResultCaller, ActivityResultContract<I, O> activityResultContract, I i5, ActivityResultRegistry activityResultRegistry, l lVar) {
        return new ActivityResultCallerLauncher(activityResultCaller.registerForActivityResult(activityResultContract, activityResultRegistry, new a(lVar)), activityResultContract, i5);
    }

    /* access modifiers changed from: private */
    public static final void registerForActivityResult$lambda$0(l lVar, Object obj) {
        lVar.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void registerForActivityResult$lambda$1(l lVar, Object obj) {
        lVar.invoke(obj);
    }

    public static final <I, O> ActivityResultLauncher<J> registerForActivityResult(ActivityResultCaller activityResultCaller, ActivityResultContract<I, O> activityResultContract, I i5, l lVar) {
        return new ActivityResultCallerLauncher(activityResultCaller.registerForActivityResult(activityResultContract, new b(lVar)), activityResultContract, i5);
    }
}
