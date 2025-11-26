package com.mbridge.msdk.newreward.player.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.player.iview.ICusTemplateView;
import com.mbridge.msdk.newreward.player.presenter.PlayPresenter902;
import com.mbridge.msdk.playercommon.PlayerView;

public class Template902 extends BaseTemplate implements ICusTemplateView {
    public Template902(@NonNull Context context) {
        super(context);
        PlayPresenter902 playPresenter902 = new PlayPresenter902(this);
        this.presenter = playPresenter902;
        playPresenter902.getView();
    }

    public void addCTAViewToLayout(View view, int i5) {
        if (this.mCtaLayout != null) {
            if (view != null && view.getParent() == null) {
                this.mCtaLayout.addView(view);
            }
            this.mCtaLayout.setVisibility(i5);
        }
    }

    public void addClickEvent() {
        super.addClickEvent();
        PlayerView playerView = this.mPlayerView;
        if (playerView != null) {
            playerView.setOnClickListener(this);
        }
        try {
            View childAt = getChildAt(0);
            if (childAt != null) {
                childAt.setOnClickListener(this);
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }

    public int getCTAViewState() {
        FrameLayout frameLayout = this.mCtaLayout;
        if (frameLayout != null) {
            return frameLayout.getVisibility();
        }
        return -1;
    }

    public Template902(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
