package q4;

import R3.a;
import R3.f;
import R3.g;
import X2.C2250q;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.model.ChoiceError;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import kotlin.jvm.internal.t;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class j implements i {

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f25706a;

    public final Object a(String str) {
        t.e(str, "jsonString");
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f25706a = jSONObject;
            return new a(jSONObject.optString("jurisdiction"), b(), 10);
        } catch (JSONException unused) {
            ChoiceCmpCallback callback = ChoiceCmp.INSTANCE.getCallback();
            if (callback != null) {
                callback.onCmpError(ChoiceError.INVALID_JSON_FORMAT);
            }
            return new a((String) null, (ArrayList) null, 15);
        }
    }

    public final ArrayList b() {
        R2.a aVar;
        JSONArray jSONArray;
        JSONObject jSONObject = this.f25706a;
        String str = null;
        if (jSONObject == null) {
            t.w("json");
            jSONObject = null;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("purposes");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            int i5 = 0;
            while (i5 < length) {
                int i6 = i5 + 1;
                JSONObject optJSONObject = optJSONArray.optJSONObject(i5);
                Integer valueOf = Integer.valueOf(optJSONObject.optInt("id"));
                Boolean valueOf2 = Boolean.valueOf(optJSONObject.optBoolean("defaultValue"));
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("consentBanner");
                if (optJSONObject2 == null) {
                    aVar = new R2.a(str, str, 15);
                } else {
                    String optString = optJSONObject2.optString(CampaignEx.JSON_KEY_TITLE);
                    t.d(optString, "it.optString(\"title\")");
                    String optString2 = optJSONObject2.optString("description");
                    t.d(optString2, "it.optString(\"description\")");
                    aVar = new R2.a(optString, optString2, 10);
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("purposes");
                ArrayList arrayList2 = new ArrayList();
                if (optJSONArray2 == null) {
                    jSONArray = optJSONArray;
                } else {
                    int length2 = optJSONArray2.length();
                    jSONArray = optJSONArray;
                    int i7 = 0;
                    while (i7 < length2) {
                        int i8 = i7 + 1;
                        JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i7);
                        Integer valueOf3 = Integer.valueOf(optJSONObject3.optInt("id"));
                        Integer valueOf4 = Integer.valueOf(optJSONObject3.optInt("order"));
                        String optString3 = optJSONObject3.optString(CampaignEx.JSON_KEY_TITLE);
                        String optString4 = optJSONObject3.optString("description");
                        t.d(optJSONObject3, "mspaSensitivePurpose");
                        arrayList2.add(new g(valueOf3, valueOf4, optString3, Boolean.FALSE, optString4, h.a(optJSONObject3, "nationalIds")));
                        i7 = i8;
                        optJSONArray2 = optJSONArray2;
                    }
                }
                Integer num = valueOf;
                arrayList.add(new f(num, "", valueOf2, Boolean.FALSE, aVar, arrayList2, C2250q.g(), optJSONObject.optBoolean("noticeOnly")));
                i5 = i6;
                optJSONArray = jSONArray;
                str = null;
            }
        }
        return arrayList;
    }
}
