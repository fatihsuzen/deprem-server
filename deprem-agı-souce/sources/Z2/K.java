package z2;

import kotlin.jvm.internal.t;
import org.json.JSONArray;
import org.json.JSONObject;
import t3.s;

public final class K {
    public final JSONArray a(JSONArray jSONArray, JSONArray jSONArray2) {
        t.e(jSONArray, "jsonArrayPartialUpdates");
        JSONArray jSONArray3 = new JSONArray();
        int length = jSONArray.length();
        for (int i5 = 0; i5 < length; i5++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i5);
            if (jSONArray2 != null) {
                int length2 = jSONArray2.length();
                int i6 = 0;
                while (true) {
                    if (i6 >= length2) {
                        break;
                    }
                    if (s.E(jSONObject.optString("packagename"), jSONArray2.getJSONObject(i6).optString("packagename"), true)) {
                        break;
                    }
                    i6++;
                }
            }
            jSONArray3.put(jSONObject);
        }
        return jSONArray3;
    }
}
