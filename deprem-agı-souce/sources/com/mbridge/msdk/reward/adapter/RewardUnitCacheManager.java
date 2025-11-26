package com.mbridge.msdk.reward.adapter;

import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.system.NoProGuard;
import com.mbridge.msdk.videocommon.d.c;
import j$.util.concurrent.ConcurrentHashMap;

public final class RewardUnitCacheManager implements NoProGuard {
    private static final String TAG = "RewardUnitCacheManager";
    private ConcurrentHashMap<String, c> rewardUnitSettings;

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final RewardUnitCacheManager f11020a = new RewardUnitCacheManager();
    }

    public static RewardUnitCacheManager getInstance() {
        return a.f11020a;
    }

    public final void add(String str, String str2, c cVar) {
        try {
            String str3 = str + "_" + str2;
            if (cVar != null && this.rewardUnitSettings.containsKey(str3)) {
                this.rewardUnitSettings.remove(str3);
            }
            this.rewardUnitSettings.put(str3, cVar);
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    public final c get(String str, String str2) {
        try {
            return this.rewardUnitSettings.remove(str + "_" + str2);
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private RewardUnitCacheManager() {
        this.rewardUnitSettings = new ConcurrentHashMap<>();
    }
}
