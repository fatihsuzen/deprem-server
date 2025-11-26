package com.mbridge.msdk.newreward.player.presenter;

import android.widget.FrameLayout;
import com.mbridge.msdk.e.b;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.newreward.function.g.e;
import com.mbridge.msdk.newreward.player.iview.IECTempleView;
import com.mbridge.msdk.video.dynview.c;
import com.mbridge.msdk.video.dynview.c.a;
import com.mbridge.msdk.video.dynview.e.h;
import java.lang.reflect.Proxy;

public class ECHalfPresenter extends ECTemplePresenter {
    IECTempleView iCusECTemplateView;

    public ECHalfPresenter(IECTempleView iECTempleView) {
        super(iECTempleView);
        this.iCusECTemplateView = (IECTempleView) Proxy.newProxyInstance(iECTempleView.getClass().getClassLoader(), new Class[]{IECTempleView.class}, new e(iECTempleView, this.adapterModel, this.commandManager));
    }

    public void getView() {
        String str;
        if (b.a()) {
            str = "cn_";
        } else {
            str = "en_";
        }
        c b5 = new com.mbridge.msdk.video.dynview.j.c().b(this.context, this.campaignEx, -1, str);
        this.nLogo = b5.n();
        com.mbridge.msdk.video.dynview.b.a().a(b5, new h() {
            public void viewInflaterFail(a aVar) {
            }

            public void viewInflaterSuccess(com.mbridge.msdk.video.dynview.a aVar) {
                ECHalfPresenter.this.initDataForView(aVar);
            }
        });
    }

    public void setHalfWH() {
        int i5;
        int i6;
        int i7;
        try {
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
            this.data.getRootViewGroup().setLayoutParams(layoutParams);
        } catch (Throwable th) {
            af.b("ECHalfPresenter", th.getMessage());
        }
    }
}
