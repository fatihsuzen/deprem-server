package k0;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class r implements s {

    /* renamed from: a  reason: collision with root package name */
    private final CountDownLatch f15492a = new CountDownLatch(1);

    /* synthetic */ r(q qVar) {
    }

    public final void a(Object obj) {
        this.f15492a.countDown();
    }

    public final void b() {
        this.f15492a.countDown();
    }

    public final void c() {
        this.f15492a.await();
    }

    public final void d(Exception exc) {
        this.f15492a.countDown();
    }

    public final boolean e(long j5, TimeUnit timeUnit) {
        return this.f15492a.await(j5, timeUnit);
    }
}
