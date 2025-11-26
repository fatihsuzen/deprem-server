package com.mbridge.msdk.videocommon.download;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import java.util.concurrent.atomic.AtomicBoolean;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private AtomicBoolean f13160a;

    /* renamed from: b  reason: collision with root package name */
    private AtomicBoolean f13161b;

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final h f13162a = new h();
    }

    public static h a() {
        return a.f13162a;
    }

    public final boolean b(int i5) {
        if (MBridgeConstans.DEBUG) {
            af.c("RewardVideoRefactorManager", "isRewardVideoRefactor adType: " + i5 + ", key: REWARD_VIDEO_REFACTOR_FOR_CAMPAIGN_REQUEST");
        }
        if (i5 != 94 && i5 != 287) {
            return false;
        }
        AtomicBoolean atomicBoolean = this.f13161b;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        try {
            this.f13161b = new AtomicBoolean(ah.a().a("r_v_r_f_c_r", false));
        } catch (Exception e5) {
            this.f13161b = new AtomicBoolean(false);
            if (MBridgeConstans.DEBUG) {
                af.b("RewardVideoRefactorManager", "isRewardVideoRefactor error: " + e5.getMessage());
            }
        }
        return this.f13161b.get();
    }

    private h() {
    }

    public final boolean a(int i5) {
        if (MBridgeConstans.DEBUG) {
            af.c("RewardVideoRefactorManager", "isRewardVideoRefactor adType: " + i5 + ", key: REWARD_VIDEO_REFACTOR_FOR_LOAD");
        }
        if (i5 != 94 && i5 != 287) {
            return false;
        }
        AtomicBoolean atomicBoolean = this.f13160a;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        try {
            this.f13160a = new AtomicBoolean(ah.a().a("r_v_r_f_l", false));
        } catch (Exception e5) {
            this.f13160a = new AtomicBoolean(false);
            if (MBridgeConstans.DEBUG) {
                af.b("RewardVideoRefactorManager", "isRewardVideoRefactor error: " + e5.getMessage());
            }
        }
        return this.f13160a.get();
    }

    public final int a(String str, int i5) {
        try {
            return ah.a().a(str, i5);
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b("RewardVideoRefactorManager", "getRewardVideoCampaignRequestTimeout error: " + e5.getMessage());
            }
            return i5;
        }
    }
}
