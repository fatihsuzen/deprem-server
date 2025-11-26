package com.mbridge.msdk.newreward.player.view.ectemplate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.player.iview.ICusECTemplateView;
import com.mbridge.msdk.newreward.player.presenter.ECPresenter1302;

public class TemplateEC1302 extends BaseECTemplate implements ICusECTemplateView {
    public TemplateEC1302(@NonNull Context context) {
        super(context);
        ECPresenter1302 eCPresenter1302 = new ECPresenter1302(this);
        this.ecPresenter = eCPresenter1302;
        eCPresenter1302.getView();
    }

    public void addShakeView(View view) {
        if (view != null) {
            View view2 = this.ctaView;
            if (view2 != null) {
                view2.setVisibility(4);
            }
            RelativeLayout relativeLayout = this.nativeECLayout;
            if (relativeLayout != null) {
                relativeLayout.addView(view);
            }
        }
    }

    public void reSetEndCardWidthAndHeight(final int i5) {
        post(new Runnable() {
            public void run() {
                try {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) TemplateEC1302.this.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.setMargins(0, 0, 0, i5);
                        TemplateEC1302.this.setLayoutParams(layoutParams);
                    }
                } catch (Exception e5) {
                    if (MBridgeConstans.DEBUG) {
                        e5.printStackTrace();
                    }
                }
            }
        });
    }

    public void show(ViewGroup viewGroup) {
        super.show(viewGroup);
        ((ECPresenter1302) this.ecPresenter).addMoreOfferView(this);
    }

    public TemplateEC1302(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
