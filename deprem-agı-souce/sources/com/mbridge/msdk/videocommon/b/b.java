package com.mbridge.msdk.videocommon.b;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private int f13009a;

    /* renamed from: b  reason: collision with root package name */
    private int f13010b;

    /* renamed from: c  reason: collision with root package name */
    private a f13011c;

    public b(int i5, int i6, a aVar) {
        this.f13009a = i5;
        this.f13010b = i6;
        this.f13011c = aVar;
    }

    public final int a() {
        return this.f13009a;
    }

    public final int b() {
        return this.f13010b;
    }

    public static List<b> a(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            int i5 = 0;
            while (i5 < jSONArray.length()) {
                try {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i5);
                    int optInt = optJSONObject.optInt("id");
                    int optInt2 = optJSONObject.optInt("timeout");
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("params");
                    arrayList.add(new b(optInt, optInt2, optJSONObject2 != null ? a.a(optJSONObject2) : null));
                    i5++;
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            return arrayList;
        }
        return null;
    }
}
