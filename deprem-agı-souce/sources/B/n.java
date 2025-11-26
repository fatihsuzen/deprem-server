package b;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import com.inmobi.cmp.ChoiceCmp;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

public final class n extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public int f821a;

    public n(C2308e eVar) {
        super(2, eVar);
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new n(eVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        M m5 = (M) obj;
        return new n((C2308e) obj2).invokeSuspend(J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.f821a;
        if (i5 == 0) {
            u.b(obj);
            ChoiceCmp choiceCmp = ChoiceCmp.INSTANCE;
            this.f821a = 1;
            if (ChoiceCmp.access$loadCmpInfo(choiceCmp, this) == f5) {
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
