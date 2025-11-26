package n0;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import l0.d;
import l0.h;

/* renamed from: n0.b  reason: case insensitive filesystem */
public abstract class C1720b extends C1721c {

    /* renamed from: n0.b$a */
    private static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final Future f15611a;

        /* renamed from: b  reason: collision with root package name */
        final C1719a f15612b;

        a(Future future, C1719a aVar) {
            this.f15611a = future;
            this.f15612b = aVar;
        }

        public void run() {
            try {
                this.f15612b.a(C1720b.b(this.f15611a));
            } catch (ExecutionException e5) {
                this.f15612b.b(e5.getCause());
            } catch (Error | RuntimeException e6) {
                this.f15612b.b(e6);
            }
        }

        public String toString() {
            return d.a(this).c(this.f15612b).toString();
        }
    }

    public static void a(C1722d dVar, C1719a aVar, Executor executor) {
        h.h(aVar);
        dVar.addListener(new a(dVar, aVar), executor);
    }

    public static Object b(Future future) {
        h.o(future.isDone(), "Future was expected to be done: %s", future);
        return C1723e.a(future);
    }
}
