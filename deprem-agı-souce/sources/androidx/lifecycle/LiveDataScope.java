package androidx.lifecycle;

import b3.C2308e;

public interface LiveDataScope<T> {
    Object emit(T t5, C2308e eVar);

    Object emitSource(LiveData<T> liveData, C2308e eVar);

    T getLatestValue();
}
