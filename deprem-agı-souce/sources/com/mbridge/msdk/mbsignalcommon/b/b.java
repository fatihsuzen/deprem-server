package com.mbridge.msdk.mbsignalcommon.b;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbsignalcommon.windvane.d;

public class b implements d {
    public void a(WebView webView, String str, Bitmap bitmap) {
        af.a("WindVaneWebView", "onPageStarted");
    }

    public boolean b(WebView webView, String str) {
        af.a("WindVaneWebView", "shouldOverrideUrlLoading");
        return true;
    }

    public void c(WebView webView, int i5) {
        af.a("WindVaneWebView", "loadingResourceStatus");
    }

    public void a(WebView webView, int i5, String str, String str2) {
        af.a("WindVaneWebView", "onReceivedError");
    }

    public void b(WebView webView, int i5) {
        af.a("WindVaneWebView", "onProgressChanged");
    }

    public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        af.a("WindVaneWebView", "onReceivedSslError");
    }

    public void a(WebView webView, String str) {
        af.a("WindVaneWebView", "onPageFinished");
    }

    public void a(WebView webView, int i5) {
        af.a("WindVaneWebView", "readyState");
    }

    public void a(WebView webView) {
        af.a("WindVaneWebView", "onRenderProcessGone");
    }
}
