package com.mbridge.msdk.interstitialvideo.out;

import android.os.Handler;
import android.os.Looper;
import com.mbridge.msdk.newout.RewardVideoListener;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;

public class InterstitialVideoListenerWrapper implements RewardVideoListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final InterstitialVideoListener f9824a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f9825b = new Handler(Looper.getMainLooper());

    public InterstitialVideoListenerWrapper(InterstitialVideoListener interstitialVideoListener) {
        this.f9824a = interstitialVideoListener;
    }

    public void onAdClose(final MBridgeIds mBridgeIds, final RewardInfo rewardInfo) {
        this.f9825b.post(new Runnable() {
            public void run() {
                if (InterstitialVideoListenerWrapper.this.f9824a != null) {
                    InterstitialVideoListenerWrapper.this.f9824a.onAdClose(mBridgeIds, rewardInfo);
                }
            }
        });
    }

    public void onAdCloseWithIVReward(final MBridgeIds mBridgeIds, final boolean z4, final int i5) {
        this.f9825b.post(new Runnable() {
            public void run() {
                if (InterstitialVideoListenerWrapper.this.f9824a != null) {
                    InterstitialVideoListenerWrapper.this.f9824a.onAdCloseWithIVReward(mBridgeIds, new RewardInfo(z4, i5));
                }
            }
        });
    }

    public void onAdShow(final MBridgeIds mBridgeIds) {
        this.f9825b.post(new Runnable() {
            public void run() {
                if (InterstitialVideoListenerWrapper.this.f9824a != null) {
                    InterstitialVideoListenerWrapper.this.f9824a.onAdShow(mBridgeIds);
                }
            }
        });
    }

    public void onEndcardShow(final MBridgeIds mBridgeIds) {
        this.f9825b.post(new Runnable() {
            public void run() {
                if (InterstitialVideoListenerWrapper.this.f9824a != null) {
                    InterstitialVideoListenerWrapper.this.f9824a.onEndcardShow(mBridgeIds);
                }
            }
        });
    }

    public void onLoadSuccess(final MBridgeIds mBridgeIds) {
        this.f9825b.post(new Runnable() {
            public void run() {
                if (InterstitialVideoListenerWrapper.this.f9824a != null) {
                    InterstitialVideoListenerWrapper.this.f9824a.onLoadSuccess(mBridgeIds);
                }
            }
        });
    }

    public void onShowFail(final MBridgeIds mBridgeIds, final String str) {
        this.f9825b.post(new Runnable() {
            public void run() {
                if (InterstitialVideoListenerWrapper.this.f9824a != null) {
                    InterstitialVideoListenerWrapper.this.f9824a.onShowFail(mBridgeIds, str);
                }
            }
        });
    }

    public void onVideoAdClicked(final MBridgeIds mBridgeIds) {
        this.f9825b.post(new Runnable() {
            public void run() {
                if (InterstitialVideoListenerWrapper.this.f9824a != null) {
                    InterstitialVideoListenerWrapper.this.f9824a.onVideoAdClicked(mBridgeIds);
                }
            }
        });
    }

    public void onVideoComplete(final MBridgeIds mBridgeIds) {
        this.f9825b.post(new Runnable() {
            public void run() {
                if (InterstitialVideoListenerWrapper.this.f9824a != null) {
                    InterstitialVideoListenerWrapper.this.f9824a.onVideoComplete(mBridgeIds);
                }
            }
        });
    }

    public void onVideoLoadFail(final MBridgeIds mBridgeIds, final String str) {
        this.f9825b.post(new Runnable() {
            public void run() {
                if (InterstitialVideoListenerWrapper.this.f9824a != null) {
                    InterstitialVideoListenerWrapper.this.f9824a.onVideoLoadFail(mBridgeIds, str);
                }
            }
        });
    }

    public void onVideoLoadSuccess(final MBridgeIds mBridgeIds) {
        this.f9825b.post(new Runnable() {
            public void run() {
                if (InterstitialVideoListenerWrapper.this.f9824a != null) {
                    InterstitialVideoListenerWrapper.this.f9824a.onVideoLoadSuccess(mBridgeIds);
                }
            }
        });
    }
}
