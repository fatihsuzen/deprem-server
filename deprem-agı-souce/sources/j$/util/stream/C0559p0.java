package j$.util.stream;

import java.util.function.Predicate;

/* renamed from: j$.util.stream.p0  reason: case insensitive filesystem */
public final class C0559p0 extends C0578t0 {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ C0583u0 f1758c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Predicate f1759d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0559p0(C0583u0 u0Var, Predicate predicate) {
        super(u0Var);
        this.f1758c = u0Var;
        this.f1759d = predicate;
    }

    public final void accept(Object obj) {
        if (!this.f1786a) {
            boolean test = this.f1759d.test(obj);
            C0583u0 u0Var = this.f1758c;
            if (test == u0Var.f1793a) {
                this.f1786a = true;
                this.f1787b = u0Var.f1794b;
            }
        }
    }
}
