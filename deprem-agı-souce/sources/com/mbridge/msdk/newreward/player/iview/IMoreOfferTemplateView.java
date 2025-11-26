package com.mbridge.msdk.newreward.player.iview;

import android.view.View;

public interface IMoreOfferTemplateView extends IBaseView {
    void addMoreOfferLikeText(String str, int i5);

    void addViewToObservableScrollView(View view);

    void setObservableScrollViewVisible();
}
