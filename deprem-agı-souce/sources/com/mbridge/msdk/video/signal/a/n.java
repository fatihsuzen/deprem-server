package com.mbridge.msdk.video.signal.a;

import android.util.Base64;
import android.webkit.WebView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import org.json.JSONObject;

public final class n extends f {

    /* renamed from: a  reason: collision with root package name */
    private WebView f12674a;

    public n(WebView webView) {
        this.f12674a = webView;
    }

    public final void a(int i5) {
        super.a(i5);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(NotificationCompat.CATEGORY_STATUS, i5);
            g.a().a(this.f12674a, "onVideoStatusNotify", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void a(int i5, String str) {
        super.a(i5, str);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, i5);
            jSONObject.put("pt", str);
            g.a().a(this.f12674a, "onJSClick", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void a(MBridgeVideoView.b bVar) {
        super.a(bVar);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("progress", a(bVar.f12549a, bVar.f12550b));
            jSONObject.put("time", String.valueOf(bVar.f12549a));
            jSONObject.put(TypedValues.TransitionType.S_DURATION, String.valueOf(bVar.f12550b));
            g.a().a(this.f12674a, "onVideoProgressNotify", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    private String a(int i5, int i6) {
        if (i6 != 0) {
            double d5 = (double) (((float) i5) / ((float) i6));
            try {
                return ak.a(Double.valueOf(d5)) + "";
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return i6 + "";
    }

    public final void a(Object obj) {
        String str;
        super.a(obj);
        if (obj == null || !(obj instanceof String)) {
            str = "";
        } else {
            str = Base64.encodeToString(obj.toString().getBytes(), 2);
        }
        g.a().a(this.f12674a, "webviewshow", str);
    }

    public final void a(int i5, int i6, int i7, int i8) {
        super.a(i5, i6, i7, i8);
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            String str = "landscape";
            if (i5 != 2 ? i6 != 2 : i6 == 1) {
                str = "portrait";
            }
            jSONObject2.put("orientation", str);
            jSONObject2.put("screen_width", i7);
            jSONObject2.put("screen_height", i8);
            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
            g.a().a(this.f12674a, "showDataInfo", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }
}
