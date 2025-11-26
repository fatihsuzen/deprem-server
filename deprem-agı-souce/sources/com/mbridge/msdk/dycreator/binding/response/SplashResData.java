package com.mbridge.msdk.dycreator.binding.response;

import com.mbridge.msdk.dycreator.binding.response.base.BaseRespData;
import com.mbridge.msdk.dycreator.f.a.a;
import com.mbridge.msdk.dycreator.listener.action.EAction;

public class SplashResData extends BaseRespData {

    /* renamed from: a  reason: collision with root package name */
    private a f8627a;

    /* renamed from: b  reason: collision with root package name */
    private EAction f8628b;

    public a getBaseViewData() {
        return this.f8627a;
    }

    public EAction geteAction() {
        return this.f8628b;
    }

    public void setBaseViewData(a aVar) {
        this.f8627a = aVar;
    }

    public void seteAction(EAction eAction) {
        this.f8628b = eAction;
    }
}
