package androidx.privacysandbox.ads.adservices.measurement;

import W2.J;
import W2.u;
import android.net.Uri;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.C2908y0;
import w3.M;
import w3.O;

@f(c = "androidx.privacysandbox.ads.adservices.measurement.MeasurementManagerImplCommon$registerSource$4", f = "MeasurementManagerImplCommon.kt", l = {}, m = "invokeSuspend")
final class MeasurementManagerImplCommon$registerSource$4 extends l implements p {
    final /* synthetic */ SourceRegistrationRequest $request;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MeasurementManagerImplCommon this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MeasurementManagerImplCommon$registerSource$4(SourceRegistrationRequest sourceRegistrationRequest, MeasurementManagerImplCommon measurementManagerImplCommon, C2308e eVar) {
        super(2, eVar);
        this.$request = sourceRegistrationRequest;
        this.this$0 = measurementManagerImplCommon;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        MeasurementManagerImplCommon$registerSource$4 measurementManagerImplCommon$registerSource$4 = new MeasurementManagerImplCommon$registerSource$4(this.$request, this.this$0, eVar);
        measurementManagerImplCommon$registerSource$4.L$0 = obj;
        return measurementManagerImplCommon$registerSource$4;
    }

    public final Object invokeSuspend(Object obj) {
        C2316b.f();
        if (this.label == 0) {
            u.b(obj);
            M m5 = (M) this.L$0;
            MeasurementManagerImplCommon measurementManagerImplCommon = this.this$0;
            SourceRegistrationRequest sourceRegistrationRequest = this.$request;
            for (Uri measurementManagerImplCommon$registerSource$4$1$1 : this.$request.getRegistrationUris()) {
                C2908y0 unused = C2876i.d(m5, (C2312i) null, (O) null, new MeasurementManagerImplCommon$registerSource$4$1$1(measurementManagerImplCommon, measurementManagerImplCommon$registerSource$4$1$1, sourceRegistrationRequest, (C2308e) null), 3, (Object) null);
            }
            return J.f19942a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((MeasurementManagerImplCommon$registerSource$4) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
