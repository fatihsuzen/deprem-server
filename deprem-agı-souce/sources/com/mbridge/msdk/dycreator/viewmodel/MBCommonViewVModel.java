package com.mbridge.msdk.dycreator.viewmodel;

import com.mbridge.msdk.dycreator.binding.response.SplashResData;
import com.mbridge.msdk.dycreator.bus.EventBus;
import com.mbridge.msdk.dycreator.g.c;
import com.mbridge.msdk.dycreator.g.d;
import com.mbridge.msdk.dycreator.g.f;
import com.mbridge.msdk.dycreator.g.h;
import com.mbridge.msdk.dycreator.wrapper.DynamicViewBackListener;

public class MBCommonViewVModel implements BaseViewModel {

    /* renamed from: a  reason: collision with root package name */
    private d f8701a;

    /* renamed from: b  reason: collision with root package name */
    private c f8702b;

    /* renamed from: c  reason: collision with root package name */
    private f f8703c;

    /* renamed from: d  reason: collision with root package name */
    private h f8704d;

    /* renamed from: e  reason: collision with root package name */
    private DynamicViewBackListener f8705e;

    public MBCommonViewVModel() {
        EventBus.getDefault().register(this);
    }

    public void onEventMainThread(SplashResData splashResData) {
        DynamicViewBackListener dynamicViewBackListener = this.f8705e;
        if (dynamicViewBackListener != null) {
            dynamicViewBackListener.viewClicked(splashResData);
        }
    }

    public void setClickSubject(c cVar) {
        if (cVar != null) {
            this.f8702b = cVar;
        }
    }

    public void setConcreteSubject(d dVar) {
        if (dVar != null) {
            this.f8701a = dVar;
        }
    }

    public void setDynamicViewBackListener(DynamicViewBackListener dynamicViewBackListener) {
        if (dynamicViewBackListener != null) {
            this.f8705e = dynamicViewBackListener;
        }
    }

    public void setEffectSubject(f fVar) {
        if (fVar != null) {
            this.f8703c = fVar;
        }
    }

    public void setModelDataAndBind() {
    }

    public void setReportSubject(h hVar) {
        if (hVar != null) {
            this.f8704d = hVar;
        }
    }
}
