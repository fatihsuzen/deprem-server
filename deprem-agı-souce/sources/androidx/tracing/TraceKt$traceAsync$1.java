package androidx.tracing;

import b3.C2308e;
import k3.l;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.tracing.TraceKt", f = "Trace.kt", l = {76}, m = "traceAsync")
final class TraceKt$traceAsync$1<T> extends d {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;

    TraceKt$traceAsync$1(C2308e eVar) {
        super(eVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return TraceKt.traceAsync((String) null, 0, (l) null, this);
    }
}
