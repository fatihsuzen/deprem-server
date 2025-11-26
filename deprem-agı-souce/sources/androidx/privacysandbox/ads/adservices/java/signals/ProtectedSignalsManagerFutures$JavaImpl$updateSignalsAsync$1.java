package androidx.privacysandbox.ads.adservices.java.signals;

import W2.J;
import W2.u;
import androidx.privacysandbox.ads.adservices.java.signals.ProtectedSignalsManagerFutures;
import androidx.privacysandbox.ads.adservices.signals.ProtectedSignalsManager;
import androidx.privacysandbox.ads.adservices.signals.UpdateSignalsRequest;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import w3.M;

@f(c = "androidx.privacysandbox.ads.adservices.java.signals.ProtectedSignalsManagerFutures$JavaImpl$updateSignalsAsync$1", f = "ProtectedSignalsManagerFutures.kt", l = {111}, m = "invokeSuspend")
final class ProtectedSignalsManagerFutures$JavaImpl$updateSignalsAsync$1 extends l implements p {
    final /* synthetic */ UpdateSignalsRequest $request;
    int label;
    final /* synthetic */ ProtectedSignalsManagerFutures.JavaImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProtectedSignalsManagerFutures$JavaImpl$updateSignalsAsync$1(ProtectedSignalsManagerFutures.JavaImpl javaImpl, UpdateSignalsRequest updateSignalsRequest, C2308e eVar) {
        super(2, eVar);
        this.this$0 = javaImpl;
        this.$request = updateSignalsRequest;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new ProtectedSignalsManagerFutures$JavaImpl$updateSignalsAsync$1(this.this$0, this.$request, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            ProtectedSignalsManager access$getMProtectedSignalsManager$p = this.this$0.mProtectedSignalsManager;
            t.b(access$getMProtectedSignalsManager$p);
            UpdateSignalsRequest updateSignalsRequest = this.$request;
            this.label = 1;
            if (access$getMProtectedSignalsManager$p.updateSignals(updateSignalsRequest, this) == f5) {
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
        return ((ProtectedSignalsManagerFutures$JavaImpl$updateSignalsAsync$1) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
