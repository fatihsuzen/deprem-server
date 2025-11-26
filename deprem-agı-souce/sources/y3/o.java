package y3;

import W2.J;
import W2.t;
import W2.u;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import w3.M;
import y3.C2938k;

abstract /* synthetic */ class o {

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f26443a;

        /* renamed from: b  reason: collision with root package name */
        private /* synthetic */ Object f26444b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ y f26445c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Object f26446d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(y yVar, Object obj, C2308e eVar) {
            super(2, eVar);
            this.f26445c = yVar;
            this.f26446d = obj;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            a aVar = new a(this.f26445c, this.f26446d, eVar);
            aVar.f26444b = obj;
            return aVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object obj2;
            Object obj3;
            Object f5 = C2316b.f();
            int i5 = this.f26443a;
            if (i5 == 0) {
                u.b(obj);
                M m5 = (M) this.f26444b;
                y yVar = this.f26445c;
                Object obj4 = this.f26446d;
                t.a aVar = t.f19966b;
                this.f26443a = 1;
                if (yVar.e(obj4, this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                try {
                    u.b(obj);
                } catch (Throwable th) {
                    t.a aVar2 = t.f19966b;
                    obj2 = t.b(u.a(th));
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            obj2 = t.b(J.f19942a);
            if (t.h(obj2)) {
                obj3 = C2938k.f26437b.c(J.f19942a);
            } else {
                obj3 = C2938k.f26437b.a(t.e(obj2));
            }
            return C2938k.b(obj3);
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final Object a(y yVar, Object obj) {
        Object r5 = yVar.r(obj);
        if (r5 instanceof C2938k.c) {
            return ((C2938k) C2874h.b((C2312i) null, new a(yVar, obj, (C2308e) null), 1, (Object) null)).k();
        }
        J j5 = (J) r5;
        return C2938k.f26437b.c(J.f19942a);
    }
}
