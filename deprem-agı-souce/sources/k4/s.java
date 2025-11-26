package k4;

import kotlin.jvm.internal.t;
import org.json.JSONObject;

public final class s extends m {

    /* renamed from: h  reason: collision with root package name */
    public final String f24641h;

    /* renamed from: i  reason: collision with root package name */
    public final Boolean f24642i;

    /* renamed from: j  reason: collision with root package name */
    public final String f24643j;

    /* renamed from: k  reason: collision with root package name */
    public final String f24644k;

    /* renamed from: l  reason: collision with root package name */
    public final c f24645l;

    /* renamed from: m  reason: collision with root package name */
    public final Boolean f24646m;

    /* renamed from: n  reason: collision with root package name */
    public final String f24647n;

    /* renamed from: o  reason: collision with root package name */
    public final Boolean f24648o;

    /* renamed from: p  reason: collision with root package name */
    public final boolean f24649p;

    public s(String str, Boolean bool, String str2, String str3, c cVar, Boolean bool2, String str4, Boolean bool3, boolean z4) {
        this.f24641h = str;
        this.f24642i = bool;
        this.f24643j = str2;
        this.f24644k = str3;
        this.f24645l = cVar;
        this.f24646m = bool2;
        this.f24647n = str4;
        this.f24648o = bool3;
        this.f24649p = z4;
    }

    public final String d() {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.putOpt("existingCMPStatus", this.f24641h);
        jSONObject2.putOpt("regulation", this.f24643j);
        jSONObject2.putOpt("cmpTriggered", this.f24642i);
        jSONObject2.putOpt("accountId", this.f24644k);
        c cVar = this.f24645l;
        if (cVar == null) {
            jSONObject = null;
        } else {
            jSONObject = cVar.a();
        }
        jSONObject2.putOpt("existingConfigs", jSONObject);
        jSONObject2.putOpt("paidUser", this.f24646m);
        jSONObject2.putOpt("existingGBCStatus", this.f24647n);
        jSONObject2.putOpt("consentOrPayApplicable", this.f24648o);
        jSONObject2.putOpt("gbcApplicable", Boolean.valueOf(this.f24649p));
        c(jSONObject2);
        String jSONObject3 = jSONObject2.toString();
        t.d(jSONObject3, "jsonObject.toString()");
        return jSONObject3;
    }
}
