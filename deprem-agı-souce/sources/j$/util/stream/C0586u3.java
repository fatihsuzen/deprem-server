package j$.util.stream;

import j$.util.Spliterator;

/* renamed from: j$.util.stream.u3  reason: case insensitive filesystem */
public abstract class C0586u3 {

    /* renamed from: a  reason: collision with root package name */
    public final long f1797a;

    /* renamed from: b  reason: collision with root package name */
    public final long f1798b;

    /* renamed from: c  reason: collision with root package name */
    public Spliterator f1799c;

    /* renamed from: d  reason: collision with root package name */
    public long f1800d;

    /* renamed from: e  reason: collision with root package name */
    public long f1801e;

    public abstract Spliterator a(Spliterator spliterator, long j5, long j6, long j7, long j8);

    public C0586u3(Spliterator spliterator, long j5, long j6, long j7, long j8) {
        this.f1799c = spliterator;
        this.f1797a = j5;
        this.f1798b = j6;
        this.f1800d = j7;
        this.f1801e = j8;
    }

    public final Spliterator trySplit() {
        long j5 = this.f1801e;
        if (this.f1797a >= j5 || this.f1800d >= j5) {
            return null;
        }
        while (true) {
            Spliterator trySplit = this.f1799c.trySplit();
            if (trySplit == null) {
                return null;
            }
            long estimateSize = trySplit.estimateSize() + this.f1800d;
            long min = Math.min(estimateSize, this.f1798b);
            long j6 = estimateSize;
            long j7 = this.f1797a;
            if (j7 >= min) {
                this.f1800d = min;
            } else {
                long j8 = this.f1798b;
                if (min >= j8) {
                    this.f1799c = trySplit;
                    this.f1801e = min;
                } else {
                    long j9 = this.f1800d;
                    if (j9 < j7 || j6 > j8) {
                        this.f1800d = min;
                        return a(trySplit, j7, j8, j9, min);
                    }
                    this.f1800d = min;
                    return trySplit;
                }
            }
        }
    }

    public final long estimateSize() {
        long j5 = this.f1801e;
        long j6 = this.f1797a;
        if (j6 < j5) {
            return j5 - Math.max(j6, this.f1800d);
        }
        return 0;
    }

    public final int characteristics() {
        return this.f1799c.characteristics();
    }
}
