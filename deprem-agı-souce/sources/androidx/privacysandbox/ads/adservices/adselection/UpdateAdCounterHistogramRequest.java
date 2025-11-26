package androidx.privacysandbox.ads.adservices.adselection;

import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.collection.a;
import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import kotlin.jvm.internal.t;

@ExperimentalFeatures.Ext8OptIn
public final class UpdateAdCounterHistogramRequest {
    private final int adEventType;
    private final long adSelectionId;
    private final AdTechIdentifier callerAdTech;

    public UpdateAdCounterHistogramRequest(long j5, int i5, AdTechIdentifier adTechIdentifier) {
        t.e(adTechIdentifier, "callerAdTech");
        this.adSelectionId = j5;
        this.adEventType = i5;
        this.callerAdTech = adTechIdentifier;
        if (i5 == 0) {
            throw new IllegalArgumentException("Win event types cannot be manually updated.");
        } else if (i5 != 1 && i5 != 2 && i5 != 3) {
            throw new IllegalArgumentException("Ad event type must be one of AD_EVENT_TYPE_IMPRESSION, AD_EVENT_TYPE_VIEW, or AD_EVENT_TYPE_CLICK");
        }
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 8), @RequiresExtension(extension = 31, version = 9)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.adselection.UpdateAdCounterHistogramRequest convertToAdServices$ads_adservices_release() {
        Y.a();
        android.adservices.adselection.UpdateAdCounterHistogramRequest a5 = X.a(this.adSelectionId, this.adEventType, this.callerAdTech.convertToAdServices$ads_adservices_release()).build();
        t.d(a5, "Builder(\n               …   )\n            .build()");
        return a5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpdateAdCounterHistogramRequest)) {
            return false;
        }
        UpdateAdCounterHistogramRequest updateAdCounterHistogramRequest = (UpdateAdCounterHistogramRequest) obj;
        if (this.adSelectionId == updateAdCounterHistogramRequest.adSelectionId && this.adEventType == updateAdCounterHistogramRequest.adEventType && t.a(this.callerAdTech, updateAdCounterHistogramRequest.callerAdTech)) {
            return true;
        }
        return false;
    }

    public final int getAdEventType() {
        return this.adEventType;
    }

    public final long getAdSelectionId() {
        return this.adSelectionId;
    }

    public final AdTechIdentifier getCallerAdTech() {
        return this.callerAdTech;
    }

    public int hashCode() {
        return (((a.a(this.adSelectionId) * 31) + this.adEventType) * 31) + this.callerAdTech.hashCode();
    }

    public String toString() {
        String str;
        int i5 = this.adEventType;
        if (i5 == 0) {
            str = "AD_EVENT_TYPE_WIN";
        } else if (i5 == 1) {
            str = "AD_EVENT_TYPE_IMPRESSION";
        } else if (i5 == 2) {
            str = "AD_EVENT_TYPE_VIEW";
        } else if (i5 != 3) {
            str = "Invalid ad event type";
        } else {
            str = "AD_EVENT_TYPE_CLICK";
        }
        return "UpdateAdCounterHistogramRequest: adSelectionId=" + this.adSelectionId + ", adEventType=" + str + ", callerAdTech=" + this.callerAdTech;
    }
}
