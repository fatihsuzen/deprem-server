package w3;

import java.util.concurrent.Future;

/* renamed from: w3.d0  reason: case insensitive filesystem */
final class C2867d0 implements C2869e0 {

    /* renamed from: a  reason: collision with root package name */
    private final Future f26277a;

    public C2867d0(Future future) {
        this.f26277a = future;
    }

    public void dispose() {
        this.f26277a.cancel(false);
    }

    public String toString() {
        return "DisposableFutureHandle[" + this.f26277a + ']';
    }
}
