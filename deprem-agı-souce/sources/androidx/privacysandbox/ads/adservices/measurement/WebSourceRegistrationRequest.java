package androidx.privacysandbox.ads.adservices.measurement;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.view.InputEvent;
import androidx.annotation.RequiresExtension;
import java.util.List;
import kotlin.jvm.internal.t;

public final class WebSourceRegistrationRequest {
    private final Uri appDestination;
    private final InputEvent inputEvent;
    private final Uri topOriginUri;
    private final Uri verifiedDestination;
    private final Uri webDestination;
    private final List<WebSourceParams> webSourceParams;

    public static final class Builder {
        private Uri appDestination;
        private InputEvent inputEvent;
        private final Uri topOriginUri;
        private Uri verifiedDestination;
        private Uri webDestination;
        private final List<WebSourceParams> webSourceParams;

        public Builder(List<WebSourceParams> list, Uri uri) {
            t.e(list, "webSourceParams");
            t.e(uri, "topOriginUri");
            this.webSourceParams = list;
            this.topOriginUri = uri;
        }

        public final WebSourceRegistrationRequest build() {
            return new WebSourceRegistrationRequest(this.webSourceParams, this.topOriginUri, this.inputEvent, this.appDestination, this.webDestination, this.verifiedDestination);
        }

        public final Builder setAppDestination(Uri uri) {
            this.appDestination = uri;
            return this;
        }

        public final Builder setInputEvent(InputEvent inputEvent2) {
            t.e(inputEvent2, "inputEvent");
            this.inputEvent = inputEvent2;
            return this;
        }

        public final Builder setVerifiedDestination(Uri uri) {
            this.verifiedDestination = uri;
            return this;
        }

        public final Builder setWebDestination(Uri uri) {
            this.webDestination = uri;
            return this;
        }
    }

    public WebSourceRegistrationRequest(List<WebSourceParams> list, Uri uri, InputEvent inputEvent2, Uri uri2, Uri uri3, Uri uri4) {
        t.e(list, "webSourceParams");
        t.e(uri, "topOriginUri");
        this.webSourceParams = list;
        this.topOriginUri = uri;
        this.inputEvent = inputEvent2;
        this.appDestination = uri2;
        this.webDestination = uri3;
        this.verifiedDestination = uri4;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    @SuppressLint({"ClassVerificationFailure", "NewApi"})
    public final android.adservices.measurement.WebSourceRegistrationRequest convertToAdServices$ads_adservices_release() {
        B.a();
        android.adservices.measurement.WebSourceRegistrationRequest a5 = A.a(WebSourceParams.Companion.convertWebSourceParams$ads_adservices_release(this.webSourceParams), this.topOriginUri).setWebDestination(this.webDestination).setAppDestination(this.appDestination).setInputEvent(this.inputEvent).setVerifiedDestination(this.verifiedDestination).build();
        t.d(a5, "Builder(\n               …ion)\n            .build()");
        return a5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebSourceRegistrationRequest)) {
            return false;
        }
        WebSourceRegistrationRequest webSourceRegistrationRequest = (WebSourceRegistrationRequest) obj;
        if (!t.a(this.webSourceParams, webSourceRegistrationRequest.webSourceParams) || !t.a(this.webDestination, webSourceRegistrationRequest.webDestination) || !t.a(this.appDestination, webSourceRegistrationRequest.appDestination) || !t.a(this.topOriginUri, webSourceRegistrationRequest.topOriginUri) || !t.a(this.inputEvent, webSourceRegistrationRequest.inputEvent) || !t.a(this.verifiedDestination, webSourceRegistrationRequest.verifiedDestination)) {
            return false;
        }
        return true;
    }

    public final Uri getAppDestination() {
        return this.appDestination;
    }

    public final InputEvent getInputEvent() {
        return this.inputEvent;
    }

    public final Uri getTopOriginUri() {
        return this.topOriginUri;
    }

    public final Uri getVerifiedDestination() {
        return this.verifiedDestination;
    }

    public final Uri getWebDestination() {
        return this.webDestination;
    }

    public final List<WebSourceParams> getWebSourceParams() {
        return this.webSourceParams;
    }

    public int hashCode() {
        int hashCode = (this.webSourceParams.hashCode() * 31) + this.topOriginUri.hashCode();
        InputEvent inputEvent2 = this.inputEvent;
        if (inputEvent2 != null) {
            hashCode = (hashCode * 31) + inputEvent2.hashCode();
        }
        Uri uri = this.appDestination;
        if (uri != null) {
            hashCode = (hashCode * 31) + uri.hashCode();
        }
        Uri uri2 = this.webDestination;
        if (uri2 != null) {
            hashCode = (hashCode * 31) + uri2.hashCode();
        }
        int hashCode2 = (hashCode * 31) + this.topOriginUri.hashCode();
        InputEvent inputEvent3 = this.inputEvent;
        if (inputEvent3 != null) {
            hashCode2 = (hashCode2 * 31) + inputEvent3.hashCode();
        }
        Uri uri3 = this.verifiedDestination;
        if (uri3 != null) {
            return (hashCode2 * 31) + uri3.hashCode();
        }
        return hashCode2;
    }

    public String toString() {
        return "WebSourceRegistrationRequest { " + ("WebSourceParams=[" + this.webSourceParams + "], TopOriginUri=" + this.topOriginUri + ", InputEvent=" + this.inputEvent + ", AppDestination=" + this.appDestination + ", WebDestination=" + this.webDestination + ", VerifiedDestination=" + this.verifiedDestination) + " }";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ WebSourceRegistrationRequest(java.util.List r2, android.net.Uri r3, android.view.InputEvent r4, android.net.Uri r5, android.net.Uri r6, android.net.Uri r7, int r8, kotlin.jvm.internal.C2633k r9) {
        /*
            r1 = this;
            r9 = r8 & 4
            r0 = 0
            if (r9 == 0) goto L_0x0006
            r4 = r0
        L_0x0006:
            r9 = r8 & 8
            if (r9 == 0) goto L_0x000b
            r5 = r0
        L_0x000b:
            r9 = r8 & 16
            if (r9 == 0) goto L_0x0010
            r6 = r0
        L_0x0010:
            r8 = r8 & 32
            if (r8 == 0) goto L_0x001c
            r8 = r0
        L_0x0015:
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            goto L_0x001e
        L_0x001c:
            r8 = r7
            goto L_0x0015
        L_0x001e:
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.measurement.WebSourceRegistrationRequest.<init>(java.util.List, android.net.Uri, android.view.InputEvent, android.net.Uri, android.net.Uri, android.net.Uri, int, kotlin.jvm.internal.k):void");
    }
}
