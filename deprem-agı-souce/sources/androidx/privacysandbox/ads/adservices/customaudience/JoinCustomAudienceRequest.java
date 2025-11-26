package androidx.privacysandbox.ads.adservices.customaudience;

import kotlin.jvm.internal.t;

public final class JoinCustomAudienceRequest {
    private final CustomAudience customAudience;

    public JoinCustomAudienceRequest(CustomAudience customAudience2) {
        t.e(customAudience2, "customAudience");
        this.customAudience = customAudience2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JoinCustomAudienceRequest)) {
            return false;
        }
        return t.a(this.customAudience, ((JoinCustomAudienceRequest) obj).customAudience);
    }

    public final CustomAudience getCustomAudience() {
        return this.customAudience;
    }

    public int hashCode() {
        return this.customAudience.hashCode();
    }

    public String toString() {
        return "JoinCustomAudience: customAudience=" + this.customAudience;
    }
}
