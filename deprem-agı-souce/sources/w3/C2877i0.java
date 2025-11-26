package w3;

import B3.C1992l;
import X2.C2241h;

/* renamed from: w3.i0  reason: case insensitive filesystem */
public abstract class C2877i0 extends I {

    /* renamed from: a  reason: collision with root package name */
    private long f26286a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f26287b;

    /* renamed from: c  reason: collision with root package name */
    private C2241h f26288c;

    public static /* synthetic */ void G(C2877i0 i0Var, boolean z4, int i5, Object obj) {
        if (obj == null) {
            if ((i5 & 1) != 0) {
                z4 = false;
            }
            i0Var.F(z4);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
    }

    private final long H(boolean z4) {
        if (z4) {
            return 4294967296L;
        }
        return 1;
    }

    public static /* synthetic */ void L(C2877i0 i0Var, boolean z4, int i5, Object obj) {
        if (obj == null) {
            if ((i5 & 1) != 0) {
                z4 = false;
            }
            i0Var.K(z4);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
    }

    public final void F(boolean z4) {
        long H4 = this.f26286a - H(z4);
        this.f26286a = H4;
        if (H4 <= 0 && this.f26287b) {
            shutdown();
        }
    }

    public final void I(Z z4) {
        C2241h hVar = this.f26288c;
        if (hVar == null) {
            hVar = new C2241h();
            this.f26288c = hVar;
        }
        hVar.addLast(z4);
    }

    /* access modifiers changed from: protected */
    public long J() {
        C2241h hVar = this.f26288c;
        if (hVar != null && !hVar.isEmpty()) {
            return 0;
        }
        return Long.MAX_VALUE;
    }

    public final void K(boolean z4) {
        this.f26286a += H(z4);
        if (!z4) {
            this.f26287b = true;
        }
    }

    public final boolean M() {
        if (this.f26286a >= H(true)) {
            return true;
        }
        return false;
    }

    public final boolean N() {
        C2241h hVar = this.f26288c;
        if (hVar != null) {
            return hVar.isEmpty();
        }
        return true;
    }

    public abstract long O();

    public final boolean P() {
        Z z4;
        C2241h hVar = this.f26288c;
        if (hVar == null || (z4 = (Z) hVar.s()) == null) {
            return false;
        }
        z4.run();
        return true;
    }

    public boolean Q() {
        return false;
    }

    public final I limitedParallelism(int i5, String str) {
        C1992l.a(i5);
        return C1992l.b(this, str);
    }

    public abstract void shutdown();
}
