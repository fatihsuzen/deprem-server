package com.mbridge.msdk.video.module.c;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.net.f.e;
import com.mbridge.msdk.foundation.tools.z;
import org.json.JSONObject;

public final class b extends a {
    public b(Context context) {
        super(context);
    }

    public final void addExtraParams(String str, e eVar) {
        super.addExtraParams(str, eVar);
        if (h.a().b(c.m().k()) != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(jSONObject.toString())) {
                    String b5 = z.b(jSONObject.toString());
                    if (!TextUtils.isEmpty(b5)) {
                        eVar.a("dvi", b5);
                    }
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }
}
