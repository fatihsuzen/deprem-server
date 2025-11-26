package androidx.privacysandbox.ads.adservices.customaudience;

import android.adservices.customaudience.FetchAndJoinCustomAudienceRequest;
import android.net.Uri;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.AdSelectionSignals;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import j$.time.Instant;
import j$.time.TimeConversions;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

@ExperimentalFeatures.Ext10OptIn
public final class FetchAndJoinCustomAudienceRequest {
    private final Instant activationTime;
    private final Instant expirationTime;
    private final Uri fetchUri;
    private final String name;
    private final AdSelectionSignals userBiddingSignals;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FetchAndJoinCustomAudienceRequest(Uri uri) {
        this(uri, (String) null, (Instant) null, (Instant) null, (AdSelectionSignals) null, 30, (C2633k) null);
        t.e(uri, "fetchUri");
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 10), @RequiresExtension(extension = 31, version = 10)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.customaudience.FetchAndJoinCustomAudienceRequest convertToAdServices$ads_adservices_release() {
        android.adservices.common.AdSelectionSignals adSelectionSignals;
        I.a();
        FetchAndJoinCustomAudienceRequest.Builder a5 = H.a(this.fetchUri).setName(this.name).setActivationTime(TimeConversions.convert(this.activationTime)).setExpirationTime(TimeConversions.convert(this.expirationTime));
        AdSelectionSignals adSelectionSignals2 = this.userBiddingSignals;
        if (adSelectionSignals2 != null) {
            adSelectionSignals = adSelectionSignals2.convertToAdServices$ads_adservices_release();
        } else {
            adSelectionSignals = null;
        }
        android.adservices.customaudience.FetchAndJoinCustomAudienceRequest a6 = a5.setUserBiddingSignals(adSelectionSignals).build();
        t.d(a6, "Builder(fetchUri)\n      …s())\n            .build()");
        return a6;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FetchAndJoinCustomAudienceRequest)) {
            return false;
        }
        FetchAndJoinCustomAudienceRequest fetchAndJoinCustomAudienceRequest = (FetchAndJoinCustomAudienceRequest) obj;
        if (!t.a(this.fetchUri, fetchAndJoinCustomAudienceRequest.fetchUri) || !t.a(this.name, fetchAndJoinCustomAudienceRequest.name) || !t.a(this.activationTime, fetchAndJoinCustomAudienceRequest.activationTime) || !t.a(this.expirationTime, fetchAndJoinCustomAudienceRequest.expirationTime) || !t.a(this.userBiddingSignals, fetchAndJoinCustomAudienceRequest.userBiddingSignals)) {
            return false;
        }
        return true;
    }

    public final Instant getActivationTime() {
        return this.activationTime;
    }

    public final Instant getExpirationTime() {
        return this.expirationTime;
    }

    public final Uri getFetchUri() {
        return this.fetchUri;
    }

    public final String getName() {
        return this.name;
    }

    public final AdSelectionSignals getUserBiddingSignals() {
        return this.userBiddingSignals;
    }

    public int hashCode() {
        int i5;
        int i6;
        int i7;
        int hashCode = this.fetchUri.hashCode() * 31;
        String str = this.name;
        int i8 = 0;
        if (str != null) {
            i5 = str.hashCode();
        } else {
            i5 = 0;
        }
        int i9 = (hashCode + i5) * 31;
        Instant instant = this.activationTime;
        if (instant != null) {
            i6 = instant.hashCode();
        } else {
            i6 = 0;
        }
        int i10 = (i9 + i6) * 31;
        Instant instant2 = this.expirationTime;
        if (instant2 != null) {
            i7 = instant2.hashCode();
        } else {
            i7 = 0;
        }
        int i11 = (i10 + i7) * 31;
        AdSelectionSignals adSelectionSignals = this.userBiddingSignals;
        if (adSelectionSignals != null) {
            i8 = adSelectionSignals.hashCode();
        }
        return i11 + i8;
    }

    public String toString() {
        return "FetchAndJoinCustomAudienceRequest: fetchUri=" + this.fetchUri + ", name=" + this.name + ", activationTime=" + this.activationTime + ", expirationTime=" + this.expirationTime + ", userBiddingSignals=" + this.userBiddingSignals;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FetchAndJoinCustomAudienceRequest(Uri uri, String str) {
        this(uri, str, (Instant) null, (Instant) null, (AdSelectionSignals) null, 28, (C2633k) null);
        t.e(uri, "fetchUri");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FetchAndJoinCustomAudienceRequest(Uri uri, String str, Instant instant) {
        this(uri, str, instant, (Instant) null, (AdSelectionSignals) null, 24, (C2633k) null);
        t.e(uri, "fetchUri");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FetchAndJoinCustomAudienceRequest(Uri uri, String str, Instant instant, Instant instant2) {
        this(uri, str, instant, instant2, (AdSelectionSignals) null, 16, (C2633k) null);
        t.e(uri, "fetchUri");
    }

    public FetchAndJoinCustomAudienceRequest(Uri uri, String str, Instant instant, Instant instant2, AdSelectionSignals adSelectionSignals) {
        t.e(uri, "fetchUri");
        this.fetchUri = uri;
        this.name = str;
        this.activationTime = instant;
        this.expirationTime = instant2;
        this.userBiddingSignals = adSelectionSignals;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FetchAndJoinCustomAudienceRequest(android.net.Uri r2, java.lang.String r3, j$.time.Instant r4, j$.time.Instant r5, androidx.privacysandbox.ads.adservices.common.AdSelectionSignals r6, int r7, kotlin.jvm.internal.C2633k r8) {
        /*
            r1 = this;
            r8 = r7 & 2
            r0 = 0
            if (r8 == 0) goto L_0x0006
            r3 = r0
        L_0x0006:
            r8 = r7 & 4
            if (r8 == 0) goto L_0x000b
            r4 = r0
        L_0x000b:
            r8 = r7 & 8
            if (r8 == 0) goto L_0x0010
            r5 = r0
        L_0x0010:
            r7 = r7 & 16
            if (r7 == 0) goto L_0x001b
            r7 = r0
        L_0x0015:
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            goto L_0x001d
        L_0x001b:
            r7 = r6
            goto L_0x0015
        L_0x001d:
            r2.<init>(r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.customaudience.FetchAndJoinCustomAudienceRequest.<init>(android.net.Uri, java.lang.String, j$.time.Instant, j$.time.Instant, androidx.privacysandbox.ads.adservices.common.AdSelectionSignals, int, kotlin.jvm.internal.k):void");
    }
}
