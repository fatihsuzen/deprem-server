package com.mbridge.msdk.newreward.player.view.hybrid.listener;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;

public interface WebViewEventListener {
    void loadingResourceStatus(WebView webView, int i5);

    void onPageFinished(WebView webView, String str);

    void onPageStarted(WebView webView, String str, Bitmap bitmap);

    void onProgressChanged(WebView webView, int i5);

    void onReceivedError(WebView webView, int i5, String str, String str2);

    void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError);

    void onRenderProcessGone(WebView webView);

    boolean shouldOverrideUrlLoading(WebView webView, String str);
}
