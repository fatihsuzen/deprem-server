package j$.util;

import java.util.Comparator;
import java.util.function.Consumer;

public final class l0 implements Spliterator {

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f1405a;

    /* renamed from: b  reason: collision with root package name */
    public int f1406b;

    /* renamed from: c  reason: collision with root package name */
    public final int f1407c;

    /* renamed from: d  reason: collision with root package name */
    public final int f1408d;

    public final /* synthetic */ long getExactSizeIfKnown() {
        return C0469e.d(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i5) {
        return C0469e.e(this, i5);
    }

    public l0(Object[] objArr, int i5, int i6, int i7) {
        this.f1405a = objArr;
        this.f1406b = i5;
        this.f1407c = i6;
        this.f1408d = i7 | 16448;
    }

    public final Spliterator trySplit() {
        int i5 = this.f1406b;
        int i6 = (this.f1407c + i5) >>> 1;
        if (i5 >= i6) {
            return null;
        }
        this.f1406b = i6;
        return new l0(this.f1405a, i5, i6, this.f1408d);
    }

    public final void forEachRemaining(Consumer consumer) {
        int i5;
        consumer.getClass();
        Object[] objArr = this.f1405a;
        int length = objArr.length;
        int i6 = this.f1407c;
        if (length >= i6 && (i5 = this.f1406b) >= 0) {
            this.f1406b = i6;
            if (i5 < i6) {
                do {
                    consumer.accept(objArr[i5]);
                    i5++;
                } while (i5 < i6);
            }
        }
    }

    public final boolean tryAdvance(Consumer consumer) {
        consumer.getClass();
        int i5 = this.f1406b;
        if (i5 < 0 || i5 >= this.f1407c) {
            return false;
        }
        this.f1406b = i5 + 1;
        consumer.accept(this.f1405a[i5]);
        return true;
    }

    public final long estimateSize() {
        return (long) (this.f1407c - this.f1406b);
    }

    public final int characteristics() {
        return this.f1408d;
    }

    public final Comparator getComparator() {
        if (C0469e.e(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }
}
