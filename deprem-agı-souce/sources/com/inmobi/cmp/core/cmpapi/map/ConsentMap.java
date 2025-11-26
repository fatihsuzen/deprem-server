package com.inmobi.cmp.core.cmpapi.map;

import androidx.annotation.Keep;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

@Keep
public final class ConsentMap {
    private Map<String, Boolean> consents;
    private Map<String, Boolean> legitimateInterests;

    public ConsentMap() {
        this((Map) null, (Map) null, 3, (C2633k) null);
    }

    public static /* synthetic */ ConsentMap copy$default(ConsentMap consentMap, Map<String, Boolean> map, Map<String, Boolean> map2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            map = consentMap.consents;
        }
        if ((i5 & 2) != 0) {
            map2 = consentMap.legitimateInterests;
        }
        return consentMap.copy(map, map2);
    }

    public final Map<String, Boolean> component1() {
        return this.consents;
    }

    public final Map<String, Boolean> component2() {
        return this.legitimateInterests;
    }

    public final ConsentMap copy(Map<String, Boolean> map, Map<String, Boolean> map2) {
        t.e(map, "consents");
        t.e(map2, "legitimateInterests");
        return new ConsentMap(map, map2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConsentMap)) {
            return false;
        }
        ConsentMap consentMap = (ConsentMap) obj;
        return t.a(this.consents, consentMap.consents) && t.a(this.legitimateInterests, consentMap.legitimateInterests);
    }

    public final Map<String, Boolean> getConsents() {
        return this.consents;
    }

    public final Map<String, Boolean> getLegitimateInterests() {
        return this.legitimateInterests;
    }

    public int hashCode() {
        return this.legitimateInterests.hashCode() + (this.consents.hashCode() * 31);
    }

    public final void setConsents(Map<String, Boolean> map) {
        t.e(map, "<set-?>");
        this.consents = map;
    }

    public final void setLegitimateInterests(Map<String, Boolean> map) {
        t.e(map, "<set-?>");
        this.legitimateInterests = map;
    }

    public String toString() {
        return "ConsentMap(consents=" + this.consents + ", legitimateInterests=" + this.legitimateInterests + ')';
    }

    public ConsentMap(Map<String, Boolean> map, Map<String, Boolean> map2) {
        t.e(map, "consents");
        t.e(map2, "legitimateInterests");
        this.consents = map;
        this.legitimateInterests = map2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConsentMap(Map map, Map map2, int i5, C2633k kVar) {
        this((i5 & 1) != 0 ? new LinkedHashMap() : map, (i5 & 2) != 0 ? new LinkedHashMap() : map2);
    }
}
