package D3;

import b3.C2312i;
import java.util.concurrent.Executor;
import w3.C2891p0;

public abstract class f extends C2891p0 {

    /* renamed from: b  reason: collision with root package name */
    private final int f18077b;

    /* renamed from: c  reason: collision with root package name */
    private final int f18078c;

    /* renamed from: d  reason: collision with root package name */
    private final long f18079d;

    /* renamed from: e  reason: collision with root package name */
    private final String f18080e;

    /* renamed from: f  reason: collision with root package name */
    private a f18081f = G();

    public f(int i5, int i6, long j5, String str) {
        this.f18077b = i5;
        this.f18078c = i6;
        this.f18079d = j5;
        this.f18080e = str;
    }

    private final a G() {
        return new a(this.f18077b, this.f18078c, this.f18079d, this.f18080e);
    }

    public Executor F() {
        return this.f18081f;
    }

    public final void H(Runnable runnable, boolean z4, boolean z5) {
        this.f18081f.o(runnable, z4, z5);
    }

    public void dispatch(C2312i iVar, Runnable runnable) {
        a.p(this.f18081f, runnable, false, false, 6, (Object) null);
    }

    public void dispatchYield(C2312i iVar, Runnable runnable) {
        a.p(this.f18081f, runnable, false, true, 2, (Object) null);
    }
}
