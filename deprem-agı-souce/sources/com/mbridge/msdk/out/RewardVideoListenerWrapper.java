package com.mbridge.msdk.out;

import android.os.Handler;
import android.os.Looper;
import com.mbridge.msdk.newout.RewardVideoListener;
import com.mbridge.msdk.video.bt.module.b.g;

public class RewardVideoListenerWrapper implements RewardVideoListener {
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public final g rewardVideoListener;

    public RewardVideoListenerWrapper(g gVar) {
        this.rewardVideoListener = gVar;
    }

    public void onAdClose(final MBridgeIds mBridgeIds, final RewardInfo rewardInfo) {
        this.mainHandler.post(new Runnable() {
            public void run() {
                if (RewardVideoListenerWrapper.this.rewardVideoListener != null) {
                    RewardVideoListenerWrapper.this.rewardVideoListener.onAdClose(mBridgeIds, rewardInfo);
                }
            }
        });
    }

    public void onAdCloseWithIVReward(MBridgeIds mBridgeIds, boolean z4, int i5) {
    }

    public void onAdShow(final MBridgeIds mBridgeIds) {
        this.mainHandler.post(new Runnable() {
            public void run() {
                if (RewardVideoListenerWrapper.this.rewardVideoListener != null) {
                    RewardVideoListenerWrapper.this.rewardVideoListener.onAdShow(mBridgeIds);
                }
            }
        });
    }

    public void onEndcardShow(final MBridgeIds mBridgeIds) {
        this.mainHandler.post(new Runnable() {
            public void run() {
                if (RewardVideoListenerWrapper.this.rewardVideoListener != null) {
                    RewardVideoListenerWrapper.this.rewardVideoListener.onEndcardShow(mBridgeIds);
                }
            }
        });
    }

    public void onLoadSuccess(final MBridgeIds mBridgeIds) {
        this.mainHandler.post(new Runnable() {
            public void run() {
                if (RewardVideoListenerWrapper.this.rewardVideoListener != null) {
                    RewardVideoListenerWrapper.this.rewardVideoListener.onLoadSuccess(mBridgeIds);
                }
            }
        });
    }

    public void onShowFail(final MBridgeIds mBridgeIds, final String str) {
        this.mainHandler.post(new Runnable() {
            public void run() {
                if (RewardVideoListenerWrapper.this.rewardVideoListener != null) {
                    RewardVideoListenerWrapper.this.rewardVideoListener.onShowFail(mBridgeIds, str);
                }
            }
        });
    }

    public void onVideoAdClicked(final MBridgeIds mBridgeIds) {
        this.mainHandler.post(new Runnable() {
            public void run() {
                if (RewardVideoListenerWrapper.this.rewardVideoListener != null) {
                    RewardVideoListenerWrapper.this.rewardVideoListener.onVideoAdClicked(mBridgeIds);
                }
            }
        });
    }

    public void onVideoComplete(final MBridgeIds mBridgeIds) {
        this.mainHandler.post(new Runnable() {
            public void run() {
                if (RewardVideoListenerWrapper.this.rewardVideoListener != null) {
                    RewardVideoListenerWrapper.this.rewardVideoListener.onVideoComplete(mBridgeIds);
                }
            }
        });
    }

    public void onVideoLoadFail(final MBridgeIds mBridgeIds, final String str) {
        this.mainHandler.post(new Runnable() {
            public void run() {
                if (RewardVideoListenerWrapper.this.rewardVideoListener != null) {
                    RewardVideoListenerWrapper.this.rewardVideoListener.onVideoLoadFail(mBridgeIds, str);
                }
            }
        });
    }

    public void onVideoLoadSuccess(final MBridgeIds mBridgeIds) {
        this.mainHandler.post(new Runnable() {
            public void run() {
                if (RewardVideoListenerWrapper.this.rewardVideoListener != null) {
                    RewardVideoListenerWrapper.this.rewardVideoListener.onVideoLoadSuccess(mBridgeIds);
                }
            }
        });
    }
}
