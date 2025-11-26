package com.mbridge.msdk.newreward.player.view.halfoffer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.newreward.player.iview.ICusTemplateView;
import com.mbridge.msdk.newreward.player.presenter.PlayPresenterHalf;
import com.mbridge.msdk.newreward.player.view.BaseTemplate;

public class TemplateHalf extends BaseTemplate implements ICusTemplateView {
    public TemplateHalf(@NonNull Context context) {
        super(context);
        PlayPresenterHalf playPresenterHalf = new PlayPresenterHalf(this);
        this.presenter = playPresenterHalf;
        playPresenterHalf.getView();
    }

    public void addCTAViewToLayout(View view, int i5) {
        try {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mSoundImageView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.setMargins(0, 0, 0, ak.a(getContext(), 60.0f));
            }
            this.mSoundImageView.setLayoutParams(layoutParams);
            addView(view);
            ((RelativeLayout.LayoutParams) view.getLayoutParams()).addRule(12, -1);
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }

    public int getCTAViewState() {
        return -1;
    }

    public void show(ViewGroup viewGroup) {
        super.show(viewGroup);
        ((PlayPresenterHalf) this.presenter).setHalfWH();
    }

    public TemplateHalf(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
