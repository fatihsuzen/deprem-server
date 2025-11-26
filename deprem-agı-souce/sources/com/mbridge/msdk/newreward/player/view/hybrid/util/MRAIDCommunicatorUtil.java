package com.mbridge.msdk.newreward.player.view.hybrid.util;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public class MRAIDCommunicatorUtil {
    public static final String KEY_CURRENTORIENTATION = "currentAppOrientation";
    public static final String KEY_PLACEMENTTYPE = "placementType";
    public static final String KEY_STATE = "state";
    public static final String KEY_VIEWABLE = "viewable";
    public static final String PLACEMENT_INLINE = "inline";
    public static final String PLACEMENT_INTERSTITIAL = "Interstitial";
    public static final String STATES_DEFAULT = "default";
    public static final String STATES_EXPANDED = "expanded";
    public static final String STATES_HIDDEN = "hidden";
    public static final String STATES_LOADING = "loading";
    public static final String STATES_RESIZED = "resized";
    private static final String TAG = "MRAIDCommunicatorUtil";

    private static void call(WebView webView, String str) {
        if (webView != null) {
            try {
                webView.evaluateJavascript(str, new ValueCallback<String>() {
                    public final void onReceiveValue(String str) {
                    }
                });
            } catch (Throwable th) {
                af.b(TAG, th.getMessage());
            }
        }
    }

    public static void fireAudioVolumeChange(WebView webView, double d5) {
        call(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.audioVolumeChange(%s);", new Object[]{Double.valueOf(d5)}));
    }

    public static void fireChangeEventForProperties(WebView webView, Map<String, Object> map) {
        if (map != null && map.size() != 0) {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry next : map.entrySet()) {
                try {
                    jSONObject.put((String) next.getKey(), next.getValue());
                } catch (Exception e5) {
                    af.b(TAG, e5.getMessage());
                }
            }
            call(webView, String.format("javascript:window.mraidbridge.fireChangeEvent(%s);", new Object[]{jSONObject.toString()}));
        }
    }

    public static void fireErrorEvent(WebView webView, String str, String str2) {
        call(webView, String.format("javascript:window.mraidbridge.fireErrorEvent('%1s', '%2s');", new Object[]{str2, str}));
    }

    public static void fireNativeMethodCompleteEvent(WebView webView, String str) {
        call(webView, String.format("javascript:window.mraidbridge.nativeCallComplete('%s');", new Object[]{str}));
    }

    public static void fireReadyEvent(WebView webView) {
        call(webView, "javascript:window.mraidbridge.fireReadyEvent();");
    }

    public static void fireSetCurrentPosition(WebView webView, float f5, float f6, float f7, float f8) {
        call(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.setCurrentPosition(%.1f, %.1f, %.1f, %.1f);", new Object[]{Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7), Float.valueOf(f8)}));
    }

    public static void fireSetDefaultPosition(WebView webView, float f5, float f6, float f7, float f8) {
        call(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.setDefaultPosition(%.1f, %.1f, %.1f, %.1f);", new Object[]{Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7), Float.valueOf(f8)}));
    }

    public static void fireSetIsViewable(WebView webView, String str) {
        call(webView, String.format("javascript:window.mraidbridge.setIsViewable(%s);", new Object[]{str}));
    }

    public static void fireSetMaxSize(WebView webView, float f5, float f6) {
        call(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.setMaxSize(%.1f, %.1f);", new Object[]{Float.valueOf(f5), Float.valueOf(f6)}));
    }

    public static void fireSetPlacementType(WebView webView, String str) {
        call(webView, String.format("javascript:window.mraidbridge.setPlacementType(%s);", new Object[]{str}));
    }

    public static void fireSetScreenSize(WebView webView, float f5, float f6) {
        call(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.setScreenSize(%.1f, %.1f);", new Object[]{Float.valueOf(f5), Float.valueOf(f6)}));
    }

    public static void fireSizeChangeEvent(WebView webView, float f5, float f6) {
        call(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.notifySizeChangeEvent(%.1f, %.1f);", new Object[]{Float.valueOf(f5), Float.valueOf(f6)}));
    }

    public static void notifyMRAIDEnvironmentChange(WebView webView, String str) {
        if (webView != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("orientation", str);
                jSONObject.put("locked", "true");
                HashMap hashMap = new HashMap();
                hashMap.put(KEY_PLACEMENTTYPE, PLACEMENT_INTERSTITIAL);
                hashMap.put(KEY_STATE, STATES_DEFAULT);
                hashMap.put(KEY_VIEWABLE, "true");
                hashMap.put(KEY_CURRENTORIENTATION, jSONObject);
                Context context = webView.getContext();
                if (context instanceof Activity) {
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                    fireSetScreenSize(webView, (float) ab.j(context), (float) ab.h(context));
                    fireSetMaxSize(webView, (float) displayMetrics.widthPixels, (float) displayMetrics.heightPixels);
                }
                fireSetDefaultPosition(webView, (float) webView.getLeft(), (float) webView.getTop(), (float) webView.getWidth(), (float) webView.getHeight());
                fireSetCurrentPosition(webView, (float) webView.getLeft(), (float) webView.getTop(), (float) webView.getWidth(), (float) webView.getHeight());
                fireChangeEventForProperties(webView, hashMap);
                fireAudioVolumeChange(webView, MBHybridUtil.getCurrentVolume(context));
                fireReadyEvent(webView);
            } catch (Throwable th) {
                af.b(TAG, th.getMessage());
            }
        }
    }
}
