package com.mbridge.msdk.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.aj;
import com.mbridge.msdk.foundation.tools.at;
import com.mbridge.msdk.foundation.webview.BrowserView;
import com.mbridge.msdk.foundation.webview.b;
import com.mbridge.msdk.out.NativeListener;

public class DomainMBCommonActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    String f7854a = "";

    /* renamed from: b  reason: collision with root package name */
    private final BrowserView.a f7855b = new BrowserView.a() {
        public final void a(WebView webView, int i5, String str, String str2) {
        }

        public final boolean b(WebView webView, String str) {
            af.b("MBCommonActivity", "shouldOverrideUrlLoading  " + str);
            if (aj.a.b(str) && aj.a.a(DomainMBCommonActivity.this, str, (NativeListener.NativeTrackingListener) null)) {
                DomainMBCommonActivity.this.finish();
            }
            return DomainMBCommonActivity.this.a(webView, str);
        }

        public final void c(WebView webView, String str) {
            af.b("MBCommonActivity", "onPageFinished  " + str);
        }

        public final void a(WebView webView, String str) {
        }

        public final void a() {
            DomainMBCommonActivity.this.finish();
        }

        public final void a(WebView webView, String str, Bitmap bitmap) {
            af.b("MBCommonActivity", "onPageStarted  " + str);
        }
    };
    protected BrowserView browserView;

    /* renamed from: c  reason: collision with root package name */
    private CampaignEx f7856c;

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
        } catch (Throwable th) {
            af.b("MBCommonActivity", th.getMessage());
        }
        if (c.m().c() == null) {
            c.m().b(getApplicationContext());
        }
        c.m().a((Context) this);
        String stringExtra = getIntent().getStringExtra("url");
        this.f7854a = stringExtra;
        if (!TextUtils.isEmpty(stringExtra)) {
            this.f7856c = (CampaignEx) getIntent().getSerializableExtra("mvcommon");
            if (b.f9820a.containsKey(this.f7854a)) {
                BrowserView browserView2 = b.f9820a.get(this.f7854a);
                this.browserView = browserView2;
                if (browserView2 != null) {
                    browserView2.setListener(this.f7855b);
                }
            } else {
                BrowserView browserView3 = new BrowserView((Context) this, this.f7856c);
                this.browserView = browserView3;
                browserView3.setListener(this.f7855b);
                this.browserView.loadUrl(this.f7854a);
            }
            BrowserView browserView4 = this.browserView;
            if (browserView4 != null) {
                at.a(browserView4);
                setContentView(this.browserView);
                return;
            }
            return;
        }
        Toast.makeText(this, "Error: no data", 0).show();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00d0 A[Catch:{ all -> 0x008e, all -> 0x0042 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00d9 A[Catch:{ all -> 0x008e, all -> 0x0042 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.webkit.WebView r10, java.lang.String r11) {
        /*
            r9 = this;
            java.lang.String r0 = "intent"
            java.lang.String r1 = "https"
            java.lang.String r2 = "http"
            java.lang.String r3 = "MBCommonActivity"
            r4 = 0
            boolean r5 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0042 }
            if (r5 == 0) goto L_0x0010
            return r4
        L_0x0010:
            android.net.Uri r5 = android.net.Uri.parse(r11)     // Catch:{ all -> 0x0042 }
            java.lang.String r6 = r5.getScheme()     // Catch:{ all -> 0x0042 }
            boolean r6 = r6.equals(r2)     // Catch:{ all -> 0x0042 }
            if (r6 != 0) goto L_0x00ef
            java.lang.String r6 = r5.getScheme()     // Catch:{ all -> 0x0042 }
            boolean r6 = r6.equals(r1)     // Catch:{ all -> 0x0042 }
            if (r6 == 0) goto L_0x002a
            goto L_0x00ef
        L_0x002a:
            java.lang.String r6 = r5.getScheme()     // Catch:{ all -> 0x0042 }
            boolean r6 = r6.equals(r0)     // Catch:{ all -> 0x0042 }
            java.lang.String r7 = "android-app"
            r8 = 1
            if (r6 != 0) goto L_0x0045
            java.lang.String r6 = r5.getScheme()     // Catch:{ all -> 0x0042 }
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x0042 }
            if (r6 == 0) goto L_0x00ca
            goto L_0x0045
        L_0x0042:
            r10 = move-exception
            goto L_0x00f0
        L_0x0045:
            java.lang.String r6 = r5.getScheme()     // Catch:{ all -> 0x0042 }
            boolean r0 = r6.equals(r0)     // Catch:{ all -> 0x0042 }
            r6 = 0
            if (r0 == 0) goto L_0x0055
            android.content.Intent r0 = android.content.Intent.parseUri(r11, r8)     // Catch:{ all -> 0x0042 }
            goto L_0x0066
        L_0x0055:
            java.lang.String r0 = r5.getScheme()     // Catch:{ all -> 0x0042 }
            boolean r0 = r0.equals(r7)     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x0065
            r0 = 2
            android.content.Intent r0 = android.content.Intent.parseUri(r11, r0)     // Catch:{ all -> 0x0042 }
            goto L_0x0066
        L_0x0065:
            r0 = r6
        L_0x0066:
            if (r0 == 0) goto L_0x006e
            r0.setComponent(r6)     // Catch:{ all -> 0x0042 }
            r0.setSelector(r6)     // Catch:{ all -> 0x0042 }
        L_0x006e:
            java.lang.String r5 = r0.getPackage()     // Catch:{ all -> 0x008e }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x008e }
            if (r6 != 0) goto L_0x0096
            android.content.pm.PackageManager r6 = r9.getPackageManager()     // Catch:{ all -> 0x008e }
            android.content.Intent r5 = r6.getLaunchIntentForPackage(r5)     // Catch:{ all -> 0x008e }
            if (r5 == 0) goto L_0x0096
            r5 = 268435456(0x10000000, float:2.5243549E-29)
            r0.setFlags(r5)     // Catch:{ all -> 0x008e }
            r9.startActivityForResult(r0, r4)     // Catch:{ all -> 0x008e }
            r9.finish()     // Catch:{ all -> 0x008e }
            return r8
        L_0x008e:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()     // Catch:{ all -> 0x0042 }
            com.mbridge.msdk.foundation.tools.af.b(r3, r5)     // Catch:{ all -> 0x0042 }
        L_0x0096:
            java.lang.String r5 = "browser_fallback_url"
            java.lang.String r0 = r0.getStringExtra(r5)     // Catch:{ all -> 0x00bd }
            boolean r5 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00bd }
            if (r5 != 0) goto L_0x00ca
            android.net.Uri r5 = android.net.Uri.parse(r11)     // Catch:{ all -> 0x00bd }
            java.lang.String r6 = r5.getScheme()     // Catch:{ all -> 0x00bd }
            boolean r6 = r6.equals(r2)     // Catch:{ all -> 0x00bd }
            if (r6 != 0) goto L_0x00bf
            java.lang.String r5 = r5.getScheme()     // Catch:{ all -> 0x00bd }
            boolean r5 = r5.equals(r1)     // Catch:{ all -> 0x00bd }
            if (r5 == 0) goto L_0x00bb
            goto L_0x00bf
        L_0x00bb:
            r11 = r0
            goto L_0x00ca
        L_0x00bd:
            r10 = move-exception
            goto L_0x00c3
        L_0x00bf:
            r10.loadUrl(r0)     // Catch:{ all -> 0x00bd }
            return r4
        L_0x00c3:
            java.lang.String r10 = r10.getMessage()     // Catch:{ all -> 0x0042 }
            com.mbridge.msdk.foundation.tools.af.b(r3, r10)     // Catch:{ all -> 0x0042 }
        L_0x00ca:
            boolean r10 = com.mbridge.msdk.click.c.e(r9, r11)     // Catch:{ all -> 0x0042 }
            if (r10 == 0) goto L_0x00d9
            java.lang.String r10 = "openDeepLink"
            com.mbridge.msdk.foundation.tools.af.b(r3, r10)     // Catch:{ all -> 0x0042 }
            r9.finish()     // Catch:{ all -> 0x0042 }
            return r8
        L_0x00d9:
            boolean r10 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0042 }
            if (r10 != 0) goto L_0x00ef
            boolean r10 = r11.startsWith(r2)     // Catch:{ all -> 0x0042 }
            if (r10 != 0) goto L_0x00eb
            boolean r10 = r11.startsWith(r1)     // Catch:{ all -> 0x0042 }
            if (r10 == 0) goto L_0x00ec
        L_0x00eb:
            r4 = r8
        L_0x00ec:
            r10 = r4 ^ 1
            return r10
        L_0x00ef:
            return r4
        L_0x00f0:
            java.lang.String r10 = r10.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r3, r10)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.activity.DomainMBCommonActivity.a(android.webkit.WebView, java.lang.String):boolean");
    }
}
