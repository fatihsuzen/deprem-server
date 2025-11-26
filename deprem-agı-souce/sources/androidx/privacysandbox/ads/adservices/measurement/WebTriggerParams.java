package androidx.privacysandbox.ads.adservices.measurement;

import android.annotation.SuppressLint;
import android.net.Uri;
import androidx.annotation.RequiresExtension;
import androidx.privacysandbox.ads.adservices.adid.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class WebTriggerParams {
    public static final Companion Companion = new Companion((C2633k) null);
    private final boolean debugKeyAllowed;
    private final Uri registrationUri;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
        @SuppressLint({"ClassVerificationFailure", "NewApi"})
        public final List<android.adservices.measurement.WebTriggerParams> convertWebTriggerParams$ads_adservices_release(List<WebTriggerParams> list) {
            t.e(list, "request");
            ArrayList arrayList = new ArrayList();
            for (WebTriggerParams next : list) {
                F.a();
                android.adservices.measurement.WebTriggerParams a5 = E.a(next.getRegistrationUri()).setDebugKeyAllowed(next.getDebugKeyAllowed()).build();
                t.d(a5, "Builder(param.registrati…                 .build()");
                arrayList.add(a5);
            }
            return arrayList;
        }

        private Companion() {
        }
    }

    public WebTriggerParams(Uri uri, boolean z4) {
        t.e(uri, "registrationUri");
        this.registrationUri = uri;
        this.debugKeyAllowed = z4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebTriggerParams)) {
            return false;
        }
        WebTriggerParams webTriggerParams = (WebTriggerParams) obj;
        if (!t.a(this.registrationUri, webTriggerParams.registrationUri) || this.debugKeyAllowed != webTriggerParams.debugKeyAllowed) {
            return false;
        }
        return true;
    }

    public final boolean getDebugKeyAllowed() {
        return this.debugKeyAllowed;
    }

    public final Uri getRegistrationUri() {
        return this.registrationUri;
    }

    public int hashCode() {
        return (this.registrationUri.hashCode() * 31) + a.a(this.debugKeyAllowed);
    }

    public String toString() {
        return "WebTriggerParams { RegistrationUri=" + this.registrationUri + ", DebugKeyAllowed=" + this.debugKeyAllowed + " }";
    }
}
