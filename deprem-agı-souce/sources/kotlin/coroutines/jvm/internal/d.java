package kotlin.coroutines.jvm.internal;

import b3.C2308e;
import b3.C2309f;
import b3.C2312i;
import kotlin.jvm.internal.t;

public abstract class d extends a {
    private final C2312i _context;
    private transient C2308e intercepted;

    public d(C2308e eVar, C2312i iVar) {
        super(eVar);
        this._context = iVar;
    }

    public C2312i getContext() {
        C2312i iVar = this._context;
        t.b(iVar);
        return iVar;
    }

    public final C2308e intercepted() {
        C2308e eVar = this.intercepted;
        if (eVar == null) {
            C2309f fVar = (C2309f) getContext().get(C2309f.f20792a0);
            if (fVar == null || (eVar = fVar.interceptContinuation(this)) == null) {
                eVar = this;
            }
            this.intercepted = eVar;
        }
        return eVar;
    }

    /* access modifiers changed from: protected */
    public void releaseIntercepted() {
        C2308e eVar = this.intercepted;
        if (!(eVar == null || eVar == this)) {
            C2312i.b bVar = getContext().get(C2309f.f20792a0);
            t.b(bVar);
            ((C2309f) bVar).releaseInterceptedContinuation(eVar);
        }
        this.intercepted = c.f24678a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public d(C2308e eVar) {
        this(eVar, eVar != null ? eVar.getContext() : null);
    }
}
