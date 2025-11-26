package androidx.datastore.core;

import W2.u;
import b3.C2308e;
import c3.C2316b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.J;
import kotlin.jvm.internal.L;

@f(c = "androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$3", f = "DataStoreImpl.kt", l = {387, 388, 390}, m = "invokeSuspend")
final class DataStoreImpl$readDataOrHandleCorruption$3 extends l implements k3.l {
    final /* synthetic */ L $newData;
    final /* synthetic */ J $version;
    Object L$0;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataStoreImpl$readDataOrHandleCorruption$3(L l5, DataStoreImpl<T> dataStoreImpl, J j5, C2308e eVar) {
        super(1, eVar);
        this.$newData = l5;
        this.this$0 = dataStoreImpl;
        this.$version = j5;
    }

    public final C2308e create(C2308e eVar) {
        return new DataStoreImpl$readDataOrHandleCorruption$3(this.$newData, this.this$0, this.$version, eVar);
    }

    public final Object invoke(C2308e eVar) {
        return ((DataStoreImpl$readDataOrHandleCorruption$3) create(eVar)).invokeSuspend(W2.J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        J j5;
        J j6;
        L l5;
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            l5 = this.$newData;
            DataStoreImpl<T> dataStoreImpl = this.this$0;
            this.L$0 = l5;
            this.label = 1;
            obj = dataStoreImpl.readDataFromFileOrDefault(this);
            if (obj == f5) {
                return f5;
            }
        } else if (i5 == 1) {
            l5 = (L) this.L$0;
            u.b(obj);
        } else if (i5 == 2) {
            j6 = (J) this.L$0;
            try {
                u.b(obj);
                j6.f24688a = ((Number) obj).intValue();
            } catch (CorruptionException unused) {
                J j7 = this.$version;
                DataStoreImpl<T> dataStoreImpl2 = this.this$0;
                Object obj2 = this.$newData.f24690a;
                this.L$0 = j7;
                this.label = 3;
                Object writeData$datastore_core_release = dataStoreImpl2.writeData$datastore_core_release(obj2, true, this);
                if (writeData$datastore_core_release != f5) {
                    j5 = j7;
                    obj = writeData$datastore_core_release;
                }
            }
            return W2.J.f19942a;
        } else if (i5 == 3) {
            j5 = (J) this.L$0;
            u.b(obj);
            j5.f24688a = ((Number) obj).intValue();
            return W2.J.f19942a;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        l5.f24690a = obj;
        j6 = this.$version;
        InterProcessCoordinator access$getCoordinator = this.this$0.getCoordinator();
        this.L$0 = j6;
        this.label = 2;
        obj = access$getCoordinator.getVersion(this);
        if (obj == f5) {
            return f5;
        }
        j6.f24688a = ((Number) obj).intValue();
        return W2.J.f19942a;
    }
}
