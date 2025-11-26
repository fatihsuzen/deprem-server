package androidx.datastore.core;

import k3.C2616a;
import kotlin.jvm.internal.u;

final class DataStoreImpl$storageConnectionDelegate$1 extends u implements C2616a {
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataStoreImpl$storageConnectionDelegate$1(DataStoreImpl<T> dataStoreImpl) {
        super(0);
        this.this$0 = dataStoreImpl;
    }

    public final StorageConnection<T> invoke() {
        return this.this$0.storage.createConnection();
    }
}
