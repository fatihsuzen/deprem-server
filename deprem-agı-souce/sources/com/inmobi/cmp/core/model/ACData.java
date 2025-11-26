package com.inmobi.cmp.core.model;

import androidx.annotation.Keep;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

@Keep
public final class ACData {
    private final String acString;

    public ACData() {
        this((String) null, 1, (C2633k) null);
    }

    public static /* synthetic */ ACData copy$default(ACData aCData, String str, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = aCData.acString;
        }
        return aCData.copy(str);
    }

    public final String component1() {
        return this.acString;
    }

    public final ACData copy(String str) {
        return new ACData(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ACData) && t.a(this.acString, ((ACData) obj).acString);
    }

    public final String getAcString() {
        return this.acString;
    }

    public int hashCode() {
        String str = this.acString;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "ACData(acString=" + this.acString + ')';
    }

    public ACData(String str) {
        this.acString = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ACData(String str, int i5, C2633k kVar) {
        this((i5 & 1) != 0 ? null : str);
    }
}
