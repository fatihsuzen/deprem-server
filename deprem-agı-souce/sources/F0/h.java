package F0;

import org.json.JSONObject;
import u0.g;
import x0.C;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private final C f2450a;

    h(C c5) {
        this.f2450a = c5;
    }

    private static i a(int i5) {
        if (i5 == 3) {
            return new m();
        }
        g f5 = g.f();
        f5.d("Could not determine SettingsJsonTransform for settings version " + i5 + ". Using default settings values.");
        return new b();
    }

    public d b(JSONObject jSONObject) {
        return a(jSONObject.getInt("settings_version")).a(this.f2450a, jSONObject);
    }
}
