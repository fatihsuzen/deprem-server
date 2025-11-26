package androidx.lifecycle;

import k3.l;

public final /* synthetic */ class e implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MediatorLiveData f377a;

    public /* synthetic */ e(MediatorLiveData mediatorLiveData) {
        this.f377a = mediatorLiveData;
    }

    public final Object invoke(Object obj) {
        return CoroutineLiveDataKt$addDisposableSource$2.invokeSuspend$lambda$0(this.f377a, obj);
    }
}
