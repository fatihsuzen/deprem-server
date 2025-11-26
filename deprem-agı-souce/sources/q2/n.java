package Q2;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import o4.C2708c;
import o4.E;
import w3.M;

public final class n extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public k3.l f18929a;

    /* renamed from: b  reason: collision with root package name */
    public int f18930b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ k3.l f18931c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ o f18932d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(k3.l lVar, o oVar, C2308e eVar) {
        super(2, eVar);
        this.f18931c = lVar;
        this.f18932d = oVar;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new n(this.f18931c, this.f18932d, eVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        M m5 = (M) obj;
        return new n(this.f18931c, this.f18932d, (C2308e) obj2).invokeSuspend(J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        k3.l lVar;
        Object f5 = C2316b.f();
        int i5 = this.f18930b;
        if (i5 == 0) {
            u.b(obj);
            k3.l lVar2 = this.f18931c;
            E e5 = this.f18932d.f18937e;
            this.f18929a = lVar2;
            this.f18930b = 1;
            Object b5 = ((C2708c) e5).b(this);
            if (b5 == f5) {
                return f5;
            }
            lVar = lVar2;
            obj = b5;
        } else if (i5 == 1) {
            lVar = this.f18929a;
            u.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        lVar.invoke(obj);
        return J.f19942a;
    }
}
