package j$.util;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

public final class t0 implements c0 {

    /* renamed from: a  reason: collision with root package name */
    public final long[] f1840a;

    /* renamed from: b  reason: collision with root package name */
    public int f1841b;

    /* renamed from: c  reason: collision with root package name */
    public final int f1842c;

    /* renamed from: d  reason: collision with root package name */
    public final int f1843d;

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

    public t0(long[] jArr, int i5, int i6, int i7) {
        this.f1840a = jArr;
        this.f1841b = i5;
        this.f1842c = i6;
        this.f1843d = i7 | 16448;
    }

    public final c0 trySplit() {
        int i5 = this.f1841b;
        int i6 = (this.f1842c + i5) >>> 1;
        if (i5 >= i6) {
            return null;
        }
        this.f1841b = i6;
        return new t0(this.f1840a, i5, i6, this.f1843d);
    }

    public final void forEachRemaining(LongConsumer longConsumer) {
        int i5;
        longConsumer.getClass();
        long[] jArr = this.f1840a;
        int length = jArr.length;
        int i6 = this.f1842c;
        if (length >= i6 && (i5 = this.f1841b) >= 0) {
            this.f1841b = i6;
            if (i5 < i6) {
                do {
                    longConsumer.accept(jArr[i5]);
                    i5++;
                } while (i5 < i6);
            }
        }
    }

    public final boolean tryAdvance(LongConsumer longConsumer) {
        longConsumer.getClass();
        int i5 = this.f1841b;
        if (i5 < 0 || i5 >= this.f1842c) {
            return false;
        }
        this.f1841b = i5 + 1;
        longConsumer.accept(this.f1840a[i5]);
        return true;
    }

    public final long estimateSize() {
        return (long) (this.f1842c - this.f1841b);
    }

    public final int characteristics() {
        return this.f1843d;
    }

    public final Comparator getComparator() {
        if (C0469e.e(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }
}
