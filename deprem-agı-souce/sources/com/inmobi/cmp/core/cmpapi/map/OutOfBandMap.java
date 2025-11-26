package com.inmobi.cmp.core.cmpapi.map;

import androidx.annotation.Keep;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

@Keep
public final class OutOfBandMap {
    private Map<String, Boolean> allowedVendors;
    private Map<String, Boolean> disclosedVendors;

    public OutOfBandMap() {
        this((Map) null, (Map) null, 3, (C2633k) null);
    }

    public static /* synthetic */ OutOfBandMap copy$default(OutOfBandMap outOfBandMap, Map<String, Boolean> map, Map<String, Boolean> map2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            map = outOfBandMap.allowedVendors;
        }
        if ((i5 & 2) != 0) {
            map2 = outOfBandMap.disclosedVendors;
        }
        return outOfBandMap.copy(map, map2);
    }

    public final Map<String, Boolean> component1() {
        return this.allowedVendors;
    }

    public final Map<String, Boolean> component2() {
        return this.disclosedVendors;
    }

    public final OutOfBandMap copy(Map<String, Boolean> map, Map<String, Boolean> map2) {
        t.e(map, "allowedVendors");
        t.e(map2, "disclosedVendors");
        return new OutOfBandMap(map, map2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OutOfBandMap)) {
            return false;
        }
        OutOfBandMap outOfBandMap = (OutOfBandMap) obj;
        return t.a(this.allowedVendors, outOfBandMap.allowedVendors) && t.a(this.disclosedVendors, outOfBandMap.disclosedVendors);
    }

    public final Map<String, Boolean> getAllowedVendors() {
        return this.allowedVendors;
    }

    public final Map<String, Boolean> getDisclosedVendors() {
        return this.disclosedVendors;
    }

    public int hashCode() {
        return this.disclosedVendors.hashCode() + (this.allowedVendors.hashCode() * 31);
    }

    public final void setAllowedVendors(Map<String, Boolean> map) {
        t.e(map, "<set-?>");
        this.allowedVendors = map;
    }

    public final void setDisclosedVendors(Map<String, Boolean> map) {
        t.e(map, "<set-?>");
        this.disclosedVendors = map;
    }

    public String toString() {
        return "OutOfBandMap(allowedVendors=" + this.allowedVendors + ", disclosedVendors=" + this.disclosedVendors + ')';
    }

    public OutOfBandMap(Map<String, Boolean> map, Map<String, Boolean> map2) {
        t.e(map, "allowedVendors");
        t.e(map2, "disclosedVendors");
        this.allowedVendors = map;
        this.disclosedVendors = map2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OutOfBandMap(Map map, Map map2, int i5, C2633k kVar) {
        this((i5 & 1) != 0 ? new LinkedHashMap() : map, (i5 & 2) != 0 ? new LinkedHashMap() : map2);
    }
}
