package androidx.datastore.core.okio;

import androidx.datastore.core.WriteScope;
import com.mbridge.msdk.MBridgeConstans;
import e4.C2362k;
import e4.Q;
import kotlin.jvm.internal.t;

public final class OkioWriteScope<T> extends OkioReadScope<T> implements WriteScope<T> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OkioWriteScope(C2362k kVar, Q q5, OkioSerializer<T> okioSerializer) {
        super(kVar, q5, okioSerializer);
        t.e(kVar, "fileSystem");
        t.e(q5, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        t.e(okioSerializer, "serializer");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: e4.i} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: e4.i} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: e4.i} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v16, resolved type: e4.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v14, resolved type: e4.i} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: e4.i} */
    /* JADX WARNING: type inference failed for: r1v1, types: [e4.i] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0079 A[SYNTHETIC, Splitter:B:26:0x0079] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0097 A[Catch:{ all -> 0x008b, all -> 0x0090 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a4 A[SYNTHETIC, Splitter:B:47:0x00a4] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object writeData(T r9, b3.C2308e r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof androidx.datastore.core.okio.OkioWriteScope$writeData$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            androidx.datastore.core.okio.OkioWriteScope$writeData$1 r0 = (androidx.datastore.core.okio.OkioWriteScope$writeData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.okio.OkioWriteScope$writeData$1 r0 = new androidx.datastore.core.okio.OkioWriteScope$writeData$1
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0040
            if (r2 != r3) goto L_0x0038
            java.lang.Object r9 = r0.L$2
            java.io.Closeable r9 = (java.io.Closeable) r9
            java.lang.Object r1 = r0.L$1
            e4.i r1 = (e4.C2360i) r1
            java.lang.Object r0 = r0.L$0
            java.io.Closeable r0 = (java.io.Closeable) r0
            W2.u.b(r10)     // Catch:{ all -> 0x0036 }
            goto L_0x0072
        L_0x0036:
            r10 = move-exception
            goto L_0x0085
        L_0x0038:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0040:
            W2.u.b(r10)
            r8.checkClose()
            e4.k r10 = r8.getFileSystem()
            e4.Q r2 = r8.getPath()
            e4.i r10 = r10.j(r2)
            r5 = 0
            e4.X r2 = e4.C2360i.y(r10, r5, r3, r4)     // Catch:{ all -> 0x00a5 }
            e4.f r2 = e4.L.c(r2)     // Catch:{ all -> 0x00a5 }
            androidx.datastore.core.okio.OkioSerializer r5 = r8.getSerializer()     // Catch:{ all -> 0x0081 }
            r0.L$0 = r10     // Catch:{ all -> 0x0081 }
            r0.L$1 = r10     // Catch:{ all -> 0x0081 }
            r0.L$2 = r2     // Catch:{ all -> 0x0081 }
            r0.label = r3     // Catch:{ all -> 0x0081 }
            java.lang.Object r9 = r5.writeTo(r9, r2, r0)     // Catch:{ all -> 0x0081 }
            if (r9 != r1) goto L_0x006f
            return r1
        L_0x006f:
            r0 = r10
            r1 = r0
            r9 = r2
        L_0x0072:
            r1.flush()     // Catch:{ all -> 0x0036 }
            W2.J r10 = W2.J.f19942a     // Catch:{ all -> 0x0036 }
            if (r9 == 0) goto L_0x007f
            r9.close()     // Catch:{ all -> 0x007d }
            goto L_0x007f
        L_0x007d:
            r9 = move-exception
            goto L_0x0095
        L_0x007f:
            r9 = r4
            goto L_0x0095
        L_0x0081:
            r9 = move-exception
            r0 = r10
            r10 = r9
            r9 = r2
        L_0x0085:
            if (r9 == 0) goto L_0x0093
            r9.close()     // Catch:{ all -> 0x008b }
            goto L_0x0093
        L_0x008b:
            r9 = move-exception
            W2.C2216e.a(r10, r9)     // Catch:{ all -> 0x0090 }
            goto L_0x0093
        L_0x0090:
            r9 = move-exception
            r10 = r0
            goto L_0x00a6
        L_0x0093:
            r9 = r10
            r10 = r4
        L_0x0095:
            if (r9 != 0) goto L_0x00a4
            kotlin.jvm.internal.t.b(r10)     // Catch:{ all -> 0x0090 }
            W2.J r9 = W2.J.f19942a     // Catch:{ all -> 0x0090 }
            if (r0 == 0) goto L_0x00b3
            r0.close()     // Catch:{ all -> 0x00a2 }
            goto L_0x00b3
        L_0x00a2:
            r4 = move-exception
            goto L_0x00b3
        L_0x00a4:
            throw r9     // Catch:{ all -> 0x0090 }
        L_0x00a5:
            r9 = move-exception
        L_0x00a6:
            if (r10 == 0) goto L_0x00b0
            r10.close()     // Catch:{ all -> 0x00ac }
            goto L_0x00b0
        L_0x00ac:
            r10 = move-exception
            W2.C2216e.a(r9, r10)
        L_0x00b0:
            r7 = r4
            r4 = r9
            r9 = r7
        L_0x00b3:
            if (r4 != 0) goto L_0x00bb
            kotlin.jvm.internal.t.b(r9)
            W2.J r9 = W2.J.f19942a
            return r9
        L_0x00bb:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.okio.OkioWriteScope.writeData(java.lang.Object, b3.e):java.lang.Object");
    }
}
