package w3;

/* renamed from: w3.f0  reason: case insensitive filesystem */
final class C2871f0 implements C2880k {

    /* renamed from: a  reason: collision with root package name */
    private final C2869e0 f26283a;

    public C2871f0(C2869e0 e0Var) {
        this.f26283a = e0Var;
    }

    public void a(Throwable th) {
        this.f26283a.dispose();
    }

    public String toString() {
        return "DisposeOnCancel[" + this.f26283a + ']';
    }
}
