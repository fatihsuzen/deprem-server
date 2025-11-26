package androidx.room;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

@f(c = "androidx.room.InvalidationTracker$addObserver$1", f = "InvalidationTracker.android.kt", l = {253}, m = "invokeSuspend")
final class InvalidationTracker$addObserver$1 extends l implements p {
    int label;
    final /* synthetic */ InvalidationTracker this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InvalidationTracker$addObserver$1(InvalidationTracker invalidationTracker, C2308e eVar) {
        super(2, eVar);
        this.this$0 = invalidationTracker;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new InvalidationTracker$addObserver$1(this.this$0, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            TriggerBasedInvalidationTracker access$getImplementation$p = this.this$0.implementation;
            this.label = 1;
            if (access$getImplementation$p.syncTriggers$room_runtime_release(this) == f5) {
                return f5;
            }
        } else if (i5 == 1) {
            u.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return J.f19942a;
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((InvalidationTracker$addObserver$1) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
