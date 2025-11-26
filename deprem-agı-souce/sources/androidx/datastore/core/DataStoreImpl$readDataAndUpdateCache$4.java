package androidx.datastore.core;

import W2.J;
import W2.u;
import W2.y;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;

@f(c = "androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$4", f = "DataStoreImpl.kt", l = {306, 309}, m = "invokeSuspend")
final class DataStoreImpl$readDataAndUpdateCache$4 extends l implements p {
    final /* synthetic */ int $cachedVersion;
    Object L$0;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataStoreImpl$readDataAndUpdateCache$4(DataStoreImpl<T> dataStoreImpl, int i5, C2308e eVar) {
        super(2, eVar);
        this.this$0 = dataStoreImpl;
        this.$cachedVersion = i5;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        DataStoreImpl$readDataAndUpdateCache$4 dataStoreImpl$readDataAndUpdateCache$4 = new DataStoreImpl$readDataAndUpdateCache$4(this.this$0, this.$cachedVersion, eVar);
        dataStoreImpl$readDataAndUpdateCache$4.Z$0 = ((Boolean) obj).booleanValue();
        return dataStoreImpl$readDataAndUpdateCache$4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Boolean) obj).booleanValue(), (C2308e) obj2);
    }

    public final Object invokeSuspend(Object obj) {
        State state;
        boolean z4;
        int i5;
        Throwable th;
        boolean z5;
        Object f5 = C2316b.f();
        int i6 = this.label;
        if (i6 == 0) {
            u.b(obj);
            z4 = this.Z$0;
            DataStoreImpl<T> dataStoreImpl = this.this$0;
            this.Z$0 = z4;
            this.label = 1;
            obj = dataStoreImpl.readDataOrHandleCorruption(z4, this);
            if (obj == f5) {
                return f5;
            }
        } else if (i6 == 1) {
            z4 = this.Z$0;
            try {
                u.b(obj);
            } catch (Throwable th2) {
                if (z4) {
                    InterProcessCoordinator access$getCoordinator = this.this$0.getCoordinator();
                    this.L$0 = th2;
                    this.Z$0 = z4;
                    this.label = 2;
                    Object version = access$getCoordinator.getVersion(this);
                    if (version != f5) {
                        z5 = z4;
                        th = th2;
                        obj = version;
                    }
                } else {
                    boolean z6 = z4;
                    th = th2;
                    i5 = this.$cachedVersion;
                    z5 = z6;
                }
            }
        } else if (i6 == 2) {
            z5 = this.Z$0;
            th = (Throwable) this.L$0;
            u.b(obj);
            i5 = ((Number) obj).intValue();
            ReadException readException = new ReadException(th, i5);
            z4 = z5;
            state = readException;
            return y.a(state, b.a(z4));
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        state = (State) obj;
        return y.a(state, b.a(z4));
    }

    public final Object invoke(boolean z4, C2308e eVar) {
        return ((DataStoreImpl$readDataAndUpdateCache$4) create(Boolean.valueOf(z4), eVar)).invokeSuspend(J.f19942a);
    }
}
