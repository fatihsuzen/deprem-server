package com.mbridge.msdk.newout;

public interface IMBRRewardVideoHandler {
    boolean isReady();

    void load();

    void load(String str);

    void setRewardVideoListener(RewardVideoListener rewardVideoListener);

    void show(String str);
}
