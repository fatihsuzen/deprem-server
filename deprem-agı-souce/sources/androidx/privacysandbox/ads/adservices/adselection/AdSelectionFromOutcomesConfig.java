package androidx.privacysandbox.ads.adservices.adselection;

import android.net.Uri;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.AdSelectionSignals;
import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.util.List;
import kotlin.jvm.internal.t;

@ExperimentalFeatures.Ext10OptIn
public final class AdSelectionFromOutcomesConfig {
    private final List<Long> adSelectionIds;
    private final AdSelectionSignals adSelectionSignals;
    private Uri selectionLogicUri;
    private final AdTechIdentifier seller;

    public AdSelectionFromOutcomesConfig(AdTechIdentifier adTechIdentifier, List<Long> list, AdSelectionSignals adSelectionSignals2, Uri uri) {
        t.e(adTechIdentifier, "seller");
        t.e(list, "adSelectionIds");
        t.e(adSelectionSignals2, "adSelectionSignals");
        t.e(uri, "selectionLogicUri");
        this.seller = adTechIdentifier;
        this.adSelectionIds = list;
        this.adSelectionSignals = adSelectionSignals2;
        this.selectionLogicUri = uri;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 10), @RequiresExtension(extension = 31, version = 10)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.adselection.AdSelectionFromOutcomesConfig convertToAdServices$ads_adservices_release() {
        android.adservices.adselection.AdSelectionFromOutcomesConfig a5 = C0390o.a().setSelectionSignals(this.adSelectionSignals.convertToAdServices$ads_adservices_release()).setAdSelectionIds(this.adSelectionIds).setSelectionLogicUri(this.selectionLogicUri).setSeller(this.seller.convertToAdServices$ads_adservices_release()).build();
        t.d(a5, "Builder()\n            .s…s())\n            .build()");
        return a5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdSelectionFromOutcomesConfig)) {
            return false;
        }
        AdSelectionFromOutcomesConfig adSelectionFromOutcomesConfig = (AdSelectionFromOutcomesConfig) obj;
        if (!t.a(this.seller, adSelectionFromOutcomesConfig.seller) || !t.a(this.adSelectionIds, adSelectionFromOutcomesConfig.adSelectionIds) || !t.a(this.adSelectionSignals, adSelectionFromOutcomesConfig.adSelectionSignals) || !t.a(this.selectionLogicUri, adSelectionFromOutcomesConfig.selectionLogicUri)) {
            return false;
        }
        return true;
    }

    public final List<Long> getAdSelectionIds() {
        return this.adSelectionIds;
    }

    public final AdSelectionSignals getAdSelectionSignals() {
        return this.adSelectionSignals;
    }

    public final Uri getSelectionLogicUri() {
        return this.selectionLogicUri;
    }

    public final AdTechIdentifier getSeller() {
        return this.seller;
    }

    public int hashCode() {
        return (((((this.seller.hashCode() * 31) + this.adSelectionIds.hashCode()) * 31) + this.adSelectionSignals.hashCode()) * 31) + this.selectionLogicUri.hashCode();
    }

    public final void setSelectionLogicUri(Uri uri) {
        t.e(uri, "<set-?>");
        this.selectionLogicUri = uri;
    }

    public String toString() {
        return "AdSelectionFromOutcomesConfig: seller=" + this.seller + ", adSelectionIds='" + this.adSelectionIds + "', adSelectionSignals=" + this.adSelectionSignals + ", selectionLogicUri=" + this.selectionLogicUri;
    }
}
