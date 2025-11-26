package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.CountedCompleter;

public final class Y1 extends C0498d {

    /* renamed from: h  reason: collision with root package name */
    public final C0594w1 f1616h;

    public final void onCompletion(CountedCompleter countedCompleter) {
        C0498d dVar = this.f1692d;
        if (dVar != null) {
            R1 r12 = (R1) ((Y1) dVar).f1694f;
            r12.j((R1) ((Y1) this.f1693e).f1694f);
            this.f1694f = r12;
        }
        super.onCompletion(countedCompleter);
    }

    public Y1(C0594w1 w1Var, C0594w1 w1Var2, Spliterator spliterator) {
        super(w1Var2, spliterator);
        this.f1616h = w1Var;
    }

    public Y1(Y1 y12, Spliterator spliterator) {
        super((C0498d) y12, spliterator);
        this.f1616h = y12.f1616h;
    }

    public final C0498d c(Spliterator spliterator) {
        return new Y1(this, spliterator);
    }

    public final Object a() {
        C0594w1 w1Var = this.f1689a;
        R1 D02 = this.f1616h.D0();
        w1Var.F0(this.f1690b, D02);
        return D02;
    }
}
