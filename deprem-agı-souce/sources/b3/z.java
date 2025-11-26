package B3;

import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import kotlin.coroutines.jvm.internal.e;
import w3.C2856C;
import w3.C2860a;

public class z extends C2860a implements e {

    /* renamed from: d  reason: collision with root package name */
    public final C2308e f17429d;

    public z(C2312i iVar, C2308e eVar) {
        super(iVar, true, true);
        this.f17429d = eVar;
    }

    /* access modifiers changed from: protected */
    public void I(Object obj) {
        C1989i.b(C2316b.c(this.f17429d), C2856C.a(obj, this.f17429d));
    }

    /* access modifiers changed from: protected */
    public void M0(Object obj) {
        C2308e eVar = this.f17429d;
        eVar.resumeWith(C2856C.a(obj, eVar));
    }

    public final e getCallerFrame() {
        C2308e eVar = this.f17429d;
        if (eVar instanceof e) {
            return (e) eVar;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final boolean l0() {
        return true;
    }
}
