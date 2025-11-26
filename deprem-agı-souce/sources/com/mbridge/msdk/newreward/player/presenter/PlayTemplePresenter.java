package com.mbridge.msdk.newreward.player.presenter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.d.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.newreward.a.b.b;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.function.command.receiver.d;
import com.mbridge.msdk.newreward.function.g.e;
import com.mbridge.msdk.newreward.function.h.a;
import com.mbridge.msdk.newreward.player.imodel.IPlayModel;
import com.mbridge.msdk.newreward.player.iview.IBaseView;
import com.mbridge.msdk.newreward.player.iview.IPlayTempleView;
import com.mbridge.msdk.newreward.player.model.PlayTempleModel;
import com.mbridge.msdk.video.dynview.e.h;
import java.io.File;
import java.lang.reflect.Proxy;
import java.util.Map;

public class PlayTemplePresenter extends BaseTemplatePresenter implements IPresenter {
    private final String TAG = "PlayTemplePresenter";

    public PlayTemplePresenter(IPlayTempleView iPlayTempleView) {
        super(iPlayTempleView);
        this.iView = (IPlayTempleView) Proxy.newProxyInstance(iPlayTempleView.getClass().getClassLoader(), new Class[]{IPlayTempleView.class, IBaseView.class}, new e(iPlayTempleView, this.adapterModel, this.commandManager));
        PlayTempleModel playTempleModel = new PlayTempleModel(this.commandManager, this.rewardVideoListener);
        this.playTempleModel = (IPlayModel) Proxy.newProxyInstance(PlayTempleModel.class.getClassLoader(), new Class[]{IPlayModel.class}, new e(playTempleModel, this.adapterModel, this.commandManager));
        this.TEMPLATE_MARK_TYPE = 2;
    }

    private void addPrivacy() {
        ak.a(1, this.iView.getPrivacyButton(), this.campaignEx, this.context, false, new a() {
            public void close() {
                PlayTemplePresenter.this.resume();
            }

            public void showed() {
                PlayTemplePresenter.this.onPause();
            }

            public void summit(String str) {
                PlayTemplePresenter.this.resume();
            }
        });
    }

    private void initPlayer() {
        try {
            if (this.campaignEx.getVideoUrlEncode() != null) {
                File g5 = this.adapterModel.g(this.campaignEx.getRequestIdNotice());
                c cVar = this.commandManager;
                Object d5 = cVar.d((Object) cVar.a("fullScreenWidth", Float.valueOf(ak.j(this.context)), "fullScreenHeight", Float.valueOf(ak.i(this.context)), "campaign", this.campaignEx, "orientation", Integer.valueOf(this.context.getResources().getConfiguration().orientation)), f.TEMP_PLAYER_INIT);
                if (d5 instanceof Map) {
                    Map map = (Map) d5;
                    int intValue = ((Integer) map.get("width")).intValue();
                    int intValue2 = ((Integer) map.get("height")).intValue();
                    this.iView.setPlayerSize(((Integer) map.get("gravity")).intValue(), intValue, intValue2);
                }
                if (g5 == null || !g5.exists()) {
                    this.iView.play(this.campaignEx.getVideoUrlEncode(), getBufferTimeout());
                } else {
                    this.iView.play(g5.getAbsolutePath(), getBufferTimeout());
                }
            }
        } catch (Exception e5) {
            af.b("PlayTemplePresenter", e5.getMessage());
            adShowFail(com.mbridge.msdk.foundation.c.a.a(890004), 890004);
        }
    }

