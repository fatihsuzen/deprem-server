package k4;

import kotlin.jvm.internal.t;
import org.json.JSONObject;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f24561a;

    /* renamed from: b  reason: collision with root package name */
    public final String f24562b;

    /* renamed from: c  reason: collision with root package name */
    public final Boolean f24563c;

    /* renamed from: d  reason: collision with root package name */
    public final Boolean f24564d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f24565e;

    public c(String str, String str2, Boolean bool, Boolean bool2, boolean z4) {
        t.e(str, "themeUuid");
        t.e(str2, "language");
        this.f24561a = str;
        this.f24562b = str2;
        this.f24563c = bool;
        this.f24564d = bool2;
        this.f24565e = z4;
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("themeUuid", this.f24561a);
        jSONObject.put("language", this.f24562b);
        jSONObject.put("copApplicable", this.f24563c);
        jSONObject.put("advancedApplicable", this.f24564d);
        jSONObject.put("gbcApplicable", this.f24565e);
        return jSONObject;
    }
}
