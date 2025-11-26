package com.mbridge.msdk.mbsignalcommon.webEnvCheck;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.controller.c;

public final class a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static volatile Boolean f10180a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile Handler f10181b;

    /* renamed from: c  reason: collision with root package name */
    private static Boolean f10182c;

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
        if (com.mbridge.msdk.MBridgeConstans.DEBUG != false) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        com.mbridge.msdk.foundation.tools.af.b("MBWebViewChecker", "destroy webview error", r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(android.content.Context r2) {
        /*
            android.webkit.WebView r0 = new android.webkit.WebView     // Catch:{ Exception -> 0x000e }
            r0.<init>(r2)     // Catch:{ Exception -> 0x000e }
            com.mbridge.msdk.mbsignalcommon.base.b r2 = new com.mbridge.msdk.mbsignalcommon.base.b     // Catch:{ Exception -> 0x000e }
            r2.<init>()     // Catch:{ Exception -> 0x000e }
            r0.setWebViewClient(r2)     // Catch:{ Exception -> 0x000e }
            goto L_0x000f
        L_0x000e:
            r0 = 0
        L_0x000f:
            if (r0 == 0) goto L_0x0025
            r0.destroy()     // Catch:{ Exception -> 0x0017, all -> 0x0015 }
            goto L_0x0023
        L_0x0015:
            r2 = move-exception
            throw r2
        L_0x0017:
            r2 = move-exception
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r0 == 0) goto L_0x0023
            java.lang.String r0 = "MBWebViewChecker"
            java.lang.String r1 = "destroy webview error"
            com.mbridge.msdk.foundation.tools.af.b(r0, r1, r2)
        L_0x0023:
            r2 = 1
            return r2
        L_0x0025:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbsignalcommon.webEnvCheck.a.b(android.content.Context):boolean");
    }

    public static boolean a(final Context context) {
        g gVar;
        try {
            gVar = h.a().a(c.m().k());
        } catch (Exception unused) {
            gVar = null;
        }
        if (gVar != null) {
            f10182c = Boolean.valueOf(gVar.aF());
        } else {
            f10182c = Boolean.FALSE;
        }
        Boolean bool = f10182c;
        if (bool == null || !bool.booleanValue()) {
            return true;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            if (f10180a == null) {
                try {
                    f10180a = Boolean.valueOf(b(context));
                } catch (Exception unused2) {
                    f10180a = Boolean.FALSE;
                }
            }
            if (f10180a == null) {
                f10180a = new Boolean(false);
            }
            return f10180a.booleanValue();
        }
        if (f10180a == null && f10181b == null) {
            f10181b = new Handler(Looper.getMainLooper());
            f10181b.post(new Runnable() {
                public final void run() {
                    if (a.f10180a == null) {
                        try {
                            Boolean unused = a.f10180a = Boolean.valueOf(a.b(context));
                        } catch (Exception unused2) {
                            Boolean unused3 = a.f10180a = Boolean.FALSE;
                        }
                    }
                }
            });
        }
        if (f10180a == null) {
            return true;
        }
        return f10180a.booleanValue();
    }
}
