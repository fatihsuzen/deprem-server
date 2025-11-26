package androidx.lifecycle;

import W2.J;
import android.annotation.SuppressLint;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import kotlin.jvm.internal.t;
import w3.C2865c0;
import w3.C2872g;

public final class LiveDataScopeImpl<T> implements LiveDataScope<T> {
    private final C2312i coroutineContext;
    private CoroutineLiveData<T> target;

    public LiveDataScopeImpl(CoroutineLiveData<T> coroutineLiveData, C2312i iVar) {
        t.e(coroutineLiveData, TypedValues.AttributesType.S_TARGET);
        t.e(iVar, "context");
        this.target = coroutineLiveData;
        this.coroutineContext = iVar.plus(C2865c0.c().F());
    }

    @SuppressLint({"NullSafeMutableLiveData"})
    public Object emit(T t5, C2308e eVar) {
        Object g5 = C2872g.g(this.coroutineContext, new LiveDataScopeImpl$emit$2(this, t5, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    public Object emitSource(LiveData<T> liveData, C2308e eVar) {
        return C2872g.g(this.coroutineContext, new LiveDataScopeImpl$emitSource$2(this, liveData, (C2308e) null), eVar);
    }

    public T getLatestValue() {
        return this.target.getValue();
    }

    public final CoroutineLiveData<T> getTarget$lifecycle_livedata_release() {
        return this.target;
    }

    public final void setTarget$lifecycle_livedata_release(CoroutineLiveData<T> coroutineLiveData) {
        t.e(coroutineLiveData, "<set-?>");
        this.target = coroutineLiveData;
    }
}
