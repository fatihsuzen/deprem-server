package androidx.privacysandbox.ads.adservices.topics;

import android.adservices.topics.GetTopicsRequest;
import android.adservices.topics.GetTopicsResponse;
import android.adservices.topics.TopicsManager;
import android.annotation.SuppressLint;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import androidx.core.os.OutcomeReceiverKt;
import androidx.privacysandbox.ads.adservices.adid.i;
import b3.C2308e;
import c3.C2316b;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.t;
import w3.C2886n;

@RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
@SuppressLint({"NewApi"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class TopicsManagerImplCommon extends TopicsManager {
    /* access modifiers changed from: private */
    public final TopicsManager mTopicsManager;

    public TopicsManagerImplCommon(TopicsManager topicsManager) {
        t.e(topicsManager, "mTopicsManager");
        this.mTopicsManager = topicsManager;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @androidx.annotation.RequiresPermission("android.permission.ACCESS_ADSERVICES_TOPICS")
    @androidx.annotation.DoNotInline
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object getTopics$suspendImpl(androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon r4, androidx.privacysandbox.ads.adservices.topics.GetTopicsRequest r5, b3.C2308e r6) {
        /*
            boolean r0 = r6 instanceof androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon$getTopics$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon$getTopics$1 r0 = (androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon$getTopics$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon$getTopics$1 r0 = new androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon$getTopics$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r4 = r0.L$0
            androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon r4 = (androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon) r4
            W2.u.b(r6)
            goto L_0x0047
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            W2.u.b(r6)
            android.adservices.topics.GetTopicsRequest r5 = r4.convertRequest$ads_adservices_release(r5)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r4.getTopicsAsyncInternal(r5, r0)
            if (r6 != r1) goto L_0x0047
            return r1
        L_0x0047:
            android.adservices.topics.GetTopicsResponse r5 = androidx.privacysandbox.ads.adservices.topics.r.a(r6)
            androidx.privacysandbox.ads.adservices.topics.GetTopicsResponse r4 = r4.convertResponse$ads_adservices_release(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon.getTopics$suspendImpl(androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon, androidx.privacysandbox.ads.adservices.topics.GetTopicsRequest, b3.e):java.lang.Object");
    }

    /* access modifiers changed from: private */
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_TOPICS")
    public final Object getTopicsAsyncInternal(GetTopicsRequest getTopicsRequest, C2308e eVar) {
        C2886n nVar = new C2886n(C2316b.c(eVar), 1);
        nVar.D();
        this.mTopicsManager.getTopics(getTopicsRequest, new i(), OutcomeReceiverKt.asOutcomeReceiver(nVar));
        Object x4 = nVar.x();
        if (x4 == C2316b.f()) {
            h.c(eVar);
        }
        return x4;
    }

    public GetTopicsRequest convertRequest$ads_adservices_release(GetTopicsRequest getTopicsRequest) {
        t.e(getTopicsRequest, "request");
        return GetTopicsRequestHelper.INSTANCE.convertRequestWithoutRecordObservation$ads_adservices_release(getTopicsRequest);
    }

    public GetTopicsResponse convertResponse$ads_adservices_release(GetTopicsResponse getTopicsResponse) {
        t.e(getTopicsResponse, "response");
        return GetTopicsResponseHelper.INSTANCE.convertResponse$ads_adservices_release(getTopicsResponse);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_TOPICS")
    @DoNotInline
    public Object getTopics(GetTopicsRequest getTopicsRequest, C2308e eVar) {
        return getTopics$suspendImpl(this, getTopicsRequest, eVar);
    }
}
