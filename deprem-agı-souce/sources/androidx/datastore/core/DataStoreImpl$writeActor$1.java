package androidx.datastore.core;

import W2.J;
import k3.l;
import kotlin.jvm.internal.u;

final class DataStoreImpl$writeActor$1 extends u implements l {
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataStoreImpl$writeActor$1(DataStoreImpl<T> dataStoreImpl) {
        super(1);
        this.this$0 = dataStoreImpl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return J.f19942a;
    }

    public final void invoke(Throwable th) {
        if (th != null) {
            this.this$0.inMemoryCache.tryUpdate(new Final(th));
        }
        if (this.this$0.storageConnectionDelegate.isInitialized()) {
            this.this$0.getStorageConnection$datastore_core_release().close();
        }
    }
}
