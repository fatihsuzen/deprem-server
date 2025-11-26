package androidx.datastore.core;

import b3.C2308e;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.t;

public class FileReadScope<T> implements ReadScope<T> {
    private final AtomicBoolean closed = new AtomicBoolean(false);
    private final File file;
    private final Serializer<T> serializer;

    public FileReadScope(File file2, Serializer<T> serializer2) {
        t.e(file2, "file");
        t.e(serializer2, "serializer");
        this.file = file2;
        this.serializer = serializer2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006f, code lost:
        r7 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0077, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        h3.C2453b.a(r7, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x007b, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0084, code lost:
        r8 = new java.io.FileInputStream(r7.file);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        r7 = r7.serializer;
        r0.L$0 = r8;
        r0.L$1 = null;
        r0.label = 2;
        r7 = r7.readFrom(r8, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0097, code lost:
        if (r7 != r1) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x009a, code lost:
        r6 = r8;
        r8 = r7;
        r7 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00a1, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00a2, code lost:
        r6 = r8;
        r8 = r7;
        r7 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        throw r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00a6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00a7, code lost:
        h3.C2453b.a(r7, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00aa, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00b1, code lost:
        return r7.serializer.getDefaultValue();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:27:0x006b, B:34:0x0076] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ <T> java.lang.Object readData$suspendImpl(androidx.datastore.core.FileReadScope<T> r7, b3.C2308e r8) {
        /*
            boolean r0 = r8 instanceof androidx.datastore.core.FileReadScope$readData$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            androidx.datastore.core.FileReadScope$readData$1 r0 = (androidx.datastore.core.FileReadScope$readData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.FileReadScope$readData$1 r0 = new androidx.datastore.core.FileReadScope$readData$1
            r0.<init>(r7, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x004b
            if (r2 == r4) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            java.lang.Object r7 = r0.L$0
            java.io.Closeable r7 = (java.io.Closeable) r7
            W2.u.b(r8)     // Catch:{ all -> 0x0032 }
            goto L_0x009d
        L_0x0032:
            r8 = move-exception
            goto L_0x00a5
        L_0x0035:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003d:
            java.lang.Object r7 = r0.L$1
            java.io.Closeable r7 = (java.io.Closeable) r7
            java.lang.Object r2 = r0.L$0
            androidx.datastore.core.FileReadScope r2 = (androidx.datastore.core.FileReadScope) r2
            W2.u.b(r8)     // Catch:{ all -> 0x0049 }
            goto L_0x006b
        L_0x0049:
            r8 = move-exception
            goto L_0x0076
        L_0x004b:
            W2.u.b(r8)
            r7.checkNotClosed()
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x007c }
            java.io.File r2 = r7.file     // Catch:{ FileNotFoundException -> 0x007c }
            r8.<init>(r2)     // Catch:{ FileNotFoundException -> 0x007c }
            androidx.datastore.core.Serializer<T> r2 = r7.serializer     // Catch:{ all -> 0x0071 }
            r0.L$0 = r7     // Catch:{ all -> 0x0071 }
            r0.L$1 = r8     // Catch:{ all -> 0x0071 }
            r0.label = r4     // Catch:{ all -> 0x0071 }
            java.lang.Object r2 = r2.readFrom(r8, r0)     // Catch:{ all -> 0x0071 }
            if (r2 != r1) goto L_0x0067
            goto L_0x0099
        L_0x0067:
            r6 = r2
            r2 = r7
            r7 = r8
            r8 = r6
        L_0x006b:
            h3.C2453b.a(r7, r5)     // Catch:{ FileNotFoundException -> 0x006f }
            return r8
        L_0x006f:
            r7 = r2
            goto L_0x007c
        L_0x0071:
            r2 = move-exception
            r6 = r2
            r2 = r7
            r7 = r8
            r8 = r6
        L_0x0076:
            throw r8     // Catch:{ all -> 0x0077 }
        L_0x0077:
            r4 = move-exception
            h3.C2453b.a(r7, r8)     // Catch:{ FileNotFoundException -> 0x006f }
            throw r4     // Catch:{ FileNotFoundException -> 0x006f }
        L_0x007c:
            java.io.File r8 = r7.file
            boolean r8 = r8.exists()
            if (r8 == 0) goto L_0x00ab
            java.io.FileInputStream r8 = new java.io.FileInputStream
            java.io.File r2 = r7.file
            r8.<init>(r2)
            androidx.datastore.core.Serializer<T> r7 = r7.serializer     // Catch:{ all -> 0x00a1 }
            r0.L$0 = r8     // Catch:{ all -> 0x00a1 }
            r0.L$1 = r5     // Catch:{ all -> 0x00a1 }
            r0.label = r3     // Catch:{ all -> 0x00a1 }
            java.lang.Object r7 = r7.readFrom(r8, r0)     // Catch:{ all -> 0x00a1 }
            if (r7 != r1) goto L_0x009a
        L_0x0099:
            return r1
        L_0x009a:
            r6 = r8
            r8 = r7
            r7 = r6
        L_0x009d:
            h3.C2453b.a(r7, r5)
            return r8
        L_0x00a1:
            r7 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        L_0x00a5:
            throw r8     // Catch:{ all -> 0x00a6 }
        L_0x00a6:
            r0 = move-exception
            h3.C2453b.a(r7, r8)
            throw r0
        L_0x00ab:
            androidx.datastore.core.Serializer<T> r7 = r7.serializer
            java.lang.Object r7 = r7.getDefaultValue()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.FileReadScope.readData$suspendImpl(androidx.datastore.core.FileReadScope, b3.e):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public final void checkNotClosed() {
        if (this.closed.get()) {
            throw new IllegalStateException("This scope has already been closed.");
        }
    }

    public void close() {
        this.closed.set(true);
    }

    /* access modifiers changed from: protected */
    public final File getFile() {
        return this.file;
    }

    /* access modifiers changed from: protected */
    public final Serializer<T> getSerializer() {
        return this.serializer;
    }

    public Object readData(C2308e eVar) {
        return readData$suspendImpl(this, eVar);
    }
}
