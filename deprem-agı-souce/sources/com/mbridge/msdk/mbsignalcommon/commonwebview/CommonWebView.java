package com.mbridge.msdk.mbsignalcommon.commonwebview;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.mbridge.msdk.click.c;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.aj;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.webview.ProgressBar;
import com.mbridge.msdk.mbsignalcommon.base.BaseWebView;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import com.mbridge.msdk.out.NativeListener;
import java.util.ArrayList;
import java.util.List;

public class CommonWebView extends LinearLayout {
    public static int DEFAULT_JUMP_TIMEOUT = 10000;

    /* renamed from: a  reason: collision with root package name */
    protected ToolBar f10121a;

    /* renamed from: b  reason: collision with root package name */
    protected ToolBar f10122b;

    /* renamed from: c  reason: collision with root package name */
    protected ProgressBar f10123c;

    /* renamed from: d  reason: collision with root package name */
    protected BaseWebView f10124d;

    /* renamed from: e  reason: collision with root package name */
    private int f10125e;

    /* renamed from: f  reason: collision with root package name */
    private int f10126f;

    /* renamed from: g  reason: collision with root package name */
    private RelativeLayout f10127g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f10128h;

    /* renamed from: i  reason: collision with root package name */
    private b f10129i;

    /* renamed from: j  reason: collision with root package name */
    private a f10130j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public View.OnClickListener f10131k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public View.OnClickListener f10132l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public View.OnClickListener f10133m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public View.OnClickListener f10134n;

    /* renamed from: o  reason: collision with root package name */
    private Handler f10135o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public int f10136p;

    /* renamed from: q  reason: collision with root package name */
    private WebViewClient f10137q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public String f10138r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public b f10139s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public boolean f10140t;

    /* renamed from: u  reason: collision with root package name */
    private final Runnable f10141u = new Runnable() {
        public final void run() {
            af.b("CommonWebView", "webview js!！超时上限：" + CommonWebView.this.f10136p + "ms");
            if (CommonWebView.this.f10139s != null) {
                boolean unused = CommonWebView.this.f10140t = false;
                CommonWebView.this.f10139s.a(CommonWebView.this.f10138r);
            }
        }
    };

    public interface a {
        void a();
    }

    public interface b {
        void a(String str);
    }

    public CommonWebView(Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        init();
    }

    public void addWebChromeClient(WebChromeClient webChromeClient) {
        this.f10130j.a(webChromeClient);
    }

    public void addWebViewClient(WebViewClient webViewClient) {
        this.f10129i.a(webViewClient);
    }

    public View findToolBarButton(String str) {
        View view;
        ToolBar toolBar;
        ToolBar toolBar2 = this.f10121a;
        if (toolBar2 != null) {
            view = toolBar2.getItem(str);
        } else {
            view = null;
        }
        if (view != null || (toolBar = this.f10122b) == null) {
            return view;
        }
        return toolBar.getItem(str);
    }

    public String getUrl() {
        BaseWebView baseWebView = this.f10124d;
        if (baseWebView == null) {
            return "";
        }
        return baseWebView.getUrl();
    }

    public WebView getWebView() {
        return this.f10124d;
    }

    public void hideCustomizedToolBar() {
        ToolBar toolBar = this.f10121a;
        if (toolBar != null) {
            toolBar.setVisibility(8);
        }
    }

    public void hideDefaultToolBar() {
        ToolBar toolBar = this.f10122b;
        if (toolBar != null) {
            toolBar.setVisibility(8);
        }
    }

    public void hideToolBarButton(String str) {
        View findToolBarButton = findToolBarButton(str);
        if (findToolBarButton != null) {
            findToolBarButton.setVisibility(8);
        }
    }

    public void hideToolBarTitle() {
        this.f10121a.hideTitle();
    }

    public void init() {
        setOrientation(1);
        setGravity(17);
        this.f10127g = new RelativeLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        addView(this.f10127g, layoutParams);
        this.f10125e = ak.a(getContext(), 40.0f);
        this.f10126f = ak.a(getContext(), 40.0f);
        this.f10129i = new b();
        this.f10130j = new a();
        initWebview();
    }

