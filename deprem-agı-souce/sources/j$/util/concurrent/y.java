package j$.util.concurrent;

import j$.util.C0469e;
import j$.util.c0;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

public final class y implements c0 {

    /* renamed from: a  reason: collision with root package name */
    public long f1360a;

    /* renamed from: b  reason: collision with root package name */
    public final long f1361b;

    /* renamed from: c  reason: collision with root package name */
    public final long f1362c;

    /* renamed from: d  reason: collision with root package name */
    public final long f1363d;

    public final int characteristics() {
        return 17728;
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0469e.c(this, consumer);
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return C0469e.d(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i5) {
        return C0469e.e(this, i5);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return C0469e.h(this, consumer);
    }

    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public y(long j5, long j6, long j7, long j8) {
        this.f1360a = j5;
        this.f1361b = j6;
        this.f1362c = j7;
        this.f1363d = j8;
    }

    /* renamed from: a */
    public final y trySplit() {
        long j5 = this.f1360a;
        long j6 = (this.f1361b + j5) >>> 1;
        if (j6 <= j5) {
            return null;
        }
        this.f1360a = j6;
        return new y(j5, j6, this.f1362c, this.f1363d);
    }

    public final long estimateSize() {
        return this.f1361b - this.f1360a;
    }

    public final boolean tryAdvance(LongConsumer longConsumer) {
        longConsumer.getClass();
        long j5 = this.f1360a;
        if (j5 >= this.f1361b) {
            return false;
        }
        longConsumer.accept(ThreadLocalRandom.current().c(this.f1362c, this.f1363d));
        this.f1360a = j5 + 1;
        return true;
    }

    public final void forEachRemaining(LongConsumer longConsumer) {
        longConsumer.getClass();
        long j5 = this.f1360a;
        long j6 = this.f1361b;
        if (j5 < j6) {
            this.f1360a = j6;
            ThreadLocalRandom current = ThreadLocalRandom.current();
            do {
                longConsumer.accept(current.c(this.f1362c, this.f1363d));
                j5++;
            } while (j5 < j6);
        }
    }
}
