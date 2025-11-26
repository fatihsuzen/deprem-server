package com.mbridge.msdk.newreward.player.presenter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.c.b;
import com.mbridge.msdk.foundation.same.c.c;
import com.mbridge.msdk.foundation.same.report.d.a;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.function.g.e;
import com.mbridge.msdk.newreward.function.h.a;
import com.mbridge.msdk.newreward.player.imodel.IECModel;
import com.mbridge.msdk.newreward.player.iview.IBaseView;
import com.mbridge.msdk.newreward.player.iview.IECTempleView;
import com.mbridge.msdk.newreward.player.model.ECTempleModel;
import com.mbridge.msdk.newreward.player.redirect.RedirectModel;
import com.mbridge.msdk.newreward.player.redirect.UrlReDirectController;
import com.mbridge.msdk.out.RewardInfo;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.mbridge.msdk.video.dynview.e.h;
import java.lang.reflect.Proxy;
import java.util.Calendar;
import java.util.Locale;

public class ECTemplePresenter extends AbsPresenter {
    public static final int MIN_CLICK_DELAY_TIME = 2000;
    final int END_CARD_BUILD_TYPE = 1;
    private final String TAG = "ECTemplePresenter";
    Runnable alacRunnable;
    IECModel ecTempleModel;
    IECTempleView iecView;
    private long lastClickTime = 0;
    Handler mHandler;
    Runnable miniCardRunnable;
    int nLogo = 1;

    public ECTemplePresenter(IECTempleView iECTempleView) {
        super(iECTempleView);
        this.iecView = (IECTempleView) Proxy.newProxyInstance(iECTempleView.getClass().getClassLoader(), new Class[]{IECTempleView.class, IBaseView.class}, new e(iECTempleView, this.adapterModel, this.commandManager));
        ECTempleModel eCTempleModel = new ECTempleModel(this.commandManager, this.rewardVideoListener);
        this.ecTempleModel = (IECModel) Proxy.newProxyInstance(ECTempleModel.class.getClassLoader(), new Class[]{IECModel.class}, new e(eCTempleModel, this.adapterModel, this.commandManager));
        this.TEMPLATE_MARK_TYPE = 3;
    }

    private void closeViewClick() {
        try {
            this.iecView.removeTempleFromSuperView(this.data.getRootViewGroup());
            if (isIVRewardEnable()) {
                this.rewardVideoListener.onAdCloseWithIVReward(this.mBridgeIds, this.adapterModel.ab(), this.adapterModel.w());
            }
            adClosed();
            this.ecTempleModel.onCloseViewClick(1);
            if (!this.isIV && !this.adapterModel.X() && this.adapterModel.ab()) {
                this.adapterModel.i(true);
                this.ecTempleModel.eventAddReward(this.redirectModel);
            }
        } catch (Exception e5) {
            af.b("ECTemplePresenter", e5.getMessage());
        }
        finish(true);
    }

