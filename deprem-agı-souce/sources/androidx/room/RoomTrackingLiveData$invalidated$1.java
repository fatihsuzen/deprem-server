package androidx.room;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

@f(c = "androidx.room.RoomTrackingLiveData$invalidated$1", f = "RoomTrackingLiveData.android.kt", l = {113}, m = "invokeSuspend")
final class RoomTrackingLiveData$invalidated$1 extends l implements p {
    int label;
    final /* synthetic */ RoomTrackingLiveData<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RoomTrackingLiveData$invalidated$1(RoomTrackingLiveData<T> roomTrackingLiveData, C2308e eVar) {
        super(2, eVar);
        this.this$0 = roomTrackingLiveData;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new RoomTrackingLiveData$invalidated$1(this.this$0, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            RoomTrackingLiveData<T> roomTrackingLiveData = this.this$0;
            this.label = 1;
            if (roomTrackingLiveData.refresh(this) == f5) {
                return f5;
            }
        } else if (i5 == 1) {
            u.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return J.f19942a;
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((RoomTrackingLiveData$invalidated$1) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
