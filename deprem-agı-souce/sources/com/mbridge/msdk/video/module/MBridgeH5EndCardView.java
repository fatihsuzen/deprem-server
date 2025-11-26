package com.mbridge.msdk.video.module;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.report.h;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.aj;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.ap;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import com.mbridge.msdk.out.Campaign;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class MBridgeH5EndCardView extends MBridgeH5EndCardViewDiff {
    /* access modifiers changed from: private */

    /* renamed from: A  reason: collision with root package name */
    public boolean f12362A = false;
    /* access modifiers changed from: private */

    /* renamed from: B  reason: collision with root package name */
    public boolean f12363B = false;
    /* access modifiers changed from: private */

    /* renamed from: C  reason: collision with root package name */
    public int f12364C = 1;
    /* access modifiers changed from: private */

    /* renamed from: D  reason: collision with root package name */
    public long f12365D = 0;
    /* access modifiers changed from: private */

    /* renamed from: E  reason: collision with root package name */
    public boolean f12366E = false;
    /* access modifiers changed from: private */

    /* renamed from: F  reason: collision with root package name */
    public boolean f12367F = false;

    /* renamed from: G  reason: collision with root package name */
    private boolean f12368G = false;

    /* renamed from: H  reason: collision with root package name */
    private boolean f12369H = false;
    /* access modifiers changed from: private */

    /* renamed from: I  reason: collision with root package name */
    public boolean f12370I = false;
    /* access modifiers changed from: private */

    /* renamed from: J  reason: collision with root package name */
    public boolean f12371J = false;
    /* access modifiers changed from: private */

    /* renamed from: K  reason: collision with root package name */
    public boolean f12372K = false;

    /* renamed from: L  reason: collision with root package name */
    private boolean f12373L = false;
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public String f12374M = "";

    /* renamed from: N  reason: collision with root package name */
    private boolean f12375N = false;

    /* renamed from: O  reason: collision with root package name */
    private boolean f12376O = false;

    /* renamed from: m  reason: collision with root package name */
    protected View f12377m;

    /* renamed from: n  reason: collision with root package name */
    protected RelativeLayout f12378n;

    /* renamed from: o  reason: collision with root package name */
    protected ImageView f12379o;

    /* renamed from: p  reason: collision with root package name */
    protected WindVaneWebView f12380p;

    /* renamed from: q  reason: collision with root package name */
    protected Handler f12381q = new Handler();

    /* renamed from: r  reason: collision with root package name */
    protected String f12382r;

    /* renamed from: s  reason: collision with root package name */
    protected boolean f12383s = false;

    /* renamed from: t  reason: collision with root package name */
    protected boolean f12384t = false;

    /* renamed from: u  reason: collision with root package name */
    Handler f12385u = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 100) {
                if (MBridgeH5EndCardView.this.f12366E) {
                    MBridgeH5EndCardView.this.notifyListener.a(122, "");
                }
                MBridgeH5EndCardView.this.notifyListener.a(103, "");
            }
        }
    };

    /* renamed from: v  reason: collision with root package name */
    boolean f12386v = false;

    /* renamed from: w  reason: collision with root package name */
    private boolean f12387w = false;

    /* renamed from: x  reason: collision with root package name */
    private boolean f12388x = false;

    /* renamed from: y  reason: collision with root package name */
    private int f12389y = 1;

    /* renamed from: z  reason: collision with root package name */
    private int f12390z = 1;

    private class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private MBridgeH5EndCardView f12398b;

        public a(MBridgeH5EndCardView mBridgeH5EndCardView) {
            this.f12398b = mBridgeH5EndCardView;
        }

        public final void run() {
            Handler handler;
            try {
                Thread.sleep(300);
            } catch (InterruptedException e5) {
                af.b("CloseRunnable", e5.getMessage());
            }
            MBridgeH5EndCardView mBridgeH5EndCardView = this.f12398b;
            if (mBridgeH5EndCardView != null && (handler = mBridgeH5EndCardView.f12385u) != null) {
                handler.sendEmptyMessage(100);
            }
        }
    }

    private class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private MBridgeH5EndCardView f12400b;

        public b(MBridgeH5EndCardView mBridgeH5EndCardView) {
            this.f12400b = mBridgeH5EndCardView;
        }

        public final void run() {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.f12400b;
            if (mBridgeH5EndCardView != null && !mBridgeH5EndCardView.f12363B) {
                boolean unused = this.f12400b.f12363B = true;
                this.f12400b.f12383s = false;
                MBridgeH5EndCardView.this.reportRenderResult("timeout", 5);
                this.f12400b.notifyListener.a(127, "");
                af.a(MBridgeBaseView.TAG, "notify TYPE_NOTIFY_SHOW_NATIVE_ENDCARD");
            }
        }
    }

    private static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private MBridgeH5EndCardView f12401a;

        /* renamed from: b  reason: collision with root package name */
        private int f12402b;

        public c(MBridgeH5EndCardView mBridgeH5EndCardView, int i5) {
            this.f12401a = mBridgeH5EndCardView;
            this.f12402b = i5;
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x0084 A[Catch:{ Exception -> 0x008a, all -> 0x0016 }] */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x008c A[Catch:{ Exception -> 0x008a, all -> 0x0016 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r13 = this;
                java.lang.String r1 = "MBridgeBaseView"
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r0 = r13.f12401a
                if (r0 == 0) goto L_0x00e8
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = r0.f12294b
                if (r2 == 0) goto L_0x00e8
                boolean r0 = r0.f12362A     // Catch:{ all -> 0x0016 }
                if (r0 == 0) goto L_0x0019
                java.lang.String r0 = "insertEndCardReadyState hasInsertLoadEndCardReport true return"
                com.mbridge.msdk.foundation.tools.af.c(r1, r0)     // Catch:{ all -> 0x0016 }
                return
            L_0x0016:
                r0 = move-exception
                goto L_0x00e1
            L_0x0019:
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r0 = r13.f12401a     // Catch:{ all -> 0x0016 }
                r2 = 1
                boolean unused = r0.f12362A = r2     // Catch:{ all -> 0x0016 }
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r0 = r13.f12401a     // Catch:{ all -> 0x0016 }
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r0.f12294b     // Catch:{ all -> 0x0016 }
                java.lang.String r0 = r0.getendcard_url()     // Catch:{ all -> 0x0016 }
                boolean r0 = com.mbridge.msdk.foundation.tools.ap.b(r0)     // Catch:{ all -> 0x0016 }
                java.lang.String r2 = "1"
                java.lang.String r3 = "2"
                if (r0 == 0) goto L_0x0043
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r0 = r13.f12401a     // Catch:{ all -> 0x0016 }
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r0.f12294b     // Catch:{ all -> 0x0016 }
                java.lang.String r0 = r0.getendcard_url()     // Catch:{ all -> 0x0016 }
                java.lang.String r4 = ".zip"
                boolean r0 = r0.contains(r4)     // Catch:{ all -> 0x0016 }
                if (r0 == 0) goto L_0x0043
                r12 = r2
                goto L_0x0044
            L_0x0043:
                r12 = r3
            L_0x0044:
                java.lang.String r11 = "ready timeout"
                com.mbridge.msdk.foundation.entity.n r4 = new com.mbridge.msdk.foundation.entity.n     // Catch:{ all -> 0x0016 }
                java.lang.String r5 = "m_download_end"
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0016 }
                r0.<init>()     // Catch:{ all -> 0x0016 }
                int r6 = r13.f12402b     // Catch:{ all -> 0x0016 }
                int r6 = r6 * 1000
                r0.append(r6)     // Catch:{ all -> 0x0016 }
                java.lang.String r6 = ""
                r0.append(r6)     // Catch:{ all -> 0x0016 }
                java.lang.String r7 = r0.toString()     // Catch:{ all -> 0x0016 }
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r0 = r13.f12401a     // Catch:{ all -> 0x0016 }
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r0.f12294b     // Catch:{ all -> 0x0016 }
                java.lang.String r8 = r0.getendcard_url()     // Catch:{ all -> 0x0016 }
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r0 = r13.f12401a     // Catch:{ all -> 0x0016 }
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r0.f12294b     // Catch:{ all -> 0x0016 }
                java.lang.String r9 = r0.getId()     // Catch:{ all -> 0x0016 }
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r0 = r13.f12401a     // Catch:{ all -> 0x0016 }
                java.lang.String r10 = r0.unitId     // Catch:{ all -> 0x0016 }
                r6 = 12
                r4.<init>((java.lang.String) r5, (int) r6, (java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9, (java.lang.String) r10, (java.lang.String) r11, (java.lang.String) r12)     // Catch:{ all -> 0x0016 }
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r0 = r13.f12401a     // Catch:{ Exception -> 0x008a }
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r0.f12294b     // Catch:{ Exception -> 0x008a }
                int r0 = r0.getAdType()     // Catch:{ Exception -> 0x008a }
                r5 = 287(0x11f, float:4.02E-43)
                if (r0 != r5) goto L_0x008c
                java.lang.String r0 = "3"
                r4.d((java.lang.String) r0)     // Catch:{ Exception -> 0x008a }
                goto L_0x00af
            L_0x008a:
                r0 = move-exception
                goto L_0x00ac
            L_0x008c:
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r0 = r13.f12401a     // Catch:{ Exception -> 0x008a }
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r0.f12294b     // Catch:{ Exception -> 0x008a }
                int r0 = r0.getAdType()     // Catch:{ Exception -> 0x008a }
                r5 = 94
                if (r0 != r5) goto L_0x009c
                r4.d((java.lang.String) r2)     // Catch:{ Exception -> 0x008a }
                goto L_0x00af
            L_0x009c:
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r0 = r13.f12401a     // Catch:{ Exception -> 0x008a }
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r0.f12294b     // Catch:{ Exception -> 0x008a }
                int r0 = r0.getAdType()     // Catch:{ Exception -> 0x008a }
                r2 = 42
                if (r0 != r2) goto L_0x00af
                r4.d((java.lang.String) r3)     // Catch:{ Exception -> 0x008a }
                goto L_0x00af
            L_0x00ac:
                r0.printStackTrace()     // Catch:{ all -> 0x0016 }
            L_0x00af:
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r0 = r13.f12401a     // Catch:{ all -> 0x0016 }
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r0.f12294b     // Catch:{ all -> 0x0016 }
                java.lang.String r0 = r0.getRequestId()     // Catch:{ all -> 0x0016 }
                r4.f(r0)     // Catch:{ all -> 0x0016 }
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r0 = r13.f12401a     // Catch:{ all -> 0x0016 }
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r0.f12294b     // Catch:{ all -> 0x0016 }
                java.lang.String r0 = r0.getCurrentLocalRid()     // Catch:{ all -> 0x0016 }
                r4.s(r0)     // Catch:{ all -> 0x0016 }
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r0 = r13.f12401a     // Catch:{ all -> 0x0016 }
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r0.f12294b     // Catch:{ all -> 0x0016 }
                java.lang.String r0 = r0.getRequestIdNotice()     // Catch:{ all -> 0x0016 }
                r4.g(r0)     // Catch:{ all -> 0x0016 }
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r0 = r13.f12401a     // Catch:{ all -> 0x0016 }
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r0.f12294b     // Catch:{ all -> 0x0016 }
                int r0 = r0.getAdSpaceT()     // Catch:{ all -> 0x0016 }
                r4.c((int) r0)     // Catch:{ all -> 0x0016 }
                com.mbridge.msdk.video.module.MBridgeH5EndCardView r0 = r13.f12401a     // Catch:{ all -> 0x0016 }
                r0.isLoadSuccess()     // Catch:{ all -> 0x0016 }
                goto L_0x00e8
            L_0x00e1:
                java.lang.String r2 = r0.getMessage()
                com.mbridge.msdk.foundation.tools.af.b(r1, r2, r0)
            L_0x00e8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeH5EndCardView.c.run():void");
        }
    }

    private class d implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private MBridgeH5EndCardView f12404b;

        public d(MBridgeH5EndCardView mBridgeH5EndCardView) {
            this.f12404b = mBridgeH5EndCardView;
        }

        public final void run() {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.f12404b;
            if (mBridgeH5EndCardView != null) {
                boolean unused = mBridgeH5EndCardView.f12370I = true;
            }
        }
    }

    private class e implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private MBridgeH5EndCardView f12406b;

        public e(MBridgeH5EndCardView mBridgeH5EndCardView) {
            this.f12406b = mBridgeH5EndCardView;
        }

        public final void run() {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.f12406b;
            if (mBridgeH5EndCardView != null) {
                boolean unused = mBridgeH5EndCardView.f12371J = true;
            }
        }
    }

    private class f implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private MBridgeH5EndCardView f12408b;

        public f(MBridgeH5EndCardView mBridgeH5EndCardView) {
            this.f12408b = mBridgeH5EndCardView;
        }

        public final void run() {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.f12408b;
            if (mBridgeH5EndCardView != null) {
                if (!mBridgeH5EndCardView.f12372K) {
                    MBridgeH5EndCardView.this.setCloseVisible(0);
                }
                boolean unused = this.f12408b.f12367F = true;
            }
        }
    }

    public MBridgeH5EndCardView(Context context) {
        super(context);
    }

    static /* synthetic */ void f(MBridgeH5EndCardView mBridgeH5EndCardView) {
        RelativeLayout.LayoutParams layoutParams;
        try {
            CampaignEx campaignEx = mBridgeH5EndCardView.f12294b;
            if (campaignEx != null) {
                campaignEx.setCampaignUnitId(mBridgeH5EndCardView.unitId);
                com.mbridge.msdk.foundation.d.b a5 = com.mbridge.msdk.foundation.d.b.a();
                a5.c(mBridgeH5EndCardView.unitId + "_" + 1);
                com.mbridge.msdk.foundation.d.b a6 = com.mbridge.msdk.foundation.d.b.a();
                a6.a(mBridgeH5EndCardView.unitId + "_" + 2, mBridgeH5EndCardView.f12294b);
            }
            CampaignEx campaignEx2 = mBridgeH5EndCardView.f12294b;
            if (campaignEx2 != null && campaignEx2.isMraid()) {
                ImageView imageView = new ImageView(com.mbridge.msdk.foundation.controller.c.m().c());
                imageView.setBackgroundResource(x.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_notice", "drawable"));
                ImageView imageView2 = mBridgeH5EndCardView.f12379o;
                if (imageView2 != null) {
                    layoutParams = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
                } else {
                    layoutParams = null;
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 12.0f), ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 12.0f));
                layoutParams2.addRule(9);
                layoutParams2.addRule(10);
                if (layoutParams != null) {
                    layoutParams2.leftMargin = layoutParams.rightMargin;
                    layoutParams2.topMargin = layoutParams.topMargin;
                    layoutParams2.width = layoutParams.width;
                    layoutParams2.height = layoutParams.height;
                } else {
                    layoutParams2.leftMargin = ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 12.0f);
                    layoutParams2.topMargin = ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 12.0f);
                }
                mBridgeH5EndCardView.addView(imageView, layoutParams2);
                ak.a(4, imageView, mBridgeH5EndCardView.f12294b, com.mbridge.msdk.foundation.controller.c.m().c(), false, new com.mbridge.msdk.foundation.d.a() {
                    public final void close() {
                        String str;
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                                jSONObject.put(NotificationCompat.CATEGORY_STATUS, 2);
                            }
                            str = jSONObject.toString();
                        } catch (Throwable th) {
                            af.b(MBridgeBaseView.TAG, th.getMessage(), th);
                            str = "";
                        }
                        g.a().a((WebView) MBridgeH5EndCardView.this.f12380p, "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
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
                            af.b(MBridgeBaseView.TAG, th.getMessage(), th);
                            str = "";
                        }
                        g.a().a((WebView) MBridgeH5EndCardView.this.f12380p, "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
                    }

                    public final void summit(String str) {
                        String str2;
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                                jSONObject.put(NotificationCompat.CATEGORY_STATUS, 2);
                            }
                            str2 = jSONObject.toString();
                        } catch (Throwable th) {
                            af.b(MBridgeBaseView.TAG, th.getMessage(), th);
                            str2 = "";
                        }
                        g.a().a((WebView) MBridgeH5EndCardView.this.f12380p, "onFeedbackAlertStatusNotify", Base64.encodeToString(str2.getBytes(), 2));
                    }
                });
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public boolean canBackPress() {
        ImageView imageView = this.f12379o;
        if (imageView == null || imageView.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public void close() {
        try {
            onCloseViewClick();
        } catch (Exception e5) {
            af.b(MBridgeBaseView.TAG, e5.getMessage());
        }
    }

    public void defaultShow() {
        super.defaultShow();
    }

    public void excuteEndCardShowTask(int i5) {
        this.f12381q.postDelayed(new c(this, i5), (long) (i5 * 1000));
    }

    public void excuteTask() {
        if (!this.f12388x && this.f12389y > -1) {
            this.f12381q.postDelayed(new f(this), (long) (this.f12389y * 1000));
        }
    }

    public void executeEndCardShow(int i5) {
        this.f12381q.postDelayed(new b(this), (long) (i5 * 1000));
    }

    public void expand(String str, boolean z4) {
    }

    public CampaignEx getMraidCampaign() {
        return this.f12294b;
    }

    public void handlerPlayableException(String str) {
        if (!this.f12384t) {
            this.f12384t = true;
            this.f12383s = false;
            if (this.f12294b != null) {
                n nVar = new n();
                nVar.f(this.f12294b.getRequestId());
                nVar.g(this.f12294b.getRequestIdNotice());
                nVar.e(this.f12294b.getId());
                nVar.h(str);
                com.mbridge.msdk.foundation.same.report.g.a(nVar, this.f12293a.getApplicationContext(), this.unitId);
            }
        }
    }

    public void init(Context context) {
        int findLayout = findLayout("mbridge_reward_endcard_h5");
        if (findLayout >= 0) {
            View inflate = this.f12295c.inflate(findLayout, (ViewGroup) null);
            this.f12377m = inflate;
            try {
                this.f12379o = (ImageView) inflate.findViewById(findID("mbridge_windwv_close"));
                this.f12378n = (RelativeLayout) inflate.findViewById(findID("mbridge_windwv_content_rl"));
                WindVaneWebView windVaneWebView = new WindVaneWebView(getContext());
                this.f12380p = windVaneWebView;
                CampaignEx campaignEx = this.f12294b;
                if (campaignEx != null) {
                    windVaneWebView.setLocalRequestId(campaignEx.getCurrentLocalRid());
                }
                this.f12380p.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                this.f12378n.addView(this.f12380p);
                this.f12297e = isNotNULL(this.f12379o, this.f12380p);
            } catch (Exception unused) {
                this.f12297e = false;
            }
            addView(this.f12377m, b());
            c();
            e();
        }
    }

    public void install(CampaignEx campaignEx) {
    }

    public boolean isLoadSuccess() {
        return this.f12383s;
    }

    public boolean isPlayable() {
        return this.f12388x;
    }

    public void notifyCloseBtn(int i5) {
        if (i5 == 0) {
            this.f12368G = true;
        } else if (i5 == 1) {
            this.f12369H = true;
        }
    }

    public void onBackPress() {
        boolean z4;
        if (this.f12367F || ((z4 && this.f12369H) || ((!(z4 = this.f12368G) && this.f12370I && !this.f12386v) || (!z4 && this.f12371J && this.f12386v)))) {
            onCloseViewClick();
        }
    }

    public void onCloseViewClick() {
        try {
            if (this.f12380p != null) {
                g.a().a((WebView) this.f12380p, "onSystemDestory", "");
                new Thread(new a(this)).start();
            } else {
                this.notifyListener.a(103, "");
                this.notifyListener.a(119, "webview is null when closing webview");
            }
        } catch (Exception e5) {
            this.notifyListener.a(103, "");
            com.mbridge.msdk.video.module.a.a aVar = this.notifyListener;
            aVar.a(119, "close webview exception" + e5.getMessage());
            af.a(MBridgeBaseView.TAG, e5.getMessage());
        }
        try {
            com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
            eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 2);
            com.mbridge.msdk.foundation.same.report.d.d.a().a("2000152", eVar);
            com.mbridge.msdk.foundation.same.report.d.d.a().a("2000134", this.f12294b);
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
            }
        }
    }

    public void onFinishRedirection(Campaign campaign, String str) {
        if (campaign != null) {
            aj.a(campaign, this);
        }
    }

    public void onRedirectionFailed(Campaign campaign, String str) {
        if (campaign != null) {
            aj.a(campaign, this);
        }
    }

    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        orientation(configuration);
    }

    public void onStartRedirection(Campaign campaign, String str) {
        aj.b(campaign, this);
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i5) {
        super.onVisibilityChanged(view, i5);
        if (i5 == 0 && !this.f12373L) {
            this.f12373L = true;
            setFocusableInTouchMode(true);
            requestFocus();
            requestFocusFromTouch();
        }
    }

    public void onWindowFocusChanged(boolean z4) {
        super.onWindowFocusChanged(z4);
        CampaignEx campaignEx = this.f12294b;
        if (campaignEx != null && campaignEx.isMraid()) {
            if (z4) {
                com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(this.f12380p, "true");
            } else {
                com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(this.f12380p, "false");
            }
        }
    }

    public void open(String str) {
        super.open(str);
    }

    public void orientation(Configuration configuration) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (configuration.orientation == 2) {
                jSONObject.put("orientation", "landscape");
            } else {
                jSONObject.put("orientation", "portrait");
            }
            g.a().a((WebView) this.f12380p, "orientation", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:71:0x014e A[Catch:{ all -> 0x00f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0152 A[Catch:{ all -> 0x00f9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void preLoadData(com.mbridge.msdk.video.signal.factory.b r15) {
        /*
            r14 = this;
            java.lang.String r0 = "="
            com.mbridge.msdk.foundation.same.b r1 = com.mbridge.msdk.foundation.same.b.a()
            java.lang.String r2 = "new_bridge_reward_video"
            boolean r1 = r1.a(r2)
            r2 = 129(0x81, float:1.81E-43)
            r3 = 127(0x7f, float:1.78E-43)
            java.lang.String r4 = "PL URL IS NULL"
            r5 = 3
            java.lang.String r6 = ""
            if (r1 == 0) goto L_0x0030
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r14.f12294b
            if (r1 == 0) goto L_0x0030
            int r1 = r1.getAdSpaceT()
            r7 = 2
            if (r1 != r7) goto L_0x0030
            r14.reportRenderResult(r4, r5)
            com.mbridge.msdk.video.module.a.a r15 = r14.notifyListener
            r15.a(r3, r6)
            com.mbridge.msdk.video.module.a.a r15 = r14.notifyListener
            r15.a(r2, r6)
            return
        L_0x0030:
            java.lang.String r8 = r14.a()
            boolean r1 = r14.f12297e
            r13 = 0
            if (r1 == 0) goto L_0x0185
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r14.f12294b
            if (r1 == 0) goto L_0x0185
            boolean r1 = android.text.TextUtils.isEmpty(r8)
            if (r1 != 0) goto L_0x0185
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r1 = r14.f12380p
            if (r1 == 0) goto L_0x0185
            long r1 = java.lang.System.currentTimeMillis()
            r14.f12365D = r1
            java.lang.String r1 = "start"
            r14.reportRenderResult(r1, r13)     // Catch:{ Exception -> 0x0052 }
        L_0x0052:
            com.mbridge.msdk.foundation.same.g.a r1 = new com.mbridge.msdk.foundation.same.g.a
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r14.f12294b
            r1.<init>(r2)
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r14.f12294b
            java.lang.String r2 = r2.getAppName()
            r1.a(r2)
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r2 = r14.f12380p
            r2.setDownloadListener(r1)
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r1 = r14.f12380p
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r14.f12294b
            java.lang.String r2 = r2.getId()
            r1.setCampaignId(r2)
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r1 = r14.f12380p
            r1.setTempTypeForMetrics(r5)
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r14.f12294b
            if (r1 == 0) goto L_0x0080
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r2 = r14.f12380p
            r2.setCampaignEx(r1)
        L_0x0080:
            r1 = 8
            r14.setCloseVisible(r1)
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r1 = r14.f12380p
            r1.setApiManagerJSFactory(r15)
            com.mbridge.msdk.foundation.entity.CampaignEx r15 = r14.f12294b
            boolean r15 = r15.isMraid()
            if (r15 == 0) goto L_0x0097
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r15 = r14.f12380p
            r15.setMraidObject(r14)
        L_0x0097:
            java.lang.String r15 = "wfr=1"
            boolean r1 = r8.contains(r15)
            r2 = 1
            if (r1 != 0) goto L_0x00ab
            java.lang.String r1 = "wfl=1"
            boolean r1 = r8.contains(r1)
            if (r1 == 0) goto L_0x00a9
            goto L_0x00ab
        L_0x00a9:
            r1 = r13
            goto L_0x00ac
        L_0x00ab:
            r1 = r2
        L_0x00ac:
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r3 = r14.f12380p
            com.mbridge.msdk.video.module.MBridgeH5EndCardView$3 r4 = new com.mbridge.msdk.video.module.MBridgeH5EndCardView$3
            r4.<init>(r1)
            r3.setWebViewListener(r4)
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r14.f12294b
            java.lang.String r1 = r1.getMraid()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x015f
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00f9 }
            r14.f12365D = r3     // Catch:{ all -> 0x00f9 }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r14.f12294b     // Catch:{ all -> 0x00f9 }
            java.lang.String r1 = r1.getendcard_url()     // Catch:{ all -> 0x00f9 }
            com.mbridge.msdk.videocommon.d.b r3 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ all -> 0x00f9 }
            com.mbridge.msdk.foundation.controller.c r4 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ all -> 0x00f9 }
            java.lang.String r4 = r4.k()     // Catch:{ all -> 0x00f9 }
            java.lang.String r5 = r14.unitId     // Catch:{ all -> 0x00f9 }
            com.mbridge.msdk.videocommon.d.c r3 = r3.a(r4, r5)     // Catch:{ all -> 0x00f9 }
            boolean r4 = r14.f12388x     // Catch:{ all -> 0x00f9 }
            if (r4 == 0) goto L_0x015f
            boolean r4 = com.mbridge.msdk.foundation.tools.ap.b(r1)     // Catch:{ all -> 0x00f9 }
            if (r4 == 0) goto L_0x015f
            boolean r4 = r1.contains(r15)     // Catch:{ all -> 0x00f9 }
            if (r4 != 0) goto L_0x00fc
            if (r3 == 0) goto L_0x015f
            int r4 = r3.o()     // Catch:{ all -> 0x00f9 }
            if (r4 <= 0) goto L_0x015f
            goto L_0x00fc
        L_0x00f9:
            r0 = move-exception
            r15 = r0
            goto L_0x0156
        L_0x00fc:
            boolean r15 = r1.contains(r15)     // Catch:{ all -> 0x00f9 }
            r4 = 20
            if (r15 == 0) goto L_0x013e
            java.lang.String r15 = "&"
            java.lang.String[] r15 = r1.split(r15)     // Catch:{ all -> 0x00f9 }
            if (r15 == 0) goto L_0x014b
            int r1 = r15.length     // Catch:{ all -> 0x00f9 }
            if (r1 <= 0) goto L_0x014b
            int r1 = r15.length     // Catch:{ all -> 0x00f9 }
            r3 = r13
        L_0x0111:
            if (r3 >= r1) goto L_0x014b
            r5 = r15[r3]     // Catch:{ all -> 0x00f9 }
            boolean r6 = com.mbridge.msdk.foundation.tools.ap.b(r5)     // Catch:{ all -> 0x00f9 }
            if (r6 == 0) goto L_0x013b
            java.lang.String r6 = "to"
            boolean r6 = r5.contains(r6)     // Catch:{ all -> 0x00f9 }
            if (r6 == 0) goto L_0x013b
            java.lang.String[] r6 = r5.split(r0)     // Catch:{ all -> 0x00f9 }
            if (r6 == 0) goto L_0x013b
            java.lang.String[] r6 = r5.split(r0)     // Catch:{ all -> 0x00f9 }
            int r6 = r6.length     // Catch:{ all -> 0x00f9 }
            if (r6 <= 0) goto L_0x013b
            java.lang.String[] r15 = r5.split(r0)     // Catch:{ all -> 0x00f9 }
            r15 = r15[r2]     // Catch:{ all -> 0x00f9 }
            int r15 = com.mbridge.msdk.foundation.tools.ak.a((java.lang.Object) r15)     // Catch:{ all -> 0x00f9 }
            goto L_0x014c
        L_0x013b:
            int r3 = r3 + 1
            goto L_0x0111
        L_0x013e:
            if (r3 == 0) goto L_0x014b
            int r15 = r3.o()     // Catch:{ all -> 0x00f9 }
            if (r15 <= 0) goto L_0x014b
            int r15 = r3.o()     // Catch:{ all -> 0x00f9 }
            goto L_0x014c
        L_0x014b:
            r15 = r4
        L_0x014c:
            if (r15 < 0) goto L_0x0152
            r14.excuteEndCardShowTask(r15)     // Catch:{ all -> 0x00f9 }
            goto L_0x015f
        L_0x0152:
            r14.excuteEndCardShowTask(r4)     // Catch:{ all -> 0x00f9 }
            goto L_0x015f
        L_0x0156:
            java.lang.String r0 = "MBridgeBaseView"
            java.lang.String r1 = r15.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r0, r1, r15)
        L_0x015f:
            com.mbridge.msdk.foundation.download.download.HTMLResourceManager r15 = com.mbridge.msdk.foundation.download.download.HTMLResourceManager.getInstance()
            java.lang.String r15 = r15.getHtmlContentFromUrl(r8)
            r14.setHtmlSource(r15)
            java.lang.String r15 = r14.f12382r
            boolean r15 = android.text.TextUtils.isEmpty(r15)
            if (r15 == 0) goto L_0x0178
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r15 = r14.f12380p
            r15.loadUrl(r8)
            goto L_0x0192
        L_0x0178:
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r7 = r14.f12380p
            java.lang.String r9 = r14.f12382r
            java.lang.String r11 = "UTF-8"
            r12 = 0
            java.lang.String r10 = "text/html"
            r7.loadDataWithBaseURL(r8, r9, r10, r11, r12)
            goto L_0x0192
        L_0x0185:
            r14.reportRenderResult(r4, r5)
            com.mbridge.msdk.video.module.a.a r15 = r14.notifyListener
            r15.a(r3, r6)
            com.mbridge.msdk.video.module.a.a r15 = r14.notifyListener
            r15.a(r2, r6)
        L_0x0192:
            r14.f12386v = r13
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeH5EndCardView.preLoadData(com.mbridge.msdk.video.signal.factory.b):void");
    }

    public void readyStatus(int i5) {
    }

    public void release() {
        Handler handler = this.f12381q;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.f12381q = null;
        }
        Handler handler2 = this.f12385u;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages((Object) null);
            this.f12385u = null;
        }
        this.f12378n.removeAllViews();
        this.f12380p.release();
        this.f12380p = null;
    }

    public void reportOpen(String str) {
        CampaignEx mraidCampaign = getMraidCampaign();
        if (mraidCampaign != null) {
            new h(getContext()).a(mraidCampaign.getRequestId(), mraidCampaign.getRequestIdNotice(), mraidCampaign.getId(), this.unitId, str, this.f12294b.isBidCampaign());
        }
    }

    public void reportRenderResult(String str, int i5) {
        if (this.f12294b != null && !this.f12384t) {
            n nVar = new n();
            nVar.f(this.f12294b.getRequestId());
            nVar.g(this.f12294b.getRequestIdNotice());
            nVar.e(this.f12294b.getId());
            nVar.b(i5);
            nVar.l(String.valueOf(System.currentTimeMillis() - this.f12365D));
            nVar.h(str);
            String str2 = "2";
            if (this.f12294b.getAdType() == 287) {
                nVar.d(ExifInterface.GPS_MEASUREMENT_3D);
            } else if (this.f12294b.getAdType() == 94) {
                nVar.d("1");
            } else if (this.f12294b.getAdType() == 42) {
                nVar.d(str2);
            }
            if (this.f12294b.isMraid()) {
                nVar.d(n.f9116a);
            } else {
                nVar.n(this.f12294b.getendcard_url());
                if (ap.b(this.f12294b.getendcard_url()) && this.f12294b.getendcard_url().contains(".zip")) {
                    str2 = "1";
                }
                nVar.o(str2);
                nVar.d(n.f9117b);
            }
            com.mbridge.msdk.foundation.same.report.g.b(nVar, this.unitId, this.f12294b);
        }
    }

    public void setCloseDelayShowTime(int i5) {
        this.f12389y = i5;
    }

    public void setCloseVisible(int i5) {
        if (this.f12297e) {
            this.f12379o.setVisibility(i5);
        }
    }

    public void setCloseVisibleForMraid(int i5) {
        if (this.f12297e) {
            this.f12372K = true;
            if (i5 == 4) {
                this.f12379o.setImageDrawable(new ColorDrawable(16711680));
            } else {
                this.f12379o.setImageResource(findDrawable("mbridge_reward_close"));
            }
            this.f12379o.setVisibility(0);
        }
    }

    public void setError(boolean z4) {
        this.f12384t = z4;
    }

    public void setHtmlSource(String str) {
        this.f12382r = str;
    }

    public void setLoadPlayable(boolean z4) {
        this.f12386v = z4;
    }

    public void setNotchValue(String str, int i5, int i6, int i7, int i8) {
        this.f12374M = str;
        CampaignEx campaignEx = this.f12294b;
        if (campaignEx != null && campaignEx.getAdSpaceT() != 2) {
            af.b(MBridgeBaseView.TAG, "NOTCH H5ENDCARD " + String.format("%1s-%2s-%3s-%4s", new Object[]{Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f12379o.getLayoutParams();
            int a5 = ak.a(getContext(), 20.0f);
            layoutParams.setMargins(i5 + a5, i7 + a5, i6 + a5, i8 + a5);
            this.f12379o.setLayoutParams(layoutParams);
        }
    }

    public void setPlayCloseBtnTm(int i5) {
        this.f12390z = i5;
    }

    public void setUnitId(String str) {
        this.unitId = str;
    }

    public void startCounterEndCardShowTimer() {
        try {
            String str = this.f12294b.getendcard_url();
            if (ap.b(str) && str.contains("wfl=1")) {
                String[] split = str.split("&");
                int i5 = 15;
                if (split != null && split.length > 0) {
                    for (String str2 : split) {
                        if (ap.b(str2) && str2.contains("timeout") && str2.split("=") != null && str2.split("=").length > 0) {
                            i5 = ak.a((Object) str2.split("=")[1]);
                        }
                    }
                }
                executeEndCardShow(i5);
            }
        } catch (Throwable th) {
            af.a(MBridgeBaseView.TAG, th.getMessage());
        }
    }

    public void toggleCloseBtn(int i5) {
        int visibility = this.f12379o.getVisibility();
        if (i5 == 1) {
            this.f12367F = true;
            visibility = 0;
        } else if (i5 == 2) {
            this.f12367F = false;
            if (this.f12386v) {
                if (!this.f12376O && !this.f12368G) {
                    this.f12376O = true;
                    int i6 = this.f12390z;
                    if (i6 == 0) {
                        this.f12371J = true;
                    } else {
                        this.f12371J = false;
                        if (i6 > -1) {
                            this.f12381q.postDelayed(new e(this), (long) (this.f12390z * 1000));
                        }
                    }
                }
            } else if (!this.f12375N && !this.f12368G) {
                this.f12375N = true;
                int i7 = this.f12389y;
                if (i7 == 0) {
                    this.f12370I = true;
                } else {
                    this.f12370I = false;
                    if (i7 > -1) {
                        this.f12381q.postDelayed(new d(this), (long) (this.f12389y * 1000));
                    }
                }
            }
            visibility = 8;
        }
        setCloseVisible(visibility);
    }

    public void unload() {
        close();
    }

    public void useCustomClose(boolean z4) {
        int i5;
        if (z4) {
            i5 = 4;
        } else {
            i5 = 0;
        }
        try {
            setCloseVisibleForMraid(i5);
        } catch (Exception e5) {
            af.b(MBridgeBaseView.TAG, e5.getMessage());
        }
    }

    public void volumeChange(double d5) {
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().a((WebView) this.f12380p, d5);
    }

    public void webviewshow() {
        WindVaneWebView windVaneWebView = this.f12380p;
        if (windVaneWebView != null) {
            windVaneWebView.post(new Runnable() {
                public final void run() {
                    String str;
                    try {
                        af.a(MBridgeBaseView.TAG, "webviewshow");
                        try {
                            int[] iArr = new int[2];
                            MBridgeH5EndCardView.this.f12380p.getLocationOnScreen(iArr);
                            af.b(MBridgeBaseView.TAG, "coordinate:" + iArr[0] + "--" + iArr[1]);
                            JSONObject jSONObject = new JSONObject();
                            Context c5 = com.mbridge.msdk.foundation.controller.c.m().c();
                            if (c5 != null) {
                                jSONObject.put("startX", ak.b(c5, (float) iArr[0]));
                                jSONObject.put("startY", ak.b(c5, (float) iArr[1]));
                                jSONObject.put(com.mbridge.msdk.foundation.same.a.f9193l, (double) ak.d(c5));
                            }
                            str = jSONObject.toString();
                        } catch (Throwable th) {
                            af.b(MBridgeBaseView.TAG, th.getMessage(), th);
                            str = "";
                        }
                        g.a().a((WebView) MBridgeH5EndCardView.this.f12380p, "webviewshow", Base64.encodeToString(str.toString().getBytes(), 2));
                        MBridgeH5EndCardView.this.notifyListener.a(109, "");
                        MBridgeH5EndCardView.d(MBridgeH5EndCardView.this);
                        MBridgeH5EndCardView.this.startCounterEndCardShowTimer();
                        g a5 = g.a();
                        MBridgeH5EndCardView mBridgeH5EndCardView = MBridgeH5EndCardView.this;
                        a5.a((WebView) mBridgeH5EndCardView.f12380p, "oncutoutfetched", Base64.encodeToString(mBridgeH5EndCardView.f12374M.getBytes(), 0));
                        MBridgeH5EndCardView.f(MBridgeH5EndCardView.this);
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
            });
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036 A[Catch:{ NullPointerException -> 0x0088, all -> 0x002d }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003e A[Catch:{ NullPointerException -> 0x0088, all -> 0x002d }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0082 A[Catch:{ NullPointerException -> 0x0088, all -> 0x002d }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008a A[Catch:{ NullPointerException -> 0x0088, all -> 0x002d }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e5 A[Catch:{ Exception -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00f9 A[Catch:{ Exception -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x010e A[ADDED_TO_REGION, Catch:{ NullPointerException -> 0x0088, all -> 0x002d }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.mbridge.msdk.video.module.MBridgeH5EndCardView r16, long r17, boolean r19) {
        /*
            r1 = r16
            java.lang.String r2 = "MBridgeBaseView"
            boolean r0 = r1.f12362A     // Catch:{ all -> 0x002d }
            if (r0 == 0) goto L_0x000a
            goto L_0x0154
        L_0x000a:
            r3 = 1
            r1.f12362A = r3     // Catch:{ all -> 0x002d }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.f12294b     // Catch:{ all -> 0x002d }
            java.lang.String r0 = r0.getendcard_url()     // Catch:{ all -> 0x002d }
            boolean r0 = com.mbridge.msdk.foundation.tools.ap.b(r0)     // Catch:{ all -> 0x002d }
            java.lang.String r4 = "1"
            java.lang.String r5 = "2"
            if (r0 == 0) goto L_0x0030
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.f12294b     // Catch:{ all -> 0x002d }
            java.lang.String r0 = r0.getendcard_url()     // Catch:{ all -> 0x002d }
            java.lang.String r6 = ".zip"
            boolean r0 = r0.contains(r6)     // Catch:{ all -> 0x002d }
            if (r0 == 0) goto L_0x0030
            r14 = r4
            goto L_0x0031
        L_0x002d:
            r0 = move-exception
            goto L_0x014d
        L_0x0030:
            r14 = r5
        L_0x0031:
            java.lang.String r0 = "ready yes"
            r6 = 2
            if (r19 == 0) goto L_0x003e
            java.lang.String r0 = "ready timeout"
            r7 = 12
        L_0x003a:
            r13 = r0
            r15 = r6
        L_0x003c:
            r8 = r7
            goto L_0x004d
        L_0x003e:
            int r7 = r1.f12364C     // Catch:{ all -> 0x002d }
            if (r7 != r6) goto L_0x0048
            java.lang.String r0 = "ready no"
            r6 = 3
            r7 = 11
            goto L_0x003a
        L_0x0048:
            r7 = 10
            r13 = r0
            r15 = r3
            goto L_0x003c
        L_0x004d:
            com.mbridge.msdk.foundation.entity.n r6 = new com.mbridge.msdk.foundation.entity.n     // Catch:{ all -> 0x002d }
            java.lang.String r7 = "m_download_end"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x002d }
            r0.<init>()     // Catch:{ all -> 0x002d }
            r9 = r17
            r0.append(r9)     // Catch:{ all -> 0x002d }
            java.lang.String r11 = ""
            r0.append(r11)     // Catch:{ all -> 0x002d }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x002d }
            com.mbridge.msdk.foundation.entity.CampaignEx r11 = r1.f12294b     // Catch:{ all -> 0x002d }
            java.lang.String r11 = r11.getendcard_url()     // Catch:{ all -> 0x002d }
            com.mbridge.msdk.foundation.entity.CampaignEx r12 = r1.f12294b     // Catch:{ all -> 0x002d }
            java.lang.String r12 = r12.getId()     // Catch:{ all -> 0x002d }
            r10 = r11
            r11 = r12
            java.lang.String r12 = r1.unitId     // Catch:{ all -> 0x002d }
            r9 = r0
            r6.<init>((java.lang.String) r7, (int) r8, (java.lang.String) r9, (java.lang.String) r10, (java.lang.String) r11, (java.lang.String) r12, (java.lang.String) r13, (java.lang.String) r14)     // Catch:{ all -> 0x002d }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.f12294b     // Catch:{ NullPointerException -> 0x0088 }
            int r0 = r0.getAdType()     // Catch:{ NullPointerException -> 0x0088 }
            r7 = 287(0x11f, float:4.02E-43)
            if (r0 != r7) goto L_0x008a
            java.lang.String r0 = "3"
            r6.d((java.lang.String) r0)     // Catch:{ NullPointerException -> 0x0088 }
            goto L_0x00a9
        L_0x0088:
            r0 = move-exception
            goto L_0x00a6
        L_0x008a:
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.f12294b     // Catch:{ NullPointerException -> 0x0088 }
            int r0 = r0.getAdType()     // Catch:{ NullPointerException -> 0x0088 }
            r7 = 94
            if (r0 != r7) goto L_0x0098
            r6.d((java.lang.String) r4)     // Catch:{ NullPointerException -> 0x0088 }
            goto L_0x00a9
        L_0x0098:
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.f12294b     // Catch:{ NullPointerException -> 0x0088 }
            int r0 = r0.getAdType()     // Catch:{ NullPointerException -> 0x0088 }
            r4 = 42
            if (r0 != r4) goto L_0x00a9
            r6.d((java.lang.String) r5)     // Catch:{ NullPointerException -> 0x0088 }
            goto L_0x00a9
        L_0x00a6:
            r0.printStackTrace()     // Catch:{ all -> 0x002d }
        L_0x00a9:
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.f12294b     // Catch:{ all -> 0x002d }
            java.lang.String r0 = r0.getRequestId()     // Catch:{ all -> 0x002d }
            r6.f(r0)     // Catch:{ all -> 0x002d }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.f12294b     // Catch:{ all -> 0x002d }
            java.lang.String r0 = r0.getCurrentLocalRid()     // Catch:{ all -> 0x002d }
            r6.s(r0)     // Catch:{ all -> 0x002d }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.f12294b     // Catch:{ all -> 0x002d }
            java.lang.String r0 = r0.getRequestIdNotice()     // Catch:{ all -> 0x002d }
            r6.g(r0)     // Catch:{ all -> 0x002d }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.f12294b     // Catch:{ all -> 0x002d }
            int r0 = r0.getAdSpaceT()     // Catch:{ all -> 0x002d }
            r6.c((int) r0)     // Catch:{ all -> 0x002d }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.f12294b     // Catch:{ all -> 0x002d }
            com.mbridge.msdk.videocommon.d.b r4 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ Exception -> 0x00ed }
            com.mbridge.msdk.foundation.controller.c r5 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x00ed }
            java.lang.String r5 = r5.k()     // Catch:{ Exception -> 0x00ed }
            java.lang.String r0 = r0.getCampaignUnitId()     // Catch:{ Exception -> 0x00ed }
            com.mbridge.msdk.videocommon.d.c r0 = r4.a(r5, r0)     // Catch:{ Exception -> 0x00ed }
            if (r0 == 0) goto L_0x00ef
            java.lang.String r0 = r0.l()     // Catch:{ Exception -> 0x00ed }
            r6.v(r0)     // Catch:{ Exception -> 0x00ed }
            goto L_0x00ef
        L_0x00ed:
            r0 = move-exception
            goto L_0x0101
        L_0x00ef:
            com.mbridge.msdk.videocommon.d.b r0 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ Exception -> 0x00ed }
            com.mbridge.msdk.videocommon.d.a r0 = r0.b()     // Catch:{ Exception -> 0x00ed }
            if (r0 == 0) goto L_0x0108
            java.lang.String r0 = r0.c()     // Catch:{ Exception -> 0x00ed }
            r6.u(r0)     // Catch:{ Exception -> 0x00ed }
            goto L_0x0108
        L_0x0101:
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x002d }
            com.mbridge.msdk.foundation.tools.af.b(r2, r0)     // Catch:{ all -> 0x002d }
        L_0x0108:
            boolean r0 = r1.isLoadSuccess()     // Catch:{ all -> 0x002d }
            if (r0 != 0) goto L_0x0154
            if (r15 != r3) goto L_0x0154
            r6.b((int) r15)     // Catch:{ all -> 0x002d }
            java.lang.String r0 = java.lang.String.valueOf(r17)     // Catch:{ all -> 0x002d }
            r6.l(r0)     // Catch:{ all -> 0x002d }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.f12294b     // Catch:{ all -> 0x002d }
            java.lang.String r0 = r0.getId()     // Catch:{ all -> 0x002d }
            r6.e((java.lang.String) r0)     // Catch:{ all -> 0x002d }
            r6.h(r13)     // Catch:{ all -> 0x002d }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.f12294b     // Catch:{ all -> 0x002d }
            boolean r0 = r0.isMraid()     // Catch:{ all -> 0x002d }
            if (r0 == 0) goto L_0x0134
            int r0 = com.mbridge.msdk.foundation.entity.n.f9116a     // Catch:{ all -> 0x002d }
            r6.d((int) r0)     // Catch:{ all -> 0x002d }
            goto L_0x0145
        L_0x0134:
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.f12294b     // Catch:{ all -> 0x002d }
            java.lang.String r0 = r0.getendcard_url()     // Catch:{ all -> 0x002d }
            r6.n(r0)     // Catch:{ all -> 0x002d }
            r6.o(r14)     // Catch:{ all -> 0x002d }
            int r0 = com.mbridge.msdk.foundation.entity.n.f9117b     // Catch:{ all -> 0x002d }
            r6.d((int) r0)     // Catch:{ all -> 0x002d }
        L_0x0145:
            java.lang.String r0 = r1.unitId     // Catch:{ all -> 0x002d }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r1.f12294b     // Catch:{ all -> 0x002d }
            com.mbridge.msdk.foundation.same.report.g.b((com.mbridge.msdk.foundation.entity.n) r6, (java.lang.String) r0, (com.mbridge.msdk.foundation.entity.CampaignEx) r1)     // Catch:{ all -> 0x002d }
            goto L_0x0154
        L_0x014d:
            java.lang.String r1 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r2, r1, r0)
        L_0x0154:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeH5EndCardView.a(com.mbridge.msdk.video.module.MBridgeH5EndCardView, long, boolean):void");
    }

    static /* synthetic */ void d(MBridgeH5EndCardView mBridgeH5EndCardView) {
        MBridgeH5EndCardView mBridgeH5EndCardView2 = mBridgeH5EndCardView;
        CampaignEx campaignEx = mBridgeH5EndCardView2.f12294b;
        if (campaignEx != null && campaignEx.isMraid()) {
            int i5 = mBridgeH5EndCardView2.getResources().getConfiguration().orientation;
            String str = "undefined";
            if (i5 != 0) {
                if (i5 == 1) {
                    str = "portrait";
                } else if (i5 == 2) {
                    str = "landscape";
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("orientation", str);
                jSONObject.put("locked", "true");
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            HashMap hashMap = new HashMap();
            hashMap.put(MRAIDCommunicatorUtil.KEY_PLACEMENTTYPE, MRAIDCommunicatorUtil.PLACEMENT_INTERSTITIAL);
            hashMap.put(MRAIDCommunicatorUtil.KEY_STATE, MRAIDCommunicatorUtil.STATES_DEFAULT);
            hashMap.put(MRAIDCommunicatorUtil.KEY_VIEWABLE, "true");
            hashMap.put(MRAIDCommunicatorUtil.KEY_CURRENTORIENTATION, jSONObject);
            if (mBridgeH5EndCardView2.getContext() instanceof Activity) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((Activity) mBridgeH5EndCardView2.getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(mBridgeH5EndCardView2.f12380p, (float) ab.j(mBridgeH5EndCardView2.getContext()), (float) ab.h(mBridgeH5EndCardView2.getContext()));
                com.mbridge.msdk.mbsignalcommon.mraid.a.a().c(mBridgeH5EndCardView2.f12380p, (float) displayMetrics.widthPixels, (float) displayMetrics.heightPixels);
            }
            com.mbridge.msdk.mbsignalcommon.mraid.a a5 = com.mbridge.msdk.mbsignalcommon.mraid.a.a();
            WindVaneWebView windVaneWebView = mBridgeH5EndCardView2.f12380p;
            a5.a(windVaneWebView, (float) windVaneWebView.getLeft(), (float) mBridgeH5EndCardView2.f12380p.getTop(), (float) mBridgeH5EndCardView2.f12380p.getWidth(), (float) mBridgeH5EndCardView2.f12380p.getHeight());
            com.mbridge.msdk.mbsignalcommon.mraid.a a6 = com.mbridge.msdk.mbsignalcommon.mraid.a.a();
            WindVaneWebView windVaneWebView2 = mBridgeH5EndCardView2.f12380p;
            a6.b(windVaneWebView2, (float) windVaneWebView2.getLeft(), (float) mBridgeH5EndCardView2.f12380p.getTop(), (float) mBridgeH5EndCardView2.f12380p.getWidth(), (float) mBridgeH5EndCardView2.f12380p.getHeight());
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a((WebView) mBridgeH5EndCardView2.f12380p, (Map<String, Object>) hashMap);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a((WebView) mBridgeH5EndCardView2.f12380p, com.mbridge.msdk.mbsignalcommon.mraid.d.f10172a);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(mBridgeH5EndCardView2.f12380p);
        }
    }

    /* access modifiers changed from: protected */
    public RelativeLayout.LayoutParams b() {
        return new RelativeLayout.LayoutParams(-1, -1);
    }

    /* access modifiers changed from: protected */
    public final void c() {
        super.c();
        if (this.f12297e) {
            this.f12379o.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    MBridgeH5EndCardView.this.onCloseViewClick();
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void e() {
        if (this.f12297e) {
            setMatchParent();
        }
    }

    public MBridgeH5EndCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public String a() {
        CampaignEx campaignEx = this.f12294b;
        if (campaignEx != null) {
            this.f12366E = true;
            if (campaignEx.isMraid()) {
                this.f12388x = false;
                String mraid = this.f12294b.getMraid();
                if (TextUtils.isEmpty(mraid)) {
                    return this.f12294b.getEndScreenUrl();
                }
                File file = new File(mraid);
                try {
                    if (!file.exists() || !file.isFile() || !file.canRead()) {
                        return this.f12294b.getEndScreenUrl();
                    }
                    return "file:////" + mraid;
                } catch (Throwable th) {
                    if (!MBridgeConstans.DEBUG) {
                        return mraid;
                    }
                    th.printStackTrace();
                    return mraid;
                }
            } else {
                String str = this.f12294b.getendcard_url();
                if (!ap.a(str)) {
                    this.f12388x = true;
                    String h5ResAddress = H5DownLoadManager.getInstance().getH5ResAddress(str);
                    if (TextUtils.isEmpty(h5ResAddress)) {
                        try {
                            String path = Uri.parse(str).getPath();
                            if (!TextUtils.isEmpty(path) && path.toLowerCase().endsWith(".zip")) {
                                String endScreenUrl = this.f12294b.getEndScreenUrl();
                                if (TextUtils.isEmpty(endScreenUrl)) {
                                    return null;
                                }
                                this.f12388x = false;
                                excuteTask();
                                return endScreenUrl;
                            }
                        } catch (Throwable th2) {
                            af.b(MBridgeBaseView.TAG, th2.getMessage());
                        }
                        return str + "&native_adtype=" + this.f12294b.getAdType();
                    }
                    return h5ResAddress + "&native_adtype=" + this.f12294b.getAdType();
                }
                this.f12388x = false;
                return this.f12294b.getEndScreenUrl();
            }
        } else {
            this.f12366E = false;
            return null;
        }
    }
}
