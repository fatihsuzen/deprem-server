package com.finazzi.distquake;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.app.C0768d;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.C0832r0;
import com.google.android.gms.ads.RequestConfiguration;

public class WebViewActivity extends C0768d {

    /* renamed from: O  reason: collision with root package name */
    private String f13556O = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    /* access modifiers changed from: private */

    /* renamed from: P  reason: collision with root package name */
    public int f13557P = 0;

    class a extends WebChromeClient {
        a() {
        }

        public static /* synthetic */ void a(a aVar, View view) {
            SharedPreferences.Editor edit = WebViewActivity.this.getSharedPreferences(MainActivity.class.getSimpleName(), 0).edit();
            edit.putBoolean("chat_rules_accepted", true);
            edit.apply();
            WebViewActivity.this.setResult(1, new Intent());
            WebViewActivity.this.finish();
        }

        public static /* synthetic */ void b(a aVar, View view) {
            SharedPreferences.Editor edit = WebViewActivity.this.getSharedPreferences(MainActivity.class.getSimpleName(), 0).edit();
            edit.putBoolean("chat_rules_accepted", false);
            edit.apply();
            WebViewActivity.this.setResult(1, new Intent());
            WebViewActivity.this.finish();
        }

        public void onProgressChanged(WebView webView, int i8) {
            if (i8 == 100) {
                ((ProgressBar) WebViewActivity.this.findViewById(C2030R.id.progressBar)).setVisibility(8);
                if (WebViewActivity.this.f13557P == 6) {
                    ((LinearLayout) WebViewActivity.this.findViewById(C2030R.id.linear)).setVisibility(0);
                    ((Button) WebViewActivity.this.findViewById(C2030R.id.button1)).setOnClickListener(new d0(this));
                    ((Button) WebViewActivity.this.findViewById(C2030R.id.button2)).setOnClickListener(new e0(this));
                }
            }
        }
    }

    class b extends WebViewClient {
        b() {
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
            return false;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2030R.layout.webview);
        int i8 = getResources().getConfiguration().uiMode & 48;
        if (Build.VERSION.SDK_INT >= 35 && i8 == 16) {
            Window window = getWindow();
            C0832r0.a(window, window.getDecorView()).d(true);
        }
        boolean z7 = getSharedPreferences(MainActivity.class.getSimpleName(), 0).getBoolean("pro_features", false);
        Toolbar toolbar = (Toolbar) findViewById(C2030R.id.toolbar);
        b0(toolbar);
        if (!z7) {
            toolbar.setLogo(2131230872);
        } else {
            toolbar.setLogo(2131230875);
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int i9 = extras.getInt("com.finazzi.distquake.map_type");
            this.f13557P = i9;
            if (i9 == 3) {
                this.f13556O = extras.getString("com.finazzi.distquake.url_usgs");
            }
            if (this.f13557P >= 4) {
                this.f13556O = extras.getString("com.finazzi.distquake.url");
            }
        }
        WebView webView = (WebView) findViewById(C2030R.id.webView1);
        webView.clearCache(true);
        webView.clearHistory();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.setWebChromeClient(new a());
        webView.setWebViewClient(new b());
        if (this.f13557P >= 3) {
            webView.loadUrl(this.f13556O);
        }
    }

    public boolean onKeyDown(int i8, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || i8 != 4) {
            return super.onKeyDown(i8, keyEvent);
        }
        finish();
        return true;
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onUserLeaveHint() {
        super.onUserLeaveHint();
        finish();
    }
}
