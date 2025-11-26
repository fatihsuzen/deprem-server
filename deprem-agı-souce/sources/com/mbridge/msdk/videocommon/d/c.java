package com.mbridge.msdk.videocommon.d;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.mbridge.msdk.videocommon.b.b;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c {

    /* renamed from: H  reason: collision with root package name */
    private static g f13042H;

    /* renamed from: a  reason: collision with root package name */
    public static String f13043a;

    /* renamed from: A  reason: collision with root package name */
    private int f13044A = 70;

    /* renamed from: B  reason: collision with root package name */
    private int f13045B = 0;

    /* renamed from: C  reason: collision with root package name */
    private int f13046C = -1;

    /* renamed from: D  reason: collision with root package name */
    private int f13047D = -1;

    /* renamed from: E  reason: collision with root package name */
    private int f13048E = -1;

    /* renamed from: F  reason: collision with root package name */
    private int f13049F;

    /* renamed from: G  reason: collision with root package name */
    private int f13050G = 20;

    /* renamed from: I  reason: collision with root package name */
    private int f13051I;

    /* renamed from: J  reason: collision with root package name */
    private int f13052J = 0;

    /* renamed from: K  reason: collision with root package name */
    private int f13053K = 1;

    /* renamed from: L  reason: collision with root package name */
    private String f13054L = "";

    /* renamed from: M  reason: collision with root package name */
    private int f13055M = 1;

    /* renamed from: N  reason: collision with root package name */
    private String f13056N = "";

    /* renamed from: O  reason: collision with root package name */
    private int f13057O = 1;

    /* renamed from: P  reason: collision with root package name */
    private String f13058P = "Virtual Item";

    /* renamed from: Q  reason: collision with root package name */
    private String f13059Q = "";

    /* renamed from: R  reason: collision with root package name */
    private String f13060R = "";

    /* renamed from: S  reason: collision with root package name */
    private int f13061S = 0;

    /* renamed from: T  reason: collision with root package name */
    private int f13062T = 1;

    /* renamed from: U  reason: collision with root package name */
    private int f13063U = 60;

    /* renamed from: V  reason: collision with root package name */
    private String f13064V = "";

    /* renamed from: W  reason: collision with root package name */
    private JSONArray f13065W;

    /* renamed from: X  reason: collision with root package name */
    private JSONObject f13066X;

    /* renamed from: b  reason: collision with root package name */
    private String f13067b;

    /* renamed from: c  reason: collision with root package name */
    private String f13068c;

    /* renamed from: d  reason: collision with root package name */
    private List<b> f13069d;

    /* renamed from: e  reason: collision with root package name */
    private long f13070e;

    /* renamed from: f  reason: collision with root package name */
    private int f13071f = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f13072g = 0;

    /* renamed from: h  reason: collision with root package name */
    private int f13073h = 0;

    /* renamed from: i  reason: collision with root package name */
    private int f13074i = 1;

    /* renamed from: j  reason: collision with root package name */
    private int f13075j = 1;

    /* renamed from: k  reason: collision with root package name */
    private int f13076k = 1;

    /* renamed from: l  reason: collision with root package name */
    private int f13077l = 1;

    /* renamed from: m  reason: collision with root package name */
    private int f13078m = 5;

    /* renamed from: n  reason: collision with root package name */
    private int f13079n = 1;

    /* renamed from: o  reason: collision with root package name */
    private int f13080o = 3;

    /* renamed from: p  reason: collision with root package name */
    private int f13081p = 80;

    /* renamed from: q  reason: collision with root package name */
    private int f13082q = 100;

    /* renamed from: r  reason: collision with root package name */
    private int f13083r = 0;

    /* renamed from: s  reason: collision with root package name */
    private double f13084s = 1.0d;

    /* renamed from: t  reason: collision with root package name */
    private int f13085t = -1;

    /* renamed from: u  reason: collision with root package name */
    private ArrayList<Integer> f13086u;

    /* renamed from: v  reason: collision with root package name */
    private int f13087v = 3;

    /* renamed from: w  reason: collision with root package name */
    private int f13088w = 1;

    /* renamed from: x  reason: collision with root package name */
    private int f13089x = 100;

    /* renamed from: y  reason: collision with root package name */
    private int f13090y = 60;

    /* renamed from: z  reason: collision with root package name */
    private int f13091z = 0;

    private void y(int i5) {
        if (i5 <= 0) {
            this.f13055M = 1;
        } else {
            this.f13055M = i5;
        }
    }

    public final int A() {
        return this.f13087v;
    }

    public final Queue<Integer> B() {
        LinkedList linkedList;
        Exception e5;
        try {
            List<b> list = this.f13069d;
            if (list == null || list.size() <= 0) {
                return null;
            }
            linkedList = new LinkedList();
            int i5 = 0;
            while (i5 < this.f13069d.size()) {
                try {
                    linkedList.add(Integer.valueOf(this.f13069d.get(i5).b()));
                    i5++;
                } catch (Exception e6) {
                    e5 = e6;
                    e5.printStackTrace();
                    return linkedList;
                }
            }
            return linkedList;
        } catch (Exception e7) {
            Exception exc = e7;
            linkedList = null;
            e5 = exc;
            e5.printStackTrace();
            return linkedList;
        }
    }

    public final int C() {
        return this.f13062T;
    }

    public final int D() {
        return this.f13063U;
    }

    public final JSONObject E() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, this.f13067b);
            jSONObject.put("callbackType", this.f13074i);
            List<b> list = this.f13069d;
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (b next : this.f13069d) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("id", next.a());
                    jSONObject2.put("timeout", next.b());
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("adSourceList", jSONArray);
            }
            jSONObject.put("aqn", this.f13075j);
            jSONObject.put("acn", this.f13076k);
            jSONObject.put("vcn", this.f13077l);
            jSONObject.put(TypedValues.CycleType.S_WAVE_OFFSET, this.f13078m);
            jSONObject.put("dlnet", this.f13079n);
            jSONObject.put("tv_start", this.f13080o);
            jSONObject.put("tv_end", this.f13081p);
            jSONObject.put(CampaignEx.JSON_KEY_READY_RATE, this.f13082q);
            jSONObject.put("endscreen_type", this.f13051I);
            jSONObject.put("daily_play_cap", this.f13045B);
            jSONObject.put("video_skip_time", this.f13046C);
            jSONObject.put("video_skip_result", this.f13047D);
            jSONObject.put("video_interactive_type", this.f13048E);
            jSONObject.put("orientation", this.f13091z);
            jSONObject.put("close_button_delay", this.f13049F);
            jSONObject.put("playclosebtn_tm", this.f13071f);
            jSONObject.put("play_ctdown", this.f13072g);
            jSONObject.put("close_alert", this.f13073h);
            jSONObject.put("rfpv", this.f13085t);
            jSONObject.put("vdcmp", this.f13084s);
            JSONArray jSONArray2 = new JSONArray();
            ArrayList<Integer> arrayList = this.f13086u;
            if (arrayList != null) {
                if (arrayList.size() > 0) {
                    ArrayList<Integer> arrayList2 = this.f13086u;
                    int size = arrayList2.size();
                    int i5 = 0;
                    while (i5 < size) {
                        Integer num = arrayList2.get(i5);
                        i5++;
                        jSONArray2.put(num);
                    }
                }
                jSONObject.put("atl_type", jSONArray2);
            }
            jSONObject.put("atl_dyt", this.f13087v);
            jSONObject.put("tmorl", this.f13088w);
            jSONObject.put("placementid", this.f13068c);
            jSONObject.put("ltafemty", this.f13089x);
            jSONObject.put("ltorwc", this.f13090y);
            jSONObject.put(RewardPlus.AMOUNT_MAX, this.f13052J);
            jSONObject.put(RewardPlus.CALLBACK_RULE, this.f13053K);
            jSONObject.put(RewardPlus.VIRTUAL_CURRENCY, this.f13054L);
            jSONObject.put(RewardPlus.AMOUNT, this.f13055M);
            jSONObject.put(RewardPlus.ICON, this.f13056N);
            jSONObject.put(RewardPlus.CURRENCY_ID, this.f13057O);
            jSONObject.put(RewardPlus.NAME, this.f13058P);
            jSONObject.put("isDefault", this.f13061S);
            jSONObject.put("video_error_rule", this.f13062T);
            jSONObject.put("loadtmo", this.f13063U);
            jSONObject.put("vtag", this.f13064V);
            return jSONObject;
        } catch (Exception e5) {
            e5.printStackTrace();
            return jSONObject;
        }
    }

    public final int F() {
        return this.f13044A;
    }

    public final JSONArray G() {
        return this.f13065W;
    }

    public final int a() {
        return this.f13089x;
    }

    public final int b() {
        return this.f13090y;
    }

    public final int c() {
        return this.f13091z;
    }

    public final int d() {
        return this.f13045B;
    }

    public final int e() {
        return this.f13046C;
    }

    public final int f() {
        return this.f13047D;
    }

    public final int g() {
        return this.f13048E;
    }

    public final int h() {
        return this.f13071f;
    }

    public final int i() {
        return this.f13073h;
    }

    public final String j() {
        return this.f13064V;
    }

    public final String k() {
        return this.f13059Q;
    }

    public final String l() {
        return this.f13060R;
    }

    public final int m() {
        return this.f13055M;
    }

    public final String n() {
        return this.f13058P;
    }

    public final int o() {
        return this.f13050G;
    }

    public final int p() {
        return this.f13049F;
    }

    public final int q() {
        return this.f13051I;
    }

    public final int r() {
        return this.f13082q;
    }

    public final int s() {
        return this.f13083r;
    }

    public final int t() {
        return this.f13075j;
    }

    public final int u() {
        return this.f13076k;
    }

    public final int v() {
        return this.f13078m;
    }

    public final int w() {
        return this.f13079n;
    }

    public final long x() {
        return this.f13070e;
    }

    public final String z() {
        return this.f13068c;
    }

    public final void a(ArrayList<Integer> arrayList) {
        this.f13086u = arrayList;
    }

    public final void b(int i5) {
        this.f13045B = i5;
    }

    public final void c(int i5) {
        this.f13046C = i5;
    }

    public final void d(int i5) {
        this.f13047D = i5;
    }

    public final void e(int i5) {
        this.f13048E = i5;
    }

    public final void f(int i5) {
        this.f13049F = i5;
    }

    public final void g(int i5) {
        this.f13051I = i5;
    }

    public final void h(int i5) {
        this.f13080o = i5;
    }

    public final void i(int i5) {
        this.f13081p = i5;
    }

    public final void j(int i5) {
        this.f13082q = i5;
    }

    public final void k(int i5) {
        this.f13083r = i5;
    }

    public final void l(int i5) {
        this.f13075j = i5;
    }

    public final void m(int i5) {
        this.f13076k = i5;
    }

    public final void n(int i5) {
        this.f13077l = i5;
    }

    public final void o(int i5) {
        this.f13078m = i5;
    }

    public final void p(int i5) {
        this.f13079n = i5;
    }

    public final void q(int i5) {
        this.f13074i = i5;
    }

    public final void r(int i5) {
        this.f13088w = i5;
    }

    public final boolean s(int i5) {
        ArrayList<Integer> arrayList = this.f13086u;
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        return this.f13086u.contains(Integer.valueOf(i5));
    }

    public final void t(int i5) {
        this.f13087v = i5;
    }

    public final void u(int i5) {
        this.f13061S = i5;
    }

    public final void v(int i5) {
        this.f13062T = i5;
    }

    public final void w(int i5) {
        this.f13063U = i5;
    }

    public final void x(int i5) {
        this.f13044A = i5;
    }

    public static c c(String str) {
        JSONObject optJSONObject;
        if (f13042H == null) {
            f13042H = g.a(com.mbridge.msdk.foundation.controller.c.m().c());
        }
        c cVar = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("vtag", "");
                String optString2 = jSONObject.optString("rid", "");
                JSONArray optJSONArray = jSONObject.optJSONArray("unitSetting");
                if (!(optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null)) {
                    String optString3 = optJSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
                    if (!TextUtils.isEmpty(optString3)) {
                        c cVar2 = new c();
                        try {
                            cVar2.f13064V = optString;
                            cVar2.f13060R = optString2;
                            List<b> a5 = b.a(optJSONObject.optJSONArray("adSourceList"));
                            cVar2.f13067b = optString3;
                            cVar2.f13069d = a5;
                            cVar2.f13074i = optJSONObject.optInt("callbackType");
                            int optInt = optJSONObject.optInt("aqn", 1);
                            if (optInt <= 0) {
                                optInt = 1;
                            }
                            cVar2.f13075j = optInt;
                            int optInt2 = optJSONObject.optInt("acn", 1);
                            if (optInt2 < 0) {
                                optInt2 = 1;
                            }
                            cVar2.f13076k = optInt2;
                            cVar2.f13077l = optJSONObject.optInt("vcn", 5);
                            cVar2.f13078m = optJSONObject.optInt(TypedValues.CycleType.S_WAVE_OFFSET, 5);
                            cVar2.f13079n = optJSONObject.optInt("dlnet", 1);
                            cVar2.f13051I = optJSONObject.optInt("endscreen_type", 2);
                            int i5 = 3;
                            cVar2.f13080o = optJSONObject.optInt("tv_start", 3);
                            cVar2.f13081p = optJSONObject.optInt("tv_end", 80);
                            cVar2.f13082q = optJSONObject.optInt(CampaignEx.JSON_KEY_READY_RATE, 100);
                            cVar2.f13083r = optJSONObject.optInt("cd_rate", 0);
                            cVar2.f13070e = jSONObject.optLong("current_time");
                            cVar2.f13091z = optJSONObject.optInt("orientation", 0);
                            cVar2.f13045B = optJSONObject.optInt("daily_play_cap", 0);
                            cVar2.f13046C = optJSONObject.optInt("video_skip_time", -1);
                            cVar2.f13047D = optJSONObject.optInt("video_skip_result", 2);
                            cVar2.f13048E = optJSONObject.optInt("video_interactive_type", -1);
                            cVar2.f13049F = optJSONObject.optInt("close_button_delay", 1);
                            cVar2.f13071f = optJSONObject.optInt("playclosebtn_tm", -1);
                            cVar2.f13072g = optJSONObject.optInt("play_ctdown", 0);
                            cVar2.f13073h = optJSONObject.optInt("close_alert", 0);
                            cVar2.f13050G = optJSONObject.optInt("rdrct", 20);
                            cVar2.f13044A = optJSONObject.optInt("load_global_timeout", 70);
                            cVar2.f13085t = optJSONObject.optInt("rfpv", -1);
                            cVar2.f13084s = optJSONObject.optDouble("vdcmp", 1.0d);
                            f13043a = optJSONObject.optString("atzu");
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray("atl_type");
                            ArrayList<Integer> arrayList = new ArrayList<>();
                            if (optJSONArray2 != null) {
                                int i6 = 0;
                                while (i6 < optJSONArray2.length()) {
                                    try {
                                        arrayList.add(Integer.valueOf(optJSONArray2.getInt(i6)));
                                        i6++;
                                    } catch (Exception e5) {
                                        e5.printStackTrace();
                                    }
                                }
                            } else {
                                arrayList.add(4);
                                arrayList.add(6);
                            }
                            cVar2.f13086u = arrayList;
                            int optInt3 = optJSONObject.optInt("atl_dyt", 0);
                            if (optInt3 > 0) {
                                i5 = optInt3;
                            }
                            cVar2.f13087v = i5;
                            int optInt4 = optJSONObject.optInt("tmorl", 1);
                            if (optInt4 > 2 || optInt4 <= 0) {
                                optInt4 = 1;
                            }
                            cVar2.f13088w = optInt4;
                            cVar2.f13068c = optJSONObject.optString("placementid");
                            cVar2.f13089x = optJSONObject.optInt("ltafemty", 10);
                            cVar2.f13090y = optJSONObject.optInt("ltorwc", 60);
                            cVar2.d(optJSONObject.optString("ab_id"));
                            cVar2.f13052J = optJSONObject.optInt(RewardPlus.AMOUNT_MAX, 0);
                            cVar2.f13053K = optJSONObject.optInt(RewardPlus.CALLBACK_RULE, 1);
                            cVar2.f13054L = optJSONObject.optString(RewardPlus.VIRTUAL_CURRENCY, "");
                            cVar2.y(optJSONObject.optInt(RewardPlus.AMOUNT, 1));
                            cVar2.f13056N = optJSONObject.optString(RewardPlus.ICON, "");
                            cVar2.f13057O = optJSONObject.optInt(RewardPlus.CURRENCY_ID, 1);
                            cVar2.e(optJSONObject.optString(RewardPlus.NAME, "Virtual Item"));
                            cVar2.f13062T = optJSONObject.optInt("video_error_rule", 1);
                            cVar2.f13063U = optJSONObject.optInt("loadtmo", 60);
                            cVar2.f13065W = optJSONObject.optJSONArray("local_cache_info");
                            try {
                                String optString4 = optJSONObject.optString(MBridgeCommon.SettingConfig.KEY_SETTING_CONFIG_RETRY_STRATEGY);
                                if (!TextUtils.isEmpty(optString4)) {
                                    String a6 = z.a(optString4);
                                    if (!TextUtils.isEmpty(a6)) {
                                        cVar2.f13066X = new JSONObject(a6);
                                    }
                                }
                            } catch (Exception unused) {
                            }
                            return cVar2;
                        } catch (Exception e6) {
                            e = e6;
                            cVar = cVar2;
                            e.printStackTrace();
                            return cVar;
                        }
                    }
                }
            } catch (Exception e7) {
                e = e7;
                e.printStackTrace();
                return cVar;
            }
        }
        return cVar;
    }

    private void d(String str) {
        this.f13059Q = str;
        a.f8822b.put(this.f13067b, str);
    }

    private void e(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f13058P = this.f13054L;
        } else {
            this.f13058P = str;
        }
    }

    public final void a(int i5) {
        this.f13091z = i5;
    }

    public final void b(String str) {
        this.f13068c = str;
    }

    public final int y() {
        return this.f13088w;
    }

    public final void a(String str) {
        this.f13067b = str;
    }

    public final void a(List<b> list) {
        this.f13069d = list;
    }

    public static c a(JSONObject jSONObject) {
        c cVar;
        c cVar2 = null;
        if (jSONObject != null) {
            try {
                cVar = new c();
            } catch (Exception e5) {
                e = e5;
                e.printStackTrace();
                return cVar2;
            }
            try {
                cVar.f13069d = b.a(jSONObject.optJSONArray("adSourceList"));
                cVar.f13074i = jSONObject.optInt("callbackType");
                int optInt = jSONObject.optInt("aqn", 1);
                if (optInt <= 0) {
                    optInt = 1;
                }
                cVar.f13075j = optInt;
                int optInt2 = jSONObject.optInt("acn", 1);
                if (optInt2 < 0) {
                    optInt2 = 1;
                }
                cVar.f13076k = optInt2;
                cVar.f13077l = jSONObject.optInt("vcn", 5);
                cVar.f13078m = jSONObject.optInt(TypedValues.CycleType.S_WAVE_OFFSET, 5);
                cVar.f13079n = jSONObject.optInt("dlnet", 1);
                cVar.f13051I = jSONObject.optInt("endscreen_type", 2);
                cVar.f13080o = jSONObject.optInt("tv_start", 3);
                cVar.f13081p = jSONObject.optInt("tv_end", 80);
                cVar.f13082q = jSONObject.optInt(CampaignEx.JSON_KEY_READY_RATE, 100);
                cVar.f13070e = jSONObject.optLong("current_time");
                cVar.f13091z = jSONObject.optInt("orientation", 0);
                cVar.f13045B = jSONObject.optInt("daily_play_cap", 0);
                cVar.f13046C = jSONObject.optInt("video_skip_time", -1);
                cVar.f13047D = jSONObject.optInt("video_skip_result", 2);
                cVar.f13048E = jSONObject.optInt("video_interactive_type", -1);
                cVar.f13049F = jSONObject.optInt("close_button_delay", 1);
                cVar.f13071f = jSONObject.optInt("playclosebtn_tm", -1);
                cVar.f13072g = jSONObject.optInt("play_ctdown", 0);
                cVar.f13073h = jSONObject.optInt("close_alert", 0);
                cVar.f13050G = jSONObject.optInt("rdrct", 20);
                cVar.f13085t = jSONObject.optInt("rfpv", -1);
                cVar.f13084s = jSONObject.optDouble("vdcmp", 1.0d);
                cVar.f13044A = jSONObject.optInt("load_global_timeout", 70);
                JSONArray optJSONArray = jSONObject.optJSONArray("atl_type");
                ArrayList<Integer> arrayList = new ArrayList<>();
                if (optJSONArray != null) {
                    int i5 = 0;
                    while (i5 < optJSONArray.length()) {
                        try {
                            arrayList.add(Integer.valueOf(optJSONArray.getInt(i5)));
                            i5++;
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                } else {
                    arrayList.add(4);
                    arrayList.add(6);
                }
                cVar.f13086u = arrayList;
                cVar.f13087v = jSONObject.optInt("atl_dyt", 3);
                int optInt3 = jSONObject.optInt("tmorl", 1);
                if (optInt3 > 2 || optInt3 <= 0) {
                    optInt3 = 1;
                }
                cVar.f13088w = optInt3;
                cVar.f13068c = jSONObject.optString("placementid");
                cVar.f13089x = jSONObject.optInt("ltafemty", 10);
                cVar.f13090y = jSONObject.optInt("ltorwc", 60);
                cVar.d(jSONObject.optString("ab_id"));
                cVar.f13060R = jSONObject.optString("rid", "");
                cVar.f13052J = jSONObject.optInt(RewardPlus.AMOUNT_MAX, 0);
                cVar.f13053K = jSONObject.optInt(RewardPlus.CALLBACK_RULE, 1);
                cVar.f13054L = jSONObject.optString(RewardPlus.VIRTUAL_CURRENCY, "");
                cVar.y(jSONObject.optInt(RewardPlus.AMOUNT, 1));
                cVar.f13056N = jSONObject.optString(RewardPlus.ICON, "");
                cVar.f13057O = jSONObject.optInt(RewardPlus.CURRENCY_ID, 1);
                cVar.e(jSONObject.optString(RewardPlus.NAME, "Virtual Item"));
                cVar.f13062T = jSONObject.optInt("video_error_rule", 1);
                cVar.f13063U = jSONObject.optInt("loadtmo", 60);
                cVar.f13064V = jSONObject.optString("vtag", "");
                cVar.f13065W = jSONObject.optJSONArray("local_cache_info");
                try {
                    String optString = jSONObject.optString(MBridgeCommon.SettingConfig.KEY_SETTING_CONFIG_RETRY_STRATEGY);
                    if (!TextUtils.isEmpty(optString)) {
                        String a5 = z.a(optString);
                        if (!TextUtils.isEmpty(a5)) {
                            cVar.f13066X = new JSONObject(a5);
                        }
                    }
                } catch (Exception unused) {
                }
                return cVar;
            } catch (Exception e7) {
                e = e7;
                cVar2 = cVar;
                e.printStackTrace();
                return cVar2;
            }
        }
        return cVar2;
    }
}
