package androidx.privacysandbox.ads.adservices.signals;

import android.net.Uri;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import kotlin.jvm.internal.t;

@ExperimentalFeatures.Ext12OptIn
public final class UpdateSignalsRequest {
    private final Uri updateUri;

    public UpdateSignalsRequest(Uri uri) {
        t.e(uri, "updateUri");
        this.updateUri = uri;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpdateSignalsRequest)) {
            return false;
        }
        return t.a(this.updateUri, ((UpdateSignalsRequest) obj).updateUri);
    }

    public final Uri getUpdateUri() {
        return this.updateUri;
    }

    public int hashCode() {
        return this.updateUri.hashCode();
    }

    public String toString() {
        return "UpdateSignalsRequest: updateUri=" + this.updateUri;
    }
}
