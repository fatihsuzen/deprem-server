package androidx.datastore.core.okio;

import b3.C2308e;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.datastore.core.okio.OkioReadScope", f = "OkioStorage.kt", l = {180, 187}, m = "readData$suspendImpl")
final class OkioReadScope$readData$1<T> extends d {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OkioReadScope<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OkioReadScope$readData$1(OkioReadScope<T> okioReadScope, C2308e eVar) {
        super(eVar);
        this.this$0 = okioReadScope;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return OkioReadScope.readData$suspendImpl(this.this$0, this);
    }
}
