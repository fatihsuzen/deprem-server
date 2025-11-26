package q4;

import U2.c;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.model.ChoiceError;
import kotlin.jvm.internal.t;
import org.json.JSONException;
import org.json.JSONObject;

public final class f implements i {
    public final Object a(String str) {
        t.e(str, "jsonString");
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("country");
            t.d(optString, "json.optString(\"country\")");
            String optString2 = jSONObject.optString(TtmlNode.TAG_REGION);
            t.d(optString2, "json.optString(\"region\")");
            String optString3 = jSONObject.optString("city");
            t.d(optString3, "json.optString(\"city\")");
            return new c(optString, optString2, optString3);
        } catch (JSONException unused) {
            ChoiceCmpCallback callback = ChoiceCmp.INSTANCE.getCallback();
            if (callback != null) {
                callback.onCmpError(ChoiceError.INVALID_JSON_FORMAT);
            }
            return new c("", "", "");
        }
    }
}
