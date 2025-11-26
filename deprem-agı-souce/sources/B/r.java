package b;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

public final class r extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public int f828a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ x f829b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(x xVar, C2308e eVar) {
        super(2, eVar);
        this.f829b = xVar;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new r(this.f829b, eVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        M m5 = (M) obj;
        return new r(this.f829b, (C2308e) obj2).invokeSuspend(J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.f828a;
        if (i5 == 0) {
            u.b(obj);
            o4.r rVar = this.f829b.f848j;
            this.f828a = 1;
            Object a5 = rVar.a(this);
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
