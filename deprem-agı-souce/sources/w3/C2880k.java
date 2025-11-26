package w3;

import k3.l;

/* renamed from: w3.k  reason: case insensitive filesystem */
public interface C2880k extends M0 {

    /* renamed from: w3.k$a */
    public static final class a implements C2880k {

        /* renamed from: a  reason: collision with root package name */
        private final l f26299a;

        public a(l lVar) {
            this.f26299a = lVar;
        }

        public void a(Throwable th) {
            this.f26299a.invoke(th);
        }

        public String toString() {
            return "CancelHandler.UserSupplied[" + Q.a(this.f26299a) + '@' + Q.b(this) + ']';
        }
    }

    void a(Throwable th);
}
