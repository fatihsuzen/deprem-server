package com.mbridge.msdk.out;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.system.NoProGuard;
import j$.util.concurrent.ConcurrentHashMap;

public class CustomInfoManager implements NoProGuard {
    private static CustomInfoManager INSTANCE = null;
    private static String TAG = "CustomInfoManager";
    public static final int TYPE_BID = 6;
    public static final int TYPE_BIDLOAD = 7;
    public static final int TYPE_LOAD = 8;
    private ConcurrentHashMap<String, String> infoMap = new ConcurrentHashMap<>();

    private CustomInfoManager() {
    }

    public static synchronized CustomInfoManager getInstance() {
        CustomInfoManager customInfoManager;
        synchronized (CustomInfoManager.class) {
            try {
                if (INSTANCE == null) {
                    synchronized (CustomInfoManager.class) {
                        if (INSTANCE == null) {
                            INSTANCE = new CustomInfoManager();
                        }
                    }
                }
                customInfoManager = INSTANCE;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            } finally {
            }
        }
        return customInfoManager;
    }

    public String getCustomInfoByType(String str, int i5) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return getCustomInfoByUnitId(str, i5);
    }

    public String getCustomInfoByUnitId(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            Uri parse = Uri.parse(str2);
            if (parse != null) {
                String host = parse.getHost();
                String path = parse.getPath();
                if (!TextUtils.isEmpty(host)) {
                    if (host.contains(CampaignEx.JSON_KEY_HB) && !TextUtils.isEmpty(path) && path.contains("bid")) {
                        return getCustomInfoByUnitId(str, 6);
                    }
                }
                if (!TextUtils.isEmpty(host) && host.contains(CampaignEx.JSON_KEY_HB) && !TextUtils.isEmpty(path) && path.contains("load")) {
                    return getCustomInfoByUnitId(str, 7);
                }
                if (!TextUtils.isEmpty(path) && path.contains("v3")) {
                    return getCustomInfoByUnitId(str, 8);
                }
            }
        } catch (Throwable th) {
            af.b(TAG, "Exception", th);
        }
        return "";
    }

    public void setCustomInfo(String str, int i5, String str2) {
        if (!TextUtils.isEmpty(str) && str2 != null) {
            String b5 = z.b(str2);
            if (i5 == 6) {
                ConcurrentHashMap<String, String> concurrentHashMap = this.infoMap;
                concurrentHashMap.put(str + "_bid", b5);
            } else if (i5 == 7) {
                ConcurrentHashMap<String, String> concurrentHashMap2 = this.infoMap;
                concurrentHashMap2.put(str + "_bidload", b5);
            } else if (i5 == 8) {
                this.infoMap.put(str, b5);
            }
        }
    }

    public String getCustomInfoByUnitId(String str, int i5) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (i5 == 6) {
            ConcurrentHashMap<String, String> concurrentHashMap = this.infoMap;
            return concurrentHashMap.get(str + "_bid");
        } else if (i5 == 7) {
            ConcurrentHashMap<String, String> concurrentHashMap2 = this.infoMap;
            return concurrentHashMap2.get(str + "_bidload");
        } else if (i5 != 8) {
            return "";
        } else {
            return this.infoMap.get(str);
        }
    }
}
