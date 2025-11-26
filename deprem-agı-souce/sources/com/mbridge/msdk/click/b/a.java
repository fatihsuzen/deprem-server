package com.mbridge.msdk.click.b;

import android.content.Context;
import android.webkit.URLUtil;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import java.io.File;
import org.json.JSONObject;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f8098a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static int f8099b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static int f8100c = 1500;

    /* renamed from: d  reason: collision with root package name */
    private static String f8101d = "2000109";

    /* renamed from: e  reason: collision with root package name */
    private static String f8102e = "DspFilterUtils";

    public static boolean a(CampaignEx campaignEx, String str, int i5) {
        boolean z4 = false;
        if (campaignEx != null && campaignEx.getTpOffer() == 1) {
            if (campaignEx.getFac() != 0) {
                z4 = true;
            }
            try {
                Context c5 = c.m().c();
                if (c5 != null) {
                    if (URLUtil.isFileUrl(str)) {
                        File file = new File(str.replace("file:////", "").replace("file:///", "").replace("file://", ""));
                        if (file.exists()) {
                            str = ad.b(file);
                        }
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", f8101d);
                    jSONObject.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, i5);
                    jSONObject.put("html", str);
                    jSONObject.put("network_type", ab.m(c5));
                    jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, campaignEx.getCampaignUnitId());
                    jSONObject.put("rid", campaignEx.getRequestId());
                    jSONObject.put("rid_n", campaignEx.getRequestIdNotice());
                    jSONObject.put("cid", campaignEx.getId());
                    if (campaignEx.isBidCampaign()) {
                        jSONObject.put(CampaignEx.JSON_KEY_HB, 1);
                    }
                    d.a().a(jSONObject);
                }
            } catch (Throwable th) {
                af.b(f8102e, th.getMessage());
            }
        }
        return z4;
    }
}
