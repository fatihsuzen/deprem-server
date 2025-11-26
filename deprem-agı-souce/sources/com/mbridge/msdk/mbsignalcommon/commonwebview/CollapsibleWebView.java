package com.mbridge.msdk.mbsignalcommon.commonwebview;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollapsibleWebView extends CommonWebView {

    /* renamed from: e  reason: collision with root package name */
    private CopyOnWriteArrayList<CommonWebView.a> f10110e;

    /* renamed from: f  reason: collision with root package name */
    private CopyOnWriteArrayList<CommonWebView.a> f10111f;

    /* renamed from: g  reason: collision with root package name */
    private CopyOnWriteArrayList<a> f10112g;

    /* renamed from: h  reason: collision with root package name */
    private String f10113h;

    /* renamed from: i  reason: collision with root package name */
    private String f10114i;

    public interface a {
        void a(View view, String str);

        void a(View view, Map<String, String> map);

        void b(View view, String str);

        void b(View view, Map<String, String> map);
    }

    public CollapsibleWebView(Context context) {
        super(context);
    }

    static /* synthetic */ void a(CollapsibleWebView collapsibleWebView) {
        Iterator<CommonWebView.a> it = collapsibleWebView.f10110e.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    static /* synthetic */ void b(CollapsibleWebView collapsibleWebView) {
        Iterator<CommonWebView.a> it = collapsibleWebView.f10111f.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public String getCollapseIconName() {
        return this.f10113h;
    }

    public String getExpandIconName() {
        return this.f10114i;
    }

    public void init() {
        super.init();
        this.f10110e = new CopyOnWriteArrayList<>();
        this.f10111f = new CopyOnWriteArrayList<>();
        this.f10112g = new CopyOnWriteArrayList<>();
        this.f10113h = "mbridge_arrow_down_white_blackbg";
        this.f10114i = "mbridge_arrow_up_white";
        useDeeplink();
        initWebViewListener();
        useProgressBar();
        ArrayList arrayList = new ArrayList();
        ToolBar.b bVar = new ToolBar.b("doCollapse");
        bVar.f10155c = false;
        bVar.f10154b = "mbridge_arrow_down_white_blackbg";
        bVar.f10156d = new View.OnClickListener() {
            public final void onClick(View view) {
                CollapsibleWebView.this.hideToolBarButton("doCollapse");
                CollapsibleWebView.this.showToolBarButton("doSpand");
                CollapsibleWebView.a(CollapsibleWebView.this);
            }
        };
        arrayList.add(bVar);
        ToolBar.b bVar2 = new ToolBar.b("doSpand");
        bVar2.f10154b = "mbridge_arrow_up_black";
        bVar2.f10156d = new View.OnClickListener() {
            public final void onClick(View view) {
                CollapsibleWebView.this.hideToolBarButton("doSpand");
                CollapsibleWebView.this.showToolBarButton("doCollapse");
                CollapsibleWebView.b(CollapsibleWebView.this);
            }
        };
        arrayList.add(bVar2);
        useDefaultToolBar();
        useCustomizedToolBar(arrayList, true);
    }

    public void initWebViewListener() {
        setPageLoadTimtoutListener(new CommonWebView.b() {
            public final void a(String str) {
                CollapsibleWebView collapsibleWebView = CollapsibleWebView.this;
                CollapsibleWebView.a(collapsibleWebView, (View) collapsibleWebView.f10124d, str);
            }
        });
        setPageLoadTimtout(CommonWebView.DEFAULT_JUMP_TIMEOUT);
        addWebViewClient(new WebViewClient() {

            /* renamed from: a  reason: collision with root package name */
            Boolean f10118a = Boolean.FALSE;

            /* renamed from: b  reason: collision with root package name */
            String f10119b = "";

            public final void onPageFinished(WebView webView, String str) {
                if (!this.f10118a.booleanValue()) {
                    CollapsibleWebView.b(CollapsibleWebView.this, (View) webView, str);
                    this.f10118a = Boolean.FALSE;
                }
            }

            public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                if (!TextUtils.isEmpty(str)) {
                    this.f10119b = str;
                }
            }

            public final void onReceivedError(WebView webView, int i5, String str, String str2) {
                HashMap hashMap = new HashMap();
                hashMap.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, CampaignEx.JSON_NATIVE_VIDEO_ERROR);
                hashMap.put("url", str2);
                hashMap.put("description", str);
                if (!this.f10118a.booleanValue() && this.f10119b.equals(str2)) {
                    this.f10118a = Boolean.TRUE;
                    CollapsibleWebView.a(CollapsibleWebView.this, (View) webView, (Map) hashMap);
                }
                CollapsibleWebView.b(CollapsibleWebView.this, (View) webView, (Map) hashMap);
            }

            public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                HashMap hashMap = new HashMap();
                hashMap.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "http");
                String str = webResourceRequest.getUrl() + "";
                hashMap.put("url", str);
                hashMap.put("statusCode", webResourceResponse.getStatusCode() + "");
                hashMap.put("description", "http error");
                if (!this.f10118a.booleanValue() && (this.f10119b.equals(str) || TextUtils.isEmpty(this.f10119b))) {
                    this.f10118a = Boolean.TRUE;
                    CollapsibleWebView.a(CollapsibleWebView.this, (View) webView, (Map) hashMap);
                }
                CollapsibleWebView.b(CollapsibleWebView.this, (View) webView, (Map) hashMap);
            }

            public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                HashMap hashMap = new HashMap();
                hashMap.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "ssl");
                hashMap.put("url", sslError.getUrl());
                hashMap.put("description", "ssl error");
                if (!this.f10118a.booleanValue()) {
                    String str = this.f10119b;
                    if (str.equals(sslError.getUrl() + "")) {
                        this.f10118a = Boolean.TRUE;
                        CollapsibleWebView.a(CollapsibleWebView.this, (View) webView, (Map) hashMap);
                    }
                }
                CollapsibleWebView.b(CollapsibleWebView.this, (View) webView, (Map) hashMap);
            }

            public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                af.b("CollapsibleWebView", "WebView called onRenderProcessGone");
                return true;
            }
        });
    }

    public void setCollapseIconName(String str) {
        this.f10113h = str;
    }

    public void setCollapseListener(CommonWebView.a aVar) {
        this.f10110e.add(aVar);
    }

    public void setCustomizedToolBarMarginWidthPixel(int i5, int i6, int i7, int i8) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f10121a.getLayoutParams();
        layoutParams.setMargins(i5, i6, i7, i8);
        this.f10121a.setLayoutParams(layoutParams);
    }

    public void setExpandIconName(String str) {
        this.f10114i = str;
    }

    public void setExpandListener(CommonWebView.a aVar) {
        this.f10111f.add(aVar);
    }

    public void setPageLoadListener(a aVar) {
        this.f10112g.add(aVar);
    }

    public CollapsibleWebView(Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }

    public CollapsibleWebView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    static /* synthetic */ void a(CollapsibleWebView collapsibleWebView, View view, String str) {
        Iterator<a> it = collapsibleWebView.f10112g.iterator();
        while (it.hasNext()) {
            it.next().b(view, str);
        }
    }

    static /* synthetic */ void b(CollapsibleWebView collapsibleWebView, View view, String str) {
        Iterator<a> it = collapsibleWebView.f10112g.iterator();
        while (it.hasNext()) {
            it.next().a(view, str);
        }
    }

    static /* synthetic */ void a(CollapsibleWebView collapsibleWebView, View view, Map map) {
        Iterator<a> it = collapsibleWebView.f10112g.iterator();
        while (it.hasNext()) {
            it.next().a(view, (Map<String, String>) map);
        }
    }

    static /* synthetic */ void b(CollapsibleWebView collapsibleWebView, View view, Map map) {
        Iterator<a> it = collapsibleWebView.f10112g.iterator();
        while (it.hasNext()) {
            it.next().b(view, (Map<String, String>) map);
        }
    }
}
