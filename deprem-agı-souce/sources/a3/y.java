package A3;

import b3.C2308e;
import b3.C2312i;
import kotlin.coroutines.jvm.internal.e;

final class y implements C2308e, e {

    /* renamed from: a  reason: collision with root package name */
    private final C2308e f17323a;

    /* renamed from: b  reason: collision with root package name */
    private final C2312i f17324b;

    public y(C2308e eVar, C2312i iVar) {
        this.f17323a = eVar;
        this.f17324b = iVar;
    }

    public e getCallerFrame() {
        C2308e eVar = this.f17323a;
        if (eVar instanceof e) {
            return (e) eVar;
        }
        return null;
    }

    public C2312i getContext() {
        return this.f17324b;
    }

    public void resumeWith(Object obj) {
        this.f17323a.resumeWith(obj);
    }
}
