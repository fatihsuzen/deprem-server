package androidx.datastore.core.okio;

import androidx.datastore.core.ReadScope;
import b3.C2308e;
import com.mbridge.msdk.MBridgeConstans;
import e4.C2362k;
import e4.Q;
import kotlin.jvm.internal.t;

public class OkioReadScope<T> implements ReadScope<T> {
    private final AtomicBoolean closed = new AtomicBoolean(false);
    private final C2362k fileSystem;
    private final Q path;
    private final OkioSerializer<T> serializer;

    public OkioReadScope(C2362k kVar, Q q5, OkioSerializer<T> okioSerializer) {
        t.e(kVar, "fileSystem");
        t.e(q5, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        t.e(okioSerializer, "serializer");
        this.fileSystem = kVar;
        this.path = q5;
        this.serializer = okioSerializer;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0072 A[SYNTHETIC, Splitter:B:28:0x0072] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0090 A[Catch:{ FileNotFoundException -> 0x008a }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0094 A[Catch:{ FileNotFoundException -> 0x008a }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00bf A[SYNTHETIC, Splitter:B:56:0x00bf] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ <T> java.lang.Object readData$suspendImpl(androidx.datastore.core.okio.OkioReadScope<T> r7, b3.C2308e r8) {
        /*
            boolean r0 = r8 instanceof androidx.datastore.core.okio.OkioReadScope$readData$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            androidx.datastore.core.okio.OkioReadScope$readData$1 r0 = (androidx.datastore.core.okio.OkioReadScope$readData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.okio.OkioReadScope$readData$1 r0 = new androidx.datastore.core.okio.OkioReadScope$readData$1
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
            goto L_0x00bd
        L_0x0032:
            r8 = move-exception
            goto L_0x00c9
        L_0x0035:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003d:
            java.lang.Object r7 = r0.L$1
            java.io.Closeable r7 = (java.io.Closeable) r7
            java.lang.Object r2 = r0.L$0
            androidx.datastore.core.okio.OkioReadScope r2 = (androidx.datastore.core.okio.OkioReadScope) r2
            W2.u.b(r8)     // Catch:{ all -> 0x0049 }
            goto L_0x0070
        L_0x0049:
            r8 = move-exception
            goto L_0x007f
        L_0x004b:
            W2.u.b(r8)
            r7.checkClose()
            e4.k r8 = r7.fileSystem     // Catch:{ FileNotFoundException -> 0x0095 }
            e4.Q r2 = r7.path     // Catch:{ FileNotFoundException -> 0x0095 }
            e4.Z r8 = r8.l(r2)     // Catch:{ FileNotFoundException -> 0x0095 }
            e4.g r8 = e4.L.d(r8)     // Catch:{ FileNotFoundException -> 0x0095 }
            androidx.datastore.core.okio.OkioSerializer<T> r2 = r7.serializer     // Catch:{ all -> 0x007a }
            r0.L$0 = r7     // Catch:{ all -> 0x007a }
            r0.L$1 = r8     // Catch:{ all -> 0x007a }
            r0.label = r4     // Catch:{ all -> 0x007a }
            java.lang.Object r2 = r2.readFrom(r8, r0)     // Catch:{ all -> 0x007a }
            if (r2 != r1) goto L_0x006c
            goto L_0x00b9
        L_0x006c:
            r6 = r2
            r2 = r7
            r7 = r8
            r8 = r6
        L_0x0070:
            if (r7 == 0) goto L_0x0078
            r7.close()     // Catch:{ all -> 0x0076 }
            goto L_0x0078
        L_0x0076:
            r7 = move-exception
            goto L_0x008e
        L_0x0078:
            r7 = r5
            goto L_0x008e
        L_0x007a:
            r2 = move-exception
            r6 = r2
            r2 = r7
            r7 = r8
            r8 = r6
        L_0x007f:
            if (r7 == 0) goto L_0x008c
            r7.close()     // Catch:{ all -> 0x0085 }
            goto L_0x008c
        L_0x0085:
            r7 = move-exception
            W2.C2216e.a(r8, r7)     // Catch:{ FileNotFoundException -> 0x008a }
            goto L_0x008c
        L_0x008a:
            r7 = r2
            goto L_0x0095
        L_0x008c:
            r7 = r8
            r8 = r5
        L_0x008e:
            if (r7 != 0) goto L_0x0094
            kotlin.jvm.internal.t.b(r8)     // Catch:{ FileNotFoundException -> 0x008a }
            goto L_0x00e4
        L_0x0094:
            throw r7     // Catch:{ FileNotFoundException -> 0x008a }
        L_0x0095:
            e4.k r8 = r7.fileSystem
            e4.Q r2 = r7.path
            boolean r8 = r8.g(r2)
            if (r8 == 0) goto L_0x00dd
            e4.k r8 = r7.fileSystem
            e4.Q r2 = r7.path
            e4.Z r8 = r8.l(r2)
            e4.g r8 = e4.L.d(r8)
            androidx.datastore.core.okio.OkioSerializer<T> r7 = r7.serializer     // Catch:{ all -> 0x00c5 }
            r0.L$0 = r8     // Catch:{ all -> 0x00c5 }
            r0.L$1 = r5     // Catch:{ all -> 0x00c5 }
            r0.label = r3     // Catch:{ all -> 0x00c5 }
            java.lang.Object r7 = r7.readFrom(r8, r0)     // Catch:{ all -> 0x00c5 }
            if (r7 != r1) goto L_0x00ba
        L_0x00b9:
            return r1
        L_0x00ba:
            r6 = r8
            r8 = r7
            r7 = r6
        L_0x00bd:
            if (r7 == 0) goto L_0x00d6
            r7.close()     // Catch:{ all -> 0x00c3 }
            goto L_0x00d6
        L_0x00c3:
            r5 = move-exception
            goto L_0x00d6
        L_0x00c5:
            r7 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        L_0x00c9:
            if (r7 == 0) goto L_0x00d3
            r7.close()     // Catch:{ all -> 0x00cf }
            goto L_0x00d3
        L_0x00cf:
            r7 = move-exception
            W2.C2216e.a(r8, r7)
        L_0x00d3:
            r6 = r5
            r5 = r8
            r8 = r6
        L_0x00d6:
            if (r5 != 0) goto L_0x00dc
            kotlin.jvm.internal.t.b(r8)
            goto L_0x00e4
        L_0x00dc:
            throw r5
        L_0x00dd:
            androidx.datastore.core.okio.OkioSerializer<T> r7 = r7.serializer
            java.lang.Object r7 = r7.getDefaultValue()
            r8 = r7
        L_0x00e4:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.okio.OkioReadScope.readData$suspendImpl(androidx.datastore.core.okio.OkioReadScope, b3.e):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public final void checkClose() {
        if (this.closed.get()) {
            throw new IllegalStateException("This scope has already been closed.");
        }
    }

    public void close() {
        this.closed.set(true);
    }

    /* access modifiers changed from: protected */
    public final C2362k getFileSystem() {
        return this.fileSystem;
    }

    /* access modifiers changed from: protected */
    public final Q getPath() {
        return this.path;
    }

    /* access modifiers changed from: protected */
    public final OkioSerializer<T> getSerializer() {
        return this.serializer;
    }

    public Object readData(C2308e eVar) {
        return readData$suspendImpl(this, eVar);
    }
}
