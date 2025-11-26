package com.mbridge.msdk.click;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.e.b;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.e;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.same.report.h;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.aj;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.out.BaseTrackingListener;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.LoadingActivity;
import com.mbridge.msdk.out.NativeListener;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.scheme.applet.AppletSchemeCallBack;
import com.mbridge.msdk.scheme.applet.AppletsModel;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f8030a = false;

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, Long> f8031b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public static Set<String> f8032c = new HashSet();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f8033d;

    /* renamed from: e  reason: collision with root package name */
    private long f8034e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public g f8035f = null;

    /* renamed from: g  reason: collision with root package name */
    private Context f8036g = null;

    /* renamed from: h  reason: collision with root package name */
    private d f8037h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public NativeListener.NativeTrackingListener f8038i = null;

    /* renamed from: j  reason: collision with root package name */
    private h f8039j;

    /* renamed from: k  reason: collision with root package name */
    private com.mbridge.msdk.c.g f8040k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f8041l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public boolean f8042m = false;

    /* renamed from: n  reason: collision with root package name */
    private boolean f8043n = true;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public boolean f8044o;

    /* renamed from: p  reason: collision with root package name */
    private i f8045p;

    public a(Context context, String str) {
        com.mbridge.msdk.c.g b5 = com.mbridge.msdk.c.h.a().b(str);
        this.f8040k = b5;
        if (b5 == null) {
            com.mbridge.msdk.c.h.a();
            this.f8040k = i.a();
        }
        this.f8041l = this.f8040k.aK();
        Context applicationContext = context.getApplicationContext();
        this.f8036g = applicationContext;
        this.f8033d = str;
        if (this.f8035f == null) {
            this.f8035f = g.a(applicationContext);
        }
        this.f8039j = new h(this.f8036g);
    }

    static /* synthetic */ void f(a aVar) {
        try {
            Intent intent = new Intent();
            intent.setAction("ExitApp");
            aVar.f8036g.sendBroadcast(intent);
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b("CommonClickControl", "Exception", e5);
            }
        }
    }

    /* access modifiers changed from: private */
    public static String b(int i5) {
        if (i5 == 1) {
            return "2000136";
        }
        if (i5 == 2) {
            return "2000137";
        }
        if (i5 == 3) {
            return "2000139";
        }
        if (i5 != 4) {
            return "";
        }
        return "2000138";
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2, boolean z4, boolean z5) {
        if (context != null) {
            String str3 = str;
            new d(context.getApplicationContext()).a(str3, campaignEx, (f) null, str2, z4, z5, com.mbridge.msdk.click.a.a.f8068f);
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String[] strArr, boolean z4, boolean z5) {
        if (context != null && campaignEx != null && !TextUtils.isEmpty(str) && strArr != null) {
            d dVar = new d(context.getApplicationContext());
            for (String a5 : strArr) {
                String str2 = str;
                dVar.a(str2, campaignEx, new f() {
                    public final void a(Object obj) {
                    }

                    public final void b(Object obj) {
                    }

                    public final void a(Object obj, String str) {
                    }
                }, a5, z4, z5, com.mbridge.msdk.click.a.a.f8068f);
            }
        }
    }

    private boolean b(CampaignEx campaignEx) {
        Long l5;
        if (campaignEx == null) {
            return true;
        }
        try {
            if (2 != campaignEx.getLinkType()) {
                if (3 != campaignEx.getLinkType()) {
                    return true;
                }
            }
            String id = campaignEx.getId();
            Map<String, Long> map = f8031b;
            if (map == null) {
                return true;
            }
            if (map.containsKey(id) && (l5 = f8031b.get(id)) != null) {
                if (l5.longValue() > System.currentTimeMillis() || f8032c.contains(campaignEx.getId())) {
                    return false;
                }
            }
            f8031b.put(campaignEx.getId(), Long.valueOf(System.currentTimeMillis() + ((long) (campaignEx.getClickTimeOutInterval() * 1000))));
            return true;
        } catch (Exception e5) {
            if (!MBridgeConstans.DEBUG) {
                return true;
            }
            e5.printStackTrace();
            return true;
        }
    }

    public final void a(String str) {
        this.f8033d = str;
    }

    public final void a(NativeListener.NativeTrackingListener nativeTrackingListener) {
        this.f8038i = nativeTrackingListener;
    }

    public final void a(i iVar) {
        this.f8045p = iVar;
    }

    public final void a(boolean z4) {
        this.f8043n = z4;
    }

    public final void a() {
        try {
            this.f8038i = null;
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void a(CampaignEx campaignEx, NativeListener.NativeAdListener nativeAdListener) {
        if (!(nativeAdListener == null || campaignEx == null)) {
            nativeAdListener.onAdClick(campaignEx);
        }
        a(campaignEx);
    }

    private int b() {
        try {
            com.mbridge.msdk.c.g gVar = this.f8040k;
            if (gVar != null) {
                return gVar.Y();
            }
            return 1;
        } catch (Exception e5) {
            e5.printStackTrace();
            return 1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:119:0x0257 A[Catch:{ Exception -> 0x0127, all -> 0x003f }] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x02a4 A[Catch:{ Exception -> 0x0127, all -> 0x003f }] */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x039f  */
    /* JADX WARNING: Removed duplicated region for block: B:227:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.mbridge.msdk.foundation.entity.CampaignEx r19) {
        /*
            r18 = this;
            r1 = r18
            r2 = r19
            java.lang.String r7 = "CommonClickControl"
            if (r2 != 0) goto L_0x000a
            goto L_0x03a6
        L_0x000a:
            boolean r0 = r18.b((com.mbridge.msdk.foundation.entity.CampaignEx) r19)     // Catch:{ all -> 0x003f }
            if (r0 != 0) goto L_0x0012
            goto L_0x03a6
        L_0x0012:
            com.mbridge.msdk.foundation.same.report.d.d r0 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ all -> 0x003f }
            java.lang.String r3 = "2000149"
            r0.a((java.lang.String) r3, (com.mbridge.msdk.foundation.entity.CampaignEx) r2)     // Catch:{ all -> 0x003f }
            java.lang.String r0 = r2.getNoticeUrl()     // Catch:{ all -> 0x003f }
            com.mbridge.msdk.foundation.db.g r3 = r1.f8035f     // Catch:{ all -> 0x003f }
            com.mbridge.msdk.foundation.db.d r3 = com.mbridge.msdk.foundation.db.d.a(r3)     // Catch:{ all -> 0x003f }
            r3.a()     // Catch:{ all -> 0x003f }
            java.lang.String r4 = r2.getId()     // Catch:{ all -> 0x003f }
            java.lang.String r5 = r1.f8033d     // Catch:{ all -> 0x003f }
            com.mbridge.msdk.click.entity.JumpLoaderResult r8 = r3.b(r4, r5)     // Catch:{ all -> 0x003f }
            r4 = 0
            if (r8 == 0) goto L_0x004a
            java.lang.String r5 = r8.getNoticeurl()     // Catch:{ all -> 0x003f }
            if (r5 == 0) goto L_0x0042
            r8.setNoticeurl(r4)     // Catch:{ all -> 0x003f }
            goto L_0x0042
        L_0x003f:
            r0 = move-exception
            goto L_0x039b
        L_0x0042:
            r2.setJumpResult(r8)     // Catch:{ all -> 0x003f }
            java.lang.String r5 = r1.f8033d     // Catch:{ all -> 0x003f }
            r3.a((com.mbridge.msdk.foundation.entity.CampaignEx) r2, (java.lang.String) r5)     // Catch:{ all -> 0x003f }
        L_0x004a:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x003f }
            r5.<init>()     // Catch:{ all -> 0x003f }
            com.mbridge.msdk.scheme.applet.AppletModelManager r3 = com.mbridge.msdk.scheme.applet.AppletModelManager.getInstance()     // Catch:{ all -> 0x003f }
            com.mbridge.msdk.scheme.applet.AppletsModel r3 = r3.get(r2)     // Catch:{ all -> 0x003f }
            boolean r6 = com.mbridge.msdk.foundation.tools.ak.b((com.mbridge.msdk.foundation.entity.CampaignEx) r2)     // Catch:{ all -> 0x003f }
            java.lang.String r9 = "&opdptype=0"
            java.lang.String r10 = "&opdptype=1"
            r11 = 3
            r12 = -1
            r13 = 1
            if (r6 == 0) goto L_0x00c2
            com.mbridge.msdk.foundation.tools.MIMManager r6 = com.mbridge.msdk.foundation.tools.MIMManager.a()     // Catch:{ all -> 0x003f }
            r6.a((com.mbridge.msdk.foundation.entity.CampaignEx) r2)     // Catch:{ all -> 0x003f }
            java.lang.String r6 = "deep_link"
            r5.add(r6)     // Catch:{ all -> 0x003f }
            android.content.Context r6 = r1.f8036g     // Catch:{ all -> 0x003f }
            java.lang.String r14 = r2.getDeepLinkURL()     // Catch:{ all -> 0x003f }
            boolean r6 = com.mbridge.msdk.click.c.e(r6, r14)     // Catch:{ all -> 0x003f }
            if (r6 == 0) goto L_0x00ac
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r3 = r1.f8038i     // Catch:{ all -> 0x003f }
            if (r3 == 0) goto L_0x0087
            java.lang.String r4 = r2.getClickURL()     // Catch:{ all -> 0x003f }
            r3.onStartRedirection(r2, r4)     // Catch:{ all -> 0x003f }
        L_0x0087:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x003f }
            r3.<init>()     // Catch:{ all -> 0x003f }
            r3.append(r0)     // Catch:{ all -> 0x003f }
            r3.append(r10)     // Catch:{ all -> 0x003f }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x003f }
            android.content.Context r3 = r1.f8036g     // Catch:{ all -> 0x003f }
            java.lang.String r4 = r1.f8033d     // Catch:{ all -> 0x003f }
            com.mbridge.msdk.click.b.a(r3, r4, r2, r0, r12)     // Catch:{ all -> 0x003f }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r1.f8038i     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x00a8
            java.lang.String r3 = r2.getClickURL()     // Catch:{ all -> 0x003f }
            r0.onFinishRedirection(r2, r3)     // Catch:{ all -> 0x003f }
        L_0x00a8:
            r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r2, (int) r11, (int) r13, (java.util.List<java.lang.String>) r5)     // Catch:{ all -> 0x003f }
            return
        L_0x00ac:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x003f }
            r6.<init>()     // Catch:{ all -> 0x003f }
            r6.append(r0)     // Catch:{ all -> 0x003f }
            r6.append(r9)     // Catch:{ all -> 0x003f }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x003f }
            com.mbridge.msdk.foundation.tools.MIMManager r6 = com.mbridge.msdk.foundation.tools.MIMManager.a()     // Catch:{ all -> 0x003f }
            r6.b((com.mbridge.msdk.foundation.entity.CampaignEx) r2)     // Catch:{ all -> 0x003f }
        L_0x00c2:
            r6 = r0
            int r0 = r2.getLinkType()     // Catch:{ all -> 0x003f }
            r14 = 12
            if (r0 != r14) goto L_0x00ee
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r1.f8038i     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x00d6
            java.lang.String r3 = r2.getClickURL()     // Catch:{ all -> 0x003f }
            r0.onStartRedirection(r2, r3)     // Catch:{ all -> 0x003f }
        L_0x00d6:
            android.content.Context r0 = r1.f8036g     // Catch:{ all -> 0x003f }
            java.lang.String r3 = r1.f8033d     // Catch:{ all -> 0x003f }
            com.mbridge.msdk.click.b.a(r0, r3, r2, r6, r12)     // Catch:{ all -> 0x003f }
            android.content.Context r0 = r1.f8036g     // Catch:{ all -> 0x003f }
            r1.a((android.content.Context) r0, (com.mbridge.msdk.foundation.entity.CampaignEx) r2, (java.util.List<java.lang.String>) r5)     // Catch:{ all -> 0x003f }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r1.f8038i     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x03a6
            java.lang.String r3 = r2.getClickURL()     // Catch:{ all -> 0x003f }
            r0.onFinishRedirection(r2, r3)     // Catch:{ all -> 0x003f }
            return
        L_0x00ee:
            if (r3 == 0) goto L_0x01b4
            boolean r0 = r3.isSupportWxScheme()     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x01b4
            boolean r0 = r3.isRequestSuccess()     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x0166
            android.content.Context r0 = r1.f8036g     // Catch:{ all -> 0x003f }
            java.lang.String r3 = r3.getDeepLink()     // Catch:{ all -> 0x003f }
            boolean r0 = com.mbridge.msdk.click.c.e(r0, r3)     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x0156
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r1.f8038i     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x0113
            java.lang.String r3 = r2.getClickURL()     // Catch:{ all -> 0x003f }
            r0.onStartRedirection(r2, r3)     // Catch:{ all -> 0x003f }
        L_0x0113:
            android.content.Context r0 = r1.f8036g     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x0133
            android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x003f }
            r0.<init>()     // Catch:{ all -> 0x003f }
            java.lang.String r3 = "mb_dp_close_broadcast_receiver"
            r0.setAction(r3)     // Catch:{ all -> 0x003f }
            android.content.Context r3 = r1.f8036g     // Catch:{ Exception -> 0x0127 }
            r3.sendBroadcast(r0)     // Catch:{ Exception -> 0x0127 }
            goto L_0x0133
        L_0x0127:
            r0 = move-exception
            boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x003f }
            if (r3 == 0) goto L_0x0133
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x003f }
            com.mbridge.msdk.foundation.tools.af.b(r7, r0)     // Catch:{ all -> 0x003f }
        L_0x0133:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x003f }
            r0.<init>()     // Catch:{ all -> 0x003f }
            r0.append(r6)     // Catch:{ all -> 0x003f }
            r0.append(r10)     // Catch:{ all -> 0x003f }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x003f }
            android.content.Context r3 = r1.f8036g     // Catch:{ all -> 0x003f }
            java.lang.String r4 = r1.f8033d     // Catch:{ all -> 0x003f }
            com.mbridge.msdk.click.b.a(r3, r4, r2, r0, r12)     // Catch:{ all -> 0x003f }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r1.f8038i     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x03a6
            java.lang.String r3 = r2.getClickURL()     // Catch:{ all -> 0x003f }
            r0.onFinishRedirection(r2, r3)     // Catch:{ all -> 0x003f }
            goto L_0x03a6
        L_0x0156:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x003f }
            r0.<init>()     // Catch:{ all -> 0x003f }
            r0.append(r6)     // Catch:{ all -> 0x003f }
            r0.append(r9)     // Catch:{ all -> 0x003f }
            java.lang.String r6 = r0.toString()     // Catch:{ all -> 0x003f }
            goto L_0x01b4
        L_0x0166:
            boolean r0 = r3.isRequesting()     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x0181
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r1.f8038i     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x0177
            java.lang.String r4 = r2.getClickURL()     // Catch:{ all -> 0x003f }
            r0.onStartRedirection(r2, r4)     // Catch:{ all -> 0x003f }
        L_0x0177:
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r1.f8038i     // Catch:{ all -> 0x003f }
            com.mbridge.msdk.scheme.applet.AppletSchemeCallBack r0 = r1.a((com.mbridge.msdk.out.NativeListener.NativeTrackingListener) r0, (com.mbridge.msdk.foundation.entity.CampaignEx) r2, (com.mbridge.msdk.scheme.applet.AppletsModel) r3, (com.mbridge.msdk.click.a) r1)     // Catch:{ all -> 0x003f }
            r3.setAppletSchemeCallBack(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x0181:
            boolean r0 = r3.can(r13)     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x01b4
            boolean r0 = r3.isRequestTimesMaxPerDay()     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x019f
            java.lang.String r0 = r3.getReBuildClickUrl()     // Catch:{ all -> 0x003f }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x003f }
            if (r0 != 0) goto L_0x01b4
            java.lang.String r0 = r3.getReBuildClickUrl()     // Catch:{ all -> 0x003f }
            r2.setClickURL(r0)     // Catch:{ all -> 0x003f }
            goto L_0x01b4
        L_0x019f:
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r1.f8038i     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x01aa
            java.lang.String r4 = r2.getClickURL()     // Catch:{ all -> 0x003f }
            r0.onStartRedirection(r2, r4)     // Catch:{ all -> 0x003f }
        L_0x01aa:
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r1.f8038i     // Catch:{ all -> 0x003f }
            com.mbridge.msdk.scheme.applet.AppletSchemeCallBack r0 = r1.a((com.mbridge.msdk.out.NativeListener.NativeTrackingListener) r0, (com.mbridge.msdk.foundation.entity.CampaignEx) r2, (com.mbridge.msdk.scheme.applet.AppletsModel) r3, (com.mbridge.msdk.click.a) r1)     // Catch:{ all -> 0x003f }
            r3.requestWxAppletsScheme(r13, r0)     // Catch:{ all -> 0x003f }
            return
        L_0x01b4:
            boolean r0 = com.mbridge.msdk.e.b.b()     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x01c1
            android.content.Context r0 = r1.f8036g     // Catch:{ all -> 0x003f }
            java.lang.String r3 = r1.f8033d     // Catch:{ all -> 0x003f }
            com.mbridge.msdk.click.b.a(r0, r3, r2, r6, r12)     // Catch:{ all -> 0x003f }
        L_0x01c1:
            boolean r0 = r2.getUserActivation()     // Catch:{ all -> 0x003f }
            if (r0 != 0) goto L_0x0216
            android.content.Context r0 = r1.f8036g     // Catch:{ all -> 0x003f }
            java.lang.String r3 = r2.getPackageName()     // Catch:{ all -> 0x003f }
            boolean r0 = com.mbridge.msdk.click.c.c(r0, r3)     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x0216
            android.content.Context r0 = r1.f8036g     // Catch:{ all -> 0x003f }
            java.lang.String r3 = r2.getPackageName()     // Catch:{ all -> 0x003f }
            com.mbridge.msdk.click.c.b(r0, r3)     // Catch:{ all -> 0x003f }
            boolean r0 = com.mbridge.msdk.e.b.a()     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x01eb
            android.content.Context r0 = r1.f8036g     // Catch:{ all -> 0x003f }
            java.lang.String r3 = r1.f8033d     // Catch:{ all -> 0x003f }
            int r8 = com.mbridge.msdk.foundation.same.a.f9171N     // Catch:{ all -> 0x003f }
            com.mbridge.msdk.click.b.a(r0, r3, r2, r6, r8)     // Catch:{ all -> 0x003f }
        L_0x01eb:
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r1.f8038i     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x01f6
            java.lang.String r3 = r2.getClickURL()     // Catch:{ all -> 0x003f }
            r0.onStartRedirection(r2, r3)     // Catch:{ all -> 0x003f }
        L_0x01f6:
            boolean r0 = com.mbridge.msdk.e.b.a()     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x0202
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x003f }
            r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r2, (boolean) r13, (java.lang.Boolean) r0, (java.util.List<java.lang.String>) r5)     // Catch:{ all -> 0x003f }
            goto L_0x0205
        L_0x0202:
            r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r2, (boolean) r13, (java.lang.Boolean) r4, (java.util.List<java.lang.String>) r5)     // Catch:{ all -> 0x003f }
        L_0x0205:
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r1.f8038i     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x03a6
            java.lang.String r3 = r2.getClickURL()     // Catch:{ all -> 0x003f }
            r0.onFinishRedirection(r2, r3)     // Catch:{ all -> 0x003f }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r1.f8038i     // Catch:{ all -> 0x003f }
            com.mbridge.msdk.foundation.tools.aj.a((com.mbridge.msdk.out.BaseTrackingListener) r0)     // Catch:{ all -> 0x003f }
            return
        L_0x0216:
            int r0 = r2.getLinkType()     // Catch:{ all -> 0x003f }
            int r3 = r1.b()     // Catch:{ all -> 0x003f }
            boolean r9 = com.mbridge.msdk.e.b.a()     // Catch:{ all -> 0x003f }
            if (r9 == 0) goto L_0x022d
            if (r0 == r11) goto L_0x022d
            android.content.Context r9 = r1.f8036g     // Catch:{ all -> 0x003f }
            java.lang.String r10 = r1.f8033d     // Catch:{ all -> 0x003f }
            com.mbridge.msdk.click.b.a(r9, r10, r2, r6, r12)     // Catch:{ all -> 0x003f }
        L_0x022d:
            r6 = 4
            r9 = 9
            r10 = 8
            r12 = 0
            if (r0 == r10) goto L_0x023c
            if (r0 == r9) goto L_0x023c
            if (r0 != r6) goto L_0x023a
            goto L_0x023c
        L_0x023a:
            r14 = r12
            goto L_0x023d
        L_0x023c:
            r14 = r13
        L_0x023d:
            java.lang.String r15 = r2.getClickURL()     // Catch:{ all -> 0x003f }
            boolean r16 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x003f }
            if (r16 != 0) goto L_0x02a4
            java.lang.String r11 = "market://"
            boolean r11 = r15.startsWith(r11)     // Catch:{ all -> 0x003f }
            if (r11 != 0) goto L_0x0257
            java.lang.String r11 = "https://play.google.com/"
            boolean r11 = r15.startsWith(r11)     // Catch:{ all -> 0x003f }
            if (r11 == 0) goto L_0x02a4
        L_0x0257:
            java.lang.String r0 = "google_play"
            r5.add(r0)     // Catch:{ all -> 0x003f }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r1.f8038i     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x0267
            java.lang.String r4 = r2.getClickURL()     // Catch:{ all -> 0x003f }
            r0.onStartRedirection(r2, r4)     // Catch:{ all -> 0x003f }
        L_0x0267:
            android.content.Context r0 = r1.f8036g     // Catch:{ all -> 0x003f }
            java.lang.String r4 = r2.getClickURL()     // Catch:{ all -> 0x003f }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r6 = r1.f8038i     // Catch:{ all -> 0x003f }
            boolean r0 = com.mbridge.msdk.foundation.tools.aj.a.a(r0, r4, r6)     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x0287
            r1.a((com.mbridge.msdk.click.entity.JumpLoaderResult) r8, (com.mbridge.msdk.foundation.entity.CampaignEx) r2, (boolean) r12)     // Catch:{ all -> 0x003f }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r1.f8038i     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x0283
            java.lang.String r3 = r2.getClickURL()     // Catch:{ all -> 0x003f }
            r0.onFinishRedirection(r2, r3)     // Catch:{ all -> 0x003f }
        L_0x0283:
            r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r2, (int) r13, (int) r13, (java.util.List<java.lang.String>) r5)     // Catch:{ all -> 0x003f }
            return
        L_0x0287:
            r2 = r3
            java.lang.String r3 = r19.getClickURL()     // Catch:{ all -> 0x003f }
            r6 = r5
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r5 = r1.f8038i     // Catch:{ all -> 0x003f }
            r4 = r19
            r1.a((int) r2, (java.lang.String) r3, (com.mbridge.msdk.foundation.entity.CampaignEx) r4, (com.mbridge.msdk.out.NativeListener.NativeTrackingListener) r5, (java.util.List<java.lang.String>) r6)     // Catch:{ all -> 0x003f }
            r2 = r4
            r1.a((com.mbridge.msdk.click.entity.JumpLoaderResult) r8, (com.mbridge.msdk.foundation.entity.CampaignEx) r2, (boolean) r12)     // Catch:{ all -> 0x003f }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r1.f8038i     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x03a6
            java.lang.String r3 = r2.getClickURL()     // Catch:{ all -> 0x003f }
            r0.onFinishRedirection(r2, r3)     // Catch:{ all -> 0x003f }
            return
        L_0x02a4:
            r11 = 2
            if (r14 == 0) goto L_0x0336
            java.lang.String r4 = r2.getClickURL()     // Catch:{ all -> 0x003f }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r14 = r1.f8038i     // Catch:{ all -> 0x003f }
            if (r14 == 0) goto L_0x02b2
            r14.onStartRedirection(r2, r4)     // Catch:{ all -> 0x003f }
        L_0x02b2:
            boolean r14 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x003f }
            if (r14 == 0) goto L_0x02c3
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r1.f8038i     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x02bf
            r0.onRedirectionFailed(r2, r4)     // Catch:{ all -> 0x003f }
        L_0x02bf:
            r1.a((com.mbridge.msdk.click.entity.JumpLoaderResult) r8, (com.mbridge.msdk.foundation.entity.CampaignEx) r2, (boolean) r13)     // Catch:{ all -> 0x003f }
            return
        L_0x02c3:
            if (r0 != r10) goto L_0x0304
            com.mbridge.msdk.foundation.entity.AabEntity r0 = r2.getAabEntity()     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x02f2
            com.mbridge.msdk.foundation.entity.AabEntity r0 = r2.getAabEntity()     // Catch:{ all -> 0x003f }
            int r0 = r0.getHlp()     // Catch:{ all -> 0x003f }
            if (r0 != r13) goto L_0x02f2
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r1.f8038i     // Catch:{ all -> 0x003f }
            if (r0 != 0) goto L_0x02e0
            com.mbridge.msdk.click.i r0 = r1.f8045p     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x02e0
            r0.onStartRedirection(r2, r4)     // Catch:{ all -> 0x003f }
        L_0x02e0:
            android.content.Context r3 = r1.f8036g     // Catch:{ all -> 0x003f }
            r17 = r4
            r4 = r0
            r0 = r3
            r3 = r1
            r1 = r17
            com.mbridge.msdk.foundation.tools.aj.a(r0, r1, r2, r3, r4, r5)     // Catch:{ all -> 0x02ee }
            r1 = r3
            goto L_0x0300
        L_0x02ee:
            r0 = move-exception
            r1 = r3
            goto L_0x039b
        L_0x02f2:
            android.content.Context r0 = r1.f8036g     // Catch:{ all -> 0x003f }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r3 = r1.f8038i     // Catch:{ all -> 0x003f }
            com.mbridge.msdk.foundation.tools.aj.a((android.content.Context) r0, (java.lang.String) r4, (com.mbridge.msdk.foundation.entity.CampaignEx) r2, (com.mbridge.msdk.out.NativeListener.NativeTrackingListener) r3, (java.util.List<java.lang.String>) r5)     // Catch:{ all -> 0x003f }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r1.f8038i     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x0300
            r0.onFinishRedirection(r2, r4)     // Catch:{ all -> 0x003f }
        L_0x0300:
            r1.a((com.mbridge.msdk.click.entity.JumpLoaderResult) r8, (com.mbridge.msdk.foundation.entity.CampaignEx) r2, (boolean) r12)     // Catch:{ all -> 0x003f }
            return
        L_0x0304:
            if (r0 != r9) goto L_0x0318
            android.content.Context r0 = r1.f8036g     // Catch:{ all -> 0x003f }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r3 = r1.f8038i     // Catch:{ all -> 0x003f }
            com.mbridge.msdk.foundation.tools.aj.a((android.content.Context) r0, (java.lang.String) r4, (com.mbridge.msdk.out.BaseTrackingListener) r3, (com.mbridge.msdk.foundation.entity.CampaignEx) r2, (java.util.List<java.lang.String>) r5)     // Catch:{ all -> 0x003f }
            r1.a((com.mbridge.msdk.click.entity.JumpLoaderResult) r8, (com.mbridge.msdk.foundation.entity.CampaignEx) r2, (boolean) r12)     // Catch:{ all -> 0x003f }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r1.f8038i     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x03a6
            r0.onFinishRedirection(r2, r4)     // Catch:{ all -> 0x003f }
            return
        L_0x0318:
            if (r0 != r6) goto L_0x032b
            if (r3 != r11) goto L_0x0324
            android.content.Context r0 = r1.f8036g     // Catch:{ all -> 0x003f }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r3 = r1.f8038i     // Catch:{ all -> 0x003f }
            com.mbridge.msdk.foundation.tools.aj.a((android.content.Context) r0, (java.lang.String) r4, (com.mbridge.msdk.foundation.entity.CampaignEx) r2, (com.mbridge.msdk.out.NativeListener.NativeTrackingListener) r3, (java.util.List<java.lang.String>) r5)     // Catch:{ all -> 0x003f }
            goto L_0x032b
        L_0x0324:
            android.content.Context r0 = r1.f8036g     // Catch:{ all -> 0x003f }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r3 = r1.f8038i     // Catch:{ all -> 0x003f }
            com.mbridge.msdk.foundation.tools.aj.a((android.content.Context) r0, (java.lang.String) r4, (com.mbridge.msdk.out.BaseTrackingListener) r3, (com.mbridge.msdk.foundation.entity.CampaignEx) r2, (java.util.List<java.lang.String>) r5)     // Catch:{ all -> 0x003f }
        L_0x032b:
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r1.f8038i     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x0332
            r0.onFinishRedirection(r2, r4)     // Catch:{ all -> 0x003f }
        L_0x0332:
            r1.a((com.mbridge.msdk.click.entity.JumpLoaderResult) r8, (com.mbridge.msdk.foundation.entity.CampaignEx) r2, (boolean) r12)     // Catch:{ all -> 0x003f }
            return
        L_0x0336:
            if (r0 != r11) goto L_0x0348
            boolean r0 = com.mbridge.msdk.e.b.a()     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x0344
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x003f }
            r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r2, (boolean) r12, (java.lang.Boolean) r0, (java.util.List<java.lang.String>) r5)     // Catch:{ all -> 0x003f }
            return
        L_0x0344:
            r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r2, (boolean) r12, (java.lang.Boolean) r4, (java.util.List<java.lang.String>) r5)     // Catch:{ all -> 0x003f }
            return
        L_0x0348:
            r3 = 3
            if (r0 != r3) goto L_0x0363
            java.lang.String r0 = "apk"
            r5.add(r0)     // Catch:{ all -> 0x003f }
            boolean r0 = com.mbridge.msdk.e.b.a()     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x035f
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x003f }
            r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r2, (boolean) r12, (java.lang.Boolean) r0, (java.util.List<java.lang.String>) r5)     // Catch:{ all -> 0x003f }
            r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r2, (int) r11, (int) r13, (java.util.List<java.lang.String>) r5)     // Catch:{ all -> 0x003f }
            return
        L_0x035f:
            r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r2, (boolean) r12, (java.lang.Boolean) r4, (java.util.List<java.lang.String>) r5)     // Catch:{ all -> 0x003f }
            return
        L_0x0363:
            java.lang.String r0 = r2.getClickURL()     // Catch:{ all -> 0x003f }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r3 = r1.f8038i     // Catch:{ all -> 0x003f }
            if (r3 == 0) goto L_0x036e
            r3.onStartRedirection(r2, r0)     // Catch:{ all -> 0x003f }
        L_0x036e:
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x003f }
            if (r3 == 0) goto L_0x037f
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r3 = r1.f8038i     // Catch:{ all -> 0x003f }
            if (r3 == 0) goto L_0x037b
            r3.onRedirectionFailed(r2, r0)     // Catch:{ all -> 0x003f }
        L_0x037b:
            r1.a((com.mbridge.msdk.click.entity.JumpLoaderResult) r8, (com.mbridge.msdk.foundation.entity.CampaignEx) r2, (boolean) r13)     // Catch:{ all -> 0x003f }
            return
        L_0x037f:
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r3 = r1.f8038i     // Catch:{ all -> 0x003f }
            if (r3 == 0) goto L_0x0386
            r3.onFinishRedirection(r2, r0)     // Catch:{ all -> 0x003f }
        L_0x0386:
            android.content.Context r3 = r1.f8036g     // Catch:{ all -> 0x003f }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r4 = r1.f8038i     // Catch:{ all -> 0x003f }
            com.mbridge.msdk.foundation.tools.aj.a((android.content.Context) r3, (java.lang.String) r0, (com.mbridge.msdk.out.BaseTrackingListener) r4, (com.mbridge.msdk.foundation.entity.CampaignEx) r2, (java.util.List<java.lang.String>) r5)     // Catch:{ all -> 0x003f }
            boolean r0 = com.mbridge.msdk.e.b.a()     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x0397
            r1.a((com.mbridge.msdk.click.entity.JumpLoaderResult) r8, (com.mbridge.msdk.foundation.entity.CampaignEx) r2, (boolean) r12)     // Catch:{ all -> 0x003f }
            return
        L_0x0397:
            r1.a((com.mbridge.msdk.click.entity.JumpLoaderResult) r8, (com.mbridge.msdk.foundation.entity.CampaignEx) r2, (boolean) r13)     // Catch:{ all -> 0x003f }
            return
        L_0x039b:
            boolean r2 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r2 == 0) goto L_0x03a6
            java.lang.String r2 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r7, r2, r0)
        L_0x03a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.entity.CampaignEx):void");
    }

    private AppletSchemeCallBack a(NativeListener.NativeTrackingListener nativeTrackingListener, CampaignEx campaignEx, AppletsModel appletsModel, a aVar) {
        return new g(nativeTrackingListener, campaignEx, appletsModel, aVar);
    }

    private void a(Context context, CampaignEx campaignEx, List<String> list) {
        if (context == null) {
            com.mbridge.msdk.foundation.same.report.i.a(c.m().c(), campaignEx, 2, "context is null", this.f8033d);
            return;
        }
        boolean z4 = ab.z() == 1;
        boolean z5 = ab.v(context) == 1;
        if (!z4 || !z5) {
            com.mbridge.msdk.foundation.same.report.i.a(context, campaignEx, 2, "integrated:" + z4 + "-hasWx:" + z5, this.f8033d);
            a(campaignEx, list);
            return;
        }
        String ghId = campaignEx.getGhId();
        String ghPath = campaignEx.getGhPath();
        String bindId = campaignEx.getBindId();
        String h5 = c.m().h();
        if (!TextUtils.isEmpty(ghId)) {
            try {
                if (!TextUtils.isEmpty(h5)) {
                    bindId = h5;
                }
                Object b5 = ab.b(bindId);
                Class<?> cls = Class.forName("com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram$Req");
                Object newInstance = cls.newInstance();
                cls.getField("userName").set(newInstance, ghId);
                cls.getField(MBridgeConstans.DYNAMIC_VIEW_WX_PATH).set(newInstance, ghPath);
                cls.getField("miniprogramType").set(newInstance, cls.getField("MINIPTOGRAM_TYPE_RELEASE").get((Object) null));
                Class.forName("com.tencent.mm.opensdk.openapi.IWXAPI").getMethod("sendReq", new Class[]{Class.forName("com.tencent.mm.opensdk.modelbase.BaseReq")}).invoke(b5, new Object[]{newInstance});
                com.mbridge.msdk.foundation.same.report.i.a(context, campaignEx, 1, "", this.f8033d);
            } catch (Throwable th) {
                com.mbridge.msdk.foundation.same.report.i.a(context, campaignEx, 2, th.getMessage(), this.f8033d);
                a(campaignEx, list);
            }
        } else {
            a(campaignEx, list);
            com.mbridge.msdk.foundation.same.report.i.a(context, campaignEx, 2, "ghid is empty", this.f8033d);
        }
    }

    private void a(CampaignEx campaignEx, List<String> list) {
        if (b() == 2) {
            aj.a(this.f8036g, campaignEx.getClickURL(), campaignEx, this.f8038i, list);
        } else {
            aj.a(this.f8036g, campaignEx.getClickURL(), (BaseTrackingListener) this.f8038i, campaignEx, list);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00fa A[Catch:{ Exception -> 0x001d }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x010b A[Catch:{ Exception -> 0x001d }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x011c A[Catch:{ Exception -> 0x001d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(final com.mbridge.msdk.foundation.entity.CampaignEx r12, final boolean r13, java.lang.Boolean r14, java.util.List<java.lang.String> r15) {
        /*
            r11 = this;
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x001d }
            r11.f8034e = r3     // Catch:{ Exception -> 0x001d }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r3 = r11.f8038i     // Catch:{ Exception -> 0x001d }
            r8 = 1
            if (r3 == 0) goto L_0x0020
            if (r13 != 0) goto L_0x0020
            java.lang.String r4 = r12.getClickURL()     // Catch:{ Exception -> 0x001d }
            r3.onStartRedirection(r12, r4)     // Catch:{ Exception -> 0x001d }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r3 = r11.f8038i     // Catch:{ Exception -> 0x001d }
            boolean r3 = r3.onInterceptDefaultLoadingDialog()     // Catch:{ Exception -> 0x001d }
            r3 = r3 ^ r8
            r9 = r3
            goto L_0x0021
        L_0x001d:
            r0 = move-exception
            goto L_0x0140
        L_0x0020:
            r9 = r8
        L_0x0021:
            r10 = 0
            r11.f8044o = r10     // Catch:{ Exception -> 0x001d }
            com.mbridge.msdk.click.entity.JumpLoaderResult r3 = r12.getJumpResult()     // Catch:{ Exception -> 0x001d }
            r4 = 1
            if (r3 == 0) goto L_0x003f
            if (r13 != 0) goto L_0x003a
            com.mbridge.msdk.click.entity.JumpLoaderResult r3 = r12.getJumpResult()     // Catch:{ Exception -> 0x001d }
            boolean r5 = r11.f8042m     // Catch:{ Exception -> 0x001d }
            r1 = r11
            r2 = r12
            r6 = r14
            r7 = r15
            r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r2, (com.mbridge.msdk.click.entity.JumpLoaderResult) r3, (boolean) r4, (boolean) r5, (java.lang.Boolean) r6, (java.util.List<java.lang.String>) r7)     // Catch:{ Exception -> 0x001d }
        L_0x003a:
            r11.f8044o = r8     // Catch:{ Exception -> 0x001d }
            r11.f8042m = r10     // Catch:{ Exception -> 0x001d }
            r4 = r10
        L_0x003f:
            com.mbridge.msdk.foundation.db.g r3 = r11.f8035f     // Catch:{ Exception -> 0x001d }
            com.mbridge.msdk.foundation.db.d r3 = com.mbridge.msdk.foundation.db.d.a(r3)     // Catch:{ Exception -> 0x001d }
            java.lang.String r5 = r12.getId()     // Catch:{ Exception -> 0x001d }
            java.lang.String r6 = r11.f8033d     // Catch:{ Exception -> 0x001d }
            boolean r3 = r3.a((java.lang.String) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x001d }
            if (r3 == 0) goto L_0x0057
            com.mbridge.msdk.click.entity.JumpLoaderResult r3 = r12.getJumpResult()     // Catch:{ Exception -> 0x001d }
            if (r3 != 0) goto L_0x011b
        L_0x0057:
            com.mbridge.msdk.foundation.db.g r3 = r11.f8035f     // Catch:{ Exception -> 0x001d }
            com.mbridge.msdk.foundation.db.d r3 = com.mbridge.msdk.foundation.db.d.a(r3)     // Catch:{ Exception -> 0x001d }
            r3.a()     // Catch:{ Exception -> 0x001d }
            java.lang.String r5 = r12.getId()     // Catch:{ Exception -> 0x001d }
            java.lang.String r6 = r11.f8033d     // Catch:{ Exception -> 0x001d }
            com.mbridge.msdk.click.entity.JumpLoaderResult r3 = r3.b(r5, r6)     // Catch:{ Exception -> 0x001d }
            if (r3 == 0) goto L_0x0084
            if (r13 != 0) goto L_0x0084
            r12.setJumpResult(r3)     // Catch:{ Exception -> 0x001d }
            if (r4 == 0) goto L_0x0082
            boolean r5 = r11.f8042m     // Catch:{ Exception -> 0x001d }
            r1 = r11
            r2 = r12
            r6 = r14
            r7 = r15
            r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r2, (com.mbridge.msdk.click.entity.JumpLoaderResult) r3, (boolean) r4, (boolean) r5, (java.lang.Boolean) r6, (java.util.List<java.lang.String>) r7)     // Catch:{ Exception -> 0x001d }
            r11.f8044o = r8     // Catch:{ Exception -> 0x001d }
            r11.f8042m = r10     // Catch:{ Exception -> 0x001d }
        L_0x0080:
            r3 = r10
            goto L_0x00e5
        L_0x0082:
            r3 = r4
            goto L_0x00e5
        L_0x0084:
            java.lang.String r3 = r12.getClick_mode()     // Catch:{ Exception -> 0x001d }
            java.lang.String r5 = "6"
            boolean r3 = r3.equals(r5)     // Catch:{ Exception -> 0x001d }
            if (r3 == 0) goto L_0x00de
            java.lang.String r3 = r12.getPackageName()     // Catch:{ Exception -> 0x001d }
            boolean r3 = r3.isEmpty()     // Catch:{ Exception -> 0x001d }
            if (r3 != 0) goto L_0x00de
            int r3 = r12.getLinkType()     // Catch:{ Exception -> 0x001d }
            r5 = 2
            if (r3 != r5) goto L_0x00de
            if (r13 != 0) goto L_0x00de
            android.content.Context r3 = r11.f8036g     // Catch:{ Exception -> 0x001d }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x001d }
            r5.<init>()     // Catch:{ Exception -> 0x001d }
            java.lang.String r6 = "market://details?id="
            r5.append(r6)     // Catch:{ Exception -> 0x001d }
            java.lang.String r6 = r12.getPackageName()     // Catch:{ Exception -> 0x001d }
            r5.append(r6)     // Catch:{ Exception -> 0x001d }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x001d }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r6 = r11.f8038i     // Catch:{ Exception -> 0x001d }
            boolean r3 = com.mbridge.msdk.foundation.tools.aj.a.a(r3, r5, r6)     // Catch:{ Exception -> 0x001d }
            if (r15 == 0) goto L_0x00c7
            java.lang.String r5 = "google_play"
            r15.add(r5)     // Catch:{ Exception -> 0x001d }
        L_0x00c7:
            if (r3 == 0) goto L_0x00cc
            r11.a((com.mbridge.msdk.foundation.entity.CampaignEx) r12, (int) r8, (int) r8, (java.util.List<java.lang.String>) r15)     // Catch:{ Exception -> 0x001d }
        L_0x00cc:
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r3 = r11.f8038i     // Catch:{ Exception -> 0x001d }
            if (r3 == 0) goto L_0x00db
            if (r4 == 0) goto L_0x00db
            r3.onDismissLoading(r12)     // Catch:{ Exception -> 0x001d }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r3 = r11.f8038i     // Catch:{ Exception -> 0x001d }
            r4 = 0
            r3.onFinishRedirection(r12, r4)     // Catch:{ Exception -> 0x001d }
        L_0x00db:
            r11.f8044o = r8     // Catch:{ Exception -> 0x001d }
            r4 = r10
        L_0x00de:
            if (r13 == 0) goto L_0x0082
            r11.f8044o = r8     // Catch:{ Exception -> 0x001d }
            r11.f8042m = r10     // Catch:{ Exception -> 0x001d }
            goto L_0x0080
        L_0x00e5:
            android.os.Handler r4 = new android.os.Handler     // Catch:{ Exception -> 0x001d }
            android.os.Looper r5 = android.os.Looper.getMainLooper()     // Catch:{ Exception -> 0x001d }
            r4.<init>(r5)     // Catch:{ Exception -> 0x001d }
            com.mbridge.msdk.click.a$3 r5 = new com.mbridge.msdk.click.a$3     // Catch:{ Exception -> 0x001d }
            r5.<init>(r9, r13, r12)     // Catch:{ Exception -> 0x001d }
            r4.post(r5)     // Catch:{ Exception -> 0x001d }
            com.mbridge.msdk.click.d r0 = r11.f8037h     // Catch:{ Exception -> 0x001d }
            if (r0 == 0) goto L_0x00fd
            r0.a()     // Catch:{ Exception -> 0x001d }
        L_0x00fd:
            java.util.Set<java.lang.String> r0 = f8032c     // Catch:{ Exception -> 0x001d }
            if (r0 == 0) goto L_0x011c
            java.lang.String r4 = r12.getId()     // Catch:{ Exception -> 0x001d }
            boolean r0 = r0.contains(r4)     // Catch:{ Exception -> 0x001d }
            if (r0 == 0) goto L_0x011c
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r11.f8038i     // Catch:{ Exception -> 0x001d }
            if (r0 == 0) goto L_0x011b
            r0.onDismissLoading(r12)     // Catch:{ Exception -> 0x001d }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r11.f8038i     // Catch:{ Exception -> 0x001d }
            java.lang.String r3 = r12.getClickURL()     // Catch:{ Exception -> 0x001d }
            r0.onFinishRedirection(r12, r3)     // Catch:{ Exception -> 0x001d }
        L_0x011b:
            return
        L_0x011c:
            java.util.Set<java.lang.String> r0 = f8032c     // Catch:{ Exception -> 0x001d }
            if (r0 == 0) goto L_0x0127
            java.lang.String r4 = r12.getId()     // Catch:{ Exception -> 0x001d }
            r0.add(r4)     // Catch:{ Exception -> 0x001d }
        L_0x0127:
            com.mbridge.msdk.click.d r8 = new com.mbridge.msdk.click.d     // Catch:{ Exception -> 0x001d }
            android.content.Context r0 = r11.f8036g     // Catch:{ Exception -> 0x001d }
            r8.<init>(r0)     // Catch:{ Exception -> 0x001d }
            r11.f8037h = r8     // Catch:{ Exception -> 0x001d }
            java.lang.String r10 = r11.f8033d     // Catch:{ Exception -> 0x001d }
            com.mbridge.msdk.click.a$4 r0 = new com.mbridge.msdk.click.a$4     // Catch:{ Exception -> 0x001d }
            r1 = r11
            r2 = r12
            r4 = r14
            r5 = r15
            r6 = r9
            r0.<init>(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x001d }
            r8.a(r10, r12, r0)     // Catch:{ Exception -> 0x001d }
            return
        L_0x0140:
            r0.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.entity.CampaignEx, boolean, java.lang.Boolean, java.util.List):void");
    }

    public final void a(JumpLoaderResult jumpLoaderResult, CampaignEx campaignEx, int i5, boolean z4) {
        if (campaignEx != null && jumpLoaderResult != null) {
            try {
                long currentTimeMillis = System.currentTimeMillis() - this.f8034e;
                e eVar = new e();
                int m5 = ab.m(this.f8036g);
                eVar.a(m5);
                eVar.c(ab.a(this.f8036g, m5));
                eVar.b(campaignEx.getRequestId());
                eVar.k(campaignEx.getRequestIdNotice());
                eVar.b(i5);
                eVar.i(currentTimeMillis + "");
                eVar.j(campaignEx.getId());
                eVar.c(jumpLoaderResult.getType());
                if (!TextUtils.isEmpty(jumpLoaderResult.getUrl())) {
                    eVar.h(URLEncoder.encode(jumpLoaderResult.getUrl(), "utf-8"));
                }
                eVar.e((this.f8034e / 1000) + "");
                eVar.d(Integer.parseInt(campaignEx.getLandingType()));
                eVar.e(campaignEx.getLinkType());
                eVar.a(this.f8033d);
                eVar.c(jumpLoaderResult.getType());
                if (!TextUtils.isEmpty(jumpLoaderResult.getUrl())) {
                    eVar.h(URLEncoder.encode(jumpLoaderResult.getUrl(), "utf-8"));
                }
                if (this.f8041l) {
                    eVar.f(jumpLoaderResult.getStatusCode());
                    if (!TextUtils.isEmpty(jumpLoaderResult.getHeader())) {
                        eVar.f(URLEncoder.encode(jumpLoaderResult.getHeader(), "utf-8"));
                    }
                    if (!TextUtils.isEmpty(jumpLoaderResult.getContent())) {
                        eVar.g(URLEncoder.encode(jumpLoaderResult.getContent(), C.UTF8_NAME));
                    }
                    if (!TextUtils.isEmpty(jumpLoaderResult.getExceptionMsg())) {
                        eVar.d(URLEncoder.encode(jumpLoaderResult.getExceptionMsg(), "utf-8"));
                    }
                }
                if (z4) {
                    JSONObject a5 = e.a(eVar);
                    if (a5 != null) {
                        d.a().a(a5);
                        return;
                    }
                    return;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(eVar);
                ArrayList<JSONObject> a6 = e.a((List<e>) arrayList);
                if (a6 != null && !a6.isEmpty()) {
                    int size = a6.size();
                    int i6 = 0;
                    while (i6 < size) {
                        JSONObject jSONObject = a6.get(i6);
                        i6++;
                        d.a().a(jSONObject);
                    }
                }
            } catch (Throwable th) {
                af.b("CommonClickControl", th.getMessage());
            }
        }
    }

    public final void a(Campaign campaign, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (campaign != null) {
                CampaignEx campaignEx = campaign instanceof CampaignEx ? (CampaignEx) campaign : null;
                if (!str.startsWith("market://")) {
                    if (!str.startsWith("https://play.google.com/")) {
                        return;
                    }
                }
                if (!aj.a.a(this.f8036g, str, this.f8038i) && campaignEx != null) {
                    if (!TextUtils.isEmpty(campaignEx.getPackageName())) {
                        Context context = this.f8036g;
                        aj.a.a(context, "market://details?id=" + campaignEx.getPackageName(), this.f8038i);
                    } else if (b() == 2) {
                        aj.a(this.f8036g, campaignEx.getClickURL(), campaignEx, this.f8038i, (List<String>) new ArrayList());
                    } else {
                        aj.a(this.f8036g, campaignEx.getClickURL(), (BaseTrackingListener) this.f8038i, campaignEx, (List<String>) new ArrayList());
                    }
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void a(JumpLoaderResult jumpLoaderResult, CampaignEx campaignEx, boolean z4) {
        a(jumpLoaderResult, campaignEx, 1, z4);
    }

    private void a(int i5, String str, CampaignEx campaignEx, NativeListener.NativeTrackingListener nativeTrackingListener, List<String> list) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (i5 == 2) {
                aj.a(this.f8036g, str, campaignEx, nativeTrackingListener, list);
            } else {
                aj.a(this.f8036g, str, (BaseTrackingListener) nativeTrackingListener, campaignEx, list);
            }
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                af.b("CommonClickControl", th.getMessage(), th);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(com.mbridge.msdk.foundation.entity.CampaignEx r10, com.mbridge.msdk.click.entity.JumpLoaderResult r11, boolean r12, int r13, java.util.List<java.lang.String> r14) {
        /*
            r9 = this;
            r7 = 1
            r8 = 0
            if (r12 == 0) goto L_0x007d
            java.lang.String r2 = r10.getLandingType()     // Catch:{ all -> 0x001c }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ all -> 0x001c }
            if (r2 != r7) goto L_0x0020
            android.content.Context r2 = r9.f8036g     // Catch:{ all -> 0x001c }
            java.lang.String r3 = r11.getUrl()     // Catch:{ all -> 0x001c }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r5 = r9.f8038i     // Catch:{ all -> 0x001c }
            com.mbridge.msdk.foundation.tools.aj.a((android.content.Context) r2, (java.lang.String) r3, (com.mbridge.msdk.out.BaseTrackingListener) r5, (com.mbridge.msdk.foundation.entity.CampaignEx) r10, (java.util.List<java.lang.String>) r14)     // Catch:{ all -> 0x001c }
        L_0x0019:
            r8 = r7
            goto L_0x007d
        L_0x001c:
            r0 = move-exception
            r7 = r8
            goto L_0x009f
        L_0x0020:
            r3 = 2
            if (r2 != r3) goto L_0x002f
            android.content.Context r2 = r9.f8036g     // Catch:{ all -> 0x001c }
            java.lang.String r3 = r11.getUrl()     // Catch:{ all -> 0x001c }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r5 = r9.f8038i     // Catch:{ all -> 0x001c }
            com.mbridge.msdk.foundation.tools.aj.a((android.content.Context) r2, (java.lang.String) r3, (com.mbridge.msdk.foundation.entity.CampaignEx) r10, (com.mbridge.msdk.out.NativeListener.NativeTrackingListener) r5, (java.util.List<java.lang.String>) r14)     // Catch:{ all -> 0x001c }
            goto L_0x0019
        L_0x002f:
            java.lang.String r2 = r10.getPackageName()     // Catch:{ all -> 0x001c }
            if (r2 == 0) goto L_0x0070
            android.content.Context r2 = r9.f8036g     // Catch:{ all -> 0x001c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x001c }
            r3.<init>()     // Catch:{ all -> 0x001c }
            java.lang.String r5 = "market://details?id="
            r3.append(r5)     // Catch:{ all -> 0x001c }
            java.lang.String r5 = r10.getPackageName()     // Catch:{ all -> 0x001c }
            r3.append(r5)     // Catch:{ all -> 0x001c }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x001c }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r5 = r9.f8038i     // Catch:{ all -> 0x001c }
            boolean r2 = com.mbridge.msdk.foundation.tools.aj.a.a(r2, r3, r5)     // Catch:{ all -> 0x001c }
            if (r2 == 0) goto L_0x0062
            if (r14 == 0) goto L_0x005e
            java.lang.String r2 = "google_play"
            r14.add(r2)     // Catch:{ all -> 0x005c }
            goto L_0x005e
        L_0x005c:
            r0 = move-exception
            goto L_0x009f
        L_0x005e:
            r9.a((com.mbridge.msdk.foundation.entity.CampaignEx) r10, (int) r7, (int) r7, (java.util.List<java.lang.String>) r14)     // Catch:{ all -> 0x005c }
            goto L_0x0019
        L_0x0062:
            java.lang.String r3 = r11.getUrl()     // Catch:{ all -> 0x001c }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r5 = r9.f8038i     // Catch:{ all -> 0x001c }
            r1 = r9
            r4 = r10
            r2 = r13
            r6 = r14
            r1.a((int) r2, (java.lang.String) r3, (com.mbridge.msdk.foundation.entity.CampaignEx) r4, (com.mbridge.msdk.out.NativeListener.NativeTrackingListener) r5, (java.util.List<java.lang.String>) r6)     // Catch:{ all -> 0x001c }
            goto L_0x007d
        L_0x0070:
            java.lang.String r3 = r11.getUrl()     // Catch:{ all -> 0x001c }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r5 = r9.f8038i     // Catch:{ all -> 0x001c }
            r1 = r9
            r4 = r10
            r2 = r13
            r6 = r14
            r1.a((int) r2, (java.lang.String) r3, (com.mbridge.msdk.foundation.entity.CampaignEx) r4, (com.mbridge.msdk.out.NativeListener.NativeTrackingListener) r5, (java.util.List<java.lang.String>) r6)     // Catch:{ all -> 0x001c }
        L_0x007d:
            if (r8 == 0) goto L_0x008e
            r9.a((com.mbridge.msdk.click.entity.JumpLoaderResult) r11, (com.mbridge.msdk.foundation.entity.CampaignEx) r10, (boolean) r7)     // Catch:{ all -> 0x001c }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r2 = r9.f8038i     // Catch:{ all -> 0x001c }
            if (r2 == 0) goto L_0x009e
            java.lang.String r0 = r11.getUrl()     // Catch:{ all -> 0x001c }
            r2.onFinishRedirection(r10, r0)     // Catch:{ all -> 0x001c }
            return r8
        L_0x008e:
            r9.a((com.mbridge.msdk.click.entity.JumpLoaderResult) r11, (com.mbridge.msdk.foundation.entity.CampaignEx) r10, (boolean) r7)     // Catch:{ all -> 0x001c }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r2 = r9.f8038i     // Catch:{ all -> 0x001c }
            if (r2 == 0) goto L_0x009e
            if (r12 == 0) goto L_0x009e
            java.lang.String r0 = r11.getUrl()     // Catch:{ all -> 0x001c }
            r2.onRedirectionFailed(r10, r0)     // Catch:{ all -> 0x001c }
        L_0x009e:
            return r8
        L_0x009f:
            boolean r2 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r2 == 0) goto L_0x00ac
            java.lang.String r2 = "CommonClickControl"
            java.lang.String r3 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r2, r3, r0)
        L_0x00ac:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.entity.CampaignEx, com.mbridge.msdk.click.entity.JumpLoaderResult, boolean, int, java.util.List):boolean");
    }

    private boolean a(CampaignEx campaignEx, JumpLoaderResult jumpLoaderResult, boolean z4, List<String> list) {
        boolean z5 = false;
        if (z4) {
            try {
                if (b.a()) {
                    b.a(this.f8036g, this.f8033d, campaignEx, campaignEx.getNoticeUrl(), com.mbridge.msdk.foundation.same.a.f9170M);
                }
                aj.a(this.f8036g, campaignEx.getClickURL(), (BaseTrackingListener) this.f8038i, campaignEx, list);
                z5 = true;
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    af.b("CommonClickControl", th.getMessage(), th);
                }
                return false;
            }
        }
        a(jumpLoaderResult, campaignEx, true);
        if (z5) {
            NativeListener.NativeTrackingListener nativeTrackingListener = this.f8038i;
            if (nativeTrackingListener != null) {
                nativeTrackingListener.onFinishRedirection(campaignEx, jumpLoaderResult.getUrl());
                return z5;
            }
        } else {
            if (b.a()) {
                a(jumpLoaderResult, campaignEx, true);
            }
            NativeListener.NativeTrackingListener nativeTrackingListener2 = this.f8038i;
            if (nativeTrackingListener2 != null) {
                nativeTrackingListener2.onRedirectionFailed(campaignEx, jumpLoaderResult.getUrl());
            }
        }
        return z5;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c2, code lost:
        if (com.mbridge.msdk.foundation.tools.aj.a.a(r0, "market://details?id=" + r9.getPackageName(), r8.f8038i) == false) goto L_0x00c4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.mbridge.msdk.foundation.entity.CampaignEx r9, com.mbridge.msdk.click.entity.JumpLoaderResult r10, boolean r11, boolean r12, java.lang.Boolean r13, java.util.List<java.lang.String> r14) {
        /*
            r8 = this;
            boolean r0 = r8.f8043n     // Catch:{ Exception -> 0x001e }
            if (r0 != 0) goto L_0x0006
            goto L_0x0164
        L_0x0006:
            r7 = 1
            if (r9 == 0) goto L_0x0157
            if (r10 != 0) goto L_0x000d
            goto L_0x0157
        L_0x000d:
            int r2 = r8.b()     // Catch:{ Exception -> 0x001e }
            int r0 = r10.getCode()     // Catch:{ Exception -> 0x001e }
            if (r13 == 0) goto L_0x0021
            boolean r3 = r13.booleanValue()     // Catch:{ Exception -> 0x001e }
            if (r3 != 0) goto L_0x0021
            return
        L_0x001e:
            r0 = move-exception
            goto L_0x0165
        L_0x0021:
            java.lang.String r3 = r10.getUrl()     // Catch:{ Exception -> 0x001e }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x001e }
            r4 = 2
            r5 = 3
            if (r3 == 0) goto L_0x0063
            if (r11 == 0) goto L_0x0063
            int r0 = r9.getLinkType()     // Catch:{ Exception -> 0x001e }
            if (r0 != r4) goto L_0x0042
            int r5 = r8.b()     // Catch:{ Exception -> 0x001e }
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r6 = r14
            r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r2, (com.mbridge.msdk.click.entity.JumpLoaderResult) r3, (boolean) r4, (int) r5, (java.util.List<java.lang.String>) r6)     // Catch:{ Exception -> 0x001e }
            return
        L_0x0042:
            r6 = r14
            if (r0 != r5) goto L_0x0049
            r8.a((com.mbridge.msdk.foundation.entity.CampaignEx) r9, (com.mbridge.msdk.click.entity.JumpLoaderResult) r10, (boolean) r11, (java.util.List<java.lang.String>) r14)     // Catch:{ Exception -> 0x001e }
            return
        L_0x0049:
            android.content.Context r0 = r8.f8036g     // Catch:{ Exception -> 0x001e }
            java.lang.String r2 = r9.getClickURL()     // Catch:{ Exception -> 0x001e }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r4 = r8.f8038i     // Catch:{ Exception -> 0x001e }
            com.mbridge.msdk.foundation.tools.aj.a((android.content.Context) r0, (java.lang.String) r2, (com.mbridge.msdk.out.BaseTrackingListener) r4, (com.mbridge.msdk.foundation.entity.CampaignEx) r9, (java.util.List<java.lang.String>) r14)     // Catch:{ Exception -> 0x001e }
            r8.a((com.mbridge.msdk.click.entity.JumpLoaderResult) r10, (com.mbridge.msdk.foundation.entity.CampaignEx) r9, (boolean) r7)     // Catch:{ Exception -> 0x001e }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r8.f8038i     // Catch:{ Exception -> 0x001e }
            if (r0 == 0) goto L_0x0164
            java.lang.String r2 = r10.getUrl()     // Catch:{ Exception -> 0x001e }
            r0.onFinishRedirection(r9, r2)     // Catch:{ Exception -> 0x001e }
            return
        L_0x0063:
            r6 = r14
            if (r0 != r7) goto L_0x00dd
            java.lang.String r0 = r9.getPackageName()     // Catch:{ Exception -> 0x001e }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x001e }
            if (r0 != 0) goto L_0x0099
            java.lang.String r0 = r10.getUrl()     // Catch:{ Exception -> 0x001e }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x001e }
            if (r0 != 0) goto L_0x0099
            java.lang.String r0 = r10.getUrl()     // Catch:{ Exception -> 0x001e }
            java.lang.String r4 = r9.getPackageName()     // Catch:{ Exception -> 0x001e }
            boolean r0 = r0.contains(r4)     // Catch:{ Exception -> 0x001e }
            if (r0 == 0) goto L_0x0099
            if (r11 == 0) goto L_0x0099
            android.content.Context r0 = r8.f8036g     // Catch:{ Exception -> 0x001e }
            java.lang.String r4 = r10.getUrl()     // Catch:{ Exception -> 0x001e }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r5 = r8.f8038i     // Catch:{ Exception -> 0x001e }
            boolean r0 = com.mbridge.msdk.foundation.tools.aj.a.a(r0, r4, r5)     // Catch:{ Exception -> 0x001e }
            if (r0 != 0) goto L_0x00cf
            goto L_0x00c4
        L_0x0099:
            if (r11 == 0) goto L_0x00cf
            java.lang.String r0 = r9.getPackageName()     // Catch:{ Exception -> 0x001e }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x001e }
            if (r0 != 0) goto L_0x00c4
            android.content.Context r0 = r8.f8036g     // Catch:{ Exception -> 0x001e }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x001e }
            r4.<init>()     // Catch:{ Exception -> 0x001e }
            java.lang.String r5 = "market://details?id="
            r4.append(r5)     // Catch:{ Exception -> 0x001e }
            java.lang.String r5 = r9.getPackageName()     // Catch:{ Exception -> 0x001e }
            r4.append(r5)     // Catch:{ Exception -> 0x001e }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x001e }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r5 = r8.f8038i     // Catch:{ Exception -> 0x001e }
            boolean r0 = com.mbridge.msdk.foundation.tools.aj.a.a(r0, r4, r5)     // Catch:{ Exception -> 0x001e }
            if (r0 != 0) goto L_0x00cf
        L_0x00c4:
            java.lang.String r3 = r10.getUrl()     // Catch:{ Exception -> 0x001e }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r5 = r8.f8038i     // Catch:{ Exception -> 0x001e }
            r1 = r8
            r4 = r9
            r1.a((int) r2, (java.lang.String) r3, (com.mbridge.msdk.foundation.entity.CampaignEx) r4, (com.mbridge.msdk.out.NativeListener.NativeTrackingListener) r5, (java.util.List<java.lang.String>) r6)     // Catch:{ Exception -> 0x001e }
        L_0x00cf:
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r8.f8038i     // Catch:{ Exception -> 0x001e }
            if (r0 == 0) goto L_0x0131
            if (r11 == 0) goto L_0x0131
            java.lang.String r1 = r10.getUrl()     // Catch:{ Exception -> 0x001e }
            r0.onFinishRedirection(r9, r1)     // Catch:{ Exception -> 0x001e }
            goto L_0x0131
        L_0x00dd:
            if (r0 != r5) goto L_0x00fc
            if (r11 == 0) goto L_0x00ee
            android.content.Context r0 = r8.f8036g     // Catch:{ Exception -> 0x001e }
            java.lang.String r2 = r8.f8033d     // Catch:{ Exception -> 0x001e }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r5 = r8.f8038i     // Catch:{ Exception -> 0x001e }
            r1 = r9
            r3 = r10
            r4 = r13
            r6 = r14
            com.mbridge.msdk.click.b.a(r0, r1, r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x001e }
        L_0x00ee:
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r8.f8038i     // Catch:{ Exception -> 0x001e }
            if (r0 == 0) goto L_0x0131
            if (r11 == 0) goto L_0x0131
            java.lang.String r1 = r10.getUrl()     // Catch:{ Exception -> 0x001e }
            r0.onFinishRedirection(r9, r1)     // Catch:{ Exception -> 0x001e }
            goto L_0x0131
        L_0x00fc:
            r6 = r14
            if (r11 == 0) goto L_0x0131
            int r0 = r9.getLinkType()     // Catch:{ Exception -> 0x001e }
            if (r5 != r0) goto L_0x0109
            r8.a((com.mbridge.msdk.foundation.entity.CampaignEx) r9, (com.mbridge.msdk.click.entity.JumpLoaderResult) r10, (boolean) r11, (java.util.List<java.lang.String>) r14)     // Catch:{ Exception -> 0x001e }
            return
        L_0x0109:
            int r0 = r9.getLinkType()     // Catch:{ Exception -> 0x001e }
            if (r4 != r0) goto L_0x011b
            int r5 = r8.b()     // Catch:{ Exception -> 0x001e }
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r2, (com.mbridge.msdk.click.entity.JumpLoaderResult) r3, (boolean) r4, (int) r5, (java.util.List<java.lang.String>) r6)     // Catch:{ Exception -> 0x001e }
            return
        L_0x011b:
            android.content.Context r0 = r8.f8036g     // Catch:{ Exception -> 0x001e }
            java.lang.String r4 = r10.getUrl()     // Catch:{ Exception -> 0x001e }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r5 = r8.f8038i     // Catch:{ Exception -> 0x001e }
            com.mbridge.msdk.foundation.tools.aj.a((android.content.Context) r0, (java.lang.String) r4, (com.mbridge.msdk.out.BaseTrackingListener) r5, (com.mbridge.msdk.foundation.entity.CampaignEx) r9, (java.util.List<java.lang.String>) r14)     // Catch:{ Exception -> 0x001e }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r8.f8038i     // Catch:{ Exception -> 0x001e }
            if (r0 == 0) goto L_0x0131
            java.lang.String r4 = r10.getUrl()     // Catch:{ Exception -> 0x001e }
            r0.onFinishRedirection(r9, r4)     // Catch:{ Exception -> 0x001e }
        L_0x0131:
            int r0 = r9.getLinkType()     // Catch:{ Exception -> 0x001e }
            java.lang.String r4 = r10.getUrl()     // Catch:{ Exception -> 0x001e }
            boolean r0 = r8.a((int) r0, (java.lang.String) r4)     // Catch:{ Exception -> 0x001e }
            if (r0 == 0) goto L_0x0144
            r0 = 0
            r8.a((com.mbridge.msdk.click.entity.JumpLoaderResult) r10, (com.mbridge.msdk.foundation.entity.CampaignEx) r9, (boolean) r0)     // Catch:{ Exception -> 0x001e }
            goto L_0x0147
        L_0x0144:
            r8.a((com.mbridge.msdk.click.entity.JumpLoaderResult) r10, (com.mbridge.msdk.foundation.entity.CampaignEx) r9, (boolean) r7)     // Catch:{ Exception -> 0x001e }
        L_0x0147:
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r8.f8038i     // Catch:{ Exception -> 0x001e }
            if (r0 == 0) goto L_0x0164
            if (r11 != 0) goto L_0x0164
            if (r12 == 0) goto L_0x0164
            java.lang.String r3 = r10.getUrl()     // Catch:{ Exception -> 0x001e }
            r0.onFinishRedirection(r9, r3)     // Catch:{ Exception -> 0x001e }
            return
        L_0x0157:
            if (r11 == 0) goto L_0x0164
            r8.a((com.mbridge.msdk.click.entity.JumpLoaderResult) r10, (com.mbridge.msdk.foundation.entity.CampaignEx) r9, (boolean) r7)     // Catch:{ Exception -> 0x001e }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r8.f8038i     // Catch:{ Exception -> 0x001e }
            if (r0 == 0) goto L_0x0164
            r2 = 0
            r0.onRedirectionFailed(r2, r2)     // Catch:{ Exception -> 0x001e }
        L_0x0164:
            return
        L_0x0165:
            r0.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.entity.CampaignEx, com.mbridge.msdk.click.entity.JumpLoaderResult, boolean, boolean, java.lang.Boolean, java.util.List):void");
    }

    private boolean a(int i5, String str) {
        if (i5 == 2) {
            try {
                if (aj.a.b(str)) {
                    return true;
                }
            } catch (Exception e5) {
                e5.printStackTrace();
                return false;
            }
        } else if (!TextUtils.isEmpty(str)) {
            return true;
        }
        return false;
    }

    private void a(CampaignEx campaignEx, int i5, int i6, List<String> list) {
        try {
            com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
            eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, Integer.valueOf(i5));
            eVar.a("result", Integer.valueOf(i6));
            if (list != null) {
                eVar.a("click_path", list.toString());
            }
            d.a().a("2000150", campaignEx, eVar);
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b("CommonClickControl", e5.getMessage());
            }
        }
    }

    public static void a(Context context, final CampaignEx campaignEx, String str, final String str2, boolean z4, boolean z5, final int i5) {
        if (context != null) {
            if (campaignEx != null) {
                try {
                    String b5 = b(i5);
                    com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                    eVar.a("result", 3);
                    d.a().a(b5, campaignEx, eVar);
                } catch (Exception e5) {
                    if (MBridgeConstans.DEBUG) {
                        e5.printStackTrace();
                    }
                }
            }
            final int i6 = TextUtils.isEmpty(str2) ? -1 : str2.startsWith("tcp") ? 1 : 0;
            new d(context.getApplicationContext()).a(str, campaignEx, new f() {
                public final void a(Object obj) {
                }

                public final void b(Object obj) {
                    try {
                        com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                        eVar.a("result", 2);
                        eVar.a("net_ty", String.valueOf(i6));
                        if (obj != null && (obj instanceof JumpLoaderResult)) {
                            JumpLoaderResult jumpLoaderResult = (JumpLoaderResult) obj;
                            String str = jumpLoaderResult.getStatusCode() + "";
                            eVar.a("status_code", str);
                            if (str.startsWith("2")) {
                                eVar.a("result", 1);
                            } else {
                                String exceptionMsg = jumpLoaderResult.getExceptionMsg();
                                if (TextUtils.isEmpty(exceptionMsg)) {
                                    exceptionMsg = "UNKNOWN EXCEPTION and Status Code is : " + str;
                                }
                                eVar.a("failingURL", aq.d(str2));
                                eVar.a("reason", exceptionMsg);
                            }
                        }
                        String a5 = a.b(i5);
                        if (campaignEx != null) {
                            d.a().a(a5, campaignEx, eVar);
                        }
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("CommonClickControl", e5.getMessage());
                        }
                    }
                }

                public final void a(Object obj, String str) {
                    try {
                        String a5 = a.b(i5);
                        com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                        eVar.a("result", 2);
                        if (obj instanceof JumpLoaderResult) {
                            JumpLoaderResult jumpLoaderResult = (JumpLoaderResult) obj;
                            String exceptionMsg = jumpLoaderResult.getExceptionMsg();
                            if (!TextUtils.isEmpty(exceptionMsg)) {
                                str = exceptionMsg;
                            }
                            eVar.a("reason", str);
                            eVar.a("status_code", Integer.valueOf(jumpLoaderResult.getStatusCode()));
                        }
                        eVar.a("code", "");
                        eVar.a("failingURL", aq.d(str2));
                        eVar.a("net_ty", String.valueOf(i6));
                        if (campaignEx != null) {
                            d.a().a(a5, campaignEx, eVar);
                        }
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("CommonClickControl", e5.getMessage());
                        }
                    }
                }
            }, str2, z4, z5, i5);
        }
    }

    static /* synthetic */ void a(a aVar, CampaignEx campaignEx) {
        try {
            Intent intent = new Intent(aVar.f8036g, LoadingActivity.class);
            intent.setFlags(268435456);
            intent.putExtra(CampaignEx.JSON_KEY_ICON_URL, campaignEx.getIconUrl());
            aVar.f8036g.startActivity(intent);
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b("CommonClickControl", "Exception", e5);
            }
        }
    }
}
