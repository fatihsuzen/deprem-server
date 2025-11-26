package com.mbridge.msdk.dycreator.viewmodel;

import com.mbridge.msdk.dycreator.binding.response.SplashResData;
import com.mbridge.msdk.dycreator.bus.EventBus;
import com.mbridge.msdk.dycreator.f.a;
import com.mbridge.msdk.dycreator.g.c;
import com.mbridge.msdk.dycreator.g.d;
import com.mbridge.msdk.dycreator.g.f;
import com.mbridge.msdk.dycreator.g.h;
import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.dycreator.wrapper.DynamicViewBackListener;

public class MBRewardViewVModel implements BaseViewModel {

    /* renamed from: a  reason: collision with root package name */
    private d f8706a;

    /* renamed from: b  reason: collision with root package name */
    private c f8707b;

    /* renamed from: c  reason: collision with root package name */
    private f f8708c;

    /* renamed from: d  reason: collision with root package name */
    private h f8709d;

    /* renamed from: e  reason: collision with root package name */
    private DynamicViewBackListener f8710e;

    /* renamed from: f  reason: collision with root package name */
    private DyOption f8711f;

    public MBRewardViewVModel(DyOption dyOption) {
        this.f8711f = dyOption;
        EventBus.getDefault().register(this);
    }

    public void onEventMainThread(SplashResData splashResData) {
        DynamicViewBackListener dynamicViewBackListener = this.f8710e;
        if (dynamicViewBackListener != null) {
            dynamicViewBackListener.viewClicked(splashResData);
        }
    }

    public void setClickSubject(c cVar) {
        if (cVar != null) {
            this.f8707b = cVar;
        }
    }

    public void setConcreteSubject(d dVar) {
        if (dVar != null) {
            this.f8706a = dVar;
        }
    }

    public void setDynamicViewBackListener(DynamicViewBackListener dynamicViewBackListener) {
        if (dynamicViewBackListener != null) {
            this.f8710e = dynamicViewBackListener;
        }
    }

    public void setEffectSubject(f fVar) {
        if (fVar != null) {
            this.f8708c = fVar;
        }
    }

    public void setModelDataAndBind() {
        a aVar = new a(this.f8711f);
        d dVar = this.f8706a;
        if (dVar != null) {
            dVar.a(aVar);
        }
        c cVar = this.f8707b;
        if (cVar != null) {
            cVar.a(aVar);
        }
        f fVar = this.f8708c;
        if (fVar != null) {
            fVar.a(aVar);
        }
        h hVar = this.f8709d;
        if (hVar != null) {
            hVar.a(aVar);
        }
    }

    public void setReportSubject(h hVar) {
        if (hVar != null) {
            this.f8709d = hVar;
        }
    }
}
