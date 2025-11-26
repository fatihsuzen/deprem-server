package com.mbridge.msdk.out.reveue;

import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONObject;

public class MBridgeRevenueParamsEntityForAdmob extends MBridgeRevenueParamsEntity {
    public MBridgeRevenueParamsEntityForAdmob(String str, String str2) {
        super(str, str2);
        setMediationName("Admob");
    }

    public void setAdType(String str) {
        super.setAdType(str);
    }

    public void setAdmobResponseInfo(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                setSourceData(str, str);
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("Loaded Adapter Response");
                if (optJSONObject != null) {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("Credentials");
                    if (optJSONObject2 != null) {
                        JSONObject jSONObject = new JSONObject();
                        Iterator<String> keys = optJSONObject2.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            jSONObject.put(next, optJSONObject2.get(next) + "");
                        }
                        setNetworkInfo(jSONObject);
                    }
                    setNetworkName(optJSONObject.optString("Ad Source Name"));
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public void setAdmobRevenueInfo(int i5, long j5, String str) {
        setRevenue(j5 + "");
        setPrecision(i5 + "");
        setCurrency(str);
    }

    public void setDspInfo(String str, String str2) {
        super.setDspInfo(str, str2);
    }
}
