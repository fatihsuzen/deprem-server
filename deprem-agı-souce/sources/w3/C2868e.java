package w3;

import b3.C2312i;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.t;

/* renamed from: w3.e  reason: case insensitive filesystem */
final class C2868e extends C2860a {

    /* renamed from: d  reason: collision with root package name */
    private final Thread f26278d;

    /* renamed from: e  reason: collision with root package name */
    private final C2877i0 f26279e;

    public C2868e(C2312i iVar, Thread thread, C2877i0 i0Var) {
        super(iVar, true, true);
        this.f26278d = thread;
        this.f26279e = i0Var;
    }

    /* access modifiers changed from: protected */
    public void I(Object obj) {
        if (!t.a(Thread.currentThread(), this.f26278d)) {
            Thread thread = this.f26278d;
            C2864c.a();
            LockSupport.unpark(thread);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: w3.A} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object Q0() {
        /*
            r6 = this;
            w3.C2864c.a()
            w3.i0 r0 = r6.f26279e     // Catch:{ all -> 0x000e }
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L_0x0010
            w3.C2877i0.L(r0, r2, r1, r3)     // Catch:{ all -> 0x000e }
            goto L_0x0010
        L_0x000e:
            r0 = move-exception
            goto L_0x0063
        L_0x0010:
            boolean r0 = java.lang.Thread.interrupted()     // Catch:{ all -> 0x001f }
            if (r0 != 0) goto L_0x0052
            w3.i0 r0 = r6.f26279e     // Catch:{ all -> 0x001f }
            if (r0 == 0) goto L_0x0021
            long r4 = r0.O()     // Catch:{ all -> 0x001f }
            goto L_0x0026
        L_0x001f:
            r0 = move-exception
            goto L_0x005b
        L_0x0021:
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x0026:
            boolean r0 = r6.C()     // Catch:{ all -> 0x001f }
            if (r0 != 0) goto L_0x0033
            w3.C2864c.a()     // Catch:{ all -> 0x001f }
            java.util.concurrent.locks.LockSupport.parkNanos(r6, r4)     // Catch:{ all -> 0x001f }
            goto L_0x0010
        L_0x0033:
            w3.i0 r0 = r6.f26279e     // Catch:{ all -> 0x000e }
            if (r0 == 0) goto L_0x003a
            w3.C2877i0.G(r0, r2, r1, r3)     // Catch:{ all -> 0x000e }
        L_0x003a:
            w3.C2864c.a()
            java.lang.Object r0 = r6.e0()
            java.lang.Object r0 = w3.F0.h(r0)
            boolean r1 = r0 instanceof w3.C2854A
            if (r1 == 0) goto L_0x004c
            r3 = r0
            w3.A r3 = (w3.C2854A) r3
        L_0x004c:
            if (r3 != 0) goto L_0x004f
            return r0
        L_0x004f:
            java.lang.Throwable r0 = r3.f26214a
            throw r0
        L_0x0052:
            java.lang.InterruptedException r0 = new java.lang.InterruptedException     // Catch:{ all -> 0x001f }
            r0.<init>()     // Catch:{ all -> 0x001f }
            r6.L(r0)     // Catch:{ all -> 0x001f }
            throw r0     // Catch:{ all -> 0x001f }
        L_0x005b:
            w3.i0 r4 = r6.f26279e     // Catch:{ all -> 0x000e }
            if (r4 == 0) goto L_0x0062
            w3.C2877i0.G(r4, r2, r1, r3)     // Catch:{ all -> 0x000e }
        L_0x0062:
            throw r0     // Catch:{ all -> 0x000e }
        L_0x0063:
            w3.C2864c.a()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: w3.C2868e.Q0():java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public boolean l0() {
        return true;
    }
}
