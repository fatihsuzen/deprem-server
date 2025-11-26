package androidx.lifecycle;

import k3.l;
import kotlin.jvm.internal.I;

public final /* synthetic */ class t implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MediatorLiveData f395a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ I f396b;

    public /* synthetic */ t(MediatorLiveData mediatorLiveData, I i5) {
        this.f395a = mediatorLiveData;
        this.f396b = i5;
    }

    public final Object invoke(Object obj) {
        return Transformations.distinctUntilChanged$lambda$4(this.f395a, this.f396b, obj);
    }
}
