package n2;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import o2.C2702a;
import w3.M;

/* renamed from: n2.d  reason: case insensitive filesystem */
public final class C2696d extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C2702a f25510a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2696d(C2702a aVar, C2308e eVar) {
        super(2, eVar);
        this.f25510a = aVar;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new C2696d(this.f25510a, eVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        M m5 = (M) obj;
        return new C2696d(this.f25510a, (C2308e) obj2).invokeSuspend(J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        C2316b.f();
        u.b(obj);
        this.f25510a.c();
        return J.f19942a;
    }
}
