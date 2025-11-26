package androidx.privacysandbox.ads.adservices.measurement;

import android.annotation.SuppressLint;
import android.net.Uri;
import androidx.annotation.RequiresExtension;
import java.util.List;
import kotlin.jvm.internal.t;

public final class WebTriggerRegistrationRequest {
    private final Uri destination;
    private final List<WebTriggerParams> webTriggerParams;

    public WebTriggerRegistrationRequest(List<WebTriggerParams> list, Uri uri) {
        t.e(list, "webTriggerParams");
        t.e(uri, "destination");
        this.webTriggerParams = list;
        this.destination = uri;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    @SuppressLint({"ClassVerificationFailure", "NewApi"})
    public final android.adservices.measurement.WebTriggerRegistrationRequest convertToAdServices$ads_adservices_release() {
        I.a();
        android.adservices.measurement.WebTriggerRegistrationRequest a5 = H.a(WebTriggerParams.Companion.convertWebTriggerParams$ads_adservices_release(this.webTriggerParams), this.destination).build();
        t.d(a5, "Builder(\n               …   )\n            .build()");
        return a5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebTriggerRegistrationRequest)) {
            return false;
        }
        WebTriggerRegistrationRequest webTriggerRegistrationRequest = (WebTriggerRegistrationRequest) obj;
        if (!t.a(this.webTriggerParams, webTriggerRegistrationRequest.webTriggerParams) || !t.a(this.destination, webTriggerRegistrationRequest.destination)) {
            return false;
        }
        return true;
    }

    public final Uri getDestination() {
        return this.destination;
    }

    public final List<WebTriggerParams> getWebTriggerParams() {
        return this.webTriggerParams;
    }

    public int hashCode() {
        return (this.webTriggerParams.hashCode() * 31) + this.destination.hashCode();
    }

    public String toString() {
        return "WebTriggerRegistrationRequest { WebTriggerParams=" + this.webTriggerParams + ", Destination=" + this.destination;
    }
}
