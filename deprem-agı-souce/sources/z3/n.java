package z3;

import k3.l;
import k3.p;
import kotlin.jvm.internal.t;

abstract /* synthetic */ class n {

    /* renamed from: a  reason: collision with root package name */
    private static final l f26632a = new l();

    /* renamed from: b  reason: collision with root package name */
    private static final p f26633b = new m();

    /* access modifiers changed from: private */
    public static final boolean c(Object obj, Object obj2) {
        return t.a(obj, obj2);
    }

    public static final C2972e e(C2972e eVar) {
        if (eVar instanceof D) {
            return eVar;
        }
        return f(eVar, f26632a, f26633b);
    }

    private static final C2972e f(C2972e eVar, l lVar, p pVar) {
        if (eVar instanceof C2971d) {
            C2971d dVar = (C2971d) eVar;
            if (dVar.f26616b == lVar && dVar.f26617c == pVar) {
                return eVar;
            }
        }
        return new C2971d(eVar, lVar, pVar);
    }

    /* access modifiers changed from: private */
    public static final Object d(Object obj) {
        return obj;
    }
}
