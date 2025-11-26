package androidx.room;

import W2.J;
import W2.t;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import java.util.concurrent.Callable;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.C2882l;
import w3.M;

@f(c = "androidx.room.CoroutinesRoom$Companion$execute$4$job$1", f = "CoroutinesRoom.android.kt", l = {}, m = "invokeSuspend")
final class CoroutinesRoom$Companion$execute$4$job$1 extends l implements p {
    final /* synthetic */ Callable<R> $callable;
    final /* synthetic */ C2882l $continuation;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoroutinesRoom$Companion$execute$4$job$1(Callable<R> callable, C2882l lVar, C2308e eVar) {
        super(2, eVar);
        this.$callable = callable;
        this.$continuation = lVar;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new CoroutinesRoom$Companion$execute$4$job$1(this.$callable, this.$continuation, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        C2316b.f();
        if (this.label == 0) {
            u.b(obj);
            try {
                this.$continuation.resumeWith(t.b(this.$callable.call()));
            } catch (Throwable th) {
                C2882l lVar = this.$continuation;
                t.a aVar = t.f19966b;
                lVar.resumeWith(t.b(u.a(th)));
            }
            return J.f19942a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((CoroutinesRoom$Companion$execute$4$job$1) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
