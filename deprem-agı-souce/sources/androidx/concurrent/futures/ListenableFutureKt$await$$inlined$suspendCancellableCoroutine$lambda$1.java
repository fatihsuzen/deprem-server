package androidx.concurrent.futures;

import W2.J;
import k3.l;
import kotlin.jvm.internal.u;
import n0.C1722d;

final class ListenableFutureKt$await$$inlined$suspendCancellableCoroutine$lambda$1 extends u implements l {
    final /* synthetic */ C1722d $this_await$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ListenableFutureKt$await$$inlined$suspendCancellableCoroutine$lambda$1(C1722d dVar) {
        super(1);
        this.$this_await$inlined = dVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return J.f19942a;
    }

    public final void invoke(Throwable th) {
        this.$this_await$inlined.cancel(false);
    }
}
