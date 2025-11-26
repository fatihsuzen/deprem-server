package k0;

/* renamed from: k0.B  reason: case insensitive filesystem */
final class C1681B implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C1698l f15454a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1682C f15455b;

    C1681B(C1682C c5, C1698l lVar) {
        this.f15455b = c5;
        this.f15454a = lVar;
    }

    public final void run() {
        synchronized (this.f15455b.f15457b) {
            try {
                C1682C c5 = this.f15455b;
                if (c5.f15458c != null) {
                    c5.f15458c.a(this.f15454a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
