package androidx.room;

import b3.C2308e;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class RoomCallableTrackingLiveData<T> extends RoomTrackingLiveData<T> {
    private final Callable<T> callableFunction;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoomCallableTrackingLiveData(RoomDatabase roomDatabase, InvalidationLiveDataContainer invalidationLiveDataContainer, boolean z4, String[] strArr, Callable<T> callable) {
        super(roomDatabase, invalidationLiveDataContainer, z4, strArr, (C2633k) null);
        t.e(roomDatabase, "database");
        t.e(invalidationLiveDataContainer, "container");
        t.e(strArr, "tableNames");
        t.e(callable, "callableFunction");
        this.callableFunction = callable;
    }

    public Object compute(C2308e eVar) {
        return this.callableFunction.call();
    }
}
