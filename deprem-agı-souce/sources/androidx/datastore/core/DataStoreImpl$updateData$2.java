package androidx.datastore.core;

import W2.J;
import W2.u;
import androidx.datastore.core.Message;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.C2901v;
import w3.C2905x;
import w3.C2908y0;
import w3.M;

@f(c = "androidx.datastore.core.DataStoreImpl$updateData$2", f = "DataStoreImpl.kt", l = {169}, m = "invokeSuspend")
final class DataStoreImpl$updateData$2 extends l implements p {
    final /* synthetic */ p $transform;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataStoreImpl$updateData$2(DataStoreImpl<T> dataStoreImpl, p pVar, C2308e eVar) {
        super(2, eVar);
        this.this$0 = dataStoreImpl;
        this.$transform = pVar;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        DataStoreImpl$updateData$2 dataStoreImpl$updateData$2 = new DataStoreImpl$updateData$2(this.this$0, this.$transform, eVar);
        dataStoreImpl$updateData$2.L$0 = obj;
        return dataStoreImpl$updateData$2;
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            C2901v b5 = C2905x.b((C2908y0) null, 1, (Object) null);
            this.this$0.writeActor.offer(new Message.Update(this.$transform, b5, this.this$0.inMemoryCache.getCurrentState(), ((M) this.L$0).getCoroutineContext()));
            this.label = 1;
            Object A4 = b5.A(this);
            if (A4 == f5) {
                return f5;
            }
            return A4;
        } else if (i5 == 1) {
            u.b(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((DataStoreImpl$updateData$2) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
