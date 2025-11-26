package androidx.datastore.core;

import b3.C2308e;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.datastore.core.DataStoreImpl", f = "DataStoreImpl.kt", l = {287, 296, 304}, m = "readDataAndUpdateCache")
final class DataStoreImpl$readDataAndUpdateCache$1 extends d {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataStoreImpl$readDataAndUpdateCache$1(DataStoreImpl<T> dataStoreImpl, C2308e eVar) {
        super(eVar);
        this.this$0 = dataStoreImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.readDataAndUpdateCache(false, this);
    }
}
