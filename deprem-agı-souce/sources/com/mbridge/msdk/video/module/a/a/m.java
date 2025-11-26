package com.mbridge.msdk.video.module.a.a;

import android.os.Handler;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.dycreator.baseview.cusview.SoundImageView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.video.bt.module.b.f;
import com.mbridge.msdk.video.module.MBridgeContainerView;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.videocommon.b.c;
import com.mbridge.msdk.videocommon.download.a;
import java.util.Timer;
import java.util.TimerTask;

public final class m extends o {
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public MBridgeVideoView f12598l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public MBridgeContainerView f12599m;

    /* renamed from: n  reason: collision with root package name */
    private int f12600n;

    /* renamed from: o  reason: collision with root package name */
    private Timer f12601o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public Handler f12602p = new Handler();

    /* renamed from: q  reason: collision with root package name */
    private boolean f12603q = false;

    /* renamed from: r  reason: collision with root package name */
    private boolean f12604r = false;

    /* renamed from: s  reason: collision with root package name */
    private boolean f12605s = false;

    /* renamed from: t  reason: collision with root package name */
    private int f12606t;

    /* renamed from: u  reason: collision with root package name */
    private int f12607u;

    /* renamed from: v  reason: collision with root package name */
    private MBridgeVideoView.a f12608v;

