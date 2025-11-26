package androidx.room;

import androidx.lifecycle.LiveData;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.Callable;
import k3.l;
import kotlin.jvm.internal.t;

public final class InvalidationLiveDataContainer {
    private final RoomDatabase database;
    private final Set<LiveData<?>> liveDataSet;

    public InvalidationLiveDataContainer(RoomDatabase roomDatabase) {
        t.e(roomDatabase, "database");
        this.database = roomDatabase;
        Set<LiveData<?>> newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        t.d(newSetFromMap, "newSetFromMap(...)");
        this.liveDataSet = newSetFromMap;
    }

    public final <T> LiveData<T> create(String[] strArr, boolean z4, Callable<T> callable) {
        t.e(strArr, "tableNames");
        t.e(callable, "callableFunction");
        return new RoomCallableTrackingLiveData(this.database, this, z4, strArr, callable);
    }

    public final Set<LiveData<?>> getLiveDataSet$room_runtime_release() {
        return this.liveDataSet;
    }

    public final void onActive(LiveData<?> liveData) {
        t.e(liveData, "liveData");
        this.liveDataSet.add(liveData);
    }

    public final void onInactive(LiveData<?> liveData) {
        t.e(liveData, "liveData");
        this.liveDataSet.remove(liveData);
    }

    public final <T> LiveData<T> create(String[] strArr, boolean z4, l lVar) {
        t.e(strArr, "tableNames");
        t.e(lVar, "lambdaFunction");
        return new RoomLambdaTrackingLiveData(this.database, this, z4, strArr, lVar);
    }
}
