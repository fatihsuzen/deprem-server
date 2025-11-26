package androidx.privacysandbox.ads.adservices.adselection;

import X2.C2250q;
import X2.M;
import android.annotation.SuppressLint;
import android.net.Uri;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.AdSelectionSignals;
import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

@SuppressLint({"ClassVerificationFailure"})
public final class AdSelectionConfig {
    public static final Companion Companion = new Companion((C2633k) null);
    /* access modifiers changed from: private */
    public static final AdSelectionConfig EMPTY;
    private final AdSelectionSignals adSelectionSignals;
    private final List<AdTechIdentifier> customAudienceBuyers;
    private final Uri decisionLogicUri;
    private final Map<AdTechIdentifier, AdSelectionSignals> perBuyerSignals;
    private final AdTechIdentifier seller;
    private final AdSelectionSignals sellerSignals;
    private final Uri trustedScoringSignalsUri;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        public final AdSelectionConfig getEMPTY() {
            return AdSelectionConfig.EMPTY;
        }

        private Companion() {
        }
    }

    static {
        AdTechIdentifier adTechIdentifier = new AdTechIdentifier("");
        Uri uri = Uri.EMPTY;
        t.d(uri, "EMPTY");
        List g5 = C2250q.g();
        AdSelectionSignals adSelectionSignals2 = new AdSelectionSignals("");
        AdSelectionSignals adSelectionSignals3 = new AdSelectionSignals("");
        Map h5 = M.h();
        t.d(uri, "EMPTY");
        EMPTY = new AdSelectionConfig(adTechIdentifier, uri, g5, adSelectionSignals2, adSelectionSignals3, h5, uri);
    }

    public AdSelectionConfig(AdTechIdentifier adTechIdentifier, Uri uri, List<AdTechIdentifier> list, AdSelectionSignals adSelectionSignals2, AdSelectionSignals adSelectionSignals3, Map<AdTechIdentifier, AdSelectionSignals> map, Uri uri2) {
        t.e(adTechIdentifier, "seller");
        t.e(uri, "decisionLogicUri");
        t.e(list, "customAudienceBuyers");
        t.e(adSelectionSignals2, "adSelectionSignals");
        t.e(adSelectionSignals3, "sellerSignals");
        t.e(map, "perBuyerSignals");
        t.e(uri2, "trustedScoringSignalsUri");
        this.seller = adTechIdentifier;
        this.decisionLogicUri = uri;
        this.customAudienceBuyers = list;
        this.adSelectionSignals = adSelectionSignals2;
        this.sellerSignals = adSelectionSignals3;
        this.perBuyerSignals = map;
        this.trustedScoringSignalsUri = uri2;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    private final List<android.adservices.common.AdTechIdentifier> convertToAdServices(List<AdTechIdentifier> list) {
        ArrayList arrayList = new ArrayList();
        for (AdTechIdentifier convertToAdServices$ads_adservices_release : list) {
            arrayList.add(convertToAdServices$ads_adservices_release.convertToAdServices$ads_adservices_release());
        }
        return arrayList;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.adselection.AdSelectionConfig convertToAdServices$ads_adservices_release() {
        android.adservices.adselection.AdSelectionConfig a5 = C0384i.a().setAdSelectionSignals(this.adSelectionSignals.convertToAdServices$ads_adservices_release()).setCustomAudienceBuyers(convertToAdServices(this.customAudienceBuyers)).setDecisionLogicUri(this.decisionLogicUri).setSeller(this.seller.convertToAdServices$ads_adservices_release()).setPerBuyerSignals(convertToAdServices(this.perBuyerSignals)).setSellerSignals(this.sellerSignals.convertToAdServices$ads_adservices_release()).setTrustedScoringSignalsUri(this.trustedScoringSignalsUri).build();
        t.d(a5, "Builder()\n            .s…Uri)\n            .build()");
        return a5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdSelectionConfig)) {
            return false;
        }
        AdSelectionConfig adSelectionConfig = (AdSelectionConfig) obj;
        if (!t.a(this.seller, adSelectionConfig.seller) || !t.a(this.decisionLogicUri, adSelectionConfig.decisionLogicUri) || !t.a(this.customAudienceBuyers, adSelectionConfig.customAudienceBuyers) || !t.a(this.adSelectionSignals, adSelectionConfig.adSelectionSignals) || !t.a(this.sellerSignals, adSelectionConfig.sellerSignals) || !t.a(this.perBuyerSignals, adSelectionConfig.perBuyerSignals) || !t.a(this.trustedScoringSignalsUri, adSelectionConfig.trustedScoringSignalsUri)) {
            return false;
        }
        return true;
    }

    public final AdSelectionSignals getAdSelectionSignals() {
        return this.adSelectionSignals;
    }

    public final List<AdTechIdentifier> getCustomAudienceBuyers() {
        return this.customAudienceBuyers;
    }

    public final Uri getDecisionLogicUri() {
        return this.decisionLogicUri;
    }

    public final Map<AdTechIdentifier, AdSelectionSignals> getPerBuyerSignals() {
        return this.perBuyerSignals;
    }

    public final AdTechIdentifier getSeller() {
        return this.seller;
    }

    public final AdSelectionSignals getSellerSignals() {
        return this.sellerSignals;
    }

    public final Uri getTrustedScoringSignalsUri() {
        return this.trustedScoringSignalsUri;
    }

    public int hashCode() {
        return (((((((((((this.seller.hashCode() * 31) + this.decisionLogicUri.hashCode()) * 31) + this.customAudienceBuyers.hashCode()) * 31) + this.adSelectionSignals.hashCode()) * 31) + this.sellerSignals.hashCode()) * 31) + this.perBuyerSignals.hashCode()) * 31) + this.trustedScoringSignalsUri.hashCode();
    }

    public String toString() {
        return "AdSelectionConfig: seller=" + this.seller + ", decisionLogicUri='" + this.decisionLogicUri + "', customAudienceBuyers=" + this.customAudienceBuyers + ", adSelectionSignals=" + this.adSelectionSignals + ", sellerSignals=" + this.sellerSignals + ", perBuyerSignals=" + this.perBuyerSignals + ", trustedScoringSignalsUri=" + this.trustedScoringSignalsUri;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    private final Map<android.adservices.common.AdTechIdentifier, android.adservices.common.AdSelectionSignals> convertToAdServices(Map<AdTechIdentifier, AdSelectionSignals> map) {
        HashMap hashMap = new HashMap();
        for (AdTechIdentifier next : map.keySet()) {
            android.adservices.common.AdTechIdentifier convertToAdServices$ads_adservices_release = next.convertToAdServices$ads_adservices_release();
            AdSelectionSignals adSelectionSignals2 = map.get(next);
            hashMap.put(convertToAdServices$ads_adservices_release, adSelectionSignals2 != null ? adSelectionSignals2.convertToAdServices$ads_adservices_release() : null);
        }
        return hashMap;
    }
}
