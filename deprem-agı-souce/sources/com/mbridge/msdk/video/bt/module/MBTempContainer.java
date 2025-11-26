package com.mbridge.msdk.video.bt.module;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.davemorrissey.labs.subscaleview.BuildConfig;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.s;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbsignalcommon.mraid.d;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.mbridge.msdk.scheme.applet.AppletModelManager;
import com.mbridge.msdk.scheme.applet.AppletSchemeCallBack;
import com.mbridge.msdk.scheme.applet.AppletsModel;
import com.mbridge.msdk.video.bt.module.b.h;
import com.mbridge.msdk.video.module.MBridgeContainerView;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.video.module.a.a.m;
import com.mbridge.msdk.video.module.a.a.n;
import com.mbridge.msdk.video.signal.a;
import com.mbridge.msdk.video.signal.a.a;
import com.mbridge.msdk.video.signal.a.k;
import com.mbridge.msdk.videocommon.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class MBTempContainer extends MBTempContainerDiff {
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public static final String f11832x = "MBTempContainer";

    /* renamed from: A  reason: collision with root package name */
    private com.mbridge.msdk.videocommon.download.a f11833A;
    /* access modifiers changed from: private */

    /* renamed from: B  reason: collision with root package name */
    public h f11834B;
    /* access modifiers changed from: private */

    /* renamed from: C  reason: collision with root package name */
    public com.mbridge.msdk.video.bt.module.a.b f11835C;

    /* renamed from: D  reason: collision with root package name */
    private com.mbridge.msdk.video.dynview.e.a f11836D;
    /* access modifiers changed from: private */

    /* renamed from: E  reason: collision with root package name */
    public int f11837E = 1;
    /* access modifiers changed from: private */

    /* renamed from: F  reason: collision with root package name */
    public String f11838F = "";

    /* renamed from: G  reason: collision with root package name */
    private com.mbridge.msdk.video.signal.factory.b f11839G;
    /* access modifiers changed from: private */

    /* renamed from: H  reason: collision with root package name */
    public int f11840H = com.mbridge.msdk.foundation.same.a.f9163F;
    /* access modifiers changed from: private */

    /* renamed from: I  reason: collision with root package name */
    public int f11841I;

    /* renamed from: J  reason: collision with root package name */
    private boolean f11842J = false;

    /* renamed from: K  reason: collision with root package name */
    private int f11843K;

    /* renamed from: L  reason: collision with root package name */
    private int f11844L;

    /* renamed from: M  reason: collision with root package name */
    private int f11845M;

    /* renamed from: N  reason: collision with root package name */
    private int f11846N;

    /* renamed from: O  reason: collision with root package name */
    private int f11847O;

    /* renamed from: P  reason: collision with root package name */
    private String f11848P = "";

    /* renamed from: Q  reason: collision with root package name */
    private String f11849Q;

    /* renamed from: R  reason: collision with root package name */
    private List<CampaignEx> f11850R = new ArrayList();

    /* renamed from: S  reason: collision with root package name */
    private int f11851S = 0;
    /* access modifiers changed from: private */

    /* renamed from: T  reason: collision with root package name */
    public com.mbridge.msdk.foundation.same.report.d.c f11852T;

    /* renamed from: U  reason: collision with root package name */
    private LayoutInflater f11853U;
    /* access modifiers changed from: private */

    /* renamed from: V  reason: collision with root package name */
    public int f11854V = 0;

    /* renamed from: W  reason: collision with root package name */
    private int f11855W = 0;

    /* renamed from: a  reason: collision with root package name */
    protected boolean f11856a = false;
    /* access modifiers changed from: private */
    public View aa;
    private boolean ab = false;
    /* access modifiers changed from: private */
    public boolean ac = false;
    private boolean ad = false;
    private boolean ae;
    private boolean af = false;
    /* access modifiers changed from: private */
    public boolean ag = false;
    /* access modifiers changed from: private */
    public boolean ah = false;
    /* access modifiers changed from: private */
    public boolean ai = false;
    /* access modifiers changed from: private */
    public boolean aj = false;
    private boolean ak = false;
    private com.mbridge.msdk.mbsignalcommon.mraid.d al;
    private u1.b am = null;
    /* access modifiers changed from: private */
    public v1.b an = null;
    private u1.a ao = null;
    /* access modifiers changed from: private */
    public Runnable ap = new Runnable() {
        public final void run() {
            if (MBTempContainer.this.aa != null) {
                MBTempContainer.this.aa.setVisibility(8);
            }
        }
    };
    /* access modifiers changed from: private */
    public boolean aq = false;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f11857b = false;

    /* renamed from: c  reason: collision with root package name */
    protected a f11858c = new a.C0109a();

    /* renamed from: d  reason: collision with root package name */
    protected WindVaneWebView f11859d;

    /* renamed from: e  reason: collision with root package name */
    protected MBridgeContainerView f11860e;

    /* renamed from: f  reason: collision with root package name */
    protected Handler f11861f = new Handler();

    /* renamed from: g  reason: collision with root package name */
    protected Runnable f11862g = new Runnable() {
        public final void run() {
            if (MBTempContainer.this.getActivityProxy().h() == 0) {
                MBTempContainer.this.defaultLoad(-1, "WebView load timeout");
            } else {
                int unused = MBTempContainer.this.f11854V = -3;
            }
        }
    };

    /* renamed from: h  reason: collision with root package name */
    protected Runnable f11863h = new Runnable() {
        public final void run() {
            if (MBTempContainer.this.getActivityProxy().h() == 0) {
                MBTempContainer.this.defaultLoad(-3, "Signal Communication connect timeout");
            } else {
                int unused = MBTempContainer.this.f11854V = -4;
            }
        }
    };

    /* renamed from: y  reason: collision with root package name */
    private View f11864y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public CampaignEx f11865z;

    public interface a {
        void a(String str);

        void a(boolean z4);

        /* renamed from: com.mbridge.msdk.video.bt.module.MBTempContainer$a$a  reason: collision with other inner class name */
        public static class C0109a implements a {

            /* renamed from: a  reason: collision with root package name */
            private boolean f11876a = false;

            public void a(String str) {
                af.b("ActivityErrorListener", str);
                this.f11876a = true;
            }

            public final void a(boolean z4) {
                this.f11876a = z4;
            }
        }
    }

    private static final class b extends AppletSchemeCallBack {

        /* renamed from: a  reason: collision with root package name */
        private CampaignEx f11877a;

        public b(CampaignEx campaignEx) {
            this.f11877a = campaignEx;
        }

        /* access modifiers changed from: protected */
        public final void onRequestFailed(int i5, String str, String str2) {
            if (MBridgeConstans.DEBUG) {
                String a5 = MBTempContainer.f11832x;
                af.a(a5, "request wx scheme failed: errorCode: " + i5 + " errorMessage: " + str);
            }
            try {
                CampaignEx campaignEx = this.f11877a;
                if (campaignEx != null) {
                    campaignEx.setClickURL(str2);
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b(MBTempContainer.f11832x, e5.getMessage());
                }
            }
        }

        /* access modifiers changed from: protected */
        public final void onRequestStart() {
            if (MBridgeConstans.DEBUG) {
                af.a(MBTempContainer.f11832x, "start request wx scheme");
            }
        }

        /* access modifiers changed from: protected */
        public final void onRequestSuccess(String str) {
            if (MBridgeConstans.DEBUG) {
                af.a(MBTempContainer.f11832x, "request wx scheme success");
            }
            try {
                CampaignEx campaignEx = this.f11877a;
                if (campaignEx != null) {
                    campaignEx.setDeepLinkUrl(str);
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b(MBTempContainer.f11832x, e5.getMessage());
                }
            }
        }
    }

    private final class c extends com.mbridge.msdk.video.module.a.a.a {
        public c(Activity activity, CampaignEx campaignEx) {
            super(activity, campaignEx);
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(int r9, java.lang.Object r10) {
            /*
                r8 = this;
                boolean r0 = com.mbridge.msdk.e.b.a()
                if (r0 == 0) goto L_0x000b
                com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                r0.setChinaJsCommonContext()
            L_0x000b:
                r0 = 108(0x6c, float:1.51E-43)
                java.lang.String r1 = ""
                r2 = 1
                if (r9 == r0) goto L_0x00ef
                r0 = 113(0x71, float:1.58E-43)
                if (r9 == r0) goto L_0x00d9
                r0 = 117(0x75, float:1.64E-43)
                if (r9 == r0) goto L_0x00b4
                r0 = 126(0x7e, float:1.77E-43)
                if (r9 == r0) goto L_0x009d
                r0 = 128(0x80, float:1.794E-43)
                if (r9 == r0) goto L_0x009d
                r0 = 131(0x83, float:1.84E-43)
                if (r9 == r0) goto L_0x0086
                switch(r9) {
                    case 103: goto L_0x007f;
                    case 104: goto L_0x007f;
                    case 105: goto L_0x0063;
                    case 106: goto L_0x002b;
                    default: goto L_0x0029;
                }
            L_0x0029:
                goto L_0x0127
            L_0x002b:
                boolean r0 = com.mbridge.msdk.e.b.a()
                if (r0 == 0) goto L_0x00d9
                com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.video.bt.module.a.b r1 = r0.f11835C
                com.mbridge.msdk.video.bt.module.MBTempContainer r2 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                java.lang.String r2 = r2.f11838F
                com.mbridge.msdk.video.bt.module.MBTempContainer r3 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.video.bt.module.b.h r3 = r3.f11834B
                com.mbridge.msdk.video.bt.module.MBTempContainer r4 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r4.f11865z
                r0.setChinaBrowserCallBack(r1, r2, r3, r4)
                com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                android.app.Activity r0 = r0.f12961i
                if (r0 == 0) goto L_0x0127
                com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r0.f11865z
                if (r0 == 0) goto L_0x0127
                com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.video.bt.module.MBTempContainer.r(r0)
                goto L_0x0127
            L_0x0063:
                boolean r0 = com.mbridge.msdk.e.b.a()
                if (r0 == 0) goto L_0x006e
                com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                r0.setChinaCTACallBack()
            L_0x006e:
                com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.video.signal.d r0 = r0.getJSCommon()
                if (r10 == 0) goto L_0x007a
                java.lang.String r1 = r10.toString()
            L_0x007a:
                r0.click(r2, r1)
                goto L_0x0127
            L_0x007f:
                com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.video.bt.module.MBTempContainer.r(r0)
                goto L_0x0127
            L_0x0086:
                com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.video.bt.module.b.h r0 = r0.f11834B
                com.mbridge.msdk.video.bt.module.MBTempContainer r1 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                java.lang.String r1 = r1.f12963k
                com.mbridge.msdk.video.bt.module.MBTempContainer r3 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                java.lang.String r3 = r3.f12962j
                r0.a((boolean) r2, (java.lang.String) r1, (java.lang.String) r3)
                goto L_0x0127
            L_0x009d:
                com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.video.bt.module.b.h r0 = r0.f11834B
                com.mbridge.msdk.video.bt.module.MBTempContainer r1 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                java.lang.String r1 = r1.f12963k
                com.mbridge.msdk.video.bt.module.MBTempContainer r2 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                java.lang.String r2 = r2.f12962j
                r3 = 0
                r0.a((boolean) r3, (java.lang.String) r1, (java.lang.String) r2)
                goto L_0x0127
            L_0x00b4:
                com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r0.mbridgeVideoView
                if (r0 == 0) goto L_0x00be
                r1 = 4
                r0.setVisible(r1)
            L_0x00be:
                com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                boolean unused = r0.ai = r2
                com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.video.bt.module.b.h r0 = r0.f11834B
                com.mbridge.msdk.video.bt.module.MBTempContainer r1 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                java.lang.String r1 = r1.f12963k
                com.mbridge.msdk.video.bt.module.MBTempContainer r2 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                java.lang.String r2 = r2.f12962j
                r0.b(r1, r2)
                goto L_0x0127
            L_0x00d9:
                com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.video.bt.module.b.h r0 = r0.f11834B
                com.mbridge.msdk.video.bt.module.MBTempContainer r1 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                java.lang.String r1 = r1.f12963k
                com.mbridge.msdk.video.bt.module.MBTempContainer r3 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                java.lang.String r3 = r3.f12962j
                r0.a((boolean) r2, (java.lang.String) r1, (java.lang.String) r3)
                goto L_0x0127
            L_0x00ef:
                boolean r0 = com.mbridge.msdk.e.b.a()
                if (r0 == 0) goto L_0x00fc
                com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r3 = r0.f11859d
                r0.setChinaCallBackStatus(r3)
            L_0x00fc:
                com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.video.signal.d r0 = r0.getJSCommon()
                com.mbridge.msdk.video.signal.a.a$b r3 = new com.mbridge.msdk.video.signal.a.a$b
                com.mbridge.msdk.video.bt.module.MBTempContainer r4 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.video.signal.d r4 = r4.getJSCommon()
                com.mbridge.msdk.video.bt.module.MBTempContainer$e r5 = new com.mbridge.msdk.video.bt.module.MBTempContainer$e
                com.mbridge.msdk.video.bt.module.MBTempContainer r6 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                r7 = 0
                r5.<init>()
                r3.<init>(r4, r5)
                r0.a((com.mbridge.msdk.video.signal.a.C0112a) r3)
                com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.video.signal.d r0 = r0.getJSCommon()
                if (r10 == 0) goto L_0x0124
                java.lang.String r1 = r10.toString()
            L_0x0124:
                r0.click(r2, r1)
            L_0x0127:
                super.a(r9, r10)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.module.MBTempContainer.c.a(int, java.lang.Object):void");
        }
    }

    private final class d extends com.mbridge.msdk.video.module.a.a.f {
        private d() {
        }

        public final void a(int i5, Object obj) {
            String str;
            super.a(i5, obj);
            try {
                if (obj instanceof JSONObject) {
                    str = obj.toString();
                } else {
                    str = (String) obj;
                }
                if (MBTempContainer.this.f12969q && !TextUtils.isEmpty(str)) {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
                    int optInt2 = jSONObject.optInt(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE);
                    if (optInt == 2) {
                        int unused = MBTempContainer.this.f11840H = com.mbridge.msdk.foundation.same.a.f9161D;
                    } else if (optInt != 3) {
                        int unused2 = MBTempContainer.this.f11840H = com.mbridge.msdk.foundation.same.a.f9163F;
                    } else {
                        int unused3 = MBTempContainer.this.f11840H = com.mbridge.msdk.foundation.same.a.f9162E;
                    }
                    int unused4 = MBTempContainer.this.f11841I = optInt2;
                }
            } catch (Exception unused5) {
                af.b("NotifyListener", "PlayableResultListener ERROR");
            }
            if (i5 != 120) {
                String str2 = "";
                if (i5 == 131) {
                    com.mbridge.msdk.video.signal.d jSCommon = MBTempContainer.this.getJSCommon();
                    if (obj != null) {
                        str2 = obj.toString();
                    }
                    jSCommon.click(4, str2);
                } else if (i5 == 126) {
                    MBTempContainer.this.f11834B.a(false, MBTempContainer.this.f12963k, MBTempContainer.this.f12962j);
                } else if (i5 != 127) {
                    switch (i5) {
                        case 100:
                            boolean unused6 = MBTempContainer.this.aj = true;
                            MBTempContainer mBTempContainer = MBTempContainer.this;
                            mBTempContainer.f11861f.postDelayed(mBTempContainer.ap, 250);
                            MBTempContainer.this.f11834B.a(MBTempContainer.this.f11852T);
                            return;
                        case 101:
                        case 102:
                            MBTempContainer.this.getJSCommon().d();
                            return;
                        case 103:
                            boolean unused7 = MBTempContainer.this.ac = true;
                            if (MBTempContainer.this.f11865z.isMraid()) {
                                MBTempContainer.r(MBTempContainer.this);
                                return;
                            } else {
                                MBTempContainer.this.getJSCommon().d();
                                return;
                            }
                        case 104:
                            MBTempContainer.r(MBTempContainer.this);
                            return;
                        case 105:
                            if (com.mbridge.msdk.e.b.a()) {
                                MBTempContainer.this.setChinaCTACallBack();
                            }
                            com.mbridge.msdk.video.signal.d jSCommon2 = MBTempContainer.this.getJSCommon();
                            if (obj != null) {
                                str2 = obj.toString();
                            }
                            jSCommon2.click(1, str2);
                            return;
                        default:
                            return;
                    }
                } else {
                    boolean unused8 = MBTempContainer.this.ac = true;
                    MBTempContainer.this.f11834B.a(MBTempContainer.this.f11852T);
                    MBTempContainer.this.f11834B.b(MBTempContainer.this.f12963k, MBTempContainer.this.f12962j);
                    MBTempContainer.this.getJSContainerModule().showEndcard(100);
                }
            } else {
                MBTempContainer.this.f11834B.b(MBTempContainer.this.f12963k, MBTempContainer.this.f12962j);
            }
        }
    }

    private final class f extends com.mbridge.msdk.video.module.a.a.f {
        private f() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0090, code lost:
            if (com.mbridge.msdk.video.bt.module.MBTempContainer.a(r6.f11881a).isCampaignIsFiltered() != false) goto L_0x00a3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x01a5, code lost:
            if (com.mbridge.msdk.video.bt.module.MBTempContainer.a(r6.f11881a).isCampaignIsFiltered() != false) goto L_0x01b8;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(int r7, java.lang.Object r8) {
            /*
                r6 = this;
                super.a(r7, r8)
                com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                boolean r0 = r0.f12969q
                java.lang.String r1 = "NotifyListener"
                if (r0 == 0) goto L_0x003e
                boolean r0 = r8 instanceof java.lang.String     // Catch:{ Exception -> 0x0036 }
                if (r0 == 0) goto L_0x003e
                r0 = r8
                java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0036 }
                boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0036 }
                if (r2 != 0) goto L_0x003e
                org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0036 }
                r2.<init>(r0)     // Catch:{ Exception -> 0x0036 }
                com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this     // Catch:{ Exception -> 0x0036 }
                java.lang.String r3 = "Alert_window_status"
                int r3 = r2.getInt(r3)     // Catch:{ Exception -> 0x0036 }
                int unused = r0.f11840H = r3     // Catch:{ Exception -> 0x0036 }
                com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this     // Catch:{ Exception -> 0x0036 }
                java.lang.String r3 = "complete_info"
                int r2 = r2.getInt(r3)     // Catch:{ Exception -> 0x0036 }
                int unused = r0.f11841I = r2     // Catch:{ Exception -> 0x0036 }
                goto L_0x003e
            L_0x0036:
                r0 = move-exception
                java.lang.String r0 = r0.getMessage()
                com.mbridge.msdk.foundation.tools.af.b(r1, r0)
            L_0x003e:
                r0 = 2
                r2 = 0
                if (r7 == r0) goto L_0x0118
                r3 = 121(0x79, float:1.7E-43)
                r4 = 1
                if (r7 == r3) goto L_0x00f7
                r3 = 16
                if (r7 == r3) goto L_0x00df
                r3 = 17
                if (r7 == r3) goto L_0x00cf
                switch(r7) {
                    case 10: goto L_0x0054;
                    case 11: goto L_0x0118;
                    case 12: goto L_0x0118;
                    default: goto L_0x0052;
                }
            L_0x0052:
                goto L_0x01fd
            L_0x0054:
                com.mbridge.msdk.video.bt.module.MBTempContainer r7 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                boolean unused = r7.ah = r4
                com.mbridge.msdk.video.bt.module.MBTempContainer r7 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.foundation.entity.CampaignEx r7 = r7.f11865z
                if (r7 == 0) goto L_0x01fd
                com.mbridge.msdk.foundation.tools.ah r7 = com.mbridge.msdk.foundation.tools.ah.a()
                java.lang.String r8 = "i_l_s_t_r_i"
                boolean r7 = r7.a((java.lang.String) r8, (boolean) r2)
                if (r7 != 0) goto L_0x01fd
                com.mbridge.msdk.video.bt.module.MBTempContainer r7 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.video.bt.module.MBTempContainer.b(r7)
                com.mbridge.msdk.video.bt.module.MBTempContainer r7 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.foundation.entity.CampaignEx r7 = r7.f11865z
                boolean r7 = r7.isDynamicView()
                if (r7 == 0) goto L_0x00a3
                com.mbridge.msdk.video.bt.module.MBTempContainer r7 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                boolean r7 = r7.f12974v
                if (r7 == 0) goto L_0x0093
                com.mbridge.msdk.video.bt.module.MBTempContainer r7 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.foundation.entity.CampaignEx r7 = r7.f11865z
                boolean r7 = r7.isCampaignIsFiltered()
                if (r7 == 0) goto L_0x00b2
                goto L_0x00a3
            L_0x0093:
                com.mbridge.msdk.video.bt.module.MBTempContainer r7 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.video.bt.module.b.h r7 = r7.f11834B
                com.mbridge.msdk.video.bt.module.MBTempContainer r8 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.foundation.same.report.d.c r8 = r8.f11852T
                r7.a(r8)
                goto L_0x00b2
            L_0x00a3:
                com.mbridge.msdk.video.bt.module.MBTempContainer r7 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.video.bt.module.b.h r7 = r7.f11834B
                com.mbridge.msdk.video.bt.module.MBTempContainer r8 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.foundation.same.report.d.c r8 = r8.f11852T
                r7.a(r8)
            L_0x00b2:
                com.mbridge.msdk.video.bt.module.MBTempContainer r7 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                android.content.Context r7 = r7.getContext()
                com.mbridge.msdk.video.bt.module.MBTempContainer r8 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.foundation.entity.CampaignEx r8 = r8.f11865z
                com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                java.lang.String r0 = r0.f12962j
                com.mbridge.msdk.video.bt.module.MBTempContainer r1 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                int r1 = r1.f11837E
                com.mbridge.msdk.video.bt.module.b.f.a((android.content.Context) r7, (com.mbridge.msdk.foundation.entity.CampaignEx) r8, (java.lang.String) r0, (int) r1)
                goto L_0x01fd
            L_0x00cf:
                com.mbridge.msdk.video.bt.module.MBTempContainer r7 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                boolean unused = r7.ac = r4
                com.mbridge.msdk.video.bt.module.MBTempContainer r7 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.video.module.MBridgeContainerView r7 = r7.f11860e
                if (r7 == 0) goto L_0x01fd
                r7.setRewardStatus(r4)
                goto L_0x01fd
            L_0x00df:
                boolean r7 = com.mbridge.msdk.e.b.a()
                if (r7 == 0) goto L_0x00ec
                com.mbridge.msdk.video.bt.module.MBTempContainer r7 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.video.bt.module.MBTempContainer.r(r7)
                goto L_0x01fd
            L_0x00ec:
                com.mbridge.msdk.video.bt.module.MBTempContainer r7 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.video.signal.d r7 = r7.getJSCommon()
                r7.d()
                goto L_0x01fd
            L_0x00f7:
                com.mbridge.msdk.video.bt.module.MBTempContainer r7 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                boolean unused = r7.ac = r4
                com.mbridge.msdk.video.bt.module.MBTempContainer r7 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.video.bt.module.b.h r7 = r7.f11834B
                com.mbridge.msdk.video.bt.module.MBTempContainer r8 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                java.lang.String r8 = r8.f12963k
                com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                java.lang.String r0 = r0.f12962j
                r7.a((java.lang.String) r8, (java.lang.String) r0)
                com.mbridge.msdk.video.bt.module.MBTempContainer r7 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                boolean unused = r7.ah = r2
                goto L_0x01fd
            L_0x0118:
                r3 = 12
                if (r7 != r3) goto L_0x01c7
                java.lang.String r3 = "Play error but has no message."
                boolean r4 = r8 instanceof java.lang.String     // Catch:{ all -> 0x0127 }
                if (r4 == 0) goto L_0x012f
                java.lang.String r3 = r8.toString()     // Catch:{ all -> 0x0127 }
                goto L_0x012f
            L_0x0127:
                r8 = move-exception
                java.lang.String r8 = r8.getMessage()
                com.mbridge.msdk.foundation.tools.af.b(r1, r8)
            L_0x012f:
                com.mbridge.msdk.video.bt.module.MBTempContainer r8 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                android.content.Context r8 = r8.getContext()
                com.mbridge.msdk.video.bt.module.MBTempContainer r1 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.foundation.entity.CampaignEx r1 = r1.f11865z
                com.mbridge.msdk.video.bt.module.MBTempContainer r4 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                java.lang.String r4 = r4.f12962j
                com.mbridge.msdk.video.bt.module.MBTempContainer r5 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                int r5 = r5.f11837E
                com.mbridge.msdk.video.bt.module.b.f.a(r8, r1, r4, r3, r5)
                com.mbridge.msdk.video.bt.module.MBTempContainer r8 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                boolean r8 = r8.ah
                if (r8 != 0) goto L_0x01c7
                com.mbridge.msdk.video.bt.module.MBTempContainer r8 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.videocommon.d.c r8 = r8.f12964l
                int r8 = r8.C()
                if (r8 != 0) goto L_0x017a
                com.mbridge.msdk.video.bt.module.MBTempContainer r7 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.video.bt.module.b.h r7 = r7.f11834B
                com.mbridge.msdk.video.bt.module.MBTempContainer r8 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.foundation.same.report.d.c r8 = r8.f11852T
                java.lang.String r0 = "play error"
                r7.a((com.mbridge.msdk.foundation.same.report.d.c) r8, (java.lang.String) r0)
                com.mbridge.msdk.video.bt.module.MBTempContainer r7 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                boolean unused = r7.ah = r2
                com.mbridge.msdk.video.bt.module.MBTempContainer r7 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.video.bt.module.MBTempContainer.r(r7)
                return
            L_0x017a:
                com.mbridge.msdk.video.bt.module.MBTempContainer r8 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.video.bt.module.MBTempContainer.b(r8)
                com.mbridge.msdk.video.bt.module.MBTempContainer r8 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.foundation.entity.CampaignEx r8 = r8.f11865z
                if (r8 == 0) goto L_0x01b8
                com.mbridge.msdk.video.bt.module.MBTempContainer r8 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.foundation.entity.CampaignEx r8 = r8.f11865z
                boolean r8 = r8.isDynamicView()
                if (r8 == 0) goto L_0x01b8
                com.mbridge.msdk.video.bt.module.MBTempContainer r8 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                boolean r8 = r8.f12974v
                if (r8 == 0) goto L_0x01a8
                com.mbridge.msdk.video.bt.module.MBTempContainer r8 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.foundation.entity.CampaignEx r8 = r8.f11865z
                boolean r8 = r8.isCampaignIsFiltered()
                if (r8 == 0) goto L_0x01c7
                goto L_0x01b8
            L_0x01a8:
                com.mbridge.msdk.video.bt.module.MBTempContainer r8 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.video.bt.module.b.h r8 = r8.f11834B
                com.mbridge.msdk.video.bt.module.MBTempContainer r1 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.foundation.same.report.d.c r1 = r1.f11852T
                r8.a(r1)
                goto L_0x01c7
            L_0x01b8:
                com.mbridge.msdk.video.bt.module.MBTempContainer r8 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.video.bt.module.b.h r8 = r8.f11834B
                com.mbridge.msdk.video.bt.module.MBTempContainer r1 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.foundation.same.report.d.c r1 = r1.f11852T
                r8.a(r1)
            L_0x01c7:
                com.mbridge.msdk.video.bt.module.MBTempContainer r8 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                com.mbridge.msdk.video.signal.j r8 = r8.getJSVideoModule()
                if (r7 != r0) goto L_0x01d1
                r1 = 6
                goto L_0x01d2
            L_0x01d1:
                r1 = 3
            L_0x01d2:
                r8.videoOperate(r1)
                com.mbridge.msdk.video.bt.module.MBTempContainer r8 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                boolean unused = r8.ah = r2
                com.mbridge.msdk.video.bt.module.MBTempContainer r8 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                v1.b r8 = r8.an
                if (r8 == 0) goto L_0x01fd
                if (r7 != r0) goto L_0x01fd
                java.lang.String r7 = "mbtc skip"
                java.lang.String r8 = "omsdk"
                com.mbridge.msdk.foundation.tools.af.b(r8, r7)
                com.mbridge.msdk.video.bt.module.MBTempContainer r7 = com.mbridge.msdk.video.bt.module.MBTempContainer.this     // Catch:{ Exception -> 0x01f5 }
                v1.b r7 = r7.an     // Catch:{ Exception -> 0x01f5 }
                r7.l()     // Catch:{ Exception -> 0x01f5 }
                goto L_0x01fd
            L_0x01f5:
                r7 = move-exception
                java.lang.String r7 = r7.getMessage()
                com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r8, (java.lang.String) r7)
            L_0x01fd:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.module.MBTempContainer.f.a(int, java.lang.Object):void");
        }
    }

    public MBTempContainer(Context context) {
        super(context);
        init(context);
    }

    static /* synthetic */ void P(MBTempContainer mBTempContainer) {
        if (mBTempContainer.isLoadSuccess()) {
            mBTempContainer.f12961i.runOnUiThread(new Runnable() {
                public final void run() {
                    MBTempContainer.this.aa.setBackgroundColor(0);
                    MBTempContainer.this.aa.setVisibility(0);
                    MBTempContainer.this.aa.bringToFront();
                }
            });
        }
    }

    static /* synthetic */ void R(MBTempContainer mBTempContainer) {
        if (mBTempContainer.isLoadSuccess()) {
            mBTempContainer.f12961i.runOnUiThread(new Runnable() {
                public final void run() {
                    MBTempContainer.this.aa.setVisibility(8);
                }
            });
        }
    }

    static /* synthetic */ void h(MBTempContainer mBTempContainer) {
        try {
            com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
            eVar.a("temp_container", mBTempContainer.getWidth() + "x" + mBTempContainer.getHeight());
            if (mBTempContainer.f11859d != null) {
                eVar.a("web_view", mBTempContainer.f11859d.getWidth() + "x" + mBTempContainer.f11859d.getHeight());
            }
            if (mBTempContainer.mbridgeVideoView != null) {
                eVar.a("mbridge_video_view", mBTempContainer.mbridgeVideoView.getWidth() + "x" + mBTempContainer.mbridgeVideoView.getHeight());
                if (mBTempContainer.mbridgeVideoView.mPlayerView != null) {
                    eVar.a("player_view", mBTempContainer.mbridgeVideoView.mPlayerView.getWidth() + "x" + mBTempContainer.mbridgeVideoView.mPlayerView.getHeight());
                }
            }
            com.mbridge.msdk.foundation.same.report.d.c cVar = mBTempContainer.f11852T;
            if (cVar != null) {
                cVar.a("2000136", eVar);
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }

    static /* synthetic */ void r(MBTempContainer mBTempContainer) {
        int i5;
        try {
            com.mbridge.msdk.video.bt.module.a.b bVar = mBTempContainer.f11835C;
            if (bVar != null) {
                if (mBTempContainer.f12969q && ((i5 = mBTempContainer.f12971s) == com.mbridge.msdk.foundation.same.a.f9165H || i5 == com.mbridge.msdk.foundation.same.a.f9166I)) {
                    boolean z4 = true;
                    if (mBTempContainer.f11841I != 1) {
                        z4 = false;
                    }
                    bVar.a(z4, mBTempContainer.f11840H);
                }
                mBTempContainer.f11835C.a(mBTempContainer.f11838F, mBTempContainer.ac, mBTempContainer.f12966n);
                return;
            }
            Activity activity = mBTempContainer.f12961i;
            if (activity != null) {
                activity.finish();
            }
        } catch (Exception unused) {
            Activity activity2 = mBTempContainer.f12961i;
            if (activity2 != null) {
                activity2.finish();
            }
        }
    }

    public boolean canBackPress() {
        MBridgeContainerView mBridgeContainerView = this.f11860e;
        if (mBridgeContainerView == null || mBridgeContainerView.canBackPress()) {
            return true;
        }
        return false;
    }

    public void defaultLoad(int i5, String str) {
        int i6;
        int i7;
        int i8;
        superDefaultLoad(i5, str);
        CampaignEx campaignEx = this.f11865z;
        if (campaignEx != null && !campaignEx.isDynamicView()) {
            this.f11865z.setTemplateRenderSucc(false);
        }
        if (isLoadSuccess()) {
            if (this.f11865z.getPlayable_ads_without_video() == 2) {
                this.f11860e.setCampaign(this.f11865z);
                this.f11860e.addOrderViewData(this.f11850R);
                this.f11860e.setUnitID(this.f12962j);
                this.f11860e.setCloseDelayTime(i());
                this.f11860e.setPlayCloseBtnTm(this.f12964l.h());
                this.f11860e.setNotifyListener(new com.mbridge.msdk.video.module.a.a.h(this.f11865z, this.f11833A, this.f12966n, b(), this.f12962j, new d(), this.f12964l.y(), this.f12974v));
                this.f11860e.preLoadData(this.f11839G);
                this.f11860e.showPlayableView();
            } else {
                a(i5, str);
                this.aa.setVisibility(8);
                loadModuleDatas();
                int f5 = this.f12964l.f();
                int c5 = c();
                if (c5 != 0) {
                    i6 = c5;
                } else {
                    i6 = f5;
                }
                CampaignEx campaignEx2 = this.f11865z;
                if (campaignEx2 != null && campaignEx2.isDynamicView()) {
                    this.mbridgeVideoView.setContainerViewOnNotifyListener(new c(this.f12961i, this.f11865z));
                }
                CampaignEx campaignEx3 = this.f11865z;
                if (campaignEx3 == null || campaignEx3.getVst() <= -2) {
                    i7 = this.f12964l.e();
                } else {
                    i7 = this.f11865z.getVst();
                }
                CampaignEx campaignEx4 = this.f11865z;
                if (campaignEx4 != null && campaignEx4.getDynamicTempCode() == 5 && (i8 = this.f11837E) > 1) {
                    i7 = a(i7, i8);
                    this.f11865z.setVst(i7);
                }
                int i9 = i7;
                this.mbridgeVideoView.setVideoSkipTime(i9);
                MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
                mBridgeVideoView.setNotifyListener(new m(mBridgeVideoView, this.f11860e, this.f11865z, this.f12966n, this.f11833A, b(), this.f12962j, i6, i9, new f(), this.f12964l.y(), this.f12974v, this.f12964l.C()));
                this.mbridgeVideoView.setAdSession(this.am);
                this.mbridgeVideoView.setVideoEvents(this.an);
                this.mbridgeVideoView.defaultShow();
                MBridgeContainerView mBridgeContainerView = this.f11860e;
                mBridgeContainerView.setNotifyListener(new com.mbridge.msdk.video.module.a.a.b(this.mbridgeVideoView, mBridgeContainerView, this.f11865z, this.f12966n, this.f11833A, b(), this.f12962j, new c(this.f12961i, this.f11865z), this.f12964l.y(), this.f12974v));
                this.f11860e.defaultShow();
            }
            g();
            return;
        }
        a(i5, str);
        Activity activity = this.f12961i;
        if (activity != null) {
            activity.finish();
        }
    }

    public int findID(String str) {
        return x.a(getContext(), str, "id");
    }

    public int findLayout(String str) {
        return x.a(getContext(), str, TtmlNode.TAG_LAYOUT);
    }

    public MBridgeContainerView findMBridgeContainerView() {
        return (MBridgeContainerView) findViewById(findID("mbridge_video_templete_container"));
    }

    public MBridgeVideoView findMBridgeVideoView() {
        return (MBridgeVideoView) findViewById(findID("mbridge_video_templete_videoview"));
    }

    public WindVaneWebView findWindVaneWebView() {
        a.C0114a aVar;
        try {
            if (this.f12974v) {
                CampaignEx campaignEx = this.f11865z;
                if (campaignEx == null || campaignEx.getRewardTemplateMode() == null) {
                    return null;
                }
                a.C0114a a5 = com.mbridge.msdk.videocommon.a.a(this.f12962j + "_" + this.f11865z.getId() + "_" + this.f11865z.getRequestId() + "_" + this.f11865z.getRewardTemplateMode().e());
                if (a5 != null) {
                    return a5.a();
                }
                return null;
            }
            if (this.f12969q) {
                aVar = com.mbridge.msdk.videocommon.a.a(287, this.f11865z);
            } else {
                aVar = com.mbridge.msdk.videocommon.a.a(94, this.f11865z);
            }
            if (aVar == null || !aVar.c()) {
                return null;
            }
            if (this.f12969q) {
                com.mbridge.msdk.videocommon.a.b(287, this.f11865z);
            } else {
                com.mbridge.msdk.videocommon.a.b(94, this.f11865z);
            }
            WindVaneWebView a6 = aVar.a();
            if (this.af) {
                a6.setWebViewTransparent();
            }
            return a6;
        } catch (Exception e5) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            e5.printStackTrace();
            return null;
        }
    }

    public u1.a getAdEvents() {
        return this.ao;
    }

    public u1.b getAdSession() {
        return this.am;
    }

    public CampaignEx getCampaign() {
        return this.f11865z;
    }

    public String getInstanceId() {
        return this.f11838F;
    }

    public int getLayoutID() {
        String str;
        if (this.af) {
            str = "mbridge_reward_activity_video_templete_transparent";
        } else {
            str = "mbridge_reward_activity_video_templete";
        }
        return findLayout(str);
    }

    public v1.b getVideoEvents() {
        return this.an;
    }

    public void init(Context context) {
        this.f11853U = LayoutInflater.from(context);
    }

    public boolean initViews() {
        View findViewById = findViewById(findID("mbridge_video_templete_progressbar"));
        this.aa = findViewById;
        if (findViewById != null) {
            return true;
        }
        return false;
    }

    public boolean isLoadSuccess() {
        return this.f11857b;
    }

    public void loadModuleDatas() {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        k b5 = b(this.f11865z);
        if (b5 != null) {
            i5 = b5.n();
        } else {
            i5 = 0;
        }
        if (i5 != 0) {
            this.f12968p = i5;
        }
        int f5 = this.f12964l.f();
        int c5 = c();
        if (c5 != 0) {
            i6 = c5;
        } else {
            i6 = f5;
        }
        this.mbridgeVideoView.setSoundState(this.f12968p);
        this.mbridgeVideoView.setCampaign(this.f11865z);
        this.mbridgeVideoView.setPlayURL(this.f11833A.t());
        CampaignEx campaignEx = this.f11865z;
        if (campaignEx == null || campaignEx.getVst() <= -2) {
            i7 = this.f12964l.e();
        } else {
            i7 = this.f11865z.getVst();
        }
        CampaignEx campaignEx2 = this.f11865z;
        if (campaignEx2 != null && campaignEx2.getDynamicTempCode() == 5 && (i10 = this.f11837E) > 1) {
            i7 = a(i7, i10);
            this.f11865z.setVst(i7);
        }
        int i11 = i7;
        this.mbridgeVideoView.setVideoSkipTime(i11);
        this.mbridgeVideoView.setCloseAlert(this.f12964l.i());
        this.mbridgeVideoView.setBufferTimeout(h());
        this.mbridgeVideoView.setNotifyListener(new n(this.f11839G, this.f11865z, this.f12966n, this.f11833A, b(), this.f12962j, i6, i11, new f(), this.f12964l.y(), this.f12974v, this.f12964l.C()));
        this.mbridgeVideoView.setShowingTransparent(this.af);
        this.mbridgeVideoView.setAdSession(this.am);
        if (this.f12969q && ((i8 = this.f12971s) == com.mbridge.msdk.foundation.same.a.f9165H || i8 == com.mbridge.msdk.foundation.same.a.f9166I)) {
            this.mbridgeVideoView.setIVRewardEnable(i8, this.f12972t, this.f12973u);
            MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
            if (getJSCommon() != null) {
                i9 = getJSCommon().h();
            } else {
                i9 = 1;
            }
            mBridgeVideoView.setDialogRole(i9);
        }
        this.f11860e.setCampaign(this.f11865z);
        this.f11860e.addOrderViewData(this.f11850R);
        this.f11860e.setUnitID(this.f12962j);
        this.f11860e.setCloseDelayTime(i());
        this.f11860e.setPlayCloseBtnTm(this.f12964l.h());
        this.f11860e.setVideoInteractiveType(this.f12964l.g());
        this.f11860e.setEndscreenType(this.f12964l.q());
        this.f11860e.setVideoSkipTime(i11);
        this.f11860e.setShowingTransparent(this.af);
        this.f11860e.setJSFactory(this.f11839G);
        if (this.f11865z.getPlayable_ads_without_video() == 2) {
            this.f11860e.setNotifyListener(new com.mbridge.msdk.video.module.a.a.h(this.f11865z, this.f11833A, this.f12966n, b(), this.f12962j, new d(), this.f12964l.y(), this.f12974v));
            this.f11860e.preLoadData(this.f11839G);
            this.f11860e.showPlayableView();
        } else {
            this.f11860e.setNotifyListener(new com.mbridge.msdk.video.module.a.a.c(this.f11839G, this.f11865z, this.f12966n, this.f11833A, b(), this.f12962j, new c(this.f12961i, this.f11865z), this.f12964l.y(), this.f12974v));
            this.f11860e.preLoadData(this.f11839G);
            this.mbridgeVideoView.preLoadData(this.f11839G);
        }
        if (this.af) {
            this.f11860e.setMBridgeClickMiniCardViewTransparent();
        }
    }

    public void onBackPressed() {
        MBridgeContainerView mBridgeContainerView;
        MBridgeContainerView mBridgeContainerView2;
        MBridgeVideoView mBridgeVideoView;
        MBridgeVideoView mBridgeVideoView2;
        if (!this.af || (mBridgeVideoView2 = this.mbridgeVideoView) == null) {
            CampaignEx campaignEx = this.f11865z;
            if (((campaignEx == null || campaignEx.getRewardTemplateMode() == null || this.f11865z.getRewardTemplateMode().f() != 5002010) && !this.ah) || (mBridgeVideoView = this.mbridgeVideoView) == null) {
                if (!this.aj || (mBridgeContainerView2 = this.f11860e) == null) {
                    if (this.ai && (mBridgeContainerView = this.f11860e) != null) {
                        mBridgeContainerView.onEndcardBackPress();
                    }
                    if (getJSCommon().b()) {
                        if (getJSContainerModule() == null || !getJSContainerModule().miniCardShowing()) {
                            getActivityProxy().g();
                        }
                    } else if (canBackPress()) {
                        Activity activity = this.f12961i;
                        if (activity != null && !this.f12974v && !this.ak) {
                            this.ak = true;
                            activity.onBackPressed();
                        }
                    } else {
                        af.a(f11832x, "onBackPressed can't excute");
                    }
                } else {
                    mBridgeContainerView2.onPlayableBackPress();
                }
            } else if (mBridgeVideoView.isMiniCardShowing()) {
                MBridgeContainerView mBridgeContainerView3 = this.f11860e;
                if (mBridgeContainerView3 != null) {
                    mBridgeContainerView3.onMiniEndcardBackPress();
                }
            } else {
                this.mbridgeVideoView.onBackPress();
            }
        } else {
            mBridgeVideoView2.notifyVideoClose();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onCreate() {
        ViewGroup viewGroup;
        int i5;
        int i6;
        List<CampaignEx> list;
        AppletsModel appletsModel;
        if (this.f12964l == null) {
            this.f12964l = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f12962j, this.f12969q);
        }
        try {
            if (this.f11865z != null) {
                try {
                    appletsModel = AppletModelManager.getInstance().get(this.f11865z);
                } catch (Exception e5) {
                    if (MBridgeConstans.DEBUG) {
                        e5.printStackTrace();
                    }
                    appletsModel = null;
                }
                if (appletsModel != null) {
                    try {
                        if (appletsModel.can(0)) {
                            appletsModel.setUserClick(false);
                            appletsModel.requestWxAppletsScheme(0, new b(this.f11865z));
                        }
                    } catch (Exception e6) {
                        appletsModel.clearRequestState();
                        if (MBridgeConstans.DEBUG) {
                            e6.printStackTrace();
                        }
                    }
                }
            }
        } catch (Exception e7) {
            if (MBridgeConstans.DEBUG) {
                e7.printStackTrace();
            }
        }
        this.ak = false;
        try {
            if (this.f12974v) {
                CampaignEx campaignEx = this.f11865z;
                if (campaignEx == null || !campaignEx.isDynamicView()) {
                    this.f11834B = new com.mbridge.msdk.video.bt.module.b.c(this.f11835C, this.f11838F);
                } else {
                    this.f11834B = new com.mbridge.msdk.video.bt.module.b.d(getContext(), this.f12969q, this.f12964l, this.f11865z, this.f11834B, b(), this.f12962j);
                }
            } else {
                this.f11834B = new com.mbridge.msdk.video.bt.module.b.d(getContext(), this.f12969q, this.f12964l, this.f11865z, this.f11834B, b(), this.f12962j);
            }
            registerErrorListener(new com.mbridge.msdk.video.bt.module.b.e(this.f11852T, this.f11834B));
            a(this.f12964l, this.f11865z);
            setShowingTransparent();
            int layoutID = getLayoutID();
            if (layoutID <= 0) {
                a("layoutID not found");
                return;
            }
            View inflate = this.f11853U.inflate(layoutID, (ViewGroup) null);
            this.f11864y = inflate;
            addView(inflate, new RelativeLayout.LayoutParams(-1, -1));
            if (this.f11856a) {
                setMatchParent();
            }
            this.f11859d = findWindVaneWebView();
            MBridgeVideoView findMBridgeVideoView = findMBridgeVideoView();
            this.mbridgeVideoView = findMBridgeVideoView;
            findMBridgeVideoView.setVideoLayout(this.f11865z);
            this.mbridgeVideoView.setIsIV(this.f12969q);
            this.mbridgeVideoView.setUnitId(this.f12962j);
            this.mbridgeVideoView.setCamPlayOrderCallback(this.f11836D, this.f11850R, this.f11837E, this.f11851S);
            if (this.f12974v) {
                this.mbridgeVideoView.setNotchPadding(this.f11844L, this.f11845M, this.f11846N, this.f11847O);
            }
            MBridgeContainerView findMBridgeContainerView = findMBridgeContainerView();
            this.f11860e = findMBridgeContainerView;
            if (this.f12974v) {
                findMBridgeContainerView.setNotchPadding(this.f11843K, this.f11844L, this.f11845M, this.f11846N, this.f11847O);
            }
            if (ah.a().a("i_l_s_t_r_i", false)) {
                this.mbridgeVideoView.setPlayerViewAttachListener(new MBridgeVideoView.a() {
                    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002b, code lost:
                        if (com.mbridge.msdk.video.bt.module.MBTempContainer.a(r4.f11870a).isCampaignIsFiltered() != false) goto L_0x003e;
                     */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void a() {
                        /*
                            r4 = this;
                            com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r0.f11865z
                            if (r0 == 0) goto L_0x0068
                            com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                            com.mbridge.msdk.video.bt.module.MBTempContainer.b(r0)
                            com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r0.f11865z
                            boolean r0 = r0.isDynamicView()
                            if (r0 == 0) goto L_0x003e
                            com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                            boolean r0 = r0.f12974v
                            if (r0 == 0) goto L_0x002e
                            com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r0.f11865z
                            boolean r0 = r0.isCampaignIsFiltered()
                            if (r0 == 0) goto L_0x004d
                            goto L_0x003e
                        L_0x002e:
                            com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                            com.mbridge.msdk.video.bt.module.b.h r0 = r0.f11834B
                            com.mbridge.msdk.video.bt.module.MBTempContainer r1 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                            com.mbridge.msdk.foundation.same.report.d.c r1 = r1.f11852T
                            r0.a(r1)
                            goto L_0x004d
                        L_0x003e:
                            com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                            com.mbridge.msdk.video.bt.module.b.h r0 = r0.f11834B
                            com.mbridge.msdk.video.bt.module.MBTempContainer r1 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                            com.mbridge.msdk.foundation.same.report.d.c r1 = r1.f11852T
                            r0.a(r1)
                        L_0x004d:
                            com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                            android.content.Context r0 = r0.getContext()
                            com.mbridge.msdk.video.bt.module.MBTempContainer r1 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r1.f11865z
                            com.mbridge.msdk.video.bt.module.MBTempContainer r2 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                            java.lang.String r2 = r2.f12962j
                            com.mbridge.msdk.video.bt.module.MBTempContainer r3 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                            int r3 = r3.f11837E
                            com.mbridge.msdk.video.bt.module.b.f.a((android.content.Context) r0, (com.mbridge.msdk.foundation.entity.CampaignEx) r1, (java.lang.String) r2, (int) r3)
                        L_0x0068:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.module.MBTempContainer.AnonymousClass4.a():void");
                    }
                });
            }
            this.mbridgeVideoView.setIPlayVideoViewLayoutCallBack(new com.mbridge.msdk.video.dynview.e.f() {
                public final void a() {
                    MBTempContainer.h(MBTempContainer.this);
                }
            });
            if (this.mbridgeVideoView == null || this.f11860e == null || !initViews()) {
                this.f11858c.a("not found View IDS");
                Activity activity = this.f12961i;
                if (activity != null) {
                    activity.finish();
                    return;
                }
                return;
            }
            this.f11857b = true;
            WindVaneWebView windVaneWebView = this.f11859d;
            this.f11839G = new com.mbridge.msdk.video.signal.factory.b(this.f12961i, windVaneWebView, this.mbridgeVideoView, this.f11860e, this.f11865z, new e());
            CampaignEx campaignEx2 = this.f11865z;
            if (!(campaignEx2 == null || campaignEx2.getDynamicTempCode() != 5 || (list = this.f11850R) == null)) {
                this.f11839G.a(list);
            }
            registerJsFactory(this.f11839G);
            com.mbridge.msdk.foundation.d.b.a().a(this.f12962j + "_" + 1, (com.mbridge.msdk.foundation.d.a) new com.mbridge.msdk.foundation.d.a() {
                public final void close() {
                    String str;
                    MBTempContainer.this.onResume();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                            jSONObject.put(NotificationCompat.CATEGORY_STATUS, 2);
                        }
                        str = jSONObject.toString();
                    } catch (Throwable th) {
                        af.b(MBTempContainer.f11832x, th.getMessage(), th);
                        str = "";
                    }
                    g.a().a((WebView) MBTempContainer.this.f11859d, "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
                }

                public final void showed() {
                    String str;
                    MBTempContainer.this.onPause();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                            jSONObject.put(NotificationCompat.CATEGORY_STATUS, 1);
                        }
                        str = jSONObject.toString();
                    } catch (Throwable th) {
                        af.b(MBTempContainer.f11832x, th.getMessage(), th);
                        str = "";
                    }
                    g.a().a((WebView) MBTempContainer.this.f11859d, "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
                }

                public final void summit(String str) {
                    String str2;
                    MBTempContainer.this.onResume();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                            jSONObject.put(NotificationCompat.CATEGORY_STATUS, 2);
                        }
                        str2 = jSONObject.toString();
                    } catch (Throwable th) {
                        af.b(MBTempContainer.f11832x, th.getMessage(), th);
                        str2 = "";
                    }
                    g.a().a((WebView) MBTempContainer.this.f11859d, "onFeedbackAlertStatusNotify", Base64.encodeToString(str2.getBytes(), 2));
                }
            });
            g();
            if (windVaneWebView != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.f11864y.findViewById(x.a(getContext(), "mbridge_video_templete_webview_parent", "id"));
                windVaneWebView.setApiManagerJSFactory(this.f11839G);
                if (windVaneWebView.getParent() != null) {
                    defaultLoad(0, "preload template webview is null or load error");
                    return;
                }
                if (windVaneWebView.getObject() instanceof k) {
                    getJSCommon().a(this.ao);
                    getJSCommon().a(this.am);
                    getJSCommon().a(this.an);
                    getJSCommon().a(this.f12968p);
                    getJSCommon().a(this.f12962j);
                    getJSCommon().a(this.f12964l);
                    getJSCommon().a((a.C0112a) new e());
                    CampaignEx campaignEx3 = this.f11865z;
                    if (campaignEx3 != null && (campaignEx3.isMraid() || this.f11865z.isActiveOm())) {
                        com.mbridge.msdk.mbsignalcommon.mraid.d dVar = new com.mbridge.msdk.mbsignalcommon.mraid.d(getContext());
                        this.al = dVar;
                        dVar.c();
                        this.al.a();
                        this.al.a(new d.b() {
                            public final void a(double d5) {
                                MBridgeContainerView mBridgeContainerView;
                                String a5 = MBTempContainer.f11832x;
                                af.b(a5, "volume is : " + d5);
                                try {
                                    if (MBTempContainer.this.f11865z.isMraid() && (mBridgeContainerView = MBTempContainer.this.f11860e) != null && mBridgeContainerView.getH5EndCardView() != null) {
                                        MBTempContainer.this.f11860e.getH5EndCardView().volumeChange(d5);
                                    }
                                } catch (Exception e5) {
                                    af.b(MBTempContainer.f11832x, e5.getMessage());
                                }
                            }
                        });
                    }
                    getJSContainerModule().readyStatus(((k) windVaneWebView.getObject()).r());
                    if (this.f11859d != null) {
                        int i7 = getResources().getConfiguration().orientation;
                        if (d()) {
                            i6 = ak.h(getContext());
                            i5 = ak.g(getContext());
                            if (com.mbridge.msdk.foundation.tools.e.a(getContext())) {
                                int c5 = ak.c(getContext());
                                if (i7 == 2) {
                                    i6 += c5;
                                } else {
                                    i5 += c5;
                                }
                            }
                        } else {
                            i6 = ak.f(getContext());
                            i5 = ak.e(getContext());
                        }
                        int b5 = this.f11865z.getRewardTemplateMode().b();
                        if (c(this.f11865z) == 1) {
                            b5 = i7;
                        }
                        getJSNotifyProxy().a(i7, b5, i6, i5);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(com.mbridge.msdk.foundation.same.a.f9193l, (double) ak.d(getContext()));
                        try {
                            if (this.f12966n != null) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put(RewardPlus.NAME, this.f12966n.a());
                                jSONObject2.put(RewardPlus.AMOUNT, this.f12966n.b());
                                jSONObject2.put("id", this.f12967o);
                                jSONObject.put("userId", this.f12965m);
                                jSONObject.put("reward", jSONObject2);
                                jSONObject.put("playVideoMute", this.f12968p);
                                jSONObject.put("extra", this.f11849Q);
                            }
                        } catch (JSONException e8) {
                            af.a(f11832x, e8.getMessage());
                        } catch (Exception e9) {
                            af.a(f11832x, e9.getMessage());
                        }
                        String jSONObject3 = jSONObject.toString();
                        com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                        eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 2);
                        com.mbridge.msdk.foundation.same.report.d.d.a().a("2000133", this.f11865z, eVar);
                        getJSNotifyProxy().a((Object) jSONObject3);
                        g.a().a((WebView) this.f11859d, "oncutoutfetched", Base64.encodeToString(this.f11848P.getBytes(), 0));
                        getJSCommon().b(true);
                        if (com.mbridge.msdk.e.b.a()) {
                            setChinaCallBackStatus(this.f11859d);
                        }
                        loadModuleDatas();
                        this.f11861f.postDelayed(this.f11862g, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                    }
                    ((k) windVaneWebView.getObject()).f12643m.a();
                    if (this.f12974v) {
                        getJSCommon().e(this.f11855W);
                    }
                }
                if (getJSCommon().a() == 1 && (viewGroup = (ViewGroup) this.f11864y.findViewById(x.a(getContext(), "mbridge_video_templete_webview_parent", "id"))) != null) {
                    ((ViewGroup) this.f11864y).removeView(viewGroup);
                    ((ViewGroup) this.f11864y).addView(viewGroup, 1);
                }
                viewGroup2.addView(windVaneWebView, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
            defaultLoad(0, "preload template webview is null or load error");
        } catch (Exception e10) {
            if (MBridgeConstans.DEBUG) {
                e10.printStackTrace();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            a("onCreate error" + th);
        }
    }

    public void onDestroy() {
        CampaignEx campaignEx;
        int i5;
        if (!this.f11842J) {
            boolean z4 = true;
            this.f11842J = true;
            super.onDestroy();
            try {
                if (com.mbridge.msdk.e.b.a()) {
                    setChinaDestroy();
                }
                MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
                if (mBridgeVideoView != null) {
                    mBridgeVideoView.releasePlayer();
                }
                WindVaneWebView windVaneWebView = this.f11859d;
                if (windVaneWebView != null) {
                    ViewGroup viewGroup = (ViewGroup) windVaneWebView.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeAllViews();
                    }
                    this.f11859d.clearWebView();
                    this.f11859d.release();
                }
                if (this.f11835C != null) {
                    this.f11835C = null;
                }
                this.f11861f.removeCallbacks(this.f11862g);
                this.f11861f.removeCallbacks(this.f11863h);
                getJSCommon().e();
                if (this.f12969q) {
                    com.mbridge.msdk.c.h.a().e(this.f12962j);
                }
                if (!this.ab) {
                    this.ab = true;
                    CampaignEx campaignEx2 = this.f11865z;
                    if (campaignEx2 != null && campaignEx2.getPlayable_ads_without_video() == 2) {
                        this.ac = true;
                    }
                    v1.b bVar = this.an;
                    if (bVar != null && !this.ac) {
                        try {
                            bVar.l();
                        } catch (Exception e5) {
                            af.a("omsdk", e5.getMessage());
                        }
                    }
                    h hVar = this.f11834B;
                    if (hVar != null) {
                        if (this.f12969q && ((i5 = this.f12971s) == com.mbridge.msdk.foundation.same.a.f9165H || i5 == com.mbridge.msdk.foundation.same.a.f9166I)) {
                            if (this.f11841I != 1) {
                                z4 = false;
                            }
                            hVar.a(z4, this.f11840H);
                        }
                        if (!this.ac) {
                            this.f12966n.a(0);
                        }
                        this.f11852T.a(this.f11865z);
                        this.f11834B.a(this.f11852T, this.ac, this.f12966n);
                    }
                    this.f11861f.removeCallbacks(this.ap);
                    if (((!this.f12969q && !this.f12974v) || ((campaignEx = this.f11865z) != null && campaignEx.isDynamicView())) && this.ac) {
                        if (!com.mbridge.msdk.e.b.a() || !checkChinaSendToServerDiff(this.f11834B)) {
                            af.a(f11832x, "sendToServerRewardInfo");
                            com.mbridge.msdk.video.module.b.b.a(this.f11865z, this.f12966n, this.f12962j, this.f12965m, this.f11849Q);
                        }
                    }
                    if (!this.f12974v) {
                        if (this.f12969q) {
                            com.mbridge.msdk.videocommon.a.b(287, this.f11865z);
                        } else {
                            com.mbridge.msdk.videocommon.a.b(94, this.f11865z);
                        }
                    }
                    MBridgeContainerView mBridgeContainerView = this.f11860e;
                    if (mBridgeContainerView != null) {
                        mBridgeContainerView.release();
                    }
                }
            } catch (Throwable th) {
                af.a(f11832x, th.getMessage());
                return;
            }
            if (!this.ae) {
                f();
            }
            com.mbridge.msdk.mbsignalcommon.mraid.d dVar = this.al;
            if (dVar != null) {
                dVar.d();
            }
            if (this.am != null) {
                af.b("omsdk", "tc onDestroy");
                this.am.e();
                this.am.c();
                this.am = null;
            }
            if (!this.f12974v) {
                if (isLoadSuccess()) {
                    this.f11861f.postDelayed(new Runnable() {
                        public final void run() {
                            if (MBTempContainer.this.f12961i != null) {
                                MBTempContainer.this.f12961i.finish();
                            }
                        }
                    }, 100);
                } else {
                    Activity activity = this.f12961i;
                    if (activity != null) {
                        activity.finish();
                    }
                }
            }
            if (!this.ae) {
                f();
            }
            com.mbridge.msdk.video.bt.a.d.c().f(this.f11838F);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void onPause() {
        super.onPause();
        this.ad = true;
        try {
            getJSVideoModule().videoOperate(2);
            MBridgeContainerView mBridgeContainerView = this.f11860e;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.setOnPause();
            }
            MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
            if (mBridgeVideoView != null) {
                mBridgeVideoView.onActivityPause();
            }
        } catch (Throwable th) {
            af.b(f11832x, th.getMessage(), th);
        }
    }

    public void onResume() {
        Runnable runnable;
        Activity activity;
        super.onResume();
        int i5 = this.f11854V;
        if (i5 == -3) {
            runnable = this.f11862g;
        } else if (i5 == -4) {
            runnable = this.f11863h;
        } else {
            runnable = null;
        }
        if (runnable != null) {
            runnable.run();
            this.f11854V = 0;
        }
        try {
            if (this.mbridgeVideoView != null && !e() && !this.mbridgeVideoView.isMiniCardShowing() && !com.mbridge.msdk.foundation.d.b.f8931c) {
                this.mbridgeVideoView.setCover(false);
            }
            MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
            if (mBridgeVideoView != null) {
                mBridgeVideoView.onActivityResume();
            }
            MBridgeContainerView mBridgeContainerView = this.f11860e;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.setOnResume();
            }
            if (this.ad && !e() && !com.mbridge.msdk.foundation.d.b.f8931c) {
                getJSVideoModule().videoOperate(1);
            }
            Activity activity2 = this.f12961i;
            if (activity2 != null) {
                ak.a(activity2.getWindow().getDecorView());
            }
            if (this.af && this.ag && (activity = this.f12961i) != null) {
                activity.finish();
            }
        } catch (Throwable th) {
            af.b(f11832x, th.getMessage(), th);
        }
    }

    public void onStop() {
        super.onStop();
        MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.setCover(true);
            this.mbridgeVideoView.onActivityStop();
        }
    }

    public void preload() {
    }

    public void receiveSuccess() {
        af.a(f11832x, "receiveSuccess ,start hybrid");
        this.f11861f.removeCallbacks(this.f11863h);
        this.f11861f.postDelayed(this.ap, 250);
    }

    public void registerErrorListener(a aVar) {
        this.f11858c = aVar;
    }

    public void setAdEvents(u1.a aVar) {
        this.ao = aVar;
        com.mbridge.msdk.video.signal.factory.b bVar = this.f11839G;
        if (bVar != null && bVar.getJSCommon() != null) {
            this.f11839G.getJSCommon().a(aVar);
        }
    }

    public void setAdSession(u1.b bVar) {
        this.am = bVar;
        com.mbridge.msdk.video.signal.factory.b bVar2 = this.f11839G;
        if (!(bVar2 == null || bVar2.getJSCommon() == null)) {
            this.f11839G.getJSCommon().a(bVar);
        }
        MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.setAdSession(bVar);
        }
    }

    public void setCamPlayOrderCallback(com.mbridge.msdk.video.dynview.e.a aVar, int i5) {
        this.f11836D = aVar;
        this.f11837E = i5;
    }

    public void setCampOrderViewData(List<CampaignEx> list, int i5) {
        if (list != null) {
            this.f11850R = list;
        }
        this.f11851S = i5;
    }

    public void setCampaign(CampaignEx campaignEx) {
        this.f11865z = campaignEx;
        if (campaignEx != null) {
            com.mbridge.msdk.foundation.same.report.d.c a5 = com.mbridge.msdk.foundation.same.report.d.d.a().a(campaignEx.getCurrentLocalRid(), "");
            this.f11852T = a5;
            if (a5 == null) {
                this.f11852T = new com.mbridge.msdk.foundation.same.report.d.c();
            }
            this.f11852T.c(campaignEx.getCurrentLocalRid());
            this.f11852T.a(campaignEx);
            if (TextUtils.isEmpty(campaignEx.getCampaignUnitId()) && !TextUtils.isEmpty(this.f12962j)) {
                campaignEx.setCampaignUnitId(this.f12962j);
            }
            AppletsModel appletsModel = AppletModelManager.getInstance().get(campaignEx);
            if (appletsModel != null) {
                this.aq = appletsModel.isSupportWxScheme();
            }
            com.mbridge.msdk.foundation.d.b a6 = com.mbridge.msdk.foundation.d.b.a();
            a6.a(campaignEx.getCampaignUnitId() + "_" + 1, campaignEx);
        }
    }

    public void setCampaignDownLoadTask(com.mbridge.msdk.videocommon.download.a aVar) {
        this.f11833A = aVar;
    }

    public void setCampaignExpired(boolean z4) {
        try {
            CampaignEx campaignEx = this.f11865z;
            if (campaignEx == null) {
                return;
            }
            if (z4) {
                campaignEx.setSpareOfferFlag(1);
                if (!com.mbridge.msdk.e.b.a()) {
                    com.mbridge.msdk.videocommon.d.c cVar = this.f12964l;
                    if (cVar == null) {
                        return;
                    }
                    if (cVar.y() == 1) {
                        this.f11865z.setCbt(1);
                    } else {
                        this.f11865z.setCbt(0);
                    }
                } else if (this.f12970r) {
                    this.f11865z.setCbt(0);
                } else {
                    com.mbridge.msdk.videocommon.d.c cVar2 = this.f12964l;
                    if (cVar2 == null) {
                        return;
                    }
                    if (cVar2.y() == 1) {
                        this.f11865z.setCbt(1);
                    } else {
                        this.f11865z.setCbt(0);
                    }
                }
            } else {
                campaignEx.setSpareOfferFlag(0);
                this.f11865z.setCbt(0);
            }
        } catch (Exception e5) {
            af.b(f11832x, e5.getMessage());
        }
    }

    public void setDeveloperExtraData(String str) {
        this.f11849Q = str;
    }

    public void setInstanceId(String str) {
        this.f11838F = str;
    }

    public void setJSFactory(com.mbridge.msdk.video.signal.factory.b bVar) {
        this.f11839G = bVar;
    }

    public void setMBridgeTempCallback(com.mbridge.msdk.video.bt.module.a.b bVar) {
        this.f11835C = bVar;
    }

    public void setMatchParent() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        layoutParams.height = -1;
        layoutParams.width = -1;
    }

    public void setMediaPlayerUrl(String str) {
    }

    public void setNotchPadding(int i5, int i6, int i7, int i8, int i9) {
        this.f11843K = i5;
        this.f11844L = i6;
        this.f11845M = i7;
        this.f11846N = i8;
        this.f11847O = i9;
        String a5 = s.a(i5, i6, i7, i8, i9);
        this.f11848P = a5;
        af.b(f11832x, a5);
        if (getJSCommon() != null && !TextUtils.isEmpty(this.f11848P)) {
            getJSCommon().b(this.f11848P);
            if (this.f11859d != null && !TextUtils.isEmpty(this.f11848P)) {
                g.a().a((WebView) this.f11859d, "oncutoutfetched", Base64.encodeToString(this.f11848P.getBytes(), 0));
            }
        }
        MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.setNotchPadding(i6, i7, i8, i9);
        }
        MBridgeContainerView mBridgeContainerView = this.f11860e;
        if (mBridgeContainerView != null) {
            mBridgeContainerView.setNotchPadding(i5, i6, i7, i8, i9);
        }
    }

    public void setShowRewardListener(h hVar) {
        this.f11834B = hVar;
    }

    public void setShowingTransparent() {
        int a5;
        Activity activity;
        boolean d5 = d();
        this.af = d5;
        if (!d5 && (a5 = x.a(getContext(), "mbridge_reward_theme", TtmlNode.TAG_STYLE)) > 1 && (activity = this.f12961i) != null) {
            activity.setTheme(a5);
        }
    }

    public void setVideoEvents(v1.b bVar) {
        this.an = bVar;
        com.mbridge.msdk.video.signal.factory.b bVar2 = this.f11839G;
        if (!(bVar2 == null || bVar2.getJSCommon() == null)) {
            this.f11839G.getJSCommon().a(bVar);
        }
        MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.setVideoEvents(bVar);
        }
    }

    public void setWebViewFront(int i5) {
        this.f11855W = i5;
    }

    public void superDefaultLoad(int i5, String str) {
        this.f11861f.removeCallbacks(this.f11862g);
        this.f11861f.removeCallbacks(this.f11863h);
        this.f11858c.a(true);
        WindVaneWebView windVaneWebView = this.f11859d;
        if (windVaneWebView != null) {
            windVaneWebView.setVisibility(8);
        }
    }

    private class e extends a.C0113a {
        private e() {
        }

        public final void a() {
            super.a();
            MBTempContainer.this.receiveSuccess();
        }

        public final void b() {
            super.b();
            MBTempContainer mBTempContainer = MBTempContainer.this;
            Handler handler = mBTempContainer.f11861f;
            if (handler != null) {
                handler.removeCallbacks(mBTempContainer.f11862g);
            }
        }

        public final void onFinishRedirection(Campaign campaign, String str) {
            super.onFinishRedirection(campaign, str);
            boolean unused = MBTempContainer.this.ag = true;
            MBTempContainer.R(MBTempContainer.this);
            if (campaign != null && (campaign instanceof CampaignEx)) {
                try {
                    CampaignEx campaignEx = (CampaignEx) campaign;
                    String optString = new JSONObject(MBTempContainer.this.getJSVideoModule().getCurrentProgress()).optString("progress", "");
                    if (campaignEx.getLinkType() == 3 && campaignEx.getEndcard_click_result() == 2 && optString.equals(BuildConfig.VERSION_NAME) && MBTempContainer.this.f12961i != null) {
                        if (MBTempContainer.this.f12974v) {
                            MBTempContainer.r(MBTempContainer.this);
                        } else {
                            MBTempContainer.this.f12961i.finish();
                        }
                    }
                } catch (JSONException e5) {
                    e5.printStackTrace();
                }
            }
            if (MBTempContainer.this.aq) {
                MBTempContainer.this.onResume();
            }
        }

        public final void onRedirectionFailed(Campaign campaign, String str) {
            super.onRedirectionFailed(campaign, str);
            MBTempContainer.R(MBTempContainer.this);
            boolean unused = MBTempContainer.this.ag = true;
        }

        public final void onStartRedirection(Campaign campaign, String str) {
            super.onStartRedirection(campaign, str);
            MBTempContainer.P(MBTempContainer.this);
            if (MBTempContainer.this.aq) {
                MBTempContainer.this.onPause();
            }
        }

        public final void a(boolean z4) {
            if (MBTempContainer.this.an != null) {
                try {
                    MBTempContainer.this.an.a(v1.a.CLICK);
                    af.a("omsdk", "mbtc adUserInteraction click");
                } catch (Exception e5) {
                    af.b("omsdk", e5.getMessage());
                }
            }
            super.a(z4);
            MBTempContainer.this.f11834B.a(z4, MBTempContainer.this.f12963k, MBTempContainer.this.f12962j);
        }

        public final void a(int i5, String str) {
            super.a(i5, str);
            MBTempContainer.this.defaultLoad(i5, str);
        }
    }

    private void f() {
        com.mbridge.msdk.foundation.same.report.h hVar = new com.mbridge.msdk.foundation.same.report.h(getContext());
        CampaignEx campaignEx = this.f11865z;
        if (campaignEx != null) {
            hVar.b(campaignEx.getRequestId(), this.f11865z.getRequestIdNotice(), this.f11865z.getId(), this.f12962j, com.mbridge.msdk.mbsignalcommon.mraid.c.a(this.f11865z.getId()), this.f11865z.isBidCampaign());
            com.mbridge.msdk.mbsignalcommon.mraid.c.b(this.f11865z.getId());
            this.ae = true;
        }
    }

    private void g() {
        u1.b bVar = this.am;
        if (bVar != null) {
            try {
                MBridgeContainerView mBridgeContainerView = this.f11860e;
                u1.h hVar = u1.h.OTHER;
                bVar.a(mBridgeContainerView, hVar, (String) null);
                View view = this.aa;
                if (view != null) {
                    this.am.a(view, hVar, (String) null);
                }
                WindVaneWebView windVaneWebView = this.f11859d;
                if (windVaneWebView != null) {
                    this.am.a(windVaneWebView, hVar, (String) null);
                }
                this.mbridgeVideoView.setVideoEvents(this.an);
                this.am.g();
                if (this.ao != null) {
                    v1.d b5 = v1.d.b(true, v1.c.STANDALONE);
                    af.a("omsdk", "bt:   adEvents.loaded");
                    this.ao.d(b5);
                    this.ao.b();
                }
            } catch (Exception e5) {
                af.a("omsdk", e5.getMessage());
            }
        }
    }

    private int i() {
        CampaignEx campaignEx = this.f11865z;
        if (campaignEx == null) {
            return 1;
        }
        boolean a5 = ak.a(MBridgeConstans.DYNAMIC_VIEW_KEY_CLOSE_BTN_DELATE, campaignEx.getendcard_url());
        int c5 = ak.c(this.f11865z.getendcard_url(), MBridgeConstans.DYNAMIC_VIEW_KEY_CLOSE_BTN_DELATE);
        if (a5 && c5 >= 0) {
            return c5;
        }
        if (this.f11865z.getCbd() > -2) {
            return this.f11865z.getCbd();
        }
        return this.f12964l.p();
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0047 A[Catch:{ Exception -> 0x004d }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void b(com.mbridge.msdk.video.bt.module.MBTempContainer r5) {
        /*
            r0 = 1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            com.mbridge.msdk.foundation.same.report.d.e r1 = new com.mbridge.msdk.foundation.same.report.d.e     // Catch:{ Exception -> 0x004d }
            r1.<init>()     // Catch:{ Exception -> 0x004d }
            com.mbridge.msdk.video.module.MBridgeVideoView r2 = r5.mbridgeVideoView     // Catch:{ Exception -> 0x004d }
            java.lang.String r3 = "notify_listener"
            if (r2 == 0) goto L_0x003b
            com.mbridge.msdk.video.module.a.a r2 = r2.notifyListener     // Catch:{ Exception -> 0x004d }
            if (r2 == 0) goto L_0x003b
            r1.a(r3, r0)     // Catch:{ Exception -> 0x004d }
            com.mbridge.msdk.video.module.MBridgeVideoView r2 = r5.mbridgeVideoView     // Catch:{ Exception -> 0x004d }
            com.mbridge.msdk.video.module.a.a r2 = r2.notifyListener     // Catch:{ Exception -> 0x004d }
            boolean r3 = r2 instanceof com.mbridge.msdk.video.module.a.a.n     // Catch:{ Exception -> 0x004d }
            java.lang.String r4 = "listener_type"
            if (r3 == 0) goto L_0x0025
            r1.a(r4, r0)     // Catch:{ Exception -> 0x004d }
            goto L_0x0043
        L_0x0025:
            boolean r0 = r2 instanceof com.mbridge.msdk.video.module.a.a.m     // Catch:{ Exception -> 0x004d }
            if (r0 == 0) goto L_0x0032
            r0 = 2
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x004d }
            r1.a(r4, r0)     // Catch:{ Exception -> 0x004d }
            goto L_0x0043
        L_0x0032:
            r0 = 3
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x004d }
            r1.a(r4, r0)     // Catch:{ Exception -> 0x004d }
            goto L_0x0043
        L_0x003b:
            r0 = 0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x004d }
            r1.a(r3, r0)     // Catch:{ Exception -> 0x004d }
        L_0x0043:
            com.mbridge.msdk.foundation.same.report.d.c r5 = r5.f11852T     // Catch:{ Exception -> 0x004d }
            if (r5 == 0) goto L_0x0055
            java.lang.String r0 = "2000130"
            r5.a(r0, r1)     // Catch:{ Exception -> 0x004d }
            return
        L_0x004d:
            r5 = move-exception
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r0 == 0) goto L_0x0055
            r5.printStackTrace()
        L_0x0055:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.module.MBTempContainer.b(com.mbridge.msdk.video.bt.module.MBTempContainer):void");
    }

    private boolean d() {
        k b5 = b(this.f11865z);
        if (b5 != null) {
            return b5.p();
        }
        return false;
    }

    private boolean e() {
        if (this.mbridgeVideoView == null) {
            return false;
        }
        if (com.mbridge.msdk.e.b.a()) {
            if (this.mbridgeVideoView.isShowingAlertView() || checkChinaShowingAlertViewState() || this.mbridgeVideoView.isRewardPopViewShowing()) {
                return true;
            }
            return false;
        } else if (this.mbridgeVideoView.isShowingAlertView() || this.mbridgeVideoView.isRewardPopViewShowing()) {
            return true;
        } else {
            return false;
        }
    }

    private int c() {
        k b5 = b(this.f11865z);
        if (b5 != null) {
            return b5.m();
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public final void a(String str) {
        h hVar = this.f11834B;
        if (hVar != null) {
            hVar.a(this.f11852T, str);
        }
        super.a(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x004c A[Catch:{ all -> 0x003d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r4, java.lang.String r5) {
        /*
            r3 = this;
            com.mbridge.msdk.foundation.entity.n r0 = new com.mbridge.msdk.foundation.entity.n     // Catch:{ all -> 0x003d }
            r0.<init>()     // Catch:{ all -> 0x003d }
            java.lang.String r1 = "2000037"
            r0.a((java.lang.String) r1)     // Catch:{ all -> 0x003d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x003d }
            r1.<init>()     // Catch:{ all -> 0x003d }
            java.lang.String r2 = "code="
            r1.append(r2)     // Catch:{ all -> 0x003d }
            r1.append(r4)     // Catch:{ all -> 0x003d }
            java.lang.String r4 = ",desc="
            r1.append(r4)     // Catch:{ all -> 0x003d }
            r1.append(r5)     // Catch:{ all -> 0x003d }
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x003d }
            r0.r(r4)     // Catch:{ all -> 0x003d }
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r3.f11865z     // Catch:{ all -> 0x003d }
            java.lang.String r5 = ""
            if (r4 == 0) goto L_0x003f
            com.mbridge.msdk.foundation.entity.CampaignEx$c r4 = r4.getRewardTemplateMode()     // Catch:{ all -> 0x003d }
            if (r4 == 0) goto L_0x003f
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r3.f11865z     // Catch:{ all -> 0x003d }
            com.mbridge.msdk.foundation.entity.CampaignEx$c r4 = r4.getRewardTemplateMode()     // Catch:{ all -> 0x003d }
            java.lang.String r4 = r4.e()     // Catch:{ all -> 0x003d }
            goto L_0x0040
        L_0x003d:
            r4 = move-exception
            goto L_0x009b
        L_0x003f:
            r4 = r5
        L_0x0040:
            r0.q(r4)     // Catch:{ all -> 0x003d }
            java.lang.String r4 = r3.f12962j     // Catch:{ all -> 0x003d }
            r0.c((java.lang.String) r4)     // Catch:{ all -> 0x003d }
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r3.f11865z     // Catch:{ all -> 0x003d }
            if (r4 == 0) goto L_0x0050
            java.lang.String r5 = r4.getId()     // Catch:{ all -> 0x003d }
        L_0x0050:
            r0.e((java.lang.String) r5)     // Catch:{ all -> 0x003d }
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r3.f11865z     // Catch:{ all -> 0x003d }
            if (r4 == 0) goto L_0x006a
            java.lang.String r4 = r4.getRequestId()     // Catch:{ all -> 0x003d }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x003d }
            if (r4 != 0) goto L_0x006a
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r3.f11865z     // Catch:{ all -> 0x003d }
            java.lang.String r4 = r4.getRequestId()     // Catch:{ all -> 0x003d }
            r0.f(r4)     // Catch:{ all -> 0x003d }
        L_0x006a:
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r3.f11865z     // Catch:{ all -> 0x003d }
            if (r4 == 0) goto L_0x0081
            java.lang.String r4 = r4.getRequestIdNotice()     // Catch:{ all -> 0x003d }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x003d }
            if (r4 != 0) goto L_0x0081
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r3.f11865z     // Catch:{ all -> 0x003d }
            java.lang.String r4 = r4.getRequestIdNotice()     // Catch:{ all -> 0x003d }
            r0.g(r4)     // Catch:{ all -> 0x003d }
        L_0x0081:
            android.content.Context r4 = r3.getContext()     // Catch:{ all -> 0x003d }
            int r4 = com.mbridge.msdk.foundation.tools.ab.m(r4)     // Catch:{ all -> 0x003d }
            r0.a((int) r4)     // Catch:{ all -> 0x003d }
            android.content.Context r5 = r3.getContext()     // Catch:{ all -> 0x003d }
            java.lang.String r4 = com.mbridge.msdk.foundation.tools.ab.a((android.content.Context) r5, (int) r4)     // Catch:{ all -> 0x003d }
            r0.k(r4)     // Catch:{ all -> 0x003d }
            com.mbridge.msdk.foundation.same.report.n.b((com.mbridge.msdk.foundation.entity.n) r0)     // Catch:{ all -> 0x003d }
            return
        L_0x009b:
            java.lang.String r5 = f11832x
            java.lang.String r0 = r4.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r5, r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.module.MBTempContainer.a(int, java.lang.String):void");
    }

    private int h() {
        try {
            com.mbridge.msdk.videocommon.d.a b5 = com.mbridge.msdk.videocommon.d.b.a().b();
            if (b5 == null) {
                com.mbridge.msdk.videocommon.d.b.a().c();
            }
            if (b5 != null) {
                return (int) b5.h();
            }
            return 5;
        } catch (Throwable th) {
            th.printStackTrace();
            return 5;
        }
    }

    private int a(int i5, int i6) {
        List<CampaignEx> list;
        if (i5 < 0 || (list = this.f11850R) == null || list.size() == 0 || i6 <= 1) {
            return i5;
        }
        int i7 = 0;
        for (int i8 = 0; i8 < i6 - 1; i8++) {
            if (this.f11850R.get(i8) != null) {
                i7 += this.f11850R.get(i8).getVideoLength();
            }
        }
        if (i5 > i7) {
            return i5 - i7;
        }
        return 0;
    }

    public MBTempContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }
}
