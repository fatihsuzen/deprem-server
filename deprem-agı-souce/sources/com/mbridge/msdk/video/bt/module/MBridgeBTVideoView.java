package com.mbridge.msdk.video.bt.module;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.dycreator.baseview.cusview.SoundImageView;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.ap;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener;
import com.mbridge.msdk.playercommon.PlayerErrorConstant;
import com.mbridge.msdk.playercommon.PlayerView;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.video.bt.a.d;
import com.mbridge.msdk.widget.FeedBackButton;
import java.io.File;
import org.json.JSONObject;
import u1.b;
import u1.h;

public class MBridgeBTVideoView extends BTBaseView {
    /* access modifiers changed from: private */

    /* renamed from: K  reason: collision with root package name */
    public static boolean f11951K = false;
    /* access modifiers changed from: private */

    /* renamed from: Q  reason: collision with root package name */
    public static long f11952Q;

    /* renamed from: A  reason: collision with root package name */
    private b f11953A;

    /* renamed from: B  reason: collision with root package name */
    private u1.a f11954B;
    /* access modifiers changed from: private */

    /* renamed from: C  reason: collision with root package name */
    public v1.b f11955C;

    /* renamed from: D  reason: collision with root package name */
    private a f11956D;
    /* access modifiers changed from: private */

    /* renamed from: E  reason: collision with root package name */
    public int f11957E = 2;

    /* renamed from: F  reason: collision with root package name */
    private int f11958F;

    /* renamed from: G  reason: collision with root package name */
    private boolean f11959G = false;

    /* renamed from: H  reason: collision with root package name */
    private int f11960H = 2;

    /* renamed from: I  reason: collision with root package name */
    private int f11961I = 1;

    /* renamed from: J  reason: collision with root package name */
    private String f11962J;

    /* renamed from: L  reason: collision with root package name */
    private boolean f11963L = false;

    /* renamed from: M  reason: collision with root package name */
    private boolean f11964M = false;

    /* renamed from: N  reason: collision with root package name */
    private boolean f11965N = false;

    /* renamed from: O  reason: collision with root package name */
    private RelativeLayout f11966O;
    /* access modifiers changed from: private */

    /* renamed from: P  reason: collision with root package name */
    public ProgressBar f11967P;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public PlayerView f11968p;

    /* renamed from: q  reason: collision with root package name */
    private SoundImageView f11969q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public TextView f11970r;

    /* renamed from: s  reason: collision with root package name */
    private View f11971s;

    /* renamed from: t  reason: collision with root package name */
    private FeedBackButton f11972t;

    /* renamed from: u  reason: collision with root package name */
    private ImageView f11973u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public WebView f11974v;

    /* renamed from: w  reason: collision with root package name */
    private com.mbridge.msdk.videocommon.download.a f11975w;

    /* renamed from: x  reason: collision with root package name */
    private int f11976x = 0;

    /* renamed from: y  reason: collision with root package name */
    private int f11977y = 0;

    /* renamed from: z  reason: collision with root package name */
    private int f11978z = 0;

    private static final class a extends DefaultVideoPlayerStatusListener {

        /* renamed from: a  reason: collision with root package name */
        private MBridgeBTVideoView f11982a;

        /* renamed from: b  reason: collision with root package name */
        private WebView f11983b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public v1.b f11984c;

        /* renamed from: d  reason: collision with root package name */
        private String f11985d;

        /* renamed from: e  reason: collision with root package name */
        private String f11986e;

        /* renamed from: f  reason: collision with root package name */
        private int f11987f;

        /* renamed from: g  reason: collision with root package name */
        private int f11988g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f11989h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f11990i = false;

        /* renamed from: j  reason: collision with root package name */
        private boolean f11991j = false;

        /* renamed from: k  reason: collision with root package name */
        private boolean f11992k = false;

        /* renamed from: l  reason: collision with root package name */
        private int f11993l;

        /* renamed from: m  reason: collision with root package name */
        private int f11994m;

        /* renamed from: n  reason: collision with root package name */
        private boolean f11995n = false;

        /* renamed from: o  reason: collision with root package name */
        private boolean f11996o = false;

        public a(MBridgeBTVideoView mBridgeBTVideoView, WebView webView, v1.b bVar) {
            this.f11982a = mBridgeBTVideoView;
            this.f11983b = webView;
            this.f11984c = bVar;
            if (mBridgeBTVideoView != null) {
                this.f11985d = mBridgeBTVideoView.f11822d;
                this.f11986e = mBridgeBTVideoView.f11821c;
            }
        }

