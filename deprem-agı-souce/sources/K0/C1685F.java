package k0;

/* renamed from: k0.F  reason: case insensitive filesystem */
final class C1685F implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C1698l f15464a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1686G f15465b;

    C1685F(C1686G g5, C1698l lVar) {
        this.f15465b = g5;
        this.f15464a = lVar;
    }

    public final void run() {
        synchronized (this.f15465b.f15467b) {
            try {
                C1686G g5 = this.f15465b;
                if (g5.f15468c != null) {
                    g5.f15468c.a(this.f15464a.j());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
