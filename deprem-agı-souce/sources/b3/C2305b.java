package b3;

import b3.C2312i;
import k3.l;
import kotlin.jvm.internal.t;

/* renamed from: b3.b  reason: case insensitive filesystem */
public abstract class C2305b implements C2312i.c {

    /* renamed from: a  reason: collision with root package name */
    private final l f20788a;

    /* renamed from: b  reason: collision with root package name */
    private final C2312i.c f20789b;

    public C2305b(C2312i.c cVar, l lVar) {
        t.e(cVar, "baseKey");
        t.e(lVar, "safeCast");
        this.f20788a = lVar;
        this.f20789b = cVar instanceof C2305b ? ((C2305b) cVar).f20789b : cVar;
    }

    public final boolean a(C2312i.c cVar) {
        t.e(cVar, "key");
        if (cVar == this || this.f20789b == cVar) {
            return true;
        }
        return false;
    }

    public final C2312i.b b(C2312i.b bVar) {
        t.e(bVar, "element");
        return (C2312i.b) this.f20788a.invoke(bVar);
    }
}
