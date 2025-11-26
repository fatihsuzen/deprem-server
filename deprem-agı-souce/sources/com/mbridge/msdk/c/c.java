package com.mbridge.msdk.c;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class c {

    /* renamed from: A  reason: collision with root package name */
    private String f7957A;

    /* renamed from: B  reason: collision with root package name */
    private int f7958B = 1;

    /* renamed from: C  reason: collision with root package name */
    private String f7959C = "";

    /* renamed from: D  reason: collision with root package name */
    private int f7960D;

    /* renamed from: E  reason: collision with root package name */
    private int f7961E;

    /* renamed from: F  reason: collision with root package name */
    private int f7962F = 100;

    /* renamed from: G  reason: collision with root package name */
    private int f7963G = 60;

    /* renamed from: H  reason: collision with root package name */
    private int f7964H = DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS;

    /* renamed from: I  reason: collision with root package name */
    private int f7965I;

    /* renamed from: J  reason: collision with root package name */
    private int f7966J = 1;

    /* renamed from: K  reason: collision with root package name */
    private String f7967K;

    /* renamed from: L  reason: collision with root package name */
    private String f7968L = "";

    /* renamed from: M  reason: collision with root package name */
    private String f7969M = "";

    /* renamed from: N  reason: collision with root package name */
    private int f7970N;

    /* renamed from: a  reason: collision with root package name */
    private String f7971a = "";

    /* renamed from: b  reason: collision with root package name */
    private List<Integer> f7972b;

    /* renamed from: c  reason: collision with root package name */
    private List<Integer> f7973c;

    /* renamed from: d  reason: collision with root package name */
    private int f7974d;

    /* renamed from: e  reason: collision with root package name */
    private int f7975e;

    /* renamed from: f  reason: collision with root package name */
    private int f7976f;

    /* renamed from: g  reason: collision with root package name */
    private int f7977g;

    /* renamed from: h  reason: collision with root package name */
    private int f7978h;

    /* renamed from: i  reason: collision with root package name */
    private int f7979i;

    /* renamed from: j  reason: collision with root package name */
    private int f7980j = 0;

    /* renamed from: k  reason: collision with root package name */
    private long f7981k;

    /* renamed from: l  reason: collision with root package name */
    private long f7982l;

    /* renamed from: m  reason: collision with root package name */
    private int f7983m;

    /* renamed from: n  reason: collision with root package name */
    private int f7984n;

    /* renamed from: o  reason: collision with root package name */
    private int f7985o;

    /* renamed from: p  reason: collision with root package name */
    private long f7986p;

    /* renamed from: q  reason: collision with root package name */
    private long f7987q;

    /* renamed from: r  reason: collision with root package name */
    private int f7988r;

    /* renamed from: s  reason: collision with root package name */
    private String f7989s;

    /* renamed from: t  reason: collision with root package name */
    private int f7990t;

    /* renamed from: u  reason: collision with root package name */
    private int f7991u;

    /* renamed from: v  reason: collision with root package name */
    private int f7992v = 30;

    /* renamed from: w  reason: collision with root package name */
    private int f7993w = 1;

    /* renamed from: x  reason: collision with root package name */
    private int f7994x = 10;

    /* renamed from: y  reason: collision with root package name */
    private int f7995y = 60;

    /* renamed from: z  reason: collision with root package name */
    private String f7996z;

    public static k a(JSONObject jSONObject) {
        k kVar;
        k kVar2 = null;
        if (jSONObject != null) {
            try {
                kVar = new k();
            } catch (Exception e5) {
                e = e5;
                e.printStackTrace();
                return kVar2;
            }
            try {
                kVar.f7967K = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
                String optString = jSONObject.optString("ab_id");
                kVar.f7971a = optString;
                a.f8822b.put(kVar.f7967K, optString);
                kVar.f7968L = jSONObject.optString("rid");
                JSONArray optJSONArray = jSONObject.optJSONArray("adSourceList");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                        arrayList.add(Integer.valueOf(optJSONArray.optInt(i5)));
                    }
                    kVar.f7972b = arrayList;
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("ad_source_timeout");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i6 = 0; i6 < optJSONArray2.length(); i6++) {
                        arrayList2.add(Integer.valueOf(optJSONArray2.optInt(i6)));
                    }
                    kVar.f7973c = arrayList2;
                }
                kVar.f7965I = jSONObject.optInt("tpqn");
                kVar.f7976f = jSONObject.optInt("aqn");
                kVar.f7975e = jSONObject.optInt("acn");
                kVar.f7970N = jSONObject.optInt("wt");
                int i7 = 1;
                kVar.f7993w = jSONObject.optInt("iscasf", 1);
                kVar.f7964H = jSONObject.optInt("spmxrt", DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS);
                kVar.f7986p = jSONObject.optLong("current_time");
                kVar.f7958B = jSONObject.optInt(TypedValues.CycleType.S_WAVE_OFFSET);
                kVar.f7987q = jSONObject.optLong("dlct", 3600);
                kVar.f7977g = jSONObject.optInt("autoplay", 0);
                kVar.f7988r = jSONObject.optInt("dlnet", 2);
                kVar.f7957A = jSONObject.optString("no_offer");
                kVar.f7979i = jSONObject.optInt("cb_type");
                kVar.f7982l = jSONObject.optLong("clct", 86400);
                kVar.f7981k = jSONObject.optLong("clcq", 300);
                kVar.f7962F = jSONObject.optInt(CampaignEx.JSON_KEY_READY_RATE, 100);
                kVar.f7980j = jSONObject.optInt("cd_rate", 0);
                kVar.f7984n = jSONObject.optInt("content", 1);
                kVar.f7991u = jSONObject.optInt("impt", 0);
                kVar.f7990t = jSONObject.optInt("icon_type", 1);
                kVar.f7996z = jSONObject.optString("no_ads_url", "");
                kVar.f7961E = jSONObject.optInt("playclosebtn_tm", -1);
                kVar.f7960D = jSONObject.optInt("play_ctdown", 0);
                kVar.f7983m = jSONObject.optInt("close_alert", 0);
                kVar.f7992v = jSONObject.optInt("intershowlimit", 30);
                kVar.f7963G = jSONObject.optInt("refreshFq", 60);
                kVar.f7978h = jSONObject.optInt("closeBtn", 0);
                int optInt = jSONObject.optInt("tmorl", 1);
                if (optInt <= 2) {
                    if (optInt > 0) {
                        i7 = optInt;
                    }
                }
                kVar.f7966J = i7;
                kVar.f7959C = jSONObject.optString("placementid", "");
                kVar.f7994x = jSONObject.optInt("ltafemty", 10);
                kVar.f7995y = jSONObject.optInt("ltorwc", 60);
                kVar.f7969M = jSONObject.optString("vtag", "");
                return kVar;
            } catch (Exception e6) {
                e = e6;
                kVar2 = kVar;
                e.printStackTrace();
                return kVar2;
            }
        }
        return kVar2;
    }

    public final List<Integer> b() {
        return this.f7972b;
    }

    public final List<Integer> c() {
        return this.f7973c;
    }

    public final int d() {
        return this.f7975e;
    }

    public final int e() {
        return this.f7976f;
    }

    public final int f() {
        return this.f7978h;
    }

    public final int g() {
        return this.f7980j;
    }

    public final int h() {
        return this.f7984n;
    }

    public final long i() {
        return this.f7986p;
    }

    public final long j() {
        return this.f7987q;
    }

    public final int k() {
        return this.f7988r;
    }

    public final int l() {
        return this.f7991u;
    }

    public final int m() {
        return this.f7993w;
    }

    public final int n() {
        return this.f7994x;
    }

    public final int o() {
        return this.f7995y;
    }

    public final int p() {
        return this.f7962F;
    }

    public final int q() {
        return this.f7963G;
    }

    public final int r() {
        return this.f7964H;
    }

    public final String s() {
        return this.f7968L;
    }

    public final String t() {
        return this.f7969M;
    }

    public String toString() {
        List<Integer> list = this.f7972b;
        String str = "";
        if (list != null && list.size() > 0) {
            for (Integer num : this.f7972b) {
                str = str + num + ",";
            }
        }
        return "offset = " + this.f7958B + " unitId = " + this.f7967K + " fbPlacementId = " + this.f7989s + str;
    }

    public final int u() {
        return this.f7970N;
    }

    public final int v() {
        return this.f7977g;
    }

    public final int w() {
        return this.f7958B;
    }

    public final JSONObject x() {
        JSONObject jSONObject = new JSONObject();
        try {
            List<Integer> list = this.f7972b;
            if (list != null && list.size() > 0) {
                int size = list.size();
                JSONArray jSONArray = new JSONArray();
                for (int i5 = 0; i5 < size; i5++) {
                    jSONArray.put(list.get(i5));
                }
                jSONObject.put("adSourceList", jSONArray);
            }
            List<Integer> list2 = this.f7973c;
            if (list2 != null && list2.size() > 0) {
                int size2 = list2.size();
                JSONArray jSONArray2 = new JSONArray();
                for (int i6 = 0; i6 < size2; i6++) {
                    jSONArray2.put(list2.get(i6));
                }
                jSONObject.put("ad_source_timeout", jSONArray2);
            }
            jSONObject.put("tpqn", this.f7965I);
            jSONObject.put("aqn", this.f7976f);
            jSONObject.put("acn", this.f7975e);
            jSONObject.put("wt", this.f7970N);
            jSONObject.put("current_time", this.f7986p);
            jSONObject.put(TypedValues.CycleType.S_WAVE_OFFSET, this.f7958B);
            jSONObject.put("dlct", this.f7987q);
            jSONObject.put("autoplay", this.f7977g);
            jSONObject.put("dlnet", this.f7988r);
            jSONObject.put("no_offer", this.f7957A);
            jSONObject.put("cb_type", this.f7979i);
            jSONObject.put("clct", this.f7982l);
            jSONObject.put("clcq", this.f7981k);
            jSONObject.put(CampaignEx.JSON_KEY_READY_RATE, this.f7962F);
            jSONObject.put("content", this.f7984n);
            jSONObject.put("impt", this.f7991u);
            jSONObject.put("icon_type", this.f7990t);
            jSONObject.put("no_ads_url", this.f7996z);
            jSONObject.put("playclosebtn_tm", this.f7961E);
            jSONObject.put("play_ctdown", this.f7960D);
            jSONObject.put("close_alert", this.f7983m);
            jSONObject.put("closeBtn", this.f7978h);
            jSONObject.put("refreshFq", this.f7963G);
            jSONObject.put("countdown", this.f7985o);
            jSONObject.put("allowSkip", this.f7974d);
            jSONObject.put("tmorl", this.f7966J);
            jSONObject.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, this.f7967K);
            jSONObject.put("placementid", this.f7959C);
            jSONObject.put("ltafemty", this.f7994x);
            jSONObject.put("ltorwc", this.f7995y);
            jSONObject.put("vtag", this.f7969M);
            return jSONObject;
        } catch (Exception e5) {
            e5.printStackTrace();
            return jSONObject;
        }
    }

    public final void b(List<Integer> list) {
        this.f7973c = list;
    }

    public final void c(int i5) {
        this.f7975e = i5;
    }

    public final void d(int i5) {
        this.f7976f = i5;
    }

    public final void e(int i5) {
        this.f7980j = i5;
    }

    public final void f(int i5) {
        this.f7984n = i5;
    }

    public final void g(int i5) {
        this.f7985o = i5;
    }

    public final void h(int i5) {
        this.f7988r = i5;
    }

    public final void i(int i5) {
        this.f7991u = i5;
    }

    public final void j(int i5) {
        this.f7994x = i5;
    }

    public final void k(int i5) {
        this.f7995y = i5;
    }

    public final void l(int i5) {
        this.f7962F = i5;
    }

    public final void m(int i5) {
        this.f7963G = i5;
    }

    public final void n(int i5) {
        this.f7965I = i5;
    }

    public final void o(int i5) {
        this.f7970N = i5;
    }

    public final void p(int i5) {
        this.f7958B = i5;
    }

    public final void b(int i5) {
        this.f7974d = i5;
    }

    public final void b(String str) {
        this.f7967K = str;
    }

    public final void a(int i5) {
        this.f7977g = i5;
    }

    public final String a() {
        return this.f7971a;
    }

    public final void a(List<Integer> list) {
        this.f7972b = list;
    }

    public final void a(long j5) {
        this.f7987q = j5;
    }

    public final void a(String str) {
        this.f7959C = str;
    }
}
