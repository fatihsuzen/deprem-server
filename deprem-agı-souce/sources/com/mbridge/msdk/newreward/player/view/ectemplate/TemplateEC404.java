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
import com.mbridge.msdk.newreward.player.presenter.ECPresenter404;

public class TemplateEC404 extends BaseECTemplate implements ICusECTemplateView {
    public TemplateEC404(@NonNull Context context) {
        super(context);
        ECPresenter404 eCPresenter404 = new ECPresenter404(this);
        this.ecPresenter = eCPresenter404;
        eCPresenter404.getView();
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
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) TemplateEC404.this.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.setMargins(0, 0, 0, i5);
                        TemplateEC404.this.setLayoutParams(layoutParams);
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
        ((ECPresenter404) this.ecPresenter).addMoreOfferView(this);
    }

    public TemplateEC404(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
