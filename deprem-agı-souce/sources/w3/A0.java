package w3;

public class A0 extends E0 implements C2907y {

    /* renamed from: c  reason: collision with root package name */
    private final boolean f26215c = M0();

    public A0(C2908y0 y0Var) {
        super(true);
        j0(y0Var);
    }

    private final boolean M0() {
        C2897t tVar;
        E0 t5;
        C2897t tVar2;
        C2895s d02 = d0();
        if (d02 instanceof C2897t) {
            tVar = (C2897t) d02;
        } else {
            tVar = null;
        }
        if (!(tVar == null || (t5 = tVar.t()) == null)) {
            while (!t5.Z()) {
                C2895s d03 = t5.d0();
                if (d03 instanceof C2897t) {
                    tVar2 = (C2897t) d03;
                } else {
                    tVar2 = null;
                }
                if (tVar2 != null) {
                    t5 = tVar2.t();
                    if (t5 == null) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    public boolean Z() {
        return this.f26215c;
    }

    public boolean a0() {
        return true;
    }
}
