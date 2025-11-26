package androidx.privacysandbox.ads.adservices.adselection;

import android.annotation.SuppressLint;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.collection.a;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

@SuppressLint({"ClassVerificationFailure"})
public final class ReportImpressionRequest {
    private final AdSelectionConfig adSelectionConfig;
    private final long adSelectionId;

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 10), @RequiresExtension(extension = 31, version = 10)})
    private static final class Ext10Impl {
        public static final Companion Companion = new Companion((C2633k) null);

        public static final class Companion {
            public /* synthetic */ Companion(C2633k kVar) {
                this();
            }

            public final android.adservices.adselection.ReportImpressionRequest convertReportImpressionRequest(ReportImpressionRequest reportImpressionRequest) {
                t.e(reportImpressionRequest, "request");
                if (t.a(reportImpressionRequest.getAdSelectionConfig(), AdSelectionConfig.Companion.getEMPTY())) {
                    V.a();
                    return T.a(reportImpressionRequest.getAdSelectionId());
                }
                V.a();
                return U.a(reportImpressionRequest.getAdSelectionId(), reportImpressionRequest.getAdSelectionConfig().convertToAdServices$ads_adservices_release());
            }

            private Companion() {
            }
        }

        private Ext10Impl() {
        }
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    private static final class Ext4Impl {
        public static final Companion Companion = new Companion((C2633k) null);

        public static final class Companion {
            public /* synthetic */ Companion(C2633k kVar) {
                this();
            }

            public final android.adservices.adselection.ReportImpressionRequest convertReportImpressionRequest(ReportImpressionRequest reportImpressionRequest) {
                t.e(reportImpressionRequest, "request");
                if (!t.a(reportImpressionRequest.getAdSelectionConfig(), AdSelectionConfig.Companion.getEMPTY())) {
                    V.a();
                    return U.a(reportImpressionRequest.getAdSelectionId(), reportImpressionRequest.getAdSelectionConfig().convertToAdServices$ads_adservices_release());
                }
                throw new UnsupportedOperationException("adSelectionConfig is mandatory forAPI versions lower than ext 10");
            }

            private Companion() {
            }
        }

        private Ext4Impl() {
        }
    }

    public ReportImpressionRequest(long j5, AdSelectionConfig adSelectionConfig2) {
        t.e(adSelectionConfig2, "adSelectionConfig");
        this.adSelectionId = j5;
        this.adSelectionConfig = adSelectionConfig2;
    }

    @SuppressLint({"NewApi"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.adselection.ReportImpressionRequest convertToAdServices$ads_adservices_release() {
        AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
        if (adServicesInfo.adServicesVersion() >= 10 || adServicesInfo.extServicesVersionS() >= 10) {
            return Ext10Impl.Companion.convertReportImpressionRequest(this);
        }
        return Ext4Impl.Companion.convertReportImpressionRequest(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReportImpressionRequest)) {
            return false;
        }
        ReportImpressionRequest reportImpressionRequest = (ReportImpressionRequest) obj;
        if (this.adSelectionId != reportImpressionRequest.adSelectionId || !t.a(this.adSelectionConfig, reportImpressionRequest.adSelectionConfig)) {
            return false;
        }
        return true;
    }

    public final AdSelectionConfig getAdSelectionConfig() {
        return this.adSelectionConfig;
    }

    public final long getAdSelectionId() {
        return this.adSelectionId;
    }

    public int hashCode() {
        return (a.a(this.adSelectionId) * 31) + this.adSelectionConfig.hashCode();
    }

    public String toString() {
        return "ReportImpressionRequest: adSelectionId=" + this.adSelectionId + ", adSelectionConfig=" + this.adSelectionConfig;
    }

    @ExperimentalFeatures.Ext8OptIn
    public ReportImpressionRequest(long j5) {
        this(j5, AdSelectionConfig.Companion.getEMPTY());
    }
}
