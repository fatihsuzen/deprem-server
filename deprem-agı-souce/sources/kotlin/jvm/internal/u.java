package kotlin.jvm.internal;

import java.io.Serializable;

public abstract class u implements C2637o, Serializable {
    private final int arity;

    public u(int i5) {
        this.arity = i5;
    }

    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String i5 = M.i(this);
        t.d(i5, "renderLambdaToString(...)");
        return i5;
    }
}
