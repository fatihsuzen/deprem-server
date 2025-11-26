package androidx.privacysandbox.ads.adservices.adselection;

import W2.J;
import android.adservices.adselection.AdSelectionConfig;
import android.adservices.adselection.AdSelectionManager;
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
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import w3.C2886n;

@SuppressLint({"NewApi", "ClassVerificationFailure"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
@RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
public class AdSelectionManagerImplCommon extends AdSelectionManager {
    private final AdSelectionManager mAdSelectionManager;

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 10), @RequiresExtension(extension = 31, version = 10)})
    private static final class Ext10Impl {
        public static final Companion Companion = new Companion((C2633k) null);

        public static final class Companion {
            public /* synthetic */ Companion(C2633k kVar) {
                this();
            }

            /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            @androidx.annotation.RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
            @androidx.annotation.DoNotInline
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object getAdSelectionData(android.adservices.adselection.AdSelectionManager r5, androidx.privacysandbox.ads.adservices.adselection.GetAdSelectionDataRequest r6, b3.C2308e r7) {
                /*
                    r4 = this;
                    boolean r0 = r7 instanceof androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$getAdSelectionData$1
                    if (r0 == 0) goto L_0x0013
                    r0 = r7
                    androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$getAdSelectionData$1 r0 = (androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$getAdSelectionData$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L_0x0018
                L_0x0013:
                    androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$getAdSelectionData$1 r0 = new androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$getAdSelectionData$1
                    r0.<init>(r4, r7)
                L_0x0018:
                    java.lang.Object r7 = r0.result
                    java.lang.Object r1 = c3.C2316b.f()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L_0x003a
                    if (r2 != r3) goto L_0x0032
                    java.lang.Object r5 = r0.L$1
                    androidx.privacysandbox.ads.adservices.adselection.GetAdSelectionDataRequest r5 = (androidx.privacysandbox.ads.adservices.adselection.GetAdSelectionDataRequest) r5
                    java.lang.Object r5 = r0.L$0
                    androidx.privacysandbox.ads.adservices.adselection.r.a(r5)
                    W2.u.b(r7)
                    goto L_0x006f
                L_0x0032:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L_0x003a:
                    W2.u.b(r7)
                    r0.L$0 = r5
                    r0.L$1 = r6
                    r0.label = r3
                    w3.n r7 = new w3.n
                    b3.e r2 = c3.C2316b.c(r0)
                    r7.<init>(r2, r3)
                    r7.D()
                    android.adservices.adselection.GetAdSelectionDataRequest r6 = r6.convertToAdServices$ads_adservices_release()
                    androidx.privacysandbox.ads.adservices.adid.i r2 = new androidx.privacysandbox.ads.adservices.adid.i
                    r2.<init>()
                    android.os.OutcomeReceiver r3 = androidx.core.os.OutcomeReceiverKt.asOutcomeReceiver(r7)
                    androidx.privacysandbox.ads.adservices.adselection.C0397w.a(r5, r6, r2, r3)
                    java.lang.Object r7 = r7.x()
                    java.lang.Object r5 = c3.C2316b.f()
                    if (r7 != r5) goto L_0x006c
                    kotlin.coroutines.jvm.internal.h.c(r0)
                L_0x006c:
                    if (r7 != r1) goto L_0x006f
                    return r1
                L_0x006f:
                    android.adservices.adselection.GetAdSelectionDataOutcome r5 = androidx.privacysandbox.ads.adservices.adselection.C0398x.a(r7)
                    androidx.privacysandbox.ads.adservices.adselection.GetAdSelectionDataOutcome r6 = new androidx.privacysandbox.ads.adservices.adselection.GetAdSelectionDataOutcome
                    r6.<init>((android.adservices.adselection.GetAdSelectionDataOutcome) r5)
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon.Ext10Impl.Companion.getAdSelectionData(android.adservices.adselection.AdSelectionManager, androidx.privacysandbox.ads.adservices.adselection.GetAdSelectionDataRequest, b3.e):java.lang.Object");
            }

            /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            @androidx.annotation.RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
            @androidx.annotation.DoNotInline
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object persistAdSelectionResult(android.adservices.adselection.AdSelectionManager r5, androidx.privacysandbox.ads.adservices.adselection.PersistAdSelectionResultRequest r6, b3.C2308e r7) {
                /*
                    r4 = this;
                    boolean r0 = r7 instanceof androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$persistAdSelectionResult$1
                    if (r0 == 0) goto L_0x0013
                    r0 = r7
                    androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$persistAdSelectionResult$1 r0 = (androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$persistAdSelectionResult$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L_0x0018
                L_0x0013:
                    androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$persistAdSelectionResult$1 r0 = new androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$persistAdSelectionResult$1
                    r0.<init>(r4, r7)
                L_0x0018:
                    java.lang.Object r7 = r0.result
                    java.lang.Object r1 = c3.C2316b.f()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L_0x003a
                    if (r2 != r3) goto L_0x0032
                    java.lang.Object r5 = r0.L$1
                    androidx.privacysandbox.ads.adservices.adselection.PersistAdSelectionResultRequest r5 = (androidx.privacysandbox.ads.adservices.adselection.PersistAdSelectionResultRequest) r5
                    java.lang.Object r5 = r0.L$0
                    androidx.privacysandbox.ads.adservices.adselection.r.a(r5)
                    W2.u.b(r7)
                    goto L_0x006f
                L_0x0032:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L_0x003a:
                    W2.u.b(r7)
                    r0.L$0 = r5
                    r0.L$1 = r6
                    r0.label = r3
                    w3.n r7 = new w3.n
                    b3.e r2 = c3.C2316b.c(r0)
                    r7.<init>(r2, r3)
                    r7.D()
                    android.adservices.adselection.PersistAdSelectionResultRequest r6 = r6.convertToAdServices$ads_adservices_release()
                    androidx.privacysandbox.ads.adservices.adid.i r2 = new androidx.privacysandbox.ads.adservices.adid.i
                    r2.<init>()
                    android.os.OutcomeReceiver r3 = androidx.core.os.OutcomeReceiverKt.asOutcomeReceiver(r7)
                    androidx.privacysandbox.ads.adservices.adselection.C0399y.a(r5, r6, r2, r3)
                    java.lang.Object r7 = r7.x()
                    java.lang.Object r5 = c3.C2316b.f()
                    if (r7 != r5) goto L_0x006c
                    kotlin.coroutines.jvm.internal.h.c(r0)
                L_0x006c:
                    if (r7 != r1) goto L_0x006f
                    return r1
                L_0x006f:
                    android.adservices.adselection.AdSelectionOutcome r5 = androidx.privacysandbox.ads.adservices.adselection.C0393s.a(r7)
                    androidx.privacysandbox.ads.adservices.adselection.AdSelectionOutcome r6 = new androidx.privacysandbox.ads.adservices.adselection.AdSelectionOutcome
                    r6.<init>(r5)
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon.Ext10Impl.Companion.persistAdSelectionResult(android.adservices.adselection.AdSelectionManager, androidx.privacysandbox.ads.adservices.adselection.PersistAdSelectionResultRequest, b3.e):java.lang.Object");
            }

            /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            @androidx.annotation.RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
            @androidx.annotation.DoNotInline
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object selectAds(android.adservices.adselection.AdSelectionManager r5, androidx.privacysandbox.ads.adservices.adselection.AdSelectionFromOutcomesConfig r6, b3.C2308e r7) {
                /*
                    r4 = this;
                    boolean r0 = r7 instanceof androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$selectAds$1
                    if (r0 == 0) goto L_0x0013
                    r0 = r7
                    androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$selectAds$1 r0 = (androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$selectAds$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L_0x0018
                L_0x0013:
                    androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$selectAds$1 r0 = new androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion$selectAds$1
                    r0.<init>(r4, r7)
                L_0x0018:
                    java.lang.Object r7 = r0.result
                    java.lang.Object r1 = c3.C2316b.f()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L_0x003a
                    if (r2 != r3) goto L_0x0032
                    java.lang.Object r5 = r0.L$1
                    androidx.privacysandbox.ads.adservices.adselection.AdSelectionFromOutcomesConfig r5 = (androidx.privacysandbox.ads.adservices.adselection.AdSelectionFromOutcomesConfig) r5
                    java.lang.Object r5 = r0.L$0
                    androidx.privacysandbox.ads.adservices.adselection.r.a(r5)
                    W2.u.b(r7)
                    goto L_0x006f
                L_0x0032:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L_0x003a:
                    W2.u.b(r7)
                    r0.L$0 = r5
                    r0.L$1 = r6
                    r0.label = r3
                    w3.n r7 = new w3.n
                    b3.e r2 = c3.C2316b.c(r0)
                    r7.<init>(r2, r3)
                    r7.D()
                    android.adservices.adselection.AdSelectionFromOutcomesConfig r6 = r6.convertToAdServices$ads_adservices_release()
                    androidx.privacysandbox.ads.adservices.adid.i r2 = new androidx.privacysandbox.ads.adservices.adid.i
                    r2.<init>()
                    android.os.OutcomeReceiver r3 = androidx.core.os.OutcomeReceiverKt.asOutcomeReceiver(r7)
                    androidx.privacysandbox.ads.adservices.adselection.C0396v.a(r5, r6, r2, r3)
                    java.lang.Object r7 = r7.x()
                    java.lang.Object r5 = c3.C2316b.f()
                    if (r7 != r5) goto L_0x006c
                    kotlin.coroutines.jvm.internal.h.c(r0)
                L_0x006c:
                    if (r7 != r1) goto L_0x006f
                    return r1
                L_0x006f:
                    android.adservices.adselection.AdSelectionOutcome r5 = androidx.privacysandbox.ads.adservices.adselection.C0393s.a(r7)
                    androidx.privacysandbox.ads.adservices.adselection.AdSelectionOutcome r6 = new androidx.privacysandbox.ads.adservices.adselection.AdSelectionOutcome
                    r6.<init>(r5)
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon.Ext10Impl.Companion.selectAds(android.adservices.adselection.AdSelectionManager, androidx.privacysandbox.ads.adservices.adselection.AdSelectionFromOutcomesConfig, b3.e):java.lang.Object");
            }

            private Companion() {
            }
        }

        private Ext10Impl() {
        }
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 8), @RequiresExtension(extension = 31, version = 9)})
    private static final class Ext8Impl {
        public static final Companion Companion = new Companion((C2633k) null);

        public static final class Companion {
            public /* synthetic */ Companion(C2633k kVar) {
                this();
            }

            @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
            @DoNotInline
            public final Object reportEvent(AdSelectionManager adSelectionManager, ReportEventRequest reportEventRequest, C2308e eVar) {
                C2886n nVar = new C2886n(C2316b.c(eVar), 1);
                nVar.D();
                adSelectionManager.reportEvent(reportEventRequest.convertToAdServices$ads_adservices_release(), new i(), OutcomeReceiverKt.asOutcomeReceiver(nVar));
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
            public final Object updateAdCounterHistogram(AdSelectionManager adSelectionManager, UpdateAdCounterHistogramRequest updateAdCounterHistogramRequest, C2308e eVar) {
                C2886n nVar = new C2886n(C2316b.c(eVar), 1);
                nVar.D();
                z.a(adSelectionManager, updateAdCounterHistogramRequest.convertToAdServices$ads_adservices_release(), new i(), OutcomeReceiverKt.asOutcomeReceiver(nVar));
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

        private Ext8Impl() {
        }
    }

    public AdSelectionManagerImplCommon(AdSelectionManager adSelectionManager) {
        t.e(adSelectionManager, "mAdSelectionManager");
        this.mAdSelectionManager = adSelectionManager;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    static /* synthetic */ Object getAdSelectionData$suspendImpl(AdSelectionManagerImplCommon adSelectionManagerImplCommon, GetAdSelectionDataRequest getAdSelectionDataRequest, C2308e eVar) {
        AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
        if (adServicesInfo.adServicesVersion() >= 10 || adServicesInfo.extServicesVersionS() >= 10) {
            return Ext10Impl.Companion.getAdSelectionData(adSelectionManagerImplCommon.mAdSelectionManager, getAdSelectionDataRequest, eVar);
        }
        throw new UnsupportedOperationException("API is not available. Min version is API 31 ext 10");
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    static /* synthetic */ Object persistAdSelectionResult$suspendImpl(AdSelectionManagerImplCommon adSelectionManagerImplCommon, PersistAdSelectionResultRequest persistAdSelectionResultRequest, C2308e eVar) {
        AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
        if (adServicesInfo.adServicesVersion() >= 10 || adServicesInfo.extServicesVersionS() >= 10) {
            return Ext10Impl.Companion.persistAdSelectionResult(adSelectionManagerImplCommon.mAdSelectionManager, persistAdSelectionResultRequest, eVar);
        }
        throw new UnsupportedOperationException("API is not available. Min version is API 31 ext 10");
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    static /* synthetic */ Object reportEvent$suspendImpl(AdSelectionManagerImplCommon adSelectionManagerImplCommon, ReportEventRequest reportEventRequest, C2308e eVar) {
        AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
        if (adServicesInfo.adServicesVersion() >= 8 || adServicesInfo.extServicesVersionS() >= 9) {
            Object reportEvent = Ext8Impl.Companion.reportEvent(adSelectionManagerImplCommon.mAdSelectionManager, reportEventRequest, eVar);
            if (reportEvent == C2316b.f()) {
                return reportEvent;
            }
            return J.f19942a;
        }
        throw new UnsupportedOperationException("API is unsupported. Min version is API 33 ext 8 or API 31/32 ext 9");
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    static /* synthetic */ Object reportImpression$suspendImpl(AdSelectionManagerImplCommon adSelectionManagerImplCommon, ReportImpressionRequest reportImpressionRequest, C2308e eVar) {
        C2886n nVar = new C2886n(C2316b.c(eVar), 1);
        nVar.D();
        adSelectionManagerImplCommon.getMAdSelectionManager().reportImpression(reportImpressionRequest.convertToAdServices$ads_adservices_release(), new i(), OutcomeReceiverKt.asOutcomeReceiver(nVar));
        Object x4 = nVar.x();
        if (x4 == C2316b.f()) {
            h.c(eVar);
        }
        if (x4 == C2316b.f()) {
            return x4;
        }
        return J.f19942a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @androidx.annotation.RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @androidx.annotation.DoNotInline
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object selectAds$suspendImpl(androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon r4, androidx.privacysandbox.ads.adservices.adselection.AdSelectionConfig r5, b3.C2308e r6) {
        /*
            boolean r0 = r6 instanceof androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$selectAds$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$selectAds$1 r0 = (androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$selectAds$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$selectAds$1 r0 = new androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$selectAds$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            W2.u.b(r6)
            goto L_0x0041
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            W2.u.b(r6)
            android.adservices.adselection.AdSelectionConfig r5 = r5.convertToAdServices$ads_adservices_release()
            r0.label = r3
            java.lang.Object r6 = r4.selectAdsInternal(r5, r0)
            if (r6 != r1) goto L_0x0041
            return r1
        L_0x0041:
            android.adservices.adselection.AdSelectionOutcome r4 = androidx.privacysandbox.ads.adservices.adselection.C0393s.a(r6)
            androidx.privacysandbox.ads.adservices.adselection.AdSelectionOutcome r5 = new androidx.privacysandbox.ads.adservices.adselection.AdSelectionOutcome
            r5.<init>(r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon.selectAds$suspendImpl(androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon, androidx.privacysandbox.ads.adservices.adselection.AdSelectionConfig, b3.e):java.lang.Object");
    }

    /* access modifiers changed from: private */
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    public final Object selectAdsInternal(AdSelectionConfig adSelectionConfig, C2308e eVar) {
        C2886n nVar = new C2886n(C2316b.c(eVar), 1);
        nVar.D();
        getMAdSelectionManager().selectAds(adSelectionConfig, new i(), OutcomeReceiverKt.asOutcomeReceiver(nVar));
        Object x4 = nVar.x();
        if (x4 == C2316b.f()) {
            h.c(eVar);
        }
        return x4;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    static /* synthetic */ Object updateAdCounterHistogram$suspendImpl(AdSelectionManagerImplCommon adSelectionManagerImplCommon, UpdateAdCounterHistogramRequest updateAdCounterHistogramRequest, C2308e eVar) {
        AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
        if (adServicesInfo.adServicesVersion() >= 8 || adServicesInfo.extServicesVersionS() >= 9) {
            Object updateAdCounterHistogram = Ext8Impl.Companion.updateAdCounterHistogram(adSelectionManagerImplCommon.mAdSelectionManager, updateAdCounterHistogramRequest, eVar);
            if (updateAdCounterHistogram == C2316b.f()) {
                return updateAdCounterHistogram;
            }
            return J.f19942a;
        }
        throw new UnsupportedOperationException("API is unsupported. Min version is API 33 ext 8 or API 31/32 ext 9");
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    public Object getAdSelectionData(GetAdSelectionDataRequest getAdSelectionDataRequest, C2308e eVar) {
        return getAdSelectionData$suspendImpl(this, getAdSelectionDataRequest, eVar);
    }

    /* access modifiers changed from: protected */
    public final AdSelectionManager getMAdSelectionManager() {
        return this.mAdSelectionManager;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    public Object persistAdSelectionResult(PersistAdSelectionResultRequest persistAdSelectionResultRequest, C2308e eVar) {
        return persistAdSelectionResult$suspendImpl(this, persistAdSelectionResultRequest, eVar);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    public Object reportEvent(ReportEventRequest reportEventRequest, C2308e eVar) {
        return reportEvent$suspendImpl(this, reportEventRequest, eVar);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    public Object reportImpression(ReportImpressionRequest reportImpressionRequest, C2308e eVar) {
        return reportImpression$suspendImpl(this, reportImpressionRequest, eVar);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    public Object selectAds(AdSelectionConfig adSelectionConfig, C2308e eVar) {
        return selectAds$suspendImpl(this, adSelectionConfig, eVar);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    public Object updateAdCounterHistogram(UpdateAdCounterHistogramRequest updateAdCounterHistogramRequest, C2308e eVar) {
        return updateAdCounterHistogram$suspendImpl(this, updateAdCounterHistogramRequest, eVar);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    public Object selectAds(AdSelectionFromOutcomesConfig adSelectionFromOutcomesConfig, C2308e eVar) {
        return selectAds$suspendImpl(this, adSelectionFromOutcomesConfig, eVar);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @DoNotInline
    static /* synthetic */ Object selectAds$suspendImpl(AdSelectionManagerImplCommon adSelectionManagerImplCommon, AdSelectionFromOutcomesConfig adSelectionFromOutcomesConfig, C2308e eVar) {
        AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
        if (adServicesInfo.adServicesVersion() >= 10 || adServicesInfo.extServicesVersionS() >= 10) {
            return Ext10Impl.Companion.selectAds(adSelectionManagerImplCommon.mAdSelectionManager, adSelectionFromOutcomesConfig, eVar);
        }
        throw new UnsupportedOperationException("API is not available. Min version is API 31 ext 10");
    }
}
