package androidx.privacysandbox.ads.adservices.java.adselection;

import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.adselection.AdSelectionConfig;
import androidx.privacysandbox.ads.adservices.adselection.AdSelectionFromOutcomesConfig;
import androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager;
import androidx.privacysandbox.ads.adservices.adselection.GetAdSelectionDataRequest;
import androidx.privacysandbox.ads.adservices.adselection.PersistAdSelectionResultRequest;
import androidx.privacysandbox.ads.adservices.adselection.ReportEventRequest;
import androidx.privacysandbox.ads.adservices.adselection.ReportImpressionRequest;
import androidx.privacysandbox.ads.adservices.adselection.UpdateAdCounterHistogramRequest;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import b3.C2308e;
import b3.C2312i;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import n0.C1722d;
import w3.C2865c0;
import w3.N;
import w3.O;

public abstract class AdSelectionManagerFutures {
    public static final Companion Companion = new Companion((C2633k) null);

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        public final AdSelectionManagerFutures from(Context context) {
            t.e(context, "context");
            AdSelectionManager obtain = AdSelectionManager.Companion.obtain(context);
            if (obtain != null) {
                return new Api33Ext4JavaImpl(obtain);
            }
            return null;
        }

        private Companion() {
        }
    }

    public static final AdSelectionManagerFutures from(Context context) {
        return Companion.from(context);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @ExperimentalFeatures.Ext10OptIn
    public abstract C1722d getAdSelectionDataAsync(GetAdSelectionDataRequest getAdSelectionDataRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @ExperimentalFeatures.Ext10OptIn
    public abstract C1722d persistAdSelectionResultAsync(PersistAdSelectionResultRequest persistAdSelectionResultRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @ExperimentalFeatures.Ext8OptIn
    public abstract C1722d reportEventAsync(ReportEventRequest reportEventRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    public abstract C1722d reportImpressionAsync(ReportImpressionRequest reportImpressionRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    public abstract C1722d selectAdsAsync(AdSelectionConfig adSelectionConfig);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @ExperimentalFeatures.Ext10OptIn
    public abstract C1722d selectAdsAsync(AdSelectionFromOutcomesConfig adSelectionFromOutcomesConfig);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @ExperimentalFeatures.Ext8OptIn
    public abstract C1722d updateAdCounterHistogramAsync(UpdateAdCounterHistogramRequest updateAdCounterHistogramRequest);

    private static final class Api33Ext4JavaImpl extends AdSelectionManagerFutures {
        /* access modifiers changed from: private */
        public final AdSelectionManager mAdSelectionManager;

        public Api33Ext4JavaImpl(AdSelectionManager adSelectionManager) {
            this.mAdSelectionManager = adSelectionManager;
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public C1722d getAdSelectionDataAsync(GetAdSelectionDataRequest getAdSelectionDataRequest) {
            t.e(getAdSelectionDataRequest, "getAdSelectionDataRequest");
            return CoroutineAdapterKt.asListenableFuture$default(C2876i.b(N.a(C2865c0.a()), (C2312i) null, (O) null, new AdSelectionManagerFutures$Api33Ext4JavaImpl$getAdSelectionDataAsync$1(this, getAdSelectionDataRequest, (C2308e) null), 3, (Object) null), (Object) null, 1, (Object) null);
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public C1722d persistAdSelectionResultAsync(PersistAdSelectionResultRequest persistAdSelectionResultRequest) {
            t.e(persistAdSelectionResultRequest, "persistAdSelectionResultRequest");
            return CoroutineAdapterKt.asListenableFuture$default(C2876i.b(N.a(C2865c0.a()), (C2312i) null, (O) null, new AdSelectionManagerFutures$Api33Ext4JavaImpl$persistAdSelectionResultAsync$1(this, persistAdSelectionResultRequest, (C2308e) null), 3, (Object) null), (Object) null, 1, (Object) null);
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public C1722d reportEventAsync(ReportEventRequest reportEventRequest) {
            t.e(reportEventRequest, "reportEventRequest");
            return CoroutineAdapterKt.asListenableFuture$default(C2876i.b(N.a(C2865c0.a()), (C2312i) null, (O) null, new AdSelectionManagerFutures$Api33Ext4JavaImpl$reportEventAsync$1(this, reportEventRequest, (C2308e) null), 3, (Object) null), (Object) null, 1, (Object) null);
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public C1722d reportImpressionAsync(ReportImpressionRequest reportImpressionRequest) {
            t.e(reportImpressionRequest, "reportImpressionRequest");
            return CoroutineAdapterKt.asListenableFuture$default(C2876i.b(N.a(C2865c0.a()), (C2312i) null, (O) null, new AdSelectionManagerFutures$Api33Ext4JavaImpl$reportImpressionAsync$1(this, reportImpressionRequest, (C2308e) null), 3, (Object) null), (Object) null, 1, (Object) null);
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public C1722d selectAdsAsync(AdSelectionConfig adSelectionConfig) {
            t.e(adSelectionConfig, "adSelectionConfig");
            return CoroutineAdapterKt.asListenableFuture$default(C2876i.b(N.a(C2865c0.a()), (C2312i) null, (O) null, new AdSelectionManagerFutures$Api33Ext4JavaImpl$selectAdsAsync$1(this, adSelectionConfig, (C2308e) null), 3, (Object) null), (Object) null, 1, (Object) null);
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public C1722d updateAdCounterHistogramAsync(UpdateAdCounterHistogramRequest updateAdCounterHistogramRequest) {
            t.e(updateAdCounterHistogramRequest, "updateAdCounterHistogramRequest");
            return CoroutineAdapterKt.asListenableFuture$default(C2876i.b(N.a(C2865c0.a()), (C2312i) null, (O) null, new AdSelectionManagerFutures$Api33Ext4JavaImpl$updateAdCounterHistogramAsync$1(this, updateAdCounterHistogramRequest, (C2308e) null), 3, (Object) null), (Object) null, 1, (Object) null);
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public C1722d selectAdsAsync(AdSelectionFromOutcomesConfig adSelectionFromOutcomesConfig) {
            t.e(adSelectionFromOutcomesConfig, "adSelectionFromOutcomesConfig");
            return CoroutineAdapterKt.asListenableFuture$default(C2876i.b(N.a(C2865c0.a()), (C2312i) null, (O) null, new AdSelectionManagerFutures$Api33Ext4JavaImpl$selectAdsAsync$2(this, adSelectionFromOutcomesConfig, (C2308e) null), 3, (Object) null), (Object) null, 1, (Object) null);
        }
    }
}
