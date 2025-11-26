package z3;

import A3.e;
import W2.J;
import b3.C2308e;
import b3.C2312i;
import b3.C2313j;
import c3.C2316b;
import k3.p;
import kotlin.jvm.internal.C2633k;
import y3.C2928a;
import y3.v;

/* renamed from: z3.c  reason: case insensitive filesystem */
class C2970c extends e {

    /* renamed from: d  reason: collision with root package name */
    private final p f26614d;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C2970c(p pVar, C2312i iVar, int i5, C2928a aVar, int i6, C2633k kVar) {
        this(pVar, (i6 & 2) != 0 ? C2313j.f20794a : iVar, (i6 & 4) != 0 ? -2 : i5, (i6 & 8) != 0 ? C2928a.SUSPEND : aVar);
    }

    static /* synthetic */ Object j(C2970c cVar, v vVar, C2308e eVar) {
        Object invoke = cVar.f26614d.invoke(vVar, eVar);
        if (invoke == C2316b.f()) {
            return invoke;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: protected */
    public Object e(v vVar, C2308e eVar) {
        return j(this, vVar, eVar);
    }

    /* access modifiers changed from: protected */
    public e f(C2312i iVar, int i5, C2928a aVar) {
        return new C2970c(this.f26614d, iVar, i5, aVar);
    }

    public String toString() {
        return "block[" + this.f26614d + "] -> " + super.toString();
    }

    public C2970c(p pVar, C2312i iVar, int i5, C2928a aVar) {
        super(iVar, i5, aVar);
        this.f26614d = pVar;
    }
}
