package androidx.datastore.core;

import java.io.File;
import kotlin.jvm.internal.t;

public final class FileWriteScope<T> extends FileReadScope<T> implements WriteScope<T> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileWriteScope(File file, Serializer<T> serializer) {
        super(file, serializer);
        t.e(file, "file");
        t.e(serializer, "serializer");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object writeData(T r6, b3.C2308e r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.datastore.core.FileWriteScope$writeData$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            androidx.datastore.core.FileWriteScope$writeData$1 r0 = (androidx.datastore.core.FileWriteScope$writeData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.FileWriteScope$writeData$1 r0 = new androidx.datastore.core.FileWriteScope$writeData$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r6 = r0.L$1
            java.io.FileOutputStream r6 = (java.io.FileOutputStream) r6
            java.lang.Object r0 = r0.L$0
            java.io.Closeable r0 = (java.io.Closeable) r0
            W2.u.b(r7)     // Catch:{ all -> 0x0031 }
            goto L_0x0062
        L_0x0031:
            r6 = move-exception
            goto L_0x0074
        L_0x0033:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003b:
            W2.u.b(r7)
            r5.checkNotClosed()
            java.io.FileOutputStream r7 = new java.io.FileOutputStream
            java.io.File r2 = r5.getFile()
            r7.<init>(r2)
            androidx.datastore.core.Serializer r2 = r5.getSerializer()     // Catch:{ all -> 0x0072 }
            androidx.datastore.core.UncloseableOutputStream r4 = new androidx.datastore.core.UncloseableOutputStream     // Catch:{ all -> 0x0072 }
            r4.<init>(r7)     // Catch:{ all -> 0x0072 }
            r0.L$0 = r7     // Catch:{ all -> 0x0072 }
            r0.L$1 = r7     // Catch:{ all -> 0x0072 }
            r0.label = r3     // Catch:{ all -> 0x0072 }
            java.lang.Object r6 = r2.writeTo(r6, r4, r0)     // Catch:{ all -> 0x0072 }
            if (r6 != r1) goto L_0x0060
            return r1
        L_0x0060:
            r6 = r7
            r0 = r6
        L_0x0062:
            java.io.FileDescriptor r6 = r6.getFD()     // Catch:{ all -> 0x0031 }
            r6.sync()     // Catch:{ all -> 0x0031 }
            W2.J r6 = W2.J.f19942a     // Catch:{ all -> 0x0031 }
            r6 = 0
            h3.C2453b.a(r0, r6)
            W2.J r6 = W2.J.f19942a
            return r6
        L_0x0072:
            r6 = move-exception
            r0 = r7
        L_0x0074:
            throw r6     // Catch:{ all -> 0x0075 }
        L_0x0075:
            r7 = move-exception
            h3.C2453b.a(r0, r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.FileWriteScope.writeData(java.lang.Object, b3.e):java.lang.Object");
    }
}
