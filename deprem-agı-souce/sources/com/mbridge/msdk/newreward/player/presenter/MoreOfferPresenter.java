package com.mbridge.msdk.newreward.player.presenter;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.newreward.a.b.b;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.function.g.e;
import com.mbridge.msdk.newreward.player.imodel.IMoreOfferModel;
import com.mbridge.msdk.newreward.player.iview.IMoreOfferTemplateView;
import com.mbridge.msdk.newreward.player.model.MoreOfferModel;
import com.mbridge.msdk.newreward.player.redirect.MoreOfferRedirectModel;
import com.mbridge.msdk.video.dynview.a;
import com.mbridge.msdk.video.dynview.widget.MBridgeRelativeLayout;
import com.mbridge.msdk.videocommon.view.RoundImageView;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class MoreOfferPresenter extends AbsPresenter {
    List<Integer> ImageLoadReadyCountList = new ArrayList();
    private final String TAG = "MoreOfferTemplatePresenter";
    private int admf;
    private int admftm;
    /* access modifiers changed from: private */
    public b callOutReqCallBack;
    IMoreOfferModel iMoreOfferModel;
    IMoreOfferTemplateView iMoreOfferTemplateView;
    int iconBufferCount = 2;
    /* access modifiers changed from: private */
    public final ImageLoadCountCallBack imageLoadCountCallBack = new ImageLoadCountCallBack() {
        public void loadCountCallback() {
            MoreOfferPresenter moreOfferPresenter = MoreOfferPresenter.this;
            if (!moreOfferPresenter.isShown) {
                int size = moreOfferPresenter.ImageLoadReadyCountList.size();
                MoreOfferPresenter moreOfferPresenter2 = MoreOfferPresenter.this;
                if (size >= moreOfferPresenter2.initCanShowMaxCount && moreOfferPresenter2.callOutReqCallBack != null) {
                    MoreOfferPresenter moreOfferPresenter3 = MoreOfferPresenter.this;
                    moreOfferPresenter3.isShown = true;
                    if (!moreOfferPresenter3.moreOfferModel.mImpressionId.contains(0)) {
                        MoreOfferPresenter.this.setItemRedirectModel(0);
                        MoreOfferPresenter.this.doMoreOfferOnlyImpression();
                    }
                    MoreOfferPresenter.this.callOutReqCallBack.reqSuccessful(MoreOfferPresenter.this.rootParentView);
                    MoreOfferPresenter.this.linearLayout.postDelayed(new Runnable() {
                        public void run() {
                            MoreOfferPresenter.this.checkItemVisibleState();
                            MoreOfferPresenter.this.reportAdmfImpression();
                        }
                    }, 500);
                    IMoreOfferModel iMoreOfferModel = MoreOfferPresenter.this.iMoreOfferModel;
                    iMoreOfferModel.onMoreOfferShow(MoreOfferPresenter.this.moreOfferType + "");
                }
            }
        }
    };
    int initCanShowMaxCount;
    boolean isShown = false;
    LinearLayout linearLayout;
    com.mbridge.msdk.newreward.function.c.a.b moreOfferMBridgeCampaigns;
    MoreOfferModel moreOfferModel;
    MoreOfferRedirectModel moreOfferRedirectModel;
    /* access modifiers changed from: private */
    public int moreOfferType;

    interface ImageLoadCountCallBack {
        void loadCountCallback();
    }

    private class MoreOfferBuildCallback implements b {
        private MoreOfferBuildCallback() {
        }

        public void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
            if (MoreOfferPresenter.this.callOutReqCallBack != null) {
                MoreOfferPresenter.this.callOutReqCallBack.reqFailed(bVar);
            }
        }

        public void reqSuccessful(Object obj) {
            IMoreOfferTemplateView iMoreOfferTemplateView = MoreOfferPresenter.this.iMoreOfferTemplateView;
            if (iMoreOfferTemplateView != null) {
                try {
                    iMoreOfferTemplateView.addViewToObservableScrollView((View) obj);
                    MoreOfferPresenter moreOfferPresenter = MoreOfferPresenter.this;
                    moreOfferPresenter.linearLayout = (LinearLayout) obj;
                    moreOfferPresenter.addMoreOfferLikeText();
                    MoreOfferPresenter moreOfferPresenter2 = MoreOfferPresenter.this;
                    if (moreOfferPresenter2.rootParentView != null) {
                        moreOfferPresenter2.calculateCanShowCount();
                    }
                } catch (Exception e5) {
                    if (MBridgeConstans.DEBUG) {
                        e5.printStackTrace();
                    }
                }
            }
        }
    }

    private class MoreOfferCampaignRequestCallback implements b {
        private MoreOfferCampaignRequestCallback() {
        }

        public void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
            IMoreOfferModel iMoreOfferModel = MoreOfferPresenter.this.iMoreOfferModel;
            if (iMoreOfferModel != null) {
                iMoreOfferModel.onMoreOfferRes(bVar.a() + "", "2", "1");
            }
            af.b("", bVar.b());
        }

        public void reqSuccessful(Object obj) {
            try {
                if (obj instanceof com.mbridge.msdk.newreward.function.c.a.b) {
                    com.mbridge.msdk.newreward.function.c.a.b bVar = (com.mbridge.msdk.newreward.function.c.a.b) obj;
                    MoreOfferPresenter.this.moreOfferMBridgeCampaigns = bVar;
                    if (bVar.E() != null) {
                        if (MoreOfferPresenter.this.moreOfferMBridgeCampaigns.E().size() >= 5) {
                            IMoreOfferModel iMoreOfferModel = MoreOfferPresenter.this.iMoreOfferModel;
                            if (iMoreOfferModel != null) {
                                iMoreOfferModel.onMoreOfferRes("1", "1");
                            }
                            MoreOfferPresenter moreOfferPresenter = MoreOfferPresenter.this;
                            c cVar = moreOfferPresenter.commandManager;
                            cVar.e((Object) cVar.a("campaign", moreOfferPresenter.campaignEx, "more_offer_campaign", obj, "command_type", f.BUILD_MORE_OFFER), (b) new MoreOfferBuildCallback());
                            return;
                        }
                    }
                    IMoreOfferModel iMoreOfferModel2 = MoreOfferPresenter.this.iMoreOfferModel;
                    if (iMoreOfferModel2 != null) {
                        iMoreOfferModel2.onMoreOfferRes("12930014", "2", "1");
                    }
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }

    public MoreOfferPresenter(IMoreOfferTemplateView iMoreOfferTemplateView2) {
        super(iMoreOfferTemplateView2);
        this.iMoreOfferTemplateView = (IMoreOfferTemplateView) Proxy.newProxyInstance(iMoreOfferTemplateView2.getClass().getClassLoader(), new Class[]{IMoreOfferTemplateView.class}, new e(iMoreOfferTemplateView2, this.adapterModel, this.commandManager));
        this.moreOfferModel = new MoreOfferModel(this.commandManager);
        if (!(this.adapterModel.E() == null || this.adapterModel.E().f10954a == null)) {
            this.moreOfferModel.mImpressionId.addAll(this.adapterModel.E().f10954a);
        }
        this.iMoreOfferModel = (IMoreOfferModel) Proxy.newProxyInstance(this.moreOfferModel.getClass().getClassLoader(), new Class[]{IMoreOfferModel.class}, new e(this.moreOfferModel, this.adapterModel, this.commandManager));
        MoreOfferRedirectModel moreOfferRedirectModel2 = new MoreOfferRedirectModel();
        this.moreOfferRedirectModel = moreOfferRedirectModel2;
        moreOfferRedirectModel2.setContext(this.context);
        this.moreOfferRedirectModel.setSettingModel(this.adapterModel.x());
    }

    /* access modifiers changed from: private */
    public void addMoreOfferLikeText() {
        if (this.iMoreOfferTemplateView != null) {
            try {
                if (ab.t(com.mbridge.msdk.foundation.controller.c.m().c()).contains("zh")) {
                    this.iMoreOfferTemplateView.addMoreOfferLikeText("猜你喜欢", ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 30.0f));
                } else {
                    this.iMoreOfferTemplateView.addMoreOfferLikeText("Just\nfor\nYou", 0);
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void calculateCanShowCount() {
        LinearLayout linearLayout2 = this.linearLayout;
        if (linearLayout2 != null && linearLayout2.getChildCount() > 5) {
            try {
                this.initCanShowMaxCount = ((ak.f(com.mbridge.msdk.foundation.controller.c.m().c()) - ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 40.0f)) / ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 70.0f)) + this.admf;
                if (this.linearLayout.getChildCount() < this.initCanShowMaxCount) {
                    this.initCanShowMaxCount = this.linearLayout.getChildCount();
                }
                if (this.linearLayout.getChildCount() >= this.initCanShowMaxCount) {
                    for (int i5 = 0; i5 < this.initCanShowMaxCount; i5++) {
                        View childAt = this.linearLayout.getChildAt(i5);
                        if (childAt != null) {
                            loadIconImageUrl(childAt, i5);
                        }
                    }
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void checkItemVisibleState() {
        if (this.linearLayout != null) {
            int i5 = 0;
            while (i5 < this.linearLayout.getChildCount()) {
                try {
                    this.moreOfferRedirectModel.setItemPositionId(i5);
                    if (!this.moreOfferModel.mImpressionId.contains(Integer.valueOf(i5))) {
                        View childAt = this.linearLayout.getChildAt(i5);
                        if (childAt != null) {
                            setItemRedirectModel(i5);
                            setMoreOfferItemClickListener(childAt);
                            doMoreOfferImpression(childAt, i5);
                        }
                    }
                    i5++;
                } catch (Exception e5) {
                    if (MBridgeConstans.DEBUG) {
                        e5.printStackTrace();
                        return;
                    }
                    return;
                }
            }
        }
    }

    private void doMoreOfferImpression(View view, int i5) {
        boolean z4;
        List<Integer> list;
        if (this.moreOfferModel != null) {
            try {
                Rect rect = new Rect();
                boolean globalVisibleRect = view.getGlobalVisibleRect(rect);
                if (rect.width() > view.getMeasuredWidth() / 5) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (!globalVisibleRect || !z4) {
                    if (this.iconBufferCount <= 2 && (list = this.ImageLoadReadyCountList) != null && !list.contains(Integer.valueOf(i5))) {
                        loadIconImageUrl(view, i5);
                    }
                    this.iconBufferCount++;
                    return;
                }
                this.iconBufferCount = 1;
                List<Integer> list2 = this.ImageLoadReadyCountList;
                if (list2 != null && !list2.contains(Integer.valueOf(i5))) {
                    loadIconImageUrl(view, i5);
                }
                this.moreOfferModel.eventImpression(this.moreOfferRedirectModel);
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void doMoreOfferOnlyImpression() {
        MoreOfferModel moreOfferModel2 = this.moreOfferModel;
        if (moreOfferModel2 != null) {
            moreOfferModel2.eventOnlyImpression(this.moreOfferRedirectModel);
        }
    }

    private CampaignEx getCampaignEx(int i5) {
        try {
            if (this.adapterModel.E() == null) {
                return null;
            }
            int i6 = this.moreOfferType;
            if (i6 != 1) {
                if (i6 != 2) {
                    return null;
                }
                if (this.adapterModel.E().b() == null || this.adapterModel.E().b().E() == null || this.adapterModel.E().b().E().isEmpty()) {
                    return null;
                }
                return this.adapterModel.E().b().E().get(i5);
            } else if (this.adapterModel.E().a() == null || this.adapterModel.E().a().E() == null || this.adapterModel.E().a().E().isEmpty()) {
                return null;
            } else {
                return this.adapterModel.E().a().E().get(i5);
            }
        } catch (Exception e5) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            e5.printStackTrace();
            return null;
        }
    }

    private void loadIconImageUrl(View view, final int i5) {
        com.mbridge.msdk.newreward.function.c.a.b bVar = this.moreOfferMBridgeCampaigns;
        if (bVar != null) {
            try {
                List<CampaignEx> E4 = bVar.E();
                if (E4 != null && E4.size() > i5) {
                    final RoundImageView roundImageView = (RoundImageView) view.findViewById(x.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_end_card_item_iv", "id"));
                    com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(E4.get(i5).getIconUrl(), new com.mbridge.msdk.foundation.same.c.c() {
                        public void onFailedLoad(String str, String str2) {
                        }

                        public void onSuccessLoad(Bitmap bitmap, String str) {
                            if (bitmap != null) {
                                try {
                                    List<Integer> list = MoreOfferPresenter.this.ImageLoadReadyCountList;
                                    if (list != null) {
                                        list.add(Integer.valueOf(i5));
                                    }
                                    roundImageView.setBorderRadius(13);
                                    roundImageView.setImageBitmap(bitmap);
                                    MoreOfferPresenter.this.imageLoadCountCallBack.loadCountCallback();
                                } catch (Exception e5) {
                                    if (MBridgeConstans.DEBUG) {
                                        e5.printStackTrace();
                                    }
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

    /* access modifiers changed from: private */
    public void reportAdmfImpression() {
        int i5 = 0;
        while (i5 < this.initCanShowMaxCount) {
            try {
                if (!this.moreOfferModel.mImpressionId.contains(Integer.valueOf(i5))) {
                    this.moreOfferRedirectModel.setItemPositionId(i5);
                    setItemRedirectModel(i5);
                    this.moreOfferModel.eventImpression(this.moreOfferRedirectModel);
                }
                i5++;
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                    return;
                }
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public void setItemRedirectModel(int i5) {
        if (this.adapterModel != null && this.moreOfferRedirectModel != null) {
            String str = "117361";
            try {
                CampaignEx campaignEx = getCampaignEx(i5);
                String str2 = "";
                if (campaignEx != null) {
                    this.moreOfferRedirectModel.setCampaignEx(campaignEx);
                    str2 = aq.a(campaignEx.getendcard_url(), "mof_testuid");
                    if (TextUtils.isEmpty(str2)) {
                        str2 = aq.a(campaignEx.getendcard_url(), "mof_uid");
                    }
                }
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.moreOfferRedirectModel.setUnitId(str);
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }

    private void setMoreOfferItemClickListener(View view) {
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MoreOfferPresenter moreOfferPresenter = MoreOfferPresenter.this;
                    MoreOfferModel moreOfferModel = moreOfferPresenter.moreOfferModel;
                    if (moreOfferModel != null) {
                        try {
                            moreOfferModel.eventClickUrl(moreOfferPresenter.moreOfferRedirectModel);
                        } catch (Exception e5) {
                            if (MBridgeConstans.DEBUG) {
                                e5.printStackTrace();
                            }
                        }
                    }
                }
            });
        }
    }

    public void click(View view) {
        if (this.iMoreOfferTemplateView != null && view != null && view.getId() == filterFindViewId(false, "mbridge_reward_end_card_like_tv")) {
            this.iMoreOfferTemplateView.setObservableScrollViewVisible();
        }
    }

    public void finish(boolean z4) {
    }

    public void getAdMFTmValue(int i5) {
        JSONObject jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject(this.campaignEx.getMoreOfferJsonData());
            if (i5 == 1) {
                jSONObject = jSONObject2.getJSONObject("template_url");
            } else if (i5 != 2) {
                jSONObject = null;
            } else {
                jSONObject = jSONObject2.getJSONObject(CampaignEx.ENDCARD_URL);
            }
            if (jSONObject != null) {
                if (jSONObject.has(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMFTM)) {
                    this.admftm = jSONObject.getInt(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMFTM);
                }
                if (jSONObject.has(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMF)) {
                    this.admf = jSONObject.getInt(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMF);
                }
            }
        } catch (Exception e5) {
            af.b("MoreOfferTemplatePresenter", e5.getMessage());
        }
    }

    public void getView() {
        if (this.iMoreOfferTemplateView != null) {
            try {
                MBridgeRelativeLayout mBridgeRelativeLayout = (MBridgeRelativeLayout) LayoutInflater.from(this.context).inflate(x.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_more_offer_view", TtmlNode.TAG_LAYOUT), (ViewGroup) null, false);
                if (mBridgeRelativeLayout != null) {
                    this.iMoreOfferTemplateView.addViewToCurrentViewGroup(mBridgeRelativeLayout);
                    mBridgeRelativeLayout.setBackgroundColor(-1);
                }
                this.iMoreOfferTemplateView.initViews(false);
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }

    public void initDataForView(a aVar) {
    }

    public void onTouch(View view) {
        if (view != null && view.getId() == filterFindViewId(false, "mbridge_moreoffer_hls")) {
            checkItemVisibleState();
        }
    }

    public void releaseSource() {
    }

    public void setIReqCallBack(b bVar) {
        this.callOutReqCallBack = bVar;
    }

    public void syncLoad(int i5) {
        int i6 = i5;
        this.moreOfferType = i6;
        if (this.campaignEx != null) {
            getAdMFTmValue(i5);
            if (i6 == 1) {
                this.iMoreOfferModel.onMoreOfferReq("1");
                c cVar = this.commandManager;
                cVar.e((Object) cVar.a("campaign", this.campaignEx, "command_type", f.REQ_MORE_OFFER_CAMPAIGN, "more_offer_type", 1, "adapter_model", this.adapterModel), (b) new MoreOfferCampaignRequestCallback());
            } else if (i6 == 2) {
                try {
                    if (this.adapterModel.E().b() != null) {
                        this.moreOfferMBridgeCampaigns = this.adapterModel.E().b();
                        if (this.adapterModel.E().b().E().size() >= 5) {
                            c cVar2 = this.commandManager;
                            cVar2.e((Object) cVar2.a("campaign", this.campaignEx, "more_offer_campaign", this.adapterModel.E().b(), "command_type", f.BUILD_MORE_OFFER), (b) new MoreOfferBuildCallback());
                            return;
                        }
                        return;
                    }
                    this.iMoreOfferModel.onMoreOfferReq("1");
                    c cVar3 = this.commandManager;
                    cVar3.e((Object) cVar3.a("campaign", this.campaignEx, "command_type", f.REQ_MORE_OFFER_CAMPAIGN, "more_offer_type", 2, "adapter_model", this.adapterModel), (b) new MoreOfferCampaignRequestCallback());
                } catch (Exception e5) {
                    if (MBridgeConstans.DEBUG) {
                        e5.printStackTrace();
                    }
                }
            }
        }
    }
}
