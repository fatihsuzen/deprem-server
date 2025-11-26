package w3;

import B3.C1992l;

public abstract class I0 extends I {
    public abstract I0 F();

    /* access modifiers changed from: protected */
    public final String G() {
        I0 i02;
        I0 c5 = C2865c0.c();
        if (this == c5) {
            return "Dispatchers.Main";
        }
        try {
            i02 = c5.F();
        } catch (UnsupportedOperationException unused) {
            i02 = null;
        }
        if (this == i02) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    public I limitedParallelism(int i5, String str) {
        C1992l.a(i5);
        return C1992l.b(this, str);
    }
}
