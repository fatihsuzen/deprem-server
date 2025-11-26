package com.mbridge.msdk.videocommon.b;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.videocommon.d.a;
import com.mbridge.msdk.videocommon.d.b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private String f13012a;

    /* renamed from: b  reason: collision with root package name */
    private int f13013b;

    public c(String str, int i5) {
        this.f13012a = str;
        this.f13013b = i5;
    }

    private static c c() {
        return new c("Virtual Item", 1);
    }

    public final String a() {
        return this.f13012a;
    }

    public final int b() {
        return this.f13013b;
    }

    public final String toString() {
        return "Reward{name='" + this.f13012a + '\'' + ", amount=" + this.f13013b + '}';
    }

    public static c b(String str) {
        c cVar = null;
        try {
            a b5 = b.a().b();
            if (TextUtils.isEmpty(str)) {
                cVar = c();
            } else if (!(b5 == null || b5.j() == null)) {
                cVar = b5.j().get(str);
            }
            return cVar == null ? c() : cVar;
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public final void a(String str) {
        this.f13012a = str;
    }

    public final void a(int i5) {
        this.f13013b = i5;
    }

    public static Map<String, c> a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i5);
                hashMap.put(optJSONObject.optString("id"), new c(optJSONObject.optString(RewardPlus.NAME), optJSONObject.optInt(RewardPlus.AMOUNT)));
            }
            return hashMap;
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public static c a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String optString = jSONObject.optString(RewardPlus.NAME);
            int optInt = jSONObject.optInt(RewardPlus.AMOUNT);
            jSONObject.optString("id");
            return new c(optString, optInt);
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }
}
