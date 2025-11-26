package w3;

import b3.C2304a;
import b3.C2308e;
import java.util.concurrent.CancellationException;
import k3.l;

public final class K0 extends C2304a implements C2908y0 {

    /* renamed from: a  reason: collision with root package name */
    public static final K0 f26241a = new K0();

    private K0() {
        super(C2908y0.f26320k0);
    }

    public boolean C() {
        return false;
    }

    public boolean isActive() {
        return true;
    }

    public boolean isCancelled() {
        return false;
    }

    public Object l(C2308e eVar) {
        throw new UnsupportedOperationException("This job is always active");
    }

    public CancellationException m() {
        throw new IllegalStateException("This job is always active");
    }

    public C2869e0 p(boolean z4, boolean z5, l lVar) {
        return L0.f26244a;
    }

    public C2869e0 s(l lVar) {
        return L0.f26244a;
    }

    public boolean start() {
        return false;
    }

    public String toString() {
        return "NonCancellable";
    }

    public C2895s z(C2899u uVar) {
        return L0.f26244a;
    }

    public void a(CancellationException cancellationException) {
    }
}
