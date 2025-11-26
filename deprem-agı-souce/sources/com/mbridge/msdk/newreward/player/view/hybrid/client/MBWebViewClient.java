package com.mbridge.msdk.newreward.player.view.hybrid.client;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.c.a;
import com.mbridge.msdk.foundation.same.c.b;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.player.view.hybrid.MBWebView;
import com.mbridge.msdk.newreward.player.view.hybrid.listener.WebViewEventListener;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MBHybridUtil;

public class MBWebViewClient extends WebViewClient {
    private final String TAG = "MBWebViewClient";
    private WebViewEventListener mEventListener;

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        WebViewEventListener webViewEventListener = this.mEventListener;
        if (webViewEventListener != null) {
            webViewEventListener.onPageFinished(webView, str);
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        WebViewEventListener webViewEventListener = this.mEventListener;
        if (webViewEventListener != null) {
            webViewEventListener.onPageStarted(webView, str, bitmap);
        }
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        WebViewEventListener webViewEventListener = this.mEventListener;
        if (webViewEventListener != null) {
            webViewEventListener.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        af.b("MBWebViewClient", "WebView called onRenderProcessGone");
        if (webView != null) {
            try {
                ViewGroup viewGroup = (ViewGroup) webView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(webView);
                }
                if (webView instanceof MBWebView) {
                    MBWebView mBWebView = (MBWebView) webView;
                    if (!mBWebView.isDestroyed()) {
                        mBWebView.destroy();
                    }
                } else {
                    webView.destroy();
                }
            } catch (Throwable th) {
                af.b("MBWebViewClient", th.getMessage());
                return true;
            }
        }
        WebViewEventListener webViewEventListener = this.mEventListener;
        if (webViewEventListener != null) {
            webViewEventListener.onRenderProcessGone(webView);
        }
        return true;
    }

    public void setWebViewEventListener(WebViewEventListener webViewEventListener) {
        this.mEventListener = webViewEventListener;
    }

    @Nullable
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        Bitmap a5;
        try {
            if (!TextUtils.isEmpty(str)) {
                String imageMimeType = MBHybridUtil.getImageMimeType(str);
                if (!TextUtils.isEmpty(imageMimeType) && (a5 = b.a(c.m().c()).a(str)) != null && !a5.isRecycled()) {
                    return new WebResourceResponse(imageMimeType, "utf-8", a.a(a5));
                }
            }
        } catch (Throwable th) {
            af.b("MBWebViewClient", th.getMessage());
        }
        return super.shouldInterceptRequest(webView, str);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        WebViewEventListener webViewEventListener = this.mEventListener;
        if (webViewEventListener != null) {
            return webViewEventListener.shouldOverrideUrlLoading(webView, str);
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    public void onReceivedError(WebView webView, int i5, String str, String str2) {
        super.onReceivedError(webView, i5, str, str2);
        WebViewEventListener webViewEventListener = this.mEventListener;
        if (webViewEventListener != null) {
            webViewEventListener.onReceivedError(webView, i5, str, str2);
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        WebViewEventListener webViewEventListener = this.mEventListener;
        if (webViewEventListener != null) {
            return webViewEventListener.shouldOverrideUrlLoading(webView, webResourceRequest.getUrl().toString());
        }
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }
}
