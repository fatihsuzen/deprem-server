package androidx.datastore.core;

import W2.J;
import W2.u;
import androidx.datastore.core.Message;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;

@f(c = "androidx.datastore.core.DataStoreImpl$writeActor$3", f = "DataStoreImpl.kt", l = {207}, m = "invokeSuspend")
final class DataStoreImpl$writeActor$3 extends l implements p {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataStoreImpl$writeActor$3(DataStoreImpl<T> dataStoreImpl, C2308e eVar) {
        super(2, eVar);
        this.this$0 = dataStoreImpl;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        DataStoreImpl$writeActor$3 dataStoreImpl$writeActor$3 = new DataStoreImpl$writeActor$3(this.this$0, eVar);
        dataStoreImpl$writeActor$3.L$0 = obj;
        return dataStoreImpl$writeActor$3;
    }

    public final Object invoke(Message.Update<T> update, C2308e eVar) {
        return ((DataStoreImpl$writeActor$3) create(update, eVar)).invokeSuspend(J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            DataStoreImpl<T> dataStoreImpl = this.this$0;
            this.label = 1;
            if (dataStoreImpl.handleUpdate((Message.Update) this.L$0, this) == f5) {
                return f5;
            }
        } else if (i5 == 1) {
            u.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return J.f19942a;
    }
}
