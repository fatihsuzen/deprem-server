package com.mbridge.msdk.mbsignalcommon.b;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbsignalcommon.windvane.b;

public class a implements b {
    public void a(Object obj) {
        af.a("RVWindVaneWebView", "getEndScreenInfo");
    }

    public final boolean b(WebView webView, String str) {
        af.a("RVWindVaneWebView", "shouldOverrideUrlLoading");
        return true;
    }

    public final void c(WebView webView, int i5) {
        af.a("RVWindVaneWebView", "loadingResourceStatus");
    }

    public void a(WebView webView, String str, String str2, int i5, int i6) {
        af.a("RVWindVaneWebView", "loadAds");
    }

    public final void b(WebView webView, int i5) {
        af.a("RVWindVaneWebView", "onProgressChanged");
    }

    public void a(Object obj, String str) {
        af.a("RVWindVaneWebView", "operateComponent");
    }

    public final void a(WebView webView, String str, Bitmap bitmap) {
        af.a("RVWindVaneWebView", "onPageStarted");
    }

    public void a(WebView webView, int i5, String str, String str2) {
        af.a("RVWindVaneWebView", "onReceivedError");
    }

    public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        af.a("RVWindVaneWebView", "onReceivedSslError");
    }

    public void a(WebView webView, String str) {
        af.a("RVWindVaneWebView", "onPageFinished");
    }

    public void a(WebView webView, int i5) {
        af.a("RVWindVaneWebView", "readyState");
    }

    public void a(WebView webView) {
        af.a("RVWindVaneWebView", "onRenderProcessGone");
    }
}
