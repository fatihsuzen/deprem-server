package b3;

import b3.C2309f;
import k3.p;
import kotlin.jvm.internal.t;

/* renamed from: b3.i  reason: case insensitive filesystem */
public interface C2312i {

    /* renamed from: b3.i$a */
    public static final class a {
        public static C2312i b(C2312i iVar, C2312i iVar2) {
            t.e(iVar2, "context");
            if (iVar2 == C2313j.f20794a) {
                return iVar;
            }
            return (C2312i) iVar2.fold(iVar, new C2311h());
        }

        /* access modifiers changed from: private */
        public static C2312i c(C2312i iVar, b bVar) {
            t.e(iVar, "acc");
            t.e(bVar, "element");
            C2312i minusKey = iVar.minusKey(bVar.getKey());
            C2313j jVar = C2313j.f20794a;
            if (minusKey == jVar) {
                return bVar;
            }
            C2309f.b bVar2 = C2309f.f20792a0;
            C2309f fVar = (C2309f) minusKey.get(bVar2);
            if (fVar == null) {
                return new C2307d(minusKey, bVar);
            }
            C2312i minusKey2 = minusKey.minusKey(bVar2);
            if (minusKey2 == jVar) {
                return new C2307d(bVar, fVar);
            }
            return new C2307d(new C2307d(minusKey2, bVar), fVar);
        }
    }

    /* renamed from: b3.i$b */
    public interface b extends C2312i {

        /* renamed from: b3.i$b$a */
        public static final class a {
            public static Object a(b bVar, Object obj, p pVar) {
                t.e(pVar, "operation");
                return pVar.invoke(obj, bVar);
            }

            public static b b(b bVar, c cVar) {
                t.e(cVar, "key");
                if (!t.a(bVar.getKey(), cVar)) {
                    return null;
                }
                t.c(bVar, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return bVar;
            }

            public static C2312i c(b bVar, c cVar) {
                t.e(cVar, "key");
                if (t.a(bVar.getKey(), cVar)) {
                    return C2313j.f20794a;
                }
                return bVar;
            }

            public static C2312i d(b bVar, C2312i iVar) {
                t.e(iVar, "context");
                return a.b(bVar, iVar);
            }
        }

        b get(c cVar);

        c getKey();
    }

    /* renamed from: b3.i$c */
    public interface c {
    }

    Object fold(Object obj, p pVar);

    b get(c cVar);

    C2312i minusKey(c cVar);

    C2312i plus(C2312i iVar);
}
