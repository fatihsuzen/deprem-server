package androidx.room.coroutines;

import b3.C2308e;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.room.coroutines.Pool", f = "ConnectionPoolImpl.kt", l = {212}, m = "acquire")
final class Pool$acquire$1 extends d {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Pool this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Pool$acquire$1(Pool pool, C2308e eVar) {
        super(eVar);
        this.this$0 = pool;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.acquire(this);
    }
}
