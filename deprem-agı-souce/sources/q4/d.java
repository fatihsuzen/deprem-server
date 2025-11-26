package q4;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.model.ChoiceError;
import java.util.ArrayList;
import kotlin.jvm.internal.t;
import m4.f;
import m4.h;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d implements i {

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f25703a;

    public final Object a(String str) {
        t.e(str, "jsonString");
        try {
            this.f25703a = new JSONObject(str);
            return new f(b());
        } catch (JSONException unused) {
            ChoiceCmpCallback callback = ChoiceCmp.INSTANCE.getCallback();
            if (callback != null) {
                callback.onCmpError(ChoiceError.INVALID_JSON_FORMAT);
            }
            return new f();
        }
    }

    public final ArrayList b() {
        JSONObject jSONObject = this.f25703a;
        if (jSONObject == null) {
            t.w("json");
            jSONObject = null;
        }
        JSONArray jSONArray = jSONObject.getJSONArray("disclosures");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        int i5 = 0;
        while (i5 < length) {
            int i6 = i5 + 1;
            JSONObject jSONObject2 = jSONArray.getJSONObject(i5);
            String optString = jSONObject2.optString("identifier");
            t.d(optString, "disclosure.optString(\"identifier\")");
            String optString2 = jSONObject2.optString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
            t.d(optString2, "disclosure.optString(\"type\")");
            int optInt = jSONObject2.optInt("maxAgeSeconds");
            String optString3 = jSONObject2.optString("domain");
            t.d(optString3, "disclosure.optString(\"domain\")");
            t.d(jSONObject2, "disclosure");
            arrayList.add(new h(optString, optString2, optInt, optString3, h.a(jSONObject2, "purposes")));
            i5 = i6;
        }
        return arrayList;
    }
}
