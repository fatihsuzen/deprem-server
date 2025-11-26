package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.CountedCompleter;
import java.util.function.BinaryOperator;
import java.util.function.LongFunction;

public class N0 extends C0498d {

    /* renamed from: h  reason: collision with root package name */
    public final C0594w1 f1541h;

    /* renamed from: i  reason: collision with root package name */
    public final LongFunction f1542i;

    /* renamed from: j  reason: collision with root package name */
    public final BinaryOperator f1543j;

    public final void onCompletion(CountedCompleter countedCompleter) {
        C0498d dVar = this.f1692d;
        if (dVar != null) {
            this.f1694f = (H0) this.f1543j.apply((H0) ((N0) dVar).f1694f, (H0) ((N0) this.f1693e).f1694f);
        }
        super.onCompletion(countedCompleter);
    }

    public N0(C0594w1 w1Var, Spliterator spliterator, LongFunction longFunction, BinaryOperator binaryOperator) {
        super(w1Var, spliterator);
        this.f1541h = w1Var;
        this.f1542i = longFunction;
        this.f1543j = binaryOperator;
    }

    public N0(N0 n02, Spliterator spliterator) {
        super((C0498d) n02, spliterator);
        this.f1541h = n02.f1541h;
        this.f1542i = n02.f1542i;
        this.f1543j = n02.f1543j;
    }

    public C0498d c(Spliterator spliterator) {
        return new N0(this, spliterator);
    }

    /* renamed from: f */
    public final H0 a() {
        C0608z0 z0Var = (C0608z0) this.f1542i.apply(this.f1541h.k0(this.f1690b));
        this.f1541h.F0(this.f1690b, z0Var);
        return z0Var.build();
    }
}
