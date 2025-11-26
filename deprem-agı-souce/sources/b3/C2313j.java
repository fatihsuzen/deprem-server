package b3;

import b3.C2312i;
import java.io.Serializable;
import k3.p;
import kotlin.jvm.internal.t;

/* renamed from: b3.j  reason: case insensitive filesystem */
public final class C2313j implements C2312i, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final C2313j f20794a = new C2313j();

    private C2313j() {
    }

    public Object fold(Object obj, p pVar) {
        t.e(pVar, "operation");
        return obj;
    }

    public C2312i.b get(C2312i.c cVar) {
        t.e(cVar, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    public C2312i minusKey(C2312i.c cVar) {
        t.e(cVar, "key");
        return this;
    }

    public C2312i plus(C2312i iVar) {
        t.e(iVar, "context");
        return iVar;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
