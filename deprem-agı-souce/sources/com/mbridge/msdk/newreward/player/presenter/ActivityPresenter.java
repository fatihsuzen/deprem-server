package com.mbridge.msdk.newreward.player.presenter;

import android.view.ViewGroup;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.command.a;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.d;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.player.iview.IMetaData;
import java.lang.reflect.Proxy;

public class ActivityPresenter {
    e adapterModel;
    c commandManager;
    d commandManagerGlobal;
    IMetaData mMetaData;

    public ActivityPresenter(IMetaData iMetaData, String str) {
        String str2;
        try {
            this.commandManagerGlobal = d.a();
            this.commandManager = d.a().b();
            this.adapterModel = this.commandManagerGlobal.a(str);
            IMetaData iMetaData2 = (IMetaData) Proxy.newProxyInstance(iMetaData.getClass().getClassLoader(), iMetaData.getClass().getInterfaces(), new com.mbridge.msdk.newreward.function.g.e(iMetaData, this.adapterModel, this.commandManager));
            this.mMetaData = iMetaData2;
            iMetaData2.setDate(this.adapterModel);
            this.mMetaData.activityReport("onCreate");
            this.commandManager.b((a) new com.mbridge.msdk.newreward.function.command.a.c());
            if (this.adapterModel.U() == null) {
                str2 = String.valueOf(this.adapterModel.D().b().C());
            } else {
                str2 = this.adapterModel.ai();
            }
            str2 = this.adapterModel.ak() ? this.adapterModel.al() : str2;
            setActivityOrientation(iMetaData);
            addTemplate(str2, iMetaData.getRootViewGroup());
        } catch (Exception e5) {
            IMetaData iMetaData3 = this.mMetaData;
            if (iMetaData3 != null) {
                iMetaData3.onShowFail(com.mbridge.msdk.foundation.c.a.a(890010), 890010);
            }
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }

    private void addTemplate(String str, ViewGroup viewGroup) {
        try {
            c cVar = this.commandManager;
            cVar.g(cVar.a("add_temple", str, "adapter_model", this.adapterModel, "template_type", 17, "parent_temple", viewGroup), f.SHOW_ADD_TEMPLE);
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0045 A[ADDED_TO_REGION, Catch:{ all -> 0x002c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setActivityOrientation(com.mbridge.msdk.newreward.player.iview.IMetaData r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof android.app.Activity     // Catch:{ all -> 0x002c }
            if (r0 == 0) goto L_0x0056
            android.app.Activity r6 = (android.app.Activity) r6     // Catch:{ all -> 0x002c }
            com.mbridge.msdk.newreward.a.e r0 = r5.adapterModel     // Catch:{ all -> 0x002c }
            java.lang.String r0 = r0.ai()     // Catch:{ all -> 0x002c }
            int r1 = r0.hashCode()     // Catch:{ all -> 0x002c }
            r2 = 50549(0xc575, float:7.0834E-41)
            r3 = 2
            r4 = 1
            if (r1 == r2) goto L_0x0038
            r2 = 55354(0xd83a, float:7.7567E-41)
            if (r1 == r2) goto L_0x002e
            r2 = 1213120338(0x484ebf52, float:211709.28)
            if (r1 == r2) goto L_0x0022
            goto L_0x0042
        L_0x0022:
            java.lang.String r1 = "5002010"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x002c }
            if (r0 == 0) goto L_0x0042
            r0 = r3
            goto L_0x0043
        L_0x002c:
            r6 = move-exception
            goto L_0x0057
        L_0x002e:
            java.lang.String r1 = "802"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x002c }
            if (r0 == 0) goto L_0x0042
            r0 = r4
            goto L_0x0043
        L_0x0038:
            java.lang.String r1 = "302"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x002c }
            if (r0 == 0) goto L_0x0042
            r0 = 0
            goto L_0x0043
        L_0x0042:
            r0 = -1
        L_0x0043:
            if (r0 == 0) goto L_0x0053
            if (r0 == r4) goto L_0x0053
            if (r0 == r3) goto L_0x0053
            com.mbridge.msdk.newreward.a.e r0 = r5.adapterModel     // Catch:{ all -> 0x002c }
            int r0 = r0.am()     // Catch:{ all -> 0x002c }
            r6.setRequestedOrientation(r0)     // Catch:{ all -> 0x002c }
            return
        L_0x0053:
            r6.setRequestedOrientation(r4)     // Catch:{ all -> 0x002c }
        L_0x0056:
            return
        L_0x0057:
            java.lang.String r0 = "ActivityPresenter"
            java.lang.String r6 = r6.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r0, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.player.presenter.ActivityPresenter.setActivityOrientation(com.mbridge.msdk.newreward.player.iview.IMetaData):void");
    }

    public void bindMethodName(String str) {
        boolean z4;
        try {
            c cVar = this.commandManager;
            ViewGroup rootViewGroup = this.mMetaData.getRootViewGroup();
            e eVar = this.adapterModel;
            if (eVar == null || !eVar.r()) {
                z4 = false;
            } else {
                z4 = true;
            }
            cVar.h(cVar.a("life_cycle", str, "parent_temple", rootViewGroup, "is_dy", Boolean.valueOf(z4)), f.SHOW_LIFE_CYCLE);
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
        if (str.equals("onDestroy") || str.equals("onCreate")) {
            this.mMetaData.activityReport(str);
        }
        if (str.equals("onDestroy")) {
            try {
                e eVar2 = this.adapterModel;
                if (eVar2 != null) {
                    d dVar = this.commandManagerGlobal;
                    if (dVar != null) {
                        dVar.b(eVar2.G());
                    }
                    com.mbridge.msdk.newreward.function.command.receiver.d.a().a(this.adapterModel.G());
                    com.mbridge.msdk.newreward.function.command.receiver.d.a().d(f.SHOW_OR_PRELOAD_WEB_EC);
                }
            } catch (Exception e6) {
                if (MBridgeConstans.DEBUG) {
                    e6.printStackTrace();
                }
            }
        }
    }
}
