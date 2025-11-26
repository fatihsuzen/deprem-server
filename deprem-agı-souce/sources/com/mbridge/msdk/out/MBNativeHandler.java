package com.mbridge.msdk.out;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.e;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.aj;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.ap;
import com.mbridge.msdk.mbnative.c.b;
import com.mbridge.msdk.mbnative.d.a;
import com.mbridge.msdk.out.NativeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class MBNativeHandler extends b implements BaseExtraInterfaceForHandler {
    private static final String TAG = MBNativeHandler.class.getName();
    public static final String TEMPLATE_ID = "id";
    public static final String TEMPLATE_NUM = "ad_num";
    private static String mUnitID;
    private a adListener = new a();
    private com.mbridge.msdk.click.a clickControler;
    private Context context;
    private Map<String, Object> map;
    private com.mbridge.msdk.mbnative.f.a nativeProvider;
    private List<NativeListener.Template> templateList;
    private NativeListener.NativeTrackingListener trackingListener;

    public static class KeyWordInfo {
        String keyWordPN;
        String keyWorkVN;

        public KeyWordInfo(String str, String str2) {
            this.keyWordPN = str;
            this.keyWorkVN = str2;
        }

        public String getKeyWordPN() {
            return this.keyWordPN;
        }

        public String getKeyWorkVN() {
            return this.keyWorkVN;
        }

        public void setKeyWordPN(String str) {
            this.keyWordPN = str;
        }

        public void setKeyWorkVN(String str) {
            this.keyWorkVN = str;
        }
    }

    public MBNativeHandler(Context context2) {
        this.context = context2;
        if (c.m().c() == null && context2 != null) {
            c.m().b(context2);
        }
        Map<String, Object> map2 = this.map;
        if (map2 != null && map2.containsKey(MBridgeConstans.PROPERTIES_UNIT_ID)) {
            String str = (String) this.map.get(MBridgeConstans.PROPERTIES_UNIT_ID);
            if (!TextUtils.isEmpty(str)) {
                a aVar = this.adListener;
                if (aVar != null) {
                    aVar.a(str);
                }
                String e5 = ak.e(str);
                if (!TextUtils.isEmpty(e5)) {
                    ak.b(str, e5);
                }
            }
        }
    }

    public static Map<String, Object> getNativeProperties(String str, String str2) {
        HashMap hashMap = new HashMap();
        mUnitID = str2;
        hashMap.put(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
        String str3 = MBridgeConstans.PLACEMENT_ID;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        hashMap.put(str3, str);
        hashMap.put(MBridgeConstans.PLUGIN_NAME, new String[]{MBridgeConstans.PLUGIN_NATIVE});
        hashMap.put(MBridgeConstans.PROPERTIES_LAYOUT_TYPE, 0);
        return hashMap;
    }

    public static String getTemplateString(List<NativeListener.Template> list) {
        if (list == null) {
            return null;
        }
        try {
            if (list.size() <= 0) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (NativeListener.Template next : list) {
                stringBuffer.append("{\"id\":");
                stringBuffer.append(next.getId() + ",");
                stringBuffer.append("\"ad_num\":");
                stringBuffer.append(next.getAdNum() + "},");
            }
            return "[{$native_info}]".replace("{$native_info}", stringBuffer.subSequence(0, stringBuffer.lastIndexOf(",")));
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean loadMB() {
        if (this.properties == null || !this.properties.containsKey(MBridgeConstans.PROPERTIES_UNIT_ID)) {
            af.d(TAG, "no unit id.");
            return true;
        }
        List<NativeListener.Template> list = this.templateList;
        if (list != null && list.size() > 0) {
            try {
                this.properties.put(MBridgeConstans.NATIVE_INFO, buildTemplateString());
            } catch (Exception unused) {
                af.d(TAG, "MBSDK set template error");
            }
        }
        try {
            this.properties.put(MBridgeConstans.PROPERTIES_HANDLER_CONTROLLER, this);
            if (this.nativeProvider == null) {
                com.mbridge.msdk.mbnative.f.a aVar = new com.mbridge.msdk.mbnative.f.a(this.adListener, this.trackingListener);
                this.nativeProvider = aVar;
                aVar.a(this.context, (Resources) null, this.properties);
            }
            this.nativeProvider.a();
            return true;
        } catch (Exception e5) {
            e5.printStackTrace();
            return true;
        }
    }

    private boolean loadMBFrame() {
        List<NativeListener.Template> list = this.templateList;
        if (list != null && list.size() > 0) {
            try {
                this.properties.put(MBridgeConstans.NATIVE_INFO, buildTemplateString());
            } catch (Exception unused) {
                af.d(TAG, "MBSDK set template error");
            }
        }
        try {
            this.properties.put(MBridgeConstans.PROPERTIES_HANDLER_CONTROLLER, this);
            if (this.nativeProvider == null) {
                com.mbridge.msdk.mbnative.f.a aVar = new com.mbridge.msdk.mbnative.f.a(this.adListener, this.trackingListener);
                this.nativeProvider = aVar;
                aVar.a(this.context, (Resources) null, this.properties);
            }
            this.nativeProvider.b();
            return true;
        } catch (Exception e5) {
            e5.printStackTrace();
            return true;
        }
    }

    public void addTemplate(NativeListener.Template template) {
        if (template != null) {
            if (this.templateList == null) {
                this.templateList = new ArrayList();
            }
            this.templateList.add(template);
        }
    }

    public String buildTemplateString() {
        try {
            List<NativeListener.Template> list = this.templateList;
            if (list == null || list.size() <= 0) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (NativeListener.Template next : this.templateList) {
                stringBuffer.append("{\"id\":");
                stringBuffer.append(next.getId() + ",");
                stringBuffer.append("\"ad_num\":");
                stringBuffer.append(next.getAdNum() + "},");
            }
            return "[{$native_info}]".replace("{$native_info}", stringBuffer.subSequence(0, stringBuffer.lastIndexOf(",")));
        } catch (Exception unused) {
            return null;
        }
    }

    public void clearCacheByUnitid(String str) {
        try {
            if (!ap.a(str)) {
                e.a((f) g.a(c.m().c())).c(str);
                if (!com.mbridge.msdk.e.b.a()) {
                    c.m().b(str);
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public void clearVideoCache() {
        try {
            com.mbridge.msdk.mbnative.f.a aVar = this.nativeProvider;
            if (aVar != null) {
                aVar.c();
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public a getAdListener() {
        return this.adListener;
    }

    public String getCreativeIdWithUnitId() {
        com.mbridge.msdk.mbnative.f.a aVar = this.nativeProvider;
        if (aVar != null) {
            return aVar.f();
        }
        return "";
    }

    public String getRequestId() {
        com.mbridge.msdk.mbnative.f.a aVar = this.nativeProvider;
        if (aVar != null) {
            return aVar.e();
        }
        return "";
    }

    public NativeListener.NativeTrackingListener getTrackingListener() {
        return this.trackingListener;
    }

    public void handleResult(Campaign campaign, String str) {
        String str2;
        if (this.clickControler == null) {
            Map<String, Object> map2 = this.map;
            if (map2 != null) {
                str2 = (String) map2.get(MBridgeConstans.PROPERTIES_UNIT_ID);
            } else {
                str2 = null;
            }
            this.clickControler = new com.mbridge.msdk.click.a(this.context, str2);
        }
        this.clickControler.a(campaign, str);
    }

    public boolean load() {
        if (this.properties == null || !this.properties.containsKey(MBridgeConstans.PROPERTIES_UNIT_ID)) {
            af.d(TAG, "no unit id.");
            return true;
        }
        loadMB();
        return true;
    }

    public boolean loadFrame() {
        if (this.properties == null || !this.properties.containsKey(MBridgeConstans.PROPERTIES_UNIT_ID)) {
            af.d(TAG, "no unit id.");
            return true;
        }
        loadMBFrame();
        return true;
    }

    public void registerView(View view, Campaign campaign) {
        if (this.nativeProvider == null) {
            this.nativeProvider = new com.mbridge.msdk.mbnative.f.a(this.adListener, this.trackingListener);
            if (this.properties != null) {
                this.properties.put(MBridgeConstans.PROPERTIES_HANDLER_CONTROLLER, this);
            }
            this.nativeProvider.a(this.context, (Resources) null, this.properties);
        }
        this.nativeProvider.a(view, campaign);
    }

    public void release() {
        com.mbridge.msdk.mbnative.f.a aVar = this.nativeProvider;
        if (aVar != null) {
            aVar.d();
        }
        this.trackingListener = null;
        c.m().b(mUnitID);
    }

    public void setAdListener(NativeListener.NativeAdListener nativeAdListener) {
        a aVar = new a(nativeAdListener);
        this.adListener = aVar;
        aVar.a(mUnitID);
        com.mbridge.msdk.mbnative.f.a aVar2 = this.nativeProvider;
        if (aVar2 != null) {
            aVar2.a(this.adListener);
        }
    }

    public void setExtraInfo(JSONObject jSONObject) {
        c.m().a(mUnitID, jSONObject);
    }

    public void setMustBrowser(boolean z4) {
        aj.f9640b = z4;
    }

    public void setTrackingListener(NativeListener.NativeTrackingListener nativeTrackingListener) {
        this.trackingListener = nativeTrackingListener;
        com.mbridge.msdk.mbnative.f.a aVar = this.nativeProvider;
        if (aVar != null) {
            aVar.a(nativeTrackingListener);
        }
    }

    public void unregisterView(View view, Campaign campaign) {
        if (this.nativeProvider == null) {
            this.nativeProvider = new com.mbridge.msdk.mbnative.f.a(this.adListener, this.trackingListener);
            if (this.properties != null) {
                this.properties.put(MBridgeConstans.PROPERTIES_HANDLER_CONTROLLER, this);
            }
            this.nativeProvider.a(this.context, (Resources) null, this.properties);
        }
        this.nativeProvider.b(view, campaign);
        c.m().b(mUnitID);
    }

    public void registerView(View view, List<View> list, Campaign campaign) {
        if (this.nativeProvider == null) {
            this.nativeProvider = new com.mbridge.msdk.mbnative.f.a(this.adListener, this.trackingListener);
            if (this.properties != null) {
                this.properties.put(MBridgeConstans.PROPERTIES_HANDLER_CONTROLLER, this);
            }
            this.nativeProvider.a(this.context, (Resources) null, this.properties);
        }
        this.nativeProvider.a(view, list, campaign);
    }

    public void unregisterView(View view, List<View> list, Campaign campaign) {
        if (this.nativeProvider == null) {
            this.nativeProvider = new com.mbridge.msdk.mbnative.f.a(this.adListener, this.trackingListener);
            if (this.properties != null) {
                this.properties.put(MBridgeConstans.PROPERTIES_HANDLER_CONTROLLER, this);
            }
            this.nativeProvider.a(this.context, (Resources) null, this.properties);
        }
        this.nativeProvider.b(view, list, campaign);
        c.m().b(mUnitID);
    }

    public MBNativeHandler(Map<String, Object> map2, Context context2) {
        super(map2, context2);
        this.context = context2;
        this.map = map2;
        if (c.m().c() == null && context2 != null) {
            c.m().b(context2);
        }
        if (map2 != null) {
            try {
                if (map2.containsKey(MBridgeConstans.PROPERTIES_UNIT_ID) && map2.get(MBridgeConstans.PROPERTIES_UNIT_ID) != null && (map2.get(MBridgeConstans.PROPERTIES_UNIT_ID) instanceof String) && map2.containsKey(MBridgeConstans.NATIVE_VIDEO_WIDTH) && map2.get(MBridgeConstans.NATIVE_VIDEO_WIDTH) != null && (map2.get(MBridgeConstans.NATIVE_VIDEO_WIDTH) instanceof Integer) && map2.containsKey(MBridgeConstans.NATIVE_VIDEO_HEIGHT) && map2.get(MBridgeConstans.NATIVE_VIDEO_HEIGHT) != null) {
                    map2.get(MBridgeConstans.NATIVE_VIDEO_HEIGHT);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (map2 != null && map2.containsKey(MBridgeConstans.PROPERTIES_UNIT_ID)) {
            String str = (String) map2.get(MBridgeConstans.PROPERTIES_UNIT_ID);
            if (!TextUtils.isEmpty(str)) {
                a aVar = this.adListener;
                if (aVar != null) {
                    aVar.a(str);
                }
                String e5 = ak.e(str);
                if (!TextUtils.isEmpty(e5)) {
                    ak.b(str, e5);
                }
            }
        }
    }
}
