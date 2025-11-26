package com.mbridge.msdk.videocommon.b;

import org.json.JSONObject;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private String f13007a;

    /* renamed from: b  reason: collision with root package name */
    private String f13008b;

    private a(String str, String str2) {
        this.f13007a = str;
        this.f13008b = str2;
    }

    public static a a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                return new a(jSONObject.optString("appId"), jSONObject.optString("placementId"));
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        return null;
    }
}
