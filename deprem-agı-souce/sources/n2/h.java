package n2;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import o2.C2702a;
import w3.M;

public final class h extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C2702a f25515a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(C2702a aVar, C2308e eVar) {
        super(2, eVar);
        this.f25515a = aVar;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new h(this.f25515a, eVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        M m5 = (M) obj;
        return new h(this.f25515a, (C2308e) obj2).invokeSuspend(J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        C2316b.f();
        u.b(obj);
        this.f25515a.a("Something went wrong");
        return J.f19942a;
    }
}
