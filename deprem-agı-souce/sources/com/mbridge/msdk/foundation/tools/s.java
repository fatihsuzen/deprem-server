package com.mbridge.msdk.foundation.tools;

import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class s {
    public static String a(int i5, int i6, int i7, int i8, int i9) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", 0);
            jSONObject.put("message", "Success");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("rotateAngle", i5);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(TtmlNode.LEFT, i6);
            jSONObject3.put(TtmlNode.RIGHT, i7);
            jSONObject3.put("top", i8);
            jSONObject3.put("bottom", i9);
            jSONObject2.put("cutoutInfo", jSONObject3);
            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
        } catch (Exception e5) {
            af.b("JSONUtils", e5.getMessage());
        } catch (Throwable th) {
            af.b("JSONUtils", th.getMessage());
            try {
                jSONObject.put("code", 1);
                jSONObject.put("message", "Fail");
            } catch (JSONException e6) {
                af.b("JSONUtils", e6.getMessage());
            }
        }
        return jSONObject.toString();
    }

    public static ArrayList<String> a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        ArrayList<String> arrayList = new ArrayList<>(length);
        for (int i5 = 0; i5 < length; i5++) {
            arrayList.add(jSONArray.optString(i5));
        }
        return arrayList;
    }
}