    private void doClickJump() {
        try {
            long timeInMillis = Calendar.getInstance().getTimeInMillis();
            if (timeInMillis - this.lastClickTime >= AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) {
                this.lastClickTime = timeInMillis;
                new UrlReDirectController().setCommandManager(this.commandManager);
                CampaignEx campaignEx = this.campaignEx;
                if (campaignEx != null) {
                    campaignEx.setClickTempSource(a.f9451h);
                    this.campaignEx.setTriggerClickSource(a.f9456m);
                }
                this.ecTempleModel.eventClickUrl(this.redirectModel);
                this.ecTempleModel.eventTrackingForClick(this.redirectModel);
                this.ecTempleModel.onAdClick(this.mBridgeIds);
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }

    private void initPrivacyButton() {
        ak.a(2, this.iecView.getNoticeIV(), this.campaignEx, this.context, true, new com.mbridge.msdk.foundation.d.a() {
            public void close() {
            }

            public void showed() {
            }

            public void summit(String str) {
            }
        });
    }

    private void loadBigImageAndBlurBG() {
        try {
            b.a(this.context.getApplicationContext()).a(this.campaignEx.getImageUrl(), new c() {
                public void onFailedLoad(String str, String str2) {
                }

                public void onSuccessLoad(Bitmap bitmap, String str) {
                    if (bitmap != null && !bitmap.isRecycled()) {
                        try {
                            ECTemplePresenter eCTemplePresenter = ECTemplePresenter.this;
                            ECTemplePresenter.this.iecView.setImageBitMap(eCTemplePresenter.filterFindViewId(eCTemplePresenter.is_dy, "mbridge_iv_adbanner"), bitmap);
                            com.mbridge.msdk.newreward.function.h.a.a(bitmap, new a.C0104a() {
                                public void blurFailCallBack() {
                                }

                                public void blurSuccessCallBack(Bitmap bitmap) {
                                    ECTemplePresenter.this.iecView.setBlurBackGround(bitmap);
                                }
                            });
                        } catch (Exception e5) {
                            af.b("ECTemplePresenter", e5.getMessage());
                        }
                    }
                }
            });
        } catch (Exception e5) {
            af.b("ECTemplePresenter", e5.getMessage());
        }
    }

    private void loadIconImage() {
        try {
            b.a(this.context.getApplicationContext()).a(this.campaignEx.getIconUrl(), new c() {
                public void onFailedLoad(String str, String str2) {
                }

                public void onSuccessLoad(Bitmap bitmap, String str) {
                    try {
                        ECTemplePresenter eCTemplePresenter = ECTemplePresenter.this;
                        ECTemplePresenter.this.iecView.setImageBitMap(eCTemplePresenter.filterFindViewId(eCTemplePresenter.is_dy, "mbridge_iv_icon"), bitmap);
                    } catch (Exception unused) {
                    }
                }
            });
        } catch (Exception e5) {
            af.b("ECTemplePresenter", e5.getMessage());
        }
    }

    private void setNLogo() {
        String str;
        Drawable drawable;
        try {
            String language = Locale.getDefault().getLanguage();
            if (!TextUtils.isEmpty(language)) {
                if (language.equals("zh")) {
                    drawable = this.context.getResources().getDrawable(this.context.getResources().getIdentifier("mbridge_reward_flag_cn", "drawable", com.mbridge.msdk.foundation.controller.c.m().g()));
                    str = "广告";
                    this.iecView.setNLogo(this.nLogo, str, drawable);
                }
            }
            drawable = this.context.getResources().getDrawable(this.context.getResources().getIdentifier("mbridge_reward_flag_en", "drawable", com.mbridge.msdk.foundation.controller.c.m().g()));
            str = "AD";
            this.iecView.setNLogo(this.nLogo, str, drawable);
        } catch (Exception e5) {
            af.b("ECTemplePresenter", e5.getMessage());
        }
    }

    public void adClosed() {
        if (!this.adapterModel.aa()) {
            this.adapterModel.l(true);
            if (this.reward != null) {
                this.ecTempleModel.onAdClose(this.mBridgeIds, new RewardInfo(this.adapterModel.ab(), this.reward.a(), String.valueOf(this.reward.b())), 2);
            }
        }
    }

    public void adShowFail(String str, int i5) {
        if (!this.adapterModel.Y()) {
            super.adShowFail(str, i5);
            this.ecTempleModel.onShowFail(this.mBridgeIds, str, i5);
            finish(true);
        }
    }

    public void adShowSuccess() {
        if (!this.adapterModel.Y()) {
            super.adShowSuccess();
            this.adapterModel.j(true);
            this.ecTempleModel.onAdShow(this.mBridgeIds);
            this.ecTempleModel.eventImpression(this.redirectModel);
            this.ecTempleModel.eventOnlyImpression(this.redirectModel);
            this.ecTempleModel.eventPvUrls(this.redirectModel);
            this.ecTempleModel.eventTrackingForImpression(this.redirectModel);
        }
    }

    public void addBaitClickView() {
        try {
            IECTempleView iECTempleView = this.iecView;
            if (iECTempleView != null) {
                if (iECTempleView.getBaitClickView() != null) {
                    com.mbridge.msdk.newreward.function.command.c cVar = this.commandManager;
                    cVar.e((Object) cVar.a("campaign", this.campaignEx, "template_model", this.ecTempleModel, "template_redirect_model", this.redirectModel, "bait_click_view", this.iecView.getBaitClickView(), "mbridge_ids", this.mBridgeIds), f.ADD_BAIT_CLICK);
                }
            }
        } catch (Exception e5) {
            af.b("ECTemplePresenter", e5.getMessage());
        }
    }

    public void addShakeView() {
        try {
            com.mbridge.msdk.newreward.function.command.c cVar = this.commandManager;
            Object e5 = cVar.e((Object) cVar.a("campaign", this.campaignEx, "template_model", this.ecTempleModel, "template_redirect_model", this.redirectModel, "mbridge_ids", this.mBridgeIds), f.ADD_SHAKE_VIEW);
            if (e5 instanceof View) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                if (this.context.getResources().getConfiguration().orientation != 2) {
                    layoutParams.addRule(2, filterFindViewId(this.is_dy, "mbridge_iv_logo"));
                    layoutParams.addRule(14);
                    ((View) e5).setPadding(0, 0, 0, ak.a(this.context, 20.0f));
                } else {
                    layoutParams.addRule(13);
                }
                ((View) e5).setLayoutParams(layoutParams);
                this.iecView.addShakeView((View) e5);
            }
        } catch (Exception e6) {
            af.b("ECTemplePresenter", e6.getMessage());
        }
    }

    public void click(View view) {
        if (view.getId() == filterFindViewId(this.is_dy, "mbridge_iv_close")) {
            closeViewClick();
        } else if (view.getId() == filterFindViewId(this.is_dy, "mbridge_tv_cta")) {
            doClickJump();
        } else if (view.getId() == filterFindViewId(this.is_dy, "mbridge_native_ec_layout")) {
            CampaignEx campaignEx = this.campaignEx;
            if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getendcard_url()) && this.campaignEx.getendcard_url().contains("alecfc=1")) {
                RedirectModel redirectModel = this.redirectModel;
                if (redirectModel != null) {
                    redirectModel.setClickSenario(1);
                }
                doClickJump();
            }
        } else if (view.getId() == filterFindViewId(this.is_dy, "mbridge_iv_adbanner")) {
            doClickJump();
        } else if (view.getId() == filterFindViewId(this.is_dy, "mbridge_iv_icon")) {
            doClickJump();
        }
    }

    public void finish(boolean z4) {
        Handler handler = this.mHandler;
        if (handler != null) {
            Runnable runnable = this.alacRunnable;
            if (runnable != null) {
                handler.removeCallbacks(runnable);
            }
            Runnable runnable2 = this.miniCardRunnable;
            if (runnable2 != null) {
                this.mHandler.removeCallbacks(runnable2);
            }
        }
        if (z4) {
            ((Activity) this.context).finish();
        }
    }

    public void getView() {
        String str;
        if (com.mbridge.msdk.e.b.a()) {
            str = "cn_";
        } else {
            str = "en_";
        }
        com.mbridge.msdk.video.dynview.c a5 = new com.mbridge.msdk.video.dynview.j.c().a(this.context, this.campaignEx, -1, str);
        this.nLogo = a5.n();
        com.mbridge.msdk.video.dynview.b.a().a(a5, new h() {
            public void viewInflaterFail(com.mbridge.msdk.video.dynview.c.a aVar) {
                ECTemplePresenter.this.adShowFail(com.mbridge.msdk.foundation.c.a.a(890008), 890008);
            }

            public void viewInflaterSuccess(com.mbridge.msdk.video.dynview.a aVar) {
                ECTemplePresenter.this.initDataForView(aVar);
            }
        });
    }

    public void handleInterceptTouchEvent(MotionEvent motionEvent) {
        RedirectModel redirectModel = this.redirectModel;
        if (redirectModel != null && motionEvent != null) {
            redirectModel.setxInScreen(motionEvent.getRawX());
            this.redirectModel.setyInScreen(motionEvent.getRawY());
        }
    }

    public void initDataForView(com.mbridge.msdk.video.dynview.a aVar) {
        if (aVar == null) {
            try {
                adShowFail(com.mbridge.msdk.foundation.c.a.a(890008), 890008);
                closeViewClick();
            } catch (Exception e5) {
                adShowFail(e5.getMessage(), -1);
                af.b("ECTemplePresenter", e5.getMessage());
            }
        } else {
            this.iecView.addViewToCurrentViewGroup(aVar.a());
            boolean c5 = aVar.c();
            this.is_dy = c5;
            this.adapterModel.g(c5);
            this.campaignEx.setECTemplateRenderSucc(this.is_dy);
            this.iecView.initViews(this.is_dy);
            loadBigImageAndBlurBG();
            loadIconImage();
            initPrivacyButton();
            setNLogo();
            double rating = this.campaignEx.getRating();
            if (rating <= 0.0d) {
                rating = 5.0d;
            }
            this.iecView.setRatingAndUser(rating, this.campaignEx.getNumberRating());
            this.iecView.setHeatCount(this.campaignEx.getNumberRating());
            this.iecView.setCTAText(this.campaignEx.getAdCall());
            this.iecView.setTextByID(filterFindViewId(this.is_dy, "mbridge_tv_apptitle"), this.campaignEx.getAppName());
            this.iecView.setTextByID(filterFindViewId(this.is_dy, "mbridge_tv_appdesc"), this.campaignEx.getAppDesc());
            this.iecView.setTextByID(filterFindViewId(this.is_dy, "mbridge_tv_number"), String.valueOf(this.campaignEx.getNumberRating()));
            adShowSuccess();
        }
    }

    public boolean isHalfScreenOffer() {
        CampaignEx campaignEx = this.campaignEx;
        if (campaignEx == null || campaignEx.getAdSpaceT() != 2) {
            return false;
        }
        return true;
    }

    public void onBackPressed() {
        closeViewClick();
    }

    public void onEndCardShow() {
        if (this.ecTempleModel != null && !this.adapterModel.Z()) {
            this.ecTempleModel.onEndCardShow(this.mBridgeIds, 1);
            this.ecTempleModel.eventTrackingForEndCardShow(this.redirectModel, 1);
            this.adapterModel.k(true);
        }
    }

    public void releaseSource() {
    }

    public void setAutoRedirect() {
        try {
            CampaignEx campaignEx = this.campaignEx;
            if (campaignEx != null) {
                String str = campaignEx.getendcard_url();
                if (TextUtils.isEmpty(str)) {
                    str = this.campaignEx.getEndScreenUrl();
                }
                String a5 = aq.a(str, "alac");
                if (!TextUtils.isEmpty(a5) && a5.equals("1")) {
                    if (this.campaignEx.getAutoShowStoreMiniCard() != 1) {
                        if (this.alacRunnable == null) {
                            this.alacRunnable = new Runnable() {
                                public void run() {
                                    CampaignEx campaignEx = ECTemplePresenter.this.campaignEx;
                                    if (campaignEx != null) {
                                        campaignEx.setClickTempSource(com.mbridge.msdk.foundation.same.report.d.a.f9451h);
                                        ECTemplePresenter.this.campaignEx.setTriggerClickSource(com.mbridge.msdk.foundation.same.report.d.a.f9457n);
                                        ECTemplePresenter.this.campaignEx.setClickType(com.mbridge.msdk.foundation.same.report.d.a.f9452i);
                                    }
                                    ECTemplePresenter eCTemplePresenter = ECTemplePresenter.this;
                                    eCTemplePresenter.ecTempleModel.eventClickUrl(eCTemplePresenter.redirectModel);
                                    ECTemplePresenter eCTemplePresenter2 = ECTemplePresenter.this;
                                    eCTemplePresenter2.ecTempleModel.eventTrackingForClick(eCTemplePresenter2.redirectModel);
                                    ECTemplePresenter eCTemplePresenter3 = ECTemplePresenter.this;
                                    eCTemplePresenter3.ecTempleModel.onAdClick(eCTemplePresenter3.mBridgeIds);
                                }
                            };
                        }
                        if (this.mHandler == null) {
                            this.mHandler = new Handler();
                        }
                        this.mHandler.postDelayed(this.alacRunnable, 1000);
                    }
                }
            }
        } catch (Throwable th) {
            af.b("ECTemplePresenter", th.getMessage());
        }
    }

    public void setCloseViewShow() {
        CampaignEx campaignEx = this.campaignEx;
        if (campaignEx == null) {
            this.iecView.setCloseViewBtnDelayShow(1000);
            return;
        }
        boolean a5 = ak.a(MBridgeConstans.DYNAMIC_VIEW_KEY_CLOSE_BTN_DELATE, campaignEx.getendcard_url());
        int c5 = ak.c(this.campaignEx.getendcard_url(), MBridgeConstans.DYNAMIC_VIEW_KEY_CLOSE_BTN_DELATE);
        if (!a5 || c5 < 0) {
            if (this.campaignEx.getCbd() > -2) {
                c5 = this.campaignEx.getCbd();
            } else if (this.adapterModel.x() == null || this.adapterModel.x().b() == null) {
                c5 = 1;
            } else {
                c5 = this.adapterModel.x().b().p();
            }
        }
        this.iecView.setCloseViewBtnDelayShow(c5 * 1000);
    }

    public void showStoreMiniCard() {
        try {
            CampaignEx campaignEx = this.campaignEx;
            if (campaignEx != null) {
                if (campaignEx.getAutoShowStoreMiniCard() != 0) {
                    if (!TextUtils.isEmpty(this.campaignEx.getDeepLinkURL())) {
                        long showStoreMiniCardDelayTime = (long) this.campaignEx.getShowStoreMiniCardDelayTime();
                        if (showStoreMiniCardDelayTime == 0) {
                            showStoreMiniCardDelayTime = 1;
                        }
                        if (this.miniCardRunnable == null) {
                            this.miniCardRunnable = new Runnable() {
                                public void run() {
                                    CampaignEx campaignEx = ECTemplePresenter.this.campaignEx;
                                    if (campaignEx != null) {
                                        campaignEx.setClickTempSource(com.mbridge.msdk.foundation.same.report.d.a.f9451h);
                                        ECTemplePresenter.this.campaignEx.setTriggerClickSource(com.mbridge.msdk.foundation.same.report.d.a.f9457n);
                                        ECTemplePresenter.this.campaignEx.setClickType(com.mbridge.msdk.foundation.same.report.d.a.f9452i);
                                    }
                                    ECTemplePresenter eCTemplePresenter = ECTemplePresenter.this;
                                    eCTemplePresenter.ecTempleModel.eventClickUrl(eCTemplePresenter.redirectModel);
                                    ECTemplePresenter eCTemplePresenter2 = ECTemplePresenter.this;
                                    eCTemplePresenter2.ecTempleModel.eventTrackingForClick(eCTemplePresenter2.redirectModel);
                                    ECTemplePresenter eCTemplePresenter3 = ECTemplePresenter.this;
                                    eCTemplePresenter3.ecTempleModel.onAdClick(eCTemplePresenter3.mBridgeIds);
                                }
                            };
                        }
                        if (this.mHandler == null) {
                            this.mHandler = new Handler();
                        }
                        this.mHandler.postDelayed(this.miniCardRunnable, showStoreMiniCardDelayTime * 1000);
                    }
                }
            }
        } catch (Throwable th) {
            af.b("ECTemplePresenter", th.getMessage());
        }
    }
}
