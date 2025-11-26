package A3;

import B3.K;
import W2.J;
import W2.u;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import z3.C2973f;

final class z implements C2973f {

    /* renamed from: a  reason: collision with root package name */
    private final C2312i f17325a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f17326b;

    /* renamed from: c  reason: collision with root package name */
    private final p f17327c;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17328a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f17329b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2973f f17330c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C2973f fVar, C2308e eVar) {
            super(2, eVar);
            this.f17330c = fVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            a aVar = new a(this.f17330c, eVar);
            aVar.f17329b = obj;
            return aVar;
        }

        public final Object invoke(Object obj, C2308e eVar) {
            return ((a) create(obj, eVar)).invokeSuspend(J.f19942a);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f17328a;
            if (i5 == 0) {
                u.b(obj);
                Object obj2 = this.f17329b;
                C2973f fVar = this.f17330c;
                this.f17328a = 1;
                if (fVar.emit(obj2, this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return J.f19942a;
        }
    }

    public z(C2973f fVar, C2312i iVar) {
        this.f17325a = iVar;
        this.f17326b = K.g(iVar);
        this.f17327c = new a(fVar, (C2308e) null);
    }

    public Object emit(Object obj, C2308e eVar) {
        Object b5 = f.b(this.f17325a, obj, this.f17326b, this.f17327c, eVar);
        if (b5 == C2316b.f()) {
            return b5;
        }
        return J.f19942a;
    }
}
