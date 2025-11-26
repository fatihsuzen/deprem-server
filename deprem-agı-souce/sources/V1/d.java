package v1;

import A1.g;
import org.json.JSONException;
import org.json.JSONObject;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f16754a;

    /* renamed from: b  reason: collision with root package name */
    private final Float f16755b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f16756c;

    /* renamed from: d  reason: collision with root package name */
    private final c f16757d;

    private d(boolean z4, Float f5, boolean z5, c cVar) {
        this.f16754a = z4;
        this.f16755b = f5;
        this.f16756c = z5;
        this.f16757d = cVar;
    }

    public static d b(boolean z4, c cVar) {
        g.b(cVar, "Position is null");
        return new d(false, (Float) null, z4, cVar);
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("skippable", this.f16754a);
            if (this.f16754a) {
                jSONObject.put("skipOffset", this.f16755b);
            }
            jSONObject.put("autoPlay", this.f16756c);
            jSONObject.put("position", this.f16757d);
            return jSONObject;
        } catch (JSONException e5) {
            A1.d.b("VastProperties: JSON error", e5);
            return jSONObject;
        }
    }
}
