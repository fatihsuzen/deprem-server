package N3;

import J3.f;
import M3.C2128b;
import M3.h;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

final class D extends C2133c {

    /* renamed from: g  reason: collision with root package name */
    private final h f18714g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public D(C2128b bVar, h hVar, String str) {
        super(bVar, hVar, str, (C2633k) null);
        t.e(bVar, "json");
        t.e(hVar, "value");
        this.f18714g = hVar;
        w("primitive");
    }

    /* access modifiers changed from: protected */
    public h F(String str) {
        t.e(str, "tag");
        if (str == "primitive") {
            return T();
        }
        throw new IllegalArgumentException("This input can only handle primitives with 'primitive' tag");
    }

    public h T() {
        return this.f18714g;
    }

    public int decodeElementIndex(f fVar) {
        t.e(fVar, "descriptor");
        return 0;
    }
}
