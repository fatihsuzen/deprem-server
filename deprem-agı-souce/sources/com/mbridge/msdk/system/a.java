package com.mbridge.msdk.system;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.MBridgeSDK;
import com.mbridge.msdk.foundation.controller.authoritycontroller.AuthorityInfoBean;
import com.mbridge.msdk.foundation.controller.authoritycontroller.CallBackForDeveloper;
import com.mbridge.msdk.foundation.controller.authoritycontroller.b;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.controller.d;
import com.mbridge.msdk.foundation.same.report.e;
import com.mbridge.msdk.foundation.same.report.f;
import com.mbridge.msdk.foundation.same.report.i;
import com.mbridge.msdk.foundation.tools.MIMManager;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.v;
import com.mbridge.msdk.out.DeveloperTransferIdInfo;
import com.mbridge.msdk.out.OnCompletionListener;
import com.mbridge.msdk.out.SDKInitStatusListener;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class a implements MBridgeSDK {
    protected static final String LOG_TAG = "com.mbridge.msdk";
    public static Map<String, String> map;
    protected volatile MBridgeSDK.PLUGIN_LOAD_STATUS STATUS = MBridgeSDK.PLUGIN_LOAD_STATUS.INITIAL;
    private final Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() {
        public final void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
            if (a.this.isMIMinited) {
                MIMManager.a().e();
            }
        }

        public final void onActivityDestroyed(@NonNull Activity activity) {
            if (a.this.isMIMinited) {
                MIMManager.a().f();
            }
        }

        public final void onActivityPaused(@NonNull Activity activity) {
            int f5 = c.m().f();
            af.b("com.mbridge.msdk", "onActivityPaused currentActivityNum:" + f5);
        }

        public final void onActivityResumed(@NonNull Activity activity) {
        }

        public final void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        }

        public final void onActivityStarted(@NonNull Activity activity) {
            int f5 = c.m().f();
            af.b("com.mbridge.msdk", "onActivityStarted currentActivityNum:" + f5);
            af.b("com.mbridge.msdk", "onActivityStarted isCoolStart:" + a.this.isCoolStart);
            if (!a.this.isCoolStart && f5 == 0) {
                i.a("1");
            }
            if (a.this.mBridgeSDKImplDiff != null) {
                b unused = a.this.mBridgeSDKImplDiff;
                a aVar = a.this;
                boolean z4 = aVar.isCoolStart;
                Context context = aVar.mContext;
            }
            a.this.isCoolStart = false;
            c.m().a(f5 + 1);
        }

        public final void onActivityStopped(@NonNull Activity activity) {
            int f5 = c.m().f();
            af.b("com.mbridge.msdk", "onActivityStopped currentActivityNum:" + f5);
            if (f5 == 1 || f5 == 0) {
                i.a("2");
            }
            c.m().a(f5 - 1);
        }
    };
    protected boolean initCallbacked = false;
    public boolean isCoolStart = true;
    protected volatile boolean isMIMinited = false;
    protected boolean isRegisteredLifeCycle = false;
    /* access modifiers changed from: private */
    public b mBridgeSDKImplDiff;
    protected volatile Context mContext;
    protected SDKInitStatusListener mStatusListener;
    protected volatile AtomicBoolean sdkInited;

    private void initMIMManager() {
        try {
            String str = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(str) && str.equals("Xiaomi")) {
                this.isMIMinited = true;
                MIMManager.a().a(this.mContext.getApplicationContext());
            }
        } catch (Throwable th) {
            af.b("com.mbridge.msdk", th.getMessage());
        }
    }

    private void startTrackManager() {
        f.a().c();
    }

    private void unregisterActivityLifecycleListener(Application application) {
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks2;
        if (this.isRegisteredLifeCycle && (activityLifecycleCallbacks2 = this.activityLifecycleCallbacks) != null) {
            application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks2);
        }
    }

    public void checkAliveContext(Context context) {
        if (c.m().c() == null && context != null) {
            c.m().b(context);
        }
    }

    public boolean getConsentStatus(Context context) {
        checkAliveContext(context);
        return com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().e();
    }

    public Map<String, String> getMBConfigurationMap(String str, String str2) {
        return getMBConfigurationMap(str, str2, "");
    }

    public MBridgeSDK.PLUGIN_LOAD_STATUS getStatus() {
        return this.STATUS;
    }

    public void init(Map<String, String> map2, Application application) {
        this.mContext = application.getApplicationContext();
        map = map2;
        init();
    }

    public void initAsync(Map<String, String> map2, Application application) {
        this.mContext = application.getApplicationContext();
        map = map2;
        init();
    }

    public void preload(Map<String, Object> map2) {
        if (this.STATUS == MBridgeSDK.PLUGIN_LOAD_STATUS.COMPLETED) {
            d.a().a(map2, 0);
        }
    }

    public void preloadFrame(Map<String, Object> map2) {
        d.a().a(map2, 1);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000c, code lost:
        if (com.mbridge.msdk.foundation.tools.ah.a().a("c_r_a_l_c", 0) == 0) goto L_0x0019;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void registerActivityLifecycleListener(android.app.Application r5) {
        /*
            r4 = this;
            r0 = 1
            com.mbridge.msdk.foundation.tools.ah r1 = com.mbridge.msdk.foundation.tools.ah.a()     // Catch:{ Exception -> 0x000f }
            java.lang.String r2 = "c_r_a_l_c"
            r3 = 0
            int r1 = r1.a((java.lang.String) r2, (int) r3)     // Catch:{ Exception -> 0x000f }
            if (r1 != 0) goto L_0x001a
            goto L_0x0019
        L_0x000f:
            r1 = move-exception
            java.lang.String r2 = "com.mbridge.msdk"
            java.lang.String r1 = r1.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r2, r1)
        L_0x0019:
            r3 = r0
        L_0x001a:
            if (r5 == 0) goto L_0x0027
            if (r3 == 0) goto L_0x0027
            android.app.Application$ActivityLifecycleCallbacks r1 = r4.activityLifecycleCallbacks
            if (r1 == 0) goto L_0x0025
            r5.registerActivityLifecycleCallbacks(r1)
        L_0x0025:
            r4.isRegisteredLifeCycle = r0
        L_0x0027:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.system.a.registerActivityLifecycleListener(android.app.Application):void");
    }

    /* access modifiers changed from: protected */
    public void registerGlobalReceiver() {
        v.a().d();
    }

    public void release() {
        if (this.STATUS == MBridgeSDK.PLUGIN_LOAD_STATUS.COMPLETED) {
            d.a().c();
        }
        if (this.mContext instanceof Application) {
            unregisterActivityLifecycleListener((Application) this.mContext);
        }
        v.a().e();
    }

    public void setAllowAcquireIds(boolean z4) {
        b.a(z4);
    }

    public void setAllowTransferIdsIfLimit(boolean z4) {
        b.b(z4);
    }

    public void setConsentStatus(Context context, int i5) {
        checkAliveContext(context);
        com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().a(i5);
    }

    public void setCoppaStatus(Context context, boolean z4) {
        int i5;
        checkAliveContext(context);
        com.mbridge.msdk.foundation.controller.authoritycontroller.c.j();
        if (z4) {
            i5 = 1;
        } else {
            i5 = 2;
        }
        com.mbridge.msdk.foundation.a.a.a.a().b(MBridgeConstans.AUTHORITY_COPPA, i5);
    }

    public void setDeveloperIds(DeveloperTransferIdInfo developerTransferIdInfo) {
        if (!b.a() && developerTransferIdInfo != null && !TextUtils.isEmpty(developerTransferIdInfo.getGaid())) {
            com.mbridge.msdk.foundation.tools.f.a(developerTransferIdInfo.getGaid());
        }
    }

    @Deprecated
    public void setDoNotTrackStatus(boolean z4) {
        com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().b(z4 ? 1 : 0);
    }

    public void setPlayVideoMute(int i5, int i6) {
        if (i5 == 94) {
            com.mbridge.msdk.foundation.same.a.f9180W = i6;
        } else if (i5 == 287) {
            com.mbridge.msdk.foundation.same.a.f9181X = i6;
        }
    }

    public void setThirdPartyFeatures(Map<String, Object> map2) {
    }

    public void setUserPrivateInfoType(Context context, String str, int i5) {
        checkAliveContext(context);
        com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().a(str, i5);
    }

    @Deprecated
    public void showUserPrivateInfoTips(Context context, CallBackForDeveloper callBackForDeveloper) {
    }

    public void updateDialogWeakActivity(WeakReference<Activity> weakReference) {
        c.m().a(weakReference);
    }

    public AuthorityInfoBean userPrivateInfo(Context context) {
        checkAliveContext(context);
        return com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().d();
    }

    public Map<String, String> getMBConfigurationMap(String str, String str2, boolean z4) {
        return getMBConfigurationMap(str, str2, "");
    }

    public void setDoNotTrackStatus(Context context, boolean z4) {
        checkAliveContext(context);
        com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().b(z4 ? 1 : 0);
    }

    public Map<String, String> getMBConfigurationMap(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put(MBridgeConstans.ID_MBRIDGE_APPID, str);
        hashMap.put(MBridgeConstans.ID_MBRIDGE_APPKEY, str2);
        hashMap.put(MBridgeConstans.ID_MBRIDGE_WX_APPID, str3);
        hashMap.put(MBridgeConstans.ID_MBRIDGE_STARTUPCRASH, String.valueOf(1));
        return hashMap;
    }

    public void setConsentStatus(Context context) {
        checkAliveContext(context);
        com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().a(context, (OnCompletionListener) null);
    }

    public void init(Map<String, String> map2, Context context) {
        this.mContext = context.getApplicationContext();
        map = map2;
        init();
    }

    public void initAsync(Map<String, String> map2, Context context) {
        this.mContext = context.getApplicationContext();
        map = map2;
        init();
    }

    public void setConsentStatus(Context context, OnCompletionListener onCompletionListener) {
        checkAliveContext(context);
        com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().a(context, onCompletionListener);
    }

    public void init(Map<String, String> map2, Application application, SDKInitStatusListener sDKInitStatusListener) {
        this.mContext = application;
        this.mStatusListener = sDKInitStatusListener;
        map = map2;
        init();
    }

    public void initAsync(Map<String, String> map2, Application application, SDKInitStatusListener sDKInitStatusListener) {
        this.mContext = application;
        this.mStatusListener = sDKInitStatusListener;
        map = map2;
        init();
    }

    public Map<String, String> getMBConfigurationMap(String str, String str2, String str3, boolean z4) {
        return getMBConfigurationMap(str, str2, "");
    }

    public void init(Map<String, String> map2, Context context, SDKInitStatusListener sDKInitStatusListener) {
        this.mContext = context.getApplicationContext();
        this.mStatusListener = sDKInitStatusListener;
        map = map2;
        init();
    }

    public void initAsync(Map<String, String> map2, Context context, SDKInitStatusListener sDKInitStatusListener) {
        this.mContext = context.getApplicationContext();
        this.mStatusListener = sDKInitStatusListener;
        map = map2;
        init();
    }

    private void init() {
        String str;
        SDKInitStatusListener sDKInitStatusListener;
        SDKInitStatusListener sDKInitStatusListener2;
        if (this.sdkInited == null) {
            this.sdkInited = new AtomicBoolean(false);
        }
        this.initCallbacked = false;
        try {
            if (this.sdkInited.get() && (sDKInitStatusListener2 = this.mStatusListener) != null && !this.initCallbacked) {
                this.initCallbacked = true;
                sDKInitStatusListener2.onInitSuccess();
                return;
            }
        } catch (Exception e5) {
            af.b("com.mbridge.msdk", e5.getMessage());
        }
        if (this.mContext != null || (sDKInitStatusListener = this.mStatusListener) == null) {
            try {
                this.mBridgeSDKImplDiff = new b();
                d.a().a((Map) map, this.mContext);
                this.STATUS = MBridgeSDK.PLUGIN_LOAD_STATUS.COMPLETED;
                startTrackManager();
                ak.j();
                initMIMManager();
                if (this.mContext instanceof Application) {
                    registerActivityLifecycleListener((Application) this.mContext);
                    registerGlobalReceiver();
                }
                this.sdkInited.set(true);
            } catch (Exception e6) {
                af.b("com.mbridge.msdk", "INIT FAIL", e6);
                if (this.sdkInited != null) {
                    this.sdkInited.set(false);
                }
                SDKInitStatusListener sDKInitStatusListener3 = this.mStatusListener;
                if (sDKInitStatusListener3 != null && !this.initCallbacked) {
                    this.initCallbacked = true;
                    sDKInitStatusListener3.onInitFail(e6.getMessage());
                }
            }
            SDKInitStatusListener sDKInitStatusListener4 = this.mStatusListener;
            if (sDKInitStatusListener4 != null && !this.initCallbacked) {
                this.initCallbacked = true;
                sDKInitStatusListener4.onInitSuccess();
            }
            try {
                e.a().b();
                com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                if (this.sdkInited != null) {
                    String str2 = "2";
                    eVar.a(NotificationCompat.CATEGORY_STATUS, this.sdkInited.get() ? "1" : str2);
                    if (c.m().d().b()) {
                        str = "1";
                    } else {
                        str = str2;
                    }
                    eVar.a("is_allow_crash", str);
                    if (c.m().d().a()) {
                        str2 = "1";
                    }
                    eVar.a("is_allow_anr", str2);
                }
                com.mbridge.msdk.foundation.same.report.d.c cVar = new com.mbridge.msdk.foundation.same.report.d.c();
                cVar.a("m_init_sdk", eVar);
                com.mbridge.msdk.foundation.same.report.d.d.a().a("m_init_sdk", cVar);
            } catch (Throwable th) {
                af.b("com.mbridge.msdk", th.getMessage());
            }
        } else {
            sDKInitStatusListener.onInitFail("Context can not be null.");
            this.initCallbacked = true;
        }
    }

    public void init(Application application) {
        this.mContext = application.getApplicationContext();
        init();
    }
}
