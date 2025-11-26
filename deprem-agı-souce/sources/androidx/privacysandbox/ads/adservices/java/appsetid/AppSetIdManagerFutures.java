package androidx.privacysandbox.ads.adservices.java.appsetid;

import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManager;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import b3.C2308e;
import b3.C2312i;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import n0.C1722d;
import w3.C2865c0;
import w3.N;
import w3.O;

public abstract class AppSetIdManagerFutures {
    public static final Companion Companion = new Companion((C2633k) null);

    private static final class Api33Ext4JavaImpl extends AppSetIdManagerFutures {
        /* access modifiers changed from: private */
        public final AppSetIdManager mAppSetIdManager;

        public Api33Ext4JavaImpl(AppSetIdManager appSetIdManager) {
            t.e(appSetIdManager, "mAppSetIdManager");
            this.mAppSetIdManager = appSetIdManager;
        }

        @DoNotInline
        public C1722d getAppSetIdAsync() {
            return CoroutineAdapterKt.asListenableFuture$default(C2876i.b(N.a(C2865c0.a()), (C2312i) null, (O) null, new AppSetIdManagerFutures$Api33Ext4JavaImpl$getAppSetIdAsync$1(this, (C2308e) null), 3, (Object) null), (Object) null, 1, (Object) null);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        public final AppSetIdManagerFutures from(Context context) {
            t.e(context, "context");
            AppSetIdManager obtain = AppSetIdManager.Companion.obtain(context);
            if (obtain != null) {
                return new Api33Ext4JavaImpl(obtain);
            }
            return null;
        }

        private Companion() {
        }
    }

    public static final AppSetIdManagerFutures from(Context context) {
        return Companion.from(context);
    }

    public abstract C1722d getAppSetIdAsync();
}
