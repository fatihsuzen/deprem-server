package androidx.work;

import W2.J;
import W2.u;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import b3.C2308e;
import c3.C2316b;
import java.util.concurrent.CancellationException;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

@f(c = "androidx.work.ListenableFutureKt$launchFuture$1$2", f = "ListenableFuture.kt", l = {42}, m = "invokeSuspend")
final class ListenableFutureKt$launchFuture$1$2 extends l implements p {
    final /* synthetic */ p $block;
    final /* synthetic */ CallbackToFutureAdapter.Completer<T> $completer;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ListenableFutureKt$launchFuture$1$2(p pVar, CallbackToFutureAdapter.Completer<T> completer, C2308e eVar) {
        super(2, eVar);
        this.$block = pVar;
        this.$completer = completer;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        ListenableFutureKt$launchFuture$1$2 listenableFutureKt$launchFuture$1$2 = new ListenableFutureKt$launchFuture$1$2(this.$block, this.$completer, eVar);
        listenableFutureKt$launchFuture$1$2.L$0 = obj;
        return listenableFutureKt$launchFuture$1$2;
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            M m5 = (M) this.L$0;
            p pVar = this.$block;
            this.label = 1;
            obj = pVar.invoke(m5, this);
            if (obj == f5) {
                return f5;
            }
        } else if (i5 == 1) {
            try {
                u.b(obj);
            } catch (CancellationException unused) {
                this.$completer.setCancelled();
            } catch (Throwable th) {
                this.$completer.setException(th);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$completer.set(obj);
        return J.f19942a;
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((ListenableFutureKt$launchFuture$1$2) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
