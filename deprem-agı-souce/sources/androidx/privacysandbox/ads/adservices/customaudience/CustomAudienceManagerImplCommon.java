package androidx.privacysandbox.ads.adservices.customaudience;

import W2.J;
import android.adservices.common.AdData;
import android.adservices.common.AdSelectionSignals;
import android.adservices.customaudience.CustomAudience;
import android.adservices.customaudience.CustomAudienceManager;
import android.adservices.customaudience.JoinCustomAudienceRequest;
import android.adservices.customaudience.LeaveCustomAudienceRequest;
import android.adservices.customaudience.TrustedBiddingData;
import android.annotation.SuppressLint;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import androidx.core.os.OutcomeReceiverKt;
import androidx.privacysandbox.ads.adservices.adid.i;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import b3.C2308e;
import c3.C2316b;
import j$.time.TimeConversions;
import java.util.ArrayList;
import java.util.List;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import w3.C2886n;

@SuppressLint({"NewApi", "ClassVerificationFailure"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
@RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
public class CustomAudienceManagerImplCommon extends CustomAudienceManager {
    private final CustomAudienceManager customAudienceManager;

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 10), @RequiresExtension(extension = 31, version = 10)})
    private static final class Ext10Impl {
        public static final Companion Companion = new Companion((C2633k) null);

        public static final class Companion {
            public /* synthetic */ Companion(C2633k kVar) {
                this();
            }

            @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
            @DoNotInline
            public final Object fetchAndJoinCustomAudience(CustomAudienceManager customAudienceManager, FetchAndJoinCustomAudienceRequest fetchAndJoinCustomAudienceRequest, C2308e eVar) {
                C2886n nVar = new C2886n(C2316b.c(eVar), 1);
                nVar.D();
                customAudienceManager.fetchAndJoinCustomAudience(fetchAndJoinCustomAudienceRequest.convertToAdServices$ads_adservices_release(), new i(), OutcomeReceiverKt.asOutcomeReceiver(nVar));
                Object x4 = nVar.x();
                if (x4 == C2316b.f()) {
                    h.c(eVar);
                }
                if (x4 == C2316b.f()) {
                    return x4;
                }
                return J.f19942a;
            }

            private Companion() {
            }
        }

        private Ext10Impl() {
        }
    }

    public CustomAudienceManagerImplCommon(CustomAudienceManager customAudienceManager2) {
        t.e(customAudienceManager2, "customAudienceManager");
        this.customAudienceManager = customAudienceManager2;
    }

    private final List<AdData> convertAds(List<androidx.privacysandbox.ads.adservices.common.AdData> list) {
        ArrayList arrayList = new ArrayList();
        for (androidx.privacysandbox.ads.adservices.common.AdData convertToAdServices$ads_adservices_release : list) {
            arrayList.add(convertToAdServices$ads_adservices_release.convertToAdServices$ads_adservices_release());
        }
        return arrayList;
    }

    private final CustomAudience convertCustomAudience(CustomAudience customAudience) {
        AdSelectionSignals adSelectionSignals;
        CustomAudience.Builder a5 = s.a().setActivationTime(TimeConversions.convert(customAudience.getActivationTime())).setAds(convertAds(customAudience.getAds())).setBiddingLogicUri(customAudience.getBiddingLogicUri()).setBuyer(customAudience.getBuyer().convertToAdServices$ads_adservices_release()).setDailyUpdateUri(customAudience.getDailyUpdateUri()).setExpirationTime(TimeConversions.convert(customAudience.getExpirationTime())).setName(customAudience.getName()).setTrustedBiddingData(convertTrustedSignals(customAudience.getTrustedBiddingSignals()));
        androidx.privacysandbox.ads.adservices.common.AdSelectionSignals userBiddingSignals = customAudience.getUserBiddingSignals();
        if (userBiddingSignals != null) {
            adSelectionSignals = userBiddingSignals.convertToAdServices$ads_adservices_release();
        } else {
            adSelectionSignals = null;
        }
        CustomAudience a6 = a5.setUserBiddingSignals(adSelectionSignals).build();
        t.d(a6, "Builder()\n            .s…s())\n            .build()");
        return a6;
    }

    /* access modifiers changed from: private */
    public final JoinCustomAudienceRequest convertJoinRequest(JoinCustomAudienceRequest joinCustomAudienceRequest) {
        JoinCustomAudienceRequest a5 = r.a().setCustomAudience(convertCustomAudience(joinCustomAudienceRequest.getCustomAudience())).build();
        t.d(a5, "Builder()\n            .s…ce))\n            .build()");
        return a5;
    }

    /* access modifiers changed from: private */
    public final LeaveCustomAudienceRequest convertLeaveRequest(LeaveCustomAudienceRequest leaveCustomAudienceRequest) {
        LeaveCustomAudienceRequest a5 = p.a().setBuyer(leaveCustomAudienceRequest.getBuyer().convertToAdServices$ads_adservices_release()).setName(leaveCustomAudienceRequest.getName()).build();
        t.d(a5, "Builder()\n            .s…ame)\n            .build()");
        return a5;
    }

    private final TrustedBiddingData convertTrustedSignals(TrustedBiddingData trustedBiddingData) {
        if (trustedBiddingData == null) {
            return null;
        }
        return q.a().setTrustedBiddingKeys(trustedBiddingData.getTrustedBiddingKeys()).setTrustedBiddingUri(trustedBiddingData.getTrustedBiddingUri()).build();
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    static /* synthetic */ Object fetchAndJoinCustomAudience$suspendImpl(CustomAudienceManagerImplCommon customAudienceManagerImplCommon, FetchAndJoinCustomAudienceRequest fetchAndJoinCustomAudienceRequest, C2308e eVar) {
        AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
        if (adServicesInfo.adServicesVersion() >= 10 || adServicesInfo.extServicesVersionS() >= 10) {
            Object fetchAndJoinCustomAudience = Ext10Impl.Companion.fetchAndJoinCustomAudience(customAudienceManagerImplCommon.customAudienceManager, fetchAndJoinCustomAudienceRequest, eVar);
            if (fetchAndJoinCustomAudience == C2316b.f()) {
                return fetchAndJoinCustomAudience;
            }
            return J.f19942a;
        }
        throw new UnsupportedOperationException("API is not available. Min version is API 31 ext 10");
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    static /* synthetic */ Object joinCustomAudience$suspendImpl(CustomAudienceManagerImplCommon customAudienceManagerImplCommon, JoinCustomAudienceRequest joinCustomAudienceRequest, C2308e eVar) {
        C2886n nVar = new C2886n(C2316b.c(eVar), 1);
        nVar.D();
        customAudienceManagerImplCommon.getCustomAudienceManager().joinCustomAudience(customAudienceManagerImplCommon.convertJoinRequest(joinCustomAudienceRequest), new i(), OutcomeReceiverKt.asOutcomeReceiver(nVar));
        Object x4 = nVar.x();
        if (x4 == C2316b.f()) {
            h.c(eVar);
        }
        if (x4 == C2316b.f()) {
            return x4;
        }
        return J.f19942a;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    static /* synthetic */ Object leaveCustomAudience$suspendImpl(CustomAudienceManagerImplCommon customAudienceManagerImplCommon, LeaveCustomAudienceRequest leaveCustomAudienceRequest, C2308e eVar) {
        C2886n nVar = new C2886n(C2316b.c(eVar), 1);
        nVar.D();
        customAudienceManagerImplCommon.getCustomAudienceManager().leaveCustomAudience(customAudienceManagerImplCommon.convertLeaveRequest(leaveCustomAudienceRequest), new i(), OutcomeReceiverKt.asOutcomeReceiver(nVar));
        Object x4 = nVar.x();
        if (x4 == C2316b.f()) {
            h.c(eVar);
        }
        if (x4 == C2316b.f()) {
            return x4;
        }
        return J.f19942a;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    public Object fetchAndJoinCustomAudience(FetchAndJoinCustomAudienceRequest fetchAndJoinCustomAudienceRequest, C2308e eVar) {
        return fetchAndJoinCustomAudience$suspendImpl(this, fetchAndJoinCustomAudienceRequest, eVar);
    }

    /* access modifiers changed from: protected */
    public final CustomAudienceManager getCustomAudienceManager() {
        return this.customAudienceManager;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    public Object joinCustomAudience(JoinCustomAudienceRequest joinCustomAudienceRequest, C2308e eVar) {
        return joinCustomAudience$suspendImpl(this, joinCustomAudienceRequest, eVar);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    public Object leaveCustomAudience(LeaveCustomAudienceRequest leaveCustomAudienceRequest, C2308e eVar) {
        return leaveCustomAudience$suspendImpl(this, leaveCustomAudienceRequest, eVar);
    }
}
