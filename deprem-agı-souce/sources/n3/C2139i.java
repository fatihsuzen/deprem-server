package N3;

import kotlin.jvm.internal.t;

/* renamed from: N3.i  reason: case insensitive filesystem */
public final class C2139i extends C2138h {

    /* renamed from: c  reason: collision with root package name */
    private final boolean f18792c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2139i(C2149t tVar, boolean z4) {
        super(tVar);
        t.e(tVar, "writer");
        this.f18792c = z4;
    }

    public void n(String str) {
        t.e(str, "value");
        if (this.f18792c) {
            super.n(str);
        } else {
            super.k(str);
        }
    }
}
