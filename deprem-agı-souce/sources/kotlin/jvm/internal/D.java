package kotlin.jvm.internal;

import r3.C2732b;
import r3.C2741k;

public abstract class D extends H implements C2741k {
    public D(Object obj, Class cls, String str, String str2, int i5) {
        super(obj, cls, str, str2, i5);
    }

    /* access modifiers changed from: protected */
    public C2732b computeReflected() {
        return M.f(this);
    }

    public Object getDelegate(Object obj) {
        return ((C2741k) getReflected()).getDelegate(obj);
    }

    public Object invoke(Object obj) {
        return get(obj);
    }

    public C2741k.a getGetter() {
        ((C2741k) getReflected()).getGetter();
        return null;
    }
}
