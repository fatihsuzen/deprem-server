package N3;

import W2.B;
import W2.D;
import W2.G;
import W2.z;
import kotlin.jvm.internal.t;

/* renamed from: N3.o  reason: case insensitive filesystem */
public final class C2145o extends C2138h {

    /* renamed from: c  reason: collision with root package name */
    private final boolean f18793c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2145o(C2149t tVar, boolean z4) {
        super(tVar);
        t.e(tVar, "writer");
        this.f18793c = z4;
    }

    public void e(byte b5) {
        boolean z4 = this.f18793c;
        String e5 = z.e(z.b(b5));
        if (z4) {
            n(e5);
        } else {
            k(e5);
        }
    }

    public void i(int i5) {
        boolean z4 = this.f18793c;
        String a5 = Long.toString(((long) B.b(i5)) & 4294967295L, 10);
        if (z4) {
            n(a5);
        } else {
            k(a5);
        }
    }

    public void j(long j5) {
        boolean z4 = this.f18793c;
        long b5 = D.b(j5);
        if (z4) {
            n(C2144n.a(b5, 10));
        } else {
            k(C2144n.a(b5, 10));
        }
    }

    public void l(short s5) {
        boolean z4 = this.f18793c;
        String e5 = G.e(G.b(s5));
        if (z4) {
            n(e5);
        } else {
            k(e5);
        }
    }
}
