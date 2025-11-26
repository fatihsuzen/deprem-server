package com.inmobi.cmp.model;

import J2.v;
import androidx.annotation.Keep;
import com.inmobi.cmp.core.cmpapi.status.CmpStatus;
import com.inmobi.cmp.core.cmpapi.status.DisplayStatus;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import t4.a;

@Keep
public final class PingReturn {
    public static final a Companion = new a();
    /* access modifiers changed from: private */
    public static final PingReturn LOADING_PING;
    /* access modifiers changed from: private */
    public static final PingReturn STUB_PING;
    private String apiVersion;
    private Integer cmpId;
    private boolean cmpLoaded;
    private CmpStatus cmpStatus;
    private String cmpVersion;
    private DisplayStatus displayStatus;
    private Boolean gdprApplies;
    private Integer gvlVersion;
    private Integer tcfPolicyVersion;
    private Boolean usRegulationApplies;

    static {
        CmpStatus cmpStatus2 = CmpStatus.STUB;
        DisplayStatus displayStatus2 = DisplayStatus.HIDDEN;
        STUB_PING = new PingReturn((Boolean) null, false, cmpStatus2, displayStatus2, MBridgeConstans.NATIVE_VIDEO_VERSION, (String) null, (Integer) null, (Integer) null, (Integer) null, (Boolean) null, 512, (C2633k) null);
        LOADING_PING = new PingReturn((Boolean) null, false, CmpStatus.LOADING, displayStatus2, MBridgeConstans.NATIVE_VIDEO_VERSION, "0.1", 10, (Integer) null, (Integer) null, (Boolean) null, 512, (C2633k) null);
    }

    public PingReturn(Boolean bool, boolean z4, CmpStatus cmpStatus2, DisplayStatus displayStatus2, String str, String str2, Integer num, Integer num2, Integer num3, Boolean bool2) {
        t.e(cmpStatus2, "cmpStatus");
        t.e(displayStatus2, "displayStatus");
        t.e(str, "apiVersion");
        this.gdprApplies = bool;
        this.cmpLoaded = z4;
        this.cmpStatus = cmpStatus2;
        this.displayStatus = displayStatus2;
        this.apiVersion = str;
        this.cmpVersion = str2;
        this.cmpId = num;
        this.gvlVersion = num2;
        this.tcfPolicyVersion = num3;
        this.usRegulationApplies = bool2;
    }

