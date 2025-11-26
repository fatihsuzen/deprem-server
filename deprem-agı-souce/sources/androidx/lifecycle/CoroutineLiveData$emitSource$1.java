package androidx.lifecycle;

import b3.C2308e;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.lifecycle.CoroutineLiveData", f = "CoroutineLiveData.kt", l = {219, 220}, m = "emitSource$lifecycle_livedata_release")
final class CoroutineLiveData$emitSource$1 extends d {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CoroutineLiveData<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoroutineLiveData$emitSource$1(CoroutineLiveData<T> coroutineLiveData, C2308e eVar) {
        super(eVar);
        this.this$0 = coroutineLiveData;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emitSource$lifecycle_livedata_release((LiveData) null, this);
    }
}
