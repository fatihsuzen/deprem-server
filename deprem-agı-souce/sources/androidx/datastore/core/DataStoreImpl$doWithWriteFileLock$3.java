package androidx.datastore.core;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;

@f(c = "androidx.datastore.core.DataStoreImpl$doWithWriteFileLock$3", f = "DataStoreImpl.kt", l = {416}, m = "invokeSuspend")
final class DataStoreImpl$doWithWriteFileLock$3 extends l implements k3.l {
    final /* synthetic */ k3.l $block;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataStoreImpl$doWithWriteFileLock$3(k3.l lVar, C2308e eVar) {
        super(1, eVar);
        this.$block = lVar;
    }

    public final C2308e create(C2308e eVar) {
        return new DataStoreImpl$doWithWriteFileLock$3(this.$block, eVar);
    }

    public final Object invoke(C2308e eVar) {
        return ((DataStoreImpl$doWithWriteFileLock$3) create(eVar)).invokeSuspend(J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            k3.l lVar = this.$block;
            this.label = 1;
            Object invoke = lVar.invoke(this);
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
}
