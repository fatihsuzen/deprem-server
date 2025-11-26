package com.uptodown.activities;

import O1.M;
import S1.k;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.uptodown.R;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class CustomWebView extends C1598a {

    /* renamed from: M  reason: collision with root package name */
    public static final a f13680M = new a((C2633k) null);

    /* renamed from: K  reason: collision with root package name */
    private String f13681K;

    /* renamed from: L  reason: collision with root package name */
    private String f13682L;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public static final class b extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            t.e(webResourceRequest, "request");
            return false;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            t.e(webView, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
            t.e(str, "url");
            return false;
        }
    }

    /* access modifiers changed from: private */
    public static final void g3(CustomWebView customWebView, View view) {
        customWebView.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.custom_web_view);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey(CampaignEx.JSON_KEY_TITLE)) {
                this.f13681K = extras.getString(CampaignEx.JSON_KEY_TITLE);
            }
            if (extras.containsKey("url")) {
                this.f13682L = extras.getString("url");
            }
        }
        ((ImageView) findViewById(R.id.iv_back_custom_web_view)).setOnClickListener(new M(this));
        TextView textView = (TextView) findViewById(R.id.tv_title_custom_web_view);
        textView.setTypeface(k.f32g.x());
        textView.setText(this.f13681K);
        WebView webView = (WebView) findViewById(R.id.wv_custom_web_view);
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setSupportZoom(true);
        webView.setScrollBarStyle(33554432);
        webView.setScrollbarFadingEnabled(true);
        webView.setInitialScale(80);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setDatabaseEnabled(true);
        webView.setWebViewClient(new b());
        String str = this.f13682L;
        if (str != null) {
            t.b(str);
            webView.loadUrl(str);
        }
    }
}
