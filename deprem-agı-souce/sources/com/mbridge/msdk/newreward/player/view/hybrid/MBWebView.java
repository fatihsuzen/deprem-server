package com.mbridge.msdk.newreward.player.view.hybrid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.player.view.hybrid.client.MBWebChromeClient;
import com.mbridge.msdk.newreward.player.view.hybrid.client.MBWebViewClient;
import com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicator;
import com.mbridge.msdk.newreward.player.view.hybrid.listener.WebViewEventListener;

public class MBWebView extends WebView {
    private final String TAG = "MBWebView";
    private boolean isDestroyed;
    private MBWebChromeClient mWebChromeClient;
    private MBWebViewClient mWebViewClient;

    public MBWebView(@NonNull Context context) {
        super(context);
        initView();
    }

    private void initView() {
        setWebViewSetting();
        MBWebViewClient mBWebViewClient = new MBWebViewClient();
        this.mWebViewClient = mBWebViewClient;
        setWebViewClient(mBWebViewClient);
        MBWebChromeClient mBWebChromeClient = new MBWebChromeClient();
        this.mWebChromeClient = mBWebChromeClient;
        mBWebChromeClient.setWeView(this);
        setWebChromeClient(this.mWebChromeClient);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void setWebViewSetting() {
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        WebSettings settings = getSettings();
        settings.setUserAgentString(settings.getUserAgentString() + " WindVane/3.0.2");
        settings.setJavaScriptEnabled(true);
        settings.setAppCacheEnabled(true);
        settings.setAppCacheMaxSize(5242880);
        settings.setAllowFileAccess(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDomStorageEnabled(true);
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setSavePassword(false);
        settings.setDatabaseEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        if (Build.VERSION.SDK_INT >= 26) {
            settings.setSafeBrowsingEnabled(false);
        }
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setMixedContentMode(0);
        settings.setDatabaseEnabled(true);
        String path = getContext().getDir("database", 0).getPath();
        settings.setDatabasePath(path);
        settings.setGeolocationEnabled(true);
        settings.setGeolocationDatabasePath(path);
    }

    public void destroy() {
        if (!this.isDestroyed) {
            try {
                this.isDestroyed = true;
                setVisibility(8);
                removeAllViews();
                setDownloadListener((DownloadListener) null);
                destroy();
            } catch (Throwable th) {
                af.b("MBWebView", th.getMessage());
            }
        }
    }

    public HybridCommunicator getHybridCommunicator() {
        MBWebChromeClient mBWebChromeClient = this.mWebChromeClient;
        if (mBWebChromeClient != null) {
            return mBWebChromeClient.getHybridCommunicator();
        }
        return null;
    }

    public boolean isDestroyed() {
        return this.isDestroyed;
    }

    public void setHybridCommunicator(HybridCommunicator hybridCommunicator) {
        MBWebChromeClient mBWebChromeClient = this.mWebChromeClient;
        if (mBWebChromeClient != null) {
            mBWebChromeClient.setHybridCommunicator(hybridCommunicator);
        }
    }

    public void setWebViewEventListener(WebViewEventListener webViewEventListener) {
        MBWebViewClient mBWebViewClient = this.mWebViewClient;
        if (mBWebViewClient != null) {
            mBWebViewClient.setWebViewEventListener(webViewEventListener);
        }
        MBWebChromeClient mBWebChromeClient = this.mWebChromeClient;
        if (mBWebChromeClient != null) {
            mBWebChromeClient.setWebViewEventListener(webViewEventListener);
        }
    }

    public MBWebView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public MBWebView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        initView();
    }

    @RequiresApi(api = 21)
    public MBWebView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
        initView();
    }
}
