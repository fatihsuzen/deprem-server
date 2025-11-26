package com.mbridge.msdk.video.bt.a;

import android.text.TextUtils;
import android.util.Base64;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.video.bt.a.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    int f11812a;

    /* renamed from: b  reason: collision with root package name */
    int f11813b;

    /* renamed from: c  reason: collision with root package name */
    private String f11814c;

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static c f11815a = new c();
    }

    public static c a() {
        return a.f11815a;
    }

    private c() {
        this.f11814c = "handlerNativeResult";
        this.f11812a = 0;
        this.f11813b = 1;
    }

    public final void a(Object obj, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (!TextUtils.isEmpty(jSONObject.toString())) {
                    String optString = jSONObject.optString("uniqueIdentifier");
                    String optString2 = jSONObject.optString(RewardPlus.NAME);
                    if (!TextUtils.isEmpty(optString)) {
                        if (!TextUtils.isEmpty(optString2)) {
                            JSONArray optJSONArray = jSONObject.optJSONArray("parameters");
                            JSONObject optJSONObject = jSONObject.optJSONObject("result");
                            int i5 = 0;
                            if (optJSONObject != null && !TextUtils.isEmpty(optJSONObject.toString())) {
                                i5 = optJSONObject.optInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 0);
                            }
                            a(this.f11812a, "receivedMessage", obj);
                            if (optString.equalsIgnoreCase("reporter")) {
                                com.mbridge.msdk.mbsignalcommon.a.a.a().a(obj, optString2, optJSONArray, i5);
                                return;
                            } else if (optString.equalsIgnoreCase("MediaPlayer")) {
                                b unused = b.a.f11811a;
                                return;
                            } else {
                                return;
                            }
                        }
                    }
                    a(this.f11813b, "module or method is null", obj);
                    return;
                }
            } catch (Exception e5) {
                af.a("HandlerH5MessageManager", e5.getMessage());
                a(this.f11813b, e5.getMessage(), obj);
                return;
            } catch (Throwable th) {
                af.a("HandlerH5MessageManager", th.getMessage());
                a(this.f11813b, th.getMessage(), obj);
                return;
            }
        }
        a(this.f11813b, "params is null", obj);
    }

    private void a(int i5, String str, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i5);
            jSONObject.put("message", str);
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (JSONException e5) {
            af.a("HandlerH5MessageManager", e5.getMessage());
        } catch (Throwable th) {
            af.a("HandlerH5MessageManager", th.getMessage());
        }
    }
}
