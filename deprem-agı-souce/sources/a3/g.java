package A3;

import W2.J;
import W2.u;
import b3.C2308e;
import b3.C2309f;
import b3.C2312i;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import w3.G;
import y3.C2928a;
import y3.v;
import z3.C2972e;
import z3.C2973f;

public abstract class g extends e {

    /* renamed from: d  reason: collision with root package name */
    protected final C2972e f17278d;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17279a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f17280b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ g f17281c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(g gVar, C2308e eVar) {
            super(2, eVar);
            this.f17281c = gVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            a aVar = new a(this.f17281c, eVar);
            aVar.f17280b = obj;
            return aVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f17279a;
            if (i5 == 0) {
                u.b(obj);
                g gVar = this.f17281c;
                this.f17279a = 1;
                if (gVar.m((C2973f) this.f17280b, this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return J.f19942a;
        }

        public final Object invoke(C2973f fVar, C2308e eVar) {
            return ((a) create(fVar, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public g(C2972e eVar, C2312i iVar, int i5, C2928a aVar) {
        super(iVar, i5, aVar);
        this.f17278d = eVar;
    }

    static /* synthetic */ Object j(g gVar, C2973f fVar, C2308e eVar) {
        if (gVar.f17269b == -3) {
            C2312i context = eVar.getContext();
            C2312i j5 = G.j(context, gVar.f17268a);
            if (t.a(j5, context)) {
                Object m5 = gVar.m(fVar, eVar);
                if (m5 == C2316b.f()) {
                    return m5;
                }
                return J.f19942a;
            }
            C2309f.b bVar = C2309f.f20792a0;
            if (t.a(j5.get(bVar), context.get(bVar))) {
                Object l5 = gVar.l(fVar, j5, eVar);
                if (l5 == C2316b.f()) {
                    return l5;
                }
                return J.f19942a;
            }
        }
        Object collect = super.collect(fVar, eVar);
        if (collect == C2316b.f()) {
            return collect;
        }
        return J.f19942a;
    }

    static /* synthetic */ Object k(g gVar, v vVar, C2308e eVar) {
        Object m5 = gVar.m(new x(vVar), eVar);
        if (m5 == C2316b.f()) {
            return m5;
        }
        return J.f19942a;
    }

    private final Object l(C2973f fVar, C2312i iVar, C2308e eVar) {
        return f.c(iVar, f.d(fVar, eVar.getContext()), (Object) null, new a(this, (C2308e) null), eVar, 4, (Object) null);
    }

    public Object collect(C2973f fVar, C2308e eVar) {
        return j(this, fVar, eVar);
    }

    /* access modifiers changed from: protected */
    public Object e(v vVar, C2308e eVar) {
        return k(this, vVar, eVar);
    }

    /* access modifiers changed from: protected */
    public abstract Object m(C2973f fVar, C2308e eVar);

    public String toString() {
        return this.f17278d + " -> " + super.toString();
    }
}
