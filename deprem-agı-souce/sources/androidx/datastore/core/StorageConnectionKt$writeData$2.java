package androidx.datastore.core;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;

@f(c = "androidx.datastore.core.StorageConnectionKt$writeData$2", f = "StorageConnection.kt", l = {77}, m = "invokeSuspend")
final class StorageConnectionKt$writeData$2 extends l implements p {
    final /* synthetic */ T $value;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StorageConnectionKt$writeData$2(T t5, C2308e eVar) {
        super(2, eVar);
        this.$value = t5;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        StorageConnectionKt$writeData$2 storageConnectionKt$writeData$2 = new StorageConnectionKt$writeData$2(this.$value, eVar);
        storageConnectionKt$writeData$2.L$0 = obj;
        return storageConnectionKt$writeData$2;
    }

    public final Object invoke(WriteScope<T> writeScope, C2308e eVar) {
        return ((StorageConnectionKt$writeData$2) create(writeScope, eVar)).invokeSuspend(J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            T t5 = this.$value;
            this.label = 1;
            if (((WriteScope) this.L$0).writeData(t5, this) == f5) {
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
