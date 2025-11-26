package w3;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.C2633k;

/* renamed from: w3.A  reason: case insensitive filesystem */
public class C2854A {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f26213b = AtomicIntegerFieldUpdater.newUpdater(C2854A.class, "_handled$volatile");
    private volatile /* synthetic */ int _handled$volatile;

    /* renamed from: a  reason: collision with root package name */
    public final Throwable f26214a;

    public C2854A(Throwable th, boolean z4) {
        this.f26214a = th;
        this._handled$volatile = z4 ? 1 : 0;
    }

    public final boolean a() {
        if (f26213b.get(this) != 0) {
            return true;
        }
        return false;
    }

    public final boolean c() {
        return f26213b.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return Q.a(this) + '[' + this.f26214a + ']';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C2854A(Throwable th, boolean z4, int i5, C2633k kVar) {
        this(th, (i5 & 2) != 0 ? false : z4);
    }
}
