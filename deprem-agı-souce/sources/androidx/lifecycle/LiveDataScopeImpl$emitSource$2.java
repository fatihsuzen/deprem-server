package androidx.lifecycle;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

@f(c = "androidx.lifecycle.LiveDataScopeImpl$emitSource$2", f = "CoroutineLiveData.kt", l = {92}, m = "invokeSuspend")
final class LiveDataScopeImpl$emitSource$2 extends l implements p {
    final /* synthetic */ LiveData<T> $source;
    int label;
    final /* synthetic */ LiveDataScopeImpl<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LiveDataScopeImpl$emitSource$2(LiveDataScopeImpl<T> liveDataScopeImpl, LiveData<T> liveData, C2308e eVar) {
        super(2, eVar);
        this.this$0 = liveDataScopeImpl;
        this.$source = liveData;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new LiveDataScopeImpl$emitSource$2(this.this$0, this.$source, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            CoroutineLiveData<T> target$lifecycle_livedata_release = this.this$0.getTarget$lifecycle_livedata_release();
            LiveData<T> liveData = this.$source;
            this.label = 1;
            Object emitSource$lifecycle_livedata_release = target$lifecycle_livedata_release.emitSource$lifecycle_livedata_release(liveData, this);
            if (emitSource$lifecycle_livedata_release == f5) {
                return f5;
            }
            return emitSource$lifecycle_livedata_release;
        } else if (i5 == 1) {
            u.b(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((LiveDataScopeImpl$emitSource$2) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
