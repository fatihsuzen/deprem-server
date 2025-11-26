package androidx.datastore.core;

import F3.a;
import F3.g;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import k3.C2616a;
import kotlin.jvm.internal.t;

public final class FileStorageConnection<T> implements StorageConnection<T> {
    private final AtomicBoolean closed = new AtomicBoolean(false);
    private final InterProcessCoordinator coordinator;
    private final File file;
    private final C2616a onClose;
    private final Serializer<T> serializer;
    private final a transactionMutex = g.b(false, 1, (Object) null);

    public FileStorageConnection(File file2, Serializer<T> serializer2, InterProcessCoordinator interProcessCoordinator, C2616a aVar) {
        t.e(file2, "file");
        t.e(serializer2, "serializer");
        t.e(interProcessCoordinator, "coordinator");
        t.e(aVar, "onClose");
        this.file = file2;
        this.serializer = serializer2;
        this.coordinator = interProcessCoordinator;
        this.onClose = aVar;
    }

    private final void checkNotClosed() {
        if (this.closed.get()) {
            throw new IllegalStateException("StorageConnection has already been disposed.");
        }
    }

    private final void createParentDirectories(File file2) {
        File parentFile = file2.getCanonicalFile().getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
            if (!parentFile.isDirectory()) {
                throw new IOException("Unable to create parent directories of " + file2);
            }
        }
    }

    public void close() {
        this.closed.set(true);
        this.onClose.invoke();
    }

    public InterProcessCoordinator getCoordinator() {
        return this.coordinator;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x007c, code lost:
        r9 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0088, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        W2.C2216e.a(r9, r1);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:31:0x007b, B:36:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007b A[SYNTHETIC, Splitter:B:31:0x007b] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <R> java.lang.Object readScope(k3.q r8, b3.C2308e r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof androidx.datastore.core.FileStorageConnection$readScope$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            androidx.datastore.core.FileStorageConnection$readScope$1 r0 = (androidx.datastore.core.FileStorageConnection$readScope$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.FileStorageConnection$readScope$1 r0 = new androidx.datastore.core.FileStorageConnection$readScope$1
            r0.<init>(r7, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            boolean r8 = r0.Z$0
            java.lang.Object r1 = r0.L$1
            androidx.datastore.core.Closeable r1 = (androidx.datastore.core.Closeable) r1
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.FileStorageConnection r0 = (androidx.datastore.core.FileStorageConnection) r0
            W2.u.b(r9)     // Catch:{ all -> 0x0034 }
            goto L_0x006b
        L_0x0034:
            r9 = move-exception
            goto L_0x0084
        L_0x0036:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003e:
            W2.u.b(r9)
            r7.checkNotClosed()
            F3.a r9 = r7.transactionMutex
            boolean r9 = F3.a.C0176a.a(r9, r4, r3, r4)
            androidx.datastore.core.FileReadScope r2 = new androidx.datastore.core.FileReadScope     // Catch:{ all -> 0x008d }
            java.io.File r5 = r7.file     // Catch:{ all -> 0x008d }
            androidx.datastore.core.Serializer<T> r6 = r7.serializer     // Catch:{ all -> 0x008d }
            r2.<init>(r5, r6)     // Catch:{ all -> 0x008d }
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.b.a(r9)     // Catch:{ all -> 0x007e }
            r0.L$0 = r7     // Catch:{ all -> 0x007e }
            r0.L$1 = r2     // Catch:{ all -> 0x007e }
            r0.Z$0 = r9     // Catch:{ all -> 0x007e }
            r0.label = r3     // Catch:{ all -> 0x007e }
            java.lang.Object r8 = r8.invoke(r2, r5, r0)     // Catch:{ all -> 0x007e }
            if (r8 != r1) goto L_0x0066
            return r1
        L_0x0066:
            r0 = r9
            r9 = r8
            r8 = r0
            r0 = r7
            r1 = r2
        L_0x006b:
            r1.close()     // Catch:{ all -> 0x0070 }
            r1 = r4
            goto L_0x0071
        L_0x0070:
            r1 = move-exception
        L_0x0071:
            if (r1 != 0) goto L_0x007b
            if (r8 == 0) goto L_0x007a
            F3.a r8 = r0.transactionMutex
            F3.a.C0176a.b(r8, r4, r3, r4)
        L_0x007a:
            return r9
        L_0x007b:
            throw r1     // Catch:{ all -> 0x007c }
        L_0x007c:
            r9 = move-exception
            goto L_0x0092
        L_0x007e:
            r8 = move-exception
            r0 = r9
            r9 = r8
            r8 = r0
            r0 = r7
            r1 = r2
        L_0x0084:
            r1.close()     // Catch:{ all -> 0x0088 }
            goto L_0x008c
        L_0x0088:
            r1 = move-exception
            W2.C2216e.a(r9, r1)     // Catch:{ all -> 0x007c }
        L_0x008c:
            throw r9     // Catch:{ all -> 0x007c }
        L_0x008d:
            r8 = move-exception
            r0 = r9
            r9 = r8
            r8 = r0
            r0 = r7
        L_0x0092:
            if (r8 == 0) goto L_0x0099
            F3.a r8 = r0.transactionMutex
            F3.a.C0176a.b(r8, r4, r3, r4)
        L_0x0099:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.FileStorageConnection.readScope(k3.q, b3.e):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00bb A[SYNTHETIC, Splitter:B:36:0x00bb] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00fd A[SYNTHETIC, Splitter:B:51:0x00fd] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object writeScope(k3.p r10, b3.C2308e r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof androidx.datastore.core.FileStorageConnection$writeScope$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            androidx.datastore.core.FileStorageConnection$writeScope$1 r0 = (androidx.datastore.core.FileStorageConnection$writeScope$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.FileStorageConnection$writeScope$1 r0 = new androidx.datastore.core.FileStorageConnection$writeScope$1
            r0.<init>(r9, r11)
        L_0x0018:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x005c
            if (r2 == r4) goto L_0x0049
            if (r2 != r3) goto L_0x0041
            java.lang.Object r10 = r0.L$3
            androidx.datastore.core.Closeable r10 = (androidx.datastore.core.Closeable) r10
            java.lang.Object r1 = r0.L$2
            java.io.File r1 = (java.io.File) r1
            java.lang.Object r2 = r0.L$1
            F3.a r2 = (F3.a) r2
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.FileStorageConnection r0 = (androidx.datastore.core.FileStorageConnection) r0
            W2.u.b(r11)     // Catch:{ all -> 0x003e }
            goto L_0x00b1
        L_0x003e:
            r11 = move-exception
            goto L_0x0102
        L_0x0041:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0049:
            java.lang.Object r10 = r0.L$2
            F3.a r10 = (F3.a) r10
            java.lang.Object r2 = r0.L$1
            k3.p r2 = (k3.p) r2
            java.lang.Object r4 = r0.L$0
            androidx.datastore.core.FileStorageConnection r4 = (androidx.datastore.core.FileStorageConnection) r4
            W2.u.b(r11)
            r8 = r2
            r2 = r10
            r10 = r8
            goto L_0x007a
        L_0x005c:
            W2.u.b(r11)
            r9.checkNotClosed()
            java.io.File r11 = r9.file
            r9.createParentDirectories(r11)
            F3.a r11 = r9.transactionMutex
            r0.L$0 = r9
            r0.L$1 = r10
            r0.L$2 = r11
            r0.label = r4
            java.lang.Object r2 = r11.lock(r5, r0)
            if (r2 != r1) goto L_0x0078
            goto L_0x00ad
        L_0x0078:
            r4 = r9
            r2 = r11
        L_0x007a:
            java.io.File r11 = new java.io.File     // Catch:{ all -> 0x00f0 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f0 }
            r6.<init>()     // Catch:{ all -> 0x00f0 }
            java.io.File r7 = r4.file     // Catch:{ all -> 0x00f0 }
            java.lang.String r7 = r7.getAbsolutePath()     // Catch:{ all -> 0x00f0 }
            r6.append(r7)     // Catch:{ all -> 0x00f0 }
            java.lang.String r7 = ".tmp"
            r6.append(r7)     // Catch:{ all -> 0x00f0 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00f0 }
            r11.<init>(r6)     // Catch:{ all -> 0x00f0 }
            androidx.datastore.core.FileWriteScope r6 = new androidx.datastore.core.FileWriteScope     // Catch:{ IOException -> 0x010b }
            androidx.datastore.core.Serializer<T> r7 = r4.serializer     // Catch:{ IOException -> 0x010b }
            r6.<init>(r11, r7)     // Catch:{ IOException -> 0x010b }
            r0.L$0 = r4     // Catch:{ all -> 0x00fe }
            r0.L$1 = r2     // Catch:{ all -> 0x00fe }
            r0.L$2 = r11     // Catch:{ all -> 0x00fe }
            r0.L$3 = r6     // Catch:{ all -> 0x00fe }
            r0.label = r3     // Catch:{ all -> 0x00fe }
            java.lang.Object r10 = r10.invoke(r6, r0)     // Catch:{ all -> 0x00fe }
            if (r10 != r1) goto L_0x00ae
        L_0x00ad:
            return r1
        L_0x00ae:
            r1 = r11
            r0 = r4
            r10 = r6
        L_0x00b1:
            W2.J r11 = W2.J.f19942a     // Catch:{ all -> 0x003e }
            r10.close()     // Catch:{ all -> 0x00b8 }
            r10 = r5
            goto L_0x00b9
        L_0x00b8:
            r10 = move-exception
        L_0x00b9:
            if (r10 != 0) goto L_0x00fd
            boolean r10 = r1.exists()     // Catch:{ IOException -> 0x00f2 }
            if (r10 == 0) goto L_0x00f5
            java.io.File r10 = r0.file     // Catch:{ IOException -> 0x00f2 }
            boolean r10 = androidx.datastore.core.FileMoves_androidKt.atomicMoveTo(r1, r10)     // Catch:{ IOException -> 0x00f2 }
            if (r10 == 0) goto L_0x00ca
            goto L_0x00f5
        L_0x00ca:
            java.io.IOException r10 = new java.io.IOException     // Catch:{ IOException -> 0x00f2 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00f2 }
            r11.<init>()     // Catch:{ IOException -> 0x00f2 }
            java.lang.String r3 = "Unable to rename "
            r11.append(r3)     // Catch:{ IOException -> 0x00f2 }
            r11.append(r1)     // Catch:{ IOException -> 0x00f2 }
            java.lang.String r3 = " to "
            r11.append(r3)     // Catch:{ IOException -> 0x00f2 }
            java.io.File r0 = r0.file     // Catch:{ IOException -> 0x00f2 }
            r11.append(r0)     // Catch:{ IOException -> 0x00f2 }
            java.lang.String r0 = ". This likely means that there are multiple instances of DataStore for this file. Ensure that you are only creating a single instance of datastore for this file."
            r11.append(r0)     // Catch:{ IOException -> 0x00f2 }
            java.lang.String r11 = r11.toString()     // Catch:{ IOException -> 0x00f2 }
            r10.<init>(r11)     // Catch:{ IOException -> 0x00f2 }
            throw r10     // Catch:{ IOException -> 0x00f2 }
        L_0x00f0:
            r10 = move-exception
            goto L_0x0116
        L_0x00f2:
            r10 = move-exception
            r11 = r1
            goto L_0x010c
        L_0x00f5:
            W2.J r10 = W2.J.f19942a     // Catch:{ all -> 0x00f0 }
            r2.unlock(r5)
            W2.J r10 = W2.J.f19942a
            return r10
        L_0x00fd:
            throw r10     // Catch:{ IOException -> 0x00f2 }
        L_0x00fe:
            r10 = move-exception
            r1 = r11
            r11 = r10
            r10 = r6
        L_0x0102:
            r10.close()     // Catch:{ all -> 0x0106 }
            goto L_0x010a
        L_0x0106:
            r10 = move-exception
            W2.C2216e.a(r11, r10)     // Catch:{ IOException -> 0x00f2 }
        L_0x010a:
            throw r11     // Catch:{ IOException -> 0x00f2 }
        L_0x010b:
            r10 = move-exception
        L_0x010c:
            boolean r0 = r11.exists()     // Catch:{ all -> 0x00f0 }
            if (r0 == 0) goto L_0x0115
            r11.delete()     // Catch:{ all -> 0x00f0 }
        L_0x0115:
            throw r10     // Catch:{ all -> 0x00f0 }
        L_0x0116:
            r2.unlock(r5)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.FileStorageConnection.writeScope(k3.p, b3.e):java.lang.Object");
    }
}
