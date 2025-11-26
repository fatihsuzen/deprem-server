package w3;

import B3.C1989i;
import B3.z;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public final class Y extends z {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f26265e = AtomicIntegerFieldUpdater.newUpdater(Y.class, "_decision$volatile");
    private volatile /* synthetic */ int _decision$volatile;

    public Y(C2312i iVar, C2308e eVar) {
        super(iVar, eVar);
    }

    private final boolean S0() {
        AtomicIntegerFieldUpdater R02 = f26265e;
        do {
            int i5 = R02.get(this);
            if (i5 != 0) {
                if (i5 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed");
            }
        } while (!f26265e.compareAndSet(this, 0, 2));
        return true;
    }

    private final boolean T0() {
        AtomicIntegerFieldUpdater R02 = f26265e;
        do {
            int i5 = R02.get(this);
            if (i5 != 0) {
                if (i5 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended");
            }
        } while (!f26265e.compareAndSet(this, 0, 1));
        return true;
    }

    /* access modifiers changed from: protected */
    public void I(Object obj) {
        M0(obj);
    }

    /* access modifiers changed from: protected */
    public void M0(Object obj) {
        if (!S0()) {
            C1989i.b(C2316b.c(this.f17429d), C2856C.a(obj, this.f17429d));
        }
    }

    public final Object Q0() {
        if (T0()) {
            return C2316b.f();
        }
        Object h5 = F0.h(e0());
        if (!(h5 instanceof C2854A)) {
            return h5;
        }
        throw ((C2854A) h5).f26214a;
    }
}
