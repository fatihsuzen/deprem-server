package com.mbridge.msdk.mbsignalcommon.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import b.w;
import com.mbridge.msdk.foundation.tools.af;
import java.lang.reflect.Method;

@SuppressLint({"NewApi"})
public class BaseWebView extends WebView {

    /* renamed from: a  reason: collision with root package name */
    protected Context f10087a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public View.OnTouchListener f10088b;

    /* renamed from: c  reason: collision with root package name */
    private View.OnTouchListener f10089c = new View.OnTouchListener() {
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                BaseWebView.this.lastTouchTime = System.currentTimeMillis();
            }
            if (BaseWebView.this.f10088b != null) {
                return BaseWebView.this.f10088b.onTouch(view, motionEvent);
            }
            return false;
        }
    };
    public long lastTouchTime = 0;
    public b mWebViewClient;

    public BaseWebView(Context context) {
        super(context);
        this.f10087a = context;
        a();
    }

    public void reload() {
        super.reload();
    }

    public void setFilter(a aVar) {
        b bVar = this.mWebViewClient;
        if (bVar != null && w.a(bVar)) {
            this.mWebViewClient.a(aVar);
        }
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.f10088b = onTouchListener;
    }

    public void setTransparent() {
        setLayerType(1, (Paint) null);
        setBackgroundColor(0);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof b) {
            this.mWebViewClient = (b) webViewClient;
        }
    }

    /* access modifiers changed from: protected */
    public void a() {
        if (this.mWebViewClient == null) {
            b bVar = new b();
            this.mWebViewClient = bVar;
            setWebViewClient(bVar);
        }
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAppCacheEnabled(true);
        settings.setAppCacheMaxSize(5242880);
        settings.setAllowFileAccess(true);
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDomStorageEnabled(true);
        settings.setSupportZoom(false);
        settings.setSavePassword(false);
        settings.setDatabaseEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                settings.setSafeBrowsingEnabled(false);
            }
        } catch (Throwable th) {
            af.b("BaseWebView", th.getMessage());
        }
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        try {
            settings.setMixedContentMode(0);
        } catch (Exception e5) {
            af.b("BaseWebView", e5.getMessage());
        }
        settings.setDatabaseEnabled(true);
        String path = this.f10087a.getDir("database", 0).getPath();
        settings.setDatabasePath(path);
        settings.setGeolocationEnabled(true);
        settings.setGeolocationDatabasePath(path);
        Class<WebSettings> cls = WebSettings.class;
        try {
            Method declaredMethod = cls.getDeclaredMethod("setDisplayZoomControls", new Class[]{Boolean.TYPE});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(settings, new Object[]{Boolean.FALSE});
        } catch (Exception e6) {
            af.b("BaseWebView", e6.getMessage());
        }
        super.setOnTouchListener(this.f10089c);
    }

    public BaseWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10087a = context;
        a();
    }

    public BaseWebView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f10087a = context;
        a();
    }
}