        public final void onBufferingEnd() {
            try {
                super.onBufferingEnd();
                if (this.f11984c != null && this.f11996o) {
                    af.b("omsdk", "bt onBufferingEnd");
                    this.f11996o = false;
                    this.f11984c.b();
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }

        public final void onBufferingStart(String str) {
            try {
                af.b("omsdk", "bt onBufferingStart1");
                super.onBufferingStart(str);
                if (this.f11984c != null) {
                    af.b("omsdk", "bt onBufferingStart");
                    this.f11984c.c();
                    this.f11996o = true;
                }
                if ((str.equals(PlayerErrorConstant.PREPARE_TIMEOUT) || str.equals(PlayerErrorConstant.PLAYERING_TIMEOUT)) && this.f11983b != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", BTBaseView.f11817n);
                        jSONObject.put("id", this.f11985d);
                        jSONObject.put(DataSchemeDataSource.SCHEME_DATA, new JSONObject());
                        g.a().a(this.f11983b, "onPlayerTimeout", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e5) {
                        d.c().a(this.f11983b, e5.getMessage());
                    }
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }

        public final void onPlayCompleted() {
            super.onPlayCompleted();
            MBridgeBTVideoView mBridgeBTVideoView = this.f11982a;
            CampaignEx campaignEx = mBridgeBTVideoView.f11820b;
            if (campaignEx == null) {
                mBridgeBTVideoView.f11970r.setText("0");
            } else if (campaignEx.getVideoCompleteTime() > 0) {
                this.f11982a.f11970r.setText(x.a(c.m().c(), "mbridge_reward_video_view_reward_time_complete", TypedValues.Custom.S_STRING));
            } else {
                this.f11982a.f11970r.setText("0");
            }
            this.f11982a.f11968p.setClickable(false);
            WebView webView = this.f11983b;
            if (webView != null) {
                BTBaseView.a(webView, "onPlayerFinish", this.f11985d);
            }
            v1.b bVar = this.f11984c;
            if (bVar != null) {
                bVar.d();
                af.a("omsdk", "play:  videoEvents.complete()");
            }
            this.f11987f = this.f11988g;
            boolean unused = MBridgeBTVideoView.f11951K = true;
            this.f11982a.stop();
        }

        public final void onPlayError(String str) {
            super.onPlayError(str);
            if (this.f11983b != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", BTBaseView.f11818o);
                    jSONObject.put("id", this.f11985d);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, str);
                    jSONObject2.put("id", this.f11985d);
                    jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                    g.a().a(this.f11983b, "onPlayerFailed", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e5) {
                    d.c().a(this.f11983b, e5.getMessage());
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x02c7 A[Catch:{ Exception -> 0x028f }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onPlayProgress(int r11, int r12) {
            /*
                r10 = this;
                java.lang.String r0 = "DefaultVideoPlayerStatusListener"
                java.lang.String r1 = "id"
                super.onPlayProgress(r11, r12)
                long r2 = com.mbridge.msdk.video.bt.module.MBridgeBTVideoView.f11952Q
                r4 = 0
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 != 0) goto L_0x0018
                long r2 = java.lang.System.currentTimeMillis()
                long unused = com.mbridge.msdk.video.bt.module.MBridgeBTVideoView.f11952Q = r2
            L_0x0018:
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r2 = r10.f11982a
                boolean r3 = r2.f11826h
                r4 = 287(0x11f, float:4.02E-43)
                r5 = 1
                if (r3 == 0) goto L_0x016c
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = r2.f11820b
                if (r2 == 0) goto L_0x004d
                int r2 = r2.getVideoCompleteTime()
                com.mbridge.msdk.foundation.d.b r3 = com.mbridge.msdk.foundation.d.b.a()
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r7 = r10.f11982a
                com.mbridge.msdk.foundation.entity.CampaignEx r7 = r7.f11820b
                java.lang.String r7 = r7.getCampaignUnitId()
                r6.append(r7)
                java.lang.String r7 = "_"
                r6.append(r7)
                r6.append(r5)
                java.lang.String r6 = r6.toString()
                r3.b(r6, r11)
                goto L_0x004e
            L_0x004d:
                r2 = 0
            L_0x004e:
                if (r2 > r12) goto L_0x0052
                if (r2 > 0) goto L_0x0053
            L_0x0052:
                r2 = r12
            L_0x0053:
                if (r2 > 0) goto L_0x0058
                int r3 = r12 - r11
                goto L_0x005a
            L_0x0058:
                int r3 = r2 - r11
            L_0x005a:
                java.lang.String r6 = "string"
                if (r3 > 0) goto L_0x0082
                if (r2 > 0) goto L_0x0063
                java.lang.String r3 = "0"
                goto L_0x00bb
            L_0x0063:
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r3 = r10.f11982a
                android.content.Context r3 = r3.getContext()
                android.content.res.Resources r3 = r3.getResources()
                com.mbridge.msdk.foundation.controller.c r7 = com.mbridge.msdk.foundation.controller.c.m()
                android.content.Context r7 = r7.c()
                java.lang.String r8 = "mbridge_reward_video_view_reward_time_complete"
                int r7 = com.mbridge.msdk.foundation.tools.x.a(r7, r8, r6)
                java.lang.CharSequence r3 = r3.getText(r7)
                java.lang.String r3 = (java.lang.String) r3
                goto L_0x00bb
            L_0x0082:
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                if (r2 > 0) goto L_0x0096
                r7.<init>()
                r7.append(r3)
                java.lang.String r3 = ""
            L_0x008e:
                r7.append(r3)
                java.lang.String r3 = r7.toString()
                goto L_0x00bb
            L_0x0096:
                r7.<init>()
                r7.append(r3)
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r3 = r10.f11982a
                android.content.Context r3 = r3.getContext()
                android.content.res.Resources r3 = r3.getResources()
                com.mbridge.msdk.foundation.controller.c r8 = com.mbridge.msdk.foundation.controller.c.m()
                android.content.Context r8 = r8.c()
                java.lang.String r9 = "mbridge_reward_video_view_reward_time_left"
                int r8 = com.mbridge.msdk.foundation.tools.x.a(r8, r9, r6)
                java.lang.CharSequence r3 = r3.getText(r8)
                java.lang.String r3 = (java.lang.String) r3
                goto L_0x008e
            L_0x00bb:
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r7 = r10.f11982a
                com.mbridge.msdk.foundation.entity.CampaignEx r7 = r7.f11820b
                if (r7 == 0) goto L_0x0163
                int r7 = r7.getUseSkipTime()
                if (r7 != r5) goto L_0x0163
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r7 = r10.f11982a
                com.mbridge.msdk.foundation.entity.CampaignEx r7 = r7.f11820b
                int r7 = r7.getVst()
                int r7 = java.lang.Math.min(r7, r12)
                r8 = 4
                java.lang.String r9 = "mbridge_reward_video_view_reward_time_left_skip_time"
                if (r7 >= r2) goto L_0x011f
                if (r7 < 0) goto L_0x011f
                int r7 = r7 - r11
                if (r7 <= 0) goto L_0x0109
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r2.append(r7)
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r3 = r10.f11982a
                android.content.Context r3 = r3.getContext()
                android.content.res.Resources r3 = r3.getResources()
                com.mbridge.msdk.foundation.controller.c r7 = com.mbridge.msdk.foundation.controller.c.m()
                android.content.Context r7 = r7.c()
                int r6 = com.mbridge.msdk.foundation.tools.x.a(r7, r9, r6)
                java.lang.CharSequence r3 = r3.getText(r6)
                java.lang.String r3 = (java.lang.String) r3
                r2.append(r3)
                java.lang.String r3 = r2.toString()
                goto L_0x0163
            L_0x0109:
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r2 = r10.f11982a
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = r2.f11820b
                int r2 = r2.getAdType()
                if (r2 != r4) goto L_0x0163
                if (r7 != 0) goto L_0x0163
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r2 = r10.f11982a
                android.widget.TextView r2 = r2.f11970r
                r2.setVisibility(r8)
                goto L_0x0163
            L_0x011f:
                int r2 = r2 - r11
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r7 = r10.f11982a
                com.mbridge.msdk.foundation.entity.CampaignEx r7 = r7.f11820b
                int r7 = r7.getAdType()
                if (r7 != r4) goto L_0x0163
                if (r2 <= 0) goto L_0x0158
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r2)
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r2 = r10.f11982a
                android.content.Context r2 = r2.getContext()
                android.content.res.Resources r2 = r2.getResources()
                com.mbridge.msdk.foundation.controller.c r7 = com.mbridge.msdk.foundation.controller.c.m()
                android.content.Context r7 = r7.c()
                int r6 = com.mbridge.msdk.foundation.tools.x.a(r7, r9, r6)
                java.lang.CharSequence r2 = r2.getText(r6)
                java.lang.String r2 = (java.lang.String) r2
                r3.append(r2)
                java.lang.String r3 = r3.toString()
                goto L_0x0163
            L_0x0158:
                if (r2 != 0) goto L_0x0163
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r2 = r10.f11982a
                android.widget.TextView r2 = r2.f11970r
                r2.setVisibility(r8)
            L_0x0163:
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r2 = r10.f11982a
                android.widget.TextView r2 = r2.f11970r
                r2.setText(r3)
            L_0x016c:
                r10.f11988g = r12
                r10.f11987f = r11
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r2 = r10.f11982a
                android.widget.ProgressBar r2 = r2.f11967P
                int r3 = r10.f11988g
                r2.setMax(r3)
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r2 = r10.f11982a
                android.widget.ProgressBar r2 = r2.f11967P
                int r3 = r10.f11987f
                r2.setProgress(r3)
                android.webkit.WebView r2 = r10.f11983b
                if (r2 == 0) goto L_0x01ec
                org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x01de }
                r2.<init>()     // Catch:{ Exception -> 0x01de }
                java.lang.String r3 = "code"
                int r6 = com.mbridge.msdk.video.bt.module.BTBaseView.f11817n     // Catch:{ Exception -> 0x01de }
                r2.put(r3, r6)     // Catch:{ Exception -> 0x01de }
                java.lang.String r3 = r10.f11985d     // Catch:{ Exception -> 0x01de }
                r2.put(r1, r3)     // Catch:{ Exception -> 0x01de }
                org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x01de }
                r3.<init>()     // Catch:{ Exception -> 0x01de }
                java.lang.String r6 = r10.f11985d     // Catch:{ Exception -> 0x01de }
                r3.put(r1, r6)     // Catch:{ Exception -> 0x01de }
                java.lang.String r1 = "progress"
                java.lang.String r6 = com.mbridge.msdk.video.bt.module.MBridgeBTVideoView.b(r11, r12)     // Catch:{ Exception -> 0x01de }
                r3.put(r1, r6)     // Catch:{ Exception -> 0x01de }
                java.lang.String r1 = "time"
                java.lang.String r6 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x01de }
                r3.put(r1, r6)     // Catch:{ Exception -> 0x01de }
                java.lang.String r1 = "duration"
                java.lang.String r6 = java.lang.String.valueOf(r12)     // Catch:{ Exception -> 0x01de }
                r3.put(r1, r6)     // Catch:{ Exception -> 0x01de }
                java.lang.String r1 = "data"
                r2.put(r1, r3)     // Catch:{ Exception -> 0x01de }
                com.mbridge.msdk.mbsignalcommon.windvane.g r1 = com.mbridge.msdk.mbsignalcommon.windvane.g.a()     // Catch:{ Exception -> 0x01de }
                android.webkit.WebView r3 = r10.f11983b     // Catch:{ Exception -> 0x01de }
                java.lang.String r6 = "onPlayerProgressChanged"
                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x01de }
                byte[] r2 = r2.getBytes()     // Catch:{ Exception -> 0x01de }
                r7 = 2
                java.lang.String r2 = android.util.Base64.encodeToString(r2, r7)     // Catch:{ Exception -> 0x01de }
                r1.a((android.webkit.WebView) r3, (java.lang.String) r6, (java.lang.String) r2)     // Catch:{ Exception -> 0x01de }
                goto L_0x01ec
            L_0x01de:
                r1 = move-exception
                com.mbridge.msdk.video.bt.a.d r2 = com.mbridge.msdk.video.bt.a.d.c()
                android.webkit.WebView r3 = r10.f11983b
                java.lang.String r1 = r1.getMessage()
                r2.a((android.webkit.WebView) r3, (java.lang.String) r1)
            L_0x01ec:
                v1.b r1 = r10.f11984c
                r2 = 100
                if (r1 == 0) goto L_0x0239
                int r3 = r11 * 100
                int r3 = r3 / r12
                int r6 = r11 + 1
                int r6 = r6 * r2
                int r6 = r6 / r12
                r7 = 25
                java.lang.String r8 = "omsdk"
                if (r3 > r7) goto L_0x0210
                if (r7 >= r6) goto L_0x0210
                boolean r7 = r10.f11990i
                if (r7 != 0) goto L_0x0210
                r10.f11990i = r5
                r1.h()
                java.lang.String r1 = "play:  videoEvents.firstQuartile()"
                com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r8, (java.lang.String) r1)
                goto L_0x0239
            L_0x0210:
                r7 = 50
                if (r3 > r7) goto L_0x0225
                if (r7 >= r6) goto L_0x0225
                boolean r7 = r10.f11991j
                if (r7 != 0) goto L_0x0225
                r10.f11991j = r5
                r1.i()
                java.lang.String r1 = "play:  videoEvents.midpoint()"
                com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r8, (java.lang.String) r1)
                goto L_0x0239
            L_0x0225:
                r7 = 75
                if (r3 > r7) goto L_0x0239
                if (r7 >= r6) goto L_0x0239
                boolean r3 = r10.f11992k
                if (r3 != 0) goto L_0x0239
                r10.f11992k = r5
                r1.n()
                java.lang.String r1 = "play:  videoEvents.thirdQuartile()"
                com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r8, (java.lang.String) r1)
            L_0x0239:
                int r1 = r10.f11993l     // Catch:{ Exception -> 0x028f }
                if (r1 == r2) goto L_0x02ed
                boolean r3 = r10.f11995n     // Catch:{ Exception -> 0x028f }
                if (r3 != 0) goto L_0x02ed
                if (r1 != 0) goto L_0x0245
                goto L_0x02ed
            L_0x0245:
                int r1 = r10.f11994m     // Catch:{ Exception -> 0x028f }
                if (r1 < 0) goto L_0x02ed
                int r12 = r12 * r1
                int r12 = r12 / r2
                if (r11 < r12) goto L_0x02ed
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r11 = r10.f11982a     // Catch:{ Exception -> 0x028f }
                com.mbridge.msdk.foundation.entity.CampaignEx r11 = r11.f11820b     // Catch:{ Exception -> 0x028f }
                int r11 = r11.getAdType()     // Catch:{ Exception -> 0x028f }
                r1 = 94
                if (r11 == r1) goto L_0x0291
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r11 = r10.f11982a     // Catch:{ Exception -> 0x028f }
                com.mbridge.msdk.foundation.entity.CampaignEx r11 = r11.f11820b     // Catch:{ Exception -> 0x028f }
                int r11 = r11.getAdType()     // Catch:{ Exception -> 0x028f }
                if (r11 != r4) goto L_0x0264
                goto L_0x0291
            L_0x0264:
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x028f }
                r11.<init>()     // Catch:{ Exception -> 0x028f }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r1 = r10.f11982a     // Catch:{ Exception -> 0x028f }
                com.mbridge.msdk.foundation.entity.CampaignEx r1 = r1.f11820b     // Catch:{ Exception -> 0x028f }
                java.lang.String r1 = r1.getId()     // Catch:{ Exception -> 0x028f }
                r11.append(r1)     // Catch:{ Exception -> 0x028f }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r1 = r10.f11982a     // Catch:{ Exception -> 0x028f }
                com.mbridge.msdk.foundation.entity.CampaignEx r1 = r1.f11820b     // Catch:{ Exception -> 0x028f }
                java.lang.String r1 = r1.getVideoUrlEncode()     // Catch:{ Exception -> 0x028f }
                r11.append(r1)     // Catch:{ Exception -> 0x028f }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r1 = r10.f11982a     // Catch:{ Exception -> 0x028f }
                com.mbridge.msdk.foundation.entity.CampaignEx r1 = r1.f11820b     // Catch:{ Exception -> 0x028f }
                java.lang.String r1 = r1.getBidToken()     // Catch:{ Exception -> 0x028f }
                r11.append(r1)     // Catch:{ Exception -> 0x028f }
                java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x028f }
                goto L_0x02bb
            L_0x028f:
                r11 = move-exception
                goto L_0x02e6
            L_0x0291:
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x028f }
                r11.<init>()     // Catch:{ Exception -> 0x028f }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r1 = r10.f11982a     // Catch:{ Exception -> 0x028f }
                com.mbridge.msdk.foundation.entity.CampaignEx r1 = r1.f11820b     // Catch:{ Exception -> 0x028f }
                java.lang.String r1 = r1.getRequestId()     // Catch:{ Exception -> 0x028f }
                r11.append(r1)     // Catch:{ Exception -> 0x028f }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r1 = r10.f11982a     // Catch:{ Exception -> 0x028f }
                com.mbridge.msdk.foundation.entity.CampaignEx r1 = r1.f11820b     // Catch:{ Exception -> 0x028f }
                java.lang.String r1 = r1.getId()     // Catch:{ Exception -> 0x028f }
                r11.append(r1)     // Catch:{ Exception -> 0x028f }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r1 = r10.f11982a     // Catch:{ Exception -> 0x028f }
                com.mbridge.msdk.foundation.entity.CampaignEx r1 = r1.f11820b     // Catch:{ Exception -> 0x028f }
                java.lang.String r1 = r1.getVideoUrlEncode()     // Catch:{ Exception -> 0x028f }
                r11.append(r1)     // Catch:{ Exception -> 0x028f }
                java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x028f }
            L_0x02bb:
                com.mbridge.msdk.videocommon.download.b r1 = com.mbridge.msdk.videocommon.download.b.getInstance()     // Catch:{ Exception -> 0x028f }
                java.lang.String r2 = r10.f11986e     // Catch:{ Exception -> 0x028f }
                com.mbridge.msdk.videocommon.download.a r11 = r1.a((java.lang.String) r2, (java.lang.String) r11)     // Catch:{ Exception -> 0x028f }
                if (r11 == 0) goto L_0x02ed
                r11.p()     // Catch:{ Exception -> 0x028f }
                r10.f11995n = r5     // Catch:{ Exception -> 0x028f }
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x028f }
                r11.<init>()     // Catch:{ Exception -> 0x028f }
                java.lang.String r1 = "CDRate is : "
                r11.append(r1)     // Catch:{ Exception -> 0x028f }
                r11.append(r12)     // Catch:{ Exception -> 0x028f }
                java.lang.String r12 = " and start download !"
                r11.append(r12)     // Catch:{ Exception -> 0x028f }
                java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x028f }
                com.mbridge.msdk.foundation.tools.af.b(r0, r11)     // Catch:{ Exception -> 0x028f }
                goto L_0x02ed
            L_0x02e6:
                java.lang.String r11 = r11.getMessage()
                com.mbridge.msdk.foundation.tools.af.b(r0, r11)
            L_0x02ed:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.module.MBridgeBTVideoView.a.onPlayProgress(int, int):void");
        }

        public final void onPlaySetDataSourceError(String str) {
            super.onPlaySetDataSourceError(str);
        }

        public final void onPlayStarted(int i5) {
            float f5;
            super.onPlayStarted(i5);
            if (!this.f11989h) {
                this.f11982a.f11967P.setMax(i5);
                WebView webView = this.f11983b;
                if (webView != null) {
                    BTBaseView.a(webView, "onPlayerPlay", this.f11985d);
                }
                this.f11989h = true;
                if (this.f11984c != null) {
                    try {
                        MBridgeBTVideoView mBridgeBTVideoView = this.f11982a;
                        if (mBridgeBTVideoView == null || mBridgeBTVideoView.f11968p == null) {
                            f5 = 0.0f;
                        } else {
                            f5 = this.f11982a.f11968p.getVolume();
                        }
                        this.f11984c.m((float) i5, f5);
                        af.a("omsdk", "play2: videoEvents.start()");
                    } catch (Exception e5) {
                        af.b("omsdk", e5.getMessage());
                    }
                }
            }
            boolean unused = MBridgeBTVideoView.f11951K = false;
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x00a7 A[Catch:{ Exception -> 0x006f }] */
        /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(int r3, int r4) {
            /*
                r2 = this;
                java.lang.String r0 = "DefaultVideoPlayerStatusListener"
                r2.f11993l = r3
                r2.f11994m = r4
                com.mbridge.msdk.foundation.tools.ah r3 = com.mbridge.msdk.foundation.tools.ah.a()
                java.lang.String r4 = "h_c_r_w_p_c"
                r1 = 0
                boolean r3 = r3.a((java.lang.String) r4, (boolean) r1)
                if (r3 != 0) goto L_0x0015
                goto L_0x00c2
            L_0x0015:
                int r3 = r2.f11993l
                r4 = 100
                if (r3 == r4) goto L_0x00c2
                int r4 = r2.f11994m
                if (r4 != 0) goto L_0x00c2
                boolean r4 = r2.f11995n
                if (r4 != 0) goto L_0x00c2
                if (r3 == 0) goto L_0x00c2
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r3 = r2.f11982a
                if (r3 == 0) goto L_0x00c2
                com.mbridge.msdk.foundation.entity.CampaignEx r3 = r3.f11820b
                if (r3 != 0) goto L_0x002f
                goto L_0x00c2
            L_0x002f:
                int r3 = r3.getAdType()     // Catch:{ Exception -> 0x006f }
                r4 = 94
                if (r3 == r4) goto L_0x0071
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r3 = r2.f11982a     // Catch:{ Exception -> 0x006f }
                com.mbridge.msdk.foundation.entity.CampaignEx r3 = r3.f11820b     // Catch:{ Exception -> 0x006f }
                int r3 = r3.getAdType()     // Catch:{ Exception -> 0x006f }
                r4 = 287(0x11f, float:4.02E-43)
                if (r3 != r4) goto L_0x0044
                goto L_0x0071
            L_0x0044:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x006f }
                r3.<init>()     // Catch:{ Exception -> 0x006f }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r4 = r2.f11982a     // Catch:{ Exception -> 0x006f }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r4.f11820b     // Catch:{ Exception -> 0x006f }
                java.lang.String r4 = r4.getId()     // Catch:{ Exception -> 0x006f }
                r3.append(r4)     // Catch:{ Exception -> 0x006f }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r4 = r2.f11982a     // Catch:{ Exception -> 0x006f }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r4.f11820b     // Catch:{ Exception -> 0x006f }
                java.lang.String r4 = r4.getVideoUrlEncode()     // Catch:{ Exception -> 0x006f }
                r3.append(r4)     // Catch:{ Exception -> 0x006f }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r4 = r2.f11982a     // Catch:{ Exception -> 0x006f }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r4.f11820b     // Catch:{ Exception -> 0x006f }
                java.lang.String r4 = r4.getBidToken()     // Catch:{ Exception -> 0x006f }
                r3.append(r4)     // Catch:{ Exception -> 0x006f }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x006f }
                goto L_0x009b
            L_0x006f:
                r3 = move-exception
                goto L_0x00b7
            L_0x0071:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x006f }
                r3.<init>()     // Catch:{ Exception -> 0x006f }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r4 = r2.f11982a     // Catch:{ Exception -> 0x006f }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r4.f11820b     // Catch:{ Exception -> 0x006f }
                java.lang.String r4 = r4.getRequestId()     // Catch:{ Exception -> 0x006f }
                r3.append(r4)     // Catch:{ Exception -> 0x006f }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r4 = r2.f11982a     // Catch:{ Exception -> 0x006f }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r4.f11820b     // Catch:{ Exception -> 0x006f }
                java.lang.String r4 = r4.getId()     // Catch:{ Exception -> 0x006f }
                r3.append(r4)     // Catch:{ Exception -> 0x006f }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r4 = r2.f11982a     // Catch:{ Exception -> 0x006f }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r4.f11820b     // Catch:{ Exception -> 0x006f }
                java.lang.String r4 = r4.getVideoUrlEncode()     // Catch:{ Exception -> 0x006f }
                r3.append(r4)     // Catch:{ Exception -> 0x006f }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x006f }
            L_0x009b:
                com.mbridge.msdk.videocommon.download.b r4 = com.mbridge.msdk.videocommon.download.b.getInstance()     // Catch:{ Exception -> 0x006f }
                java.lang.String r1 = r2.f11986e     // Catch:{ Exception -> 0x006f }
                com.mbridge.msdk.videocommon.download.a r3 = r4.a((java.lang.String) r1, (java.lang.String) r3)     // Catch:{ Exception -> 0x006f }
                if (r3 == 0) goto L_0x00c2
                r3.p()     // Catch:{ Exception -> 0x006f }
                r3 = 1
                r2.f11995n = r3     // Catch:{ Exception -> 0x006f }
                boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x006f }
                if (r3 == 0) goto L_0x00c2
                java.lang.String r3 = "CDRate is : 0  and start download when player create!"
                com.mbridge.msdk.foundation.tools.af.b(r0, r3)     // Catch:{ Exception -> 0x006f }
                return
            L_0x00b7:
                boolean r4 = com.mbridge.msdk.MBridgeConstans.DEBUG
                if (r4 == 0) goto L_0x00c2
                java.lang.String r3 = r3.getMessage()
                com.mbridge.msdk.foundation.tools.af.b(r0, r3)
            L_0x00c2:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.module.MBridgeBTVideoView.a.a(int, int):void");
        }
    }

    public MBridgeBTVideoView(Context context) {
        super(context);
    }

    public u1.a getAdEvents() {
        return this.f11954B;
    }

    public b getAdSession() {
        return this.f11953A;
    }

    public int getMute() {
        return this.f11957E;
    }

    public v1.b getVideoEvents() {
        return this.f11955C;
    }

    public void init(Context context) {
        int findLayout = findLayout("mbridge_reward_videoview_item");
        if (findLayout > 0) {
            this.f11824f.inflate(findLayout, this);
            boolean c5 = c();
            this.f11826h = c5;
            if (!c5) {
                af.b(BTBaseView.TAG, "MBridgeVideoView init fail");
            }
            a();
        }
        f11951K = false;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        View rootView;
        int i5;
        int i6;
        super.onAttachedToWindow();
        if (!this.f11965N) {
            this.f11960H = d.c().e(this.f11821c);
        }
        View view = this.f11971s;
        int i7 = 0;
        if (view != null) {
            if (this.f11977y == 0) {
                i6 = 8;
            } else {
                i6 = 0;
            }
            view.setVisibility(i6);
        }
        SoundImageView soundImageView = this.f11969q;
        if (soundImageView != null) {
            if (this.f11978z == 0) {
                i5 = 8;
            } else {
                i5 = 0;
            }
            soundImageView.setVisibility(i5);
        }
        CampaignEx campaignEx = this.f11820b;
        if (campaignEx != null) {
            campaignEx.setCampaignUnitId(this.f11821c);
            com.mbridge.msdk.foundation.d.b.a().a(this.f11821c + "_" + 1, this.f11820b);
        }
        TextView textView = this.f11970r;
        if (textView != null) {
            if (this.f11976x == 0) {
                i7 = 8;
            }
            textView.setVisibility(i7);
            if (this.f11970r.getVisibility() == 0 && com.mbridge.msdk.foundation.d.b.a().b()) {
                com.mbridge.msdk.foundation.d.b.a().a(this.f11821c + "_" + 1, this.f11972t);
            }
        }
        if (this.f11953A != null && (rootView = getRootView()) != null) {
            this.f11953A.f(rootView);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onDestory() {
        try {
            if (this.f11968p != null) {
                b bVar = this.f11953A;
                if (bVar != null) {
                    bVar.c();
                }
                this.f11968p.setOnClickListener((View.OnClickListener) null);
                this.f11968p.release();
                this.f11968p = null;
                e eVar = new e();
                eVar.a(TypedValues.TransitionType.S_DURATION, Long.valueOf(System.currentTimeMillis() - f11952Q));
                com.mbridge.msdk.foundation.same.report.d.d.a().a("2000146", this.f11820b, eVar);
            }
            SoundImageView soundImageView = this.f11969q;
            if (soundImageView != null) {
                soundImageView.setOnClickListener((View.OnClickListener) null);
            }
            View view = this.f11971s;
            if (view != null) {
                view.setOnClickListener((View.OnClickListener) null);
            }
            if (this.f11974v != null) {
                this.f11974v = null;
            }
            if (this.f11953A != null) {
                this.f11953A = null;
            }
            if (this.f11955C != null) {
                this.f11955C = null;
            }
            setOnClickListener((View.OnClickListener) null);
        } catch (Throwable th) {
            af.a(BTBaseView.TAG, th.getMessage());
        }
    }

    public void onPause() {
        PlayerView playerView = this.f11968p;
        if (playerView != null) {
            boolean isPlayIng = playerView.isPlayIng();
            this.f11964M = isPlayIng;
            this.f11968p.setIsBTVideoPlaying(isPlayIng);
            v1.b bVar = this.f11955C;
            if (bVar != null) {
                this.f11968p.setVideoEvents(bVar);
            }
            this.f11968p.onPause();
        }
    }

    public void onResume() {
        PlayerView playerView = this.f11968p;
        if (playerView != null) {
            playerView.setDesk(true);
            this.f11968p.setIsCovered(false);
            if (this.f11964M) {
                this.f11968p.start(true);
            }
            this.f11968p.resumeOMSDK();
        }
    }

    public void onStop() {
        PlayerView playerView = this.f11968p;
        if (playerView != null) {
            playerView.setIsCovered(true);
        }
    }

    public void pause() {
        try {
            PlayerView playerView = this.f11968p;
            if (playerView != null) {
                playerView.pause();
                WebView webView = this.f11974v;
                if (webView != null) {
                    BTBaseView.a(webView, "onPlayerPause", this.f11822d);
                }
            }
        } catch (Exception e5) {
            af.b(BTBaseView.TAG, e5.getMessage(), e5);
        }
    }

    public void play() {
        a aVar;
        try {
            if (!this.f11965N) {
                String d5 = d();
                this.f11962J = d5;
                this.f11968p.initVFPData(d5, this.f11820b.getVideoUrlEncode(), this.f11956D);
                if (this.f11960H == 1) {
                    playMute();
                } else {
                    playUnMute();
                }
                try {
                    if (this.f11954B != null) {
                        af.b("omsdk", "bt impressionOccurred");
                        this.f11954B.b();
                    }
                } catch (Throwable th) {
                    af.a(BTBaseView.TAG, th.getMessage());
                }
                if (!this.f11968p.playVideo() && (aVar = this.f11956D) != null) {
                    aVar.onPlayError("play video failed");
                }
                this.f11965N = true;
                return;
            }
            if (this.f11959G) {
                this.f11968p.playVideo(0);
                this.f11959G = false;
            } else {
                this.f11968p.start(false);
            }
            try {
                v1.b bVar = this.f11955C;
                if (bVar != null) {
                    bVar.k();
                    af.a("omsdk", "btv play2:  videoEvents.resume()");
                }
            } catch (Throwable th2) {
                af.a(BTBaseView.TAG, th2.getMessage());
            }
            WebView webView = this.f11974v;
            if (webView != null) {
                BTBaseView.a(webView, "onPlayerPlay", this.f11822d);
            }
        } catch (Exception e5) {
            af.b(BTBaseView.TAG, e5.getMessage(), e5);
        }
    }

    public boolean playMute() {
        try {
            PlayerView playerView = this.f11968p;
            if (!(playerView == null || this.f11974v == null)) {
                playerView.closeSound();
                this.f11969q.setSoundStatus(false);
                this.f11957E = 1;
                try {
                    v1.b bVar = this.f11955C;
                    if (bVar != null) {
                        bVar.o(0.0f);
                    }
                } catch (Exception e5) {
                    af.a("OMSDK", e5.getMessage());
                }
                BTBaseView.a(this.f11974v, "onPlayerMute", this.f11822d);
                return true;
            }
        } catch (Exception e6) {
            af.b(BTBaseView.TAG, e6.getMessage());
        }
        return false;
    }

    public boolean playUnMute() {
        try {
            PlayerView playerView = this.f11968p;
            if (playerView == null || this.f11974v == null) {
                return false;
            }
            playerView.openSound();
            this.f11969q.setSoundStatus(true);
            this.f11957E = 2;
            try {
                v1.b bVar = this.f11955C;
                if (bVar != null) {
                    bVar.o(1.0f);
                }
            } catch (Exception e5) {
                af.a("OMSDK", e5.getMessage());
            }
            BTBaseView.a(this.f11974v, "onUnmute", this.f11822d);
            return true;
        } catch (Exception e6) {
            af.b(BTBaseView.TAG, e6.getMessage());
            return false;
        }
    }

    public void preLoadData() {
        String str;
        int i5;
        if (this.f11820b.getAdType() == 94 || this.f11820b.getAdType() == 287) {
            str = this.f11820b.getRequestId() + this.f11820b.getId() + this.f11820b.getVideoUrlEncode();
        } else {
            str = this.f11820b.getId() + this.f11820b.getVideoUrlEncode() + this.f11820b.getBidToken();
        }
        com.mbridge.msdk.videocommon.download.a a5 = com.mbridge.msdk.videocommon.download.b.getInstance().a(this.f11821c, str);
        if (a5 != null) {
            this.f11975w = a5;
        }
        this.f11958F = e();
        String d5 = d();
        this.f11962J = d5;
        if (this.f11826h && !TextUtils.isEmpty(d5) && this.f11820b != null) {
            b bVar = this.f11953A;
            if (bVar != null) {
                bVar.d(this.f11968p);
                b bVar2 = this.f11953A;
                SoundImageView soundImageView = this.f11969q;
                h hVar = h.OTHER;
                bVar2.a(soundImageView, hVar, (String) null);
                this.f11953A.a(this.f11970r, hVar, (String) null);
                this.f11953A.a(this.f11971s, h.VIDEO_CONTROLS, (String) null);
            }
            a aVar = new a(this, this.f11974v, this.f11955C);
            this.f11956D = aVar;
            CampaignEx campaignEx = this.f11820b;
            if (campaignEx == null) {
                i5 = com.mbridge.msdk.videocommon.d.b.a().a(c.m().k(), this.f11821c, false).r();
            } else if (campaignEx.getReady_rate() != -1) {
                i5 = campaignEx.getReady_rate();
            } else {
                i5 = com.mbridge.msdk.videocommon.d.b.a().a(c.m().k(), this.f11821c, false).r();
            }
            aVar.a(i5, com.mbridge.msdk.videocommon.d.b.a().a(c.m().k(), this.f11821c, false).s());
            this.f11968p.setDesk(false);
            this.f11968p.initBufferIngParam(this.f11958F);
            soundOperate(this.f11957E, -1, (String) null);
        }
        f11951K = false;
    }

    public void resume() {
        try {
            PlayerView playerView = this.f11968p;
            if (playerView != null) {
                if (this.f11959G) {
                    playerView.playVideo(0);
                    this.f11959G = false;
                } else {
                    playerView.onResume();
                }
                try {
                    v1.b bVar = this.f11955C;
                    if (bVar != null) {
                        bVar.k();
                        af.a("omsdk", "btv play3:  videoEvents.resume()");
                    }
                } catch (Throwable th) {
                    af.a(BTBaseView.TAG, th.getMessage());
                }
                WebView webView = this.f11974v;
                if (webView != null) {
                    BTBaseView.a(webView, "onPlayerResume", this.f11822d);
                }
            }
        } catch (Exception e5) {
            af.b(BTBaseView.TAG, e5.getMessage());
        }
    }

    public void setAdEvents(u1.a aVar) {
        this.f11954B = aVar;
    }

    public void setAdSession(b bVar) {
        this.f11953A = bVar;
    }

    public void setCampaign(CampaignEx campaignEx) {
        super.setCampaign(campaignEx);
        if (campaignEx == null || campaignEx.getVideoCompleteTime() <= 0) {
            this.f11970r.setBackgroundResource(x.a(c.m().c(), "mbridge_reward_shape_progress", "drawable"));
            this.f11970r.setWidth(ak.a(c.m().c(), 30.0f));
            return;
        }
        this.f11970r.setBackgroundResource(x.a(c.m().c(), "mbridge_reward_video_time_count_num_bg", "drawable"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, ak.a(c.m().c(), 30.0f));
        int a5 = ak.a(c.m().c(), 5.0f);
        layoutParams.setMargins(a5, 0, 0, 0);
        this.f11970r.setPadding(a5, 0, a5, 0);
        this.f11970r.setLayoutParams(layoutParams);
    }

    public void setCloseViewVisable(int i5) {
        int i6;
        View view = this.f11971s;
        if (i5 == 0) {
            i6 = 4;
        } else {
            i6 = 0;
        }
        view.setVisibility(i6);
    }

    public void setCountDownTextViewVisable(int i5) {
        int i6;
        TextView textView = this.f11970r;
        if (i5 == 0) {
            i6 = 4;
        } else {
            i6 = 0;
        }
        textView.setVisibility(i6);
    }

    public void setCreateWebView(WebView webView) {
        this.f11974v = webView;
    }

    public void setNotchPadding(int i5, int i6, int i7, int i8) {
        if (i5 <= 0) {
            i5 = this.f11966O.getPaddingLeft();
        }
        if (i6 <= 0) {
            i6 = this.f11966O.getPaddingRight();
        }
        if (i7 <= 0) {
            i7 = this.f11966O.getPaddingTop();
        }
        if (i8 <= 0) {
            i8 = this.f11966O.getPaddingBottom();
        }
        af.b(BTBaseView.TAG, "NOTCH BTVideoView " + String.format("%1s-%2s-%3s-%4s", new Object[]{Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}));
        this.f11966O.setPadding(i5, i7, i6, i8);
    }

    public void setOrientation(int i5) {
        this.f11961I = i5;
    }

    public void setPlaybackParams(float f5) {
        PlayerView playerView = this.f11968p;
        if (playerView != null) {
            playerView.setPlaybackParams(f5);
        }
    }

    public void setProgressBarState(int i5) {
        int i6;
        ProgressBar progressBar = this.f11967P;
        if (progressBar != null) {
            if (i5 == 0) {
                i6 = 8;
            } else {
                i6 = 0;
            }
            progressBar.setVisibility(i6);
            CampaignEx campaignEx = this.f11820b;
            if (campaignEx != null && campaignEx.getProgressBarShow() == 1) {
                this.f11967P.setVisibility(0);
            }
        }
    }

    public void setShowClose(int i5) {
        this.f11977y = i5;
    }

    public void setShowMute(int i5) {
        this.f11978z = i5;
    }

    public void setShowTime(int i5) {
        this.f11976x = i5;
    }

    public void setSoundImageViewVisble(int i5) {
        int i6;
        SoundImageView soundImageView = this.f11969q;
        if (i5 == 0) {
            i6 = 4;
        } else {
            i6 = 0;
        }
        soundImageView.setVisibility(i6);
    }

    public void setVideoEvents(v1.b bVar) {
        this.f11955C = bVar;
        a aVar = this.f11956D;
        if (aVar != null) {
            v1.b unused = aVar.f11984c = bVar;
        }
        PlayerView playerView = this.f11968p;
        if (playerView != null) {
            playerView.setVideoEvents(bVar);
        }
    }

    public void setVolume(float f5, float f6) {
        PlayerView playerView = this.f11968p;
        if (playerView != null) {
            playerView.setVolume(f5, f6);
        }
    }

    public void soundOperate(int i5, int i6, String str) {
        if (this.f11826h) {
            this.f11957E = i5;
            if (i5 == 1) {
                this.f11969q.setSoundStatus(false);
                this.f11968p.closeSound();
            } else if (i5 == 2) {
                this.f11969q.setSoundStatus(true);
                this.f11968p.openSound();
            }
            if (i6 == 1) {
                this.f11969q.setVisibility(8);
            } else if (i6 == 2) {
                this.f11969q.setVisibility(0);
            }
            v1.b bVar = this.f11955C;
            if (bVar != null) {
                try {
                    bVar.o(this.f11968p.getVolume());
                } catch (Exception e5) {
                    af.b("omsdk", e5.getMessage());
                }
            }
        }
    }

    public void stop() {
        try {
            PlayerView playerView = this.f11968p;
            if (playerView != null) {
                playerView.pause();
                this.f11968p.stop();
                this.f11959G = true;
                WebView webView = this.f11974v;
                if (webView != null) {
                    BTBaseView.a(webView, "onPlayerStop", this.f11822d);
                }
            }
        } catch (Exception e5) {
            af.b(BTBaseView.TAG, e5.getMessage(), e5);
        }
    }

    private boolean c() {
        try {
            this.f11968p = (PlayerView) findViewById(findID("mbridge_vfpv"));
            this.f11969q = (SoundImageView) findViewById(findID("mbridge_sound_switch"));
            this.f11970r = (TextView) findViewById(findID("mbridge_tv_count"));
            this.f11971s = findViewById(findID("mbridge_rl_playing_close"));
            this.f11966O = (RelativeLayout) findViewById(findID("mbridge_top_control"));
            this.f11967P = (ProgressBar) findViewById(findID("mbridge_video_progress_bar"));
            this.f11968p.setIsBTVideo(true);
            this.f11972t = (FeedBackButton) findViewById(findID("mbridge_native_endcard_feed_btn"));
            this.f11973u = (ImageView) findViewById(findID("mbridge_iv_link"));
            return isNotNULL(this.f11968p, this.f11969q, this.f11970r, this.f11971s);
        } catch (Throwable th) {
            af.b(BTBaseView.TAG, th.getMessage(), th);
            return false;
        }
    }

    private String d() {
        try {
            String videoUrlEncode = this.f11820b.getVideoUrlEncode();
            com.mbridge.msdk.videocommon.download.a aVar = this.f11975w;
            if (aVar != null) {
                String h5 = aVar.h();
                return (ap.a(h5) || !new File(h5).exists()) ? videoUrlEncode : h5;
            }
        } catch (Throwable th) {
            af.b(BTBaseView.TAG, th.getMessage(), th);
            return "";
        }
    }

    private int e() {
        int i5 = 5;
        try {
            com.mbridge.msdk.videocommon.d.a b5 = com.mbridge.msdk.videocommon.d.b.a().b();
            if (b5 == null) {
                com.mbridge.msdk.videocommon.d.b.a().c();
            }
            if (b5 != null) {
                i5 = (int) b5.h();
            }
            af.c(BTBaseView.TAG, "MBridgeBaseView buffetTimeout:" + i5);
            return i5;
        } catch (Throwable th) {
            th.printStackTrace();
            return 5;
        }
    }

    /* access modifiers changed from: private */
    public static String b(int i5, int i6) {
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

    /* access modifiers changed from: protected */
    public final void a() {
        super.a();
        if (this.f11826h) {
            this.f11969q.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    boolean isSilent = MBridgeBTVideoView.this.f11968p.isSilent();
                    if (MBridgeBTVideoView.this.f11974v != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("code", BTBaseView.f11817n);
                            jSONObject.put("id", MBridgeBTVideoView.this.f11822d);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(CampaignEx.JSON_NATIVE_VIDEO_MUTE, MBridgeBTVideoView.this.f11957E);
                            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                            g.a().a(MBridgeBTVideoView.this.f11974v, "onPlayerMuteBtnClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                            af.a("OperateViews", "onPlayerMuteBtnClicked isMute = " + isSilent + " mute = " + MBridgeBTVideoView.this.f11957E);
                        } catch (Exception e5) {
                            d.c().a(MBridgeBTVideoView.this.f11974v, e5.getMessage());
                        }
                    }
                }
            });
            this.f11971s.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (MBridgeBTVideoView.this.f11974v != null) {
                        BTBaseView.a(MBridgeBTVideoView.this.f11974v, "onPlayerCloseBtnClicked", MBridgeBTVideoView.this.f11822d);
                    }
                }
            });
            setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (MBridgeBTVideoView.this.f11955C != null) {
                        try {
                            MBridgeBTVideoView.this.f11955C.a(v1.a.CLICK);
                            af.a("omsdk", "btv adUserInteraction click");
                        } catch (Exception e5) {
                            af.b("omsdk", e5.getMessage());
                        }
                    }
                    if (MBridgeBTVideoView.this.f11974v != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("code", BTBaseView.f11817n);
                            jSONObject.put("id", MBridgeBTVideoView.this.f11822d);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("x", String.valueOf(view.getX()));
                            jSONObject2.put("y", String.valueOf(view.getY()));
                            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                            g.a().a(MBridgeBTVideoView.this.f11974v, "onClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                        } catch (Exception unused) {
                            d.c().a(MBridgeBTVideoView.this.f11974v, "onClicked", MBridgeBTVideoView.this.f11822d);
                        }
                    }
                }
            });
        }
    }

    public MBridgeBTVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
