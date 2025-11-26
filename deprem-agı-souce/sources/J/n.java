package J;

import java.util.concurrent.CountDownLatch;
import k0.C1692f;
import k0.C1698l;

public final /* synthetic */ class n implements C1692f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f2639a;

    public /* synthetic */ n(CountDownLatch countDownLatch) {
        this.f2639a = countDownLatch;
    }

    public final void a(C1698l lVar) {
        this.f2639a.countDown();
    }
}
