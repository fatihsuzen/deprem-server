package com.mbridge.msdk.foundation.same;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.a.b;
import com.mbridge.msdk.foundation.download.core.DownloadRequest;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.ak;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final List<String> f9274a = new LinkedList();

    public static int a(CampaignEx campaignEx, String str) {
        if (campaignEx == null) {
            return -1;
        }
        try {
            if (!TextUtils.isEmpty(campaignEx.getMof_template_url())) {
                return ak.b(campaignEx.getMof_template_url());
            }
            return ak.b(str);
        } catch (Exception e5) {
            af.b("SameTools", e5.getMessage());
            return -1;
        }
    }

    public static boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.equals(str2, com.mbridge.msdk.foundation.same.net.e.d.f().f9368c) || TextUtils.equals(str2, com.mbridge.msdk.foundation.same.net.e.d.f().f9345F) || ((!TextUtils.equals(str, "download_video") && !TextUtils.equals(str, "download_image") && !TextUtils.equals(str, "download_template") && !TextUtils.equals(str, "") && !TextUtils.equals(str, "download_other") && !TextUtils.equals(str, "download_html") && !TextUtils.equals(str, "applets_model") && !TextUtils.equals(str, "campaign") && !TextUtils.equals(str, "bid_request") && !TextUtils.equals(str, "more_offer") && !TextUtils.equals(str, "mraid_js") && !TextUtils.equals(str, "om_sdk") && !TextUtils.equals(str, "roas") && !TextUtils.equals(str, "web_env_check_js") && !TextUtils.equals(str, "setting")) || !ah.a().a("request_track", true))) {
            return false;
        }
        return true;
    }

    public static String a(DownloadRequest<?> downloadRequest) {
        if (downloadRequest == null) {
            return "un_known";
        }
        String str = downloadRequest.get("download_scene", "");
        if (TextUtils.isEmpty(str)) {
            return "un_known";
        }
        return str;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String[] split = str.split(";");
            if (split.length > 0) {
                return split[0].trim();
            }
            return str.trim();
        } catch (Exception unused) {
            return "";
        }
    }

    public static void a(String str, File file) {
        if (file != null && file.exists()) {
            try {
                List<String> list = f9274a;
                if (list.contains(str)) {
                    list.add(str);
                    System.gc();
                } else {
                    ad.a(b.c(t1.b.a(MBridgeConstans.OMID_JS_SERVICE_CONTENT, ad.b(file))).getBytes(), file);
                    list.add(str);
                    System.gc();
                }
                Runtime.getRuntime().gc();
            } catch (Throwable unused) {
            }
        }
    }
}
