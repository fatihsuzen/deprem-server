package j$.util.concurrent;

import j$.util.C0469e;
import j$.util.Z;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public final class x implements Z {

    /* renamed from: a  reason: collision with root package name */
    public long f1356a;

    /* renamed from: b  reason: collision with root package name */
    public final long f1357b;

    /* renamed from: c  reason: collision with root package name */
    public final int f1358c;

    /* renamed from: d  reason: collision with root package name */
    public final int f1359d;

    public final int characteristics() {
        return 17728;
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0469e.b(this, consumer);
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return C0469e.d(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i5) {
        return C0469e.e(this, i5);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return C0469e.g(this, consumer);
    }

    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public x(long j5, long j6, int i5, int i6) {
        this.f1356a = j5;
        this.f1357b = j6;
        this.f1358c = i5;
        this.f1359d = i6;
    }

    /* renamed from: a */
    public final x trySplit() {
        long j5 = this.f1356a;
        long j6 = (this.f1357b + j5) >>> 1;
        if (j6 <= j5) {
            return null;
        }
        this.f1356a = j6;
        return new x(j5, j6, this.f1358c, this.f1359d);
    }

    public final long estimateSize() {
        return this.f1357b - this.f1356a;
    }

    public final boolean tryAdvance(IntConsumer intConsumer) {
        intConsumer.getClass();
        long j5 = this.f1356a;
        if (j5 >= this.f1357b) {
            return false;
        }
        intConsumer.accept(ThreadLocalRandom.current().b(this.f1358c, this.f1359d));
        this.f1356a = j5 + 1;
        return true;
    }

    public final void forEachRemaining(IntConsumer intConsumer) {
        intConsumer.getClass();
        long j5 = this.f1356a;
        long j6 = this.f1357b;
        if (j5 < j6) {
            this.f1356a = j6;
            ThreadLocalRandom current = ThreadLocalRandom.current();
            do {
                intConsumer.accept(current.b(this.f1358c, this.f1359d));
                j5++;
            } while (j5 < j6);
        }
    }
}
