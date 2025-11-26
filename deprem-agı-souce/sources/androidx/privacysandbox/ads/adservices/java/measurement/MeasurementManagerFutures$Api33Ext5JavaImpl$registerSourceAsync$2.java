package androidx.privacysandbox.ads.adservices.java.measurement;

import W2.J;
import W2.u;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import androidx.privacysandbox.ads.adservices.measurement.MeasurementManager;
import androidx.privacysandbox.ads.adservices.measurement.SourceRegistrationRequest;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

@f(c = "androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$2", f = "MeasurementManagerFutures.kt", l = {154}, m = "invokeSuspend")
final class MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$2 extends l implements p {
    final /* synthetic */ SourceRegistrationRequest $request;
    int label;
    final /* synthetic */ MeasurementManagerFutures.Api33Ext5JavaImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$2(MeasurementManagerFutures.Api33Ext5JavaImpl api33Ext5JavaImpl, SourceRegistrationRequest sourceRegistrationRequest, C2308e eVar) {
        super(2, eVar);
        this.this$0 = api33Ext5JavaImpl;
        this.$request = sourceRegistrationRequest;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$2(this.this$0, this.$request, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            MeasurementManager access$getMMeasurementManager$p = this.this$0.mMeasurementManager;
            SourceRegistrationRequest sourceRegistrationRequest = this.$request;
            this.label = 1;
            if (access$getMMeasurementManager$p.registerSource(sourceRegistrationRequest, this) == f5) {
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
        return ((MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$2) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
