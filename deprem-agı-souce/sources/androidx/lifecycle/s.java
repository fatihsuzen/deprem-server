package androidx.lifecycle;

import k3.l;

public final /* synthetic */ class s implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MediatorLiveData f392a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f393b;

    public /* synthetic */ s(MediatorLiveData mediatorLiveData, l lVar) {
        this.f392a = mediatorLiveData;
        this.f393b = lVar;
    }

    public final Object invoke(Object obj) {
        return Transformations.map$lambda$0(this.f392a, this.f393b, obj);
    }
}
