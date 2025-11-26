package j$.util;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public final class r0 implements Z {

    /* renamed from: a  reason: collision with root package name */
    public final int[] f1421a;

    /* renamed from: b  reason: collision with root package name */
    public int f1422b;

    /* renamed from: c  reason: collision with root package name */
    public final int f1423c;

    /* renamed from: d  reason: collision with root package name */
    public final int f1424d;

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

    public r0(int[] iArr, int i5, int i6, int i7) {
        this.f1421a = iArr;
        this.f1422b = i5;
        this.f1423c = i6;
        this.f1424d = i7 | 16448;
    }

    public final Z trySplit() {
        int i5 = this.f1422b;
        int i6 = (this.f1423c + i5) >>> 1;
        if (i5 >= i6) {
            return null;
        }
        this.f1422b = i6;
        return new r0(this.f1421a, i5, i6, this.f1424d);
    }

    public final void forEachRemaining(IntConsumer intConsumer) {
        int i5;
        intConsumer.getClass();
        int[] iArr = this.f1421a;
        int length = iArr.length;
        int i6 = this.f1423c;
        if (length >= i6 && (i5 = this.f1422b) >= 0) {
            this.f1422b = i6;
            if (i5 < i6) {
                do {
                    intConsumer.accept(iArr[i5]);
                    i5++;
                } while (i5 < i6);
            }
        }
    }

    public final boolean tryAdvance(IntConsumer intConsumer) {
        intConsumer.getClass();
        int i5 = this.f1422b;
        if (i5 < 0 || i5 >= this.f1423c) {
            return false;
        }
        this.f1422b = i5 + 1;
        intConsumer.accept(this.f1421a[i5]);
        return true;
    }

    public final long estimateSize() {
        return (long) (this.f1423c - this.f1422b);
    }

    public final int characteristics() {
        return this.f1424d;
    }

    public final Comparator getComparator() {
        if (C0469e.e(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }
}
