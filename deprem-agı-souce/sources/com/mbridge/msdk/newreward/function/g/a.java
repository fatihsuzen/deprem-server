package com.mbridge.msdk.newreward.function.g;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.newreward.function.common.MBridgeSharedPreferenceModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static c a() {
        c cVar = new c();
        String string = MBridgeSharedPreferenceModel.getInstance().getString(MBridgeConstans.SP_DYNAMIC_METRICS_REPORT, "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                int optInt = jSONObject.optInt("version", -1);
                if (optInt != -1) {
                    String optString = jSONObject.optString(RewardPlus.NAME, "");
                    JSONArray jSONArray = jSONObject.getJSONArray("report");
                    d[] dVarArr = new d[jSONArray.length()];
                    for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                        try {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i5);
                            if (jSONObject2 != null) {
                                String optString2 = jSONObject2.optString("key", "");
                                String optString3 = jSONObject2.optString("classname", "");
                                String optString4 = jSONObject2.optString("method", "");
                                if (!TextUtils.isEmpty(optString2)) {
                                    dVarArr[i5] = new d(optString3, optString4, optString2);
                                }
                            }
                        } catch (JSONException e5) {
                            if (MBridgeConstans.DEBUG) {
                                e5.printStackTrace();
                            }
                        }
                    }
                    cVar.a(optString);
                    cVar.a(optInt);
                    cVar.a(dVarArr);
                }
            } catch (JSONException e6) {
                if (MBridgeConstans.DEBUG) {
                    e6.printStackTrace();
                }
            }
        }
        return cVar;
    }
}
