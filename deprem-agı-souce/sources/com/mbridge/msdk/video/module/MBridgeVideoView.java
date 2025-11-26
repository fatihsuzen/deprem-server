package com.mbridge.msdk.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeSegmentsProgressBar;
import com.mbridge.msdk.dycreator.baseview.cusview.SoundImageView;
import com.mbridge.msdk.dycreator.baseview.rewardpopview.AcquireRewardPopViewBehaviourListener;
import com.mbridge.msdk.dycreator.baseview.rewardpopview.AcquireRewardPopViewParameters;
import com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.ap;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.foundation.tools.p;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbsignalcommon.commonwebview.CollapsibleWebView;
import com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView;
import com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener;
import com.mbridge.msdk.playercommon.PlayerView;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.mbridge.msdk.video.dynview.e.f;
import com.mbridge.msdk.video.signal.j;
import com.mbridge.msdk.widget.FeedBackButton;
import com.mbridge.msdk.widget.dialog.MBAlertDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class MBridgeVideoView extends MBridgeBaseView implements j {
    /* access modifiers changed from: private */
    public static long aQ = 0;

    /* renamed from: m  reason: collision with root package name */
    private static int f12481m = 0;

    /* renamed from: n  reason: collision with root package name */
    private static int f12482n = 0;

    /* renamed from: o  reason: collision with root package name */
    private static int f12483o = 0;

    /* renamed from: p  reason: collision with root package name */
    private static int f12484p = 0;

    /* renamed from: q  reason: collision with root package name */
    private static int f12485q = 0;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public static boolean f12486r = false;
    /* access modifiers changed from: private */

    /* renamed from: A  reason: collision with root package name */
    public com.mbridge.msdk.video.module.a.a f12487A;
    /* access modifiers changed from: private */

    /* renamed from: B  reason: collision with root package name */
    public a f12488B;
    /* access modifiers changed from: private */

    /* renamed from: C  reason: collision with root package name */
    public boolean f12489C = false;
    /* access modifiers changed from: private */

    /* renamed from: D  reason: collision with root package name */
    public com.mbridge.msdk.video.dynview.e.a f12490D;
    /* access modifiers changed from: private */

    /* renamed from: E  reason: collision with root package name */
    public f f12491E;
    /* access modifiers changed from: private */

    /* renamed from: F  reason: collision with root package name */
    public int f12492F = 0;
    /* access modifiers changed from: private */

    /* renamed from: G  reason: collision with root package name */
    public boolean f12493G;
    /* access modifiers changed from: private */

    /* renamed from: H  reason: collision with root package name */
    public FrameLayout f12494H;

    /* renamed from: I  reason: collision with root package name */
    private MBridgeClickCTAView f12495I;

    /* renamed from: J  reason: collision with root package name */
    private com.mbridge.msdk.video.signal.factory.b f12496J;
    /* access modifiers changed from: private */

    /* renamed from: K  reason: collision with root package name */
    public int f12497K;
    /* access modifiers changed from: private */

    /* renamed from: L  reason: collision with root package name */
    public int f12498L;

    /* renamed from: M  reason: collision with root package name */
    private RelativeLayout f12499M;

    /* renamed from: N  reason: collision with root package name */
    private boolean f12500N = false;
    /* access modifiers changed from: private */

    /* renamed from: O  reason: collision with root package name */
    public boolean f12501O = false;
    /* access modifiers changed from: private */

    /* renamed from: P  reason: collision with root package name */
    public boolean f12502P = false;

    /* renamed from: Q  reason: collision with root package name */
    private String f12503Q;
    /* access modifiers changed from: private */

    /* renamed from: R  reason: collision with root package name */
    public int f12504R;

    /* renamed from: S  reason: collision with root package name */
    private int f12505S;

    /* renamed from: T  reason: collision with root package name */
    private int f12506T;

    /* renamed from: U  reason: collision with root package name */
    private MBAlertDialog f12507U;

    /* renamed from: V  reason: collision with root package name */
    private com.mbridge.msdk.widget.dialog.a f12508V;
    /* access modifiers changed from: private */

    /* renamed from: W  reason: collision with root package name */
    public String f12509W = "";
    /* access modifiers changed from: private */
    public boolean aA = false;
    /* access modifiers changed from: private */
    public boolean aB = false;
    /* access modifiers changed from: private */
    public boolean aC = false;
    /* access modifiers changed from: private */
    public AlphaAnimation aD;
    private MBridgeBaitClickView aE;
    /* access modifiers changed from: private */
    public int aF = 0;
    /* access modifiers changed from: private */
    public int aG = 5;
    private int aH = 5;
    /* access modifiers changed from: private */
    public int aI = 5;
    private AcquireRewardPopViewParameters aJ;
    /* access modifiers changed from: private */
    public MBAcquireRewardPopView aK;
    private boolean aL = false;
    /* access modifiers changed from: private */
    public RelativeLayout aM;
    /* access modifiers changed from: private */
    public CollapsibleWebView aN;
    /* access modifiers changed from: private */
    public RelativeLayout aO;
    /* access modifiers changed from: private */
    public boolean aP = false;
    /* access modifiers changed from: private */
    public int aR = 0;
    /* access modifiers changed from: private */
    public boolean aS = false;
    /* access modifiers changed from: private */
    public boolean aT = false;
    private c aU = new c(this);
    private boolean aV = false;
    private Runnable aW = new Runnable() {
        public final void run() {
            if (MBridgeVideoView.this.f12494H != null) {
                MBridgeVideoView.this.f12494H.setVisibility(8);
            }
        }
    };
    /* access modifiers changed from: private */
    public final Runnable aX = new Runnable() {
        public final void run() {
            if (MBridgeVideoView.this.aG <= 0) {
                MBridgeVideoView.this.showRewardPopView();
                MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                mBridgeVideoView.removeCallbacks(mBridgeVideoView.aX);
                return;
            }
            MBridgeVideoView.aa(MBridgeVideoView.this);
            MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
            mBridgeVideoView2.postDelayed(mBridgeVideoView2.aX, 1000);
        }
    };
    private double aa;
    private double ab;
    private boolean ac = false;
    private boolean ad = false;
    private boolean ae = false;
    private boolean af = false;
    private boolean ag = false;
    private boolean ah = false;
    private boolean ai = false;
    /* access modifiers changed from: private */
    public boolean aj = false;
    private boolean ak = false;
    private int al;
    /* access modifiers changed from: private */
    public boolean am = false;
    private int an = 2;
    private u1.b ao;
    /* access modifiers changed from: private */
    public v1.b ap;
    /* access modifiers changed from: private */
    public String aq;
    /* access modifiers changed from: private */
    public int ar;
    private int as;
    private int at;
    /* access modifiers changed from: private */
    public boolean au = false;
    /* access modifiers changed from: private */
    public boolean av = false;
    /* access modifiers changed from: private */
    public boolean aw = false;
    /* access modifiers changed from: private */
    public boolean ax = true;
    /* access modifiers changed from: private */
    public boolean ay = false;
    private boolean az = false;
    public List<CampaignEx> mCampOrderViewData;
    public int mCampaignSize = 1;
    public int mCurrPlayNum = 1;
    public int mCurrentPlayProgressTime = 0;
    public int mMuteSwitch = 0;
    public PlayerView mPlayerView;
    public SoundImageView mSoundImageView;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public TextView f12510s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public View f12511t;
    public TextView tvFlag;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public RelativeLayout f12512u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public ImageView f12513v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public ProgressBar f12514w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public FeedBackButton f12515x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public ImageView f12516y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public MBridgeSegmentsProgressBar f12517z;

    public interface a {
        void a();
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f12549a;

        /* renamed from: b  reason: collision with root package name */
        public int f12550b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f12551c;

        public final String toString() {
            return "ProgressData{curPlayPosition=" + this.f12549a + ", allDuration=" + this.f12550b + '}';
        }
    }

    private static final class c extends DefaultVideoPlayerStatusListener {

        /* renamed from: a  reason: collision with root package name */
        private MBridgeVideoView f12552a;

        /* renamed from: b  reason: collision with root package name */
        private int f12553b;

        /* renamed from: c  reason: collision with root package name */
        private int f12554c;

        /* renamed from: d  reason: collision with root package name */
        private int f12555d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f12556e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public v1.b f12557f;

        /* renamed from: g  reason: collision with root package name */
        private b f12558g = new b();

        /* renamed from: h  reason: collision with root package name */
        private boolean f12559h = false;

        /* renamed from: i  reason: collision with root package name */
        private boolean f12560i = false;

        /* renamed from: j  reason: collision with root package name */
        private boolean f12561j = false;

        /* renamed from: k  reason: collision with root package name */
        private boolean f12562k;

        /* renamed from: l  reason: collision with root package name */
        private String f12563l;

        /* renamed from: m  reason: collision with root package name */
        private CampaignEx f12564m;

        /* renamed from: n  reason: collision with root package name */
        private int f12565n;

        /* renamed from: o  reason: collision with root package name */
        private int f12566o;

        /* renamed from: p  reason: collision with root package name */
        private boolean f12567p = false;

        public c(MBridgeVideoView mBridgeVideoView) {
            this.f12552a = mBridgeVideoView;
            if (mBridgeVideoView != null) {
                this.f12563l = mBridgeVideoView.getUnitId();
                this.f12564m = mBridgeVideoView.getCampaign();
            }
        }

        private void d() {
            MBridgeVideoView mBridgeVideoView = this.f12552a;
            if (mBridgeVideoView != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mBridgeVideoView.f12510s.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = -2;
                    layoutParams.height = ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 25.0f);
                    this.f12552a.f12510s.setLayoutParams(layoutParams);
                }
                int a5 = ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 5.0f);
                this.f12552a.f12510s.setPadding(a5, 0, a5, 0);
            }
        }

        public final int b() {
            return this.f12555d;
        }

        public final void c() {
            this.f12552a = null;
            boolean unused = MBridgeVideoView.f12486r = false;
        }

        public final void onBufferingEnd() {
            try {
                super.onBufferingEnd();
                v1.b bVar = this.f12557f;
                if (bVar != null) {
                    bVar.b();
                    af.a("omsdk", "play:  videoEvents.bufferFinish()");
                }
                this.f12552a.notifyListener.a(14, "");
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }

        public final void onBufferingStart(String str) {
            try {
                super.onBufferingStart(str);
                if (this.f12557f != null) {
                    af.a("omsdk", "play:  videoEvents.bufferStart()");
                    this.f12557f.c();
                }
                this.f12552a.notifyListener.a(13, "");
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }

        public final void onPlayCompleted() {
            MBridgeVideoView mBridgeVideoView;
            super.onPlayCompleted();
            boolean unused = this.f12552a.ay = true;
            CampaignEx campaignEx = this.f12564m;
            if (campaignEx != null) {
                if (!this.f12562k || campaignEx.getRewardTemplateMode() == null || this.f12564m.getRewardTemplateMode().f() != 5002010) {
                    this.f12552a.f12510s.setText(x.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_video_view_reward_time_complete", TypedValues.Custom.S_STRING));
                } else {
                    this.f12552a.f12510s.setText("0");
                }
                this.f12564m.setVideoPlayProgress(100);
                if (this.f12564m.getAdSpaceT() == 2) {
                    this.f12552a.f12511t.setVisibility(4);
                    if (this.f12552a.f12515x != null) {
                        this.f12552a.f12515x.setClickable(false);
                    }
                    SoundImageView soundImageView = this.f12552a.mSoundImageView;
                    if (soundImageView != null) {
                        soundImageView.setClickable(false);
                    }
                }
            } else {
                this.f12552a.f12510s.setText("0");
            }
            v1.b bVar = this.f12557f;
            if (bVar != null) {
                bVar.d();
                af.a("omsdk", "play:  videoEvents.complete()");
            }
            this.f12552a.mPlayerView.setClickable(false);
            String e5 = this.f12552a.b(true);
            CampaignEx campaignEx2 = this.f12564m;
            if (!(campaignEx2 == null || campaignEx2.getRewardTemplateMode() == null || this.f12564m.getRewardTemplateMode().f() != 5002010)) {
                this.f12552a.j();
            }
            CampaignEx campaignEx3 = this.f12564m;
            if (!(campaignEx3 == null || campaignEx3.getDynamicTempCode() != 5 || (mBridgeVideoView = this.f12552a) == null || mBridgeVideoView.f12490D == null)) {
                MBridgeVideoView mBridgeVideoView2 = this.f12552a;
                if (mBridgeVideoView2.mCampaignSize > mBridgeVideoView2.mCurrPlayNum) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("position", Integer.valueOf(this.f12552a.mCurrPlayNum));
                    int i5 = this.f12552a.mMuteSwitch;
                    if (i5 != 0) {
                        hashMap.put(CampaignEx.JSON_NATIVE_VIDEO_MUTE, Integer.valueOf(i5));
                    }
                    this.f12552a.f12490D.a(hashMap);
                    return;
                }
            }
            MBridgeVideoView mBridgeVideoView3 = this.f12552a;
            if (mBridgeVideoView3 != null) {
                mBridgeVideoView3.notifyListener.a(121, "");
                this.f12552a.notifyListener.a(11, e5);
            }
            int i6 = this.f12554c;
            this.f12553b = i6;
            this.f12552a.mCurrentPlayProgressTime = i6;
            boolean unused2 = MBridgeVideoView.f12486r = true;
        }

        public final void onPlayError(String str) {
            af.b("DefaultVideoPlayerStatusListener", "errorStr" + str);
            super.onPlayError(str);
            MBridgeVideoView mBridgeVideoView = this.f12552a;
            if (mBridgeVideoView != null) {
                mBridgeVideoView.notifyListener.a(12, str);
            }
        }

        /* JADX WARNING: type inference failed for: r5v36, types: [java.lang.CharSequence] */
        /* JADX WARNING: type inference failed for: r0v115, types: [java.lang.CharSequence] */
        /* JADX WARNING: type inference failed for: r0v121, types: [java.lang.CharSequence] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onPlayProgress(int r14, int r15) {
            /*
                r13 = this;
                super.onPlayProgress(r14, r15)
                long r0 = com.mbridge.msdk.video.module.MBridgeVideoView.aQ
                r2 = 0
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 != 0) goto L_0x0014
                long r0 = java.lang.System.currentTimeMillis()
                long unused = com.mbridge.msdk.video.module.MBridgeVideoView.aQ = r0
            L_0x0014:
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r13.f12552a
                boolean r0 = r0.aT
                r1 = 1
                if (r0 != 0) goto L_0x0033
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r13.f12552a
                com.mbridge.msdk.video.dynview.e.f r0 = r0.f12491E
                if (r0 == 0) goto L_0x0033
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r13.f12552a
                boolean unused = r0.aT = r1
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r13.f12552a
                com.mbridge.msdk.video.dynview.e.f r0 = r0.f12491E
                r0.a()
            L_0x0033:
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r13.f12552a
                boolean r0 = r0.f12297e
                java.lang.String r2 = "DefaultVideoPlayerStatusListener"
                java.lang.String r3 = ""
                if (r0 == 0) goto L_0x033a
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r13.f12564m
                r4 = 0
                if (r0 == 0) goto L_0x006b
                int r0 = r0.getVideoCompleteTime()
                if (r0 > 0) goto L_0x0049
                r0 = r15
            L_0x0049:
                com.mbridge.msdk.foundation.d.b r5 = com.mbridge.msdk.foundation.d.b.a()
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                com.mbridge.msdk.foundation.entity.CampaignEx r7 = r13.f12564m
                java.lang.String r7 = r7.getCampaignUnitId()
                r6.append(r7)
                java.lang.String r7 = "_"
                r6.append(r7)
                r6.append(r1)
                java.lang.String r6 = r6.toString()
                r5.b(r6, r14)
                goto L_0x006c
            L_0x006b:
                r0 = r4
            L_0x006c:
                com.mbridge.msdk.foundation.entity.CampaignEx r5 = r13.f12564m
                java.lang.String r6 = "0"
                java.lang.String r7 = "mbridge_reward_video_view_reward_time_left"
                java.lang.String r8 = "mbridge_reward_video_view_reward_time_complete"
                java.lang.String r9 = "mbridge_reward_video_view_reward_time_left_skip_time"
                r10 = 4
                java.lang.String r11 = "string"
                if (r5 == 0) goto L_0x01d8
                boolean r5 = r5.isDynamicView()
                if (r5 == 0) goto L_0x01d8
                com.mbridge.msdk.foundation.entity.CampaignEx r5 = r13.f12564m
                int r5 = r5.getDynamicTempCode()
                r12 = 5
                if (r5 != r12) goto L_0x01d8
                com.mbridge.msdk.video.module.MBridgeVideoView r4 = r13.f12552a     // Catch:{ Exception -> 0x00f7 }
                int r4 = r4.f12492F     // Catch:{ Exception -> 0x00f7 }
                com.mbridge.msdk.video.module.MBridgeVideoView r5 = r13.f12552a     // Catch:{ Exception -> 0x00f7 }
                if (r5 != 0) goto L_0x0096
                goto L_0x033a
            L_0x0096:
                android.content.Context r5 = r5.getContext()     // Catch:{ Exception -> 0x00f7 }
                android.content.res.Resources r5 = r5.getResources()     // Catch:{ Exception -> 0x00f7 }
                com.mbridge.msdk.foundation.controller.c r12 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x00f7 }
                android.content.Context r12 = r12.c()     // Catch:{ Exception -> 0x00f7 }
                int r8 = com.mbridge.msdk.foundation.tools.x.a(r12, r8, r11)     // Catch:{ Exception -> 0x00f7 }
                java.lang.CharSequence r5 = r5.getText(r8)     // Catch:{ Exception -> 0x00f7 }
                java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x00f7 }
                com.mbridge.msdk.video.module.MBridgeVideoView r8 = r13.f12552a     // Catch:{ Exception -> 0x00f7 }
                android.content.Context r8 = r8.getContext()     // Catch:{ Exception -> 0x00f7 }
                android.content.res.Resources r8 = r8.getResources()     // Catch:{ Exception -> 0x00f7 }
                com.mbridge.msdk.foundation.controller.c r12 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x00f7 }
                android.content.Context r12 = r12.c()     // Catch:{ Exception -> 0x00f7 }
                int r7 = com.mbridge.msdk.foundation.tools.x.a(r12, r7, r11)     // Catch:{ Exception -> 0x00f7 }
                java.lang.CharSequence r7 = r8.getText(r7)     // Catch:{ Exception -> 0x00f7 }
                java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x00f7 }
                if (r0 < 0) goto L_0x015d
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r13.f12564m     // Catch:{ Exception -> 0x00f7 }
                int r4 = r4.getUseSkipTime()     // Catch:{ Exception -> 0x00f7 }
                if (r4 != r1) goto L_0x0148
                com.mbridge.msdk.video.module.MBridgeVideoView r4 = r13.f12552a     // Catch:{ Exception -> 0x00f7 }
                int r4 = r4.f12504R     // Catch:{ Exception -> 0x00f7 }
                int r4 = java.lang.Math.min(r4, r0)     // Catch:{ Exception -> 0x00f7 }
                if (r4 >= r0) goto L_0x0118
                if (r4 <= 0) goto L_0x0118
                int r4 = r4 - r14
                if (r4 > 0) goto L_0x00fa
                int r4 = r0 - r14
                boolean r0 = r13.f12562k     // Catch:{ Exception -> 0x00f7 }
                if (r0 == 0) goto L_0x014a
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r13.f12552a     // Catch:{ Exception -> 0x00f7 }
                android.widget.TextView r0 = r0.f12510s     // Catch:{ Exception -> 0x00f7 }
                r0.setVisibility(r10)     // Catch:{ Exception -> 0x00f7 }
                goto L_0x014a
            L_0x00f7:
                r0 = move-exception
                goto L_0x01cf
            L_0x00fa:
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r13.f12552a     // Catch:{ Exception -> 0x00f7 }
                android.content.Context r0 = r0.getContext()     // Catch:{ Exception -> 0x00f7 }
                android.content.res.Resources r0 = r0.getResources()     // Catch:{ Exception -> 0x00f7 }
                com.mbridge.msdk.foundation.controller.c r6 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x00f7 }
                android.content.Context r6 = r6.c()     // Catch:{ Exception -> 0x00f7 }
                int r6 = com.mbridge.msdk.foundation.tools.x.a(r6, r9, r11)     // Catch:{ Exception -> 0x00f7 }
                java.lang.CharSequence r0 = r0.getText(r6)     // Catch:{ Exception -> 0x00f7 }
                r7 = r0
                java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x00f7 }
                goto L_0x014a
            L_0x0118:
                int r4 = r0 - r14
                boolean r0 = r13.f12562k     // Catch:{ Exception -> 0x00f7 }
                if (r0 == 0) goto L_0x014a
                if (r4 > 0) goto L_0x012a
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r13.f12552a     // Catch:{ Exception -> 0x00f7 }
                android.widget.TextView r0 = r0.f12510s     // Catch:{ Exception -> 0x00f7 }
                r0.setVisibility(r10)     // Catch:{ Exception -> 0x00f7 }
                goto L_0x014a
            L_0x012a:
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r13.f12552a     // Catch:{ Exception -> 0x00f7 }
                android.content.Context r0 = r0.getContext()     // Catch:{ Exception -> 0x00f7 }
                android.content.res.Resources r0 = r0.getResources()     // Catch:{ Exception -> 0x00f7 }
                com.mbridge.msdk.foundation.controller.c r6 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x00f7 }
                android.content.Context r6 = r6.c()     // Catch:{ Exception -> 0x00f7 }
                int r6 = com.mbridge.msdk.foundation.tools.x.a(r6, r9, r11)     // Catch:{ Exception -> 0x00f7 }
                java.lang.CharSequence r0 = r0.getText(r6)     // Catch:{ Exception -> 0x00f7 }
                r7 = r0
                java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x00f7 }
                goto L_0x014a
            L_0x0148:
                int r4 = r0 - r14
            L_0x014a:
                if (r4 > 0) goto L_0x014d
                goto L_0x0181
            L_0x014d:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f7 }
                r0.<init>()     // Catch:{ Exception -> 0x00f7 }
                r0.append(r4)     // Catch:{ Exception -> 0x00f7 }
                r0.append(r7)     // Catch:{ Exception -> 0x00f7 }
                java.lang.String r5 = r0.toString()     // Catch:{ Exception -> 0x00f7 }
                goto L_0x0181
            L_0x015d:
                int r4 = r4 - r14
                if (r4 > 0) goto L_0x0163
                if (r0 > 0) goto L_0x0181
                goto L_0x0182
            L_0x0163:
                if (r0 > 0) goto L_0x0175
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f7 }
                r0.<init>()     // Catch:{ Exception -> 0x00f7 }
                r0.append(r4)     // Catch:{ Exception -> 0x00f7 }
                r0.append(r3)     // Catch:{ Exception -> 0x00f7 }
            L_0x0170:
                java.lang.String r5 = r0.toString()     // Catch:{ Exception -> 0x00f7 }
                goto L_0x0181
            L_0x0175:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f7 }
                r0.<init>()     // Catch:{ Exception -> 0x00f7 }
                r0.append(r4)     // Catch:{ Exception -> 0x00f7 }
                r0.append(r7)     // Catch:{ Exception -> 0x00f7 }
                goto L_0x0170
            L_0x0181:
                r6 = r5
            L_0x0182:
                com.mbridge.msdk.video.module.MBridgeVideoView$b r0 = r13.f12558g     // Catch:{ Exception -> 0x00f7 }
                r0.f12549a = r14     // Catch:{ Exception -> 0x00f7 }
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r13.f12552a     // Catch:{ Exception -> 0x00f7 }
                android.widget.TextView r0 = r0.f12510s     // Catch:{ Exception -> 0x00f7 }
                r0.setText(r6)     // Catch:{ Exception -> 0x00f7 }
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r13.f12552a     // Catch:{ Exception -> 0x00f7 }
                android.widget.ProgressBar r0 = r0.f12514w     // Catch:{ Exception -> 0x00f7 }
                if (r0 == 0) goto L_0x01ac
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r13.f12552a     // Catch:{ Exception -> 0x00f7 }
                android.widget.ProgressBar r0 = r0.f12514w     // Catch:{ Exception -> 0x00f7 }
                int r0 = r0.getVisibility()     // Catch:{ Exception -> 0x00f7 }
                if (r0 != 0) goto L_0x01ac
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r13.f12552a     // Catch:{ Exception -> 0x00f7 }
                android.widget.ProgressBar r0 = r0.f12514w     // Catch:{ Exception -> 0x00f7 }
                r0.setProgress(r14)     // Catch:{ Exception -> 0x00f7 }
            L_0x01ac:
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r13.f12552a     // Catch:{ Exception -> 0x00f7 }
                int r0 = r0.aI     // Catch:{ Exception -> 0x00f7 }
                if (r4 >= r0) goto L_0x033a
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r13.f12552a     // Catch:{ Exception -> 0x00f7 }
                com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView r0 = r0.aK     // Catch:{ Exception -> 0x00f7 }
                if (r0 == 0) goto L_0x033a
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r13.f12552a     // Catch:{ Exception -> 0x00f7 }
                boolean r0 = r0.f12502P     // Catch:{ Exception -> 0x00f7 }
                if (r0 == 0) goto L_0x033a
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r13.f12552a     // Catch:{ Exception -> 0x00f7 }
                com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView r0 = r0.aK     // Catch:{ Exception -> 0x00f7 }
                r0.onTimeLessThanReduce(r4)     // Catch:{ Exception -> 0x00f7 }
                goto L_0x033a
            L_0x01cf:
                java.lang.String r0 = r0.getMessage()
                com.mbridge.msdk.foundation.tools.af.b(r2, r0)
                goto L_0x033a
            L_0x01d8:
                com.mbridge.msdk.video.module.MBridgeVideoView r5 = r13.f12552a
                if (r5 != 0) goto L_0x01de
                goto L_0x0336
            L_0x01de:
                boolean r12 = r13.f12562k
                if (r12 == 0) goto L_0x01f4
                int r5 = r15 - r14
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object[] r6 = new java.lang.Object[r1]
                r6[r4] = r5
                java.lang.String r4 = "%s"
                java.lang.String r4 = java.lang.String.format(r4, r6)
                goto L_0x027b
            L_0x01f4:
                if (r0 <= r15) goto L_0x01f7
                r0 = r15
            L_0x01f7:
                if (r0 > 0) goto L_0x01fc
                int r12 = r15 - r14
                goto L_0x01fe
            L_0x01fc:
                int r12 = r0 - r14
            L_0x01fe:
                if (r12 > 0) goto L_0x021f
                if (r0 > 0) goto L_0x0203
                goto L_0x0259
            L_0x0203:
                android.content.Context r5 = r5.getContext()
                android.content.res.Resources r5 = r5.getResources()
                com.mbridge.msdk.foundation.controller.c r6 = com.mbridge.msdk.foundation.controller.c.m()
                android.content.Context r6 = r6.c()
                int r6 = com.mbridge.msdk.foundation.tools.x.a(r6, r8, r11)
                java.lang.CharSequence r5 = r5.getText(r6)
                r6 = r5
                java.lang.String r6 = (java.lang.String) r6
                goto L_0x0259
            L_0x021f:
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                if (r0 > 0) goto L_0x0231
                r4.<init>()
                r4.append(r12)
                r4.append(r3)
            L_0x022c:
                java.lang.String r4 = r4.toString()
                goto L_0x0257
            L_0x0231:
                r4.<init>()
                r4.append(r12)
                com.mbridge.msdk.video.module.MBridgeVideoView r5 = r13.f12552a
                android.content.Context r5 = r5.getContext()
                android.content.res.Resources r5 = r5.getResources()
                com.mbridge.msdk.foundation.controller.c r6 = com.mbridge.msdk.foundation.controller.c.m()
                android.content.Context r6 = r6.c()
                int r6 = com.mbridge.msdk.foundation.tools.x.a(r6, r7, r11)
                java.lang.CharSequence r5 = r5.getText(r6)
                java.lang.String r5 = (java.lang.String) r5
                r4.append(r5)
                goto L_0x022c
            L_0x0257:
                r6 = r4
                r4 = r12
            L_0x0259:
                com.mbridge.msdk.video.module.MBridgeVideoView r5 = r13.f12552a
                int r5 = r5.aI
                if (r4 >= r5) goto L_0x027a
                com.mbridge.msdk.video.module.MBridgeVideoView r5 = r13.f12552a
                com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView r5 = r5.aK
                if (r5 == 0) goto L_0x027a
                com.mbridge.msdk.video.module.MBridgeVideoView r5 = r13.f12552a
                boolean r5 = r5.f12502P
                if (r5 == 0) goto L_0x027a
                com.mbridge.msdk.video.module.MBridgeVideoView r5 = r13.f12552a
                com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView r5 = r5.aK
                r5.onTimeLessThanReduce(r4)
            L_0x027a:
                r4 = r6
            L_0x027b:
                com.mbridge.msdk.foundation.entity.CampaignEx r5 = r13.f12564m
                if (r5 == 0) goto L_0x0310
                int r5 = r5.getUseSkipTime()
                if (r5 != r1) goto L_0x0310
                com.mbridge.msdk.video.module.MBridgeVideoView r5 = r13.f12552a
                int r5 = r5.f12504R
                int r5 = java.lang.Math.min(r5, r15)
                if (r5 >= r0) goto L_0x02d2
                if (r5 < 0) goto L_0x02d2
                int r5 = r5 - r14
                if (r5 <= 0) goto L_0x02c2
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r5)
                com.mbridge.msdk.video.module.MBridgeVideoView r4 = r13.f12552a
                android.content.Context r4 = r4.getContext()
                android.content.res.Resources r4 = r4.getResources()
                com.mbridge.msdk.foundation.controller.c r5 = com.mbridge.msdk.foundation.controller.c.m()
                android.content.Context r5 = r5.c()
                int r5 = com.mbridge.msdk.foundation.tools.x.a(r5, r9, r11)
                java.lang.CharSequence r4 = r4.getText(r5)
                java.lang.String r4 = (java.lang.String) r4
                r0.append(r4)
                java.lang.String r4 = r0.toString()
                goto L_0x0310
            L_0x02c2:
                boolean r0 = r13.f12562k
                if (r0 == 0) goto L_0x0310
                if (r5 != 0) goto L_0x0310
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r13.f12552a
                android.widget.TextView r0 = r0.f12510s
                r0.setVisibility(r10)
                goto L_0x0310
            L_0x02d2:
                int r0 = r0 - r14
                boolean r5 = r13.f12562k
                if (r5 == 0) goto L_0x0310
                if (r0 <= 0) goto L_0x0305
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                r4.append(r0)
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r13.f12552a
                android.content.Context r0 = r0.getContext()
                android.content.res.Resources r0 = r0.getResources()
                com.mbridge.msdk.foundation.controller.c r5 = com.mbridge.msdk.foundation.controller.c.m()
                android.content.Context r5 = r5.c()
                int r5 = com.mbridge.msdk.foundation.tools.x.a(r5, r9, r11)
                java.lang.CharSequence r0 = r0.getText(r5)
                java.lang.String r0 = (java.lang.String) r0
                r4.append(r0)
                java.lang.String r4 = r4.toString()
                goto L_0x0310
            L_0x0305:
                if (r0 != 0) goto L_0x0310
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r13.f12552a
                android.widget.TextView r0 = r0.f12510s
                r0.setVisibility(r10)
            L_0x0310:
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r13.f12552a
                android.widget.TextView r0 = r0.f12510s
                r0.setText(r4)
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r13.f12552a
                android.widget.ProgressBar r0 = r0.f12514w
                if (r0 == 0) goto L_0x0336
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r13.f12552a
                android.widget.ProgressBar r0 = r0.f12514w
                int r0 = r0.getVisibility()
                if (r0 != 0) goto L_0x0336
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r13.f12552a
                android.widget.ProgressBar r0 = r0.f12514w
                r0.setProgress(r14)
            L_0x0336:
                com.mbridge.msdk.video.module.MBridgeVideoView$b r0 = r13.f12558g
                r0.f12549a = r14
            L_0x033a:
                r13.f12554c = r15
                com.mbridge.msdk.video.module.MBridgeVideoView$b r0 = r13.f12558g
                r0.f12550b = r15
                com.mbridge.msdk.video.module.MBridgeVideoView r4 = r13.f12552a
                boolean r4 = r4.aA
                r0.f12551c = r4
                r13.f12553b = r14
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r13.f12552a
                android.widget.ImageView r0 = r0.f12516y
                if (r0 == 0) goto L_0x036c
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r13.f12552a
                android.widget.ImageView r0 = r0.f12516y
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                r4.append(r3)
                int r3 = r13.f12553b
                r4.append(r3)
                java.lang.String r3 = r4.toString()
                r0.setTag(r3)
            L_0x036c:
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r13.f12552a
                r0.mCurrentPlayProgressTime = r14
                com.mbridge.msdk.video.module.a.a r0 = r0.notifyListener
                r3 = 15
                com.mbridge.msdk.video.module.MBridgeVideoView$b r4 = r13.f12558g
                r0.a(r3, r4)
                v1.b r0 = r13.f12557f
                r3 = 100
                if (r0 == 0) goto L_0x03c6
                int r4 = r14 * 100
                int r4 = r4 / r15
                int r5 = r14 + 1
                int r5 = r5 * r3
                int r5 = r5 / r15
                r6 = 25
                java.lang.String r7 = "omsdk"
                if (r4 > r6) goto L_0x039d
                if (r6 >= r5) goto L_0x039d
                boolean r6 = r13.f12559h
                if (r6 != 0) goto L_0x039d
                r13.f12559h = r1
                r0.h()
                java.lang.String r0 = "play:  videoEvents.firstQuartile()"
                com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r7, (java.lang.String) r0)
                goto L_0x03c6
            L_0x039d:
                r6 = 50
                if (r4 > r6) goto L_0x03b2
                if (r6 >= r5) goto L_0x03b2
                boolean r6 = r13.f12560i
                if (r6 != 0) goto L_0x03b2
                r13.f12560i = r1
                r0.i()
                java.lang.String r0 = "play:  videoEvents.midpoint()"
                com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r7, (java.lang.String) r0)
                goto L_0x03c6
            L_0x03b2:
                r6 = 75
                if (r4 > r6) goto L_0x03c6
                if (r6 >= r5) goto L_0x03c6
                boolean r4 = r13.f12561j
                if (r4 != 0) goto L_0x03c6
                r13.f12561j = r1
                r0.n()
                java.lang.String r0 = "play:  videoEvents.thirdQuartile()"
                com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r7, (java.lang.String) r0)
            L_0x03c6:
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r13.f12552a
                boolean r0 = r0.am
                if (r0 == 0) goto L_0x03e5
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r13.f12552a
                boolean r0 = r0.au
                if (r0 != 0) goto L_0x03e5
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r13.f12552a
                int r0 = r0.ar
                int r4 = com.mbridge.msdk.foundation.same.a.f9166I
                if (r0 != r4) goto L_0x03e5
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r13.f12552a
                r0.e()
            L_0x03e5:
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r13.f12552a     // Catch:{ all -> 0x0406 }
                if (r0 == 0) goto L_0x0408
                com.mbridge.msdk.dycreator.baseview.cusview.MBridgeSegmentsProgressBar r0 = r0.f12517z     // Catch:{ all -> 0x0406 }
                if (r0 == 0) goto L_0x0408
                int r0 = r14 * 100
                int r0 = r0 / r15
                com.mbridge.msdk.video.module.MBridgeVideoView r4 = r13.f12552a     // Catch:{ all -> 0x0406 }
                com.mbridge.msdk.dycreator.baseview.cusview.MBridgeSegmentsProgressBar r4 = r4.f12517z     // Catch:{ all -> 0x0406 }
                com.mbridge.msdk.video.module.MBridgeVideoView r5 = r13.f12552a     // Catch:{ all -> 0x0406 }
                int r5 = r5.mCurrPlayNum     // Catch:{ all -> 0x0406 }
                int r5 = r5 - r1
                r4.setProgress(r0, r5)     // Catch:{ all -> 0x0406 }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r13.f12564m     // Catch:{ all -> 0x0406 }
                r4.setVideoPlayProgress(r0)     // Catch:{ all -> 0x0406 }
                goto L_0x0408
            L_0x0406:
                r0 = move-exception
                goto L_0x0437
            L_0x0408:
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r13.f12552a     // Catch:{ all -> 0x0406 }
                if (r0 == 0) goto L_0x043e
                int r0 = r0.f12498L     // Catch:{ all -> 0x0406 }
                r4 = -5
                if (r0 == r4) goto L_0x041a
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r13.f12552a     // Catch:{ all -> 0x0406 }
                int r0 = r0.f12498L     // Catch:{ all -> 0x0406 }
                goto L_0x0420
            L_0x041a:
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r13.f12552a     // Catch:{ all -> 0x0406 }
                int r0 = r0.f12497K     // Catch:{ all -> 0x0406 }
            L_0x0420:
                r4 = -1
                if (r0 == r4) goto L_0x043e
                if (r14 != r0) goto L_0x043e
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r13.f12552a     // Catch:{ all -> 0x0406 }
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r0.f12294b     // Catch:{ all -> 0x0406 }
                if (r0 == 0) goto L_0x043e
                boolean r0 = r0.isDynamicView()     // Catch:{ all -> 0x0406 }
                if (r0 == 0) goto L_0x043e
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r13.f12552a     // Catch:{ all -> 0x0406 }
                r0.setCTALayoutVisibleOrGone()     // Catch:{ all -> 0x0406 }
                goto L_0x043e
            L_0x0437:
                java.lang.String r0 = r0.getMessage()
                com.mbridge.msdk.foundation.tools.af.b(r2, r0)
            L_0x043e:
                int r0 = r13.f12565n
                if (r0 == r3) goto L_0x04e2
                boolean r4 = r13.f12567p
                if (r4 != 0) goto L_0x04e2
                if (r0 != 0) goto L_0x044a
                goto L_0x04e2
            L_0x044a:
                int r4 = r13.f12566o
                if (r4 <= r0) goto L_0x0452
                int r0 = r0 / 2
                r13.f12566o = r0
            L_0x0452:
                int r0 = r13.f12566o
                if (r0 < 0) goto L_0x04e2
                int r15 = r15 * r0
                int r15 = r15 / r3
                if (r14 < r15) goto L_0x04e2
                com.mbridge.msdk.foundation.entity.CampaignEx r14 = r13.f12564m
                int r14 = r14.getAdType()
                r0 = 94
                if (r14 == r0) goto L_0x0494
                com.mbridge.msdk.foundation.entity.CampaignEx r14 = r13.f12564m
                int r14 = r14.getAdType()
                r0 = 287(0x11f, float:4.02E-43)
                if (r14 != r0) goto L_0x046f
                goto L_0x0494
            L_0x046f:
                java.lang.StringBuilder r14 = new java.lang.StringBuilder
                r14.<init>()
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r13.f12564m
                java.lang.String r0 = r0.getId()
                r14.append(r0)
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r13.f12564m
                java.lang.String r0 = r0.getVideoUrlEncode()
                r14.append(r0)
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r13.f12564m
                java.lang.String r0 = r0.getBidToken()
                r14.append(r0)
                java.lang.String r14 = r14.toString()
                goto L_0x04b8
            L_0x0494:
                java.lang.StringBuilder r14 = new java.lang.StringBuilder
                r14.<init>()
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r13.f12564m
                java.lang.String r0 = r0.getRequestId()
                r14.append(r0)
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r13.f12564m
                java.lang.String r0 = r0.getId()
                r14.append(r0)
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r13.f12564m
                java.lang.String r0 = r0.getVideoUrlEncode()
                r14.append(r0)
                java.lang.String r14 = r14.toString()
            L_0x04b8:
                com.mbridge.msdk.videocommon.download.b r0 = com.mbridge.msdk.videocommon.download.b.getInstance()
                java.lang.String r3 = r13.f12563l
                com.mbridge.msdk.videocommon.download.a r14 = r0.a((java.lang.String) r3, (java.lang.String) r14)
                if (r14 == 0) goto L_0x04e2
                r14.p()
                r13.f12567p = r1
                java.lang.StringBuilder r14 = new java.lang.StringBuilder
                r14.<init>()
                java.lang.String r0 = "CDRate is : "
                r14.append(r0)
                r14.append(r15)
                java.lang.String r15 = " and start download !"
                r14.append(r15)
                java.lang.String r14 = r14.toString()
                com.mbridge.msdk.foundation.tools.af.b(r2, r14)
            L_0x04e2:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeVideoView.c.onPlayProgress(int, int):void");
        }

        public final void onPlaySetDataSourceError(String str) {
            super.onPlaySetDataSourceError(str);
        }

        public final void onPlayStarted(int i5) {
            float f5;
            PlayerView playerView;
            CampaignEx campaignEx;
            super.onPlayStarted(i5);
            MBridgeVideoView mBridgeVideoView = this.f12552a;
            if (mBridgeVideoView != null) {
                MBridgeVideoView.C(mBridgeVideoView);
            }
            if (!this.f12556e) {
                MBridgeVideoView mBridgeVideoView2 = this.f12552a;
                if (mBridgeVideoView2 != null) {
                    boolean unused = mBridgeVideoView2.f12493G = true;
                    this.f12552a.notifyListener.a(10, this.f12558g);
                }
                this.f12556e = true;
            }
            this.f12555d = i5;
            CampaignEx campaignEx2 = this.f12564m;
            if (campaignEx2 != null) {
                int videoCompleteTime = campaignEx2.getVideoCompleteTime();
                if (videoCompleteTime <= 0) {
                    videoCompleteTime = i5;
                }
                String str = "mbridge_reward_shape_progress";
                if (this.f12564m.isDynamicView()) {
                    MBridgeVideoView mBridgeVideoView3 = this.f12552a;
                    if (!(mBridgeVideoView3 == null || mBridgeVideoView3.f12510s == null)) {
                        if (this.f12564m.getDynamicTempCode() == 5) {
                            MBridgeVideoView mBridgeVideoView4 = this.f12552a;
                            if (mBridgeVideoView4.mCurrPlayNum > 1 && videoCompleteTime <= 0) {
                                mBridgeVideoView4.f12510s.setBackgroundResource(x.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_video_time_count_num_bg", "drawable"));
                                d();
                            }
                        }
                        if (videoCompleteTime > 0) {
                            if (!this.f12562k || this.f12564m.getDynamicTempCode() == 5) {
                                d();
                            }
                            str = "mbridge_reward_video_time_count_num_bg";
                        }
                        CampaignEx campaignEx3 = this.f12564m;
                        if (campaignEx3 != null && campaignEx3.getUseSkipTime() == 1 && this.f12562k) {
                            d();
                        }
                        this.f12552a.f12510s.setBackgroundResource(x.a(com.mbridge.msdk.foundation.controller.c.m().c(), str, "drawable"));
                    }
                } else if (videoCompleteTime > 0) {
                    this.f12552a.f12510s.setBackgroundResource(x.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_video_time_count_num_bg", "drawable"));
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 30.0f));
                    int a5 = ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 5.0f);
                    layoutParams.addRule(1, x.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_native_endcard_feed_btn", "id"));
                    layoutParams.setMargins(a5, 0, 0, 0);
                    this.f12552a.f12510s.setPadding(a5, 0, a5, 0);
                    this.f12552a.f12510s.setLayoutParams(layoutParams);
                } else {
                    this.f12552a.f12510s.setBackgroundResource(x.a(com.mbridge.msdk.foundation.controller.c.m().c(), str, "drawable"));
                }
            }
            MBridgeVideoView mBridgeVideoView5 = this.f12552a;
            if (!(mBridgeVideoView5 == null || mBridgeVideoView5.f12514w == null)) {
                this.f12552a.f12514w.setMax(i5);
            }
            MBridgeVideoView mBridgeVideoView6 = this.f12552a;
            if (!(mBridgeVideoView6 == null || mBridgeVideoView6.f12512u == null || (campaignEx = this.f12564m) == null || campaignEx.getAdSpaceT() != 2)) {
                this.f12552a.f12512u.setVisibility(0);
            }
            MBridgeVideoView mBridgeVideoView7 = this.f12552a;
            if (!(mBridgeVideoView7 == null || mBridgeVideoView7.f12510s == null || this.f12552a.f12510s.getVisibility() != 0)) {
                this.f12552a.n();
            }
            boolean unused2 = MBridgeVideoView.f12486r = false;
            if (this.f12552a != null && this.f12564m.isDynamicView()) {
                if (this.f12552a.f12498L != -5) {
                    if (this.f12552a.f12498L == 0) {
                        this.f12552a.setCTALayoutVisibleOrGone();
                    }
                } else if (this.f12552a.f12497K == 0) {
                    this.f12552a.setCTALayoutVisibleOrGone();
                }
            }
            MBridgeVideoView mBridgeVideoView8 = this.f12552a;
            if (mBridgeVideoView8 != null) {
                mBridgeVideoView8.showMoreOfferInPlayTemplate();
                this.f12552a.showBaitClickView();
                MBridgeVideoView.I(this.f12552a);
            }
            if (this.f12557f != null) {
                try {
                    MBridgeVideoView mBridgeVideoView9 = this.f12552a;
                    if (mBridgeVideoView9 == null || (playerView = mBridgeVideoView9.mPlayerView) == null) {
                        f5 = 0.0f;
                    } else {
                        f5 = playerView.getVolume();
                    }
                    this.f12557f.m((float) i5, f5);
                    af.a("omsdk", "play video view:  videoEvents.start");
                } catch (Exception e5) {
                    af.b("omsdk", e5.getMessage());
                }
            }
        }

        public final void a(CampaignEx campaignEx) {
            this.f12564m = campaignEx;
        }

        public final void a(boolean z4) {
            this.f12562k = z4;
        }

        public final void a(String str) {
            this.f12563l = str;
        }

        public final int a() {
            return this.f12553b;
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x0095 A[Catch:{ Exception -> 0x0063 }] */
        /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(int r3, int r4) {
            /*
                r2 = this;
                java.lang.String r0 = "DefaultVideoPlayerStatusListener"
                r2.f12565n = r3
                r2.f12566o = r4
                com.mbridge.msdk.foundation.tools.ah r3 = com.mbridge.msdk.foundation.tools.ah.a()
                java.lang.String r4 = "h_c_r_w_p_c"
                r1 = 0
                boolean r3 = r3.a((java.lang.String) r4, (boolean) r1)
                if (r3 != 0) goto L_0x0015
                goto L_0x00b0
            L_0x0015:
                int r3 = r2.f12565n
                r4 = 100
                if (r3 == r4) goto L_0x00b0
                int r4 = r2.f12566o
                if (r4 != 0) goto L_0x00b0
                boolean r4 = r2.f12567p
                if (r4 != 0) goto L_0x00b0
                if (r3 == 0) goto L_0x00b0
                com.mbridge.msdk.foundation.entity.CampaignEx r3 = r2.f12564m
                if (r3 != 0) goto L_0x002b
                goto L_0x00b0
            L_0x002b:
                int r3 = r3.getAdType()     // Catch:{ Exception -> 0x0063 }
                r4 = 94
                if (r3 == r4) goto L_0x0065
                com.mbridge.msdk.foundation.entity.CampaignEx r3 = r2.f12564m     // Catch:{ Exception -> 0x0063 }
                int r3 = r3.getAdType()     // Catch:{ Exception -> 0x0063 }
                r4 = 287(0x11f, float:4.02E-43)
                if (r3 != r4) goto L_0x003e
                goto L_0x0065
            L_0x003e:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0063 }
                r3.<init>()     // Catch:{ Exception -> 0x0063 }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r2.f12564m     // Catch:{ Exception -> 0x0063 }
                java.lang.String r4 = r4.getId()     // Catch:{ Exception -> 0x0063 }
                r3.append(r4)     // Catch:{ Exception -> 0x0063 }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r2.f12564m     // Catch:{ Exception -> 0x0063 }
                java.lang.String r4 = r4.getVideoUrlEncode()     // Catch:{ Exception -> 0x0063 }
                r3.append(r4)     // Catch:{ Exception -> 0x0063 }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r2.f12564m     // Catch:{ Exception -> 0x0063 }
                java.lang.String r4 = r4.getBidToken()     // Catch:{ Exception -> 0x0063 }
                r3.append(r4)     // Catch:{ Exception -> 0x0063 }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0063 }
                goto L_0x0089
            L_0x0063:
                r3 = move-exception
                goto L_0x00a5
            L_0x0065:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0063 }
                r3.<init>()     // Catch:{ Exception -> 0x0063 }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r2.f12564m     // Catch:{ Exception -> 0x0063 }
                java.lang.String r4 = r4.getRequestId()     // Catch:{ Exception -> 0x0063 }
                r3.append(r4)     // Catch:{ Exception -> 0x0063 }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r2.f12564m     // Catch:{ Exception -> 0x0063 }
                java.lang.String r4 = r4.getId()     // Catch:{ Exception -> 0x0063 }
                r3.append(r4)     // Catch:{ Exception -> 0x0063 }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r2.f12564m     // Catch:{ Exception -> 0x0063 }
                java.lang.String r4 = r4.getVideoUrlEncode()     // Catch:{ Exception -> 0x0063 }
                r3.append(r4)     // Catch:{ Exception -> 0x0063 }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0063 }
            L_0x0089:
                com.mbridge.msdk.videocommon.download.b r4 = com.mbridge.msdk.videocommon.download.b.getInstance()     // Catch:{ Exception -> 0x0063 }
                java.lang.String r1 = r2.f12563l     // Catch:{ Exception -> 0x0063 }
                com.mbridge.msdk.videocommon.download.a r3 = r4.a((java.lang.String) r1, (java.lang.String) r3)     // Catch:{ Exception -> 0x0063 }
                if (r3 == 0) goto L_0x00b0
                r3.p()     // Catch:{ Exception -> 0x0063 }
                r3 = 1
                r2.f12567p = r3     // Catch:{ Exception -> 0x0063 }
                boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x0063 }
                if (r3 == 0) goto L_0x00b0
                java.lang.String r3 = "CDRate is : 0  and start download when player create!"
                com.mbridge.msdk.foundation.tools.af.b(r0, r3)     // Catch:{ Exception -> 0x0063 }
                return
            L_0x00a5:
                boolean r4 = com.mbridge.msdk.MBridgeConstans.DEBUG
                if (r4 == 0) goto L_0x00b0
                java.lang.String r3 = r3.getMessage()
                com.mbridge.msdk.foundation.tools.af.b(r0, r3)
            L_0x00b0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeVideoView.c.a(int, int):void");
        }
    }

    public MBridgeVideoView(Context context) {
        super(context);
    }

    static /* synthetic */ void C(MBridgeVideoView mBridgeVideoView) {
        CollapsibleWebView collapsibleWebView = mBridgeVideoView.aN;
        if (collapsibleWebView != null && mBridgeVideoView.f12294b != null && TextUtils.isEmpty(collapsibleWebView.getUrl())) {
            mBridgeVideoView.aN.loadUrl(mBridgeVideoView.f12294b.getClickURL());
            mBridgeVideoView.aN.setToolBarTitle(mBridgeVideoView.f12294b.getAppName());
            g b5 = h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
            if (b5 == null) {
                h.a();
                b5 = i.a();
            }
            mBridgeVideoView.aN.setPageLoadTimtout((int) b5.ar());
            mBridgeVideoView.aN.setPageLoadListener(new CollapsibleWebView.a() {
                public final void a(View view, String str) {
                    JSONObject jSONObject;
                    if (!MBridgeVideoView.this.aP) {
                        boolean unused = MBridgeVideoView.this.aP = true;
                        if (!(MBridgeVideoView.this.aM == null || MBridgeVideoView.this.aM.getVisibility() == 0)) {
                            MBridgeVideoView.this.aM.setVisibility(0);
                        }
                        Context context = MBridgeVideoView.this.getContext();
                        MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                        com.mbridge.msdk.click.a.a(context, mBridgeVideoView.f12294b, mBridgeVideoView.getUnitId(), MBridgeVideoView.this.f12294b.getNoticeUrl(), true, false, com.mbridge.msdk.click.a.a.f8071i);
                        com.mbridge.msdk.video.module.b.b.d(com.mbridge.msdk.foundation.controller.c.m().c().getApplicationContext(), MBridgeVideoView.this.f12294b);
                        e eVar = new e();
                        eVar.a("result", 1);
                        if (MBridgeVideoView.this.f12487A != null) {
                            JSONObject jSONObject2 = null;
                            try {
                                jSONObject = new JSONObject();
                                try {
                                    jSONObject.put(com.mbridge.msdk.foundation.same.a.f9191j, MBridgeVideoView.this.a(0));
                                } catch (JSONException e5) {
                                    e = e5;
                                    jSONObject2 = jSONObject;
                                }
                            } catch (JSONException e6) {
                                e = e6;
                                e.printStackTrace();
                                jSONObject = jSONObject2;
                                MBridgeVideoView.this.f12487A.a(131, jSONObject);
                                MBridgeVideoView.this.f12294b.setClickType(1);
                                MBridgeVideoView.this.f12294b.setClickTempSource(1);
                                MBridgeVideoView.this.f12294b.setTriggerClickSource(2);
                                d.a().a("2000149", MBridgeVideoView.this.f12294b);
                                eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 9);
                                ArrayList arrayList = new ArrayList();
                                arrayList.add("web_view");
                                eVar.a("click_path", arrayList.toString());
                                d.a().a("2000150", MBridgeVideoView.this.f12294b, eVar);
                                eVar.a("url", str);
                                d.a().a("m_webview_render", MBridgeVideoView.this.f12294b, eVar);
                            }
                            MBridgeVideoView.this.f12487A.a(131, jSONObject);
                            MBridgeVideoView.this.f12294b.setClickType(1);
                            MBridgeVideoView.this.f12294b.setClickTempSource(1);
                            MBridgeVideoView.this.f12294b.setTriggerClickSource(2);
                            d.a().a("2000149", MBridgeVideoView.this.f12294b);
                            eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 9);
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add("web_view");
                            eVar.a("click_path", arrayList2.toString());
                            d.a().a("2000150", MBridgeVideoView.this.f12294b, eVar);
                        }
                        eVar.a("url", str);
                        d.a().a("m_webview_render", MBridgeVideoView.this.f12294b, eVar);
                    }
                }

                public final void b(View view, Map<String, String> map) {
                }

                public final void b(View view, String str) {
                    a(str, "timeout");
                }

                public final void a(View view, Map<String, String> map) {
                    String str;
                    String str2 = "";
                    if (map != null) {
                        String str3 = map.get("url");
                        if (str3 != null) {
                            str2 = str3;
                        }
                        str = map.get("description");
                    } else {
                        str = str2;
                    }
                    a(str2, str);
                }

                private void a(String str, String str2) {
                    if (!MBridgeVideoView.this.aP) {
                        boolean unused = MBridgeVideoView.this.aP = true;
                        if (str == null) {
                            str = "";
                        }
                        if (MBridgeVideoView.this.aM != null && MBridgeVideoView.this.aM.getVisibility() == 0) {
                            MBridgeVideoView.this.aM.setVisibility(8);
                        }
                        e eVar = new e();
                        eVar.a("result", 2);
                        eVar.a("url", str);
                        eVar.a("reason", str2);
                        d.a().a("m_webview_render", MBridgeVideoView.this.f12294b, eVar);
                    }
                }
            });
            mBridgeVideoView.aN.setWebViewClient(new WebViewClient() {
                public final void onPageFinished(WebView webView, String str) {
                }

                public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                }
            });
            mBridgeVideoView.aN.setCollapseListener(new CommonWebView.a() {
                public final void a() {
                    if (MBridgeVideoView.this.aO != null) {
                        MBridgeVideoView.this.aO.setVisibility(0);
                        e eVar = new e();
                        eVar.a(NotificationCompat.CATEGORY_STATUS, 1);
                        d.a().a("m_webview_zoom", MBridgeVideoView.this.f12294b, eVar);
                    }
                    if (MBridgeVideoView.this.aN != null) {
                        MBridgeVideoView.this.aN.setCustomizedToolBarMarginWidthPixel(0, 0, 0, 0);
                    }
                    MBridgeVideoView.this.h();
                }
            });
            mBridgeVideoView.aN.setExpandListener(new CommonWebView.a() {
                public final void a() {
                    if (MBridgeVideoView.this.aO != null) {
                        MBridgeVideoView.this.aO.setVisibility(8);
                        e eVar = new e();
                        eVar.a(NotificationCompat.CATEGORY_STATUS, 2);
                        d.a().a("m_webview_zoom", MBridgeVideoView.this.f12294b, eVar);
                    }
                    if (MBridgeVideoView.this.aN != null) {
                        MBridgeVideoView.this.aN.setCustomizedToolBarMarginWidthPixel(0, MBridgeVideoView.this.aR, 0, 0);
                    }
                    MBridgeVideoView.this.g();
                }
            });
            mBridgeVideoView.aN.setExitsClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (MBridgeVideoView.this.aO != null) {
                        MBridgeVideoView.this.aO.setVisibility(0);
                    }
                    if (MBridgeVideoView.this.aM != null) {
                        MBridgeVideoView.this.aM.setVisibility(8);
                    }
                    if (!MBridgeVideoView.this.ay) {
                        MBridgeVideoView.this.h();
                    }
                }
            });
        }
    }

    static /* synthetic */ void I(MBridgeVideoView mBridgeVideoView) {
        String str;
        CampaignEx campaignEx = mBridgeVideoView.f12294b;
        if (campaignEx != null && campaignEx.isDynamicView() && !mBridgeVideoView.f12500N) {
            if (!TextUtils.isEmpty(mBridgeVideoView.f12294b.getMof_template_url())) {
                str = mBridgeVideoView.f12294b.getMof_template_url();
            } else if (mBridgeVideoView.f12294b.getRewardTemplateMode() != null) {
                str = mBridgeVideoView.f12294b.getRewardTemplateMode().e();
            } else {
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    String a5 = aq.a(str, "guideShow");
                    String a6 = aq.a(str, "guideDelay");
                    String a7 = aq.a(str, "guideTime");
                    String a8 = aq.a(str, "guideRewardTime");
                    if (!TextUtils.isEmpty(a5)) {
                        mBridgeVideoView.aF = Integer.parseInt(a5);
                    }
                    if (!TextUtils.isEmpty(a6)) {
                        int parseInt = Integer.parseInt(a6);
                        mBridgeVideoView.aG = parseInt;
                        if (parseInt > 10 || parseInt < 3) {
                            mBridgeVideoView.aG = 5;
                        }
                    }
                    if (!TextUtils.isEmpty(a7)) {
                        int parseInt2 = Integer.parseInt(a7);
                        mBridgeVideoView.aH = parseInt2;
                        if (parseInt2 > 10 || parseInt2 < 3) {
                            mBridgeVideoView.aH = 5;
                        }
                    }
                    if (!TextUtils.isEmpty(a8)) {
                        int parseInt3 = Integer.parseInt(a8);
                        mBridgeVideoView.aI = parseInt3;
                        if (parseInt3 > 10 || parseInt3 < 5) {
                            mBridgeVideoView.aI = 5;
                        }
                    }
                    int i5 = mBridgeVideoView.aF;
                    if (i5 <= 0) {
                        return;
                    }
                    if (i5 <= 2) {
                        int o5 = mBridgeVideoView.o();
                        if (o5 == 0 || o5 > mBridgeVideoView.aG) {
                            int i6 = o5 - mBridgeVideoView.aG;
                            if (i6 >= 0 && mBridgeVideoView.aI > i6) {
                                mBridgeVideoView.aI = i6;
                            }
                            int p5 = mBridgeVideoView.p();
                            if (mBridgeVideoView.aI >= p5) {
                                mBridgeVideoView.aI = p5 - mBridgeVideoView.aG;
                            }
                            if (mBridgeVideoView.aG < p5) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(mBridgeVideoView.f12294b.getAppName());
                                String str2 = "US";
                                g a9 = h.a().a(com.mbridge.msdk.foundation.controller.c.m().k());
                                if (a9 != null) {
                                    str2 = a9.r();
                                }
                                mBridgeVideoView.aJ = new AcquireRewardPopViewParameters.Builder("", mBridgeVideoView.f12509W, mBridgeVideoView.aF, str2).setAutoDismissTime(mBridgeVideoView.aH).setReduceTime(mBridgeVideoView.aI).setBehaviourListener(new AcquireRewardPopViewBehaviourListener() {
                                    public final void onOutOfContentClicked(float f5, float f6) {
                                        if (MBridgeVideoView.this.f12487A != null) {
                                            MBridgeVideoView.this.f12487A.a(105, "");
                                        }
                                    }

                                    public final void onReceivedFail(String str) {
                                        boolean unused = MBridgeVideoView.this.f12502P = false;
                                        if (com.mbridge.msdk.e.b.b()) {
                                            MBridgeVideoView.this.setCover(false);
                                        }
                                        MBridgeVideoView.this.h();
                                        MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                                        com.mbridge.msdk.foundation.same.report.i.a(mBridgeVideoView.f12294b, mBridgeVideoView.f12509W, MBridgeVideoView.this.aF, 2, str);
                                    }

                                    public final void onReceivedSuccess(int i5) {
                                        boolean unused = MBridgeVideoView.this.f12502P = false;
                                        if (com.mbridge.msdk.e.b.b()) {
                                            MBridgeVideoView.this.setCover(false);
                                        }
                                        int A4 = MBridgeVideoView.this.o() - i5;
                                        MBridgeVideoView.this.f12294b.setVideoCompleteTime(A4);
                                        MBridgeVideoView.this.h();
                                        com.mbridge.msdk.video.module.a.a aVar = MBridgeVideoView.this.notifyListener;
                                        if (aVar != null) {
                                            aVar.a(TsExtractor.TS_STREAM_TYPE_HDMV_DTS, Integer.valueOf(A4));
                                        }
                                        MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                                        com.mbridge.msdk.foundation.same.report.i.a(mBridgeVideoView.f12294b, mBridgeVideoView.f12509W, MBridgeVideoView.this.aF, 1, "");
                                    }
                                }).setRightAnswerList(arrayList).build();
                                mBridgeVideoView.postDelayed(mBridgeVideoView.aX, 1000);
                            }
                        }
                    }
                } catch (Throwable th) {
                    af.b(MBridgeBaseView.TAG, th.getMessage());
                }
            }
        }
    }

    static /* synthetic */ int aa(MBridgeVideoView mBridgeVideoView) {
        int i5 = mBridgeVideoView.aG;
        mBridgeVideoView.aG = i5 - 1;
        return i5;
    }

    public void addCTAView() {
        if (this.f12494H != null) {
            if (this.f12495I == null) {
                MBridgeClickCTAView mBridgeClickCTAView = new MBridgeClickCTAView(getContext());
                this.f12495I = mBridgeClickCTAView;
                mBridgeClickCTAView.setCampaign(this.f12294b);
                this.f12495I.setUnitId(this.f12509W);
                com.mbridge.msdk.video.module.a.a aVar = this.f12487A;
                if (aVar != null) {
                    this.f12495I.setNotifyListener(new com.mbridge.msdk.video.module.a.a.i(aVar));
                }
                this.f12495I.preLoadData(this.f12496J);
            }
            this.f12494H.addView(this.f12495I);
        }
    }

    public void alertWebViewShowed() {
        this.f12501O = true;
        setShowingAlertViewCover(true);
    }

    public void closeVideoOperate(int i5, int i6) {
        if (i5 == 1) {
            this.aB = true;
            if (getVisibility() == 0) {
                e();
            }
            try {
                e eVar = new e();
                eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1);
                d.a().a("2000152", eVar);
                d.a().a("2000148", this.f12294b, eVar);
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    th.printStackTrace();
                }
            }
        }
        if (i6 == 1) {
            gonePlayingCloseView();
        } else if (i6 != 2) {
        } else {
            if (!this.aA || getVisibility() != 0) {
                j();
            }
        }
    }

    public void defaultShow() {
        super.defaultShow();
        this.ac = true;
        showVideoLocation(0, 0, ak.f(this.f12293a), ak.e(this.f12293a), 0, 0, 0, 0, 0);
        videoOperate(1);
        if (this.f12504R == 0) {
            closeVideoOperate(-1, 2);
        }
    }

    public void dismissAllAlert() {
        MBAlertDialog mBAlertDialog = this.f12507U;
        if (mBAlertDialog != null) {
            mBAlertDialog.dismiss();
        }
        com.mbridge.msdk.video.module.a.a aVar = this.notifyListener;
        if (aVar != null) {
            aVar.a(R.styleable.AppCompatTheme_windowMinWidthMinor, "");
        }
    }

    public int getBorderViewHeight() {
        return f12485q;
    }

    public int getBorderViewLeft() {
        return f12483o;
    }

    public int getBorderViewRadius() {
        return f12481m;
    }

    public int getBorderViewTop() {
        return f12482n;
    }

    public int getBorderViewWidth() {
        return f12484p;
    }

    public int getCloseAlert() {
        return this.f12506T;
    }

    public String getCurrentProgress() {
        int i5;
        try {
            int a5 = this.aU.a();
            CampaignEx campaignEx = this.f12294b;
            if (campaignEx != null) {
                i5 = campaignEx.getVideoLength();
            } else {
                i5 = 0;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("progress", a(a5, i5));
            jSONObject.put("time", a5);
            jSONObject.put(TypedValues.TransitionType.S_DURATION, i5 + "");
            return jSONObject.toString();
        } catch (Throwable th) {
            af.b(MBridgeBaseView.TAG, th.getMessage(), th);
            return "{}";
        }
    }

    public int getMute() {
        return this.an;
    }

    public String getUnitId() {
        return this.f12509W;
    }

    public int getVideoSkipTime() {
        return this.f12504R;
    }

    public void gonePlayingCloseView() {
        if (this.f12297e && this.f12511t.getVisibility() != 8) {
            this.f12511t.setVisibility(8);
            this.ag = false;
        }
        if (!this.aV && !this.aj && !this.ah) {
            this.aV = true;
            int i5 = this.f12504R;
            if (i5 >= 0) {
                if (i5 == 0) {
                    this.aj = true;
                } else {
                    new Handler().postDelayed(new Runnable() {
                        public final void run() {
                            boolean unused = MBridgeVideoView.this.aj = true;
                        }
                    }, (long) (this.f12504R * 1000));
                }
            }
        }
    }

    public void hideAlertView(int i5) {
        if (this.f12501O) {
            this.f12501O = false;
            this.au = true;
            setShowingAlertViewCover(false);
            com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f12509W, false);
            int i6 = i5;
            com.mbridge.msdk.foundation.same.report.i.a(this.f12293a, this.f12294b, com.mbridge.msdk.videocommon.d.c.f13043a, this.f12509W, 1, i6, 1);
            if (i6 == 0) {
                h();
                if (this.am) {
                    int i7 = this.ar;
                    if (i7 == com.mbridge.msdk.foundation.same.a.f9166I || i7 == com.mbridge.msdk.foundation.same.a.f9165H) {
                        this.av = true;
                        com.mbridge.msdk.video.module.a.a aVar = this.notifyListener;
                        if (aVar != null) {
                            aVar.a(R.styleable.AppCompatTheme_windowMinWidthMajor, "");
                        }
                        CampaignEx campaignEx = this.f12294b;
                        if (campaignEx == null || campaignEx.getRewardTemplateMode() == null || this.f12294b.getRewardTemplateMode().f() != 5002010) {
                            this.aA = true;
                            gonePlayingCloseView();
                            return;
                        }
                        j();
                        return;
                    }
                    return;
                }
                return;
            }
            this.aw = true;
            boolean z4 = this.am;
            if (z4 && this.ar == com.mbridge.msdk.foundation.same.a.f9166I) {
                h();
            } else if (!z4 || this.ar != com.mbridge.msdk.foundation.same.a.f9165H) {
                com.mbridge.msdk.video.module.a.a aVar2 = this.notifyListener;
                if (aVar2 != null) {
                    this.aS = true;
                    aVar2.a(2, "");
                }
            } else {
                com.mbridge.msdk.video.module.a.a aVar3 = this.notifyListener;
                if (aVar3 != null) {
                    this.aS = true;
                    aVar3.a(2, b(this.ay));
                }
            }
        }
    }

    public void init(Context context) {
    }

    public boolean isH5Canvas() {
        if (getLayoutParams().height >= ak.e(this.f12293a.getApplicationContext())) {
            return false;
        }
        return true;
    }

    public boolean isInstDialogShowing() {
        return this.aL;
    }

    public boolean isMiniCardShowing() {
        return this.af;
    }

    public boolean isRewardPopViewShowing() {
        return this.f12502P;
    }

    public boolean isShowingAlertView() {
        return this.f12501O;
    }

    public boolean isShowingTransparent() {
        return this.ak;
    }

    public boolean isfront() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup == null) {
            return false;
        }
        int indexOfChild = viewGroup.indexOfChild(this);
        int childCount = viewGroup.getChildCount();
        int i5 = indexOfChild + 1;
        boolean z4 = false;
        while (i5 <= childCount - 1) {
            if (viewGroup.getChildAt(i5).getVisibility() == 0 && this.af) {
                return false;
            }
            i5++;
            z4 = true;
        }
        return z4;
    }

    public void notifyCloseBtn(int i5) {
        if (i5 == 0) {
            this.ah = true;
            this.aj = false;
        } else if (i5 == 1) {
            this.ai = true;
        }
    }

    public void notifyVideoClose() {
        this.aS = true;
        this.notifyListener.a(2, "");
    }

    public void onActivityPause() {
        try {
            MBAcquireRewardPopView mBAcquireRewardPopView = this.aK;
            if (mBAcquireRewardPopView != null) {
                mBAcquireRewardPopView.onPause();
            }
        } catch (Throwable th) {
            af.b(MBridgeBaseView.TAG, th.getMessage());
        }
    }

    public void onActivityResume() {
        try {
            MBAcquireRewardPopView mBAcquireRewardPopView = this.aK;
            if (mBAcquireRewardPopView != null) {
                mBAcquireRewardPopView.onResume();
            }
        } catch (Throwable th) {
            af.b(MBridgeBaseView.TAG, th.getMessage());
        }
    }

    public void onActivityStop() {
        try {
            MBAcquireRewardPopView mBAcquireRewardPopView = this.aK;
            if (mBAcquireRewardPopView != null) {
                mBAcquireRewardPopView.onStop();
            }
        } catch (Throwable th) {
            af.b(MBridgeBaseView.TAG, th.getMessage());
        }
    }

    public void onBackPress() {
        boolean z4;
        if (!this.af && !this.f12501O && !this.av) {
            CampaignEx campaignEx = this.f12294b;
            if (campaignEx != null && campaignEx.getRewardTemplateMode() != null && this.f12294b.getRewardTemplateMode().f() == 5002010 && (z4 = this.ay)) {
                com.mbridge.msdk.video.module.a.a aVar = this.notifyListener;
                if (aVar != null) {
                    this.aS = true;
                    aVar.a(2, b(z4));
                }
            } else if (this.ag) {
                e();
            } else {
                boolean z5 = this.ah;
                if (z5 && this.ai) {
                    e();
                } else if (!z5 && this.aj) {
                    e();
                }
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        CampaignEx campaignEx = this.f12294b;
        if ((campaignEx == null || !campaignEx.isDynamicView()) && this.f12297e && this.ac) {
            k();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            if (this.aW != null) {
                getHandler().removeCallbacks(this.aW);
            }
            if (this.aF != 0) {
                removeCallbacks(this.aX);
            }
        } catch (Throwable th) {
            af.b(MBridgeBaseView.TAG, th.getMessage());
        }
    }

    public void preLoadData(com.mbridge.msdk.video.signal.factory.b bVar) {
        this.f12496J = bVar;
        if (!this.f12297e) {
            com.mbridge.msdk.video.module.a.a aVar = this.notifyListener;
            if (aVar != null) {
                aVar.a(12, "MBridgeVideoView initSuccess false");
            }
        } else if (!TextUtils.isEmpty(this.f12503Q) && this.f12294b != null) {
            u1.b bVar2 = this.ao;
            if (bVar2 != null) {
                bVar2.d(this.mPlayerView);
                SoundImageView soundImageView = this.mSoundImageView;
                if (soundImageView != null) {
                    this.ao.a(soundImageView, u1.h.OTHER, (String) null);
                }
                this.ao.a(this.f12510s, u1.h.OTHER, (String) null);
                this.ao.a(this.f12511t, u1.h.VIDEO_CONTROLS, (String) null);
            }
            CampaignEx campaignEx = this.f12294b;
            if (campaignEx != null && ap.b(campaignEx.getVideoResolution())) {
                String videoResolution = this.f12294b.getVideoResolution();
                af.c(MBridgeBaseView.TAG, "MBridgeBaseView videoResolution:" + videoResolution);
                String[] split = videoResolution.split("x");
                if (split.length == 2) {
                    if (ak.m(split[0]) > 0.0d) {
                        this.aa = ak.m(split[0]);
                    }
                    if (ak.m(split[1]) > 0.0d) {
                        this.ab = ak.m(split[1]);
                    }
                    af.c(MBridgeBaseView.TAG, "MBridgeBaseView mVideoW:" + this.aa + "  mVideoH:" + this.ab);
                }
                if (this.aa <= 0.0d) {
                    this.aa = 1280.0d;
                }
                if (this.ab <= 0.0d) {
                    this.ab = 720.0d;
                }
            }
            this.mPlayerView.initBufferIngParam(this.f12505S);
            this.mPlayerView.initVFPData(this.f12503Q, this.f12294b.getVideoUrlEncode(), this.aU);
            soundOperate(this.an, -1, (String) null);
        }
        f12486r = false;
    }

    public void progressBarOperate(int i5) {
        ProgressBar progressBar;
        if (!this.f12297e) {
            return;
        }
        if (i5 == 1) {
            ProgressBar progressBar2 = this.f12514w;
            if (progressBar2 != null) {
                progressBar2.setVisibility(8);
            }
        } else if (i5 == 2 && (progressBar = this.f12514w) != null) {
            progressBar.setVisibility(0);
        }
    }

    public void progressOperate(int i5, int i6) {
        int i7;
        if (this.f12297e) {
            af.c(MBridgeBaseView.TAG, "progressOperate progress:" + i5);
            CampaignEx campaignEx = this.f12294b;
            if (campaignEx != null) {
                i7 = campaignEx.getVideoLength();
            } else {
                i7 = 0;
            }
            if (i5 > 0 && i5 <= i7 && this.mPlayerView != null) {
                af.c(MBridgeBaseView.TAG, "progressOperate progress:" + i5);
                this.mPlayerView.seekTo(i5 * 1000);
            }
            if (i6 == 1) {
                this.f12510s.setVisibility(8);
            } else if (i6 == 2) {
                this.f12510s.setVisibility(0);
            }
            if (this.f12510s.getVisibility() == 0) {
                n();
            }
        }
    }

    public void releasePlayer() {
        try {
            PlayerView playerView = this.mPlayerView;
            if (playerView != null && !this.ae) {
                playerView.release();
                e eVar = new e();
                eVar.a(TypedValues.TransitionType.S_DURATION, Long.valueOf(System.currentTimeMillis() - aQ));
                d.a().a("2000146", this.f12294b, eVar);
            }
            c cVar = this.aU;
            if (cVar != null) {
                cVar.c();
            }
            if (this.f12487A != null) {
                this.f12487A = null;
            }
        } catch (Exception e5) {
            af.b(MBridgeBaseView.TAG, e5.getMessage());
        }
    }

    public void setAdSession(u1.b bVar) {
        this.ao = bVar;
    }

    public void setBufferTimeout(int i5) {
        this.f12505S = i5;
    }

    public void setCTALayoutVisibleOrGone() {
        CampaignEx campaignEx = this.f12294b;
        if (campaignEx != null && this.f12494H != null) {
            if (campaignEx.getRewardTemplateMode() == null || this.f12294b.getRewardTemplateMode().f() != 902) {
                int i5 = this.f12498L;
                if (i5 != -5) {
                    if (i5 != -3) {
                        if (this.f12495I == null) {
                            addCTAView();
                        }
                        if (this.f12498L == -1) {
                            if (this.f12494H.getVisibility() != 0) {
                                this.f12494H.setVisibility(0);
                                postDelayed(this.aW, 3000);
                            } else {
                                this.f12494H.setVisibility(8);
                                getHandler().removeCallbacks(this.aW);
                            }
                        }
                        if (this.f12498L >= 0) {
                            this.f12494H.setVisibility(0);
                        }
                    }
                } else if (this.f12497K >= -1) {
                    if (this.f12495I == null) {
                        addCTAView();
                    }
                    int i6 = this.f12497K;
                    if (i6 >= 0) {
                        this.f12494H.setVisibility(0);
                    } else if (i6 != -1) {
                    } else {
                        if (this.f12494H.getVisibility() != 0) {
                            this.f12494H.setVisibility(0);
                            postDelayed(this.aW, 3000);
                            return;
                        }
                        this.f12494H.setVisibility(8);
                        getHandler().removeCallbacks(this.aW);
                    }
                }
            }
        }
    }

    public void setCamPlayOrderCallback(com.mbridge.msdk.video.dynview.e.a aVar, List<CampaignEx> list, int i5, int i6) {
        MBridgeSegmentsProgressBar mBridgeSegmentsProgressBar;
        this.f12490D = aVar;
        this.mCampaignSize = list.size();
        this.mCurrPlayNum = i5;
        this.f12492F = i6;
        this.mCampOrderViewData = list;
        CampaignEx campaignEx = this.f12294b;
        if (campaignEx == null || campaignEx.getDynamicTempCode() != 5) {
            CampaignEx campaignEx2 = this.f12294b;
            if (campaignEx2 != null && campaignEx2.getProgressBarShow() == 1 && (mBridgeSegmentsProgressBar = this.f12517z) != null) {
                mBridgeSegmentsProgressBar.init(1, 3);
                this.f12517z.setVisibility(0);
                return;
            }
            return;
        }
        MBridgeSegmentsProgressBar mBridgeSegmentsProgressBar2 = this.f12517z;
        if (mBridgeSegmentsProgressBar2 != null && this.mCampOrderViewData != null) {
            if (this.mCampaignSize > 1) {
                mBridgeSegmentsProgressBar2.setVisibility(0);
                this.f12517z.init(this.mCampaignSize, 2);
                for (int i7 = 0; i7 < this.mCampOrderViewData.size(); i7++) {
                    int videoPlayProgress = this.mCampOrderViewData.get(i7).getVideoPlayProgress();
                    if (videoPlayProgress > 0) {
                        this.f12517z.setProgress(videoPlayProgress, i7);
                    }
                    if (this.mCampOrderViewData.get(i7).isRewardPopViewShowed) {
                        this.f12500N = true;
                    }
                }
                return;
            }
            CampaignEx campaignEx3 = this.f12294b;
            if (campaignEx3 == null || campaignEx3.getProgressBarShow() != 1) {
                this.f12517z.setVisibility(8);
                return;
            }
            MBridgeSegmentsProgressBar mBridgeSegmentsProgressBar3 = this.f12517z;
            if (mBridgeSegmentsProgressBar3 != null) {
                mBridgeSegmentsProgressBar3.init(1, 3);
                this.f12517z.setVisibility(0);
            }
        }
    }

    public void setCampaign(CampaignEx campaignEx) {
        int i5;
        super.setCampaign(campaignEx);
        c cVar = this.aU;
        if (cVar != null) {
            cVar.a(campaignEx);
            c cVar2 = this.aU;
            if (campaignEx == null) {
                i5 = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f12509W, false).r();
            } else if (campaignEx.getReady_rate() != -1) {
                i5 = campaignEx.getReady_rate();
            } else {
                i5 = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f12509W, false).r();
            }
            cVar2.a(i5, com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f12509W, false).s());
        }
    }

    public void setCloseAlert(int i5) {
        this.f12506T = i5;
    }

    public void setContainerViewOnNotifyListener(com.mbridge.msdk.video.module.a.a aVar) {
        this.f12487A = aVar;
    }

    public void setCover(boolean z4) {
        if (this.f12297e) {
            this.mPlayerView.setIsCovered(z4);
        }
    }

    public void setDialogRole(int i5) {
        boolean z4 = true;
        if (i5 != 1) {
            z4 = false;
        }
        this.ax = z4;
        af.b(MBridgeBaseView.TAG, i5 + " " + this.ax);
    }

    public void setIPlayVideoViewLayoutCallBack(f fVar) {
        this.f12491E = fVar;
    }

    public void setIVRewardEnable(int i5, int i6, int i7) {
        this.ar = i5;
        this.as = i6;
        this.at = i7;
    }

    public void setInstDialogState(boolean z4) {
        PlayerView playerView;
        this.aL = z4;
        if (com.mbridge.msdk.e.b.a() && (playerView = this.mPlayerView) != null) {
            playerView.setIsCovered(z4);
        }
    }

    public void setIsIV(boolean z4) {
        this.am = z4;
        c cVar = this.aU;
        if (cVar != null) {
            cVar.a(z4);
        }
    }

    public void setMiniEndCardState(boolean z4) {
        this.af = z4;
    }

    public void setNotchPadding(int i5, int i6, int i7, int i8) {
        MBridgeVideoView mBridgeVideoView;
        RelativeLayout relativeLayout;
        try {
            af.b(MBridgeBaseView.TAG, "NOTCH VideoView " + String.format("%1s-%2s-%3s-%4s", new Object[]{Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            int i9 = layoutParams.leftMargin;
            int i10 = layoutParams.rightMargin;
            int i11 = layoutParams.topMargin;
            int i12 = layoutParams.bottomMargin;
            this.aR = i7;
            if (Math.max(Math.max(i9, i10), Math.max(i11, i12)) <= Math.max(Math.max(i5, i6), Math.max(i7, i8)) && (relativeLayout = this.f12512u) != null) {
                mBridgeVideoView = this;
                final int i13 = i5;
                final int i14 = i6;
                final int i15 = i7;
                final int i16 = i8;
                try {
                    relativeLayout.postDelayed(new Runnable() {
                        public final void run() {
                            if (MBridgeVideoView.this.f12512u != null) {
                                MBridgeVideoView.this.f12512u.setVisibility(0);
                                CampaignEx campaignEx = MBridgeVideoView.this.f12294b;
                                if (campaignEx != null && campaignEx.getAdSpaceT() != 2) {
                                    MBridgeVideoView.this.f12512u.setPadding(i13, i15, i14, i16);
                                    MBridgeVideoView.this.f12512u.startAnimation(MBridgeVideoView.this.aD);
                                }
                            }
                        }
                    }, 200);
                } catch (Exception e5) {
                    e = e5;
                    af.b(MBridgeBaseView.TAG, e.getMessage());
                }
            } else {
                mBridgeVideoView = this;
            }
            if (mBridgeVideoView.f12510s.getVisibility() == 0) {
                n();
            }
        } catch (Exception e6) {
            e = e6;
            af.b(MBridgeBaseView.TAG, e.getMessage());
        }
    }

    public void setPlayURL(String str) {
        this.f12503Q = str;
    }

    public void setPlayerViewAttachListener(a aVar) {
        this.f12488B = aVar;
    }

    public void setScaleFitXY(int i5) {
        this.al = i5;
    }

    public void setShowingAlertViewCover(boolean z4) {
        MBAcquireRewardPopView mBAcquireRewardPopView;
        if (z4 && (mBAcquireRewardPopView = this.aK) != null && this.f12502P && this.f12501O) {
            mBAcquireRewardPopView.onPause();
        }
        this.mPlayerView.setIsCovered(z4);
    }

    public void setShowingTransparent(boolean z4) {
        this.ak = z4;
    }

    public void setSoundState(int i5) {
        this.an = i5;
    }

    public void setUnitId(String str) {
        this.f12509W = str;
        c cVar = this.aU;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    public void setVideoEvents(v1.b bVar) {
        this.ap = bVar;
        c cVar = this.aU;
        if (cVar != null) {
            v1.b unused = cVar.f12557f = bVar;
        }
        PlayerView playerView = this.mPlayerView;
        if (playerView != null) {
            playerView.setVideoEvents(bVar);
        }
    }

    public void setVideoLayout(CampaignEx campaignEx) {
        if (campaignEx != null) {
            this.f12294b = campaignEx;
            this.f12300h = campaignEx.isDynamicView();
        }
        if (this.f12300h) {
            final com.mbridge.msdk.video.dynview.c a5 = new com.mbridge.msdk.video.dynview.j.c().a((View) this, campaignEx);
            com.mbridge.msdk.video.dynview.b.a().a(a5, new com.mbridge.msdk.video.dynview.e.h() {
                public final void viewInflaterFail(com.mbridge.msdk.video.dynview.c.a aVar) {
                    af.b(MBridgeBaseView.TAG, "errorMsg：" + aVar.b());
                }

                public final void viewInflaterSuccess(com.mbridge.msdk.video.dynview.a aVar) {
                    if (aVar != null) {
                        if (!(this == null || aVar.a() == null)) {
                            aVar.a().setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                            this.addView(aVar.a());
                        }
                        if (aVar.b() != null) {
                            for (View onClickListener : aVar.b()) {
                                onClickListener.setOnClickListener(new com.mbridge.msdk.widget.a() {
                                    /* access modifiers changed from: protected */
                                    public final void onNoDoubleClick(View view) {
                                        if (view instanceof TextView) {
                                            MBridgeVideoView.this.f12294b.setTriggerClickSource(1);
                                        } else {
                                            MBridgeVideoView.this.f12294b.setTriggerClickSource(2);
                                        }
                                        if (MBridgeVideoView.this.f12294b.getRewardTemplateMode() == null || MBridgeVideoView.this.f12294b.getRewardTemplateMode().f() != 902) {
                                            MBridgeVideoView.a(MBridgeVideoView.this, "video_play_click");
                                        } else {
                                            MBridgeVideoView.b(MBridgeVideoView.this);
                                        }
                                    }
                                });
                            }
                        }
                        boolean unused = MBridgeVideoView.this.aC = aVar.c();
                        MBridgeVideoView.this.b();
                        boolean unused2 = MBridgeVideoView.f12486r = false;
                        MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                        CampaignEx campaignEx = mBridgeVideoView.f12294b;
                        if (campaignEx != null) {
                            campaignEx.setTemplateRenderSucc(mBridgeVideoView.aC);
                        }
                        int unused3 = MBridgeVideoView.this.f12497K = a5.j();
                        int unused4 = MBridgeVideoView.this.f12498L = a5.m();
                    }
                }
            });
            return;
        }
        int findLayout = findLayout("mbridge_reward_videoview_item");
        if (findLayout > 0) {
            this.f12295c.inflate(findLayout, this);
            b();
        }
        f12486r = false;
        CampaignEx campaignEx2 = this.f12294b;
        if (campaignEx2 != null && campaignEx2.getAdSpaceT() == 2 && this.tvFlag != null) {
            String language = Locale.getDefault().getLanguage();
            if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                this.tvFlag.setText("AD");
            } else {
                this.tvFlag.setText("广告");
            }
        }
    }

    public void setVideoSkipTime(int i5) {
        this.f12504R = i5;
    }

    public void setVisible(int i5) {
        setVisibility(i5);
    }

    public void showAlertView() {
        CampaignEx campaignEx;
        if (!this.af) {
            if (this.f12508V == null) {
                this.f12508V = new com.mbridge.msdk.widget.dialog.a() {
                    public final void a() {
                        boolean unused = MBridgeVideoView.this.f12501O = false;
                        MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                        mBridgeVideoView.setShowingAlertViewCover(mBridgeVideoView.f12501O);
                        if (MBridgeVideoView.this.am && (MBridgeVideoView.this.ar == com.mbridge.msdk.foundation.same.a.f9166I || MBridgeVideoView.this.ar == com.mbridge.msdk.foundation.same.a.f9165H)) {
                            boolean unused2 = MBridgeVideoView.this.av = true;
                            com.mbridge.msdk.video.module.a.a aVar = MBridgeVideoView.this.notifyListener;
                            if (aVar != null) {
                                aVar.a(R.styleable.AppCompatTheme_windowMinWidthMajor, "");
                            }
                            boolean unused3 = MBridgeVideoView.this.aA = true;
                            MBridgeVideoView.this.gonePlayingCloseView();
                        }
                        MBridgeVideoView.this.h();
                        MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
                        com.mbridge.msdk.foundation.same.report.i.a(mBridgeVideoView2.f12293a, mBridgeVideoView2.f12294b, mBridgeVideoView2.aq, MBridgeVideoView.this.f12509W, 1, 0, 1);
                    }

                    public final void b() {
                        boolean unused = MBridgeVideoView.this.f12501O = false;
                        boolean unused2 = MBridgeVideoView.this.aw = true;
                        MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                        mBridgeVideoView.setShowingAlertViewCover(mBridgeVideoView.f12501O);
                        MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
                        com.mbridge.msdk.foundation.same.report.i.a(mBridgeVideoView2.f12293a, mBridgeVideoView2.f12294b, mBridgeVideoView2.aq, MBridgeVideoView.this.f12509W, 1, 1, 1);
                        if (MBridgeVideoView.this.am && MBridgeVideoView.this.ar == com.mbridge.msdk.foundation.same.a.f9165H) {
                            MBridgeVideoView mBridgeVideoView3 = MBridgeVideoView.this;
                            if (mBridgeVideoView3.notifyListener != null) {
                                boolean unused3 = mBridgeVideoView3.aS = true;
                                MBridgeVideoView mBridgeVideoView4 = MBridgeVideoView.this;
                                mBridgeVideoView4.notifyListener.a(2, mBridgeVideoView4.b(mBridgeVideoView4.ay));
                            }
                        } else if (!MBridgeVideoView.this.am || MBridgeVideoView.this.ar != com.mbridge.msdk.foundation.same.a.f9166I) {
                            MBridgeVideoView mBridgeVideoView5 = MBridgeVideoView.this;
                            if (mBridgeVideoView5.notifyListener != null) {
                                boolean unused4 = mBridgeVideoView5.aS = true;
                                MBridgeVideoView.this.notifyListener.a(2, "");
                            }
                        } else {
                            MBridgeVideoView.this.h();
                        }
                    }

                    public final void c() {
                    }
                };
            }
            if (this.f12507U == null) {
                MBAlertDialog mBAlertDialog = new MBAlertDialog(getContext(), this.f12508V);
                this.f12507U = mBAlertDialog;
                u1.b bVar = this.ao;
                if (bVar != null) {
                    bVar.a(mBAlertDialog.getWindow().getDecorView(), u1.h.NOT_VISIBLE, (String) null);
                }
            }
            if (this.am) {
                this.f12507U.makeIVAlertView(this.ar, this.f12509W);
            } else {
                this.f12507U.makeRVAlertView(this.f12509W);
            }
            PlayerView playerView = this.mPlayerView;
            if (playerView == null) {
                return;
            }
            if (!playerView.isComplete() || !((campaignEx = this.f12294b) == null || campaignEx.getRewardTemplateMode() == null || this.f12294b.getRewardTemplateMode().f() != 5002010)) {
                this.f12507U.show();
                this.au = true;
                this.f12501O = true;
                setShowingAlertViewCover(true);
                com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f12509W, false);
                String str = com.mbridge.msdk.videocommon.d.c.f13043a;
                this.aq = str;
                com.mbridge.msdk.foundation.same.report.i.a(this.f12293a, this.f12294b, str, this.f12509W, 1, 1);
            }
        }
    }

    public void showBaitClickView() {
        int parseInt;
        MBridgeBaitClickView mBridgeBaitClickView;
        CampaignEx campaignEx = this.f12294b;
        if (campaignEx != null && campaignEx.isDynamicView() && this.f12294b.getRewardTemplateMode() != null) {
            String e5 = this.f12294b.getRewardTemplateMode().e();
            if (!TextUtils.isEmpty(e5)) {
                try {
                    String a5 = aq.a(e5, "bait_click");
                    if (!TextUtils.isEmpty(a5) && (parseInt = Integer.parseInt(a5)) != 0 && (mBridgeBaitClickView = this.aE) != null) {
                        mBridgeBaitClickView.setVisibility(0);
                        this.aE.init(parseInt);
                        this.aE.startAnimation();
                        this.aE.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                                if (mBridgeVideoView.notifyListener != null) {
                                    mBridgeVideoView.f12294b.setTriggerClickSource(2);
                                    MBridgeVideoView.a(MBridgeVideoView.this, "bait_click_clicked");
                                }
                            }
                        });
                    }
                } catch (Exception e6) {
                    af.b(MBridgeBaseView.TAG, e6.getMessage());
                }
            }
        }
    }

    public void showIVRewardAlertView(String str) {
        this.notifyListener.a(8, "");
    }

    public void showMoreOfferInPlayTemplate() {
        CampaignEx campaignEx = this.f12294b;
        if (campaignEx != null && this.f12499M != null && campaignEx.isDynamicView() && this.f12294b.getRewardTemplateMode() != null) {
            String e5 = this.f12294b.getRewardTemplateMode().e();
            if (!TextUtils.isEmpty(e5)) {
                try {
                    String a5 = aq.a(e5, "mof");
                    if (!TextUtils.isEmpty(a5) && Integer.parseInt(a5) == 1) {
                        com.mbridge.msdk.video.dynview.moffer.a.a().a(this.f12294b, this, new com.mbridge.msdk.video.module.a.a.i(this.f12487A), 1);
                    }
                } catch (Exception e6) {
                    af.b(MBridgeBaseView.TAG, e6.getMessage());
                }
            }
        }
    }

    public void showRewardPopView() {
        AcquireRewardPopViewParameters acquireRewardPopViewParameters;
        MBAcquireRewardPopView mBAcquireRewardPopView = this.aK;
        if (mBAcquireRewardPopView != null && (acquireRewardPopViewParameters = this.aJ) != null) {
            try {
                mBAcquireRewardPopView.init(acquireRewardPopViewParameters);
                this.aK.setVisibility(0);
                setCover(true);
                g();
                this.f12502P = true;
                CampaignEx campaignEx = this.f12294b;
                if (campaignEx != null) {
                    campaignEx.isRewardPopViewShowed = true;
                }
            } catch (Exception e5) {
                af.b(MBridgeBaseView.TAG, e5.getMessage());
            }
        }
    }

    public void showVideoLocation(int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
        float f5;
        af.c(MBridgeBaseView.TAG, "showVideoLocation marginTop:" + i5 + " marginLeft:" + i6 + " width:" + i7 + "  height:" + i8 + " radius:" + i9 + " borderTop:" + i10 + " borderLeft:" + i11 + " borderWidth:" + i12 + " borderHeight:" + i13);
        if (this.f12297e) {
            this.f12512u.setPadding(0, 0, 0, 0);
            setVisibility(0);
            if (this.f12512u.getVisibility() != 0) {
                this.f12512u.setVisibility(0);
            }
            if (this.f12510s.getVisibility() == 0) {
                n();
            }
            int f6 = ak.f(this.f12293a);
            int e5 = ak.e(this.f12293a);
            if (i7 <= 0 || i8 <= 0 || f6 < i7 || e5 < i8 || this.ac) {
                k();
                return;
            }
            f12482n = i10;
            f12483o = i11;
            f12484p = i12 + 4;
            f12485q = i13 + 4;
            float f7 = ((float) i7) / ((float) i8);
            try {
                f5 = (float) (this.aa / this.ab);
            } catch (Throwable th) {
                af.b(MBridgeBaseView.TAG, th.getMessage(), th);
                f5 = 0.0f;
            }
            if (i9 > 0) {
                f12481m = i9;
                if (i9 > 0) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setCornerRadius((float) ak.a(getContext(), (float) i9));
                    gradientDrawable.setColor(-1);
                    gradientDrawable.setStroke(1, 0);
                    setBackground(gradientDrawable);
                    this.mPlayerView.setBackground(gradientDrawable);
                    setClipToOutline(true);
                    this.mPlayerView.setClipToOutline(true);
                }
            }
            if (Math.abs(f7 - f5) <= 0.1f || this.al == 1) {
                k();
                if (this.ak) {
                    setLayoutCenter(i7, i8);
                    if (f12486r) {
                        this.notifyListener.a(114, "");
                    } else {
                        this.notifyListener.a(116, "");
                    }
                } else {
                    setLayoutParam(i6, i5, i7, i8);
                }
            } else {
                k();
                videoOperate(1);
            }
        }
    }

    public void soundOperate(int i5, int i6) {
        soundOperate(i5, i6, "2");
    }

    public void videoOperate(int i5) {
        af.a(MBridgeBaseView.TAG, "VideoView videoOperate:" + i5);
        if (!this.f12297e) {
            return;
        }
        if (i5 == 1) {
            if (getVisibility() == 0 && isfront()) {
                af.a(MBridgeBaseView.TAG, "VideoView videoOperate:play");
                RelativeLayout relativeLayout = this.aO;
                if ((relativeLayout != null && relativeLayout.getVisibility() != 0) || this.f12501O || com.mbridge.msdk.foundation.d.b.f8931c) {
                    return;
                }
                if (!com.mbridge.msdk.e.b.a()) {
                    h();
                } else if (!this.af && !this.aL) {
                    h();
                }
            }
        } else if (i5 == 2) {
            if (getVisibility() == 0 && isfront()) {
                af.a(MBridgeBaseView.TAG, "VideoView videoOperate:pause");
                g();
            }
        } else if (i5 == 3) {
            if (!this.ae) {
                this.mPlayerView.stop();
                CampaignEx campaignEx = this.f12294b;
                if (campaignEx == null || campaignEx.getRewardTemplateMode() == null || this.f12294b.getRewardTemplateMode().f() != 5002010) {
                    this.mPlayerView.release();
                    this.ae = true;
                    e eVar = new e();
                    eVar.a(TypedValues.TransitionType.S_DURATION, Long.valueOf(System.currentTimeMillis() - aQ));
                    d.a().a("2000146", this.f12294b, eVar);
                }
            }
        } else if (i5 == 5) {
            if (com.mbridge.msdk.e.b.a()) {
                this.aL = true;
                if (!this.ae) {
                    g();
                }
            }
        } else if (i5 == 4) {
            if (com.mbridge.msdk.e.b.a()) {
                this.aL = false;
                if (!this.ae && !isMiniCardShowing()) {
                    h();
                }
            }
        } else if (i5 == 6 && !this.ae) {
            this.mPlayerView.release();
            this.ae = true;
            e eVar2 = new e();
            eVar2.a(TypedValues.TransitionType.S_DURATION, Long.valueOf(System.currentTimeMillis() - aQ));
            d.a().a("2000146", this.f12294b, eVar2);
        }
    }

    private int p() {
        int i5 = 0;
        try {
            c cVar = this.aU;
            if (cVar != null) {
                i5 = cVar.b();
            }
            return i5 == 0 ? this.f12294b.getVideoLength() : i5;
        } catch (Throwable th) {
            af.b(MBridgeBaseView.TAG, th.getMessage());
            return 0;
        }
    }

    public void soundOperate(int i5, int i6, String str) {
        com.mbridge.msdk.video.module.a.a aVar;
        SoundImageView soundImageView;
        if (this.f12297e) {
            this.an = i5;
            if (i5 == 1) {
                SoundImageView soundImageView2 = this.mSoundImageView;
                if (soundImageView2 != null) {
                    soundImageView2.setSoundStatus(false);
                }
                this.mPlayerView.closeSound();
                try {
                    v1.b bVar = this.ap;
                    if (bVar != null) {
                        bVar.o(0.0f);
                        af.a("omsdk", "play video view:  mute");
                    }
                } catch (Exception e5) {
                    af.a("OMSDK", e5.getMessage());
                }
            } else if (i5 == 2) {
                SoundImageView soundImageView3 = this.mSoundImageView;
                if (soundImageView3 != null) {
                    soundImageView3.setSoundStatus(true);
                }
                this.mPlayerView.openSound();
                try {
                    v1.b bVar2 = this.ap;
                    if (bVar2 != null) {
                        bVar2.o(1.0f);
                        af.a("omsdk", "play video view:  unmute");
                    }
                } catch (Exception e6) {
                    af.a("OMSDK", e6.getMessage());
                }
            }
            CampaignEx campaignEx = this.f12294b;
            if (campaignEx != null && campaignEx.isDynamicView()) {
                SoundImageView soundImageView4 = this.mSoundImageView;
                if (soundImageView4 != null) {
                    soundImageView4.setVisibility(0);
                }
            } else if (i6 == 1) {
                SoundImageView soundImageView5 = this.mSoundImageView;
                if (soundImageView5 != null) {
                    soundImageView5.setVisibility(8);
                }
            } else if (i6 == 2 && (soundImageView = this.mSoundImageView) != null) {
                soundImageView.setVisibility(0);
            }
        }
        if (str != null && str.equals("2") && (aVar = this.notifyListener) != null) {
            aVar.a(7, Integer.valueOf(i5));
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        PlayerView playerView;
        boolean f5 = f();
        this.f12297e = f5;
        if (!f5) {
            af.b(MBridgeBaseView.TAG, "MBridgeVideoView init fail");
        }
        if (ah.a().a("i_l_s_t_r_i", false) && (playerView = this.mPlayerView) != null) {
            playerView.setNotifyListener(new PlayerView.OnPlayerViewVisibleListener() {
                public final void playerViewVisibleCallback() {
                    if (!MBridgeVideoView.this.f12489C) {
                        boolean unused = MBridgeVideoView.this.f12489C = true;
                        MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                        if (mBridgeVideoView.notifyListener != null && mBridgeVideoView.f12488B != null) {
                            MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
                            mBridgeVideoView2.notifyListener.a(20, mBridgeVideoView2.f12488B);
                        }
                    }
                }
            });
        }
        c();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 100.0f);
        this.aD = alphaAnimation;
        alphaAnimation.setDuration(200);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x013b, code lost:
        if (r5 < r0) goto L_0x013f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x013d, code lost:
        if (r0 == 0) goto L_0x013f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0156 A[Catch:{ Exception -> 0x0031 }] */
    /* JADX WARNING: Removed duplicated region for block: B:133:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e() {
        /*
            r8 = this;
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r8.f12294b     // Catch:{ Exception -> 0x0031 }
            r1 = 2
            r2 = 1
            if (r0 == 0) goto L_0x0034
            com.mbridge.msdk.foundation.entity.CampaignEx$c r0 = r0.getRewardTemplateMode()     // Catch:{ Exception -> 0x0031 }
            if (r0 == 0) goto L_0x0034
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r8.f12294b     // Catch:{ Exception -> 0x0031 }
            com.mbridge.msdk.foundation.entity.CampaignEx$c r0 = r0.getRewardTemplateMode()     // Catch:{ Exception -> 0x0031 }
            int r0 = r0.f()     // Catch:{ Exception -> 0x0031 }
            r3 = 5002010(0x4c531a, float:7.009309E-39)
            if (r0 != r3) goto L_0x0034
            boolean r0 = r8.aS     // Catch:{ Exception -> 0x0031 }
            if (r0 == 0) goto L_0x0034
            boolean r0 = r8.ay     // Catch:{ Exception -> 0x0031 }
            if (r0 != 0) goto L_0x0034
            com.mbridge.msdk.video.module.a.a r3 = r8.notifyListener     // Catch:{ Exception -> 0x0031 }
            if (r3 == 0) goto L_0x0165
            r8.aS = r2     // Catch:{ Exception -> 0x0031 }
            java.lang.String r0 = r8.b((boolean) r0)     // Catch:{ Exception -> 0x0031 }
            r3.a(r1, r0)     // Catch:{ Exception -> 0x0031 }
            return
        L_0x0031:
            r0 = move-exception
            goto L_0x0166
        L_0x0034:
            boolean r0 = r8.am     // Catch:{ Exception -> 0x0031 }
            r3 = 8
            java.lang.String r4 = ""
            if (r0 == 0) goto L_0x010e
            int r0 = r8.ar     // Catch:{ Exception -> 0x0031 }
            int r5 = com.mbridge.msdk.foundation.same.a.f9165H     // Catch:{ Exception -> 0x0031 }
            if (r0 == r5) goto L_0x0046
            int r5 = com.mbridge.msdk.foundation.same.a.f9166I     // Catch:{ Exception -> 0x0031 }
            if (r0 != r5) goto L_0x010e
        L_0x0046:
            boolean r5 = r8.au     // Catch:{ Exception -> 0x0031 }
            if (r5 == 0) goto L_0x005e
            int r3 = com.mbridge.msdk.foundation.same.a.f9166I     // Catch:{ Exception -> 0x0031 }
            if (r0 != r3) goto L_0x0165
            com.mbridge.msdk.video.module.a.a r0 = r8.notifyListener     // Catch:{ Exception -> 0x0031 }
            if (r0 == 0) goto L_0x0165
            r8.aS = r2     // Catch:{ Exception -> 0x0031 }
            boolean r2 = r8.ay     // Catch:{ Exception -> 0x0031 }
            java.lang.String r2 = r8.b((boolean) r2)     // Catch:{ Exception -> 0x0031 }
            r0.a(r1, r2)     // Catch:{ Exception -> 0x0031 }
            return
        L_0x005e:
            int r5 = com.mbridge.msdk.foundation.same.a.f9166I     // Catch:{ Exception -> 0x0031 }
            if (r0 != r5) goto L_0x0076
            boolean r0 = r8.aB     // Catch:{ Exception -> 0x0031 }
            if (r0 == 0) goto L_0x0076
            com.mbridge.msdk.video.module.a.a r0 = r8.notifyListener     // Catch:{ Exception -> 0x0031 }
            if (r0 == 0) goto L_0x0165
            r8.aS = r2     // Catch:{ Exception -> 0x0031 }
            boolean r2 = r8.ay     // Catch:{ Exception -> 0x0031 }
            java.lang.String r2 = r8.b((boolean) r2)     // Catch:{ Exception -> 0x0031 }
            r0.a(r1, r2)     // Catch:{ Exception -> 0x0031 }
            return
        L_0x0076:
            boolean r0 = r8.ax     // Catch:{ Exception -> 0x0031 }
            if (r0 == 0) goto L_0x0165
            com.mbridge.msdk.playercommon.PlayerView r0 = r8.mPlayerView     // Catch:{ Exception -> 0x0031 }
            int r0 = r0.getCurPosition()     // Catch:{ Exception -> 0x0031 }
            int r0 = r0 / 1000
            com.mbridge.msdk.playercommon.PlayerView r5 = r8.mPlayerView     // Catch:{ Exception -> 0x0031 }
            int r5 = r5.getDuration()     // Catch:{ Exception -> 0x0031 }
            if (r5 != 0) goto L_0x0091
            com.mbridge.msdk.foundation.entity.CampaignEx r5 = r8.f12294b     // Catch:{ Exception -> 0x0031 }
            int r5 = r5.getVideoLength()     // Catch:{ Exception -> 0x0031 }
            goto L_0x0097
        L_0x0091:
            com.mbridge.msdk.playercommon.PlayerView r5 = r8.mPlayerView     // Catch:{ Exception -> 0x0031 }
            int r5 = r5.getDuration()     // Catch:{ Exception -> 0x0031 }
        L_0x0097:
            float r6 = (float) r0     // Catch:{ Exception -> 0x0031 }
            float r5 = (float) r5     // Catch:{ Exception -> 0x0031 }
            float r6 = r6 / r5
            r5 = 1120403456(0x42c80000, float:100.0)
            float r6 = r6 * r5
            int r5 = (int) r6     // Catch:{ Exception -> 0x0031 }
            int r6 = r8.ar     // Catch:{ Exception -> 0x0031 }
            int r7 = com.mbridge.msdk.foundation.same.a.f9165H     // Catch:{ Exception -> 0x0031 }
            if (r6 != r7) goto L_0x00e0
            r8.g()     // Catch:{ Exception -> 0x0031 }
            int r6 = r8.as     // Catch:{ Exception -> 0x0031 }
            int r7 = com.mbridge.msdk.foundation.same.a.f9167J     // Catch:{ Exception -> 0x0031 }
            if (r6 != r7) goto L_0x00c1
            int r7 = r8.at     // Catch:{ Exception -> 0x0031 }
            if (r5 < r7) goto L_0x00c1
            com.mbridge.msdk.video.module.a.a r0 = r8.notifyListener     // Catch:{ Exception -> 0x0031 }
            if (r0 == 0) goto L_0x0165
            r8.aS = r2     // Catch:{ Exception -> 0x0031 }
            boolean r2 = r8.ay     // Catch:{ Exception -> 0x0031 }
            java.lang.String r2 = r8.b((boolean) r2)     // Catch:{ Exception -> 0x0031 }
            r0.a(r1, r2)     // Catch:{ Exception -> 0x0031 }
            return
        L_0x00c1:
            int r7 = com.mbridge.msdk.foundation.same.a.f9168K     // Catch:{ Exception -> 0x0031 }
            if (r6 != r7) goto L_0x00d9
            int r6 = r8.at     // Catch:{ Exception -> 0x0031 }
            if (r0 < r6) goto L_0x00d9
            com.mbridge.msdk.video.module.a.a r0 = r8.notifyListener     // Catch:{ Exception -> 0x0031 }
            if (r0 == 0) goto L_0x0165
            r8.aS = r2     // Catch:{ Exception -> 0x0031 }
            boolean r2 = r8.ay     // Catch:{ Exception -> 0x0031 }
            java.lang.String r2 = r8.b((boolean) r2)     // Catch:{ Exception -> 0x0031 }
            r0.a(r1, r2)     // Catch:{ Exception -> 0x0031 }
            return
        L_0x00d9:
            com.mbridge.msdk.video.module.a.a r1 = r8.notifyListener     // Catch:{ Exception -> 0x0031 }
            if (r1 == 0) goto L_0x00e0
            r1.a(r3, r4)     // Catch:{ Exception -> 0x0031 }
        L_0x00e0:
            int r1 = r8.ar     // Catch:{ Exception -> 0x0031 }
            int r2 = com.mbridge.msdk.foundation.same.a.f9166I     // Catch:{ Exception -> 0x0031 }
            if (r1 != r2) goto L_0x0165
            int r1 = r8.as     // Catch:{ Exception -> 0x0031 }
            int r2 = com.mbridge.msdk.foundation.same.a.f9167J     // Catch:{ Exception -> 0x0031 }
            if (r1 != r2) goto L_0x00fb
            int r2 = r8.at     // Catch:{ Exception -> 0x0031 }
            if (r5 < r2) goto L_0x00fb
            r8.g()     // Catch:{ Exception -> 0x0031 }
            com.mbridge.msdk.video.module.a.a r0 = r8.notifyListener     // Catch:{ Exception -> 0x0031 }
            if (r0 == 0) goto L_0x0165
            r0.a(r3, r4)     // Catch:{ Exception -> 0x0031 }
            return
        L_0x00fb:
            int r2 = com.mbridge.msdk.foundation.same.a.f9168K     // Catch:{ Exception -> 0x0031 }
            if (r1 != r2) goto L_0x0165
            int r1 = r8.at     // Catch:{ Exception -> 0x0031 }
            if (r0 < r1) goto L_0x0165
            r8.g()     // Catch:{ Exception -> 0x0031 }
            com.mbridge.msdk.video.module.a.a r0 = r8.notifyListener     // Catch:{ Exception -> 0x0031 }
            if (r0 == 0) goto L_0x0165
            r0.a(r3, r4)     // Catch:{ Exception -> 0x0031 }
            return
        L_0x010e:
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r8.f12294b     // Catch:{ Exception -> 0x0031 }
            if (r0 == 0) goto L_0x015c
            int r0 = r0.getAdSpaceT()     // Catch:{ Exception -> 0x0031 }
            if (r0 == r1) goto L_0x015c
            int r0 = r8.o()     // Catch:{ Exception -> 0x0031 }
            com.mbridge.msdk.playercommon.PlayerView r5 = r8.mPlayerView     // Catch:{ Exception -> 0x0031 }
            int r5 = r5.getCurPosition()     // Catch:{ Exception -> 0x0031 }
            int r5 = r5 / 1000
            com.mbridge.msdk.foundation.entity.CampaignEx r6 = r8.f12294b     // Catch:{ Exception -> 0x0031 }
            int r6 = r6.getDynamicTempCode()     // Catch:{ Exception -> 0x0031 }
            r7 = 5
            if (r6 != r7) goto L_0x0139
            int r6 = r8.mCurrPlayNum     // Catch:{ Exception -> 0x0031 }
            if (r6 <= r2) goto L_0x0139
            if (r0 != 0) goto L_0x0134
            goto L_0x0152
        L_0x0134:
            if (r0 <= 0) goto L_0x0152
            if (r5 >= r0) goto L_0x0152
            goto L_0x013f
        L_0x0139:
            if (r0 <= 0) goto L_0x013d
            if (r5 < r0) goto L_0x013f
        L_0x013d:
            if (r0 != 0) goto L_0x0152
        L_0x013f:
            int r0 = r8.f12506T     // Catch:{ Exception -> 0x0031 }
            if (r0 != r2) goto L_0x0152
            boolean r0 = r8.ak     // Catch:{ Exception -> 0x0031 }
            if (r0 != 0) goto L_0x0152
            r8.g()     // Catch:{ Exception -> 0x0031 }
            com.mbridge.msdk.video.module.a.a r0 = r8.notifyListener     // Catch:{ Exception -> 0x0031 }
            if (r0 == 0) goto L_0x0165
            r0.a(r3, r4)     // Catch:{ Exception -> 0x0031 }
            return
        L_0x0152:
            com.mbridge.msdk.video.module.a.a r0 = r8.notifyListener     // Catch:{ Exception -> 0x0031 }
            if (r0 == 0) goto L_0x0165
            r8.aS = r2     // Catch:{ Exception -> 0x0031 }
            r0.a(r1, r4)     // Catch:{ Exception -> 0x0031 }
            return
        L_0x015c:
            com.mbridge.msdk.video.module.a.a r0 = r8.notifyListener     // Catch:{ Exception -> 0x0031 }
            if (r0 == 0) goto L_0x0165
            r8.aS = r2     // Catch:{ Exception -> 0x0031 }
            r0.a(r1, r4)     // Catch:{ Exception -> 0x0031 }
        L_0x0165:
            return
        L_0x0166:
            java.lang.String r1 = "MBridgeBaseView"
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeVideoView.e():void");
    }

    private boolean f() {
        try {
            this.mPlayerView = (PlayerView) findViewById(filterFindViewId(this.aC, "mbridge_vfpv"));
            this.mSoundImageView = (SoundImageView) findViewById(filterFindViewId(this.aC, "mbridge_sound_switch"));
            this.f12510s = (TextView) findViewById(filterFindViewId(this.aC, "mbridge_tv_count"));
            View findViewById = findViewById(filterFindViewId(this.aC, "mbridge_rl_playing_close"));
            this.f12511t = findViewById;
            if (findViewById != null) {
                findViewById.setVisibility(4);
            }
            this.f12512u = (RelativeLayout) findViewById(filterFindViewId(this.aC, "mbridge_top_control"));
            this.f12513v = (ImageView) findViewById(filterFindViewId(this.aC, "mbridge_videoview_bg"));
            this.f12514w = (ProgressBar) findViewById(filterFindViewId(this.aC, "mbridge_video_progress_bar"));
            this.f12515x = (FeedBackButton) findViewById(filterFindViewId(this.aC, "mbridge_native_endcard_feed_btn"));
            this.f12516y = (ImageView) findViewById(filterFindViewId(this.aC, "mbridge_iv_link"));
            this.aM = (RelativeLayout) findViewById(filterFindViewId(this.aC, "mbridge_reward_scale_webview_layout"));
            this.aO = (RelativeLayout) findViewById(filterFindViewId(this.aC, "mbridge_reward_header_layout"));
            if (this.aM != null) {
                CollapsibleWebView collapsibleWebView = new CollapsibleWebView(getContext());
                this.aN = collapsibleWebView;
                this.aM.addView(collapsibleWebView, new RelativeLayout.LayoutParams(-1, -1));
            }
            ak.a(1, this.f12516y, this.f12294b, this.f12293a, false, new com.mbridge.msdk.foundation.d.a() {
                public final void close() {
                    MBridgeVideoView.this.h();
                }

                public final void showed() {
                    MBridgeVideoView.this.g();
                }

                public final void summit(String str) {
                    MBridgeVideoView.this.h();
                }
            });
            this.f12517z = (MBridgeSegmentsProgressBar) findViewById(filterFindViewId(this.aC, "mbridge_reward_segment_progressbar"));
            this.f12494H = (FrameLayout) findViewById(filterFindViewId(this.aC, "mbridge_reward_cta_layout"));
            this.aE = (MBridgeBaitClickView) findViewById(filterFindViewId(this.aC, "mbridge_animation_click_view"));
            this.f12499M = (RelativeLayout) findViewById(filterFindViewId(this.aC, "mbridge_reward_moreoffer_layout"));
            this.aK = (MBAcquireRewardPopView) findViewById(filterFindViewId(this.aC, "mbridge_reward_popview"));
            this.tvFlag = (TextView) findViewById(filterFindViewId(this.aC, "mbridge_tv_flag"));
            return isNotNULL(this.mPlayerView, this.mSoundImageView, this.f12510s, this.f12511t);
        } catch (Throwable th) {
            af.b(MBridgeBaseView.TAG, th.getMessage(), th);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        boolean z4;
        try {
            PlayerView playerView = this.mPlayerView;
            if (playerView != null) {
                playerView.onPause();
                CampaignEx campaignEx = this.f12294b;
                if (campaignEx != null && !campaignEx.isRewardPopViewShowed) {
                    removeCallbacks(this.aX);
                }
                if (com.mbridge.msdk.e.b.a()) {
                    PlayerView playerView2 = this.mPlayerView;
                    if (!this.aL && !this.f12501O) {
                        if (!this.f12502P) {
                            z4 = false;
                            playerView2.setIsCovered(z4);
                        }
                    }
                    z4 = true;
                    playerView2.setIsCovered(z4);
                }
                CampaignEx campaignEx2 = this.f12294b;
                if (campaignEx2 != null && campaignEx2.getNativeVideoTracking() != null && !this.f12294b.isHasReportAdTrackPause()) {
                    this.f12294b.setHasReportAdTrackPause(true);
                    Context c5 = com.mbridge.msdk.foundation.controller.c.m().c();
                    CampaignEx campaignEx3 = this.f12294b;
                    com.mbridge.msdk.click.a.a(c5, campaignEx3, this.f12509W, campaignEx3.getNativeVideoTracking().m(), false, false);
                }
            }
        } catch (Throwable th) {
            af.b(MBridgeBaseView.TAG, th.getMessage(), th);
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        c cVar;
        RelativeLayout relativeLayout;
        try {
            CampaignEx campaignEx = this.f12294b;
            if (campaignEx != null && campaignEx.getRewardTemplateMode() != null && this.f12294b.getRewardTemplateMode().f() == 5002010 && (relativeLayout = this.aO) != null && relativeLayout.getVisibility() != 0) {
                return;
            }
            if (!this.ad) {
                boolean playVideo = this.mPlayerView.playVideo();
                CampaignEx campaignEx2 = this.f12294b;
                if (!(campaignEx2 == null || campaignEx2.getPlayable_ads_without_video() == 2 || playVideo || (cVar = this.aU) == null)) {
                    cVar.onPlayError("play video failed");
                }
                this.ad = true;
                return;
            }
            MBAcquireRewardPopView mBAcquireRewardPopView = this.aK;
            if (mBAcquireRewardPopView != null && this.f12502P) {
                mBAcquireRewardPopView.onResume();
            }
            if (this.f12502P) {
                return;
            }
            if (!com.mbridge.msdk.e.b.a()) {
                i();
            } else if (!this.aL && !this.f12501O) {
                this.mPlayerView.setIsCovered(false);
                i();
            }
        } catch (Exception e5) {
            af.b(MBridgeBaseView.TAG, e5.getMessage(), e5);
        }
    }

    private void i() {
        if (this.ay) {
            if (!this.az) {
                this.mPlayerView.seekToEndFrame();
            }
            this.az = true;
        } else {
            this.mPlayerView.onResume();
        }
        CampaignEx campaignEx = this.f12294b;
        if (campaignEx != null && !campaignEx.isRewardPopViewShowed) {
            post(this.aX);
        }
    }

    /* access modifiers changed from: private */
    public void j() {
        if (this.f12297e && this.f12511t.getVisibility() != 0) {
            if (!this.f12300h || this.f12493G) {
                this.f12511t.setVisibility(0);
            }
            this.ag = true;
        }
    }

    private void k() {
        CampaignEx campaignEx = this.f12294b;
        if (campaignEx != null && campaignEx.getAdSpaceT() != 2) {
            l();
        }
    }

    private void l() {
        int i5;
        int i6;
        float f5 = (float) ak.f(this.f12293a);
        float e5 = (float) ak.e(this.f12293a);
        double d5 = this.aa;
        if (d5 > 0.0d) {
            double d6 = this.ab;
            if (d6 > 0.0d && f5 > 0.0f && e5 > 0.0f) {
                double d7 = d5 / d6;
                double d8 = (double) (f5 / e5);
                af.c(MBridgeBaseView.TAG, "videoWHDivide:" + d7 + "  screenWHDivide:" + d8);
                double a5 = ak.a(Double.valueOf(d7));
                double a6 = ak.a(Double.valueOf(d8));
                af.c(MBridgeBaseView.TAG, "videoWHDivideFinal:" + a5 + "  screenWHDivideFinal:" + a6);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mPlayerView.getLayoutParams();
                if (a5 > a6) {
                    layoutParams.width = -1;
                    layoutParams.height = (int) ((((double) f5) * this.ab) / this.aa);
                    layoutParams.gravity = 17;
                } else if (a5 < a6) {
                    layoutParams.width = (int) (((double) e5) * d7);
                    layoutParams.height = -1;
                    layoutParams.gravity = 17;
                } else {
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                }
                try {
                    CampaignEx campaignEx = this.f12294b;
                    if (campaignEx != null && campaignEx.isDynamicView()) {
                        if (this.f12294b.getRewardTemplateMode() != null) {
                            i6 = this.f12294b.getRewardTemplateMode().f();
                            i5 = this.f12294b.getRewardTemplateMode().b();
                        } else {
                            i5 = this.f12293a.getResources().getConfiguration().orientation;
                            i6 = TypedValues.Custom.TYPE_BOOLEAN;
                        }
                        if (i6 == 102 || i6 == 202) {
                            if (i5 == 1) {
                                layoutParams.width = -1;
                                layoutParams.gravity = 17;
                                layoutParams.height = (int) (this.ab / (this.aa / ((double) f5)));
                            } else {
                                layoutParams.height = -1;
                                layoutParams.gravity = 17;
                                layoutParams.width = (int) (((double) e5) * d7);
                            }
                        }
                        if (i6 == 202 && !TextUtils.isEmpty(this.f12294b.getImageUrl())) {
                            a(this.f12294b.getImageUrl());
                        }
                        if (i6 == 302 || i6 == 802 || i6 == 5002010) {
                            double d9 = this.aa;
                            double d10 = this.ab;
                            if (d9 / d10 > 1.0d) {
                                layoutParams.width = -1;
                                layoutParams.height = (int) ((d10 * ((double) f5)) / d9);
                            } else {
                                int a7 = ak.a(getContext(), 220.0f);
                                layoutParams.width = (int) ((this.aa * ((double) a7)) / this.ab);
                                layoutParams.height = a7;
                            }
                        }
                    }
                } catch (Throwable th) {
                    af.b(MBridgeBaseView.TAG, th.getMessage());
                }
                this.mPlayerView.setLayoutParams(layoutParams);
                setMatchParent();
                return;
            }
        }
        m();
    }

    private void m() {
        try {
            setLayoutParam(0, 0, -1, -1);
            if (!isLandscape() && this.f12297e) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mPlayerView.getLayoutParams();
                int f5 = ak.f(this.f12293a);
                layoutParams.width = -1;
                layoutParams.height = (f5 * 9) / 16;
                layoutParams.gravity = 17;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void n() {
        CampaignEx campaignEx = this.f12294b;
        if (campaignEx != null) {
            campaignEx.setCampaignUnitId(this.f12509W);
            com.mbridge.msdk.foundation.d.b a5 = com.mbridge.msdk.foundation.d.b.a();
            a5.a(this.f12509W + "_" + 1, this.f12294b);
        }
        if (!com.mbridge.msdk.foundation.d.b.a().b()) {
            FeedBackButton feedBackButton = this.f12515x;
            if (feedBackButton != null) {
                feedBackButton.setVisibility(8);
            }
        } else if (this.f12515x != null) {
            com.mbridge.msdk.foundation.d.b a6 = com.mbridge.msdk.foundation.d.b.a();
            a6.a(this.f12509W + "_" + 1, this.f12515x);
        }
    }

    /* access modifiers changed from: private */
    public int o() {
        try {
            int p5 = p();
            CampaignEx campaignEx = this.f12294b;
            if (campaignEx != null) {
                int videoCompleteTime = campaignEx.getVideoCompleteTime();
                if (this.f12294b.getDynamicTempCode() != 5 && videoCompleteTime > p5) {
                    videoCompleteTime = p5;
                }
                return videoCompleteTime <= 0 ? p5 : videoCompleteTime;
            }
        } catch (Throwable th) {
            af.b(MBridgeBaseView.TAG, th.getMessage());
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public final void c() {
        super.c();
        if (this.f12297e) {
            if (!this.f12300h) {
                this.mPlayerView.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        MBridgeVideoView.this.f12294b.setClickTempSource(1);
                        MBridgeVideoView.this.f12294b.setTriggerClickSource(2);
                        d.a().a("m_player_click", MBridgeVideoView.this.f12294b);
                        if (MBridgeVideoView.this.notifyListener != null) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put(com.mbridge.msdk.foundation.same.a.f9191j, MBridgeVideoView.this.mPlayerView.buildH5JsonObject(0));
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                            MBridgeVideoView.this.notifyListener.a(1, jSONObject);
                        }
                    }
                });
            } else if (com.mbridge.msdk.video.dynview.i.a.a(this.f12294b) == -1 || com.mbridge.msdk.video.dynview.i.a.a(this.f12294b) == 100) {
                this.mPlayerView.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        if (MBridgeVideoView.this.notifyListener != null) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put(com.mbridge.msdk.foundation.same.a.f9191j, MBridgeVideoView.this.mPlayerView.buildH5JsonObject(0));
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                            MBridgeVideoView.this.f12294b.setClickTempSource(1);
                            MBridgeVideoView.this.f12294b.setTriggerClickSource(2);
                            MBridgeVideoView.this.notifyListener.a(1, jSONObject);
                        }
                        if (MBridgeVideoView.this.ap != null) {
                            try {
                                MBridgeVideoView.this.ap.a(v1.a.CLICK);
                                af.a("omsdk", "play video view:  click");
                            } catch (Exception e6) {
                                af.b("omsdk", e6.getMessage());
                            }
                        }
                        MBridgeVideoView.this.setCTALayoutVisibleOrGone();
                    }
                });
            }
            SoundImageView soundImageView = this.mSoundImageView;
            if (soundImageView != null) {
                soundImageView.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        e eVar = new e();
                        Integer num = 2;
                        PlayerView playerView = MBridgeVideoView.this.mPlayerView;
                        if (playerView != null) {
                            eVar.a("mute_state", Boolean.valueOf(playerView.isSilent()));
                            if (MBridgeVideoView.this.mPlayerView.isSilent()) {
                                num = 1;
                            }
                        }
                        if (num.intValue() == 1) {
                            MBridgeVideoView.this.mMuteSwitch = 2;
                        } else {
                            MBridgeVideoView.this.mMuteSwitch = 1;
                        }
                        com.mbridge.msdk.video.module.a.a aVar = MBridgeVideoView.this.notifyListener;
                        if (aVar != null) {
                            aVar.a(5, num);
                        }
                        d.a().a("m_sound_click", MBridgeVideoView.this.f12294b, eVar);
                    }
                });
            }
            this.f12511t.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    try {
                        e eVar = new e();
                        eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1);
                        d.a().a("2000152", eVar);
                        d.a().a("2000148", MBridgeVideoView.this.f12294b, eVar);
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            e5.printStackTrace();
                        }
                    }
                    if (MBridgeVideoView.this.am) {
                        boolean unused = MBridgeVideoView.this.aB = true;
                        CampaignEx campaignEx = MBridgeVideoView.this.f12294b;
                        if (campaignEx != null && campaignEx.getRewardTemplateMode() != null && MBridgeVideoView.this.f12294b.getRewardTemplateMode().f() == 5002010 && MBridgeVideoView.this.ay) {
                            MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                            if (mBridgeVideoView.notifyListener != null) {
                                boolean unused2 = mBridgeVideoView.aS = true;
                                MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
                                mBridgeVideoView2.notifyListener.a(2, mBridgeVideoView2.b(mBridgeVideoView2.ay));
                            }
                        } else if (!MBridgeVideoView.this.ax) {
                            com.mbridge.msdk.video.module.a.a aVar = MBridgeVideoView.this.notifyListener;
                            if (aVar != null) {
                                aVar.a(123, "");
                            }
                        } else {
                            MBridgeVideoView.this.e();
                        }
                    } else {
                        CampaignEx campaignEx2 = MBridgeVideoView.this.f12294b;
                        if (campaignEx2 == null || campaignEx2.getRewardTemplateMode() == null || MBridgeVideoView.this.f12294b.getRewardTemplateMode().f() != 5002010 || !MBridgeVideoView.this.ay) {
                            MBridgeVideoView.this.e();
                            return;
                        }
                        MBridgeVideoView mBridgeVideoView3 = MBridgeVideoView.this;
                        if (mBridgeVideoView3.notifyListener != null) {
                            boolean unused3 = mBridgeVideoView3.aS = true;
                            MBridgeVideoView mBridgeVideoView4 = MBridgeVideoView.this;
                            mBridgeVideoView4.notifyListener.a(2, mBridgeVideoView4.b(mBridgeVideoView4.ay));
                        }
                    }
                }
            });
        }
    }

    private String a(int i5, int i6) {
        if (i6 != 0) {
            double d5 = (double) (((float) i5) / ((float) i6));
            try {
                return ak.a(Double.valueOf(d5)) + "";
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return i6 + "";
    }

    private void a(String str) {
        com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(str, new com.mbridge.msdk.foundation.same.c.c() {
            public final void onFailedLoad(String str, String str2) {
                af.b(MBridgeBaseView.TAG, str);
            }

            public final void onSuccessLoad(final Bitmap bitmap, String str) {
                if (bitmap != null) {
                    try {
                        if (!bitmap.isRecycled() && MBridgeVideoView.this.f12513v != null) {
                            com.mbridge.msdk.foundation.same.f.a.a().execute(new Runnable() {
                                public final void run() {
                                    try {
                                        final Bitmap a5 = p.a(bitmap, 10);
                                        MBridgeVideoView.this.f12513v.post(new Runnable() {
                                            public final void run() {
                                                MBridgeVideoView.this.f12513v.setVisibility(0);
                                                MBridgeVideoView.this.f12513v.setImageBitmap(a5);
                                            }
                                        });
                                    } catch (Exception e5) {
                                        af.b(MBridgeBaseView.TAG, e5.getMessage());
                                    }
                                }
                            });
                        }
                    } catch (Throwable th) {
                        af.b(MBridgeBaseView.TAG, th.getMessage());
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public String b(boolean z4) {
        if (!this.am) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (!this.au) {
                jSONObject.put("Alert_window_status", com.mbridge.msdk.foundation.same.a.f9163F);
            }
            if (this.aw) {
                jSONObject.put("Alert_window_status", com.mbridge.msdk.foundation.same.a.f9161D);
            }
            if (this.av) {
                jSONObject.put("Alert_window_status", com.mbridge.msdk.foundation.same.a.f9162E);
            }
            jSONObject.put("complete_info", z4 ? 1 : 2);
            return jSONObject.toString();
        } catch (Exception unused) {
            af.b(MBridgeBaseView.TAG, "getIVRewardStatusString ERROR");
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0081 A[SYNTHETIC, Splitter:B:28:0x0081] */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.mbridge.msdk.video.module.MBridgeVideoView r8, java.lang.String r9) {
        /*
            com.mbridge.msdk.video.module.a.a r0 = r8.f12487A
            if (r0 == 0) goto L_0x009e
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r8.f12294b
            if (r0 == 0) goto L_0x0056
            r1 = 1
            r0.setClickTempSource(r1)
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r8.f12294b     // Catch:{ Exception -> 0x002b }
            com.mbridge.msdk.foundation.entity.CampaignEx$c r0 = r0.getRewardTemplateMode()     // Catch:{ Exception -> 0x002b }
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0029
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002b }
            r2.<init>()     // Catch:{ Exception -> 0x002b }
            int r0 = r0.f()     // Catch:{ Exception -> 0x002b }
            r2.append(r0)     // Catch:{ Exception -> 0x002b }
            r2.append(r1)     // Catch:{ Exception -> 0x002b }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x002b }
        L_0x0029:
            r7 = r1
            goto L_0x002e
        L_0x002b:
            r0 = move-exception
            r9 = r0
            goto L_0x0053
        L_0x002e:
            android.content.Context r0 = r8.f12293a     // Catch:{ Exception -> 0x002b }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r8.f12294b     // Catch:{ Exception -> 0x002b }
            java.lang.String r2 = r1.getCampaignUnitId()     // Catch:{ Exception -> 0x002b }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r8.f12294b     // Catch:{ Exception -> 0x002b }
            boolean r3 = r1.isBidCampaign()     // Catch:{ Exception -> 0x002b }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r8.f12294b     // Catch:{ Exception -> 0x002b }
            java.lang.String r4 = r1.getRequestId()     // Catch:{ Exception -> 0x002b }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r8.f12294b     // Catch:{ Exception -> 0x002b }
            java.lang.String r5 = r1.getRequestIdNotice()     // Catch:{ Exception -> 0x002b }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r8.f12294b     // Catch:{ Exception -> 0x002b }
            java.lang.String r6 = r1.getId()     // Catch:{ Exception -> 0x002b }
            r1 = r9
            com.mbridge.msdk.foundation.same.report.i.a(r0, r1, r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x002b }
            goto L_0x0056
        L_0x0053:
            r9.printStackTrace()
        L_0x0056:
            r9 = 0
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x006a }
            r1.<init>()     // Catch:{ JSONException -> 0x006a }
            java.lang.String r9 = com.mbridge.msdk.foundation.same.a.f9191j     // Catch:{ JSONException -> 0x0067 }
            r0 = 0
            org.json.JSONObject r0 = r8.a(r0)     // Catch:{ JSONException -> 0x0067 }
            r1.put(r9, r0)     // Catch:{ JSONException -> 0x0067 }
            goto L_0x0070
        L_0x0067:
            r0 = move-exception
        L_0x0068:
            r9 = r0
            goto L_0x006d
        L_0x006a:
            r0 = move-exception
            r1 = r9
            goto L_0x0068
        L_0x006d:
            r9.printStackTrace()
        L_0x0070:
            com.mbridge.msdk.video.module.a.a r9 = r8.f12487A
            r0 = 105(0x69, float:1.47E-43)
            r9.a(r0, r1)
            com.mbridge.msdk.foundation.controller.c r9 = com.mbridge.msdk.foundation.controller.c.m()
            android.content.Context r9 = r9.c()
            if (r9 == 0) goto L_0x009e
            com.mbridge.msdk.foundation.controller.c r9 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x0093 }
            android.content.Context r9 = r9.c()     // Catch:{ Exception -> 0x0093 }
            android.content.Context r9 = r9.getApplicationContext()     // Catch:{ Exception -> 0x0093 }
            com.mbridge.msdk.foundation.entity.CampaignEx r8 = r8.f12294b     // Catch:{ Exception -> 0x0093 }
            com.mbridge.msdk.video.module.b.b.d(r9, r8)     // Catch:{ Exception -> 0x0093 }
            goto L_0x009e
        L_0x0093:
            r0 = move-exception
            r8 = r0
            java.lang.String r9 = "MBridgeBaseView"
            java.lang.String r8 = r8.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r9, r8)
        L_0x009e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeVideoView.a(com.mbridge.msdk.video.module.MBridgeVideoView, java.lang.String):void");
    }

    static /* synthetic */ void b(MBridgeVideoView mBridgeVideoView) {
        CampaignEx campaignEx = mBridgeVideoView.f12294b;
        if (campaignEx != null && campaignEx.isDynamicView() && mBridgeVideoView.f12494H != null) {
            if (mBridgeVideoView.f12495I == null) {
                mBridgeVideoView.addCTAView();
            }
            if (mBridgeVideoView.f12494H.getVisibility() != 0) {
                mBridgeVideoView.f12494H.setVisibility(0);
                mBridgeVideoView.postDelayed(mBridgeVideoView.aW, 3000);
                return;
            }
            mBridgeVideoView.f12494H.setVisibility(8);
            mBridgeVideoView.getHandler().removeCallbacks(mBridgeVideoView.aW);
        }
    }

    public MBridgeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
