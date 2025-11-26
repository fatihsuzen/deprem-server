package androidx.datastore.core.okio;

import F3.a;
import F3.g;
import androidx.datastore.core.InterProcessCoordinator;
import androidx.datastore.core.StorageConnection;
import com.mbridge.msdk.MBridgeConstans;
import e4.C2362k;
import e4.Q;
import k3.C2616a;
import kotlin.jvm.internal.t;

public final class OkioStorageConnection<T> implements StorageConnection<T> {
    private final AtomicBoolean closed = new AtomicBoolean(false);
    private final InterProcessCoordinator coordinator;
    private final C2362k fileSystem;
    private final C2616a onClose;
    private final Q path;
    private final OkioSerializer<T> serializer;
    private final a transactionMutex = g.b(false, 1, (Object) null);

    public OkioStorageConnection(C2362k kVar, Q q5, OkioSerializer<T> okioSerializer, InterProcessCoordinator interProcessCoordinator, C2616a aVar) {
        t.e(kVar, "fileSystem");
        t.e(q5, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        t.e(okioSerializer, "serializer");
        t.e(interProcessCoordinator, "coordinator");
        t.e(aVar, "onClose");
        this.fileSystem = kVar;
        this.path = q5;
        this.serializer = okioSerializer;
        this.coordinator = interProcessCoordinator;
        this.onClose = aVar;
    }

    private final void checkNotClosed() {
        if (this.closed.get()) {
            throw new IllegalStateException("StorageConnection has already been disposed.");
        }
    }

    public void close() {
        this.closed.set(true);
        this.onClose.invoke();
    }

    public InterProcessCoordinator getCoordinator() {
        return this.coordinator;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x007e, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x008a, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        W2.C2216e.a(r10, r1);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:31:0x007d, B:36:0x0086] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007d A[SYNTHETIC, Splitter:B:31:0x007d] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <R> java.lang.Object readScope(k3.q r9, b3.C2308e r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof androidx.datastore.core.okio.OkioStorageConnection$readScope$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            androidx.datastore.core.okio.OkioStorageConnection$readScope$1 r0 = (androidx.datastore.core.okio.OkioStorageConnection$readScope$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.okio.OkioStorageConnection$readScope$1 r0 = new androidx.datastore.core.okio.OkioStorageConnection$readScope$1
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            boolean r9 = r0.Z$0
            java.lang.Object r1 = r0.L$1
            androidx.datastore.core.Closeable r1 = (androidx.datastore.core.Closeable) r1
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.okio.OkioStorageConnection r0 = (androidx.datastore.core.okio.OkioStorageConnection) r0
            W2.u.b(r10)     // Catch:{ all -> 0x0034 }
            goto L_0x006d
        L_0x0034:
            r10 = move-exception
            goto L_0x0086
        L_0x0036:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003e:
            W2.u.b(r10)
            r8.checkNotClosed()
            F3.a r10 = r8.transactionMutex
            boolean r10 = F3.a.C0176a.a(r10, r4, r3, r4)
            androidx.datastore.core.okio.OkioReadScope r2 = new androidx.datastore.core.okio.OkioReadScope     // Catch:{ all -> 0x008f }
            e4.k r5 = r8.fileSystem     // Catch:{ all -> 0x008f }
            e4.Q r6 = r8.path     // Catch:{ all -> 0x008f }
            androidx.datastore.core.okio.OkioSerializer<T> r7 = r8.serializer     // Catch:{ all -> 0x008f }
            r2.<init>(r5, r6, r7)     // Catch:{ all -> 0x008f }
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.b.a(r10)     // Catch:{ all -> 0x0080 }
            r0.L$0 = r8     // Catch:{ all -> 0x0080 }
            r0.L$1 = r2     // Catch:{ all -> 0x0080 }
            r0.Z$0 = r10     // Catch:{ all -> 0x0080 }
            r0.label = r3     // Catch:{ all -> 0x0080 }
            java.lang.Object r9 = r9.invoke(r2, r5, r0)     // Catch:{ all -> 0x0080 }
            if (r9 != r1) goto L_0x0068
            return r1
        L_0x0068:
            r0 = r10
            r10 = r9
            r9 = r0
            r0 = r8
            r1 = r2
        L_0x006d:
            r1.close()     // Catch:{ all -> 0x0072 }
            r1 = r4
            goto L_0x0073
        L_0x0072:
            r1 = move-exception
        L_0x0073:
            if (r1 != 0) goto L_0x007d
            if (r9 == 0) goto L_0x007c
            F3.a r9 = r0.transactionMutex
            F3.a.C0176a.b(r9, r4, r3, r4)
        L_0x007c:
            return r10
        L_0x007d:
            throw r1     // Catch:{ all -> 0x007e }
        L_0x007e:
            r10 = move-exception
            goto L_0x0094
        L_0x0080:
            r9 = move-exception
            r0 = r10
            r10 = r9
            r9 = r0
            r0 = r8
            r1 = r2
        L_0x0086:
            r1.close()     // Catch:{ all -> 0x008a }
            goto L_0x008e
        L_0x008a:
            r1 = move-exception
            W2.C2216e.a(r10, r1)     // Catch:{ all -> 0x007e }
        L_0x008e:
            throw r10     // Catch:{ all -> 0x007e }
        L_0x008f:
            r9 = move-exception
            r0 = r10
            r10 = r9
            r9 = r0
            r0 = r8
        L_0x0094:
            if (r9 == 0) goto L_0x009b
            F3.a r9 = r0.transactionMutex
            F3.a.C0176a.b(r9, r4, r3, r4)
        L_0x009b:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.okio.OkioStorageConnection.readScope(k3.q, b3.e):java.lang.Object");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x010f */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00cf A[SYNTHETIC, Splitter:B:38:0x00cf] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ef A[SYNTHETIC, Splitter:B:50:0x00ef] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object writeScope(k3.p r10, b3.C2308e r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof androidx.datastore.core.okio.OkioStorageConnection$writeScope$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            androidx.datastore.core.okio.OkioStorageConnection$writeScope$1 r0 = (androidx.datastore.core.okio.OkioStorageConnection$writeScope$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.okio.OkioStorageConnection$writeScope$1 r0 = new androidx.datastore.core.okio.OkioStorageConnection$writeScope$1
            r0.<init>(r9, r11)
        L_0x0018:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0060
            if (r2 == r5) goto L_0x004a
            if (r2 != r4) goto L_0x0042
            java.lang.Object r10 = r0.L$3
            androidx.datastore.core.Closeable r10 = (androidx.datastore.core.Closeable) r10
            java.lang.Object r1 = r0.L$2
            e4.Q r1 = (e4.Q) r1
            java.lang.Object r2 = r0.L$1
            F3.a r2 = (F3.a) r2
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.okio.OkioStorageConnection r0 = (androidx.datastore.core.okio.OkioStorageConnection) r0
            W2.u.b(r11)     // Catch:{ all -> 0x003f }
            goto L_0x00c5
        L_0x003f:
            r11 = move-exception
            goto L_0x00f6
        L_0x0042:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x004a:
            java.lang.Object r10 = r0.L$3
            F3.a r10 = (F3.a) r10
            java.lang.Object r2 = r0.L$2
            e4.Q r2 = (e4.Q) r2
            java.lang.Object r5 = r0.L$1
            k3.p r5 = (k3.p) r5
            java.lang.Object r7 = r0.L$0
            androidx.datastore.core.okio.OkioStorageConnection r7 = (androidx.datastore.core.okio.OkioStorageConnection) r7
            W2.u.b(r11)
            r11 = r10
            r10 = r5
            goto L_0x0087
        L_0x0060:
            W2.u.b(r11)
            r9.checkNotClosed()
            e4.Q r11 = r9.path
            e4.Q r2 = r11.h()
            if (r2 == 0) goto L_0x0114
            e4.k r11 = r9.fileSystem
            r11.b(r2, r3)
            F3.a r11 = r9.transactionMutex
            r0.L$0 = r9
            r0.L$1 = r10
            r0.L$2 = r2
            r0.L$3 = r11
            r0.label = r5
            java.lang.Object r5 = r11.lock(r6, r0)
            if (r5 != r1) goto L_0x0086
            goto L_0x00c0
        L_0x0086:
            r7 = r9
        L_0x0087:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ff }
            r5.<init>()     // Catch:{ all -> 0x00ff }
            e4.Q r8 = r7.path     // Catch:{ all -> 0x00ff }
            java.lang.String r8 = r8.e()     // Catch:{ all -> 0x00ff }
            r5.append(r8)     // Catch:{ all -> 0x00ff }
            java.lang.String r8 = ".tmp"
            r5.append(r8)     // Catch:{ all -> 0x00ff }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00ff }
            e4.Q r2 = r2.k(r5)     // Catch:{ all -> 0x00ff }
            e4.k r5 = r7.fileSystem     // Catch:{ IOException -> 0x0101 }
            r5.f(r2, r3)     // Catch:{ IOException -> 0x0101 }
            androidx.datastore.core.okio.OkioWriteScope r3 = new androidx.datastore.core.okio.OkioWriteScope     // Catch:{ IOException -> 0x0101 }
            e4.k r5 = r7.fileSystem     // Catch:{ IOException -> 0x0101 }
            androidx.datastore.core.okio.OkioSerializer<T> r8 = r7.serializer     // Catch:{ IOException -> 0x0101 }
            r3.<init>(r5, r2, r8)     // Catch:{ IOException -> 0x0101 }
            r0.L$0 = r7     // Catch:{ all -> 0x00f0 }
            r0.L$1 = r11     // Catch:{ all -> 0x00f0 }
            r0.L$2 = r2     // Catch:{ all -> 0x00f0 }
            r0.L$3 = r3     // Catch:{ all -> 0x00f0 }
            r0.label = r4     // Catch:{ all -> 0x00f0 }
            java.lang.Object r10 = r10.invoke(r3, r0)     // Catch:{ all -> 0x00f0 }
            if (r10 != r1) goto L_0x00c1
        L_0x00c0:
            return r1
        L_0x00c1:
            r1 = r2
            r10 = r3
            r0 = r7
            r2 = r11
        L_0x00c5:
            W2.J r11 = W2.J.f19942a     // Catch:{ all -> 0x003f }
            r10.close()     // Catch:{ all -> 0x00cc }
            r10 = r6
            goto L_0x00cd
        L_0x00cc:
            r10 = move-exception
        L_0x00cd:
            if (r10 != 0) goto L_0x00ef
            e4.k r10 = r0.fileSystem     // Catch:{ IOException -> 0x00e2 }
            boolean r10 = r10.g(r1)     // Catch:{ IOException -> 0x00e2 }
            if (r10 == 0) goto L_0x00e7
            e4.k r10 = r0.fileSystem     // Catch:{ IOException -> 0x00e2 }
            e4.Q r11 = r0.path     // Catch:{ IOException -> 0x00e2 }
            r10.a(r1, r11)     // Catch:{ IOException -> 0x00e2 }
            goto L_0x00e7
        L_0x00df:
            r10 = move-exception
            r11 = r2
            goto L_0x0110
        L_0x00e2:
            r10 = move-exception
            r7 = r0
            r11 = r2
            r2 = r1
            goto L_0x0102
        L_0x00e7:
            W2.J r10 = W2.J.f19942a     // Catch:{ all -> 0x00df }
            r2.unlock(r6)
            W2.J r10 = W2.J.f19942a
            return r10
        L_0x00ef:
            throw r10     // Catch:{ IOException -> 0x00e2 }
        L_0x00f0:
            r10 = move-exception
            r1 = r2
            r0 = r7
            r2 = r11
            r11 = r10
            r10 = r3
        L_0x00f6:
            r10.close()     // Catch:{ all -> 0x00fa }
            goto L_0x00fe
        L_0x00fa:
            r10 = move-exception
            W2.C2216e.a(r11, r10)     // Catch:{ IOException -> 0x00e2 }
        L_0x00fe:
            throw r11     // Catch:{ IOException -> 0x00e2 }
        L_0x00ff:
            r10 = move-exception
            goto L_0x0110
        L_0x0101:
            r10 = move-exception
        L_0x0102:
            e4.k r0 = r7.fileSystem     // Catch:{ all -> 0x00ff }
            boolean r0 = r0.g(r2)     // Catch:{ all -> 0x00ff }
            if (r0 == 0) goto L_0x010f
            e4.k r0 = r7.fileSystem     // Catch:{ IOException -> 0x010f }
            r0.e(r2)     // Catch:{ IOException -> 0x010f }
        L_0x010f:
            throw r10     // Catch:{ all -> 0x00ff }
        L_0x0110:
            r11.unlock(r6)
            throw r10
        L_0x0114:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "must have a parent path"
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.okio.OkioStorageConnection.writeScope(k3.p, b3.e):java.lang.Object");
    }
}
