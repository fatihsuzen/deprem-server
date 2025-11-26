package com.mbridge.msdk.video.module.a.a;

import androidx.annotation.RequiresApi;
import com.mbridge.msdk.video.module.MBridgeClickMiniCardView;
import com.mbridge.msdk.video.module.a.a;

public final class g extends i {

    /* renamed from: a  reason: collision with root package name */
    private MBridgeClickMiniCardView f12578a;

    public g(MBridgeClickMiniCardView mBridgeClickMiniCardView, a aVar) {
        super(aVar);
        this.f12578a = mBridgeClickMiniCardView;
    }

    @RequiresApi(api = 11)
    public final void a(int i5, Object obj) {
        boolean z4 = false;
        switch (i5) {
            case 100:
                MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f12578a;
                if (mBridgeClickMiniCardView != null) {
                    mBridgeClickMiniCardView.webviewshow();
                    MBridgeClickMiniCardView mBridgeClickMiniCardView2 = this.f12578a;
                    mBridgeClickMiniCardView2.onSelfConfigurationChanged(mBridgeClickMiniCardView2.getResources().getConfiguration());
                    break;
                }
                break;
            case 101:
            case 102:
                z4 = true;
                break;
            case 103:
                i5 = 107;
                break;
        }
        if (!z4) {
            super.a(i5, obj);
        }
    }
}
