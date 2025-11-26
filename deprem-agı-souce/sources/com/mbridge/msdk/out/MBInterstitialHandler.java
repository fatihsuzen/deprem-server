package com.mbridge.msdk.out;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.interstitial.c.a;
import java.util.Map;

public class MBInterstitialHandler {
    private a mController;
    private String unitId;

    public MBInterstitialHandler(Context context, Map<String, Object> map) {
        if (this.mController == null) {
            this.mController = new a();
        }
        if (map != null && map.containsKey(MBridgeConstans.PROPERTIES_UNIT_ID)) {
            String str = (String) map.get(MBridgeConstans.PROPERTIES_UNIT_ID);
            this.unitId = str;
            if (!TextUtils.isEmpty(str)) {
                String e5 = ak.e(str);
                if (!TextUtils.isEmpty(e5)) {
                    ak.b(str, e5);
                }
            }
        }
        this.mController.a(context, map);
        if (c.m().c() == null && context != null) {
            c.m().b(context);
        }
    }

    public String getCreativeIdWithUnitId() {
        a aVar = this.mController;
        if (aVar != null) {
            return aVar.c();
        }
        return "";
    }

    public String getRequestId() {
        a aVar = this.mController;
        if (aVar != null) {
            return aVar.b();
        }
        return "";
    }

    public void preload() {
        try {
            a aVar = this.mController;
            if (aVar != null) {
                aVar.a();
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public void setInterstitialListener(InterstitialListener interstitialListener) {
        try {
            a aVar = this.mController;
            if (aVar != null) {
                aVar.a(interstitialListener);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public void show() {
        try {
            this.mController.d();
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }
}
