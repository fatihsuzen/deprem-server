package com.mbridge.msdk.scheme.report;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import org.json.JSONObject;

public class AppletsReport {
    public static final String APPLETS_API_VALUE = "2000118";
    private static final String TAG = "com.mbridge.msdk.scheme.report.AppletsReport";

    public static void reportAppletsLoadState(Context context, String str, String str2, String str3) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", APPLETS_API_VALUE);
                    jSONObject.put("network_type", ab.m(context));
                    jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                    if (!TextUtils.isEmpty(a.f9179V)) {
                        jSONObject.put(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, a.f9179V);
                    }
                    if (!TextUtils.isEmpty(a.f9188g)) {
                        jSONObject.put("c", a.f9188g);
                    }
                    jSONObject.put(CampaignEx.JSON_KEY_HB, 0);
                    jSONObject.put("rid_n", str3);
                    jSONObject.put("reason", str);
                    d.a().a(jSONObject);
                }
            } catch (Throwable th) {
                af.b(TAG, th.getMessage());
            }
        }
    }
}
