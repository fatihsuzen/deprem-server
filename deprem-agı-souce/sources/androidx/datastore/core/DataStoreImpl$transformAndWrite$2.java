package androidx.datastore.core;

import W2.J;
import b3.C2308e;
import b3.C2312i;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;

@f(c = "androidx.datastore.core.DataStoreImpl$transformAndWrite$2", f = "DataStoreImpl.kt", l = {330, 331, 337}, m = "invokeSuspend")
final class DataStoreImpl$transformAndWrite$2 extends l implements k3.l {
    final /* synthetic */ C2312i $callerContext;
    final /* synthetic */ p $transform;
    Object L$0;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataStoreImpl$transformAndWrite$2(DataStoreImpl<T> dataStoreImpl, C2312i iVar, p pVar, C2308e eVar) {
        super(1, eVar);
        this.this$0 = dataStoreImpl;
        this.$callerContext = iVar;
        this.$transform = pVar;
    }

    public final C2308e create(C2308e eVar) {
        return new DataStoreImpl$transformAndWrite$2(this.this$0, this.$callerContext, this.$transform, eVar);
    }

    public final Object invoke(C2308e eVar) {
        return ((DataStoreImpl$transformAndWrite$2) create(eVar)).invokeSuspend(J.f19942a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0036, code lost:
        if (r9 == r0) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004e, code lost:
        if (r9 == r0) goto L_0x006a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = c3.C2316b.f()
            int r1 = r8.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x002b
            if (r1 == r4) goto L_0x0027
            if (r1 == r3) goto L_0x001f
            if (r1 != r2) goto L_0x0017
            java.lang.Object r0 = r8.L$0
            W2.u.b(r9)
            return r0
        L_0x0017:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x001f:
            java.lang.Object r1 = r8.L$0
            androidx.datastore.core.Data r1 = (androidx.datastore.core.Data) r1
            W2.u.b(r9)
            goto L_0x0051
        L_0x0027:
            W2.u.b(r9)
            goto L_0x0039
        L_0x002b:
            W2.u.b(r9)
            androidx.datastore.core.DataStoreImpl<T> r9 = r8.this$0
            r8.label = r4
            java.lang.Object r9 = r9.readDataOrHandleCorruption(r4, r8)
            if (r9 != r0) goto L_0x0039
            goto L_0x006a
        L_0x0039:
            r1 = r9
            androidx.datastore.core.Data r1 = (androidx.datastore.core.Data) r1
            b3.i r9 = r8.$callerContext
            androidx.datastore.core.DataStoreImpl$transformAndWrite$2$newData$1 r5 = new androidx.datastore.core.DataStoreImpl$transformAndWrite$2$newData$1
            k3.p r6 = r8.$transform
            r7 = 0
            r5.<init>(r6, r1, r7)
            r8.L$0 = r1
            r8.label = r3
            java.lang.Object r9 = w3.C2872g.g(r9, r5, r8)
            if (r9 != r0) goto L_0x0051
            goto L_0x006a
        L_0x0051:
            r1.checkHashCode()
            java.lang.Object r1 = r1.getValue()
            boolean r1 = kotlin.jvm.internal.t.a(r1, r9)
            if (r1 != 0) goto L_0x006b
            androidx.datastore.core.DataStoreImpl<T> r1 = r8.this$0
            r8.L$0 = r9
            r8.label = r2
            java.lang.Object r1 = r1.writeData$datastore_core_release(r9, r4, r8)
            if (r1 != r0) goto L_0x006b
        L_0x006a:
            return r0
        L_0x006b:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$transformAndWrite$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
