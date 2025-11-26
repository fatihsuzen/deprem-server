package w3;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import k3.l;

/* renamed from: w3.w0  reason: case insensitive filesystem */
final class C2904w0 extends D0 {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f26317f = AtomicIntegerFieldUpdater.newUpdater(C2904w0.class, "_invoked$volatile");
    private volatile /* synthetic */ int _invoked$volatile = 0;

    /* renamed from: e  reason: collision with root package name */
    private final l f26318e;

    public C2904w0(l lVar) {
        this.f26318e = lVar;
    }

    public boolean u() {
        return true;
    }

    public void v(Throwable th) {
        if (f26317f.compareAndSet(this, 0, 1)) {
            this.f26318e.invoke(th);
        }
    }
}
