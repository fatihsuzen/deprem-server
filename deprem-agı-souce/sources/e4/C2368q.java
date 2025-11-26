package e4;

import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.t;

/* renamed from: e4.q  reason: case insensitive filesystem */
class C2368q implements Z {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f21605a;

    /* renamed from: b  reason: collision with root package name */
    private final a0 f21606b;

    public C2368q(InputStream inputStream, a0 a0Var) {
        t.e(inputStream, "input");
        t.e(a0Var, "timeout");
        this.f21605a = inputStream;
        this.f21606b = a0Var;
    }

    public void close() {
        this.f21605a.close();
    }

    public long e(C2356e eVar, long j5) {
        t.e(eVar, "sink");
        int i5 = (j5 > 0 ? 1 : (j5 == 0 ? 0 : -1));
        if (i5 == 0) {
            return 0;
        }
        if (i5 >= 0) {
            try {
                this.f21606b.f();
                U C4 = eVar.C(1);
                int read = this.f21605a.read(C4.f21513a, C4.f21515c, (int) Math.min(j5, (long) (8192 - C4.f21515c)));
                if (read != -1) {
                    C4.f21515c += read;
                    long j6 = (long) read;
                    eVar.z(eVar.size() + j6);
                    return j6;
                } else if (C4.f21514b != C4.f21515c) {
                    return -1;
                } else {
                    eVar.f21556a = C4.b();
                    V.b(C4);
                    return -1;
                }
            } catch (AssertionError e5) {
                if (L.e(e5)) {
                    throw new IOException(e5);
                }
                throw e5;
            }
        } else {
            throw new IllegalArgumentException(("byteCount < 0: " + j5).toString());
        }
    }

    public a0 timeout() {
        return this.f21606b;
    }

    public String toString() {
        return "source(" + this.f21605a + ')';
    }
}
