package com.mbridge.msdk.foundation.db.a;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.g;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.an;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f8936a = "FrequencyDaoMiddle";

    /* renamed from: b  reason: collision with root package name */
    private static a f8937b = null;

    /* renamed from: c  reason: collision with root package name */
    private static String f8938c = "FrequencyDaoMiddle";

    /* renamed from: d  reason: collision with root package name */
    private static JSONArray f8939d = new JSONArray();

    private a() {
        try {
            String str = (String) an.a(c.m().c(), f8938c, f8939d.toString());
            if (!TextUtils.isEmpty(str)) {
                f8939d = new JSONArray(str);
            }
        } catch (Exception e5) {
            af.b(f8936a, e5.getMessage());
        }
    }

    public static a a() {
        if (f8937b == null) {
            synchronized (a.class) {
                try {
                    if (f8937b == null) {
                        f8937b = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f8937b;
    }

    private void c() {
        try {
            if (f8939d != null) {
                an.b(c.m().c(), f8938c, f8939d.toString());
            }
        } catch (Exception e5) {
            af.b(f8936a, e5.getMessage());
        }
    }

    public final String[] b() {
        ArrayList arrayList = new ArrayList();
        if (f8939d != null) {
            for (int i5 = 0; i5 < f8939d.length(); i5++) {
                try {
                    JSONObject jSONObject = f8939d.getJSONObject(i5);
                    if (jSONObject != null && jSONObject.optInt("fc_a") < jSONObject.optInt("impression_count")) {
                        arrayList.add(jSONObject.optString("id"));
                    }
                } catch (JSONException e5) {
                    af.b(f8936a, e5.getMessage());
                }
            }
        }
        String[] strArr = new String[arrayList.size()];
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            strArr[i6] = (String) arrayList.get(i6);
        }
        return strArr;
    }

    public final void a(g gVar) {
        JSONObject a5;
        if (gVar != null && (a5 = a(gVar.a(), gVar.c(), gVar.d(), gVar.f(), gVar.e(), gVar.b())) != null) {
            if (f8939d == null) {
                f8939d = new JSONArray();
            }
            f8939d.put(a5);
            c();
        }
    }

    public final void a(String str) {
        if (f8939d != null) {
            JSONArray jSONArray = new JSONArray();
            for (int i5 = 0; i5 < f8939d.length(); i5++) {
                try {
                    JSONObject jSONObject = f8939d.getJSONObject(i5);
                    if (jSONObject != null) {
                        if (jSONObject.optString("id", "").equals(str)) {
                            jSONObject.put("impression_count", jSONObject.optInt("impression_count", 0) + 1);
                            jSONArray.put(jSONObject);
                        } else {
                            jSONArray.put(jSONObject);
                        }
                    }
                } catch (JSONException e5) {
                    af.b(f8936a, e5.getMessage());
                }
            }
            if (jSONArray.length() > 0) {
                f8939d = jSONArray;
            }
            c();
        }
    }

    public final void a(long j5) {
        if (f8939d != null) {
            JSONArray jSONArray = new JSONArray();
            for (int i5 = 0; i5 < f8939d.length(); i5++) {
                try {
                    JSONObject jSONObject = f8939d.getJSONObject(i5);
                    if (jSONObject != null && ((long) jSONObject.optInt(CampaignEx.JSON_KEY_ST_TS)) >= j5) {
                        jSONArray.put(jSONObject);
                    }
                } catch (JSONException e5) {
                    af.b(f8936a, e5.getMessage());
                }
            }
            if (jSONArray.length() > 0) {
                f8939d = jSONArray;
            }
        }
        c();
    }

    private JSONObject a(String str, int i5, int i6, long j5, int i7, int i8) {
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("id", str);
                jSONObject2.put("fc_a", i5);
                jSONObject2.put("fc_b", i6);
                jSONObject2.put(CampaignEx.JSON_KEY_ST_TS, j5);
                jSONObject2.put("impression_count", i7);
                jSONObject2.put("click_count", i8);
                return jSONObject2;
            } catch (Exception e5) {
                e = e5;
                jSONObject = jSONObject2;
                af.b(f8936a, e.getMessage());
                return jSONObject;
            }
        } catch (Exception e6) {
            e = e6;
            af.b(f8936a, e.getMessage());
            return jSONObject;
        }
    }
}
