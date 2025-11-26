package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.ForkJoinPool;

/* renamed from: j$.util.stream.d  reason: case insensitive filesystem */
public abstract class C0498d extends CountedCompleter {

    /* renamed from: g  reason: collision with root package name */
    public static final int f1688g = (ForkJoinPool.getCommonPoolParallelism() << 2);

    /* renamed from: a  reason: collision with root package name */
    public final C0594w1 f1689a;

    /* renamed from: b  reason: collision with root package name */
    public Spliterator f1690b;

    /* renamed from: c  reason: collision with root package name */
    public long f1691c;

    /* renamed from: d  reason: collision with root package name */
    public C0498d f1692d;

    /* renamed from: e  reason: collision with root package name */
    public C0498d f1693e;

    /* renamed from: f  reason: collision with root package name */
    public Object f1694f;

    public abstract Object a();

    public abstract C0498d c(Spliterator spliterator);

    public C0498d(C0594w1 w1Var, Spliterator spliterator) {
        super((CountedCompleter) null);
        this.f1689a = w1Var;
        this.f1690b = spliterator;
        this.f1691c = 0;
    }

    public C0498d(C0498d dVar, Spliterator spliterator) {
        super(dVar);
        this.f1690b = spliterator;
        this.f1689a = dVar.f1689a;
        this.f1691c = dVar.f1691c;
    }

    public static long e(long j5) {
        long j6 = j5 / ((long) f1688g);
        if (j6 > 0) {
            return j6;
        }
        return 1;
    }

    public Object getRawResult() {
        return this.f1694f;
    }

    public final void setRawResult(Object obj) {
        if (obj != null) {
            throw new IllegalStateException();
        }
    }

    public void d(Object obj) {
        this.f1694f = obj;
    }

    public final boolean b() {
        return ((C0498d) getCompleter()) == null;
    }

    public void compute() {
        Spliterator trySplit;
        Spliterator spliterator = this.f1690b;
        long estimateSize = spliterator.estimateSize();
        long j5 = this.f1691c;
        if (j5 == 0) {
            j5 = e(estimateSize);
            this.f1691c = j5;
        }
        boolean z4 = false;
        C0498d dVar = this;
        while (estimateSize > j5 && (trySplit = spliterator.trySplit()) != null) {
            C0498d c5 = dVar.c(trySplit);
            dVar.f1692d = c5;
            C0498d c6 = dVar.c(spliterator);
            dVar.f1693e = c6;
            dVar.setPendingCount(1);
            if (z4) {
                spliterator = trySplit;
                dVar = c5;
                c5 = c6;
            } else {
                dVar = c6;
            }
            z4 = !z4;
            c5.fork();
            estimateSize = spliterator.estimateSize();
        }
        dVar.d(dVar.a());
        dVar.tryComplete();
    }

    public void onCompletion(CountedCompleter countedCompleter) {
        this.f1690b = null;
        this.f1693e = null;
        this.f1692d = null;
    }
}