    public void initWebview() {
        try {
            if (this.f10124d == null) {
                this.f10124d = new BaseWebView(getContext());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(10);
            this.f10124d.setLayoutParams(layoutParams);
            BaseWebView baseWebView = this.f10124d;
            com.mbridge.msdk.mbsignalcommon.base.b bVar = baseWebView.mWebViewClient;
            baseWebView.setWebViewClient(this.f10129i);
            this.f10124d.setWebChromeClient(this.f10130j);
            addWebViewClient(bVar);
        } catch (Throwable th) {
            af.b("CommonWebView", "webview is error", th);
        }
        this.f10127g.addView(this.f10124d);
    }

    public void loadUrl(String str) {
        this.f10124d.loadUrl(str);
        if (this.f10137q != null) {
            a();
        }
    }

    public void onBackwardClicked(View.OnClickListener onClickListener) {
        this.f10131k = onClickListener;
    }

    public void onForwardClicked(View.OnClickListener onClickListener) {
        this.f10132l = onClickListener;
    }

    public void onOpenByBrowserClicked(View.OnClickListener onClickListener) {
        this.f10134n = onClickListener;
    }

    public void onRefreshClicked(View.OnClickListener onClickListener) {
        this.f10133m = onClickListener;
    }

    public void removeWebChromeClient(WebChromeClient webChromeClient) {
        this.f10130j.b(webChromeClient);
    }

    public void removeWebViewClient(WebViewClient webViewClient) {
        this.f10129i.b(webViewClient);
    }

    public void setCustomizedToolBarFloating() {
        ((ViewGroup) this.f10121a.getParent()).removeView(this.f10121a);
        this.f10127g.addView(this.f10121a);
    }

    public void setCustomizedToolBarUnfloating() {
        ((ViewGroup) this.f10121a.getParent()).removeView(this.f10121a);
        addView(this.f10121a, 0);
    }

    public void setExitsClickListener(View.OnClickListener onClickListener) {
        this.f10128h = onClickListener;
    }

    public void setPageLoadTimtout(int i5) {
        this.f10136p = i5;
        if (this.f10135o == null) {
            this.f10135o = new Handler(Looper.getMainLooper());
        }
        if (this.f10137q == null) {
            AnonymousClass7 r22 = new WebViewClient() {
                public final void onPageFinished(WebView webView, String str) {
                    boolean unused = CommonWebView.this.f10140t = false;
                    CommonWebView.this.f10135o.removeCallbacks(CommonWebView.this.f10141u);
                }

                public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                    String unused = CommonWebView.this.f10138r = str;
                    if (!CommonWebView.this.f10140t) {
                        boolean unused2 = CommonWebView.this.f10140t = true;
                        CommonWebView.this.a();
                    }
                }

                public final void onReceivedError(WebView webView, int i5, String str, String str2) {
                    boolean unused = CommonWebView.this.f10140t = false;
                    CommonWebView.this.f10135o.removeCallbacks(CommonWebView.this.f10141u);
                }

                public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    String unused = CommonWebView.this.f10138r = str;
                    if (CommonWebView.this.f10140t) {
                        CommonWebView.this.f10135o.removeCallbacks(CommonWebView.this.f10141u);
                    }
                    boolean unused2 = CommonWebView.this.f10140t = true;
                    CommonWebView.this.a();
                    return false;
                }
            };
            this.f10137q = r22;
            addWebViewClient(r22);
        }
    }

    public void setPageLoadTimtoutListener(b bVar) {
        this.f10139s = bVar;
    }

    public void setToolBarTitle(String str, int i5) {
        this.f10121a.setTitle(str, i5);
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        addWebChromeClient(webChromeClient);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        addWebViewClient(webViewClient);
    }

    public void showCustomizedToolBar() {
        ToolBar toolBar = this.f10121a;
        if (toolBar != null) {
            toolBar.setVisibility(0);
        }
    }

    public void showDefaultToolBar() {
        ToolBar toolBar = this.f10122b;
        if (toolBar != null) {
            toolBar.setVisibility(0);
        }
    }

    public void showToolBarButton(String str) {
        View findToolBarButton = findToolBarButton(str);
        if (findToolBarButton != null) {
            findToolBarButton.setVisibility(0);
        }
    }

    public void showToolBarTitle() {
        this.f10121a.showTitle();
    }

    public void useCustomizedToolBar(ArrayList<ToolBar.b> arrayList, boolean z4) {
        a(arrayList, z4);
    }

    public void useDeeplink() {
        addWebViewClient(new WebViewClient() {
            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (aj.a.b(str)) {
                    aj.a.a(CommonWebView.this.getContext(), str, (NativeListener.NativeTrackingListener) null);
                }
                return CommonWebView.this.a(webView, str);
            }
        });
    }

    public void useDefaultToolBar() {
        if (this.f10122b == null) {
            this.f10122b = new ToolBar(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.f10126f);
            layoutParams.bottomMargin = 0;
            this.f10122b.setLayoutParams(layoutParams);
            this.f10122b.setBackgroundColor(-1);
            this.f10122b.setOnItemClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    BaseWebView baseWebView = CommonWebView.this.f10124d;
                    if (baseWebView != null) {
                        baseWebView.stopLoading();
                        String str = (String) view.getTag();
                        if (TextUtils.equals(str, ToolBar.BACKWARD)) {
                            CommonWebView.this.f10122b.getItem(ToolBar.FORWARD).setEnabled(true);
                            if (CommonWebView.this.f10124d.canGoBack()) {
                                CommonWebView.this.f10124d.goBack();
                            }
                            CommonWebView.this.f10122b.getItem(ToolBar.BACKWARD).setEnabled(CommonWebView.this.f10124d.canGoBack());
                            if (CommonWebView.this.f10131k != null) {
                                CommonWebView.this.f10131k.onClick(view);
                            }
                        } else if (TextUtils.equals(str, ToolBar.FORWARD)) {
                            CommonWebView.this.f10122b.getItem(ToolBar.BACKWARD).setEnabled(true);
                            if (CommonWebView.this.f10124d.canGoForward()) {
                                CommonWebView.this.f10124d.goForward();
                            }
                            CommonWebView.this.f10122b.getItem(ToolBar.FORWARD).setEnabled(CommonWebView.this.f10124d.canGoForward());
                            if (CommonWebView.this.f10132l != null) {
                                CommonWebView.this.f10132l.onClick(view);
                            }
                        } else if (TextUtils.equals(str, ToolBar.REFRESH)) {
                            CommonWebView.this.f10122b.getItem(ToolBar.BACKWARD).setEnabled(CommonWebView.this.f10124d.canGoBack());
                            CommonWebView.this.f10122b.getItem(ToolBar.FORWARD).setEnabled(CommonWebView.this.f10124d.canGoForward());
                            CommonWebView.this.f10124d.reload();
                            if (CommonWebView.this.f10133m != null) {
                                CommonWebView.this.f10133m.onClick(view);
                            }
                        } else if (TextUtils.equals(str, ToolBar.EXITS)) {
                            if (CommonWebView.this.f10128h != null) {
                                CommonWebView.this.f10128h.onClick(view);
                            }
                        } else if (TextUtils.equals(str, ToolBar.OPEN_BY_BROWSER)) {
                            if (CommonWebView.this.f10134n != null) {
                                CommonWebView.this.f10134n.onClick(view);
                            }
                            c.d(CommonWebView.this.getContext(), CommonWebView.this.f10124d.getUrl());
                        }
                    }
                }
            });
            addWebViewClient(new WebViewClient() {
                public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    CommonWebView.this.f10122b.getItem(ToolBar.BACKWARD).setEnabled(true);
                    CommonWebView.this.f10122b.getItem(ToolBar.FORWARD).setEnabled(false);
                    return false;
                }
            });
            addView(this.f10122b);
        }
    }

    public void useProgressBar() {
        ProgressBar progressBar = new ProgressBar(getContext());
        this.f10123c = progressBar;
        progressBar.setLayoutParams(new LinearLayout.LayoutParams(-1, 4));
        addWebViewClient(new WebViewClient() {
            public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                af.c("CommonWebView", "newProgress! 开始! = " + str);
                CommonWebView.this.f10123c.setVisible(true);
                CommonWebView.this.f10123c.setProgressState(5);
            }
        });
        addWebChromeClient(new WebChromeClient() {
            public final void onProgressChanged(WebView webView, int i5) {
                af.c("CommonWebView", "newProgress! = " + i5);
                if (i5 == 100) {
                    CommonWebView.this.f10123c.setProgressState(7);
                    new Handler().postDelayed(new Runnable() {
                        public final void run() {
                            CommonWebView.this.f10123c.setVisible(false);
                        }
                    }, 200);
                }
            }
        });
        addView(this.f10123c);
        this.f10123c.initResource(true);
    }

    public void setToolBarTitle(String str) {
        this.f10121a.setTitle(str);
    }

    public void useCustomizedToolBar(ArrayList<ToolBar.b> arrayList) {
        a(arrayList, false);
    }

    public CommonWebView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void a(ArrayList<ToolBar.b> arrayList, boolean z4) {
        if (this.f10121a == null) {
            ToolBar.a aVar = new ToolBar.a();
            aVar.f10152a = 40;
            ToolBar.a.f10150b = 80;
            ToolBar toolBar = new ToolBar(getContext(), aVar, (List<ToolBar.b>) arrayList);
            this.f10121a = toolBar;
            toolBar.setBackgroundColor(Color.argb(153, 255, 255, 255));
            if (z4) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f10125e);
                layoutParams.addRule(10);
                this.f10121a.setLayoutParams(layoutParams);
                this.f10127g.addView(this.f10121a);
                return;
            }
            this.f10121a.setLayoutParams(new LinearLayout.LayoutParams(-1, this.f10125e));
            addView(this.f10121a, 0);
        }
    }

    public CommonWebView(Context context) {
        super(context);
        init();
    }

    /* access modifiers changed from: private */
    public boolean a(WebView webView, String str) {
        boolean z4 = false;
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Uri parse = Uri.parse(str);
            if (!parse.getScheme().equals("http")) {
                if (!parse.getScheme().equals("https")) {
                    if (parse.getScheme().equals("intent")) {
                        Intent parseUri = Intent.parseUri(str, 1);
                        String str2 = parseUri.getPackage();
                        if (!TextUtils.isEmpty(str2) && getContext().getPackageManager().getLaunchIntentForPackage(str2) != null) {
                            parseUri.setComponent((ComponentName) null);
                            parseUri.setSelector((Intent) null);
                            parseUri.setFlags(268435456);
                            getContext().startActivity(parseUri);
                            return true;
                        }
                        try {
                            String stringExtra = parseUri.getStringExtra("browser_fallback_url");
                            if (!TextUtils.isEmpty(stringExtra)) {
                                Uri parse2 = Uri.parse(str);
                                if (!parse2.getScheme().equals("http")) {
                                    if (!parse2.getScheme().equals("https")) {
                                        str = stringExtra;
                                    }
                                }
                                webView.loadUrl(stringExtra);
                                return false;
                            }
                        } catch (Throwable th) {
                            af.b("CommonWebView", th.getMessage());
                        }
                    }
                    if (c.e(getContext(), str)) {
                        af.b("CommonWebView", "openDeepLink");
                        return true;
                    } else if (!TextUtils.isEmpty(str)) {
                        if (str.startsWith("http") || str.startsWith("https")) {
                            z4 = true;
                        }
                        return !z4;
                    }
                }
            }
            return false;
        } catch (Throwable th2) {
            af.b("CommonWebView", th2.getMessage());
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        this.f10135o.postDelayed(this.f10141u, (long) this.f10136p);
    }
}
