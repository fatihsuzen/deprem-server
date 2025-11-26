package androidx.room;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.room.InvalidationTracker;
import java.util.Set;
import kotlin.jvm.internal.t;

public final class RoomTrackingLiveData$observer$1 extends InvalidationTracker.Observer {
    final /* synthetic */ RoomTrackingLiveData<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RoomTrackingLiveData$observer$1(String[] strArr, RoomTrackingLiveData<T> roomTrackingLiveData) {
        super(strArr);
        this.this$0 = roomTrackingLiveData;
    }

    /* access modifiers changed from: private */
    public static final void onInvalidated$lambda$0(RoomTrackingLiveData roomTrackingLiveData) {
        roomTrackingLiveData.invalidated();
    }

    public void onInvalidated(Set<String> set) {
        t.e(set, "tables");
        ArchTaskExecutor.getInstance().executeOnMainThread(new p(this.this$0));
    }
}
