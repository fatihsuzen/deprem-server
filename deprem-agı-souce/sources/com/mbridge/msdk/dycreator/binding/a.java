package com.mbridge.msdk.dycreator.binding;

import android.text.TextUtils;
import android.view.View;
import com.mbridge.msdk.dycreator.baseview.MBCountDownView;
import com.mbridge.msdk.dycreator.baseview.MBLinearLayout;
import com.mbridge.msdk.dycreator.baseview.MBRelativeLayout;
import com.mbridge.msdk.dycreator.baseview.inter.InterBase;
import com.mbridge.msdk.dycreator.binding.a.b;
import com.mbridge.msdk.dycreator.binding.a.c;
import com.mbridge.msdk.dycreator.binding.a.e;
import com.mbridge.msdk.dycreator.binding.a.f;
import com.mbridge.msdk.dycreator.binding.a.g;
import com.mbridge.msdk.dycreator.binding.base.BaseStrategy;
import com.mbridge.msdk.dycreator.bridge.MBSplashData;
import com.mbridge.msdk.dycreator.e.d;
import com.mbridge.msdk.foundation.entity.CampaignEx;

public final class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private com.mbridge.msdk.dycreator.f.a.a f8597a;

    public a(com.mbridge.msdk.dycreator.f.a.a aVar) {
        this.f8597a = aVar;
    }

    public final void onClick(View view) {
        com.mbridge.msdk.dycreator.f.a.a aVar;
        if (view != null && (view instanceof InterBase)) {
            if (!(view instanceof MBCountDownView) || (aVar = this.f8597a) == null || aVar.getEffectData() == null || this.f8597a.getEffectData().isCanSkip()) {
                com.mbridge.msdk.dycreator.f.a.a aVar2 = this.f8597a;
                if (aVar2 != null && (view instanceof MBRelativeLayout) && d.a(view, aVar2)) {
                    com.mbridge.msdk.dycreator.f.a.a aVar3 = this.f8597a;
                    if (aVar3 instanceof MBSplashData) {
                        MBRelativeLayout mBRelativeLayout = (MBRelativeLayout) view;
                        ((MBSplashData) aVar3).setxInScreen(mBRelativeLayout.getxInScreen());
                        ((MBSplashData) this.f8597a).setyInScreen(mBRelativeLayout.getyInScreen());
                        ((MBSplashData) this.f8597a).setClickType(1);
                    }
                }
                com.mbridge.msdk.dycreator.f.a.a aVar4 = this.f8597a;
                if (aVar4 != null && (view instanceof MBLinearLayout) && d.a(view, aVar4)) {
                    com.mbridge.msdk.dycreator.f.a.a aVar5 = this.f8597a;
                    if (aVar5 instanceof MBSplashData) {
                        MBLinearLayout mBLinearLayout = (MBLinearLayout) view;
                        ((MBSplashData) aVar5).setxInScreen(mBLinearLayout.getxInScreen());
                        ((MBSplashData) this.f8597a).setyInScreen(mBLinearLayout.getyInScreen());
                        ((MBSplashData) this.f8597a).setClickType(0);
                    }
                }
                String strategyDes = ((InterBase) view).getStrategyDes();
                if (!TextUtils.isEmpty(strategyDes)) {
                    c.a();
                    BaseStrategy baseStrategy = null;
                    if (!TextUtils.isEmpty(strategyDes)) {
                        if (strategyDes.equals(CampaignEx.JSON_NATIVE_VIDEO_CLOSE)) {
                            baseStrategy = new c();
                        } else if (strategyDes.equals("download")) {
                            baseStrategy = new b();
                        } else if (!strategyDes.equals("deeplink") && strategyDes.equals("activity")) {
                            baseStrategy = new com.mbridge.msdk.dycreator.binding.a.a();
                        }
                        if (strategyDes.equals("feedback")) {
                            baseStrategy = new com.mbridge.msdk.dycreator.binding.a.d();
                        }
                        if (strategyDes.equals("notice")) {
                            baseStrategy = new e();
                        }
                        if (strategyDes.equals("permissionInfo")) {
                            baseStrategy = new f();
                        }
                        if (strategyDes.equals("privateAddress")) {
                            baseStrategy = new g();
                        }
                    }
                    if (baseStrategy != null) {
                        baseStrategy.bindClickData(view, this.f8597a);
                    }
                }
            }
        }
    }
}
