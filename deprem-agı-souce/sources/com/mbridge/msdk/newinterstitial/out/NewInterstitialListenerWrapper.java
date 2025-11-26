package com.mbridge.msdk.newinterstitial.out;

import android.os.Handler;
import android.os.Looper;
import com.mbridge.msdk.newout.RewardVideoListener;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;

public class NewInterstitialListenerWrapper implements RewardVideoListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final NewInterstitialListener f10305a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f10306b = new Handler(Looper.getMainLooper());

    public NewInterstitialListenerWrapper(NewInterstitialListener newInterstitialListener) {
        this.f10305a = newInterstitialListener;
    }

    public void onAdClose(final MBridgeIds mBridgeIds, final RewardInfo rewardInfo) {
        this.f10306b.post(new Runnable() {
            public void run() {
                if (NewInterstitialListenerWrapper.this.f10305a != null) {
                    NewInterstitialListenerWrapper.this.f10305a.onAdClose(mBridgeIds, rewardInfo);
                }
            }
        });
    }

    public void onAdCloseWithIVReward(final MBridgeIds mBridgeIds, final boolean z4, final int i5) {
        this.f10306b.post(new Runnable() {
            public void run() {
                if (NewInterstitialListenerWrapper.this.f10305a != null) {
                    NewInterstitialListenerWrapper.this.f10305a.onAdCloseWithNIReward(mBridgeIds, new RewardInfo(z4, i5));
                }
            }
        });
    }

    public void onAdShow(final MBridgeIds mBridgeIds) {
        this.f10306b.post(new Runnable() {
            public void run() {
                if (NewInterstitialListenerWrapper.this.f10305a != null) {
                    NewInterstitialListenerWrapper.this.f10305a.onAdShow(mBridgeIds);
                }
            }
        });
    }

    public void onEndcardShow(final MBridgeIds mBridgeIds) {
        this.f10306b.post(new Runnable() {
            public void run() {
                if (NewInterstitialListenerWrapper.this.f10305a != null) {
                    NewInterstitialListenerWrapper.this.f10305a.onEndcardShow(mBridgeIds);
                }
            }
        });
    }

    public void onLoadSuccess(final MBridgeIds mBridgeIds) {
        this.f10306b.post(new Runnable() {
            public void run() {
                if (NewInterstitialListenerWrapper.this.f10305a != null) {
                    NewInterstitialListenerWrapper.this.f10305a.onLoadCampaignSuccess(mBridgeIds);
                }
            }
        });
    }

    public void onShowFail(final MBridgeIds mBridgeIds, final String str) {
        this.f10306b.post(new Runnable() {
            public void run() {
                if (NewInterstitialListenerWrapper.this.f10305a != null) {
                    NewInterstitialListenerWrapper.this.f10305a.onShowFail(mBridgeIds, str);
                }
            }
        });
    }

    public void onVideoAdClicked(final MBridgeIds mBridgeIds) {
        this.f10306b.post(new Runnable() {
            public void run() {
                if (NewInterstitialListenerWrapper.this.f10305a != null) {
                    NewInterstitialListenerWrapper.this.f10305a.onAdClicked(mBridgeIds);
                }
            }
        });
    }

    public void onVideoComplete(final MBridgeIds mBridgeIds) {
        this.f10306b.post(new Runnable() {
            public void run() {
                if (NewInterstitialListenerWrapper.this.f10305a != null) {
                    NewInterstitialListenerWrapper.this.f10305a.onVideoComplete(mBridgeIds);
                }
            }
        });
    }

    public void onVideoLoadFail(final MBridgeIds mBridgeIds, final String str) {
        this.f10306b.post(new Runnable() {
            public void run() {
                if (NewInterstitialListenerWrapper.this.f10305a != null) {
                    NewInterstitialListenerWrapper.this.f10305a.onResourceLoadFail(mBridgeIds, str);
                }
            }
        });
    }

    public void onVideoLoadSuccess(final MBridgeIds mBridgeIds) {
        this.f10306b.post(new Runnable() {
            public void run() {
                if (NewInterstitialListenerWrapper.this.f10305a != null) {
                    NewInterstitialListenerWrapper.this.f10305a.onResourceLoadSuccess(mBridgeIds);
                }
            }
        });
    }
}
