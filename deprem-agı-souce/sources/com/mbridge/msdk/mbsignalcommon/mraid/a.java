package com.mbridge.msdk.mbsignalcommon.mraid;

import android.webkit.WebView;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public final class a {

    /* renamed from: com.mbridge.msdk.mbsignalcommon.mraid.a$a  reason: collision with other inner class name */
    private static class C0096a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final a f10169a = new a();
    }

    public static a a() {
        return C0096a.f10169a;
    }

    public final void b(WebView webView, float f5, float f6) {
        c(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.setScreenSize(%.1f, %.1f);", new Object[]{Float.valueOf(f5), Float.valueOf(f6)}));
    }

    public final void c(WebView webView, float f5, float f6) {
        c(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.setMaxSize(%.1f, %.1f);", new Object[]{Float.valueOf(f5), Float.valueOf(f6)}));
    }

    public final void a(WebView webView) {
        c(webView, "javascript:window.mraidbridge.fireReadyEvent();");
    }

    private void c(WebView webView, String str) {
        if (webView != null) {
            try {
                webView.loadUrl(str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void b(WebView webView, float f5, float f6, float f7, float f8) {
        c(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.setCurrentPosition(%.1f, %.1f, %.1f, %.1f);", new Object[]{Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7), Float.valueOf(f8)}));
    }

    public final void a(WebView webView, Map<String, Object> map) {
        if (map != null && map.size() != 0) {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry next : map.entrySet()) {
                try {
                    jSONObject.put((String) next.getKey(), next.getValue());
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            String jSONObject2 = jSONObject.toString();
            try {
                jSONObject2 = URLEncoder.encode(jSONObject2, C.UTF8_NAME);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            c(webView, String.format("javascript:window.mraidbridge.fireChangeEvent(%s);", new Object[]{jSONObject2}));
        }
    }

    public final void b(WebView webView, String str) {
        try {
            str = URLEncoder.encode(str, C.UTF8_NAME);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        c(webView, String.format("javascript:window.mraidbridge.setIsViewable(%s);", new Object[]{str}));
    }

    public final void a(WebView webView, String str, String str2) {
        try {
            str2 = URLEncoder.encode(str2, C.UTF8_NAME);
            str = URLEncoder.encode(str, C.UTF8_NAME);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        c(webView, String.format("javascript:window.mraidbridge.fireErrorEvent('%1s', '%2s');", new Object[]{str2, str}));
    }

    public final void a(WebView webView, float f5, float f6) {
        c(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.notifySizeChangeEvent(%.1f, %.1f);", new Object[]{Float.valueOf(f5), Float.valueOf(f6)}));
    }

    public final void a(WebView webView, double d5) {
        c(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.audioVolumeChange(%s);", new Object[]{Double.valueOf(d5)}));
    }

    public final void a(WebView webView, float f5, float f6, float f7, float f8) {
        c(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.setDefaultPosition(%.1f, %.1f, %.1f, %.1f);", new Object[]{Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7), Float.valueOf(f8)}));
    }

    public final void a(WebView webView, String str) {
        try {
            str = URLEncoder.encode(str, C.UTF8_NAME);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        c(webView, String.format("javascript:window.mraidbridge.nativeCallComplete('%s');", new Object[]{str}));
    }
}
