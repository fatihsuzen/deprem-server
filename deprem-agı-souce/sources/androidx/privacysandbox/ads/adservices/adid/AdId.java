package androidx.privacysandbox.ads.adservices.adid;

import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class AdId {
    private final String adId;
    private final boolean isLimitAdTrackingEnabled;

    public AdId(String str, boolean z4) {
        t.e(str, "adId");
        this.adId = str;
        this.isLimitAdTrackingEnabled = z4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdId)) {
            return false;
        }
        AdId adId2 = (AdId) obj;
        if (!t.a(this.adId, adId2.adId) || this.isLimitAdTrackingEnabled != adId2.isLimitAdTrackingEnabled) {
            return false;
        }
        return true;
    }

    public final String getAdId() {
        return this.adId;
    }

    public int hashCode() {
        return (this.adId.hashCode() * 31) + a.a(this.isLimitAdTrackingEnabled);
    }

    public final boolean isLimitAdTrackingEnabled() {
        return this.isLimitAdTrackingEnabled;
    }

    public String toString() {
        return "AdId: adId=" + this.adId + ", isLimitAdTrackingEnabled=" + this.isLimitAdTrackingEnabled;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdId(String str, boolean z4, int i5, C2633k kVar) {
        this(str, (i5 & 2) != 0 ? false : z4);
    }
}
