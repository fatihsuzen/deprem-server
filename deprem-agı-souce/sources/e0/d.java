package E0;

import java.util.concurrent.CountDownLatch;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f2400a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f2401b;

    public /* synthetic */ d(e eVar, CountDownLatch countDownLatch) {
        this.f2400a = eVar;
        this.f2401b = countDownLatch;
    }

    public final void run() {
        e.b(this.f2400a, this.f2401b);
    }
}
