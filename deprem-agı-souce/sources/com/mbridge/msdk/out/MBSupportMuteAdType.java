package com.mbridge.msdk.out;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class MBSupportMuteAdType {
    public static final int INTERSTITIAL_VIDEO = 287;
    public static final int REWARD_VIDEO = 94;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AdType {
    }

    private MBSupportMuteAdType() {
    }
}
