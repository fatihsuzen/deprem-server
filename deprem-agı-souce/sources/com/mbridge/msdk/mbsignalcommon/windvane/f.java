package com.mbridge.msdk.mbsignalcommon.windvane;

import android.content.Context;
import java.util.HashMap;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<String, Class> f10223a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private Context f10224b;

    /* renamed from: c  reason: collision with root package name */
    private Object f10225c;

    /* renamed from: d  reason: collision with root package name */
    private WindVaneWebView f10226d;

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x004a */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0050 A[Catch:{ Exception -> 0x005d }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public f(android.content.Context r1, com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r2) {
        /*
            r0 = this;
            r0.<init>()
            r0.f10224b = r1
            r0.f10226d = r2
            java.lang.String r1 = "com.mbridge.msdk.interstitial.signalcommon.interstitial"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x0012 }
            java.lang.String r2 = com.mbridge.msdk.mbsignalcommon.base.e.f10094a     // Catch:{ ClassNotFoundException -> 0x0012 }
            r0.a(r2, r1)     // Catch:{ ClassNotFoundException -> 0x0012 }
        L_0x0012:
            java.lang.Class<com.mbridge.msdk.video.signal.communication.RewardSignal> r1 = com.mbridge.msdk.video.signal.communication.RewardSignal.class
            int r2 = com.mbridge.msdk.video.signal.communication.RewardSignal.f12682g     // Catch:{ ClassNotFoundException -> 0x001b }
            java.lang.String r2 = com.mbridge.msdk.mbsignalcommon.base.e.f10095b     // Catch:{ ClassNotFoundException -> 0x001b }
            r0.a(r2, r1)     // Catch:{ ClassNotFoundException -> 0x001b }
        L_0x001b:
            java.lang.Class<com.mbridge.msdk.video.signal.communication.VideoCommunication> r1 = com.mbridge.msdk.video.signal.communication.VideoCommunication.class
            int r2 = com.mbridge.msdk.video.signal.communication.VideoCommunication.f12708g     // Catch:{ ClassNotFoundException -> 0x0024 }
            java.lang.String r2 = com.mbridge.msdk.mbsignalcommon.base.e.f10096c     // Catch:{ ClassNotFoundException -> 0x0024 }
            r0.a(r2, r1)     // Catch:{ ClassNotFoundException -> 0x0024 }
        L_0x0024:
            java.lang.Class<com.mbridge.msdk.mbsignalcommon.mraid.MraidSignalCommunication> r1 = com.mbridge.msdk.mbsignalcommon.mraid.MraidSignalCommunication.class
            int r2 = com.mbridge.msdk.mbsignalcommon.mraid.MraidSignalCommunication.f10167g     // Catch:{ ClassNotFoundException -> 0x002d }
            java.lang.String r2 = com.mbridge.msdk.mbsignalcommon.base.e.f10098e     // Catch:{ ClassNotFoundException -> 0x002d }
            r0.a(r2, r1)     // Catch:{ ClassNotFoundException -> 0x002d }
        L_0x002d:
            java.lang.Class<com.mbridge.msdk.mbsignalcommon.communication.BannerSignalPlugin> r1 = com.mbridge.msdk.mbsignalcommon.communication.BannerSignalPlugin.class
            int r2 = com.mbridge.msdk.mbsignalcommon.communication.BannerSignalPlugin.f10159g     // Catch:{ ClassNotFoundException -> 0x0036 }
            java.lang.String r2 = com.mbridge.msdk.mbsignalcommon.base.e.f10099f     // Catch:{ ClassNotFoundException -> 0x0036 }
            r0.a(r2, r1)     // Catch:{ ClassNotFoundException -> 0x0036 }
        L_0x0036:
            java.lang.String r1 = "com.mbridge.msdk.splash.signal.SplashSignal"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x0041 }
            java.lang.String r2 = com.mbridge.msdk.mbsignalcommon.base.e.f10100g     // Catch:{ ClassNotFoundException -> 0x0041 }
            r0.a(r2, r1)     // Catch:{ ClassNotFoundException -> 0x0041 }
        L_0x0041:
            java.lang.Class<com.mbridge.msdk.mbsignalcommon.webEnvCheck.WebGLCheckSignal> r1 = com.mbridge.msdk.mbsignalcommon.webEnvCheck.WebGLCheckSignal.class
            int r2 = com.mbridge.msdk.mbsignalcommon.webEnvCheck.WebGLCheckSignal.f10179g     // Catch:{ ClassNotFoundException -> 0x004a }
            java.lang.String r2 = com.mbridge.msdk.mbsignalcommon.base.e.f10101h     // Catch:{ ClassNotFoundException -> 0x004a }
            r0.a(r2, r1)     // Catch:{ ClassNotFoundException -> 0x004a }
        L_0x004a:
            boolean r1 = com.mbridge.msdk.e.b.a()     // Catch:{ Exception -> 0x005d }
            if (r1 == 0) goto L_0x005d
            java.lang.String r1 = "com.mbridge.msdk.mbsignalcommon.confirmation.bridge.ConfirmationJsBridgePlugin"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ Exception -> 0x005d }
            java.lang.String r2 = r1.getSimpleName()     // Catch:{ Exception -> 0x005d }
            r0.a(r2, r1)     // Catch:{ Exception -> 0x005d }
        L_0x005d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbsignalcommon.windvane.f.<init>(android.content.Context, com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView):void");
    }

    public final void a(Context context) {
        this.f10224b = context;
    }

    public final void a(Object obj) {
        this.f10225c = obj;
    }

    private Object a(String str, WindVaneWebView windVaneWebView, Context context) {
        Class cls = f10223a.get(str);
        if (cls == null) {
            return null;
        }
        try {
            if (!h.class.isAssignableFrom(cls)) {
                return null;
            }
            h hVar = (h) cls.newInstance();
            hVar.initialize(context, windVaneWebView);
            hVar.initialize(this.f10225c, windVaneWebView);
            return hVar;
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public final void a(String str, Class cls) {
        if (f10223a == null) {
            f10223a = new HashMap<>();
        }
        f10223a.put(str, cls);
    }

    public final Object a(String str) {
        if (f10223a == null) {
            f10223a = new HashMap<>();
        }
        return a(str, this.f10226d, this.f10224b);
    }
}
