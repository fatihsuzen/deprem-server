package androidx.lifecycle;

import androidx.arch.core.util.Function;
import k3.l;

public final /* synthetic */ class u implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MediatorLiveData f397a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function f398b;

    public /* synthetic */ u(MediatorLiveData mediatorLiveData, Function function) {
        this.f397a = mediatorLiveData;
        this.f398b = function;
    }

    public final Object invoke(Object obj) {
        return Transformations.map$lambda$1(this.f397a, this.f398b, obj);
    }
}
