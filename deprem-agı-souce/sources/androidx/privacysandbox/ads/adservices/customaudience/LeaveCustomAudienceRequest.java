package androidx.privacysandbox.ads.adservices.customaudience;

import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import kotlin.jvm.internal.t;

public final class LeaveCustomAudienceRequest {
    private final AdTechIdentifier buyer;
    private final String name;

    public LeaveCustomAudienceRequest(AdTechIdentifier adTechIdentifier, String str) {
        t.e(adTechIdentifier, "buyer");
        t.e(str, RewardPlus.NAME);
        this.buyer = adTechIdentifier;
        this.name = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LeaveCustomAudienceRequest)) {
            return false;
        }
        LeaveCustomAudienceRequest leaveCustomAudienceRequest = (LeaveCustomAudienceRequest) obj;
        if (!t.a(this.buyer, leaveCustomAudienceRequest.buyer) || !t.a(this.name, leaveCustomAudienceRequest.name)) {
            return false;
        }
        return true;
    }

    public final AdTechIdentifier getBuyer() {
        return this.buyer;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (this.buyer.hashCode() * 31) + this.name.hashCode();
    }

    public String toString() {
        return "LeaveCustomAudience: buyer=" + this.buyer + ", name=" + this.name;
    }
}
