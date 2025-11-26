package androidx.datastore.core;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

@f(c = "androidx.datastore.core.DataStoreImpl$transformAndWrite$2$newData$1", f = "DataStoreImpl.kt", l = {331}, m = "invokeSuspend")
final class DataStoreImpl$transformAndWrite$2$newData$1 extends l implements p {
    final /* synthetic */ Data<T> $curData;
    final /* synthetic */ p $transform;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataStoreImpl$transformAndWrite$2$newData$1(p pVar, Data<T> data, C2308e eVar) {
        super(2, eVar);
        this.$transform = pVar;
        this.$curData = data;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new DataStoreImpl$transformAndWrite$2$newData$1(this.$transform, this.$curData, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            p pVar = this.$transform;
            T value = this.$curData.getValue();
            this.label = 1;
            Object invoke = pVar.invoke(value, this);
            if (invoke == f5) {
                return f5;
            }
            return invoke;
        } else if (i5 == 1) {
            u.b(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((DataStoreImpl$transformAndWrite$2$newData$1) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
