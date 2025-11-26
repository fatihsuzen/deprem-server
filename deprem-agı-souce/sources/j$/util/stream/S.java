package j$.util.stream;

import j$.util.Spliterator;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountedCompleter;

public final class S extends CountedCompleter {

    /* renamed from: a  reason: collision with root package name */
    public final C0594w1 f1569a;

    /* renamed from: b  reason: collision with root package name */
    public Spliterator f1570b;

    /* renamed from: c  reason: collision with root package name */
    public final long f1571c;

    /* renamed from: d  reason: collision with root package name */
    public final ConcurrentHashMap f1572d;

    /* renamed from: e  reason: collision with root package name */
    public final Q f1573e;

    /* renamed from: f  reason: collision with root package name */
    public final S f1574f;

    /* renamed from: g  reason: collision with root package name */
    public H0 f1575g;

    public S(C0594w1 w1Var, Spliterator spliterator, Q q5) {
        super((CountedCompleter) null);
        this.f1569a = w1Var;
        this.f1570b = spliterator;
        this.f1571c = C0498d.e(spliterator.estimateSize());
        this.f1572d = new ConcurrentHashMap(Math.max(16, C0498d.f1688g << 1));
        this.f1573e = q5;
        this.f1574f = null;
    }

    public S(S s5, Spliterator spliterator, S s6) {
        super(s5);
        this.f1569a = s5.f1569a;
        this.f1570b = spliterator;
        this.f1571c = s5.f1571c;
        this.f1572d = s5.f1572d;
        this.f1573e = s5.f1573e;
        this.f1574f = s6;
    }

    public final void compute() {
        Spliterator trySplit;
        Spliterator spliterator = this.f1570b;
        long j5 = this.f1571c;
        boolean z4 = false;
        S s5 = this;
        while (spliterator.estimateSize() > j5 && (trySplit = spliterator.trySplit()) != null) {
            S s6 = new S(s5, trySplit, s5.f1574f);
            S s7 = new S(s5, spliterator, s6);
            s5.addToPendingCount(1);
            s7.addToPendingCount(1);
            s5.f1572d.put(s6, s7);
            if (s5.f1574f != null) {
                s6.addToPendingCount(1);
                if (s5.f1572d.replace(s5.f1574f, s5, s6)) {
                    s5.addToPendingCount(-1);
                } else {
                    s6.addToPendingCount(-1);
                }
            }
            if (z4) {
                spliterator = trySplit;
                s5 = s6;
                s6 = s7;
            } else {
                s5 = s7;
            }
            z4 = !z4;
            s6.fork();
        }
        if (s5.getPendingCount() > 0) {
            C0553o oVar = new C0553o(15);
            C0594w1 w1Var = s5.f1569a;
            C0608z0 A02 = w1Var.A0(w1Var.k0(spliterator), oVar);
            s5.f1569a.F0(spliterator, A02);
            s5.f1575g = A02.build();
            s5.f1570b = null;
        }
        s5.tryComplete();
    }

    public final void onCompletion(CountedCompleter countedCompleter) {
        H0 h02 = this.f1575g;
        if (h02 != null) {
            h02.forEach(this.f1573e);
            this.f1575g = null;
        } else {
            Spliterator spliterator = this.f1570b;
            if (spliterator != null) {
                this.f1569a.F0(spliterator, this.f1573e);
                this.f1570b = null;
            }
        }
        S s5 = (S) this.f1572d.remove(this);
        if (s5 != null) {
            s5.tryComplete();
        }
    }
}
