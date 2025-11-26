package com.mbridge.msdk.mbsignalcommon.base;

import android.net.http.SslError;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.d;
import java.io.File;

public class b extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    private a f10091a;

    /* renamed from: b  reason: collision with root package name */
    private d f10092b;

    /* access modifiers changed from: protected */
    public final boolean a(String str, String str2) {
        try {
            return new File(str).getCanonicalFile().getPath().startsWith(new File(str2).getCanonicalFile().getPath());
        } catch (Exception unused) {
            return false;
        }
    }

    public final a b() {
        return this.f10091a;
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        d dVar = this.f10092b;
        if (dVar != null) {
            dVar.a(webView, str);
        }
    }

    public void onReceivedError(WebView webView, int i5, String str, String str2) {
        super.onReceivedError(webView, i5, str, str2);
        d dVar = this.f10092b;
        if (dVar != null) {
            dVar.a(webView, i5, str, str2);
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        d dVar = this.f10092b;
        if (dVar != null) {
            dVar.a(webView, sslErrorHandler, sslError);
        }
    }

    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        af.b("BaseWebViewClient", "WebView called onRenderProcessGone");
        if (webView != null) {
            try {
                ViewGroup viewGroup = (ViewGroup) webView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(webView);
                }
                if (webView instanceof WindVaneWebView) {
                    ((WindVaneWebView) webView).release();
                } else {
                    webView.destroy();
                }
            } catch (Throwable th) {
                af.b("BaseWebViewClient", th.getMessage());
                return true;
            }
        }
        d dVar = this.f10092b;
        if (dVar != null) {
            dVar.a(webView);
        }
        return true;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        a aVar = this.f10091a;
        if (aVar != null && aVar.a(str)) {
            return true;
        }
        d dVar = this.f10092b;
        if (dVar != null) {
            dVar.b(webView, str);
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    public final void a(a aVar) {
        this.f10091a = aVar;
    }

    public final void a(d dVar) {
        this.f10092b = dVar;
    }
}
