package x0;

import java.util.concurrent.CountDownLatch;
import k0.C1689c;
import k0.C1698l;

public final /* synthetic */ class b0 implements C1689c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f16849a;

    public /* synthetic */ b0(CountDownLatch countDownLatch) {
        this.f16849a = countDownLatch;
    }

    public final Object a(C1698l lVar) {
        return this.f16849a.countDown();
    }
}
