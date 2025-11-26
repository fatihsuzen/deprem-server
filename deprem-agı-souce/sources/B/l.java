package b;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import com.inmobi.cmp.ChoiceCmp;
import k3.p;
import w3.M;

public final class l extends kotlin.coroutines.jvm.internal.l implements p {

    /* renamed from: a  reason: collision with root package name */
    public int f820a;

    public l(C2308e eVar) {
        super(2, eVar);
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new l(eVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        M m5 = (M) obj;
        return new l((C2308e) obj2).invokeSuspend(J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.f820a;
        if (i5 == 0) {
            u.b(obj);
            ChoiceCmp choiceCmp = ChoiceCmp.INSTANCE;
            this.f820a = 1;
            if (ChoiceCmp.access$showCMP(choiceCmp, this) == f5) {
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
