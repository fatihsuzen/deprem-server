package e4;

import java.io.OutputStream;
import kotlin.jvm.internal.t;

final class O implements X {

    /* renamed from: a  reason: collision with root package name */
    private final OutputStream f21499a;

    /* renamed from: b  reason: collision with root package name */
    private final a0 f21500b;

    public O(OutputStream outputStream, a0 a0Var) {
        t.e(outputStream, "out");
        t.e(a0Var, "timeout");
        this.f21499a = outputStream;
        this.f21500b = a0Var;
    }

    public void close() {
        this.f21499a.close();
    }

    public void f(C2356e eVar, long j5) {
        t.e(eVar, "source");
        C2353b.b(eVar.size(), 0, j5);
        while (j5 > 0) {
            this.f21500b.f();
            U u5 = eVar.f21556a;
            t.b(u5);
            int min = (int) Math.min(j5, (long) (u5.f21515c - u5.f21514b));
            this.f21499a.write(u5.f21513a, u5.f21514b, min);
            u5.f21514b += min;
            long j6 = (long) min;
            j5 -= j6;
            eVar.z(eVar.size() - j6);
            if (u5.f21514b == u5.f21515c) {
                eVar.f21556a = u5.b();
                V.b(u5);
            }
        }
    }

    public void flush() {
        this.f21499a.flush();
    }

    public a0 timeout() {
        return this.f21500b;
    }

    public String toString() {
        return "sink(" + this.f21499a + ')';
    }
}
