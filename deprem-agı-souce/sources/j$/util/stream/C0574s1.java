package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer$CC;
import java.util.concurrent.CountedCompleter;
import java.util.function.Consumer;

/* renamed from: j$.util.stream.s1  reason: case insensitive filesystem */
public abstract class C0574s1 extends CountedCompleter implements C0546m2 {

    /* renamed from: a  reason: collision with root package name */
    public final Spliterator f1776a;

    /* renamed from: b  reason: collision with root package name */
    public final C0594w1 f1777b;

    /* renamed from: c  reason: collision with root package name */
    public final long f1778c;

    /* renamed from: d  reason: collision with root package name */
    public final long f1779d;

    /* renamed from: e  reason: collision with root package name */
    public final long f1780e;

    /* renamed from: f  reason: collision with root package name */
    public int f1781f;

    /* renamed from: g  reason: collision with root package name */
    public int f1782g;

    public abstract C0574s1 a(Spliterator spliterator, long j5, long j6);

    public /* synthetic */ void accept(double d5) {
        C0594w1.C();
        throw null;
    }

    public /* synthetic */ void accept(int i5) {
        C0594w1.J();
        throw null;
    }

    public /* synthetic */ void accept(long j5) {
        C0594w1.K();
        throw null;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ boolean e() {
        return false;
    }

    public final /* synthetic */ void end() {
    }

    public C0574s1(Spliterator spliterator, C0594w1 w1Var, int i5) {
        this.f1776a = spliterator;
        this.f1777b = w1Var;
        this.f1778c = C0498d.e(spliterator.estimateSize());
        this.f1779d = 0;
        this.f1780e = (long) i5;
    }

    public C0574s1(C0574s1 s1Var, Spliterator spliterator, long j5, long j6, int i5) {
        super(s1Var);
        this.f1776a = spliterator;
        this.f1777b = s1Var.f1777b;
        this.f1778c = s1Var.f1778c;
        this.f1779d = j5;
        this.f1780e = j6;
        if (j5 < 0 || j6 < 0 || (j5 + j6) - 1 >= ((long) i5)) {
            throw new IllegalArgumentException(String.format("offset and length interval [%d, %d + %d) is not within array size interval [0, %d)", new Object[]{Long.valueOf(j5), Long.valueOf(j5), Long.valueOf(j6), Integer.valueOf(i5)}));
        }
    }

    public final void compute() {
        Spliterator trySplit;
        Spliterator spliterator = this.f1776a;
        C0574s1 s1Var = this;
        while (spliterator.estimateSize() > s1Var.f1778c && (trySplit = spliterator.trySplit()) != null) {
            s1Var.setPendingCount(1);
            long estimateSize = trySplit.estimateSize();
            C0574s1 s1Var2 = s1Var;
            s1Var2.a(trySplit, s1Var.f1779d, estimateSize).fork();
            s1Var = s1Var2.a(spliterator, s1Var2.f1779d + estimateSize, s1Var2.f1780e - estimateSize);
        }
        C0574s1 s1Var3 = s1Var;
        s1Var3.f1777b.F0(spliterator, s1Var3);
        s1Var3.propagateCompletion();
    }

    public final void c(long j5) {
        long j6 = this.f1780e;
        if (j5 <= j6) {
            int i5 = (int) this.f1779d;
            this.f1781f = i5;
            this.f1782g = i5 + ((int) j6);
            return;
        }
        throw new IllegalStateException("size passed to Sink.begin exceeds array length");
    }
}
