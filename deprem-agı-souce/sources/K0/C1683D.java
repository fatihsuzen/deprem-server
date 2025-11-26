package k0;

import N.C0722p;

/* renamed from: k0.D  reason: case insensitive filesystem */
final class C1683D implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C1698l f15459a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1684E f15460b;

    C1683D(C1684E e5, C1698l lVar) {
        this.f15460b = e5;
        this.f15459a = lVar;
    }

    public final void run() {
        synchronized (this.f15460b.f15462b) {
            try {
                C1684E e5 = this.f15460b;
                if (e5.f15463c != null) {
                    e5.f15463c.d((Exception) C0722p.k(this.f15459a.i()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