    public static /* synthetic */ PingReturn copy$default(PingReturn pingReturn, Boolean bool, boolean z4, CmpStatus cmpStatus2, DisplayStatus displayStatus2, String str, String str2, Integer num, Integer num2, Integer num3, Boolean bool2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            bool = pingReturn.gdprApplies;
        }
        if ((i5 & 2) != 0) {
            z4 = pingReturn.cmpLoaded;
        }
        if ((i5 & 4) != 0) {
            cmpStatus2 = pingReturn.cmpStatus;
        }
        if ((i5 & 8) != 0) {
            displayStatus2 = pingReturn.displayStatus;
        }
        if ((i5 & 16) != 0) {
            str = pingReturn.apiVersion;
        }
        if ((i5 & 32) != 0) {
            str2 = pingReturn.cmpVersion;
        }
        if ((i5 & 64) != 0) {
            num = pingReturn.cmpId;
        }
        if ((i5 & 128) != 0) {
            num2 = pingReturn.gvlVersion;
        }
        if ((i5 & 256) != 0) {
            num3 = pingReturn.tcfPolicyVersion;
        }
        if ((i5 & 512) != 0) {
            bool2 = pingReturn.usRegulationApplies;
        }
        Integer num4 = num3;
        Boolean bool3 = bool2;
        Integer num5 = num;
        Integer num6 = num2;
        String str3 = str;
        String str4 = str2;
        DisplayStatus displayStatus3 = displayStatus2;
        boolean z5 = z4;
        return pingReturn.copy(bool, z5, cmpStatus2, displayStatus3, str3, str4, num5, num6, num4, bool3);
    }

    public final Boolean component1() {
        return this.gdprApplies;
    }

    public final Boolean component10() {
        return this.usRegulationApplies;
    }

    public final boolean component2() {
        return this.cmpLoaded;
    }

    public final CmpStatus component3() {
        return this.cmpStatus;
    }

    public final DisplayStatus component4() {
        return this.displayStatus;
    }

    public final String component5() {
        return this.apiVersion;
    }

    public final String component6() {
        return this.cmpVersion;
    }

    public final Integer component7() {
        return this.cmpId;
    }

    public final Integer component8() {
        return this.gvlVersion;
    }

    public final Integer component9() {
        return this.tcfPolicyVersion;
    }

    public final PingReturn copy(Boolean bool, boolean z4, CmpStatus cmpStatus2, DisplayStatus displayStatus2, String str, String str2, Integer num, Integer num2, Integer num3, Boolean bool2) {
        t.e(cmpStatus2, "cmpStatus");
        DisplayStatus displayStatus3 = displayStatus2;
        t.e(displayStatus3, "displayStatus");
        String str3 = str;
        t.e(str3, "apiVersion");
        return new PingReturn(bool, z4, cmpStatus2, displayStatus3, str3, str2, num, num2, num3, bool2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PingReturn)) {
            return false;
        }
        PingReturn pingReturn = (PingReturn) obj;
        return t.a(this.gdprApplies, pingReturn.gdprApplies) && this.cmpLoaded == pingReturn.cmpLoaded && this.cmpStatus == pingReturn.cmpStatus && this.displayStatus == pingReturn.displayStatus && t.a(this.apiVersion, pingReturn.apiVersion) && t.a(this.cmpVersion, pingReturn.cmpVersion) && t.a(this.cmpId, pingReturn.cmpId) && t.a(this.gvlVersion, pingReturn.gvlVersion) && t.a(this.tcfPolicyVersion, pingReturn.tcfPolicyVersion) && t.a(this.usRegulationApplies, pingReturn.usRegulationApplies);
    }

    public final String getApiVersion() {
        return this.apiVersion;
    }

    public final Integer getCmpId() {
        return this.cmpId;
    }

    public final boolean getCmpLoaded() {
        return this.cmpLoaded;
    }

    public final CmpStatus getCmpStatus() {
        return this.cmpStatus;
    }

    public final String getCmpVersion() {
        return this.cmpVersion;
    }

    public final DisplayStatus getDisplayStatus() {
        return this.displayStatus;
    }

    public final Boolean getGdprApplies() {
        return this.gdprApplies;
    }

    public final Integer getGvlVersion() {
        return this.gvlVersion;
    }

    public final Integer getTcfPolicyVersion() {
        return this.tcfPolicyVersion;
    }

    public final Boolean getUsRegulationApplies() {
        return this.usRegulationApplies;
    }

    public int hashCode() {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        Boolean bool = this.gdprApplies;
        int i10 = 0;
        if (bool == null) {
            i5 = 0;
        } else {
            i5 = bool.hashCode();
        }
        int i11 = i5 * 31;
        boolean z4 = this.cmpLoaded;
        if (z4) {
            z4 = true;
        }
        int hashCode = this.cmpStatus.hashCode();
        int a5 = v.a(this.apiVersion, (this.displayStatus.hashCode() + ((hashCode + ((i11 + (z4 ? 1 : 0)) * 31)) * 31)) * 31, 31);
        String str = this.cmpVersion;
        if (str == null) {
            i6 = 0;
        } else {
            i6 = str.hashCode();
        }
        int i12 = (a5 + i6) * 31;
        Integer num = this.cmpId;
        if (num == null) {
            i7 = 0;
        } else {
            i7 = num.hashCode();
        }
        int i13 = (i12 + i7) * 31;
        Integer num2 = this.gvlVersion;
        if (num2 == null) {
            i8 = 0;
        } else {
            i8 = num2.hashCode();
        }
        int i14 = (i13 + i8) * 31;
        Integer num3 = this.tcfPolicyVersion;
        if (num3 == null) {
            i9 = 0;
        } else {
            i9 = num3.hashCode();
        }
        int i15 = (i14 + i9) * 31;
        Boolean bool2 = this.usRegulationApplies;
        if (bool2 != null) {
            i10 = bool2.hashCode();
        }
        return i15 + i10;
    }

    public final void setApiVersion(String str) {
        t.e(str, "<set-?>");
        this.apiVersion = str;
    }

    public final void setCmpId(Integer num) {
        this.cmpId = num;
    }

    public final void setCmpLoaded(boolean z4) {
        this.cmpLoaded = z4;
    }

    public final void setCmpStatus(CmpStatus cmpStatus2) {
        t.e(cmpStatus2, "<set-?>");
        this.cmpStatus = cmpStatus2;
    }

    public final void setCmpVersion(String str) {
        this.cmpVersion = str;
    }

    public final void setDisplayStatus(DisplayStatus displayStatus2) {
        t.e(displayStatus2, "<set-?>");
        this.displayStatus = displayStatus2;
    }

    public final void setGdprApplies(Boolean bool) {
        this.gdprApplies = bool;
    }

    public final void setGvlVersion(Integer num) {
        this.gvlVersion = num;
    }

    public final void setTcfPolicyVersion(Integer num) {
        this.tcfPolicyVersion = num;
    }

    public final void setUsRegulationApplies(Boolean bool) {
        this.usRegulationApplies = bool;
    }

    public String toString() {
        return "PingReturn(gdprApplies=" + this.gdprApplies + ", cmpLoaded=" + this.cmpLoaded + ", cmpStatus=" + this.cmpStatus + ", displayStatus=" + this.displayStatus + ", apiVersion=" + this.apiVersion + ", cmpVersion=" + this.cmpVersion + ", cmpId=" + this.cmpId + ", gvlVersion=" + this.gvlVersion + ", tcfPolicyVersion=" + this.tcfPolicyVersion + ", usRegulationApplies=" + this.usRegulationApplies + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PingReturn(Boolean bool, boolean z4, CmpStatus cmpStatus2, DisplayStatus displayStatus2, String str, String str2, Integer num, Integer num2, Integer num3, Boolean bool2, int i5, C2633k kVar) {
        this(bool, z4, cmpStatus2, displayStatus2, str, str2, num, num2, num3, (i5 & 512) != 0 ? null : bool2);
    }
}
