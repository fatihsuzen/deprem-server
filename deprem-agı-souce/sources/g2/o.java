package G2;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import java.util.UUID;
import k3.p;
import k4.h;
import k4.z;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

public final class o extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public int f18177a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p f18178b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(p pVar, C2308e eVar) {
        super(2, eVar);
        this.f18178b = pVar;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new o(this.f18178b, eVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        M m5 = (M) obj;
        return new o(this.f18178b, (C2308e) obj2).invokeSuspend(J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.f18177a;
        if (i5 == 0) {
            u.b(obj);
            UUID uuid = z.f24676a;
            h hVar = h.MSPA;
            int i6 = this.f18178b.f18182d;
            this.f18177a = 1;
            if (z.c(hVar, i6, this) == f5) {
                return f5;
            }
        } else if (i5 == 1) {
            u.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return J.f19942a;
    }
}
