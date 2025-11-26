package com.mbridge.msdk.newreward.player.view.moreoffer;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.player.presenter.MoreOfferPresenter;
import com.mbridge.msdk.video.dynview.widget.ObservableScrollView;

public abstract class BaseMoreOfferTemplate extends RelativeLayout {
    TextView likeTv;
    protected boolean mDyXmlSuccess = false;
    ObservableScrollView mObservableScrollView;
    MoreOfferPresenter moreOfferPresenter;

    public BaseMoreOfferTemplate(@NonNull Context context) {
        super(context);
    }

    public abstract void addClickEvent();

    public boolean initViews(boolean z4) {
        MoreOfferPresenter moreOfferPresenter2 = this.moreOfferPresenter;
        if (moreOfferPresenter2 == null) {
            return false;
        }
        try {
            this.mObservableScrollView = (ObservableScrollView) findViewById(moreOfferPresenter2.filterFindViewId(this.mDyXmlSuccess, "mbridge_moreoffer_hls"));
            this.likeTv = (TextView) findViewById(this.moreOfferPresenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_reward_end_card_like_tv"));
            addClickEvent();
            return true;
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
            return false;
        }
    }

    public BaseMoreOfferTemplate(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
