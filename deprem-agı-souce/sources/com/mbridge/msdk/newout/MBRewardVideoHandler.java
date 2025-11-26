package com.mbridge.msdk.newout;

import android.content.Context;
import com.mbridge.msdk.newreward.b.c;
import com.mbridge.msdk.newreward.b.d;

public class MBRewardVideoHandler implements IMBRRewardVideoHandler {
    private c controller = null;
    private String unitId;

    public MBRewardVideoHandler(Context context, String str, String str2) {
        this.controller = new d(94, str, str2, false);
        this.unitId = str2;
    }

    public boolean isReady() {
        return this.controller.a(true);
    }

    public void load(String str) {
        this.controller.a(true, str);
    }

    public void setRewardVideoListener(RewardVideoListener rewardVideoListener) {
        this.controller.a(rewardVideoListener);
    }

    public void show(String str) {
        this.controller.a(str, "", "");
    }

    public void load() {
        this.controller.a(true, "");
    }
}
