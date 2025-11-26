package com.mbridge.msdk.newreward.player.presenter;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import b.w;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.c.b;
import com.mbridge.msdk.foundation.same.c.c;
import com.mbridge.msdk.foundation.same.report.d.a;
import com.mbridge.msdk.foundation.tools.ae;
import com.mbridge.msdk.newreward.player.iview.IECoverTemplateView;
import com.mbridge.msdk.newreward.player.iview.IPlayTempleView;

public class PlayPresenterEndCover extends PlayTemplePresenter {
    IECoverTemplateView ieCoverTemplateView;

    public PlayPresenterEndCover(IPlayTempleView iPlayTempleView) {
        super(iPlayTempleView);
        if (iPlayTempleView instanceof IECoverTemplateView) {
            this.ieCoverTemplateView = (IECoverTemplateView) iPlayTempleView;
        }
    }

    private void setViewSourceInfo() {
        if (this.campaignEx != null) {
            try {
                if (w.a(this.ieCoverTemplateView)) {
                    this.ieCoverTemplateView.setTitle(this.campaignEx.getAppName());
                    this.ieCoverTemplateView.setCtaBtn(this.campaignEx.getAdCall());
                    this.ieCoverTemplateView.setDesc(this.campaignEx.getAppDesc());
                    if (!TextUtils.isEmpty(this.campaignEx.getIconUrl())) {
                        b.a(this.context.getApplicationContext()).a(this.campaignEx.getIconUrl(), new c() {
                            public void onFailedLoad(String str, String str2) {
                            }

                            public void onSuccessLoad(Bitmap bitmap, String str) {
                                if (bitmap != null) {
                                    try {
                                        if (!bitmap.isRecycled()) {
                                            PlayPresenterEndCover.this.ieCoverTemplateView.setIconImageView(ae.a(bitmap, 1, 8));
                                        }
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
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }

    public void click(View view) {
        try {
            if (view.getId() == filterFindViewId(false, "mbridge_vec_iv_close")) {
                finish(true);
            } else if (view.getId() == filterFindViewId(false, "mbridge_vec_btn")) {
                CampaignEx campaignEx = this.campaignEx;
                if (campaignEx != null) {
                    campaignEx.setClickTempSource(a.f9450g);
                    this.campaignEx.setTriggerClickSource(a.f9456m);
                }
                this.playTempleModel.onAdClick(this.mBridgeIds);
                this.playTempleModel.eventClickUrl(this.redirectModel);
                this.playTempleModel.eventTrackingForClick(this.redirectModel);
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
            finish(true);
        }
    }

    public void getView() {
        this.iView.initViews(false);
        setViewSourceInfo();
    }
}
