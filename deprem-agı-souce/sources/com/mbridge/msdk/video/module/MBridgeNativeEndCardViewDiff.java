package com.mbridge.msdk.video.module;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.mbridge.msdk.MBridgeConstans;

public abstract class MBridgeNativeEndCardViewDiff extends MBridgeBaseView {
    public TextView ctaView;

    public MBridgeNativeEndCardViewDiff(Context context) {
        super(context);
    }

    public boolean checkChinaShakeState() {
        return false;
    }

    public boolean checkProgressBarIntercepted() {
        return false;
    }

    public boolean ctaViewCanGet(View view, boolean z4) {
        try {
            View findViewById = view.findViewById(filterFindViewId(z4, "mbridge_tv_cta"));
            if (findViewById instanceof TextView) {
                this.ctaView = (TextView) findViewById;
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
        if (this.ctaView == null) {
            return false;
        }
        return true;
    }

    public MBridgeNativeEndCardViewDiff(Context context, AttributeSet attributeSet, boolean z4, int i5, boolean z5, int i6, int i7) {
        super(context, attributeSet, z4, i5, z5, i6, i7);
    }

    public MBridgeNativeEndCardViewDiff(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
