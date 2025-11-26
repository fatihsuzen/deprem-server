package com.mbridge.msdk.out.reveue;

import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class MBridgeRevenueParamsEntityForMax extends MBridgeRevenueParamsEntity {
    public MBridgeRevenueParamsEntityForMax(String str, String str2) {
        super(str, str2);
        setMediationName("Max");
    }

    public void setDspInfo(String str, String str2) {
        super.setDspInfo(str, str2);
    }

    public void setMaxAdInfo(String str, String str2) {
        JSONObject optJSONObject;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str.replace("MediatedAd", "").replace("=", ":").replace(" ", ""));
                setAdType(jSONObject.optString("format"));
                setMediationUnitId(jSONObject.optString("adUnitId"));
                setNetworkName(jSONObject.optString("networkName"));
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            try {
                JSONArray optJSONArray = new JSONObject(str2.replace("MaxAdWaterfallInfo", "").replace("MaxResponseInfo", "").replace("MaxMediatedNetworkInfo", "").replace("Bundle", "").replace("=", ":").replace(" ", "")).optJSONArray("networkResponses");
                if (optJSONArray != null) {
                    int i5 = 0;
                    while (true) {
                        if (i5 >= optJSONArray.length()) {
                            break;
                        }
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i5);
                        if (jSONObject2.optString("adLoadState", "").equals("AD_LOADED")) {
                            setBidType(Boolean.valueOf(jSONObject2.optBoolean("isBidding", false)));
                            JSONArray optJSONArray2 = jSONObject2.optJSONArray("credentials");
                            if (optJSONArray2 != null && optJSONArray2.length() > 0 && (optJSONObject = optJSONArray2.optJSONObject(0)) != null) {
                                JSONObject jSONObject3 = new JSONObject();
                                Iterator<String> keys = optJSONObject.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    jSONObject3.put(next, optJSONObject.get(next) + "");
                                }
                                setNetworkInfo(jSONObject3);
                            }
                        } else {
                            i5++;
                        }
                    }
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
        setSourceData(str, str2);
    }

    public void setMaxRevenueInfo(String str, Double d5) {
        setRevenue(d5 + "");
        setPrecision(str + "");
    }
}
