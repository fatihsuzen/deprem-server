package com.mbridge.msdk.out;

import com.mbridge.msdk.system.NoProGuard;
import java.io.Serializable;

public class RewardInfo implements NoProGuard, Serializable {
    private boolean isCompleteView;
    private int rewardAlertStatus;
    private String rewardAmount;
    private String rewardName;

    public RewardInfo(boolean z4, int i5) {
        this.isCompleteView = z4;
        this.rewardAlertStatus = i5;
    }

    public int getRewardAlertStatus() {
        return this.rewardAlertStatus;
    }

    public String getRewardAmount() {
        return this.rewardAmount;
    }

    public String getRewardName() {
        return this.rewardName;
    }

    public boolean isCompleteView() {
        return this.isCompleteView;
    }

    public void setCompleteView(boolean z4) {
        this.isCompleteView = z4;
    }

    public void setRewardAlertStatus(int i5) {
        this.rewardAlertStatus = i5;
    }

    public void setRewardAmount(String str) {
        this.rewardAmount = str;
    }

    public void setRewardName(String str) {
        this.rewardName = str;
    }

    public String toString() {
        return "RewardInfo{isCompleteView=" + this.isCompleteView + ", rewardName='" + this.rewardName + '\'' + ", rewardAmount='" + this.rewardAmount + '\'' + ", rewardAlertStatus=" + this.rewardAlertStatus + '}';
    }

    public RewardInfo(boolean z4, String str, String str2) {
        this.isCompleteView = z4;
        this.rewardName = str;
        this.rewardAmount = str2;
    }

    public RewardInfo(boolean z4, String str, String str2, int i5) {
        this.isCompleteView = z4;
        this.rewardName = str;
        this.rewardAmount = str2;
        this.rewardAlertStatus = i5;
    }
}
