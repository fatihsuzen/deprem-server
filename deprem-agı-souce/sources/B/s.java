package b;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import o4.t;
import w3.M;

public final class s extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public int f830a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ x f831b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s(x xVar, C2308e eVar) {
        super(2, eVar);
        this.f831b = xVar;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new s(this.f831b, eVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        M m5 = (M) obj;
        return new s(this.f831b, (C2308e) obj2).invokeSuspend(J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.f830a;
        if (i5 == 0) {
            u.b(obj);
            t tVar = this.f831b.f846h;
            this.f830a = 1;
            Object a5 = tVar.a(this);
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
