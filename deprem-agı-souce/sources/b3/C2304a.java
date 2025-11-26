package b3;

import b3.C2312i;
import k3.p;
import kotlin.jvm.internal.t;

/* renamed from: b3.a  reason: case insensitive filesystem */
public abstract class C2304a implements C2312i.b {
    private final C2312i.c key;

    public C2304a(C2312i.c cVar) {
        t.e(cVar, "key");
        this.key = cVar;
    }

    public <R> R fold(R r5, p pVar) {
        return C2312i.b.a.a(this, r5, pVar);
    }

    public C2312i.b get(C2312i.c cVar) {
        return C2312i.b.a.b(this, cVar);
    }

    public C2312i.c getKey() {
        return this.key;
    }

    public C2312i minusKey(C2312i.c cVar) {
        return C2312i.b.a.c(this, cVar);
    }

    public C2312i plus(C2312i iVar) {
        return C2312i.b.a.d(this, iVar);
    }
}
