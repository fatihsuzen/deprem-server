package q4;

import R2.a;
import R2.b;
import R2.c;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.model.ChoiceError;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import kotlin.jvm.internal.t;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e implements i {

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f25704a;

    public final Object a(String str) {
        t.e(str, "jsonString");
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f25704a = jSONObject;
            return new c(jSONObject.optString("language"), a(), b());
        } catch (JSONException unused) {
            ChoiceCmpCallback callback = ChoiceCmp.INSTANCE.getCallback();
            if (callback != null) {
                callback.onCmpError(ChoiceError.INVALID_JSON_FORMAT);
            }
            return new c();
        }
    }

    public final ArrayList b() {
        JSONObject jSONObject = this.f25704a;
        if (jSONObject == null) {
            t.w("json");
            jSONObject = null;
        }
        JSONArray jSONArray = jSONObject.getJSONArray("purposes");
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            int length = jSONArray.length();
            int i5 = 0;
            while (i5 < length) {
                int i6 = i5 + 1;
                JSONObject jSONObject2 = jSONArray.getJSONObject(i5);
                Integer valueOf = Integer.valueOf(jSONObject2.optInt("id"));
                JSONObject jSONObject3 = jSONObject2.getJSONObject("banner");
                t.d(jSONObject3, "gbcPurpose.getJSONObject(\"banner\")");
                String optString = jSONObject3.optString(CampaignEx.JSON_KEY_TITLE);
                t.d(optString, "jsonObject.optString(\"title\")");
                arrayList.add(new b(valueOf, new a(optString, (String) null, 14)));
                i5 = i6;
            }
        }
        return arrayList;
    }

    public final a a() {
        JSONObject jSONObject = this.f25704a;
        if (jSONObject == null) {
            t.w("json");
            jSONObject = null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("banner");
        String optString = jSONObject2.optString(CampaignEx.JSON_KEY_TITLE);
        t.d(optString, "bannerDetails.optString(\"title\")");
        String optString2 = jSONObject2.optString("sectionTitle");
        t.d(optString2, "bannerDetails.optString(\"sectionTitle\")");
        String optString3 = jSONObject2.optString("description");
        t.d(optString3, "bannerDetails.optString(\"description\")");
        String optString4 = jSONObject2.optString("confirm");
        t.d(optString4, "bannerDetails.optString(\"confirm\")");
        return new a(optString, optString2, optString3, optString4);
    }
}
