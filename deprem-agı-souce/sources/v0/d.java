package v0;

import android.os.Bundle;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import org.json.JSONException;
import org.json.JSONObject;
import u0.g;
import w0.C1898a;
import w0.b;

public class d implements C1894b, b {

    /* renamed from: a  reason: collision with root package name */
    private C1898a f16741a;

    private static String b(String str, Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (String next : bundle.keySet()) {
            jSONObject2.put(next, bundle.get(next));
        }
        jSONObject.put(RewardPlus.NAME, str);
        jSONObject.put("parameters", jSONObject2);
        return jSONObject.toString();
    }

    public void a(C1898a aVar) {
        this.f16741a = aVar;
        g.f().b("Registered Firebase Analytics event receiver for breadcrumbs");
    }

    public void onEvent(String str, Bundle bundle) {
        C1898a aVar = this.f16741a;
        if (aVar != null) {
            try {
                aVar.a("$A$:" + b(str, bundle));
            } catch (JSONException unused) {
                g.f().k("Unable to serialize Firebase Analytics event to breadcrumb.");
            }
        }
    }
}
