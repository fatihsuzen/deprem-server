package D3;

import B3.C1992l;
import b3.C2312i;
import w3.I;

final class k extends I {

    /* renamed from: a  reason: collision with root package name */
    public static final k f18091a = new k();

    private k() {
    }

    public void dispatch(C2312i iVar, Runnable runnable) {
        c.f18075g.H(runnable, true, false);
    }

    public void dispatchYield(C2312i iVar, Runnable runnable) {
        c.f18075g.H(runnable, true, true);
    }

    public I limitedParallelism(int i5, String str) {
        C1992l.a(i5);
        if (i5 >= j.f18088d) {
            return C1992l.b(this, str);
        }
        return super.limitedParallelism(i5, str);
    }

    public String toString() {
        return "Dispatchers.IO";
    }
}
