package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.authoritycontroller.b;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.same.net.f.e;
import org.json.JSONException;
import org.json.JSONObject;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f9680a;

    /* renamed from: b  reason: collision with root package name */
    public int f9681b;

    /* renamed from: c  reason: collision with root package name */
    public String f9682c;

    /* renamed from: d  reason: collision with root package name */
    public String f9683d;

    /* renamed from: e  reason: collision with root package name */
    public String f9684e;

    /* renamed from: f  reason: collision with root package name */
    public String f9685f;

    /* renamed from: g  reason: collision with root package name */
    public String f9686g;

    /* renamed from: h  reason: collision with root package name */
    public String f9687h;

    /* renamed from: i  reason: collision with root package name */
    public String f9688i = ab.m();

    /* renamed from: j  reason: collision with root package name */
    public String f9689j;

    /* renamed from: k  reason: collision with root package name */
    public String f9690k;

    /* renamed from: l  reason: collision with root package name */
    public String f9691l = f.c();

    /* renamed from: m  reason: collision with root package name */
    public int f9692m;

    /* renamed from: n  reason: collision with root package name */
    public String f9693n;

    /* renamed from: o  reason: collision with root package name */
    public String f9694o;

    /* renamed from: p  reason: collision with root package name */
    public String f9695p;

    /* renamed from: q  reason: collision with root package name */
    public String f9696q = "android";

    /* renamed from: r  reason: collision with root package name */
    public String f9697r;

    /* renamed from: s  reason: collision with root package name */
    public String f9698s;

    /* renamed from: t  reason: collision with root package name */
    public String f9699t;

    /* renamed from: u  reason: collision with root package name */
    public String f9700u = ab.w();

    /* renamed from: v  reason: collision with root package name */
    public String f9701v;

    public d(Context context) {
        int m5 = ab.m(context);
        this.f9693n = String.valueOf(m5);
        this.f9694o = ab.a(context, m5);
        this.f9689j = ab.g(context);
        this.f9684e = c.m().b();
        this.f9683d = c.m().k();
        this.f9699t = String.valueOf(ak.f(context));
        this.f9698s = String.valueOf(ak.e(context));
        this.f9697r = String.valueOf(ak.d(context));
        this.f9701v = c.m().i().toString();
        this.f9686g = ab.x();
        this.f9692m = ak.a();
        if (context.getResources().getConfiguration().orientation == 2) {
            this.f9695p = "landscape";
        } else {
            this.f9695p = "portrait";
        }
        this.f9685f = a.f9179V;
        this.f9687h = a.f9188g;
        this.f9690k = ab.n();
        this.f9682c = f.d();
        this.f9680a = f.a();
        this.f9681b = b.b() ? 1 : 0;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                jSONObject.put("device", this.f9688i);
                jSONObject.put("system_version", this.f9700u);
                jSONObject.put("network_type", this.f9693n);
                jSONObject.put("network_type_str", this.f9694o);
                jSONObject.put("device_ua", this.f9689j);
                jSONObject.put("has_wx", ab.v(c.m().c()));
                jSONObject.put("integrated_wx", ab.z());
                jSONObject.put("opensdk_ver", ab.u() + "");
                jSONObject.put("wx_api_ver", ab.c(c.m().h()) + "");
                jSONObject.put("brand", this.f9686g);
                jSONObject.put("mnc", ab.l(c.m().c()));
                jSONObject.put("mcc", ab.k(c.m().c()));
                jSONObject.put("adid_limit", this.f9680a);
                jSONObject.put("adid_limit_dev", this.f9681b);
            }
            jSONObject.put("plantform", this.f9696q);
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                jSONObject.put("google_ad_id", this.f9691l);
                jSONObject.put("az_aid_info", this.f9682c);
            }
            jSONObject.put("appkey", this.f9684e);
            jSONObject.put("appId", this.f9683d);
            jSONObject.put("screen_width", this.f9699t);
            jSONObject.put("screen_height", this.f9698s);
            jSONObject.put("orientation", this.f9695p);
            jSONObject.put("scale", this.f9697r);
            jSONObject.put(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, this.f9685f);
            jSONObject.put("c", this.f9687h);
            jSONObject.put("web_env", this.f9701v);
            jSONObject.put("f", this.f9690k);
            jSONObject.put("misk_spt", this.f9692m);
            if (ab.q() != 0) {
                jSONObject.put("tun", ab.q());
            }
            String str = e.f9396c;
            jSONObject.put(str, com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().f() + "");
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("adid_limit", this.f9680a);
                jSONObject2.put("adid_limit_dev", this.f9681b);
                jSONObject.put("dvi", z.b(jSONObject2.toString()));
            }
            if (!b.a()) {
                jSONObject.put("dev_source", "2");
            }
            if (DomainNameUtils.getInstance().isExcludeCNDomain()) {
                jSONObject.put("re_domain", "1");
            }
            return jSONObject;
        } catch (JSONException e5) {
            e5.printStackTrace();
            return jSONObject;
        }
    }
}
