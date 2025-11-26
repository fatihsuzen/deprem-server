package androidx.privacysandbox.ads.adservices.measurement;

import W2.J;
import android.adservices.measurement.MeasurementManager;
import android.annotation.SuppressLint;
import android.net.Uri;
import android.view.InputEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import androidx.core.os.OutcomeReceiverKt;
import androidx.privacysandbox.ads.adservices.adid.i;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import b3.C2308e;
import c3.C2316b;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.t;
import w3.C2886n;
import w3.N;

@RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 5), @RequiresExtension(extension = 31, version = 9)})
@SuppressLint({"NewApi", "ClassVerificationFailure"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class MeasurementManagerImplCommon extends MeasurementManager {
    private final MeasurementManager mMeasurementManager;

    public MeasurementManagerImplCommon(MeasurementManager measurementManager) {
        t.e(measurementManager, "mMeasurementManager");
        this.mMeasurementManager = measurementManager;
    }

    @DoNotInline
    static /* synthetic */ Object deleteRegistrations$suspendImpl(MeasurementManagerImplCommon measurementManagerImplCommon, DeletionRequest deletionRequest, C2308e eVar) {
        C2886n nVar = new C2886n(C2316b.c(eVar), 1);
        nVar.D();
        measurementManagerImplCommon.getMMeasurementManager().deleteRegistrations(deletionRequest.convertToAdServices$ads_adservices_release(), new i(), OutcomeReceiverKt.asOutcomeReceiver(nVar));
        Object x4 = nVar.x();
        if (x4 == C2316b.f()) {
            h.c(eVar);
        }
        if (x4 == C2316b.f()) {
            return x4;
        }
        return J.f19942a;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    static /* synthetic */ Object getMeasurementApiStatus$suspendImpl(MeasurementManagerImplCommon measurementManagerImplCommon, C2308e eVar) {
        C2886n nVar = new C2886n(C2316b.c(eVar), 1);
        nVar.D();
        measurementManagerImplCommon.getMMeasurementManager().getMeasurementApiStatus(new i(), OutcomeReceiverKt.asOutcomeReceiver(nVar));
        Object x4 = nVar.x();
        if (x4 == C2316b.f()) {
            h.c(eVar);
        }
        return x4;
    }

    @DoNotInline
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @ExperimentalFeatures.RegisterSourceOptIn
    static /* synthetic */ Object registerSource$suspendImpl(MeasurementManagerImplCommon measurementManagerImplCommon, SourceRegistrationRequest sourceRegistrationRequest, C2308e eVar) {
        Object d5 = N.d(new MeasurementManagerImplCommon$registerSource$4(sourceRegistrationRequest, measurementManagerImplCommon, (C2308e) null), eVar);
        return d5 == C2316b.f() ? d5 : J.f19942a;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    static /* synthetic */ Object registerTrigger$suspendImpl(MeasurementManagerImplCommon measurementManagerImplCommon, Uri uri, C2308e eVar) {
        C2886n nVar = new C2886n(C2316b.c(eVar), 1);
        nVar.D();
        measurementManagerImplCommon.getMMeasurementManager().registerTrigger(uri, new i(), OutcomeReceiverKt.asOutcomeReceiver(nVar));
        Object x4 = nVar.x();
        if (x4 == C2316b.f()) {
            h.c(eVar);
        }
        if (x4 == C2316b.f()) {
            return x4;
        }
        return J.f19942a;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    static /* synthetic */ Object registerWebSource$suspendImpl(MeasurementManagerImplCommon measurementManagerImplCommon, WebSourceRegistrationRequest webSourceRegistrationRequest, C2308e eVar) {
        C2886n nVar = new C2886n(C2316b.c(eVar), 1);
        nVar.D();
        measurementManagerImplCommon.getMMeasurementManager().registerWebSource(webSourceRegistrationRequest.convertToAdServices$ads_adservices_release(), new i(), OutcomeReceiverKt.asOutcomeReceiver(nVar));
        Object x4 = nVar.x();
        if (x4 == C2316b.f()) {
            h.c(eVar);
        }
        if (x4 == C2316b.f()) {
            return x4;
        }
        return J.f19942a;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    static /* synthetic */ Object registerWebTrigger$suspendImpl(MeasurementManagerImplCommon measurementManagerImplCommon, WebTriggerRegistrationRequest webTriggerRegistrationRequest, C2308e eVar) {
        C2886n nVar = new C2886n(C2316b.c(eVar), 1);
        nVar.D();
        measurementManagerImplCommon.getMMeasurementManager().registerWebTrigger(webTriggerRegistrationRequest.convertToAdServices$ads_adservices_release(), new i(), OutcomeReceiverKt.asOutcomeReceiver(nVar));
        Object x4 = nVar.x();
        if (x4 == C2316b.f()) {
            h.c(eVar);
        }
        if (x4 == C2316b.f()) {
            return x4;
        }
        return J.f19942a;
    }

    @DoNotInline
    public Object deleteRegistrations(DeletionRequest deletionRequest, C2308e eVar) {
        return deleteRegistrations$suspendImpl(this, deletionRequest, eVar);
    }

    /* access modifiers changed from: protected */
    public final MeasurementManager getMMeasurementManager() {
        return this.mMeasurementManager;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    public Object getMeasurementApiStatus(C2308e eVar) {
        return getMeasurementApiStatus$suspendImpl(this, eVar);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    public Object registerSource(Uri uri, InputEvent inputEvent, C2308e eVar) {
        return registerSource$suspendImpl(this, uri, inputEvent, eVar);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    public Object registerTrigger(Uri uri, C2308e eVar) {
        return registerTrigger$suspendImpl(this, uri, eVar);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    public Object registerWebSource(WebSourceRegistrationRequest webSourceRegistrationRequest, C2308e eVar) {
        return registerWebSource$suspendImpl(this, webSourceRegistrationRequest, eVar);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    public Object registerWebTrigger(WebTriggerRegistrationRequest webTriggerRegistrationRequest, C2308e eVar) {
        return registerWebTrigger$suspendImpl(this, webTriggerRegistrationRequest, eVar);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    static /* synthetic */ Object registerSource$suspendImpl(MeasurementManagerImplCommon measurementManagerImplCommon, Uri uri, InputEvent inputEvent, C2308e eVar) {
        C2886n nVar = new C2886n(C2316b.c(eVar), 1);
        nVar.D();
        measurementManagerImplCommon.getMMeasurementManager().registerSource(uri, inputEvent, new i(), OutcomeReceiverKt.asOutcomeReceiver(nVar));
        Object x4 = nVar.x();
        if (x4 == C2316b.f()) {
            h.c(eVar);
        }
        if (x4 == C2316b.f()) {
            return x4;
        }
        return J.f19942a;
    }

    @DoNotInline
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @ExperimentalFeatures.RegisterSourceOptIn
    public Object registerSource(SourceRegistrationRequest sourceRegistrationRequest, C2308e eVar) {
        return registerSource$suspendImpl(this, sourceRegistrationRequest, eVar);
    }
}
