package F0;

import F0.d;
import org.json.JSONObject;
import x0.C;

class m implements i {
    m() {
    }

    private static d.a b(JSONObject jSONObject) {
        return new d.a(jSONObject.optBoolean("collect_reports", true), jSONObject.optBoolean("collect_anrs", false), jSONObject.optBoolean("collect_build_ids", false));
    }

    private static d.b c(JSONObject jSONObject) {
        return new d.b(jSONObject.optInt("max_custom_exception_events", 8), 4);
    }

    private static long d(C c5, long j5, JSONObject jSONObject) {
        if (jSONObject.has("expires_at")) {
            return jSONObject.optLong("expires_at");
        }
        return c5.a() + (j5 * 1000);
    }

    public d a(C c5, JSONObject jSONObject) {
        d.b c6;
        JSONObject jSONObject2 = jSONObject;
        int optInt = jSONObject2.optInt("settings_version", 0);
        int optInt2 = jSONObject2.optInt("cache_duration", 3600);
        double optDouble = jSONObject2.optDouble("on_demand_upload_rate_per_minute", 10.0d);
        double optDouble2 = jSONObject2.optDouble("on_demand_backoff_base", 1.2d);
        int optInt3 = jSONObject2.optInt("on_demand_backoff_step_duration_seconds", 60);
        if (jSONObject2.has("session")) {
            c6 = c(jSONObject2.getJSONObject("session"));
        } else {
            c6 = c(new JSONObject());
        }
        return new d(d(c5, (long) optInt2, jSONObject2), c6, b(jSONObject2.getJSONObject("features")), optInt, optInt2, optDouble, optDouble2, optInt3);
    }
}
