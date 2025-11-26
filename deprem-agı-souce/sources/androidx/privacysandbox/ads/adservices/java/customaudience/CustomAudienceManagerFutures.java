package androidx.privacysandbox.ads.adservices.java.customaudience;

import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.customaudience.CustomAudienceManager;
import androidx.privacysandbox.ads.adservices.customaudience.FetchAndJoinCustomAudienceRequest;
import androidx.privacysandbox.ads.adservices.customaudience.JoinCustomAudienceRequest;
import androidx.privacysandbox.ads.adservices.customaudience.LeaveCustomAudienceRequest;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import b3.C2308e;
import b3.C2312i;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import n0.C1722d;
import w3.C2865c0;
import w3.N;
import w3.O;

public abstract class CustomAudienceManagerFutures {
    public static final Companion Companion = new Companion((C2633k) null);

    private static final class Api33Ext4JavaImpl extends CustomAudienceManagerFutures {
        /* access modifiers changed from: private */
        public final CustomAudienceManager mCustomAudienceManager;

        public Api33Ext4JavaImpl(CustomAudienceManager customAudienceManager) {
            this.mCustomAudienceManager = customAudienceManager;
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public C1722d fetchAndJoinCustomAudienceAsync(FetchAndJoinCustomAudienceRequest fetchAndJoinCustomAudienceRequest) {
            t.e(fetchAndJoinCustomAudienceRequest, "request");
            return CoroutineAdapterKt.asListenableFuture$default(C2876i.b(N.a(C2865c0.a()), (C2312i) null, (O) null, new CustomAudienceManagerFutures$Api33Ext4JavaImpl$fetchAndJoinCustomAudienceAsync$1(this, fetchAndJoinCustomAudienceRequest, (C2308e) null), 3, (Object) null), (Object) null, 1, (Object) null);
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public C1722d joinCustomAudienceAsync(JoinCustomAudienceRequest joinCustomAudienceRequest) {
            t.e(joinCustomAudienceRequest, "request");
            return CoroutineAdapterKt.asListenableFuture$default(C2876i.b(N.a(C2865c0.a()), (C2312i) null, (O) null, new CustomAudienceManagerFutures$Api33Ext4JavaImpl$joinCustomAudienceAsync$1(this, joinCustomAudienceRequest, (C2308e) null), 3, (Object) null), (Object) null, 1, (Object) null);
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public C1722d leaveCustomAudienceAsync(LeaveCustomAudienceRequest leaveCustomAudienceRequest) {
            t.e(leaveCustomAudienceRequest, "request");
            return CoroutineAdapterKt.asListenableFuture$default(C2876i.b(N.a(C2865c0.a()), (C2312i) null, (O) null, new CustomAudienceManagerFutures$Api33Ext4JavaImpl$leaveCustomAudienceAsync$1(this, leaveCustomAudienceRequest, (C2308e) null), 3, (Object) null), (Object) null, 1, (Object) null);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        public final CustomAudienceManagerFutures from(Context context) {
            t.e(context, "context");
            CustomAudienceManager obtain = CustomAudienceManager.Companion.obtain(context);
            if (obtain != null) {
                return new Api33Ext4JavaImpl(obtain);
            }
            return null;
        }

        private Companion() {
        }
    }

    public static final CustomAudienceManagerFutures from(Context context) {
        return Companion.from(context);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @ExperimentalFeatures.Ext10OptIn
    public abstract C1722d fetchAndJoinCustomAudienceAsync(FetchAndJoinCustomAudienceRequest fetchAndJoinCustomAudienceRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    public abstract C1722d joinCustomAudienceAsync(JoinCustomAudienceRequest joinCustomAudienceRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    public abstract C1722d leaveCustomAudienceAsync(LeaveCustomAudienceRequest leaveCustomAudienceRequest);
}
