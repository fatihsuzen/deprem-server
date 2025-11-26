package A3;

import W2.J;
import W2.u;
import b3.C2308e;
import b3.C2312i;
import b3.C2313j;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import w3.C2908y0;
import w3.M;
import w3.O;
import y3.C2928a;
import y3.t;
import y3.v;
import y3.x;
import z3.C2972e;

public final class i extends e {

    /* renamed from: d  reason: collision with root package name */
    private final Iterable f17282d;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17283a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2972e f17284b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ x f17285c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C2972e eVar, x xVar, C2308e eVar2) {
            super(2, eVar2);
            this.f17284b = eVar;
            this.f17285c = xVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f17284b, this.f17285c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f17283a;
            if (i5 == 0) {
                u.b(obj);
                C2972e eVar = this.f17284b;
                x xVar = this.f17285c;
                this.f17283a = 1;
                if (eVar.collect(xVar, this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(Iterable iterable, C2312i iVar, int i5, C2928a aVar, int i6, C2633k kVar) {
        this(iterable, (i6 & 2) != 0 ? C2313j.f20794a : iVar, (i6 & 4) != 0 ? -2 : i5, (i6 & 8) != 0 ? C2928a.SUSPEND : aVar);
    }

    /* access modifiers changed from: protected */
    public Object e(v vVar, C2308e eVar) {
        x xVar = new x(vVar);
        for (C2972e aVar : this.f17282d) {
            C2908y0 unused = C2876i.d(vVar, (C2312i) null, (O) null, new a(aVar, xVar, (C2308e) null), 3, (Object) null);
        }
        return J.f19942a;
    }

    /* access modifiers changed from: protected */
    public e f(C2312i iVar, int i5, C2928a aVar) {
        return new i(this.f17282d, iVar, i5, aVar);
    }

    public x i(M m5) {
        return t.b(m5, this.f17268a, this.f17269b, g());
    }

    public i(Iterable iterable, C2312i iVar, int i5, C2928a aVar) {
        super(iVar, i5, aVar);
        this.f17282d = iterable;
    }
}
