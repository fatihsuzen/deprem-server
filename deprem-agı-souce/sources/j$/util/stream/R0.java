package j$.util.stream;

import java.util.function.IntFunction;

public abstract class R0 extends J0 implements G0 {
    public final /* synthetic */ Object[] m(IntFunction intFunction) {
        return C0594w1.L(this, intFunction);
    }

    public final void g(Object obj) {
        ((G0) this.f1504a).g(obj);
        ((G0) this.f1505b).g(obj);
    }

    public final void f(int i5, Object obj) {
        H0 h02 = this.f1504a;
        ((G0) h02).f(i5, obj);
        ((G0) this.f1505b).f(i5 + ((int) ((G0) h02).count()), obj);
    }

    public final Object b() {
        long j5 = this.f1506c;
        if (j5 < 2147483639) {
            Object newArray = newArray((int) j5);
            f(0, newArray);
            return newArray;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public final String toString() {
        long j5 = this.f1506c;
        if (j5 < 32) {
            return String.format("%s[%s.%s]", new Object[]{getClass().getName(), this.f1504a, this.f1505b});
        }
        return String.format("%s[size=%d]", new Object[]{getClass().getName(), Long.valueOf(j5)});
    }
}
