package com.mbridge.msdk.newreward.function.command.receiver.tagreceiver;

import android.text.TextUtils;
import com.mbridge.apt_anotation.ReceiverAction;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.function.command.receiver.b;
import com.mbridge.msdk.newreward.function.common.MBridgeSharedPreferenceModel;
import com.mbridge.msdk.newreward.function.h.c;
import java.io.File;
import java.util.Map;

@ReceiverAction(id = "SharePreReceiver", type = b.class)
public class SharePreReceiver implements b {
    public final void a(Object obj) {
        int i5;
        String str;
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.get("resource_type") instanceof Integer) {
                i5 = ((Integer) map.get("resource_type")).intValue();
            } else {
                i5 = -1;
            }
            if (2 == i5) {
                if (map.get("metrics_config_path") instanceof String) {
                    str = (String) map.get("metrics_config_path");
                } else {
                    str = "";
                }
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str)) {
                    try {
                        String a5 = c.a(new File(str));
                        if (!TextUtils.isEmpty(a5)) {
                            MBridgeSharedPreferenceModel.getInstance().putString(MBridgeConstans.SP_DYNAMIC_METRICS_REPORT, a5);
                        }
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            e5.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
