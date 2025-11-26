package androidx.datastore.core;

import W2.J;
import W2.u;
import W2.y;
import b3.C2308e;
import c3.C2316b;
import kotlin.coroutines.jvm.internal.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;

@f(c = "androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$3", f = "DataStoreImpl.kt", l = {298, 300}, m = "invokeSuspend")
final class DataStoreImpl$readDataAndUpdateCache$3 extends l implements k3.l {
    Object L$0;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataStoreImpl$readDataAndUpdateCache$3(DataStoreImpl<T> dataStoreImpl, C2308e eVar) {
        super(1, eVar);
        this.this$0 = dataStoreImpl;
    }

    public final C2308e create(C2308e eVar) {
        return new DataStoreImpl$readDataAndUpdateCache$3(this.this$0, eVar);
    }

    public final Object invoke(C2308e eVar) {
        return ((DataStoreImpl$readDataAndUpdateCache$3) create(eVar)).invokeSuspend(J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        State state;
        Throwable th;
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            DataStoreImpl<T> dataStoreImpl = this.this$0;
            this.label = 1;
            obj = dataStoreImpl.readDataOrHandleCorruption(true, this);
            if (obj == f5) {
                return f5;
            }
        } else if (i5 == 1) {
            try {
                u.b(obj);
            } catch (Throwable th2) {
                InterProcessCoordinator access$getCoordinator = this.this$0.getCoordinator();
                this.L$0 = th2;
                this.label = 2;
                Object version = access$getCoordinator.getVersion(this);
                if (version != f5) {
                    th = th2;
                    obj = version;
                }
            }
        } else if (i5 == 2) {
            th = (Throwable) this.L$0;
            u.b(obj);
            state = new ReadException(th, ((Number) obj).intValue());
            return y.a(state, b.a(true));
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        state = (State) obj;
        return y.a(state, b.a(true));
    }
}
