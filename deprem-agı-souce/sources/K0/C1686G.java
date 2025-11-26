package k0;

import java.util.concurrent.Executor;

/* renamed from: k0.G  reason: case insensitive filesystem */
final class C1686G implements J {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f15466a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Object f15467b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public C1694h f15468c;

    public C1686G(Executor executor, C1694h hVar) {
        this.f15466a = executor;
        this.f15468c = hVar;
    }

    public final void c(C1698l lVar) {
        if (lVar.n()) {
            synchronized (this.f15467b) {
                try {
                    if (this.f15468c != null) {
                        this.f15466a.execute(new C1685F(this, lVar));
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }
    }
}
