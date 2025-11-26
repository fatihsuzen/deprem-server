package androidx.privacysandbox.ads.adservices.customaudience;

import android.net.Uri;
import java.util.List;
import kotlin.jvm.internal.t;

public final class TrustedBiddingData {
    private final List<String> trustedBiddingKeys;
    private final Uri trustedBiddingUri;

    public TrustedBiddingData(Uri uri, List<String> list) {
        t.e(uri, "trustedBiddingUri");
        t.e(list, "trustedBiddingKeys");
        this.trustedBiddingUri = uri;
        this.trustedBiddingKeys = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TrustedBiddingData)) {
            return false;
        }
        TrustedBiddingData trustedBiddingData = (TrustedBiddingData) obj;
        if (!t.a(this.trustedBiddingUri, trustedBiddingData.trustedBiddingUri) || !t.a(this.trustedBiddingKeys, trustedBiddingData.trustedBiddingKeys)) {
            return false;
        }
        return true;
    }

    public final List<String> getTrustedBiddingKeys() {
        return this.trustedBiddingKeys;
    }

    public final Uri getTrustedBiddingUri() {
        return this.trustedBiddingUri;
    }

    public int hashCode() {
        return (this.trustedBiddingUri.hashCode() * 31) + this.trustedBiddingKeys.hashCode();
    }

    public String toString() {
        return "TrustedBiddingData: trustedBiddingUri=" + this.trustedBiddingUri + " trustedBiddingKeys=" + this.trustedBiddingKeys;
    }
}
