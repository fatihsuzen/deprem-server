package l2;

import android.content.Context;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import kotlin.jvm.internal.t;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: l2.c  reason: case insensitive filesystem */
public final class C2654c {

    /* renamed from: a  reason: collision with root package name */
    private String f24961a;

    /* renamed from: b  reason: collision with root package name */
    private String f24962b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList f24963c;

    public final ArrayList a() {
        return this.f24963c;
    }

    public final String b() {
        return this.f24962b;
    }

    public final String c() {
        return this.f24961a;
    }

    public final void d(JSONObject jSONObject) {
        t.e(jSONObject, "jsonData");
        if (!jSONObject.isNull(CampaignEx.JSON_KEY_TITLE)) {
            this.f24961a = jSONObject.optString(CampaignEx.JSON_KEY_TITLE);
        }
        if (!jSONObject.isNull("description")) {
            this.f24962b = jSONObject.optString("description");
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("apps");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i5 = 0; i5 < length; i5++) {
                C2657f fVar = new C2657f();
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i5);
                t.b(jSONObject2);
                C2657f.b(fVar, jSONObject2, (Context) null, 2, (Object) null);
                arrayList.add(fVar);
            }
            this.f24963c = arrayList;
        }
    }
}
