package b;

import W2.J;
import W2.u;
import android.content.Context;
import b3.C2308e;
import c3.C2316b;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.cmpapi.status.CmpStatus;
import com.inmobi.cmp.core.cmpapi.status.DisplayStatus;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import s4.c;
import w3.M;

public final class j extends l implements p {
    public j(C2308e eVar) {
        super(2, eVar);
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new j(eVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        M m5 = (M) obj;
        return new j((C2308e) obj2).invokeSuspend(J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        C2316b.f();
        u.b(obj);
        ChoiceCmp choiceCmp = ChoiceCmp.INSTANCE;
        choiceCmp.getClass();
        ChoiceCmpCallback callback = choiceCmp.getCallback();
        if (callback != null) {
            callback.onCmpLoaded(choiceCmp.ping$app_release(true, CmpStatus.LOADED, DisplayStatus.HIDDEN));
        }
        if (c.f25853a != null) {
            choiceCmp.a((Context) c.c());
        }
        return J.f19942a;
    }
}
