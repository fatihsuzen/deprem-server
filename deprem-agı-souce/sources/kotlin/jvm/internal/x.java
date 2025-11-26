package kotlin.jvm.internal;

import r3.C2732b;
import r3.C2738h;
import r3.C2741k;

public abstract class x extends z implements C2738h {
    public x(Object obj, Class cls, String str, String str2, int i5) {
        super(obj, cls, str, str2, i5);
    }

    /* access modifiers changed from: protected */
    public C2732b computeReflected() {
        return M.d(this);
    }

    public Object getDelegate(Object obj) {
        return ((C2738h) getReflected()).getDelegate(obj);
    }

    public Object invoke(Object obj) {
        return get(obj);
    }

    public C2741k.a getGetter() {
        ((C2738h) getReflected()).getGetter();
        return null;
    }

    public C2738h.a getSetter() {
        ((C2738h) getReflected()).getSetter();
        return null;
    }
}
