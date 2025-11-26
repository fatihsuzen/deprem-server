package W2;

import W2.t;
import b3.C2308e;
import b3.C2312i;
import b3.C2313j;
import c3.C2316b;
import k3.q;
import kotlin.coroutines.jvm.internal.a;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.S;
import kotlin.jvm.internal.t;

/* renamed from: W2.d  reason: case insensitive filesystem */
final class C2215d extends C2214c implements C2308e {

    /* renamed from: a  reason: collision with root package name */
    private q f19947a;

    /* renamed from: b  reason: collision with root package name */
    private Object f19948b;

    /* renamed from: c  reason: collision with root package name */
    private C2308e f19949c = this;

    /* renamed from: d  reason: collision with root package name */
    private Object f19950d = C2213b.f19946a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2215d(q qVar, Object obj) {
        super((C2633k) null);
        t.e(qVar, "block");
        this.f19947a = qVar;
        this.f19948b = obj;
        t.c(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
    }

    public Object a(Object obj, C2308e eVar) {
        t.c(eVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.f19949c = eVar;
        this.f19948b = obj;
        Object f5 = C2316b.f();
        if (f5 == C2316b.f()) {
            h.c(eVar);
        }
        return f5;
    }

    public final Object b() {
        Object obj;
        while (true) {
            Object obj2 = this.f19950d;
            C2308e eVar = this.f19949c;
            if (eVar == null) {
                u.b(obj2);
                return obj2;
            } else if (t.d(C2213b.f19946a, obj2)) {
                try {
                    q qVar = this.f19947a;
                    Object obj3 = this.f19948b;
                    if (!(qVar instanceof a)) {
                        obj = C2316b.e(qVar, this, obj3, eVar);
                    } else {
                        obj = ((q) S.c(qVar, 3)).invoke(this, obj3, eVar);
                    }
                    if (obj != C2316b.f()) {
                        eVar.resumeWith(t.b(obj));
                    }
                } catch (Throwable th) {
                    t.a aVar = t.f19966b;
                    eVar.resumeWith(t.b(u.a(th)));
                }
            } else {
                this.f19950d = C2213b.f19946a;
                eVar.resumeWith(obj2);
            }
        }
    }

    public C2312i getContext() {
        return C2313j.f20794a;
    }

    public void resumeWith(Object obj) {
        this.f19949c = null;
        this.f19950d = obj;
    }
}
