package androidx.lifecycle;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import z3.C2972e;
import z3.C2973f;

@f(c = "androidx.lifecycle.FlowLiveDataConversions$asLiveData$1", f = "FlowLiveData.kt", l = {78}, m = "invokeSuspend")
final class FlowLiveDataConversions$asLiveData$1 extends l implements p {
    final /* synthetic */ C2972e $this_asLiveData;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowLiveDataConversions$asLiveData$1(C2972e eVar, C2308e eVar2) {
        super(2, eVar2);
        this.$this_asLiveData = eVar;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        FlowLiveDataConversions$asLiveData$1 flowLiveDataConversions$asLiveData$1 = new FlowLiveDataConversions$asLiveData$1(this.$this_asLiveData, eVar);
        flowLiveDataConversions$asLiveData$1.L$0 = obj;
        return flowLiveDataConversions$asLiveData$1;
    }

    public final Object invoke(LiveDataScope<T> liveDataScope, C2308e eVar) {
        return ((FlowLiveDataConversions$asLiveData$1) create(liveDataScope, eVar)).invokeSuspend(J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            final LiveDataScope liveDataScope = (LiveDataScope) this.L$0;
            C2972e eVar = this.$this_asLiveData;
            AnonymousClass1 r32 = new C2973f() {
                public final Object emit(T t5, C2308e eVar) {
                    Object emit = liveDataScope.emit(t5, eVar);
                    if (emit == C2316b.f()) {
                        return emit;
                    }
                    return J.f19942a;
                }
            };
            this.label = 1;
            if (eVar.collect(r32, this) == f5) {
                return f5;
            }
        } else if (i5 == 1) {
            u.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return J.f19942a;
    }
}
