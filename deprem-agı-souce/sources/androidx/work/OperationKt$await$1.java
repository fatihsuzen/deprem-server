package androidx.work;

import b3.C2308e;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.work.OperationKt", f = "Operation.kt", l = {36}, m = "await")
final class OperationKt$await$1 extends d {
    int label;
    /* synthetic */ Object result;

    OperationKt$await$1(C2308e eVar) {
        super(eVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return OperationKt.await((Operation) null, this);
    }
}
