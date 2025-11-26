package b1;

import T2.a;
import d1.C1625b;

public final class J implements C1625b {

    /* renamed from: a  reason: collision with root package name */
    private final a f4538a;

    public J(a aVar) {
        this.f4538a = aVar;
    }

    public static J a(a aVar) {
        return new J(aVar);
    }

    public static I c(Q q5) {
        return new I(q5);
    }

    /* renamed from: b */
    public I get() {
        return c((Q) this.f4538a.get());
    }
}
