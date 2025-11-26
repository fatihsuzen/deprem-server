package b;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import o4.v;
import w3.M;

public final class t extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public int f832a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ x f833b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t(x xVar, C2308e eVar) {
        super(2, eVar);
        this.f833b = xVar;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new t(this.f833b, eVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        M m5 = (M) obj;
        return new t(this.f833b, (C2308e) obj2).invokeSuspend(J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.f832a;
        if (i5 == 0) {
            u.b(obj);
            v vVar = this.f833b.f847i;
            this.f832a = 1;
            Object a5 = vVar.a(this);
            if (a5 == f5) {
                return f5;
            }
            return a5;
        } else if (i5 == 1) {
            u.b(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
