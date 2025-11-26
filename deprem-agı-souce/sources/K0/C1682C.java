package k0;

import java.util.concurrent.Executor;

/* renamed from: k0.C  reason: case insensitive filesystem */
final class C1682C implements J {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f15456a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Object f15457b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public C1692f f15458c;

    public C1682C(Executor executor, C1692f fVar) {
        this.f15456a = executor;
        this.f15458c = fVar;
    }

    public final void c(C1698l lVar) {
        synchronized (this.f15457b) {
            try {
                if (this.f15458c != null) {
                    this.f15456a.execute(new C1681B(this, lVar));
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }
}
