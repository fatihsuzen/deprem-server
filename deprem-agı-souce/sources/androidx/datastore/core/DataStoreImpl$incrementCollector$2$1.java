package androidx.datastore.core;

import W2.J;
import b3.C2308e;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

@f(c = "androidx.datastore.core.DataStoreImpl$incrementCollector$2$1", f = "DataStoreImpl.kt", l = {134, 135}, m = "invokeSuspend")
final class DataStoreImpl$incrementCollector$2$1 extends l implements p {
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataStoreImpl$incrementCollector$2$1(DataStoreImpl<T> dataStoreImpl, C2308e eVar) {
        super(2, eVar);
        this.this$0 = dataStoreImpl;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new DataStoreImpl$incrementCollector$2$1(this.this$0, eVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004b, code lost:
        if (r5.collect(r1, r4) == r0) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004d, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002d, code lost:
        if (r5.awaitComplete(r4) == r0) goto L_0x004d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = c3.C2316b.f()
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001e
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            W2.u.b(r5)
            goto L_0x004e
        L_0x0012:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x001a:
            W2.u.b(r5)
            goto L_0x0030
        L_0x001e:
            W2.u.b(r5)
            androidx.datastore.core.DataStoreImpl<T> r5 = r4.this$0
            androidx.datastore.core.DataStoreImpl$InitDataStore r5 = r5.readAndInit
            r4.label = r3
            java.lang.Object r5 = r5.awaitComplete(r4)
            if (r5 != r0) goto L_0x0030
            goto L_0x004d
        L_0x0030:
            androidx.datastore.core.DataStoreImpl<T> r5 = r4.this$0
            androidx.datastore.core.InterProcessCoordinator r5 = r5.getCoordinator()
            z3.e r5 = r5.getUpdateNotifications()
            z3.e r5 = z3.C2974g.i(r5)
            androidx.datastore.core.DataStoreImpl$incrementCollector$2$1$1 r1 = new androidx.datastore.core.DataStoreImpl$incrementCollector$2$1$1
            androidx.datastore.core.DataStoreImpl<T> r3 = r4.this$0
            r1.<init>(r3)
            r4.label = r2
            java.lang.Object r5 = r5.collect(r1, r4)
            if (r5 != r0) goto L_0x004e
        L_0x004d:
            return r0
        L_0x004e:
            W2.J r5 = W2.J.f19942a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$incrementCollector$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((DataStoreImpl$incrementCollector$2$1) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
