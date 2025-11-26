package androidx.privacysandbox.ads.adservices.java.internal;

import W2.J;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.CancellationException;
import k3.l;
import kotlin.jvm.internal.u;
import w3.U;

final class CoroutineAdapterKt$asListenableFuture$1$1 extends u implements l {
    final /* synthetic */ CallbackToFutureAdapter.Completer<T> $completer;
    final /* synthetic */ U $this_asListenableFuture;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoroutineAdapterKt$asListenableFuture$1$1(CallbackToFutureAdapter.Completer<T> completer, U u5) {
        super(1);
        this.$completer = completer;
        this.$this_asListenableFuture = u5;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return J.f19942a;
    }

    public final void invoke(Throwable th) {
        if (th == null) {
            this.$completer.set(this.$this_asListenableFuture.d());
        } else if (th instanceof CancellationException) {
            this.$completer.setCancelled();
        } else {
            this.$completer.setException(th);
        }
    }
}
