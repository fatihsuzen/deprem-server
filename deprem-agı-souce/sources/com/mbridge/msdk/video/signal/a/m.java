package com.mbridge.msdk.video.signal.a;

import com.mbridge.msdk.video.module.MBridgeContainerView;

public final class m extends e {

    /* renamed from: a  reason: collision with root package name */
    private MBridgeContainerView f12673a;

    public m(MBridgeContainerView mBridgeContainerView) {
        this.f12673a = mBridgeContainerView;
    }

    public final void configurationChanged(int i5, int i6, int i7) {
        super.configurationChanged(i5, i6, i7);
        try {
            MBridgeContainerView mBridgeContainerView = this.f12673a;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.configurationChanged(i5, i6, i7);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean endCardShowing() {
        try {
            MBridgeContainerView mBridgeContainerView = this.f12673a;
            if (mBridgeContainerView != null) {
                return mBridgeContainerView.endCardShowing();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return super.endCardShowing();
    }

    public final void hideAlertWebview() {
        super.hideAlertWebview();
        MBridgeContainerView mBridgeContainerView = this.f12673a;
        if (mBridgeContainerView != null) {
            mBridgeContainerView.hideAlertWebview();
        }
    }

    public final void ivRewardAdsWithoutVideo(String str) {
        super.ivRewardAdsWithoutVideo(str);
        MBridgeContainerView mBridgeContainerView = this.f12673a;
        if (mBridgeContainerView != null) {
            mBridgeContainerView.ivRewardAdsWithoutVideo(str);
        }
    }

    public final boolean miniCardShowing() {
        try {
            MBridgeContainerView mBridgeContainerView = this.f12673a;
            if (mBridgeContainerView != null) {
                return mBridgeContainerView.miniCardShowing();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return super.miniCardShowing();
    }

    public final void readyStatus(int i5) {
        try {
            MBridgeContainerView mBridgeContainerView = this.f12673a;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.readyStatus(i5);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.readyStatus(i5);
    }

    public final void resizeMiniCard(int i5, int i6, int i7) {
        super.resizeMiniCard(i5, i6, i7);
        try {
            MBridgeContainerView mBridgeContainerView = this.f12673a;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.resizeMiniCard(i5, i6, i7);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean showAlertWebView() {
        super.showAlertWebView();
        MBridgeContainerView mBridgeContainerView = this.f12673a;
        if (mBridgeContainerView != null) {
            return mBridgeContainerView.showAlertWebView();
        }
        return false;
    }

    public final void showEndcard(int i5) {
        super.showEndcard(i5);
        try {
            MBridgeContainerView mBridgeContainerView = this.f12673a;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.showEndcard(i5);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void showMiniCard(int i5, int i6, int i7, int i8, int i9) {
        super.showMiniCard(i5, i6, i7, i8, i9);
        int i10 = i5;
        try {
            MBridgeContainerView mBridgeContainerView = this.f12673a;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.showMiniCard(i10, i6, i7, i8, i9);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void showVideoClickView(int i5) {
        super.showVideoClickView(i5);
        MBridgeContainerView mBridgeContainerView = this.f12673a;
        if (mBridgeContainerView != null) {
            mBridgeContainerView.showVideoClickView(i5);
        }
    }

    public final void showVideoEndCover() {
        super.showVideoEndCover();
        try {
            MBridgeContainerView mBridgeContainerView = this.f12673a;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.showVideoEndCover();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void toggleCloseBtn(int i5) {
        super.toggleCloseBtn(i5);
        try {
            MBridgeContainerView mBridgeContainerView = this.f12673a;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.toggleCloseBtn(i5);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
