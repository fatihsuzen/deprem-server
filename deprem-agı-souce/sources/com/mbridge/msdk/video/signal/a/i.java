package com.mbridge.msdk.video.signal.a;

import android.content.res.Configuration;
import android.util.Base64;
import android.webkit.WebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import org.json.JSONObject;

public final class i extends b {

    /* renamed from: a  reason: collision with root package name */
    private WebView f12651a;

    /* renamed from: b  reason: collision with root package name */
    private int f12652b = 0;

    public i(WebView webView) {
        this.f12651a = webView;
    }

    public final void a() {
        super.a();
        this.f12652b = 1;
        g.a().a(this.f12651a, "onSystemPause", "");
    }

    public final void b() {
        super.b();
        this.f12652b = 0;
        g.a().a(this.f12651a, "onSystemResume", "");
    }

    public final void c() {
        super.c();
        g.a().a(this.f12651a, "onSystemDestory", "");
    }

    public final void g() {
        super.g();
        g.a().a(this.f12651a, "onSystemBackPressed", "");
    }

    public final int h() {
        return this.f12652b;
    }

    public final void a(Configuration configuration) {
        super.a(configuration);
        try {
            JSONObject jSONObject = new JSONObject();
            if (configuration.orientation == 2) {
                jSONObject.put("orientation", "landscape");
            } else {
                jSONObject.put("orientation", "portrait");
            }
            g.a().a(this.f12651a, "orientation", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void a(int i5) {
        super.a(i5);
        this.f12652b = i5;
    }
}
