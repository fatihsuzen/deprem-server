package androidx.datastore.core;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import k3.q;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;

@f(c = "androidx.datastore.core.StorageConnectionKt$readData$2", f = "StorageConnection.kt", l = {74}, m = "invokeSuspend")
final class StorageConnectionKt$readData$2 extends l implements q {
    private /* synthetic */ Object L$0;
    int label;

    StorageConnectionKt$readData$2(C2308e eVar) {
        super(3, eVar);
    }

    public final Object invoke(ReadScope<T> readScope, boolean z4, C2308e eVar) {
        StorageConnectionKt$readData$2 storageConnectionKt$readData$2 = new StorageConnectionKt$readData$2(eVar);
        storageConnectionKt$readData$2.L$0 = readScope;
        return storageConnectionKt$readData$2.invokeSuspend(J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            this.label = 1;
            Object readData = ((ReadScope) this.L$0).readData(this);
            if (readData == f5) {
                return f5;
            }
            return readData;
        } else if (i5 == 1) {
            u.b(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((ReadScope) obj, ((Boolean) obj2).booleanValue(), (C2308e) obj3);
    }
}
