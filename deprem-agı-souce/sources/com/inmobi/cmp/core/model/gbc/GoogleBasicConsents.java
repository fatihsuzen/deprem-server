package com.inmobi.cmp.core.model.gbc;

import androidx.annotation.Keep;
import com.inmobi.cmp.core.model.portalconfig.GBCConsentValue;
import kotlin.jvm.internal.t;

@Keep
public final class GoogleBasicConsents {
    private final GBCConsentValue adPersonalization;
    private final GBCConsentValue adStorage;
    private final GBCConsentValue adUserData;
    private final GBCConsentValue analyticsStorage;

    public GoogleBasicConsents(GBCConsentValue gBCConsentValue, GBCConsentValue gBCConsentValue2, GBCConsentValue gBCConsentValue3, GBCConsentValue gBCConsentValue4) {
        t.e(gBCConsentValue, "adStorage");
        t.e(gBCConsentValue2, "adUserData");
        t.e(gBCConsentValue3, "adPersonalization");
        t.e(gBCConsentValue4, "analyticsStorage");
        this.adStorage = gBCConsentValue;
        this.adUserData = gBCConsentValue2;
        this.adPersonalization = gBCConsentValue3;
        this.analyticsStorage = gBCConsentValue4;
    }

    public static /* synthetic */ GoogleBasicConsents copy$default(GoogleBasicConsents googleBasicConsents, GBCConsentValue gBCConsentValue, GBCConsentValue gBCConsentValue2, GBCConsentValue gBCConsentValue3, GBCConsentValue gBCConsentValue4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            gBCConsentValue = googleBasicConsents.adStorage;
        }
        if ((i5 & 2) != 0) {
            gBCConsentValue2 = googleBasicConsents.adUserData;
        }
        if ((i5 & 4) != 0) {
            gBCConsentValue3 = googleBasicConsents.adPersonalization;
        }
        if ((i5 & 8) != 0) {
            gBCConsentValue4 = googleBasicConsents.analyticsStorage;
        }
        return googleBasicConsents.copy(gBCConsentValue, gBCConsentValue2, gBCConsentValue3, gBCConsentValue4);
    }

    public final GBCConsentValue component1() {
        return this.adStorage;
    }

    public final GBCConsentValue component2() {
        return this.adUserData;
    }

    public final GBCConsentValue component3() {
        return this.adPersonalization;
    }

    public final GBCConsentValue component4() {
        return this.analyticsStorage;
    }

    public final GoogleBasicConsents copy(GBCConsentValue gBCConsentValue, GBCConsentValue gBCConsentValue2, GBCConsentValue gBCConsentValue3, GBCConsentValue gBCConsentValue4) {
        t.e(gBCConsentValue, "adStorage");
        t.e(gBCConsentValue2, "adUserData");
        t.e(gBCConsentValue3, "adPersonalization");
        t.e(gBCConsentValue4, "analyticsStorage");
        return new GoogleBasicConsents(gBCConsentValue, gBCConsentValue2, gBCConsentValue3, gBCConsentValue4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoogleBasicConsents)) {
            return false;
        }
        GoogleBasicConsents googleBasicConsents = (GoogleBasicConsents) obj;
        return this.adStorage == googleBasicConsents.adStorage && this.adUserData == googleBasicConsents.adUserData && this.adPersonalization == googleBasicConsents.adPersonalization && this.analyticsStorage == googleBasicConsents.analyticsStorage;
    }

    public final GBCConsentValue getAdPersonalization() {
        return this.adPersonalization;
    }

    public final GBCConsentValue getAdStorage() {
        return this.adStorage;
    }

    public final GBCConsentValue getAdUserData() {
        return this.adUserData;
    }

    public final GBCConsentValue getAnalyticsStorage() {
        return this.analyticsStorage;
    }

    public int hashCode() {
        int hashCode = this.adUserData.hashCode();
        int hashCode2 = this.adPersonalization.hashCode();
        return this.analyticsStorage.hashCode() + ((hashCode2 + ((hashCode + (this.adStorage.hashCode() * 31)) * 31)) * 31);
    }

    public String toString() {
        return "GoogleBasicConsents(adStorage=" + this.adStorage + ", adUserData=" + this.adUserData + ", adPersonalization=" + this.adPersonalization + ", analyticsStorage=" + this.analyticsStorage + ')';
    }
}