    private boolean parseRemoteViewData(com.mbridge.msdk.video.dynview.a aVar) {
        if (aVar == null) {
            return false;
        }
        try {
            boolean c5 = aVar.c();
            this.is_dy = c5;
            com.mbridge.msdk.newreward.a.e eVar = this.adapterModel;
            if (eVar != null) {
                eVar.g(c5);
                this.campaignEx.setTemplateRenderSucc(this.is_dy);
            }
            if (aVar.a() == null) {
                return false;
            }
            aVar.a().setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            try {
                this.iView.addViewToCurrentViewGroup(aVar.a());
                if (aVar.b() != null) {
                    for (View onClickListener : aVar.b()) {
                        onClickListener.setOnClickListener(new com.mbridge.msdk.widget.a() {
                            /* access modifiers changed from: protected */
                            public void onNoDoubleClick(View view) {
                                CampaignEx campaignEx = PlayTemplePresenter.this.campaignEx;
                                if (campaignEx != null) {
                                    campaignEx.setClickTempSource(com.mbridge.msdk.foundation.same.report.d.a.f9450g);
                                    if (view instanceof TextView) {
                                        PlayTemplePresenter.this.campaignEx.setTriggerClickSource(com.mbridge.msdk.foundation.same.report.d.a.f9456m);
                                    } else {
                                        PlayTemplePresenter.this.campaignEx.setTriggerClickSource(com.mbridge.msdk.foundation.same.report.d.a.f9457n);
                                    }
                                }
                                PlayTemplePresenter playTemplePresenter = PlayTemplePresenter.this;
                                playTemplePresenter.playTempleModel.onAdClick(playTemplePresenter.mBridgeIds);
                                PlayTemplePresenter playTemplePresenter2 = PlayTemplePresenter.this;
                                playTemplePresenter2.playTempleModel.eventClickUrl(playTemplePresenter2.redirectModel);
                                PlayTemplePresenter playTemplePresenter3 = PlayTemplePresenter.this;
                                playTemplePresenter3.playTempleModel.eventTrackingForClick(playTemplePresenter3.redirectModel);
                            }
                        });
                    }
                }
                return this.iView.initViews(this.is_dy);
            } catch (Exception e5) {
                af.b("PlayTemplePresenter", e5.getMessage());
                return false;
            }
        } catch (Exception e6) {
            af.b("PlayTemplePresenter", e6.getMessage());
            return false;
        }
    }

