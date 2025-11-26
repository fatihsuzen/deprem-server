package k4;

import J2.v;
import kotlin.jvm.internal.t;
import org.json.JSONObject;

public final class n extends m {

    /* renamed from: h  reason: collision with root package name */
    public final String f24615h;

    /* renamed from: i  reason: collision with root package name */
    public final String f24616i;

    /* renamed from: j  reason: collision with root package name */
    public final int f24617j;

    /* renamed from: k  reason: collision with root package name */
    public final String f24618k;

    /* renamed from: l  reason: collision with root package name */
    public final String f24619l;

    /* renamed from: m  reason: collision with root package name */
    public final c f24620m;

    /* renamed from: n  reason: collision with root package name */
    public final c f24621n;

    /* renamed from: o  reason: collision with root package name */
    public final String f24622o;

    /* renamed from: p  reason: collision with root package name */
    public final String f24623p;

    /* renamed from: q  reason: collision with root package name */
    public final Boolean f24624q;

    public n(String str, String str2, int i5, String str3, String str4, c cVar, c cVar2, String str5, String str6, Boolean bool) {
        t.e(str, "accountId");
        t.e(str2, "publisher");
        t.e(str3, "displayType");
        t.e(str4, "configurationHashCode");
        this.f24615h = str;
        this.f24616i = str2;
        this.f24617j = i5;
        this.f24618k = str3;
        this.f24619l = str4;
        this.f24620m = cVar;
        this.f24621n = cVar2;
        this.f24622o = str5;
        this.f24623p = str6;
        this.f24624q = bool;
    }

    public final String d() {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("displayType", this.f24618k);
        jSONObject2.put("configurationHashCode", this.f24619l);
        jSONObject2.put("cmpId", this.f24617j);
        jSONObject2.put("accountId", this.f24615h);
        jSONObject2.put("publisher", this.f24616i);
        c cVar = this.f24620m;
        JSONObject jSONObject3 = null;
        if (cVar == null) {
            jSONObject = null;
        } else {
            jSONObject = cVar.a();
        }
        jSONObject2.putOpt("configs", jSONObject);
        c cVar2 = this.f24621n;
        if (cVar2 != null) {
            jSONObject3 = cVar2.a();
        }
        jSONObject2.putOpt("existingConfigs", jSONObject3);
        jSONObject2.putOpt("existingCMPStatus", this.f24622o);
        jSONObject2.put("manualTrigger", this.f24624q);
        jSONObject2.put("existingGBCStatus", this.f24623p);
        c(jSONObject2);
        String jSONObject4 = jSONObject2.toString();
        t.d(jSONObject4, "jsonObject.toString()");
        return jSONObject4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        if (t.a(this.f24615h, nVar.f24615h) && t.a(this.f24616i, nVar.f24616i) && this.f24617j == nVar.f24617j && t.a(this.f24618k, nVar.f24618k) && t.a(this.f24619l, nVar.f24619l) && t.a(this.f24620m, nVar.f24620m) && t.a(this.f24621n, nVar.f24621n) && t.a(this.f24622o, nVar.f24622o) && t.a(this.f24623p, nVar.f24623p) && t.a(this.f24624q, nVar.f24624q)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i5;
        int i6;
        int i7;
        int i8;
        int a5 = v.a(this.f24619l, v.a(this.f24618k, (this.f24617j + v.a(this.f24616i, this.f24615h.hashCode() * 31, 31)) * 31, 31), 31);
        c cVar = this.f24620m;
        int i9 = 0;
        if (cVar == null) {
            i5 = 0;
        } else {
            i5 = cVar.hashCode();
        }
        int i10 = (a5 + i5) * 31;
        c cVar2 = this.f24621n;
        if (cVar2 == null) {
            i6 = 0;
        } else {
            i6 = cVar2.hashCode();
        }
        int i11 = (i10 + i6) * 31;
        String str = this.f24622o;
        if (str == null) {
            i7 = 0;
        } else {
            i7 = str.hashCode();
        }
        int i12 = (i11 + i7) * 31;
        String str2 = this.f24623p;
        if (str2 == null) {
            i8 = 0;
        } else {
            i8 = str2.hashCode();
        }
        int i13 = (i12 + i8) * 31;
        Boolean bool = this.f24624q;
        if (bool != null) {
            i9 = bool.hashCode();
        }
        return i13 + i9;
    }

    public final String toString() {
        return "TrackingInitLog(accountId=" + this.f24615h + ", publisher=" + this.f24616i + ", cmpId=" + this.f24617j + ", displayType=" + this.f24618k + ", configurationHashCode=" + this.f24619l + ", configs=" + this.f24620m + ", existingConfigs=" + this.f24621n + ", existingCMPStatus=" + this.f24622o + ", existingGBCStatus=" + this.f24623p + ", manualTrigger=" + this.f24624q + ')';
    }
}
