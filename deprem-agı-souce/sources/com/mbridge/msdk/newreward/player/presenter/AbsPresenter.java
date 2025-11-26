package com.mbridge.msdk.newreward.player.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.newout.RewardVideoListener;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.d;
import com.mbridge.msdk.newreward.player.iview.IBaseView;
import com.mbridge.msdk.newreward.player.iview.IMetaData;
import com.mbridge.msdk.newreward.player.redirect.RedirectModel;
import com.mbridge.msdk.out.MBridgeIds;

public abstract class AbsPresenter {
    int TEMPLATE_MARK_TYPE;
    e adapterModel;
    CampaignEx campaignEx;
    int closeAlert;
    c commandManager;
    Context context;
    IMetaData data;
    boolean isIV;
    boolean is_dy;
    int ivRewardAlertViewStatus = a.f9163F;
    int ivRewardMode;
    int ivRewardValue;
    int ivRewardValueType;
    MBridgeIds mBridgeIds;
    View moreOfferTemp;
    RedirectModel redirectModel;
    com.mbridge.msdk.videocommon.b.c reward;
    RewardVideoListener rewardVideoListener;
    ViewGroup rootParentView;
    int videoEndType;
    int videoSkipResult;
    int videoSkipTime;

    public AbsPresenter(IBaseView iBaseView) {
        ViewGroup viewGroup = (ViewGroup) iBaseView;
        this.rootParentView = viewGroup;
        Context context2 = viewGroup.getContext();
        this.context = context2;
        IMetaData iMetaData = (IMetaData) context2;
        this.data = iMetaData;
        this.adapterModel = (e) iMetaData.getDate();
        this.commandManager = d.a().b();
        this.campaignEx = this.adapterModel.U();
        this.mBridgeIds = this.adapterModel.S();
        this.rewardVideoListener = this.adapterModel.K();
        RedirectModel redirectModel2 = new RedirectModel();
        this.redirectModel = redirectModel2;
        redirectModel2.setCampaignEx(this.campaignEx);
        this.redirectModel.setContext(this.context);
        this.redirectModel.setSettingModel(this.adapterModel.x());
        this.redirectModel.setUnitId(this.adapterModel.H());
        this.redirectModel.setDevExtraData(this.adapterModel.W());
        prepareShowParameter();
        buildReward("");
    }

    private void buildReward(String str) {
        if (this.campaignEx != null) {
            this.reward = com.mbridge.msdk.videocommon.b.c.b(str);
            com.mbridge.msdk.videocommon.d.c b5 = this.adapterModel.x().b();
            if (b5 != null) {
                this.reward.a(b5.m());
                this.reward.a(b5.n());
            }
            com.mbridge.msdk.videocommon.b.c cVar = this.reward;
            if (cVar != null && cVar.b() <= 0) {
                this.reward.a(1);
            }
            try {
                if (this.campaignEx.getRewardPlus() != null) {
                    RewardPlus rewardPlus = this.campaignEx.getRewardPlus();
                    if (!TextUtils.isEmpty(rewardPlus.getName()) && rewardPlus.getAmount() > 0) {
                        com.mbridge.msdk.videocommon.b.c cVar2 = new com.mbridge.msdk.videocommon.b.c(rewardPlus.getName(), rewardPlus.getAmount());
                        this.reward = cVar2;
                        if (cVar2.b() < 0) {
                            this.reward.a(1);
                        }
                    }
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
            RedirectModel redirectModel2 = this.redirectModel;
            if (redirectModel2 != null) {
                redirectModel2.setReward(this.reward);
            }
        }
    }

    private void prepareShowParameter() {
        int i5;
        boolean z4;
        if (this.campaignEx != null) {
            if (this.adapterModel.h() == 0) {
                i5 = this.campaignEx.getAdType();
            } else {
                i5 = this.adapterModel.h();
            }
            if (i5 == 287) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.isIV = z4;
            if (z4) {
                this.ivRewardMode = this.adapterModel.L();
                this.ivRewardValueType = this.adapterModel.u();
                this.ivRewardValue = this.adapterModel.v();
            }
            this.closeAlert = this.adapterModel.x().b().i();
            CampaignEx campaignEx2 = this.campaignEx;
            if (campaignEx2 == null || campaignEx2.getVst() <= -2) {
                this.videoSkipTime = this.adapterModel.x().b().e();
            } else {
                this.videoSkipTime = this.campaignEx.getVst();
            }
            this.videoSkipResult = this.adapterModel.x().b().f();
            this.videoEndType = this.campaignEx.getVideo_end_type();
        }
    }

    public void adClosed() {
    }

    public void adShowFail(String str, int i5) {
        e eVar = this.adapterModel;
        if (eVar != null) {
            eVar.j(true);
            com.mbridge.msdk.newreward.function.d.c.a().b().a(this.adapterModel.h(), this.adapterModel.C(), this.adapterModel.H(), this.adapterModel.G(), 7);
        }
    }

    public void adShowSuccess() {
        e eVar = this.adapterModel;
        if (eVar != null) {
            eVar.j(true);
            com.mbridge.msdk.newreward.function.d.c.a().b().a(this.adapterModel.h(), this.adapterModel.C(), this.adapterModel.H(), this.adapterModel.G(), 6);
        }
    }

    public void click(View view) {
    }

    public int filterFindViewId(boolean z4, String str) {
        if (z4) {
            return findDyID(str);
        }
        return findID(str);
    }

    public int findDyID(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.hashCode();
        }
        return -1;
    }

    public int findID(String str) {
        return x.a(this.context.getApplicationContext(), str, "id");
    }

    public abstract void finish(boolean z4);

    public abstract void getView();

    public abstract void initDataForView(com.mbridge.msdk.video.dynview.a aVar);

    /* access modifiers changed from: protected */
    public boolean isIVRewardEnable() {
        if (!this.isIV) {
            return false;
        }
        int i5 = this.ivRewardMode;
        if (i5 == a.f9166I || i5 == a.f9165H) {
            return true;
        }
        return false;
    }

    public boolean isNotNULL(View... viewArr) {
        if (viewArr == null) {
            return false;
        }
        int length = viewArr.length;
        int i5 = 0;
        boolean z4 = false;
        while (i5 < length) {
            if (viewArr[i5] == null) {
                return false;
            }
            i5++;
            z4 = true;
        }
        return z4;
    }

    public void onDestroy() {
    }

    public abstract void releaseSource();
}
