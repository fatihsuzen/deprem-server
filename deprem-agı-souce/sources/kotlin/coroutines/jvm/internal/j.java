package kotlin.coroutines.jvm.internal;

import b3.C2308e;
import b3.C2312i;
import b3.C2313j;

public abstract class j extends a {
    public j(C2308e eVar) {
        super(eVar);
        if (eVar != null && eVar.getContext() != C2313j.f20794a) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext");
        }
    }

    public C2312i getContext() {
        return C2313j.f20794a;
    }
}
