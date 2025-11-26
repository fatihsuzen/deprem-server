package com.mbridge.msdk.newreward.player.presenter;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.newreward.a.b.b;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.function.g.e;
import com.mbridge.msdk.newreward.player.iview.ICusECTemplateView;
import com.mbridge.msdk.newreward.player.iview.IECTempleView;
import java.lang.reflect.Proxy;

public class ECPresenter404 extends ECTemplePresenter {
    ICusECTemplateView iCusECTemplateView;

    public ECPresenter404(IECTempleView iECTempleView) {
        super(iECTempleView);
        this.iCusECTemplateView = (ICusECTemplateView) Proxy.newProxyInstance(iECTempleView.getClass().getClassLoader(), new Class[]{ICusECTemplateView.class}, new e(iECTempleView, this.adapterModel, this.commandManager));
    }

    public void addMoreOfferView(ViewGroup viewGroup) {
        try {
            String a5 = aq.a(this.campaignEx.getendcard_url(), "mof");
            if (!TextUtils.isEmpty(a5)) {
                if (Integer.parseInt(a5) == 1) {
                    c cVar = this.commandManager;
                    cVar.d((Object) cVar.a("add_temple", 295, "parent_temple", viewGroup, "more_offer_type", 2, "command_type", f.SHOW_ADD_TEMPLE), (b) new b() {
                        public void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
                        }

                        public void reqSuccessful(Object obj) {
                            try {
                                if (obj instanceof View) {
                                    ((View) obj).setVisibility(0);
                                    new com.mbridge.msdk.video.dynview.h.b().a((View) obj, 0, ak.f(com.mbridge.msdk.foundation.controller.c.m().c()), 0, ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 100.0f), 500);
                                }
                                ICusECTemplateView iCusECTemplateView = ECPresenter404.this.iCusECTemplateView;
                                if (iCusECTemplateView != null) {
                                    iCusECTemplateView.reSetEndCardWidthAndHeight(ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 100.0f));
                                }
                            } catch (Exception e5) {
                                Exception exc = e5;
                                if (MBridgeConstans.DEBUG) {
                                    exc.printStackTrace();
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
