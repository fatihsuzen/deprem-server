package com.mbridge.msdk.newreward.function.command.receiver.concretereceiver;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.net.d;
import com.mbridge.msdk.foundation.same.net.e.c;
import com.mbridge.msdk.newreward.function.command.receiver.e;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class f implements e {
    public final Object a(Object obj) {
        Map map;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Map) {
            map = (Map) obj;
        } else {
            map = null;
        }
        if (map == null) {
            return null;
        }
        com.mbridge.msdk.newreward.a.e eVar = (com.mbridge.msdk.newreward.a.e) map.get("adapter_model");
        long longValue = ((Long) map.get("last_response_empty_time")).longValue();
        if (eVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(eVar.J()) || eVar.x() == null || eVar.x().b() == null || System.currentTimeMillis() - longValue >= ((long) (eVar.x().b().a() * 1000))) {
            d a5 = c.a().a(eVar.B(), eVar.H(), eVar.C(), eVar.J(), eVar.h() + "");
            if (a5 != null) {
                try {
                    JSONObject jSONObject = new JSONObject(a5.f9311c.toString());
                    jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
                    jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
                    hashMap.put("error_code", jSONObject.optInt(NotificationCompat.CATEGORY_STATUS) + "");
                    hashMap.put(NotificationCompat.CATEGORY_MESSAGE, jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE));
                    return hashMap;
                } catch (JSONException e5) {
                    if (MBridgeConstans.DEBUG) {
                        e5.printStackTrace();
                    }
                }
            }
            return hashMap;
        }
        hashMap.put("error_code", "-1");
        hashMap.put(NotificationCompat.CATEGORY_MESSAGE, "EXCEPTION_RETURN_EMPTY");
        return hashMap;
    }
}
