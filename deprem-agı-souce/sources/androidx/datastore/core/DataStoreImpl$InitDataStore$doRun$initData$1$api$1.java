package androidx.datastore.core;

import F3.a;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.L;

public final class DataStoreImpl$InitDataStore$doRun$initData$1$api$1 implements InitializerApi<T> {
    final /* synthetic */ L $currentData;
    final /* synthetic */ I $initializationComplete;
    final /* synthetic */ a $updateLock;
    final /* synthetic */ DataStoreImpl<T> this$0;

    DataStoreImpl$InitDataStore$doRun$initData$1$api$1(a aVar, I i5, L l5, DataStoreImpl<T> dataStoreImpl) {
        this.$updateLock = aVar;
        this.$initializationComplete = i5;
        this.$currentData = l5;
        this.this$0 = dataStoreImpl;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009a A[Catch:{ all -> 0x00d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ba A[Catch:{ all -> 0x0056 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d1 A[Catch:{ all -> 0x003b }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object updateData(k3.p r10, b3.C2308e r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1 r0 = (androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1 r0 = new androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1$api$1$updateData$1
            r0.<init>(r9, r11)
        L_0x0018:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0076
            if (r2 == r5) goto L_0x005a
            if (r2 == r4) goto L_0x0046
            if (r2 != r3) goto L_0x003e
            java.lang.Object r10 = r0.L$2
            java.lang.Object r1 = r0.L$1
            kotlin.jvm.internal.L r1 = (kotlin.jvm.internal.L) r1
            java.lang.Object r0 = r0.L$0
            F3.a r0 = (F3.a) r0
            W2.u.b(r11)     // Catch:{ all -> 0x003b }
            goto L_0x00cd
        L_0x003b:
            r10 = move-exception
            goto L_0x00e3
        L_0x003e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0046:
            java.lang.Object r10 = r0.L$2
            androidx.datastore.core.DataStoreImpl r10 = (androidx.datastore.core.DataStoreImpl) r10
            java.lang.Object r2 = r0.L$1
            kotlin.jvm.internal.L r2 = (kotlin.jvm.internal.L) r2
            java.lang.Object r4 = r0.L$0
            F3.a r4 = (F3.a) r4
            W2.u.b(r11)     // Catch:{ all -> 0x0056 }
            goto L_0x00b2
        L_0x0056:
            r10 = move-exception
            r0 = r4
            goto L_0x00e3
        L_0x005a:
            java.lang.Object r10 = r0.L$4
            androidx.datastore.core.DataStoreImpl r10 = (androidx.datastore.core.DataStoreImpl) r10
            java.lang.Object r2 = r0.L$3
            kotlin.jvm.internal.L r2 = (kotlin.jvm.internal.L) r2
            java.lang.Object r5 = r0.L$2
            kotlin.jvm.internal.I r5 = (kotlin.jvm.internal.I) r5
            java.lang.Object r7 = r0.L$1
            F3.a r7 = (F3.a) r7
            java.lang.Object r8 = r0.L$0
            k3.p r8 = (k3.p) r8
            W2.u.b(r11)
            r11 = r8
            r8 = r10
            r10 = r11
            r11 = r7
            goto L_0x0096
        L_0x0076:
            W2.u.b(r11)
            F3.a r11 = r9.$updateLock
            kotlin.jvm.internal.I r2 = r9.$initializationComplete
            kotlin.jvm.internal.L r7 = r9.$currentData
            androidx.datastore.core.DataStoreImpl<T> r8 = r9.this$0
            r0.L$0 = r10
            r0.L$1 = r11
            r0.L$2 = r2
            r0.L$3 = r7
            r0.L$4 = r8
            r0.label = r5
            java.lang.Object r5 = r11.lock(r6, r0)
            if (r5 != r1) goto L_0x0094
            goto L_0x00c9
        L_0x0094:
            r5 = r2
            r2 = r7
        L_0x0096:
            boolean r5 = r5.f24687a     // Catch:{ all -> 0x00d8 }
            if (r5 != 0) goto L_0x00db
            java.lang.Object r5 = r2.f24690a     // Catch:{ all -> 0x00d8 }
            r0.L$0 = r11     // Catch:{ all -> 0x00d8 }
            r0.L$1 = r2     // Catch:{ all -> 0x00d8 }
            r0.L$2 = r8     // Catch:{ all -> 0x00d8 }
            r0.L$3 = r6     // Catch:{ all -> 0x00d8 }
            r0.L$4 = r6     // Catch:{ all -> 0x00d8 }
            r0.label = r4     // Catch:{ all -> 0x00d8 }
            java.lang.Object r10 = r10.invoke(r5, r0)     // Catch:{ all -> 0x00d8 }
            if (r10 != r1) goto L_0x00af
            goto L_0x00c9
        L_0x00af:
            r4 = r11
            r11 = r10
            r10 = r8
        L_0x00b2:
            java.lang.Object r5 = r2.f24690a     // Catch:{ all -> 0x0056 }
            boolean r5 = kotlin.jvm.internal.t.a(r11, r5)     // Catch:{ all -> 0x0056 }
            if (r5 != 0) goto L_0x00d1
            r0.L$0 = r4     // Catch:{ all -> 0x0056 }
            r0.L$1 = r2     // Catch:{ all -> 0x0056 }
            r0.L$2 = r11     // Catch:{ all -> 0x0056 }
            r0.label = r3     // Catch:{ all -> 0x0056 }
            r3 = 0
            java.lang.Object r10 = r10.writeData$datastore_core_release(r11, r3, r0)     // Catch:{ all -> 0x0056 }
            if (r10 != r1) goto L_0x00ca
        L_0x00c9:
            return r1
        L_0x00ca:
            r10 = r11
            r1 = r2
            r0 = r4
        L_0x00cd:
            r1.f24690a = r10     // Catch:{ all -> 0x003b }
            r2 = r1
            goto L_0x00d2
        L_0x00d1:
            r0 = r4
        L_0x00d2:
            java.lang.Object r10 = r2.f24690a     // Catch:{ all -> 0x003b }
            r0.unlock(r6)
            return r10
        L_0x00d8:
            r10 = move-exception
            r0 = r11
            goto L_0x00e3
        L_0x00db:
            java.lang.String r10 = "InitializerApi.updateData should not be called after initialization is complete."
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00d8 }
            r0.<init>(r10)     // Catch:{ all -> 0x00d8 }
            throw r0     // Catch:{ all -> 0x00d8 }
        L_0x00e3:
            r0.unlock(r6)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1$api$1.updateData(k3.p, b3.e):java.lang.Object");
    }
}
