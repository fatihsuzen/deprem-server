package q4;

import java.util.ArrayList;
import kotlin.jvm.internal.t;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class h {
    public static final ArrayList a(JSONObject jSONObject, String str) {
        t.e(jSONObject, "<this>");
        t.e(str, "key");
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray(str);
            if (jSONArray.length() > 0) {
                int length = jSONArray.length();
                int i5 = 0;
                while (i5 < length) {
                    int i6 = i5 + 1;
                    int optInt = jSONArray.optInt(i5);
                    Integer valueOf = Integer.valueOf(optInt);
                    if (optInt == 0) {
                        valueOf = null;
                    }
                    if (valueOf != null) {
                        arrayList.add(Integer.valueOf(valueOf.intValue()));
                    }
                    i5 = i6;
                }
            }
            return arrayList;
        } catch (JSONException unused) {
            return new ArrayList();
        }
    }

    public static final ArrayList b(JSONObject jSONObject, String str) {
        t.e(jSONObject, "<this>");
        t.e(str, "key");
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray(str);
            if (jSONArray.length() > 0) {
                int length = jSONArray.length();
                int i5 = 0;
                while (i5 < length) {
                    int i6 = i5 + 1;
                    String optString = jSONArray.optString(i5);
                    t.d(optString, "item");
                    if (optString.length() <= 0) {
                        optString = null;
                    }
                    if (optString != null) {
                        arrayList.add(optString);
                    }
                    i5 = i6;
                }
            }
            return arrayList;
        } catch (JSONException unused) {
            return new ArrayList();
        }
    }
}
