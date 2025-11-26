package com.mbridge.msdk.reward.player;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.same.report.d.c;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon;
import com.mbridge.msdk.reward.adapter.RewardUnitCacheManager;
import com.mbridge.msdk.scheme.applet.AppletModelManager;
import com.mbridge.msdk.video.bt.module.MBTempContainer;
import com.mbridge.msdk.video.bt.module.MBridgeBTContainer;
import com.mbridge.msdk.video.bt.module.b.h;
import com.mbridge.msdk.video.dynview.e.d;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.video.signal.a.k;
import com.mbridge.msdk.video.signal.activity.AbstractJSActivity;
import com.mbridge.msdk.videocommon.a;
import com.mbridge.msdk.videocommon.download.j;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MBRewardVideoActivity extends AbstractJSActivity {
    public static String INTENT_EXTRADATA = "extraData";
    public static String INTENT_ISBID = "isBid";
    public static String INTENT_ISBIG_OFFER = "isBigOffer";
    public static String INTENT_ISIV = "isIV";
    public static String INTENT_IVREWARD_MODETYPE = "ivRewardMode";
    public static String INTENT_IVREWARD_VALUE = "ivRewardValue";
    public static String INTENT_IVREWARD_VALUETYPE = "ivRewardValueType";
    public static String INTENT_LOCAL_REQUEST_ID = "lRid";
    public static String INTENT_MUTE = "mute";
    public static String INTENT_REWARD = "reward";
    public static String INTENT_UNITID = "unitId";
    public static String INTENT_USERID = "userId";
    public static String SAVE_STATE_KEY_REPORT = "hasRelease";

    /* renamed from: A  reason: collision with root package name */
    private boolean f11422A;
    /* access modifiers changed from: private */

    /* renamed from: B  reason: collision with root package name */
    public int f11423B = 1;
    /* access modifiers changed from: private */

    /* renamed from: C  reason: collision with root package name */
    public int f11424C = 0;
    /* access modifiers changed from: private */

    /* renamed from: D  reason: collision with root package name */
    public int f11425D = 0;
    /* access modifiers changed from: private */

    /* renamed from: E  reason: collision with root package name */
    public int f11426E = 0;
    /* access modifiers changed from: private */

    /* renamed from: F  reason: collision with root package name */
    public int f11427F = 0;
    /* access modifiers changed from: private */

    /* renamed from: G  reason: collision with root package name */
    public int f11428G = 0;
    /* access modifiers changed from: private */

    /* renamed from: H  reason: collision with root package name */
    public int f11429H = 0;

    /* renamed from: I  reason: collision with root package name */
    private String f11430I;
    /* access modifiers changed from: private */

    /* renamed from: J  reason: collision with root package name */
    public c f11431J;

    /* renamed from: K  reason: collision with root package name */
    private boolean f11432K = false;

    /* renamed from: L  reason: collision with root package name */
    private boolean f11433L;

    /* renamed from: M  reason: collision with root package name */
    private u1.b f11434M = null;

    /* renamed from: N  reason: collision with root package name */
    private v1.b f11435N = null;

    /* renamed from: O  reason: collision with root package name */
    private u1.a f11436O = null;

    /* renamed from: P  reason: collision with root package name */
    private long f11437P = 0;

    /* renamed from: Q  reason: collision with root package name */
    private String f11438Q = "";

    /* renamed from: R  reason: collision with root package name */
    private boolean f11439R = false;

    /* renamed from: S  reason: collision with root package name */
    private boolean f11440S = false;

    /* renamed from: T  reason: collision with root package name */
    private boolean f11441T = false;

    /* renamed from: U  reason: collision with root package name */
    private com.mbridge.msdk.video.dynview.e.a f11442U = new com.mbridge.msdk.video.dynview.e.a() {
        public final void a(Map<String, Object> map) {
            if (map != null) {
                if (map.containsKey(CampaignEx.JSON_NATIVE_VIDEO_MUTE)) {
                    int unused = MBRewardVideoActivity.this.f11448e = ((Integer) map.get(CampaignEx.JSON_NATIVE_VIDEO_MUTE)).intValue();
                }
                if (map.containsKey("position")) {
                    int intValue = ((Integer) map.get("position")).intValue();
                    if (MBRewardVideoActivity.this.f11463t != null && MBRewardVideoActivity.this.f11463t.size() > 0 && intValue >= 1) {
                        MBRewardVideoActivity mBRewardVideoActivity = MBRewardVideoActivity.this;
                        CampaignEx unused2 = mBRewardVideoActivity.f11461r = (CampaignEx) mBRewardVideoActivity.f11463t.get(intValue);
                        MBRewardVideoActivity.b(MBRewardVideoActivity.this);
                        int i5 = intValue - 1;
                        if (MBRewardVideoActivity.this.f11463t.get(i5) != null) {
                            MBRewardVideoActivity mBRewardVideoActivity2 = MBRewardVideoActivity.this;
                            int unused3 = mBRewardVideoActivity2.f11424C = mBRewardVideoActivity2.f11424C - ((CampaignEx) MBRewardVideoActivity.this.f11463t.get(i5)).getVideoLength();
                        }
                        MBRewardVideoActivity mBRewardVideoActivity3 = MBRewardVideoActivity.this;
                        MBRewardVideoActivity.this.f11461r.setVideoCompleteTime(mBRewardVideoActivity3.a(mBRewardVideoActivity3.f11461r.getVideoCompleteTime(), MBRewardVideoActivity.this.f11423B));
                        MBRewardVideoActivity.this.f11461r.setShowIndex(MBRewardVideoActivity.this.f11423B);
                        MBRewardVideoActivity.this.f11461r.setShowType(1);
                        MBRewardVideoActivity mBRewardVideoActivity4 = MBRewardVideoActivity.this;
                        mBRewardVideoActivity4.b(mBRewardVideoActivity4.f11461r);
                    }
                }
            }
        }
    };

    /* renamed from: V  reason: collision with root package name */
    private d f11443V = new d() {
        public final void countDownClick() {
            if (MBRewardVideoActivity.this.f11465v != null) {
                new com.mbridge.msdk.video.dynview.h.b().b((View) MBRewardVideoActivity.this.f11465v, 500);
            }
            boolean unused = MBRewardVideoActivity.this.f11454k = true;
            MBRewardVideoActivity.this.b();
            if (MBRewardVideoActivity.this.f11464u != null) {
                MBRewardVideoActivity.this.f11464u.setNotchPadding(MBRewardVideoActivity.this.f11429H, MBRewardVideoActivity.this.f11425D, MBRewardVideoActivity.this.f11427F, MBRewardVideoActivity.this.f11426E, MBRewardVideoActivity.this.f11428G);
            }
        }

        public final void itemClick(CampaignEx campaignEx) {
            if (campaignEx != null) {
                if (MBRewardVideoActivity.this.f11465v != null) {
                    new com.mbridge.msdk.video.dynview.h.b().b((View) MBRewardVideoActivity.this.f11465v, 500);
                }
                CampaignEx unused = MBRewardVideoActivity.this.f11461r = campaignEx;
                MBRewardVideoActivity.this.f11461r.setShowType(2);
                MBRewardVideoActivity mBRewardVideoActivity = MBRewardVideoActivity.this;
                mBRewardVideoActivity.b(mBRewardVideoActivity.f11461r);
                return;
            }
            MBRewardVideoActivity.this.a("campaign is null");
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f11444a;

    /* renamed from: b  reason: collision with root package name */
    private String f11445b;

    /* renamed from: c  reason: collision with root package name */
    private String f11446c;

    /* renamed from: d  reason: collision with root package name */
    private com.mbridge.msdk.videocommon.b.c f11447d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f11448e = 2;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11449f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f11450g = false;

    /* renamed from: h  reason: collision with root package name */
    private int f11451h;

    /* renamed from: i  reason: collision with root package name */
    private int f11452i;

    /* renamed from: j  reason: collision with root package name */
    private int f11453j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public boolean f11454k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f11455l = false;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public h f11456m;

    /* renamed from: n  reason: collision with root package name */
    private com.mbridge.msdk.videocommon.d.c f11457n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f11458o = false;

    /* renamed from: p  reason: collision with root package name */
    private boolean f11459p = false;

    /* renamed from: q  reason: collision with root package name */
    private com.mbridge.msdk.videocommon.download.a f11460q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public CampaignEx f11461r;

    /* renamed from: s  reason: collision with root package name */
    private List<com.mbridge.msdk.videocommon.download.a> f11462s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public List<CampaignEx> f11463t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public MBTempContainer f11464u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public MBridgeBTContainer f11465v;

    /* renamed from: w  reason: collision with root package name */
    private WindVaneWebView f11466w;

    /* renamed from: x  reason: collision with root package name */
    private com.mbridge.msdk.video.bt.module.a.a f11467x;

    /* renamed from: y  reason: collision with root package name */
    private String f11468y;

    /* renamed from: z  reason: collision with root package name */
    private String f11469z;

    private static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final List<com.mbridge.msdk.videocommon.download.a> f11474a;

        /* renamed from: b  reason: collision with root package name */
        private final String f11475b;

        /* renamed from: c  reason: collision with root package name */
        private final String f11476c;

        public a(List<com.mbridge.msdk.videocommon.download.a> list, String str, String str2) {
            this.f11474a = list;
            this.f11475b = str;
            this.f11476c = str2;
        }

        public final void run() {
            try {
                List<com.mbridge.msdk.videocommon.download.a> list = this.f11474a;
                if (list != null && list.size() > 0) {
                    for (com.mbridge.msdk.videocommon.download.a next : this.f11474a) {
                        if (!(next == null || next.l() == null)) {
                            CampaignEx l5 = next.l();
                            try {
                                AppletModelManager.getInstance().remove(l5);
                            } catch (Exception e5) {
                                if (MBridgeConstans.DEBUG) {
                                    af.b("MBRewardVideoActivity", "AppletModelManager remove error", e5);
                                }
                            }
                            String str = l5.getRequestId() + l5.getId() + l5.getVideoUrlEncode();
                            j c5 = com.mbridge.msdk.videocommon.download.b.getInstance().c(this.f11475b);
                            if (c5 != null) {
                                try {
                                    c5.b(str);
                                } catch (Exception e6) {
                                    if (MBridgeConstans.DEBUG) {
                                        af.b("DownLoadManager", e6.getMessage());
                                    }
                                }
                            }
                            if (l5.getRewardTemplateMode() != null) {
                                if (!TextUtils.isEmpty(l5.getRewardTemplateMode().e())) {
                                    com.mbridge.msdk.videocommon.a.b(this.f11475b + "_" + l5.getId() + "_" + this.f11476c + "_" + l5.getRewardTemplateMode().e());
                                    com.mbridge.msdk.videocommon.a.b(l5.getAdType(), l5);
                                }
                                if (!TextUtils.isEmpty(l5.getCMPTEntryUrl())) {
                                    com.mbridge.msdk.videocommon.a.b(this.f11475b + "_" + this.f11476c + "_" + l5.getCMPTEntryUrl());
                                }
                                com.mbridge.msdk.videocommon.a.a.a().a(l5);
                            }
                        }
                    }
                }
            } catch (Exception e7) {
                af.a("MBRewardVideoActivity", e7.getMessage());
            }
        }
    }

    private static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final List<com.mbridge.msdk.videocommon.download.a> f11477a;

        /* renamed from: b  reason: collision with root package name */
        private final String f11478b;

        public b(String str, List<com.mbridge.msdk.videocommon.download.a> list) {
            this.f11477a = list;
            this.f11478b = str;
        }

        public final void run() {
            try {
                List<com.mbridge.msdk.videocommon.download.a> list = this.f11477a;
                if (list != null && list.size() > 0) {
                    for (com.mbridge.msdk.videocommon.download.a next : this.f11477a) {
                        if (!(next == null || next.l() == null)) {
                            com.mbridge.msdk.videocommon.a.a.a().a(next.l(), this.f11478b);
                        }
                    }
                }
            } catch (Throwable th) {
                af.b("MBRewardVideoActivity", th.getMessage());
            }
        }
    }

    static /* synthetic */ int b(MBRewardVideoActivity mBRewardVideoActivity) {
        int i5 = mBRewardVideoActivity.f11423B;
        mBRewardVideoActivity.f11423B = i5 + 1;
        return i5;
    }

    private void c(CampaignEx campaignEx) {
    }

    public void changeHalfScreenPadding(int i5) {
        int e5;
        int f5;
        int e6;
        int f6;
        float f7;
        try {
            CampaignEx campaignEx = this.f11461r;
            if (campaignEx != null && campaignEx.getAdSpaceT() == 2) {
                getWindow().getDecorView().setBackgroundColor(-1728053248);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f11464u.getLayoutParams();
                layoutParams.gravity = 17;
                if (this.f11461r.getRewardTemplateMode().b() == 0) {
                    if (i5 == 2) {
                        e6 = (int) (((float) ak.e((Context) this)) * 0.6f);
                        f6 = ak.f((Context) this);
                    } else {
                        e5 = (int) (((float) ak.e((Context) this)) * 0.6f);
                        f5 = ak.f((Context) this);
                        f7 = ((float) f5) * 0.7f;
                        int i6 = (int) f7;
                        layoutParams.height = e6;
                        layoutParams.width = i6;
                        this.f11464u.setLayoutParams(layoutParams);
                    }
                } else if (this.f11461r.getRewardTemplateMode().b() == 2) {
                    e6 = (int) (((float) ak.e((Context) this)) * 0.6f);
                    f6 = ak.f((Context) this);
                } else {
                    e5 = (int) (((float) ak.e((Context) this)) * 0.6f);
                    f5 = ak.f((Context) this);
                    f7 = ((float) f5) * 0.7f;
                    int i62 = (int) f7;
                    layoutParams.height = e6;
                    layoutParams.width = i62;
                    this.f11464u.setLayoutParams(layoutParams);
                }
                f7 = ((float) f6) * 0.6f;
                int i622 = (int) f7;
                layoutParams.height = e6;
                layoutParams.width = i622;
                this.f11464u.setLayoutParams(layoutParams);
            }
        } catch (Throwable th) {
            af.b("MBRewardVideoActivity", th.getMessage());
        }
    }

    public int findID(String str) {
        return x.a(getApplicationContext(), str, "id");
    }

    public int findLayout(String str) {
        return x.a(getApplicationContext(), str, TtmlNode.TAG_LAYOUT);
    }

    public void finish() {
        this.f11440S = true;
        if (this.f11434M != null) {
            af.b("omsdk", "mbrewardvideoac finish");
            this.f11434M.e();
            this.f11434M.c();
            this.f11434M = null;
        }
        com.mbridge.msdk.foundation.controller.c.m().b(0);
        MBTempContainer mBTempContainer = this.f11464u;
        if (mBTempContainer != null) {
            mBTempContainer.onDestroy();
            this.f11464u = null;
        }
        MBridgeBTContainer mBridgeBTContainer = this.f11465v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onDestroy();
            this.f11465v = null;
        }
        com.mbridge.msdk.foundation.d.b.a().c(this.f11444a);
        super.finish();
    }

    public void onBackPressed() {
        this.f11441T = true;
        super.onBackPressed();
        MBTempContainer mBTempContainer = this.f11464u;
        if (mBTempContainer != null) {
            mBTempContainer.onBackPressed();
        }
        MBridgeBTContainer mBridgeBTContainer = this.f11465v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f11464u != null) {
            changeHalfScreenPadding(configuration.orientation);
            this.f11464u.onConfigurationChanged(configuration);
        }
        MBridgeBTContainer mBridgeBTContainer = this.f11465v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onConfigurationChanged(configuration);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String str;
        int i5;
        WindVaneWebView windVaneWebView;
        List<com.mbridge.msdk.videocommon.download.a> list;
        String str2 = "";
        super.onCreate(bundle);
        MBridgeConstans.isRewardActivityShowing = true;
        com.mbridge.msdk.foundation.controller.c.m().a((Context) this);
        this.f11437P = SystemClock.elapsedRealtime();
        if (TextUtils.isEmpty(this.f11438Q)) {
            str = "onCreate";
        } else {
            str = this.f11438Q + "_onCreate";
        }
        this.f11438Q = str;
        try {
            Intent intent = getIntent();
            this.f11444a = intent.getStringExtra(INTENT_UNITID);
            this.f11445b = intent.getStringExtra(MBridgeConstans.PLACEMENT_ID);
            this.f11447d = com.mbridge.msdk.videocommon.b.c.b(intent.getStringExtra(INTENT_REWARD));
            this.f11446c = intent.getStringExtra(INTENT_USERID);
            this.f11448e = intent.getIntExtra(INTENT_MUTE, 2);
            this.f11449f = intent.getBooleanExtra(INTENT_ISIV, false);
            com.mbridge.msdk.foundation.controller.c m5 = com.mbridge.msdk.foundation.controller.c.m();
            int i6 = 94;
            if (this.f11449f) {
                i5 = 287;
            } else {
                i5 = 94;
            }
            m5.b(i5);
            this.f11450g = intent.getBooleanExtra(INTENT_ISBID, false);
            this.f11469z = intent.getStringExtra(INTENT_EXTRADATA);
            boolean booleanExtra = intent.getBooleanExtra("is_refactor", false);
            this.f11432K = booleanExtra;
            if (booleanExtra) {
                this.f11456m = MBridgeGlobalCommon.showRewardListenerMap.get(this.f11444a);
            } else {
                this.f11456m = com.mbridge.msdk.reward.b.a.f11298f.get(this.f11444a);
            }
            if (this.f11449f) {
                this.f11451h = intent.getIntExtra(INTENT_IVREWARD_MODETYPE, 0);
                this.f11452i = intent.getIntExtra(INTENT_IVREWARD_VALUETYPE, 0);
                this.f11453j = intent.getIntExtra(INTENT_IVREWARD_VALUE, 0);
            }
            this.f11454k = intent.getBooleanExtra(INTENT_ISBIG_OFFER, false);
            this.f11462s = com.mbridge.msdk.videocommon.download.b.getInstance().b(this.f11444a);
            this.f11463t = com.mbridge.msdk.videocommon.download.b.getInstance().a(this.f11444a);
            int findLayout = findLayout("mbridge_more_offer_activity");
            if (findLayout < 0) {
                a("no mbridge_more_offer_activity layout");
                return;
            }
            setContentView(findLayout);
            if (TextUtils.isEmpty(this.f11444a)) {
                a("data empty error");
                return;
            }
            com.mbridge.msdk.video.signal.factory.b bVar = new com.mbridge.msdk.video.signal.factory.b(this);
            this.jsFactory = bVar;
            registerJsFactory(bVar);
            if (this.f11456m == null) {
                a("showRewardListener is null");
                return;
            }
            com.mbridge.msdk.videocommon.d.c cVar = RewardUnitCacheManager.getInstance().get(this.f11445b, this.f11444a);
            this.f11457n = cVar;
            if (cVar == null) {
                com.mbridge.msdk.videocommon.d.c a5 = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f11444a);
                this.f11457n = a5;
                if (a5 == null) {
                    this.f11457n = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f11444a, this.f11449f);
                }
            }
            com.mbridge.msdk.videocommon.d.c cVar2 = this.f11457n;
            if (cVar2 != null) {
                this.f11447d.a(cVar2.m());
                this.f11447d.a(this.f11457n.n());
            }
            com.mbridge.msdk.videocommon.b.c cVar3 = this.f11447d;
            if (cVar3 != null && cVar3.b() <= 0) {
                this.f11447d.a(1);
            }
            int a6 = x.a(this, "mbridge_reward_activity_open", "anim");
            int a7 = x.a(this, "mbridge_reward_activity_stay", "anim");
            if (a6 > 1 && a7 > 1) {
                overridePendingTransition(a6, a7);
            }
            if (bundle != null) {
                this.f11459p = bundle.getBoolean(SAVE_STATE_KEY_REPORT);
            }
            af.a("DynamicViewCampaignResourceDownloader", "进入 show，大模板 " + this.f11454k);
            if (!this.f11454k) {
                List<com.mbridge.msdk.videocommon.download.a> list2 = this.f11462s;
                if (list2 != null && list2.size() > 0) {
                    this.f11460q = this.f11462s.get(0);
                }
                com.mbridge.msdk.videocommon.download.a aVar = this.f11460q;
                if (aVar != null) {
                    this.f11461r = aVar.l();
                    this.f11460q.e(true);
                    this.f11460q.f(false);
                    CampaignEx campaignEx = this.f11461r;
                    if (campaignEx != null) {
                        this.f11430I = campaignEx.getCurrentLocalRid();
                        this.f11461r.setShowIndex(1);
                        this.f11461r.setShowType(1);
                        com.mbridge.msdk.reward.b.a.f11295b = this.f11461r.getEcppv();
                        com.mbridge.msdk.click.c.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f11461r.getMaitve(), this.f11461r.getMaitve_src());
                    }
                }
                if (this.f11460q == null || this.f11461r == null || this.f11447d == null) {
                    a("data empty error");
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.f11461r);
                b((List<CampaignEx>) arrayList);
                a(this.f11461r);
                b();
                if (!com.mbridge.msdk.e.b.a()) {
                    a();
                    return;
                }
                return;
            }
            b(this.f11463t);
            this.f11468y = str2;
            List<CampaignEx> list3 = this.f11463t;
            if (list3 != null && list3.size() > 0) {
                CampaignEx campaignEx2 = this.f11463t.get(0);
                a(campaignEx2);
                str2 = campaignEx2.getCMPTEntryUrl();
                this.f11468y = campaignEx2.getRequestId();
                this.f11430I = campaignEx2.getCurrentLocalRid();
                com.mbridge.msdk.reward.b.a.f11295b = campaignEx2.getEcppv();
                com.mbridge.msdk.click.c.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx2.getMaitve(), campaignEx2.getMaitve_src());
            }
            a.C0114a a8 = com.mbridge.msdk.videocommon.a.a(this.f11444a + "_" + this.f11468y + "_" + str2);
            com.mbridge.msdk.videocommon.download.a aVar2 = null;
            if (a8 != null) {
                windVaneWebView = a8.a();
            } else {
                windVaneWebView = null;
            }
            this.f11466w = windVaneWebView;
            if (windVaneWebView == null) {
                if (this.f11460q == null && (list = this.f11462s) != null && list.size() > 0) {
                    this.f11460q = this.f11462s.get(0);
                }
                if (this.f11460q == null) {
                    com.mbridge.msdk.videocommon.download.b instance = com.mbridge.msdk.videocommon.download.b.getInstance();
                    if (this.f11449f) {
                        i6 = 287;
                    }
                    String str3 = this.f11444a;
                    boolean z4 = this.f11450g;
                    j c5 = instance.c(str3);
                    if (c5 != null) {
                        aVar2 = c5.b(i6, z4);
                    }
                    this.f11460q = aVar2;
                }
                com.mbridge.msdk.videocommon.download.a aVar3 = this.f11460q;
                if (aVar3 != null) {
                    this.f11461r = aVar3.l();
                    this.f11460q.e(true);
                    this.f11460q.f(false);
                }
                if (!(this.f11460q == null || this.f11461r == null)) {
                    if (this.f11447d != null) {
                        this.f11454k = false;
                        List<CampaignEx> a9 = com.mbridge.msdk.videocommon.a.a.a().a(this.f11463t);
                        if (a9 == null) {
                            a("no available campaign");
                            return;
                        }
                        int size = a9.size();
                        if (size == 0) {
                            a("no available campaign");
                            return;
                        } else if (a9.get(0) == null || !a9.get(0).isDynamicView()) {
                            b();
                        } else if (size == 1) {
                            CampaignEx campaignEx3 = a9.get(0);
                            this.f11461r = campaignEx3;
                            if (campaignEx3 != null) {
                                this.f11430I = campaignEx3.getCurrentLocalRid();
                                this.f11461r.setCampaignIsFiltered(true);
                            }
                            b(this.f11461r);
                        } else {
                            a(a9);
                        }
                    }
                }
                a("data empty error");
                return;
            }
            a(this.f11463t.get(0));
            WindVaneWebView windVaneWebView2 = this.f11466w;
            if (windVaneWebView2 != null) {
                try {
                    k kVar = (k) windVaneWebView2.getObject();
                    kVar.a(this.f11436O);
                    kVar.a(this.f11434M);
                    kVar.a(this.f11435N);
                    this.f11466w.setObject(kVar);
                } catch (Exception e5) {
                    af.b("MBRewardVideoActivity", e5.getMessage());
                }
            }
            c();
            if (!com.mbridge.msdk.e.b.a()) {
                a();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        } catch (Throwable th) {
            b(this.f11463t);
            a("onCreate error" + th);
        }
    }

    public void onDestroy() {
        String str;
        String str2;
        int i5;
        int i6;
        int i7;
        int i8;
        h hVar;
        if (TextUtils.isEmpty(this.f11438Q)) {
            str = "onDestroy";
        } else {
            str = this.f11438Q + "_onDestroy";
        }
        this.f11438Q = str;
        super.onDestroy();
        h hVar2 = this.f11456m;
        if (hVar2 != null && (hVar2 instanceof com.mbridge.msdk.video.bt.module.b.b)) {
            try {
                com.mbridge.msdk.video.bt.module.b.b bVar = (com.mbridge.msdk.video.bt.module.b.b) hVar2;
                if (!bVar.f12013b && !bVar.f12014c) {
                    this.f11439R = true;
                }
            } catch (Throwable th) {
                af.b("MBRewardVideoActivity", th.getMessage());
            }
        }
        e eVar = new e();
        if (TextUtils.isEmpty(this.f11438Q)) {
            str2 = "unKnown";
        } else {
            str2 = this.f11438Q;
        }
        eVar.a("activity_life_cycle", str2);
        eVar.a("activity_duration", Long.valueOf(SystemClock.elapsedRealtime() - this.f11437P));
        if (this.f11439R) {
            i5 = 1;
        } else {
            i5 = 2;
        }
        eVar.a("is_unexpected_destroy", Integer.valueOf(i5));
        if (this.f11456m == null) {
            i6 = 1;
        } else {
            i6 = 2;
        }
        eVar.a("is_listener_null", Integer.valueOf(i6));
        if (this.f11440S) {
            i7 = 1;
        } else {
            i7 = 2;
        }
        eVar.a("is_called_finish", Integer.valueOf(i7));
        if (this.f11441T) {
            i8 = 1;
        } else {
            i8 = 2;
        }
        eVar.a("is_back_pressed", Integer.valueOf(i8));
        com.mbridge.msdk.foundation.same.report.d.d.a().a("2000151", this.f11461r, eVar);
        try {
            if (this.f11439R && (hVar = this.f11456m) != null) {
                hVar.a(this.f11431J, "show fail : unexpected destroy");
            }
        } catch (Throwable th2) {
            af.b("MBRewardVideoActivity", th2.getMessage());
        }
        com.mbridge.msdk.video.module.b.b.a(this.f11444a);
        e();
        MBTempContainer mBTempContainer = this.f11464u;
        if (mBTempContainer != null) {
            mBTempContainer.onDestroy();
            this.f11464u = null;
        }
        MBridgeBTContainer mBridgeBTContainer = this.f11465v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onDestroy();
            this.f11465v = null;
        }
        this.f11442U = null;
        this.f11443V = null;
        com.mbridge.msdk.foundation.d.b.a().c(this.f11444a + "_" + 1);
        com.mbridge.msdk.foundation.d.b.a().c(this.f11444a + "_" + 2);
        com.mbridge.msdk.foundation.same.f.a.b().execute(new a(this.f11462s, this.f11444a, this.f11468y));
    }

    public void onPause() {
        String str;
        super.onPause();
        if (TextUtils.isEmpty(this.f11438Q)) {
            str = "onPause";
        } else {
            str = this.f11438Q + "_onPause";
        }
        this.f11438Q = str;
        MBTempContainer mBTempContainer = this.f11464u;
        if (mBTempContainer != null) {
            mBTempContainer.onPause();
        }
        MBridgeBTContainer mBridgeBTContainer = this.f11465v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onPause();
        }
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        String str;
        super.onRestart();
        if (TextUtils.isEmpty(this.f11438Q)) {
            str = "onRestart";
        } else {
            str = this.f11438Q + "_onRestart";
        }
        this.f11438Q = str;
        MBTempContainer mBTempContainer = this.f11464u;
        if (mBTempContainer != null) {
            mBTempContainer.onRestart();
        }
        MBridgeBTContainer mBridgeBTContainer = this.f11465v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onRestart();
        }
    }

    public void onResume() {
        String str;
        MBridgeVideoView mBridgeVideoView;
        super.onResume();
        if (TextUtils.isEmpty(this.f11438Q)) {
            str = "onResume";
        } else {
            str = this.f11438Q + "_onResume";
        }
        this.f11438Q = str;
        if (com.mbridge.msdk.foundation.d.b.f8931c) {
            MBTempContainer mBTempContainer = this.f11464u;
            if (mBTempContainer != null && (mBridgeVideoView = mBTempContainer.mbridgeVideoView) != null) {
                mBridgeVideoView.setCover(false);
                return;
            }
            return;
        }
        com.mbridge.msdk.foundation.controller.c.m().a((Context) this);
        try {
            com.mbridge.msdk.foundation.same.f.a.b().execute(new b(this.f11444a, this.f11462s));
        } catch (Throwable th) {
            af.b("MBRewardVideoActivity", th.getMessage());
        }
        MBTempContainer mBTempContainer2 = this.f11464u;
        if (mBTempContainer2 != null) {
            mBTempContainer2.onResume();
        }
        MBridgeBTContainer mBridgeBTContainer = this.f11465v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onResume();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(SAVE_STATE_KEY_REPORT, this.f11459p);
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        String str;
        super.onStart();
        if (TextUtils.isEmpty(this.f11438Q)) {
            str = "onStart";
        } else {
            str = this.f11438Q + "_onStart";
        }
        this.f11438Q = str;
        if (!com.mbridge.msdk.foundation.d.b.f8931c) {
            new com.mbridge.msdk.foundation.d.a() {
                public final void close() {
                    MBRewardVideoActivity.this.onResume();
                }

                public final void showed() {
                    MBRewardVideoActivity.this.onPause();
                }

                public final void summit(String str) {
                    MBRewardVideoActivity.this.onResume();
                }
            };
            MBTempContainer mBTempContainer = this.f11464u;
            if (mBTempContainer != null) {
                mBTempContainer.onStart();
                this.f11461r.setCampaignUnitId(this.f11444a);
                com.mbridge.msdk.foundation.d.b.a().a(this.f11444a + "_" + 1, this.f11461r);
            }
            MBridgeBTContainer mBridgeBTContainer = this.f11465v;
            if (mBridgeBTContainer != null) {
                mBridgeBTContainer.onStart();
                List<CampaignEx> list = this.f11463t;
                if (list != null && list.size() > 0) {
                    CampaignEx campaignEx = this.f11463t.get(0);
                    campaignEx.setCampaignUnitId(this.f11444a);
                    com.mbridge.msdk.foundation.d.b.a().a(this.f11444a + "_" + 1, campaignEx);
                }
            }
            if (!this.f11422A) {
                com.mbridge.msdk.foundation.d.b.a().a(this.f11444a + "_" + 1, 1);
                com.mbridge.msdk.foundation.d.b.a().c(this.f11444a + "_" + 2);
                this.f11422A = true;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        String str;
        if (TextUtils.isEmpty(this.f11438Q)) {
            str = "onStop";
        } else {
            str = this.f11438Q + "_onStop";
        }
        this.f11438Q = str;
        MBridgeConstans.isRewardActivityShowing = false;
        super.onStop();
        MBTempContainer mBTempContainer = this.f11464u;
        if (mBTempContainer != null) {
            mBTempContainer.onStop();
        }
        MBridgeBTContainer mBridgeBTContainer = this.f11465v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onStop();
        }
    }

    public void setTheme(int i5) {
        super.setTheme(x.a(this, "mbridge_transparent_theme", TtmlNode.TAG_STYLE));
    }

    public void setTopControllerPadding(int i5, int i6, int i7, int i8, int i9) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        this.f11425D = i6;
        this.f11427F = i7;
        this.f11426E = i8;
        this.f11428G = i9;
        this.f11429H = i5;
        MBTempContainer mBTempContainer = this.f11464u;
        if (mBTempContainer != null) {
            int i15 = i5;
            int i16 = i6;
            int i17 = i7;
            int i18 = i8;
            int i19 = i9;
            mBTempContainer.setNotchPadding(i15, i16, i17, i18, i19);
            i10 = i19;
            i11 = i18;
            i12 = i17;
            i13 = i16;
            i14 = i15;
        } else {
            i14 = i5;
            i13 = i6;
            i12 = i7;
            i11 = i8;
            i10 = i9;
        }
        MBridgeBTContainer mBridgeBTContainer = this.f11465v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.setNotchPadding(i14, i13, i12, i11, i10);
        }
        int i20 = i14;
        int i21 = i13;
        int i22 = i12;
        com.mbridge.msdk.video.dynview.a.a.f12036e = i20;
        com.mbridge.msdk.video.dynview.a.a.f12032a = i21;
        com.mbridge.msdk.video.dynview.a.a.f12033b = i22;
        com.mbridge.msdk.video.dynview.a.a.f12034c = i11;
        com.mbridge.msdk.video.dynview.a.a.f12035d = i10;
    }

    private com.mbridge.msdk.video.bt.module.a.a d() {
        if (this.f11467x == null) {
            this.f11467x = new com.mbridge.msdk.video.bt.module.a.a() {
                public final void a() {
                    if (MBRewardVideoActivity.this.f11456m != null) {
                        MBRewardVideoActivity.this.f11456m.a(MBRewardVideoActivity.this.f11431J);
                    }
                }

                public final void b(String str, String str2) {
                    if (MBRewardVideoActivity.this.f11456m != null) {
                        MBRewardVideoActivity.this.f11456m.b(str, str2);
                    }
                }

                public final void a(boolean z4, com.mbridge.msdk.videocommon.b.c cVar) {
                    if (MBRewardVideoActivity.this.f11456m != null) {
                        MBRewardVideoActivity.this.f11456m.a(MBRewardVideoActivity.this.f11431J, z4, cVar);
                    }
                }

                public final void a(boolean z4, int i5) {
                    if (MBRewardVideoActivity.this.f11456m != null) {
                        MBRewardVideoActivity.this.f11456m.a(z4, i5);
                    }
                }

                public final void a(String str) {
                    if (MBRewardVideoActivity.this.f11456m != null) {
                        MBRewardVideoActivity.this.f11456m.a(MBRewardVideoActivity.this.f11431J, str);
                    }
                }

                public final void a(boolean z4, String str, String str2) {
                    if (MBRewardVideoActivity.this.f11456m != null) {
                        MBRewardVideoActivity.this.f11456m.a(z4, str, str2);
                    }
                }

                public final void a(String str, String str2) {
                    if (MBRewardVideoActivity.this.f11456m != null) {
                        MBRewardVideoActivity.this.f11456m.a(str, str2);
                    }
                }

                public final void a(int i5, String str, String str2) {
                    if (MBRewardVideoActivity.this.f11456m != null) {
                        MBRewardVideoActivity.this.f11456m.a(i5, str, str2);
                    }
                }
            };
        }
        return this.f11467x;
    }

    private void e() {
        try {
            List<CampaignEx> list = this.f11463t;
            if (list != null && list.size() > 0) {
                for (CampaignEx d5 : this.f11463t) {
                    d(d5);
                }
            }
            CampaignEx campaignEx = this.f11461r;
            if (campaignEx != null) {
                d(campaignEx);
            }
        } catch (Throwable th) {
            af.b("MBRewardVideoActivity", th.getMessage());
        }
    }

    private void c() {
        List<CampaignEx> list;
        RewardPlus rewardPlus;
        int findID = findID("mbridge_bt_container");
        if (findID < 0) {
            a("no mbridge_webview_framelayout in mbridge_more_offer_activity layout");
        }
        MBridgeBTContainer mBridgeBTContainer = (MBridgeBTContainer) findViewById(findID);
        this.f11465v = mBridgeBTContainer;
        if (mBridgeBTContainer == null) {
            a("env error");
        }
        this.f11465v.setVisibility(0);
        com.mbridge.msdk.video.bt.module.a.a d5 = d();
        this.f11467x = d5;
        this.f11465v.setBTContainerCallback(d5);
        this.f11465v.setShowRewardVideoListener(this.f11456m);
        this.f11465v.setChoiceOneCallback(this.f11443V);
        this.f11465v.setCampaigns(this.f11463t);
        this.f11465v.setCampaignDownLoadTasks(this.f11462s);
        this.f11465v.setRewardUnitSetting(this.f11457n);
        this.f11465v.setUnitId(this.f11444a);
        this.f11465v.setPlacementId(this.f11445b);
        this.f11465v.setUserId(this.f11446c);
        this.f11465v.setActivity(this);
        CampaignEx campaignEx = this.f11461r;
        if (!((campaignEx == null || (rewardPlus = campaignEx.getRewardPlus()) == null) && (this.f11463t.get(0) == null || (rewardPlus = this.f11463t.get(0).getRewardPlus()) == null)) && !TextUtils.isEmpty(rewardPlus.getName()) && rewardPlus.getAmount() > 0) {
            com.mbridge.msdk.videocommon.b.c cVar = new com.mbridge.msdk.videocommon.b.c(rewardPlus.getName(), rewardPlus.getAmount());
            if (cVar.b() < 0) {
                cVar.a(1);
            }
            this.f11447d = cVar;
        }
        this.f11465v.setReward(this.f11447d);
        this.f11465v.setIVRewardEnable(this.f11451h, this.f11452i, this.f11453j);
        this.f11465v.setIV(this.f11449f);
        this.f11465v.setMute(this.f11448e);
        this.f11465v.setJSFactory((com.mbridge.msdk.video.signal.factory.b) this.jsFactory);
        this.f11465v.setDeveloperExtraData(this.f11469z);
        this.f11465v.init(this);
        this.f11465v.setAdSession(this.f11434M);
        this.f11465v.setVideoEvents(this.f11435N);
        this.f11465v.setAdEvents(this.f11436O);
        this.f11465v.onCreate(this.f11432K);
        if (com.mbridge.msdk.e.b.a() && (list = this.f11463t) != null && list.size() > 0 && this.f11463t.get(0) != null) {
            c(this.f11463t.get(0));
        }
    }

    /* access modifiers changed from: private */
    public void b(CampaignEx campaignEx) {
        CampaignEx l5;
        try {
            List<com.mbridge.msdk.videocommon.download.a> list = this.f11462s;
            if (list != null && list.size() > 0) {
                for (com.mbridge.msdk.videocommon.download.a next : this.f11462s) {
                    if (next != null && (l5 = next.l()) != null && TextUtils.equals(l5.getId(), campaignEx.getId()) && TextUtils.equals(l5.getRequestId(), campaignEx.getRequestId())) {
                        this.f11460q = next;
                    }
                }
            }
            this.f11454k = true;
            b();
            MBTempContainer mBTempContainer = this.f11464u;
            if (mBTempContainer != null) {
                mBTempContainer.setNotchPadding(this.f11429H, this.f11425D, this.f11427F, this.f11426E, this.f11428G);
            }
        } catch (Exception e5) {
            af.b("MBRewardVideoActivity", e5.getMessage());
            a("more offer to one offer exception");
        }
    }

    private void d(CampaignEx campaignEx) {
        if (campaignEx != null) {
            if (!TextUtils.isEmpty(campaignEx.getImageUrl())) {
                com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.c.m().c());
                campaignEx.getImageUrl();
            }
            if (!TextUtils.isEmpty(campaignEx.getIconUrl())) {
                com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.c.m().c());
                campaignEx.getIconUrl();
            }
        }
    }

    private void a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                if (campaignEx.isActiveOm() && this.f11434M == null) {
                    u1.b a5 = com.mbridge.msdk.a.b.a(getApplicationContext(), false, campaignEx.getOmid(), campaignEx.getRequestId(), campaignEx.getId(), this.f11444a, campaignEx.getVideoUrlEncode(), campaignEx.getRequestIdNotice());
                    this.f11434M = a5;
                    if (a5 != null) {
                        this.f11436O = u1.a.a(a5);
                        this.f11435N = v1.b.g(this.f11434M);
                    }
                }
            } catch (Throwable th) {
                af.b("MBRewardVideoActivity", th.getMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        CampaignEx campaignEx;
        RewardPlus rewardPlus;
        List<CampaignEx> list;
        List<CampaignEx> list2;
        int findID = findID("mbridge_temp_container");
        if (findID < 0) {
            a("no id mbridge_bt_container in mbridge_more_offer_activity layout");
        }
        MBTempContainer mBTempContainer = (MBTempContainer) findViewById(findID);
        this.f11464u = mBTempContainer;
        if (mBTempContainer == null) {
            a("env error");
        }
        List<CampaignEx> list3 = this.f11463t;
        if (list3 == null || list3.size() <= 0 || !this.f11463t.get(0).isDynamicView()) {
            this.f11464u.setVisibility(0);
        } else {
            new com.mbridge.msdk.video.dynview.h.b().c((View) this.f11464u, 500);
        }
        changeHalfScreenPadding(-1);
        this.f11464u.setActivity(this);
        this.f11464u.setBidCampaign(this.f11450g);
        this.f11464u.setBigOffer(this.f11454k);
        this.f11464u.setUnitId(this.f11444a);
        this.f11464u.setCampaign(this.f11461r);
        if (this.f11461r.getDynamicTempCode() == 5 && (list2 = this.f11463t) != null && list2.size() > 1) {
            View findViewById = findViewById(findID("mbridge_reward_root_container"));
            if (findViewById != null) {
                findViewById.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.f11464u.removeAllViews();
            this.f11464u.setCampOrderViewData(this.f11463t, this.f11424C);
            this.f11464u.setCamPlayOrderCallback(this.f11442U, this.f11423B);
        }
        this.f11464u.setCampaignDownLoadTask(this.f11460q);
        this.f11464u.setIV(this.f11449f);
        CampaignEx campaignEx2 = this.f11461r;
        if (campaignEx2 == null || campaignEx2.getAdSpaceT() != 2) {
            this.f11464u.setIVRewardEnable(this.f11451h, this.f11452i, this.f11453j);
        } else {
            this.f11464u.setIVRewardEnable(0, 0, 0);
        }
        this.f11464u.setMute(this.f11448e);
        CampaignEx campaignEx3 = this.f11461r;
        if (!((campaignEx3 == null || (rewardPlus = campaignEx3.getRewardPlus()) == null) && ((list = this.f11463t) == null || list.size() <= 0 || this.f11463t.get(0) == null || (rewardPlus = this.f11463t.get(0).getRewardPlus()) == null)) && !TextUtils.isEmpty(rewardPlus.getName()) && rewardPlus.getAmount() > 0) {
            com.mbridge.msdk.videocommon.b.c cVar = new com.mbridge.msdk.videocommon.b.c(rewardPlus.getName(), rewardPlus.getAmount());
            if (cVar.b() < 0) {
                cVar.a(1);
            }
            this.f11447d = cVar;
        }
        this.f11464u.setReward(this.f11447d);
        this.f11464u.setRewardUnitSetting(this.f11457n);
        this.f11464u.setPlacementId(this.f11445b);
        this.f11464u.setUserId(this.f11446c);
        this.f11464u.setShowRewardListener(this.f11456m);
        this.f11464u.setDeveloperExtraData(this.f11469z);
        this.f11464u.init(this);
        this.f11464u.setAdSession(this.f11434M);
        this.f11464u.setAdEvents(this.f11436O);
        this.f11464u.setVideoEvents(this.f11435N);
        this.f11464u.onCreate();
        if (com.mbridge.msdk.e.b.a() && (campaignEx = this.f11461r) != null) {
            c(campaignEx);
        }
    }

    private void a() {
        try {
            ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
            BitmapDrawable a5 = com.mbridge.msdk.foundation.controller.c.m().a(this.f11444a, this.f11449f ? 287 : 94);
            if (a5 != null) {
                ImageView imageView = new ImageView(com.mbridge.msdk.foundation.controller.c.m().c());
                ak.a(imageView, a5, getResources().getDisplayMetrics());
                ((ViewGroup) ((ViewGroup) ((ViewGroup) viewGroup.getChildAt(0)).getChildAt(1)).getChildAt(0)).addView(imageView, new ViewGroup.LayoutParams(-1, -1));
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    private void a(List<CampaignEx> list) {
        int i5;
        if (list == null) {
            a("no available campaign");
        } else if (list.size() == 0) {
            a("no available campaign");
        } else {
            if (list.get(0) != null) {
                i5 = list.get(0).getDynamicTempCode();
                this.f11430I = list.get(0).getCurrentLocalRid();
            } else {
                i5 = 0;
            }
            if (i5 != 5) {
                c();
                return;
            }
            for (CampaignEx next : list) {
                if (next != null) {
                    this.f11424C += next.getVideoLength();
                }
            }
            CampaignEx campaignEx = list.get(0);
            if (campaignEx != null) {
                int a5 = a(campaignEx.getVideoCompleteTime(), this.f11423B);
                this.f11461r = campaignEx;
                campaignEx.setCampaignIsFiltered(true);
                this.f11423B = 1;
                this.f11461r.setVideoCompleteTime(a5);
                this.f11461r.setShowIndex(this.f11423B);
                this.f11461r.setShowType(1);
                b(this.f11461r);
                return;
            }
            a("campaign is less");
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        af.b("MBRewardVideoActivity", str);
        b(this.f11463t);
        h hVar = this.f11456m;
        if (hVar != null) {
            hVar.a(this.f11431J, str);
        }
        finish();
    }

    /* access modifiers changed from: private */
    public int a(int i5, int i6) {
        List<CampaignEx> list = this.f11463t;
        if (!(list == null || list.size() == 0)) {
            int i7 = 0;
            int i8 = 0;
            for (int i9 = 0; i9 < this.f11463t.size(); i9++) {
                if (this.f11463t.get(0) != null) {
                    if (i9 == 0) {
                        i8 = this.f11463t.get(0).getVideoCompleteTime();
                    }
                    i7 += this.f11463t.get(i9).getVideoLength();
                }
            }
            if (i6 == 1) {
                if (i5 == 0) {
                    if (i7 >= 45) {
                        return 45;
                    }
                } else if (i7 > i5) {
                    if (i5 > 45) {
                        return 45;
                    }
                }
                return i7;
            }
            int i10 = 0;
            for (int i11 = 0; i11 < i6 - 1; i11++) {
                if (this.f11463t.get(i11) != null) {
                    i10 += this.f11463t.get(i11).getVideoLength();
                }
            }
            if (i8 > i10) {
                return i8 - i10;
            }
            return 0;
        }
        return i5;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x005d A[Catch:{ Exception -> 0x0010 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006d A[SYNTHETIC, Splitter:B:32:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b2 A[Catch:{ Exception -> 0x0010 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r5) {
        /*
            r4 = this;
            boolean r0 = r4.f11433L
            if (r0 == 0) goto L_0x0006
            goto L_0x00cb
        L_0x0006:
            r0 = 0
            if (r5 != 0) goto L_0x003f
            boolean r5 = r4.f11454k     // Catch:{ Exception -> 0x0010 }
            if (r5 == 0) goto L_0x0013
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r5 = r4.f11463t     // Catch:{ Exception -> 0x0010 }
            goto L_0x003f
        L_0x0010:
            r5 = move-exception
            goto L_0x00c4
        L_0x0013:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x0010 }
            r5.<init>()     // Catch:{ Exception -> 0x0010 }
            java.util.List<com.mbridge.msdk.videocommon.download.a> r1 = r4.f11462s     // Catch:{ Exception -> 0x0010 }
            if (r1 == 0) goto L_0x003f
            java.lang.Object r1 = r1.get(r0)     // Catch:{ Exception -> 0x0010 }
            if (r1 == 0) goto L_0x003f
            java.util.List<com.mbridge.msdk.videocommon.download.a> r1 = r4.f11462s     // Catch:{ Exception -> 0x0010 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ Exception -> 0x0010 }
            com.mbridge.msdk.videocommon.download.a r1 = (com.mbridge.msdk.videocommon.download.a) r1     // Catch:{ Exception -> 0x0010 }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r1.l()     // Catch:{ Exception -> 0x0010 }
            if (r1 == 0) goto L_0x003f
            java.util.List<com.mbridge.msdk.videocommon.download.a> r1 = r4.f11462s     // Catch:{ Exception -> 0x0010 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ Exception -> 0x0010 }
            com.mbridge.msdk.videocommon.download.a r1 = (com.mbridge.msdk.videocommon.download.a) r1     // Catch:{ Exception -> 0x0010 }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r1.l()     // Catch:{ Exception -> 0x0010 }
            r5.add(r1)     // Catch:{ Exception -> 0x0010 }
        L_0x003f:
            java.lang.String r1 = ""
            if (r5 == 0) goto L_0x0056
            boolean r2 = r5.isEmpty()     // Catch:{ Exception -> 0x0010 }
            if (r2 != 0) goto L_0x0056
            java.lang.Object r0 = r5.get(r0)     // Catch:{ Exception -> 0x0010 }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0     // Catch:{ Exception -> 0x0010 }
            if (r0 == 0) goto L_0x0056
            java.lang.String r0 = r0.getCurrentLocalRid()     // Catch:{ Exception -> 0x0010 }
            goto L_0x0057
        L_0x0056:
            r0 = r1
        L_0x0057:
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0010 }
            if (r2 != 0) goto L_0x0067
            com.mbridge.msdk.foundation.same.report.d.d r2 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x0010 }
            com.mbridge.msdk.foundation.same.report.d.c r0 = r2.a((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x0010 }
            r4.f11431J = r0     // Catch:{ Exception -> 0x0010 }
        L_0x0067:
            com.mbridge.msdk.foundation.same.report.d.c r0 = r4.f11431J     // Catch:{ Exception -> 0x0010 }
            java.lang.String r1 = "2000129"
            if (r0 != 0) goto L_0x00b0
            com.mbridge.msdk.foundation.same.report.d.c r0 = new com.mbridge.msdk.foundation.same.report.d.c     // Catch:{ Exception -> 0x0010 }
            r0.<init>()     // Catch:{ Exception -> 0x0010 }
            r4.f11431J = r0     // Catch:{ Exception -> 0x0010 }
            com.mbridge.msdk.foundation.same.report.d.e r0 = new com.mbridge.msdk.foundation.same.report.d.e     // Catch:{ Exception -> 0x0010 }
            r0.<init>()     // Catch:{ Exception -> 0x0010 }
            java.lang.String r2 = "unit_id"
            java.lang.String r3 = r4.f11444a     // Catch:{ Exception -> 0x0010 }
            r0.a(r2, r3)     // Catch:{ Exception -> 0x0010 }
            java.lang.String r2 = "hb"
            boolean r3 = r4.f11450g     // Catch:{ Exception -> 0x0010 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0010 }
            r0.a(r2, r3)     // Catch:{ Exception -> 0x0010 }
            java.lang.String r2 = "adtp"
            boolean r3 = r4.f11449f     // Catch:{ Exception -> 0x0010 }
            if (r3 == 0) goto L_0x0094
            r3 = 287(0x11f, float:4.02E-43)
            goto L_0x0096
        L_0x0094:
            r3 = 94
        L_0x0096:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0010 }
            r0.a(r2, r3)     // Catch:{ Exception -> 0x0010 }
            java.lang.String r2 = "lrid"
            java.lang.String r3 = r4.f11430I     // Catch:{ Exception -> 0x0010 }
            r0.a(r2, r3)     // Catch:{ Exception -> 0x0010 }
            java.lang.String r2 = "his_reason"
            java.lang.String r3 = "show campaign is null"
            r0.a(r2, r3)     // Catch:{ Exception -> 0x0010 }
            com.mbridge.msdk.foundation.same.report.d.c r2 = r4.f11431J     // Catch:{ Exception -> 0x0010 }
            r2.a(r1, r0)     // Catch:{ Exception -> 0x0010 }
        L_0x00b0:
            if (r5 == 0) goto L_0x00b7
            com.mbridge.msdk.foundation.same.report.d.c r0 = r4.f11431J     // Catch:{ Exception -> 0x0010 }
            r0.b((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r5)     // Catch:{ Exception -> 0x0010 }
        L_0x00b7:
            r5 = 1
            r4.f11433L = r5     // Catch:{ Exception -> 0x0010 }
            com.mbridge.msdk.reward.c.a.a r5 = com.mbridge.msdk.reward.c.a.a.a()     // Catch:{ Exception -> 0x0010 }
            com.mbridge.msdk.foundation.same.report.d.c r0 = r4.f11431J     // Catch:{ Exception -> 0x0010 }
            r5.a(r1, r0)     // Catch:{ Exception -> 0x0010 }
            return
        L_0x00c4:
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r0 == 0) goto L_0x00cb
            r5.printStackTrace()
        L_0x00cb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.player.MBRewardVideoActivity.b(java.util.List):void");
    }
}
