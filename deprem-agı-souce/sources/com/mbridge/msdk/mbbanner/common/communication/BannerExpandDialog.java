package com.mbridge.msdk.mbbanner.common.communication;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.mbbanner.common.b.a;
import com.mbridge.msdk.mbsignalcommon.mraid.b;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import com.mbridge.msdk.widget.MBAdChoice;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class BannerExpandDialog extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private final String f10026a = "BannerExpandDialog";

    /* renamed from: b  reason: collision with root package name */
    private String f10027b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10028c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f10029d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public WindVaneWebView f10030e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public TextView f10031f;

    /* renamed from: g  reason: collision with root package name */
    private String f10032g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public List<CampaignEx> f10033h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public a f10034i;

    /* renamed from: j  reason: collision with root package name */
    private b f10035j = new b() {
        public final void close() {
            BannerExpandDialog.this.dismiss();
        }

        public final void expand(String str, boolean z4) {
        }

        public final CampaignEx getMraidCampaign() {
            return null;
        }

        public final void open(String str) {
            try {
                if (BannerExpandDialog.this.f10030e == null || System.currentTimeMillis() - BannerExpandDialog.this.f10030e.lastTouchTime <= ((long) com.mbridge.msdk.click.b.a.f8100c) || !com.mbridge.msdk.click.b.a.a((CampaignEx) BannerExpandDialog.this.f10033h.get(0), BannerExpandDialog.this.f10030e.getUrl(), com.mbridge.msdk.click.b.a.f8098a)) {
                    af.b("BannerExpandDialog", str);
                    if (BannerExpandDialog.this.f10033h.size() > 1) {
                        c.m().c().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        str = null;
                    }
                    if (BannerExpandDialog.this.f10034i != null) {
                        BannerExpandDialog.this.f10034i.a(true, str);
                    }
                }
            } catch (Throwable th) {
                af.b("BannerExpandDialog", "open", th);
            }
        }

        public final void unload() {
            close();
        }

        public final void useCustomClose(boolean z4) {
            int i5;
            try {
                TextView g5 = BannerExpandDialog.this.f10031f;
                if (z4) {
                    i5 = 4;
                } else {
                    i5 = 0;
                }
                g5.setVisibility(i5);
            } catch (Throwable th) {
                af.b("BannerExpandDialog", "useCustomClose", th);
            }
        }
    };

    public BannerExpandDialog(Context context, Bundle bundle, a aVar) {
        super(context);
        if (bundle != null) {
            this.f10027b = bundle.getString("url");
            this.f10028c = bundle.getBoolean("shouldUseCustomClose");
        }
        this.f10034i = aVar;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        int i5;
        CampaignEx campaignEx;
        super.onCreate(bundle);
        requestWindowFeature(1);
        setCanceledOnTouchOutside(false);
        setCancelable(true);
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f10029d = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        WindVaneWebView windVaneWebView = new WindVaneWebView(getContext().getApplicationContext());
        this.f10030e = windVaneWebView;
        windVaneWebView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f10029d.addView(this.f10030e);
        TextView textView = new TextView(getContext());
        this.f10031f = textView;
        textView.setBackgroundColor(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(96, 96);
        layoutParams.gravity = 8388661;
        layoutParams.setMargins(30, 30, 30, 30);
        this.f10031f.setLayoutParams(layoutParams);
        TextView textView2 = this.f10031f;
        if (this.f10028c) {
            i5 = 4;
        } else {
            i5 = 0;
        }
        textView2.setVisibility(i5);
        this.f10031f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BannerExpandDialog.this.dismiss();
            }
        });
        BitmapDrawable a5 = c.m().a(this.f10032g, 296);
        if (a5 != null) {
            ImageView imageView = new ImageView(c.m().c());
            ak.a(imageView, a5, this.f10029d.getResources().getDisplayMetrics());
            this.f10029d.addView(imageView, new ViewGroup.LayoutParams(-1, -1));
        }
        this.f10029d.addView(this.f10031f);
        setContentView(this.f10029d);
        a();
        this.f10030e.setWebViewListener(new com.mbridge.msdk.mbsignalcommon.b.b() {
            public final void a(WebView webView, String str) {
                super.a(webView, str);
                webView.evaluateJavascript("javascript:" + com.mbridge.msdk.c.b.a.a().b(), new ValueCallback<String>() {
                    public final /* bridge */ /* synthetic */ void onReceiveValue(Object obj) {
                        String str = (String) obj;
                    }
                });
                BannerExpandDialog.a(BannerExpandDialog.this);
            }
        });
        this.f10030e.setObject(this.f10035j);
        this.f10030e.loadUrl(this.f10027b);
        List<CampaignEx> list = this.f10033h;
        if (!(list == null || list.size() <= 0 || (campaignEx = this.f10033h.get(0)) == null || campaignEx.getPrivacyButtonTemplateVisibility() == 0)) {
            MBAdChoice mBAdChoice = new MBAdChoice(c.m().c());
            mBAdChoice.setCampaign(campaignEx);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(ak.a(c.m().c(), 12.0f), ak.a(c.m().c(), 12.0f));
            layoutParams2.gravity = 85;
            layoutParams2.bottomMargin = layoutParams.topMargin;
            layoutParams2.rightMargin = layoutParams.rightMargin;
            mBAdChoice.setFeedbackDialogEventListener(new com.mbridge.msdk.foundation.d.a() {
                public final void close() {
                    BannerExpandDialog.this.a();
                }

                public final void showed() {
                }

                public final void summit(String str) {
                    BannerExpandDialog.this.a();
                }
            });
            this.f10029d.addView(mBAdChoice, layoutParams2);
        }
        setOnDismissListener(new DialogInterface.OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                if (BannerExpandDialog.this.f10034i != null) {
                    BannerExpandDialog.this.f10034i.a(false);
                }
                BannerExpandDialog.this.f10030e.loadDataWithBaseURL((String) null, "", "text/html", "utf-8", (String) null);
                BannerExpandDialog.this.f10029d.removeView(BannerExpandDialog.this.f10030e);
                BannerExpandDialog.this.f10030e.release();
                WindVaneWebView unused = BannerExpandDialog.this.f10030e = null;
                a unused2 = BannerExpandDialog.this.f10034i = null;
            }
        });
    }

    public void setCampaignList(String str, List<CampaignEx> list) {
        this.f10032g = str;
        this.f10033h = list;
    }

    static /* synthetic */ void a(BannerExpandDialog bannerExpandDialog) {
        BannerExpandDialog bannerExpandDialog2 = bannerExpandDialog;
        try {
            int i5 = c.m().c().getResources().getConfiguration().orientation;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("orientation", i5 == 2 ? "landscape" : i5 == 1 ? "portrait" : "undefined");
            jSONObject.put("locked", "true");
            HashMap i6 = ab.i(c.m().c());
            int intValue = ((Integer) i6.get("width")).intValue();
            int intValue2 = ((Integer) i6.get("height")).intValue();
            HashMap hashMap = new HashMap();
            hashMap.put(MRAIDCommunicatorUtil.KEY_PLACEMENTTYPE, MRAIDCommunicatorUtil.PLACEMENT_INTERSTITIAL);
            hashMap.put(MRAIDCommunicatorUtil.KEY_STATE, MRAIDCommunicatorUtil.STATES_EXPANDED);
            hashMap.put(MRAIDCommunicatorUtil.KEY_VIEWABLE, "true");
            hashMap.put(MRAIDCommunicatorUtil.KEY_CURRENTORIENTATION, jSONObject);
            int[] iArr = new int[2];
            bannerExpandDialog2.f10030e.getLocationInWindow(iArr);
            com.mbridge.msdk.mbsignalcommon.mraid.a a5 = com.mbridge.msdk.mbsignalcommon.mraid.a.a();
            WindVaneWebView windVaneWebView = bannerExpandDialog2.f10030e;
            a5.a(windVaneWebView, (float) iArr[0], (float) iArr[1], (float) windVaneWebView.getWidth(), (float) bannerExpandDialog2.f10030e.getHeight());
            com.mbridge.msdk.mbsignalcommon.mraid.a a6 = com.mbridge.msdk.mbsignalcommon.mraid.a.a();
            WindVaneWebView windVaneWebView2 = bannerExpandDialog2.f10030e;
            a6.b(windVaneWebView2, (float) iArr[0], (float) iArr[1], (float) windVaneWebView2.getWidth(), (float) bannerExpandDialog2.f10030e.getHeight());
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(bannerExpandDialog2.f10030e, (float) ab.j(c.m().c()), (float) ab.h(c.m().c()));
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().c(bannerExpandDialog2.f10030e, (float) intValue, (float) intValue2);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a((WebView) bannerExpandDialog2.f10030e, (Map<String, Object>) hashMap);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(bannerExpandDialog2.f10030e);
        } catch (Throwable th) {
            af.b("BannerExpandDialog", "notifyMraid", th);
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        if (getWindow() != null) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            getWindow().setAttributes(attributes);
            getWindow().getDecorView().setSystemUiVisibility(4615);
        }
    }
}
