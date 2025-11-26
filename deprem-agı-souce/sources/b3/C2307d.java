package b3;

import b3.C2312i;
import java.io.Serializable;
import k3.p;
import kotlin.jvm.internal.t;

/* renamed from: b3.d  reason: case insensitive filesystem */
public final class C2307d implements C2312i, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final C2312i f20790a;

    /* renamed from: b  reason: collision with root package name */
    private final C2312i.b f20791b;

    public C2307d(C2312i iVar, C2312i.b bVar) {
        t.e(iVar, TtmlNode.LEFT);
        t.e(bVar, "element");
        this.f20790a = iVar;
        this.f20791b = bVar;
    }

    private final boolean c(C2312i.b bVar) {
        return t.a(get(bVar.getKey()), bVar);
    }

    private final boolean e(C2307d dVar) {
        while (c(dVar.f20791b)) {
            C2312i iVar = dVar.f20790a;
            if (iVar instanceof C2307d) {
                dVar = (C2307d) iVar;
            } else {
                t.c(iVar, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return c((C2312i.b) iVar);
            }
        }
        return false;
    }

    private final int f() {
        int i5 = 2;
        C2307d dVar = this;
        while (true) {
            C2312i iVar = dVar.f20790a;
            if (iVar instanceof C2307d) {
                dVar = (C2307d) iVar;
            } else {
                dVar = null;
            }
            if (dVar == null) {
                return i5;
            }
            i5++;
        }
    }

    /* access modifiers changed from: private */
    public static final String g(String str, C2312i.b bVar) {
        t.e(str, "acc");
        t.e(bVar, "element");
        if (str.length() == 0) {
            return bVar.toString();
        }
        return str + ", " + bVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2307d)) {
            return false;
        }
        C2307d dVar = (C2307d) obj;
        if (dVar.f() != f() || !dVar.e(this)) {
            return false;
        }
        return true;
    }

    public Object fold(Object obj, p pVar) {
        t.e(pVar, "operation");
        return pVar.invoke(this.f20790a.fold(obj, pVar), this.f20791b);
    }

    public C2312i.b get(C2312i.c cVar) {
        t.e(cVar, "key");
        C2307d dVar = this;
        while (true) {
            C2312i.b bVar = dVar.f20791b.get(cVar);
            if (bVar != null) {
                return bVar;
            }
            C2312i iVar = dVar.f20790a;
            if (!(iVar instanceof C2307d)) {
                return iVar.get(cVar);
            }
            dVar = (C2307d) iVar;
        }
    }

    public int hashCode() {
        return this.f20790a.hashCode() + this.f20791b.hashCode();
    }

    public C2312i minusKey(C2312i.c cVar) {
        t.e(cVar, "key");
        if (this.f20791b.get(cVar) != null) {
            return this.f20790a;
        }
        C2312i minusKey = this.f20790a.minusKey(cVar);
        if (minusKey == this.f20790a) {
            return this;
        }
        if (minusKey == C2313j.f20794a) {
            return this.f20791b;
        }
        return new C2307d(minusKey, this.f20791b);
    }

    public C2312i plus(C2312i iVar) {
        return C2312i.a.b(this, iVar);
    }

    public String toString() {
        return '[' + ((String) fold("", new C2306c())) + ']';
    }
}
