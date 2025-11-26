package B3;

import androidx.core.internal.view.SupportMenu;
import b3.C2312i;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import w3.M0;

public abstract class A extends C1982b implements M0 {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f17366d = AtomicIntegerFieldUpdater.newUpdater(A.class, "cleanedAndPointers$volatile");

    /* renamed from: c  reason: collision with root package name */
    public final long f17367c;
    private volatile /* synthetic */ int cleanedAndPointers$volatile;

    public A(long j5, A a5, int i5) {
        super(a5);
        this.f17367c = j5;
        this.cleanedAndPointers$volatile = i5 << 16;
    }

    public boolean k() {
        if (f17366d.get(this) != r() || l()) {
            return false;
        }
        return true;
    }

    public final boolean p() {
        if (f17366d.addAndGet(this, SupportMenu.CATEGORY_MASK) != r() || l()) {
            return false;
        }
        return true;
    }

    public abstract int r();

    public abstract void s(int i5, Throwable th, C2312i iVar);

    public final void t() {
        if (f17366d.incrementAndGet(this) == r()) {
            n();
        }
    }

    public final boolean u() {
        int i5;
        AtomicIntegerFieldUpdater q5 = f17366d;
        do {
            i5 = q5.get(this);
            if (i5 == r() && !l()) {
                return false;
            }
        } while (!q5.compareAndSet(this, i5, 65536 + i5));
        return true;
    }
}
