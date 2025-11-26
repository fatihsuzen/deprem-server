package k0;

import java.util.concurrent.Executor;

/* renamed from: k0.E  reason: case insensitive filesystem */
final class C1684E implements J {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f15461a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Object f15462b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public C1693g f15463c;

    public C1684E(Executor executor, C1693g gVar) {
        this.f15461a = executor;
        this.f15463c = gVar;
    }

    public final void c(C1698l lVar) {
        if (!lVar.n() && !lVar.l()) {
            synchronized (this.f15462b) {
                try {
                    if (this.f15463c != null) {
                        this.f15461a.execute(new C1683D(this, lVar));
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
