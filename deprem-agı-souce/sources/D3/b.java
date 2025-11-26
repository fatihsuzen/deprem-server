package D3;

import B3.E;
import b3.C2312i;
import b3.C2313j;
import java.util.concurrent.Executor;
import q3.C2729e;
import w3.C2891p0;
import w3.I;

public final class b extends C2891p0 implements Executor {

    /* renamed from: b  reason: collision with root package name */
    public static final b f18073b = new b();

    /* renamed from: c  reason: collision with root package name */
    private static final I f18074c = I.limitedParallelism$default(k.f18091a, G.e("kotlinx.coroutines.io.parallelism", C2729e.c(64, E.a()), 0, 0, 12, (Object) null), (String) null, 2, (Object) null);

    private b() {
    }

    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    public void dispatch(C2312i iVar, Runnable runnable) {
        f18074c.dispatch(iVar, runnable);
    }

    public void dispatchYield(C2312i iVar, Runnable runnable) {
        f18074c.dispatchYield(iVar, runnable);
    }

    public void execute(Runnable runnable) {
        dispatch(C2313j.f20794a, runnable);
    }

    public I limitedParallelism(int i5, String str) {
        return k.f18091a.limitedParallelism(i5, str);
    }

    public String toString() {
        return "Dispatchers.IO";
    }

    public Executor F() {
        return this;
    }
}
