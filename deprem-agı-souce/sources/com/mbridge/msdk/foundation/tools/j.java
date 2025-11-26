package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.authoritycontroller.c;
import org.json.JSONException;
import org.json.JSONObject;

public class j extends d {

    /* renamed from: w  reason: collision with root package name */
    public int f9724w = ab.f();

    /* renamed from: x  reason: collision with root package name */
    public int f9725x = ab.o();

    public j(Context context) {
        super(context);
    }

    public JSONObject a() {
        JSONObject a5 = super.a();
        try {
            if (c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("dmt", this.f9725x + "");
                jSONObject.put("dmf", this.f9724w);
                return a5;
            }
        } catch (JSONException e5) {
            if (MBridgeConstans.DEBUG) {
                af.b("DomainDeviceInfo", e5.getMessage());
            }
        }
        return a5;
    }
}
