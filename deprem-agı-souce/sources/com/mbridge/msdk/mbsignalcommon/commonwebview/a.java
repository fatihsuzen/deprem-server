package com.mbridge.msdk.mbsignalcommon.commonwebview;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.tools.af;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class a extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    private CopyOnWriteArrayList<WebChromeClient> f10157a = new CopyOnWriteArrayList<>();

    public final void a(WebChromeClient webChromeClient) {
        this.f10157a.add(webChromeClient);
    }

    public final void b(WebChromeClient webChromeClient) {
        this.f10157a.remove(webChromeClient);
    }

    public final Bitmap getDefaultVideoPoster() {
        return super.getDefaultVideoPoster();
    }

    public final View getVideoLoadingProgressView() {
        return super.getVideoLoadingProgressView();
    }

    public final void getVisitedHistory(ValueCallback<String[]> valueCallback) {
        super.getVisitedHistory(valueCallback);
    }

    public final void onCloseWindow(WebView webView) {
        Iterator<WebChromeClient> it = this.f10157a.iterator();
        while (it.hasNext()) {
            it.next().onCloseWindow(webView);
        }
    }

    @Deprecated
    public final void onConsoleMessage(String str, int i5, String str2) {
        Iterator<WebChromeClient> it = this.f10157a.iterator();
        while (it.hasNext()) {
            it.next().onConsoleMessage(str, i5, str2);
        }
    }

    public final boolean onCreateWindow(WebView webView, boolean z4, boolean z5, Message message) {
        Iterator<WebChromeClient> it = this.f10157a.iterator();
        boolean z6 = false;
        while (it.hasNext()) {
            z6 = it.next().onCreateWindow(webView, z4, z5, message);
        }
        return z6;
    }

    @Deprecated
    public final void onExceededDatabaseQuota(String str, String str2, long j5, long j6, long j7, WebStorage.QuotaUpdater quotaUpdater) {
        Iterator<WebChromeClient> it = this.f10157a.iterator();
        while (it.hasNext()) {
            it.next().onExceededDatabaseQuota(str, str2, j5, j6, j7, quotaUpdater);
        }
    }

    public final void onGeolocationPermissionsHidePrompt() {
        Iterator<WebChromeClient> it = this.f10157a.iterator();
        while (it.hasNext()) {
            it.next().onGeolocationPermissionsHidePrompt();
        }
    }

    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        Iterator<WebChromeClient> it = this.f10157a.iterator();
        while (it.hasNext()) {
            it.next().onGeolocationPermissionsShowPrompt(str, callback);
        }
    }

    public final void onHideCustomView() {
        Iterator<WebChromeClient> it = this.f10157a.iterator();
        while (it.hasNext()) {
            it.next().onHideCustomView();
        }
    }

    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        Iterator<WebChromeClient> it = this.f10157a.iterator();
        boolean z4 = false;
        while (it.hasNext()) {
            z4 = it.next().onJsAlert(webView, str, str2, jsResult);
        }
        return z4;
    }

    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        Iterator<WebChromeClient> it = this.f10157a.iterator();
        boolean z4 = false;
        while (it.hasNext()) {
            z4 = it.next().onJsBeforeUnload(webView, str, str2, jsResult);
        }
        return z4;
    }

    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        Iterator<WebChromeClient> it = this.f10157a.iterator();
        boolean z4 = false;
        while (it.hasNext()) {
            z4 = it.next().onJsConfirm(webView, str, str2, jsResult);
        }
        return z4;
    }

    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        Iterator<WebChromeClient> it = this.f10157a.iterator();
        boolean z4 = false;
        while (it.hasNext()) {
            z4 = it.next().onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }
        return z4;
    }

    @Deprecated
    public final boolean onJsTimeout() {
        Iterator<WebChromeClient> it = this.f10157a.iterator();
        boolean z4 = false;
        while (it.hasNext()) {
            z4 = it.next().onJsTimeout();
        }
        return z4;
    }

    public final void onPermissionRequest(PermissionRequest permissionRequest) {
        try {
            Iterator<WebChromeClient> it = this.f10157a.iterator();
            while (it.hasNext()) {
                it.next().onPermissionRequest(permissionRequest);
            }
        } catch (Exception e5) {
            af.b("CommonWebChromeClient", e5.getMessage());
        }
    }

    public final void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
        try {
            Iterator<WebChromeClient> it = this.f10157a.iterator();
            while (it.hasNext()) {
                it.next().onPermissionRequestCanceled(permissionRequest);
            }
        } catch (Exception e5) {
            af.b("CommonWebChromeClient", e5.getMessage());
        }
    }

    public final void onProgressChanged(WebView webView, int i5) {
        Iterator<WebChromeClient> it = this.f10157a.iterator();
        while (it.hasNext()) {
            it.next().onProgressChanged(webView, i5);
        }
    }

    @Deprecated
    public final void onReachedMaxAppCacheSize(long j5, long j6, WebStorage.QuotaUpdater quotaUpdater) {
        Iterator<WebChromeClient> it = this.f10157a.iterator();
        while (it.hasNext()) {
            it.next().onReachedMaxAppCacheSize(j5, j6, quotaUpdater);
        }
    }

    public final void onReceivedIcon(WebView webView, Bitmap bitmap) {
        Iterator<WebChromeClient> it = this.f10157a.iterator();
        while (it.hasNext()) {
            it.next().onReceivedIcon(webView, bitmap);
        }
    }

    public final void onReceivedTitle(WebView webView, String str) {
        Iterator<WebChromeClient> it = this.f10157a.iterator();
        while (it.hasNext()) {
            it.next().onReceivedTitle(webView, str);
        }
    }

    public final void onReceivedTouchIconUrl(WebView webView, String str, boolean z4) {
        Iterator<WebChromeClient> it = this.f10157a.iterator();
        while (it.hasNext()) {
            it.next().onReceivedTouchIconUrl(webView, str, z4);
        }
    }

    public final void onRequestFocus(WebView webView) {
        Iterator<WebChromeClient> it = this.f10157a.iterator();
        while (it.hasNext()) {
            it.next().onRequestFocus(webView);
        }
    }

    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        Iterator<WebChromeClient> it = this.f10157a.iterator();
        while (it.hasNext()) {
            it.next().onShowCustomView(view, customViewCallback);
        }
    }

    public final boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        boolean z4 = false;
        try {
            Iterator<WebChromeClient> it = this.f10157a.iterator();
            while (it.hasNext()) {
                z4 = it.next().onShowFileChooser(webView, valueCallback, fileChooserParams);
            }
            return z4;
        } catch (Exception e5) {
            af.b("CommonWebChromeClient", e5.getMessage());
            return false;
        }
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        Iterator<WebChromeClient> it = this.f10157a.iterator();
        boolean z4 = false;
        while (it.hasNext()) {
            z4 = it.next().onConsoleMessage(consoleMessage);
        }
        return z4;
    }

    @Deprecated
    public final void onShowCustomView(View view, int i5, WebChromeClient.CustomViewCallback customViewCallback) {
        Iterator<WebChromeClient> it = this.f10157a.iterator();
        while (it.hasNext()) {
            it.next().onShowCustomView(view, i5, customViewCallback);
        }
    }
}
