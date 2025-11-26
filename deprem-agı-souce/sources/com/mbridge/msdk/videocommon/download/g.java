package com.mbridge.msdk.videocommon.download;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.download.download.ResourceManager;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.same.d;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.aq;
import java.io.File;
import java.util.List;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static String f13156a = "ResourceManager";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f13157b;

    /* renamed from: com.mbridge.msdk.videocommon.download.g$1  reason: invalid class name */
    class AnonymousClass1 extends com.mbridge.msdk.foundation.same.e.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f13158a;

        public final void cancelTask() {
        }

        public final void pauseTask(boolean z4) {
        }

        public final void runTask() {
            ad.a(this.f13158a.f13157b);
        }
    }

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        public static g f13159a = new g((AnonymousClass1) null);
    }

    /* synthetic */ g(AnonymousClass1 r12) {
        this();
    }

    private g() {
        this.f13157b = e.a(c.MBRIDGE_700_RES);
    }

    public static g a() {
        return a.f13159a;
    }

    public final String a(String str) {
        String str2;
        String str3 = "";
        try {
            String str4 = this.f13157b + "/" + SameMD5.getMD5(aq.b(str));
            List<String> queryParameters = Uri.parse(str).getQueryParameters(ResourceManager.KEY_INDEX_HTML);
            if (queryParameters == null || queryParameters.size() <= 0) {
                return null;
            }
            String str5 = queryParameters.get(0);
            if (TextUtils.isEmpty(str5)) {
                return null;
            }
            String str6 = str4 + "/" + str5 + "/" + str5 + ".html";
            if (!ad.d(str6)) {
                return null;
            }
            try {
                com.mbridge.msdk.c.g b5 = h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
                if (b5 != null && !TextUtils.isEmpty(b5.W())) {
                    d.a(str, new File(str6));
                }
                str2 = str.substring(str.indexOf("?") + 1);
            } catch (Exception unused) {
                str2 = str3;
            }
            if (!TextUtils.isEmpty(str2)) {
                str3 = "?" + str2;
            }
            return "file://" + str6 + str3;
        } catch (Exception e5) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            e5.printStackTrace();
            return null;
        }
    }
}
