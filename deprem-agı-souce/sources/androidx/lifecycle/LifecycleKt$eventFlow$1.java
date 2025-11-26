package androidx.lifecycle;

import W2.J;
import W2.u;
import androidx.lifecycle.Lifecycle;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import y3.t;
import y3.v;
import y3.y;

@f(c = "androidx.lifecycle.LifecycleKt$eventFlow$1", f = "Lifecycle.kt", l = {373}, m = "invokeSuspend")
final class LifecycleKt$eventFlow$1 extends l implements p {
    final /* synthetic */ Lifecycle $this_eventFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LifecycleKt$eventFlow$1(Lifecycle lifecycle, C2308e eVar) {
        super(2, eVar);
        this.$this_eventFlow = lifecycle;
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(v vVar, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        vVar.r(event);
        if (event == Lifecycle.Event.ON_DESTROY) {
            y.a.a(vVar, (Throwable) null, 1, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final J invokeSuspend$lambda$1(Lifecycle lifecycle, LifecycleEventObserver lifecycleEventObserver) {
        lifecycle.removeObserver(lifecycleEventObserver);
        return J.f19942a;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        LifecycleKt$eventFlow$1 lifecycleKt$eventFlow$1 = new LifecycleKt$eventFlow$1(this.$this_eventFlow, eVar);
        lifecycleKt$eventFlow$1.L$0 = obj;
        return lifecycleKt$eventFlow$1;
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            v vVar = (v) this.L$0;
            l lVar = new l(vVar);
            this.$this_eventFlow.addObserver(lVar);
            m mVar = new m(this.$this_eventFlow, lVar);
            this.label = 1;
            if (t.a(vVar, mVar, this) == f5) {
                return f5;
            }
        } else if (i5 == 1) {
            u.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return J.f19942a;
    }

    public final Object invoke(v vVar, C2308e eVar) {
        return ((LifecycleKt$eventFlow$1) create(vVar, eVar)).invokeSuspend(J.f19942a);
    }
}
