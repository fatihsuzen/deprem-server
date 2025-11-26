package B3;

import b3.C2312i;
import b3.C2313j;
import k3.p;
import kotlin.jvm.internal.t;
import w3.U0;

public final class L implements U0 {

    /* renamed from: a  reason: collision with root package name */
    private final Object f17377a;

    /* renamed from: b  reason: collision with root package name */
    private final ThreadLocal f17378b;

    /* renamed from: c  reason: collision with root package name */
    private final C2312i.c f17379c;

    public L(Object obj, ThreadLocal threadLocal) {
        this.f17377a = obj;
        this.f17378b = threadLocal;
        this.f17379c = new M(threadLocal);
    }

    public Object fold(Object obj, p pVar) {
        return U0.a.a(this, obj, pVar);
    }

    public C2312i.b get(C2312i.c cVar) {
        if (!t.a(getKey(), cVar)) {
            return null;
        }
        t.c(this, "null cannot be cast to non-null type E of kotlinx.coroutines.internal.ThreadLocalElement.get");
        return this;
    }

    public C2312i.c getKey() {
        return this.f17379c;
    }

    public C2312i minusKey(C2312i.c cVar) {
        if (t.a(getKey(), cVar)) {
            return C2313j.f20794a;
        }
        return this;
    }

    public C2312i plus(C2312i iVar) {
        return U0.a.b(this, iVar);
    }

    public String toString() {
        return "ThreadLocal(value=" + this.f17377a + ", threadLocal = " + this.f17378b + ')';
    }

    public void u(C2312i iVar, Object obj) {
        this.f17378b.set(obj);
    }

    public Object x(C2312i iVar) {
        Object obj = this.f17378b.get();
        this.f17378b.set(this.f17377a);
        return obj;
    }
}
