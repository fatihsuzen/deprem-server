package androidx.room;

import androidx.room.util.DBUtil;
import b3.C2308e;
import k3.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class RoomLambdaTrackingLiveData<T> extends RoomTrackingLiveData<T> {
    private final l lambdaFunction;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoomLambdaTrackingLiveData(RoomDatabase roomDatabase, InvalidationLiveDataContainer invalidationLiveDataContainer, boolean z4, String[] strArr, l lVar) {
        super(roomDatabase, invalidationLiveDataContainer, z4, strArr, (C2633k) null);
        t.e(roomDatabase, "database");
        t.e(invalidationLiveDataContainer, "container");
        t.e(strArr, "tableNames");
        t.e(lVar, "lambdaFunction");
        this.lambdaFunction = lVar;
    }

    public Object compute(C2308e eVar) {
        return DBUtil.performSuspending(getDatabase(), true, getInTransaction(), this.lambdaFunction, eVar);
    }
}
