package j$.util.concurrent;

import j$.util.C0469e;
import j$.util.W;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

public final class w implements W {

    /* renamed from: a  reason: collision with root package name */
    public long f1352a;

    /* renamed from: b  reason: collision with root package name */
    public final long f1353b;

    /* renamed from: c  reason: collision with root package name */
    public final double f1354c;

    /* renamed from: d  reason: collision with root package name */
    public final double f1355d;

    public final int characteristics() {
        return 17728;
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0469e.a(this, consumer);
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return C0469e.d(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i5) {
        return C0469e.e(this, i5);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return C0469e.f(this, consumer);
    }

    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public w(long j5, long j6, double d5, double d6) {
        this.f1352a = j5;
        this.f1353b = j6;
        this.f1354c = d5;
        this.f1355d = d6;
    }

    /* renamed from: a */
    public final w trySplit() {
        long j5 = this.f1352a;
        long j6 = (this.f1353b + j5) >>> 1;
        if (j6 <= j5) {
            return null;
        }
        this.f1352a = j6;
        return new w(j5, j6, this.f1354c, this.f1355d);
    }

    public final long estimateSize() {
        return this.f1353b - this.f1352a;
    }

    public final boolean tryAdvance(DoubleConsumer doubleConsumer) {
        doubleConsumer.getClass();
        long j5 = this.f1352a;
        if (j5 >= this.f1353b) {
            return false;
        }
        doubleConsumer.accept(ThreadLocalRandom.current().a(this.f1354c, this.f1355d));
        this.f1352a = j5 + 1;
        return true;
    }

    public final void forEachRemaining(DoubleConsumer doubleConsumer) {
        doubleConsumer.getClass();
        long j5 = this.f1352a;
        long j6 = this.f1353b;
        if (j5 < j6) {
            this.f1352a = j6;
            ThreadLocalRandom current = ThreadLocalRandom.current();
            do {
                doubleConsumer.accept(current.a(this.f1354c, this.f1355d));
                j5++;
            } while (j5 < j6);
        }
    }
}
