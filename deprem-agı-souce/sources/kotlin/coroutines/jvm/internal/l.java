package kotlin.coroutines.jvm.internal;

import b3.C2308e;
import kotlin.jvm.internal.C2637o;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;

public abstract class l extends d implements C2637o {
    private final int arity;

    public l(int i5, C2308e eVar) {
        super(eVar);
        this.arity = i5;
    }

    public int getArity() {
        return this.arity;
    }

    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String h5 = M.h(this);
        t.d(h5, "renderLambdaToString(...)");
        return h5;
    }
}
