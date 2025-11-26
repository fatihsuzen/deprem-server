package androidx.lifecycle;

import k3.l;

public final /* synthetic */ class v implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MediatorLiveData f399a;

    public /* synthetic */ v(MediatorLiveData mediatorLiveData) {
        this.f399a = mediatorLiveData;
    }

    public final Object invoke(Object obj) {
        return Transformations.switchMap$lambda$3$lambda$2(this.f399a, obj);
    }
}
