package androidx.privacysandbox.ads.adservices.java.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import kotlin.jvm.internal.t;
import n0.C1722d;
import w3.U;

public final class CoroutineAdapterKt {
    public static final <T> C1722d asListenableFuture(U u5, Object obj) {
        t.e(u5, "<this>");
        C1722d future = CallbackToFutureAdapter.getFuture(new a(u5, obj));
        t.d(future, "getFuture { completer ->…      }\n        tag\n    }");
        return future;
    }

    public static /* synthetic */ C1722d asListenableFuture$default(U u5, Object obj, int i5, Object obj2) {
        if ((i5 & 1) != 0) {
            obj = "Deferred.asListenableFuture";
        }
        return asListenableFuture(u5, obj);
    }

    /* access modifiers changed from: private */
    public static final Object asListenableFuture$lambda$0(U u5, Object obj, CallbackToFutureAdapter.Completer completer) {
        t.e(u5, "$this_asListenableFuture");
        t.e(completer, "completer");
        u5.s(new CoroutineAdapterKt$asListenableFuture$1$1(completer, u5));
        return obj;
    }
}
