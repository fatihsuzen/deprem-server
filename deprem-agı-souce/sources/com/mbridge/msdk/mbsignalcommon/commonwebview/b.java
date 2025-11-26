package com.mbridge.msdk.mbsignalcommon.commonwebview;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mbridge.msdk.foundation.tools.af;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class b extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    private CopyOnWriteArrayList<WebViewClient> f10158a = new CopyOnWriteArrayList<>();

    public final void a(WebViewClient webViewClient) {
        this.f10158a.add(webViewClient);
    }

    public final void b(WebViewClient webViewClient) {
        this.f10158a.remove(webViewClient);
    }

    public final void doUpdateVisitedHistory(WebView webView, String str, boolean z4) {
        Iterator<WebViewClient> it = this.f10158a.iterator();
        while (it.hasNext()) {
            it.next().doUpdateVisitedHistory(webView, str, z4);
        }
    }

    public final void onFormResubmission(WebView webView, Message message, Message message2) {
        Iterator<WebViewClient> it = this.f10158a.iterator();
        while (it.hasNext()) {
            it.next().onFormResubmission(webView, message, message2);
        }
    }

    public final void onLoadResource(WebView webView, String str) {
        Iterator<WebViewClient> it = this.f10158a.iterator();
        while (it.hasNext()) {
            it.next().onLoadResource(webView, str);
        }
    }

    public final void onPageCommitVisible(WebView webView, String str) {
        try {
            Iterator<WebViewClient> it = this.f10158a.iterator();
            while (it.hasNext()) {
                it.next().onPageCommitVisible(webView, str);
            }
        } catch (Exception e5) {
            af.b("CommonWebViewClient", e5.getMessage());
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        Iterator<WebViewClient> it = this.f10158a.iterator();
        while (it.hasNext()) {
            it.next().onPageFinished(webView, str);
        }
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Iterator<WebViewClient> it = this.f10158a.iterator();
        while (it.hasNext()) {
            it.next().onPageStarted(webView, str, bitmap);
        }
    }

    public final void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        try {
            Iterator<WebViewClient> it = this.f10158a.iterator();
            while (it.hasNext()) {
                it.next().onReceivedClientCertRequest(webView, clientCertRequest);
            }
        } catch (Exception e5) {
            af.b("CommonWebViewClient", e5.getMessage());
        }
    }

    @Deprecated
    public final void onReceivedError(WebView webView, int i5, String str, String str2) {
        Iterator<WebViewClient> it = this.f10158a.iterator();
        while (it.hasNext()) {
            it.next().onReceivedError(webView, i5, str, str2);
        }
    }

    public final void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        Iterator<WebViewClient> it = this.f10158a.iterator();
        while (it.hasNext()) {
            it.next().onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        }
    }

    public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        try {
            Iterator<WebViewClient> it = this.f10158a.iterator();
            while (it.hasNext()) {
                it.next().onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }
        } catch (Exception e5) {
            af.b("CommonWebViewClient", e5.getMessage());
        }
    }

    public final void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        Iterator<WebViewClient> it = this.f10158a.iterator();
        while (it.hasNext()) {
            it.next().onReceivedLoginRequest(webView, str, str2, str3);
        }
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        Iterator<WebViewClient> it = this.f10158a.iterator();
        while (it.hasNext()) {
            it.next().onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        boolean z4 = false;
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                Iterator<WebViewClient> it = this.f10158a.iterator();
                while (it.hasNext()) {
                    z4 = it.next().onRenderProcessGone(webView, renderProcessGoneDetail);
                }
            }
            return z4;
        } catch (Exception e5) {
            af.b("CommonWebViewClient", e5.getMessage());
            return false;
        }
    }

    public final void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i5, SafeBrowsingResponse safeBrowsingResponse) {
        try {
            if (Build.VERSION.SDK_INT >= 27) {
                Iterator<WebViewClient> it = this.f10158a.iterator();
                while (it.hasNext()) {
                    it.next().onSafeBrowsingHit(webView, webResourceRequest, i5, safeBrowsingResponse);
                }
            }
        } catch (Exception e5) {
            af.b("CommonWebViewClient", e5.getMessage());
        }
    }

    public final void onScaleChanged(WebView webView, float f5, float f6) {
        Iterator<WebViewClient> it = this.f10158a.iterator();
        while (it.hasNext()) {
            it.next().onScaleChanged(webView, f5, f6);
        }
    }

    @Deprecated
    public final void onTooManyRedirects(WebView webView, Message message, Message message2) {
        Iterator<WebViewClient> it = this.f10158a.iterator();
        while (it.hasNext()) {
            it.next().onTooManyRedirects(webView, message, message2);
        }
    }

    public final void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        Iterator<WebViewClient> it = this.f10158a.iterator();
        while (it.hasNext()) {
            it.next().onUnhandledKeyEvent(webView, keyEvent);
        }
    }

    @Deprecated
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        Iterator<WebViewClient> it = this.f10158a.iterator();
        WebResourceResponse webResourceResponse = null;
        while (it.hasNext()) {
            webResourceResponse = it.next().shouldInterceptRequest(webView, str);
        }
        return webResourceResponse;
    }

    public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        Iterator<WebViewClient> it = this.f10158a.iterator();
        boolean z4 = false;
        while (it.hasNext()) {
            z4 = it.next().shouldOverrideKeyEvent(webView, keyEvent);
        }
        return z4;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Iterator<WebViewClient> it = this.f10158a.iterator();
        boolean z4 = false;
        while (it.hasNext()) {
            boolean shouldOverrideUrlLoading = it.next().shouldOverrideUrlLoading(webView, str);
            if (shouldOverrideUrlLoading) {
                z4 = shouldOverrideUrlLoading;
            }
        }
        return z4;
    }

    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        try {
            Iterator<WebViewClient> it = this.f10158a.iterator();
            while (it.hasNext()) {
                it.next().onReceivedError(webView, webResourceRequest, webResourceError);
            }
        } catch (Exception e5) {
            af.b("CommonWebViewClient", e5.getMessage());
        }
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        WebResourceResponse webResourceResponse = null;
        try {
            Iterator<WebViewClient> it = this.f10158a.iterator();
            while (it.hasNext()) {
                webResourceResponse = it.next().shouldInterceptRequest(webView, webResourceRequest);
            }
            return webResourceResponse;
        } catch (Exception e5) {
            af.b("CommonWebViewClient", e5.getMessage());
            return null;
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        boolean z4 = false;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                Iterator<WebViewClient> it = this.f10158a.iterator();
                while (it.hasNext()) {
                    boolean a5 = it.next().shouldOverrideUrlLoading(webView, webResourceRequest);
                    if (a5) {
                        z4 = a5;
                    }
                }
            }
            return z4;
        } catch (Exception e5) {
            af.b("CommonWebViewClient", e5.getMessage());
            return false;
        }
    }
}
