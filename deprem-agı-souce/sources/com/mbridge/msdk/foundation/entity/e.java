package com.mbridge.msdk.foundation.entity;

import android.text.TextUtils;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.controller.authoritycontroller.c;
import com.mbridge.msdk.foundation.tools.af;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private String f9040a;

    /* renamed from: b  reason: collision with root package name */
    private String f9041b;

    /* renamed from: c  reason: collision with root package name */
    private String f9042c;

    /* renamed from: d  reason: collision with root package name */
    private int f9043d;

    /* renamed from: e  reason: collision with root package name */
    private int f9044e;

    /* renamed from: f  reason: collision with root package name */
    private String f9045f;

    /* renamed from: g  reason: collision with root package name */
    private String f9046g;

    /* renamed from: h  reason: collision with root package name */
    private String f9047h;

    /* renamed from: i  reason: collision with root package name */
    private int f9048i;

    /* renamed from: j  reason: collision with root package name */
    private String f9049j;

    /* renamed from: k  reason: collision with root package name */
    private int f9050k;

    /* renamed from: l  reason: collision with root package name */
    private String f9051l;

    /* renamed from: m  reason: collision with root package name */
    private int f9052m;

    /* renamed from: n  reason: collision with root package name */
    private String f9053n;

    /* renamed from: o  reason: collision with root package name */
    private String f9054o;

    /* renamed from: p  reason: collision with root package name */
    private int f9055p;

    /* renamed from: q  reason: collision with root package name */
    private String f9056q;

    public final void a(String str) {
        this.f9056q = str;
    }

    public final void b(String str) {
        this.f9053n = str;
    }

    public final void c(String str) {
        this.f9051l = str;
    }

    public final void d(String str) {
        this.f9046g = str;
    }

    public final void e(int i5) {
        this.f9050k = i5;
    }

    public final void f(String str) {
        this.f9047h = str;
    }

    public final void g(String str) {
        this.f9045f = str;
    }

    public final void h(String str) {
        this.f9049j = str;
    }

    public final void i(String str) {
        this.f9041b = str;
    }

    public final void j(String str) {
        this.f9040a = str;
    }

    public final void k(String str) {
        this.f9054o = str;
    }

    public final String toString() {
        return "ClickTime [campaignId=" + this.f9040a + ", click_duration=" + this.f9041b + ", lastUrl=" + this.f9049j + ", code=" + this.f9044e + ", excepiton=" + this.f9046g + ", header=" + this.f9047h + ", content=" + this.f9045f + ", type=" + this.f9055p + ", click_type=" + this.f9043d + "]";
    }

    public final void a(int i5) {
        this.f9052m = i5;
    }

    public final void b(int i5) {
        this.f9043d = i5;
    }

    public final void c(int i5) {
        this.f9055p = i5;
    }

    public final void d(int i5) {
        this.f9048i = i5;
    }

    public final void e(String str) {
        this.f9042c = str;
    }

    public final void f(int i5) {
        this.f9044e = i5;
    }

    public static ArrayList<JSONObject> a(List<e> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList<JSONObject> arrayList = new ArrayList<>();
        for (e next : list) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("rid", next.f9053n);
                jSONObject.put("rid_n", next.f9054o);
                jSONObject.put("cid", next.f9040a);
                jSONObject.put("click_type", next.f9043d);
                jSONObject.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, next.f9055p);
                jSONObject.put("click_duration", next.f9041b);
                jSONObject.put("key", "2000013");
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, next.f9056q);
                jSONObject.put("last_url", next.f9049j);
                jSONObject.put("content", next.f9045f);
                jSONObject.put("code", next.f9044e);
                jSONObject.put("exception", next.f9046g);
                jSONObject.put("header", next.f9047h);
                jSONObject.put(CampaignEx.JSON_KEY_LANDING_TYPE, next.f9048i);
                jSONObject.put(CampaignEx.JSON_KEY_LINK_TYPE, next.f9050k);
                jSONObject.put("click_time", next.f9042c);
                if (c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                    jSONObject.put("network_type", next.f9052m);
                    jSONObject.put("network_str", next.f9051l);
                }
                String str = next.f9056q;
                if (!TextUtils.isEmpty(str)) {
                    String str2 = a.f8822b.get(str);
                    if (str2 == null) {
                        str2 = "";
                    }
                    jSONObject.put("u_stid", str2);
                }
                arrayList.add(jSONObject);
            } catch (Throwable th) {
                af.b("ClickTime", th.getMessage());
            }
        }
        return arrayList;
    }

    public static JSONObject a(e eVar) {
        if (eVar == null) {
            return null;
        }
        String str = eVar.f9049j;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("rid", eVar.f9053n);
            jSONObject.put("rid_n", eVar.f9054o);
            jSONObject.put("click_type", eVar.f9043d);
            jSONObject.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, eVar.f9055p);
            jSONObject.put("cid", eVar.f9040a);
            jSONObject.put("click_duration", eVar.f9041b);
            jSONObject.put("key", "2000012");
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, eVar.f9056q);
            jSONObject.put("last_url", str);
            jSONObject.put("code", eVar.f9044e);
            jSONObject.put("exception", eVar.f9046g);
            jSONObject.put(CampaignEx.JSON_KEY_LANDING_TYPE, eVar.f9048i);
            jSONObject.put(CampaignEx.JSON_KEY_LINK_TYPE, eVar.f9050k);
            jSONObject.put("click_time", eVar.f9042c);
            if (c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                jSONObject.put("network_type", eVar.f9052m);
                jSONObject.put("network_str", eVar.f9051l);
            }
            return jSONObject;
        } catch (Throwable th) {
            af.b("ClickTime", th.getMessage());
            return null;
        }
    }
}
