package q4;

import J2.f;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.model.ChoiceError;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.t;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class g implements i {

    /* renamed from: a  reason: collision with root package name */
    public JSONArray f25705a;

    public final Object a(String str) {
        t.e(str, "jsonString");
        try {
            this.f25705a = new JSONArray(str);
            return new f(b());
        } catch (JSONException unused) {
            ChoiceCmpCallback callback = ChoiceCmp.INSTANCE.getCallback();
            if (callback != null) {
                callback.onCmpError(ChoiceError.INVALID_JSON_FORMAT);
            }
            return new f();
        }
    }

    public final LinkedHashMap b() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONArray jSONArray = this.f25705a;
        if (jSONArray == null) {
            t.w("googleVendorsJson");
            jSONArray = null;
        }
        int length = jSONArray.length();
        int i5 = 0;
        while (i5 < length) {
            int i6 = i5 + 1;
            JSONArray jSONArray2 = this.f25705a;
            if (jSONArray2 == null) {
                t.w("googleVendorsJson");
                jSONArray2 = null;
            }
            String string = jSONArray2.getString(i5);
            if (string == null) {
                string = "0";
            }
            JSONArray jSONArray3 = this.f25705a;
            if (jSONArray3 == null) {
                t.w("googleVendorsJson");
                jSONArray3 = null;
            }
            JSONObject jSONObject = jSONArray3.getJSONObject(i5);
            String string2 = jSONObject.getString("provider_id");
            t.d(string2, "googleVendor.getString(\"provider_id\")");
            int parseInt = Integer.parseInt(string2);
            String string3 = jSONObject.getString("provider_name");
            t.d(string3, "googleVendor.getString(\"provider_name\")");
            String string4 = jSONObject.getString("policy_url");
            t.d(string4, "googleVendor.getString(\"policy_url\")");
            String string5 = jSONObject.getString("domains");
            t.d(string5, "googleVendor.getString(\"domains\")");
            linkedHashMap.put(string, new J2.g(parseInt, string3, string4, string5));
            i5 = i6;
        }
        return linkedHashMap;
    }
}
