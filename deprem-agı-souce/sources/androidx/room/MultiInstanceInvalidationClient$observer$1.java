package androidx.room;

import android.os.RemoteException;
import android.util.Log;
import androidx.room.InvalidationTracker;
import java.util.Set;
import kotlin.jvm.internal.t;

public final class MultiInstanceInvalidationClient$observer$1 extends InvalidationTracker.Observer {
    final /* synthetic */ MultiInstanceInvalidationClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MultiInstanceInvalidationClient$observer$1(MultiInstanceInvalidationClient multiInstanceInvalidationClient, String[] strArr) {
        super(strArr);
        this.this$0 = multiInstanceInvalidationClient;
    }

    public boolean isRemote$room_runtime_release() {
        return true;
    }

    public void onInvalidated(Set<String> set) {
        t.e(set, "tables");
        if (!this.this$0.stopped.get()) {
            try {
                IMultiInstanceInvalidationService access$getInvalidationService$p = this.this$0.invalidationService;
                if (access$getInvalidationService$p != null) {
                    access$getInvalidationService$p.broadcastInvalidation(this.this$0.clientId, (String[]) set.toArray(new String[0]));
                }
            } catch (RemoteException e5) {
                Log.w(Room.LOG_TAG, "Cannot broadcast invalidation", e5);
            }
        }
    }
}
