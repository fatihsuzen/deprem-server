package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.CountedCompleter;

public final class T extends CountedCompleter {

    /* renamed from: a  reason: collision with root package name */
    public Spliterator f1579a;

    /* renamed from: b  reason: collision with root package name */
    public final C0546m2 f1580b;

    /* renamed from: c  reason: collision with root package name */
    public final C0594w1 f1581c;

    /* renamed from: d  reason: collision with root package name */
    public long f1582d;

    public T(C0594w1 w1Var, Spliterator spliterator, C0546m2 m2Var) {
        super((CountedCompleter) null);
        this.f1580b = m2Var;
        this.f1581c = w1Var;
        this.f1579a = spliterator;
        this.f1582d = 0;
    }

    public T(T t5, Spliterator spliterator) {
        super(t5);
        this.f1579a = spliterator;
        this.f1580b = t5.f1580b;
        this.f1582d = t5.f1582d;
        this.f1581c = t5.f1581c;
    }

    public final void compute() {
        Spliterator trySplit;
        Spliterator spliterator = this.f1579a;
        long estimateSize = spliterator.estimateSize();
        long j5 = this.f1582d;
        if (j5 == 0) {
            j5 = C0498d.e(estimateSize);
            this.f1582d = j5;
        }
        boolean h5 = Z2.SHORT_CIRCUIT.h(((C0483a) this.f1581c).f1653m);
        C0546m2 m2Var = this.f1580b;
        boolean z4 = false;
        T t5 = this;
        while (true) {
            if (h5 && m2Var.e()) {
                break;
            } else if (estimateSize <= j5 || (trySplit = spliterator.trySplit()) == null) {
                t5.f1581c.f0(spliterator, m2Var);
            } else {
                T t6 = new T(t5, trySplit);
                t5.addToPendingCount(1);
                if (z4) {
                    spliterator = trySplit;
                } else {
                    T t7 = t5;
                    t5 = t6;
                    t6 = t7;
                }
                z4 = !z4;
                t5.fork();
                t5 = t6;
                estimateSize = spliterator.estimateSize();
            }
        }
        t5.f1581c.f0(spliterator, m2Var);
        t5.f1579a = null;
        t5.propagateCompletion();
    }
}
