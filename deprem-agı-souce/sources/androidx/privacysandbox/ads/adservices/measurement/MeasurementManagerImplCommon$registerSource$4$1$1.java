package androidx.privacysandbox.ads.adservices.measurement;

import W2.J;
import W2.u;
import android.net.Uri;
import androidx.core.os.OutcomeReceiverKt;
import androidx.privacysandbox.ads.adservices.adid.i;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.h;
import kotlin.coroutines.jvm.internal.l;
import w3.C2886n;
import w3.M;

@f(c = "androidx.privacysandbox.ads.adservices.measurement.MeasurementManagerImplCommon$registerSource$4$1$1", f = "MeasurementManagerImplCommon.kt", l = {131}, m = "invokeSuspend")
final class MeasurementManagerImplCommon$registerSource$4$1$1 extends l implements p {
    final /* synthetic */ SourceRegistrationRequest $request;
    final /* synthetic */ Uri $uri;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ MeasurementManagerImplCommon this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MeasurementManagerImplCommon$registerSource$4$1$1(MeasurementManagerImplCommon measurementManagerImplCommon, Uri uri, SourceRegistrationRequest sourceRegistrationRequest, C2308e eVar) {
        super(2, eVar);
        this.this$0 = measurementManagerImplCommon;
        this.$uri = uri;
        this.$request = sourceRegistrationRequest;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new MeasurementManagerImplCommon$registerSource$4$1$1(this.this$0, this.$uri, this.$request, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            MeasurementManagerImplCommon measurementManagerImplCommon = this.this$0;
            Uri uri = this.$uri;
            SourceRegistrationRequest sourceRegistrationRequest = this.$request;
            this.L$0 = measurementManagerImplCommon;
            this.L$1 = uri;
            this.L$2 = sourceRegistrationRequest;
            this.label = 1;
            C2886n nVar = new C2886n(C2316b.c(this), 1);
            nVar.D();
            measurementManagerImplCommon.getMMeasurementManager().registerSource(uri, sourceRegistrationRequest.getInputEvent(), new i(), OutcomeReceiverKt.asOutcomeReceiver(nVar));
            Object x4 = nVar.x();
            if (x4 == C2316b.f()) {
                h.c(this);
            }
            if (x4 == f5) {
                return f5;
            }
        } else if (i5 == 1) {
            SourceRegistrationRequest sourceRegistrationRequest2 = (SourceRegistrationRequest) this.L$2;
            Uri uri2 = (Uri) this.L$1;
            MeasurementManagerImplCommon measurementManagerImplCommon2 = (MeasurementManagerImplCommon) this.L$0;
            u.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return J.f19942a;
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((MeasurementManagerImplCommon$registerSource$4$1$1) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
