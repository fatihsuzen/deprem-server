package L3;

import H3.b;
import W2.t;
import W2.u;
import X2.C2250q;
import j$.util.concurrent.ConcurrentHashMap;
import j3.C2582a;
import java.util.ArrayList;
import java.util.List;
import k3.C2616a;
import k3.p;
import kotlin.jvm.internal.t;
import r3.C2733c;
import r3.C2743m;

/* renamed from: L3.u  reason: case insensitive filesystem */
final class C2115u implements C2126z0 {

    /* renamed from: a  reason: collision with root package name */
    private final p f18591a;

    /* renamed from: b  reason: collision with root package name */
    private final C2117v f18592b = new C2117v();

    /* renamed from: L3.u$a */
    public static final class a implements C2616a {
        public final Object invoke() {
            return new C2124y0();
        }
    }

    public C2115u(p pVar) {
        t.e(pVar, "compute");
        this.f18591a = pVar;
    }

    public Object a(C2733c cVar, List list) {
        Object obj;
        t.e(cVar, "key");
        t.e(list, "types");
        Object a5 = this.f18592b.get(C2582a.a(cVar));
        t.d(a5, "get(...)");
        C2101m0 m0Var = (C2101m0) a5;
        Object obj2 = m0Var.f18560a.get();
        if (obj2 == null) {
            obj2 = m0Var.a(new a());
        }
        C2124y0 y0Var = (C2124y0) obj2;
        Iterable<C2743m> iterable = list;
        ArrayList arrayList = new ArrayList(C2250q.p(iterable, 10));
        for (C2743m y4 : iterable) {
            arrayList.add(new Y(y4));
        }
        ConcurrentHashMap a6 = y0Var.f18603a;
        Object obj3 = a6.get(arrayList);
        if (obj3 == null) {
            try {
                t.a aVar = W2.t.f19966b;
                obj = W2.t.b((b) this.f18591a.invoke(cVar, list));
            } catch (Throwable th) {
                t.a aVar2 = W2.t.f19966b;
                obj = W2.t.b(u.a(th));
            }
            W2.t a7 = W2.t.a(obj);
            Object putIfAbsent = a6.putIfAbsent(arrayList, a7);
            if (putIfAbsent == null) {
                obj3 = a7;
            } else {
                obj3 = putIfAbsent;
            }
        }
        kotlin.jvm.internal.t.d(obj3, "getOrPut(...)");
        return ((W2.t) obj3).j();
    }
}
