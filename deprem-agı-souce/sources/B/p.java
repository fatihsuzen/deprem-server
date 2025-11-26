package b;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import kotlin.coroutines.jvm.internal.l;
import o4.B;
import o4.w;
import w3.M;

public final class p extends l implements k3.p {

    /* renamed from: a  reason: collision with root package name */
    public int f824a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ x f825b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p(x xVar, C2308e eVar) {
        super(2, eVar);
        this.f825b = xVar;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new p(this.f825b, eVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        M m5 = (M) obj;
        return new p(this.f825b, (C2308e) obj2).invokeSuspend(J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.f824a;
        if (i5 == 0) {
            u.b(obj);
            x xVar = this.f825b;
            w wVar = xVar.f842d;
            int i6 = xVar.f841c.f19281b.f19216G;
            this.f824a = 1;
            Object a5 = ((B) wVar).a(i6, this);
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
