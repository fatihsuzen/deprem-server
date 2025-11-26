package com.mbridge.msdk.newreward.player.presenter;

import android.view.View;
import android.widget.FrameLayout;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.a;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.function.g.e;
import com.mbridge.msdk.newreward.player.iview.ICusTemplateView;
import com.mbridge.msdk.newreward.player.iview.IPlayTempleView;
import com.mbridge.msdk.video.dynview.e.h;
import com.mbridge.msdk.video.module.MBridgeClickCTAView;
import com.mbridge.msdk.video.signal.factory.b;
import java.lang.reflect.Proxy;

public class PlayPresenterHalf extends PlayTemplePresenter {
    private ICusTemplateView iTemplateView;
    private MBridgeClickCTAView mClickCTAView;
    private String templateUrl;

    public PlayPresenterHalf(IPlayTempleView iPlayTempleView) {
        super(iPlayTempleView);
        this.iTemplateView = (ICusTemplateView) Proxy.newProxyInstance(iPlayTempleView.getClass().getClassLoader(), new Class[]{ICusTemplateView.class}, new e(iPlayTempleView, this.adapterModel, this.commandManager));
        CampaignEx campaignEx = this.campaignEx;
        if (campaignEx != null) {
            this.templateUrl = campaignEx.getRewardTemplateMode().e();
        }
    }

    private void addCTAView() {
        if (this.mClickCTAView == null) {
            MBridgeClickCTAView mBridgeClickCTAView = new MBridgeClickCTAView(this.context);
            this.mClickCTAView = mBridgeClickCTAView;
            mBridgeClickCTAView.setCampaign(this.campaignEx);
            this.mClickCTAView.setUnitId(this.adapterModel.H());
            this.mClickCTAView.preLoadData((b) null);
            this.mClickCTAView.setCtaClickCallBack(new MBridgeClickCTAView.a() {
                public void ctaClick() {
                    CampaignEx campaignEx = PlayPresenterHalf.this.campaignEx;
                    if (campaignEx != null) {
                        campaignEx.setClickTempSource(a.f9450g);
                        PlayPresenterHalf.this.campaignEx.setTriggerClickSource(a.f9456m);
                    }
                    PlayPresenterHalf playPresenterHalf = PlayPresenterHalf.this;
                    playPresenterHalf.playTempleModel.onAdClick(playPresenterHalf.mBridgeIds);
                    PlayPresenterHalf playPresenterHalf2 = PlayPresenterHalf.this;
                    playPresenterHalf2.playTempleModel.eventClickUrl(playPresenterHalf2.redirectModel);
                    PlayPresenterHalf playPresenterHalf3 = PlayPresenterHalf.this;
                    playPresenterHalf3.playTempleModel.eventTrackingForClick(playPresenterHalf3.redirectModel);
                }
            });
        }
        this.iTemplateView.addCTAViewToLayout(this.mClickCTAView, 0);
    }

    public void click(View view) {
        super.click(view);
        try {
            if (view.getId() != filterFindViewId(this.is_dy, "mbridge_rl_playing_close")) {
                return;
            }
            if (this.ivRewardMode == com.mbridge.msdk.foundation.same.a.f9165H) {
                showIVRewardDialogOnCloseMode();
                return;
            }
            c cVar = this.commandManager;
            cVar.g(cVar.a("add_temple", "HALF_TEMPLATE_EC", "adapter_model", this.adapterModel, "parent_temple", this.data.getRootViewGroup()), f.SHOW_ADD_TEMPLE);
            this.iView.removeTempleFromSuperView(this.data.getRootViewGroup());
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }

    public void getView() {
        com.mbridge.msdk.video.dynview.b.a().a(new com.mbridge.msdk.video.dynview.j.c().a(this.rootParentView, this.campaignEx, com.mbridge.msdk.newreward.function.h.c.b(this.templateUrl)), new h() {
            public void viewInflaterFail(com.mbridge.msdk.video.dynview.c.a aVar) {
                PlayPresenterHalf playPresenterHalf = PlayPresenterHalf.this;
                if (playPresenterHalf.playTempleModel != null) {
                    playPresenterHalf.adShowFail(com.mbridge.msdk.foundation.c.a.a(890008), 890008);
                }
            }

            public void viewInflaterSuccess(com.mbridge.msdk.video.dynview.a aVar) {
                PlayPresenterHalf.this.initDataForView(aVar);
            }
        });
    }

    public void onPlayStarted(int i5) {
        super.onPlayStarted(i5);
        addCTAView();
    }

    public void setHalfWH() {
        int i5;
        int i6;
        int i7;
        this.data.getRootViewGroup().setBackgroundColor(-1728053248);
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
        this.data.getRootViewGroup().setLayoutParams(layoutParams);
    }
}
