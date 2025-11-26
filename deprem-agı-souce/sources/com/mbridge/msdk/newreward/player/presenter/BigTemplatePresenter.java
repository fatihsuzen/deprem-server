package com.mbridge.msdk.newreward.player.presenter;

import android.app.Activity;
import android.content.Context;
import android.widget.RelativeLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.function.g.e;
import com.mbridge.msdk.newreward.player.imodel.IBigTempModel;
import com.mbridge.msdk.newreward.player.iview.IBaseView;
import com.mbridge.msdk.newreward.player.model.BigTemplateModel;
import com.mbridge.msdk.video.dynview.b;
import com.mbridge.msdk.video.dynview.c.a;
import com.mbridge.msdk.video.dynview.e.d;
import com.mbridge.msdk.video.dynview.e.h;
import java.lang.reflect.Proxy;
import java.util.HashMap;

public class BigTemplatePresenter extends AbsPresenter implements d {
    BigTemplateModel bigTemplateModel;
    IBigTempModel iBigTempModel;
    IBaseView iView;
    CampaignEx.c rewardTemplateMode;
    int videoTemplateCode = TypedValues.Custom.TYPE_BOOLEAN;

    public BigTemplatePresenter(IBaseView iBaseView) {
        super(iBaseView);
        this.redirectModel.setCampaignEx(getDefaultCampaign(this.adapterModel));
        this.TEMPLATE_MARK_TYPE = 1;
        this.iView = iBaseView;
        BigTemplateModel bigTemplateModel2 = new BigTemplateModel(this.commandManager, this.rewardVideoListener);
        this.bigTemplateModel = bigTemplateModel2;
        this.iBigTempModel = (IBigTempModel) Proxy.newProxyInstance(bigTemplateModel2.getClass().getClassLoader(), new Class[]{IBigTempModel.class}, new e(this.bigTemplateModel, this.adapterModel, this.commandManager));
    }

    private CampaignEx getDefaultCampaign(com.mbridge.msdk.newreward.a.e eVar) {
        try {
            if (eVar.D() == null || eVar.D().a() == null || eVar.D().a().isEmpty()) {
                return null;
            }
            return eVar.D().a().get(0);
        } catch (Exception e5) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            e5.printStackTrace();
            return null;
        }
    }

    public void adShowFail(String str, int i5) {
        if (!this.adapterModel.Y()) {
            this.adapterModel.j(true);
            super.adShowFail(str, i5);
            IBigTempModel iBigTempModel2 = this.iBigTempModel;
            if (iBigTempModel2 != null) {
                iBigTempModel2.onShowFail(this.mBridgeIds, str, i5);
            }
            finish(true);
        }
    }

    public void adShowSuccess() {
        if (!this.adapterModel.ah()) {
            this.adapterModel.q(true);
            this.iBigTempModel.onAdShow(this.mBridgeIds);
            this.iBigTempModel.eventOnlyImpression(this.redirectModel);
        }
    }

    public void countDownClick() {
        CampaignEx defaultCampaign = getDefaultCampaign(this.adapterModel);
        if (defaultCampaign == null) {
            finish(true);
            return;
        }
        try {
            this.adapterModel.a(defaultCampaign);
            CampaignEx.c cVar = this.rewardTemplateMode;
            if (cVar != null) {
                this.videoTemplateCode = cVar.f();
            }
            c cVar2 = this.commandManager;
            cVar2.g(cVar2.a("add_temple", Integer.valueOf(this.videoTemplateCode), "template_type", 17, "parent_temple", this.data.getRootViewGroup(), "adapter_model", this.adapterModel), f.SHOW_ADD_TEMPLE);
            this.iView.removeTempleFromSuperView(this.data.getRootViewGroup());
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }

    public void finish(boolean z4) {
        if (z4) {
            Context context = this.context;
            if (context instanceof Activity) {
                ((Activity) context).finish();
            }
        }
    }

    public void getView() {
        com.mbridge.msdk.video.dynview.c a5 = new com.mbridge.msdk.video.dynview.j.c().a(this.context, this.adapterModel.D().a());
        HashMap hashMap = new HashMap();
        hashMap.put("choice_one_callback", this);
        b.a().a(a5, new h() {
            public void viewInflaterFail(a aVar) {
                BigTemplatePresenter.this.adShowFail(com.mbridge.msdk.foundation.c.a.a(890008), 890008);
            }

            public void viewInflaterSuccess(com.mbridge.msdk.video.dynview.a aVar) {
                BigTemplatePresenter.this.initDataForView(aVar);
            }
        }, hashMap);
    }

    public void initDataForView(com.mbridge.msdk.video.dynview.a aVar) {
        if (aVar != null) {
            try {
                if (aVar.a() != null) {
                    aVar.a().setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                    this.iView.addViewToCurrentViewGroup(aVar.a());
                }
                this.is_dy = aVar.c();
                adShowSuccess();
                this.iView.initViews(this.is_dy);
            } catch (Exception e5) {
                adShowFail(com.mbridge.msdk.foundation.c.a.a(890008), 890008);
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }

    public void itemClick(CampaignEx campaignEx) {
        if (campaignEx == null) {
            finish(true);
            return;
        }
        try {
            campaignEx.setShowType(com.mbridge.msdk.foundation.same.report.d.a.f9447d);
            this.campaignEx = campaignEx;
            this.adapterModel.a(campaignEx);
            CampaignEx.c rewardTemplateMode2 = campaignEx.getRewardTemplateMode();
            this.rewardTemplateMode = rewardTemplateMode2;
            if (rewardTemplateMode2 != null) {
                this.videoTemplateCode = rewardTemplateMode2.f();
            }
            c cVar = this.commandManager;
            cVar.g(cVar.a("add_temple", Integer.valueOf(this.videoTemplateCode), "template_type", 17, "adapter_model", this.adapterModel, "parent_temple", this.data.getRootViewGroup()), f.SHOW_ADD_TEMPLE);
            this.iView.removeTempleFromSuperView(this.data.getRootViewGroup());
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }

    public void releaseSource() {
    }
}
