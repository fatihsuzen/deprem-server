package androidx.work.impl.constraints.trackers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.t;

public final class BroadcastReceiverConstraintTracker$broadcastReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ BroadcastReceiverConstraintTracker<T> this$0;

    BroadcastReceiverConstraintTracker$broadcastReceiver$1(BroadcastReceiverConstraintTracker<T> broadcastReceiverConstraintTracker) {
        this.this$0 = broadcastReceiverConstraintTracker;
    }

    public void onReceive(Context context, Intent intent) {
        t.e(context, "context");
        t.e(intent, "intent");
        this.this$0.onBroadcastReceive(intent);
    }
}
