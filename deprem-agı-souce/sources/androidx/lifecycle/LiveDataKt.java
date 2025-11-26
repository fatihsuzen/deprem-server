package androidx.lifecycle;

import androidx.annotation.MainThread;
import k3.l;
import kotlin.jvm.internal.t;

public final class LiveDataKt {
    @MainThread
    public static final <T> Observer<T> observe(LiveData<T> liveData, LifecycleOwner lifecycleOwner, l lVar) {
        t.e(liveData, "<this>");
        t.e(lifecycleOwner, "owner");
        t.e(lVar, "onChanged");
        LiveDataKt$observe$wrappedObserver$1 liveDataKt$observe$wrappedObserver$1 = new LiveDataKt$observe$wrappedObserver$1(lVar);
        liveData.observe(lifecycleOwner, liveDataKt$observe$wrappedObserver$1);
        return liveDataKt$observe$wrappedObserver$1;
    }
}
