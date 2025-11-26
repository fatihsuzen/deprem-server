package w3;

import java.util.concurrent.locks.LockSupport;
import w3.C2879j0;

/* renamed from: w3.k0  reason: case insensitive filesystem */
public abstract class C2881k0 extends C2877i0 {
    /* access modifiers changed from: protected */
    public abstract Thread R();

    /* access modifiers changed from: protected */
    public void S(long j5, C2879j0.c cVar) {
        S.f26256g.g0(j5, cVar);
    }

    /* access modifiers changed from: protected */
    public final void T() {
        Thread R4 = R();
        if (Thread.currentThread() != R4) {
            C2864c.a();
            LockSupport.unpark(R4);
        }
    }
}
