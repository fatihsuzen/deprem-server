package androidx.datastore.core;

import W2.J;
import b3.C2308e;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import z3.C2973f;

@f(c = "androidx.datastore.core.DataStoreImpl$data$1", f = "DataStoreImpl.kt", l = {72, 74, 100}, m = "invokeSuspend")
final class DataStoreImpl$data$1 extends l implements p {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataStoreImpl$data$1(DataStoreImpl<T> dataStoreImpl, C2308e eVar) {
        super(2, eVar);
        this.this$0 = dataStoreImpl;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        DataStoreImpl$data$1 dataStoreImpl$data$1 = new DataStoreImpl$data$1(this.this$0, eVar);
        dataStoreImpl$data$1.L$0 = obj;
        return dataStoreImpl$data$1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00bb, code lost:
        if (z3.C2974g.m(r1, r9, r8) == r0) goto L_0x00bd;
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
            if (r1 == 0) goto L_0x0032
            if (r1 == r4) goto L_0x002a
            if (r1 == r3) goto L_0x001e
            if (r1 != r2) goto L_0x0016
            W2.u.b(r9)
            goto L_0x00be
        L_0x0016:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x001e:
            java.lang.Object r1 = r8.L$1
            androidx.datastore.core.State r1 = (androidx.datastore.core.State) r1
            java.lang.Object r3 = r8.L$0
            z3.f r3 = (z3.C2973f) r3
            W2.u.b(r9)
            goto L_0x0067
        L_0x002a:
            java.lang.Object r1 = r8.L$0
            z3.f r1 = (z3.C2973f) r1
            W2.u.b(r9)
            goto L_0x004b
        L_0x0032:
            W2.u.b(r9)
            java.lang.Object r9 = r8.L$0
            z3.f r9 = (z3.C2973f) r9
            androidx.datastore.core.DataStoreImpl<T> r1 = r8.this$0
            r8.L$0 = r9
            r8.label = r4
            r4 = 0
            java.lang.Object r1 = r1.readState(r4, r8)
            if (r1 != r0) goto L_0x0048
            goto L_0x00bd
        L_0x0048:
            r7 = r1
            r1 = r9
            r9 = r7
        L_0x004b:
            androidx.datastore.core.State r9 = (androidx.datastore.core.State) r9
            boolean r4 = r9 instanceof androidx.datastore.core.Data
            if (r4 == 0) goto L_0x006a
            r4 = r9
            androidx.datastore.core.Data r4 = (androidx.datastore.core.Data) r4
            java.lang.Object r4 = r4.getValue()
            r8.L$0 = r1
            r8.L$1 = r9
            r8.label = r3
            java.lang.Object r3 = r1.emit(r4, r8)
            if (r3 != r0) goto L_0x0065
            goto L_0x00bd
        L_0x0065:
            r3 = r1
            r1 = r9
        L_0x0067:
            r9 = r1
            r1 = r3
            goto L_0x0079
        L_0x006a:
            boolean r3 = r9 instanceof androidx.datastore.core.UnInitialized
            if (r3 != 0) goto L_0x00c8
            boolean r3 = r9 instanceof androidx.datastore.core.ReadException
            if (r3 != 0) goto L_0x00c1
            boolean r3 = r9 instanceof androidx.datastore.core.Final
            if (r3 == 0) goto L_0x0079
            W2.J r9 = W2.J.f19942a
            return r9
        L_0x0079:
            androidx.datastore.core.DataStoreImpl<T> r3 = r8.this$0
            androidx.datastore.core.DataStoreInMemoryCache r3 = r3.inMemoryCache
            z3.e r3 = r3.getFlow()
            androidx.datastore.core.DataStoreImpl$data$1$1 r4 = new androidx.datastore.core.DataStoreImpl$data$1$1
            androidx.datastore.core.DataStoreImpl<T> r5 = r8.this$0
            r6 = 0
            r4.<init>(r5, r6)
            z3.e r3 = z3.C2974g.x(r3, r4)
            androidx.datastore.core.DataStoreImpl$data$1$2 r4 = new androidx.datastore.core.DataStoreImpl$data$1$2
            r4.<init>(r6)
            z3.e r3 = z3.C2974g.z(r3, r4)
            androidx.datastore.core.DataStoreImpl$data$1$3 r4 = new androidx.datastore.core.DataStoreImpl$data$1$3
            r4.<init>(r9, r6)
            z3.e r9 = z3.C2974g.k(r3, r4)
            androidx.datastore.core.DataStoreImpl$data$1$invokeSuspend$$inlined$map$1 r3 = new androidx.datastore.core.DataStoreImpl$data$1$invokeSuspend$$inlined$map$1
            r3.<init>(r9)
            androidx.datastore.core.DataStoreImpl$data$1$5 r9 = new androidx.datastore.core.DataStoreImpl$data$1$5
            androidx.datastore.core.DataStoreImpl<T> r4 = r8.this$0
            r9.<init>(r4, r6)
            z3.e r9 = z3.C2974g.v(r3, r9)
            r8.L$0 = r6
            r8.L$1 = r6
            r8.label = r2
            java.lang.Object r9 = z3.C2974g.m(r1, r9, r8)
            if (r9 != r0) goto L_0x00be
        L_0x00bd:
            return r0
        L_0x00be:
            W2.J r9 = W2.J.f19942a
            return r9
        L_0x00c1:
            androidx.datastore.core.ReadException r9 = (androidx.datastore.core.ReadException) r9
            java.lang.Throwable r9 = r9.getReadException()
            throw r9
        L_0x00c8:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542"
            r9.<init>(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$data$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    public final Object invoke(C2973f fVar, C2308e eVar) {
        return ((DataStoreImpl$data$1) create(fVar, eVar)).invokeSuspend(J.f19942a);
    }
}