    private void preLoadECMoreOfferData() {
        CampaignEx campaignEx = this.campaignEx;
        if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getendcard_url()) && com.mbridge.msdk.newreward.function.h.c.b(this.campaignEx.getendcard_url())) {
            String a5 = aq.a(this.campaignEx.getendcard_url(), "mof");
            if (!TextUtils.isEmpty(a5)) {
                try {
                    if (Integer.parseInt(a5) == 1) {
                        com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                        eVar.a("retry", "2");
                        this.playTempleModel.modelReport("m_mof_initiate", eVar);
                        c cVar = this.commandManager;
                        cVar.e((Object) cVar.a("campaign", this.campaignEx, "command_type", f.REQ_MORE_OFFER_CAMPAIGN, "more_offer_type", 2, "adapter_model", this.adapterModel), (b) new b() {
                            public void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
                                com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                                eVar.a("result", "2");
                                eVar.a("code", Integer.valueOf(bVar.a()));
                                eVar.a("retry", "2");
                                PlayTemplePresenter.this.playTempleModel.modelReport("m_mof_req_result", eVar);
                            }

                            public void reqSuccessful(Object obj) {
                                PlayTemplePresenter playTemplePresenter = PlayTemplePresenter.this;
                                playTemplePresenter.commandManager.a((Object) playTemplePresenter.adapterModel, "MoreOfferPreSendTrackingReceiver");
                                com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                                eVar.a("result", "1");
                                eVar.a("retry", "2");
                                PlayTemplePresenter.this.playTempleModel.modelReport("m_mof_req_result", eVar);
                            }
                        });
                    }
                } catch (Exception e5) {
                    if (MBridgeConstans.DEBUG) {
                        e5.printStackTrace();
                    }
                }
            }
        }
    }

    private void preRenderEc() {
        try {
            com.mbridge.msdk.newreward.a.e eVar = this.adapterModel;
            if (eVar != null && eVar.aj().equals("WEB_EC")) {
                c cVar = this.commandManager;
                cVar.i(cVar.a("web_resource_action", 1, "parent_temple", this.data.getRootViewGroup(), "adapter_model", this.adapterModel, "bridge_ids", this.campaignEx.getRequestIdNotice()), f.SHOW_OR_PRELOAD_WEB_EC);
            }
        } catch (Exception e5) {
            af.b("PlayTemplePresenter", e5.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void resume() {
        this.iView.resume();
        this.playTempleModel.eventTrackingForResume(this.redirectModel);
    }

    public void addBaitClickView() {
        try {
            IPlayTempleView iPlayTempleView = this.iView;
            if (iPlayTempleView != null) {
                if (iPlayTempleView.getBaitClickView() != null) {
                    c cVar = this.commandManager;
                    cVar.e((Object) cVar.a("campaign", this.campaignEx, "template_model", this.playTempleModel, "template_redirect_model", this.redirectModel, "bait_click_view", this.iView.getBaitClickView(), "mbridge_ids", this.mBridgeIds), f.ADD_BAIT_CLICK);
                }
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }

    public void addMoreOfferView(ViewGroup viewGroup) {
        CampaignEx campaignEx = this.campaignEx;
        if (campaignEx != null && campaignEx.getRewardTemplateMode() != null && !TextUtils.isEmpty(this.campaignEx.getRewardTemplateMode().e())) {
            try {
                String a5 = aq.a(this.campaignEx.getRewardTemplateMode().e(), "mof");
                if (!TextUtils.isEmpty(a5) && Integer.parseInt(a5) == 1) {
                    c cVar = this.commandManager;
                    cVar.d((Object) cVar.a("add_temple", 295, "parent_temple", viewGroup, "more_offer_type", 1, "command_type", f.SHOW_ADD_TEMPLE), (b) new b() {
                        public void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
                        }

                        public void reqSuccessful(Object obj) {
                            try {
                                View view = (View) obj;
                                PlayTemplePresenter.this.moreOfferTemp = view;
                                view.setVisibility(0);
                                new com.mbridge.msdk.video.dynview.h.b().a(PlayTemplePresenter.this.moreOfferTemp, 0, ak.f(com.mbridge.msdk.foundation.controller.c.m().c()), 0, ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 100.0f), 500);
                                PlayTemplePresenter.this.iView.setTemplateWidthAndHeight(ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 100.0f));
                            } catch (Exception e5) {
                                Exception exc = e5;
                                if (MBridgeConstans.DEBUG) {
                                    exc.printStackTrace();
                                }
                            }
                        }
                    });
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }

    public void click(View view) {
        super.click(view);
        if (view.getId() == filterFindViewId(this.is_dy, "mbridge_rl_playing_close")) {
            onCloseButtonClick();
        } else if (view.getId() != filterFindViewId(this.is_dy, "mbridge_sound_switch")) {
        } else {
            if (this.iView.getMuteState()) {
                this.iView.setMuteState(false);
                this.playTempleModel.eventTrackingForMute(this.redirectModel);
                return;
            }
            this.iView.setMuteState(true);
            this.playTempleModel.eventTrackingForUnMute(this.redirectModel);
        }
    }

    public void finish(boolean z4) {
        try {
            releaseSource();
            if (z4) {
                ((Activity) this.context).finish();
                d.a().d(f.SHOW_OR_PRELOAD_WEB_EC);
            }
            d.a().a(this.adapterModel.G());
        } catch (Throwable th) {
            af.b("PlayTemplePresenter", th.getMessage());
        }
    }

    public void getView() {
        com.mbridge.msdk.video.dynview.b.a().a(new com.mbridge.msdk.video.dynview.j.c().a((View) this.rootParentView, this.campaignEx), new h() {
            public void viewInflaterFail(com.mbridge.msdk.video.dynview.c.a aVar) {
                PlayTemplePresenter playTemplePresenter = PlayTemplePresenter.this;
                if (playTemplePresenter.playTempleModel != null) {
                    playTemplePresenter.adShowFail(com.mbridge.msdk.foundation.c.a.a(890008), 890008);
                }
            }

            public void viewInflaterSuccess(com.mbridge.msdk.video.dynview.a aVar) {
                PlayTemplePresenter.this.initDataForView(aVar);
            }
        });
    }

    public void initDataForView(com.mbridge.msdk.video.dynview.a aVar) {
        try {
            preRenderEc();
            if (!parseRemoteViewData(aVar)) {
                this.playTemplateRanderSuccess = false;
                closeAdOrShowEndCard();
                return;
            }
            initPlayer();
            addPrivacy();
            preLoadECMoreOfferData();
        } catch (Exception e5) {
            af.b("PlayTemplePresenter", e5.getMessage());
            adShowFail(com.mbridge.msdk.foundation.c.a.a(890009), 890009);
        }
    }

    public void onBackPressed() {
        if (!this.isAlertShowing && !this.dialogContinueClicked && this.closeBtnVisible) {
            onCloseButtonClick();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        try {
            releaseSource();
            d.a().d(f.SHOW_OR_PRELOAD_WEB_EC);
            d.a().a(this.adapterModel.G());
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }

    public void releaseSource() {
        if (!this.adapterModel.ac()) {
            this.adapterModel.n(true);
            this.playTempleModel.modelReport("2000146");
        }
        this.iView.release();
    }

    public void removeCurrPlayTemplateMoreOfferView(ViewGroup viewGroup) {
        View view;
        if (viewGroup != null && (view = this.moreOfferTemp) != null) {
            viewGroup.removeView(view);
        }
    }

    public void setBackGrandImage() {
        try {
            com.mbridge.msdk.foundation.same.c.b.a(this.context.getApplicationContext()).a(this.campaignEx.getImageUrl(), new com.mbridge.msdk.foundation.same.c.c() {
                public void onFailedLoad(String str, String str2) {
                }

                public void onSuccessLoad(Bitmap bitmap, String str) {
                    if (bitmap != null && !bitmap.isRecycled()) {
                        com.mbridge.msdk.newreward.function.h.a.a(bitmap, new a.C0104a() {
                            public void blurFailCallBack() {
                            }

                            public void blurSuccessCallBack(Bitmap bitmap) {
                                PlayTemplePresenter.this.iView.setBackGroundImage(bitmap);
                            }
                        });
                    }
                }
            });
        } catch (Exception e5) {
            af.b("PlayTemplePresenter", e5.getMessage());
        }
    }

    public void windowFocusChanged() {
        int i5;
        int i6;
        int i7;
        try {
            if (isHalfScreenOffer()) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.data.getRootViewGroup().getLayoutParams();
                layoutParams.gravity = 17;
                if (this.campaignEx.getRewardTemplateMode() != null) {
                    i5 = this.campaignEx.getRewardTemplateMode().b();
                } else {
                    i5 = x.a(this.context).getConfiguration().orientation;
                }
                if (i5 == 1) {
                    i7 = (int) (((float) ak.e(this.context)) * 0.55f);
                    i6 = (int) (((float) ak.f(this.context)) * 0.65f);
                } else {
                    i7 = (int) (((float) ak.e(this.context)) * 0.6f);
                    i6 = (int) (((float) ak.f(this.context)) * 0.6f);
                }
                layoutParams.height = i7;
                layoutParams.width = i6;
                this.iView.setPlayerSize(17, i6, i7);
                return;
            }
            c cVar = this.commandManager;
            Object d5 = cVar.d((Object) cVar.a("fullScreenWidth", Float.valueOf(ak.j(this.context)), "fullScreenHeight", Float.valueOf(ak.i(this.context)), "campaign", this.campaignEx, "orientation", Integer.valueOf(this.context.getResources().getConfiguration().orientation)), f.TEMP_PLAYER_INIT);
            if (d5 instanceof Map) {
                Map map = (Map) d5;
                int intValue = ((Integer) map.get("width")).intValue();
                int intValue2 = ((Integer) map.get("height")).intValue();
                this.iView.setPlayerSize(((Integer) map.get("gravity")).intValue(), intValue, intValue2);
            }
        } catch (Exception e5) {
            af.b("PlayTemplePresenter", e5.getMessage());
        }
    }
}
