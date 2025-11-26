package w3;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: w3.q  reason: case insensitive filesystem */
public final class C2892q extends C2854A {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f26310c = AtomicIntegerFieldUpdater.newUpdater(C2892q.class, "_resumed$volatile");
    private volatile /* synthetic */ int _resumed$volatile;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C2892q(b3.C2308e r3, java.lang.Throwable r4, boolean r5) {
        /*
            r2 = this;
            if (r4 != 0) goto L_0x001d
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Continuation "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r3 = " was cancelled normally"
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r4.<init>(r3)
        L_0x001d:
            r2.<init>(r4, r5)
            r3 = 0
            r2._resumed$volatile = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: w3.C2892q.<init>(b3.e, java.lang.Throwable, boolean):void");
    }

    public final boolean e() {
        return f26310c.compareAndSet(this, 0, 1);
    }
}
