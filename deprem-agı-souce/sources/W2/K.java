package W2;

import java.io.Serializable;
import k3.C2616a;
import kotlin.jvm.internal.t;

public final class K implements C2223l, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private C2616a f19943a;

    /* renamed from: b  reason: collision with root package name */
    private Object f19944b = F.f19936a;

    public K(C2616a aVar) {
        t.e(aVar, "initializer");
        this.f19943a = aVar;
    }

    public Object getValue() {
        if (this.f19944b == F.f19936a) {
            C2616a aVar = this.f19943a;
            t.b(aVar);
            this.f19944b = aVar.invoke();
            this.f19943a = null;
        }
        return this.f19944b;
    }

    public boolean isInitialized() {
        if (this.f19944b != F.f19936a) {
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
}
