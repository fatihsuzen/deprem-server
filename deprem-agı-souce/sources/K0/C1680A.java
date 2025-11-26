package k0;

import java.util.concurrent.Executor;

/* renamed from: k0.A  reason: case insensitive filesystem */
final class C1680A implements J {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f15451a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Object f15452b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public C1691e f15453c;

    public C1680A(Executor executor, C1691e eVar) {
        this.f15451a = executor;
        this.f15453c = eVar;
    }

    public final void c(C1698l lVar) {
        if (lVar.l()) {
            synchronized (this.f15452b) {
                try {
                    if (this.f15453c != null) {
                        this.f15451a.execute(new z(this));
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }
    }
}
