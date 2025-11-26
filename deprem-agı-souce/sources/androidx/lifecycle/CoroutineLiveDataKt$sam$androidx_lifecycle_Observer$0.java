package androidx.lifecycle;

import W2.C2218g;
import k3.l;
import kotlin.jvm.internal.C2636n;
import kotlin.jvm.internal.t;

final class CoroutineLiveDataKt$sam$androidx_lifecycle_Observer$0 implements Observer, C2636n {
    private final /* synthetic */ l function;

    CoroutineLiveDataKt$sam$androidx_lifecycle_Observer$0(l lVar) {
        t.e(lVar, "function");
        this.function = lVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Observer) || !(obj instanceof C2636n)) {
            return false;
        }
        return t.a(getFunctionDelegate(), ((C2636n) obj).getFunctionDelegate());
    }

    public final C2218g getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    public final /* synthetic */ void onChanged(Object obj) {
        this.function.invoke(obj);
    }
}
