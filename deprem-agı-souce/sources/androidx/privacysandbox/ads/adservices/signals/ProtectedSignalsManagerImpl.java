package androidx.privacysandbox.ads.adservices.signals;

import W2.J;
import android.adservices.signals.ProtectedSignalsManager;
import android.adservices.signals.UpdateSignalsRequest;
import android.annotation.SuppressLint;
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

@RequiresExtension(extension = 1000000, version = 12)
@SuppressLint({"NewApi", "ClassVerificationFailure"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
@ExperimentalFeatures.Ext12OptIn
public class ProtectedSignalsManagerImpl extends ProtectedSignalsManager {
    /* access modifiers changed from: private */
    public final ProtectedSignalsManager protectedSignalsManager;

    public ProtectedSignalsManagerImpl(ProtectedSignalsManager protectedSignalsManager2) {
        t.e(protectedSignalsManager2, "protectedSignalsManager");
        this.protectedSignalsManager = protectedSignalsManager2;
    }

    /* access modifiers changed from: private */
    public final UpdateSignalsRequest convertUpdateRequest(UpdateSignalsRequest updateSignalsRequest) {
        e.a();
        UpdateSignalsRequest a5 = d.a(updateSignalsRequest.getUpdateUri()).build();
        t.d(a5, "Builder(request.updateUri).build()");
        return a5;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_PROTECTED_SIGNALS")
    @DoNotInline
    static /* synthetic */ Object updateSignals$suspendImpl(ProtectedSignalsManagerImpl protectedSignalsManagerImpl, UpdateSignalsRequest updateSignalsRequest, C2308e eVar) {
        C2886n nVar = new C2886n(C2316b.c(eVar), 1);
        nVar.D();
        protectedSignalsManagerImpl.protectedSignalsManager.updateSignals(protectedSignalsManagerImpl.convertUpdateRequest(updateSignalsRequest), new i(), OutcomeReceiverKt.asOutcomeReceiver(nVar));
        Object x4 = nVar.x();
        if (x4 == C2316b.f()) {
            h.c(eVar);
        }
        if (x4 == C2316b.f()) {
            return x4;
        }
        return J.f19942a;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_PROTECTED_SIGNALS")
    @DoNotInline
    public Object updateSignals(UpdateSignalsRequest updateSignalsRequest, C2308e eVar) {
        return updateSignals$suspendImpl(this, updateSignalsRequest, eVar);
    }
}
