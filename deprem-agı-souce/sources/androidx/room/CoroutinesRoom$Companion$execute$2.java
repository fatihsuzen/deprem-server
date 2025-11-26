package androidx.room;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import java.util.concurrent.Callable;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

@f(c = "androidx.room.CoroutinesRoom$Companion$execute$2", f = "CoroutinesRoom.android.kt", l = {}, m = "invokeSuspend")
final class CoroutinesRoom$Companion$execute$2 extends l implements p {
    final /* synthetic */ Callable<R> $callable;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoroutinesRoom$Companion$execute$2(Callable<R> callable, C2308e eVar) {
        super(2, eVar);
        this.$callable = callable;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new CoroutinesRoom$Companion$execute$2(this.$callable, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        C2316b.f();
        if (this.label == 0) {
            u.b(obj);
            return this.$callable.call();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((CoroutinesRoom$Companion$execute$2) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
