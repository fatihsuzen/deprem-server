package A3;

import W2.J;
import b3.C2308e;
import b3.C2312i;
import b3.C2313j;
import c3.C2316b;
import kotlin.jvm.internal.C2633k;
import y3.C2928a;
import z3.C2972e;
import z3.C2973f;

public final class h extends g {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(C2972e eVar, C2312i iVar, int i5, C2928a aVar, int i6, C2633k kVar) {
        this(eVar, (i6 & 2) != 0 ? C2313j.f20794a : iVar, (i6 & 4) != 0 ? -3 : i5, (i6 & 8) != 0 ? C2928a.SUSPEND : aVar);
    }

    /* access modifiers changed from: protected */
    public e f(C2312i iVar, int i5, C2928a aVar) {
        return new h(this.f17278d, iVar, i5, aVar);
    }

    /* access modifiers changed from: protected */
    public Object m(C2973f fVar, C2308e eVar) {
        Object collect = this.f17278d.collect(fVar, eVar);
        if (collect == C2316b.f()) {
            return collect;
        }
        return J.f19942a;
    }

    public h(C2972e eVar, C2312i iVar, int i5, C2928a aVar) {
        super(eVar, iVar, i5, aVar);
    }
}
