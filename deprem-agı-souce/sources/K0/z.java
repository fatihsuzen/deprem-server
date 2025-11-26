package k0;

final class z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C1680A f15512a;

    z(C1680A a5) {
        this.f15512a = a5;
    }

    public final void run() {
        synchronized (this.f15512a.f15452b) {
            try {
                C1680A a5 = this.f15512a;
                if (a5.f15453c != null) {
                    a5.f15453c.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
