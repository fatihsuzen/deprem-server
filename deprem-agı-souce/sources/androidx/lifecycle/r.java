package androidx.lifecycle;

import k3.l;
import kotlin.jvm.internal.L;

public final /* synthetic */ class r implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f389a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ L f390b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediatorLiveData f391c;

    public /* synthetic */ r(l lVar, L l5, MediatorLiveData mediatorLiveData) {
        this.f389a = lVar;
        this.f390b = l5;
        this.f391c = mediatorLiveData;
    }

    public final Object invoke(Object obj) {
        return Transformations.switchMap$lambda$3(this.f389a, this.f390b, this.f391c, obj);
    }
}
