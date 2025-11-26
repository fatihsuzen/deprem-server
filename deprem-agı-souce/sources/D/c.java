package D;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class c extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference f2351a;

    /* renamed from: b  reason: collision with root package name */
    private final long f2352b;

    /* renamed from: c  reason: collision with root package name */
    final CountDownLatch f2353c = new CountDownLatch(1);

    /* renamed from: d  reason: collision with root package name */
    boolean f2354d = false;

    public c(C0635a aVar, long j5) {
        this.f2351a = new WeakReference(aVar);
        this.f2352b = j5;
        start();
    }

    private final void a() {
        C0635a aVar = (C0635a) this.f2351a.get();
        if (aVar != null) {
            aVar.c();
            this.f2354d = true;
        }
    }

    public final void run() {
        try {
            if (!this.f2353c.await(this.f2352b, TimeUnit.MILLISECONDS)) {
                a();
            }
        } catch (InterruptedException unused) {
            a();
        }
    }
}
