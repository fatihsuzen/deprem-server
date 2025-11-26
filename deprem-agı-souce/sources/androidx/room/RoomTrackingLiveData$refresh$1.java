package androidx.room;

import b3.C2308e;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.room.RoomTrackingLiveData", f = "RoomTrackingLiveData.android.kt", l = {82}, m = "refresh")
final class RoomTrackingLiveData$refresh$1 extends d {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RoomTrackingLiveData<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RoomTrackingLiveData$refresh$1(RoomTrackingLiveData<T> roomTrackingLiveData, C2308e eVar) {
        super(eVar);
        this.this$0 = roomTrackingLiveData;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.refresh(this);
    }
}
