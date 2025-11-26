package l2;

import kotlin.jvm.internal.t;
import org.json.JSONObject;

/* renamed from: l2.F  reason: case insensitive filesystem */
public final class C2646F {

    /* renamed from: a  reason: collision with root package name */
    private int f24760a;

    /* renamed from: b  reason: collision with root package name */
    private String f24761b;

    public final void a(JSONObject jSONObject) {
        t.e(jSONObject, "jsonObject");
        if (!jSONObject.isNull("positives")) {
            this.f24760a = jSONObject.optInt("positives");
        }
        if (!jSONObject.isNull("sha256")) {
            this.f24761b = jSONObject.optString("sha256");
        }
    }

    public final int b() {
        return this.f24760a;
    }

    public final String c() {
        return this.f24761b;
    }
}
