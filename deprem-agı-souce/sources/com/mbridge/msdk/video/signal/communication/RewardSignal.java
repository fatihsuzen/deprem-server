package com.mbridge.msdk.video.signal.communication;

import android.os.Handler;
import android.os.Looper;
import com.mbridge.msdk.foundation.tools.ak;

public class RewardSignal extends BaseRewardSignal implements BaseIRewardCommunication {

    /* renamed from: g  reason: collision with root package name */
    public static final /* synthetic */ int f12682g = 0;

    /* renamed from: e  reason: collision with root package name */
    private Handler f12683e = new Handler(Looper.getMainLooper());

    public void getEndScreenInfo(final Object obj, final String str) {
        if (ak.g()) {
            super.getEndScreenInfo(obj, str);
        } else {
            this.f12683e.post(new Runnable() {
                public final void run() {
                    RewardSignal.super.getEndScreenInfo(obj, str);
                }
            });
        }
    }

    public void handlerPlayableException(final Object obj, final String str) {
        if (ak.g()) {
            super.handlerPlayableException(obj, str);
        } else {
            this.f12683e.post(new Runnable() {
                public final void run() {
                    RewardSignal.super.handlerPlayableException(obj, str);
                }
            });
        }
    }

    public void install(final Object obj, final String str) {
        if (ak.g()) {
            super.install(obj, str);
        } else {
            this.f12683e.post(new Runnable() {
                public final void run() {
                    RewardSignal.super.install(obj, str);
                }
            });
        }
    }

    public void notifyCloseBtn(final Object obj, final String str) {
        if (ak.g()) {
            super.notifyCloseBtn(obj, str);
        } else {
            this.f12683e.post(new Runnable() {
                public final void run() {
                    RewardSignal.super.notifyCloseBtn(obj, str);
                }
            });
        }
    }

    public void openURL(final Object obj, final String str) {
        if (ak.g()) {
            super.openURL(obj, str);
        } else {
            this.f12683e.post(new Runnable() {
                public final void run() {
                    RewardSignal.super.openURL(obj, str);
                }
            });
        }
    }

    public void setOrientation(final Object obj, final String str) {
        if (ak.g()) {
            super.setOrientation(obj, str);
        } else {
            this.f12683e.post(new Runnable() {
                public final void run() {
                    RewardSignal.super.setOrientation(obj, str);
                }
            });
        }
    }

    public void toggleCloseBtn(final Object obj, final String str) {
        if (ak.g()) {
            super.toggleCloseBtn(obj, str);
        } else {
            this.f12683e.post(new Runnable() {
                public final void run() {
                    RewardSignal.super.toggleCloseBtn(obj, str);
                }
            });
        }
    }

    public void triggerCloseBtn(final Object obj, final String str) {
        if (ak.g()) {
            super.triggerCloseBtn(obj, str);
        } else {
            this.f12683e.post(new Runnable() {
                public final void run() {
                    RewardSignal.super.getEndScreenInfo(obj, str);
                }
            });
        }
    }
}
