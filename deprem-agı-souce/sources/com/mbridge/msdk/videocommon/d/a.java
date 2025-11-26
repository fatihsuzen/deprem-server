package com.mbridge.msdk.videocommon.d;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.videocommon.b.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Integer> f13022a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, c> f13023b;

    /* renamed from: c  reason: collision with root package name */
    private long f13024c;

    /* renamed from: d  reason: collision with root package name */
    private long f13025d;

    /* renamed from: e  reason: collision with root package name */
    private long f13026e;

    /* renamed from: f  reason: collision with root package name */
    private long f13027f;

    /* renamed from: g  reason: collision with root package name */
    private long f13028g;

    /* renamed from: h  reason: collision with root package name */
    private long f13029h;

    /* renamed from: i  reason: collision with root package name */
    private int f13030i = 0;

    /* renamed from: j  reason: collision with root package name */
    private String f13031j;

    /* renamed from: k  reason: collision with root package name */
    private String f13032k = "";

    /* renamed from: l  reason: collision with root package name */
    private String f13033l = "";

    public final String a() {
        return this.f13032k;
    }

    public final String b() {
        return this.f13031j;
    }

    public final String c() {
        return this.f13033l;
    }

    public final long d() {
        return this.f13024c * 1000;
    }

    public final long e() {
        return this.f13025d * 1000;
    }

    public final long f() {
        return this.f13026e * 1000;
    }

    public final long g() {
        return this.f13027f;
    }

    public final long h() {
        return this.f13028g;
    }

    public final long i() {
        return this.f13029h;
    }

    public final Map<String, c> j() {
        return this.f13023b;
    }

    public final JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            Map<String, Integer> map = this.f13022a;
            if (map != null && map.size() > 0) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry next : this.f13022a.entrySet()) {
                        jSONObject2.put((String) next.getKey(), ((Integer) next.getValue()).intValue());
                    }
                    jSONObject.put("caplist", jSONObject2);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            Map<String, c> map2 = this.f13023b;
            if (map2 != null && map2.size() > 0) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry next2 : this.f13023b.entrySet()) {
                        JSONObject jSONObject3 = new JSONObject();
                        String str = (String) next2.getKey();
                        c cVar = (c) next2.getValue();
                        if (cVar != null) {
                            jSONObject3.put(RewardPlus.NAME, cVar.a());
                            jSONObject3.put(RewardPlus.AMOUNT, cVar.b());
                            jSONObject3.put("id", str);
                        }
                        jSONArray.put(jSONObject3);
                    }
                    jSONObject.put("reward", jSONArray);
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
            jSONObject.put("getpf", this.f13024c);
            jSONObject.put("ruct", this.f13025d);
            jSONObject.put(CampaignEx.JSON_KEY_PLCT, this.f13026e);
            jSONObject.put("dlct", this.f13027f);
            jSONObject.put("vcct", this.f13028g);
            jSONObject.put("current_time", this.f13029h);
            jSONObject.put("vtag", this.f13032k);
            jSONObject.put("isDefault", this.f13030i);
            return jSONObject;
        } catch (Exception e7) {
            e7.printStackTrace();
            return jSONObject;
        }
    }

    public final void a(long j5) {
        this.f13024c = j5;
    }

    public final void b(long j5) {
        this.f13025d = j5;
    }

    public final void c(long j5) {
        this.f13026e = j5;
    }

    public final void d(long j5) {
        this.f13027f = j5;
    }

    public final void e(long j5) {
        this.f13028g = j5;
    }

    public final void a(Map<String, Integer> map) {
        this.f13022a = map;
    }

    public final void b(Map<String, c> map) {
        this.f13023b = map;
    }

    public final void a(int i5) {
        this.f13030i = i5;
    }

    public static a a(String str) {
        a aVar = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                a aVar2 = new a();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    JSONObject optJSONObject = jSONObject.optJSONObject("caplist");
                    aVar2.f13031j = jSONObject.optString("ab_id", "");
                    aVar2.f13033l = jSONObject.optString("rid", "");
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        HashMap hashMap = new HashMap();
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys != null && keys.hasNext()) {
                            String next = keys.next();
                            int optInt = optJSONObject.optInt(next, 1000);
                            if (!TextUtils.isEmpty(next)) {
                                if (TextUtils.isEmpty(next) || optInt != 0) {
                                    hashMap.put(next, Integer.valueOf(optInt));
                                } else {
                                    hashMap.put(next, 1000);
                                }
                            }
                        }
                        aVar2.f13022a = hashMap;
                    }
                    aVar2.f13023b = c.a(jSONObject.optJSONArray("reward"));
                    aVar2.f13024c = jSONObject.optLong("getpf", 43200);
                    aVar2.f13025d = jSONObject.optLong("ruct", 5400);
                    aVar2.f13026e = jSONObject.optLong(CampaignEx.JSON_KEY_PLCT, 3600);
                    aVar2.f13027f = jSONObject.optLong("dlct", 3600);
                    aVar2.f13028g = jSONObject.optLong("vcct", 5);
                    aVar2.f13029h = jSONObject.optLong("current_time");
                    aVar2.f13032k = jSONObject.optString("vtag", "");
                    return aVar2;
                } catch (Exception e5) {
                    e = e5;
                    aVar = aVar2;
                    e.printStackTrace();
                    return aVar;
                }
            } catch (Exception e6) {
                e = e6;
                e.printStackTrace();
                return aVar;
            }
        }
        return aVar;
    }
}
