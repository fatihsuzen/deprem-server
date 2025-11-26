package k0;

import java.util.concurrent.Executor;

final class w implements J {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f15504a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final C1689c f15505b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final O f15506c;

    public w(Executor executor, C1689c cVar, O o5) {
        this.f15504a = executor;
        this.f15505b = cVar;
        this.f15506c = o5;
    }

    public final void c(C1698l lVar) {
        this.f15504a.execute(new v(this, lVar));
    }
}
