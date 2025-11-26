package l2;

import kotlin.jvm.internal.t;
import org.json.JSONObject;

/* renamed from: l2.E  reason: case insensitive filesystem */
public final class C2645E {

    /* renamed from: a  reason: collision with root package name */
    private String f24758a;

    /* renamed from: b  reason: collision with root package name */
    private String f24759b;

    public final void a(JSONObject jSONObject) {
        t.e(jSONObject, "jsonObject");
        if (!jSONObject.isNull("permission")) {
            this.f24758a = jSONObject.optString("permission");
        }
        if (!jSONObject.isNull("description")) {
            this.f24759b = jSONObject.optString("description");
        }
    }

    public final String b() {
        return this.f24758a;
    }

    public final void c(String str) {
        this.f24759b = str;
    }

    public final void d(String str) {
        this.f24758a = str;
    }
}
