package k4;

import kotlin.jvm.internal.t;
import org.json.JSONObject;

public abstract class m {

    /* renamed from: a  reason: collision with root package name */
    public long f24608a;

    /* renamed from: b  reason: collision with root package name */
    public g f24609b = g.NONE;

    /* renamed from: c  reason: collision with root package name */
    public String f24610c;

    /* renamed from: d  reason: collision with root package name */
    public String f24611d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f24612e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f24613f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f24614g;

    public long a() {
        return this.f24608a;
    }

    public void b(long j5) {
        this.f24608a = j5;
    }

    public final void c(JSONObject jSONObject) {
        t.e(jSONObject, "jsonObject");
        jSONObject.putOpt("clientTimestamp", Long.valueOf(a()));
        if (this.f24609b != g.VISIT) {
            jSONObject.putOpt("sessionId", this.f24610c);
        }
        jSONObject.putOpt("domain", this.f24611d);
        jSONObject.putOpt("cmpVersion", "2.3.3");
        jSONObject.putOpt("cmpPlatform", "android");
        jSONObject.putOpt("deviceType", this.f24613f);
        jSONObject.putOpt("country", this.f24612e);
        jSONObject.putOpt("siteUuid", this.f24614g);
        jSONObject.putOpt("operationType", this.f24609b.f24584a);
    }

    public abstract String d();
}
