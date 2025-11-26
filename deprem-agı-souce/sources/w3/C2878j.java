package w3;

import java.util.concurrent.Future;

/* renamed from: w3.j  reason: case insensitive filesystem */
final class C2878j implements C2880k {

    /* renamed from: a  reason: collision with root package name */
    private final Future f26289a;

    public C2878j(Future future) {
        this.f26289a = future;
    }

    public void a(Throwable th) {
        this.f26289a.cancel(false);
    }

    public String toString() {
        return "CancelFutureOnCancel[" + this.f26289a + ']';
    }
}
