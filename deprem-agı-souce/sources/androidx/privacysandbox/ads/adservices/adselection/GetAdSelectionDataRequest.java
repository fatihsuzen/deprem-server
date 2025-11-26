package androidx.privacysandbox.ads.adservices.adselection;

import android.annotation.SuppressLint;
import android.net.Uri;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

@ExperimentalFeatures.Ext10OptIn
public final class GetAdSelectionDataRequest {
    private final Uri coordinatorOriginUri;
    private final AdTechIdentifier seller;

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 10), @RequiresExtension(extension = 31, version = 10)})
    private static final class Ext10Impl {
        public static final Companion Companion = new Companion((C2633k) null);

        public static final class Companion {
            public /* synthetic */ Companion(C2633k kVar) {
                this();
            }

            public final android.adservices.adselection.GetAdSelectionDataRequest convertGetAdSelectionDataRequest(GetAdSelectionDataRequest getAdSelectionDataRequest) {
                t.e(getAdSelectionDataRequest, "request");
                android.adservices.adselection.GetAdSelectionDataRequest a5 = H.a().setSeller(getAdSelectionDataRequest.getSeller().convertToAdServices$ads_adservices_release()).build();
                t.d(a5, "Builder()\n              …                 .build()");
                return a5;
            }

            private Companion() {
            }
        }

        private Ext10Impl() {
        }
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 12), @RequiresExtension(extension = 31, version = 12)})
    private static final class Ext12Impl {
        public static final Companion Companion = new Companion((C2633k) null);

        public static final class Companion {
            public /* synthetic */ Companion(C2633k kVar) {
                this();
            }

            public final android.adservices.adselection.GetAdSelectionDataRequest convertGetAdSelectionDataRequest(GetAdSelectionDataRequest getAdSelectionDataRequest) {
                t.e(getAdSelectionDataRequest, "request");
                android.adservices.adselection.GetAdSelectionDataRequest a5 = H.a().setSeller(getAdSelectionDataRequest.getSeller().convertToAdServices$ads_adservices_release()).setCoordinatorOriginUri(getAdSelectionDataRequest.getCoordinatorOriginUri()).build();
                t.d(a5, "Builder()\n              …                 .build()");
                return a5;
            }

            private Companion() {
            }
        }

        private Ext12Impl() {
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GetAdSelectionDataRequest(AdTechIdentifier adTechIdentifier) {
        this(adTechIdentifier, (Uri) null, 2, (C2633k) null);
        t.e(adTechIdentifier, "seller");
    }

    @ExperimentalFeatures.Ext12OptIn
    public static /* synthetic */ void getCoordinatorOriginUri$annotations() {
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 10), @RequiresExtension(extension = 31, version = 10)})
    @SuppressLint({"NewApi"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.adselection.GetAdSelectionDataRequest convertToAdServices$ads_adservices_release() {
        AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
        if (adServicesInfo.adServicesVersion() >= 12 || adServicesInfo.extServicesVersionS() >= 12) {
            return Ext12Impl.Companion.convertGetAdSelectionDataRequest(this);
        }
        return Ext10Impl.Companion.convertGetAdSelectionDataRequest(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetAdSelectionDataRequest)) {
            return false;
        }
        GetAdSelectionDataRequest getAdSelectionDataRequest = (GetAdSelectionDataRequest) obj;
        if (!t.a(this.seller, getAdSelectionDataRequest.seller) || !t.a(this.coordinatorOriginUri, getAdSelectionDataRequest.coordinatorOriginUri)) {
            return false;
        }
        return true;
    }

    public final Uri getCoordinatorOriginUri() {
        return this.coordinatorOriginUri;
    }

    public final AdTechIdentifier getSeller() {
        return this.seller;
    }

    public int hashCode() {
        int i5;
        int hashCode = this.seller.hashCode() * 31;
        Uri uri = this.coordinatorOriginUri;
        if (uri != null) {
            i5 = uri.hashCode();
        } else {
            i5 = 0;
        }
        return hashCode + i5;
    }

    public String toString() {
        return "GetAdSelectionDataRequest: seller=" + this.seller + ", coordinatorOriginUri=" + this.coordinatorOriginUri;
    }

    public GetAdSelectionDataRequest(AdTechIdentifier adTechIdentifier, Uri uri) {
        t.e(adTechIdentifier, "seller");
        this.seller = adTechIdentifier;
        this.coordinatorOriginUri = uri;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetAdSelectionDataRequest(AdTechIdentifier adTechIdentifier, Uri uri, int i5, C2633k kVar) {
        this(adTechIdentifier, (i5 & 2) != 0 ? null : uri);
    }
}
