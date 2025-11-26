package com.mbridge.msdk.newreward.player.view.hybrid.util;

import android.text.TextUtils;
import android.util.Base64;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.newreward.player.view.hybrid.MBWebView;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.Iterator;
import org.json.JSONObject;

public class MBCommunicatorUtil {
    public static final String TAG = "MBCommunicatorUtil";

    public static void callException(WebView webView, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", 1);
            jSONObject.put("message", str2);
            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, new JSONObject());
            callSuccess(webView, str, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
        }
    }

    public static void callFailure(WebView webView, String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str2)) {
            str3 = String.format("javascript:window.WindVane.onFailure(%s,'');", new Object[]{str});
        } else {
            str3 = String.format("javascript:window.WindVane.onFailure(%s,'%s');", new Object[]{str, MBHybridUtil.convert2Unicode(str2)});
        }
        if (webView != null) {
            evaluateJavascript(webView, str3);
        }
    }

    public static void callSuccess(WebView webView, String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str2)) {
            str3 = String.format("javascript:window.WindVane.onSuccess(%s,'');", new Object[]{str});
        } else {
            str3 = String.format("javascript:window.WindVane.onSuccess(%s,'%s');", new Object[]{str, MBHybridUtil.convert2Unicode(str2)});
        }
        if (webView != null) {
            evaluateJavascript(webView, str3);
        }
    }

    public static void evaluateJavascript(WebView webView, String str) {
        if (webView != null) {
            try {
                if (!(webView instanceof MBWebView) || !((MBWebView) webView).isDestroyed()) {
                    webView.evaluateJavascript(str, new ValueCallback<String>() {
                        public final void onReceiveValue(String str) {
                        }
                    });
                }
            } catch (Throwable th) {
                af.b(TAG, th.getMessage());
            }
        }
    }

    public static void fireEvent(WebView webView, String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str2)) {
            str3 = String.format("javascript:window.WindVane.fireEvent('%s', '');", new Object[]{str});
        } else {
            str3 = String.format("javascript:window.WindVane.fireEvent('%s','%s');", new Object[]{str, MBHybridUtil.convert2Unicode(str2)});
        }
        if (webView != null) {
            evaluateJavascript(webView, str3);
        }
    }

    public static void notifyClick(WebView webView, int i5, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, i5);
            jSONObject.put("pt", str);
            fireEvent(webView, "onJSClick", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
        }
    }

    public static void notifyNotchData(WebView webView, String str) {
        try {
            if (!TextUtils.isEmpty(str) && webView != null) {
                fireEvent(webView, "oncutoutfetched", Base64.encodeToString(str.getBytes(), 2));
            }
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
        }
    }

    public static void notifyShowDataInfo(WebView webView, int i5, int i6) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            String str = "landscape";
            if (i5 == 2) {
                if (i6 == 1) {
                    str = "portrait";
                }
                jSONObject2.put("orientation", str);
            } else {
                if (i6 != 2) {
                    str = "portrait";
                }
                jSONObject2.put("orientation", str);
            }
            jSONObject2.put("screen_width", (double) ak.j(webView.getContext()));
            jSONObject2.put("screen_height", (double) ak.i(webView.getContext()));
            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
            fireEvent(webView, "showDataInfo", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
        }
    }

    public static void notifyVideoProgress(WebView webView, int i5, int i6) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("progress", (int) (((float) i5) / ((float) i6)));
            jSONObject.put("time", String.valueOf(i5));
            jSONObject.put(TypedValues.TransitionType.S_DURATION, String.valueOf(i6));
            fireEvent(webView, "onVideoProgressNotify", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
        }
    }

    public static void notifyVideoStatus(WebView webView, int i5) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(NotificationCompat.CATEGORY_STATUS, i5);
            fireEvent(webView, "onVideoStatusNotify", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
        }
    }

    public static void notifyWebViewShowed(WebView webView, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("orientation", str);
            fireEvent(webView, "orientation", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
        try {
            int[] iArr = new int[2];
            webView.getLocationOnScreen(iArr);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("startX", ak.b(webView.getContext(), (float) iArr[0]));
            jSONObject2.put("startY", ak.b(webView.getContext(), (float) iArr[1]));
            jSONObject2.put(a.f9193l, (double) ak.d(webView.getContext()));
            if (TextUtils.isEmpty(str2)) {
                JSONObject jSONObject3 = new JSONObject(str2);
                if (jSONObject3.length() > 0) {
                    Iterator<String> keys = jSONObject3.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject2.put(next, jSONObject3.get(next));
                    }
                }
            }
            fireEvent(webView, "webviewshow", Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
        }
        MRAIDCommunicatorUtil.notifyMRAIDEnvironmentChange(webView, str);
    }
}
