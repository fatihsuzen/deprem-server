package androidx.activity.result;

import W2.J;
import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import k3.C2616a;
import kotlin.jvm.internal.u;

final class ActivityResultCallerLauncher$resultContract$2 extends u implements C2616a {
    final /* synthetic */ ActivityResultCallerLauncher<I, O> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ActivityResultCallerLauncher$resultContract$2(ActivityResultCallerLauncher<I, O> activityResultCallerLauncher) {
        super(0);
        this.this$0 = activityResultCallerLauncher;
    }

    public final AnonymousClass1 invoke() {
        final ActivityResultCallerLauncher<I, O> activityResultCallerLauncher = this.this$0;
        return new ActivityResultContract<J, O>() {
            public O parseResult(int i5, Intent intent) {
                return activityResultCallerLauncher.getCallerContract().parseResult(i5, intent);
            }

            public Intent createIntent(Context context, J j5) {
                return activityResultCallerLauncher.getCallerContract().createIntent(context, activityResultCallerLauncher.getCallerInput());
            }
        };
    }
}
