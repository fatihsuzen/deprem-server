package androidx.privacysandbox.ads.adservices.java.adid;

import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.adid.AdIdManager;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import b3.C2308e;
import b3.C2312i;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import n0.C1722d;
import w3.C2865c0;
import w3.N;
import w3.O;

public abstract class AdIdManagerFutures {
    public static final Companion Companion = new Companion((C2633k) null);

    private static final class Api33Ext4JavaImpl extends AdIdManagerFutures {
        /* access modifiers changed from: private */
        public final AdIdManager mAdIdManager;

        public Api33Ext4JavaImpl(AdIdManager adIdManager) {
            t.e(adIdManager, "mAdIdManager");
            this.mAdIdManager = adIdManager;
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_AD_ID")
        @DoNotInline
        public C1722d getAdIdAsync() {
            return CoroutineAdapterKt.asListenableFuture$default(C2876i.b(N.a(C2865c0.a()), (C2312i) null, (O) null, new AdIdManagerFutures$Api33Ext4JavaImpl$getAdIdAsync$1(this, (C2308e) null), 3, (Object) null), (Object) null, 1, (Object) null);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        public final AdIdManagerFutures from(Context context) {
            t.e(context, "context");
            AdIdManager obtain = AdIdManager.Companion.obtain(context);
            if (obtain != null) {
                return new Api33Ext4JavaImpl(obtain);
            }
            return null;
        }

        private Companion() {
        }
    }

    public static final AdIdManagerFutures from(Context context) {
        return Companion.from(context);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_AD_ID")
    public abstract C1722d getAdIdAsync();
}
