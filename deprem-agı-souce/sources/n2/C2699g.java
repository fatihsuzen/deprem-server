package n2;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import o2.C2702a;
import w3.M;

/* renamed from: n2.g  reason: case insensitive filesystem */
public final class C2699g extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C2702a f25514a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2699g(C2702a aVar, C2308e eVar) {
        super(2, eVar);
        this.f25514a = aVar;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new C2699g(this.f25514a, eVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        M m5 = (M) obj;
        return new C2699g(this.f25514a, (C2308e) obj2).invokeSuspend(J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        C2316b.f();
        u.b(obj);
        this.f25514a.a("Something went wrong");
        return J.f19942a;
    }
}
