package androidx.datastore.core.okio;

import b3.C2308e;
import k3.q;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.datastore.core.okio.OkioStorageConnection", f = "OkioStorage.kt", l = {113}, m = "readScope")
final class OkioStorageConnection$readScope$1<R> extends d {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OkioStorageConnection<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OkioStorageConnection$readScope$1(OkioStorageConnection<T> okioStorageConnection, C2308e eVar) {
        super(eVar);
        this.this$0 = okioStorageConnection;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.readScope((q) null, this);
    }
}
