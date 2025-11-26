package androidx.privacysandbox.ads.adservices.java.signals;

import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import androidx.privacysandbox.ads.adservices.signals.ProtectedSignalsManager;
import androidx.privacysandbox.ads.adservices.signals.UpdateSignalsRequest;
import b3.C2308e;
import b3.C2312i;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import n0.C1722d;
import w3.C2865c0;
import w3.N;
import w3.O;

public abstract class ProtectedSignalsManagerFutures {
    public static final Companion Companion = new Companion((C2633k) null);

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        public final ProtectedSignalsManagerFutures from(Context context) {
            t.e(context, "context");
            ProtectedSignalsManager obtain = ProtectedSignalsManager.Companion.obtain(context);
            if (obtain != null) {
                return new JavaImpl(obtain);
            }
            return null;
        }

        private Companion() {
        }
    }

    private static final class JavaImpl extends ProtectedSignalsManagerFutures {
        /* access modifiers changed from: private */
        public final ProtectedSignalsManager mProtectedSignalsManager;

        public JavaImpl(ProtectedSignalsManager protectedSignalsManager) {
            this.mProtectedSignalsManager = protectedSignalsManager;
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_PROTECTED_SIGNALS")
        @DoNotInline
        public C1722d updateSignalsAsync(UpdateSignalsRequest updateSignalsRequest) {
            t.e(updateSignalsRequest, "request");
            return CoroutineAdapterKt.asListenableFuture$default(C2876i.b(N.a(C2865c0.a()), (C2312i) null, (O) null, new ProtectedSignalsManagerFutures$JavaImpl$updateSignalsAsync$1(this, updateSignalsRequest, (C2308e) null), 3, (Object) null), (Object) null, 1, (Object) null);
        }
    }

    public static final ProtectedSignalsManagerFutures from(Context context) {
        return Companion.from(context);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_PROTECTED_SIGNALS")
    public abstract C1722d updateSignalsAsync(UpdateSignalsRequest updateSignalsRequest);
}
