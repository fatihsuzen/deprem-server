package D3;

import B3.C1992l;
import w3.I;

public final class c extends f {

    /* renamed from: g  reason: collision with root package name */
    public static final c f18075g = new c();

    private c() {
        super(j.f18087c, j.f18088d, j.f18089e, j.f18085a);
    }

    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    public I limitedParallelism(int i5, String str) {
        C1992l.a(i5);
        if (i5 >= j.f18087c) {
            return C1992l.b(this, str);
        }
        return super.limitedParallelism(i5, str);
    }

    public String toString() {
        return "Dispatchers.Default";
    }
}
