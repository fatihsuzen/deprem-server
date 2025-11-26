package com.mbridge.msdk.dycreator.binding.a;

import android.view.View;
import com.mbridge.msdk.dycreator.binding.base.BaseStrategy;
import com.mbridge.msdk.dycreator.binding.response.SplashResData;
import com.mbridge.msdk.dycreator.bus.EventBus;
import com.mbridge.msdk.dycreator.f.a.a;
import com.mbridge.msdk.dycreator.listener.action.EAction;

public final class d<T extends View, K> implements BaseStrategy {
    public final void bindClickData(View view, a aVar) {
        SplashResData splashResData = new SplashResData();
        splashResData.setBaseViewData(aVar);
        splashResData.seteAction(EAction.FEEDBACK);
        EventBus.getDefault().post(splashResData);
    }
}
