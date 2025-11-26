package com.mbridge.msdk.mbsignalcommon.windvane;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.RequiresApi;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.c.a;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbsignalcommon.base.b;

public final class l extends b {

    /* renamed from: b  reason: collision with root package name */
    public static boolean f10245b = true;

    /* renamed from: a  reason: collision with root package name */
    protected String f10246a = null;

    /* renamed from: c  reason: collision with root package name */
    private int f10247c = 0;

    /* renamed from: d  reason: collision with root package name */
    private d f10248d;

    @RequiresApi(api = 11)
    private WebResourceResponse a(String str) {
        try {
            if (TextUtils.isEmpty(str) || !j.d(str)) {
                return null;
            }
            af.c("WindVaneWebViewClient", "is image " + str);
            Bitmap a5 = com.mbridge.msdk.foundation.same.c.b.a(c.m().c()).a(str);
            af.c("WindVaneWebViewClient", "find image from cache " + str);
            if (a5 == null || a5.isRecycled()) {
                return null;
            }
            return new WebResourceResponse(j.e(str), "utf-8", a.a(a5));
        } catch (Throwable unused) {
            return null;
        }
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.f10246a = str;
        d dVar = this.f10248d;
        if (dVar != null) {
            dVar.a(webView, str, bitmap);
        }
    }

    @TargetApi(11)
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        WebResourceResponse a5 = a(str);
        if (a5 == null) {
            return super.shouldInterceptRequest(webView, str);
        }
        af.c("WindVaneWebViewClient", "find WebResourceResponse url is " + str);
        return a5;
    }
}
