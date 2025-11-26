package androidx.lifecycle;

import k3.l;

public final class LiveDataKt$observe$wrappedObserver$1<T> implements Observer {
    final /* synthetic */ l $onChanged;

    public LiveDataKt$observe$wrappedObserver$1(l lVar) {
        this.$onChanged = lVar;
    }

    public final void onChanged(T t5) {
        this.$onChanged.invoke(t5);
    }
}