    public m(MBridgeVideoView mBridgeVideoView, MBridgeContainerView mBridgeContainerView, CampaignEx campaignEx, c cVar, a aVar, String str, String str2, int i5, int i6, com.mbridge.msdk.video.module.a.a aVar2, int i7, boolean z4, int i8) {
        super(campaignEx, cVar, aVar, str, str2, aVar2, i7, z4);
        boolean z5;
        this.f12598l = mBridgeVideoView;
        this.f12599m = mBridgeContainerView;
        this.f12607u = i5;
        this.f12600n = i6;
        this.f12606t = i8;
        if (mBridgeVideoView != null) {
            if (mBridgeVideoView.getVideoSkipTime() == 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            this.f12603q = z5;
        }
        if (mBridgeVideoView == null || mBridgeContainerView == null) {
            this.f12581a = false;
        }
    }

    private void i() {
        try {
            Timer timer = this.f12601o;
            if (timer != null) {
                timer.cancel();
                this.f12601o = null;
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void j() {
        /*
            r4 = this;
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r4.f12582b
            if (r0 == 0) goto L_0x0070
            int r0 = r0.getDynamicTempCode()
            r1 = 5
            if (r0 != r1) goto L_0x0070
            com.mbridge.msdk.video.module.MBridgeVideoView r0 = r4.f12598l
            if (r0 == 0) goto L_0x005c
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r0.mCampOrderViewData
            if (r0 == 0) goto L_0x005c
            r0 = 0
            r1 = r0
        L_0x0015:
            com.mbridge.msdk.video.module.MBridgeVideoView r2 = r4.f12598l
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r2 = r2.mCampOrderViewData
            int r2 = r2.size()
            if (r1 >= r2) goto L_0x0045
            com.mbridge.msdk.video.module.MBridgeVideoView r2 = r4.f12598l
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r2 = r2.mCampOrderViewData
            java.lang.Object r2 = r2.get(r1)
            if (r2 == 0) goto L_0x0042
            com.mbridge.msdk.video.module.MBridgeVideoView r2 = r4.f12598l
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r2 = r2.mCampOrderViewData
            java.lang.Object r2 = r2.get(r1)
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = (com.mbridge.msdk.foundation.entity.CampaignEx) r2
            java.lang.String r2 = r2.getId()
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = r4.f12582b
            java.lang.String r3 = r3.getId()
            if (r2 != r3) goto L_0x0042
            int r0 = r1 + -1
            goto L_0x0045
        L_0x0042:
            int r1 = r1 + 1
            goto L_0x0015
        L_0x0045:
            if (r0 < 0) goto L_0x005c
            com.mbridge.msdk.video.module.MBridgeVideoView r1 = r4.f12598l
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r1 = r1.mCampOrderViewData
            java.lang.Object r1 = r1.get(r0)
            if (r1 == 0) goto L_0x005c
            com.mbridge.msdk.video.module.MBridgeVideoView r1 = r4.f12598l
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r1 = r1.mCampOrderViewData
            java.lang.Object r0 = r1.get(r0)
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0
            goto L_0x005d
        L_0x005c:
            r0 = 0
        L_0x005d:
            if (r0 == 0) goto L_0x0070
            com.mbridge.msdk.video.module.MBridgeVideoView r1 = r4.f12598l
            if (r1 == 0) goto L_0x0066
            r1.setCampaign(r0)
        L_0x0066:
            com.mbridge.msdk.video.module.MBridgeContainerView r1 = r4.f12599m
            if (r1 == 0) goto L_0x006d
            r1.setCampaign(r0)
        L_0x006d:
            r4.a((com.mbridge.msdk.foundation.entity.CampaignEx) r0)
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.a.a.m.j():void");
    }

    public final void a(int i5, Object obj) {
        Integer num;
        int i6;
        CampaignEx campaignEx;
        if (this.f12581a) {
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 5) {
                        if (i5 != 6) {
                            if (i5 == 8) {
                                MBridgeContainerView mBridgeContainerView = this.f12599m;
                                if (mBridgeContainerView == null) {
                                    MBridgeVideoView mBridgeVideoView = this.f12598l;
                                    if (mBridgeVideoView != null) {
                                        mBridgeVideoView.showAlertView();
                                    }
                                } else if (!mBridgeContainerView.showAlertWebView()) {
                                    MBridgeVideoView mBridgeVideoView2 = this.f12598l;
                                    if (mBridgeVideoView2 != null) {
                                        mBridgeVideoView2.showAlertView();
                                    }
                                } else {
                                    MBridgeVideoView mBridgeVideoView3 = this.f12598l;
                                    if (mBridgeVideoView3 != null) {
                                        mBridgeVideoView3.alertWebViewShowed();
                                    }
                                }
                            } else if (i5 != 20) {
                                switch (i5) {
                                    case 10:
                                        this.f12604r = true;
                                        this.f12598l.soundOperate(0, 2);
                                        this.f12598l.progressOperate(0, 2);
                                        break;
                                    case 11:
                                        this.f12598l.videoOperate(3);
                                        this.f12598l.dismissAllAlert();
                                        CampaignEx campaignEx2 = this.f12582b;
                                        if (campaignEx2 == null || campaignEx2.getVideo_end_type() == 3 || this.f12582b.getRewardTemplateMode() == null || this.f12582b.getRewardTemplateMode().f() == 5002010) {
                                            this.f12598l.setVisibility(0);
                                        } else if (this.f12582b.getAdSpaceT() != 2) {
                                            this.f12598l.setVisibility(8);
                                        }
                                        CampaignEx campaignEx3 = this.f12582b;
                                        if (campaignEx3 != null && campaignEx3.getDynamicTempCode() == 5) {
                                            MBridgeVideoView mBridgeVideoView4 = this.f12598l;
                                            if (mBridgeVideoView4.mCurrPlayNum == mBridgeVideoView4.mCampaignSize) {
                                                MBridgeContainerView mBridgeContainerView2 = this.f12599m;
                                                if (mBridgeContainerView2 != null) {
                                                    mBridgeContainerView2.setRewardStatus(true);
                                                    this.f12599m.showOrderCampView();
                                                    break;
                                                }
                                            }
                                        }
                                        CampaignEx campaignEx4 = this.f12582b;
                                        if (campaignEx4 == null || campaignEx4.getRewardTemplateMode() == null || this.f12582b.getRewardTemplateMode().f() != 5002010) {
                                            if (this.f12582b.getAdSpaceT() != 2) {
                                                this.f12599m.showEndcard(this.f12582b.getVideo_end_type());
                                                break;
                                            } else {
                                                this.f12599m.showVideoEndCover();
                                                break;
                                            }
                                        }
                                        break;
                                    case 12:
                                        h();
                                        this.f12598l.videoOperate(3);
                                        this.f12598l.dismissAllAlert();
                                        if (this.f12582b.getVideo_end_type() != 3) {
                                            this.f12598l.setVisibility(8);
                                        } else {
                                            this.f12598l.setVisibility(0);
                                        }
                                        if (this.f12604r || this.f12606t != 0) {
                                            if (this.f12582b.isDynamicView() && this.f12582b.getDynamicTempCode() == 5 && TextUtils.isEmpty(this.f12582b.getendcard_url())) {
                                                j();
                                                this.f12606t = 0;
                                            }
                                            if (!this.f12604r && this.f12606t == 1) {
                                                g();
                                                f();
                                                e();
                                                if (ah.a().a("i_l_s_t_r_i", false) && !this.f12605s) {
                                                    this.f12605s = true;
                                                    MBridgeVideoView.a aVar = this.f12608v;
                                                    if (aVar != null) {
                                                        aVar.a();
                                                    }
                                                }
                                            }
                                            if (this.f12582b.getAdSpaceT() == 2) {
                                                this.f12599m.showVideoEndCover();
                                                break;
                                            } else {
                                                this.f12599m.showEndcard(this.f12582b.getVideo_end_type());
                                                break;
                                            }
                                        }
                                    case 13:
                                        this.f12598l.closeVideoOperate(0, 2);
                                        break;
                                    case 14:
                                        if (!this.f12603q) {
                                            this.f12598l.closeVideoOperate(0, 1);
                                            break;
                                        }
                                        break;
                                    case 15:
                                        if (obj != null && (obj instanceof MBridgeVideoView.b)) {
                                            MBridgeVideoView.b bVar = (MBridgeVideoView.b) obj;
                                            int videoInteractiveType = this.f12599m.getVideoInteractiveType();
                                            if (this.f12582b.getAdSpaceT() == 2) {
                                                SoundImageView soundImageView = this.f12598l.mSoundImageView;
                                                if (soundImageView != null && (soundImageView.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                                                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f12598l.mSoundImageView.getLayoutParams();
                                                    layoutParams.setMargins(ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 5.0f), 0, 0, ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 85.0f));
                                                    this.f12598l.mSoundImageView.setLayoutParams(layoutParams);
                                                }
                                                TextView textView = this.f12598l.tvFlag;
                                                if (textView != null && (textView.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                                                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f12598l.tvFlag.getLayoutParams();
                                                    layoutParams2.setMargins(ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 5.0f), 0, 0, ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 85.0f));
                                                    this.f12598l.tvFlag.setVisibility(0);
                                                    this.f12598l.tvFlag.setLayoutParams(layoutParams2);
                                                }
                                                this.f12599m.showVideoClickView(1);
                                            } else if (videoInteractiveType >= 0 && bVar.f12549a >= videoInteractiveType) {
                                                this.f12599m.showVideoClickView(1);
                                                this.f12598l.soundOperate(0, 1);
                                            }
                                            this.f12603q = bVar.f12551c;
                                            if (this.f12582b.getDynamicTempCode() != 5) {
                                                int i7 = this.f12600n;
                                                if (((i7 >= 0 && ((i6 = bVar.f12549a) >= i7 || i6 == bVar.f12550b)) || (this.f12582b.getVideoCompleteTime() > 0 && (bVar.f12549a > this.f12582b.getVideoCompleteTime() || bVar.f12549a == bVar.f12550b))) && !this.f12603q) {
                                                    this.f12598l.closeVideoOperate(0, 2);
                                                    this.f12603q = true;
                                                    break;
                                                }
                                            } else {
                                                int i8 = bVar.f12549a;
                                                int i9 = bVar.f12550b;
                                                if (!(this.f12603q || this.f12598l == null || (campaignEx = this.f12582b) == null)) {
                                                    int i10 = this.f12600n;
                                                    int i11 = (i10 < 0 || i8 < i10) ? 1 : 2;
                                                    if (i11 != 2 && (campaignEx.getVideoCompleteTime() != 0 ? i8 > this.f12582b.getVideoCompleteTime() : this.f12598l.mCurrPlayNum > 1)) {
                                                        i11 = 2;
                                                    }
                                                    if (i11 != 2 && this.f12598l.mCurrPlayNum > 1 && i8 == i9) {
                                                        i11 = 2;
                                                    }
                                                    if (i11 == 2) {
                                                        this.f12598l.closeVideoOperate(0, i11);
                                                        this.f12603q = true;
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                        break;
                                }
                            } else if (ah.a().a("i_l_s_t_r_i", false) && (obj instanceof MBridgeVideoView.a)) {
                                this.f12608v = (MBridgeVideoView.a) obj;
                            }
                        }
                    } else if (obj != null && (obj instanceof Integer)) {
                        if (((Integer) obj).intValue() == 1) {
                            num = 2;
                        } else {
                            num = 1;
                        }
                        this.f12598l.soundOperate(num.intValue(), -1);
                    }
                }
                this.f12598l.dismissAllAlert();
                this.f12598l.videoOperate(3);
                CampaignEx campaignEx5 = this.f12582b;
                if (campaignEx5 != null && campaignEx5.isDynamicView() && this.f12582b.getDynamicTempCode() == 5) {
                    if (this.f12599m != null) {
                        MBridgeVideoView mBridgeVideoView5 = this.f12598l;
                        if (mBridgeVideoView5.mCurrPlayNum == mBridgeVideoView5.mCampaignSize) {
                            if (this.f12582b.getAdSpaceT() != 2) {
                                this.f12599m.setRewardStatus(true);
                                this.f12599m.showOrderCampView();
                            }
                            i5 = 16;
                        }
                    }
                    f.a(this.f12582b, this.f12587g, this.f12598l.mCurrentPlayProgressTime);
                }
                if (this.f12607u == 2 && !this.f12599m.endCardShowing() && this.f12582b.getAdSpaceT() != 2) {
                    this.f12599m.showEndcard(this.f12582b.getVideo_end_type());
                }
                i5 = 16;
            } else if (!this.f12599m.endCardShowing()) {
                int videoInteractiveType2 = this.f12599m.getVideoInteractiveType();
                if (videoInteractiveType2 != -2) {
                    if (videoInteractiveType2 == -1) {
                        if (this.f12599m.isLast()) {
                            this.f12599m.showVideoClickView(1);
                            this.f12598l.soundOperate(0, 1);
                            try {
                                i();
                                this.f12601o = new Timer();
                                this.f12601o.schedule(new TimerTask() {
                                    public final void run() {
                                        try {
                                            m.this.f12602p.post(new Runnable() {
                                                public final void run() {
                                                    m.this.f12599m.showVideoClickView(-1);
                                                    m.this.f12598l.soundOperate(0, 2);
                                                }
                                            });
                                        } catch (Throwable th) {
                                            if (MBridgeConstans.DEBUG) {
                                                th.printStackTrace();
                                            }
                                        }
                                    }
                                }, 3000);
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                        } else {
                            this.f12599m.showVideoClickView(-1);
                            this.f12598l.soundOperate(0, 2);
                            i();
                        }
                    }
                } else if (this.f12599m.miniCardLoaded()) {
                    this.f12599m.showVideoClickView(2);
                }
            }
        }
        super.a(i5, obj);
    }
}
