package W2;

import java.io.Serializable;
import k3.C2616a;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

final class w implements C2223l, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private C2616a f19974a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f19975b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f19976c;

    public w(C2616a aVar, Object obj) {
        t.e(aVar, "initializer");
        this.f19974a = aVar;
        this.f19975b = F.f19936a;
        this.f19976c = obj == null ? this : obj;
    }

    public Object getValue() {
        Object obj;
        Object obj2 = this.f19975b;
        F f5 = F.f19936a;
        if (obj2 != f5) {
            return obj2;
        }
        synchronized (this.f19976c) {
            obj = this.f19975b;
            if (obj == f5) {
                C2616a aVar = this.f19974a;
                t.b(aVar);
                obj = aVar.invoke();
                this.f19975b = obj;
                this.f19974a = null;
            }
        }
        return obj;
    }

    public boolean isInitialized() {
        if (this.f19975b != F.f19936a) {
            return true;
        }
        return false;
    }

    public String toString() {
        if (isInitialized()) {
            return String.valueOf(getValue());
        }
        return "Lazy value not initialized yet.";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w(C2616a aVar, Object obj, int i5, C2633k kVar) {
        this(aVar, (i5 & 2) != 0 ? null : obj);
    }
}
