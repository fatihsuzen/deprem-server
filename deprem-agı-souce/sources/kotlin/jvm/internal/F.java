package kotlin.jvm.internal;

import r3.C2732b;
import r3.C2742l;

public abstract class F extends H implements C2742l {
    public F(Class cls, String str, String str2, int i5) {
        super(C2628f.NO_RECEIVER, cls, str, str2, i5);
    }

    /* access modifiers changed from: protected */
    public C2732b computeReflected() {
        return M.g(this);
    }

    public C2742l.a getGetter() {
        ((C2742l) getReflected()).getGetter();
        return null;
    }

    public Object invoke(Object obj, Object obj2) {
        return i(obj, obj2);
    }
}
