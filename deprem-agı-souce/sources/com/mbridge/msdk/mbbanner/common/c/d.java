package com.mbridge.msdk.mbbanner.common.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.k;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.mbbanner.common.b.c;
import com.mbridge.msdk.mbbanner.common.b.e;
import com.mbridge.msdk.mbbanner.common.util.BannerUtils;
import com.mbridge.msdk.mbbanner.view.MBBannerWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.out.MBBannerView;
import com.mbridge.msdk.widget.FeedBackButton;
import com.mbridge.msdk.widget.MBAdChoice;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import u1.a;
import u1.b;

public class d {
    /* access modifiers changed from: private */

    /* renamed from: A  reason: collision with root package name */
    public b f9976A;
    /* access modifiers changed from: private */

    /* renamed from: B  reason: collision with root package name */
    public a f9977B;

    /* renamed from: C  reason: collision with root package name */
    private final Handler f9978C = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                try {
                    if (d.this.f9976A != null) {
                        d dVar = d.this;
                        a unused = dVar.f9977B = a.a(dVar.f9976A);
                        if (d.this.f9977B != null) {
                            d.this.f9977B.c();
                            d.this.f9977B.b();
                        }
                    }
                } catch (Throwable th) {
                    af.a("BannerShowManager", th.getMessage());
                }
            }
        }
    };

    /* renamed from: D  reason: collision with root package name */
    private final com.mbridge.msdk.foundation.same.e.a f9979D = new com.mbridge.msdk.foundation.same.e.a() {
        public final void cancelTask() {
        }

        public final void pauseTask(boolean z4) {
        }

        public final void runTask() {
            com.mbridge.msdk.foundation.c.b bVar = new com.mbridge.msdk.foundation.c.b(880045);
            bVar.b(d.this.f9986b.getLocalRequestId());
            d.this.a(bVar);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: E  reason: collision with root package name */
    public float f9980E;
    /* access modifiers changed from: private */

    /* renamed from: F  reason: collision with root package name */
    public float f9981F;

    /* renamed from: G  reason: collision with root package name */
    private final View.OnClickListener f9982G = new View.OnClickListener() {
        public final void onClick(View view) {
            d dVar = d.this;
            if (dVar.f9988d) {
                int unused = dVar.f10004t = 1;
                d.c(d.this);
            }
        }
    };

    /* renamed from: H  reason: collision with root package name */
    private com.mbridge.msdk.mbbanner.common.b.a f9983H = new com.mbridge.msdk.mbbanner.common.b.a() {
        public final void a(int i5) {
            if (i5 == 2) {
                d.d(d.this);
            } else {
                d.this.g();
            }
        }

        public final void b(int i5) {
            if (i5 == 1) {
                d.this.e();
                d.this.a("", 1);
                return;
            }
            d.this.d();
        }

        public final void a(String str) {
            int unused = d.this.f10004t = 2;
            d.c(d.this);
        }

        public final void a() {
            int unused = d.this.f10004t = 2;
            d.c(d.this);
        }

        public final void a(CampaignEx campaignEx) {
            d.this.a(campaignEx, false, "");
        }

        public final void a(boolean z4) {
            d dVar = d.this;
            if (dVar.f9985a != null) {
                boolean unused = dVar.f10001q = z4;
                if (z4) {
                    d.this.f9985a.c();
                } else {
                    d.this.f9985a.d();
                }
            }
        }

        public final void a(boolean z4, String str) {
            try {
                if (d.this.f9985a == null) {
                    return;
                }
                if (TextUtils.isEmpty(str)) {
                    d.this.f9985a.a();
                    d.this.f9985a.b();
                    return;
                }
                CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(CampaignEx.campaignToJsonObject(d.this.f9986b));
                parseCampaignWithBackData.setClickURL(str);
                d.this.a(parseCampaignWithBackData, z4, str);
            } catch (Exception e5) {
                af.b("BannerShowManager", e5.getMessage());
            }
        }
    };

    /* renamed from: I  reason: collision with root package name */
    private com.mbridge.msdk.mbsignalcommon.b.b f9984I = new com.mbridge.msdk.mbsignalcommon.b.b() {
        public final void a(WebView webView, String str) {
            boolean unused = d.this.f9998n = true;
            af.b("BannerCallJS", "fireOnJSBridgeConnected");
            g.a().a(webView);
            boolean unused2 = d.this.f10000p = true;
            CampaignEx campaignEx = d.this.f9986b;
            if (campaignEx != null && !campaignEx.isHasMBTplMark()) {
                d.this.e();
                d.this.a("", 1);
            }
        }

        public final void a(WebView webView, int i5, String str, String str2) {
            com.mbridge.msdk.foundation.c.b bVar = new com.mbridge.msdk.foundation.c.b(880000);
            bVar.a(i5 + " WebView receive error: " + i5 + "  message : " + str);
            bVar.b(d.this.f10003s);
            d.this.a(bVar);
            d.this.a(str, 2);
        }

        public final void a(WebView webView) {
            d.this.d();
        }
    };

    /* renamed from: a  reason: collision with root package name */
    protected c f9985a;

    /* renamed from: b  reason: collision with root package name */
    protected CampaignEx f9986b;

    /* renamed from: c  reason: collision with root package name */
    protected final MBBannerView f9987c;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f9988d;

    /* renamed from: e  reason: collision with root package name */
    protected final String f9989e;

    /* renamed from: f  reason: collision with root package name */
    com.mbridge.msdk.click.a f9990f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f9991g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public ImageView f9992h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public MBBannerWebView f9993i;

    /* renamed from: j  reason: collision with root package name */
    private ImageView f9994j;

    /* renamed from: k  reason: collision with root package name */
    private ImageView f9995k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f9996l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f9997m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public boolean f9998n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f9999o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public boolean f10000p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public boolean f10001q;

    /* renamed from: r  reason: collision with root package name */
    private final String f10002r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public String f10003s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public int f10004t = -1;

    /* renamed from: u  reason: collision with root package name */
    private List<CampaignEx> f10005u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public int f10006v = 1;

    /* renamed from: w  reason: collision with root package name */
    private int f10007w = 1;

    /* renamed from: x  reason: collision with root package name */
    private int f10008x;

    /* renamed from: y  reason: collision with root package name */
    private final long f10009y = 15000;

    /* renamed from: z  reason: collision with root package name */
    private com.mbridge.msdk.mbbanner.common.communication.a f10010z;

    public d(MBBannerView mBBannerView, c cVar, String str, String str2, boolean z4, k kVar) {
        this.f9991g = z4;
        this.f9987c = mBBannerView;
        this.f9989e = str2;
        this.f10002r = str;
        this.f9985a = new e(cVar, kVar);
    }

    /* access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void d() {
        if (this.f9987c != null) {
            MBBannerWebView mBBannerWebView = this.f9993i;
            if (!(mBBannerWebView == null || mBBannerWebView.getParent() == null)) {
                this.f9987c.removeView(this.f9993i);
            }
            if (this.f9992h == null) {
                ImageView imageView = new ImageView(com.mbridge.msdk.foundation.controller.c.m().c());
                this.f9992h = imageView;
                imageView.setOnTouchListener(new View.OnTouchListener() {
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        float unused = d.this.f9980E = motionEvent.getRawX();
                        float unused2 = d.this.f9981F = motionEvent.getRawY();
                        af.b("BannerShowManager", d.this.f9980E + "  " + d.this.f9981F);
                        return false;
                    }
                });
                this.f9992h.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        d.this.a(BannerUtils.managerCampaignEX(com.mbridge.msdk.mbsignalcommon.communication.d.a(d.this.f9980E, d.this.f9981F), d.this.f9986b), false, "");
                    }
                });
            }
            String imageUrl = this.f9986b.getImageUrl();
            if (!TextUtils.isEmpty(imageUrl)) {
                com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(imageUrl, new com.mbridge.msdk.foundation.same.c.c() {
                    public final void onFailedLoad(String str, String str2) {
                        com.mbridge.msdk.foundation.c.b bVar = new com.mbridge.msdk.foundation.c.b(880039);
                        bVar.b(d.this.f10003s);
                        d.this.a(bVar);
                    }

                    public final void onSuccessLoad(Bitmap bitmap, String str) {
                        if (d.this.f9992h != null) {
                            d.this.f9992h.setImageBitmap(bitmap);
                        }
                        boolean unused = d.this.f9998n = true;
                        d.m(d.this);
                        d.this.g();
                        d.this.h();
                        d dVar = d.this;
                        if (!dVar.f9988d) {
                            dVar.e();
                        }
                    }
                });
                return;
            }
            com.mbridge.msdk.foundation.c.b bVar = new com.mbridge.msdk.foundation.c.b(880047);
            bVar.b(this.f10003s);
            a(bVar);
            return;
        }
        com.mbridge.msdk.foundation.c.b bVar2 = new com.mbridge.msdk.foundation.c.b(880046);
        bVar2.b(this.f10003s);
        a(bVar2);
    }

    static /* synthetic */ void m(d dVar) {
        if (dVar.f9992h != null) {
            MBBannerWebView mBBannerWebView = dVar.f9993i;
            if (mBBannerWebView != null) {
                mBBannerWebView.setVisibility(8);
            }
            if (dVar.f9992h.getVisibility() != 0) {
                dVar.f9992h.setVisibility(0);
            }
            dVar.f10007w = 2;
            if (dVar.f9987c != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(10);
                dVar.f9992h.setScaleType(ImageView.ScaleType.FIT_XY);
                if (dVar.f9992h.getParent() == null) {
                    dVar.f9987c.addView(dVar.f9992h, layoutParams);
                }
                dVar.d(true);
            }
        }
    }

    public void a(CampaignEx campaignEx, boolean z4, String str) {
    }

    private boolean c() {
        String a5 = a(this.f9986b);
        if (TextUtils.isEmpty(a5)) {
            return false;
        }
        if (this.f9987c != null) {
            if (this.f9993i == null) {
                try {
                    MBBannerWebView mBBannerWebView = new MBBannerWebView(com.mbridge.msdk.foundation.controller.c.m().c());
                    this.f9993i = mBBannerWebView;
                    mBBannerWebView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                    this.f9993i.setWebViewClient(new com.mbridge.msdk.mbbanner.view.a(this.f9989e, this.f10005u, this.f9983H));
                } catch (Throwable unused) {
                    a(com.mbridge.msdk.foundation.c.a.a(880029), 1);
                    return false;
                }
            }
            ImageView imageView = this.f9992h;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            if (this.f9993i.getVisibility() != 0) {
                this.f9993i.setVisibility(0);
            }
            if (this.f9993i.getParent() == null) {
                this.f9987c.addView(this.f9993i);
                d(this.f9986b.isMraid());
            }
            if (this.f9986b.isMraid()) {
                h();
            }
            g();
            com.mbridge.msdk.mbbanner.common.communication.a aVar = new com.mbridge.msdk.mbbanner.common.communication.a(this.f9987c.getContext(), this.f10002r, this.f9989e);
            this.f10010z = aVar;
            aVar.a(this.f10005u);
            this.f10010z.a(this.f9983H);
            this.f10010z.a(this.f10008x);
            this.f9993i.setWebViewListener(this.f9984I);
            this.f9993i.setObject(this.f10010z);
            this.f9993i.loadUrl(a5);
            MBBannerWebView mBBannerWebView2 = this.f9993i;
            if (mBBannerWebView2 != null) {
                mBBannerWebView2.postDelayed(new Runnable() {
                    public final void run() {
                        String str;
                        try {
                            if (d.this.f9993i != null) {
                                if (d.this.f10006v == 2) {
                                    str = "false";
                                } else {
                                    str = "true";
                                }
                                MBBannerWebView h5 = d.this.f9993i;
                                h5.evaluateJavascript("(function() {\n    var videos = document.getElementsByTagName('video');\n    for (var i = 0; i < videos.length; i++) {\n    videos[i].muted = " + str + ";\n    }\n    var audios = document.getElementsByTagName('audio');\n    for (var i = 0; i < audios.length; i++) {\n    audios[i].muted = " + str + ";\n    }\n    })()", (ValueCallback) null);
                            }
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                    }
                }, 1000);
            }
        } else {
            a(com.mbridge.msdk.foundation.c.a.a(880046), 2);
            com.mbridge.msdk.foundation.c.b bVar = new com.mbridge.msdk.foundation.c.b(880046);
            bVar.b(this.f10003s);
            a(bVar);
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0437  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0129 A[Catch:{ all -> 0x012c }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0131 A[Catch:{ all -> 0x012c }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0205 A[Catch:{ all -> 0x021b }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0249  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e() {
        /*
            r24 = this;
            r1 = r24
            java.lang.String r2 = "true"
            boolean r0 = r1.f9998n
            r3 = 1
            if (r0 == 0) goto L_0x0047
            boolean r0 = r1.f9999o
            if (r0 != 0) goto L_0x0047
            com.mbridge.msdk.mbbanner.common.b.c r0 = r1.f9985a
            if (r0 == 0) goto L_0x0047
            r1.f9999o = r3
            android.os.Handler r0 = r1.f9978C
            com.mbridge.msdk.foundation.same.e.a r4 = r1.f9979D
            r0.removeCallbacks(r4)
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.f9986b
            if (r0 == 0) goto L_0x0047
            boolean r0 = r0.isCallbacked()
            if (r0 != 0) goto L_0x0047
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.f9986b
            r0.setCallbacked(r3)
            com.mbridge.msdk.mbbanner.common.b.c r0 = r1.f9985a
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r4 = r1.f10005u
            r0.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r4)
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()
            android.content.Context r0 = r0.c()
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r1.f9986b
            int r4 = r4.getMaitve()
            com.mbridge.msdk.foundation.entity.CampaignEx r5 = r1.f9986b
            java.lang.String r5 = r5.getMaitve_src()
            com.mbridge.msdk.click.c.a((android.content.Context) r0, (int) r4, (java.lang.String) r5)
        L_0x0047:
            boolean r0 = r1.f9998n
            if (r0 == 0) goto L_0x043d
            boolean r0 = r1.f9996l
            if (r0 == 0) goto L_0x043d
            boolean r0 = r1.f9997m
            if (r0 == 0) goto L_0x043d
            boolean r0 = r1.f9999o
            if (r0 == 0) goto L_0x043d
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.f9986b
            if (r0 == 0) goto L_0x043d
            boolean r0 = r1.f()
            if (r0 != 0) goto L_0x043d
            com.mbridge.msdk.out.MBBannerView r0 = r1.f9987c
            r4 = 0
            if (r0 != 0) goto L_0x0067
            goto L_0x007f
        L_0x0067:
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.f9986b
            if (r0 == 0) goto L_0x0070
            int r0 = r0.getImpReportType()
            goto L_0x0071
        L_0x0070:
            r0 = r4
        L_0x0071:
            com.mbridge.msdk.out.MBBannerView r5 = r1.f9987c
            boolean r0 = com.mbridge.msdk.foundation.tools.as.a((android.view.View) r5, (int) r0)
            if (r0 != 0) goto L_0x007f
            boolean r0 = r1.f10001q
            if (r0 != 0) goto L_0x007f
            r5 = r3
            goto L_0x0080
        L_0x007f:
            r5 = r4
        L_0x0080:
            r6 = 1000(0x3e8, double:4.94E-321)
            if (r5 != 0) goto L_0x0090
            com.mbridge.msdk.out.MBBannerView r0 = r1.f9987c
            if (r0 == 0) goto L_0x0090
            com.mbridge.msdk.mbbanner.common.c.d$13 r8 = new com.mbridge.msdk.mbbanner.common.c.d$13
            r8.<init>()
            r0.postDelayed(r8, r6)
        L_0x0090:
            boolean r0 = r1.f10000p
            java.lang.String r9 = "BannerShowManager"
            r10 = 2
            if (r0 == 0) goto L_0x022a
            if (r5 == 0) goto L_0x022a
            java.lang.String r0 = "onBannerWebViewShow && transInfoToMraid"
            com.mbridge.msdk.foundation.tools.af.b(r9, r0)
            int[] r11 = new int[r10]
            com.mbridge.msdk.out.MBBannerView r0 = r1.f9987c
            r0.getLocationInWindow(r11)
            com.mbridge.msdk.mbbanner.view.MBBannerWebView r0 = r1.f9993i
            r12 = r11[r4]
            float r12 = (float) r12
            r13 = r11[r3]
            float r13 = (float) r13
            java.lang.String r14 = "BannerCallJS"
            java.lang.String r15 = "fireOnBannerWebViewShow"
            com.mbridge.msdk.foundation.tools.af.b(r14, r15)
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ all -> 0x00f1 }
            r6.<init>()     // Catch:{ all -> 0x00f1 }
            java.lang.String r7 = "startX"
            r16 = r9
            double r8 = (double) r12
            r6.put(r7, r8)     // Catch:{ all -> 0x00ef }
            java.lang.String r7 = "startY"
            double r8 = (double) r13     // Catch:{ all -> 0x00ef }
            r6.put(r7, r8)     // Catch:{ all -> 0x00ef }
            java.lang.String r7 = "scale"
            com.mbridge.msdk.foundation.controller.c r8 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ all -> 0x00ef }
            android.content.Context r8 = r8.c()     // Catch:{ all -> 0x00ef }
            float r8 = com.mbridge.msdk.foundation.tools.ak.d((android.content.Context) r8)     // Catch:{ all -> 0x00ef }
            double r8 = (double) r8     // Catch:{ all -> 0x00ef }
            r6.put(r7, r8)     // Catch:{ all -> 0x00ef }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00ef }
            byte[] r6 = r6.getBytes()     // Catch:{ all -> 0x00ef }
            java.lang.String r6 = android.util.Base64.encodeToString(r6, r10)     // Catch:{ all -> 0x00ef }
            com.mbridge.msdk.mbsignalcommon.windvane.g r7 = com.mbridge.msdk.mbsignalcommon.windvane.g.a()     // Catch:{ all -> 0x00ef }
            java.lang.String r8 = "webviewshow"
            r7.a((android.webkit.WebView) r0, (java.lang.String) r8, (java.lang.String) r6)     // Catch:{ all -> 0x00ef }
            goto L_0x00f7
        L_0x00ef:
            r0 = move-exception
            goto L_0x00f4
        L_0x00f1:
            r0 = move-exception
            r16 = r9
        L_0x00f4:
            com.mbridge.msdk.foundation.tools.af.b(r14, r15, r0)
        L_0x00f7:
            com.mbridge.msdk.mbbanner.view.MBBannerWebView r0 = r1.f9993i
            r6 = r11[r4]
            r7 = r11[r3]
            com.mbridge.msdk.out.MBBannerView r8 = r1.f9987c
            int r8 = r8.getWidth()
            com.mbridge.msdk.out.MBBannerView r9 = r1.f9987c
            int r9 = r9.getHeight()
            java.lang.String r11 = "transInfoForMraid"
            com.mbridge.msdk.foundation.tools.af.b(r14, r11)
            com.mbridge.msdk.foundation.controller.c r12 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ all -> 0x012c }
            android.content.Context r12 = r12.c()     // Catch:{ all -> 0x012c }
            android.content.res.Resources r12 = r12.getResources()     // Catch:{ all -> 0x012c }
            android.content.res.Configuration r12 = r12.getConfiguration()     // Catch:{ all -> 0x012c }
            int r12 = r12.orientation     // Catch:{ all -> 0x012c }
            org.json.JSONObject r13 = new org.json.JSONObject     // Catch:{ all -> 0x012c }
            r13.<init>()     // Catch:{ all -> 0x012c }
            java.lang.String r15 = "orientation"
            if (r12 != r10) goto L_0x0131
            java.lang.String r12 = "landscape"
            goto L_0x0138
        L_0x012c:
            r0 = move-exception
            r23 = r5
            goto L_0x01dc
        L_0x0131:
            if (r12 != r3) goto L_0x0136
            java.lang.String r12 = "portrait"
            goto L_0x0138
        L_0x0136:
            java.lang.String r12 = "undefined"
        L_0x0138:
            r13.put(r15, r12)     // Catch:{ all -> 0x012c }
            java.lang.String r12 = "locked"
            r13.put(r12, r2)     // Catch:{ all -> 0x012c }
            com.mbridge.msdk.foundation.controller.c r12 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ all -> 0x012c }
            android.content.Context r12 = r12.c()     // Catch:{ all -> 0x012c }
            int r12 = com.mbridge.msdk.foundation.tools.ab.j(r12)     // Catch:{ all -> 0x012c }
            float r12 = (float) r12     // Catch:{ all -> 0x012c }
            com.mbridge.msdk.foundation.controller.c r15 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ all -> 0x012c }
            android.content.Context r15 = r15.c()     // Catch:{ all -> 0x012c }
            int r15 = com.mbridge.msdk.foundation.tools.ab.h(r15)     // Catch:{ all -> 0x012c }
            float r15 = (float) r15     // Catch:{ all -> 0x012c }
            com.mbridge.msdk.foundation.controller.c r17 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ all -> 0x012c }
            android.content.Context r17 = r17.c()     // Catch:{ all -> 0x012c }
            java.util.HashMap r10 = com.mbridge.msdk.foundation.tools.ab.i(r17)     // Catch:{ all -> 0x012c }
            java.lang.String r3 = "width"
            java.lang.Object r3 = r10.get(r3)     // Catch:{ all -> 0x012c }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ all -> 0x012c }
            int r3 = r3.intValue()     // Catch:{ all -> 0x012c }
            java.lang.String r4 = "height"
            java.lang.Object r4 = r10.get(r4)     // Catch:{ all -> 0x012c }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ all -> 0x012c }
            int r4 = r4.intValue()     // Catch:{ all -> 0x012c }
            java.util.HashMap r10 = new java.util.HashMap     // Catch:{ all -> 0x012c }
            r10.<init>()     // Catch:{ all -> 0x012c }
            r18 = r0
            java.lang.String r0 = "placementType"
            r23 = r5
            java.lang.String r5 = "inline"
            r10.put(r0, r5)     // Catch:{ all -> 0x01db }
            java.lang.String r0 = "state"
            java.lang.String r5 = "default"
            r10.put(r0, r5)     // Catch:{ all -> 0x01db }
            java.lang.String r0 = "viewable"
            r10.put(r0, r2)     // Catch:{ all -> 0x01db }
            java.lang.String r0 = "currentAppOrientation"
            r10.put(r0, r13)     // Catch:{ all -> 0x01db }
            com.mbridge.msdk.mbsignalcommon.mraid.a r17 = com.mbridge.msdk.mbsignalcommon.mraid.a.a()     // Catch:{ all -> 0x01db }
            float r0 = (float) r6     // Catch:{ all -> 0x01db }
            float r2 = (float) r7     // Catch:{ all -> 0x01db }
            float r5 = (float) r8     // Catch:{ all -> 0x01db }
            float r6 = (float) r9     // Catch:{ all -> 0x01db }
            r19 = r0
            r20 = r2
            r21 = r5
            r22 = r6
            r17.a(r18, r19, r20, r21, r22)     // Catch:{ all -> 0x01db }
            com.mbridge.msdk.mbsignalcommon.mraid.a r17 = com.mbridge.msdk.mbsignalcommon.mraid.a.a()     // Catch:{ all -> 0x01db }
            r17.b(r18, r19, r20, r21, r22)     // Catch:{ all -> 0x01db }
            r0 = r18
            com.mbridge.msdk.mbsignalcommon.mraid.a r2 = com.mbridge.msdk.mbsignalcommon.mraid.a.a()     // Catch:{ all -> 0x01db }
            r2.b(r0, r12, r15)     // Catch:{ all -> 0x01db }
            com.mbridge.msdk.mbsignalcommon.mraid.a r2 = com.mbridge.msdk.mbsignalcommon.mraid.a.a()     // Catch:{ all -> 0x01db }
            float r3 = (float) r3     // Catch:{ all -> 0x01db }
            float r4 = (float) r4     // Catch:{ all -> 0x01db }
            r2.c(r0, r3, r4)     // Catch:{ all -> 0x01db }
            com.mbridge.msdk.mbsignalcommon.mraid.a r2 = com.mbridge.msdk.mbsignalcommon.mraid.a.a()     // Catch:{ all -> 0x01db }
            r2.a((android.webkit.WebView) r0, (java.util.Map<java.lang.String, java.lang.Object>) r10)     // Catch:{ all -> 0x01db }
            com.mbridge.msdk.mbsignalcommon.mraid.a r2 = com.mbridge.msdk.mbsignalcommon.mraid.a.a()     // Catch:{ all -> 0x01db }
            r2.a(r0)     // Catch:{ all -> 0x01db }
        L_0x01d9:
            r2 = 0
            goto L_0x01e0
        L_0x01db:
            r0 = move-exception
        L_0x01dc:
            com.mbridge.msdk.foundation.tools.af.b(r14, r11, r0)
            goto L_0x01d9
        L_0x01e0:
            r1.f10000p = r2
            r2 = 1
            r1.f10007w = r2
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.f9986b
            java.lang.String r0 = r0.getImageUrl()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0201
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()
            android.content.Context r0 = r0.c()
            com.mbridge.msdk.foundation.same.c.b.a((android.content.Context) r0)
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.f9986b
            r0.getImageUrl()
        L_0x0201:
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.f9986b     // Catch:{ all -> 0x021b }
            if (r0 == 0) goto L_0x021d
            java.lang.String r2 = r1.f9989e     // Catch:{ all -> 0x021b }
            java.lang.String r0 = r0.getLocalRequestId()     // Catch:{ all -> 0x021b }
            com.mbridge.msdk.foundation.same.report.d.c r0 = com.mbridge.msdk.mbbanner.common.d.a.a(r2, r0)     // Catch:{ all -> 0x021b }
            int r2 = r1.f10007w     // Catch:{ all -> 0x021b }
            r0.g((int) r2)     // Catch:{ all -> 0x021b }
            java.lang.String r2 = "2000133"
            r3 = 0
            com.mbridge.msdk.mbbanner.common.d.a.a(r2, r0, r3)     // Catch:{ all -> 0x021b }
            goto L_0x021d
        L_0x021b:
            r0 = move-exception
            goto L_0x0220
        L_0x021d:
            r2 = r16
            goto L_0x022d
        L_0x0220:
            java.lang.String r0 = r0.getMessage()
            r2 = r16
            com.mbridge.msdk.foundation.tools.af.b(r2, r0)
            goto L_0x022d
        L_0x022a:
            r23 = r5
            r2 = r9
        L_0x022d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "showSuccessed:"
            r0.append(r3)
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = r1.f9986b
            java.lang.String r3 = r3.getId()
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.mbridge.msdk.foundation.tools.af.b(r2, r0)
            if (r23 == 0) goto L_0x0437
            android.widget.ImageView r0 = r1.f9992h
            java.lang.String r2 = "banner"
            if (r0 == 0) goto L_0x0295
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x0295
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.f9986b
            if (r0 == 0) goto L_0x0292
            if (r0 == 0) goto L_0x0282
            com.mbridge.msdk.foundation.controller.c r3 = com.mbridge.msdk.foundation.controller.c.m()
            android.content.Context r3 = r3.c()
            java.lang.String r4 = r1.f9989e
            r1.c(r0, r3, r4)
            com.mbridge.msdk.foundation.controller.c r3 = com.mbridge.msdk.foundation.controller.c.m()
            android.content.Context r3 = r3.c()
            java.lang.String r4 = r1.f9989e
            r1.b(r0, r3, r4)
            com.mbridge.msdk.foundation.controller.c r3 = com.mbridge.msdk.foundation.controller.c.m()
            android.content.Context r3 = r3.c()
            java.lang.String r4 = r1.f9989e
            r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r0, (android.content.Context) r3, (java.lang.String) r4)
        L_0x0282:
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.f9986b
            r3 = 1
            r0.setReport(r3)
            r3 = 2
            r1.f10007w = r3
            java.lang.String r0 = r1.f9989e
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = r1.f9986b
            com.mbridge.msdk.foundation.same.a.b.a((java.lang.String) r0, (com.mbridge.msdk.foundation.entity.CampaignEx) r3, (java.lang.String) r2)
        L_0x0292:
            r2 = 1
            goto L_0x0329
        L_0x0295:
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r1.f10005u
            if (r0 == 0) goto L_0x0292
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0292
            r0 = 0
            r3 = 0
            r4 = 0
        L_0x02a2:
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r5 = r1.f10005u
            int r5 = r5.size()
            if (r3 >= r5) goto L_0x02fb
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r5 = r1.f10005u
            java.lang.Object r5 = r5.get(r3)
            com.mbridge.msdk.foundation.entity.CampaignEx r5 = (com.mbridge.msdk.foundation.entity.CampaignEx) r5
            boolean r5 = r5.isHasMBTplMark()
            if (r5 != 0) goto L_0x02f8
            if (r3 == 0) goto L_0x02c8
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r5 = r1.f10005u
            java.lang.Object r5 = r5.get(r3)
            com.mbridge.msdk.foundation.entity.CampaignEx r5 = (com.mbridge.msdk.foundation.entity.CampaignEx) r5
            boolean r5 = r5.isReport()
            if (r5 != 0) goto L_0x02f8
        L_0x02c8:
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r1.f10005u
            java.lang.Object r0 = r0.get(r3)
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0
            com.mbridge.msdk.foundation.controller.c r4 = com.mbridge.msdk.foundation.controller.c.m()
            android.content.Context r4 = r4.c()
            java.lang.String r5 = r1.f9989e
            r1.c(r0, r4, r5)
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r1.f10005u
            java.lang.Object r0 = r0.get(r3)
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0
            r4 = 1
            r0.setReport(r4)
            java.lang.String r0 = r1.f9989e
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r4 = r1.f10005u
            java.lang.Object r4 = r4.get(r3)
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = (com.mbridge.msdk.foundation.entity.CampaignEx) r4
            com.mbridge.msdk.foundation.same.a.b.a((java.lang.String) r0, (com.mbridge.msdk.foundation.entity.CampaignEx) r4, (java.lang.String) r2)
            r4 = r3
            r0 = 1
        L_0x02f8:
            int r3 = r3 + 1
            goto L_0x02a2
        L_0x02fb:
            if (r0 == 0) goto L_0x0292
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r1.f10005u
            java.lang.Object r0 = r0.get(r4)
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0
            com.mbridge.msdk.foundation.controller.c r2 = com.mbridge.msdk.foundation.controller.c.m()
            android.content.Context r2 = r2.c()
            java.lang.String r3 = r1.f9989e
            r1.b(r0, r2, r3)
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r1.f10005u
            java.lang.Object r0 = r0.get(r4)
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0
            com.mbridge.msdk.foundation.controller.c r2 = com.mbridge.msdk.foundation.controller.c.m()
            android.content.Context r2 = r2.c()
            java.lang.String r3 = r1.f9989e
            r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r0, (android.content.Context) r2, (java.lang.String) r3)
            goto L_0x0292
        L_0x0329:
            r1.f9988d = r2
            com.mbridge.msdk.mbbanner.common.b.c r0 = r1.f9985a
            if (r0 == 0) goto L_0x0334
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r1.f9986b
            r0.a((com.mbridge.msdk.foundation.entity.CampaignEx) r2)
        L_0x0334:
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.f9986b     // Catch:{ Exception -> 0x03af }
            if (r0 == 0) goto L_0x03d7
            boolean r0 = r0.isActiveOm()     // Catch:{ Exception -> 0x03af }
            if (r0 == 0) goto L_0x03d7
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x03af }
            android.content.Context r0 = r0.c()     // Catch:{ Exception -> 0x03af }
            com.mbridge.msdk.mbbanner.view.MBBannerWebView r2 = r1.f9993i     // Catch:{ Exception -> 0x03af }
            java.lang.String r3 = r2.getUrl()     // Catch:{ Exception -> 0x03af }
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r1.f9986b     // Catch:{ Exception -> 0x03af }
            u1.b r0 = com.mbridge.msdk.a.b.a(r0, r2, r3, r4)     // Catch:{ Exception -> 0x03af }
            r1.f9976A = r0     // Catch:{ Exception -> 0x03af }
            if (r0 == 0) goto L_0x0386
            com.mbridge.msdk.mbbanner.view.MBBannerWebView r2 = r1.f9993i     // Catch:{ Exception -> 0x0368 }
            r0.d(r2)     // Catch:{ Exception -> 0x0368 }
            android.widget.ImageView r0 = r1.f9994j     // Catch:{ Exception -> 0x0368 }
            if (r0 == 0) goto L_0x036a
            u1.b r2 = r1.f9976A     // Catch:{ Exception -> 0x0368 }
            u1.h r3 = u1.h.CLOSE_AD     // Catch:{ Exception -> 0x0368 }
            r4 = 0
            r2.a(r0, r3, r4)     // Catch:{ Exception -> 0x0368 }
            goto L_0x036a
        L_0x0368:
            r0 = move-exception
            goto L_0x037c
        L_0x036a:
            android.widget.ImageView r0 = r1.f9992h     // Catch:{ Exception -> 0x0368 }
            if (r0 == 0) goto L_0x0376
            u1.b r2 = r1.f9976A     // Catch:{ Exception -> 0x0368 }
            u1.h r3 = u1.h.OTHER     // Catch:{ Exception -> 0x0368 }
            r4 = 0
            r2.a(r0, r3, r4)     // Catch:{ Exception -> 0x0368 }
        L_0x0376:
            u1.b r0 = r1.f9976A     // Catch:{ Exception -> 0x0368 }
            r0.g()     // Catch:{ Exception -> 0x0368 }
            goto L_0x03d7
        L_0x037c:
            java.lang.String r2 = "OMSDK"
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x03af }
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r2, (java.lang.String) r0)     // Catch:{ Exception -> 0x03af }
            goto L_0x03d7
        L_0x0386:
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.f9986b     // Catch:{ Exception -> 0x03af }
            if (r0 == 0) goto L_0x03d7
            java.lang.String r3 = r0.getRequestId()     // Catch:{ Exception -> 0x03af }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.f9986b     // Catch:{ Exception -> 0x03af }
            java.lang.String r5 = r0.getId()     // Catch:{ Exception -> 0x03af }
            java.lang.String r6 = r1.f9989e     // Catch:{ Exception -> 0x03af }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.f9986b     // Catch:{ Exception -> 0x03af }
            java.lang.String r4 = r0.getRequestIdNotice()     // Catch:{ Exception -> 0x03af }
            com.mbridge.msdk.foundation.same.report.h r2 = new com.mbridge.msdk.foundation.same.report.h     // Catch:{ Exception -> 0x03af }
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x03af }
            android.content.Context r0 = r0.c()     // Catch:{ Exception -> 0x03af }
            r2.<init>(r0)     // Catch:{ Exception -> 0x03af }
            java.lang.String r7 = "fetch OM failed, context null"
            r2.a((java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7)     // Catch:{ Exception -> 0x03af }
            goto L_0x03d7
        L_0x03af:
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.f9986b
            if (r0 == 0) goto L_0x03d7
            java.lang.String r3 = r0.getRequestId()
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.f9986b
            java.lang.String r5 = r0.getId()
            java.lang.String r6 = r1.f9989e
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.f9986b
            java.lang.String r4 = r0.getRequestIdNotice()
            com.mbridge.msdk.foundation.same.report.h r2 = new com.mbridge.msdk.foundation.same.report.h
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()
            android.content.Context r0 = r0.c()
            r2.<init>(r0)
            java.lang.String r7 = "fetch OM failed, context null"
            r2.a((java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7)
        L_0x03d7:
            android.os.Handler r0 = r1.f9978C
            r2 = 1000(0x3e8, double:4.94E-321)
            r4 = 1
            r0.sendEmptyMessageDelayed(r4, r2)
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()
            java.lang.String r2 = r1.f9989e
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = r1.f9986b
            int r3 = r3.getAdType()
            android.graphics.drawable.BitmapDrawable r0 = r0.a((java.lang.String) r2, (int) r3)
            if (r0 == 0) goto L_0x043d
            android.widget.ImageView r2 = r1.f9995k
            if (r2 != 0) goto L_0x0404
            android.widget.ImageView r2 = new android.widget.ImageView
            com.mbridge.msdk.foundation.controller.c r3 = com.mbridge.msdk.foundation.controller.c.m()
            android.content.Context r3 = r3.c()
            r2.<init>(r3)
            r1.f9995k = r2
        L_0x0404:
            android.widget.ImageView r2 = r1.f9995k
            int r2 = r2.getVisibility()
            if (r2 == 0) goto L_0x0412
            android.widget.ImageView r2 = r1.f9995k
            r3 = 0
            r2.setVisibility(r3)
        L_0x0412:
            android.widget.ImageView r2 = r1.f9995k
            com.mbridge.msdk.out.MBBannerView r3 = r1.f9987c
            android.content.res.Resources r3 = r3.getResources()
            android.util.DisplayMetrics r3 = r3.getDisplayMetrics()
            com.mbridge.msdk.foundation.tools.ak.a((android.widget.ImageView) r2, (android.graphics.drawable.BitmapDrawable) r0, (android.util.DisplayMetrics) r3)
            android.widget.ImageView r0 = r1.f9995k
            android.view.ViewParent r0 = r0.getParent()
            if (r0 != 0) goto L_0x043d
            com.mbridge.msdk.out.MBBannerView r0 = r1.f9987c
            android.widget.ImageView r2 = r1.f9995k
            android.view.ViewGroup$LayoutParams r3 = new android.view.ViewGroup$LayoutParams
            r4 = -1
            r3.<init>(r4, r4)
            r0.addView(r2, r3)
            goto L_0x043d
        L_0x0437:
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.f9986b
            r2 = 0
            r0.setReport(r2)
        L_0x043d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbbanner.common.c.d.e():void");
    }

    private synchronized boolean f() {
        boolean isReport;
        isReport = this.f9986b.isReport();
        if (!isReport) {
            this.f9986b.setReport(true);
        }
        return isReport;
    }

    /* access modifiers changed from: private */
    public void g() {
        ImageView imageView;
        if (this.f9991g && (imageView = this.f9994j) != null) {
            if (imageView.getVisibility() != 0) {
                this.f9994j.setVisibility(0);
                this.f9994j.setOnClickListener(this.f9982G);
            }
            if (this.f9994j.getParent() == null && this.f9987c != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 12.0f), ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 12.0f));
                layoutParams.addRule(11);
                layoutParams.addRule(10);
                this.f9987c.addView(this.f9994j, layoutParams);
            }
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        if (this.f9987c != null) {
            CampaignEx campaignEx = this.f9986b;
            if (campaignEx == null || campaignEx.getPrivacyButtonTemplateVisibility() == 1) {
                MBAdChoice mBAdChoice = new MBAdChoice(com.mbridge.msdk.foundation.controller.c.m().c());
                mBAdChoice.setCampaign(this.f9986b);
                mBAdChoice.setFeedbackDialogEventListener(new com.mbridge.msdk.foundation.d.a() {
                    public final void close() {
                        String str;
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                                jSONObject.put(NotificationCompat.CATEGORY_STATUS, 2);
                            }
                            str = jSONObject.toString();
                        } catch (Throwable th) {
                            af.b("BannerShowManager", th.getMessage(), th);
                            str = "";
                        }
                        g.a().a((WebView) d.this.f9993i, "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
                    }

                    public final void showed() {
                        String str;
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                                jSONObject.put(NotificationCompat.CATEGORY_STATUS, 1);
                            }
                            str = jSONObject.toString();
                        } catch (Throwable th) {
                            af.b("BannerShowManager", th.getMessage(), th);
                            str = "";
                        }
                        g.a().a((WebView) d.this.f9993i, "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
                    }

                    public final void summit(String str) {
                        String str2;
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                                jSONObject.put(NotificationCompat.CATEGORY_STATUS, 1);
                            }
                            str2 = jSONObject.toString();
                        } catch (Throwable th) {
                            af.b("BannerShowManager", th.getMessage(), th);
                            str2 = "";
                        }
                        g.a().a((WebView) d.this.f9993i, "onFeedbackAlertStatusNotify", Base64.encodeToString(str2.getBytes(), 2));
                    }
                });
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 6.0f), ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 6.0f));
                layoutParams.addRule(11);
                layoutParams.addRule(12);
                this.f9987c.addView(mBAdChoice, layoutParams);
            }
        }
    }

    private void i() {
        b bVar = this.f9976A;
        if (bVar != null) {
            bVar.c();
            this.f9976A = null;
            af.a("omsdk", " adSession.finish() ");
        }
    }

    public final void b(boolean z4) {
        this.f9996l = z4;
        e();
    }

    private void b(CampaignEx campaignEx, Context context, String str) {
        if (campaignEx != null) {
            try {
                if (!TextUtils.isEmpty(campaignEx.getOnlyImpressionURL())) {
                    Context context2 = context;
                    com.mbridge.msdk.click.a.a(context2, campaignEx, str, campaignEx.getOnlyImpressionURL(), false, true, com.mbridge.msdk.click.a.a.f8070h);
                }
            } catch (Throwable th) {
                af.b("BannerShowManager", th.getMessage());
            }
        }
    }

    public final void a(boolean z4, int i5) {
        this.f10008x = i5;
        if (i5 == 0) {
            k d5 = h.a().d(com.mbridge.msdk.foundation.controller.c.m().k(), this.f9989e);
            if (d5 != null) {
                z4 = d5.f() == 1;
            } else {
                return;
            }
        }
        this.f9991g = z4;
    }

    public final int b() {
        return this.f10007w;
    }

    public final void a(boolean z4) {
        this.f9991g = z4;
    }

    private String a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                String bannerUrl = campaignEx.getBannerUrl();
                if (TextUtils.isEmpty(bannerUrl)) {
                    bannerUrl = campaignEx.getBannerHtml();
                    File file = new File(bannerUrl);
                    if (file.exists() && file.isFile() && file.canRead()) {
                        return "file:////" + bannerUrl;
                    }
                }
                return bannerUrl;
            } catch (Throwable th) {
                af.b("BannerShowManager", th.getMessage());
            }
        }
        return "";
    }

    private void d(boolean z4) {
        if (this.f9987c != null) {
            FeedBackButton b5 = com.mbridge.msdk.foundation.d.b.a().b(this.f9989e);
            if (com.mbridge.msdk.foundation.d.b.a().b() && z4 && b5 != null) {
                ViewGroup viewGroup = (ViewGroup) b5.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(b5);
                }
                b5.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) b5.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new RelativeLayout.LayoutParams(com.mbridge.msdk.foundation.d.b.f8930b, com.mbridge.msdk.foundation.d.b.f8929a);
                }
                layoutParams.addRule(12);
                b5.setLayoutParams(layoutParams);
                this.f9987c.addView(b5);
            }
            com.mbridge.msdk.foundation.d.b.a().a(this.f9989e, (com.mbridge.msdk.foundation.d.a) new com.mbridge.msdk.foundation.d.a() {
                public final void close() {
                    String str;
                    d.this.f9987c.onResume();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                            jSONObject.put(NotificationCompat.CATEGORY_STATUS, 2);
                        }
                        str = jSONObject.toString();
                    } catch (Throwable th) {
                        af.b("BannerShowManager", th.getMessage(), th);
                        str = "";
                    }
                    g.a().a((WebView) d.this.f9993i, "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
                }

                public final void showed() {
                    String str;
                    d.this.f9987c.onPause();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                            jSONObject.put(NotificationCompat.CATEGORY_STATUS, 1);
                        }
                        str = jSONObject.toString();
                    } catch (Throwable th) {
                        af.b("BannerShowManager", th.getMessage(), th);
                        str = "";
                    }
                    g.a().a((WebView) d.this.f9993i, "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
                }

                public final void summit(String str) {
                    String str2;
                    d.this.f9987c.onResume();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                            jSONObject.put(NotificationCompat.CATEGORY_STATUS, 2);
                        }
                        str2 = jSONObject.toString();
                    } catch (Throwable th) {
                        af.b("BannerShowManager", th.getMessage(), th);
                        str2 = "";
                    }
                    g.a().a((WebView) d.this.f9993i, "onFeedbackAlertStatusNotify", Base64.encodeToString(str2.getBytes(), 2));
                }
            });
            this.f9986b.setCampaignUnitId(this.f9989e);
            com.mbridge.msdk.foundation.d.b.a().a(this.f9989e, this.f9986b);
        }
    }

    /* access modifiers changed from: private */
    public void a(com.mbridge.msdk.foundation.c.b bVar) {
        if (this.f9986b != null && !f()) {
            this.f9978C.removeCallbacks(this.f9979D);
            c cVar = this.f9985a;
            if (cVar != null) {
                cVar.a(bVar);
            }
        }
    }

    public final void a() {
        i();
        CampaignEx campaignEx = this.f9986b;
        String str = this.f9989e;
        if (campaignEx != null) {
            try {
                String a5 = com.mbridge.msdk.mbsignalcommon.mraid.c.a(campaignEx.getId());
                if (!TextUtils.isEmpty(a5)) {
                    new com.mbridge.msdk.foundation.same.report.h(com.mbridge.msdk.foundation.controller.c.m().c()).b(campaignEx.getRequestId(), campaignEx.getRequestIdNotice(), campaignEx.getId(), str, a5, campaignEx.isBidCampaign());
                    com.mbridge.msdk.mbsignalcommon.mraid.c.b(campaignEx.getId());
                }
            } catch (Throwable th) {
                af.b("BannerReport", th.getMessage());
            }
        }
        if (this.f9985a != null) {
            this.f9985a = null;
        }
        MBBannerWebView mBBannerWebView = this.f9993i;
        if (mBBannerWebView != null) {
            mBBannerWebView.setWebViewListener((com.mbridge.msdk.mbsignalcommon.windvane.d) null);
        }
        if (this.f9984I != null) {
            this.f9984I = null;
        }
        ImageView imageView = this.f9994j;
        if (imageView != null) {
            imageView.setOnClickListener((View.OnClickListener) null);
        }
        ImageView imageView2 = this.f9992h;
        if (imageView2 != null) {
            imageView2.setOnClickListener((View.OnClickListener) null);
        }
        MBBannerView mBBannerView = this.f9987c;
        if (mBBannerView != null) {
            mBBannerView.removeAllViews();
        }
        MBBannerWebView mBBannerWebView2 = this.f9993i;
        if (mBBannerWebView2 != null) {
            mBBannerWebView2.release();
        }
        com.mbridge.msdk.mbbanner.common.communication.a aVar = this.f10010z;
        if (aVar != null) {
            aVar.a();
        }
        if (this.f9983H != null) {
            this.f9983H = null;
        }
        com.mbridge.msdk.foundation.d.b.a().c(this.f9989e);
        String str2 = this.f9989e;
        try {
            if (!TextUtils.isEmpty(str2)) {
                LinkedHashMap<String, com.mbridge.msdk.foundation.same.report.d.c> b5 = com.mbridge.msdk.foundation.same.report.d.d.a().b();
                if (b5 != null && !b5.isEmpty()) {
                    Iterator<Map.Entry<String, com.mbridge.msdk.foundation.same.report.d.c>> it = b5.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry next = it.next();
                        if (next != null) {
                            com.mbridge.msdk.foundation.same.report.d.c cVar = (com.mbridge.msdk.foundation.same.report.d.c) next.getValue();
                            if (cVar.s()) {
                                it.remove();
                            }
                            if (cVar.i().equals(str2)) {
                                it.remove();
                            }
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            af.b("BannerReport", th2.getMessage());
        }
    }

    static /* synthetic */ void d(d dVar) {
        ImageView imageView;
        if (dVar.f9991g && (imageView = dVar.f9994j) != null && imageView.getVisibility() == 0) {
            dVar.f9994j.setVisibility(8);
            dVar.f9994j.setOnClickListener((View.OnClickListener) null);
            if (dVar.f9987c != null && dVar.f9994j.getParent() != null) {
                dVar.f9987c.removeView(dVar.f9994j);
            }
        }
    }

    public final void c(boolean z4) {
        this.f9997m = z4;
        e();
    }

    private void c(final CampaignEx campaignEx, final Context context, String str) {
        if (!TextUtils.isEmpty(campaignEx.getImpressionURL())) {
            new Thread(new Runnable() {
                public final void run() {
                    try {
                        j.a((f) com.mbridge.msdk.foundation.db.g.a(context)).a(campaignEx.getId());
                    } catch (Exception e5) {
                        af.b("BannerShowManager", e5.getMessage());
                    }
                }
            }).start();
            Context context2 = context;
            com.mbridge.msdk.click.a.a(context2, campaignEx, str, campaignEx.getImpressionURL(), false, true, com.mbridge.msdk.click.a.a.f8069g);
        }
        if (!TextUtils.isEmpty(str) && campaignEx.getNativeVideoTracking() != null && campaignEx.getNativeVideoTracking().p() != null) {
            Context context3 = context;
            com.mbridge.msdk.click.a.a(context3, campaignEx, str, campaignEx.getNativeVideoTracking().p(), false, false);
        }
    }

    static /* synthetic */ void c(d dVar) {
        try {
            CampaignEx campaignEx = dVar.f9986b;
            if (campaignEx != null) {
                com.mbridge.msdk.foundation.same.report.d.c a5 = com.mbridge.msdk.mbbanner.common.d.a.a(dVar.f9989e, campaignEx.getLocalRequestId());
                a5.g(dVar.f10007w);
                com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                eVar.a("close_click_type", Integer.valueOf(dVar.f10004t));
                eVar.a(CampaignEx.JSON_KEY_CREATIVE_ID, Long.valueOf(dVar.f9986b.getCreativeId()));
                com.mbridge.msdk.mbbanner.common.d.a.a("2000069", a5, eVar);
            }
        } catch (Throwable th) {
            af.b("BannerShowManager", th.getMessage());
        }
        MBBannerWebView mBBannerWebView = dVar.f9993i;
        if (!(mBBannerWebView == null || mBBannerWebView.getParent() == null)) {
            dVar.f9987c.removeView(dVar.f9993i);
        }
        ImageView imageView = dVar.f9992h;
        if (!(imageView == null || imageView.getParent() == null)) {
            dVar.f9992h.setVisibility(8);
            dVar.f9987c.removeView(dVar.f9992h);
        }
        ImageView imageView2 = dVar.f9994j;
        if (!(imageView2 == null || imageView2.getParent() == null)) {
            dVar.f9987c.removeView(dVar.f9994j);
            dVar.f9994j.setVisibility(8);
        }
        com.mbridge.msdk.foundation.d.b.a().c(dVar.f9989e);
        ImageView imageView3 = dVar.f9995k;
        if (!(imageView3 == null || imageView3.getParent() == null)) {
            dVar.f9987c.removeView(dVar.f9995k);
            dVar.f9995k.setVisibility(8);
        }
        BannerUtils.inserCloseId(dVar.f9989e, dVar.f10005u);
        try {
            CampaignEx campaignEx2 = dVar.f9986b;
            if (campaignEx2 != null) {
                com.mbridge.msdk.foundation.same.report.d.c a6 = com.mbridge.msdk.mbbanner.common.d.a.a(dVar.f9989e, campaignEx2.getLocalRequestId());
                a6.g(dVar.f10007w);
                a6.c(true);
                com.mbridge.msdk.mbbanner.common.d.a.a("2000152", a6, (com.mbridge.msdk.foundation.same.report.d.e) null);
            }
        } catch (Throwable th2) {
            af.b("BannerShowManager", th2.getMessage());
        }
        c cVar = dVar.f9985a;
        if (cVar != null) {
            cVar.e();
        }
        dVar.i();
    }

    private void a(CampaignEx campaignEx, Context context, String str) {
        if (campaignEx != null) {
            try {
                List<String> pv_urls = campaignEx.getPv_urls();
                if (pv_urls != null && pv_urls.size() > 0) {
                    for (String a5 : pv_urls) {
                        CampaignEx campaignEx2 = campaignEx;
                        Context context2 = context;
                        String str2 = str;
                        com.mbridge.msdk.click.a.a(context2, campaignEx2, str2, a5, false, true);
                        context = context2;
                        campaignEx = campaignEx2;
                        str = str2;
                    }
                }
            } catch (Throwable th) {
                af.b("BannerShowManager", th.getMessage());
            }
        }
    }

    public final void a(int i5, int i6, int i7, int i8) {
        if (i5 != i7 || i6 != i8) {
            MBBannerWebView mBBannerWebView = this.f9993i;
            af.b("BannerCallJS", "fireOnBannerViewSizeChange");
            try {
                com.mbridge.msdk.mbsignalcommon.mraid.a.a().a((WebView) mBBannerWebView, (float) i5, (float) i6);
            } catch (Throwable th) {
                af.b("BannerCallJS", "fireOnBannerViewSizeChange", th);
            }
        }
    }

    public final void a(String str) {
        this.f10003s = str;
    }

    /* access modifiers changed from: private */
    public void a(String str, int i5) {
        try {
            CampaignEx campaignEx = this.f9986b;
            if (campaignEx != null) {
                com.mbridge.msdk.foundation.same.report.d.c a5 = com.mbridge.msdk.mbbanner.common.d.a.a(this.f9989e, campaignEx.getLocalRequestId());
                a5.g(this.f10007w);
                com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                eVar.a("result", Integer.valueOf(i5));
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                eVar.a("reason", str);
                a5.f(TextUtils.isEmpty(this.f9986b.getBannerUrl()) ? 2 : 1);
                com.mbridge.msdk.mbbanner.common.d.a.a("2000068", a5, eVar);
            }
        } catch (Throwable th) {
            af.b("BannerShowManager", th.getMessage());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001f  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.mbridge.msdk.foundation.entity.CampaignUnit r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L_0x001a
            java.util.ArrayList r5 = r5.getAds()
            r4.f10005u = r5
            if (r5 == 0) goto L_0x001a
            int r5 = r5.size()
            if (r5 <= 0) goto L_0x001a
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r5 = r4.f10005u
            java.lang.Object r5 = r5.get(r0)
            com.mbridge.msdk.foundation.entity.CampaignEx r5 = (com.mbridge.msdk.foundation.entity.CampaignEx) r5
            goto L_0x001b
        L_0x001a:
            r5 = 0
        L_0x001b:
            r4.f9986b = r5
            if (r5 != 0) goto L_0x0030
            com.mbridge.msdk.foundation.c.b r5 = new com.mbridge.msdk.foundation.c.b
            r0 = 880043(0xd6dab, float:1.233203E-39)
            r5.<init>(r0)
            java.lang.String r0 = r4.f10003s
            r5.b((java.lang.String) r0)
            r4.a((com.mbridge.msdk.foundation.c.b) r5)
            return
        L_0x0030:
            android.os.Handler r5 = r4.f9978C
            com.mbridge.msdk.foundation.same.e.a r1 = r4.f9979D
            r5.removeCallbacks(r1)
            boolean r5 = r4.f9991g
            if (r5 == 0) goto L_0x006f
            android.widget.ImageView r5 = r4.f9994j
            if (r5 != 0) goto L_0x006f
            android.widget.ImageView r5 = new android.widget.ImageView
            com.mbridge.msdk.foundation.controller.c r1 = com.mbridge.msdk.foundation.controller.c.m()
            android.content.Context r1 = r1.c()
            r5.<init>(r1)
            r4.f9994j = r5
            com.mbridge.msdk.foundation.controller.c r1 = com.mbridge.msdk.foundation.controller.c.m()
            android.content.Context r1 = r1.c()
            java.lang.String r2 = "mbridge_banner_close"
            java.lang.String r3 = "drawable"
            int r1 = com.mbridge.msdk.foundation.tools.x.a(r1, r2, r3)
            r5.setBackgroundResource(r1)
            android.widget.ImageView r5 = r4.f9994j
            r1 = 8
            r5.setVisibility(r1)
            android.widget.ImageView r5 = r4.f9994j
            java.lang.String r1 = "closeButton"
            r5.setContentDescription(r1)
        L_0x006f:
            r4.f9998n = r0
            r4.f9999o = r0
            r4.f9988d = r0
            com.mbridge.msdk.foundation.entity.CampaignEx r5 = r4.f9986b
            java.lang.String r5 = r5.getBannerHtml()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L_0x008d
            com.mbridge.msdk.foundation.entity.CampaignEx r5 = r4.f9986b
            java.lang.String r5 = r5.getBannerUrl()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x00f1
        L_0x008d:
            java.lang.String r5 = r4.f9989e
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r4.f9986b
            if (r0 == 0) goto L_0x00f1
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x00de }
            r1.<init>()     // Catch:{ all -> 0x00de }
            java.lang.String r2 = "key"
            java.lang.String r3 = "2000067"
            r1.put(r2, r3)     // Catch:{ all -> 0x00de }
            java.lang.String r2 = "rid"
            java.lang.String r3 = r0.getRequestId()     // Catch:{ all -> 0x00de }
            r1.put(r2, r3)     // Catch:{ all -> 0x00de }
            java.lang.String r2 = "rid_n"
            java.lang.String r3 = r0.getRequestIdNotice()     // Catch:{ all -> 0x00de }
            r1.put(r2, r3)     // Catch:{ all -> 0x00de }
            java.lang.String r2 = "cid"
            java.lang.String r3 = r0.getId()     // Catch:{ all -> 0x00de }
            r1.put(r2, r3)     // Catch:{ all -> 0x00de }
            java.lang.String r2 = "unit_id"
            r1.put(r2, r5)     // Catch:{ all -> 0x00de }
            java.lang.String r2 = "hb"
            boolean r0 = r0.isBidCampaign()     // Catch:{ all -> 0x00de }
            r1.put(r2, r0)     // Catch:{ all -> 0x00de }
            java.util.HashMap<java.lang.String, java.lang.String> r0 = com.mbridge.msdk.foundation.controller.a.f8822b     // Catch:{ all -> 0x00de }
            if (r0 == 0) goto L_0x00e0
            java.lang.Object r5 = r0.get(r5)     // Catch:{ all -> 0x00de }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x00de }
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x00de }
            if (r0 != 0) goto L_0x00e0
            java.lang.String r0 = "u_stid"
            r1.put(r0, r5)     // Catch:{ all -> 0x00de }
            goto L_0x00e0
        L_0x00de:
            r5 = move-exception
            goto L_0x00e8
        L_0x00e0:
            com.mbridge.msdk.foundation.same.report.d.d r5 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ all -> 0x00de }
            r5.a((org.json.JSONObject) r1)     // Catch:{ all -> 0x00de }
            goto L_0x00f1
        L_0x00e8:
            java.lang.String r0 = "BannerReport"
            java.lang.String r5 = r5.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r0, r5)
        L_0x00f1:
            android.os.Handler r5 = r4.f9978C
            com.mbridge.msdk.foundation.same.e.a r0 = r4.f9979D
            r1 = 15000(0x3a98, double:7.411E-320)
            r5.postDelayed(r0, r1)
            boolean r5 = r4.c()
            if (r5 != 0) goto L_0x0126
            com.mbridge.msdk.foundation.entity.CampaignEx r5 = r4.f9986b
            java.lang.String r5 = r5.getBannerHtml()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L_0x0118
            com.mbridge.msdk.foundation.entity.CampaignEx r5 = r4.f9986b
            java.lang.String r5 = r5.getBannerUrl()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x0123
        L_0x0118:
            r5 = 880048(0xd6db0, float:1.23321E-39)
            java.lang.String r5 = com.mbridge.msdk.foundation.c.a.a(r5)
            r0 = 2
            r4.a((java.lang.String) r5, (int) r0)
        L_0x0123:
            r4.d()
        L_0x0126:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbbanner.common.c.d.a(com.mbridge.msdk.foundation.entity.CampaignUnit):void");
    }
}
