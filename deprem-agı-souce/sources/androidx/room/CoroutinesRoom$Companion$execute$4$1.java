package androidx.room;

import W2.J;
import android.os.CancellationSignal;
import java.util.concurrent.CancellationException;
import k3.l;
import w3.C2908y0;

final class CoroutinesRoom$Companion$execute$4$1 implements l {
    final /* synthetic */ CancellationSignal $cancellationSignal;
    final /* synthetic */ C2908y0 $job;

    CoroutinesRoom$Companion$execute$4$1(CancellationSignal cancellationSignal, C2908y0 y0Var) {
        this.$cancellationSignal = cancellationSignal;
        this.$job = y0Var;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return J.f19942a;
    }

    public final void invoke(Throwable th) {
        CancellationSignal cancellationSignal = this.$cancellationSignal;
        if (cancellationSignal != null) {
            cancellationSignal.cancel();
        }
        C2908y0.a.a(this.$job, (CancellationException) null, 1, (Object) null);
    }
}
