package androidx.privacysandbox.ads.adservices.appsetid;

import android.adservices.appsetid.AppSetId;
import android.adservices.appsetid.AppSetIdManager;
import android.annotation.SuppressLint;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.core.os.OutcomeReceiverKt;
import androidx.privacysandbox.ads.adservices.adid.i;
import b3.C2308e;
import c3.C2316b;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.t;
import w3.C2886n;

@RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
@SuppressLint({"ClassVerificationFailure", "NewApi"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class AppSetIdManagerImplCommon extends AppSetIdManager {
    /* access modifiers changed from: private */
    public final AppSetIdManager mAppSetIdManager;

    public AppSetIdManagerImplCommon(AppSetIdManager appSetIdManager) {
        t.e(appSetIdManager, "mAppSetIdManager");
        this.mAppSetIdManager = appSetIdManager;
    }

    private final AppSetId convertResponse(AppSetId appSetId) {
        if (appSetId.getScope() == 1) {
            String a5 = appSetId.getId();
            t.d(a5, "response.id");
            return new AppSetId(a5, 1);
        }
        String a6 = appSetId.getId();
        t.d(a6, "response.id");
        return new AppSetId(a6, 2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @androidx.annotation.DoNotInline
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object getAppSetId$suspendImpl(androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon r4, b3.C2308e r5) {
        /*
            boolean r0 = r5 instanceof androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon$getAppSetId$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon$getAppSetId$1 r0 = (androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon$getAppSetId$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon$getAppSetId$1 r0 = new androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon$getAppSetId$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r4 = r0.L$0
            androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon r4 = (androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon) r4
            W2.u.b(r5)
            goto L_0x0043
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            W2.u.b(r5)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r4.getAppSetIdAsyncInternal(r0)
            if (r5 != r1) goto L_0x0043
            return r1
        L_0x0043:
            android.adservices.appsetid.AppSetId r5 = androidx.privacysandbox.ads.adservices.appsetid.e.a(r5)
            androidx.privacysandbox.ads.adservices.appsetid.AppSetId r4 = r4.convertResponse(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon.getAppSetId$suspendImpl(androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon, b3.e):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object getAppSetIdAsyncInternal(C2308e eVar) {
        C2886n nVar = new C2886n(C2316b.c(eVar), 1);
        nVar.D();
        this.mAppSetIdManager.getAppSetId(new i(), OutcomeReceiverKt.asOutcomeReceiver(nVar));
        Object x4 = nVar.x();
        if (x4 == C2316b.f()) {
            h.c(eVar);
        }
        return x4;
    }

    @DoNotInline
    public Object getAppSetId(C2308e eVar) {
        return getAppSetId$suspendImpl(this, eVar);
    }
}
