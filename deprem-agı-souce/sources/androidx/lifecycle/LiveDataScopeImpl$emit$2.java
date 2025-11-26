package androidx.lifecycle;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

@f(c = "androidx.lifecycle.LiveDataScopeImpl$emit$2", f = "CoroutineLiveData.kt", l = {98}, m = "invokeSuspend")
final class LiveDataScopeImpl$emit$2 extends l implements p {
    final /* synthetic */ T $value;
    int label;
    final /* synthetic */ LiveDataScopeImpl<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LiveDataScopeImpl$emit$2(LiveDataScopeImpl<T> liveDataScopeImpl, T t5, C2308e eVar) {
        super(2, eVar);
        this.this$0 = liveDataScopeImpl;
        this.$value = t5;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new LiveDataScopeImpl$emit$2(this.this$0, this.$value, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            CoroutineLiveData<T> target$lifecycle_livedata_release = this.this$0.getTarget$lifecycle_livedata_release();
            this.label = 1;
            if (target$lifecycle_livedata_release.clearSource$lifecycle_livedata_release(this) == f5) {
                return f5;
            }
        } else if (i5 == 1) {
            u.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.getTarget$lifecycle_livedata_release().setValue(this.$value);
        return J.f19942a;
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((LiveDataScopeImpl$emit$2) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
