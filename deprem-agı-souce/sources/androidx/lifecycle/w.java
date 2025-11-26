package androidx.lifecycle;

import k3.l;

public final /* synthetic */ class w implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MediatorLiveData f400a;

    public /* synthetic */ w(MediatorLiveData mediatorLiveData) {
        this.f400a = mediatorLiveData;
    }

    public final Object invoke(Object obj) {
        return Transformations$switchMap$2.onChanged$lambda$0(this.f400a, obj);
    }
}
